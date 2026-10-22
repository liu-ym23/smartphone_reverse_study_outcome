package androidx.compose.foundation.gestures.snapping;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.MotionDurationScale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\t\u0010\nJ.\u0010\u0011\u001a\u00020\u0006*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u0015H\u0096@¢\u0006\u0002\u0010\u0017J:\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001a0\u0019*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u0015H\u0082@¢\u0006\u0002\u0010\u0017JB\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001a0\u001d*\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u0015H\u0082@¢\u0006\u0002\u0010!JQ\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001a0\u0019*\u00020\u00122\u0006\u0010#\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00160\u0015H\u0082@¢\u0006\u0002\u0010!J\u0018\u0010(\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J\u0013\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010,H\u0096\u0002J\b\u0010-\u001a\u00020.H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006/"}, d2 = {"Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "snapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "<init>", "(Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;)V", "motionScaleDuration", "Landroidx/compose/ui/MotionDurationScale;", "getMotionScaleDuration$foundation_release", "()Landroidx/compose/ui/MotionDurationScale;", "setMotionScaleDuration$foundation_release", "(Landroidx/compose/ui/MotionDurationScale;)V", "performFling", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "onRemainingDistanceUpdated", "Lkotlin/Function1;", "", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fling", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "Landroidx/compose/animation/core/AnimationVector1D;", "onRemainingScrollOffsetUpdate", "tryApproach", "Landroidx/compose/animation/core/AnimationState;", "offset", "velocity", "updateRemainingScrollOffset", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runApproach", "initialTargetOffset", "onAnimationStep", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "delta", "isDecayApproachPossible", "", "equals", "other", "", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SnapFlingBehavior implements TargetedFlingBehavior {
    public static final int $stable = 0;
    private final DecayAnimationSpec<Float> decayAnimationSpec;
    private MotionDurationScale motionScaleDuration;
    private final AnimationSpec<Float> snapAnimationSpec;
    private final SnapLayoutInfoProvider snapLayoutInfoProvider;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior", f = "SnapFlingBehavior.kt", i = {0}, l = {114}, m = "fling", n = {"onRemainingScrollOffsetUpdate"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SnapFlingBehavior this$0;

        public AnonymousClass1(SnapFlingBehavior r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return SnapFlingBehavior.access$fling(this.this$0, null, MenuKt.ClosedAlphaTarget, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior", f = "SnapFlingBehavior.kt", i = {}, l = {100}, m = "performFling", n = {}, s = {})
    public static final class C01671 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SnapFlingBehavior this$0;

        public C01671(SnapFlingBehavior r1, Continuation<? super C01671> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return this.this$0.performFling(null, MenuKt.ClosedAlphaTarget, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$tryApproach$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior", f = "SnapFlingBehavior.kt", i = {}, l = {174}, m = "tryApproach", n = {}, s = {})
    public static final class C01681 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SnapFlingBehavior this$0;

        public C01681(SnapFlingBehavior r1, Continuation<? super C01681> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return SnapFlingBehavior.access$tryApproach(this.this$0, null, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, this);
        }
    }

    @Override // androidx.compose.foundation.gestures.TargetedFlingBehavior, androidx.compose.foundation.gestures.FlingBehavior
    public final /* synthetic */ Object performFling(ScrollScope r1, float r2, Continuation r3) {
        return TargetedFlingBehavior.CC.$default$performFling(this, r1, r2, r3);
    }

    public int hashCode() {
        return ((((0 + this.snapAnimationSpec.hashCode()) * 31) + this.decayAnimationSpec.hashCode()) * 31) + this.snapLayoutInfoProvider.hashCode();
    }

    public final MotionDurationScale getMotionScaleDuration$foundation_release() {
        return this.motionScaleDuration;
    }

    public static final /* synthetic */ DecayAnimationSpec access$getDecayAnimationSpec$p(SnapFlingBehavior r0) {
        return r0.decayAnimationSpec;
    }

    public static final /* synthetic */ AnimationSpec access$getSnapAnimationSpec$p(SnapFlingBehavior r0) {
        return r0.snapAnimationSpec;
    }

    public static final /* synthetic */ SnapLayoutInfoProvider access$getSnapLayoutInfoProvider$p(SnapFlingBehavior r0) {
        return r0.snapLayoutInfoProvider;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof SnapFlingBehavior) == false) goto L12;
        SnapFlingBehavior r5 = (SnapFlingBehavior) r4;
        if (Intrinsics.areEqual(r5.snapAnimationSpec, this.snapAnimationSpec) == true) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(r5.decayAnimationSpec, this.decayAnimationSpec) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(r5.snapLayoutInfoProvider, this.snapLayoutInfoProvider) == false) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    public final void setMotionScaleDuration$foundation_release(MotionDurationScale r1) {
        this.motionScaleDuration = r1;
    }

    private final boolean isDecayApproachPossible(float r3, float r4) {
        if (Math.abs(DecayAnimationSpecKt.calculateTargetValue(this.decayAnimationSpec, MenuKt.ClosedAlphaTarget, r4)) < Math.abs(r3)) goto L5;
        return true;
    L5:
        return false;
    }

    public SnapFlingBehavior(SnapLayoutInfoProvider r1, DecayAnimationSpec<Float> r2, AnimationSpec<Float> r3) {
        this.snapLayoutInfoProvider = r1;
        this.decayAnimationSpec = r2;
        this.snapAnimationSpec = r3;
        this.motionScaleDuration = ScrollableKt.getDefaultScrollMotionDurationScale();
    }

    private final Object fling(ScrollScope r11, float r12, Function1<? super Float, Unit> r13, Continuation<? super AnimationResult<Float, AnimationVector1D>> r14) {
        if ((r14 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r14;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r13 = (Function1) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L17:
        AnimationResult r16 = (AnimationResult) r15;
        r13.invoke(Boxing.boxFloat(MenuKt.ClosedAlphaTarget));
        return r16;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        MotionDurationScale r17 = this.motionScaleDuration;
        SnapFlingBehavior$fling$result$1 r4 = new SnapFlingBehavior$fling$result$1(this, r12, r13, r11, null);
        r0.L$0 = r13;
        r0.label = 1;
        r15 = BuildersKt.withContext(r17, r4, r0);
        if (r15 != r2) goto L17;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r14);
        goto L8
    }

    @Override // androidx.compose.foundation.gestures.TargetedFlingBehavior
    public Object performFling(ScrollScope r5, float r6, Function1<? super Float, Unit> r7, Continuation<? super Float> r8) {
        if ((r8 instanceof C01671) == false) goto L7;
        C01671 r0 = (C01671) r8;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L17:
        AnimationResult r10 = (AnimationResult) r9;
        float r11 = ((Number) r10.component1()).floatValue();
        AnimationState r12 = r10.component2();
        float r13 = MenuKt.ClosedAlphaTarget;
        if (r11 == MenuKt.ClosedAlphaTarget) goto L21;
        r4 = false;
    L21:
        if (r4 == true) goto L25;
        r13 = ((Number) r12.getVelocity()).floatValue();
    L25:
        return Boxing.boxFloat(r13);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        r0.label = 1;
        r9 = fling(r5, r6, r7, r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new C01671(this, r8);
        goto L8
    }

    public static final /* synthetic */ Object access$fling(SnapFlingBehavior r0, ScrollScope r1, float r2, Function1 r3, Continuation r4) {
        return r0.fling(r1, r2, r3, r4);
    }

    private final Object runApproach(ScrollScope r9, float r10, float r11, Function1<? super Float, Unit> r12, Continuation<? super AnimationResult<Float, AnimationVector1D>> r13) {
        if (isDecayApproachPossible(r10, r11) == false) goto L5;
        ApproachAnimation r0 = new DecayApproachAnimation(this.decayAnimationSpec);
    L7:
        return SnapFlingBehaviorKt.access$approach(r9, r10, r11, r0, r12, r13);
    L5:
        r0 = new TargetApproachAnimation(this.snapAnimationSpec);
        goto L7
    }

    private final Object tryApproach(ScrollScope r10, float r11, float r12, Function1<? super Float, Unit> r13, Continuation<? super AnimationState<Float, AnimationVector1D>> r14) {
        if ((r14 instanceof C01681) == false) goto L7;
        C01681 r0 = (C01681) r14;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        C01681 r6 = r0;
        Object r15 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
    L30:
        return ((AnimationResult) r15).getCurrentAnimationState();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        boolean r4 = false;
        if (Math.abs(r11) != MenuKt.ClosedAlphaTarget) goto L17;
        boolean r16 = true;
    L18:
        if (r16 == true) goto L29;
        if (Math.abs(r12) != MenuKt.ClosedAlphaTarget) goto L22;
        r4 = true;
    L22:
        if (r4 == true) goto L29;
        r6.label = 1;
        r15 = runApproach(r10, r11, r12, r13, r6);
        if (r15 != r2) goto L30;
        return r2;
    L29:
        return AnimationStateKt.AnimationState$default(r11, r12, 0, 0, false, 28, null);
    L17:
        r16 = false;
    L7:
        r0 = new C01681(this, r14);
        goto L8
    }

    public static final /* synthetic */ Object access$runApproach(SnapFlingBehavior r0, ScrollScope r1, float r2, float r3, Function1 r4, Continuation r5) {
        return r0.runApproach(r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ Object access$tryApproach(SnapFlingBehavior r0, ScrollScope r1, float r2, float r3, Function1 r4, Continuation r5) {
        return r0.tryApproach(r1, r2, r3, r4, r5);
    }
}
