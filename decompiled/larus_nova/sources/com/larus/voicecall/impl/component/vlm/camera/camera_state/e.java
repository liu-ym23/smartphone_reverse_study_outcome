package com.larus.voicecall.impl.component.vlm.camera.camera_state;

import com.larus.utils.logger.FLogger;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class e implements q3a.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q3a.o f377876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f377877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r3a.l f377878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReentrantReadWriteLock f377879d;

    public static final class a {
    }

    static {
    }

    @Override // q3a.p
    public final void a() {
    }

    @Override // q3a.p
    public final void g() {
    }

    @Override // q3a.p
    public final void k(int r100) {
    }

    @Override // q3a.p
    public final void p(boolean r100, int r101) {
    }

    @Override // q3a.p
    public final void n() {
        b(new d());
    }

    @Override // q3a.p
    public final void r() {
        b(new c());
    }

    @Override // q3a.p
    public final String o() {
        return this.f377877b;
    }

    public e(q3a.o r100) {
        Intrinsics.checkNotNullParameter(r100, "eventDispatcher");
        this.f377876a = r100;
        this.f377877b = "CameraStateManager";
        this.f377878c = new b();
        this.f377879d = new ReentrantReadWriteLock();
        r100.a(this);
    }

    public final void b(final r3a.l r110) {
        Intrinsics.checkNotNullParameter(r110, "newState");
        ReentrantReadWriteLock r100 = this.f377879d;
        ReentrantReadWriteLock.ReadLock r101 = r100.readLock();
        int r102 = 0;
        if (r100.getWriteHoldCount() != 0) goto L5;
        int r103 = r100.getReadHoldCount();
    L6:
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L9;
        r101.unlock();
        r104 = r104 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r105 = r100.writeLock();
        r105.lock();
        final r3a.l r106 = this.f377878c;     // Catch: Throwable -> L20
        this.f377878c = r110;     // Catch: Throwable -> L20
        FLogger.f375446a.i("CameraStateManager", "State transition: " + r106.getTag() + " -> " + r110.getTag());     // Catch: Throwable -> L20
    L11:
        if (r102 >= r103) goto L13;
        r101.lock();
        r102 = r102 + 1;
        goto L11
    L13:
        r105.unlock();
        if (Intrinsics.areEqual(r106, r110) == true) goto L30;
        q3a.o r107 = this.f377876a;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r106, "oldState");
        Intrinsics.checkNotNullParameter(r110, "newState");
        if (r107.f531555c.get() == true) goto L31;
        FLogger.f375446a.i("CameraEventDispatcher", "Dispatching state change: " + r106.getTag() + " -> " + r110.getTag());
        r107.c("onStateChanged", new q3a.i(r106, r110));
        return;
    L31:
        return;
    L30:
        return;
    L20:
        th = move-exception;
    L21:
        if (r102 >= r103) goto L23;
        r101.lock();
        r102 = r102 + 1;
        goto L21
    L23:
        r105.unlock();
        throw th;
    L5:
        r103 = 0;
        goto L6
    }

    @Override // q3a.p
    public final void i(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "captureParams");
        b(new com.larus.voicecall.impl.component.vlm.camera.camera_state.a());
    }

    @Override // q3a.p
    public final void l(s3a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    @Override // q3a.p
    public final void s(r3a.i r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
    }

    @Override // q3a.p
    public final void t(r3a.j r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
    }

    @Override // q3a.p
    public final void h(r3a.l r100, r3a.l r101) {
        Intrinsics.checkNotNullParameter(r100, "oldState");
        Intrinsics.checkNotNullParameter(r101, "newState");
    }
}
