package com.bytedance.ies.bullet.core.kit.bridge;

import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class c implements IBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m16.b f246545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IBridgeMethod.Access f246546b;

    public boolean a() {
        return this instanceof com.bytedance.ies.bullet.kit.web.jsbridge.b;
    }

    public boolean i90() {
        return false;
    }

    @Override // com.bytedance.ies.bullet.service.base.i0
    public void release() {
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.a
    public IBridgeMethod.Access getAccess() {
        return this.f246546b;
    }

    public c(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        this.f246545a = r100;
        this.f246546b = IBridgeMethod.Access.PRIVATE;
    }
}
