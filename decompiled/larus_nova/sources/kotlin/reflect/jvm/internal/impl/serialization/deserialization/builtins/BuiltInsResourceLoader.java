package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.a;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public final class BuiltInsResourceLoader {
    public BuiltInsResourceLoader() {
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_kotlin_reflect_jvm_internal_impl_serialization_deserialization_builtins_BuiltInsResourceLoader_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        a.b(a.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    public final InputStream loadResource(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        ClassLoader r101 = BuiltInsResourceLoader.class.getClassLoader();
        if (r101 == null) goto L5;
        URL r102 = r101.getResource(r100);
        if (r102 != null) goto L10;
        return null;
    L10:
        URLConnection r103 = INVOKEVIRTUAL_kotlin_reflect_jvm_internal_impl_serialization_deserialization_builtins_BuiltInsResourceLoader_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r102);
        r103.setUseCaches(false);
        return r103.getInputStream();
    L5:
        return ClassLoader.getSystemResourceAsStream(r100);
    }
}
