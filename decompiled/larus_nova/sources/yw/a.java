package yw;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f569332b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Unsafe f569333a;

    public static a a() {
        if (f569332b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f569332b == null) goto L19;
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
        goto L15
    L19:
        Field r100 = Unsafe.class.getDeclaredField("theUnsafe");     // Catch: Exception -> L16 Throwable -> L11
        r100.setAccessible(true);     // Catch: Exception -> L16 Throwable -> L11
        f569332b = new a((Unsafe) r100.get(null));     // Catch: Exception -> L16 Throwable -> L11
    L15:
        return f569332b;
    }

    public a(Unsafe r100) {
        this.f569333a = r100;
    }

    public final long b(Field r100) {
        return this.f569333a.objectFieldOffset(r100);
    }
}
