package yu5;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f569228a = null;

    static {
        f569228a = PatternProtector.compile("(&|\\\\u0026)#(\\d{3}|x[0-9a-zA-Z]{2});");
    }

    public static int c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return 0;
    L7:
        return r100.length();
    }

    public static String d(Throwable r100) {
        StringBuilder r101 = new StringBuilder();
        StackTraceElement[] r102 = r100.getStackTrace();
        if (r102 == null) goto L12;
        int r103 = 0;
    L6:
        if (r103 >= r102.length) goto L12;
        if (r102[r103].toString().contains("com.ss.android.lark") == false) goto L10;
        r101.append(r102[r103].toString());
        r101.append("\n");
    L10:
        r103 = r103 + 1;
    L12:
        return r101.toString();
    }

    public static String e(String r100) {
        String r101 = UriProtector.parse(r100).getLastPathSegment();     // Catch: Throwable -> L20
        String r102 = "";
        if (TextUtils.isEmpty(r101) == false) goto L7;
    L9:
        int r103 = r100.indexOf("?");     // Catch: Throwable -> L20
        if (r103 < 0) goto L12;
        r100 = r100.substring(0, r103);     // Catch: Throwable -> L20
    L12:
        Matcher r104 = PatternProtector.compile("(?<=\\/doc\\/|\\/docs\\/|\\/sheet\\/|\\/sheets\\/|\\/mindnote\\/|\\/slide\\/|\\/siides\\/|\\/file\\/|\\/bitable\\/|\\/base\\/|\\/folder\\/|\\/wiki\\/|\\/isv\\/|\\/docx\\/)([a-zA-Z0-9]{22,})(?=\\/|$)").matcher(r100);     // Catch: Throwable -> L20
        boolean r105 = r104.find();     // Catch: Throwable -> L20
        StringBuffer r106 = new StringBuffer();     // Catch: Throwable -> L20
        if (r105 == false) goto L25;
        String r107 = r104.group();     // Catch: Throwable -> L20
        if (r107.length() >= 22) goto L18;
        r102 = r107;
    L18:
        r104.appendReplacement(r106, r102);     // Catch: Throwable -> L20
        r104.appendTail(r106);     // Catch: Throwable -> L20
        r100 = r106.toString();     // Catch: Throwable -> L20
        tt5.a.h("StringUtils", "find matched pattern");     // Catch: Throwable -> L20
        return r100;
    L25:
        return r100;
    L7:
        if (r101.length() < 22) goto L9;
        r100 = r100.replace(r101, "");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        tt5.a.l("StringUtils", "getUrl: ", th);
        return r100;
    }

    public static String h(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L10;
        int r101 = r100.indexOf("?");
        if (r101 > 0) goto L7;
        return r100;
    L7:
        if (r101 < r100.length()) goto L9;
        return r100;
    L9:
        return r100.substring(0, r101);
    L10:
        return r100;
    }

    public static String i(String r100) {
        return r100.replaceFirst("(?s)\n(?!.*?\n)", "");
    }

    public static String j(String r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return du5.b.g(r100);
    }

    public static String m(String r100) {
        int r101 = r100.length();
    L3:
        if (r101 <= 0) goto L8;
        if (r100.charAt(r101 - 1) > ' ') goto L8;
        r101 = r101 - 1;
    L8:
        if (r101 < r100.length()) goto L10;
        return r100;
    L10:
        return r100.substring(0, r101);
    }

    public static boolean a(String r100, String r101) {
        if (r100 == null) goto L7;
        if (r101 != null) goto L6;
        return false;
    L6:
        return TextUtils.equals(r100.toLowerCase(), r101.toLowerCase());
    L7:
        return false;
    }

    public static int b(String r100, String r101) {
        long r102 = g(r100, 0) - g(r101, 0);
        if (r102 != 0) goto L6;
        return 0;
    L6:
        if (r102 <= 0) goto L9;
        return 1;
    L9:
        return -1;
    }

    public static int f(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return r101;
    L10:
        return CastIntegerProtector.parseInt(r100);
    L7:
        e = move-exception;
        tt5.a.f("StringUtils", e, false);
        return r101;
    }

    public static long g(String r100, long r101) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return r101;
    L10:
        return CastLongProtector.parseLong(r100);
    L7:
        e = move-exception;
        tt5.a.f("StringUtils", e, false);
        return r101;
    }

    public static String k(String r100, int r101) {
        if (r101 > r100.length()) goto L20;
        if (r101 < 0) goto L21;
        if (r101 != 0) goto L10;
        return "";
    L10:
        if (r101 >= r100.length()) goto L16;
        boolean r102 = a.b(r100.charAt(r101 - 1));
        boolean r103 = a.b(r100.charAt(r101));
        if (r102 == false) goto L16;
        if (r103 == false) goto L16;
        r101 = r101 + 1;
    L16:
        return r100.substring(0, r101);
    L21:
        return r100;
    L20:
        return r100;
    }

    public static String l(List<String> r100, String r101) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.isEmpty() == true) goto L20;
        StringBuilder r102 = new StringBuilder();
        int r103 = 0;
    L8:
        if (r103 >= r100.size()) goto L14;
        r102.append((String) ListProtector.get(r100, r103));
        if (r103 == (r100.size() - 1)) goto L12;
        r102.append(r101);
    L12:
        r103 = r103 + 1;
        goto L8
    L14:
        return r102.toString();
    L20:
        return "";
    }
}
