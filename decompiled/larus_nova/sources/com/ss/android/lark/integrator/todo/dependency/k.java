package com.ss.android.lark.integrator.todo.dependency;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class k implements g7c.s {
    public k() {
    }

    @Override // g7c.s
    public final void sendEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
    }

    @Override // g7c.s
    public final void sendEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
    }
}
