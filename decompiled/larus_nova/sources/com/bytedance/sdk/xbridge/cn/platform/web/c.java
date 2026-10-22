package com.bytedance.sdk.xbridge.cn.platform.web;

import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class c extends me7.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ue7.d f270030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PlatformType f270031f;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final ue7.d getJsEventDelegate() {
        return this.f270030e;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final PlatformType getPlatformType() {
        return this.f270031f;
    }

    public c(String r100, SSWebView r101, ue7.d r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "containerID");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "jsEventDelegate");
        Intrinsics.checkNotNullParameter(r103, "namespace");
        super(r100, r101, r103);
        this.f270030e = r102;
        this.f270031f = PlatformType.WEB;
    }
}
