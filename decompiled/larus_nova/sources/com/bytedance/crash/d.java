package com.bytedance.crash;

import android.os.Process;
import android.text.TextUtils;
import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Map;
import javax.net.ssl.SSLException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f203142a = 0;

    public static void b(String r100) {
        com.bytedance.crash.monitor.j.c().e(r100, 4);
    }

    public static void c(Throwable r100) {
        if (g(r100) == false) goto L5;
        return;
    L5:
        fh4.f r101 = com.bytedance.crash.monitor.j.c();
        if (r101.d("core_exception_monitor", null) == false) goto L8;
        com.bytedance.crash.util.p.e("reportThrowable：isDrop:");
        return;
    L8:
        r101.g(null, null, r100, "core_exception_monitor");
    }

    public static boolean g(Throwable r100) {
        if (r100 != null) goto L39;
        return true;
    L39:
    L35:
        th = move-exception;
        th.printStackTrace();
        return false;
    L6:
        if ((r100 instanceof ConnectTimeoutException) == false) goto L9;
        return true;
    L9:
        if ((r100 instanceof SocketTimeoutException) == false) goto L12;
        return true;
    L12:
        if ((r100 instanceof BindException) == false) goto L15;
        return true;
    L15:
        if ((r100 instanceof ConnectException) == false) goto L18;
        return true;
    L18:
        if ((r100 instanceof NoRouteToHostException) == false) goto L21;
        return true;
    L21:
        if ((r100 instanceof PortUnreachableException) == false) goto L24;
        return true;
    L24:
        if ((r100 instanceof SocketException) == false) goto L27;
        return true;
    L27:
        if ((r100 instanceof UnknownHostException) == false) goto L30;
        return true;
    L30:
        if ((r100 instanceof ProtocolException) == false) goto L32;
        return true;
    L32:
        if ((r100 instanceof SSLException) == false) goto L41;
        return true;
    L41:
        return false;
    }

    public static void d(Throwable r100, String r101) {
        if (g(r100) == false) goto L5;
        return;
    L5:
        com.bytedance.crash.monitor.j.c().g(r101, null, r100, "core_exception_monitor");
    }

    public static void e(Throwable r100, String r101, Map<String, String> r102) {
        if (g(r100) == false) goto L5;
        return;
    L5:
        com.bytedance.crash.monitor.j.c().g(r101, r102, r100, "core_exception_monitor");
    }

    public static void f(String r100, Throwable r101, String r102) {
        if (g(r101) == false) goto L5;
        return;
    L5:
        com.bytedance.crash.monitor.j.c().g(r102, null, r101, r100);
    }

    public static void a(String r110, String r111, String r112, String r113, Map<String, String> r114) {
        fh4.f r100 = com.bytedance.crash.monitor.j.c();
        r100.getClass();
        String r101 = null;
        if (TextUtils.isEmpty(null) == false) goto L5;
        r101 = "core_exception_monitor";
    L5:
        String r102 = r101;
        if (r100.d(r102, r113) == false) goto L8;
        com.bytedance.crash.util.p.e("reportNativeEnsure：isDrop:" + r102 + " " + r113);
        return;
    L8:
        r100.f(new fh4.g(r111, r110, r113, r114, r112, r102, Process.myPid()));
    }
}
