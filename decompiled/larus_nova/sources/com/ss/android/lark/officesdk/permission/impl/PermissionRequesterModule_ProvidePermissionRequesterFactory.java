package com.ss.android.lark.officesdk.permission.impl;

import com.ss.android.lark.officesdk.permission.api.IPermissionRequester;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes37.dex */
public final class PermissionRequesterModule_ProvidePermissionRequesterFactory implements Factory<IPermissionRequester> {
    private final a module;

    @Override // javax.inject.Provider
    public IPermissionRequester get() {
        return providePermissionRequester(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PermissionRequesterModule_ProvidePermissionRequesterFactory(a r100) {
        this.module = r100;
    }

    public static PermissionRequesterModule_ProvidePermissionRequesterFactory create(a r100) {
        return new PermissionRequesterModule_ProvidePermissionRequesterFactory(r100);
    }

    public static IPermissionRequester providePermissionRequester(a r100) {
        r100.getClass();
        return (IPermissionRequester) Preconditions.checkNotNullFromProvides(new b());
    }
}
