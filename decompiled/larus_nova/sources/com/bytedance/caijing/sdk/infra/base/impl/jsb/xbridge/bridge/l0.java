package com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.bridge;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;

/* JADX INFO: loaded from: classes15.dex */
@XBridgeMethod(name = "ttcjpay.preconnect")
public final class l0 extends com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f202654k;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.a
    public final boolean h() {
        return true;
    }

    public l0() {
        this.f202654k = "ttcjpay.preconnect";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f202654k;
    }
}
