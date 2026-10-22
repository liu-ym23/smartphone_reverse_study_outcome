package com.ss.android.lark.vote;

import dagger.internal.Factory;
import javax.inject.Provider;
import pbc.a;

/* JADX INFO: loaded from: classes38.dex */
public final class VoteModule_Factory implements Factory<VoteModule> {
    private final Provider<a> chatDependencyProvider;

    public static VoteModule newInstance() {
        return new VoteModule();
    }

    @Override // javax.inject.Provider
    public VoteModule get() {
        VoteModule r100 = newInstance();
        r100.f445147a = this.chatDependencyProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public VoteModule_Factory(Provider<a> r100) {
        this.chatDependencyProvider = r100;
    }

    public static VoteModule_Factory create(Provider<a> r100) {
        return new VoteModule_Factory(r100);
    }
}
