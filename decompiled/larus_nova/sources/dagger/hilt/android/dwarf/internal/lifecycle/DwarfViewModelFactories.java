package dagger.hilt.android.dwarf.internal.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistryOwner;
import dagger.Module;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.lifecycle.ViewModelAssistant;
import dagger.multibindings.Multibinds;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes41.dex */
public class DwarfViewModelFactories {

    public static final class DwarfInternalFactoryFactory {
        private final Application application;
        private final Set<String> assistedKeySet;
        private final Set<String> keySet;

        public static /* synthetic */ Object a(Object r100, SavedStateHandle r101) {
            return lambda$getDwarfViewModelAssistedFactory$1(r100, r101);
        }

        public static /* synthetic */ Object b(Object r100, SavedStateHandle r101) {
            return lambda$getHiltViewModelFactory$0(r100, r101);
        }

        private static /* synthetic */ Object lambda$getDwarfViewModelAssistedFactory$1(Object r100, SavedStateHandle r101) {
            return r100;
        }

        private static /* synthetic */ Object lambda$getHiltViewModelFactory$0(Object r100, SavedStateHandle r101) {
            return r100;
        }

        @Inject
        public DwarfInternalFactoryFactory(Application r100, Set<String> r101, Set<String> r102) {
            this.application = r100;
            this.keySet = r101;
            this.assistedKeySet = r102;
        }

        public <Factory> ViewModelProvider.Factory assistedFromActivity(ComponentActivity r100, Object r101, ViewModelAssistant<Factory, ? extends ViewModel> r102) {
            if (r100.getIntent() == null) goto L5;
            Bundle r103 = r100.getIntent().getExtras();
        L7:
            return getDwarfViewModelAssistedFactory(r100, r103, r101, r102);
        L5:
            r103 = null;
            goto L7
        }

        public <Factory> ViewModelProvider.Factory assistedFromFragment(Fragment r100, Object r101, ViewModelAssistant<Factory, ? extends ViewModel> r102) {
            return getDwarfViewModelAssistedFactory(r100, r100.getArguments(), r101, r102);
        }

        public ViewModelProvider.Factory fromActivity(ComponentActivity r100, ViewModelProvider.Factory r101, Object r102) {
            if (r100.getIntent() == null) goto L5;
            Bundle r103 = r100.getIntent().getExtras();
        L7:
            return getHiltViewModelFactory(r100, r103, r101, r102);
        L5:
            r103 = null;
            goto L7
        }

        public ViewModelProvider.Factory fromFragment(Fragment r100, ViewModelProvider.Factory r101, Object r102) {
            return getHiltViewModelFactory(r100, r100.getArguments(), r101, r102);
        }

        private <Factory> ViewModelProvider.Factory getDwarfViewModelAssistedFactory(SavedStateRegistryOwner r100, Bundle r101, final Object r102, ViewModelAssistant<Factory, ? extends ViewModel> r103) {
            return new DwarfViewModelAssistedFactory(r100, r101, new a(r102), r103);
        }

        private ViewModelProvider.Factory getHiltViewModelFactory(SavedStateRegistryOwner r100, Bundle r110, ViewModelProvider.Factory r111, final Object r112) {
            if (r111 != null) goto L4;
            r111 = new SavedStateViewModelFactory(this.application, r100, r110);
        L4:
            Set<String> r101 = this.keySet;
            Set<String> r102 = this.assistedKeySet;
            return new DwarfViewModelFactory(r100, r110, r101, r102, r111, new b(r112));
        }
    }

    public interface FactoryFactoryCollector {
        DwarfInternalFactoryFactory getDwarfInternalFactoryFactory();
    }

    public interface FactoryFactoryEntryPoint {
        FactoryFactoryCollector factoryFactoryCollector();
    }

    public interface SingletonEntryPoint extends FactoryFactoryEntryPoint {

        /* JADX INFO: renamed from: dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories$SingletonEntryPoint$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static /* bridge */ /* synthetic */ FactoryFactoryCollector $default$factoryFactoryCollector(SingletonEntryPoint r100) {
                return r100.factoryFactoryCollector();
            }
        }

