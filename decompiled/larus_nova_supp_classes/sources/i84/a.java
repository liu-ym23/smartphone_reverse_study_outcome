package i84;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.o0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class a {
    public static final C0008a a = null;

    /* JADX INFO: renamed from: i84.a$a, reason: collision with other inner class name */
    public static class C0008a extends r<SharedPreferences> {
        public C0008a() {
        }

        @Override // i84.r
        public final SharedPreferences a(Object[] r3) {
            return ((Context) r3[0]).getSharedPreferences("ug_install_settings_pref", 0);
        }
    }

    static {
        a = new C0008a();
    }

    public static SharedPreferences a(Context r3, o0 r4) {
        if (r4 == null) goto L10;
        if (r4.O == false) goto L8;
        return a.b(new Object[]{r3});
    L8:
        return r3.getSharedPreferences("ug_install_settings_pref_" + String.valueOf(r4.a), 0);
    L10:
        return a.b(new Object[]{r3});
    }

    public static String b(String r1, com.bytedance.bdinstall.b r2) {
        if (r2.c == false) goto L6;
        r1 = r1 + "_i18n";
    L6:
        if (r2.d == false) goto L9;
        r1 = r1 + "_boe";
    L9:
        if (r2.a == true) goto L11;
        return r1;
    L11:
        return r1 + "_cm";
    }
}
