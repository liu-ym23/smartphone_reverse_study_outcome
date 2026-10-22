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
import com.bytedance.ee.bear.office.export.space.OfficeSpaceActionResult;
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
import java.io.Serializable;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 (2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001(B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0013H\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J \u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020'H\u0002R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/demo/OfficeFolderDetailDemoActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseCommonActivity;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEventListener;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceLongPressEventListener;", "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPageDelegate;", "<init>", "()V", "officeSpaceSdk", "Lcom/bytedance/ee/bear/office/export/space/IOfficeSpaceSdk;", "getOfficeSpaceSdk", "()Lcom/bytedance/ee/bear/office/export/space/IOfficeSpaceSdk;", "setOfficeSpaceSdk", "(Lcom/bytedance/ee/bear/office/export/space/IOfficeSpaceSdk;)V", "fragmentContainerId", "", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "onOpenChildFolder", "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderActionResult;", "request", "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPageRequest;", "onSearch", com.alipay.sdk.m.x.d.f25924n, "onLongPressActionClick", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceActionResult;", "action", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceLongPressAction;", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceItem;", "source", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEventSource;", "handleFolderBack", "", "Companion", "office-ccm-demo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeFolderDetailDemoActivity extends Hilt_OfficeFolderDetailDemoActivity implements d0c.c, com.bytedance.ee.bear.office.export.space.h, com.bytedance.ee.bear.office.export.space.k, com.bytedance.ee.bear.office.export.space.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f217526f = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Inject
    public com.bytedance.ee.bear.office.export.space.a f217527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f217528e;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f217529a = null;

        static {
            int[] r100 = new int[OfficeSpaceLongPressAction.values().length];
            r100[OfficeSpaceLongPressAction.ASK_DOUBAO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f217529a = r100;
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
    @Override // com.bytedance.ee.bear.demo.Hilt_OfficeFolderDetailDemoActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(OfficeFolderDetailDemoActivity.class.getName()));
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

    @Override // com.bytedance.ee.bear.demo.Hilt_OfficeFolderDetailDemoActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(OfficeFolderDetailDemoActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public OfficeFolderDetailDemoActivity() {
        this.f217528e = -1;
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

    @Override // com.bytedance.ee.bear.office.export.space.b
    public final OfficeFolderActionResult E00(OfficeFolderPageRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        UDToast.a r101 = UDToast.build(this);
        r101.g("搜索：" + r100.getFolderTitle());
        r101.f285429b.f417630d = -1;
        r101.h();
        return OfficeFolderActionResult.Handled;
    }

    @Override // com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        A1(r100);
        super.onCreate(r100);
        Serializable r101 = getIntent().getSerializableExtra("office_folder_request");
        com.bytedance.ee.bear.office.export.space.a r102 = null;
        if ((r101 instanceof OfficeFolderPageRequest) == false) goto L13;
        OfficeFolderPageRequest r103 = (OfficeFolderPageRequest) r101;
    L14:
        if (r103 != null) goto L16;
        UDToast.a r104 = UDToast.build(this);
        r104.g("文件夹参数缺失");
        r104.f285429b.f417630d = -1;
        r104.h();
        finish();
        return;
    L16:
        LinearLayout r105 = new LinearLayout(this);
        boolean r106 = true;
        r105.setOrientation(1);
        if (r100 == null) goto L28;
        Integer r107 = Integer.valueOf(r100.getInt("state_fragment_container_id", -1));
        int r108 = r107.intValue();
        if (r108 == (-1)) goto L22;
        if (r108 == 0) goto L22;
    L23:
        if (r106 == true) goto L26;
        r107 = null;
    L26:
        if (r107 == null) goto L28;
        int r109 = r107.intValue();
    L29:
        this.f217528e = r109;
        FrameLayout r110 = new FrameLayout(this);
        r110.setId(this.f217528e);
        r105.addView(r110, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        setContentView(r105);
        if (r100 != null) goto L40;
        FragmentTransaction r111 = getSupportFragmentManager().beginTransaction();
        int r112 = r110.getId();
        com.bytedance.ee.bear.office.export.space.a r113 = this.f217527d;
        if (r113 == null) goto L34;
        r102 = r113;
    L35:
        Fragment r114 = r102.e(r103, this);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r111, r114, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "office_folder_detail_host", r112) == true) goto L39;
        r111 = r111.replace(r112, r114, "office_folder_detail_host");
    L39:
        r111.commitNowAllowingStateLoss();
        goto L40
    L34:
        Intrinsics.throwUninitializedPropertyAccessException("officeSpaceSdk");
    L40:
        getOnBackPressedDispatcher().addCallback(this, new AnonymousClass2(this));
        return;
    L22:
        r106 = false;
    L28:
        r109 = View.generateViewId();
        goto L29
    L13:
        r103 = null;
        goto L14
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        super.onSaveInstanceState(r100);
        r100.putInt("state_fragment_container_id", this.f217528e);
    }

    @Override // com.bytedance.ee.bear.office.export.space.b
    public final OfficeFolderActionResult pH(OfficeFolderPageRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(this, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, "request");
        startActivity(new Intent(this, OfficeFolderDetailDemoActivity.class).putExtra("office_folder_request", r100));
        return OfficeFolderActionResult.Handled;
    }

    @Override // com.bytedance.ee.bear.office.export.space.b
    public final OfficeFolderActionResult r50(OfficeFolderPageRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        finish();
        return OfficeFolderActionResult.Handled;
    }

    @Override // com.bytedance.ee.bear.office.export.space.h
    public final OfficeSpaceActionResult Zj(OfficeSpaceHeaderAction r100, OfficeSpaceHeaderEventSource r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "source");
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
        if (b.f217529a[r100.ordinal()] != 1) goto L9;
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
