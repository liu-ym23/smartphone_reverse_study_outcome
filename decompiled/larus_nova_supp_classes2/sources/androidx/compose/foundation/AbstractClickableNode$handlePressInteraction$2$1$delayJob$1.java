package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.AbstractClickableNode$handlePressInteraction$2$1$delayJob$1", f = "Clickable.kt", i = {1}, l = {1719, 1722}, m = "invokeSuspend", n = {"press"}, s = {"L$0"})
public final class AbstractClickableNode$handlePressInteraction$2$1$delayJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $offset;
    Object L$0;
    int label;
    final /* synthetic */ AbstractClickableNode this$0;

    public AbstractClickableNode$handlePressInteraction$2$1$delayJob$1(AbstractClickableNode r1, long r2, MutableInteractionSource r4, Continuation<? super AbstractClickableNode$handlePressInteraction$2$1$delayJob$1> r5) {
        this.this$0 = r1;
        this.$offset = r2;
        this.$interactionSource = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AbstractClickableNode$handlePressInteraction$2$1$delayJob$1(this.this$0, this.$offset, this.$interactionSource, r8);
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
        if (r1 != 2) goto L8;
        PressInteraction.Press r2 = (PressInteraction.Press) this.L$0;
        ResultKt.throwOnFailure(r7);
    L19:
        AbstractClickableNode.access$setPressInteraction$p(this.this$0, r2);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L15:
        PressInteraction.Press r8 = new PressInteraction.Press(this.$offset, null);
        MutableInteractionSource r3 = this.$interactionSource;
        this.L$0 = r8;
        this.label = 2;
        if (r3.emit(r8, this) != r0) goto L18;
        return r0;
    L18:
        r2 = r8;
        goto L19
    L10:
        ResultKt.throwOnFailure(r7);
        if (AbstractClickableNode.access$delayPressInteraction(this.this$0) == false) goto L15;
        long r4 = Clickable_androidKt.getTapIndicationDelay();
        this.label = 1;
        if (DelayKt.delay(r4, this) != r0) goto L15;
        return r0;
    }
}
