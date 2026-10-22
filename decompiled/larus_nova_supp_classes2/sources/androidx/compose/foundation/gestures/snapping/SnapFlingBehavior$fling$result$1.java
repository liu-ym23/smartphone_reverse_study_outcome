package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.material.TextFieldImplKt;
import androidx.compose.material3.MenuKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1", f = "SnapFlingBehavior.kt", i = {0}, l = {134, TextFieldImplKt.AnimationDuration}, m = "invokeSuspend", n = {"remainingScrollOffset"}, s = {"L$0"})
public final class SnapFlingBehavior$fling$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AnimationResult<Float, AnimationVector1D>>, Object> {
    final /* synthetic */ float $initialVelocity;
    final /* synthetic */ Function1<Float, Unit> $onRemainingScrollOffsetUpdate;
    final /* synthetic */ ScrollScope $this_fling;
    Object L$0;
    int label;
    final /* synthetic */ SnapFlingBehavior this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public SnapFlingBehavior$fling$result$1(SnapFlingBehavior r1, float r2, Function1<? super Float, Unit> r3, ScrollScope r4, Continuation<? super SnapFlingBehavior$fling$result$1> r5) {
        this.this$0 = r1;
        this.$initialVelocity = r2;
        this.$onRemainingScrollOffsetUpdate = r3;
        this.$this_fling = r4;
        super(2, r5);
    }

    public static /* synthetic */ Unit a(Ref.FloatRef r0, Function1 r1, float r2) {
        return invokeSuspend$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ Unit c(Ref.FloatRef r0, Function1 r1, float r2) {
        return invokeSuspend$lambda$4(r0, r1, r2);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SnapFlingBehavior$fling$result$1(this.this$0, this.$initialVelocity, this.$onRemainingScrollOffsetUpdate, this.$this_fling, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super AnimationResult<Float, AnimationVector1D>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r15);
    L22:
        return r15;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        final Ref.FloatRef r2 = (Ref.FloatRef) this.L$0;
        ResultKt.throwOnFailure(r15);
    L16:
        AnimationState r4 = (AnimationState) r15;
        float r16 = SnapFlingBehavior.access$getSnapLayoutInfoProvider$p(this.this$0).calculateSnapOffset(((Number) r4.getVelocity()).floatValue());
        if ((true ^ Float.isNaN(r16)) == true) goto L19;
        InlineClassHelperKt.throwIllegalStateException("calculateSnapOffset returned NaN. Please use a valid value.");
    L19:
        r2.element = r16;
        ScrollScope r3 = this.$this_fling;
        AnimationState r9 = AnimationStateKt.copy$default(r4, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 0, 0, false, 30, null);
        AnimationSpec r10 = SnapFlingBehavior.access$getSnapAnimationSpec$p(this.this$0);
        final Function1<Float, Unit> r5 = this.$onRemainingScrollOffsetUpdate;
        Function1 r11 = new b(r2, r5);
        this.L$0 = null;
        this.label = 2;
        r15 = SnapFlingBehaviorKt.access$animateWithTarget(r3, r16, r16, r9, r10, r11, this);
        if (r15 != r0) goto L22;
        return r0;
    L10:
        ResultKt.throwOnFailure(r15);
        float r17 = SnapFlingBehavior.access$getSnapLayoutInfoProvider$p(this.this$0).calculateApproachOffset(this.$initialVelocity, DecayAnimationSpecKt.calculateTargetValue(SnapFlingBehavior.access$getDecayAnimationSpec$p(this.this$0), MenuKt.ClosedAlphaTarget, this.$initialVelocity));
        if ((!Float.isNaN(r17)) == true) goto L13;
        InlineClassHelperKt.throwIllegalStateException("calculateApproachOffset returned NaN. Please use a valid value.");
    L13:
        r2 = new Ref.FloatRef();
        float r18 = Math.abs(r17) * Math.signum(this.$initialVelocity);
        r2.element = r18;
        this.$onRemainingScrollOffsetUpdate.invoke(Boxing.boxFloat(r18));
        SnapFlingBehavior r6 = this.this$0;
        ScrollScope r7 = this.$this_fling;
        float r8 = r2.element;
        float r12 = this.$initialVelocity;
        final Function1<Float, Unit> r19 = this.$onRemainingScrollOffsetUpdate;
        Function1 r13 = new a(r2, r19);
        this.L$0 = r2;
        this.label = 1;
        r15 = SnapFlingBehavior.access$tryApproach(r6, r7, r8, r12, r13, this);
        if (r15 != r0) goto L16;
        return r0;
    }

    private static final Unit invokeSuspend$lambda$1(Ref.FloatRef r1, Function1 r2, float r3) {
        float r0 = r1.element - r3;
        r1.element = r0;
        r2.invoke(Float.valueOf(r0));
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$4(Ref.FloatRef r1, Function1 r2, float r3) {
        float r0 = r1.element - r3;
        r1.element = r0;
        r2.invoke(Float.valueOf(r0));
        return Unit.INSTANCE;
    }
}
