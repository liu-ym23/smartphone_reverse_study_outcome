package io.ktor.utils.io.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes41.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f492098b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f492099c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f492100d = null;
    public volatile /* synthetic */ int _availableForRead$internal;
    public volatile /* synthetic */ int _availableForWrite$internal;
    volatile /* synthetic */ int _pendingToFlush;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f492101a;

    static {
        f492098b = AtomicIntegerFieldUpdater.newUpdater(j.class, "_availableForRead$internal");
        f492099c = AtomicIntegerFieldUpdater.newUpdater(j.class, "_availableForWrite$internal");
        f492100d = AtomicIntegerFieldUpdater.newUpdater(j.class, "_pendingToFlush");
    }

    public final void f() {
        this._availableForRead$internal = 0;
        this._pendingToFlush = 0;
        this._availableForWrite$internal = this.f492101a;
    }

    public final boolean c() {
        int r100 = f492100d.getAndSet(this, 0);
        if (r100 != 0) goto L9;
        if (this._availableForRead$internal <= 0) goto L12;
        return true;
    L12:
        return false;
    L9:
        if (f492098b.addAndGet(this, r100) <= 0) goto L13;
        return true;
    L13:
        return false;
    }

    public final boolean d() {
        if (this._availableForWrite$internal != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void e() {
        this._availableForRead$internal = this.f492101a;
        this._availableForWrite$internal = 0;
        this._pendingToFlush = 0;
    }

    public final boolean g() {
    L2:
        int r100 = this._availableForWrite$internal;
        if (this._pendingToFlush > 0) goto L13;
        if (this._availableForRead$internal > 0) goto L13;
        if (r100 != this.f492101a) goto L13;
        if (f492099c.compareAndSet(this, r100, 0) == false) goto L2;
        return true;
    L13:
        return false;
    }

    public final String toString() {
        return "RingBufferCapacity[read: " + this._availableForRead$internal + ", write: " + this._availableForWrite$internal + ", flush: " + this._pendingToFlush + ", capacity: " + this.f492101a + ']';
    }

    public j(int r100) {
        this.f492101a = r100;
        this._availableForRead$internal = 0;
        this._availableForWrite$internal = r100;
        this._pendingToFlush = 0;
    }

    public final void a(int r100) {
    L2:
        int r101 = this._availableForWrite$internal;
        int r102 = r101 + r100;
        if (r102 > this.f492101a) goto L8;
        if (f492099c.compareAndSet(this, r101, r102) == false) goto L2;
        return;
    L8:
        throw new IllegalArgumentException("Completed read overflow: " + r101 + " + " + r100 + " = " + r102 + " > " + this.f492101a);
    }

    public final void b(int r100) {
    L2:
        int r101 = this._pendingToFlush;
        int r102 = r101 + r100;
        if (r102 > this.f492101a) goto L8;
        if (f492100d.compareAndSet(this, r101, r102) == false) goto L2;
        return;
    L8:
        throw new IllegalArgumentException("Complete write overflow: " + r101 + " + " + r100 + " > " + this.f492101a);
    }

    public final int h(int r100) {
    L2:
        int r101 = this._availableForRead$internal;
        int r102 = Math.min(r100, r101);
        if (r102 == 0) goto L4;
        AtomicIntegerFieldUpdater r103 = f492098b;
        if (r103.compareAndSet(this, r101, r101 - r102) == false) goto L2;
        return Math.min(r100, r101);
    L4:
        return 0;
    }

    public final boolean i(int r100) {
    L2:
        int r101 = this._availableForRead$internal;
        if (r101 < r100) goto L4;
        AtomicIntegerFieldUpdater r102 = f492098b;
        if (r102.compareAndSet(this, r101, r101 - r100) == false) goto L2;
        return true;
    L4:
        return false;
    }

    public final int j(int r100) {
    L2:
        int r101 = this._availableForWrite$internal;
        int r102 = Math.min(r100, r101);
        if (r102 == 0) goto L4;
        AtomicIntegerFieldUpdater r103 = f492099c;
        if (r103.compareAndSet(this, r101, r101 - r102) == false) goto L2;
        return Math.min(r100, r101);
    L4:
        return 0;
    }

    public final boolean k(int r100) {
    L2:
        int r101 = this._availableForWrite$internal;
        if (r101 < r100) goto L4;
        AtomicIntegerFieldUpdater r102 = f492099c;
        if (r102.compareAndSet(this, r101, r101 - r100) == false) goto L2;
        return true;
    L4:
        return false;
    }
}
