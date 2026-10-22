package com.bytedance.ee.bear.doc.vote;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
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
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
public class VoteOptionMembersActivity extends BaseActivity {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f218393p = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BaseTitleBar f218394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView f218395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VoteOptionMemberAdapter f218396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SmartRefreshLayout f218397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public EmptyView f218398g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.ee.bear.facade.common.empty.c f218399h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public VoteOptionMemberViewModel f218400i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f218401j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f218402k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f218403l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f218404m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f218405n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f218406o;

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

    public VoteOptionMembersActivity() {
        this.f218405n = "1";
        this.f218406o = false;
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

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity
    public final void B1(Bundle r100) {
        setContentView(com.larus.nova.R.layout.activity_vote_option_members);
        this.f218394c = (BaseTitleBar) findViewById(com.larus.nova.R.id.vote_option_title_bar);
        this.f218397f = (SmartRefreshLayout) findViewById(com.larus.nova.R.id.vote_option_members_refresh_layout);
        this.f218395d = (RecyclerView) findViewById(com.larus.nova.R.id.vote_option_members_rv);
        this.f218398g = (EmptyView) findViewById(com.larus.nova.R.id.vote_option_member_ev);
        this.f218402k = getIntent().getStringExtra(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID);
        this.f218403l = getIntent().getStringExtra(BitableResourceData.KEY_BLOCK_ID);
        this.f218404m = getIntent().getStringExtra("option_id");
        this.f218401j = getIntent().getIntExtra("vote_count", 0);
        this.f218405n = getIntent().getStringExtra("offset");
        this.f218406o = getIntent().getBooleanExtra("isVoteDesc", false);
        BaseTitleBar r101 = this.f218394c;
        Resources r102 = getResources();
        int r103 = this.f218401j;
        r101.setTitle(r102.getQuantityString(com.larus.nova.R.plurals.LarkCCM_Docx_Poll_VoteDetails_Header, r103, new Object[]{Integer.valueOf(r103)}));
        this.f218395d.setLayoutManager(new LinearLayoutManager(this));
        VoteOptionMemberAdapter r104 = new VoteOptionMemberAdapter(this);
        this.f218396e = r104;
        r104.f218384d = new j();
        this.f218395d.setAdapter(r104);
        this.f218397f.F(new LoadMoreFooter(this), -2);
        this.f218397f.A = false;
        this.f218398g.setConfig(new VoteOptionMemberEmptyConfig(getApplicationContext(), ((i0) org.koin.java.a.a(i0.class)).a()).f218390c.invoke());
        this.f218399h = new com.bytedance.ee.bear.facade.common.empty.c(getApplicationContext(), this, this.f218398g, this.f218397f);
        VoteOptionMemberViewModel r105 = (VoteOptionMemberViewModel) ViewModelProviders.of(this).get(VoteOptionMemberViewModel.class);
        this.f218400i = r105;
        r105.attach(new c(this.f218399h.f226424c, this.f218402k, this.f218403l, this.f218404m, this.f218405n, this.f218406o));
        this.f218400i.items().observe(this, new k(this));
        this.f218400i.loadMoreState().observe(this, new l(this));
        this.f218400i.count().observe(this, new m(this));
        this.f218397f.i(new o(this));
        EmptyView r106 = this.f218398g;
        VoteOptionMemberViewModel r107 = this.f218400i;
        Objects.requireNonNull(r107);
        r106.setOnRetryListener(new n(r107));
    }
}
