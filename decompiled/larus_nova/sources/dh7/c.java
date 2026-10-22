package dh7;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Unit;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<KClass<? extends b>, b> f468621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantReadWriteLock f468622b;

    public static final class a {
    }

    static {
    }

    public c() {
        this.f468621a = new LinkedHashMap();
        this.f468622b = new ReentrantReadWriteLock();
    }

    public final void a(b r100) {
        ReentrantReadWriteLock r101 = this.f468622b;
        ReentrantReadWriteLock.ReadLock r102 = r101.readLock();
        int r103 = 0;
        if (r101.getWriteHoldCount() != 0) goto L5;
        int r104 = r101.getReadHoldCount();
    L6:
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L9;
        r102.unlock();
        r105 = r105 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r106 = r101.writeLock();
        r106.lock();
        this.f468621a.put(Reflection.getOrCreateKotlinClass(r100.getClass()), r100);     // Catch: Throwable -> L15
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L11:
        if (r103 >= r104) goto L13;
        r102.lock();
        r103 = r103 + 1;
        goto L11
    L13:
        r106.unlock();
        return;
    L15:
        th = move-exception;
    L16:
        if (r103 >= r104) goto L18;
        r102.lock();
        r103 = r103 + 1;
        goto L16
    L18:
        r106.unlock();
        throw th;
    L5:
        r104 = 0;
        goto L6
    }
}
