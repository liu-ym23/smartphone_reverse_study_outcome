package zu5;

import android.content.Context;
import android.text.TextUtils;
import com.larus.nova.R;
import com.ss.android.lark.time.format.entity.DatePreciseness;
import com.ss.android.lark.time.format.entity.DisplayPattern;
import com.ss.android.lark.time.format.entity.LengthType;
import iu5.d;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, SimpleDateFormat> f573665a = null;

    static {
        TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS);
        f573665a = new ConcurrentHashMap();
    }

    public static SimpleDateFormat a(String r100) {
        SimpleDateFormat r101 = (SimpleDateFormat) ((ConcurrentHashMap) f573665a).get(r100);
        if (r101 == null) goto L10;
    L9:
        return r101;
    L10:
        r101 = new SimpleDateFormat(r100);     // Catch: Exception -> L6
    L8:
        ((ConcurrentHashMap) f573665a).put(r100, r101);
    L6:
        e = move-exception;
        SimpleDateFormat r102 = new SimpleDateFormat();
        d.a("DateUtils", e);
        r101 = r102;
        goto L8
    }

    public static boolean i(long r100) {
        Calendar r101 = Calendar.getInstance();
        r101.setTime(new Date(System.currentTimeMillis()));
        Calendar r102 = Calendar.getInstance();
        r102.setTime(new Date(r100));
        if (r102.get(1) == r101.get(1)) goto L5;
        return false;
    L5:
        if ((r101.get(6) - r102.get(6)) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public static String b(Context r110, long r111) {
        if (r110 == null) goto L5;
        boolean r100 = false;
    L6:
        if (r100 == false) goto L9;
        return "";
    L9:
        long r101 = new Date().getTime() - r111;
        if ((new Date().getTime() - r111) >= 60000) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == false) goto L17;
        return r110.getString(R.string.LarkCCM_Docs_DocDetails_ModifiedTime_JustNow_Text_Mob);
    L17:
        if ((new Date().getTime() - r111) >= 3600000) goto L19;
        boolean r103 = true;
    L20:
        if (r103 == false) goto L24;
        long r104 = r101 / 60000;
        return r110.getResources().getQuantityString(R.plurals.Doc_Util_MinsAgo, (int) r104, new Object[]{Long.valueOf(r104)});
    L24:
        if (h(r110, r111) == false) goto L28;
        long r105 = r101 / 3600000;
        return r110.getResources().getQuantityString(R.plurals.Doc_Util_HoursAgo, (int) r105, new Object[]{Long.valueOf(r105)});
    L28:
        if (i(r111) == false) goto L32;
        c7c.a r106 = new c7c.a();
        r106.b(DisplayPattern.RELATIVE);
        return c7c.b.c(r110, new Date(r111), r106);
    L32:
        if (g(r110, r111) == false) goto L36;
        c7c.a r107 = new c7c.a();
        r107.c(LengthType.SHORT);
        return r110.getString(R.string.Doc_Util_AtWithTime) + " " + c7c.b.c(r110, new Date(r111), r107);
    L36:
        return c7c.b.a(r110, new Date(r111), null);
    L19:
        r103 = false;
        goto L20
    L12:
        r102 = false;
        goto L13
    L5:
        r100 = true;
        goto L6
    }

    public static String c(Context r110, long r111) {
        if (r110 == null) goto L5;
        boolean r100 = false;
    L6:
        if (r100 == false) goto L9;
        return "";
    L9:
        long r101 = new Date().getTime() - r111;
        if ((new Date().getTime() - r111) >= 45000) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == false) goto L17;
        return r110.getString(R.string.LarkCCM_Docs_DocDetails_ModifiedTime_JustNow_Text_Mob);
    L17:
        if ((new Date().getTime() - r111) >= 90000) goto L19;
        boolean r103 = true;
    L21:
        if (r103 == false) goto L25;
        return r110.getResources().getQuantityString(R.plurals.Doc_Util_MinsAgo, 1, new Object[]{1});
    L25:
        if ((new Date().getTime() - r111) >= 2700000) goto L27;
        boolean r104 = true;
    L28:
        if (r104 == false) goto L32;
        long r105 = r101 / 60000;
        return r110.getResources().getQuantityString(R.plurals.Doc_Util_MinsAgo, (int) r105, new Object[]{Long.valueOf(r105)});
    L32:
        if ((new Date().getTime() - r111) >= 5400000) goto L34;
        boolean r106 = true;
    L36:
        if (r106 == false) goto L40;
        return r110.getResources().getQuantityString(R.plurals.Doc_Util_HoursAgo, 1, new Object[]{1L});
    L40:
        if (h(r110, r111) == false) goto L44;
        long r107 = r101 / 3600000;
        return r110.getResources().getQuantityString(R.plurals.Doc_Util_HoursAgo, (int) r107, new Object[]{Long.valueOf(r107)});
    L44:
        if (i(r111) == false) goto L48;
        c7c.a r108 = new c7c.a();
        r108.f22684h = true;
        r108.b(DisplayPattern.RELATIVE);
        return c7c.b.c(r110, new Date(r111), r108);
    L48:
        if (g(r110, r111) == false) goto L52;
        c7c.a r109 = new c7c.a();
        r109.c(LengthType.SHORT);
        r109.f22684h = true;
        return r110.getString(R.string.Doc_Util_AtWithTime) + " " + c7c.b.c(r110, new Date(r111), r109);
    L52:
        return c7c.b.a(r110, new Date(r111), null);
    L34:
        r106 = false;
        goto L36
    L27:
        r104 = false;
        goto L28
    L19:
        r103 = false;
        goto L21
    L12:
        r102 = false;
        goto L13
    L5:
        r100 = true;
        goto L6
    }

    public static String d(Context r100, long r101) {
        if (r100 == null) goto L4;
        boolean r102 = false;
    L5:
        if (r102 == false) goto L8;
        return "";
    L8:
        c7c.a r103 = new c7c.a();
        r103.c(LengthType.MIN);
        return c7c.b.i(r100, new Date(r101), r103);
    L4:
        r102 = true;
        goto L5
    }

    public static String e(Context r100, long r101) {
        if (r100 == null) goto L4;
        boolean r102 = false;
    L5:
        if (r102 == false) goto L9;
        return "";
    L9:
        if (h(r100, r101) == false) goto L13;
        c7c.a r103 = new c7c.a();
        r103.c(LengthType.SHORT);
        r103.b(DisplayPattern.RELATIVE);
        return c7c.b.c(r100, new Date(r101), r103);
    L13:
        if (i(r101) == false) goto L17;
        c7c.a r104 = new c7c.a();
        r104.b(DisplayPattern.RELATIVE);
        return c7c.b.c(r100, new Date(r101), r104);
    L17:
        if (g(r100, r101) == false) goto L21;
        c7c.a r105 = new c7c.a();
        r105.c(LengthType.SHORT);
        return r100.getString(R.string.Doc_Util_AtWithTime) + " " + c7c.b.c(r100, new Date(r101), r105);
    L21:
        return c7c.b.a(r100, new Date(r101), null);
    L4:
        r102 = true;
        goto L5
    }

    public static String f(Context r100, long r101) {
        if (r100 == null) goto L4;
        boolean r102 = false;
    L5:
        if (r102 == false) goto L8;
        return "";
    L8:
        c7c.a r103 = new c7c.a();
        if (g(r100, r101) == false) goto L11;
        r103.c(LengthType.SHORT);
    L11:
        r103.a(DatePreciseness.DAY);
        return c7c.b.a(r100, new Date(r101), r103);
    L4:
        r102 = true;
        goto L5
    }

    public static boolean g(Context r100, long r101) {
        if (r100 == null) goto L5;
        boolean r102 = false;
    L6:
        if (r102 == false) goto L8;
        return false;
    L8:
        SimpleDateFormat r103 = a("yyyy");
        return TextUtils.equals(r103.format(Long.valueOf(new Date().getTime())), r103.format(Long.valueOf(r101)));
    L5:
        r102 = true;
        goto L6
    }

    public static boolean h(Context r100, long r101) {
        if (r100 == null) goto L5;
        boolean r102 = false;
    L6:
        if (r102 == false) goto L8;
        return false;
    L8:
        SimpleDateFormat r103 = a("MMM d, yyyy");
        return TextUtils.equals(r103.format(Long.valueOf(new Date().getTime())), r103.format(Long.valueOf(r101)));
    L5:
        r102 = true;
        goto L6
    }
}
