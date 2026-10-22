package rna;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public final class c {
    public c() {
    }

    static {
    }

    public static void a(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.isDirectory() == true) goto L6;
        r101.mkdirs();
        return;
    }

    public static void b(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);     // Catch: Exception -> L14
        if (r101.isDirectory() == false) goto L11;
        File[] r102 = r101.listFiles();     // Catch: Exception -> L14
        int r103 = r102.length;     // Catch: Exception -> L14
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L8;
        b(r102[r104].getPath());     // Catch: Exception -> L14
        r104 = r104 + 1;     // Catch: Exception -> L14
        goto L5
    L8:
        if (r101.delete() == true) goto L19;
        r101.getPath();     // Catch: Exception -> L14
        return;
    L19:
        return;
    L11:
        if (r101.delete() == true) goto L21;
        r101.getPath();     // Catch: Exception -> L14
        return;
    L21:
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
    }

    public static boolean c(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return new PolarisFileWrapper(r100).exists();
    }

    public static byte[] d(String r100) throws IOException {
        RandomAccessFile r101 = new RandomAccessFile(new PolarisFileWrapper(r100), "r");
        long r102 = r101.length();     // Catch: Throwable -> L10
        int r103 = (int) r102;     // Catch: Throwable -> L10
        if (r103 != r102) goto L9;
        byte[] r104 = new byte[r103];     // Catch: Throwable -> L10
        r101.readFully(r104);     // Catch: Throwable -> L10
        r101.close();
        return r104;
    L9:
        throw new IOException("File size >= 2 GB");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r101.close();
        throw th;
    }

    public static ByteBuffer e(String r100) throws IOException {
        RandomAccessFile r101 = new RandomAccessFile(new PolarisFileWrapper(r100), "r");
        long r102 = r101.length();     // Catch: Throwable -> L10
        int r103 = (int) r102;     // Catch: Throwable -> L10
        if (r103 != r102) goto L9;
        byte[] r104 = new byte[r103];     // Catch: Throwable -> L10
        r101.readFully(r104);     // Catch: Throwable -> L10
        ByteBuffer r105 = ByteBuffer.allocateDirect(r103);     // Catch: Throwable -> L10
        r105.put(r104);     // Catch: Throwable -> L10
        r101.close();
        return r105;
    L9:
        throw new IOException("File size >= 2 GB");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r101.close();
        throw th;
    }
}
