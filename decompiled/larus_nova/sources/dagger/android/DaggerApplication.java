package dagger.android;

import android.app.Application;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes41.dex */
public abstract class DaggerApplication extends Application implements HasAndroidInjector {

    @Inject
    volatile DispatchingAndroidInjector<Object> androidInjector;

    public abstract AndroidInjector<? extends DaggerApplication> applicationInjector();

    private void injectIfNecessary() {
        if (this.androidInjector != null) goto L17;
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L6:
        if (this.androidInjector != null) goto L12;
        applicationInjector().inject(this);     // Catch: Throwable -> L14
        if (this.androidInjector != null) goto L12;
        throw new IllegalStateException("The AndroidInjector returned from applicationInjector() did not inject the DaggerApplication");     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    }

    @Override // dagger.android.HasAndroidInjector
    public AndroidInjector<Object> androidInjector() {
        injectIfNecessary();
        return this.androidInjector;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        injectIfNecessary();
    }

    public DaggerApplication() {
    }
}
