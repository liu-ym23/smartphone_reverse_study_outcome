package com.bytedance.ies.bullet.web.pia;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;

/* JADX INFO: loaded from: classes19.dex */
public final class d<T> implements l47.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f248311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f248312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IDLXBridgeMethod f248313c;

    public d(String r100, String r101, IDLXBridgeMethod r102) {
        this.f248311a = r100;
        this.f248312b = r101;
        this.f248313c = r102;
    }

    @Override // l47.b
    public final Object create() {
        return new k(this.f248311a, this.f248312b, this.f248313c);
    }

    @Override // l47.b
    public final Object create(Object r100) {
        return create();
    }
}
