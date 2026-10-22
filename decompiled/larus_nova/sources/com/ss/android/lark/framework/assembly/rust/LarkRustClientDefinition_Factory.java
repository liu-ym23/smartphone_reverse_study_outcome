package com.ss.android.lark.framework.assembly.rust;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class LarkRustClientDefinition_Factory implements Factory<n> {
    private final Provider<Set<com.bytedance.lark.rustclient.api.o>> asyncCallbackExecutorGroupsProvider;
    private final Provider<e5c.b> simpleModeProvider;

    @Override // javax.inject.Provider
    public n get() {
        return newInstance(this.simpleModeProvider.get(), this.asyncCallbackExecutorGroupsProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public LarkRustClientDefinition_Factory(Provider<e5c.b> r100, Provider<Set<com.bytedance.lark.rustclient.api.o>> r101) {
        this.simpleModeProvider = r100;
        this.asyncCallbackExecutorGroupsProvider = r101;
    }

    public static LarkRustClientDefinition_Factory create(Provider<e5c.b> r100, Provider<Set<com.bytedance.lark.rustclient.api.o>> r101) {
        return new LarkRustClientDefinition_Factory(r100, r101);
    }

    public static n newInstance(e5c.b r100, Set<com.bytedance.lark.rustclient.api.o> r101) {
        return new n(r100, r101);
    }
}
