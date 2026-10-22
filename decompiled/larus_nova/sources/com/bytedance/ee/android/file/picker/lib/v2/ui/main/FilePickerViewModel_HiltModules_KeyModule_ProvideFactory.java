package com.bytedance.ee.android.file.picker.lib.v2.ui.main;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes15.dex */
public final class FilePickerViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FilePickerViewModel_HiltModules_KeyModule_ProvideFactory f206125a = null;

        static {
            f206125a = new FilePickerViewModel_HiltModules_KeyModule_ProvideFactory();
        }
    }

    public FilePickerViewModel_HiltModules_KeyModule_ProvideFactory() {
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides("com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel");
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static FilePickerViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return a.f206125a;
    }

    @Override // javax.inject.Provider
    public String get() {
        return provide();
    }
}
