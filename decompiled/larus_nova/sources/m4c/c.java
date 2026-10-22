package m4c;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.d;
import java.io.Closeable;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RandomAccessFile f511911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FileLock f511912b;

    public final void a() {
        FileLock r100 = this.f511912b;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isValid() == true) goto L23;
        return;
    L23:
        this.f511912b.release();     // Catch: Throwable -> L11 Exception -> L13
        d.b(new Closeable[]{this.f511911a});
        RandomAccessFile r101 = this.f511911a;
        if (r101 == null) goto L27;
        d.b(new Closeable[]{r101.getChannel()});
        return;
    L27:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        d.b(new Closeable[]{this.f511911a});
        RandomAccessFile r102 = this.f511911a;
        if (r102 == null) goto L29;
        d.b(new Closeable[]{r102.getChannel()});
        return;
    L29:
        return;
    L11:
        th = move-exception;
        d.b(new Closeable[]{this.f511911a});
        RandomAccessFile r103 = this.f511911a;
        if (r103 == null) goto L21;
        d.b(new Closeable[]{r103.getChannel()});
    L21:
        throw th;
    }

    public c(PolarisFileWrapper r100) {
        if (r100.exists() == true) goto L15;
        r100.createNewFile();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
    L15:
        this.f511911a = new RandomAccessFile(r100, "rw");     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }
}
