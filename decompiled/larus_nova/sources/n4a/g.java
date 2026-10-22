package n4a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes32.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f517288a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f517289b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f517290c = null;

    static {
        f517288a = f5.o("SYmFja3Vwcw");
        f517289b = f5.o("SLmFkaXU");
        f517290c = f5.o("JIw");
    }

    public static synchronized void a(Context r100, String r101, String r102) {
        monitor-enter(g.class);
        FileLock r103 = null;
        File r104 = r100.getExternalCacheDir();     // Catch: Throwable -> L11 Exception -> L56
        if (r104 != null) goto L8;
        r104 = r100.getCacheDir();     // Catch: Throwable -> L11 Exception -> L56
    L8:
        if (r104 == null) goto L13;
        String r105 = r104.getAbsolutePath();     // Catch: Throwable -> L11 Exception -> L56
    L15:
        if (TextUtils.isEmpty(r105) == false) goto L18;
        monitor-exit(g.class);
        return;
    L18:
        String r106 = r101 + f517290c + r102;     // Catch: Throwable -> L11
        PolarisFileWrapper r107 = new PolarisFileWrapper(r105 + File.separator + f517288a);     // Catch: Throwable -> L11
        PolarisFileWrapper r108 = new PolarisFileWrapper(r107, f517289b);     // Catch: Throwable -> L11
    L38:
        FileChannel r109 = null;
        RandomAccessFile r110 = null;
    L39:
        if (r103 != null) goto L62;
    L43:
        if (r109 != null) goto L57;
    L45:
        if (r110 != null) goto L75;
    L47:
        monitor-exit(g.class);
        return;
    L75:
        r110.close();     // Catch: Throwable -> L55
        goto L47
    L57:
        r109.close();     // Catch: Throwable -> L11 IOException -> L54
        goto L45
    L62:
        r103.release();     // Catch: Throwable -> L11 IOException -> L42
        goto L43
    L20:
        if (r107.exists() == true) goto L22;
    L23:
        r107.mkdirs();     // Catch: Throwable -> L38
    L24:
        r108.createNewFile();     // Catch: Throwable -> L38
        r110 = new RandomAccessFile(r108, "rws");     // Catch: Throwable -> L38
        r109 = r110.getChannel();     // Catch: Throwable -> L37
        r103 = r109.tryLock();     // Catch: Throwable -> L30
        if (r103 == null) goto L31;
        r109.write(ByteBuffer.wrap(r106.getBytes("UTF-8")));     // Catch: Throwable -> L30
    L31:
        if (r103 != null) goto L71;
    L69:
        r109.close();     // Catch: Throwable -> L11 IOException -> L52
    L59:
        r110.close();     // Catch: Throwable -> L53
    L35:
        monitor-exit(g.class);
        return;
    L71:
        r103.release();     // Catch: Throwable -> L11 IOException -> L51
    L37:
        r109 = null;
        goto L39
    L22:
        if (r107.isDirectory() == false) goto L24;
    L11:
        th = move-exception;
        throw th;
    L13:
        r105 = null;
        goto L15
    }
}
