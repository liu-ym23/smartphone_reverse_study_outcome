package com.ss.android.lark.chameleonv2.lkapi.usercomponent;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import q1b.c;

/* JADX INFO: loaded from: classes35.dex */
public final class LkApiUserComponentImpl_Factory implements Factory<c> {
    private final Provider<m> pProvider;
    private final Provider<l> rProvider;

    @Override // javax.inject.Provider
    public c get() {
        return newInstance(this.pProvider.get(), this.rProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public LkApiUserComponentImpl_Factory(Provider<m> r100, Provider<l> r101) {
        this.pProvider = r100;
        this.rProvider = r101;
    }

    public static LkApiUserComponentImpl_Factory create(Provider<m> r100, Provider<l> r101) {
        return new LkApiUserComponentImpl_Factory(r100, r101);
    }

    public static c newInstance(m r100, l r101) {
        return new c(r100, r101);
    }
}
