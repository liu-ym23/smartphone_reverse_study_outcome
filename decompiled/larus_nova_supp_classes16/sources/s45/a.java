package s45;

import android.text.TextUtils;
import com.bytedance.ee.util.info.AppInfoUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {

    /* JADX INFO: renamed from: s45.a$a, reason: collision with other inner class name */
    public static final class C0288a {
        public final String a;
        public final String b;

        public String getType() {
            return this.a;
        }

        public C0288a(String r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static boolean c() {
        return Boolean.TRUE.equals(AppInfoUtils.f());
    L4:
        return false;
    }

    public static boolean b(String r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (TextUtils.isEmpty(r0) == true) goto L7;
        return false;
    }

    public static boolean d(String r2) {
        if (c() == true) goto L12;
        if (b(r2) == false) goto L7;
    L9:
        return false;
    L7:
        if (r2.startsWith("/record/") == false) goto L9;
        return true;
    L12:
        return !b(a(r2, "/share/base/record/"));
    }

    public static C0288a e(String r3) {
        if (c() == true) goto L5;
        return null;
    L5:
        String r0 = a(r3, "/share/base/record/");
        if (b(r0) == false) goto L8;
        String r4 = a(r3, "/share/base/add/");
        if (b(r4) == false) goto L12;
        return null;
    L12:
        return new C0288a(sbb.e.j.getType(), r4);
    L8:
        return new C0288a(sbb.e.i.getType(), r0);
    }

    public static String a(String r1, String r2) {
        if (b(r1) == false) goto L5;
    L16:
        return null;
    L5:
        if (r1.startsWith(r2) == false) goto L16;
        String r3 = r1.substring(r2.length());
        if (r3.length() == 0) goto L16;
        if (r3.endsWith("/") == true) goto L16;
        if (b(r3) == true) goto L16;
        if (r3.contains("/") == true) goto L16;
        return r3;
    }
}
