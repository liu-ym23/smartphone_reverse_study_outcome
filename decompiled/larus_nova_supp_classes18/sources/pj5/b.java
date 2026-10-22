package pj5;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String b(Date r3) {
        if (r3 != null) goto L9;
    L7:
        return "";
    L9:
        return new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(r3);
    L6:
        tt5.a.d("DateTimeUtils", "dateToString error");
        goto L7
    }

    public static Date a(Date r1, Integer r2) {
        if (r2 == null) goto L4;
        Calendar r0 = Calendar.getInstance();     // Catch: Exception -> L7
        r0.setTime(r1);     // Catch: Exception -> L7
        r0.add(5, r2.intValue());     // Catch: Exception -> L7
        Date r3 = r0.getTime();     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L7
        return r3;
    L8:
        return new Date();
    L4:
        return new Date();
    }

    public static long c(Date r1, Integer r2) {
        if (r2 == null) goto L4;
        Calendar r0 = Calendar.getInstance();     // Catch: Exception -> L7
        r0.setTime(r1);     // Catch: Exception -> L7
        r0.add(5, r2.intValue());     // Catch: Exception -> L7
        return r0.getTime().getTime();
    L8:
        return new Date().getTime();
    L4:
        return new Date().getTime();
    }

    public static boolean d(int r5, int r6, int r7) {
        Calendar r0 = Calendar.getInstance();     // Catch: Exception -> L12
        r0.setTimeInMillis(System.currentTimeMillis());     // Catch: Exception -> L12
        r0.setTime(new Date(System.currentTimeMillis()));     // Catch: Exception -> L12
        int r2 = r0.get(1);     // Catch: Exception -> L12
        int r3 = r0.get(2);     // Catch: Exception -> L12
        int r1 = r0.get(5);     // Catch: Exception -> L12
        if (r5 <= r2) goto L5;
        return true;
    L5:
        if (r5 != r2) goto L8;
        if (r6 <= r3) goto L8;
        return true;
    L8:
        if (r5 != r2) goto L17;
        if (r6 != r3) goto L18;
        if (r7 <= r1) goto L19;
        return true;
    L19:
        return false;
    L18:
        return false;
    L17:
        return false;
    L12:
        tt5.a.d("DateTimeUtils", "isMoreThanOneDay error");
        return false;
    }
}
