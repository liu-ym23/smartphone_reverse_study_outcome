package dagger.hilt.android.internal.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistryOwner;
import dagger.Module;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.lifecycle.ViewModelAssistant;
import dagger.hilt.internal.GeneratedComponentManager;
import dagger.multibindings.Multibinds;
import java.util.Set;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes41.dex */
public final class DefaultViewModelFactories {

    public interface ActivityEntryPoint {
        InternalFactoryFactory getHiltInternalFactoryFactory();
    }

    @Module
    public interface ActivityModule {
        @Multibinds
        Set<String> viewModelAssistedKeys();

        @Multibinds
        Set<String> viewModelKeys();
    }

    public interface FragmentEntryPoint {
        InternalFactoryFactory getHiltInternalFactoryFactory();
    }

    public static final class InternalFactoryFactory {
        private final Application application;
        private final Set<String> assistedKeySet;
        private final Set<String> keySet;
        private final ViewModelComponentBuilder viewModelComponentBuilder;

        public <Factory> ViewModelProvider.Factory assistedFromActivity(ComponentActivity r100, ViewModelAssistant<Factory, ? extends ViewModel> r101) {
            if (r100.getIntent() == null) goto L5;
            Bundle r102 = r100.getIntent().getExtras();
        L7:
            return getHiltViewModelAssistedFactory(r100, r102, r101);
        L5:
            r102 = null;
            goto L7
        }

        public <Factory> ViewModelProvider.Factory assistedFromFragment(Fragment r100, ViewModelAssistant<Factory, ? extends ViewModel> r101) {
            return getHiltViewModelAssistedFactory(r100, r100.getArguments(), r101);
        }

        public ViewModelProvider.Factory fromActivity(ComponentActivity r100, ViewModelProvider.Factory r101) {
            if (r100.getIntent() == null) goto L5;
            Bundle r102 = r100.getIntent().getExtras();
        L7:
            return getHiltViewModelFactory(r100, r102, r101);
        L5:
            r102 = null;
            goto L7
        }

        public ViewModelProvider.Factory fromFragment(Fragment r100, ViewModelProvider.Factory r101) {
            return getHiltViewModelFactory(r100, r100.getArguments(), r101);
        }

        private <Factory> ViewModelProvider.Factory getHiltViewModelAssistedFactory(SavedStateRegistryOwner r100, Bundle r101, ViewModelAssistant<Factory, ? extends ViewModel> r102) {
            return new HiltViewModelAssistedFactory(r100, r101, this.viewModelComponentBuilder, r102);
        }

        private ViewModelProvider.Factory getHiltViewModelFactory(SavedStateRegistryOwner r100, Bundle r110, ViewModelProvider.Factory r111) {
            if (r111 != null) goto L4;
            r111 = new SavedStateViewModelFactory(this.application, r100, r110);
        L4:
            Set<String> r101 = this.keySet;
            Set<String> r102 = this.assistedKeySet;
            return new HiltViewModelFactory(r100, r110, r101, r102, r111, this.viewModelComponentBuilder);
        }

        @Inject
        public InternalFactoryFactory(Application r100, Set<String> r101, Set<String> r102, ViewModelComponentBuilder r103) {
            this.application = r100;
            this.keySet = r101;
            this.assistedKeySet = r102;
            this.viewModelComponentBuilder = r103;
        }
    }

    private DefaultViewModelFactories() {
    }

    public static <Factory> ViewModelProvider.Factory getActivityAssistedFactory(ComponentActivity r100, ViewModelAssistant<Factory, ? extends ViewModel> r101) {
        if ((r100 instanceof GeneratedComponentManager) == false) goto L7;
        return ((ActivityEntryPoint) EntryPoints.get(r100, ActivityEntryPoint.class)).getHiltInternalFactoryFactory().assistedFromActivity(r100, r101);
    L7:
        throw new IllegalStateException("Expected activity " + r100.getClass().getName() + " is @AndroidEntryPoint-annotated class to use 'hiltAssisted()' extension or 'HiltViewModelFactories.assisted()'");
    }

    public static ViewModelProvider.Factory getActivityFactory(ComponentActivity r100, ViewModelProvider.Factory r101) {
        return ((ActivityEntryPoint) EntryPoints.get(r100, ActivityEntryPoint.class)).getHiltInternalFactoryFactory().fromActivity(r100, r101);
    }

    public static <Factory> ViewModelProvider.Factory getFragmentAssistedFactory(Fragment r100, ViewModelAssistant<Factory, ? extends ViewModel> r101) {
        if ((r100 instanceof GeneratedComponentManager) == false) goto L7;
        return ((FragmentEntryPoint) EntryPoints.get(r100, FragmentEntryPoint.class)).getHiltInternalFactoryFactory().assistedFromFragment(r100, r101);
    L7:
        throw new IllegalStateException("Expected fragment " + r100.getClass().getName() + " is @AndroidEntryPoint-annotated class to use 'hiltAssisted()' extension or 'HiltViewModelFactories.assisted()'");
    }

    public static ViewModelProvider.Factory getFragmentFactory(Fragment r100, ViewModelProvider.Factory r101) {
        return ((FragmentEntryPoint) EntryPoints.get(r100, FragmentEntryPoint.class)).getHiltInternalFactoryFactory().fromFragment(r100, r101);
    }
}
