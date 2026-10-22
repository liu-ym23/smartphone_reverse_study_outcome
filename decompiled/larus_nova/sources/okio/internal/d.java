package okio.internal;

import kotlin.jvm.internal.Intrinsics;
import okio.SegmentedByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class d {
    public static final int a(SegmentedByteString r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int[] r102 = r100.getDirectory$okio();
        int r103 = r101 + 1;
        int r104 = r100.getSegments$okio().length;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        int r105 = r104 - 1;
        int r106 = 0;
    L3:
        if (r106 > r105) goto L9;
        int r107 = (r106 + r105) >>> 1;
        int r108 = r102[r107];
        if (r108 < r103) goto L6;
        if (r108 <= r103) goto L10;
        r105 = r107 - 1;
    L10:
        if (r107 < 0) goto L13;
        return r107;
    L13:
        return ~r107;
    L6:
        r106 = r107 + 1;
        goto L3
    L9:
        r107 = (-r106) - 1;
        goto L10
    }
}
