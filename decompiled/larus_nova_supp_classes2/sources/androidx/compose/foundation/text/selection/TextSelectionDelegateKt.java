package androidx.compose.foundation.text.selection;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\t\u001a$\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¨\u0006\f"}, d2 = {"getSelectionHandleCoordinates", "Landroidx/compose/ui/geometry/Offset;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offset", "", "isStart", "", "areHandlesCrossed", "(Landroidx/compose/ui/text/TextLayoutResult;IZZ)J", "getHorizontalPosition", "", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextSelectionDelegateKt {
    public static final float getHorizontalPosition(TextLayoutResult r1, int r2, boolean r3, boolean r4) {
        boolean r0 = false;
        if (r3 == false) goto L5;
        if (r4 == true) goto L5;
    L7:
        int r5 = r2;
    L10:
        if (r1.getBidiRunDirection(r5) != r1.getParagraphDirection(r2)) goto L13;
        r0 = true;
    L13:
        return r1.getHorizontalPosition(r2, r0);
    L5:
        if (r3 == true) goto L8;
        if (r4 == true) goto L7;
    L8:
        r5 = Math.max(r2 - 1, 0);
        goto L10
    }

    public static final long getSelectionHandleCoordinates(TextLayoutResult r6, int r7, boolean r8, boolean r9) {
        int r0 = r6.getLineForOffset(r7);
        if (r0 >= r6.getLineCount()) goto L5;
        float r10 = RangesKt.coerceIn(getHorizontalPosition(r6, r7, r8, r9), MenuKt.ClosedAlphaTarget, (int) (r6.getSize-YbymL2g() >> 32));
        float r11 = RangesKt.coerceIn(r6.getLineBottom(r0), MenuKt.ClosedAlphaTarget, (int) (r6.getSize-YbymL2g() & 4294967295L));
        return Offset.constructor-impl((Float.floatToRawIntBits(r10) << 32) | (Float.floatToRawIntBits(r11) & 4294967295L));
    L5:
        return Offset.Companion.getUnspecified-F1C5BW0();
    }
}
