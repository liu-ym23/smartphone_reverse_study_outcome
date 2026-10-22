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
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.AbstractClickableNode$handlePressInteractionRelease$1$1", f = "Clickable.kt", i = {1}, l = {1676, 1681, 1682}, m = "invokeSuspend", n = {"release"}, s = {"L$0"})
public final class AbstractClickableNode$handlePressInteractionRelease$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $offset;
    Object L$0;
    int label;
    final /* synthetic */ AbstractClickableNode this$0;

    public AbstractClickableNode$handlePressInteractionRelease$1$1(AbstractClickableNode r1, long r2, MutableInteractionSource r4, Continuation<? super AbstractClickableNode$handlePressInteractionRelease$1$1> r5) {
        this.this$0 = r1;
        this.$offset = r2;
        this.$interactionSource = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AbstractClickableNode$handlePressInteractionRelease$1$1(this.this$0, this.$offset, this.$interactionSource, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r8);
    L24:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        PressInteraction.Release r2 = (PressInteraction.Release) this.L$0;
        ResultKt.throwOnFailure(r8);
    L20:
        MutableInteractionSource r9 = this.$interactionSource;
        this.L$0 = null;
        this.label = 3;
        if (r9.emit(r2, this) != r0) goto L24;
        return r0;
    L11:
        ResultKt.throwOnFailure(r8);
    L17:
        PressInteraction.Press r10 = new PressInteraction.Press(this.$offset, null);
        r2 = new PressInteraction.Release(r10);
        MutableInteractionSource r5 = this.$interactionSource;
        this.L$0 = r2;
        this.label = 2;
        if (r5.emit(r10, this) != r0) goto L20;
        return r0;
    L12:
        ResultKt.throwOnFailure(r8);
        Job r11 = AbstractClickableNode.access$getDelayJob$p(this.this$0);
        if (r11 == null) goto L17;
        this.label = 1;
        if (JobKt.cancelAndJoin(r11, this) != r0) goto L17;
        return r0;
    }
}
