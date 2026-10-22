package com.bytedance.locallife.live.dsl;

import bolts.Task;
import com.alibaba.gaiax.api.GXRegisterCenterApi;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements GXRegisterCenterApi.GXMonitor {
    public e() {
    }

    @Override // com.alibaba.gaiax.api.GXRegisterCenterApi.GXMonitor
    public final void onImageLoadSuccess(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "uri");
        boolean r102 = LiveLocalLifeDSLEngine.f259406a;
        if (((Boolean) LiveLocalLifeDSLEngine.f259410e.getValue()).booleanValue() == false) goto L7;
        Task.callInBackground(new g(r101, r100));
        return;
    }
}
