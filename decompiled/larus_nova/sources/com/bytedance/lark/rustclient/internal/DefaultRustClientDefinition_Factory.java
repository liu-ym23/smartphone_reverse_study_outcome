package com.bytedance.lark.rustclient.internal;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes20.dex */
public final class DefaultRustClientDefinition_Factory implements Factory<DefaultRustClientDefinition> {
    private final Provider<Set<com.bytedance.lark.rustclient.api.o>> asyncCallbackExecutorGroupsProvider;

    @Override // javax.inject.Provider
    public DefaultRustClientDefinition get() {
        return newInstance(this.asyncCallbackExecutorGroupsProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DefaultRustClientDefinition_Factory(Provider<Set<com.bytedance.lark.rustclient.api.o>> r100) {
        this.asyncCallbackExecutorGroupsProvider = r100;
    }

    public static DefaultRustClientDefinition_Factory create(Provider<Set<com.bytedance.lark.rustclient.api.o>> r100) {
        return new DefaultRustClientDefinition_Factory(r100);
    }

    public static DefaultRustClientDefinition newInstance(Set<com.bytedance.lark.rustclient.api.o> r100) {
        return new DefaultRustClientDefinition(r100);
    }
}
