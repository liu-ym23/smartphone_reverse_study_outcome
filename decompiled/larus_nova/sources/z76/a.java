package z76;

import com.airbnb.lottie.l;
import com.airbnb.lottie.network.FileExtension;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements Callable<l<File>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f570667a;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public l<File> call() throws Exception {
        b r100 = this.f570667a;
        r100.getClass();
        URL r101 = new URL(r100.f570669b);
        String r102 = r101.getHost();     // Catch: Throwable -> L8 IOException -> L41
        String r103 = r101.getPath();     // Catch: Throwable -> L8 IOException -> L41
        if (com.obric.assistant.network.okhttp.a.c(r102, r103) == false) goto L10;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r102 + " path=" + r103);     // Catch: Throwable -> L8 IOException -> L41
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r102, r103), r102, r103);     // Catch: Throwable -> L8 IOException -> L41
        throw new IOException("[NetGuard] dropped " + r101);     // Catch: Throwable -> L8 IOException -> L41
    L10:
        HttpURLConnection r104 = (HttpURLConnection) r101.openConnection();
        r104.setRequestMethod("GET");
        r104.connect();
        if (r104.getErrorStream() == null) goto L13;
    L35:
        BufferedReader r105 = new BufferedReader(new InputStreamReader(r104.getErrorStream()));
        StringBuilder r106 = new StringBuilder();
    L36:
        String r107 = r105.readLine();
        if (r107 == null) goto L40;
        r106.append(r107);
        r106.append('\n');
        goto L36
    L40:
        return new l(new IllegalArgumentException("Unable to fetch " + r100.f570669b + ". Failed with " + r104.getResponseCode() + "\n" + r106));
    L13:
        if (r104.getResponseCode() != 200) goto L35;
        String r108 = r104.getContentType();
        if (r108.hashCode() != (-43840953)) goto L19;
        r108.equals("application/json");
    L19:
        FileExtension r109 = FileExtension.Json;
        InputStream r110 = r104.getInputStream();
        PolarisFileWrapper r111 = new PolarisFileWrapper(r100.f570668a.getCacheDir(), "lynx_lottie_" + r100.f570669b.replaceAll("\\W+", "") + r109.extension);
        PolarisFileOutputStreamWrapper r112 = new PolarisFileOutputStreamWrapper(r111);     // Catch: Throwable -> L32
        byte[] r113 = new byte[1024];     // Catch: Throwable -> L29
    L23:
        int r114 = r110.read(r113);     // Catch: Throwable -> L29
        if (r114 == (-1)) goto L26;
        r112.write(r113, 0, r114);     // Catch: Throwable -> L29
        goto L23
    L26:
        r112.flush();     // Catch: Throwable -> L29
        r112.close();     // Catch: Throwable -> L32
        r110.close();
        return new l(r111);
    L29:
        th = move-exception;
        r112.close();     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        r110.close();
        throw th;
    L41:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L10
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ l<File> call() throws Exception {
        return call();
    }

    public a(b r100) {
        this.f570667a = r100;
    }
}
