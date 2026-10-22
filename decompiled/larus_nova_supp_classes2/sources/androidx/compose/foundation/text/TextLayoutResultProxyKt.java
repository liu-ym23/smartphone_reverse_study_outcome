package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"coerceIn", "Landroidx/compose/ui/geometry/Offset;", "rect", "Landroidx/compose/ui/geometry/Rect;", "coerceIn-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)J", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextLayoutResultProxyKt {
    /* JADX INFO: renamed from: access$coerceIn-3MmeM6k, reason: not valid java name */
    public static final /* synthetic */ long m1485access$coerceIn3MmeM6k(long r0, Rect r2) {
        return m1486coerceIn3MmeM6k(r0, r2);
    }

    /* JADX INFO: renamed from: coerceIn-3MmeM6k, reason: not valid java name */
    private static final long m1486coerceIn3MmeM6k(long r6, Rect r8) {
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
}
