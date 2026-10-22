package com.ss.android.lark.profile_office.userprofile;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeProfileViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeProfileViewModel_HiltModules_KeyModule_ProvideFactory f438908a = null;

        static {
            f438908a = new OfficeProfileViewModel_HiltModules_KeyModule_ProvideFactory();
        }
    }

    public OfficeProfileViewModel_HiltModules_KeyModule_ProvideFactory() {
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides("com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel");
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static OfficeProfileViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return a.f438908a;
    }

    @Override // javax.inject.Provider
    public String get() {
        return provide();
    }
}
