package com.ivy.ivykit.plugin.impl.jsb.auth;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class a {
    public a() {
    }

    public final String a() {
        Intrinsics.checkNotNullParameter("com.bytedance.sdk.xbridge.cn.protocol.permission.permission_config_response", "key");
        return BridgeAuthInitializer.f278379a.getString("com.bytedance.sdk.xbridge.cn.protocol.permission.permission_config_response", null);
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter("com.bytedance.sdk.xbridge.cn.protocol.permission.permission_config_response", "key");
        Intrinsics.checkNotNullParameter(r100, "value");
        BridgeAuthInitializer.f278379a.storeString("com.bytedance.sdk.xbridge.cn.protocol.permission.permission_config_response", r100);
    }
}
