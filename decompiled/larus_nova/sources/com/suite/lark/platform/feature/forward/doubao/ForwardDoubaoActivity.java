package com.suite.lark.platform.feature.forward.doubao;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larksuite.framework.utils.UIUtils;
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
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 R2\u00020\u0001:\u0001RB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u001eH\u0002J\b\u0010$\u001a\u00020\u0011H\u0002J\u0012\u0010%\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010&\u001a\u00020\u001eH\u0002J\b\u0010'\u001a\u00020\u001eH\u0003J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020\u001eH\u0002J\b\u0010,\u001a\u00020\u001eH\u0002J\u0014\u0010-\u001a\u00020\u001e2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/J\u0006\u00101\u001a\u00020\u001eJ\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000203H\u0016J\b\u00105\u001a\u00020\u001eH\u0016J8\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\f2\u000e\b\u0002\u00109\u001a\b\u0012\u0004\u0012\u00020\u001e0:2\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001e0:H\u0002J\b\u0010<\u001a\u00020\u001eH\u0002JX\u0010=\u001a\u00020\u00072\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?0/2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\f2%\b\u0002\u0010A\u001a\u001f\u0012\u0013\u0012\u00110C¢\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u001e\u0018\u00010B2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010C¢\u0006\u0002\u0010HJZ\u0010I\u001a\u00020\u001e2\u0006\u0010J\u001a\u00020C2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\f2\u0006\u0010K\u001a\u00020C2%\b\u0002\u0010A\u001a\u001f\u0012\u0013\u0012\u00110C¢\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u001e\u0018\u00010B2\b\b\u0002\u0010L\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010MJh\u0010N\u001a\u00020\u001e2\u0006\u0010J\u001a\u00020C2\b\u0010O\u001a\u0004\u0018\u00010P2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010C2%\b\u0002\u0010A\u001a\u001f\u0012\u0013\u0012\u00110C¢\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u001e\u0018\u00010B2\b\b\u0002\u0010L\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010QR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/ForwardDoubaoActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "<init>", "()V", "mFragment", "Lcom/suite/lark/platform/feature/forward/doubao/DoubaoForwardFragment;", "isFinishingAnim", "", "hasShownSheet", "velocityTracker", "Landroid/view/VelocityTracker;", "downRawY", "", "downTranslationY", "isDragHandleTouched", "hasDraggedSheetDown", "touchSlop", "", "dragStartThresholdPx", "dragDismissMinDistancePx", "dismissTranslationY", "bgMask", "Landroid/view/View;", "bottomSheetContainer", "dragHandleHeightPx", "dragHeaderHeightPx", "dragButtonSafeInsetPx", "isShowingSendToBanner", "confirmModeActive", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "ensureTransparentActivityBackground", "initBottomSheetLayout", "applySheetHeight", "pickerSheetHeightPx", "dropRestoredConfirmFragmentIfNeeded", "initEnterAnimation", "initDragToDismiss", "isInDragHandleArea", "event", "Landroid/view/MotionEvent;", "initDismissBehavior", "handleBackOrFinish", "openConfirmFragment", "items", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "closeFromPicker", "getEnterAnimationConfig", "Lcom/ss/android/lark/base/activity/ActivityAnimationManager$AnimationConfig;", "getExitAnimationConfig", VideoEventOneOutSync.END_TYPE_FINISH, "animateTo", LiveDegradeFpsAnimator.TRANSLATION_Y, "maskAlpha", "endAction", "Lkotlin/Function0;", "cancelAction", "superFinishNoAnim", "showSendToBannerAndDismissSheet", "targets", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "bottomOffsetDp", "onOpenChat", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "chatId", "sourceChatId", "(Ljava/util/List;Ljava/lang/Float;Lkotlin/jvm/functions/Function1;Ljava/lang/String;)Z", "loadDoubaoForwardDrawable", "bannerText", "chatIdForJump", "enableJump", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Z)V", "showFlowToast", "drawable", "Landroid/graphics/drawable/Drawable;", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Ljava/lang/Float;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Z)V", "Companion", "forward-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForwardDoubaoActivity extends BaseFragmentActivity {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f461251p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DoubaoForwardFragment f461252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f461253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VelocityTracker f461254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f461255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f461256e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f461257f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f461258g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f461259h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f461260i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f461261j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f461262k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f461263l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f461264m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f461265n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f461266o;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f461267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f461268b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f461269c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f461267a = true;
            this.f461268b.invoke();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f461267a == true) goto L6;
            this.f461269c.invoke();
            return;
        }

        public b(Function0<Unit> r100, Function0<Unit> r101) {
            this.f461268b = r100;
            this.f461269c = r101;
        }
    }

    public static final class c implements FlowToast.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f461270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f461271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1<String, Unit> f461272c;

        @Override // com.larksuite.component.universe_design.toast.UDToast.b
        public final void a(com.ss.android.lark.compose.foundation.toast.b r100) {
            Intrinsics.checkNotNullParameter(r100, "toast");
            if (this.f461270a == false) goto L11;
            String r101 = this.f461271b;
            if (r101 != null) goto L7;
            return;
        L7:
            Function1<String, Unit> r102 = this.f461272c;
            if (r102 == null) goto L11;
            r102.invoke(r101);
        L11:
            if (r100.isShowing() == false) goto L14;
            r100.cancel();
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(boolean r100, String r101, Function1<? super String, Unit> r102) {
            this.f461270a = r100;
            this.f461271b = r101;
            this.f461272c = r102;
        }
    }

    public static final class d implements FlowToast.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ForwardDoubaoActivity f461273a;

        @Override // com.larksuite.component.universe_design.toast.UDToast.c
        public final void a() {
            this.f461273a.finish();
        }

        public d(ForwardDoubaoActivity r100) {
            this.f461273a = r100;
        }
    }

    static {
    }

    public final void B1() {
        if (this.f461266o == false) goto L5;
        int r100 = -2;
    L6:
        View r101 = this.f461263l;
        Integer r102 = null;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r101 = null;
    L9:
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
        if ((r103 instanceof FrameLayout.LayoutParams) == false) goto L12;
        FrameLayout.LayoutParams r104 = (FrameLayout.LayoutParams) r103;
    L13:
        r103.height = r100;
        boolean r105 = false;
        if (r104 == null) goto L16;
        r104.topMargin = 0;
        r104.gravity = 80;
    L16:
        View r106 = this.f461263l;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r106 = null;
    L19:
        r106.setLayoutParams(r103);
        if (this.f461266o == false) goto L32;
        View r107 = this.f461263l;
        if (r107 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r107 = null;
    L24:
        Integer r108 = Integer.valueOf(r107.getMeasuredHeight());
        if (r108.intValue() <= 0) goto L27;
        r105 = true;
    L27:
        if (r105 == false) goto L29;
        r102 = r108;
    L29:
        if (r102 == null) goto L31;
        int r109 = r102.intValue();
    L33:
        this.f461261j = r109;
        return;
    L31:
        r109 = C1();
        goto L33
    L32:
        r109 = C1();
        goto L33
    L12:
        r104 = null;
        goto L13
    L5:
        r100 = C1();
        goto L6
    }

    /* JADX INFO: Removed unreachable split cross block B:60:0x0127 */
    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        if (this.f461263l != null) goto L5;
        super.finish();
    L10:
        if ((this instanceof ChatWindowActivity) == true) goto L51;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(ForwardDoubaoActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L52
        if (r103 != null) goto L17;
    L20:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L52
        monitor-exit(r102);     // Catch: Throwable -> L52
    L49:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L57:
        return;
    L23:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L26;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L49
        goto L57
    L26:
        if (isFinishing() == true) goto L29;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L49
        goto L57
    L29:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L32;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L49
        goto L57
    L32:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L35;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L49
        goto L57
    L35:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L38;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L49
        goto L57
    L38:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L40;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L49
        goto L57
    L40:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L49
        if (r104 == null) goto L57;
        r104.addFlags(268435456);     // Catch: Throwable -> L49
        r104.addFlags(2097152);     // Catch: Throwable -> L49
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L49
        startActivity(r104);     // Catch: Throwable -> L46
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L49
        goto L57
    L17:
        if ((r101 - r103.longValue()) >= 800) goto L20;
        monitor-exit(r102);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        throw th;
    L51:
        return;
    L5:
        KeyboardUtils.hideKeyboard(this);
        if (this.f461253b == false) goto L8;
        F1();
        goto L10
    L8:
        this.f461253b = true;
        z1(this.f461261j, 0.0f, new AnonymousClass1(this), new AnonymousClass2(this));
        goto L10
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity
    public final ActivityAnimationManager.AnimationConfig getEnterAnimationConfig() {
        return new ActivityAnimationManager.AnimationConfig(0, 0);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity
    public final ActivityAnimationManager.AnimationConfig getExitAnimationConfig() {
        return new ActivityAnimationManager.AnimationConfig(0, 0);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ForwardDoubaoActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public final int C1() {
        int r100 = UIHelper.dp2px(785.0f);
        View r101 = findViewById(R.id.content);
        if (r101 == null) goto L5;
        int r102 = r101.getHeight();
    L6:
        Integer r103 = Integer.valueOf(r102);
        if (r103.intValue() <= 0) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == true) goto L13;
        r103 = null;
    L13:
        if (r103 == null) goto L15;
        int r105 = r103.intValue();
    L17:
        return RangesKt.coerceAtMost(r100, RangesKt.coerceAtLeast(r105 - UIHelper.dp2px(getIntent().getFloatExtra("extra_top_spacing_dp", 50.0f)), 0));
    L15:
        Resources r106 = getResources();
        r105 = WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()).heightPixels;
        goto L17
    L9:
        r104 = false;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final void F1() {
        KeyboardUtils.hideKeyboard(this);
        super.finish();
        overridePendingTransition(0, 0);
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

    public ForwardDoubaoActivity() {
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
        Intent r101 = getIntent();
        if (r101 == null) goto L13;
        Bundle r102 = r101.getExtras();
    L14:
        if (r102 == null) goto L16;
        ForwardTemplateNew r103 = (ForwardTemplateNew) r102.getParcelable("key_intent_forward_template_new");
    L17:
        if (r103 != null) goto L19;
        Log.e("ForwardDoubaoActivity", "ForwardTemplateNew is null, finish");
        finish();
        return;
    L19:
        setContentView(com.larus.nova.R.layout.activity_forward_doubao);
        UIUtils.setStatusBarTransparent(this);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        getWindow().clearFlags(2);
        View r104 = findViewById(R.id.content);
        if (r104 == null) goto L22;
        r104.setBackgroundResource(R.color.transparent);
    L22:
        View r105 = findViewById(com.larus.nova.R.id.forward_activity_root);
        if (r105 == null) goto L25;
        r105.setBackgroundResource(R.color.transparent);
    L25:
        this.f461262k = findViewById(com.larus.nova.R.id.bg_mask);
        this.f461263l = findViewById(com.larus.nova.R.id.bottom_sheet_container);
        this.f461264m = UIHelper.dp2px(18.0f) + UIHelper.dp2px(44.0f);
        this.f461265n = UIHelper.dp2px(72.0f);
        this.f461259h = Math.max(ViewConfiguration.get(this).getScaledTouchSlop(), UIHelper.dp2px(12.0f));
        this.f461260i = UIHelper.dp2px(72.0f);
        if (r100 == null) goto L34;
        Fragment r106 = getSupportFragmentManager().findFragmentByTag("DoubaoForwardConfirmFragment");
        if (r106 == null) goto L34;
        getSupportFragmentManager().popBackStackImmediate("DoubaoForwardConfirmFragment", 1);
        if (r106.isAdded() == false) goto L34;
        getSupportFragmentManager().beginTransaction().remove(r106).commitNowAllowingStateLoss();
    L34:
        List<Fragment> r107 = getSupportFragmentManager().getFragments();
        ArrayList r108 = new ArrayList();
        Iterator<T> r109 = r107.iterator();
    L36:
        if (r109.hasNext() == false) goto L40;
        Object r110 = r109.next();
        if ((r110 instanceof DoubaoForwardFragment) == false) goto L36;
        r108.add(r110);
        goto L36
    L40:
        this.f461252a = (DoubaoForwardFragment) CollectionsKt.firstOrNull(r108);
        this.f461266o = false;
        getWindow().setSoftInputMode(48);
        View r111 = this.f461262k;
        if (r111 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("bgMask");
        r111 = null;
    L43:
        r111.setAlpha(0.0f);
        View r112 = this.f461263l;
        if (r112 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r112 = null;
    L46:
        r112.setClickable(true);
        View r113 = this.f461263l;
        if (r113 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r113 = null;
    L49:
        r113.setFocusable(true);
        B1();
        View r114 = this.f461263l;
        if (r114 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r114 = null;
    L52:
        r114.setTranslationY(this.f461261j);
        View r115 = this.f461263l;
        if (r115 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r115 = null;
    L55:
        r115.addOnLayoutChangeListener(new y(this));
        View r116 = this.f461263l;
        if (r116 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r116 = null;
    L58:
        r116.setOnTouchListener(new a0(this));
        View r117 = this.f461263l;
        if (r117 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r117 = null;
    L61:
        r117.post(new b0(this));
        View r118 = this.f461262k;
        if (r118 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("bgMask");
        r118 = null;
    L64:
        r118.setOnClickListener(new z(this));
        getOnBackPressedDispatcher().addCallback(this, new ForwardDoubaoActivity$initDismissBehavior$2(this));
        if (this.f461252a != null) goto L84;
        DoubaoForwardFragment r119 = new DoubaoForwardFragment();
        if (r102 == null) goto L69;
        Bundle r120 = new Bundle(r102);
    L70:
        r119.setArguments(r120);
        this.f461252a = r119;
        FragmentTransaction r121 = getSupportFragmentManager().beginTransaction();
        DoubaoForwardFragment r122 = this.f461252a;
        Intrinsics.checkNotNull(r122);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r121, r122, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, com.larus.nova.R.id.fragment_container) == true) goto L74;
        r121 = r121.replace(com.larus.nova.R.id.fragment_container, r122);
    L74:
        r121.commitAllowingStateLoss();
        return;
    L69:
        r120 = null;
        goto L70
    L84:
        return;
    L16:
        r103 = null;
        goto L17
    L13:
        r102 = null;
        goto L14
    }

    public final void z1(float r100, float r101, Function0<Unit> r102, Function0<Unit> r103) {
        View r104 = this.f461263l;
        View r105 = null;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r104 = null;
    L5:
        ViewPropertyAnimator r106 = r104.animate().translationY(r100).setDuration(300);
        r106.setListener(new b(r103, r102));
        r106.start();
        View r107 = this.f461262k;
        if (r107 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bgMask");
    L9:
        r105.animate().alpha(r101).setDuration(300).start();
        return;
    L8:
        r105 = r107;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void A1(ForwardDoubaoActivity r100, float r101, float r102, Function0 r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r103 = ForwardDoubaoActivity$animateTo$1.INSTANCE;
    L6:
        if ((r104 & 8) == 0) goto L8;
        ForwardDoubaoActivity$animateTo$2 r105 = ForwardDoubaoActivity$animateTo$2.INSTANCE;
    L9:
        r100.z1(r101, r102, r103, r105);
        return;
    L8:
        r105 = null;
        goto L9
    }

    public final void D1(String r100, Drawable r101, Float r102, String r103, Function1<? super String, Unit> r104, boolean r105) {
        FlowToast.a r106 = FlowToast.a(this);
        Intrinsics.checkNotNullParameter(r100, "value");
        r106.f417628b = r100;
        if (r102 == null) goto L5;
        float r107 = r102.floatValue();
    L6:
        r106.c(0, 0, UIHelper.dp2px(r107));
        d r108 = new d(this);
        Intrinsics.checkNotNullParameter(r108, "dismiss");
        r106.f417633g = r108;
        if (r101 == null) goto L9;
        Intrinsics.checkNotNullParameter(r101, "value");
        r106.f417629c = r101;
    L9:
        if (r103 == null) goto L11;
        r106.b(com.larus.nova.R.string.LarkIM_Msg_MsgForwardedView_Button, new c(r105, r103, r104));
    L11:
        r106.a().show();
        return;
    L5:
        r107 = 100.0f;
        goto L6
    }
}
