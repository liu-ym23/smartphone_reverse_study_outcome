package com.ss.android.lark.rustinfrabridge.netstate.impl;

import com.bytedance.lark.rustclient.api.h;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class LarkNetworkLevelManager_Factory implements Factory<LarkNetworkLevelManager> {
    private final Provider<h> rustClientProvider;

    @Override // javax.inject.Provider
    public LarkNetworkLevelManager get() {
        return newInstance(this.rustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public LarkNetworkLevelManager_Factory(Provider<h> r100) {
        this.rustClientProvider = r100;
    }

    public static LarkNetworkLevelManager_Factory create(Provider<h> r100) {
        return new LarkNetworkLevelManager_Factory(r100);
    }

    public static LarkNetworkLevelManager newInstance(h r100) {
        return new LarkNetworkLevelManager(r100);
    }
}
