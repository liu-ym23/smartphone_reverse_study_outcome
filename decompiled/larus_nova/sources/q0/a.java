package q0;

import android.content.Context;
import com.airbnb.lottie.network.FileExtension;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f531153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f531154b;

    public a(Context r100, String r101) {
        this.f531153a = r100.getApplicationContext();
        this.f531154b = r101;
    }

    public final PolarisFileWrapper b(InputStream r100, FileExtension r101) throws IOException {
        String r102 = a(this.f531154b, r101, true);
        PolarisFileWrapper r103 = new PolarisFileWrapper(this.f531153a.getCacheDir(), r102);
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(r103);     // Catch: Throwable -> L16
        byte[] r105 = new byte[1024];     // Catch: Throwable -> L13
    L6:
        int r106 = r100.read(r105);     // Catch: Throwable -> L13
        if (r106 == (-1)) goto L9;
        r104.write(r105, 0, r106);     // Catch: Throwable -> L13
        goto L6
    L9:
        r104.flush();     // Catch: Throwable -> L13
        r104.close();     // Catch: Throwable -> L16
        r100.close();
        return r103;
    L13:
        th = move-exception;
        r104.close();     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r100.close();
        throw th;
    }

    public static String a(String r100, FileExtension r101, boolean r102) {
        StringBuilder r103 = new StringBuilder("lottie_cache_");
        r103.append(r100.replaceAll("\\W+", ""));
        if (r102 == false) goto L5;
        String r104 = r101.tempExtension();
    L6:
        r103.append(r104);
        return r103.toString();
    L5:
        r104 = r101.extension;
        goto L6
    }
}
