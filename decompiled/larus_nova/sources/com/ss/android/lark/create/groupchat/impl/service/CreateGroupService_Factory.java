package com.ss.android.lark.create.groupchat.impl.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class CreateGroupService_Factory implements Factory<CreateGroupService> {
    private final Provider<b> createGroupErrorHandleProvider;
    private final Provider<b38.b> rucketProvider;

    @Override // javax.inject.Provider
    public CreateGroupService get() {
        return newInstance(this.rucketProvider.get(), this.createGroupErrorHandleProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CreateGroupService_Factory(Provider<b38.b> r100, Provider<b> r101) {
        this.rucketProvider = r100;
        this.createGroupErrorHandleProvider = r101;
    }

    public static CreateGroupService_Factory create(Provider<b38.b> r100, Provider<b> r101) {
        return new CreateGroupService_Factory(r100, r101);
    }

    public static CreateGroupService newInstance(b38.b r100, b r101) {
        return new CreateGroupService(r100, r101);
    }
}
