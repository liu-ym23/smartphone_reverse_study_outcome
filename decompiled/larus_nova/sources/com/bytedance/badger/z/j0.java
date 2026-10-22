package com.bytedance.badger.z;

import com.bytedance.badger.data.DataJson;
import com.bytedance.badger.module.BadgerModuleBase;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class j0 implements a74.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject[] f199475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f199476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BadgerModuleBase.BadgerRequestData f199477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Long f199478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f199479e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String[] f199480f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ k0 f199481g;

    public j0(k0 r100, JSONObject[] r101, AtomicBoolean r102, BadgerModuleBase.BadgerRequestData r103, Long r104, CountDownLatch r105, String[] r106) {
        this.f199481g = r100;
        this.f199475a = r101;
        this.f199476b = r102;
        this.f199477c = r103;
        this.f199478d = r104;
        this.f199479e = r105;
        this.f199480f = r106;
    }

    @Override // a74.q
    public final void a(String r100) {
        this.f199480f[0] = r100;
        this.f199479e.countDown();
    }

    @Override // a74.q
    public final void a(JSONObject r100) {
        this.f199475a[0] = r100;
        if (this.f199476b.get() == false) goto L7;
        k0 r101 = this.f199481g;
        Long r102 = Long.valueOf(this.f199477c.getToken());
        DataJson r103 = new DataJson(r100);
        long r104 = System.currentTimeMillis() - this.f199478d.longValue();
        r101.getClass();
        boolean r105 = u0.b(r102, r103, r104);
        com.bytedance.badger.e.g("sensor#", "compensate status " + r105);
        if (r105 == false) goto L8;
        com.bytedance.badger.network.z0 r106 = com.bytedance.badger.network.d0.f199093a;
        com.bytedance.badger.network.d0.b(23, z64.h.b.f570472a, new i0(), true);
    L8:
        this.f199479e.countDown();
        return;
    L7:
        com.bytedance.badger.e.g("sensor#", " not compensate!");
        goto L8
    }
}
