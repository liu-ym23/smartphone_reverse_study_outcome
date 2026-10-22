package hvc;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import me.ele.lancet.base.annotations.Skip;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes42.dex */
public final class e extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f487385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Method f487386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Method f487387e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Class<?> f487388f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Class<?> f487389g;

    public static class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f487390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f487391b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f487392c;

        public a(List<String> r100) {
            this.f487390a = r100;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
            String r103 = r101.getName();
            Class<?> r104 = r101.getReturnType();
            if (r102 != null) goto L6;
            r102 = cvc.c.f465514b;
        L6:
            if (r103.equals("supports") == false) goto L12;
            if (Boolean.TYPE != r104) goto L12;
            return Boolean.TRUE;
        L12:
            if (r103.equals("unsupported") == false) goto L18;
            if (Void.TYPE != r104) goto L18;
            this.f487391b = true;
            return null;
        L18:
            if (r103.equals("protocols") == false) goto L24;
            if (r102.length != 0) goto L24;
            return this.f487390a;
        L24:
            if (r103.equals("selectProtocol") == true) goto L28;
            if (r103.equals("select") == true) goto L28;
        L43:
            if (r103.equals("protocolSelected") == true) goto L47;
            if (r103.equals("selected") == true) goto L47;
        L51:
            return r101.invoke(this, r102);
        L47:
            if (r102.length != 1) goto L51;
            this.f487392c = (String) r102[0];
            return null;
        L28:
            if (String.class != r104) goto L43;
            if (r102.length != 1) goto L43;
            Object r105 = r102[0];
            if ((r105 instanceof List) == false) goto L43;
            List r106 = (List) r105;
            int r107 = r106.size();
            int r108 = 0;
        L34:
            if (r108 >= r107) goto L40;
            if (this.f487390a.contains(ListProtector.get(r106, r108)) == true) goto L37;
            r108 = r108 + 1;
            goto L34
        L37:
            String r109 = (String) ListProtector.get(r106, r108);
            this.f487392c = r109;
            return r109;
        L40:
            String r110 = (String) ListProtector.get(this.f487390a, 0);
            this.f487392c = r110;
            return r110;
        }
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class q(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    @Override // hvc.g
    public final void b(SSLSocket r100) {
        this.f487387e.invoke(null, new Object[]{r100});     // Catch: InvocationTargetException -> L4 Throwable -> L6
        return;
    L6:
        e = move-exception;
        throw cvc.c.a("unable to remove alpn", e);
    }

    @Override // hvc.g
    @Nullable
    public final String j(SSLSocket r100) {
        a r101 = (a) Proxy.getInvocationHandler(this.f487386d.invoke(null, new Object[]{r100}));     // Catch: IllegalAccessException -> L12 Throwable -> L14
        boolean r102 = r101.f487391b;     // Catch: IllegalAccessException -> L12 Throwable -> L14
        if (r102 == false) goto L5;
    L8:
        if (r102 == false) goto L11;
        return null;
    L11:
        return r101.f487392c;
    L5:
        if (r101.f487392c != null) goto L8;
        g.f487396a.m(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);     // Catch: IllegalAccessException -> L12 Throwable -> L14
        return null;
    L14:
        e = move-exception;
        throw cvc.c.a("unable to get selected protocol", e);
    }

    @Override // hvc.g
    public final void g(SSLSocket r100, String r101, List<Protocol> r102) {
        List<String> r103 = g.c(r102);
        Object r104 = Proxy.newProxyInstance(g.class.getClassLoader(), new Class[]{this.f487388f, this.f487389g}, new a(r103));     // Catch: IllegalAccessException -> L5 Throwable -> L7
        this.f487385c.invoke(null, new Object[]{r100, r104});     // Catch: IllegalAccessException -> L5 Throwable -> L7
        return;
    L7:
        e = move-exception;
        throw cvc.c.a("unable to set alpn", e);
    }

    public e(Method r100, Method r101, Method r102, Class<?> r103, Class<?> r104) {
        this.f487385c = r100;
        this.f487386d = r101;
        this.f487387e = r102;
        this.f487388f = r103;
        this.f487389g = r104;
    }
}
