package dagger.hilt.android.internal.modules;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.internal.Contexts;

/* JADX INFO: loaded from: classes41.dex */
@Module
public final class ApplicationContextModule {
    private final Context applicationContext;

    @Provides
    public Application provideApplication() {
        return Contexts.getApplication(this.applicationContext);
    }

    @Provides
    public Context provideContext() {
        return this.applicationContext;
    }

    public ApplicationContextModule(Context r100) {
        this.applicationContext = r100;
    }
}
