package dagger.hilt.android.dwarf.internal.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistryOwner;
import dagger.Module;
import dagger.multibindings.Multibinds;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes41.dex */
public final class DwarfViewModelFactory implements ViewModelProvider.Factory {
    private final ViewModelProvider.Factory delegateFactory;
    private final Set<String> hiltViewModelAssistedKeys;
    private final AbstractSavedStateViewModelFactory hiltViewModelFactory;
    private final Set<String> hiltViewModelKeys;

    public interface ComponentProducer {
        Object produce(SavedStateHandle r100);
    }

    public interface DwarfViewModelCollector {
        Map<String, Object> getDwarfViewModelAssistedMap();

        Map<String, Provider<ViewModel>> getDwarfViewModelMap();
    }

    public interface DwarfViewModelCollectorEntryPoint {
        DwarfViewModelCollector dwarfViewModelCollector();
    }

    public static final class SingletonDwarfViewModelCollector implements DwarfViewModelCollector {
        private final Map<String, Object> assistedFactories;
        private final Map<String, Provider<ViewModel>> factories;

        @Override // dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory.DwarfViewModelCollector
        public Map<String, Object> getDwarfViewModelAssistedMap() {
            return this.assistedFactories;
        }

        @Override // dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory.DwarfViewModelCollector
        public Map<String, Provider<ViewModel>> getDwarfViewModelMap() {
            return this.factories;
        }

        @Inject
        public SingletonDwarfViewModelCollector(Map<String, Provider<ViewModel>> r100, Map<String, Object> r101) {
            this.factories = r100;
            this.assistedFactories = r101;
        }
    }

    public interface SingletonDwarfViewModelCollectorEntryPoint extends DwarfViewModelCollectorEntryPoint {

        /* JADX INFO: renamed from: dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory$SingletonDwarfViewModelCollectorEntryPoint$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static /* bridge */ /* synthetic */ DwarfViewModelCollector $default$dwarfViewModelCollector(SingletonDwarfViewModelCollectorEntryPoint r100) {
                return r100.dwarfViewModelCollector();
            }
        }

        @Override // dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory.DwarfViewModelCollectorEntryPoint
        /* bridge */ /* synthetic */ DwarfViewModelCollector dwarfViewModelCollector();

        @Override // dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory.DwarfViewModelCollectorEntryPoint
        SingletonDwarfViewModelCollector dwarfViewModelCollector();
    }

    @Module
    public interface SingletonModule {
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
        throw new IllegalStateException("Found the @DwarfViewModel-annotated class '" + r100.getName() + "' using @AssistedInject but tried to create with default 'ViewModelProvider.Factory'. Use 'ViewModelProvider.Factory' return from 'dwarfAssisted()' extension or 'DwarfViewModels.assisted()' instead.");
    }

    public DwarfViewModelFactory(final SavedStateRegistryOwner r100, final Bundle r101, Set<String> r102, Set<String> r103, ViewModelProvider.Factory r104, final ComponentProducer r105) {
        this.hiltViewModelKeys = r102;
        this.hiltViewModelAssistedKeys = r103;
        this.delegateFactory = r104;
        this.hiltViewModelFactory = new AnonymousClass1(this, r100, r101, r105);
    }
}
