package kotlinx.coroutines.internal;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
public final class c0 {
    public static final long a(String r100, long r101, long r102, long r103) {
        int r104 = d0.f504940a;
        String r105 = System.getProperty(r100);     // Catch: SecurityException -> L5
    L6:
        if (r105 == null) goto L25;
        Long r106 = StringsKt.toLongOrNull(r105);
        if (r106 == null) goto L22;
        long r107 = r106.longValue();
        if (r102 <= r107) goto L13;
    L15:
        boolean r108 = false;
    L16:
        if (r108 == false) goto L20;
        return r107;
    L20:
        throw new IllegalStateException(("System property '" + r100 + "' should be in range " + r102 + DownloadConstants.VULNERABILITY_PATH + r103 + ", but is '" + r107 + '\'').toString());
    L13:
        if (r107 > r103) goto L15;
        r108 = true;
        goto L16
    L22:
        throw new IllegalStateException(("System property '" + r100 + "' has unrecognized value '" + r105 + '\'').toString());
    L25:
        return r101;
    L5:
        r105 = null;
        goto L6
    }

    public static int b(String r100, int r101, int r102, int r110, int r111) {
        if ((r111 & 4) == 0) goto L6;
        r102 = 1;
    L6:
        if ((r111 & 8) == 0) goto L9;
        r110 = Integer.MAX_VALUE;
    L9:
        return (int) a(r100, r101, r102, r110);
    }
}
