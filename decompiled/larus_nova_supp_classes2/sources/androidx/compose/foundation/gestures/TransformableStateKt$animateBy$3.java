package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$animateBy$3", f = "TransformableState.kt", i = {}, l = {230}, m = "invokeSuspend", n = {}, s = {})
public final class TransformableStateKt$animateBy$3 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DelegatingAnimationSpec $animationSpec;
    final /* synthetic */ Ref.ObjectRef<AnimationData> $previousState;
    final /* synthetic */ AnimationData $targetState;
    private /* synthetic */ Object L$0;
    int label;

    public TransformableStateKt$animateBy$3(Ref.ObjectRef<AnimationData> r1, AnimationData r2, DelegatingAnimationSpec r3, Continuation<? super TransformableStateKt$animateBy$3> r4) {
        this.$previousState = r1;
        this.$targetState = r2;
        this.$animationSpec = r3;
        super(2, r4);
    }

    public static /* synthetic */ Unit a(Ref.ObjectRef r0, TransformScope r1, AnimationScope r2) {
        return invokeSuspend$lambda$0(r0, r1, r2);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        TransformableStateKt$animateBy$3 r0 = new TransformableStateKt$animateBy$3(this.$previousState, this.$targetState, this.$animationSpec, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(TransformScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((TransformScope) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r21) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r21);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r21);
        final TransformScope r1 = (TransformScope) this.L$0;
        AnimationState r2 = AnimationStateKt.AnimationState$default(AnimationDataConverter.INSTANCE, this.$previousState.element, TransformableStateKt.access$getZeroAnimationVelocity$p(), 0, 0, false, 56, null);
        AnimationData r3 = this.$targetState;
        DelegatingAnimationSpec r4 = this.$animationSpec;
        final Ref.ObjectRef<AnimationData> r6 = this.$previousState;
        Function1 r7 = new q2(r6, r1);
        this.label = 1;
        if (SuspendAnimationKt.animateTo$default(r2, r3, r4, false, r7, this, 4, null) != r9) goto L12;
        return r9;
    }

    private static final Unit invokeSuspend$lambda$0(Ref.ObjectRef r6, TransformScope r7, AnimationScope r8) {
        if (((AnimationData) r6.element).getZoom() != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        float r1 = 1.0f;
    L9:
        float r2 = ((AnimationData) r8.getValue()).getDegrees() - ((AnimationData) r6.element).getDegrees();
        r7.mo564transformByd4ec7I(r1, Offset.minus-MK-Hz9U(((AnimationData) r8.getValue()).m550getOffsetF1C5BW0(), ((AnimationData) r6.element).m550getOffsetF1C5BW0()), r2);
        r6.element = r8.getValue();
        return Unit.INSTANCE;
    L8:
        r1 = ((AnimationData) r8.getValue()).getZoom() / ((AnimationData) r6.element).getZoom();
        goto L9
    L5:
        r0 = false;
        goto L6
    }
}
