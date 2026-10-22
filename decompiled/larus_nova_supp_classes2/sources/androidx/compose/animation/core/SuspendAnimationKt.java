package androidx.compose.animation.core;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.autofill.HintConstants;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.MotionDurationScale;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u001ap\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u000726\u0010\b\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010\u000e\u001a^\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u001026\u0010\b\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010\u0011\u001a\u0096\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0012\"\b\b\u0001\u0010\u0013*\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u00162\u0006\u0010\u0002\u001a\u0002H\u00122\u0006\u0010\u0004\u001a\u0002H\u00122\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u0001H\u00122\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00120\u000726\u0010\b\u001a2\u0012\u0013\u0012\u0011H\u0012¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u0011H\u0012¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010\u0017\u001aw\u0010\u0018\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0012\"\b\b\u0001\u0010\u0013*\u00020\u0014*\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u00192\u0006\u0010\u0004\u001a\u0002H\u00122\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2%\b\u0002\u0010\b\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u001d\u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\b\u001eH\u0086@¢\u0006\u0002\u0010\u001f\u001am\u0010\u000f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0012\"\b\b\u0001\u0010\u0013*\u00020\u0014*\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u00192\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00120 2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2%\b\u0002\u0010\b\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u001d\u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\b\u001eH\u0086@¢\u0006\u0002\u0010!\u001as\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0012\"\b\b\u0001\u0010\u0013*\u00020\u0014*\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u00192\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130#2\b\b\u0002\u0010$\u001a\u00020%2%\b\u0002\u0010\b\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u001d\u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\b\u001eH\u0080@¢\u0006\u0002\u0010&\u001aW\u0010'\u001a\u0002H(\"\u0004\b\u0000\u0010(\"\u0004\b\u0001\u0010\u0012\"\b\b\u0002\u0010\u0013*\u00020\u0014*\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130#2!\u0010)\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(*\u0012\u0004\u0012\u0002H(0\u001cH\u0082@¢\u0006\u0002\u0010+\u001a<\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0012\"\b\b\u0001\u0010\u0013*\u00020\u0014*\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u001d2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u0019H\u0000\u001a\u0085\u0001\u00102\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0012\"\b\b\u0001\u0010\u0013*\u00020\u0014*\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u001d2\u0006\u0010*\u001a\u00020%2\u0006\u0010,\u001a\u00020\u00032\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130#2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u00192#\u0010\b\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u001d\u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\b\u001eH\u0002\u001a\u0085\u0001\u00104\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0012\"\b\b\u0001\u0010\u0013*\u00020\u0014*\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u001d2\u0006\u0010*\u001a\u00020%2\u0006\u00105\u001a\u00020%2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130#2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u00192#\u0010\b\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u001d\u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\b\u001eH\u0002\"\u0018\u0010,\u001a\u00020\u0003*\u00020-8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00066"}, d2 = {"animate", "", "initialValue", "", "targetValue", "initialVelocity", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "value", "velocity", "(FFFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateDecay", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "(FFLandroidx/compose/animation/core/FloatDecayAnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "Landroidx/compose/animation/core/AnimationState;", "sequentialAnimation", "", "Lkotlin/Function1;", "Landroidx/compose/animation/core/AnimationScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/AnimationState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animation", "Landroidx/compose/animation/core/Animation;", "startTimeNanos", "", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/Animation;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callWithFrameNanos", "R", "onFrame", "frameTimeNanos", "(Landroidx/compose/animation/core/Animation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "durationScale", "Lkotlin/coroutines/CoroutineContext;", "getDurationScale", "(Lkotlin/coroutines/CoroutineContext;)F", "updateState", "state", "doAnimationFrameWithScale", "anim", "doAnimationFrame", "playTimeNanos", "animation-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SuspendAnimationKt {

    /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$animate$4, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.SuspendAnimationKt", f = "SuspendAnimation.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {231, 280}, m = "animate", n = {"$this$animate", "animation", "block", "lateInitScope", "$this$animate", "animation", "block", "lateInitScope"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    public static final class AnonymousClass4<T, V extends AnimationVector> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass4(Continuation<? super AnonymousClass4> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return SuspendAnimationKt.animate(null, null, 0, null, this);
        }
    }

    public static /* synthetic */ Unit a(AnimationScope r0) {
        return animate$lambda$5(r0);
    }

    public static /* synthetic */ Object b(Function1 r0, long r1) {
        return callWithFrameNanos$lambda$12(r0, r1);
    }

    public static /* synthetic */ Unit c(AnimationState r0) {
        return animate$lambda$9(r0);
    }

    public static /* synthetic */ Unit d(AnimationScope r0) {
        return animateDecay$lambda$4(r0);
    }

    public static /* synthetic */ Unit e(Ref.ObjectRef r0, Object r1, Animation r2, AnimationVector r3, AnimationState r4, float r5, Function1 r6, long r7) {
        return animate$lambda$8(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit f(AnimationState r0) {
        return animate$lambda$8$lambda$6(r0);
    }

    public static /* synthetic */ Unit g(Function2 r0, AnimationScope r1) {
        return animateDecay$lambda$0(r0, r1);
    }

    public static /* synthetic */ Unit h(Ref.ObjectRef r0, float r1, Animation r2, AnimationState r3, Function1 r4, long r5) {
        return animate$lambda$11(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit i(Function2 r0, TwoWayConverter r1, AnimationScope r2) {
        return animate$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ Unit j(AnimationScope r0) {
        return animateTo$lambda$3(r0);
    }

    private static final Unit animate$lambda$5(AnimationScope r0) {
        return Unit.INSTANCE;
    }

    private static final Unit animate$lambda$8$lambda$6(AnimationState r1) {
        r1.setRunning$animation_core(false);
        return Unit.INSTANCE;
    }

    private static final Unit animate$lambda$9(AnimationState r1) {
        r1.setRunning$animation_core(false);
        return Unit.INSTANCE;
    }

    private static final Unit animateDecay$lambda$4(AnimationScope r0) {
        return Unit.INSTANCE;
    }

    private static final Unit animateTo$lambda$3(AnimationScope r0) {
        return Unit.INSTANCE;
    }

    public static final float getDurationScale(CoroutineContext r1) {
        MotionDurationScale r2 = r1.get(MotionDurationScale.Key);
        if (r2 == null) goto L5;
        float r3 = r2.getScaleFactor();
    L7:
        if (r3 < MenuKt.ClosedAlphaTarget) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L12;
        PreconditionsKt.throwIllegalStateException("negative scale factor");
    L12:
        return r3;
    L9:
        r0 = false;
        goto L10
    L5:
        r3 = 1.0f;
        goto L7
    }

    private static final Unit animateDecay$lambda$0(Function2 r1, AnimationScope r2) {
        r1.invoke(r2.getValue(), Float.valueOf(((AnimationVector1D) r2.getVelocityVector()).getValue()));
        return Unit.INSTANCE;
    }

    private static final Object callWithFrameNanos$lambda$12(Function1 r2, long r3) {
        return r2.invoke(Long.valueOf(r3 / 1));
    }

    public static final <T, V extends AnimationVector> void updateState(AnimationScope<T, V> r2, AnimationState<T, V> r3) {
        r3.setValue$animation_core(r2.getValue());
        AnimationVectorsKt.copyFrom(r3.getVelocityVector(), r2.getVelocityVector());
        r3.setFinishedTimeNanos$animation_core(r2.getFinishedTimeNanos());
        r3.setLastFrameTimeNanos$animation_core(r2.getLastFrameTimeNanos());
        r3.setRunning$animation_core(r2.isRunning());
    }

    public static final /* synthetic */ Object access$callWithFrameNanos(Animation r0, Function1 r1, Continuation r2) {
        return callWithFrameNanos(r0, r1, r2);
    }

    private static final Unit animate$lambda$2(Function2 r1, TwoWayConverter r2, AnimationScope r3) {
        r1.invoke(r3.getValue(), r2.getConvertFromVector().invoke(r3.getVelocityVector()));
        return Unit.INSTANCE;
    }

    private static final <R, T, V extends AnimationVector> Object callWithFrameNanos(Animation<T, V> r0, final Function1<? super Long, ? extends R> r1, Continuation<? super R> r2) {
        if (r0.isInfinite() == false) goto L7;
        return InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(r1, r2);
    L7:
        return MonotonicFrameClockKt.withFrameNanos(new a0(r1), r2);
    }

    public static final <T, V extends AnimationVector> Object animate(final AnimationState<T, V> r25, final Animation<T, V> r26, long r27, final Function1<? super AnimationScope<T, V>, Unit> r29, Continuation<? super Unit> r30) {
        final AnimationState<T, V> r9 = r25;
        Animation<T, V> r0 = r26;
        if ((r30 instanceof AnonymousClass4) == false) goto L7;
        AnonymousClass4 r2 = (AnonymousClass4) r30;
        int r3 = r2.label;
        if ((r3 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r2.label = r3 - RtlSpacingHelper.UNDEFINED;
    L8:
        AnonymousClass4 r10 = r2;
        Object r1 = r10.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r10.label;
        boolean r13 = true;
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        Ref.ObjectRef r5 = (Ref.ObjectRef) r10.L$3;
        Function1<? super AnimationScope<T, V>, Unit> r6 = (Function1) r10.L$2;
        Animation<T, V> r7 = (Animation) r10.L$1;
        AnimationState<T, V> r8 = (AnimationState) r10.L$0;
    L54:
        ResultKt.throwOnFailure(r1);     // Catch: CancellationException -> L18
        Function1<? super AnimationScope<T, V>, Unit> r12 = r6;
        r0 = r7;
    L31:
        Object r14 = r5.element;     // Catch: CancellationException -> L18
        Intrinsics.checkNotNull(r14);     // Catch: CancellationException -> L18
        if (((AnimationScope) r14).isRunning() == false) goto L37;
        final float r15 = getDurationScale(r10.getContext());     // Catch: CancellationException -> L18
        final Ref.ObjectRef r28 = r5;
        final Animation<T, V> r210 = r0;
        final AnimationState<T, V> r211 = r8;
        final Function1<? super AnimationScope<T, V>, Unit> r31 = r12;
        Function1 r16 = new y(r28, r15, r210, r211, r31);     // Catch: CancellationException -> L18
        r10.L$0 = r8;     // Catch: CancellationException -> L18
        r10.L$1 = r0;     // Catch: CancellationException -> L18
        r10.L$2 = r12;     // Catch: CancellationException -> L18
        r10.L$3 = r5;     // Catch: CancellationException -> L18
        r10.label = 2;     // Catch: CancellationException -> L18
        if (callWithFrameNanos(r0, r16, r10) != r11) goto L31;
        return r11;
    L37:
        return Unit.INSTANCE;
    L18:
        e = e;
        r9 = r8;
    L42:
        AnimationScope r17 = (AnimationScope) r5.element;
        if (r17 == null) goto L45;
        r17.setRunning$animation_core(false);
    L45:
        AnimationScope r18 = (AnimationScope) r5.element;
        if (r18 != null) goto L48;
    L50:
        r13 = false;
    L51:
        if (r13 == false) goto L53;
        r9.setRunning$animation_core(false);
    L53:
        throw e;
    L48:
        if (r18.getLastFrameTimeNanos() != r9.getLastFrameTimeNanos()) goto L50;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r5 = (Ref.ObjectRef) r10.L$3;
        r6 = (Function1) r10.L$2;
        r7 = (Animation) r10.L$1;
        r8 = (AnimationState) r10.L$0;
        goto L54
    L20:
        ResultKt.throwOnFailure(r1);
        final T r19 = r0.getValueFromNanos(0);
        final AnimationVector r110 = r0.getVelocityVectorFromNanos(0);
        final Ref.ObjectRef r111 = new Ref.ObjectRef();
        if (r27 != Long.MIN_VALUE) goto L25;
        final float r20 = getDurationScale(r10.getContext());     // Catch: CancellationException -> L40
        Function1 r21 = new w(r111, r19, r26, r110, r25, r20, r29);     // Catch: CancellationException -> L40
        r10.L$0 = r9;     // Catch: CancellationException -> L40
        r10.L$1 = r0;     // Catch: CancellationException -> L40
        r12 = r29;
        r10.L$2 = r12;     // Catch: CancellationException -> L40
        r10.L$3 = r111;     // Catch: CancellationException -> L40
        r10.label = 1;     // Catch: CancellationException -> L40
        if (callWithFrameNanos(r0, r21, r10) != r11) goto L30;
        return r11;
    L30:
        r8 = r9;
        r5 = r111;
        goto L31
    L25:
        r12 = r29;
        AnimationScope r22 = new AnimationScope(r19, r26.getTypeConverter(), r110, r27, r26.getTargetValue(), r27, true, new x(r9));     // Catch: CancellationException -> L38
        r111 = r111;
        doAnimationFrameWithScale(r22, r27, getDurationScale(r10.getContext()), r26, r25, r29);     // Catch: CancellationException -> L40
        r111.element = r22;     // Catch: CancellationException -> L40
    L38:
        e = e;
        r111 = r111;
    L41:
        r5 = r111;
    L40:
        e = e;
    L7:
        r2 = new AnonymousClass4(r30);
        goto L8
    }

    public static final <T, V extends AnimationVector> Object animateDecay(AnimationState<T, V> r9, DecayAnimationSpec<T> r10, boolean r11, Function1<? super AnimationScope<T, V>, Unit> r12, Continuation<? super Unit> r13) {
        T r0 = r9.getValue();
        AnimationVector r1 = r9.getVelocityVector();
        DecayAnimation r4 = new DecayAnimation(r10, r9.getTypeConverter(), r0, r1);
        if (r11 == false) goto L5;
        long r14 = r9.getLastFrameTimeNanos();
    L6:
        Object r15 = animate(r9, r4, r14, r12, r13);
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r15;
    L10:
        return Unit.INSTANCE;
    L5:
        r14 = Long.MIN_VALUE;
        goto L6
    }

    public static final Object animateDecay(float r11, float r12, FloatDecayAnimationSpec r13, final Function2<? super Float, ? super Float, Unit> r14, Continuation<? super Unit> r15) {
        DecayAnimation<Float, AnimationVector1D> r1 = AnimationKt.DecayAnimation(r13, r11, r12);
        Object r16 = animate$default(AnimationStateKt.AnimationState$default(r11, r12, 0, 0, false, 28, null), r1, 0, new b0(r14), r15, 2, null);
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r16;
    L6:
        return Unit.INSTANCE;
    }

    public static final Object animate(float r8, float r9, float r10, AnimationSpec<Float> r11, Function2<? super Float, ? super Float, Unit> r12, Continuation<? super Unit> r13) {
        Object r14 = animate(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Boxing.boxFloat(r8), Boxing.boxFloat(r9), Boxing.boxFloat(r10), r11, r12, r13);
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r14;
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit animate$lambda$11(Ref.ObjectRef r7, float r8, Animation r9, AnimationState r10, Function1 r11, long r12) {
        Object r13 = r7.element;
        Intrinsics.checkNotNull(r13);
        doAnimationFrameWithScale((AnimationScope) r13, r12, r8, r9, r10, r11);
        return Unit.INSTANCE;
    }

    public static final <T, V extends AnimationVector> Object animateTo(AnimationState<T, V> r12, T r13, AnimationSpec<T> r14, boolean r15, Function1<? super AnimationScope<T, V>, Unit> r16, Continuation<? super Unit> r17) {
        T r3 = r12.getValue();
        TargetBasedAnimation r7 = new TargetBasedAnimation(r14, r12.getTypeConverter(), r3, r13, r12.getVelocityVector());
        if (r15 == false) goto L5;
        long r0 = r12.getLastFrameTimeNanos();
    L6:
        Object r1 = animate(r12, r7, r0, r16, r17);
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r1;
    L10:
        return Unit.INSTANCE;
    L5:
        r0 = Long.MIN_VALUE;
        goto L6
    }

    private static final <T, V extends AnimationVector> void doAnimationFrame(AnimationScope<T, V> r0, long r1, long r3, Animation<T, V> r5, AnimationState<T, V> r6, Function1<? super AnimationScope<T, V>, Unit> r7) {
        r0.setLastFrameTimeNanos$animation_core(r1);
        r0.setValue$animation_core(r5.getValueFromNanos(r3));
        r0.setVelocityVector$animation_core(r5.getVelocityVectorFromNanos(r3));
        if (r5.isFinishedFromNanos(r3) == false) goto L5;
        r0.setFinishedTimeNanos$animation_core(r0.getLastFrameTimeNanos());
        r0.setRunning$animation_core(false);
    L5:
        updateState(r0, r6);
        r7.invoke(r0);
    }

    private static final <T, V extends AnimationVector> void doAnimationFrameWithScale(AnimationScope<T, V> r10, long r11, float r13, Animation<T, V> r14, AnimationState<T, V> r15, Function1<? super AnimationScope<T, V>, Unit> r16) {
        if (r13 != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        long r1 = r14.getDurationNanos();
    L9:
        doAnimationFrame(r10, r11, r1, r14, r15, r16);
        return;
    L8:
        r1 = (long) ((r11 - r10.getStartTimeNanos()) / r13);
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    public static final <T, V extends AnimationVector> Object animate(final TwoWayConverter<T, V> r15, T r16, T r17, T r18, AnimationSpec<T> r19, final Function2<? super T, ? super T, Unit> r20, Continuation<? super Unit> r21) {
        if (r18 == null) goto L8;
        AnimationVector r0 = (AnimationVector) r15.getConvertToVector().invoke(r18);
        if (r0 == null) goto L8;
    L9:
        TargetBasedAnimation r12 = new TargetBasedAnimation(r19, r15, r16, r17, r0);
        Object r1 = animate$default(new AnimationState(r15, r16, r0, 0, 0, false, 56, null), r12, 0, new z(r20, r15), r21, 2, null);
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r1;
    L13:
        return Unit.INSTANCE;
    L8:
        r0 = AnimationVectorsKt.newInstance((AnimationVector) r15.getConvertToVector().invoke(r16));
        goto L9
    }

    public static /* synthetic */ Object animate$default(AnimationState r6, Animation r7, long r8, Function1 r10, Continuation r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r8 = Long.MIN_VALUE;
    L5:
        long r2 = r8;
        if ((r12 & 4) == 0) goto L9;
        r10 = new v();
    L9:
        return animate(r6, r7, r2, r10, r11);
    }

    public static /* synthetic */ Object animateDecay$default(AnimationState r0, DecayAnimationSpec r1, boolean r2, Function1 r3, Continuation r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = new t();
    L9:
        return animateDecay(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Object animate$default(float r7, float r8, float r9, AnimationSpec r10, Function2 r11, Continuation r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        float r3 = MenuKt.ClosedAlphaTarget;
    L7:
        if ((r13 & 8) == 0) goto L10;
        r10 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, 7, null);
    L10:
        return animate(r7, r8, r3, r10, r11, r12);
    L5:
        r3 = r9;
        goto L7
    }

    private static final Unit animate$lambda$8(Ref.ObjectRef r13, Object r14, Animation r15, AnimationVector r16, final AnimationState r17, float r18, Function1 r19, long r20) {
        AnimationScope r11 = new AnimationScope(r14, r15.getTypeConverter(), r16, r20, r15.getTargetValue(), r20, true, new c0(r17));
        doAnimationFrameWithScale(r11, r20, r18, r15, r17, r19);
        r13.element = r11;
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$default(AnimationState r6, Object r7, AnimationSpec r8, boolean r9, Function1 r10, Continuation r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r8 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, 7, null);
    L5:
        AnimationSpec r2 = r8;
        if ((r12 & 4) == 0) goto L8;
        boolean r3 = false;
    L10:
        if ((r12 & 8) == 0) goto L13;
        r10 = new u();
    L13:
        return animateTo(r6, r7, r2, r3, r10, r11);
    L8:
        r3 = r9;
        goto L10
    }

    public static /* synthetic */ Object animate$default(TwoWayConverter r9, Object r10, Object r11, Object r12, AnimationSpec r13, Function2 r14, Continuation r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        Object r5 = null;
    L7:
        if ((r16 & 16) == 0) goto L9;
        AnimationSpec r6 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, 7, null);
    L11:
        return animate(r9, r10, r11, r5, r6, r14, r15);
    L9:
        r6 = r13;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }
}
