package com.bytedance.ee.bear.demo;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
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
import com.bytedance.ee.bear.office.space.OfficeSpaceFragment;
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
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 #2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001#B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/demo/OfficeSpaceDemoActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseCommonActivity;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEventListener;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceLongPressEventListener;", "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderRootNavigationListener;", "<init>", "()V", "officeSpaceSdk", "Lcom/bytedance/ee/bear/office/export/space/IOfficeSpaceSdk;", "getOfficeSpaceSdk", "()Lcom/bytedance/ee/bear/office/export/space/IOfficeSpaceSdk;", "setOfficeSpaceSdk", "(Lcom/bytedance/ee/bear/office/export/space/IOfficeSpaceSdk;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onOpenFolder", "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderActionResult;", "request", "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPageRequest;", "onLongPressActionClick", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceActionResult;", JSEventListener.ACTION, "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceLongPressAction;", "item", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceItem;", "source", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEventSource;", "onHeaderActionClick", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderAction;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderEventSource;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "Companion", "office-ccm-demo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpaceDemoActivity extends Hilt_OfficeSpaceDemoActivity implements d0c.c, com.bytedance.ee.bear.office.export.space.h, com.bytedance.ee.bear.office.export.space.k, com.bytedance.ee.bear.office.export.space.c {
    public static final /* synthetic */ int e = 0;

    @Inject
    public com.bytedance.ee.bear.office.export.space.a d;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[OfficeSpaceLongPressAction.values().length];
            r0[OfficeSpaceLongPressAction.ASK_DOUBAO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L4:
            a = r0;
            int[] r1 = new int[OfficeSpaceHeaderAction.values().length];
            r1[OfficeSpaceHeaderAction.OPEN_MENU.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L32:
            r1[OfficeSpaceHeaderAction.SEARCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L48:
            r1[OfficeSpaceHeaderAction.CREATE_DOC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L28:
            r1[OfficeSpaceHeaderAction.CREATE_PPT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L38:
            r1[OfficeSpaceHeaderAction.CREATE_BITABLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L22
        L30:
            r1[OfficeSpaceHeaderAction.CREATE_SHEET.ordinal()] = 6;     // Catch: NoSuchFieldError -> L23
        L40:
            r1[OfficeSpaceHeaderAction.CREATE_FOLDER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L24
        L44:
            r1[OfficeSpaceHeaderAction.UPLOAD_IMAGE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L25
        L34:
            r1[OfficeSpaceHeaderAction.UPLOAD_FILE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L26
        L36:
            r1[OfficeSpaceHeaderAction.SELECT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L27
        L15:
            b = r1;
        }
    }

    static {
    }

    public final /* synthetic */ OfficeSpaceActionResult.NotHandled XS(OfficeSpaceItem r1, OfficeSpaceEventSource r2) {
        return com.bytedance.ee.bear.office.export.space.g.a(r1, r2);
    }

    public final void YJ(OfficeSpaceSelectionState r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    public final void oI(OfficeSpaceTab r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.demo.Hilt_OfficeSpaceDemoActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(OfficeSpaceDemoActivity.class.getName()));
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
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L48;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.demo.Hilt_OfficeSpaceDemoActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(OfficeSpaceDemoActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public final UserSession e9() {
        return PassportcConvention.a(LarkContext.getApplication());
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
    public final /* bridge */ /* synthetic */ Object m129provideComponent() {
        return provideComponent();
    }

    public OfficeSpaceDemoActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final OfficeFolderActionResult j1(OfficeFolderPageRequest r3) {
        Intrinsics.checkNotNullParameter(r3, "request");
        int r1 = OfficeFolderDetailDemoActivity.f;
        Intrinsics.checkNotNullParameter(this, "context");
        Intrinsics.checkNotNullParameter(r3, "request");
        startActivity(new Intent(this, OfficeFolderDetailDemoActivity.class).putExtra("office_folder_request", r3));
        return OfficeFolderActionResult.Handled;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public final void onCreate(Bundle r26) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L7;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (v19.f.f(this) == false) goto L11;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        A1(r26);
        super.onCreate(r26);
        OfficeSpaceConfig r1 = new OfficeSpaceConfig(null, SetsKt.setOf(new OfficeSpaceTab[]{OfficeSpaceTab.RECENT, OfficeSpaceTab.MINE, OfficeSpaceTab.SHARED, OfficeSpaceTab.FAVORITE}), false, false, false, null, new OfficeListConfig(null, false, true, false, null, null, 59, null), null, 189, null);
        LinearLayout r2 = new LinearLayout(this);
        r2.setOrientation(1);
        FrameLayout r3 = new FrameLayout(this);
        r3.setId(View.generateViewId());
        r2.addView(r3, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        setContentView(r2);
        FragmentTransaction r4 = getSupportFragmentManager().beginTransaction();
        int r5 = r3.getId();
        com.bytedance.ee.bear.office.export.space.a r6 = this.d;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("officeSpaceSdk");
        r6 = null;
    L15:
        OfficeSpaceFragment r7 = r6.h(r1, this);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r4, r7, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r5) == true) goto L19;
        r4 = r4.replace(r5, r7);
    L19:
        r4.commitNowAllowingStateLoss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final OfficeSpaceActionResult Zj(OfficeSpaceHeaderAction r3, OfficeSpaceHeaderEventSource r4) {
        Intrinsics.checkNotNullParameter(r3, JSEventListener.ACTION);
        Intrinsics.checkNotNullParameter(r4, "source");
        switch(b.b[r3.ordinal()]) {
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
        String r5 = "外部收到搜索点击：" + r4.getCurrentTab();
    L10:
        UDToast.a r6 = UDToast.build(this);
        r6.g(r5);
        r6.b.d = -1;
        r6.h();
        return OfficeSpaceActionResult.Handled.INSTANCE;
    L9:
        r5 = "外部收到菜单点击：" + r4.getCurrentTab();
        goto L10
    L5:
        throw new NoWhenBranchMatchedException();
    L7:
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    }

    public final OfficeSpaceActionResult ne(OfficeSpaceItem r2, OfficeSpaceEventSource r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "source");
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final OfficeSpaceActionResult xR(OfficeSpaceLongPressAction r3, OfficeSpaceItem r4, OfficeSpaceEventSource r5) {
        Intrinsics.checkNotNullParameter(r3, JSEventListener.ACTION);
        Intrinsics.checkNotNullParameter(r4, "item");
        Intrinsics.checkNotNullParameter(r5, "source");
        if (b.a[r3.ordinal()] != 1) goto L9;
        UDToast.a r6 = UDToast.build(this);
        String r7 = r4.getTitle();
        if (r7 != null) goto L7;
        r7 = "";
    L7:
        r6.g("多选底栏问问豆包：".concat(r7));
        r6.b.d = -1;
        r6.h();
        return OfficeSpaceActionResult.Handled.INSTANCE;
    L9:
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    }
}
