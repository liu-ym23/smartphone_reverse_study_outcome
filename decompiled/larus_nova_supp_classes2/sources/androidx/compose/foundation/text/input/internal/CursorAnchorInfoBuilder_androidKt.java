package androidx.compose.foundation.text.input.internal;

import android.graphics.Matrix;
import android.os.Build;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\u001au\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a$\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a,\u0010\u0019\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u001c"}, d2 = {"build", "Landroid/view/inputmethod/CursorAnchorInfo;", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "matrix", "Landroid/graphics/Matrix;", "innerTextFieldBounds", "Landroidx/compose/ui/geometry/Rect;", "decorationBoxBounds", "includeInsertionMarker", "", "includeCharacterBounds", "includeEditorBounds", "includeLineBounds", "build-vxqZcH0", "(Landroid/view/inputmethod/CursorAnchorInfo$Builder;Ljava/lang/CharSequence;JLandroidx/compose/ui/text/TextRange;Landroidx/compose/ui/text/TextLayoutResult;Landroid/graphics/Matrix;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;ZZZZ)Landroid/view/inputmethod/CursorAnchorInfo;", "setInsertionMarker", "selectionStart", "", "addCharacterBounds", "startOffset", "endOffset", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CursorAnchorInfoBuilder_androidKt {
    private static final CursorAnchorInfo.Builder setInsertionMarker(CursorAnchorInfo.Builder r10, int r11, TextLayoutResult r12, Rect r13) {
        if (r11 >= 0) goto L4;
        return r10;
    L4:
        Rect r0 = r12.getCursorRect(r11);
        float r5 = RangesKt.coerceIn(r0.getLeft(), MenuKt.ClosedAlphaTarget, (int) (r12.getSize-YbymL2g() >> 32));
        boolean r1 = LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(r13, r5, r0.getTop());
        boolean r14 = LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(r13, r5, r0.getBottom());
        int r2 = 1;
        if (r12.getBidiRunDirection(r11) != ResolvedTextDirection.Rtl) goto L7;
        boolean r15 = true;
    L8:
        if (r1 == true) goto L12;
        if (r14 == true) goto L12;
        r2 = 0;
    L12:
        if (r1 == false) goto L14;
        if (r14 == false) goto L14;
    L15:
        if (r15 == false) goto L17;
        int r9 = r2 | 4;
    L18:
        r10.setInsertionMarkerLocation(r5, r0.getTop(), r0.getBottom(), r0.getBottom(), r9);
        return r10;
    L17:
        r9 = r2;
    L14:
        r2 = r2 | 2;
        goto L15
    L7:
        r15 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    private static final CursorAnchorInfo.Builder addCharacterBounds(CursorAnchorInfo.Builder r14, int r15, int r16, TextLayoutResult r17, Rect r18) {
        float[] r2 = new float[(r16 - r15) * 4];
        r17.getMultiParagraph().fillBoundingBoxes-8ffj60Q(TextRangeKt.TextRange(r15, r16), r2, 0);
        int r3 = r15;
    L3:
        if (r3 >= r16) goto L13;
        int r4 = (r3 - r15) * 4;
        Rect r5 = new Rect(r2[r4], r2[r4 + 1], r2[r4 + 2], r2[r4 + 3]);
        boolean r6 = r18.overlaps(r5);
        if (LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(r18, r5.getLeft(), r5.getTop()) == false) goto L8;
        ?? r7 = r6;
        if (LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(r18, r5.getRight(), r5.getBottom()) == false) goto L8;
    L10:
        if (r17.getBidiRunDirection(r3) != ResolvedTextDirection.Rtl) goto L12;
        r7 = (r7 == true ? 1 : 0) | 4;
    L12:
        int r8 = r3;
        r14.addCharacterBounds(r8, r5.getLeft(), r5.getTop(), r5.getRight(), r5.getBottom(), r7 == true ? 1 : 0);
        r3 = r3 + 1;
    L8:
        r7 = (r6 ? 1 : 0) | 2;
        goto L10
    L13:
        return r14;
    }

    /* JADX INFO: renamed from: build-vxqZcH0, reason: not valid java name */
    public static final CursorAnchorInfo m1577buildvxqZcH0(CursorAnchorInfo.Builder r0, CharSequence r1, long r2, TextRange r4, TextLayoutResult r5, Matrix r6, Rect r7, Rect r8, boolean r9, boolean r10, boolean r11, boolean r12) {
        r0.reset();
        r0.setMatrix(r6);
        int r13 = TextRange.getMin-impl(r2);
        r0.setSelectionRange(r13, TextRange.getMax-impl(r2));
        if (r9 == false) goto L5;
        setInsertionMarker(r0, r13, r5, r7);
    L5:
        if (r10 == false) goto L18;
        int r3 = -1;
        if (r4 == null) goto L9;
        int r14 = TextRange.getMin-impl(r4.unbox-impl());
    L10:
        if (r4 == null) goto L12;
        r3 = TextRange.getMax-impl(r4.unbox-impl());
    L12:
        boolean r15 = false;
        if (r14 < 0) goto L16;
        if (r14 >= r3) goto L16;
        r15 = true;
    L16:
        if (r15 == false) goto L18;
        r0.setComposingText(r14, r1.subSequence(r14, r3));
        addCharacterBounds(r0, r14, r3, r5, r7);
        goto L18
    L9:
        r14 = -1;
    L18:
        int r16 = Build.VERSION.SDK_INT;
        if (r16 < 33) goto L23;
        if (r11 == false) goto L23;
        CursorAnchorInfoApi33Helper.setEditorBoundsInfo(r0, r8);
    L23:
        if (r16 < 34) goto L27;
        if (r12 == false) goto L27;
        CursorAnchorInfoApi34Helper.addVisibleLineBounds(r0, r5, r7);
    L27:
        return r0.build();
    }

    /* JADX INFO: renamed from: build-vxqZcH0$default, reason: not valid java name */
    public static /* synthetic */ CursorAnchorInfo m1578buildvxqZcH0$default(CursorAnchorInfo.Builder r16, CharSequence r17, long r18, TextRange r20, TextLayoutResult r21, Matrix r22, Rect r23, Rect r24, boolean r25, boolean r26, boolean r27, boolean r28, int r29, Object r30) {
        if ((r29 & 128) == 0) goto L5;
        boolean r12 = true;
    L7:
        if ((r29 & 256) == 0) goto L9;
        boolean r13 = true;
    L11:
        if ((r29 & 512) == 0) goto L13;
        boolean r14 = true;
    L15:
        if ((r29 & 1024) == 0) goto L17;
        boolean r15 = true;
    L19:
        return m1577buildvxqZcH0(r16, r17, r18, r20, r21, r22, r23, r24, r12, r13, r14, r15);
    L17:
        r15 = r28;
        goto L19
    L13:
        r14 = r27;
        goto L15
    L9:
        r13 = r26;
        goto L11
    L5:
        r12 = r25;
        goto L7
    }
}
