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
import com.bytedance.ee.bear.office.export.space.OfficeSpaceActionResult;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEventSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderEventSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceItem;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceLongPressAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceSelectionState;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.office.list.OfficeFolderDetailHostFragment;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 (2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001(B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0013H\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J \u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020'H\u0002R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/demo/OfficeFolderDetailDemoActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseCommonActivity;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEventListener;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceLongPressEventListener;", "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPageDelegate;", "<init>", "()V", "officeSpaceSdk", "Lcom/bytedance/ee/bear/office/export/space/IOfficeSpaceSdk;", "getOfficeSpaceSdk", "()Lcom/bytedance/ee/bear/office/export/space/IOfficeSpaceSdk;", "setOfficeSpaceSdk", "(Lcom/bytedance/ee/bear/office/export/space/IOfficeSpaceSdk;)V", "fragmentContainerId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "onOpenChildFolder", "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderActionResult;", "request", "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPageRequest;", "onSearch", "onBack", "onLongPressActionClick", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceActionResult;", JSEventListener.ACTION, "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceLongPressAction;", "item", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceItem;", "source", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEventSource;", "handleFolderBack", "", "Companion", "office-ccm-demo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeFolderDetailDemoActivity extends Hilt_OfficeFolderDetailDemoActivity implements d0c.c, com.bytedance.ee.bear.office.export.space.h, com.bytedance.ee.bear.office.export.space.k, com.bytedance.ee.bear.office.export.space.b {
    public static final /* synthetic */ int f = 0;

    @Inject
    public com.bytedance.ee.bear.office.export.space.a d;
    public int e;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeSpaceLongPressAction.values().length];
            r0[OfficeSpaceLongPressAction.ASK_DOUBAO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
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
    @Override // com.bytedance.ee.bear.demo.Hilt_OfficeFolderDetailDemoActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(OfficeFolderDetailDemoActivity.class.getName()));
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

    @Override // com.bytedance.ee.bear.demo.Hilt_OfficeFolderDetailDemoActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(OfficeFolderDetailDemoActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public OfficeFolderDetailDemoActivity() {
        this.e = -1;
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
    public final /* bridge */ /* synthetic */ Object m128provideComponent() {
        return provideComponent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final OfficeFolderActionResult E00(OfficeFolderPageRequest r4) {
        Intrinsics.checkNotNullParameter(r4, "request");
        UDToast.a r0 = UDToast.build(this);
        r0.g("搜索：" + r4.getFolderTitle());
        r0.b.d = -1;
        r0.h();
        return OfficeFolderActionResult.Handled;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public final void onCreate(Bundle r9) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        A1(r9);
        super.onCreate(r9);
        OfficeFolderPageRequest r0 = getIntent().getSerializableExtra("office_folder_request");
        com.bytedance.ee.bear.office.export.space.a r2 = null;
        if ((r0 instanceof OfficeFolderPageRequest) == false) goto L13;
        OfficeFolderPageRequest r1 = r0;
    L14:
        if (r1 != null) goto L16;
        UDToast.a r10 = UDToast.build(this);
        r10.g("文件夹参数缺失");
        r10.b.d = -1;
        r10.h();
        finish();
        return;
    L16:
        LinearLayout r3 = new LinearLayout(this);
        boolean r4 = true;
        r3.setOrientation(1);
        if (r9 == null) goto L28;
        Integer r6 = Integer.valueOf(r9.getInt("state_fragment_container_id", -1));
        int r7 = r6.intValue();
        if (r7 == (-1)) goto L22;
        if (r7 == 0) goto L22;
    L23:
        if (r4 == true) goto L26;
        r6 = null;
    L26:
        if (r6 == null) goto L28;
        int r5 = r6.intValue();
    L29:
        this.e = r5;
        FrameLayout r8 = new FrameLayout(this);
        r8.setId(this.e);
        r3.addView(r8, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        setContentView(r3);
        if (r9 != null) goto L40;
        FragmentTransaction r11 = getSupportFragmentManager().beginTransaction();
        int r12 = r8.getId();
        com.bytedance.ee.bear.office.export.space.a r13 = this.d;
        if (r13 == null) goto L34;
        r2 = r13;
    L35:
        OfficeFolderDetailHostFragment r14 = r2.e(r1, this);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r11, r14, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "office_folder_detail_host", r12) == true) goto L39;
        r11 = r11.replace(r12, r14, "office_folder_detail_host");
    L39:
        r11.commitNowAllowingStateLoss();
        goto L40
    L34:
        Intrinsics.throwUninitializedPropertyAccessException("officeSpaceSdk");
    L40:
        getOnBackPressedDispatcher().addCallback(this, new AnonymousClass2(this));
        return;
    L22:
        r4 = false;
    L28:
        r5 = View.generateViewId();
        goto L29
    L13:
        r1 = null;
        goto L14
    }

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(r3);
        r3.putInt("state_fragment_container_id", this.e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final OfficeFolderActionResult pH(OfficeFolderPageRequest r3) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(this, "context");
        Intrinsics.checkNotNullParameter(r3, "request");
        startActivity(new Intent(this, OfficeFolderDetailDemoActivity.class).putExtra("office_folder_request", r3));
        return OfficeFolderActionResult.Handled;
    }

    public final OfficeFolderActionResult r50(OfficeFolderPageRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        finish();
        return OfficeFolderActionResult.Handled;
    }

    public final OfficeSpaceActionResult Zj(OfficeSpaceHeaderAction r2, OfficeSpaceHeaderEventSource r3) {
        Intrinsics.checkNotNullParameter(r2, JSEventListener.ACTION);
        Intrinsics.checkNotNullParameter(r3, "source");
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
