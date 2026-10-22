package com.bytedance.ee.bear.demo;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.office.export.space.OfficeFolderActionResult;
import com.bytedance.ee.bear.office.export.space.OfficeFolderPageRequest;
import com.bytedance.ee.bear.office.export.space.OfficeListConfig;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceActionResult;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceConfig;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEventSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderEventSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceItem;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceLongPressAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceSelectionState;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 #2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001#B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/demo/OfficeSpaceDemoActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseCommonActivity;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEventListener;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceLongPressEventListener;", "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderRootNavigationListener;", "<init>", "()V", "officeSpaceSdk", "Lcom/bytedance/ee/bear/office/export/space/IOfficeSpaceSdk;", "getOfficeSpaceSdk", "()Lcom/bytedance/ee/bear/office/export/space/IOfficeSpaceSdk;", "setOfficeSpaceSdk", "(Lcom/bytedance/ee/bear/office/export/space/IOfficeSpaceSdk;)V", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onOpenFolder", "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderActionResult;", "request", "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPageRequest;", "onLongPressActionClick", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceActionResult;", "action", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceLongPressAction;", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceItem;", "source", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEventSource;", "onHeaderActionClick", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderAction;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderEventSource;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "Companion", "office-ccm-demo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpaceDemoActivity extends Hilt_OfficeSpaceDemoActivity implements d0c.c, com.bytedance.ee.bear.office.export.space.h, com.bytedance.ee.bear.office.export.space.k, com.bytedance.ee.bear.office.export.space.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f217531e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Inject
    public com.bytedance.ee.bear.office.export.space.a f217532d;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f217533a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f217534b = null;

        static {
            int[] r100 = new int[OfficeSpaceLongPressAction.values().length];
            r100[OfficeSpaceLongPressAction.ASK_DOUBAO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L4:
            f217533a = r100;
            int[] r101 = new int[OfficeSpaceHeaderAction.values().length];
            r101[OfficeSpaceHeaderAction.OPEN_MENU.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L32:
            r101[OfficeSpaceHeaderAction.SEARCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L48:
            r101[OfficeSpaceHeaderAction.CREATE_DOC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L28:
            r101[OfficeSpaceHeaderAction.CREATE_PPT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L38:
            r101[OfficeSpaceHeaderAction.CREATE_BITABLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L22
        L30:
            r101[OfficeSpaceHeaderAction.CREATE_SHEET.ordinal()] = 6;     // Catch: NoSuchFieldError -> L23
        L40:
            r101[OfficeSpaceHeaderAction.CREATE_FOLDER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L24
        L44:
            r101[OfficeSpaceHeaderAction.UPLOAD_IMAGE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L25
        L34:
            r101[OfficeSpaceHeaderAction.UPLOAD_FILE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L26
        L36:
            r101[OfficeSpaceHeaderAction.SELECT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L27
        L15:
            f217534b = r101;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.office.export.space.h
    public final /* synthetic */ OfficeSpaceActionResult.NotHandled XS(OfficeSpaceItem r100, OfficeSpaceEventSource r101) {
        return com.bytedance.ee.bear.office.export.space.g.a(r100, r101);
    }

    @Override // com.bytedance.ee.bear.office.export.space.h
    public final void YJ(OfficeSpaceSelectionState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

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
    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.bytedance.ee.bear.office.export.space.h
    public final void oI(OfficeSpaceTab r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
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

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // com.bytedance.ee.bear.demo.Hilt_OfficeSpaceDemoActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(OfficeSpaceDemoActivity.class.getName()));
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
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L48;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.demo.Hilt_OfficeSpaceDemoActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(OfficeSpaceDemoActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.a(LarkContext.getApplication());
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

    public OfficeSpaceDemoActivity() {
    }

    @Override // com.bytedance.ee.bear.office.export.space.c
    public final OfficeFolderActionResult j1(OfficeFolderPageRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        int r101 = OfficeFolderDetailDemoActivity.f217526f;
        Intrinsics.checkNotNullParameter(this, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, "request");
        startActivity(new Intent(this, OfficeFolderDetailDemoActivity.class).putExtra("office_folder_request", r100));
        return OfficeFolderActionResult.Handled;
    }

    @Override // com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r210) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L7;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (v19.f.f(this) == false) goto L11;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        A1(r210);
        super.onCreate(r210);
        OfficeSpaceConfig r100 = new OfficeSpaceConfig(null, SetsKt.setOf(new OfficeSpaceTab[]{OfficeSpaceTab.RECENT, OfficeSpaceTab.MINE, OfficeSpaceTab.SHARED, OfficeSpaceTab.FAVORITE}), false, false, false, null, new OfficeListConfig(null, false, true, false, null, null, 59, null), null, 189, null);
        LinearLayout r101 = new LinearLayout(this);
        r101.setOrientation(1);
        FrameLayout r102 = new FrameLayout(this);
        r102.setId(View.generateViewId());
        r101.addView(r102, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        setContentView(r101);
        FragmentTransaction r103 = getSupportFragmentManager().beginTransaction();
        int r104 = r102.getId();
        com.bytedance.ee.bear.office.export.space.a r105 = this.f217532d;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("officeSpaceSdk");
        r105 = null;
    L15:
        Fragment r106 = r105.h(r100, this);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r103, r106, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r104) == true) goto L19;
        r103 = r103.replace(r104, r106);
    L19:
        r103.commitNowAllowingStateLoss();
    }

    @Override // com.bytedance.ee.bear.office.export.space.h
    public final OfficeSpaceActionResult Zj(OfficeSpaceHeaderAction r100, OfficeSpaceHeaderEventSource r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "source");
        switch(b.f217534b[r100.ordinal()]) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L7;
            case 9: goto L7;
            case 10: goto L7;
            default: goto L5;
        };
    L8:
        String r102 = "外部收到搜索点击：" + r101.getCurrentTab();
    L10:
        UDToast.a r103 = UDToast.build(this);
        r103.g(r102);
        r103.f285429b.f417630d = -1;
        r103.h();
        return OfficeSpaceActionResult.Handled.INSTANCE;
    L9:
        r102 = "外部收到菜单点击：" + r101.getCurrentTab();
        goto L10
    L5:
        throw new NoWhenBranchMatchedException();
    L7:
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    }

    @Override // com.bytedance.ee.bear.office.export.space.h
    public final OfficeSpaceActionResult ne(OfficeSpaceItem r100, OfficeSpaceEventSource r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "source");
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    }

    @Override // com.bytedance.ee.bear.office.export.space.k
    public final OfficeSpaceActionResult xR(OfficeSpaceLongPressAction r100, OfficeSpaceItem r101, OfficeSpaceEventSource r102) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r102, "source");
        if (b.f217533a[r100.ordinal()] != 1) goto L9;
        UDToast.a r103 = UDToast.build(this);
        String r104 = r101.getTitle();
        if (r104 != null) goto L7;
        r104 = "";
    L7:
        r103.g("多选底栏问问豆包：".concat(r104));
        r103.f285429b.f417630d = -1;
        r103.h();
        return OfficeSpaceActionResult.Handled.INSTANCE;
    L9:
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    }
}
