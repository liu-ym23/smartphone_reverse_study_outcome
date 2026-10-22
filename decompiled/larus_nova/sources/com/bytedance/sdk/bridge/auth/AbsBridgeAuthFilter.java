package com.bytedance.sdk.bridge.auth;

import com.bytedance.sdk.bridge.BridgeMethodInfo;

/* JADX INFO: loaded from: classes22.dex */
public abstract class AbsBridgeAuthFilter<T> implements BridgeAuthFilter<T> {
    public AbsBridgeAuthFilter() {
    }

    public abstract boolean auth(T r100, BridgeMethodInfo r101);

    @Override // com.bytedance.sdk.bridge.auth.BridgeAuthFilter
    public boolean doAuthFilter(T r100, BridgeMethodInfo r101, a<T> r102) {
        if (auth(r100, r101) == false) goto L7;
        return true;
    L7:
        return r102.a(r100, r101);
    }
}
