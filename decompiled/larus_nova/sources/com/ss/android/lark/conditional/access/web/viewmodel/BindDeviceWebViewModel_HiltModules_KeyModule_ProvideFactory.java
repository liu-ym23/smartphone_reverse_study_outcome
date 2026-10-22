package com.ss.android.lark.conditional.access.web.viewmodel;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes35.dex */
public final class BindDeviceWebViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BindDeviceWebViewModel_HiltModules_KeyModule_ProvideFactory f418513a = null;

        static {
            f418513a = new BindDeviceWebViewModel_HiltModules_KeyModule_ProvideFactory();
        }
    }

    public BindDeviceWebViewModel_HiltModules_KeyModule_ProvideFactory() {
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides("com.ss.android.lark.conditional.access.web.viewmodel.BindDeviceWebViewModel");
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static BindDeviceWebViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return a.f418513a;
    }

    @Override // javax.inject.Provider
    public String get() {
        return provide();
    }
}
