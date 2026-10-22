package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$2", f = "TextFieldDecoratorModifier.kt", i = {}, l = {238}, m = "invokeSuspend", n = {}, s = {})
public final class TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $requestFocus;
    final /* synthetic */ PointerInputScope $this_SuspendingPointerInputModifierNode;
    final /* synthetic */ TextFieldSelectionState $this_with;
    int label;
    final /* synthetic */ TextFieldDecoratorModifierNode this$0;

    public TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$2(TextFieldDecoratorModifierNode r1, TextFieldSelectionState r2, PointerInputScope r3, Function0<Unit> r4, Continuation<? super TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$2> r5) {
        this.this$0 = r1;
        this.$this_with = r2;
        this.$this_SuspendingPointerInputModifierNode = r3;
        this.$requestFocus = r4;
        super(2, r5);
    }

    public static /* synthetic */ Unit a(TextFieldDecoratorModifierNode r0) {
        return invokeSuspend$lambda$0(r0);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$2(this.this$0, this.$this_with, this.$this_SuspendingPointerInputModifierNode, this.$requestFocus, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    private static final Unit invokeSuspend$lambda$0(TextFieldDecoratorModifierNode r1) {
        if (TextFieldDecoratorModifierNode.access$getInputSessionJob$p(r1) == null) goto L5;
        TextFieldDecoratorModifierNode.access$requireKeyboardController(r1).show();
    L7:
        return Unit.INSTANCE;
    L5:
        TextFieldDecoratorModifierNode.access$startInputSession(r1, true);
        goto L7
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        MutableInteractionSource r5 = this.this$0.getInteractionSource();
        TextFieldSelectionState r3 = this.$this_with;
        PointerInputScope r4 = this.$this_SuspendingPointerInputModifierNode;
        Function0<Unit> r6 = this.$requestFocus;
        final TextFieldDecoratorModifierNode r11 = this.this$0;
        Function0<Unit> r7 = new t1(r11);
        this.label = 1;
        if (r3.detectTextFieldTapGestures(r4, r5, r6, r7, this) != r0) goto L12;
        return r0;
    }
}
