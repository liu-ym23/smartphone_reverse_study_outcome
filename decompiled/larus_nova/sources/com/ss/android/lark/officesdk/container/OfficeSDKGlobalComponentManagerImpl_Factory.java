package com.ss.android.lark.officesdk.container;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKGlobalComponentManagerImpl_Factory implements Factory<OfficeSDKGlobalComponentManagerImpl> {
    private final Provider<OfficeSDKGlobalComponent.OfficeSDKGlobalComponentBuilder> builderProvider;

    @Override // javax.inject.Provider
    public OfficeSDKGlobalComponentManagerImpl get() {
        return newInstance(this.builderProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSDKGlobalComponentManagerImpl_Factory(Provider<OfficeSDKGlobalComponent.OfficeSDKGlobalComponentBuilder> r100) {
        this.builderProvider = r100;
    }

    public static OfficeSDKGlobalComponentManagerImpl_Factory create(Provider<OfficeSDKGlobalComponent.OfficeSDKGlobalComponentBuilder> r100) {
        return new OfficeSDKGlobalComponentManagerImpl_Factory(r100);
    }

    public static OfficeSDKGlobalComponentManagerImpl newInstance(OfficeSDKGlobalComponent.OfficeSDKGlobalComponentBuilder r100) {
        return new OfficeSDKGlobalComponentManagerImpl(r100);
    }
}
