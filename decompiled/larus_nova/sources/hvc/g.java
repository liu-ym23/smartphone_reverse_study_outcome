package hvc;

import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import me.ele.lancet.base.annotations.Skip;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f487396a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f487397b = null;

    public g() {
    }

    public void b(SSLSocket r100) {
    }

    public void f(SSLSocketFactory r100) {
    }

    public void g(SSLSocket r100, @Nullable String r101, List<Protocol> r102) throws IOException {
    }

    @Nullable
    public String j(SSLSocket r100) {
        return null;
    }

    public boolean l(String r100) {
        return true;
    }

    static {
        g r100 = null;
        if ("Dalvik".equals(System.getProperty("java.vm.name")) == false) goto L41;
        if ("Dalvik".equals(System.getProperty("java.vm.name")) == true) goto L63;
    L15:
        g r101 = null;
    L16:
        if (r101 == null) goto L65;
    L59:
        f487396a = r101;
        f487397b = Logger.getLogger(OkHttpClient.class.getName());
        return;
    L65:
        if ("Dalvik".equals(System.getProperty("java.vm.name")) == false) goto L36;
        Class r102 = b.r("com.android.org.conscrypt.SSLParametersImpl");     // Catch: ClassNotFoundException -> L23
    L22:
        Class r103 = r102;
        f r104 = new f(null, "setUseSessionTickets", new Class[]{Boolean.TYPE});     // Catch: ClassNotFoundException -> L35
        f r105 = new f(null, "setHostname", new Class[]{String.class});     // Catch: ClassNotFoundException -> L35
        if (Security.getProvider("GMSCore_OpenSSL") == null) goto L72;
    L28:
        boolean r106 = true;
    L30:
        if (r106 == false) goto L32;
        f r110 = new f(byte[].class, "getAlpnSelectedProtocol", new Class[0]);     // Catch: ClassNotFoundException -> L35
        f r111 = new f(null, "setAlpnProtocols", new Class[]{byte[].class});     // Catch: ClassNotFoundException -> L35
    L33:
        r100 = new b(r103, r104, r105, r110, r111);     // Catch: ClassNotFoundException -> L35
        goto L36
    L32:
        r110 = null;
        r111 = null;
        goto L33
    L72:
        b.r("android.net.Network");     // Catch: ClassNotFoundException -> L29
    L29:
        r106 = false;
        goto L30
    L23:
        r102 = b.r("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");     // Catch: ClassNotFoundException -> L35
    L36:
        if (r100 == null) goto L39;
    L37:
        r101 = r100;
        goto L59
    L39:
        throw new NullPointerException("No platform found on Android");
    L63:
        int r107 = Build.VERSION.SDK_INT;     // Catch: ClassNotFoundException -> L9 NoClassDefFoundError -> L10
    L12:
        if (r107 < 29) goto L15;
        r101 = new a(a.t());     // Catch: ClassNotFoundException -> L9
    L10:
        r107 = 0;
        goto L12
    L41:
        if ("conscrypt".equals(System.getProperty("okhttp.platform")) == false) goto L43;
        boolean r108 = true;
    L44:
        if (r108 == false) goto L61;
        g r109 = c.r();
        if (r109 == null) goto L61;
    L47:
        r101 = r109;
    L61:
        r101 = new d(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));     // Catch: NoSuchMethodException -> L50
    L51:
        if (r101 != null) goto L59;
        Class r112 = e.q("org.eclipse.jetty.alpn.ALPN");     // Catch: Throwable -> L55
        Class<?> r113 = e.q("org.eclipse.jetty.alpn.ALPN$Provider");     // Catch: Throwable -> L55
        r100 = new e(r112.getMethod("put", new Class[]{SSLSocket.class, r113}), r112.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{SSLSocket.class}), r112.getMethod("remove", new Class[]{SSLSocket.class}), e.q("org.eclipse.jetty.alpn.ALPN$ClientProvider"), e.q("org.eclipse.jetty.alpn.ALPN$ServerProvider"));     // Catch: Throwable -> L55
    L56:
        if (r100 != null) goto L37;
        r109 = new g();
    L50:
        r101 = null;
        goto L51
    L43:
        r108 = "Conscrypt".equals(Security.getProviders()[0].getName());
        goto L44
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("sun.security.ssl.SSLContextImpl");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("sun.security.ssl.SSLContextImpl");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("sun.security.ssl.SSLContextImpl");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("sun.security.ssl.SSLContextImpl");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("sun.security.ssl.SSLContextImpl");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("sun.security.ssl.SSLContextImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("sun.security.ssl.SSLContextImpl");
    }

    public SSLContext i() {
        if ("1.7".equals(System.getProperty("java.specification.version")) == false) goto L14;
        return SSLContext.getInstance("TLSv1.2");
    L14:
        return SSLContext.getInstance("TLS");
    L8:
        e = move-exception;
        throw new IllegalStateException("No TLS provider", e);
    }

    public Object k() {
        if (f487397b.isLoggable(Level.FINE) == true) goto L5;
        return null;
    L5:
        return new Throwable("response.body().close()");
    }

    public final String toString() {
        return getClass().getSimpleName();
    }

    public static List<String> c(List<Protocol> r100) {
        ArrayList r101 = new ArrayList(r100.size());
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        Protocol r104 = (Protocol) ListProtector.get(r100, r103);
        if (r104 == Protocol.HTTP_1_0) goto L8;
        r101.add(r104.toString());
    L8:
        r103 = r103 + 1;
        goto L3
    L9:
        return r101;
    }

    public jvc.c d(X509TrustManager r100) {
        return new jvc.a(e(r100));
    }

    public jvc.e e(X509TrustManager r100) {
        return new jvc.b(r100.getAcceptedIssuers());
    }

    @Nullable
    public X509TrustManager p(SSLSocketFactory r100) {
        Object r101 = o(r100, a(), PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: ClassNotFoundException -> L8
        if (r101 != null) goto L6;
        return null;
    L6:
        return (X509TrustManager) o(r101, X509TrustManager.class, "trustManager");
    L8:
        return null;
    }

    public void n(String r100, Object r101) {
        if (r101 != null) goto L4;
        r100 = r100 + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
    L4:
        m(5, r100, (Throwable) r101);
    }

    @Nullable
    public static <T> T o(Object r100, Class<T> r101, String r102) {
        Class<?> r103 = r100.getClass();
    L4:
        if (r103 == Object.class) goto L17;
        Field r104 = r103.getDeclaredField(r102);     // Catch: IllegalAccessException -> L13 NoSuchFieldException -> L15
        r104.setAccessible(true);     // Catch: IllegalAccessException -> L13 NoSuchFieldException -> L15
        Object r105 = r104.get(r100);     // Catch: IllegalAccessException -> L13 NoSuchFieldException -> L15
        if (r105 == null) goto L12;
        if (r101.isInstance(r105) == false) goto L12;
        goto L14
    L11:
        return r101.cast(r105);
    L12:
        return null;
    L15:
        r103 = r103.getSuperclass();
    L14:
        throw new AssertionError();
    L17:
        if (r102.equals("delegate") == true) goto L22;
        Object r106 = o(r100, Object.class, "delegate");
        if (r106 == null) goto L22;
        return (T) o(r106, r101, r102);
    L22:
        return null;
    }

    public void h(Socket r100, InetSocketAddress r101, int r102) throws IOException {
        r100.connect(r101, r102);
    }

    public void m(int r100, String r101, @Nullable Throwable r102) {
        if (r100 != 5) goto L5;
        Level r103 = Level.WARNING;
    L6:
        f487397b.log(r103, r101, r102);
        return;
    L5:
        r103 = Level.INFO;
        goto L6
    }
}
