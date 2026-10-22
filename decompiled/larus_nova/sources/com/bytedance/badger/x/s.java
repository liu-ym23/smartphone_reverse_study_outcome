package com.bytedance.badger.x;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes47.dex */
public final class s implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f199400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f199401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f199402c;

    public s(u r100, CountDownLatch r101, Ref.ObjectRef r102) {
        this.f199400a = r100;
        this.f199401b = r101;
        this.f199402c = r102;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.bytedance.badger.x.f] */
    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName r100) {
        if (this.f199400a.f199410d == this) goto L5;
        return;
    L5:
        this.f199400a.f199408b = null;
        Ref.ObjectRef r101 = this.f199402c;
        r101.element = new C10463f("service binding died", null);
        this.f199401b.countDown();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.bytedance.badger.x.f] */
    @Override // android.content.ServiceConnection
    public final void onNullBinding(ComponentName r100) {
        if (this.f199400a.f199410d == this) goto L5;
        return;
    L5:
        Ref.ObjectRef r101 = this.f199402c;
        r101.element = new C10463f("service null binding", null);
        this.f199401b.countDown();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
        if (this.f199400a.f199410d == this) goto L5;
        return;
    L5:
        this.f199400a.f199408b = null;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        if (this.f199400a.f199410d == this) goto L5;
        return;
    L5:
        u r102 = this.f199400a;
        r102.f199408b = C.a(r101);
        this.f199401b.countDown();
    }
}
