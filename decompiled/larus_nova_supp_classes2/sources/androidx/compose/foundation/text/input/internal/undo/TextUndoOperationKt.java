package androidx.compose.foundation.text.input.internal.undo;

import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldBufferKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0006"}, d2 = {"undo", "", "Landroidx/compose/foundation/text/input/TextFieldState;", "op", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "redo", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextUndoOperationKt {
    public static final void redo(TextFieldState r10, TextUndoOperation r11) {
        r10.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r0 = r10.getMainBuffer$foundation_release();
        r0.replace(r11.getIndex(), r11.getIndex() + r11.getPreText().length(), r11.getPostText());
        TextFieldBufferKt.setSelectionCoerced(r0, TextRange.getStart-impl(r11.m1735getPostSelectiond9O1mEE()), TextRange.getEnd-impl(r11.m1735getPostSelectiond9O1mEE()));
        TextFieldCharSequence r12 = TextFieldBuffer.m1524toTextFieldCharSequencewFTz33Y$foundation_release$default(r10.getMainBuffer$foundation_release(), 0, null, null, null, 15, null);
        TextFieldState.access$updateValueAndNotifyListeners(r10, r10.getValue$foundation_release(), r12, true);
    }

    public static final void undo(TextFieldState r10, TextUndoOperation r11) {
        r10.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r0 = r10.getMainBuffer$foundation_release();
        r0.replace(r11.getIndex(), r11.getIndex() + r11.getPostText().length(), r11.getPreText());
        TextFieldBufferKt.setSelectionCoerced(r0, TextRange.getStart-impl(r11.m1736getPreSelectiond9O1mEE()), TextRange.getEnd-impl(r11.m1736getPreSelectiond9O1mEE()));
        TextFieldCharSequence r12 = TextFieldBuffer.m1524toTextFieldCharSequencewFTz33Y$foundation_release$default(r10.getMainBuffer$foundation_release(), 0, null, null, null, 15, null);
        TextFieldState.access$updateValueAndNotifyListeners(r10, r10.getValue$foundation_release(), r12, true);
    }
}
