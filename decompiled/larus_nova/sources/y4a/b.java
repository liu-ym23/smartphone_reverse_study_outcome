package y4a;

import com.lynx.animax.util.AnimaXLog;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes32.dex */
public final class b {
    public static void a(Closeable r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        r100.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        AnimaXLog.a("AnimaXStreamUtil", "Failed to close resource: " + e);
    }

    public static byte[] c(InputStream r100, int r101) {
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();
        if (b(r100, r102, r101) == true) goto L5;
        return null;
    L5:
        return r102.toByteArray();
    }

    public static boolean b(InputStream r100, OutputStream r101, int r102) {
        if (r100 == null) goto L21;
        if (r101 == null) goto L21;
        if (r102 >= 1024) goto L10;
        r102 = 1024;
    L12:
        byte[] r103 = new byte[r102];     // Catch: IOException -> L17 Throwable -> L24
    L13:
        int r104 = r100.read(r103, 0, r102);     // Catch: IOException -> L17 Throwable -> L24
        if (r104 == (-1)) goto L19;
        r101.write(r103, 0, r104);     // Catch: IOException -> L17 Throwable -> L24
        goto L13
    L19:
        a(r100);
        a(r101);
        return true;
    L10:
        if (r102 <= 8192) goto L12;
        r102 = 8192;
    L21:
        AnimaXLog.a("AnimaXStreamUtil", "Invalid input stream or output stream");     // Catch: IOException -> L17 Throwable -> L24
    L22:
        a(r100);
        a(r101);
        return false;
    L24:
        th = move-exception;
        a(r100);
        a(r101);
        throw th;
    L17:
        e = move-exception;
        AnimaXLog.a("AnimaXStreamUtil", "Failed to copy input stream to output stream, reason: " + e);     // Catch: Throwable -> L24
        goto L22
    }
}
