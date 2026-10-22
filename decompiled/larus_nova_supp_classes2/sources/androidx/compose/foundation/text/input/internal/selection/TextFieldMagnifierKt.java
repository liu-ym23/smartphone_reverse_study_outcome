package androidx.compose.foundation.text.input.internal.selection;

import androidx.collection.SieveCacheKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "selectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-hUlJWOE", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;J)J", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldMagnifierKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Handle.values().length];
            r0[Handle.Cursor.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Handle.SelectionStart.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Handle.SelectionEnd.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: calculateSelectionMagnifierCenterAndroid-hUlJWOE, reason: not valid java name */
    public static final long m1706calculateSelectionMagnifierCenterAndroidhUlJWOE(TransformedTextFieldState r9, TextFieldSelectionState r10, TextLayoutState r11, long r12) {
        long r0 = r10.m1723getHandleDragPositionF1C5BW0();
        boolean r6 = false;
        if ((SieveCacheKt.InvalidMapping & r0) != 9205357640488583168L) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L49;
        if (r9.getVisualText().length() != 0) goto L10;
        r6 = true;
    L10:
        if (r6 == true) goto L49;
        long r3 = r9.getVisualText().m1535getSelectiond9O1mEE();
        Handle r13 = r10.getDraggingHandle();
        if (r13 != null) goto L15;
        int r14 = -1;
    L16:
        if (r14 == (-1)) goto L47;
        if (r14 == 1) goto L25;
        if (r14 == 2) goto L25;
        if (r14 != 3) goto L24;
        int r15 = TextRange.getEnd-impl(r3);
    L26:
        TextLayoutResult r4 = r11.getLayoutResult();
        if (r4 == null) goto L29;
        float r1 = Float.intBitsToFloat((int) (r0 >> 32));
        int r16 = r4.getLineForOffset(r15);
        float r5 = r4.getLineLeft(r16);
        float r7 = r4.getLineRight(r16);
        float r8 = RangesKt.coerceIn(r1, Math.min(r5, r7), Math.max(r5, r7));
        if (IntSize.equals-impl0(r12, IntSize.Companion.getZero-YbymL2g()) == false) goto L33;
    L36:
        float r17 = r4.getLineTop(r16);
        float r18 = ((r4.getLineBottom(r16) - r17) / 2) + r17;
        long r19 = Float.floatToRawIntBits(r8);
        long r20 = Offset.constructor-impl((((long) Float.floatToRawIntBits(r18)) & 4294967295L) | (r19 << 32));
        LayoutCoordinates r110 = r11.getTextLayoutNodeCoordinates();
        if (r110 == null) goto L45;
        if (r110.isAttached() == true) goto L42;
        r110 = null;
    L42:
        if (r110 == null) goto L45;
        r20 = TextLayoutStateKt.m1666coerceIn3MmeM6k(r20, SelectionManagerKt.visibleBounds(r110));
    L45:
        return TextLayoutStateKt.m1668fromTextLayoutToCoreUv8p0NA(r11, r20);
    L33:
        if (Math.abs(r1 - r8) <= (((int) (r12 >> 32)) / 2)) goto L36;
        return Offset.Companion.getUnspecified-F1C5BW0();
    L29:
        return Offset.Companion.getUnspecified-F1C5BW0();
    L24:
        throw new NoWhenBranchMatchedException();
    L25:
        r15 = TextRange.getStart-impl(r3);
        goto L26
    L47:
        return Offset.Companion.getUnspecified-F1C5BW0();
    L15:
        r14 = WhenMappings.$EnumSwitchMapping$0[r13.ordinal()];
    L49:
        return Offset.Companion.getUnspecified-F1C5BW0();
    L5:
        r2 = false;
        goto L6
    }
}
