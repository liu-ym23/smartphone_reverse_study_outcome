package hvc;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.IOException;
import java.security.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import me.ele.lancet.base.annotations.Skip;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;

/* JADX INFO: loaded from: classes42.dex */
public final class c extends g {
    public static c r() {
        q();     // Catch: ClassNotFoundException -> L8
        if (Conscrypt.isAvailable() == true) goto L6;
        return null;
    L6:
        return new c();
    L8:
        return null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static void q() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class.forName("org.conscrypt.Conscrypt");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a("org.conscrypt.Conscrypt");     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("org.conscrypt.Conscrypt");
    L12:
        throw th;
    L34:
        Class.forName("org.conscrypt.Conscrypt");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
        FastClassNotFoundHandler.a("org.conscrypt.Conscrypt");     // Catch: Throwable -> L17
        return;
    L37:
        return;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("org.conscrypt.Conscrypt");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        MiraPluginFix.forName("org.conscrypt.Conscrypt");
        return;
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }

    @Override // hvc.g
    public final SSLContext i() {
        return SSLContext.getInstance("TLSv1.3", s());
    L4:
        e = move-exception;
        return SSLContext.getInstance("TLS", s());
    L8:
        throw new IllegalStateException("No TLS provider", e);
    }

    public static Provider s() {
        return Conscrypt.newProviderBuilder().provideTrustManager().build();
    }

    public c() {
    }

    @Override // hvc.g
    public final void f(SSLSocketFactory r100) {
        if (Conscrypt.isConscrypt(r100) == false) goto L6;
        Conscrypt.setUseEngineSocket(r100, true);
        return;
    }

    @Override // hvc.g
    @Nullable
    public final String j(SSLSocket r100) {
        if (Conscrypt.isConscrypt(r100) == true) goto L5;
        return null;
    L5:
        return Conscrypt.getApplicationProtocol(r100);
    }

    @Override // hvc.g
    @Nullable
    public final X509TrustManager p(SSLSocketFactory r100) {
        if (Conscrypt.isConscrypt(r100) == false) goto L5;
        Object r101 = g.o(r100, Object.class, "sslParameters");     // Catch: Exception -> L12
        if (r101 == null) goto L10;
        return (X509TrustManager) g.o(r101, X509TrustManager.class, "x509TrustManager");
    L10:
        return null;
    L12:
        e = move-exception;
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on Conscrypt", e);
    L5:
        return super.p(r100);
    }

    @Override // hvc.g
    public final void g(SSLSocket r100, String r101, List<Protocol> r102) throws IOException {
        if (Conscrypt.isConscrypt(r100) == false) goto L8;
        if (r101 == null) goto L6;
        Conscrypt.setUseSessionTickets(r100, true);
        Conscrypt.setHostname(r100, r101);
    L6:
        List<String> r103 = g.c(r102);
        ArrayList r104 = (ArrayList) r103;
        Conscrypt.setApplicationProtocols(r100, (String[]) r104.toArray(new String[0]));
        return;
    }
}
