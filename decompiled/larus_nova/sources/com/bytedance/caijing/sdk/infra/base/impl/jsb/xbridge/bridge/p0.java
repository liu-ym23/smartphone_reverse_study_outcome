package com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.bridge;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;

/* JADX INFO: loaded from: classes15.dex */
@XBridgeMethod(name = "ttcjpay.preload")
public final class p0 extends com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f202674k;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.a
    public final boolean h() {
        return true;
    }

    public p0() {
        this.f202674k = "ttcjpay.preload";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f202674k;
    }
}
