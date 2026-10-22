package rj4;

import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes15.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static e f538048b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<b> f538049a;

    public interface a {
        void a(byte[] r100, int r101, int r102);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte f538050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte f538051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte f538052c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f538053d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final short f538054e;

        public b(byte r100, byte r101, byte r102, byte[] r103, short r104) {
            this.f538050a = r100;
            this.f538051b = r101;
            this.f538052c = r102;
            this.f538053d = r103;
            this.f538054e = r104;
        }
    }

    public static synchronized e a() {
        monitor-enter(e.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f538048b != null) goto L7;
        f538048b = new e();     // Catch: Throwable -> L10
    L7:
        e r100 = f538048b;     // Catch: Throwable -> L10
        monitor-exit(e.class);
        return r100;
    }

    public e() {
        new LinkedBlockingQueue(2000);
        new LinkedBlockingQueue(2000);
        new LinkedBlockingQueue(2000);
        this.f538049a = new LinkedBlockingQueue(2000);
    }

    static {
    }

    public final synchronized void b(byte r100, byte r110, byte r111, byte[] r112, short r113) {
        monitor-enter(this);
        this.f538049a.add(new b(r100, r110, r111, r112, r113));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
