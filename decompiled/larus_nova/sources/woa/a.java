package woa;

import android.content.ContentResolver;
import android.provider.Settings;
import f06.b;
import f06.c;
import f06.d;

/* JADX INFO: loaded from: classes34.dex */
public final class a {
    public static String a(ContentResolver r110) {
        c r100 = new c();
        Object[] r101 = {r110, "android_id"};
        b r111 = new b();
        d r112 = r100.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, null, r111, false);
        return (String) r112.f474983b;
    L6:
        String r113 = Settings.Secure.getString(r110, "android_id");
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, r113, r111, true);
        return r113;
    }
}
