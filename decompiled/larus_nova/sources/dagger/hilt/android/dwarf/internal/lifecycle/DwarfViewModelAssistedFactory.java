package dagger.hilt.android.dwarf.internal.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.SavedStateRegistryOwner;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.dwarf.lifecycle.SavedStateHandleReceiver;
import dagger.hilt.android.lifecycle.ViewModelAssistant;

/* JADX INFO: loaded from: classes41.dex */
public class DwarfViewModelAssistedFactory<Factory> extends AbstractSavedStateViewModelFactory {
    private final ViewModelAssistant<Factory, ? extends ViewModel> assistant;
    private final DwarfViewModelFactory.ComponentProducer componentProducer;

    @Override // androidx.lifecycle.AbstractSavedStateViewModelFactory
    public <T extends ViewModel> T create(String r100, Class<T> r101, SavedStateHandle r102) {
        Object r103 = this.componentProducer.produce(r102);
        DwarfViewModelFactory.DwarfViewModelCollector r104 = ((DwarfViewModelFactory.DwarfViewModelCollectorEntryPoint) EntryPoints.get(r103, DwarfViewModelFactory.DwarfViewModelCollectorEntryPoint.class)).dwarfViewModelCollector();
        Object r105 = r104.getDwarfViewModelAssistedMap().get(r101.getName());
        if (r105 == null) goto L5;
        T r106 = (T) this.assistant.assist((Factory) r105);
        if ((r106 instanceof SavedStateHandleReceiver) == false) goto L13;
        ((SavedStateHandleReceiver) r106).receive(r102);
    L13:
        return r106;
    L5:
        if (r104.getDwarfViewModelMap().containsKey(r101.getName()) == false) goto L9;
        throw new IllegalStateException("Found creation with assisted factory but class '" + r101.getName() + "' does not have an assisted factory specified in @DwarfViewModel.");
    L9:
        throw new IllegalStateException("Found creation with dwarf assisted factory but class '" + r101.getName() + "' does not annotated with @DwarfViewModel or the viewModel is not contribute to component '" + r103.getClass().getName() + "'");
    }

    public DwarfViewModelAssistedFactory(SavedStateRegistryOwner r100, Bundle r101, DwarfViewModelFactory.ComponentProducer r102, ViewModelAssistant<Factory, ? extends ViewModel> r103) {
        super(r100, r101);
        this.componentProducer = r102;
        this.assistant = r103;
    }
}
