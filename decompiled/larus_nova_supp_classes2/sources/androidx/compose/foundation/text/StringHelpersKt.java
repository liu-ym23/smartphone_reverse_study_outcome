package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0019\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"findParagraphStart", "", "", "startIndex", "findParagraphEnd", "getParagraphBoundary", "Landroidx/compose/ui/text/TextRange;", "index", "(Ljava/lang/CharSequence;I)J", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class StringHelpersKt {
    public static final int findParagraphEnd(CharSequence r3, int r4) {
        int r0 = r3.length();
    L3:
        if (r4 >= r0) goto L9;
        if (r3.charAt(r4) == '\n') goto L6;
        r4 = r4 + 1;
        goto L3
    L6:
        return r4;
    L9:
        return r3.length();
    }

    public static final int findParagraphStart(CharSequence r2, int r3) {
    L2:
        if (r3 <= 0) goto L7;
        if (r2.charAt(r3 - 1) == '\n') goto L5;
        r3 = r3 - 1;
        goto L2
    L5:
        return r3;
    L7:
        return 0;
    }

    public static final long getParagraphBoundary(CharSequence r1, int r2) {
        return TextRangeKt.TextRange(findParagraphStart(r1, r2), findParagraphEnd(r1, r2));
    }
}
