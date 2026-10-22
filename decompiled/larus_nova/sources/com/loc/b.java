package com.loc;

import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class b extends bo {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final byte[] f379922k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, String> f379923l;

    @Override // com.loc.bo
    public final Map<String, String> a() {
        return null;
    }

    @Override // com.loc.bo
    public final String c() {
        return "https://adiu.amap.com/ws/device/adius";
    }

    @Override // com.loc.bo
    public final Map<String, String> h() {
        return this.f379923l;
    }

    @Override // com.loc.bo
    public final byte[] i() {
        return this.f379922k;
    }

    public b(byte[] r100, Map<String, String> r101) {
        this.f379922k = r100;
        this.f379923l = r101;
        this.f379932i = bo.a.f379938e;
        b(bo.c.f379951b);
    }
}
