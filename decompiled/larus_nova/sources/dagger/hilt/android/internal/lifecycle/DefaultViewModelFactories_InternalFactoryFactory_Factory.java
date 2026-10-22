package dagger.hilt.android.internal.lifecycle;

import android.app.Application;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes41.dex */
public final class DefaultViewModelFactories_InternalFactoryFactory_Factory implements Factory<DefaultViewModelFactories.InternalFactoryFactory> {
    private final Provider<Application> applicationProvider;
    private final Provider<Set<String>> assistedKeySetProvider;
    private final Provider<Set<String>> keySetProvider;
    private final Provider<ViewModelComponentBuilder> viewModelComponentBuilderProvider;

    @Override // javax.inject.Provider
    public DefaultViewModelFactories.InternalFactoryFactory get() {
        return newInstance(this.applicationProvider.get(), this.keySetProvider.get(), this.assistedKeySetProvider.get(), this.viewModelComponentBuilderProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DefaultViewModelFactories_InternalFactoryFactory_Factory(Provider<Application> r100, Provider<Set<String>> r101, Provider<Set<String>> r102, Provider<ViewModelComponentBuilder> r103) {
        this.applicationProvider = r100;
        this.keySetProvider = r101;
        this.assistedKeySetProvider = r102;
        this.viewModelComponentBuilderProvider = r103;
    }

    public static DefaultViewModelFactories_InternalFactoryFactory_Factory create(Provider<Application> r100, Provider<Set<String>> r101, Provider<Set<String>> r102, Provider<ViewModelComponentBuilder> r103) {
        return new DefaultViewModelFactories_InternalFactoryFactory_Factory(r100, r101, r102, r103);
    }

    public static DefaultViewModelFactories.InternalFactoryFactory newInstance(Application r100, Set<String> r101, Set<String> r102, ViewModelComponentBuilder r103) {
        return new DefaultViewModelFactories.InternalFactoryFactory(r100, r101, r102, r103);
    }
}
