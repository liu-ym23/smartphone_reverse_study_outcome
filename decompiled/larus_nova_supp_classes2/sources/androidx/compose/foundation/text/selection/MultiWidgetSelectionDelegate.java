package androidx.compose.foundation.text.selection;

import androidx.collection.SieveCacheKt;
import androidx.compose.foundation.text.TextLayoutHelperKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001f\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\n\u0010$\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010%\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0013H\u0016J\u0010\u0010+\u001a\u00020,2\u0006\u0010*\u001a\u00020\u0013H\u0016J\u0010\u0010-\u001a\u00020,2\u0006\u0010*\u001a\u00020\u0013H\u0016J\u0010\u0010.\u001a\u00020,2\u0006\u0010*\u001a\u00020\u0013H\u0016J\u0017\u0010/\u001a\u0002002\u0006\u0010*\u001a\u00020\u0013H\u0016¢\u0006\u0004\b1\u00102J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u0010\u00103\u001a\u00020,2\u0006\u0010*\u001a\u00020\u0013H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00060\u000ej\u0002`\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\u00020\u0013*\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u00064"}, d2 = {"Landroidx/compose/foundation/text/selection/MultiWidgetSelectionDelegate;", "Landroidx/compose/foundation/text/selection/Selectable;", "selectableId", "", "coordinatesCallback", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutResultCallback", "Landroidx/compose/ui/text/TextLayoutResult;", "<init>", "(JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getSelectableId", "()J", "lock", "", "Landroidx/compose/foundation/platform/SynchronizedObject;", "Ljava/lang/Object;", "_previousTextLayoutResult", "_previousLastVisibleOffset", "", "lastVisibleOffset", "getLastVisibleOffset", "(Landroidx/compose/ui/text/TextLayoutResult;)I", "appendSelectableInfoToBuilder", "", "builder", "Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;", "getSelectAllSelection", "Landroidx/compose/foundation/text/selection/Selection;", "getHandlePosition", "Landroidx/compose/ui/geometry/Offset;", "selection", "isStartHandle", "", "getHandlePosition-dBAh8RU", "(Landroidx/compose/foundation/text/selection/Selection;Z)J", "getLayoutCoordinates", "textLayoutResult", "getText", "Landroidx/compose/ui/text/AnnotatedString;", "getBoundingBox", "Landroidx/compose/ui/geometry/Rect;", "offset", "getLineLeft", "", "getLineRight", "getCenterYForOffset", "getRangeOfLineContaining", "Landroidx/compose/ui/text/TextRange;", "getRangeOfLineContaining--jx7JFs", "(I)J", "getLineHeight", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MultiWidgetSelectionDelegate implements Selectable {
    public static final int $stable = 8;
    private int _previousLastVisibleOffset;
    private TextLayoutResult _previousTextLayoutResult;
    private final Function0<LayoutCoordinates> coordinatesCallback;
    private final Function0<TextLayoutResult> layoutResultCallback;
    private final Object lock;
    private final long selectableId;

    @Override // androidx.compose.foundation.text.selection.Selectable
    public int getLastVisibleOffset() {
        TextLayoutResult r0 = (TextLayoutResult) this.layoutResultCallback.invoke();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return getLastVisibleOffset(r0);
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates r0 = (LayoutCoordinates) this.coordinatesCallback.invoke();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isAttached() == false) goto L10;
        return r0;
    L10:
        return null;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public Selection getSelectAllSelection() {
        TextLayoutResult r0 = (TextLayoutResult) this.layoutResultCallback.invoke();
        if (r0 != null) goto L6;
        return null;
    L6:
        int r1 = r0.getLayoutInput().getText().length();
        return new Selection(new Selection.AnchorInfo(r0.getBidiRunDirection(0), 0, getSelectableId()), new Selection.AnchorInfo(r0.getBidiRunDirection(Math.max(r1 - 1, 0)), r1, getSelectableId()), false);
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public AnnotatedString getText() {
        TextLayoutResult r0 = (TextLayoutResult) this.layoutResultCallback.invoke();
        if (r0 != null) goto L7;
        return new AnnotatedString("", null, 2, null);
    L7:
        return r0.getLayoutInput().getText();
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public TextLayoutResult textLayoutResult() {
        return (TextLayoutResult) this.layoutResultCallback.invoke();
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public long getSelectableId() {
        return this.selectableId;
    }

    private final int getLastVisibleOffset(TextLayoutResult r10) {
        Object r0 = this.lock;
        monitor-enter(r0);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (this._previousTextLayoutResult != r10) goto L7;
    L19:
        int r11 = this._previousLastVisibleOffset;     // Catch: Throwable -> L22
        monitor-exit(r0);
        return r11;
    L7:
        if (r10.getDidOverflowHeight() == true) goto L9;
    L17:
        int r1 = r10.getLineCount() - 1;     // Catch: Throwable -> L22
    L18:
        this._previousLastVisibleOffset = r10.getLineEnd(r1, true);     // Catch: Throwable -> L22
        this._previousTextLayoutResult = r10;     // Catch: Throwable -> L22
        goto L19
    L9:
        if (r10.getMultiParagraph().getDidExceedMaxLines() == true) goto L17;
        int r2 = RangesKt.coerceAtMost(r10.getLineForVerticalPosition((int) (r10.getSize-YbymL2g() & 4294967295L)), r10.getLineCount() - 1);     // Catch: Throwable -> L22
    L12:
        if (r2 < 0) goto L16;
        if (r10.getLineTop(r2) < ((int) (r10.getSize-YbymL2g() & 4294967295L))) goto L16;
        r2 = r2 - 1;     // Catch: Throwable -> L22
    L16:
        r1 = RangesKt.coerceAtLeast(r2, 0);     // Catch: Throwable -> L22
        goto L18
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public void appendSelectableInfoToBuilder(SelectionLayoutBuilder r12) {
        LayoutCoordinates r0 = getLayoutCoordinates();
        if (r0 != null) goto L5;
        return;
    L5:
        TextLayoutResult r3 = (TextLayoutResult) this.layoutResultCallback.invoke();
        if (r3 != null) goto L8;
        return;
    L8:
        LayoutCoordinates r1 = r12.getContainerCoordinates();
        Offset.Companion r2 = Offset.Companion;
        long r4 = r1.localPositionOf-R5De75A(r0, r2.getZero-F1C5BW0());
        long r5 = Offset.minus-MK-Hz9U(r12.m1851getCurrentPositionF1C5BW0(), r4);
        if ((r12.m1852getPreviousHandlePositionF1C5BW0() & SieveCacheKt.InvalidMapping) != 9205357640488583168L) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == false) goto L14;
        long r7 = r2.getUnspecified-F1C5BW0();
    L15:
        MultiWidgetSelectionDelegateKt.m1832appendSelectableInfoParwq6A(r12, r3, r5, r7, getSelectableId());
        return;
    L14:
        r7 = Offset.minus-MK-Hz9U(r12.m1852getPreviousHandlePositionF1C5BW0(), r4);
        goto L15
    L11:
        r6 = false;
        goto L12
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public Rect getBoundingBox(int r5) {
        TextLayoutResult r0 = (TextLayoutResult) this.layoutResultCallback.invoke();
        if (r0 == null) goto L5;
        int r1 = r0.getLayoutInput().getText().length();
        if (r1 >= 1) goto L11;
        return Rect.Companion.getZero();
    L11:
        return r0.getBoundingBox(RangesKt.coerceIn(r5, 0, r1 - 1));
    L5:
        return Rect.Companion.getZero();
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public float getCenterYForOffset(int r4) {
        TextLayoutResult r0 = (TextLayoutResult) this.layoutResultCallback.invoke();
        if (r0 != null) goto L5;
        return -1.0f;
    L5:
        int r5 = r0.getLineForOffset(r4);
        if (r5 < r0.getLineCount()) goto L8;
        return -1.0f;
    L8:
        float r1 = r0.getLineTop(r5);
        return ((r0.getLineBottom(r5) - r1) / 2) + r1;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public float getLineHeight(int r2) {
        TextLayoutResult r0 = (TextLayoutResult) this.layoutResultCallback.invoke();
        if (r0 != null) goto L7;
        return MenuKt.ClosedAlphaTarget;
    L7:
        return TextLayoutHelperKt.getLineHeight(r0, r2);
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public float getLineLeft(int r4) {
        TextLayoutResult r0 = (TextLayoutResult) this.layoutResultCallback.invoke();
        if (r0 != null) goto L5;
        return -1.0f;
    L5:
        int r5 = r0.getLineForOffset(r4);
        if (r5 < r0.getLineCount()) goto L9;
        return -1.0f;
    L9:
        return r0.getLineLeft(r5);
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public float getLineRight(int r4) {
        TextLayoutResult r0 = (TextLayoutResult) this.layoutResultCallback.invoke();
        if (r0 != null) goto L5;
        return -1.0f;
    L5:
        int r5 = r0.getLineForOffset(r4);
        if (r5 < r0.getLineCount()) goto L9;
        return -1.0f;
    L9:
        return r0.getLineRight(r5);
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    /* JADX INFO: renamed from: getRangeOfLineContaining--jx7JFs, reason: not valid java name */
    public long mo1831getRangeOfLineContainingjx7JFs(int r5) {
        TextLayoutResult r0 = (TextLayoutResult) this.layoutResultCallback.invoke();
        if (r0 == null) goto L5;
        int r1 = getLastVisibleOffset(r0);
        if (r1 < 1) goto L9;
        int r6 = r0.getLineForOffset(RangesKt.coerceIn(r5, 0, r1 - 1));
        return TextRangeKt.TextRange(r0.getLineStart(r6), r0.getLineEnd(r6, true));
    L9:
        return TextRange.Companion.getZero-d9O1mEE();
    L5:
        return TextRange.Companion.getZero-d9O1mEE();
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    /* JADX INFO: renamed from: getHandlePosition-dBAh8RU, reason: not valid java name */
    public long mo1830getHandlePositiondBAh8RU(Selection r6, boolean r7) {
        if (r7 == true) goto L4;
    L5:
        if (r7 == true) goto L11;
        if (r6.getEnd().getSelectableId() == getSelectableId()) goto L11;
    L9:
        return Offset.Companion.getUnspecified-F1C5BW0();
    L11:
        if (getLayoutCoordinates() == null) goto L13;
        TextLayoutResult r0 = (TextLayoutResult) this.layoutResultCallback.invoke();
        if (r0 == null) goto L17;
        if (r7 == false) goto L20;
        Selection.AnchorInfo r1 = r6.getStart();
    L22:
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(r0, RangesKt.coerceIn(r1.getOffset(), 0, getLastVisibleOffset(r0)), r7, r6.getHandlesCrossed());
    L20:
        r1 = r6.getEnd();
        goto L22
    L17:
        return Offset.Companion.getUnspecified-F1C5BW0();
    L13:
        return Offset.Companion.getUnspecified-F1C5BW0();
    L4:
        if (r6.getStart().getSelectableId() != getSelectableId()) goto L9;
        goto L5
    }

    public MultiWidgetSelectionDelegate(long r1, Function0<? extends LayoutCoordinates> r3, Function0<TextLayoutResult> r4) {
        this.selectableId = r1;
        this.coordinatesCallback = r3;
        this.layoutResultCallback = r4;
        this.lock = this;
        this._previousLastVisibleOffset = -1;
    }
}
