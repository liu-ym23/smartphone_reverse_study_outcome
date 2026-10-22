package com.ss.android.lark.reaction.service.impl;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class ReactionService2_Factory implements Factory<ReactionService2> {
    private final Provider<m> passportProvider;
    private final Provider<l> rustClientProvider;

    @Override // javax.inject.Provider
    public ReactionService2 get() {
        return newInstance(this.passportProvider.get(), this.rustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ReactionService2_Factory(Provider<m> r100, Provider<l> r101) {
        this.passportProvider = r100;
        this.rustClientProvider = r101;
    }

    public static ReactionService2_Factory create(Provider<m> r100, Provider<l> r101) {
        return new ReactionService2_Factory(r100, r101);
    }

    public static ReactionService2 newInstance(m r100, l r101) {
        return new ReactionService2(r100, r101);
    }
}
