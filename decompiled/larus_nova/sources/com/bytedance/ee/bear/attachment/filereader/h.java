package com.bytedance.ee.bear.attachment.filereader;

import com.bytedance.ee.util.io.FileUtils;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import okhttp3.Response;

/* JADX INFO: loaded from: classes15.dex */
public final class h {

    public interface a {
        void a();

        void b();

        void c();
    }

    public static void b(final a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        com.bytedance.ee.util.ui.m.a(new c(r100));
    }

    public static void a(Response r110, String r111, a r112) {
        if (r110 != null) goto L4;
    L31:
        b(r112);
        return;
    L4:
        if (r110.isSuccessful() == false) goto L31;
        byte[] r100 = new byte[2048];
        Closeable r101 = null;
        InputStream r102 = r110.body().byteStream();     // Catch: Throwable -> L23 Exception -> L25
        long r103 = r110.body().contentLength();     // Catch: Throwable -> L19 Exception -> L33
        OutputStream r113 = ay4.d.a().i(r111).newOutputStream();     // Catch: Throwable -> L19 Exception -> L33
        goto L22
    L40:
        Long r114 = 0L;     // Catch: Throwable -> L16 Exception -> L18
        int r104 = r102.read(r100);     // Catch: Throwable -> L16 Exception -> L18
    L12:
        if (r104 == (-1)) goto L14;
        r113.write(r100, 0, r104);     // Catch: Throwable -> L16 Exception -> L18
        r114 = Long.valueOf(r114.longValue() + ((long) r104));     // Catch: Throwable -> L16 Exception -> L18
        com.bytedance.ee.util.ui.m.a(new f(r112, (int) ((r114.longValue() * 1.0f) / r103)));     // Catch: Throwable -> L16 Exception -> L18
        r104 = r102.read(r100);     // Catch: Throwable -> L16 Exception -> L18
        goto L12
    L14:
        r113.flush();     // Catch: Throwable -> L16 Exception -> L18
        com.bytedance.ee.util.ui.m.a(new g(r112));     // Catch: Throwable -> L16 Exception -> L18
        FileUtils.e(new Closeable[]{r102, r113});
        return;
    L18:
        r101 = r113;
    L16:
        Throwable th10 = th;
        r101 = r113;
    L21:
        Closeable r115 = r101;
        r101 = r102;
    L29:
        FileUtils.e(new Closeable[]{r101, r115});
        throw th10;
    L19:
        th = move-exception;
        th10 = th;
    L22:
        r115 = r101;
        r101 = r102;
    L34:
        b(r112);     // Catch: Throwable -> L28
        FileUtils.e(new Closeable[]{r101, r115});
        return;
    L28:
        th10 = th;
        goto L29
    L25:
        r115 = null;
    L23:
        th = move-exception;
        th10 = th;
        r115 = null;
        goto L29
    }
}
