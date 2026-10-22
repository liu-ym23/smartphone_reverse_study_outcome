package n1;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.apm.lite.k.h;
import f06.d;
import java.util.UUID;
import r1.o;

/* JADX INFO: loaded from: classes39.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile UUID f516641a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f516642b = "";

    public a(Context r100) {
        if (f516641a == null) goto L5;
        return;
    L5:
        monitor-enter(a.class);
    L26:
        th = move-exception;
        throw th;
    L7:
        if (f516641a != null) goto L24;
        o r101 = o.b();     // Catch: Throwable -> L26
        r101.getClass();     // Catch: Throwable -> L26
        String r102 = null;
        String r103 = h.b(r101.f535580c.getAbsolutePath());     // Catch: Throwable -> L12
    L13:
        if (r103 == null) goto L34;
        f516641a = UUID.fromString(r103);     // Catch: Throwable -> L26
        goto L24
    L34:
        r102 = b(r100.getContentResolver());     // Catch: Throwable -> L18
    L36:
        if (r102 == null) goto L21;
        UUID r104 = UUID.nameUUIDFromBytes(r102.getBytes("utf8"));     // Catch: Throwable -> L30
    L22:
        f516641a = r104;     // Catch: Throwable -> L30
        goto L38
    L21:
        r104 = UUID.randomUUID();     // Catch: Throwable -> L30
    L38:
        o r105 = o.b();     // Catch: Throwable -> L31
        String r106 = f516641a.toString();     // Catch: Throwable -> L31
        r105.getClass();     // Catch: Throwable -> L31
        h.h(r105.f535580c, r106, false);     // Catch: Throwable -> L31
    L12:
        r103 = null;
    L24:
        monitor-exit(a.class);     // Catch: Throwable -> L26
    }

    public static synchronized String a(Context r100) {
        monitor-enter(a.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(f516642b) == false) goto L9;
        new a(r100);     // Catch: Throwable -> L12
        UUID r101 = f516641a;     // Catch: Throwable -> L12
        if (r101 == null) goto L9;
        f516642b = r101.toString();     // Catch: Throwable -> L12
    L9:
        String r102 = f516642b;     // Catch: Throwable -> L12
        monitor-exit(a.class);
        return r102;
    }

    public static String b(ContentResolver r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r110, "android_id"};
        f06.b r111 = new f06.b();
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
