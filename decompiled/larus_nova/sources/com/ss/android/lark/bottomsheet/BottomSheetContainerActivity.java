package com.ss.android.lark.bottomsheet;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResultCaller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.base.activity.ActivityAnimationManager;
import com.ss.android.lark.bottomsheet.fragment.BottomSheetFrameFragment;
import com.ss.android.lark.bottomsheet.view.OverClapBottomSheetBehavior;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.bottomsheet.BottomSheetViewModel;
import com.ss.android.lark.chat.utils.z;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.utils.StatusBarUtil;
import com.ss.android.lark.view.SizeDetectConstraintLayout;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 P2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001PB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\b\u0010+\u001a\u00020(H\u0002J\b\u0010,\u001a\u00020(H\u0016J\b\u0010-\u001a\u00020(H\u0002J\b\u0010.\u001a\u00020(H\u0002J\b\u0010/\u001a\u00020(H\u0002J\b\u00100\u001a\u00020(H\u0002J\b\u00101\u001a\u00020(H\u0016J\b\u00102\u001a\u00020(H\u0002J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u00020(H\u0002J\b\u00108\u001a\u000209H\u0002J\u0010\u0010:\u001a\u00020(2\b\u0010;\u001a\u0004\u0018\u00010\u001eJ\u000e\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u000206J\b\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020?H\u0016J\u0010\u0010A\u001a\u00020(2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020(H\u0014J\b\u0010E\u001a\u00020(H\u0014J\u0012\u0010F\u001a\u00020(2\b\u0010G\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010H\u001a\u00020(2\b\u0010G\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010I\u001a\u00020(2\u0006\u0010J\u001a\u00020KH\u0016J\u0012\u0010L\u001a\u00020K2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\b\u0010O\u001a\u00020KH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R)\u0010\u001f\u001a\r\u0012\t\u0012\u00070!¢\u0006\u0002\b\"0 8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006Q"}, d2 = {"Lcom/ss/android/lark/bottomsheet/BottomSheetContainerActivity;", "Lcom/ss/android/lark/bottomsheet/BottomSheetContainerBaseActivity;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/IBottomSheetFunction;", "Lcom/ss/android/lark/notification/export/IPushNotifyStrategy;", "<init>", "()V", "mRootView", "Lcom/ss/android/lark/view/SizeDetectConstraintLayout;", "mShadowView", "Landroid/view/View;", "mCoordinateLayout", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "mFragmentContainerView", "Landroid/widget/FrameLayout;", "bottomSheetBehavior", "Lcom/ss/android/lark/bottomsheet/view/OverClapBottomSheetBehavior;", "viewModel", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/bottomsheet/BottomSheetViewModel;", "getViewModel", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/bottomsheet/BottomSheetViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "expandAnimator", "Lcom/ss/android/lark/bottomsheet/view/ExpandValueAnimator;", "fragmentFactory", "Lcom/ss/android/lark/bottomsheet/fragment/BottomSheetFragmentFactory;", "getFragmentFactory", "()Lcom/ss/android/lark/bottomsheet/fragment/BottomSheetFragmentFactory;", "fragmentFactory$delegate", "topMarginProvider", "Lcom/ss/android/lark/bottomsheet/TopMarginProvider;", "fragmentProviders", "", "Lcom/ss/android/lark/bottomsheet/fragment/BottomSheetFragmentFactory$IBottomSheetFragmentProvider;", "Lkotlin/jvm/JvmSuppressWildcards;", "getFragmentProviders", "()Ljava/util/List;", "setFragmentProviders", "(Ljava/util/List;)V", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "ensureTransparentActivityBackground", "loadFragment", "initFragmentFactory", "initView", "initCustomView", "finishInternal", VideoEventOneOutSync.END_TYPE_FINISH, "initBottomSheetBehavior", "calculateMarginTop", "", "orientation", "", "initViewModel", "createAnimConfig", "Lcom/ss/android/lark/bottomsheet/view/ExpandValueAnimator$AnimatorConfig;", "setTopMarginProvider", ShortVideoSegments.KEY_PROP_PROVIDER, "updateFragmentContainerHeight", "newTopMargin", "getEnterAnimationConfig", "Lcom/ss/android/lark/base/activity/ActivityAnimationManager$AnimationConfig;", "getExitAnimationConfig", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "registerBottomSheetBarOverLapView", "view", "registerBottomSheetTitleBarView", "enableBottomSheet", "enable", "", "shouldNotifyPush", "notice", "Lcom/ss/android/lark/notification/export/entity/Notice;", "statusBarBackgroundVisible", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@AndroidEntryPoint
public final class BottomSheetContainerActivity extends Hilt_BottomSheetContainerActivity implements com.ss.android.lark.chat.chatwindow.chat.v2.component.b, zsb.d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f410661n = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SizeDetectConstraintLayout f410662e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f410663f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CoordinatorLayout f410664g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f410665h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public OverClapBottomSheetBehavior<View> f410666i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewModelLazy f410667j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.ss.android.lark.bottomsheet.view.a f410668k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f410669l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Inject
    public List<com.ss.android.lark.bottomsheet.fragment.a.c> f410670m;

    public static final class a {
    }

    public static final class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetContainerActivity f410671a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public b(BottomSheetContainerActivity r100) {
            this.f410671a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            BottomSheetContainerActivity.B1(this.f410671a);
        }
    }

    static {
    }

    public final com.ss.android.lark.bottomsheet.view.a.b D1() {
        CoordinatorLayout r100 = this.f410664g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCoordinateLayout");
        r100 = null;
    L5:
        WindowInsetsCompat r101 = ViewCompat.getRootWindowInsets(r100);
        if (r101 == null) goto L10;
        Insets r102 = r101.getInsets(WindowInsetsCompat.Type.statusBars());
        if (r102 == null) goto L10;
        int r103 = r102.top;
    L11:
        Integer r104 = F1().getOrientation().getValue();
        if (r104 != null) goto L15;
    L17:
        if (r104 != null) goto L20;
    L22:
        long r105 = 300;
    L24:
        return new com.ss.android.lark.bottomsheet.view.a.b(r103, r105);
    L20:
        if (r104.intValue() != 2) goto L22;
        r105 = 100;
        goto L24
    L15:
        if (r104.intValue() != 1) goto L17;
    L10:
        r103 = StatusBarUtil.getStatusBarHeight(this);
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final BottomSheetViewModel F1() {
        return (BottomSheetViewModel) this.f410667j.getValue();
    }

    @Override // com.ss.android.lark.bottomsheet.Hilt_BottomSheetContainerActivity, com.ss.android.lark.bottomsheet.BottomSheetContainerBaseActivity, com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(BottomSheetContainerActivity.class.getName()));
    L5:
        super.onDestroy();
        com.ss.android.lark.bottomsheet.view.a r100 = this.f410668k;
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.a().isRunning() == false) goto L12;
        r100.a().cancel();
        return;
    }

    public BottomSheetContainerActivity() {
        Function0<ViewModelProvider.Factory> r100 = new BottomSheetContainerActivity$special$$inlined$viewModels$default$1(this);
        final Function0 r101 = null;
        this.f410667j = new ViewModelLazy(Reflection.getOrCreateKotlinClass(BottomSheetViewModel.class), new BottomSheetContainerActivity$special$$inlined$viewModels$default$2(this), r100, new BottomSheetContainerActivity$special$$inlined$viewModels$default$3(r101, this));
        this.f410669l = LazyKt.lazy(BottomSheetContainerActivity$fragmentFactory$2.INSTANCE);
    }

    /* JADX INFO: Removed unreachable split cross block B:65:0x0160 */
    @Override // com.ss.android.lark.bottomsheet.Hilt_BottomSheetContainerActivity, com.ss.android.lark.bottomsheet.BottomSheetContainerBaseActivity, com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        z.a(this);
        Integer r100 = F1().getState().getValue();
        if (r100 != null) goto L6;
    L8:
        Animation r101 = AnimationUtils.loadAnimation(this, R.anim.embedded_fragment_exit);
        r101.setFillAfter(true);
        r101.setAnimationListener(new b(this));
        FrameLayout r102 = this.f410665h;
        View r103 = null;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFragmentContainerView");
        r102 = null;
    L11:
        r102.startAnimation(r101);
        View r104 = this.f410663f;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mShadowView");
    L15:
        Animation r105 = AnimationUtils.loadAnimation(this, R.anim.embedded_activity_shadow_exit);
        r105.setFillAfter(true);
        r103.startAnimation(r105);
    L17:
        if ((this instanceof ChatWindowActivity) == true) goto L58;
        FLogger r106 = FLogger.f375446a;
        r106.i("ActivityLancet", "finish ".concat(BottomSheetContainerActivity.class.getName()));
        long r107 = SystemClock.uptimeMillis();
        Map<Activity, Long> r108 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r108);
        Long r109 = r108.get(this);     // Catch: Throwable -> L59
        if (r109 != null) goto L24;
    L27:
        r108.put(this, Long.valueOf(r107));     // Catch: Throwable -> L59
        monitor-exit(r108);     // Catch: Throwable -> L59
    L56:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L62:
        return;
    L30:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L33;
        r106.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L56
        goto L62
    L33:
        if (isFinishing() == true) goto L36;
        r106.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L56
        goto L62
    L36:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L39;
        r106.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L56
        goto L62
    L39:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L42;
        r106.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L56
        goto L62
    L42:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L45;
        r106.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L56
        goto L62
    L45:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L47;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L56
        goto L62
    L47:
        Intent r110 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L56
        if (r110 == null) goto L62;
        r110.addFlags(268435456);     // Catch: Throwable -> L56
        r110.addFlags(2097152);     // Catch: Throwable -> L56
        r106.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L56
        startActivity(r110);     // Catch: Throwable -> L53
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L56
        goto L62
    L24:
        if ((r107 - r109.longValue()) >= 800) goto L27;
        monitor-exit(r108);     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        throw th;
    L58:
        return;
    L14:
        r103 = r104;
        goto L15
    L6:
        if (r100.intValue() != 2) goto L8;
        super.finish();
        goto L17
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity
    public final ActivityAnimationManager.AnimationConfig getEnterAnimationConfig() {
        Integer r100 = F1().getState().getValue();
        if (r100 == null) goto L10;
        if (r100.intValue() != 2) goto L10;
        return new ActivityAnimationManager.AnimationConfig(ActivityAnimationManager.ANIM_SLIDE_RIGHT_IN);
    L10:
        return new ActivityAnimationManager.AnimationConfig(ActivityAnimationManager.ANIM_HOLD);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity
    public final ActivityAnimationManager.AnimationConfig getExitAnimationConfig() {
        Integer r100 = F1().getState().getValue();
        if (r100 == null) goto L10;
        if (r100.intValue() != 2) goto L10;
        return new ActivityAnimationManager.AnimationConfig(ActivityAnimationManager.ANIM_SLIDE_RIGHT_OUT);
    L10:
        return new ActivityAnimationManager.AnimationConfig(ActivityAnimationManager.ANIM_HOLD);
    }

    public final void loadFragment() {
        Animation r100 = AnimationUtils.loadAnimation(this, R.anim.embedded_activity_shadow_enter);
        r100.setFillBefore(true);
        View r101 = this.f410663f;
        FrameLayout r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mShadowView");
        r101 = null;
    L5:
        r101.startAnimation(r100);
        FragmentTransaction r103 = getSupportFragmentManager().beginTransaction();
        Pair<BottomSheetFrameFragment, com.ss.android.lark.bottomsheet.fragment.a.b> r104 = ((com.ss.android.lark.bottomsheet.fragment.a) this.f410669l.getValue()).a(getIntent().getExtras());
        if (r104 == null) goto L8;
        BottomSheetFrameFragment r105 = r104.getFirst();
    L9:
        if (r105 != null) goto L11;
        super.finish();
    L19:
        r103.commitNowAllowingStateLoss();
        return;
    L11:
        r103.setCustomAnimations(R.anim.embedded_fragment_enter, R.anim.embedded_fragment_exit);
        FrameLayout r106 = this.f410665h;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFragmentContainerView");
    L15:
        int r107 = r102.getId();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r103, r105, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "installed_fragment", r107) == true) goto L19;
        r103.replace(r107, r105, "installed_fragment");
        goto L19
    L14:
        r102 = r106;
        goto L15
    L8:
        r105 = null;
        goto L9
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (isFinishing() == false) goto L6;
        z.a(this);
    L6:
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L12;
        z1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L9
        return;
    L13:
        return;
    }

    public static final void B1(BottomSheetContainerActivity r100) {
        super.finish();
    }

    public static final /* synthetic */ String C1(BottomSheetContainerActivity r100) {
        return r100.PARENT_TAG;
    }

    public static View z1(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // zsb.d
    public final boolean Cy(Notice r100) {
        ActivityResultCaller r101 = getFragment();
        if ((r101 instanceof com.ss.android.lark.bottomsheet.fragment.d) == false) goto L5;
        com.ss.android.lark.bottomsheet.fragment.d r102 = (com.ss.android.lark.bottomsheet.fragment.d) r101;
    L6:
        if (r102 != null) goto L10;
        return true;
    L10:
        return r102.y30(r100);
    L5:
        r102 = null;
        goto L6
    }

    public final void G1(int r100) {
        CoordinatorLayout r101 = this.f410664g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCoordinateLayout");
        r101 = null;
    L5:
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L10;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        r103.topMargin = r100;
        r101.setLayoutParams(r103);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (dc9.d.a() == true) goto L19;
        int r101 = getRequestedOrientation();     // Catch: Throwable -> L17
        if (r100 == null) goto L8;
        Integer r102 = Integer.valueOf(r100.orientation);     // Catch: Throwable -> L17
    L9:
        if (r102 != null) goto L12;
    L14:
        if (r101 != 3) goto L19;
        setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.f375446a.i("PadLancet", "onConfigurationChanged, phone reset page:BottomSheetContainerActivity portrait");     // Catch: Throwable -> L17
        goto L19
    L12:
        if (r102.intValue() == r101) goto L19;
    L8:
        r102 = null;
    L19:
        int r103 = r100.orientation;
        Integer r104 = F1().getOrientation().getValue();
        if (r104 != null) goto L23;
    L24:
        F1().getOrientation().postValue(Integer.valueOf(r100.orientation));
        return;
    L23:
        if (r103 != r104.intValue()) goto L24;
        return;
    L17:
        th = move-exception;
        FLogger.f375446a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L19
    }

    @Override // com.ss.android.lark.bottomsheet.BottomSheetContainerBaseActivity, com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.ss.android.lark.insets.h r101 = WindowInsetsUtils.c(this);
        r101.c(false);
        r101.o(false);
        r101.f(false);
        r101.b(0);
        F1().getOrientation().setValue(Integer.valueOf(getResources().getConfiguration().orientation));
        setContentView(R.layout.activity_common_bottom_sheet);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        getWindow().clearFlags(2);
        View r102 = findViewById(android.R.id.content);
        if (r102 == null) goto L13;
        r102.setBackgroundResource(android.R.color.transparent);
    L13:
        View r103 = findViewById(R.id.root);
        if (r103 == null) goto L16;
        r103.setBackgroundResource(android.R.color.transparent);
    L16:
        Log.i("BottomSheetContainer", "load bottom sheet activity start");
        List<com.ss.android.lark.bottomsheet.fragment.a.c> r104 = this.f410670m;
        CoordinatorLayout r105 = null;
        if (r104 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentProviders");
        r104 = null;
    L20:
        Iterator<T> r106 = r104.iterator();
    L22:
        if (r106.hasNext() == false) goto L24;
        com.ss.android.lark.bottomsheet.fragment.a.c r107 = (com.ss.android.lark.bottomsheet.fragment.a.c) r106.next();
        com.ss.android.lark.bottomsheet.fragment.a r108 = (com.ss.android.lark.bottomsheet.fragment.a) this.f410669l.getValue();
        r108.getClass();
        Intrinsics.checkNotNullParameter(r107, ShortVideoSegments.KEY_PROP_PROVIDER);
        ((HashMap) r108.f410710a).put(r107.clazz(), r107);
        goto L22
    L24:
        this.f410663f = findViewById(R.id.shadow);
        this.f410664g = (CoordinatorLayout) findViewById(R.id.coordinator);
        this.f410662e = (SizeDetectConstraintLayout) findViewById(R.id.root);
        this.f410665h = (FrameLayout) findViewById(R.id.fragment_container);
        View r109 = this.f410663f;
        if (r109 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mShadowView");
        r109 = null;
    L27:
        r109.setOnClickListener(new d(this));
        FrameLayout r110 = this.f410665h;
        if (r110 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mFragmentContainerView");
        r110 = null;
    L30:
        BottomSheetBehavior r111 = BottomSheetBehavior.from(r110);
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type com.ss.android.lark.bottomsheet.view.OverClapBottomSheetBehavior<android.view.View>");
        OverClapBottomSheetBehavior<View> r112 = (OverClapBottomSheetBehavior) r111;
        this.f410666i = r112;
        if (r112 == null) goto L33;
        r112.setBottomSheetCallback(new c(this, r112));
        r112.setSkipCollapsed(true);
        r112.setFitToContents(true);
        r112.setHideable(true);
        r112.setState(5);
    L33:
        SizeDetectConstraintLayout r113 = this.f410662e;
        if (r113 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        r113 = null;
    L36:
        OneShotPreDrawListener.add(r113, new com.ss.android.lark.bottomsheet.b(r113, this));
        SizeDetectConstraintLayout r114 = this.f410662e;
        if (r114 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        r114 = null;
    L39:
        r114.addOnLayoutChangeListener(new com.ss.android.lark.bottomsheet.a(this));
        if (getSupportFragmentManager().findFragmentByTag("installed_fragment") != null) goto L42;
        loadFragment();
    L43:
        F1().getState().observe(this, new f(this));
        F1().getStatusBarColorChangeEvent().observe(this, new g(this));
        F1().getBottomSheetStateChangeEvent().observe(this, new i(this));
        F1().getOrientation().observe(this, new k(this));
        String r115 = getIntent().getStringExtra("key_bottom_sheet_content_class");
        List<com.ss.android.lark.bottomsheet.fragment.a.c> r116 = this.f410670m;
        if (r116 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentProviders");
        r116 = null;
    L47:
        Iterator<T> r117 = r116.iterator();
    L49:
        if (r117.hasNext() == false) goto L53;
        Object r118 = r117.next();
        if (Intrinsics.areEqual(((com.ss.android.lark.bottomsheet.fragment.a.c) r118).clazz(), r115) == false) goto L49;
    L54:
        com.ss.android.lark.bottomsheet.fragment.a.c r119 = (com.ss.android.lark.bottomsheet.fragment.a.c) r118;
        if (r119 == null) goto L62;
        Integer r120 = r119.b();
        if (r120 == null) goto L62;
        int r121 = r120.intValue();
        View r122 = this.f410663f;
        if (r122 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("mShadowView");
        r122 = null;
    L61:
        r122.setBackgroundResource(r121);
    L62:
        CoordinatorLayout r123 = this.f410664g;
        if (r123 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("mCoordinateLayout");
    L66:
        this.f410668k = new com.ss.android.lark.bottomsheet.view.a(r105, D1());
        WindowInsetsUtils.f(this);
        return;
    L65:
        r105 = r123;
        goto L66
    L53:
        r118 = null;
        goto L54
    L42:
        Log.i(this.PARENT_TAG, "activity recreated");
        goto L43
    }

    public void registerBottomSheetBarOverLapView(View r100) {
        if (r100 == null) goto L7;
        OverClapBottomSheetBehavior<View> r101 = this.f410666i;
        if (r101 == null) goto L8;
        Intrinsics.checkNotNullParameter(r100, "view");
        r101.f410747d = r100;
        return;
    L8:
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.b
    public void registerBottomSheetTitleBarView(View r100) {
        ActivityResultCaller r101 = getFragment();
        if ((r101 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.b) == false) goto L5;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.b r102 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.b) r101;
    L6:
        if (r102 == null) goto L9;
        r102.registerBottomSheetTitleBarView(r100);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static final float A1(BottomSheetContainerActivity r100, int r101) {
        if (r101 != 1) goto L5;
        int r102 = z1(r100.getWindow()).getHeight();
    L9:
        float r103 = r102;
        float r104 = 0.2f;
    L11:
        return r103 * r104;
    L5:
        if (r101 == 2) goto L7;
        r102 = z1(r100.getWindow()).getHeight();
        goto L9
    L7:
        r103 = z1(r100.getWindow()).getHeight();
        r104 = 0.1f;
        goto L11
    }
}
