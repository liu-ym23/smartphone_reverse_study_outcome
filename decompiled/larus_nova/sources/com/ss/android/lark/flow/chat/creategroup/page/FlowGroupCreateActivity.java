package com.ss.android.lark.flow.chat.creategroup.page;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.base.activity.ActivityAnimationManager;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.StatusBarUtil;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\rH\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0003J\b\u0010 \u001a\u00020\u0018H\u0002J\b\u0010!\u001a\u00020\u0018H\u0002J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020\u0018H\u0016J*\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\r2\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010*H\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\rH\u0002J\b\u0010.\u001a\u00020\u0018H\u0002J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020\u0018H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/ss/android/lark/flow/chat/creategroup/page/FlowGroupCreateActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "mFragment", "Lcom/ss/android/lark/flow/chat/creategroup/page/FlowGroupCreateFragmentV2;", "isFinishingAnim", "", "hasShownSheet", "velocityTracker", "Landroid/view/VelocityTracker;", "downRawY", "", "downTranslationY", "touchSlop", "", "dismissTranslationY", "bgMask", "Landroid/view/View;", "bottomSheetContainer", "baseSheetHeight", "dragHandleHeightPx", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "initBottomSheetLayout", "dpToPx", "dp", "initEnterAnimation", "initDragToDismiss", "hideSoftKeyboard", "initDismissBehavior", "getEnterAnimationConfig", "Lcom/ss/android/lark/base/activity/ActivityAnimationManager$AnimationConfig;", "getExitAnimationConfig", VideoEventOneOutSync.END_TYPE_FINISH, "animateTo", LiveDegradeFpsAnimator.TRANSLATION_Y, "maskAlpha", "endAction", "Lkotlin/Function0;", "createTopRoundedBg", "Landroid/graphics/drawable/GradientDrawable;", "radiusDp", "superFinishNoAnim", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "setStatusBarTransparent", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowGroupCreateActivity extends Hilt_FlowGroupCreateActivity implements d0c.c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f422065l = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FlowGroupCreateFragmentV2 f422066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f422067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VelocityTracker f422068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f422069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f422070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f422071g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f422072h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f422073i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f422074j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f422075k;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f422076a;

        public b(Function0<Unit> r100) {
            this.f422076a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function0<Unit> r100 = this.f422076a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.invoke();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
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
    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:57:0x0117 */
    @Override // com.ss.android.lark.flow.chat.creategroup.page.Hilt_FlowGroupCreateActivity, com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        if (this.f422067c == false) goto L5;
        B1();
    L7:
        if ((this instanceof ChatWindowActivity) == true) goto L48;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(FlowGroupCreateActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L49
        if (r103 != null) goto L14;
    L17:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L49
        monitor-exit(r102);     // Catch: Throwable -> L49
    L46:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L54:
        return;
    L20:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L23;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L46
        goto L54
    L23:
        if (isFinishing() == true) goto L26;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L46
        goto L54
    L26:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L29;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L46
        goto L54
    L29:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L32;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L46
        goto L54
    L32:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L35;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L46
        goto L54
    L35:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L37;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L46
        goto L54
    L37:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L46
        if (r104 == null) goto L54;
        r104.addFlags(268435456);     // Catch: Throwable -> L46
        r104.addFlags(2097152);     // Catch: Throwable -> L46
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L46
        startActivity(r104);     // Catch: Throwable -> L43
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L46
        goto L54
    L14:
        if ((r101 - r103.longValue()) >= 800) goto L17;
        monitor-exit(r102);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        throw th;
    L48:
        return;
    L5:
        this.f422067c = true;
        A1(this.f422072h, 0.0f, new AnonymousClass1(this));
        goto L7
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity
    public final ActivityAnimationManager.AnimationConfig getEnterAnimationConfig() {
        return new ActivityAnimationManager.AnimationConfig(0, 0);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity
    public final ActivityAnimationManager.AnimationConfig getExitAnimationConfig() {
        return new ActivityAnimationManager.AnimationConfig(0, 0);
    }

    @Override // com.ss.android.lark.flow.chat.creategroup.page.Hilt_FlowGroupCreateActivity, com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(FlowGroupCreateActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public final void B1() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.c(this);
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

    public FlowGroupCreateActivity() {
    }

    public static final void z1(FlowGroupCreateActivity r100) {
        r100.getClass();
        Log.d("FlowGroupCreateActivitytesttest", "hideSoftKeyboard");     // Catch: Throwable -> L12
        View r101 = r100.getCurrentFocus();     // Catch: Throwable -> L12
        if (r101 == null) goto L17;
        Object r102 = r100.getSystemService("input_method");     // Catch: Throwable -> L12
        if ((r102 instanceof InputMethodManager) == false) goto L8;
        InputMethodManager r103 = (InputMethodManager) r102;     // Catch: Throwable -> L12
    L9:
        if (r103 == null) goto L18;
        r103.hideSoftInputFromWindow(r101.getWindowToken(), 0);     // Catch: Throwable -> L12
        return;
    L18:
        return;
    L8:
        r103 = null;
        goto L9
    L17:
        return;
    L12:
        th = move-exception;
        Log.e("FlowGroupCreateActivity", "hideSoftKeyboard error: " + th);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        ImSdk r101 = ImSdk.f425890a;
        boolean r102 = ImSdk.f425892c;
        boolean r103 = OfficeSDKManager.isAvailable();
        if (r103 == false) goto L56;
        if (r102 == false) goto L56;
        setContentView(com.larus.nova.R.layout.layout_flow_activity_group_create);
        StatusBarUtil.setTransparent(this);     // Catch: Throwable -> L58
    L16:
        this.f422073i = findViewById(com.larus.nova.R.id.bg_mask);
        this.f422074j = findViewById(com.larus.nova.R.id.bottom_sheet_container);
        Resources r104 = getResources();
        this.f422075k = (int) ((WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density * 24.0f) + 0.5f);
        this.f422071g = ViewConfiguration.get(this).getScaledTouchSlop();
        View r105 = this.f422073i;
        if (r105 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("bgMask");
        r105 = null;
    L19:
        r105.setAlpha(0.0f);
        int r106 = UIUtils.getScreenHeight(this);
        int r107 = vgb.b.f554781a;
        Resources r108 = getResources();
        int r109 = r108.getIdentifier("status_bar_height", "dimen", "android");
        if (r109 <= 0) goto L22;
        int r110 = r108.getDimensionPixelSize(r109);
    L23:
        int r111 = r106 - r110;
        Resources r112 = getResources();
        if (r112 == null) goto L26;
        int r113 = r112.getDimensionPixelSize(r112.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android"));
    L27:
        int r114 = r111 - r113;
        View r115 = this.f422074j;
        if (r115 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r115 = null;
    L30:
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
        r116.height = r114;
        View r117 = this.f422074j;
        if (r117 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r117 = null;
    L33:
        r117.setLayoutParams(r116);
        this.f422072h = r114;
        View r118 = this.f422074j;
        if (r118 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r118 = null;
    L36:
        r118.setTranslationY(this.f422072h);
        View r119 = this.f422074j;
        if (r119 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r119 = null;
    L39:
        Resources r120 = getResources();
        float r121 = WindowDisplayMetricsOverride.apply(r120, r120.getDisplayMetrics()).density * 16.0f;
        GradientDrawable r122 = new GradientDrawable();
        r122.setShape(0);
        r122.setColor(-1);
        r122.setCornerRadii(new float[]{r121, r121, r121, r121, 0.0f, 0.0f, 0.0f, 0.0f});
        r119.setBackground(r122);
        View r123 = this.f422074j;
        if (r123 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r123 = null;
    L42:
        r123.setOnTouchListener(new com.ss.android.lark.flow.chat.creategroup.page.b(this));
        View r124 = this.f422074j;
        if (r124 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r124 = null;
    L45:
        r124.post(new c(this));
        View r125 = this.f422073i;
        if (r125 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("bgMask");
        r125 = null;
    L48:
        r125.setOnClickListener(new com.ss.android.lark.flow.chat.creategroup.page.a(this));
        getOnBackPressedDispatcher().addCallback(this, new FlowGroupCreateActivity$initDismissBehavior$2(this));
        this.f422066b = new FlowGroupCreateFragmentV2();
        PassportcConvention.f(new Bundle(), LarkContext.getApplication());
        FlowGroupCreateFragmentV2 r126 = this.f422066b;
        if (r126 == null) goto L51;
        r126.setArguments(getIntent().getExtras());
    L51:
        FragmentTransaction r127 = getSupportFragmentManager().beginTransaction();
        FlowGroupCreateFragmentV2 r128 = this.f422066b;
        Intrinsics.checkNotNull(r128);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r127, r128, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, com.larus.nova.R.id.fragment_container) == true) goto L55;
        r127 = r127.replace(com.larus.nova.R.id.fragment_container, r128);
    L55:
        r127.commitAllowingStateLoss();
        return;
    L26:
        r113 = 0;
        goto L27
    L22:
        r110 = 0;
    L56:
        Log.w("OfficeSDKInitGuard", "office sdk available: " + r103 + ", im sdk ready: " + r102 + ", finish. " + FlowGroupCreateActivity.class.getName());
        super.finish();
    }

    public final void A1(float r100, float r101, Function0<Unit> r102) {
        View r103 = this.f422074j;
        View r104 = null;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r103 = null;
    L5:
        r103.animate().translationY(r100).setDuration(300).withEndAction(new b(r102)).start();
        View r105 = this.f422073i;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bgMask");
    L9:
        r104.animate().alpha(r101).setDuration(300).start();
        return;
    L8:
        r104 = r105;
        goto L9
    }
}
