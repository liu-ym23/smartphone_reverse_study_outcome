package com.bytedance.helios.sdk.engine;

import com.bytedance.helios.sdk.HeliosEnvImpl;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements v97.d<String> {
    public f() {
    }

    @Override // v97.d
    public final String name() {
        return "user_region";
    }

    @Override // v97.d
    public final String getValue() {
        fz5.b.InterfaceC5970b r100 = HeliosEnvImpl.get().f245459b;
        if (r100 == null) goto L8;
        r100.b();
        return "";
    L8:
        return "";
    }
}
