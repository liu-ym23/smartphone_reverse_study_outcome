package i84;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.o0;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C6241a f488614a = null;

    /* JADX INFO: renamed from: i84.a$a, reason: collision with other inner class name */
    public static class C6241a extends r<SharedPreferences> {
        public C6241a() {
        }

        @Override // i84.r
        public final SharedPreferences a(Object[] r100) {
            return ((Context) r100[0]).getSharedPreferences("ug_install_settings_pref", 0);
        }
    }

    static {
        f488614a = new C6241a();
    }

    public static SharedPreferences a(Context r100, o0 r101) {
        if (r101 == null) goto L10;
        if (r101.O == false) goto L8;
        return f488614a.b(new Object[]{r100});
    L8:
        return r100.getSharedPreferences("ug_install_settings_pref_" + String.valueOf(r101.f199728a), 0);
    L10:
        return f488614a.b(new Object[]{r100});
    }

    public static String b(String r100, com.bytedance.bdinstall.b r101) {
        if (r101.f199615c == false) goto L6;
        r100 = r100 + "_i18n";
    L6:
        if (r101.f199616d == false) goto L9;
        r100 = r100 + "_boe";
    L9:
        if (r101.f199613a == true) goto L11;
        return r100;
    L11:
        return r100 + "_cm";
    }
}
