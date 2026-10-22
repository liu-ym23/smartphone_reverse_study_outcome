package u7b;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f549131a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f549132b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f549133c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C7845a f549134d = null;

    /* JADX INFO: renamed from: u7b.a$a, reason: collision with other inner class name */
    public class C7845a {
        public C7845a() {
        }

        public final void a(String r100, StringBuilder r101) {
            if (r100.charAt(0) != '\\') goto L5;
            r101.append(r100, 1, r100.length());
            return;
        L5:
            r101.append(b.a(r100));
        }
    }

    static {
        f549131a = PatternProtector.compile("[\\\\&]");
        f549132b = PatternProtector.compile("\\\\[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]|&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);
        PatternProtector.compile("(%[a-fA-F0-9]{0,2}|[^:/?#@!$&'()*+,;=a-zA-Z0-9\\-._~])");
        f549133c = PatternProtector.compile("[ \t\r\n]+");
        f549134d = new C7845a();
    }

    public static String a(String r100) {
        String r101 = r100.trim();
        Locale r102 = Locale.ROOT;
        String r103 = r101.toLowerCase(r102).toUpperCase(r102);
        return f549133c.matcher(r103).replaceAll(" ");
    }

    public static String b(String r100) {
        if (f549131a.matcher(r100).find() == false) goto L17;
        Pattern r101 = f549132b;
        C7845a r102 = f549134d;
        Matcher r103 = r101.matcher(r100);
        if (r103.find() == false) goto L18;
        StringBuilder r104 = new StringBuilder(r100.length() + 16);
        int r105 = 0;
    L8:
        r104.append(r100, r105, r103.start());
        r102.a(r103.group(), r104);
        r105 = r103.end();
        if (r103.find() == true) goto L8;
        if (r105 == r100.length()) goto L14;
        r104.append(r100, r105, r100.length());
    L14:
        return r104.toString();
    L18:
        return r100;
    L17:
        return r100;
    }
}
