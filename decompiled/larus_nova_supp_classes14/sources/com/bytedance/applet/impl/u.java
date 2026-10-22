package com.bytedance.applet.impl;

import com.bytedance.ai.bridge.service.IHostLogDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDependV2;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u implements IHostLogDepend {
    public u() {
    }

    public final void putCommonParams(Map<String, String> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        XBaseRuntime.a.getClass();
        IHostLogDependV2 r0 = XBaseRuntime.x;
        if (r0 == null) goto L6;
        r0.putCommonParams(r2, r3);
        return;
    }
}
