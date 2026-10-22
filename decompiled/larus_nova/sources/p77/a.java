package p77;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f528038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f528039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f528040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FileLock f528041d;

    public a(String r100) {
        this.f528038a = r100;
    }

    public final boolean a(Context r100) {
    L14:
        th = move-exception;
        th.printStackTrace();
        this.f528040c = false;
        return false;
    L3:
        if (this.f528039b == true) goto L5;
        this.f528039b = true;     // Catch: Throwable -> L14
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getFilesDir(), this.f528038a);     // Catch: Throwable -> L14
        if (r101.isDirectory() == false) goto L10;
        r101.delete();     // Catch: Throwable -> L14
    L10:
        if (r101.exists() == true) goto L12;
        r101.createNewFile();     // Catch: Throwable -> L14
    L12:
        this.f528040c = b(r101);     // Catch: Throwable -> L14
        int r102 = q77.a.f531973a;     // Catch: Throwable -> L14
        d87.a.b(r100);     // Catch: Throwable -> L14
        r101.getPath();     // Catch: Throwable -> L14
        return this.f528040c;
    L5:
        return this.f528040c;
    }

    public final boolean b(PolarisFileWrapper r100) {
        if (r100.exists() == true) goto L5;
        return false;
    L5:
        boolean r101 = true;
        FileLock r102 = new RandomAccessFile(r100, "rwd").getChannel().tryLock();     // Catch: Throwable -> L15
        if (r102 == null) goto L9;
        this.f528041d = r102;     // Catch: Throwable -> L15
    L9:
        FileLock r103 = this.f528041d;     // Catch: Throwable -> L15
        if (r103 == null) goto L31;
        if (r103.isValid() == false) goto L32;
        return true;
    L32:
        return false;
    L31:
        return false;
    L15:
        th = move-exception;
    L25:
        th = move-exception;
        throw th;
    L17:
        if ((th instanceof IOException) == true) goto L19;
    L21:
        r101 = false;
    L22:
        if (r101 == true) goto L24;
        th.printStackTrace();     // Catch: Throwable -> L25
    L24:
        return false;
    L19:
        if (th.getMessage().contains("fcntl failed: EAGAIN") == false) goto L21;
        goto L21
    }
}
