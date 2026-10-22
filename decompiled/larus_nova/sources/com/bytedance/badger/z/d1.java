package com.bytedance.badger.z;

import android.content.Context;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataJson;
import com.bytedance.badger.module.BadgerModuleBase;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class d1 extends u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f199457a;

    public d1() {
    }

    public static BadgerResult c(com.bytedance.badger.x.y r100) {
        String r101 = r100.f199427d;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.length();
    L7:
        if (r103 <= 3) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L22;
        Pair[] r105 = new Pair[3];
        r105[0] = TuplesKt.to("1", r100.f199427d);
        r105[1] = TuplesKt.to("2", r100.f199428e);
        com.bytedance.badger.x.z r106 = r100.f199426c;
        boolean r107 = r106.f199430a;
        if (r107 == true) goto L14;
    L16:
        if (r107 == false) goto L19;
        r102 = 2;
    L21:
        r105[2] = TuplesKt.to("3", Integer.valueOf(r102));
        return new BadgerResult.Success(new DataJson(com.bm.badgervi.b.f(r105)));
    L19:
        if (r106.f199431b == false) goto L21;
        r102 = 1;
        goto L21
    L14:
        if (r106.f199431b == false) goto L16;
        r102 = 3;
        goto L21
    L22:
        int r108 = r100.f199424a;
        String r109 = r100.f199425b;
        if (r109.length() <= 25) goto L26;
        r109 = r109.substring(0, 25);
    L26:
        return new BadgerResult.Failure(r108, r109);
    L9:
        r104 = false;
        goto L10
    L5:
        r103 = 0;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [T, com.bytedance.badger.x.y] */
    /* JADX WARN: Type inference failed for: r0v7, types: [T, com.bytedance.badger.x.y] */
    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r110, BadgerModuleBase.BadgerRequestData r210) {
        long r100 = System.currentTimeMillis();
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        r101.element = null;
        AtomicBoolean r102 = new AtomicBoolean(false);
        com.bytedance.badger.x.f0.f199382h.getClass();
        Lazy r103 = com.bytedance.badger.x.f0.f199381g;
        KProperty r104 = com.bytedance.badger.x.x.f199423a[0];
        com.bytedance.badger.x.f0 r105 = (com.bytedance.badger.x.f0) r103.getValue();
        r105.getClass();
        com.bytedance.badger.x.z r111 = new com.bytedance.badger.x.z(com.bytedance.badger.x.f0.g(), com.bytedance.badger.x.p.d(r110));
        this.f199457a = null;     // Catch: Throwable -> L12
        com.bytedance.badger.e.b("DeviceFingerprint1Provider", "getInfoV2 start");     // Catch: Throwable -> L12
        CountDownLatch r106 = new CountDownLatch(1);     // Catch: Throwable -> L12
        r105.e(r110, new c1(this, r102, r101, r106));     // Catch: Throwable -> L12
        com.bytedance.badger.v.d.f199322f0.getClass();     // Catch: Throwable -> L12
        com.bytedance.badger.v.g r107 = com.bytedance.badger.v.d.f199324h;     // Catch: Throwable -> L12
        KProperty r112 = com.bytedance.badger.v.d.f199311a[7];     // Catch: Throwable -> L12
        com.bytedance.badger.v.w r108 = (com.bytedance.badger.v.w) r107.a();     // Catch: Throwable -> L12
        if (r106.await(r108.f199356a, r108.f199357b) == true) goto L11;
        this.f199457a = Long.valueOf(r210.getToken());     // Catch: Throwable -> L12
        boolean r109 = true;
        r101.element = new com.bytedance.badger.x.y(-2001, "timeout", r111, null, null, 56);     // Catch: Throwable -> L9
    L15:
        r102.set(r109);
        StringBuilder r113 = new StringBuilder("getInfoV2 result= ");
        com.bytedance.badger.x.y r114 = (com.bytedance.badger.x.y) r101.element;
        if (r114 == null) goto L18;
        String r115 = r114.f199425b;
    L19:
        r113.append(r115);
        com.bytedance.badger.e.b("DeviceFingerprint1Provider", r113.toString());
        com.bytedance.badger.x.y r116 = (com.bytedance.badger.x.y) r101.element;
        if (r116 == null) goto L33;
        com.bytedance.badger.x.f0.f("getInfo", r116, System.currentTimeMillis() - r100, null, null);
        return c(r116);
    L33:
        return new BadgerResult.Failure(-1000, "DeviceFp1Task onFailure");
    L18:
        r115 = null;
    L9:
        th = th;
    L31:
        com.bytedance.badger.e.c("DeviceFingerprint1Provider", "DeviceFp1Task  " + th.getClass().getName() + ' ' + th.getMessage(), th);     // Catch: Throwable -> L24
        r101.element = new com.bytedance.badger.x.y(-2001, "timeout", r111, null, null, 56);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        r102.set(r109);
        throw th;
    L11:
        r109 = true;
    L12:
        th = th;
        r109 = true;
        goto L31
    }
}
