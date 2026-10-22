package com.bytedance.ee.bear.wikiv2.spacedetail;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.wikiv2.common.widget.ExpandableTextView;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class WikiSpaceDetailActivity extends b implements d0c.c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f241304p = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BaseTitleBar f241305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ExpandableTextView f241306e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView f241307f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WikiSpaceMemberAdapter f241308g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f241309h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f241310i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f241311j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f241312k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f241313l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Disposable f241314m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public i f241315n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Inject
    public NetService f241316o;

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    public final void C1() {
        i r100 = this.f241315n;
        String r101 = this.f241311j;
        NetService r102 = this.f241316o;
        r100.getClass();
        NetService.d r103 = r102.Vc(new j());
        NetService.f r104 = new NetService.f("/space/api/wiki/v2/space/get_member/");
        r104.f216906c = 2;
        r104.b(DocViewModel.EXTRA_SPACE_ID, r101);
        this.f241314m = r103.a(r104).map(new h()).subscribe(new e(this), new f(this));
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // com.bytedance.ee.bear.wikiv2.spacedetail.b, com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
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

    @Override // com.bytedance.ee.bear.wikiv2.spacedetail.b, com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        Disposable r100 = this.f241314m;
        if (r100 == null) goto L8;
        r100.dispose();
    L8:
        super.onDestroy();
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.c(this);
    L5:
        return new ce5.a().f23447b;
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

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    public WikiSpaceDetailActivity() {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity
    public final void B1(Bundle r100) {
        if (getIntent() != null) goto L5;
        tt5.a.d("WikiSpaceDetailActivity", "getIntent is null");
        finish();
    L6:
        setContentView(com.larus.nova.R.layout.wiki_space_detail_activity_v2);
        this.f241315n = new i();
        this.f241305d = (BaseTitleBar) findViewById(com.larus.nova.R.id.wiki_space_detail_title_bar);
        this.f241306e = (ExpandableTextView) findViewById(com.larus.nova.R.id.expand_text_view);
        this.f241307f = (RecyclerView) findViewById(com.larus.nova.R.id.wiki_member_recycler_view);
        this.f241310i = (TextView) findViewById(com.larus.nova.R.id.tv_member_list_name);
        this.f241309h = findViewById(com.larus.nova.R.id.layout_loading_empty_state);
        this.f241308g = new WikiSpaceMemberAdapter(this);
        this.f241307f.setLayoutManager(new LinearLayoutManager(this));
        this.f241307f.setAdapter(this.f241308g);
        WikiSpaceMemberAdapter r101 = this.f241308g;
        ArrayList r102 = new ArrayList();
        int r103 = 0;
    L8:
        if (r103 >= 10) goto L10;
        r102.add(new SpaceBean.MembersBean());
        r103 = r103 + 1;
        goto L8
    L10:
        r101.f241317a = r102;
        r101.f241319c = true;
        this.f241308g.notifyDataSetChanged();
        WikiSpaceMemberAdapter r104 = this.f241308g;
        r104.f241320d = new c(this);
        this.f241309h.setOnClickListener(new d(this));
        this.f241305d.setTitle(com.larus.nova.R.string.Doc_Wiki_SpaceDetail_Title);
        String r105 = this.f241312k;
        if (TextUtils.isEmpty(r105) == true) goto L13;
        this.f241306e.setText(r105);
    L14:
        C1();
        return;
    L13:
        this.f241306e.setText(getResources().getString(com.larus.nova.R.string.Doc_Wiki_SpaceDetail_IntroductionPlaceholder));
        goto L14
    L5:
        this.f241311j = getIntent().getStringExtra(DocViewModel.EXTRA_SPACE_ID);
        this.f241312k = getIntent().getStringExtra("EXTRA_WIKI_DESCRIPTION");
        this.f241313l = getIntent().getStringExtra("node_name");
        goto L6
    }
}
