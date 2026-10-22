package dagger.hilt.android.internal.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes41.dex */
public final class ApplicationContextModule_ProvideContextFactory implements Factory<Context> {
    private final ApplicationContextModule module;

    @Override // javax.inject.Provider
    public Context get() {
        return provideContext(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ApplicationContextModule_ProvideContextFactory(ApplicationContextModule r100) {
        this.module = r100;
    }

    public static ApplicationContextModule_ProvideContextFactory create(ApplicationContextModule r100) {
        return new ApplicationContextModule_ProvideContextFactory(r100);
    }

    public static Context provideContext(ApplicationContextModule r100) {
        return (Context) Preconditions.checkNotNullFromProvides(r100.provideContext());
    }
}
