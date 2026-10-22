package com.ss.android.lark.create.groupchat.impl;

import dagger.internal.Factory;
import hab.b;
import iab.a;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class CreateGroupChatCoreModule_Factory implements Factory<a> {
    private final Provider<hab.a> auditDependencyProvider;
    private final Provider<b> chatDependencyProvider;

    public static a newInstance() {
        return new a();
    }

    @Override // javax.inject.Provider
    public a get() {
        a r100 = newInstance();
        r100.f488975a = this.chatDependencyProvider.get();
        r100.f488976b = this.auditDependencyProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CreateGroupChatCoreModule_Factory(Provider<b> r100, Provider<hab.a> r101) {
        this.chatDependencyProvider = r100;
        this.auditDependencyProvider = r101;
    }

    public static CreateGroupChatCoreModule_Factory create(Provider<b> r100, Provider<hab.a> r101) {
        return new CreateGroupChatCoreModule_Factory(r100, r101);
    }
}
