package dagger.hilt.android.internal.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistryOwner;
import dagger.Module;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.multibindings.Multibinds;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes41.dex */
public final class HiltViewModelFactory implements ViewModelProvider.Factory {
    private final ViewModelProvider.Factory delegateFactory;
    private final Set<String> hiltViewModelAssistedKeys;
    private final AbstractSavedStateViewModelFactory hiltViewModelFactory;
    private final Set<String> hiltViewModelKeys;

    public interface ActivityCreatorEntryPoint {
        Set<String> getViewModelAssistedKeys();

        ViewModelComponentBuilder getViewModelComponentBuilder();

        Set<String> getViewModelKeys();
    }

    public interface InstalledViewModelFactoriesEntryPoint extends ViewModelFactoriesEntryPoint {
    }

    public interface ViewModelFactoriesEntryPoint {
        Map<String, Object> getHiltViewModelAssistedMap();

        Map<String, Provider<ViewModel>> getHiltViewModelMap();
    }

    @Module
    public interface ViewModelModule {
        @Multibinds
        Map<String, Object> hiltViewModelAssistedMap();

        @Multibinds
        Map<String, ViewModel> hiltViewModelMap();
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(Class r100, CreationExtras r101) {
        return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(KClass r100, CreationExtras r101) {
        return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> r100) {
        if (this.hiltViewModelKeys.contains(r100.getName()) == false) goto L7;
        return (T) this.hiltViewModelFactory.create(r100);
    L7:
        if (this.hiltViewModelAssistedKeys.contains(r100.getName()) == true) goto L11;
        return (T) this.delegateFactory.create(r100);
    L11:
        throw new IllegalStateException("Found the @HiltViewModel-annotated class '" + r100.getName() + "' using @AssistedInject but tried to create with default 'ViewModelProvider.Factory'. Use 'ViewModelProvider.Factory' return from 'hiltAssisted()' extension or 'HiltViewModelFactories.assisted()' instead.");
    }

    public static ViewModelProvider.Factory createInternal(Activity r100, SavedStateRegistryOwner r101, Bundle r110, ViewModelProvider.Factory r111) {
        ActivityCreatorEntryPoint r102 = (ActivityCreatorEntryPoint) EntryPoints.get(r100, ActivityCreatorEntryPoint.class);
        return new HiltViewModelFactory(r101, r110, r102.getViewModelKeys(), r102.getViewModelAssistedKeys(), r111, r102.getViewModelComponentBuilder());
    }

    public HiltViewModelFactory(final SavedStateRegistryOwner r100, final Bundle r101, Set<String> r102, Set<String> r103, ViewModelProvider.Factory r104, final ViewModelComponentBuilder r105) {
        this.hiltViewModelKeys = r102;
        this.hiltViewModelAssistedKeys = r103;
        this.delegateFactory = r104;
        this.hiltViewModelFactory = new AnonymousClass1(this, r100, r101, r105);
    }
}
