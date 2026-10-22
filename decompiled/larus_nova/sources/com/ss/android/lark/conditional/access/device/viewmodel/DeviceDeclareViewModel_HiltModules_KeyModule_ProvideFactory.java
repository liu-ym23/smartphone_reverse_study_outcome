package com.ss.android.lark.conditional.access.device.viewmodel;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes35.dex */
public final class DeviceDeclareViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DeviceDeclareViewModel_HiltModules_KeyModule_ProvideFactory f418042a = null;

        static {
            f418042a = new DeviceDeclareViewModel_HiltModules_KeyModule_ProvideFactory();
        }
    }

    public DeviceDeclareViewModel_HiltModules_KeyModule_ProvideFactory() {
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides("com.ss.android.lark.conditional.access.device.viewmodel.DeviceDeclareViewModel");
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static DeviceDeclareViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return a.f418042a;
    }

    @Override // javax.inject.Provider
    public String get() {
        return provide();
    }
}
