package com.bytedance.badger.z;

import com.bytedance.badger.data.DataString;
import com.bytedance.badger.module.BadgerModuleBase;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes47.dex */
public final class g0 implements com.bytedance.badger.utils.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f199461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f199462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f199463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BadgerModuleBase.BadgerRequestData f199464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f199465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f199466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.badger.utils.x f199467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f199468h;

    public g0(h0 r100, AtomicInteger r101, Ref.ObjectRef r102, BadgerModuleBase.BadgerRequestData r103, long r104, CountDownLatch r105, com.bytedance.badger.utils.x r106, Ref.ObjectRef r107) {
        this.f199461a = r100;
        this.f199462b = r101;
        this.f199463c = r102;
        this.f199464d = r103;
        this.f199465e = r104;
        this.f199466f = r105;
        this.f199467g = r106;
        this.f199468h = r107;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.String] */
    public final void a(com.bytedance.badger.utils.p r100) {
        Ref.ObjectRef r101 = this.f199468h;     // Catch: Throwable -> L5
        r101.element = r100.a();     // Catch: Throwable -> L5
        this.f199466f.countDown();
        this.f199467g.d();
        return;
    L5:
        th = move-exception;
        this.f199466f.countDown();
        this.f199467g.d();
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v3, types: [T, java.lang.String] */
    public final void b(String r100) {
    L8:
        th = move-exception;
        Ref.ObjectRef r101 = this.f199468h;     // Catch: Throwable -> L15
        r101.element = th.toString();     // Catch: Throwable -> L15
    L13:
        this.f199466f.countDown();
        this.f199467g.d();
        return;
    L15:
        th = move-exception;
        this.f199466f.countDown();
        this.f199467g.d();
        throw th;
    L3:
        if (this.f199462b.compareAndSet(0, 1) == false) goto L5;
        this.f199463c.element = r100;     // Catch: Throwable -> L8
    L20:
        goto L13
    L5:
        h0 r102 = this.f199461a;     // Catch: Throwable -> L8
        Long r103 = Long.valueOf(this.f199464d.getToken());     // Catch: Throwable -> L8
        DataString r104 = new DataString(r100);     // Catch: Throwable -> L8
        long r105 = System.currentTimeMillis() - this.f199465e;     // Catch: Throwable -> L8
        r102.getClass();     // Catch: Throwable -> L8
        if (u0.b(r103, r104, r105) == false) goto L10;
        com.bytedance.badger.network.z0 r106 = com.bytedance.badger.network.d0.f199093a;     // Catch: Throwable -> L8
        com.bytedance.badger.network.d0.b(23, z64.h.b.f570472a, new f0(), true);     // Catch: Throwable -> L8
        goto L20
    L10:
        com.bytedance.badger.e.g("oppo#", " complete fail.");     // Catch: Throwable -> L8
        goto L20
    }
}
