package com.bytedance.sdk.bridge.auth;

import com.bytedance.sdk.bridge.BridgeMethodInfo;
import com.bytedance.sdk.bridge.g;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes22.dex */
public abstract class AbsBridgeAuthenticator<T> implements g<T> {
    protected a<T> chain;

    public AbsBridgeAuthenticator() {
        this.chain = new a();
    }

    public AbsBridgeAuthenticator<T> add(BridgeAuthFilter<T> r100) {
        ((ArrayList) this.chain.f269564a).add(r100);
        return this;
    }

    @Override // com.bytedance.sdk.bridge.g
    public boolean auth(T r100, BridgeMethodInfo r101) {
        return authFilters(r100, r101);
    }

    public boolean authFilters(T r100, BridgeMethodInfo r101) {
        boolean r102 = this.chain.a(r100, r101);
        this.chain.f269565b = 0;
        return r102;
    }
}
