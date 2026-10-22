package dagger.hilt.android.internal.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.SavedStateRegistryOwner;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.lifecycle.ViewModelAssistant;

/* JADX INFO: loaded from: classes41.dex */
public class HiltViewModelAssistedFactory<Factory> extends AbstractSavedStateViewModelFactory {
    private final ViewModelAssistant<Factory, ? extends ViewModel> assistant;
    private final ViewModelComponentBuilder viewModelComponentBuilder;

    @Override // androidx.lifecycle.AbstractSavedStateViewModelFactory
    public <T extends ViewModel> T create(String r100, Class<T> r101, SavedStateHandle r102) {
        HiltViewModelFactory.ViewModelFactoriesEntryPoint r103 = (HiltViewModelFactory.ViewModelFactoriesEntryPoint) EntryPoints.get(this.viewModelComponentBuilder.savedStateHandle(r102).build(), HiltViewModelFactory.ViewModelFactoriesEntryPoint.class);
        Object r104 = r103.getHiltViewModelAssistedMap().get(r101.getName());
        if (r104 != null) goto L11;
        if (r103.getHiltViewModelMap().containsKey(r101.getName()) == false) goto L9;
        throw new IllegalStateException("Found creation with assisted factory but class '" + r101.getName() + "' does not have an assisted factory specified in @HiltViewModel.");
    L9:
        throw new IllegalStateException("Found creation with hilt assisted factory but class '" + r101.getName() + "' does not annotated with @HiltViewModel.");
    L11:
        return (T) this.assistant.assist((Factory) r104);
    }

    public HiltViewModelAssistedFactory(SavedStateRegistryOwner r100, Bundle r101, ViewModelComponentBuilder r102, ViewModelAssistant<Factory, ? extends ViewModel> r103) {
        super(r100, r101);
        this.viewModelComponentBuilder = r102;
        this.assistant = r103;
    }
}
