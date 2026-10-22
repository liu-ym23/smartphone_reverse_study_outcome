package io.ktor.utils.io.pool;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public abstract class f<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f492136a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f492137b = null;
    private volatile /* synthetic */ int borrowed;
    private volatile /* synthetic */ int disposed;
    private volatile /* synthetic */ Object instance;

    static {
        f492136a = AtomicIntegerFieldUpdater.newUpdater(f.class, "borrowed");
        f492137b = AtomicIntegerFieldUpdater.newUpdater(f.class, "disposed");
    }

    public abstract void b(T r100);

    public abstract T c();

    @Override // io.ktor.utils.io.pool.e
    public final T Q5() {
    L2:
        int r100 = this.borrowed;
        if (r100 != 0) goto L9;
        if (f492136a.compareAndSet(this, r100, 1) == false) goto L2;
        T r101 = c();
        this.instance = r101;
        return r101;
    L9:
        throw new IllegalStateException("Instance is already consumed");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        if (f492137b.compareAndSet(this, 0, 1) == false) goto L9;
        Object r100 = this.instance;
        if (r100 != null) goto L7;
        return;
    L7:
        this.instance = null;
        b(r100);
        return;
    }

    public f() {
        this.borrowed = 0;
        this.disposed = 0;
        this.instance = null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a();
    }

    @Override // io.ktor.utils.io.pool.e
    public final void Rl(T r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        if (this.instance != r100) goto L5;
        this.instance = null;
        if (f492137b.compareAndSet(this, 0, 1) == false) goto L17;
        b(r100);
        return;
    L17:
        throw new IllegalStateException("An instance is already disposed");
    L5:
        if (this.instance != null) goto L11;
        if (this.borrowed == 0) goto L11;
        throw new IllegalStateException("Already recycled or an irrelevant instance tried to be recycled");
    L11:
        throw new IllegalStateException("Unable to recycle irrelevant instance");
    }
}
