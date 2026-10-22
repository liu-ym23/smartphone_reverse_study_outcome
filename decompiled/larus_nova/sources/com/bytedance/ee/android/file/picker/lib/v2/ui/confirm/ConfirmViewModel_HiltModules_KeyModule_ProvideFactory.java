package com.bytedance.ee.android.file.picker.lib.v2.ui.confirm;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes15.dex */
public final class ConfirmViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ConfirmViewModel_HiltModules_KeyModule_ProvideFactory f206096a = null;

        static {
            f206096a = new ConfirmViewModel_HiltModules_KeyModule_ProvideFactory();
        }
    }

    public ConfirmViewModel_HiltModules_KeyModule_ProvideFactory() {
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides("com.bytedance.ee.android.file.picker.lib.v2.ui.confirm.ConfirmViewModel");
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static ConfirmViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return a.f206096a;
    }

    @Override // javax.inject.Provider
    public String get() {
        return provide();
    }
}
