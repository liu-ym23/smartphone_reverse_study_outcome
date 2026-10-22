package e87;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.io.IOUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements a {
    public b() {
    }

    public static boolean a(String r100, String r110) throws IOException {
        URL r101 = new URL(r100);
        String r102 = r101.getHost();     // Catch: Throwable -> L8 IOException -> L42
        String r103 = r101.getPath();     // Catch: Throwable -> L8 IOException -> L42
        if (com.obric.assistant.network.okhttp.a.c(r102, r103) == false) goto L10;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r102 + " path=" + r103);     // Catch: Throwable -> L8 IOException -> L42
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r102, r103), r102, r103);     // Catch: Throwable -> L8 IOException -> L42
        throw new IOException("[NetGuard] dropped " + r101);     // Catch: Throwable -> L8 IOException -> L42
    L10:
        HttpURLConnection r104 = (HttpURLConnection) r101.openConnection();
        r104.setConnectTimeout(15000);
        r104.setReadTimeout(20000);
        r104.setUseCaches(true);
        int r105 = r104.getResponseCode();
        if (r105 >= 300) goto L40;
        InputStream r106 = r104.getInputStream();
        if (r106 != null) goto L16;
        return false;
    L16:
        if (r104.getHeaderFieldInt("Content-Length", -1) != 0) goto L46;
        IOUtils.close(r106);
        throw new IOException("Received response with 0 content-length header.");
    L46:
        PolarisFileWrapper r107 = new PolarisFileWrapper(r110);     // Catch: Throwable -> L33
        if (r107.exists() == false) goto L20;
    L23:
        PolarisFileOutputStreamWrapper r111 = new PolarisFileOutputStreamWrapper(r107);     // Catch: Throwable -> L33
        byte[] r108 = new byte[2048];     // Catch: Throwable -> L32
    L26:
        int r109 = r106.read(r108);     // Catch: Throwable -> L32
        if (r109 == (-1)) goto L29;
        r111.write(r108, 0, r109);     // Catch: Throwable -> L32
        goto L26
    L29:
        r111.flush();     // Catch: Throwable -> L32
        r111.close();     // Catch: Throwable -> L32
        Logger.i("UrlConnectionDownloader", "download success");     // Catch: Throwable -> L32
        IOUtils.close(r106);
        IOUtils.close(r111);
        return true;
    L34:
        IOUtils.close(r106);
        if (r111 == null) goto L37;
        IOUtils.close(r111);
    L37:
        return false;
    L20:
        if (r107.createNewFile() == true) goto L23;
        IOUtils.close(r106);
        return false;
    L33:
        r111 = null;
        goto L34
    L40:
        r104.disconnect();
        throw new IOException(r105 + " " + r104.getResponseMessage());
    L42:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L10
    }
}
