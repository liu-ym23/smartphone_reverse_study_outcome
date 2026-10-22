package com.bytedance.applet.impl;

import com.bytedance.ai.model.AppletRuntimeManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class y1 implements AppletRuntimeManager.RuntimeLifecycleListener {
    public y1() {
    }

    public final void onRuntimeTerminated(String r3) {
        Intrinsics.checkNotNullParameter(r3, "appletId");
        aw3.w r0 = aw3.w.a;
        aw3.w.w(r3, "runtime_terminated");
        bw3.v.a.getClass();
        bw3.v.i(r3, "runtime_terminated");
    }
}
