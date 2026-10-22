package m57;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import com.bytedance.platform.godzilla.anr.sp.ConcurrentLinkedQueueProxy;
import com.bytedance.platform.godzilla.anr.sp.LinkedListProxyForFinishers;
import com.bytedance.platform.godzilla.anr.sp.LinkedListProxyForWorks;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.PluginState;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import o57.b;
import o57.c;
import o57.d;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends t57.a {
    @Override // t57.a
    public final String b() {
        return "SpPlugin";
    }

    @Override // t57.a
    public final void d() {
        PluginState r100 = PluginState.INITIALIZED;
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 26) goto L18;
        System.currentTimeMillis();
        Field r102 = d.a().getDeclaredField("sPendingWorkFinishers");     // Catch: Exception -> L12
        r102.setAccessible(true);     // Catch: Exception -> L11
        ConcurrentLinkedQueue r103 = (ConcurrentLinkedQueue) r102.get(null);     // Catch: Exception -> L11
        if (r103 != null) goto L52;
    L16:
        System.currentTimeMillis();
    L48:
        Logger.a("SpPlugin", "start");
        return;
    L52:
        r102.set(null, new ConcurrentLinkedQueueProxy(r103));     // Catch: Exception -> L10
    L13:
        if (r103 == null) goto L16;
        if (r102 == null) goto L16;
        r102.set(null, r103);     // Catch: Exception -> L50
    L11:
        r103 = null;
    L12:
        r102 = null;
        r103 = null;
        goto L13
    L18:
        if (r101 > 29) goto L48;
        Class r104 = c.a("android.app.QueuedWork");     // Catch: Exception -> L51
        Field r105 = u57.a.a(r104, "sFinishers");     // Catch: Exception -> L51
        if (r105 == null) goto L48;
        r105.setAccessible(true);     // Catch: Exception -> L51
        LinkedList r106 = (LinkedList) r105.get(null);     // Catch: Exception -> L51
        if (r106 == null) goto L26;
        r105.set(null, new LinkedListProxyForFinishers(r106));     // Catch: Exception -> L51
    L26:
        Field r107 = u57.a.a(r104, "sWork");     // Catch: Exception -> L51
        if (r107 == null) goto L48;
        r107.setAccessible(true);     // Catch: Exception -> L51
        LinkedList r108 = (LinkedList) r107.get(null);     // Catch: Exception -> L51
        if (r108 == null) goto L32;
        LinkedListProxyForWorks r109 = new LinkedListProxyForWorks(r108);     // Catch: Exception -> L51
        c.f522103b = r109;     // Catch: Exception -> L51
        r107.set(null, r109);     // Catch: Exception -> L51
    L32:
        Method r110 = u57.d.a(r104, "getHandler", new Class[0]);     // Catch: Exception -> L51
        if (r110 == null) goto L48;
        r110.setAccessible(true);     // Catch: Exception -> L51
        Handler r111 = (Handler) r110.invoke(null, new Object[0]);     // Catch: Exception -> L51
        c.f522102a = r111;     // Catch: Exception -> L51
        if (r111 == null) goto L47;
        Field r112 = u57.a.a(c.a(Handler.class.getName()), "mCallback");     // Catch: ClassNotFoundException -> L43 IllegalAccessException -> L45 Exception -> L51
        if (r112 == null) goto L47;
        r112.setAccessible(true);     // Catch: ClassNotFoundException -> L43 IllegalAccessException -> L45 Exception -> L51
        r112.set(r111, new b());     // Catch: ClassNotFoundException -> L43 IllegalAccessException -> L45 Exception -> L51
    L43:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L51
    L45:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L51
    L47:
        System.currentTimeMillis();
        goto L48
    }

    public a() {
    }

    @Override // t57.a
    public final void c(Application r100) {
        PluginState r101 = PluginState.INITIALIZED;
    }
}
