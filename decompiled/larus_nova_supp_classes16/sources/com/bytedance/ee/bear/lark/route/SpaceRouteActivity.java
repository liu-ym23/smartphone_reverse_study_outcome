package com.bytedance.ee.bear.lark.route;

import ac5.d;
import ac5.e;
import ac5.f;
import android.R;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuConfig;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuViewModel;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.lark.dependency.k;
import com.bytedance.ee.bear.list.ainote.SidebarAINoteFragment;
import com.bytedance.ee.bear.list.create.x0;
import com.bytedance.ee.bear.list.drive.HomeDriveFragment;
import com.bytedance.ee.bear.list.folder.HomePersonalFragment;
import com.bytedance.ee.bear.list.homepage.navigation.NavigationEnum;
import com.bytedance.ee.bear.list.homepage.title.HomeMainTitleBar;
import com.bytedance.ee.bear.list.manualoffline.HomeOfflineFragment;
import com.bytedance.ee.bear.list.recent.subordinate.SubordinateHomeFragment;
import com.bytedance.ee.bear.list.share.HomeSharedFragment;
import com.bytedance.ee.bear.list.sidebar.homedrive.SidebarHomeDriveFragment;
import com.bytedance.ee.bear.list.sidebar.homedrive.pinfolder.SidebarPinFolderFragment;
import com.bytedance.ee.bear.list.star.HomeFavoriteFragment;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.button.CommonCreateButton;
import com.bytedance.ee.bear.wikiv2.home2.WikiHomeFragment2;
import com.bytedance.ee.bear.wikiv2.mylib.HomeLibraryFragment;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import d0c.b;
import d0c.c;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import e0c.l;
import f0c.h;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tt5.a;
import wc5.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SpaceRouteActivity extends BaseActivity implements g, c {
    public static final /* synthetic */ int i = 0;
    public HomeMainTitleBar c;
    public x0 d;
    public int e;
    public String f;
    public String g;
    public String h;

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return b.a(this);
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return b.b(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
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

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    public final UserSession e9() {
        return PassportcConvention.c(this);
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

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m429provideComponent() {
        return provideComponent();
    }

    public SpaceRouteActivity() {
    }

    public final com.bytedance.ee.bear.list.homepage.title.b getTitleBar() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.BaseCommonActivity
    public final void A1(Bundle r5) {
        super.A1(r5);
        getWindow().setBackgroundDrawable(new ColorDrawable(ResourcesCompat.getColor(getResources(), 2131100548, null)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.BaseActivity
    public final void B1(Bundle r10) {
        setContentView(2131561746);
        Intent r11 = getIntent();
        NavigationEnum r0 = NavigationEnum.MY_SPACE;
        this.e = r11.getIntExtra("extra_destination", r0.id);
        a.h("SpaceRouteActivity", "initData()...mDestination = " + this.e);
        qc5.a.j();
        a.h("SpaceRouteActivity", "initView()...singleContainerEnable = true");
        HomeMainTitleBar r12 = findViewById(2131374494);
        this.c = r12;
        int r1 = this.e;
        NavigationEnum r2 = NavigationEnum.SUBORDINATE_RECENT;
        if (r1 == r2.id) goto L5;
        boolean r3 = true;
    L6:
        r12.getClass();
        r12.j = HomeMainTitleBar.TitleType.SPACE_ROUTE.ordinal();
        r12.c();
        if (r3 == false) goto L9;
        r12.e();
    L9:
        qc5.a.k();
        int r13 = this.e;
        if (r13 != r0.id) goto L13;
        String r14 = HomePersonalFragment.class.getName();
        String r4 = getString(2131887935);
        this.f = "personal";
        this.g = "belongtome";
        this.h = "ccm_space_personal_page_click";
    L47:
        HashMap r5 = new HashMap();
        r5.put("module", this.f);
        r5.put("sub_module", this.g);
        BaseTitleBar r6 = this.c.getTitleBar();
        if (r6 == null) goto L50;
        r6.setTag(2131388811, r5);
    L50:
        int r7 = this.e;
        NavigationEnum r8 = NavigationEnum.AI_NOTE;
        if (r7 != r8.id) goto L56;
        String r9 = getIntent().getStringExtra("extra_from");
        if (TextUtils.isEmpty(r9) == false) goto L55;
        r9 = "other";
    L55:
        r5.put("source", r9);
    L56:
        this.c.setTitle(r4);
        this.c.setOnSearchBtnClickListener(new e(this));
        this.c.setOnCreateViewClickListener(new ac5.c(this));
        Fragment r16 = Fragment.instantiate(this, r14, getIntent().getExtras());
        FragmentTransaction r17 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r17, r16, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L60;
        r17 = r17.replace(2131373275, r16);
    L60:
        r17.commitAllowingStateLoss();
        String r18 = this.h;
        CommonCreateButton r19 = findViewById(2131367552);
        qc5.a.k();
        qc5.a.j();
        int r20 = this.e;
        if (r20 != NavigationEnum.SHARED_SPACE.id) goto L63;
    L83:
        r19.setVisibility(8);
        if (this.c.getCreateView() == null) goto L87;
        this.c.getCreateView().setVisibility(8);
    L87:
        if (this.e != NavigationEnum.PIN_FOLDER.id) goto L98;
        HomeMainTitleBar r110 = this.c;
        if (r110 == null) goto L99;
        r110.e.removeAllViews();
        return;
    L99:
        return;
    L98:
        return;
    L63:
        if (r20 == NavigationEnum.PIN_FOLDER.id) goto L83;
        if (r20 != NavigationEnum.FAVORITE.id) goto L71;
        r19.setVisibility(8);
        if (this.c.getCreateView() == null) goto L92;
        this.c.getCreateView().setVisibility(8);
        return;
    L92:
        return;
    L71:
        if (r20 != NavigationEnum.WIKI.id) goto L73;
    L82:
        r19.setVisibility(8);
        return;
    L73:
        if (r20 == NavigationEnum.MY_LIBRARY.id) goto L82;
        if (r20 != r2.id) goto L79;
        r19.setVisibility(8);
        return;
    L79:
        if (r20 != r8.id) goto L81;
        r19.setVisibility(8);
        return;
    L81:
        AppCompatImageView r21 = r19.getCreateButton();
        r21.setOnClickListener(new f(this, r18));
        com.bytedance.ee.bear.lark.e.b(r21, com.bytedance.ee.bear.lark.e.a(), true);
        ((SelectCreationMenuViewModel) ViewModelProviders.of(this).get(SelectCreationMenuViewModel.class)).getSelectedCreationTypeLiveData().observe(this, new d(this));
        return;
    L13:
        if (r13 != NavigationEnum.SHARED_SPACE.id) goto L23;
        r14 = HomeSharedFragment.class.getName();
        qc5.a.j();
        if (qc5.a.d() == true) goto L18;
        r4 = getString(2131887300);
    L21:
        this.f = "shared";
        this.g = "sharetome";
        this.h = "ccm_space_shared_page_click";
        goto L47
    L18:
        if (qc5.a.h() == false) goto L20;
        r4 = getString(2131887929);
        goto L21
    L20:
        r4 = getString(2131887981);
        goto L21
    L23:
        if (r13 != NavigationEnum.WIKI.id) goto L26;
        r14 = WikiHomeFragment2.class.getName();
        r4 = getString(2131887849);
        this.f = "wiki_home";
        this.g = "recent";
        this.h = "ccm_space_wiki_page_click";
        goto L47
    L26:
        if (r13 != NavigationEnum.FAVORITE.id) goto L29;
        r14 = HomeFavoriteFragment.class.getName();
        r4 = getString(2131887927);
        this.f = "favorites";
        this.h = "ccm_space_favorites_page_click";
        goto L47
    L29:
        if (r13 != NavigationEnum.MY_DRIVE.id) goto L32;
        r14 = HomeDriveFragment.class.getName();
        r4 = getString(2131888777);
        this.f = "personal";
        this.g = "belongtome";
        this.h = "ccm_space_personal_page_click";
        goto L47
    L32:
        if (r13 != NavigationEnum.MY_LIBRARY.id) goto L35;
        r14 = HomeLibraryFragment.class.getName();
        r4 = getString(2131888790);
        this.f = "my_docs";
        this.h = "ccm_space_wiki_page_click";
        this.c.setVisibility(8);
        goto L47
    L35:
        if (r13 != NavigationEnum.SIDEBAR_DRIVE.id) goto L38;
        r14 = SidebarHomeDriveFragment.class.getName();
        r4 = getString(2131888777);
        this.f = "new_drive";
        this.h = "ccm_space_drive_page_click";
        goto L47
    L38:
        if (r13 != r2.id) goto L41;
        r14 = SubordinateHomeFragment.class.getName();
        r4 = xo5.a.c(this, 2131888784, "user", getString(2131888047));
        this.f = "offline";
        this.h = "ccm_space_offline_page_click";
        goto L47
    L41:
        if (r13 != NavigationEnum.PIN_FOLDER.id) goto L44;
        r14 = SidebarPinFolderFragment.class.getName();
        r4 = getString(2131887955);
        this.f = "new_drive";
        goto L47
    L44:
        if (r13 != NavigationEnum.AI_NOTE.id) goto L46;
        r14 = SidebarAINoteFragment.class.getName();
        r4 = getString(2131888699);
        this.f = "ai_notes";
        this.h = "ccm_space_drive_page_click";
        goto L47
    L46:
        r14 = HomeOfflineFragment.class.getName();
        r4 = getString(2131887949);
        this.f = "offline";
        this.h = "ccm_space_offline_page_click";
        goto L47
    L5:
        r3 = false;
        goto L6
    }

    public void onMenuCreateClick(View r7) {
        a.h("SpaceRouteActivity", "onMenuCreateClick()...");
        boolean r8 = ((ww4.a) org.koin.java.a.a(ww4.a.class)).a().d().a;
        if (this.e != NavigationEnum.SHARED_SPACE.id) goto L5;
        boolean r0 = true;
    L6:
        boolean r1 = ((k) org.koin.java.a.a(k.class)).d();
        SelectCreationMenuConfig r4 = new SelectCreationMenuConfig();
        r4.k = true;
        r4.l = t0.s();
        if (r1 == true) goto L9;
    L12:
        boolean r2 = true;
    L13:
        r4.o = r2;
        com.bytedance.ee.bear.appsetting.c r3 = com.bytedance.ee.bear.appsetting.c.a.a;
        r4.q = r3.i("ccm.bitable.ccmspace.hassurvey.enable", false);
        r4.p = r3.f("spacekit.mobile.docx_create_enable");
        r4.n = r8;
        boolean r9 = !r0;
        r4.d = r9;
        r4.f = r9;
        r4.g = r9;
        iw4.h r10 = new iw4.h();
        r10.b = this.f;
        r10.c = this.g;
        r10.d = "home";
        qc5.a.j();
        r10.g = true;
        if (this.d != null) goto L16;
        this.d = new x0();
    L16:
        this.d.c(this, r10, r4, null);
        return;
    L9:
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.spacekit.bitable.enable", true) == true) goto L12;
        r2 = false;
        goto L13
    L5:
        r0 = false;
        goto L6
    }
}