        @Override // dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories.FactoryFactoryEntryPoint
        /* bridge */ /* synthetic */ FactoryFactoryCollector factoryFactoryCollector();

        @Override // dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories.FactoryFactoryEntryPoint
        SingletonFactoryFactoryCollector factoryFactoryCollector();
    }

    public static final class SingletonFactoryFactoryCollector implements FactoryFactoryCollector {
        private Provider<DwarfInternalFactoryFactory> factory;

        @Override // dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories.FactoryFactoryCollector
        public DwarfInternalFactoryFactory getDwarfInternalFactoryFactory() {
            return this.factory.get();
        }

        @Inject
        public SingletonFactoryFactoryCollector(Provider<DwarfInternalFactoryFactory> r100) {
            this.factory = r100;
        }
    }

    @Module
    public interface SingletonModule {
        @Multibinds
        Set<String> viewModelAssistedKeys();

        @Multibinds
        Set<String> viewModelKeys();
    }

    private DwarfViewModelFactories() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <Factory> ViewModelProvider.Factory getActivityAssistedFactory(ComponentActivity r100, ViewModelAssistant<Factory, ? extends ViewModel> r101) {
        if ((r100 instanceof DwarfComponentProvider) == false) goto L11;
        Object r102 = ((DwarfComponentProvider) r100).provideComponent();
        if ((r102 instanceof FactoryFactoryEntryPoint) == false) goto L9;
        return ((FactoryFactoryEntryPoint) EntryPoints.get(r102, FactoryFactoryEntryPoint.class)).factoryFactoryCollector().getDwarfInternalFactoryFactory().assistedFromActivity(r100, r102, r101);
    L9:
        throw new IllegalStateException("The component " + r102.getClass().getName() + " binds to @DwarfInjectPoint-annotated activity " + r100.getClass().getName() + " doesn't support ViewModel. 'dwarfAssisted()' extension or 'DwarfViewModels.assisted()' can't be used under the component. Need to annotate @SupportViewModel on the component's definition.");
    L11:
        throw new IllegalStateException("Expected activity " + r100.getClass().getName() + " is @DwarfInjectPoint-annotated class to use 'dwarfAssisted()' extension or 'DwarfViewModels.assisted()'");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <Factory> ViewModelProvider.Factory getFragmentAssistedFactory(Fragment r100, ViewModelAssistant<Factory, ? extends ViewModel> r101) {
        if ((r100 instanceof DwarfComponentProvider) == false) goto L11;
        Object r102 = ((DwarfComponentProvider) r100).provideComponent();
        if ((r102 instanceof FactoryFactoryEntryPoint) == false) goto L9;
        return ((FactoryFactoryEntryPoint) EntryPoints.get(r102, FactoryFactoryEntryPoint.class)).factoryFactoryCollector().getDwarfInternalFactoryFactory().assistedFromFragment(r100, r102, r101);
    L9:
        throw new IllegalStateException("The component " + r102.getClass().getName() + " binds to @DwarfInjectPoint-annotated fragment " + r100.getClass().getName() + " doesn't support ViewModel. 'dwarfAssisted()' extension or 'DwarfViewModels.assisted()' can't be used under the component. Need to annotate @SupportViewModel on the component's definition.");
    L11:
        throw new IllegalStateException("Expected fragment " + r100.getClass().getName() + " is @DwarfInjectPoint-annotated class to use 'dwarfAssisted()' extension or 'DwarfViewModels.assisted()'");
    }

    public static ViewModelProvider.Factory getActivityFactory(ComponentActivity r100, ViewModelProvider.Factory r101, Object r102) {
        return ((FactoryFactoryEntryPoint) EntryPoints.get(r102, FactoryFactoryEntryPoint.class)).factoryFactoryCollector().getDwarfInternalFactoryFactory().fromActivity(r100, r101, r102);
    }

    public static ViewModelProvider.Factory getFragmentFactory(Fragment r100, ViewModelProvider.Factory r101, Object r102) {
        return ((FactoryFactoryEntryPoint) EntryPoints.get(r102, FactoryFactoryEntryPoint.class)).factoryFactoryCollector().getDwarfInternalFactoryFactory().fromFragment(r100, r101, r102);
    }
}
