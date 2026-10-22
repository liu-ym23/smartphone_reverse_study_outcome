package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.material3.internal.ElevationKt;
import androidx.compose.ui.geometry.Offset;
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
@DebugMetadata(c = "androidx.compose.material3.ButtonElevation$animateElevation$2$1", f = "Button.kt", i = {}, l = {998, 1007}, m = "invokeSuspend", n = {}, s = {})
public final class ButtonElevation$animateElevation$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Dp, AnimationVector1D> $animatable;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Interaction $interaction;
    final /* synthetic */ float $target;
    int label;
    final /* synthetic */ ButtonElevation this$0;

    public ButtonElevation$animateElevation$2$1(Animatable<Dp, AnimationVector1D> r1, float r2, boolean r3, ButtonElevation r4, Interaction r5, Continuation<? super ButtonElevation$animateElevation$2$1> r6) {
        this.$animatable = r1;
        this.$target = r2;
        this.$enabled = r3;
        this.this$0 = r4;
        this.$interaction = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ButtonElevation$animateElevation$2$1(this.$animatable, this.$target, this.$enabled, this.this$0, this.$interaction, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L30:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r7);
        if (Dp.equals-impl0(this.$animatable.getTargetValue().unbox-impl(), this.$target) == true) goto L30;
        if (this.$enabled == true) goto L17;
        Animatable<Dp, AnimationVector1D> r8 = this.$animatable;
        Dp r2 = Dp.box-impl(this.$target);
        this.label = 1;
        if (r8.snapTo(r2, this) != r0) goto L30;
        return r0;
    L17:
        float r9 = this.$animatable.getTargetValue().unbox-impl();
        Interaction r3 = null;
        if (Dp.equals-impl0(r9, ButtonElevation.access$getPressedElevation$p(this.this$0)) == false) goto L21;
        r3 = new PressInteraction.Press(Offset.Companion.getZero-F1C5BW0(), null);
    L26:
        Animatable<Dp, AnimationVector1D> r10 = this.$animatable;
        float r4 = this.$target;
        Interaction r5 = this.$interaction;
        this.label = 2;
        if (ElevationKt.animateElevation-rAjV9yQ(r10, r4, r3, r5, this) != r0) goto L30;
        return r0;
    L21:
        if (Dp.equals-impl0(r9, ButtonElevation.access$getHoveredElevation$p(this.this$0)) == false) goto L24;
        r3 = new HoverInteraction.Enter();
        goto L26
    L24:
        if (Dp.equals-impl0(r9, ButtonElevation.access$getFocusedElevation$p(this.this$0)) == false) goto L26;
        r3 = new FocusInteraction.Focus();
        goto L26
    }
}
