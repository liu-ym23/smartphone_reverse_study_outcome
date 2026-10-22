package com.ss.android.lark.message.lynxcard.monitor;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class LynxCardMonitorServiceImpl_Factory implements Factory<LynxCardMonitorServiceImpl> {
    private final Provider<l> rustClientProvider;

    @Override // javax.inject.Provider
    public LynxCardMonitorServiceImpl get() {
        return newInstance(this.rustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public LynxCardMonitorServiceImpl_Factory(Provider<l> r100) {
        this.rustClientProvider = r100;
    }

    public static LynxCardMonitorServiceImpl_Factory create(Provider<l> r100) {
        return new LynxCardMonitorServiceImpl_Factory(r100);
    }

    public static LynxCardMonitorServiceImpl newInstance(l r100) {
        return new LynxCardMonitorServiceImpl(r100);
    }
}
