package com.bytedance.ee.bear.middleground.like;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.facade.common.empty.Config;
import com.bytedance.ee.bear.facade.common.empty.EmptyView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LoadMoreFooter;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class LikeListActivity extends BaseActivity {
    public static final /* synthetic */ int n = 0;
    public BaseTitleBar c;
    public RecyclerView d;
    public LikeListAdapter e;
    public SmartRefreshLayout f;
    public EmptyView g;
    public com.bytedance.ee.bear.facade.common.empty.c h;
    public LikeViewModel i;
    public String j;
    public int k;
    public boolean l;
    public String m;

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
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public LikeListActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1(Bundle r7) {
        setContentView(2131563465);
        this.c = (BaseTitleBar) findViewById(2131377880);
        this.d = findViewById(2131377873);
        this.f = findViewById(2131377879);
        this.g = findViewById(2131377875);
        this.j = getIntent().getStringExtra("doc_token");
        int r1 = 0;
        this.k = getIntent().getIntExtra("ref_type", 0);
        this.l = "from_lark_info".equals(getIntent().getStringExtra("from"));
        this.m = getIntent().getStringExtra(ResourceData.KEY_URL);
        this.c.setTitle(2131887870);
        this.d.setLayoutManager(new LinearLayoutManager(this));
        LikeListAdapter r8 = new LikeListAdapter(this);
        this.e = r8;
        r8.e = new g(this);
        this.d.setAdapter(r8);
        this.f.F(new LoadMoreFooter(this), -2);
        this.f.A = false;
        boolean r2 = true;
        if (this.l == false) goto L5;
        h r9 = new h(this, getString(2131887873));
        this.c.a(r9, true);
    L5:
        EmptyView r10 = this.g;
        Context r4 = getApplicationContext();
        int r5 = p.a;
        r10.setConfig((Config) new LikeEmptyConfig(r4, ((i0) org.koin.java.a.a(i0.class)).a()).c.invoke());
        this.h = new com.bytedance.ee.bear.facade.common.empty.c(getApplicationContext(), this, this.g, this.f);
        LikeViewModel r11 = (LikeViewModel) ViewModelProviders.of(this).get(LikeViewModel.class);
        this.i = r11;
        r11.attach(this.h.c, this.j, this.k);
        this.i.items().observe(this, new c(this));
        this.i.loadMoreState().observe(this, new d(this));
        this.i.count().observe(this, new e(this));
        SmartRefreshLayout r12 = this.f;
        i r3 = new i(this);
        r12.W = r3;
        r12.k0 = r3;
        if (r12.B == false) goto L8;
    L11:
        r12.B = r2;
        EmptyView r13 = this.g;
        final LikeViewModel r6 = this.i;
        Objects.requireNonNull(r6);
        r13.setOnRetryListener(new f(r6));
        HashMap r14 = new HashMap();
        String r0 = getIntent().getStringExtra("from");
        if (TextUtils.isEmpty(r0) == true) goto L14;
        r14.put("praise_page_source", r0);
    L14:
        Integer r15 = (Integer) this.i.count().getValue();
        StringBuilder r16 = new StringBuilder("");
        if (r15 == null) goto L17;
        r1 = r15.intValue();
    L17:
        r16.append(r1);
        r14.put("praise_nums", r16.toString());
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("show_praise_page", r14);
        return;
    L8:
        if (r12.U == false) goto L11;
        r2 = false;
        goto L11
    }
}
