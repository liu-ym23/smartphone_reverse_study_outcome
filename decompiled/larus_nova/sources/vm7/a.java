package vm7;

import android.app.Application;
import com.bytedance.ug.sdk.luckyhost.api.api.ILuckyBaseService;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import en7.b;
import en7.c;
import java.lang.reflect.Proxy;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static ILuckyBaseService a() {
        Object r100 = en7.a.f473190e;
        en7.a r101 = en7.a.c.f473200a;
        r101.getClass();
        if (en7.a.e() == true) goto L18;
        if (r101.d() == false) goto L18;
        fn7.a r102 = new fn7.a();
        Set<String> r103 = c.f473206a;
        Object r104 = Proxy.newProxyInstance(fn7.a.class.getClassLoader(), fn7.a.class.getInterfaces(), new b(r102));     // Catch: Throwable -> L10
    L12:
        ILuckyBaseService r105 = (ILuckyBaseService) r104;
        if (r105 == null) goto L16;
        return r105;
    L16:
        return new fn7.a();
    L10:
        th = move-exception;
        th.getMessage();
        r104 = r102;
    L18:
        return new fn7.a();
    }

    public static void b(Application r110, an7.c r111) {
        Object r100 = en7.a.f473190e;
        en7.a r101 = en7.a.c.f473200a;
        if (r101.d() == false) goto L18;
        Object r102 = en7.a.f473190e;
        monitor-enter(r102);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (en7.a.e() == false) goto L11;
        com.bytedance.ug.sdk.luckydog.api.log.a.c("LuckyHostApiManager", "sdk has init, return");     // Catch: Throwable -> L16
        monitor-exit(r102);     // Catch: Throwable -> L16
    L20:
        return;
    L11:
        long r103 = System.currentTimeMillis();     // Catch: Throwable -> L16
        rk7.a.e("luckydog_init");     // Catch: Throwable -> L16
        ek7.b.b(r110, en7.a.c(r111));     // Catch: Throwable -> L16
        rk7.a.d("luckydog_init");     // Catch: Throwable -> L16
        long r104 = System.currentTimeMillis();     // Catch: Throwable -> L16
        rk7.a.e("luckycat_init");     // Catch: Throwable -> L16
        oi7.a.a(r110, en7.a.b(r111));     // Catch: Throwable -> L16
        rk7.a.d("luckycat_init");     // Catch: Throwable -> L16
        en7.a.g(System.currentTimeMillis() - r104, r104 - r103);     // Catch: Throwable -> L16
        r101.f();     // Catch: Throwable -> L16
        com.bytedance.ug.sdk.luckydog.api.log.a.c("LuckyHostApiManager", "init sdk with lock " + ThreadMethodProxy.currentThread() + " start : " + r103 + " end : " + System.currentTimeMillis());     // Catch: Throwable -> L16
        monitor-exit(r102);     // Catch: Throwable -> L16
        goto L20
    L18:
        long r105 = System.currentTimeMillis();
        rk7.a.e("luckycat_init");
        oi7.a.a(r110, en7.a.b(r111));
        rk7.a.d("luckycat_init");
        long r106 = System.currentTimeMillis();
        rk7.a.e("luckydog_init");
        ek7.b.b(r110, en7.a.c(r111));
        rk7.a.d("luckydog_init");
        en7.a.g(r106 - r105, System.currentTimeMillis() - r106);
        com.bytedance.ug.sdk.luckydog.api.log.a.c("LuckyHostApiManager", "init sdk without lock");
    }
}
