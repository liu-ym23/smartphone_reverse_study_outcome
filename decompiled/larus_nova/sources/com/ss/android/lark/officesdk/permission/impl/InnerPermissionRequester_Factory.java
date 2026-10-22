package com.ss.android.lark.officesdk.permission.impl;

import com.ss.android.lark.officesdk.permission.api.IPermissionRequester;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class InnerPermissionRequester_Factory implements Factory<InnerPermissionRequester> {
    private final Provider<IPermissionRequester> delegateProvider;

    @Override // javax.inject.Provider
    public InnerPermissionRequester get() {
        return newInstance(this.delegateProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public InnerPermissionRequester_Factory(Provider<IPermissionRequester> r100) {
        this.delegateProvider = r100;
    }

    public static InnerPermissionRequester_Factory create(Provider<IPermissionRequester> r100) {
        return new InnerPermissionRequester_Factory(r100);
    }

    public static InnerPermissionRequester newInstance(IPermissionRequester r100) {
        return new InnerPermissionRequester(r100);
    }
}
