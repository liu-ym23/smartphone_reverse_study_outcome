package com.ss.android.lark.rustinfrabridge.appstatesync.service.impl;

import com.bytedance.lark.rustclient.api.h;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class GlobalAppStateService_Factory implements Factory<d> {
    private final Provider<h> rustClientProvider;

    @Override // javax.inject.Provider
    public d get() {
        return newInstance(this.rustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public GlobalAppStateService_Factory(Provider<h> r100) {
        this.rustClientProvider = r100;
    }

    public static GlobalAppStateService_Factory create(Provider<h> r100) {
        return new GlobalAppStateService_Factory(r100);
    }

    public static d newInstance(h r100) {
        return new d(r100);
    }
}
