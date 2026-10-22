package androidx.compose.foundation.gestures.snapping;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.autofill.HintConstants;
import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u001a\u0015\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\n\u001ae\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u00122!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0014H\u0082@¢\u0006\u0002\u0010\u0019\u001a(\u0010\u001a\u001a\u0002H\u001b\"\u000e\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u001c*\b\u0012\u0004\u0012\u0002H\u001b0\u001dH\u0082\u0002¢\u0006\u0002\u0010\u001e\u001a(\u0010\u001f\u001a\u0002H\u001b\"\u000e\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u001c*\b\u0012\u0004\u0012\u0002H\u001b0\u001dH\u0082\u0002¢\u0006\u0002\u0010\u001e\u001ak\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f*\u00020\u000e2\u0006\u0010!\u001a\u00020\u00062\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0#2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0014H\u0082@¢\u0006\u0002\u0010$\u001as\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f*\u00020\u000e2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0#2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\b2!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0014H\u0082@¢\u0006\u0002\u0010(\u001a\u0014\u0010)\u001a\u00020\u0006*\u00020\u00062\u0006\u0010*\u001a\u00020\u0006H\u0002\u001a'\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0006H\u0000¢\u0006\u0004\b7\u00108\u001a\u0017\u0010;\u001a\u00020\u00182\f\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=H\u0082\b\"\u0016\u0010+\u001a\u00020,X\u0080\u0004¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.\"\u000e\u00100\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u00101\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u00109\u001a\u00020:X\u0082T¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"snapFlingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "snapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "rememberSnapFlingBehavior", "(Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "approach", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialTargetOffset", "initialVelocity", "animation", "Landroidx/compose/foundation/gestures/snapping/ApproachAnimation;", "onAnimationStep", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "delta", "", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLandroidx/compose/foundation/gestures/snapping/ApproachAnimation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "T", "", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "component2", "animateDecay", "targetOffset", "animationState", "Landroidx/compose/animation/core/AnimationState;", "(Landroidx/compose/foundation/gestures/ScrollScope;FLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateWithTarget", "cancelOffset", "animationSpec", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coerceToTarget", "target", "MinFlingVelocityDp", "Landroidx/compose/ui/unit/Dp;", "getMinFlingVelocityDp", "()F", "F", "NoDistance", "NoVelocity", "calculateFinalOffset", "snappingOffset", "Landroidx/compose/foundation/gestures/snapping/FinalSnappingItem;", "lowerBound", "upperBound", "calculateFinalOffset-Fhqu1e0", "(IFF)F", "DEBUG", "", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SnapFlingBehaviorKt {
    private static final boolean DEBUG = false;
    private static final float MinFlingVelocityDp = 0.0f;
    public static final float NoDistance = 0.0f;
    public static final float NoVelocity = 0.0f;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt", f = "SnapFlingBehavior.kt", i = {0, 0, 0}, l = {308}, m = "animateDecay", n = {"animationState", "previousValue", "targetOffset"}, s = {"L$0", "L$1", "F$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return SnapFlingBehaviorKt.access$animateDecay(null, MenuKt.ClosedAlphaTarget, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateWithTarget$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt", f = "SnapFlingBehavior.kt", i = {0, 0, 0, 0}, l = {349}, m = "animateWithTarget", n = {"animationState", "consumedUpToNow", "targetOffset", "initialVelocity"}, s = {"L$0", "L$1", "F$0", "F$1"})
    public static final class C01691 extends ContinuationImpl {
        float F$0;
        float F$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C01691(Continuation<? super C01691> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r8) {
            this.result = r8;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return SnapFlingBehaviorKt.access$animateWithTarget(null, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, null, null, this);
        }
    }

    public static /* synthetic */ Unit a(float r0, Ref.FloatRef r1, ScrollScope r2, Function1 r3, AnimationScope r4) {
        return animateWithTarget$lambda$3(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit b(float r0, Ref.FloatRef r1, ScrollScope r2, Function1 r3, AnimationScope r4) {
        return animateDecay$lambda$1(r0, r1, r2, r3, r4);
    }

    private static final boolean calculateFinalOffset_Fhqu1e0$isValidDistance(float r3) {
        if (r3 != Float.POSITIVE_INFINITY) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
    L13:
        return false;
    L8:
        if (r3 != Float.NEGATIVE_INFINITY) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L13;
        return true;
    L10:
        r4 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    private static final void debugLog(Function0<String> r0) {
    }

    static {
        MinFlingVelocityDp = Dp.constructor-impl(400);
    }

    public static final float getMinFlingVelocityDp() {
        return MinFlingVelocityDp;
    }

    private static final <T extends Comparable<? super T>> T component1(ClosedFloatingPointRange<T> r0) {
        return (T) r0.getStart();
    }

    private static final <T extends Comparable<? super T>> T component2(ClosedFloatingPointRange<T> r0) {
        return (T) r0.getEndInclusive();
    }

    private static final float coerceToTarget(float r2, float r3) {
        if (r3 != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return MenuKt.ClosedAlphaTarget;
    L9:
        if (r3 <= MenuKt.ClosedAlphaTarget) goto L12;
        return RangesKt.coerceAtMost(r2, r3);
    L12:
        return RangesKt.coerceAtLeast(r2, r3);
    L5:
        r1 = false;
        goto L6
    }

    /* JADX INFO: renamed from: calculateFinalOffset-Fhqu1e0, reason: not valid java name */
    public static final float m741calculateFinalOffsetFhqu1e0(int r3, float r4, float r5) {
        FinalSnappingItem.Companion r0 = FinalSnappingItem.Companion;
        if (FinalSnappingItem.m734equalsimpl0(r3, r0.m738getClosestItembbeMdSM()) == false) goto L8;
        if (Math.abs(r5) > Math.abs(r4)) goto L15;
    L9:
        r4 = r5;
    L15:
        if (calculateFinalOffset_Fhqu1e0$isValidDistance(r4) == true) goto L17;
        return MenuKt.ClosedAlphaTarget;
    L17:
        return r4;
    L8:
        if (FinalSnappingItem.m734equalsimpl0(r3, r0.m739getNextItembbeMdSM()) == true) goto L9;
        if (FinalSnappingItem.m734equalsimpl0(r3, r0.m740getPreviousItembbeMdSM()) == true) goto L15;
        r4 = MenuKt.ClosedAlphaTarget;
        goto L15
    }

    public static final TargetedFlingBehavior rememberSnapFlingBehavior(SnapLayoutInfoProvider r5, Composer r6, int r7) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1921733134, r7, -1, "androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior (SnapFlingBehavior.kt:230)");
    L5:
        Density r0 = (Density) r6.consume(CompositionLocalsKt.getLocalDensity());
        boolean r1 = false;
        DecayAnimationSpec r2 = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(r6, 0);
        if (((r7 & 14) ^ 6) <= 4) goto L10;
        if (r6.changed(r5) == false) goto L10;
    L11:
        r1 = true;
    L12:
        boolean r8 = (r6.changed(r2) | r1) | r6.changed(r0);
        Object r3 = r6.rememberedValue();
        if (r8 == false) goto L15;
    L16:
        r3 = snapFlingBehavior(r5, r2, AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, null, 5, null));
        r6.updateRememberedValue(r3);
    L17:
        TargetedFlingBehavior r4 = (TargetedFlingBehavior) r3;
        if (ComposerKt.isTraceInProgress() == false) goto L20;
        ComposerKt.traceEventEnd();
    L20:
        return r4;
    L15:
        if (r3 != Composer.Companion.getEmpty()) goto L17;
    L10:
        if ((r7 & 6) != 4) goto L12;
        goto L11
    }

    public static final TargetedFlingBehavior snapFlingBehavior(SnapLayoutInfoProvider r1, DecayAnimationSpec<Float> r2, AnimationSpec<Float> r3) {
        return new SnapFlingBehavior(r1, r2, r3);
    }

    private static final void animateDecay$consumeDelta(AnimationScope<Float, AnimationVector1D> r1, ScrollScope r2, Function1<? super Float, Unit> r3, float r4) {
        float r5 = r2.scrollBy(r4);     // Catch: CancellationException -> L4
    L5:
        r3.invoke(Float.valueOf(r5));
        if (Math.abs(r4 - r5) <= 0.5f) goto L11;
        r1.cancelAnimation();
        return;
    L11:
        return;
    L4:
        r1.cancelAnimation();
        r5 = MenuKt.ClosedAlphaTarget;
        goto L5
    }

    private static final Unit animateDecay$lambda$1(float r2, Ref.FloatRef r3, ScrollScope r4, Function1 r5, AnimationScope r6) {
        if (Math.abs(((Number) r6.getValue()).floatValue()) < Math.abs(r2)) goto L5;
        float r7 = coerceToTarget(((Number) r6.getValue()).floatValue(), r2);
        animateDecay$consumeDelta(r6, r4, r5, r7 - r3.element);
        r6.cancelAnimation();
        r3.element = r7;
    L7:
        return Unit.INSTANCE;
    L5:
        animateDecay$consumeDelta(r6, r4, r5, ((Number) r6.getValue()).floatValue() - r3.element);
        r3.element = ((Number) r6.getValue()).floatValue();
        goto L7
    }

    private static final Unit animateWithTarget$lambda$3(float r2, Ref.FloatRef r3, ScrollScope r4, Function1 r5, AnimationScope r6) {
        float r7 = coerceToTarget(((Number) r6.getValue()).floatValue(), r2);
        float r0 = r7 - r3.element;
        float r8 = r4.scrollBy(r0);     // Catch: CancellationException -> L5
    L6:
        r5.invoke(Float.valueOf(r8));
        if (Math.abs(r0 - r8) <= 0.5f) goto L9;
    L13:
        r6.cancelAnimation();
    L14:
        r3.element += r8;
        return Unit.INSTANCE;
    L9:
        if (r7 != ((Number) r6.getValue()).floatValue()) goto L11;
        boolean r9 = true;
    L12:
        if (r9 == true) goto L14;
    L11:
        r9 = false;
    L5:
        r6.cancelAnimation();
        r8 = MenuKt.ClosedAlphaTarget;
        goto L6
    }

    public static final /* synthetic */ Object access$animateDecay(ScrollScope r0, float r1, AnimationState r2, DecayAnimationSpec r3, Function1 r4, Continuation r5) {
        return animateDecay(r0, r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ Object access$approach(ScrollScope r0, float r1, float r2, ApproachAnimation r3, Function1 r4, Continuation r5) {
        return approach(r0, r1, r2, r3, r4, r5);
    }

    private static final Object animateDecay(final ScrollScope r5, final float r6, AnimationState<Float, AnimationVector1D> r7, DecayAnimationSpec<Float> r8, final Function1<? super Float, Unit> r9, Continuation<? super AnimationResult<Float, AnimationVector1D>> r10) {
        if ((r10 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r10;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = r0.F$0;
        Ref.FloatRef r12 = (Ref.FloatRef) r0.L$1;
        r7 = (AnimationState) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L23:
        return new AnimationResult(Boxing.boxFloat(r6 - r12.element), r7);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        final Ref.FloatRef r13 = new Ref.FloatRef();
        if (r7.getVelocity().floatValue() != MenuKt.ClosedAlphaTarget) goto L17;
        boolean r4 = true;
    L18:
        Function1 r14 = new c(r6, r13, r5, r9);
        r0.L$0 = r7;
        r0.L$1 = r13;
        r0.F$0 = r6;
        r0.label = 1;
        if (SuspendAnimationKt.animateDecay(r7, r8, !r4, r14, r0) != r2) goto L21;
        return r2;
    L21:
        r12 = r13;
        goto L23
    L17:
        r4 = false;
    L7:
        r0 = new AnonymousClass1(r10);
        goto L8
    }

    private static final Object approach(ScrollScope r6, float r7, float r8, ApproachAnimation<Float, AnimationVector1D> r9, Function1<? super Float, Unit> r10, Continuation<? super AnimationResult<Float, AnimationVector1D>> r11) {
        return r9.approachAnimation(r6, Boxing.boxFloat(r7), Boxing.boxFloat(r8), r10, r11);
    }

    public static final /* synthetic */ Object access$animateWithTarget(ScrollScope r0, float r1, float r2, AnimationState r3, AnimationSpec r4, Function1 r5, Continuation r6) {
        return animateWithTarget(r0, r1, r2, r3, r4, r5, r6);
    }

    private static final Object animateWithTarget(final ScrollScope r12, float r13, final float r14, AnimationState<Float, AnimationVector1D> r15, AnimationSpec<Float> r16, final Function1<? super Float, Unit> r17, Continuation<? super AnimationResult<Float, AnimationVector1D>> r18) {
        if ((r18 instanceof C01691) == false) goto L7;
        C01691 r1 = (C01691) r18;
        int r2 = r1.label;
        if ((r2 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r1.label = r2 - RtlSpacingHelper.UNDEFINED;
    L8:
        C01691 r7 = r1;
        Object r0 = r7.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r7.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        float r5 = r7.F$1;
        float r6 = r7.F$0;
        Ref.FloatRef r8 = (Ref.FloatRef) r7.L$1;
        AnimationState<Float, AnimationVector1D> r9 = (AnimationState) r7.L$0;
        ResultKt.throwOnFailure(r0);
        float r10 = r6;
        AnimationState<Float, AnimationVector1D> r11 = r9;
    L23:
        return new AnimationResult(Boxing.boxFloat(r10 - r8.element), AnimationStateKt.copy$default(r11, MenuKt.ClosedAlphaTarget, coerceToTarget(r11.getVelocity().floatValue(), r5), 0, 0, false, 29, null));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        final Ref.FloatRef r19 = new Ref.FloatRef();
        float r20 = r15.getVelocity().floatValue();
        Float r21 = Boxing.boxFloat(r13);
        if (r15.getVelocity().floatValue() != MenuKt.ClosedAlphaTarget) goto L17;
        boolean r22 = true;
    L18:
        Function1 r23 = new d(r14, r19, r12, r17);
        r7.L$0 = r15;
        r7.L$1 = r19;
        r10 = r13;
        r7.F$0 = r10;
        r7.F$1 = r20;
        r7.label = 1;
        if (SuspendAnimationKt.animateTo(r15, r21, r16, !r22, r23, r7) != r3) goto L21;
        return r3;
    L21:
        r8 = r19;
        r5 = r20;
        r11 = r15;
        goto L23
    L17:
        r22 = false;
    L7:
        r1 = new C01691(r18);
        goto L8
    }
}
