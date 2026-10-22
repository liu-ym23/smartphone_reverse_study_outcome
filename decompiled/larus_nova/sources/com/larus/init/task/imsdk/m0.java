package com.larus.init.task.imsdk;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class m0 implements com.bytedance.lark.view_flow_wrapper.y {
    public m0() {
    }

    @Override // com.bytedance.lark.view_flow_wrapper.y
    public final void a(com.bytedance.lark.view_flow_wrapper.z r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        FLogger.f375446a.i("LarusViewFlowLogCallback", "larus onCallbackInfo info:" + r100);
    }
}
