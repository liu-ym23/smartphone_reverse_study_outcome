package com.ttnet.org.chromium.net;

import com.larus.utils.logger.FLogger;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class ChromiumNetworkAdapter {
    private ChromiumNetworkAdapter() {
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_ttnet_org_chromium_net_ChromiumNetworkAdapter_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(com.obric.assistant.network.okhttp.a.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
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

    public static URLConnection openConnection(URL r100, NetworkTrafficAnnotationTag r101) throws IOException {
        return INVOKEVIRTUAL_com_ttnet_org_chromium_net_ChromiumNetworkAdapter_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r100);
    }

    public static InputStream openStream(URL r100, NetworkTrafficAnnotationTag r101) throws IOException {
        return r100.openStream();
    }

    public static URLConnection openConnection(URL r100, Proxy r101, NetworkTrafficAnnotationTag r102) throws IOException {
        return r100.openConnection(r101);
    }
}
