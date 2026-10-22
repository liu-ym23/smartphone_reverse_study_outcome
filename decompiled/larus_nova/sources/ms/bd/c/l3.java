package ms.bd.c;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;

/* JADX INFO: loaded from: classes5.dex */
public abstract class l3 {
    public static String a(Context r100) {
        String r101 = b(r100.getContentResolver());     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return "null_";
    L6:
        if (r101.contains(HTTP.URL_DEFAULT) == false) goto L19;
        return r101.split(HTTP.URL_DEFAULT)[0];
    L19:
        return r101;
    L10:
        th = move-exception;
        return "null_" + th.getMessage();
    L21:
        return "null_";
    }

    public static String b(ContentResolver r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r110, "default_input_method"};
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, null, r111, false);
        return (String) r112.f474983b;
    L6:
        String r113 = Settings.Secure.getString(r110, "default_input_method");
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, r113, r111, true);
        return r113;
    }
}
