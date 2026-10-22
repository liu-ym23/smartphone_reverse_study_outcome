package com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.bridge;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;

/* JADX INFO: loaded from: classes15.dex */
@XBridgeMethod(name = "ttcjpay.disallowCapture")
public final class v extends com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f202685k;

    public static final class a {
    }

    static {
    }

    public v() {
        this.f202685k = "ttcjpay.disallowCapture";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f202685k;
    }
}
