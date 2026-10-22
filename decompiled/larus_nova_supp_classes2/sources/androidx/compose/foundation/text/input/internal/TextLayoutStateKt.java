package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u000b\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\f\u0010\n\u001a\u001b\u0010\r\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"coerceIn", "Landroidx/compose/ui/geometry/Offset;", "rect", "Landroidx/compose/ui/geometry/Rect;", "coerceIn-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)J", "fromTextLayoutToCore", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "offset", "fromTextLayoutToCore-Uv8p0NA", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;J)J", "fromDecorationToTextLayout", "fromDecorationToTextLayout-Uv8p0NA", "fromWindowToDecoration", "fromWindowToDecoration-Uv8p0NA", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextLayoutStateKt {
    /* JADX INFO: renamed from: coerceIn-3MmeM6k, reason: not valid java name */
    public static final long m1666coerceIn3MmeM6k(long r6, Rect r8) {
        int r2 = (int) (r6 >> 32);
        if (Float.intBitsToFloat(r2) >= r8.getLeft()) goto L6;
        float r1 = r8.getLeft();
    L9:
        int r7 = (int) (r6 & 4294967295L);
        if (Float.intBitsToFloat(r7) >= r8.getTop()) goto L13;
        float r9 = r8.getTop();
    L17:
        return Offset.constructor-impl((Float.floatToRawIntBits(r1) << 32) | (Float.floatToRawIntBits(r9) & 4294967295L));
    L13:
        if (Float.intBitsToFloat(r7) <= r8.getBottom()) goto L15;
        r9 = r8.getBottom();
        goto L17
    L15:
        r9 = Float.intBitsToFloat(r7);
        goto L17
    L6:
        if (Float.intBitsToFloat(r2) <= r8.getRight()) goto L8;
        r1 = r8.getRight();
        goto L9
    L8:
        r1 = Float.intBitsToFloat(r2);
        goto L9
    }

    /* JADX INFO: renamed from: fromDecorationToTextLayout-Uv8p0NA, reason: not valid java name */
    public static final long m1667fromDecorationToTextLayoutUv8p0NA(TextLayoutState r2, long r3) {
        LayoutCoordinates r0 = r2.getTextLayoutNodeCoordinates();
        if (r0 == null) goto L17;
        LayoutCoordinates r4 = r2.getDecoratorNodeCoordinates();
        if (r4 != null) goto L7;
        Offset r5 = null;
    L14:
        if (r5 != null) goto L16;
        return r3;
    L16:
        return r5.unbox-impl();
    L7:
        if (r0.isAttached() == true) goto L9;
    L11:
        long r1 = r3;
    L12:
        r5 = Offset.box-impl(r1);
        goto L14
    L9:
        if (r4.isAttached() == false) goto L11;
        r1 = r0.localPositionOf-R5De75A(r4, r3);
        goto L12
    L17:
        return r3;
    }

    /* JADX INFO: renamed from: fromTextLayoutToCore-Uv8p0NA, reason: not valid java name */
    public static final long m1668fromTextLayoutToCoreUv8p0NA(TextLayoutState r3, long r4) {
        LayoutCoordinates r0 = r3.getTextLayoutNodeCoordinates();
        if (r0 == null) goto L20;
        Offset r2 = null;
        if (r0.isAttached() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L21;
        LayoutCoordinates r5 = r3.getCoreNodeCoordinates();
        if (r5 != null) goto L12;
    L17:
        if (r2 != null) goto L19;
        return r4;
    L19:
        return r2.unbox-impl();
    L12:
        if (r5.isAttached() == true) goto L15;
        r5 = null;
    L15:
        if (r5 == null) goto L17;
        r2 = Offset.box-impl(r5.localPositionOf-R5De75A(r0, r4));
        goto L17
    L21:
        return r4;
    L20:
        return r4;
    }

    /* JADX INFO: renamed from: fromWindowToDecoration-Uv8p0NA, reason: not valid java name */
    public static final long m1669fromWindowToDecorationUv8p0NA(TextLayoutState r1, long r2) {
        LayoutCoordinates r3 = r1.getDecoratorNodeCoordinates();
        if (r3 != null) goto L5;
        return r2;
    L5:
        if (r3.isAttached() == true) goto L7;
        return r2;
    L7:
        return r3.windowToLocal-MK-Hz9U(r2);
    }
}
