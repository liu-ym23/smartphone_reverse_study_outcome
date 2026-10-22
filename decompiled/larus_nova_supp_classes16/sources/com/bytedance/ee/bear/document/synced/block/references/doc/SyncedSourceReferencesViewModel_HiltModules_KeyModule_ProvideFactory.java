package com.bytedance.ee.bear.document.synced.block.references.doc;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class SyncedSourceReferencesViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {

    public static final class a {
        public static final SyncedSourceReferencesViewModel_HiltModules_KeyModule_ProvideFactory a = null;

        static {
            a = new SyncedSourceReferencesViewModel_HiltModules_KeyModule_ProvideFactory();
        }
    }

    public SyncedSourceReferencesViewModel_HiltModules_KeyModule_ProvideFactory() {
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides("com.bytedance.ee.bear.document.synced.block.references.doc.SyncedSourceReferencesViewModel");
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m271get();
    }

    public static SyncedSourceReferencesViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public String m271get() {
        return provide();
    }
}
