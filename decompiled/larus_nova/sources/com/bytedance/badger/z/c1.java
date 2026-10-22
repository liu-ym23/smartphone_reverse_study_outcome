package com.bytedance.badger.z;

import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.IBadgerData;
import com.bytedance.badger.monitor.TriggerStage;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes47.dex */
public final class c1 implements com.bytedance.badger.x.b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d1 f199452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f199453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f199454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f199455d;

    public c1(d1 r100, AtomicBoolean r101, Ref.ObjectRef r102, CountDownLatch r103) {
        this.f199452a = r100;
        this.f199453b = r101;
        this.f199454c = r102;
        this.f199455d = r103;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.badger.x.b0
    public final void a(com.bytedance.badger.x.y r110, long r111) {
        if (this.f199453b.compareAndSet(false, true) == true) goto L12;
        Long r100 = this.f199452a.f199457a;
        BadgerResult r112 = d1.c(r110);
        if ((r112 instanceof BadgerResult.Success) == false) goto L10;
        if (r100 == null) goto L10;
        com.bytedance.badger.e.f("DeviceFingerprint1Provider", " onComplete after timeout");
        d1 r101 = this.f199452a;
        IBadgerData r113 = ((BadgerResult.Success) r112).getData();
        r101.getClass();
        if (u0.b(r100, r113, r111) == false) goto L10;
        com.bytedance.badger.C.b r114 = x64.b.f562608a;
        x64.b.a(new x64.l(TriggerStage.recollect, 16, false, com.bytedance.badger.C.a.f199021e, null, null, 52), null);
    L10:
        this.f199452a.f199457a = null;
        return;
    L12:
        this.f199454c.element = r110;
        this.f199455d.countDown();
    }
}
