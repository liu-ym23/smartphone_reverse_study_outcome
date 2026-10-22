package q95;

import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f532098b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue<byte[]> f532099a;

    static {
        f532098b = new a();
    }

    public final byte[] a() {
        Queue<byte[]> r100 = this.f532099a;
        monitor-enter(r100);
        byte[] r101 = (byte[]) ((ArrayDeque) this.f532099a).poll();     // Catch: Throwable -> L9
        monitor-exit(r100);     // Catch: Throwable -> L9
        if (r101 != null) goto L14;
        byte[] r102 = new byte[65536];
        tt5.a.b("ByteArrayPool", "Created temp bytes");
        return r102;
    L14:
        return r101;
    L9:
        th = move-exception;
        throw th;
    }

    public a() {
        int r100 = f.f532111a;
        this.f532099a = new ArrayDeque(0);
    }

    public final void b(byte[] r100) {
        if (r100.length == 65536) goto L5;
        return;
    L5:
        Queue<byte[]> r101 = this.f532099a;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (((ArrayDeque) this.f532099a).size() >= 32) goto L10;
        ((ArrayDeque) this.f532099a).offer(r100);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
    }
}
