package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.Interaction;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.AbstractClickableNode$handlePressInteraction$2$1", f = "Clickable.kt", i = {0, 1, 2}, l = {1725, 1727, 1734, 1735, 1745}, m = "invokeSuspend", n = {"delayJob", "success", "release"}, s = {"L$0", "Z$0", "L$0"})
public final class AbstractClickableNode$handlePressInteraction$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $offset;
    final /* synthetic */ PressGestureScope $this_handlePressInteraction;
    private /* synthetic */ Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ AbstractClickableNode this$0;

    public AbstractClickableNode$handlePressInteraction$2$1(PressGestureScope r1, long r2, MutableInteractionSource r4, AbstractClickableNode r5, Continuation<? super AbstractClickableNode$handlePressInteraction$2$1> r6) {
        this.$this_handlePressInteraction = r1;
        this.$offset = r2;
        this.$interactionSource = r4;
        this.this$0 = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        AbstractClickableNode$handlePressInteraction$2$1 r7 = new AbstractClickableNode$handlePressInteraction$2$1(this.$this_handlePressInteraction, this.$offset, this.$interactionSource, this.this$0, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L14;
        if (r2 == 3) goto L13;
        if (r2 == 4) goto L12;
        if (r2 == 5) goto L12;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r19);
    L42:
        AbstractClickableNode.access$setPressInteraction$p(this.this$0, null);
        return Unit.INSTANCE;
    L13:
        PressInteraction.Release r3 = (PressInteraction.Release) this.L$0;
        ResultKt.throwOnFailure(r19);
    L30:
        MutableInteractionSource r4 = this.$interactionSource;
        this.L$0 = null;
        this.label = 4;
        if (r4.emit(r3, this) != r1) goto L42;
        return r1;
    L14:
        boolean r5 = this.Z$0;
        ResultKt.throwOnFailure(r19);
    L25:
        if (r5 == false) goto L42;
        PressInteraction.Press r6 = new PressInteraction.Press(this.$offset, null);
        PressInteraction.Release r7 = new PressInteraction.Release(r6);
        MutableInteractionSource r8 = this.$interactionSource;
        this.L$0 = r7;
        this.label = 3;
        if (r8.emit(r6, this) != r1) goto L29;
        return r1;
    L29:
        r3 = r7;
        goto L30
    L15:
        Job r9 = (Job) this.L$0;
        ResultKt.throwOnFailure(r19);
        Object r10 = r19;
    L19:
        boolean r11 = ((Boolean) r10).booleanValue();
        if (r9.isActive() == false) goto L33;
        this.L$0 = null;
        this.Z$0 = r11;
        this.label = 2;
        if (JobKt.cancelAndJoin(r9, this) != r1) goto L24;
        return r1;
    L24:
        r5 = r11;
        goto L25
    L33:
        PressInteraction.Press r12 = AbstractClickableNode.access$getPressInteraction$p(this.this$0);
        if (r12 == null) goto L42;
        MutableInteractionSource r13 = this.$interactionSource;
        if (r11 == false) goto L38;
        Interaction r14 = new PressInteraction.Release(r12);
    L39:
        this.L$0 = null;
        this.label = 5;
        if (r13.emit(r14, this) != r1) goto L42;
        return r1;
    L38:
        r14 = new PressInteraction.Cancel(r12);
        goto L39
    L16:
        ResultKt.throwOnFailure(r19);
        r9 = BuildersKt.launch$default((CoroutineScope) this.L$0, null, null, new AbstractClickableNode$handlePressInteraction$2$1$delayJob$1(this.this$0, this.$offset, this.$interactionSource, null), 3, null);
        PressGestureScope r15 = this.$this_handlePressInteraction;
        this.L$0 = r9;
        this.label = 1;
        r10 = r15.tryAwaitRelease(this);
        if (r10 != r1) goto L19;
        return r1;
    }
}
