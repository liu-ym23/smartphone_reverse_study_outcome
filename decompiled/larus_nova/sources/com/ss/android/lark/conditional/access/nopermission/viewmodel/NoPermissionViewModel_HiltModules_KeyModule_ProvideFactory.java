package com.ss.android.lark.conditional.access.nopermission.viewmodel;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes35.dex */
public final class NoPermissionViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NoPermissionViewModel_HiltModules_KeyModule_ProvideFactory f418422a = null;

        static {
            f418422a = new NoPermissionViewModel_HiltModules_KeyModule_ProvideFactory();
        }
    }

    public NoPermissionViewModel_HiltModules_KeyModule_ProvideFactory() {
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides("com.ss.android.lark.conditional.access.nopermission.viewmodel.NoPermissionViewModel");
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static NoPermissionViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return a.f418422a;
    }

    @Override // javax.inject.Provider
    public String get() {
        return provide();
    }
}
