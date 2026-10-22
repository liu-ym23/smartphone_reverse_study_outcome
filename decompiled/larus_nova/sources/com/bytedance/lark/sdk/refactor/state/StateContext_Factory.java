package com.bytedance.lark.sdk.refactor.state;

import com.bytedance.lark.sdk.refactor.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes20.dex */
public final class StateContext_Factory implements Factory<i> {
    private final Provider<m> delegateProvider;

    @Override // javax.inject.Provider
    public i get() {
        return newInstance(this.delegateProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public StateContext_Factory(Provider<m> r100) {
        this.delegateProvider = r100;
    }

    public static StateContext_Factory create(Provider<m> r100) {
        return new StateContext_Factory(r100);
    }

    public static i newInstance(m r100) {
        return new i(r100);
    }
}
