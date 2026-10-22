package t67;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.common.utility.io.IOUtils;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements a {
    public d() {
    }

    public static Bitmap b(c r100) throws IOException {
        URL r101 = new URL(r100.f544677a.toString());
        String r102 = r101.getHost();     // Catch: Throwable -> L8 IOException -> L32
        String r103 = r101.getPath();     // Catch: Throwable -> L8 IOException -> L32
        if (com.obric.assistant.network.okhttp.a.c(r102, r103) == false) goto L10;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r102 + " path=" + r103);     // Catch: Throwable -> L8 IOException -> L32
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r102, r103), r102, r103);     // Catch: Throwable -> L8 IOException -> L32
        throw new IOException("[NetGuard] dropped " + r101);     // Catch: Throwable -> L8 IOException -> L32
    L10:
        HttpURLConnection r104 = (HttpURLConnection) r101.openConnection();
        r104.setConnectTimeout(15000);
        r104.setReadTimeout(20000);
        r104.setUseCaches(true);
        int r105 = r104.getResponseCode();
        if (r105 >= 300) goto L30;
        InputStream r106 = r104.getInputStream();
        if (r106 != null) goto L34;
        return null;
    L34:
        if (r104.getHeaderFieldInt("Content-Length", -1) != 0) goto L35;
        IOUtils.close(r106);
        throw new IOException("Received response with 0 content-length header.");
    L35:
        Bitmap r107 = a(r106, r100);     // Catch: Throwable -> L20 Exception -> L22
        IOUtils.close(r106);
        return r107;
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
        IOUtils.close(r106);
        return null;
    L20:
        th = move-exception;
        IOUtils.close(r106);
        throw th;
    L30:
        r104.disconnect();
        throw new IOException(r105 + " " + r104.getResponseMessage());
    L32:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L10
    }

    @Override // t67.a
    public final Bitmap downloadImage(c r100) {
        return b(r100);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static Bitmap a(InputStream r100, c r101) throws IOException {
        b r102 = new b(r100);
        long r103 = r102.b(65536);
        r101.getClass();
        byte[] r104 = new byte[12];
        if (r102.read(r104, 0, 12) == 12) goto L5;
    L9:
        boolean r105 = false;
    L10:
        r102.a(r103);
        if (r105 == false) goto L18;
        ByteArrayOutputStream r106 = new ByteArrayOutputStream();
        byte[] r107 = new byte[4096];
    L13:
        int r108 = r102.read(r107);
        if ((-1) == r108) goto L16;
        r106.write(r107, 0, r108);
        goto L13
    L16:
        byte[] r109 = r106.toByteArray();
        return BitmapFactory.decodeByteArray(r109, 0, r109.length, null);
    L18:
        Bitmap r110 = BitmapFactory.decodeStream(r102, null, null);
        if (r110 == null) goto L22;
        return r110;
    L22:
        throw new IOException("Failed to decode stream.");
    L5:
        if ("RIFF".equals(new String(r104, 0, 4, "US-ASCII")) == false) goto L9;
        if ("WEBP".equals(new String(r104, 8, 4, "US-ASCII")) == false) goto L9;
        r105 = true;
        goto L10
    }
}
