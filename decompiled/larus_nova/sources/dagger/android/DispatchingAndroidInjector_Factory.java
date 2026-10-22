package dagger.android;

import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes41.dex */
public final class DispatchingAndroidInjector_Factory<T> implements Factory<DispatchingAndroidInjector<T>> {
    private final Provider<Map<Class<?>, Provider<AndroidInjector.Factory<?>>>> injectorFactoriesWithClassKeysProvider;
    private final Provider<Map<String, Provider<AndroidInjector.Factory<?>>>> injectorFactoriesWithStringKeysProvider;

    @Override // javax.inject.Provider
    public DispatchingAndroidInjector<T> get() {
        return newInstance(this.injectorFactoriesWithClassKeysProvider.get(), this.injectorFactoriesWithStringKeysProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DispatchingAndroidInjector_Factory(Provider<Map<Class<?>, Provider<AndroidInjector.Factory<?>>>> r100, Provider<Map<String, Provider<AndroidInjector.Factory<?>>>> r101) {
        this.injectorFactoriesWithClassKeysProvider = r100;
        this.injectorFactoriesWithStringKeysProvider = r101;
    }

    public static <T> DispatchingAndroidInjector_Factory<T> create(Provider<Map<Class<?>, Provider<AndroidInjector.Factory<?>>>> r100, Provider<Map<String, Provider<AndroidInjector.Factory<?>>>> r101) {
        return new DispatchingAndroidInjector_Factory(r100, r101);
    }

    public static <T> DispatchingAndroidInjector<T> newInstance(Map<Class<?>, Provider<AndroidInjector.Factory<?>>> r100, Map<String, Provider<AndroidInjector.Factory<?>>> r101) {
        return new DispatchingAndroidInjector(r100, r101);
    }
}
