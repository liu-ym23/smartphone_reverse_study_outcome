package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002\u001a4\u0010\u000b\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002\u001a\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a,\u0010\u0015\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u0014\u0010\u0017\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0000\u001a\u0014\u0010\u0018\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0002\u001a\u001c\u0010\u0019\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\tH\u0002¨\u0006\u001b²\u0006\n\u0010\u001c\u001a\u00020\tX\u008a\u0084\u0002²\u0006\n\u0010\u001d\u001a\u00020\u0001X\u008a\u0084\u0002"}, d2 = {"updateSelectionBoundary", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "info", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "previousSelectionAnchor", "isExpanding", "", "currentRawOffset", "", "isStart", "snapToWordBoundary", "currentLine", "currentOffset", "otherOffset", "crossed", "adjustToBoundaries", "Landroidx/compose/foundation/text/selection/Selection;", "layout", "boundaryFunction", "Landroidx/compose/foundation/text/selection/BoundaryFunction;", "anchorOnBoundary", "slot", "ensureAtLeastOneChar", "expandOneChar", "changeOffset", "newOffset", "foundation_release", "currentRawLine", "anchorSnappedToWordBoundary"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SelectionAdjustmentKt {
    public static /* synthetic */ int a(SelectableInfo r0, int r1) {
        return updateSelectionBoundary$lambda$0(r0, r1);
    }

    public static /* synthetic */ Selection.AnchorInfo b(SelectableInfo r0, int r1, int r2, SelectionLayout r3, Lazy r4) {
        return updateSelectionBoundary$lambda$2(r0, r1, r2, r3, r4);
    }

    private static final int updateSelectionBoundary$lambda$1(Lazy<Integer> r0) {
        return ((Number) r0.getValue()).intValue();
    }

    private static final Selection.AnchorInfo updateSelectionBoundary$lambda$3(Lazy<Selection.AnchorInfo> r0) {
        return (Selection.AnchorInfo) r0.getValue();
    }

    public static final /* synthetic */ Selection access$adjustToBoundaries(SelectionLayout r0, BoundaryFunction r1) {
        return adjustToBoundaries(r0, r1);
    }

    private static final Selection adjustToBoundaries(SelectionLayout r6, BoundaryFunction r7) {
        if (r6.getCrossStatus() != CrossStatus.CROSSED) goto L5;
        boolean r0 = true;
    L7:
        return new Selection(anchorOnBoundary(r6.getStartInfo(), r0, true, r6.getStartSlot(), r7), anchorOnBoundary(r6.getEndInfo(), r0, false, r6.getEndSlot(), r7), r0);
    L5:
        r0 = false;
        goto L7
    }

    public static final Selection ensureAtLeastOneChar(Selection r3, SelectionLayout r4) {
        if (SelectionLayoutKt.isCollapsed(r3, r4) == true) goto L5;
        return r3;
    L5:
        String r0 = r4.getCurrentInfo().getInputText();
        boolean r2 = true;
        if (r4.getSize() <= 1) goto L8;
        return r3;
    L8:
        if (r4.getPreviousSelection() != null) goto L10;
        return r3;
    L10:
        if (r0.length() == 0) goto L13;
        r2 = false;
    L13:
        if (r2 == false) goto L16;
        return r3;
    L16:
        return expandOneChar(r3, r4);
    }

    private static final Selection expandOneChar(Selection r12, SelectionLayout r13) {
        SelectableInfo r0 = r13.getCurrentInfo();
        String r1 = r0.getInputText();
        int r2 = r0.getRawStartHandleOffset();
        int r3 = r1.length();
        if (r2 != 0) goto L8;
        int r4 = StringHelpers_androidKt.findFollowingBreak(r1, 0);
        if (r13.isStartHandle() == false) goto L29;
        return Selection.copy$default(r12, changeOffset(r12.getStart(), r0, r4), null, true, 2, null);
    L29:
        return Selection.copy$default(r12, null, changeOffset(r12.getEnd(), r0, r4), false, 1, null);
    L8:
        if (r2 != r3) goto L13;
        int r5 = StringHelpers_androidKt.findPrecedingBreak(r1, r3);
        if (r13.isStartHandle() == false) goto L31;
        return Selection.copy$default(r12, changeOffset(r12.getStart(), r0, r5), null, false, 2, null);
    L31:
        return Selection.copy$default(r12, null, changeOffset(r12.getEnd(), r0, r5), true, 1, null);
    L13:
        Selection r6 = r13.getPreviousSelection();
        if (r6 != null) goto L16;
    L18:
        boolean r9 = false;
    L20:
        if ((r13.isStartHandle() ^ r9) == false) goto L22;
        int r7 = StringHelpers_androidKt.findPrecedingBreak(r1, r2);
    L24:
        if (r13.isStartHandle() == false) goto L27;
        return Selection.copy$default(r12, changeOffset(r12.getStart(), r0, r7), null, r9, 2, null);
    L27:
        return Selection.copy$default(r12, null, changeOffset(r12.getEnd(), r0, r7), r9, 1, null);
    L22:
        r7 = StringHelpers_androidKt.findFollowingBreak(r1, r2);
        goto L24
    L16:
        if (r6.getHandlesCrossed() != true) goto L18;
        r9 = true;
        goto L20
    }

    private static final int updateSelectionBoundary$lambda$0(SelectableInfo r0, int r1) {
        return r0.getTextLayoutResult().getLineForOffset(r1);
    }

    public static final /* synthetic */ Selection.AnchorInfo access$updateSelectionBoundary(SelectionLayout r0, SelectableInfo r1, Selection.AnchorInfo r2) {
        return updateSelectionBoundary(r0, r1, r2);
    }

    private static final Selection.AnchorInfo changeOffset(Selection.AnchorInfo r7, SelectableInfo r8, int r9) {
        return Selection.AnchorInfo.copy$default(r7, r8.getTextLayoutResult().getBidiRunDirection(r9), r9, 0, 4, null);
    }

    private static final boolean isExpanding(SelectableInfo r4, int r5, boolean r6) {
        if (r4.getRawPreviousHandleOffset() != (-1)) goto L6;
        return true;
    L6:
        if (r5 != r4.getRawPreviousHandleOffset()) goto L9;
        return false;
    L9:
        if (r4.getRawCrossStatus() != CrossStatus.CROSSED) goto L11;
        boolean r0 = true;
    L13:
        if ((r6 ^ r0) == false) goto L18;
        if (r5 < r4.getRawPreviousHandleOffset()) goto L22;
    L20:
        return false;
    L22:
        return true;
    L18:
        if (r5 <= r4.getRawPreviousHandleOffset()) goto L20;
        return true;
    L11:
        r0 = false;
        goto L13
    }

    private static final Selection.AnchorInfo updateSelectionBoundary(final SelectionLayout r10, final SelectableInfo r11, Selection.AnchorInfo r12) {
        if (r10.isStartHandle() == false) goto L5;
        final int r0 = r11.getRawStartHandleOffset();
    L7:
        if (r10.isStartHandle() == false) goto L9;
        int r1 = r10.getStartSlot();
    L11:
        if (r1 != r11.getSlot()) goto L13;
        LazyThreadSafetyMode r7 = LazyThreadSafetyMode.NONE;
        final Lazy r8 = LazyKt.lazy(r7, new q(r11, r0));
        if (r10.isStartHandle() == false) goto L17;
        int r2 = r11.getRawEndHandleOffset();
    L18:
        final int r4 = r2;
        final int r3 = r0;
        Lazy r5 = LazyKt.lazy(r7, new r(r11, r3, r4, r10, r8));
        if (r11.getSelectableId() != r12.getSelectableId()) goto L21;
        int r6 = r11.getRawPreviousHandleOffset();
        if (r0 != r6) goto L25;
        return r12;
    L25:
        int r9 = r11.getTextLayoutResult().getLineForOffset(r6);
        if (updateSelectionBoundary$lambda$1(r8) != r9) goto L28;
        int r13 = r12.getOffset();
        long r14 = r11.getTextLayoutResult().getWordBoundary--jx7JFs(r13);
        if (isExpanding(r11, r0, r10.isStartHandle()) == true) goto L34;
        return r11.anchorForOffset(r0);
    L34:
        if (r13 == TextRange.getStart-impl(r14)) goto L41;
        if (r13 == TextRange.getEnd-impl(r14)) goto L41;
        return r11.anchorForOffset(r0);
    L41:
        return updateSelectionBoundary$lambda$3(r5);
    L28:
        return updateSelectionBoundary$lambda$3(r5);
    L21:
        return updateSelectionBoundary$lambda$3(r5);
    L17:
        r2 = r11.getRawStartHandleOffset();
        goto L18
    L13:
        return r11.anchorForOffset(r0);
    L9:
        r1 = r10.getEndSlot();
        goto L11
    L5:
        r0 = r11.getRawEndHandleOffset();
        goto L7
    }

    private static final Selection.AnchorInfo anchorOnBoundary(SelectableInfo r2, boolean r3, boolean r4, int r5, BoundaryFunction r6) {
        if (r4 == false) goto L4;
        int r0 = r2.getRawStartHandleOffset();
    L6:
        if (r5 != r2.getSlot()) goto L8;
        long r7 = r6.mo1828getBoundaryfzxv0v0(r2, r0);
        if ((r3 ^ r4) == false) goto L12;
        int r8 = TextRange.getStart-impl(r7);
    L14:
        return r2.anchorForOffset(r8);
    L12:
        r8 = TextRange.getEnd-impl(r7);
        goto L14
    L8:
        return r2.anchorForOffset(r0);
    L4:
        r0 = r2.getRawEndHandleOffset();
        goto L6
    }

    private static final Selection.AnchorInfo updateSelectionBoundary$lambda$2(SelectableInfo r6, int r7, int r8, SelectionLayout r9, Lazy r10) {
        int r1 = updateSelectionBoundary$lambda$1(r10);
        boolean r4 = r9.isStartHandle();
        if (r9.getCrossStatus() != CrossStatus.CROSSED) goto L5;
        boolean r5 = true;
    L7:
        return snapToWordBoundary(r6, r1, r7, r8, r4, r5);
    L5:
        r5 = false;
        goto L7
    }

    private static final Selection.AnchorInfo snapToWordBoundary(SelectableInfo r5, int r6, int r7, int r8, boolean r9, boolean r10) {
        long r0 = r5.getTextLayoutResult().getWordBoundary--jx7JFs(r7);
        if (r5.getTextLayoutResult().getLineForOffset(TextRange.getStart-impl(r0)) != r6) goto L6;
        int r2 = TextRange.getStart-impl(r0);
    L10:
        if (r5.getTextLayoutResult().getLineForOffset(TextRange.getEnd-impl(r0)) != r6) goto L13;
        int r11 = TextRange.getEnd-impl(r0);
    L16:
        if (r2 == r8) goto L18;
        if (r11 != r8) goto L23;
        return r5.anchorForOffset(r2);
    L23:
        if ((r9 ^ r10) == false) goto L26;
        if (r7 <= r11) goto L29;
    L27:
        r2 = r11;
    L29:
        return r5.anchorForOffset(r2);
    L26:
        if (r7 < r2) goto L29;
    L18:
        return r5.anchorForOffset(r11);
    L13:
        if (r6 < r5.getTextLayoutResult().getLineCount()) goto L15;
        r11 = TextLayoutResult.getLineEnd$default(r5.getTextLayoutResult(), r5.getTextLayoutResult().getLineCount() - 1, false, 2, null);
        goto L16
    L15:
        r11 = TextLayoutResult.getLineEnd$default(r5.getTextLayoutResult(), r6, false, 2, null);
        goto L16
    L6:
        if (r6 < r5.getTextLayoutResult().getLineCount()) goto L8;
        r2 = r5.getTextLayoutResult().getLineStart(r5.getTextLayoutResult().getLineCount() - 1);
        goto L10
    L8:
        r2 = r5.getTextLayoutResult().getLineStart(r6);
        goto L10
    }
}
