package androidx.compose.foundation.text.selection;

import androidx.collection.SieveCacheKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.Comparator;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a4\u0010\f\u001a\u00020\r*\u00020\u000e2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0010j\b\u0012\u0004\u0012\u00020\t`\u00112\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\rH\u0002\u001a\u001f\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001f\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001c\u0010\u001a\u001a\u001c\u0010\u001d\u001a\u00020\u0015*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0002\u001a\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0002\u001a\u001f\u0010#\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0004\b$\u0010%¨\u0006&"}, d2 = {"appendSelectableInfo", "", "Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "localPosition", "Landroidx/compose/ui/geometry/Offset;", "previousHandlePosition", "selectableId", "", "appendSelectableInfo-Parwq6A", "(Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;Landroidx/compose/ui/text/TextLayoutResult;JJJ)V", "getPreviousAdjustedOffset", "", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "selectableIdOrderingComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "currentSelectableId", "currentTextLength", "getXDirection", "Landroidx/compose/foundation/text/selection/Direction;", "position", "bounds", "Landroidx/compose/ui/geometry/Rect;", "getXDirection-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)Landroidx/compose/foundation/text/selection/Direction;", "getYDirection", "getYDirection-3MmeM6k", "getDirectionById", "anchorSelectableId", "isSelected", "", "currentDirection", "otherDirection", "getOffsetForPosition", "getOffsetForPosition-3MmeM6k", "(JLandroidx/compose/ui/text/TextLayoutResult;)I", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MultiWidgetSelectionDelegateKt {
    /* JADX INFO: renamed from: getOffsetForPosition-3MmeM6k, reason: not valid java name */
    private static final int m1833getOffsetForPosition3MmeM6k(long r3, TextLayoutResult r5) {
        int r1 = (int) (4294967295L & r3);
        if (Float.intBitsToFloat(r1) > MenuKt.ClosedAlphaTarget) goto L6;
        return 0;
    L6:
        if (Float.intBitsToFloat(r1) < r5.getMultiParagraph().getHeight()) goto L9;
        return r5.getLayoutInput().getText().length();
    L9:
        return r5.getOffsetForPosition-k-4lQ0M(r3);
    }

    /* JADX INFO: renamed from: getXDirection-3MmeM6k, reason: not valid java name */
    private static final Direction m1834getXDirection3MmeM6k(long r1, Rect r3) {
        int r2 = (int) (r1 >> 32);
        if (Float.intBitsToFloat(r2) >= r3.getLeft()) goto L6;
        return Direction.BEFORE;
    L6:
        if (Float.intBitsToFloat(r2) <= r3.getRight()) goto L9;
        return Direction.AFTER;
    L9:
        return Direction.ON;
    }

    /* JADX INFO: renamed from: getYDirection-3MmeM6k, reason: not valid java name */
    private static final Direction m1835getYDirection3MmeM6k(long r2, Rect r4) {
        int r3 = (int) (r2 & 4294967295L);
        if (Float.intBitsToFloat(r3) >= r4.getTop()) goto L6;
        return Direction.BEFORE;
    L6:
        if (Float.intBitsToFloat(r3) <= r4.getBottom()) goto L9;
        return Direction.AFTER;
    L9:
        return Direction.ON;
    }

    private static final boolean isSelected(Direction r1, Direction r2) {
        if (r1 == Direction.ON) goto L7;
        if (r1 != r2) goto L7;
        return false;
    L7:
        return true;
    }

    private static final Direction getDirectionById(SelectionLayoutBuilder r0, long r1, long r3) {
        int r2 = r0.getSelectableIdOrderingComparator().compare(Long.valueOf(r1), Long.valueOf(r3));
        if (r2 < 0) goto L9;
        if (r2 <= 0) goto L8;
        return Direction.AFTER;
    L8:
        return Direction.ON;
    L9:
        return Direction.BEFORE;
    }

    private static final int getPreviousAdjustedOffset(Selection.AnchorInfo r2, Comparator<Long> r3, long r4, int r6) {
        int r5 = r3.compare(Long.valueOf(r2.getSelectableId()), Long.valueOf(r4));
        if (r5 >= 0) goto L5;
        return 0;
    L5:
        if (r5 <= 0) goto L8;
        return r6;
    L8:
        return r2.getOffset();
    }

    /* JADX INFO: renamed from: appendSelectableInfo-Parwq6A, reason: not valid java name */
    public static final void m1832appendSelectableInfoParwq6A(SelectionLayoutBuilder r16, TextLayoutResult r17, long r18, long r20, long r22) {
        Rect r4 = new Rect(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, (int) (r17.getSize-YbymL2g() >> 32), (int) (r17.getSize-YbymL2g() & 4294967295L));
        Direction r13 = m1834getXDirection3MmeM6k(r18, r4);
        Direction r14 = m1835getYDirection3MmeM6k(r18, r4);
        if (r16.isStartHandle() == false) goto L9;
        Selection r5 = r16.getPreviousSelection();
        if (r5 == null) goto L7;
        Selection.AnchorInfo r9 = r5.getEnd();
    L8:
        Direction r6 = appendSelectableInfo_Parwq6A$otherDirection(r13, r14, r16, r22, r9);
        Direction r7 = r6;
        Direction r8 = r7;
        Direction r10 = r13;
        Direction r11 = r14;
    L15:
        if (isSelected(SelectionLayoutKt.resolve2dDirection(r13, r14), r6) == true) goto L17;
        return;
    L17:
        int r12 = r17.getLayoutInput().getText().length();
        if (r16.isStartHandle() == false) goto L26;
        int r0 = m1833getOffsetForPosition3MmeM6k(r18, r17);
        Selection r1 = r16.getPreviousSelection();
        if (r1 == null) goto L24;
        Selection.AnchorInfo r2 = r1.getEnd();
        if (r2 == null) goto L24;
        int r3 = getPreviousAdjustedOffset(r2, r16.getSelectableIdOrderingComparator(), r22, r12);
    L25:
        int r15 = r0;
        int r19 = r3;
    L34:
        if ((SieveCacheKt.InvalidMapping & r20) != 9205357640488583168L) goto L36;
        boolean r21 = true;
    L37:
        if (r21 == false) goto L39;
        int r110 = -1;
    L40:
        r16.appendInfo(r22, r15, r10, r11, r19, r7, r8, r110, r17);
        return;
    L39:
        r110 = m1833getOffsetForPosition3MmeM6k(r20, r17);
        goto L40
    L36:
        r21 = false;
    L24:
        r3 = r0;
        goto L25
    L26:
        int r23 = m1833getOffsetForPosition3MmeM6k(r18, r17);
        Selection r24 = r16.getPreviousSelection();
        if (r24 == null) goto L31;
        Selection.AnchorInfo r25 = r24.getStart();
        if (r25 == null) goto L31;
        int r26 = getPreviousAdjustedOffset(r25, r16.getSelectableIdOrderingComparator(), r22, r12);
    L32:
        r19 = r23;
        r15 = r26;
    L31:
        r26 = r23;
        goto L32
    L7:
        r9 = null;
        goto L8
    L9:
        Selection r27 = r16.getPreviousSelection();
        if (r27 == null) goto L12;
        Selection.AnchorInfo r28 = r27.getStart();
    L13:
        r6 = appendSelectableInfo_Parwq6A$otherDirection(r13, r14, r16, r22, r28);
        r10 = r6;
        r11 = r10;
        r7 = r13;
        r8 = r14;
        goto L15
    L12:
        r28 = null;
        goto L13
    }

    private static final Direction appendSelectableInfo_Parwq6A$otherDirection(Direction r2, Direction r3, SelectionLayoutBuilder r4, long r5, Selection.AnchorInfo r7) {
        if (r7 == null) goto L6;
        Direction r6 = getDirectionById(r4, r7.getSelectableId(), r5);
        if (r6 == null) goto L6;
        return r6;
    L6:
        return SelectionLayoutKt.resolve2dDirection(r2, r3);
    }
}
