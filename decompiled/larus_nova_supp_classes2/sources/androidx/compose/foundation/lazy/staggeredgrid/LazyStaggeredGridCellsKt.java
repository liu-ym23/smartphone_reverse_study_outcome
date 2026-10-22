package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¨\u0006\u0006"}, d2 = {"calculateCellsCrossAxisSizeImpl", "", "gridSize", "", "slotCount", "spacing", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyStaggeredGridCellsKt {
    public static final /* synthetic */ int[] access$calculateCellsCrossAxisSizeImpl(int r0, int r1, int r2) {
        return calculateCellsCrossAxisSizeImpl(r0, r1, r2);
    }

    private static final int[] calculateCellsCrossAxisSizeImpl(int r4, int r5, int r6) {
        int r7 = r4 - (r6 * (r5 - 1));
        int r8 = r7 / r5;
        int r9 = r7 % r5;
        int[] r0 = new int[r5];
        int r2 = 0;
    L3:
        if (r2 >= r5) goto L11;
        if (r8 >= 0) goto L6;
        int r3 = 0;
    L10:
        r0[r2] = r3;
        r2 = r2 + 1;
        goto L3
    L6:
        if (r2 >= r9) goto L8;
        int r10 = 1;
    L9:
        r3 = r10 + r8;
        goto L10
    L8:
        r10 = 0;
        goto L9
    L11:
        return r0;
    }
}
