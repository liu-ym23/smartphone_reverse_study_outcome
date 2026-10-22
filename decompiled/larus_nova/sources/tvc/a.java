package tvc;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes42.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f547710a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f547711b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f547712c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C7784a f547713d = null;

    /* JADX INFO: renamed from: tvc.a$a, reason: collision with other inner class name */
    public static class C7784a {
        public C7784a() {
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
        f547710a = PatternProtector.compile("[\\\\&]");
        f547711b = PatternProtector.compile("\\\\[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]|&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);
        PatternProtector.compile("(%[a-fA-F0-9]{0,2}|[^:/?#@!$&'()*+,;=a-zA-Z0-9\\-._~])");
        f547712c = PatternProtector.compile("[ \t\r\n]+");
        f547713d = new C7784a();
    }

    public static String a(String r100) {
        if (f547710a.matcher(r100).find() == false) goto L17;
        Pattern r101 = f547711b;
        C7784a r102 = f547713d;
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
