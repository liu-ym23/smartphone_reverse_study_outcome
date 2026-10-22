package j3;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f497067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f497068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque<Long> f497069c;

    public static boolean a(a r100) {
        long r101 = System.currentTimeMillis();
        monitor-enter(r100);
        long r102 = r101 - r100.f497068b;     // Catch: Throwable -> L18
    L6:
        if ((!r100.f497069c.isEmpty()) == false) goto L11;
        if (r100.f497069c.peekFirst().longValue() > r102) goto L11;
        r100.f497069c.pollFirst();     // Catch: Throwable -> L18
    L11:
        if (r100.f497069c.size() < r100.f497067a) goto L14;
        monitor-exit(r100);
        return true;
    L14:
        r100.f497069c.addLast(Long.valueOf(r101));     // Catch: Throwable -> L18
        monitor-exit(r100);
        return false;
    L18:
        th = move-exception;
        throw th;
    }

    public a(int r100, long r101) {
        this.f497067a = r100;
        this.f497068b = r101;
        this.f497069c = new ArrayDeque();
    }
}
