package s67;

import android.content.Context;
import com.bytedance.push.utils.f;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.message.util.ToolUtils;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, a> f540824d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f540825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FileLock f540826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RandomAccessFile f540827c;

    static {
        f540824d = new HashMap();
    }

    public final void d() {
        FileLock r100 = this.f540826b;
        if (r100 == null) goto L56;
        r100.release();     // Catch: Throwable -> L15 IOException -> L17
        this.f540826b.close();     // Catch: IOException -> L7
    L9:
        RandomAccessFile r101 = this.f540827c;
        if (r101 == null) goto L47;
    L39:
        r101.close();     // Catch: IOException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L47:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L15
        this.f540826b.close();     // Catch: IOException -> L21
    L23:
        r101 = this.f540827c;
        if (r101 == null) goto L47;
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L56:
        return;
    L15:
        th = move-exception;
        this.f540826b.close();     // Catch: IOException -> L29
    L31:
        RandomAccessFile r102 = this.f540827c;
        if (r102 == null) goto L54;
        r102.close();     // Catch: IOException -> L35
        throw th;
    L35:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L54:
        throw th;
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    }

    public a(String r100) {
        this.f540825a = r100;
    }

    public static a a(String r100) {
        Map<String, a> r101 = f540824d;
        a r102 = (a) ((HashMap) r101).get(r100);
        if (r102 != null) goto L13;
        monitor-enter(r101);
        r102 = (a) ((HashMap) r101).get(r100);     // Catch: Throwable -> L10
        if (r102 != null) goto L8;
        r102 = new a(r100);     // Catch: Throwable -> L10
        ((HashMap) r101).put(r100, r102);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L13:
        return r102;
    }

    public final void b(Context r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getFilesDir(), this.f540825a);     // Catch: Throwable -> L13
        if (r101.isDirectory() == false) goto L7;
        r101.delete();     // Catch: Throwable -> L13
    L7:
        if (r101.exists() == true) goto L9;
        r101.createNewFile();     // Catch: Throwable -> L13
    L9:
        boolean r102 = c(r101);     // Catch: Throwable -> L13
        if (f.f267065a == false) goto L18;
        f.b("FileLockHelper", "isFirstLockFile: sIsFirst = " + r102 + "  process = " + ToolUtils.getCurProcessName(r100) + r101.getPath());     // Catch: Throwable -> L13
        return;
    L18:
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
    }

    public final boolean c(PolarisFileWrapper r100) {
        if (r100.exists() == true) goto L5;
        return false;
    L5:
        boolean r101 = true;
        RandomAccessFile r102 = new RandomAccessFile(r100, "rwd");     // Catch: Throwable -> L15
        this.f540827c = r102;     // Catch: Throwable -> L15
        FileLock r103 = r102.getChannel().lock();     // Catch: Throwable -> L15
        if (r103 == null) goto L9;
        this.f540826b = r103;     // Catch: Throwable -> L15
    L9:
        FileLock r104 = this.f540826b;     // Catch: Throwable -> L15
        if (r104 == null) goto L27;
        if (r104.isValid() == false) goto L28;
        return true;
    L28:
        return false;
    L27:
        return false;
    L15:
        th = move-exception;
        if ((th instanceof IOException) == true) goto L19;
    L21:
        r101 = false;
    L22:
        if (r101 == true) goto L24;
        th.printStackTrace();
    L24:
        return false;
    L19:
        if (th.getMessage().contains("fcntl failed: EAGAIN") == false) goto L21;
        goto L21
    }
}
