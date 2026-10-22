package pj5;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f529469a = 0;

    static {
    }

    public static String b(Date r100) {
        if (r100 != null) goto L9;
    L7:
        return "";
    L9:
        return new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(r100);
    L6:
        tt5.a.d("DateTimeUtils", "dateToString error");
        goto L7
    }

    public static Date a(Date r100, Integer r101) {
        if (r101 == null) goto L4;
        Calendar r102 = Calendar.getInstance();     // Catch: Exception -> L7
        r102.setTime(r100);     // Catch: Exception -> L7
        r102.add(5, r101.intValue());     // Catch: Exception -> L7
        Date r103 = r102.getTime();     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L7
        return r103;
    L8:
        return new Date();
    L4:
        return new Date();
    }

    public static long c(Date r100, Integer r101) {
        if (r101 == null) goto L4;
        Calendar r102 = Calendar.getInstance();     // Catch: Exception -> L7
        r102.setTime(r100);     // Catch: Exception -> L7
        r102.add(5, r101.intValue());     // Catch: Exception -> L7
        return r102.getTime().getTime();
    L8:
        return new Date().getTime();
    L4:
        return new Date().getTime();
    }

    public static boolean d(int r100, int r101, int r102) {
        Calendar r103 = Calendar.getInstance();     // Catch: Exception -> L12
        r103.setTimeInMillis(System.currentTimeMillis());     // Catch: Exception -> L12
        r103.setTime(new Date(System.currentTimeMillis()));     // Catch: Exception -> L12
        int r104 = r103.get(1);     // Catch: Exception -> L12
        int r105 = r103.get(2);     // Catch: Exception -> L12
        int r106 = r103.get(5);     // Catch: Exception -> L12
        if (r100 <= r104) goto L5;
        return true;
    L5:
        if (r100 != r104) goto L8;
        if (r101 <= r105) goto L8;
        return true;
    L8:
        if (r100 != r104) goto L17;
        if (r101 != r105) goto L18;
        if (r102 <= r106) goto L19;
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
