package com.bytedance.ies.bullet.core.kit.bridge;

import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class j implements com.bytedance.ies.bullet.service.base.bridge.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m16.b f246554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IBridgeMethod.Access f246555b;

    @Override // com.bytedance.ies.bullet.service.base.i0
    public void release() {
    }

    public IBridgeMethod.Access getAccess() {
        return this.f246555b;
    }

    public j(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        this.f246554a = r100;
        this.f246555b = IBridgeMethod.Access.PRIVATE;
    }
}
