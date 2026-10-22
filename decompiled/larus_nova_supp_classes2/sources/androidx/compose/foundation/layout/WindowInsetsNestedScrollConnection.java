package androidx.compose.foundation.layout;

import android.graphics.Insets;
import android.os.CancellationSignal;
import android.view.View;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010#\u001a\u0004\u0018\u00010\u0016H\u0082@¢\u0006\u0002\u0010$J\u001f\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J'\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0016¢\u0006\u0004\b.\u0010/J\u001f\u00100\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u00101\u001a\u00020\u001cH\u0002¢\u0006\u0004\b2\u00103J\u0018\u00104\u001a\u0002052\u0006\u0010'\u001a\u000205H\u0096@¢\u0006\u0004\b6\u00107J \u00108\u001a\u0002052\u0006\u0010-\u001a\u0002052\u0006\u0010'\u001a\u000205H\u0096@¢\u0006\u0004\b9\u0010:J(\u0010;\u001a\u0002052\u0006\u0010'\u001a\u0002052\u0006\u0010<\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020\u0018H\u0082@¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001a\u00020 2\u0006\u0010A\u001a\u00020\u001cH\u0002J\u0018\u0010B\u001a\u00020 2\u0006\u0010C\u001a\u00020\u00162\u0006\u0010D\u001a\u00020EH\u0016J\u0006\u0010F\u001a\u00020 J\u0010\u0010G\u001a\u00020 2\u0006\u0010C\u001a\u00020\u0016H\u0016J\u0012\u0010H\u001a\u00020 2\b\u0010C\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010I\u001a\u00020 H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroid/view/WindowInsetsAnimationControlListener;", "windowInsets", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "view", "Landroid/view/View;", "sideCalculator", "Landroidx/compose/foundation/layout/SideCalculator;", "density", "Landroidx/compose/ui/unit/Density;", "<init>", "(Landroidx/compose/foundation/layout/AndroidWindowInsets;Landroid/view/View;Landroidx/compose/foundation/layout/SideCalculator;Landroidx/compose/ui/unit/Density;)V", "getWindowInsets", "()Landroidx/compose/foundation/layout/AndroidWindowInsets;", "getView", "()Landroid/view/View;", "getSideCalculator", "()Landroidx/compose/foundation/layout/SideCalculator;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "animationController", "Landroid/view/WindowInsetsAnimationController;", "isControllerRequested", "", "cancellationSignal", "Landroid/os/CancellationSignal;", "partialConsumption", "", "animationJob", "Lkotlinx/coroutines/Job;", "requestAnimationController", "", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "getAnimationController", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "scroll", "scrollAmount", "scroll-8S9VItk", "(JF)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fling", "flingAmount", "towardShown", "fling-huYlsQE", "(JFZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adjustInsets", "inset", "onReady", "controller", "types", "", "dispose", "onFinished", "onCancelled", "animationEnded", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class WindowInsetsNestedScrollConnection implements NestedScrollConnection, WindowInsetsAnimationControlListener {
    private WindowInsetsAnimationController animationController;
    private Job animationJob;
    private final CancellationSignal cancellationSignal;
    private kotlinx.coroutines.i<? super WindowInsetsAnimationController> continuation;
    private final Density density;
    private boolean isControllerRequested;
    private float partialConsumption;
    private final SideCalculator sideCalculator;
    private final View view;
    private final AndroidWindowInsets windowInsets;

    public static /* synthetic */ Unit a(Throwable r0) {
        return onReady$lambda$3(r0);
    }

    public static /* synthetic */ Unit b(Throwable r0) {
        return dispose$lambda$4(r0);
    }

    public static /* synthetic */ Unit c(Throwable r0) {
        return animationEnded$lambda$5(r0);
    }

    private final void animationEnded() {
        WindowInsetsAnimationController r0 = this.animationController;
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.isReady() != true) goto L7;
    L8:
        if (r2 == false) goto L12;
        WindowInsetsAnimationController r1 = this.animationController;
        if (r1 == null) goto L12;
        r1.finish(this.windowInsets.isVisible());
    L12:
        this.animationController = null;
        kotlinx.coroutines.i<? super WindowInsetsAnimationController> r3 = this.continuation;
        if (r3 == null) goto L15;
        r3.h(null, new k2());
    L15:
        this.continuation = null;
        Job r4 = this.animationJob;
        if (r4 == null) goto L18;
        r4.cancel(new WindowInsetsAnimationCancelledException());
    L18:
        this.animationJob = null;
        this.partialConsumption = MenuKt.ClosedAlphaTarget;
        this.isControllerRequested = false;
        return;
    L7:
        r2 = false;
        goto L8
    }

    private final void requestAnimationController() {
        if (this.isControllerRequested == true) goto L8;
        this.isControllerRequested = true;
        WindowInsetsController r1 = this.view.getWindowInsetsController();
        if (r1 == null) goto L9;
        r1.controlWindowInsetsAnimation(this.windowInsets.getType$foundation_layout(), -1, null, this.cancellationSignal, this);
        return;
    L9:
        return;
    }

    public final void dispose() {
        kotlinx.coroutines.i<? super WindowInsetsAnimationController> r0 = this.continuation;
        if (r0 == null) goto L5;
        r0.h(null, new i2());
    L5:
        Job r1 = this.animationJob;
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        WindowInsetsAnimationController r2 = this.animationController;
        if (r2 == null) goto L12;
        r2.finish(!Intrinsics.areEqual(r2.getCurrentInsets(), r2.getHiddenStateInsets()));
        return;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final SideCalculator getSideCalculator() {
        return this.sideCalculator;
    }

    public final View getView() {
        return this.view;
    }

    public final AndroidWindowInsets getWindowInsets() {
        return this.windowInsets;
    }

    public static final /* synthetic */ Job access$getAnimationJob$p(WindowInsetsNestedScrollConnection r0) {
        return r0.animationJob;
    }

    public static final /* synthetic */ void access$requestAnimationController(WindowInsetsNestedScrollConnection r0) {
        r0.requestAnimationController();
    }

    private final void adjustInsets(float r4) {
        WindowInsetsAnimationController r0 = this.animationController;
        if (r0 == null) goto L6;
        Insets r1 = r0.getCurrentInsets();
        r0.setInsetsAndAlpha(this.sideCalculator.adjustInsets(r1, Math.round(r4)), 1.0f, MenuKt.ClosedAlphaTarget);
        return;
    }

    private static final Unit animationEnded$lambda$5(Throwable r0) {
        return Unit.INSTANCE;
    }

    private static final Unit dispose$lambda$4(Throwable r0) {
        return Unit.INSTANCE;
    }

    private final Object getAnimationController(Continuation<? super WindowInsetsAnimationController> r4) {
        Object r0 = this.animationController;
        if (r0 != null) goto L7;
        kotlinx.coroutines.j r1 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r4), 1);
        r1.C();
        access$setContinuation$p(this, r1);
        access$requestAnimationController(this);
        r0 = r1.B();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L7;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L7:
        return r0;
    }

    private static final Unit onReady$lambda$3(Throwable r0) {
        return Unit.INSTANCE;
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onCancelled(WindowInsetsAnimationController r1) {
        animationEnded();
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onFinished(WindowInsetsAnimationController r1) {
        animationEnded();
    }

    public static final /* synthetic */ void access$adjustInsets(WindowInsetsNestedScrollConnection r0, float r1) {
        r0.adjustInsets(r1);
    }

    public static final /* synthetic */ Object access$getAnimationController(WindowInsetsNestedScrollConnection r0, Continuation r1) {
        return r0.getAnimationController(r1);
    }

    public static final /* synthetic */ void access$setAnimationController$p(WindowInsetsNestedScrollConnection r0, WindowInsetsAnimationController r1) {
        r0.animationController = r1;
    }

    public static final /* synthetic */ void access$setAnimationJob$p(WindowInsetsNestedScrollConnection r0, Job r1) {
        r0.animationJob = r1;
    }

    public static final /* synthetic */ void access$setContinuation$p(WindowInsetsNestedScrollConnection r0, kotlinx.coroutines.i r1) {
        r0.continuation = r1;
    }

    /* JADX INFO: renamed from: scroll-8S9VItk, reason: not valid java name */
    private final long m1049scroll8S9VItk(long r8, float r10) {
        Job r0 = this.animationJob;
        if (r0 == null) goto L5;
        r0.cancel(new WindowInsetsAnimationCancelledException());
        this.animationJob = null;
    L5:
        WindowInsetsAnimationController r1 = this.animationController;
        boolean r2 = true;
        if (r10 != MenuKt.ClosedAlphaTarget) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == true) goto L33;
        boolean r5 = this.windowInsets.isVisible();
        if (r10 > MenuKt.ClosedAlphaTarget) goto L14;
        r2 = false;
    L14:
        if (r5 != r2) goto L17;
        if (r1 == null) goto L33;
    L17:
        if (r1 != null) goto L20;
        this.partialConsumption = MenuKt.ClosedAlphaTarget;
        requestAnimationController();
        return this.sideCalculator.mo994consumedOffsetsMKHz9U(r8);
    L20:
        int r3 = this.sideCalculator.valueOf(r1.getHiddenStateInsets());
        int r6 = this.sideCalculator.valueOf(r1.getShownStateInsets());
        Insets r7 = r1.getCurrentInsets();
        int r9 = this.sideCalculator.valueOf(r7);
        if (r10 <= MenuKt.ClosedAlphaTarget) goto L23;
        int r11 = r6;
    L24:
        if (r9 != r11) goto L27;
        this.partialConsumption = MenuKt.ClosedAlphaTarget;
        return Offset.Companion.getZero-F1C5BW0();
    L27:
        float r12 = (r9 + r10) + this.partialConsumption;
        int r13 = RangesKt.coerceIn(Math.round(r12), r3, r6);
        this.partialConsumption = r12 - Math.round(r12);
        if (r13 == r9) goto L31;
        r1.setInsetsAndAlpha(this.sideCalculator.adjustInsets(r7, r13), 1.0f, MenuKt.ClosedAlphaTarget);
    L31:
        return this.sideCalculator.mo994consumedOffsetsMKHz9U(r8);
    L23:
        r11 = r3;
    L33:
        return Offset.Companion.getZero-F1C5BW0();
    L8:
        r4 = false;
        goto L9
    }

    /* JADX INFO: renamed from: onPreFling-QWom1Mo, reason: not valid java name */
    public Object m1052onPreFlingQWom1Mo(long r10, Continuation<? super Velocity> r12) {
        return m1048flinghuYlsQE(r10, this.sideCalculator.hideMotion(Velocity.getX-impl(r10), Velocity.getY-impl(r10)), false, r12);
    }

    /* JADX INFO: renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public long m1053onPreScrollOzD1aCk(long r4, int r6) {
        return m1049scroll8S9VItk(r4, this.sideCalculator.hideMotion(Float.intBitsToFloat((int) (r4 >> 32)), Float.intBitsToFloat((int) (4294967295L & r4))));
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onReady(WindowInsetsAnimationController r2, int r3) {
        this.animationController = r2;
        this.isControllerRequested = false;
        kotlinx.coroutines.i<? super WindowInsetsAnimationController> r4 = this.continuation;
        if (r4 == null) goto L5;
        r4.h(r2, new j2());
    L5:
        this.continuation = null;
    }

    /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    public Object m1050onPostFlingRZ2iAVY(long r8, long r10, Continuation<? super Velocity> r12) {
        return m1048flinghuYlsQE(r10, this.sideCalculator.showMotion(Velocity.getX-impl(r10), Velocity.getY-impl(r10)), true, r12);
    }

    /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public long m1051onPostScrollDzOQY0M(long r3, long r5, int r7) {
        return m1049scroll8S9VItk(r5, this.sideCalculator.showMotion(Float.intBitsToFloat((int) (r5 >> 32)), Float.intBitsToFloat((int) (4294967295L & r5))));
    }

    public WindowInsetsNestedScrollConnection(AndroidWindowInsets r1, View r2, SideCalculator r3, Density r4) {
        this.windowInsets = r1;
        this.view = r2;
        this.sideCalculator = r3;
        this.density = r4;
        this.cancellationSignal = new CancellationSignal();
    }

    /* JADX INFO: renamed from: fling-huYlsQE, reason: not valid java name */
    private final Object m1048flinghuYlsQE(long r20, float r22, boolean r23, Continuation<? super Velocity> r24) {
        if ((r24 instanceof WindowInsetsNestedScrollConnection$fling$1) == false) goto L7;
        WindowInsetsNestedScrollConnection$fling$1 r3 = (WindowInsetsNestedScrollConnection$fling$1) r24;
        int r4 = r3.label;
        if ((r4 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r3.label = r4 - RtlSpacingHelper.UNDEFINED;
    L8:
        WindowInsetsNestedScrollConnection$fling$1 r12 = r3;
        Object r2 = r12.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r12.label;
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        long r0 = r12.J$0;
        ResultKt.throwOnFailure(r2);
    L69:
        return Velocity.box-impl(this.sideCalculator.mo995consumedVelocityQWom1Mo(r0, MenuKt.ClosedAlphaTarget));
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        long r1 = r12.J$0;
        Ref.FloatRef r6 = (Ref.FloatRef) r12.L$0;
        ResultKt.throwOnFailure(r2);
        WindowInsetsNestedScrollConnection r7 = this;
    L75:
        return Velocity.box-impl(r7.sideCalculator.mo995consumedVelocityQWom1Mo(r1, r6.element));
    L17:
        float r8 = r12.F$0;
        long r14 = r12.J$0;
        ResultKt.throwOnFailure(r2);
        float r9 = r8;
    L37:
        WindowInsetsAnimationController r10 = (WindowInsetsAnimationController) r2;
        if (r10 == null) goto L40;
        int r11 = this.sideCalculator.valueOf(r10.getHiddenStateInsets());
        int r15 = this.sideCalculator.valueOf(r10.getShownStateInsets());
        int r16 = this.sideCalculator.valueOf(r10.getCurrentInsets());
        if (r9 > MenuKt.ClosedAlphaTarget) goto L45;
        if (r16 != r11) goto L45;
    L47:
        if (r16 != r15) goto L49;
        boolean r17 = true;
    L50:
        r10.finish(r17);
        this.animationController = null;
        return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
    L49:
        r17 = false;
    L45:
        if (r9 < MenuKt.ClosedAlphaTarget) goto L52;
        if (r16 == r15) goto L47;
    L52:
        SplineBasedFloatDecayAnimationSpec r18 = new SplineBasedFloatDecayAnimationSpec(this.density);
        float r19 = r16 + r18.flingDistance(r9);
        float r21 = r11;
        if (((r19 - r21) / (r15 - r11)) <= 0.5f) goto L55;
        boolean r110 = true;
    L56:
        if (r110 == false) goto L58;
        int r25 = r15;
    L60:
        if (r19 <= r15) goto L62;
    L70:
        Ref.FloatRef r26 = new Ref.FloatRef();
        WindowInsetsNestedScrollConnection$fling$2 r27 = new WindowInsetsNestedScrollConnection$fling$2(this, r16, r9, r18, r11, r15, r26, r10, r110, null);
        r12.L$0 = r26;
        r12.J$0 = r14;
        r12.label = 2;
        if (CoroutineScopeKt.coroutineScope(r27, r12) != r13) goto L73;
        return r13;
    L73:
        r7 = this;
        r6 = r26;
        r1 = r14;
        goto L75
    L62:
        if (r19 < r21) goto L70;
        WindowInsetsNestedScrollConnection$fling$3 r28 = new WindowInsetsNestedScrollConnection$fling$3(this, r16, r25, r9, r10, r110, null);
        r12.J$0 = r14;
        r12.label = 3;
        if (CoroutineScopeKt.coroutineScope(r28, r12) != r13) goto L67;
        return r13;
    L67:
        r0 = r14;
        goto L69
    L58:
        r25 = r11;
        goto L60
    L55:
        r110 = false;
        goto L56
    L40:
        return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
    L18:
        ResultKt.throwOnFailure(r2);
        Job r29 = this.animationJob;
        if (r29 == null) goto L21;
        r29.cancel(new WindowInsetsAnimationCancelledException());
    L21:
        this.animationJob = null;
        this.partialConsumption = MenuKt.ClosedAlphaTarget;
        if (r22 != MenuKt.ClosedAlphaTarget) goto L24;
        boolean r30 = true;
    L25:
        if (r30 == false) goto L28;
        if (r23 == true) goto L28;
    L32:
        return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
    L28:
        if (this.animationController == null) goto L30;
    L33:
        r12.J$0 = r20;
        r12.F$0 = r22;
        r12.label = 1;
        Object r31 = getAnimationController(r12);
        if (r31 != r13) goto L36;
        return r13;
    L36:
        r9 = r22;
        r14 = r20;
        r2 = r31;
        goto L37
    L30:
        if (this.windowInsets.isVisible() != r23) goto L33;
    L24:
        r30 = false;
    L7:
        r3 = new WindowInsetsNestedScrollConnection$fling$1(this, r24);
        goto L8
    }

    /* JADX INFO: renamed from: access$fling-huYlsQE, reason: not valid java name */
    public static final /* synthetic */ Object m1047access$flinghuYlsQE(WindowInsetsNestedScrollConnection r0, long r1, float r3, boolean r4, Continuation r5) {
        return r0.m1048flinghuYlsQE(r1, r3, r4, r5);
    }
}
