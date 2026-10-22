package com.ss.android.lark.chat.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class EditMessageService_Factory implements Factory<EditMessageService> {
    private final Provider<m6b.j> configServiceProvider;
    private final Provider<com.ss.android.lark.im.sdk.service.p> msgServiceProvider;
    private final Provider<b38.b> rucketProvider;

    @Override // javax.inject.Provider
    public EditMessageService get() {
        return newInstance(this.rucketProvider.get(), this.configServiceProvider.get(), this.msgServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public EditMessageService_Factory(Provider<b38.b> r100, Provider<m6b.j> r101, Provider<com.ss.android.lark.im.sdk.service.p> r102) {
        this.rucketProvider = r100;
        this.configServiceProvider = r101;
        this.msgServiceProvider = r102;
    }

    public static EditMessageService_Factory create(Provider<b38.b> r100, Provider<m6b.j> r101, Provider<com.ss.android.lark.im.sdk.service.p> r102) {
        return new EditMessageService_Factory(r100, r101, r102);
    }

    public static EditMessageService newInstance(b38.b r100, m6b.j r101, com.ss.android.lark.im.sdk.service.p r102) {
        return new EditMessageService(r100, r101, r102);
    }
}
