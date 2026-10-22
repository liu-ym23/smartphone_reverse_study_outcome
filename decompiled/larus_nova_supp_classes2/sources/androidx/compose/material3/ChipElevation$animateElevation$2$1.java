package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.material3.internal.ElevationKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.ChipElevation$animateElevation$2$1", f = "Chip.kt", i = {}, l = {2423, 2425}, m = "invokeSuspend", n = {}, s = {})
public final class ChipElevation$animateElevation$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Dp, AnimationVector1D> $animatable;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Interaction $interaction;
    final /* synthetic */ MutableState<Interaction> $lastInteraction$delegate;
    final /* synthetic */ float $target;
    int label;

    public ChipElevation$animateElevation$2$1(Animatable<Dp, AnimationVector1D> r1, float r2, boolean r3, Interaction r4, MutableState<Interaction> r5, Continuation<? super ChipElevation$animateElevation$2$1> r6) {
        this.$animatable = r1;
        this.$target = r2;
        this.$enabled = r3;
        this.$interaction = r4;
        this.$lastInteraction$delegate = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChipElevation$animateElevation$2$1(this.$animatable, this.$target, this.$enabled, this.$interaction, this.$lastInteraction$delegate, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L20:
        ChipElevation.access$animateElevation$lambda$3(this.$lastInteraction$delegate, this.$interaction);
    L22:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r6);
        if (Dp.equals-impl0(this.$animatable.getTargetValue().unbox-impl(), this.$target) == true) goto L22;
        if (this.$enabled == true) goto L17;
        Animatable<Dp, AnimationVector1D> r7 = this.$animatable;
        Dp r2 = Dp.box-impl(this.$target);
        this.label = 1;
        if (r7.snapTo(r2, this) != r0) goto L20;
        return r0;
    L17:
        Interaction r8 = ChipElevation.access$animateElevation$lambda$2(this.$lastInteraction$delegate);
        Animatable<Dp, AnimationVector1D> r3 = this.$animatable;
        float r4 = this.$target;
        Interaction r5 = this.$interaction;
        this.label = 2;
        if (ElevationKt.animateElevation-rAjV9yQ(r3, r4, r8, r5, this) != r0) goto L20;
        return r0;
    }
}
