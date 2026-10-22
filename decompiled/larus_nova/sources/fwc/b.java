package fwc;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;
import java.util.regex.Pattern;
import tb2.c;

/* JADX INFO: loaded from: classes42.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f479045a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f479046b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f479047c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f479048d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f479049e = null;

    public class a extends ThreadLocal<Stack<StringBuilder>> {
        @Override // java.lang.ThreadLocal
        public final Stack<StringBuilder> initialValue() {
            return new Stack();
        }

        public a() {
        }
    }

    public static boolean e(int r100) {
        if (r100 != 32) goto L5;
    L14:
        return true;
    L5:
        if (r100 == 9) goto L14;
        if (r100 == 10) goto L14;
        if (r100 == 12) goto L14;
        if (r100 == 13) goto L14;
        return false;
    }

    static {
        f479045a = new String[]{"", " ", c.DEFAULT_TEXT, "   ", LineContent.FOUR_SPACE, "     ", "      ", "       ", "        ", "         ", "          ", "           ", "            ", "             ", "              ", "               ", "                ", "                 ", "                  ", "                   ", "                    "};
        f479046b = PatternProtector.compile("^/((\\.{1,2}/)+)");
        f479047c = PatternProtector.compile("^[a-zA-Z][a-zA-Z0-9+-.]*:");
        f479048d = PatternProtector.compile("[\\x00-\\x1f]*");
        f479049e = new a();
    }

    public static StringBuilder b() {
        Stack<StringBuilder> r100 = f479049e.get();
        if (r100.empty() == false) goto L6;
        return new StringBuilder(8192);
    L6:
        return r100.pop();
    }

    public static boolean d(String r100) {
        if (r100 != null) goto L5;
    L13:
        return true;
    L5:
        if (r100.length() == 0) goto L13;
        int r101 = r100.length();
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L13;
        if (e(r100.codePointAt(r102)) == false) goto L11;
        r102 = r102 + 1;
        goto L8
    L11:
        return false;
    }

    public static String g(StringBuilder r100) {
        ewc.b.d(r100);
        String r101 = r100.toString();
        if (r100.length() <= 8192) goto L5;
        r100 = new StringBuilder(8192);
    L6:
        Stack<StringBuilder> r102 = f479049e.get();
        r102.push(r100);
    L8:
        if (r102.size() <= 8) goto L10;
        r102.pop();
        goto L8
    L10:
        return r101;
    L5:
        r100.delete(0, r100.length());
        goto L6
    }

    public static boolean c(String r100, String[] r101) {
        if (Arrays.binarySearch(r101, r100) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static String f(Collection<?> r100, String r101) {
        Iterator<?> r102 = r100.iterator();
        if (r102.hasNext() == true) goto L5;
        return "";
    L5:
        String r103 = r102.next().toString();
        if (r102.hasNext() == false) goto L16;
        StringBuilder r104 = b();
        ewc.b.d(r104);
        r104.append(r103);
    L10:
        if (r102.hasNext() == false) goto L13;
        Object r105 = r102.next();
        r104.append(r101);
        r104.append(r105);
        goto L10
    L13:
        return g(r104);
    L16:
        return r103;
    }

    public static URL h(URL r100, String r101) throws MalformedURLException {
        String r102 = f479048d.matcher(r101).replaceAll("");
        if (r102.startsWith("?") == false) goto L5;
        r102 = r100.getPath() + r102;
    L5:
        URL r103 = new URL(r100, r102);
        String r104 = f479046b.matcher(r103.getFile()).replaceFirst(HTTP.URL_DEFAULT);
        if (r103.getRef() == null) goto L9;
        r104 = r104 + "#" + r103.getRef();
    L9:
        return new URL(r103.getProtocol(), r103.getHost(), r103.getPort(), r104);
    }

    public static void a(StringBuilder r100, String r110, boolean r111) {
        int r101 = r110.length();
        int r102 = 0;
        boolean r103 = false;
        boolean r104 = false;
    L3:
        if (r102 >= r101) goto L35;
        int r105 = r110.codePointAt(r102);
        if (r105 != 32) goto L7;
    L18:
        boolean r106 = true;
    L19:
        if (r106 == false) goto L26;
        if (r111 == false) goto L22;
        if (r103 == true) goto L22;
    L34:
        r102 = r102 + Character.charCount(r105);
    L22:
        if (r104 == true) goto L34;
        r100.append(' ');
        r104 = true;
        goto L34
    L26:
        if (r105 != 8203) goto L28;
    L31:
        boolean r107 = true;
    L32:
        if (r107 == true) goto L34;
        r100.appendCodePoint(r105);
        r103 = true;
        r104 = false;
        goto L34
    L28:
        if (r105 == 173) goto L31;
        r107 = false;
        goto L32
    L7:
        if (r105 == 9) goto L18;
        if (r105 == 10) goto L18;
        if (r105 == 12) goto L18;
        if (r105 == 13) goto L18;
        if (r105 == 160) goto L18;
        r106 = false;
        goto L19
    }
}
