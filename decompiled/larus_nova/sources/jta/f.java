package jta;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes6.dex */
public final class f {
    public static void a(Context r100, boolean r101, com.ss.android.common.applog.b r102, boolean r103, boolean r104, boolean r105, boolean r106) {
        g.f500376j.o(r101);
        g.f500376j.h(r102);
        g.f500376j.setAnonymous(r103);
        g.f500376j.q(r104);
        if (r100 == null) goto L24;
        g.f500368b = true;
        if ((r100 instanceof Activity) == false) goto L7;
        g.f500376j.q(true);
    L7:
        g.f500369c = r100.getApplicationContext();
        if (g.f500367a != null) goto L20;
        monitor-enter(g.class);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (g.f500367a != null) goto L14;
        g.f500367a = new g(r105, r106);     // Catch: Throwable -> L16
        g.f500367a.getClass();     // Catch: Throwable -> L16
        g.f500376j.a(r100);     // Catch: Throwable -> L16
    L14:
        monitor-exit(g.class);     // Catch: Throwable -> L16
    L20:
        if (Logger.debug() == false) goto L27;
        ita.j.b("DeviceRegister init, DeviceRegister : " + g.f500367a.toString() + ", process : " + Process.myPid(), null);
        return;
    L27:
        return;
    L24:
        throw new IllegalArgumentException("context = null");
    }
}
