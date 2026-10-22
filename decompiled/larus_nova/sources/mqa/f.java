package mqa;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f514926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f514927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FileLock f514928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RandomAccessFile f514929d;

    public f() {
    }

    public final boolean a(PolarisFileWrapper r100) {
        boolean r101 = false;
        if (r100.exists() == true) goto L5;
        return false;
    L5:
        boolean r102 = true;
        FileLock r103 = null;
        RandomAccessFile r104 = new RandomAccessFile(r100, "rwd");     // Catch: Throwable -> L17
        this.f514929d = r104;     // Catch: Throwable -> L17
        r103 = r104.getChannel().tryLock();     // Catch: Throwable -> L17
        if (r103 == null) goto L9;
        this.f514928c = r103;     // Catch: Throwable -> L17
    L9:
        FileLock r105 = this.f514928c;     // Catch: Throwable -> L17
        if (r105 == null) goto L14;
        if (r105.isValid() == false) goto L14;
        r101 = true;
    L14:
        if (r103 != null) goto L16;
        ThreadMethodProxy.start(new PthreadThreadV2(new e(this, this.f514929d), "ExclusiveFileLock"));
    L16:
        return r101;
    L17:
        th = move-exception;
    L29:
        th = move-exception;
        if (r103 != null) goto L32;
        ThreadMethodProxy.start(new PthreadThreadV2(new e(this, this.f514929d), "ExclusiveFileLock"));
    L32:
        throw th;
    L19:
        if ((th instanceof IOException) == true) goto L21;
    L23:
        r102 = false;
    L24:
        if (r102 == true) goto L26;
        th.printStackTrace();     // Catch: Throwable -> L29
    L26:
        if (r103 != null) goto L28;
        ThreadMethodProxy.start(new PthreadThreadV2(new e(this, this.f514929d), "ExclusiveFileLock"));
    L28:
        return false;
    L21:
        if (th.getMessage().contains("fcntl failed: EAGAIN") == false) goto L23;
        goto L23
    }
}
