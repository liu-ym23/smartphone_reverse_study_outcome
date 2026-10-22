package kotlinx.coroutines.internal;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c0 {
    public static final long a(String r4, long r5, long r7, long r9) {
        int r0 = d0.a;
        String r1 = System.getProperty(r4);     // Catch: SecurityException -> L5
    L6:
        if (r1 == null) goto L25;
        Long r6 = StringsKt.toLongOrNull(r1);
        if (r6 == null) goto L22;
        long r2 = r6.longValue();
        if (r7 <= r2) goto L13;
    L15:
        boolean r8 = false;
    L16:
        if (r8 == false) goto L20;
        return r2;
    L20:
        throw new IllegalStateException(("System property '" + r4 + "' should be in range " + r7 + ".." + r9 + ", but is '" + r2 + '\'').toString());
    L13:
        if (r2 > r9) goto L15;
        r8 = true;
        goto L16
    L22:
        throw new IllegalStateException(("System property '" + r4 + "' has unrecognized value '" + r1 + '\'').toString());
    L25:
        return r5;
    L5:
        r1 = null;
        goto L6
    }

    public static int b(String r7, int r8, int r9, int r10, int r11) {
        if ((r11 & 4) == 0) goto L6;
        r9 = 1;
    L6:
        if ((r11 & 8) == 0) goto L9;
        r10 = Integer.MAX_VALUE;
    L9:
        return (int) a(r7, r8, r9, r10);
    }
}
