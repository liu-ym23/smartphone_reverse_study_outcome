package hvc;

import android.os.Build;
import android.util.Log;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import me.ele.lancet.base.annotations.Skip;
import okhttp3.Protocol;
import okio.Buffer;

/* JADX INFO: loaded from: classes5.dex */
public class b extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class<?> f487370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f<Socket> f487371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f<Socket> f487372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f<Socket> f487373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f<Socket> f487374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f487375h;

    public static final class a extends jvc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f487376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f487377b;

        public final int hashCode() {
            return 0;
        }

        public final boolean equals(Object r100) {
            return r100 instanceof a;
        }

        public a(Object r100, Method r101) {
            this.f487376a = r100;
            this.f487377b = r101;
        }

        @Override // jvc.c
        public final List<Certificate> a(List<Certificate> r100, String r101) throws SSLPeerUnverifiedException {
            X509Certificate[] r102 = (X509Certificate[]) r100.toArray(new X509Certificate[r100.size()]);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L7
            return (List) this.f487377b.invoke(this.f487376a, new Object[]{r102, com.alipay.sdk.m.n.d.f25615a, r101});
        L4:
            e = move-exception;
            throw new AssertionError(e);
        L7:
            e = move-exception;
            SSLPeerUnverifiedException r103 = new SSLPeerUnverifiedException(e.getMessage());
            r103.initCause(e);
            throw r103;
        }
    }

    /* JADX INFO: renamed from: hvc.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes42.dex */
    public static final class C6205b implements jvc.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final X509TrustManager f487378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f487379b;

        public final int hashCode() {
            return this.f487378a.hashCode() + (this.f487379b.hashCode() * 31);
        }

        @Override // jvc.e
        public final X509Certificate a(X509Certificate r100) {
            TrustAnchor r101 = (TrustAnchor) this.f487379b.invoke(this.f487378a, new Object[]{r100});     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L8
            if (r101 == null) goto L6;
            goto L6
        L14:
            return r101.getTrustedCert();
        L8:
            e = move-exception;
            throw cvc.c.a("unable to get issues and signature", e);
        L6:
            return null;
        }

        public final boolean equals(Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if ((r100 instanceof C6205b) == true) goto L8;
            return false;
        L8:
            C6205b r101 = (C6205b) r100;
            if (this.f487378a.equals(r101.f487378a) == true) goto L11;
        L13:
            return false;
        L11:
            if (this.f487379b.equals(r101.f487379b) == false) goto L13;
            return true;
        }

        public C6205b(X509TrustManager r100, Method r101) {
            this.f487379b = r101;
            this.f487378a = r100;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f487380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f487381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f487382c;

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a() throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r102 = Class.forName("dalvik.system.CloseGuard");     // Catch: Throwable -> L8
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("dalvik.system.CloseGuard");     // Catch: Throwable -> L8
        L7:
            return r102;
        L8:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("dalvik.system.CloseGuard");
        L12:
            throw th;
        L34:
            Class<?> r103 = Class.forName("dalvik.system.CloseGuard");     // Catch: Throwable -> L17
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("dalvik.system.CloseGuard");     // Catch: Throwable -> L17
        L16:
            return r103;
        L17:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("dalvik.system.CloseGuard");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("dalvik.system.CloseGuard");
        }

        public c(Method r100, Method r101, Method r102) {
            this.f487380a = r100;
            this.f487381b = r101;
            this.f487382c = r102;
        }
    }

    @Override // hvc.g
    public final SSLContext i() {
        boolean r100 = true;
        if (Build.VERSION.SDK_INT < 22) goto L9;
        r100 = false;
    L9:
        if (r100 == false) goto L20;
        return SSLContext.getInstance("TLSv1.2");
    L20:
        return SSLContext.getInstance("TLS");
    L14:
        e = move-exception;
        throw new IllegalStateException("No TLS provider", e);
    }

    @Override // hvc.g
    public final Object k() {
        c r100 = this.f487375h;
        Method r101 = r100.f487380a;
        if (r101 != null) goto L9;
        return null;
    L9:
        Object r102 = r101.invoke(null, new Object[0]);     // Catch: Exception -> L8
        r100.f487381b.invoke(r102, new Object[]{"response.body().close()"});     // Catch: Exception -> L8
        return r102;
    L12:
        return null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class q(ClassLoader r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == false) goto L34;
        Class<?> r103 = Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.google.android.gms.org.conscrypt.SSLParametersImpl");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.google.android.gms.org.conscrypt.SSLParametersImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl");
    L34:
        Class<?> r104 = Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.google.android.gms.org.conscrypt.SSLParametersImpl");     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.google.android.gms.org.conscrypt.SSLParametersImpl");
    L12:
        throw th;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class r(String r100) throws ClassNotFoundException {
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
    public final jvc.c d(X509TrustManager r100) {
        Class r101 = r("android.net.http.X509TrustManagerExtensions");     // Catch: Exception -> L4
        return new a(r101.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{r100}), r101.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class}));
    L5:
        return super.d(r100);
    }

    @Override // hvc.g
    public final jvc.e e(X509TrustManager r100) {
        Method r101 = r100.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});     // Catch: NoSuchMethodException -> L4
        r101.setAccessible(true);     // Catch: NoSuchMethodException -> L4
        return new C6205b(r100, r101);
    L5:
        return super.e(r100);
    }

    @Override // hvc.g
    @Nullable
    public String j(SSLSocket r100) {
        f<Socket> r101 = this.f487373f;
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r101.a(r100.getClass()) == null) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        return null;
    L11:
        f<Socket> r103 = this.f487373f;
        Object[] r104 = new Object[0];
        r103.getClass();
        byte[] r105 = (byte[]) r103.b(r100, r104);
        if (r105 != null) goto L16;
        return null;
    L16:
        return new String(r105, cvc.c.f465522j);
    L17:
        e = move-exception;
        Throwable r106 = e.getTargetException();
        if ((r106 instanceof RuntimeException) == true) goto L21;
        AssertionError r107 = new AssertionError("Unexpected exception");
        r107.initCause(r106);
        throw r107;
    L21:
        throw ((RuntimeException) r106);
    L8:
        r102 = false;
        goto L9
    }

    @Override // hvc.g
    public final boolean l(String r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L15;
        return true;
    L15:
        Class r101 = r("android.security.NetworkSecurityPolicy");     // Catch: InvocationTargetException -> L7 IllegalArgumentException -> L9 IllegalAccessException -> L11 Throwable -> L14
        return s(r100, r101, r101.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
    L14:
        return true;
    L11:
        e = e;
    L13:
        throw cvc.c.a("unable to determine cleartext support", e);
    L9:
        e = e;
    L7:
        e = e;
        goto L13
    }

    @Override // hvc.g
    @Nullable
    public final X509TrustManager p(SSLSocketFactory r100) {
        Object r101 = g.o(r100, this.f487370c, "sslParameters");
        if (r101 == null) goto L13;
    L8:
        X509TrustManager r102 = (X509TrustManager) g.o(r101, X509TrustManager.class, "x509TrustManager");
        if (r102 == null) goto L12;
        return r102;
    L12:
        return (X509TrustManager) g.o(r101, X509TrustManager.class, "trustManager");
    L13:
        r101 = g.o(r100, q(r100.getClass().getClassLoader()), "sslParameters");     // Catch: ClassNotFoundException -> L6
    L7:
        return super.p(r100);
    }

    @Override // hvc.g
    public final void n(String r100, Object r101) {
        c r102 = this.f487375h;
        r102.getClass();
        boolean r103 = false;
        if (r101 != null) goto L10;
    L7:
        if (r103 == true) goto L12;
        m(5, r100, null);
        return;
    L12:
        return;
    L10:
        r102.f487382c.invoke(r101, new Object[0]);     // Catch: Exception -> L6
        r103 = true;
        goto L7
    }

    public static boolean s(String r100, Class r101, Object r102) throws InvocationTargetException, IllegalAccessException {
        return ((Boolean) r101.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(r102, new Object[]{r100})).booleanValue();
    L5:
        return ((Boolean) r101.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(r102, new Object[0])).booleanValue();
    L11:
        return true;
    }

    @Override // hvc.g
    public void g(SSLSocket r100, String r101, List<Protocol> r102) throws IOException {
        if (r101 == null) goto L5;
        this.f487371d.c(r100, new Object[]{Boolean.TRUE});
        this.f487372e.c(r100, new Object[]{r101});
    L5:
        f<Socket> r103 = this.f487374g;
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.a(r100.getClass()) == null) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L35;
        Object[] r105 = new Object[1];
        Buffer r106 = new Buffer();
        int r107 = r102.size();
        int r108 = 0;
    L13:
        if (r108 >= r107) goto L19;
        Protocol r109 = (Protocol) ListProtector.get(r102, r108);
        if (r109 == Protocol.HTTP_1_0) goto L18;
        r106.writeByte(r109.toString().length());
        r106.writeUtf8(r109.toString());
    L18:
        r108 = r108 + 1;
        goto L13
    L19:
        r105[0] = r106.readByteArray();
        f<Socket> r110 = this.f487374g;
        r110.getClass();
        r110.b(r100, r105);     // Catch: InvocationTargetException -> L22
        return;
    L22:
        e = move-exception;
        Throwable r111 = e.getTargetException();
        if ((r111 instanceof RuntimeException) == true) goto L26;
        AssertionError r112 = new AssertionError("Unexpected exception");
        r112.initCause(r111);
        throw r112;
    L26:
        throw ((RuntimeException) r111);
    L35:
        return;
    L10:
        r104 = false;
        goto L11
    }

    @Override // hvc.g
    public final void h(Socket r100, InetSocketAddress r101, int r102) throws IOException {
        r100.connect(r101, r102);     // Catch: ClassCastException -> L5 SecurityException -> L11 AssertionError -> L14
        return;
    L14:
        e = move-exception;
        if (cvc.c.q(e) == true) goto L18;
        throw e;
    L18:
        throw new IOException(e);
    L5:
        e = move-exception;
        if (Build.VERSION.SDK_INT != 26) goto L10;
        IOException r103 = new IOException("Exception in connect");
        r103.initCause(e);
        throw r103;
    L10:
        throw e;
    L11:
        e = move-exception;
        IOException r104 = new IOException("Exception in connect");
        r104.initCause(e);
        throw r104;
    }

    @Override // hvc.g
    public final void m(int r100, String r101, @Nullable Throwable r102) {
        if (r102 == null) goto L5;
        r101 = r101 + '\n' + Log.getStackTraceString(r102);
    L5:
        int r103 = r101.length();
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L15;
        int r105 = r101.indexOf(10, r104);
        if (r105 != (-1)) goto L11;
        r105 = r103;
    L11:
        int r106 = Math.min(r105, r104 + 4000);
        r101.substring(r104, r106);
        if (r106 >= r105) goto L13;
        r104 = r106;
        goto L11
    L13:
        r104 = r106 + 1;
        goto L6
    }

    public b(Class<?> r100, f<Socket> r101, f<Socket> r102, f<Socket> r110, f<Socket> r111) {
        Class r103 = c.a();     // Catch: Exception -> L5
        Method r104 = r103.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[0]);     // Catch: Exception -> L5
        Method r105 = r103.getMethod("open", new Class[]{String.class});     // Catch: Exception -> L5
        Method r106 = r103.getMethod("warnIfOpen", new Class[0]);     // Catch: Exception -> L5
    L6:
        this.f487375h = new c(r104, r105, r106);
        this.f487370c = r100;
        this.f487371d = r101;
        this.f487372e = r102;
        this.f487373f = r110;
        this.f487374g = r111;
        return;
    L5:
        r104 = null;
        r106 = null;
        r105 = null;
        goto L6
    }
}
