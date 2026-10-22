package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\n\u001a/\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\"\u0018\u0010\u0013\u001a\u00020\u0004*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"finalConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxIntrinsicWidth", "", "finalConstraints-tfFHcEY", "(JZIF)J", "finalMaxWidth", "", "finalMaxWidth-tfFHcEY", "(JZIF)I", "finalMaxLines", "maxLinesIn", "finalMaxLines-xdlQI24", "(ZII)I", "isEllipsis", "isEllipsis-MW5-ApA", "(I)Z", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LayoutUtilsKt {
    /* JADX INFO: renamed from: isEllipsis-MW5-ApA, reason: not valid java name */
    public static final boolean m1765isEllipsisMW5ApA(int r2) {
        TextOverflow.Companion r0 = TextOverflow.Companion;
        if (TextOverflow.equals-impl0(r2, r0.getEllipsis-gIe3tQ8()) == false) goto L5;
    L10:
        return true;
    L5:
        if (TextOverflow.equals-impl0(r2, r0.getStartEllipsis-gIe3tQ8()) == true) goto L10;
        if (TextOverflow.equals-impl0(r2, r0.getMiddleEllipsis-gIe3tQ8()) == true) goto L10;
        return false;
    }

    /* JADX INFO: renamed from: finalMaxLines-xdlQI24, reason: not valid java name */
    public static final int m1763finalMaxLinesxdlQI24(boolean r1, int r2, int r3) {
        if (r1 == false) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L11;
        return 1;
    L11:
        return RangesKt.coerceAtLeast(r3, 1);
    L5:
        if (m1765isEllipsisMW5ApA(r2) == false) goto L7;
        r4 = true;
        goto L8
    }

    /* JADX INFO: renamed from: finalConstraints-tfFHcEY, reason: not valid java name */
    public static final long m1762finalConstraintstfFHcEY(long r1, boolean r3, int r4, float r5) {
        return Constraints.Companion.fitPrioritizingWidth-Zbe2FdA(0, m1764finalMaxWidthtfFHcEY(r1, r3, r4, r5), 0, Constraints.getMaxHeight-impl(r1));
    }

    /* JADX INFO: renamed from: finalMaxWidth-tfFHcEY, reason: not valid java name */
    public static final int m1764finalMaxWidthtfFHcEY(long r0, boolean r2, int r3, float r4) {
        if (r2 == false) goto L4;
    L7:
        boolean r5 = true;
    L8:
        if (r5 == true) goto L10;
    L12:
        int r6 = Integer.MAX_VALUE;
    L14:
        if (Constraints.getMinWidth-impl(r0) != r6) goto L17;
        return r6;
    L17:
        return RangesKt.coerceIn(TextDelegateKt.ceilToIntPx(r4), Constraints.getMinWidth-impl(r0), r6);
    L10:
        if (Constraints.getHasBoundedWidth-impl(r0) == false) goto L12;
        r6 = Constraints.getMaxWidth-impl(r0);
        goto L14
    L4:
        if (m1765isEllipsisMW5ApA(r3) == true) goto L7;
        r5 = false;
        goto L8
    }
}
