package androidx.compose.foundation.text.input.internal;

import android.graphics.Matrix;
import android.os.Build;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\u001ad\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000fH\u0000\u001a,\u0010\u0013\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a4\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u001c\u0010\u0019\u001a\u00020\u000f*\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0000¨\u0006\u001d"}, d2 = {"build", "Landroid/view/inputmethod/CursorAnchorInfo;", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "matrix", "Landroid/graphics/Matrix;", "innerTextFieldBounds", "Landroidx/compose/ui/geometry/Rect;", "decorationBoxBounds", "includeInsertionMarker", "", "includeCharacterBounds", "includeEditorBounds", "includeLineBounds", "setInsertionMarker", "selectionStart", "", "addCharacterBounds", "startOffset", "endOffset", "containsInclusive", "x", "", "y", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LegacyCursorAnchorInfoBuilder_androidKt {
    public static final boolean containsInclusive(Rect r4, float r5, float r6) {
        float r0 = r4.getLeft();
        if (r5 <= r4.getRight()) goto L5;
    L7:
        boolean r7 = false;
    L8:
        if (r7 == false) goto L17;
        float r8 = r4.getTop();
        if (r6 <= r4.getBottom()) goto L12;
    L14:
        boolean r9 = false;
    L15:
        if (r9 == false) goto L17;
        return true;
    L12:
        if (r8 > r6) goto L14;
        r9 = true;
    L17:
        return false;
    L5:
        if (r0 > r5) goto L7;
        r7 = true;
        goto L8
    }

    private static final CursorAnchorInfo.Builder setInsertionMarker(CursorAnchorInfo.Builder r9, int r10, OffsetMapping r11, TextLayoutResult r12, Rect r13) {
        if (r10 >= 0) goto L4;
        return r9;
    L4:
        int r14 = r11.originalToTransformed(r10);
        Rect r15 = r12.getCursorRect(r14);
        float r4 = RangesKt.coerceIn(r15.getLeft(), MenuKt.ClosedAlphaTarget, (int) (r12.getSize-YbymL2g() >> 32));
        boolean r0 = containsInclusive(r13, r4, r15.getTop());
        boolean r16 = containsInclusive(r13, r4, r15.getBottom());
        int r1 = 1;
        if (r12.getBidiRunDirection(r14) != ResolvedTextDirection.Rtl) goto L7;
        boolean r17 = true;
    L8:
        if (r0 == true) goto L12;
        if (r16 == true) goto L12;
        r1 = 0;
    L12:
        if (r0 == false) goto L14;
        if (r16 == false) goto L14;
    L15:
        if (r17 == false) goto L17;
        int r8 = r1 | 4;
    L18:
        r9.setInsertionMarkerLocation(r4, r15.getTop(), r15.getBottom(), r15.getBottom(), r8);
        return r9;
    L17:
        r8 = r1;
    L14:
        r1 = r1 | 2;
        goto L15
    L7:
        r17 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1, types: [int] */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r17v0, types: [android.view.inputmethod.CursorAnchorInfo$Builder] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    private static final CursorAnchorInfo.Builder addCharacterBounds(CursorAnchorInfo.Builder r17, int r18, int r19, OffsetMapping r20, TextLayoutResult r21, Rect r22) {
        int r2 = r18;
        int r4 = r20.originalToTransformed(r2);
        int r5 = r20.originalToTransformed(r19);
        float[] r6 = new float[(r5 - r4) * 4];
        r21.getMultiParagraph().fillBoundingBoxes-8ffj60Q(TextRangeKt.TextRange(r4, r5), r6, 0);
    L3:
        if (r2 >= r19) goto L14;
        int r7 = r20.originalToTransformed(r2);
        int r8 = (r7 - r4) * 4;
        Rect r9 = new Rect(r6[r8], r6[r8 + 1], r6[r8 + 2], r6[r8 + 3]);
        boolean r10 = r22.overlaps(r9);
        if (containsInclusive(r22, r9.getLeft(), r9.getTop()) == false) goto L8;
        ?? r11 = r10;
        if (containsInclusive(r22, r9.getRight(), r9.getBottom()) == false) goto L8;
    L10:
        if (r21.getBidiRunDirection(r7) != ResolvedTextDirection.Rtl) goto L12;
        ?? r16 = r11 | 4;
    L13:
        int r12 = r2;
        r17.addCharacterBounds(r12, r9.getLeft(), r9.getTop(), r9.getRight(), r9.getBottom(), r16);
        r2 = r2 + 1;
        goto L3
    L12:
        r16 = r11;
    L8:
        r11 = (r10 ? 1 : 0) | 2;
        goto L10
    L14:
        return r17;
    }

    public static final CursorAnchorInfo build(CursorAnchorInfo.Builder r9, TextFieldValue r10, OffsetMapping r11, TextLayoutResult r12, Matrix r13, Rect r14, Rect r15, boolean r16, boolean r17, boolean r18, boolean r19) {
        r9.reset();
        r9.setMatrix(r13);
        int r0 = TextRange.getMin-impl(r10.getSelection-d9O1mEE());
        r9.setSelectionRange(r0, TextRange.getMax-impl(r10.getSelection-d9O1mEE()));
        if (r16 == false) goto L5;
        setInsertionMarker(r9, r0, r11, r12, r14);
    L5:
        if (r17 == false) goto L20;
        TextRange r1 = r10.getComposition-MzsxiRA();
        if (r1 == null) goto L9;
        int r2 = TextRange.getMin-impl(r1.unbox-impl());
    L10:
        TextRange r3 = r10.getComposition-MzsxiRA();
        if (r3 == null) goto L13;
        int r4 = TextRange.getMax-impl(r3.unbox-impl());
    L14:
        boolean r5 = false;
        if (r2 < 0) goto L18;
        if (r2 >= r4) goto L18;
        r5 = true;
    L18:
        if (r5 == false) goto L20;
        r9.setComposingText(r2, r10.getText().subSequence(r2, r4));
        addCharacterBounds(r9, r2, r4, r11, r12, r14);
        goto L20
    L13:
        r4 = -1;
        goto L14
    L9:
        r2 = -1;
    L20:
        int r6 = Build.VERSION.SDK_INT;
        if (r6 < 33) goto L25;
        if (r18 == false) goto L25;
        CursorAnchorInfoApi33Helper.setEditorBoundsInfo(r9, r15);
    L25:
        if (r6 < 34) goto L29;
        if (r19 == false) goto L29;
        CursorAnchorInfoApi34Helper.addVisibleLineBounds(r9, r12, r14);
    L29:
        return r9.build();
    }

    public static /* synthetic */ CursorAnchorInfo build$default(CursorAnchorInfo.Builder r14, TextFieldValue r15, OffsetMapping r16, TextLayoutResult r17, Matrix r18, Rect r19, Rect r20, boolean r21, boolean r22, boolean r23, boolean r24, int r25, Object r26) {
        if ((r25 & 64) == 0) goto L5;
        boolean r10 = true;
    L7:
        if ((r25 & 128) == 0) goto L9;
        boolean r11 = true;
    L11:
        if ((r25 & 256) == 0) goto L13;
        boolean r12 = true;
    L15:
        if ((r25 & 512) == 0) goto L17;
        boolean r13 = true;
    L19:
        return build(r14, r15, r16, r17, r18, r19, r20, r10, r11, r12, r13);
    L17:
        r13 = r24;
        goto L19
    L13:
        r12 = r23;
        goto L15
    L9:
        r11 = r22;
        goto L11
    L5:
        r10 = r21;
        goto L7
    }
}
