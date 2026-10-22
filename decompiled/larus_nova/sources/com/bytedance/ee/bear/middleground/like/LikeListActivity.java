package com.bytedance.ee.bear.middleground.like;

import android.R;
import android.app.Activity;
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
import com.bytedance.ee.bear.facade.common.empty.EmptyView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LoadMoreFooter;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
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

/* JADX INFO: loaded from: classes18.dex */
public class LikeListActivity extends BaseActivity {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f232712n = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BaseTitleBar f232713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView f232714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LikeListAdapter f232715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SmartRefreshLayout f232716f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public EmptyView f232717g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.ee.bear.facade.common.empty.c f232718h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LikeViewModel f232719i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f232720j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f232721k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f232722l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f232723m;

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
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public LikeListActivity() {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity
    public final void B1(Bundle r100) {
        setContentView(com.larus.nova.R.layout.like_list_activity);
        this.f232713c = (BaseTitleBar) findViewById(com.larus.nova.R.id.like_list_title_bar);
        this.f232714d = (RecyclerView) findViewById(com.larus.nova.R.id.like_list);
        this.f232716f = (SmartRefreshLayout) findViewById(com.larus.nova.R.id.like_list_refresh_layout);
        this.f232717g = (EmptyView) findViewById(com.larus.nova.R.id.like_list_empty);
        this.f232720j = getIntent().getStringExtra("doc_token");
        int r101 = 0;
        this.f232721k = getIntent().getIntExtra("ref_type", 0);
        this.f232722l = "from_lark_info".equals(getIntent().getStringExtra("from"));
        this.f232723m = getIntent().getStringExtra("url");
        this.f232713c.setTitle(com.larus.nova.R.string.Doc_Like_LikeDetails);
        this.f232714d.setLayoutManager(new LinearLayoutManager(this));
        LikeListAdapter r102 = new LikeListAdapter(this);
        this.f232715e = r102;
        r102.f232728e = new g(this);
        this.f232714d.setAdapter(r102);
        this.f232716f.F(new LoadMoreFooter(this), -2);
        this.f232716f.A = false;
        boolean r103 = true;
        if (this.f232722l == false) goto L5;
        h r104 = new h(this, getString(com.larus.nova.R.string.Doc_Like_ViewDocument));
        this.f232713c.a(r104, true);
    L5:
        EmptyView r105 = this.f232717g;
        Context r106 = getApplicationContext();
        int r107 = p.f232814a;
        r105.setConfig(new LikeEmptyConfig(r106, ((i0) org.koin.java.a.a(i0.class)).a()).f232711c.invoke());
        this.f232718h = new com.bytedance.ee.bear.facade.common.empty.c(getApplicationContext(), this, this.f232717g, this.f232716f);
        LikeViewModel r108 = (LikeViewModel) ViewModelProviders.of(this).get(LikeViewModel.class);
        this.f232719i = r108;
        r108.attach(this.f232718h.f226424c, this.f232720j, this.f232721k);
        this.f232719i.items().observe(this, new c(this));
        this.f232719i.loadMoreState().observe(this, new d(this));
        this.f232719i.count().observe(this, new e(this));
        SmartRefreshLayout r109 = this.f232716f;
        i r110 = new i(this);
        r109.W = r110;
        r109.f405877k0 = r110;
        if (r109.B == false) goto L8;
    L11:
        r109.B = r103;
        EmptyView r111 = this.f232717g;
        final LikeViewModel r112 = this.f232719i;
        Objects.requireNonNull(r112);
        r111.setOnRetryListener(new f(r112));
        HashMap r113 = new HashMap();
        String r114 = getIntent().getStringExtra("from");
        if (TextUtils.isEmpty(r114) == true) goto L14;
        r113.put("praise_page_source", r114);
    L14:
        Integer r115 = this.f232719i.count().getValue();
        StringBuilder r116 = new StringBuilder("");
        if (r115 == null) goto L17;
        r101 = r115.intValue();
    L17:
        r116.append(r101);
        r113.put("praise_nums", r116.toString());
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("show_praise_page", r113);
        return;
    L8:
        if (r109.U == false) goto L11;
        r103 = false;
        goto L11
    }
}
