package com.bytedance.ee.bear.middleground.permission.batchauthorize;

import android.R;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.BatchAuthorizeViewModel;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.EmbededDocumentInfo;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.livedata.AuthorizeStateNode;
import com.bytedance.ee.bear.middleground_permission_export.model.batchauthorize.BatchAuthorizeInfo;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.bytedance.ee.util.ui.n;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import lg5.d;
import lg5.e;
import lg5.f;
import lg5.g;
import lg5.h;
import lg5.i;
import lg5.j;
import lg5.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class BatchAuthorizeActivity extends BaseActivity {
    public static final /* synthetic */ int p = 0;
    public BaseTitleBar c;
    public TextView d;
    public TextView e;
    public LinearLayout f;
    public RecyclerView g;
    public DocumentAuthAdapter h;
    public BatchAuthorizeViewModel i;
    public BearLottieView j;
    public BatchAuthorizeInfo k;
    public LinearLayout l;
    public SmartRefreshLayout m;
    public LinearLayout n;
    public boolean o;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AuthorizeStateNode.BatchAuthorizeState.values().length];
            a = r0;
            r0[AuthorizeStateNode.BatchAuthorizeState.MODE_UNABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[AuthorizeStateNode.BatchAuthorizeState.MODE_ALL_BATCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[AuthorizeStateNode.BatchAuthorizeState.MODE_ALL_DISBATCH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L50;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        BearLottieView r0 = this.j;
        if (r0 == null) goto L9;
        r0.cancelAnimation();
        return;
    }

    public BatchAuthorizeActivity() {
        this.o = true;
    }

    public final void onBackPressed() {
        super/*com.bytedance.ee.bear.facade.common.BaseCommonActivity*/.onBackPressed();
        this.i.updateCardState();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == c.a) goto L9;
        c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1(Bundle r8) {
        this.o = true;
        setContentView(2131558447);
        BatchAuthorizeInfo r0 = (BatchAuthorizeInfo) getIntent().getSerializableExtra(BatchAuthorizeInfo.KEY_BATCH_AUTHORIZE);
        this.k = r0;
        if (r0 != null) goto L5;
        finish();
    L5:
        BaseTitleBar r1 = (BaseTitleBar) findViewById(2131364008);
        this.c = r1;
        r1.setLeftClickListener(new k(this));
        this.c.setTitle(2131887196);
        this.d = (TextView) findViewById(2131363567);
        this.f = (LinearLayout) findViewById(2131363549);
        TextView r2 = (TextView) findViewById(2131365606);
        if (this.k.getChatType() != 0) goto L8;
        String r3 = getString(2131887195);
    L9:
        r2.setText(r3);
        TextView r4 = (TextView) findViewById(2131363539);
        this.e = r4;
        int r5 = 8;
        r4.setVisibility(8);
        this.g = findViewById(2131369310);
        BearLottieView r6 = findViewById(2131378998);
        this.j = r6;
        r6.playAnimation();
        this.e.setOnClickListener(new b(this));
        UDAvatar r7 = findViewById(2131363638);
        String r9 = "";
        Glide.with(this).load(AvatarImage.Builder.obtain(this.k.getChatAvatar(), "", n.d(40), n.d(40)).build()).placeholder(2131235295).into(r7);
        TextView r10 = (TextView) findViewById(2131365502);
        TextView r11 = (TextView) findViewById(2131365500);
        int r12 = this.k.getChatType();
        String r13 = this.k.getChatDesp();
        if (TextUtils.isEmpty(r13) == true) goto L13;
    L16:
        r10.setText(this.k.getChatName());
        if (TextUtils.isEmpty(this.k.getChatName()) == false) goto L19;
        int r14 = 8;
    L20:
        r10.setVisibility(r14);
        r11.setText(r13);
        if (TextUtils.isEmpty(r13) == true) goto L24;
        r5 = 0;
    L24:
        r11.setVisibility(r5);
        this.l = (LinearLayout) findViewById(2131384068);
        SmartRefreshLayout r15 = findViewById(2131363560);
        this.m = r15;
        r15.A = false;
        r15.g(true);
        this.m.i(new lg5.b(this));
        this.n = (LinearLayout) findViewById(2131378979);
        findViewById(2131384461).setOnClickListener(new lg5.c(this));
        BatchAuthorizeInfo r16 = this.k;
        BatchAuthorizeViewModel r17 = (BatchAuthorizeViewModel) ViewModelProviders.of(this).get(BatchAuthorizeViewModel.class);
        this.i = r17;
        r17.setInfo(r16);
        DocumentAuthAdapter r18 = new DocumentAuthAdapter();
        this.h = r18;
        r18.c = r16.getChatType();
        DocumentAuthAdapter r19 = this.h;
        r19.b = new d(this);
        this.g.setLayoutManager(new LinearLayoutManagerWrapper(this));
        this.g.setAdapter(this.h);
        D1(true, true);
        this.i.getDocNewData().observe(this, new e(this));
        this.i.getStateData().observe(this, new com.bytedance.ee.bear.middleground.permission.batchauthorize.a(this));
        this.i.getSingleAuthList().observe(this, new f(this));
        this.i.getDocNewData().observe(this, new g(this));
        this.i.getAuthOperateData().observe(this, new h(this));
        this.i.getCancelAuth().observe(this, new i(this));
        this.i.getHasPages().observe(this, new j(this));
        if (getLastNonConfigurationInstance() != null) goto L27;
    L32:
        this.i.getEmbededDocumentInfo();
        return;
    L27:
        if (this.i.getDocNewData().getValue() == null) goto L32;
        if (((EmbededDocumentInfo.EmbededData) this.i.getDocNewData().getValue()).getResult() == null) goto L32;
        if (((EmbededDocumentInfo.EmbededData) this.i.getDocNewData().getValue()).getResult().isEmpty() == true) goto L32;
        return;
    L19:
        r14 = 0;
        goto L20
    L13:
        if (r12 != 2) goto L15;
        r9 = getString(2131887785);
    L15:
        r13 = r9;
        goto L16
    L8:
        r3 = getString(2131887195);
        goto L9
    }

    public final void D1(boolean r5, boolean r6) {
        BearLottieView r0 = this.j;
        if (r5 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        if (r5 == false) goto L9;
        this.j.playAnimation();
        this.l.setVisibility(8);
        this.n.setVisibility(8);
        this.f.setVisibility(4);
        return;
    L9:
        this.j.cancelAnimation();
        if (r6 == false) goto L12;
        this.f.setVisibility(0);
        this.l.setVisibility(0);
        this.n.setVisibility(8);
        return;
    L12:
        this.l.setVisibility(8);
        this.f.setVisibility(4);
        this.n.setVisibility(0);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void C1(BatchAuthorizeActivity r2, int r3, int r4, DialogInterface.OnClickListener r5, DialogInterface.OnClickListener r6) {
        r2.getClass();
        BearUDDialogBuilder r0 = new BearUDDialogBuilder(r2);
        r0.a.title(r3);
        r0.f(r2.getString(r4));
        r0.b(2131391777, 2131887182, 2131105548, r5);
        r0.b(2131391778, 2131888142, 2131106622, r6);
        r0.a.style(2131951622);
        r0.h();
    }
}
