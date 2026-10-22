package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.internal.ClipboardUtils_androidKt;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValueKt;
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
@DebugMetadata(c = "androidx.compose.foundation.text.selection.TextFieldSelectionManager$paste$1", f = "TextFieldSelectionManager.kt", i = {}, l = {841, 841}, m = "invokeSuspend", n = {}, s = {})
public final class TextFieldSelectionManager$paste$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TextFieldSelectionManager this$0;

    public TextFieldSelectionManager$paste$1(TextFieldSelectionManager r1, Continuation<? super TextFieldSelectionManager$paste$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new TextFieldSelectionManager$paste$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r5);
    L20:
        AnnotatedString r6 = (AnnotatedString) r5;
        if (r6 == null) goto L29;
        AnnotatedString r2 = TextFieldValueKt.getTextBeforeSelection(this.this$0.getValue$foundation_release(), this.this$0.getValue$foundation_release().getText().length()).plus(r6).plus(TextFieldValueKt.getTextAfterSelection(this.this$0.getValue$foundation_release(), this.this$0.getValue$foundation_release().getText().length()));
        int r3 = TextRange.getMin-impl(this.this$0.getValue$foundation_release().getSelection-d9O1mEE()) + r6.length();
        TextFieldValue r7 = TextFieldSelectionManager.m1891access$createTextFieldValueFDrldGo(this.this$0, r2, TextRangeKt.TextRange(r3, r3));
        this.this$0.getOnValueChange$foundation_release().invoke(r7);
        this.this$0.m1907setLatestSelectionOEnZFl4$foundation_release(TextRange.box-impl(r7.getSelection-d9O1mEE()));
        TextFieldSelectionManager.access$setHandleState(this.this$0, HandleState.None);
        UndoManager r8 = this.this$0.getUndoManager();
        if (r8 == null) goto L27;
        r8.forceNextSnapshot();
    L27:
        return Unit.INSTANCE;
    L29:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L15:
        ClipEntry r9 = (ClipEntry) r5;
        if (r9 == null) goto L29;
        this.label = 2;
        r5 = ClipboardUtils_androidKt.readAnnotatedString(r9, this);
        if (r5 != r0) goto L20;
        return r0;
    L10:
        ResultKt.throwOnFailure(r5);
        Clipboard r10 = this.this$0.getClipboard$foundation_release();
        if (r10 == null) goto L29;
        this.label = 1;
        r5 = r10.getClipEntry(this);
        if (r5 != r0) goto L15;
        return r0;
    }
}
