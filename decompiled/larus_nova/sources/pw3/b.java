package pw3;

import com.bytedance.applog.log.n;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static byte[] a(byte[] r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream(8192);     // Catch: Throwable -> L14
        GZIPOutputStream r102 = new GZIPOutputStream(r101);     // Catch: Throwable -> L12
        if (r100 != null) goto L24;
    L10:
        d.a(r102);
        d.a(r101);
        return r101.toByteArray();
    L24:
        r102.write(r100);     // Catch: Throwable -> L8
    L8:
        th = th;
    L28:
        n.w().o(14, "compress with gzip failed", th, new Object[0]);     // Catch: Throwable -> L19
        d.a(r102);
        d.a(r101);
        return null;
    L19:
        th = move-exception;
        d.a(r102);
        d.a(r101);
        throw th;
    L12:
        th = th;
        r102 = null;
    L14:
        th = th;
        r101 = null;
        r102 = null;
        goto L28
    }
}
