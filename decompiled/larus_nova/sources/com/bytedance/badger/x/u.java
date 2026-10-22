package com.bytedance.badger.x;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.v.d;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class u extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f199407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile D f199408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f199409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile s f199410d;

    public u() {
        this.f199407a = new Object();
    }

    @Override // com.bytedance.badger.x.q
    public final String c() {
        return "service";
    }

    public final void h() {
        Context r100 = this.f199409c;
        s r101 = this.f199410d;
        if (r100 == null) goto L6;
        if (r101 == null) goto L6;
        r100.unbindService(r101);     // Catch: Throwable -> L8
    L6:
        this.f199410d = null;
        this.f199408b = null;
    }

    @Override // com.bytedance.badger.x.q
    public final String a() {
        D r100 = this.f199408b;
        if (r100 == null) goto L27;
        boolean r101 = false;
        A r102 = r100.d(0);
        if (r102 == null) goto L25;
        if (r102.f199359a != 0) goto L23;
        byte[] r103 = r102.f199360b;
        if (r103 == null) goto L21;
        if (r103.length != 0) goto L14;
        r101 = true;
    L14:
        if ((!r101) == false) goto L21;
        String r104 = p.c(r103);
        if (r104 == null) goto L19;
        return r104;
    L19:
        throw new IllegalStateException("parse failed");
    L21:
        throw new IllegalStateException("exportResult.exportData is null");
    L23:
        throw new IllegalStateException("exportResult.resultCode != 0");
    L25:
        throw new IllegalStateException("exportResult is null");
    L27:
        throw new h("service target is null", null);
    }

    @Override // com.bytedance.badger.x.q
    public final void b() {
        D r100 = this.f199408b;
        if (r100 == null) goto L7;
        r100.b(0);
        return;
    L7:
        throw new h("service target is null", null);
    }

    @Override // com.bytedance.badger.x.q
    public final boolean e() {
        D r100 = this.f199408b;
        if (r100 == null) goto L7;
        return r100.c(0);
    L7:
        throw new h("service target is null", null);
    }

    @Override // com.bytedance.badger.x.q
    public final void f() {
        D r100 = this.f199408b;
        if (r100 == null) goto L7;
        r100.a(0);
        return;
    L7:
        throw new h("service target is null", null);
    }

    @Override // com.bytedance.badger.x.q
    public final void d(Context r100) {
        this.f199409c = r100.getApplicationContext();
        D r101 = this.f199408b;
        boolean r102 = true;
        if (r101 == null) goto L11;
        IBinder r103 = r101.asBinder();
        if (r103 == null) goto L11;
        if (r103.isBinderAlive() == false) goto L11;
        if (r103.pingBinder() == false) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
        return;
    L14:
        Object r105 = this.f199407a;
        monitor-enter(r105);
        D r106 = this.f199408b;     // Catch: Throwable -> L40
        if (r106 == null) goto L25;
        IBinder r107 = r106.asBinder();     // Catch: Throwable -> L40
        if (r107 == null) goto L25;
        if (r107.isBinderAlive() == false) goto L25;
        if (r107.pingBinder() == false) goto L25;
    L26:
        if (r102 == false) goto L44;
        monitor-exit(r105);
        return;
    L44:
        h();     // Catch: Throwable -> L35 i -> L38
        Context r108 = this.f199409c;     // Catch: Throwable -> L35 i -> L38
        if (r108 != null) goto L32;
        Intrinsics.throwNpe();     // Catch: Throwable -> L35 i -> L38
    L32:
        this.f199408b = g(r108);     // Catch: Throwable -> L35 i -> L38
        monitor-exit(r105);
        return;
    L35:
        th = move-exception;
        throw new h("service init failed", th);     // Catch: Throwable -> L40
    L38:
        e = move-exception;
        throw e;     // Catch: Throwable -> L40
    L25:
        r102 = false;
    L40:
        th = move-exception;
        throw th;
    L11:
        r104 = false;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final D g(Context r110) {
        CountDownLatch r100 = new CountDownLatch(1);
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        r101.element = null;
        s r102 = new s(this, r100, r101);
        this.f199410d = r102;
        Intent r103 = new Intent();
        BadgerCore.Companion.getClass();
        r103.setAction(com.bytedance.badger.j.b(2418618557650235769L));
        r103.setPackage(com.bytedance.badger.j.b(8129550834698778238L));
        if (r110.bindService(r103, r102, 1) == false) goto L18;
        d.f199322f0.getClass();
        com.bytedance.badger.v.g r111 = d.f199324h;
        KProperty r104 = d.f199311a[7];
        com.bytedance.badger.v.w r112 = (com.bytedance.badger.v.w) r111.a();
        if (r100.await(r112.f199356a, r112.f199357b) == false) goto L16;
        Throwable r113 = (Throwable) r101.element;
        if (r113 != null) goto L14;
        D r114 = this.f199408b;
        if (r114 == null) goto L12;
        return r114;
    L12:
        h();
        throw new h("service target is null after bind", null);
    L14:
        h();
        throw r113;
    L16:
        h();
        throw new g("wait service connect timeout");
    L18:
        this.f199410d = null;
        throw new C10463f("bind service failed", null);
    L20:
        th = move-exception;
        this.f199410d = null;
        throw new C10463f("bind service failed", th);
    }
}
