package com.bytedance.ee.android.file.picker.lib.v2.ui.confirm;

import androidx.lifecycle.SavedStateHandle;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes15.dex */
public final class ConfirmViewModel_Factory implements Factory<ConfirmViewModel> {
    private final Provider<SavedStateHandle> mSavedStateHandleProvider;

    @Override // javax.inject.Provider
    public ConfirmViewModel get() {
        return newInstance(this.mSavedStateHandleProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ConfirmViewModel_Factory(Provider<SavedStateHandle> r100) {
        this.mSavedStateHandleProvider = r100;
    }

    public static ConfirmViewModel_Factory create(Provider<SavedStateHandle> r100) {
        return new ConfirmViewModel_Factory(r100);
    }

    public static ConfirmViewModel newInstance(SavedStateHandle r100) {
        return new ConfirmViewModel(r100);
    }
}
