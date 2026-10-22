package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
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
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$clipboardKeyCommandsHandler$1$1", f = "TextFieldDecoratorModifier.kt", i = {}, l = {382, 383, 384}, m = "invokeSuspend", n = {}, s = {})
public final class TextFieldDecoratorModifierNode$clipboardKeyCommandsHandler$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ KeyCommand $keyCommand;
    int label;
    final /* synthetic */ TextFieldDecoratorModifierNode this$0;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[KeyCommand.values().length];
            r0[KeyCommand.COPY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[KeyCommand.CUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[KeyCommand.PASTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public TextFieldDecoratorModifierNode$clipboardKeyCommandsHandler$1$1(KeyCommand r1, TextFieldDecoratorModifierNode r2, Continuation<? super TextFieldDecoratorModifierNode$clipboardKeyCommandsHandler$1$1> r3) {
        this.$keyCommand = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new TextFieldDecoratorModifierNode$clipboardKeyCommandsHandler$1$1(this.$keyCommand, this.this$0, r4);
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
        if (r1 == 1) goto L7;
        if (r1 == 2) goto L7;
        if (r1 == 3) goto L7;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        ResultKt.throwOnFailure(r6);
    L25:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r6);
        KeyCommand r7 = this.$keyCommand;
        int r8 = WhenMappings.$EnumSwitchMapping$0[r7.ordinal()];
        if (r8 == 1) goto L21;
        if (r8 == 2) goto L18;
        if (r8 != 3) goto L25;
        TextFieldSelectionState r9 = this.this$0.getTextFieldSelectionState();
        this.label = 3;
        if (r9.paste(this) != r0) goto L25;
        return r0;
    L18:
        TextFieldSelectionState r10 = this.this$0.getTextFieldSelectionState();
        this.label = 2;
        if (r10.cut(this) != r0) goto L25;
        return r0;
    L21:
        TextFieldSelectionState r11 = this.this$0.getTextFieldSelectionState();
        this.label = 1;
        if (r11.copy(false, this) != r0) goto L25;
        return r0;
    }
}
