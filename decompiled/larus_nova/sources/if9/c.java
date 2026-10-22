package if9;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ReentrantReadWriteLock f489641a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f489642b = null;

    static {
        f489641a = new ReentrantReadWriteLock();
        f489642b = new ConcurrentHashMap();
    }

    public static b c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ReentrantReadWriteLock.ReadLock r101 = f489641a.readLock();
        r101.lock();
        b r102 = f489642b.get(r100);     // Catch: Throwable -> L6
        r101.unlock();
        return r102;
    L6:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    public static void a(String r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "step");
        ReentrantReadWriteLock r102 = f489641a;
        ReentrantReadWriteLock.ReadLock r103 = r102.readLock();
        int r104 = 0;
        if (r102.getWriteHoldCount() != 0) goto L5;
        int r105 = r102.getReadHoldCount();
    L6:
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L9;
        r103.unlock();
        r106 = r106 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r107 = r102.writeLock();
        r107.lock();
        b r108 = f489642b.get(r100);     // Catch: Throwable -> L17
        if (r108 == null) goto L13;
        r108.a(r101);     // Catch: Throwable -> L17
    L13:
        if (r104 >= r105) goto L15;
        r103.lock();
        r104 = r104 + 1;
        goto L13
    L15:
        r107.unlock();
        return;
    L17:
        th = move-exception;
    L18:
        if (r104 >= r105) goto L20;
        r103.lock();
        r104 = r104 + 1;
        goto L18
    L20:
        r107.unlock();
        throw th;
    L5:
        r105 = 0;
        goto L6
    }

    public static void b(String r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "data");
        ReentrantReadWriteLock r102 = f489641a;
        ReentrantReadWriteLock.ReadLock r103 = r102.readLock();
        int r104 = 0;
        if (r102.getWriteHoldCount() != 0) goto L5;
        int r105 = r102.getReadHoldCount();
    L6:
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L9;
        r103.unlock();
        r106 = r106 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r107 = r102.writeLock();
        r107.lock();
        ConcurrentHashMap<String, b> r108 = f489642b;     // Catch: Throwable -> L21
        if (r108.get(r100) == null) goto L16;
    L12:
        if (r104 >= r105) goto L14;
        r103.lock();
        r104 = r104 + 1;
        goto L12
    L14:
        r107.unlock();
        return;
    L16:
        r108.put(r100, r101);     // Catch: Throwable -> L21
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L21
    L17:
        if (r104 >= r105) goto L19;
        r103.lock();
        r104 = r104 + 1;
        goto L17
    L19:
        r107.unlock();
        return;
    L21:
        th = move-exception;
    L22:
        if (r104 >= r105) goto L24;
        r103.lock();
        r104 = r104 + 1;
        goto L22
    L24:
        r107.unlock();
        throw th;
    L5:
        r105 = 0;
        goto L6
    }
}
