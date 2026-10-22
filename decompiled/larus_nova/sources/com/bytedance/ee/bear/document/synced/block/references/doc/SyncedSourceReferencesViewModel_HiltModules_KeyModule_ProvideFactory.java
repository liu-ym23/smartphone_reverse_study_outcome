package com.bytedance.ee.bear.document.synced.block.references.doc;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes16.dex */
public final class SyncedSourceReferencesViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SyncedSourceReferencesViewModel_HiltModules_KeyModule_ProvideFactory f221950a = null;

        static {
            f221950a = new SyncedSourceReferencesViewModel_HiltModules_KeyModule_ProvideFactory();
        }
    }

    public SyncedSourceReferencesViewModel_HiltModules_KeyModule_ProvideFactory() {
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides("com.bytedance.ee.bear.document.synced.block.references.doc.SyncedSourceReferencesViewModel");
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static SyncedSourceReferencesViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return a.f221950a;
    }

    @Override // javax.inject.Provider
    public String get() {
        return provide();
    }
}
