package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.animation.core.VectorConvertersKt;
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
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$animatePanBy$2", f = "TransformableState.kt", i = {}, l = {182}, m = "invokeSuspend", n = {}, s = {})
public final class TransformableStateKt$animatePanBy$2 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnimationSpec<Offset> $animationSpec;
    final /* synthetic */ long $offset;
    final /* synthetic */ Ref.LongRef $previous;
    private /* synthetic */ Object L$0;
    int label;

    public TransformableStateKt$animatePanBy$2(Ref.LongRef r1, long r2, AnimationSpec<Offset> r4, Continuation<? super TransformableStateKt$animatePanBy$2> r5) {
        this.$previous = r1;
        this.$offset = r2;
        this.$animationSpec = r4;
        super(2, r5);
    }

    public static /* synthetic */ Unit a(Ref.LongRef r0, TransformScope r1, AnimationScope r2) {
        return invokeSuspend$lambda$0(r0, r1, r2);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        TransformableStateKt$animatePanBy$2 r6 = new TransformableStateKt$animatePanBy$2(this.$previous, this.$offset, this.$animationSpec, r9);
        r6.L$0 = r8;
        return r6;
    }

    public final Object invoke(TransformScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((TransformScope) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        final TransformScope r16 = (TransformScope) this.L$0;
        AnimationState r2 = new AnimationState(VectorConvertersKt.getVectorConverter(Offset.Companion), Offset.box-impl(this.$previous.element), null, 0, 0, false, 60, null);
        Offset r4 = Offset.box-impl(this.$offset);
        AnimationSpec<Offset> r5 = this.$animationSpec;
        final Ref.LongRef r3 = this.$previous;
        Function1 r7 = new r2(r3, r16);
        this.label = 1;
        if (SuspendAnimationKt.animateTo$default(r2, r4, r5, false, r7, this, 4, null) != r0) goto L12;
        return r0;
    }

    private static final Unit invokeSuspend$lambda$0(Ref.LongRef r11, TransformScope r12, AnimationScope r13) {
        TransformScope.CC.m721transformByd4ec7I$default(r12, MenuKt.ClosedAlphaTarget, Offset.minus-MK-Hz9U(((Offset) r13.getValue()).unbox-impl(), r11.element), MenuKt.ClosedAlphaTarget, 5, null);
        r11.element = ((Offset) r13.getValue()).unbox-impl();
        return Unit.INSTANCE;
    }
}
