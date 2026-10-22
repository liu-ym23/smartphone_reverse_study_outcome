package com.ss.android.lark.security.compliance.infra.usercomponent;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;
import y4c.c;

/* JADX INFO: loaded from: classes38.dex */
public final class ScsUserComponentImpl_Factory implements Factory<c> {
    private final Provider<l> rProvider;

    @Override // javax.inject.Provider
    public c get() {
        return newInstance(this.rProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ScsUserComponentImpl_Factory(Provider<l> r100) {
        this.rProvider = r100;
    }

    public static ScsUserComponentImpl_Factory create(Provider<l> r100) {
        return new ScsUserComponentImpl_Factory(r100);
    }

    public static c newInstance(l r100) {
        return new c(r100);
    }
}
