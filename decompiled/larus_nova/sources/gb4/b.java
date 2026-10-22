package gb4;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f480679c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f480680d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f480681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f480682b;

    static {
        f480679c = PatternProtector.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
        f480680d = PatternProtector.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }

    public final int hashCode() {
        return this.f480681a.hashCode();
    }

    public final String toString() {
        return this.f480681a;
    }

    public static b a(String r100) {
        Matcher r101 = f480679c.matcher(r100);
        if (r101.lookingAt() == true) goto L5;
        return null;
    L5:
        String r102 = r101.group(1);
        Locale r103 = Locale.US;
        String r104 = r102.toLowerCase(r103);
        r101.group(2).toLowerCase(r103);
        Matcher r105 = f480680d.matcher(r100);
        int r106 = r101.end();
        String r107 = null;
    L7:
        if (r106 >= r100.length()) goto L33;
        r105.region(r106, r100.length());
        if (r105.lookingAt() == false) goto L10;
        String r108 = r105.group(1);
        if (r108 == null) goto L31;
        if ("charset".equalsIgnoreCase(r108) == false) goto L31;
        String r109 = r105.group(2);
        if (r109 != null) goto L19;
        r109 = r105.group(3);
    L26:
        if (r107 != null) goto L28;
    L30:
        r107 = r109;
        goto L31
    L28:
        if (r109.equalsIgnoreCase(r107) == true) goto L30;
        return null;
    L19:
        if (r109.startsWith("'") == false) goto L26;
        if (r109.endsWith("'") == false) goto L26;
        if (r109.length() <= 2) goto L26;
        r109 = r109.substring(1, r109.length() - 1);
    L31:
        r106 = r105.end();
        goto L7
    L10:
        return null;
    L33:
        return new b(r100, r104, r107);
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof b) == true) goto L5;
    L7:
        return false;
    L5:
        if (((b) r100).f480681a.equals(this.f480681a) == false) goto L7;
        return true;
    }

    public b(String r100, String r101, String r102) {
        this.f480681a = r100;
        this.f480682b = r101;
    }
}
