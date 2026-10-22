package dagger.android.support;

import dagger.android.AndroidInjector;

/* JADX INFO: loaded from: classes41.dex */
public abstract class DaggerApplication extends dagger.android.DaggerApplication {
    @Override // dagger.android.DaggerApplication
    public abstract AndroidInjector<? extends DaggerApplication> applicationInjector();

    public DaggerApplication() {
    }
}
