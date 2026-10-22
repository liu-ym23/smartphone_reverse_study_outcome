package com.bytedance.ies.argus.api.params;

import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class v extends com.bytedance.ies.argus.strategy.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AuthBridgeAccess f245786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f245787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f245788d;

    public v(AuthBridgeAccess r100) {
        Intrinsics.checkNotNullParameter(r100, "methodAuthType");
        this.f245786b = r100;
        this.f245787c = null;
        this.f245788d = null;
    }
}
