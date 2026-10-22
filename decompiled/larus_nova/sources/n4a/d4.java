package n4a;

import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes32.dex */
public final class d4 {
    public static long b(long r100) {
        Calendar r101 = Calendar.getInstance();
        r101.setTime(new Date(r100));
        r101.set(11, 0);
        r101.set(12, 0);
        r101.set(13, 0);
        r101.set(14, 0);
        return r101.getTimeInMillis();
    }

    public static long a(long r100, long r101, int r110) {
        if (r110 > 0) goto L19;
    L17:
        return r100;
    L19:
        if (Math.abs(r100 - r101) <= (((long) r110) * 31536000000L)) goto L17;
        long r102 = r100 - b(r100);     // Catch: Throwable -> L18
        long r103 = b(r101) + r102;     // Catch: Throwable -> L18
        long r104 = Math.abs(r103 - r101);     // Catch: Throwable -> L18
        Calendar r111 = Calendar.getInstance();     // Catch: Throwable -> L18
        r111.setTime(new Date(r103));     // Catch: Throwable -> L18
        int r105 = r111.get(11);     // Catch: Throwable -> L18
        if (r105 == 23) goto L10;
    L12:
        if (r105 == 0) goto L14;
        return r103;
    L14:
        if (r104 >= 82800000) goto L16;
        return r103;
    L16:
        return r103 + 86400000;
    L10:
        if (r104 < 82800000) goto L12;
        r103 = r103 - 86400000;
        goto L12
    }
}
