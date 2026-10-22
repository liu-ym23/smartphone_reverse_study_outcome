package com.bytedance.ee.bear.middleground.permission.batchauthorize;

import android.R;
import android.app.Activity;
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
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.livedata.AuthorizeStateNode;
import com.bytedance.ee.bear.middleground_permission_export.model.batchauthorize.BatchAuthorizeInfo;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.bytedance.ee.util.ui.n;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.component.universe_design.button.UDButton;
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

/* JADX INFO: loaded from: classes18.dex */
public class BatchAuthorizeActivity extends BaseActivity {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f233109p = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BaseTitleBar f233110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f233111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f233112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f233113f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f233114g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DocumentAuthAdapter f233115h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BatchAuthorizeViewModel f233116i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BearLottieView f233117j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BatchAuthorizeInfo f233118k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinearLayout f233119l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public SmartRefreshLayout f233120m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LinearLayout f233121n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f233122o;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f233123a = null;

        static {
            int[] r100 = new int[AuthorizeStateNode.BatchAuthorizeState.values().length];
            f233123a = r100;
            r100[AuthorizeStateNode.BatchAuthorizeState.MODE_UNABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f233123a[AuthorizeStateNode.BatchAuthorizeState.MODE_ALL_BATCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f233123a[AuthorizeStateNode.BatchAuthorizeState.MODE_ALL_DISBATCH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L50;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        BearLottieView r100 = this.f233117j;
        if (r100 == null) goto L9;
        r100.cancelAnimation();
        return;
    }

    public BatchAuthorizeActivity() {
        this.f233122o = true;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseCommonActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        super.onBackPressed();
        this.f233116i.updateCardState();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == c.f346341a) goto L9;
        c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity
    public final void B1(Bundle r100) {
        this.f233122o = true;
        setContentView(com.larus.nova.R.layout.activity_batch_authorize);
        BatchAuthorizeInfo r101 = (BatchAuthorizeInfo) getIntent().getSerializableExtra(BatchAuthorizeInfo.KEY_BATCH_AUTHORIZE);
        this.f233118k = r101;
        if (r101 != null) goto L5;
        finish();
    L5:
        BaseTitleBar r102 = (BaseTitleBar) findViewById(com.larus.nova.R.id.batch_auth_title_bar);
        this.f233110c = r102;
        r102.setLeftClickListener(new k(this));
        this.f233110c.setTitle(com.larus.nova.R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_Title);
        this.f233111d = (TextView) findViewById(com.larus.nova.R.id.auth_text);
        this.f233113f = (LinearLayout) findViewById(com.larus.nova.R.id.auth_content);
        TextView r103 = (TextView) findViewById(com.larus.nova.R.id.chat_tips);
        if (this.f233118k.getChatType() != 0) goto L8;
        String r104 = getString(com.larus.nova.R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_Subtitle_Chat_ver2);
    L9:
        r103.setText(r104);
        TextView r105 = (TextView) findViewById(com.larus.nova.R.id.auth_action);
        this.f233112e = r105;
        int r106 = 8;
        r105.setVisibility(8);
        this.f233114g = (RecyclerView) findViewById(com.larus.nova.R.id.doc_content);
        BearLottieView r107 = (BearLottieView) findViewById(com.larus.nova.R.id.loading_anim_view);
        this.f233117j = r107;
        r107.playAnimation();
        this.f233112e.setOnClickListener(new b(this));
        UDAvatar r108 = (UDAvatar) findViewById(com.larus.nova.R.id.avatarView);
        String r109 = "";
        Glide.with(this).load(AvatarImage.Builder.obtain(this.f233118k.getChatAvatar(), "", n.d(40), n.d(40)).build()).placeholder(com.larus.nova.R.drawable.facade_common_avatar_place_holder).into(r108);
        TextView r110 = (TextView) findViewById(com.larus.nova.R.id.chatTitle);
        TextView r111 = (TextView) findViewById(com.larus.nova.R.id.chatDesp);
        int r112 = this.f233118k.getChatType();
        String r113 = this.f233118k.getChatDesp();
        if (TextUtils.isEmpty(r113) == true) goto L13;
    L16:
        r110.setText(this.f233118k.getChatName());
        if (TextUtils.isEmpty(this.f233118k.getChatName()) == false) goto L19;
        int r114 = 8;
    L20:
        r110.setVisibility(r114);
        r111.setText(r113);
        if (TextUtils.isEmpty(r113) == true) goto L24;
        r106 = 0;
    L24:
        r111.setVisibility(r106);
        this.f233119l = (LinearLayout) findViewById(com.larus.nova.R.id.recycle_layout);
        SmartRefreshLayout r115 = (SmartRefreshLayout) findViewById(com.larus.nova.R.id.auth_list_refresh_layout);
        this.f233120m = r115;
        r115.A = false;
        r115.g(true);
        this.f233120m.i(new lg5.b(this));
        this.f233121n = (LinearLayout) findViewById(com.larus.nova.R.id.loadingFailedLayout);
        ((UDButton) findViewById(com.larus.nova.R.id.retryBtn)).setOnClickListener(new lg5.c(this));
        BatchAuthorizeInfo r116 = this.f233118k;
        BatchAuthorizeViewModel r117 = (BatchAuthorizeViewModel) ViewModelProviders.of(this).get(BatchAuthorizeViewModel.class);
        this.f233116i = r117;
        r117.setInfo(r116);
        DocumentAuthAdapter r118 = new DocumentAuthAdapter();
        this.f233115h = r118;
        r118.f233127c = r116.getChatType();
        DocumentAuthAdapter r119 = this.f233115h;
        r119.f233126b = new d(this);
        this.f233114g.setLayoutManager(new LinearLayoutManagerWrapper(this));
        this.f233114g.setAdapter(this.f233115h);
        D1(true, true);
        this.f233116i.getDocNewData().observe(this, new e(this));
        this.f233116i.getStateData().observe(this, new com.bytedance.ee.bear.middleground.permission.batchauthorize.a(this));
        this.f233116i.getSingleAuthList().observe(this, new f(this));
        this.f233116i.getDocNewData().observe(this, new g(this));
        this.f233116i.getAuthOperateData().observe(this, new h(this));
        this.f233116i.getCancelAuth().observe(this, new i(this));
        this.f233116i.getHasPages().observe(this, new j(this));
        if (getLastNonConfigurationInstance() != null) goto L27;
    L32:
        this.f233116i.getEmbededDocumentInfo();
        return;
    L27:
        if (this.f233116i.getDocNewData().getValue() == null) goto L32;
        if (this.f233116i.getDocNewData().getValue().getResult() == null) goto L32;
        if (this.f233116i.getDocNewData().getValue().getResult().isEmpty() == true) goto L32;
        return;
    L19:
        r114 = 0;
        goto L20
    L13:
        if (r112 != 2) goto L15;
        r109 = getString(com.larus.nova.R.string.Doc_Facade_NoGroupDesc);
    L15:
        r113 = r109;
        goto L16
    L8:
        r104 = getString(com.larus.nova.R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_Subtitle_Chat_ver2);
        goto L9
    }

    public final void D1(boolean r100, boolean r101) {
        BearLottieView r102 = this.f233117j;
        if (r100 == false) goto L5;
        int r103 = 0;
    L6:
        r102.setVisibility(r103);
        if (r100 == false) goto L9;
        this.f233117j.playAnimation();
        this.f233119l.setVisibility(8);
        this.f233121n.setVisibility(8);
        this.f233113f.setVisibility(4);
        return;
    L9:
        this.f233117j.cancelAnimation();
        if (r101 == false) goto L12;
        this.f233113f.setVisibility(0);
        this.f233119l.setVisibility(0);
        this.f233121n.setVisibility(8);
        return;
    L12:
        this.f233119l.setVisibility(8);
        this.f233113f.setVisibility(4);
        this.f233121n.setVisibility(0);
        return;
    L5:
        r103 = 8;
        goto L6
    }

    public static void C1(BatchAuthorizeActivity r100, int r101, int r102, DialogInterface.OnClickListener r103, DialogInterface.OnClickListener r104) {
        r100.getClass();
        BearUDDialogBuilder r105 = new BearUDDialogBuilder(r100);
        r105.f240192a.title(r101);
        r105.f(r100.getString(r102));
        r105.b(com.larus.nova.R.id.ud_dialog_btn_primary, com.larus.nova.R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_ConfirmButton, com.larus.nova.R.color.primary_fill_default, r103);
        r105.b(com.larus.nova.R.id.ud_dialog_btn_secondary, com.larus.nova.R.string.Doc_Reminder_Button_Cancel, com.larus.nova.R.color.text_title, r104);
        r105.f240192a.style(com.larus.nova.R.style.ActionSheetDialogStyle);
        r105.h();
    }
}
