package jta;

import android.content.Context;
import android.text.TextUtils;
import kta.u;

/* JADX INFO: loaded from: classes6.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static mta.a f500378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f500379b;

    public h() {
    }

    public static mta.a a(Context r100) throws IllegalArgumentException {
        if (g.f500368b == false) goto L33;
        if (f500378a != null) goto L31;
        monitor-enter(h.class);
    L27:
        th = move-exception;
        throw th;
    L9:
        if (f500378a != null) goto L25;
        if (r100 == null) goto L24;
        if (b(r100) == false) goto L21;
        k r101 = (k) ota.b.a(k.class);     // Catch: Exception -> L19 Throwable -> L27
        if (r101.b() == false) goto L17;
        r101.clearCache();     // Catch: Exception -> L19 Throwable -> L27
    L17:
        f500378a = r101.d();     // Catch: Exception -> L19 Throwable -> L27
        ita.j.b("DRParameterFactory create new user device param provider & NewUserModeManager success", null);     // Catch: Exception -> L19 Throwable -> L27
    L19:
        ita.j.g("DRParameterFactoryclass com.ss.android.deviceregister.newuser.NewUserModeManager not fount", null);     // Catch: Throwable -> L27
    L21:
        if (f500378a != null) goto L25;
        g.f500376j.isLocalTest();     // Catch: Throwable -> L27
        f500378a = new e(r100, false);     // Catch: Throwable -> L27
        goto L25
    L24:
        throw new IllegalArgumentException("context == null");     // Catch: Throwable -> L27
    L25:
        monitor-exit(h.class);     // Catch: Throwable -> L27
    L31:
        return f500378a;
    L33:
        throw new IllegalStateException("please init TeaAgent first");
    }

    public static boolean b(Context r100) {
        if (r100 != null) goto L5;
    L15:
        StringBuilder r101 = new StringBuilder("DRParameterFactory #isNewUserMode false. context=");
        r101.append(r100);
        r101.append(" isDebugChannel()=");
        if (TextUtils.isEmpty(f500379b) == false) goto L18;
        f500379b = u.f506137a;
    L18:
        r101.append("local_test".equals(f500379b));
        ita.j.b(r101.toString(), null);
        return false;
    L5:
        if (TextUtils.isEmpty(f500379b) == false) goto L8;
        f500379b = u.f506137a;
    L8:
        if ("local_test".equals(f500379b) == true) goto L10;
        g r102 = g.f500367a;
        goto L15
    L10:
        k r103 = (k) ota.b.a(k.class);
        if (r103 != null) goto L13;
        return false;
    L13:
        return r103.c();
    }
}
