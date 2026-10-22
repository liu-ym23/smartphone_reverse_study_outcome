package q95;

import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final a b = null;
    public final Queue<byte[]> a;

    static {
        b = new a();
    }

    public final byte[] a() {
        Queue<byte[]> r0 = this.a;
        monitor-enter(r0);
        byte[] r1 = (byte[]) ((ArrayDeque) this.a).poll();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (r1 != null) goto L14;
        byte[] r2 = new byte[65536];
        tt5.a.b("ByteArrayPool", "Created temp bytes");
        return r2;
    L14:
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    public a() {
        int r0 = f.a;
        this.a = new ArrayDeque(0);
    }

    public final void b(byte[] r4) {
        if (r4.length == 65536) goto L5;
        return;
    L5:
        Queue<byte[]> r0 = this.a;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (((ArrayDeque) this.a).size() >= 32) goto L10;
        ((ArrayDeque) this.a).offer(r4);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }
}
