package com.ss.android.lark.chat.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class MessageTenantConfService_Factory implements Factory<MessageTenantConfService> {
    private final Provider<b38.b> rucketProvider;

    @Override // javax.inject.Provider
    public MessageTenantConfService get() {
        return newInstance(this.rucketProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MessageTenantConfService_Factory(Provider<b38.b> r100) {
        this.rucketProvider = r100;
    }

    public static MessageTenantConfService_Factory create(Provider<b38.b> r100) {
        return new MessageTenantConfService_Factory(r100);
    }

    public static MessageTenantConfService newInstance(b38.b r100) {
        return new MessageTenantConfService(r100);
    }
}
