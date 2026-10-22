package jgc;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PolarisFileWrapper f499061a;

    public static PolarisFileWrapper c() {
        PolarisFileWrapper r100 = f499061a;
        if (r100 != null) goto L11;
        String r101 = System.getProperty("java.io.tmpdir", ".");
        if (f.a(r101) == false) goto L8;
        return null;
    L8:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        r102.mkdirs();
        return r102;
    L11:
        if (r100.exists() == true) goto L14;
        f499061a.mkdirs();
    L14:
        return f499061a;
    }

    public static File a(String r100) throws IOException {
        String r101 = "ttapkdiffpatch".concat(r100);
        c();
        File r102 = File.createTempFile(r101, "tmp", c());
        r102.deleteOnExit();
        if (r102.exists() == true) goto L5;
        r102.getPath();
    L5:
        return r102;
    }

    public static boolean b(File r100) {
        if (r100.exists() == true) goto L7;
        return true;
    L7:
        if (r100.isDirectory() == true) goto L9;
        return false;
    L9:
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L27;
        if (r101.length <= 0) goto L27;
        int r102 = r101.length;
        int r103 = 0;
    L14:
        if (r103 >= r102) goto L27;
        File r104 = r101[r103];
        if (r104.isFile() == false) goto L21;
        if (r104.delete() == true) goto L25;
        return false;
    L25:
        r103 = r103 + 1;
        goto L14
    L21:
        if (r104.isDirectory() == false) goto L25;
        if (b(r104) == true) goto L25;
        return false;
    L27:
        return r100.delete();
    }

    public static void d(OutputStream r100, File r110) throws IOException {
        long r101 = r110.length();     // Catch: Throwable -> L22
        BufferedInputStream r102 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r110));     // Catch: Throwable -> L22
        if (PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID < r101) goto L6;
        byte[] r111 = new byte[(int) r101];     // Catch: Throwable -> L20
    L9:
        if (r101 <= 0) goto L18;
        int r103 = r102.read(r111);     // Catch: Throwable -> L20
        if (r103 == (-1)) goto L18;
        r100.write(r111, 0, r103);     // Catch: Throwable -> L20
        r101 = r101 - ((long) r103);     // Catch: Throwable -> L20
        if (r101 > PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) goto L9;
        if (r101 <= 0) goto L9;
        r111 = new byte[(int) r101];     // Catch: Throwable -> L20
    L18:
        r100.flush();
        e.a(r102);
        return;
    L6:
        r111 = new byte[32768];     // Catch: Throwable -> L20
    L20:
        th = th;
    L24:
        r100.flush();
        e.a(r102);
        throw th;
    L22:
        th = th;
        r102 = null;
        goto L24
    }
}
