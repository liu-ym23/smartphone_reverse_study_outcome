package com.bytedance.ee.bear.document.synced.block.references.doc;

import com.bytedance.ee.bear.contract.NetService;
import dagger.internal.Factory;
import javax.inject.Provider;
import t45.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class SyncedSourceReferencesViewModel_Factory implements Factory<SyncedSourceReferencesViewModel> {
    private final Provider<c> spacekitUrlHelperProvider;
    private final Provider<NetService> userNetServiceProvider;

    public SyncedSourceReferencesViewModel get() {
        return newInstance((NetService) this.userNetServiceProvider.get(), (c) this.spacekitUrlHelperProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m270get() {
        return get();
    }

    public SyncedSourceReferencesViewModel_Factory(Provider<NetService> r1, Provider<c> r2) {
        this.userNetServiceProvider = r1;
        this.spacekitUrlHelperProvider = r2;
    }

    public static SyncedSourceReferencesViewModel_Factory create(Provider<NetService> r1, Provider<c> r2) {
        return new SyncedSourceReferencesViewModel_Factory(r1, r2);
    }

    public static SyncedSourceReferencesViewModel newInstance(NetService r1, c r2) {
        return new SyncedSourceReferencesViewModel(r1, r2);
    }
}
