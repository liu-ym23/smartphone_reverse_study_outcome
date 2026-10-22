package q0;

import android.content.Context;
import androidx.core.util.Pair;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.f;
import com.airbnb.lottie.l;
import com.airbnb.lottie.network.FileExtension;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import com.ss.android.downloadlib.constants.MimeType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Set;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f531156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f531157b;

    public final l a() throws IOException {
        Set<String> r100 = f.f24776a;
        URL r101 = new URL(this.f531156a);
        String r102 = r101.getHost();     // Catch: Throwable -> L8 IOException -> L43
        String r103 = r101.getPath();     // Catch: Throwable -> L8 IOException -> L43
        if (com.obric.assistant.network.okhttp.a.c(r102, r103) == false) goto L10;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r102 + " path=" + r103);     // Catch: Throwable -> L8 IOException -> L43
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r102, r103), r102, r103);     // Catch: Throwable -> L8 IOException -> L43
        throw new IOException("[NetGuard] dropped " + r101);     // Catch: Throwable -> L8 IOException -> L43
    L10:
        HttpURLConnection r104 = (HttpURLConnection) r101.openConnection();
        r104.setRequestMethod("GET");
        r104.connect();
        if (r104.getErrorStream() == null) goto L13;
    L37:
        BufferedReader r105 = new BufferedReader(new InputStreamReader(r104.getErrorStream()));
        StringBuilder r106 = new StringBuilder();
    L38:
        String r107 = r105.readLine();
        if (r107 == null) goto L42;
        r106.append(r107);
        r106.append('\n');
        goto L38
    L42:
        return new l(new IllegalArgumentException("Unable to fetch " + this.f531156a + ". Failed with " + r104.getResponseCode() + "\n" + r106));
    L13:
        if (r104.getResponseCode() != 200) goto L37;
        String r108 = r104.getContentType();
        int r109 = r108.hashCode();
        if (r109 == (-1248325150)) goto L24;
        if (r109 == (-43840953)) goto L21;
    L26:
        byte r110 = -1;
    L27:
        if (r110 == 0) goto L29;
        Set<String> r111 = f.f24776a;
        FileExtension r112 = FileExtension.Json;
        l<LottieComposition> r113 = LottieCompositionFactory.fromJsonInputStreamSync(new PolarisFileInputStreamWrapper(new PolarisFileWrapper(this.f531157b.b(r104.getInputStream(), r112).getAbsolutePath())), this.f531156a);
    L31:
        if (r113.f24812a == null) goto L36;
        a r114 = this.f531157b;
        PolarisFileWrapper r115 = new PolarisFileWrapper(r114.f531153a.getCacheDir(), a.a(r114.f531154b, r112, true));
        PolarisFileWrapper r116 = new PolarisFileWrapper(r115.getAbsolutePath().replace(".temp", ""));
        boolean r117 = r115.renameTo(r116);
        r116.toString();
        if (r117 == true) goto L36;
        f.b("Unable to rename cache file " + r115.getAbsolutePath() + " to " + r116.getAbsolutePath() + ".");
    L36:
        return r113;
    L29:
        Set<String> r118 = f.f24776a;
        r112 = FileExtension.Zip;
        r113 = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(new PolarisFileInputStreamWrapper(this.f531157b.b(r104.getInputStream(), r112))), this.f531156a);
        goto L31
    L21:
        if (r108.equals("application/json") == false) goto L26;
        r110 = 1;
        goto L27
    L24:
        if (r108.equals(MimeType.ZIP) == false) goto L26;
        r110 = 0;
    L43:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final l<LottieComposition> b() {
        a r100 = this.f531157b;
        r100.getClass();
        LottieComposition r101 = null;
        String r102 = r100.f531154b;     // Catch: FileNotFoundException -> L17
        File r103 = r100.f531153a.getCacheDir();     // Catch: FileNotFoundException -> L17
        FileExtension r104 = FileExtension.Json;     // Catch: FileNotFoundException -> L17
        PolarisFileWrapper r105 = new PolarisFileWrapper(r103, a.a(r102, r104, false));     // Catch: FileNotFoundException -> L17
        if (r105.exists() == true) goto L10;
        r105 = new PolarisFileWrapper(r100.f531153a.getCacheDir(), a.a(r102, FileExtension.Zip, false));     // Catch: FileNotFoundException -> L17
        if (r105.exists() == true) goto L10;
        r105 = null;
    L10:
        if (r105 == null) goto L18;
        PolarisFileInputStreamWrapper r106 = new PolarisFileInputStreamWrapper(r105);     // Catch: FileNotFoundException -> L17
        if (r105.getAbsolutePath().endsWith(".zip") == false) goto L16;
        r104 = FileExtension.Zip;
    L16:
        r105.getAbsolutePath();
        Set<String> r107 = f.f24776a;
        Pair r108 = new Pair(r104, r106);
    L19:
        if (r108 == null) goto L28;
        FileExtension r109 = (FileExtension) r108.first;
        InputStream r110 = (InputStream) r108.second;
        if (r109 != FileExtension.Zip) goto L24;
        l<LottieComposition> r111 = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(r110), this.f531156a);
    L25:
        LottieComposition r112 = r111.f24812a;
        if (r112 == null) goto L28;
        r101 = r112;
        goto L28
    L24:
        r111 = LottieCompositionFactory.fromJsonInputStreamSync(r110, this.f531156a);
    L28:
        if (r101 != null) goto L30;
        Set<String> r113 = f.f24776a;
        return a();
    L34:
        e = move-exception;
        return new l(e);
    L30:
        return new l(r101);
    L18:
        r108 = null;
        goto L19
    }

    public c(Context r100, String r101) {
        Context r102 = r100.getApplicationContext();
        this.f531156a = r101;
        this.f531157b = new a(r102, r101);
    }
}
