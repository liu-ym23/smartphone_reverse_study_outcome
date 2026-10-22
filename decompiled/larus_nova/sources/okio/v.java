package okio;

import java.io.RandomAccessFile;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class v extends j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RandomAccessFile f524113d;

    @Override // okio.j
    public final synchronized void a() {
        monitor-enter(this);
        this.f524113d.close();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // okio.j
    public final synchronized long c() {
        monitor-enter(this);
        long r100 = this.f524113d.length();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public v(RandomAccessFile r100) {
        Intrinsics.checkNotNullParameter(r100, "randomAccessFile");
        this.f524113d = r100;
    }

    @Override // okio.j
    public final synchronized int b(long r100, byte[] r101, int r102, int r103) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r101, "array");     // Catch: Throwable -> L14
        this.f524113d.seek(r100);     // Catch: Throwable -> L14
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L12;
        int r105 = this.f524113d.read(r101, r102, r103 - r104);     // Catch: Throwable -> L14
        if (r105 == (-1)) goto L8;
        r104 = r104 + r105;
        goto L4
    L8:
        if (r104 != 0) goto L12;
        monitor-exit(this);
        return -1;
    L12:
        monitor-exit(this);
        return r104;
    L14:
        th = move-exception;
        throw th;
    }
}
