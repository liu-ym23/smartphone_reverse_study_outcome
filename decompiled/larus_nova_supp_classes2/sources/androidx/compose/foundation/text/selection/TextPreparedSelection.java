package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.OffsetMapping;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/text/selection/TextPreparedSelection;", "Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "originalText", "Landroidx/compose/ui/text/AnnotatedString;", "originalSelection", "Landroidx/compose/ui/text/TextRange;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "state", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextPreparedSelection extends BaseTextPreparedSelection<TextPreparedSelection> {
    public static final int $stable = 8;

    public /* synthetic */ TextPreparedSelection(AnnotatedString r1, long r2, TextLayoutResult r4, OffsetMapping r5, TextPreparedSelectionState r6, DefaultConstructorMarker r7) {
        this(r1, r2, r4, r5, r6);
    }

    private TextPreparedSelection(AnnotatedString r9, long r10, TextLayoutResult r12, OffsetMapping r13, TextPreparedSelectionState r14) {
        super(r9, r10, r12, r13, r14, null);
    }

    public /* synthetic */ TextPreparedSelection(AnnotatedString r10, long r11, TextLayoutResult r13, OffsetMapping r14, TextPreparedSelectionState r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 4) == 0) goto L5;
        TextLayoutResult r5 = null;
    L7:
        if ((r16 & 8) == 0) goto L9;
        OffsetMapping r6 = OffsetMapping.Companion.getIdentity();
    L11:
        if ((r16 & 16) == 0) goto L13;
        TextPreparedSelectionState r7 = new TextPreparedSelectionState();
    L14:
        this(r10, r11, r5, r6, r7, null);
        return;
    L13:
        r7 = r15;
        goto L14
    L9:
        r6 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }
}
