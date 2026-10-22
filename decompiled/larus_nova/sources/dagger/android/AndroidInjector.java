package dagger.android;

import dagger.BindsInstance;

/* JADX INFO: loaded from: classes41.dex */
public interface AndroidInjector<T> {

    public static abstract class Builder<T> implements Factory<T> {
        public Builder() {
        }

        public abstract AndroidInjector<T> build();

        @BindsInstance
        public abstract void seedInstance(T r100);

        @Override // dagger.android.AndroidInjector.Factory
        public final AndroidInjector<T> create(T r100) {
            seedInstance(r100);
            return build();
        }
    }

    public interface Factory<T> {
        AndroidInjector<T> create(@BindsInstance T r100);
    }

    void inject(T r100);
}
