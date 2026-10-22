package dagger.hilt.android.internal.modules;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes41.dex */
public final class ApplicationContextModule_ProvideApplicationFactory implements Factory<Application> {
    private final ApplicationContextModule module;

    @Override // javax.inject.Provider
    public Application get() {
        return provideApplication(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ApplicationContextModule_ProvideApplicationFactory(ApplicationContextModule r100) {
        this.module = r100;
    }

    public static ApplicationContextModule_ProvideApplicationFactory create(ApplicationContextModule r100) {
        return new ApplicationContextModule_ProvideApplicationFactory(r100);
    }

    public static Application provideApplication(ApplicationContextModule r100) {
        return (Application) Preconditions.checkNotNullFromProvides(r100.provideApplication());
    }
}
