package androidx.compose.foundation.gestures;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.MotionDurationScale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006JJ\u0010\u0014\u001a\u00020\u00152!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00150\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u001cH\u0086@\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u001dR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/gestures/UpdatableAnimationState;", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Landroidx/compose/animation/core/AnimationSpec;)V", "vectorizedSpec", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "Landroidx/compose/animation/core/AnimationVector1D;", "lastFrameTime", "", "lastVelocity", "isRunning", "", "value", "getValue", "()F", "setValue", "(F)V", "animateToZero", "", "beforeFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "valueDelta", "afterFrame", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UpdatableAnimationState {
    public static final int $stable = 0;
    private static final Companion Companion = null;
    public static final float VisibilityThreshold = 0.01f;
    private static final AnimationVector1D ZeroVector = null;
    private boolean isRunning;
    private long lastFrameTime;
    private AnimationVector1D lastVelocity;
    private float value;
    private final VectorizedAnimationSpec<AnimationVector1D> vectorizedSpec;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\n\u001a\u00020\u000b*\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/gestures/UpdatableAnimationState$Companion;", "", "<init>", "()V", "VisibilityThreshold", "", "ZeroVector", "Landroidx/compose/animation/core/AnimationVector1D;", "getZeroVector", "()Landroidx/compose/animation/core/AnimationVector1D;", "isZeroish", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final AnimationVector1D getZeroVector() {
            return UpdatableAnimationState.access$getZeroVector$cp();
        }

        public final boolean isZeroish(float r2) {
            if (Math.abs(r2) >= 0.01f) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.UpdatableAnimationState", f = "UpdatableAnimationState.kt", i = {0, 0, 0, 1}, l = {100, 151}, m = "animateToZero", n = {"beforeFrame", "afterFrame", "durationScale", "afterFrame"}, s = {"L$0", "L$1", "F$0", "L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ UpdatableAnimationState this$0;

        public AnonymousClass1(UpdatableAnimationState r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return this.this$0.animateToZero(null, null, this);
        }
    }

    public static /* synthetic */ Unit a(UpdatableAnimationState r0, Function1 r1, long r2) {
        return animateToZero$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(UpdatableAnimationState r0, float r1, Function1 r2, long r3) {
        return animateToZero$lambda$1(r0, r1, r2, r3);
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        ZeroVector = new AnimationVector1D(MenuKt.ClosedAlphaTarget);
    }

    public static final /* synthetic */ AnimationVector1D access$getZeroVector$cp() {
        return ZeroVector;
    }

    public final float getValue() {
        return this.value;
    }

    public UpdatableAnimationState(AnimationSpec<Float> r3) {
        this.vectorizedSpec = r3.vectorize(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE));
        this.lastFrameTime = Long.MIN_VALUE;
        this.lastVelocity = ZeroVector;
    }

    public final void setValue(float r1) {
        this.value = r1;
    }

    private static final Unit animateToZero$lambda$2(UpdatableAnimationState r0, Function1 r1, long r2) {
        float r3 = r0.value;
        r0.value = MenuKt.ClosedAlphaTarget;
        r1.invoke(Float.valueOf(r3));
        return Unit.INSTANCE;
    }

    public final Object animateToZero(Function1<? super Float, Unit> r13, Function0<Unit> r14, Continuation<? super Unit> r15) {
        if ((r15 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r15;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r8 = true;
        if (r3 != 0) goto L58;
        ResultKt.throwOnFailure(r16);
        if ((!this.isRunning) == true) goto L25;
        InlineClassHelperKt.throwIllegalStateException("animateToZero called while previous animation is running");
    L25:
        MotionDurationScale r17 = r0.getContext().get(MotionDurationScale.Key);
        if (r17 == null) goto L28;
        float r18 = r17.getScaleFactor();
    L29:
        this.isRunning = true;
        final UpdatableAnimationState r4 = this;
        final Function1<? super Float, Unit> r19 = r13;
        final float r110 = r18;
        Function0<Unit> r111 = r14;
    L31:
        if (Companion.isZeroish(r4.value) == true) goto L40;
        Function1 r9 = new u2(r4, r110, r19);     // Catch: Throwable -> L41
        r0.L$0 = r19;     // Catch: Throwable -> L41
        r0.L$1 = r111;     // Catch: Throwable -> L41
        r0.F$0 = r110;     // Catch: Throwable -> L41
        r0.label = 1;     // Catch: Throwable -> L41
        if (MonotonicFrameClockKt.withFrameNanos(r9, r0) != r2) goto L56;
        return r2;
    L56:
        r111.invoke();     // Catch: Throwable -> L41
        if (r110 != MenuKt.ClosedAlphaTarget) goto L59;
        if (1 == 0) goto L31;
    L59:
        if (0 == 0) goto L31;
    L41:
        th = th;
    L54:
        r4.lastFrameTime = Long.MIN_VALUE;
        r4.lastVelocity = ZeroVector;
        r4.isRunning = false;
        throw th;
    L40:
        Function0<Unit> r112 = r111;
        if (Math.abs(r4.value) == MenuKt.ClosedAlphaTarget) goto L47;
        r8 = false;
    L47:
        if (r8 == true) goto L52;
        Function1 r113 = new v2(r4, r19);     // Catch: Throwable -> L41
        r0.L$0 = r112;     // Catch: Throwable -> L41
        r0.L$1 = null;     // Catch: Throwable -> L41
        r0.label = 2;     // Catch: Throwable -> L41
        if (MonotonicFrameClockKt.withFrameNanos(r113, r0) != r2) goto L51;
        return r2;
    L51:
        r112.invoke();     // Catch: Throwable -> L41
    L52:
        r4.lastFrameTime = Long.MIN_VALUE;
        r4.lastVelocity = ZeroVector;
        r4.isRunning = false;
        return Unit.INSTANCE;
    L28:
        r18 = 1.0f;
        goto L29
    L58:
        if (r3 == 1) goto L17;
        if (r3 != 2) goto L16;
        r112 = (Function0) r0.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L20
        r4 = this;
        goto L51
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r110 = r0.F$0;
        Function0<Unit> r114 = (Function0) r0.L$1;
        Function1<? super Float, Unit> r5 = (Function1) r0.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L20
        r111 = r114;
        r19 = r5;
        r4 = this;
    L20:
        th = th;
        r4 = this;
    L7:
        r0 = new AnonymousClass1(this, r15);
        goto L8
    }

    private static final Unit animateToZero$lambda$1(UpdatableAnimationState r11, float r12, Function1 r13, long r14) {
        if (r11.lastFrameTime != Long.MIN_VALUE) goto L5;
        r11.lastFrameTime = r14;
    L5:
        AnimationVector1D r0 = new AnimationVector1D(r11.value);
        if (r12 != MenuKt.ClosedAlphaTarget) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        long r2 = r11.vectorizedSpec.getDurationNanos(new AnimationVector1D(r11.value), ZeroVector, r11.lastVelocity);
    L12:
        VectorizedAnimationSpec<AnimationVector1D> r5 = r11.vectorizedSpec;
        AnimationVector1D r15 = ZeroVector;
        long r6 = r2;
        float r3 = ((AnimationVector1D) r5.getValueFromNanos(r6, r0, r15, r11.lastVelocity)).getValue();
        r11.lastVelocity = (AnimationVector1D) r11.vectorizedSpec.getVelocityFromNanos(r6, r0, r15, r11.lastVelocity);
        r11.lastFrameTime = r14;
        float r16 = r11.value - r3;
        r11.value = r3;
        r13.invoke(Float.valueOf(r16));
        return Unit.INSTANCE;
    L11:
        r2 = MathKt.roundToLong((r14 - r11.lastFrameTime) / r12);
        goto L12
    L8:
        r1 = false;
        goto L9
    }
}
