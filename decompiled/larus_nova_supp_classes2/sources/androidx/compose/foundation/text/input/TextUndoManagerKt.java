package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.UndoManagerKt;
import androidx.compose.foundation.text.input.internal.undo.TextDeleteType;
import androidx.compose.foundation.text.input.internal.undo.TextEditType;
import androidx.compose.foundation.text.input.internal.undo.TextUndoOperation;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a.\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0000\"\u0018\u0010\r\u001a\u00020\f*\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"merge", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "next", "recordChanges", "", "Landroidx/compose/foundation/text/input/TextUndoManager;", "pre", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "post", "changes", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "allowMerge", "", "isNewLineInsert", "(Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;)Z", "TEXT_UNDO_CAPACITY", "", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextUndoManagerKt {
    private static final int TEXT_UNDO_CAPACITY = 100;

    private static final boolean isNewLineInsert(TextUndoOperation r2) {
        if (Intrinsics.areEqual(r2.getPostText(), "\n") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r2.getPostText(), "\r\n") == true) goto L8;
        return false;
    }

    public static final TextUndoOperation merge(TextUndoOperation r16, TextUndoOperation r17) {
        if (r16.getCanMerge() == true) goto L5;
    L42:
        return null;
    L5:
        if (r17.getCanMerge() == false) goto L42;
        if (r17.getTimeInMillis() < r16.getTimeInMillis()) goto L42;
        if ((r17.getTimeInMillis() - r16.getTimeInMillis()) >= UndoManagerKt.getSNAPSHOTS_INTERVAL_MILLIS()) goto L42;
        if (isNewLineInsert(r16) == true) goto L42;
        if (isNewLineInsert(r17) == true) goto L42;
        if (r16.getTextEditType() == r17.getTextEditType()) goto L21;
        return null;
    L21:
        if (r16.getTextEditType() != TextEditType.Insert) goto L27;
        if ((r16.getIndex() + r16.getPostText().length()) != r17.getIndex()) goto L27;
        return new TextUndoOperation(r16.getIndex(), "", r16.getPostText() + r17.getPostText(), r16.m1736getPreSelectiond9O1mEE(), r17.m1735getPostSelectiond9O1mEE(), r16.getTimeInMillis(), false, 64, null);
    L27:
        if (r16.getTextEditType() != TextEditType.Delete) goto L42;
        if (r16.getDeletionType() != r17.getDeletionType()) goto L42;
        if (r16.getDeletionType() == TextDeleteType.Start) goto L35;
        if (r16.getDeletionType() != TextDeleteType.End) goto L42;
    L35:
        if (r16.getIndex() != (r17.getIndex() + r17.getPreText().length())) goto L39;
        return new TextUndoOperation(r17.getIndex(), r17.getPreText() + r16.getPreText(), "", r16.m1736getPreSelectiond9O1mEE(), r17.m1735getPostSelectiond9O1mEE(), r16.getTimeInMillis(), false, 64, null);
    L39:
        if (r16.getIndex() != r17.getIndex()) goto L42;
        return new TextUndoOperation(r16.getIndex(), r16.getPreText() + r17.getPreText(), "", r16.m1736getPreSelectiond9O1mEE(), r17.m1735getPostSelectiond9O1mEE(), r16.getTimeInMillis(), false, 64, null);
    }

    public static final void recordChanges(TextUndoManager r19, TextFieldCharSequence r20, TextFieldCharSequence r21, TextFieldBuffer.ChangeList r22, boolean r23) {
        if (r22.getChangeCount() <= 1) goto L6;
        r19.record(new TextUndoOperation(0, r20.toString(), r21.toString(), r20.m1535getSelectiond9O1mEE(), r21.m1535getSelectiond9O1mEE(), 0, false, 32, null));
        return;
    L6:
        if (r22.getChangeCount() != 1) goto L14;
        long r3 = r22.mo1531getOriginalRangejx7JFs(0);
        long r1 = r22.mo1532getRangejx7JFs(0);
        if (TextRange.getCollapsed-impl(r3) == true) goto L10;
    L11:
        r19.record(new TextUndoOperation(TextRange.getMin-impl(r3), TextRangeKt.substring-FDrldGo(r20, r3), TextRangeKt.substring-FDrldGo(r21, r1), r20.m1535getSelectiond9O1mEE(), r21.m1535getSelectiond9O1mEE(), 0, r23, 32, null));
        return;
    L10:
        if (TextRange.getCollapsed-impl(r1) == false) goto L11;
        return;
    }

    public static /* synthetic */ void recordChanges$default(TextUndoManager r0, TextFieldCharSequence r1, TextFieldCharSequence r2, TextFieldBuffer.ChangeList r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = true;
    L5:
        recordChanges(r0, r1, r2, r3, r4);
    }
}
