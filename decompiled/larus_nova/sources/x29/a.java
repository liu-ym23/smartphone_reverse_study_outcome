package x29;

import androidx.collection.SieveCacheKt;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f562257a = 0;

    static {
    }

    public static String a(long r100) {
        if (r100 >= 1000) goto L6;
        return String.valueOf(r100);
    L6:
        if (r100 >= 1000000) goto L9;
        return BigDecimal.valueOf(r100).divide(BigDecimal.valueOf(1000), 1, RoundingMode.HALF_UP).toPlainString() + 'K';
    L9:
        return BigDecimal.valueOf(r100).divide(BigDecimal.valueOf(1000000), 1, RoundingMode.HALF_UP).toPlainString() + 'M';
    }

    public static int b(long r100, long r101) {
        if (r100 > 0) goto L5;
    L9:
        return 0;
    L5:
        if (r101 <= 0) goto L9;
        return BigDecimal.valueOf(r100).multiply(BigDecimal.valueOf(1000)).divide(BigDecimal.valueOf(r101), 0, RoundingMode.HALF_UP).min(BigDecimal.valueOf(1000)).min(BigDecimal.valueOf(SieveCacheKt.NodeLinkMask)).intValue();
    }
}
