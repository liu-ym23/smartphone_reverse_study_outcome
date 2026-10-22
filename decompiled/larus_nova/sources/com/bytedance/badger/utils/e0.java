package com.bytedance.badger.utils;

import android.os.Binder;
import android.os.Parcel;
import com.bytedance.badger.BadgerCore;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes47.dex */
public final class e0 extends Binder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f0 f199238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0 f199239b;

    public e0(f0 r100, f0 r101) {
        this.f199238a = r100;
        this.f199239b = r101;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) {
        if (r100 != 1) goto L5;
        f r104 = f.f199243d;     // Catch: Throwable -> L19
        r104.getClass();     // Catch: Throwable -> L19
        BadgerCore.Companion.getClass();     // Catch: Throwable -> L19
        r101.enforceInterface(com.bytedance.badger.j.b(2079221550204419682L));     // Catch: Throwable -> L19
        r101.readString();     // Catch: Throwable -> L19
        String r105 = r101.readString();     // Catch: Throwable -> L19
        r101.readString();     // Catch: Throwable -> L19
        r101.readInt();     // Catch: Throwable -> L19
        if (this.f199238a.f199247d.compareAndSet(0, 1) == false) goto L12;
        this.f199238a.f199248e.set(r105);     // Catch: Throwable -> L19
        com.bytedance.badger.e.f("vivo#", "get result done, t=" + ThreadMethodProxy.currentThread().getName());     // Catch: Throwable -> L19
    L16:
        if (r102 == null) goto L18;
        r102.writeNoException();     // Catch: Throwable -> L19
    L18:
        f0 r106 = this.f199238a;
        AtomicBoolean r107 = r106.f199252i;
        CountDownLatch r108 = r106.f199253j;
        w r109 = new w(this);
    L22:
        f.c(r104, r107, r108, r109);
        return true;
    L12:
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        f.a(r104).post(new d0(this, r105));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        this.f199238a.f199255l.set(th);     // Catch: Throwable -> L24
        r104 = f.f199243d;
        f0 r110 = this.f199238a;
        r107 = r110.f199252i;
        r108 = r110.f199253j;
        r109 = new w(this);
    L24:
        th = move-exception;
        f r111 = f.f199243d;
        f0 r112 = this.f199238a;
        f.c(r111, r112.f199252i, r112.f199253j, new w(this));
        throw th;
    L5:
        return super.onTransact(r100, r101, r102, r103);
    }
}
