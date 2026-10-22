package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0007"}, d2 = {"getTextDirectionForOffset", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "Landroidx/compose/ui/text/TextLayoutResult;", "offset", "", "isOffsetAnEmptyLine", "", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SelectionHelpersKt {
    public static final ResolvedTextDirection getTextDirectionForOffset(TextLayoutResult r1, int r2) {
        if (isOffsetAnEmptyLine(r1, r2) == false) goto L6;
        return r1.getParagraphDirection(r2);
    L6:
        return r1.getBidiRunDirection(r2);
    }

    private static final boolean isOffsetAnEmptyLine(TextLayoutResult r4, int r5) {
        if (r4.getLayoutInput().getText().length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L19;
        int r1 = r4.getLineForOffset(r5);
        if (r5 == 0) goto L12;
        if (r1 != r4.getLineForOffset(r5 - 1)) goto L12;
    L16:
        boolean r6 = false;
    L18:
        if (r6 == true) goto L19;
        return false;
    L12:
        if (r5 != r4.getLayoutInput().getText().length()) goto L14;
    L17:
        r6 = true;
        goto L18
    L14:
        if (r1 == r4.getLineForOffset(r5 + 1)) goto L16;
    L19:
        return true;
    L5:
        r0 = false;
        goto L6
    }
}
