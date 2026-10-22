package com.bytedance.ee.bear.document.synced.block.references.doc;

import com.bytedance.ee.bear.contract.NetService;
import dagger.internal.Factory;
import javax.inject.Provider;
import t45.c;

/* JADX INFO: loaded from: classes16.dex */
public final class SyncedSourceReferencesViewModel_Factory implements Factory<SyncedSourceReferencesViewModel> {
    private final Provider<c> spacekitUrlHelperProvider;
    private final Provider<NetService> userNetServiceProvider;

    @Override // javax.inject.Provider
    public SyncedSourceReferencesViewModel get() {
        return newInstance(this.userNetServiceProvider.get(), this.spacekitUrlHelperProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SyncedSourceReferencesViewModel_Factory(Provider<NetService> r100, Provider<c> r101) {
        this.userNetServiceProvider = r100;
        this.spacekitUrlHelperProvider = r101;
    }

    public static SyncedSourceReferencesViewModel_Factory create(Provider<NetService> r100, Provider<c> r101) {
        return new SyncedSourceReferencesViewModel_Factory(r100, r101);
    }

    public static SyncedSourceReferencesViewModel newInstance(NetService r100, c r101) {
        return new SyncedSourceReferencesViewModel(r100, r101);
    }
}
