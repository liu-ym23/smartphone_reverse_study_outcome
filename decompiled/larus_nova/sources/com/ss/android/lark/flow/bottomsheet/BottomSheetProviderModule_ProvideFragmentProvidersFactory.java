package com.ss.android.lark.flow.bottomsheet;

import agb.b;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class BottomSheetProviderModule_ProvideFragmentProvidersFactory implements Factory<List<com.ss.android.lark.bottomsheet.fragment.a.c>> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BottomSheetProviderModule_ProvideFragmentProvidersFactory f421962a = null;

        static {
            f421962a = new BottomSheetProviderModule_ProvideFragmentProvidersFactory();
        }
    }

    public BottomSheetProviderModule_ProvideFragmentProvidersFactory() {
    }

    public static List<com.ss.android.lark.bottomsheet.fragment.a.c> provideFragmentProviders() {
        int r100 = com.ss.android.lark.flow.bottomsheet.a.f421963a;
        return (List) Preconditions.checkNotNullFromProvides(CollectionsKt.listOf(new com.ss.android.lark.bottomsheet.fragment.a.c[]{new bgb.a(), new b(), new cgb.a()}));
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static BottomSheetProviderModule_ProvideFragmentProvidersFactory create() {
        return a.f421962a;
    }

    @Override // javax.inject.Provider
    public List<com.ss.android.lark.bottomsheet.fragment.a.c> get() {
        return provideFragmentProviders();
    }
}
