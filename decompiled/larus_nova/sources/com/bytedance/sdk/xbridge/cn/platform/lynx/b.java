package com.bytedance.sdk.xbridge.cn.platform.lynx;

import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.lynx.tasm.LynxView;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class b extends me7.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LynxView f269969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ue7.d f269970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PlatformType f269971g;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final ue7.d getJsEventDelegate() {
        return this.f269970f;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final PlatformType getPlatformType() {
        return this.f269971g;
    }

    public b(String r100, LynxView r101, ue7.d r102, String r103) {
        PlatformType r104 = PlatformType.LYNX;
        Intrinsics.checkNotNullParameter(r100, "containerID");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "jsEventDelegate");
        Intrinsics.checkNotNullParameter(r103, "namespace");
        Intrinsics.checkNotNullParameter(r104, Keys.API_PARAM_KEY_PLATFORM_TYPE);
        super(r100, r101, r103);
        this.f269969e = r101;
        this.f269970f = r102;
        this.f269971g = r104;
    }
}
