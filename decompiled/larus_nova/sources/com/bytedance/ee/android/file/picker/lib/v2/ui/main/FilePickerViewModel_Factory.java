package com.bytedance.ee.android.file.picker.lib.v2.ui.main;

import android.app.Application;
import androidx.lifecycle.SavedStateHandle;
import com.bytedance.ee.android.file.picker.lib.v2.data.FilePickerRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes15.dex */
public final class FilePickerViewModel_Factory implements Factory<FilePickerViewModel> {
    private final Provider<Application> mApplicationProvider;
    private final Provider<sm4.b> mCategoryConfigManagerProvider;
    private final Provider<FilePickerRepository> mRepositoryProvider;
    private final Provider<SavedStateHandle> mSavedStateHandleProvider;

    @Override // javax.inject.Provider
    public FilePickerViewModel get() {
        return newInstance(this.mCategoryConfigManagerProvider.get(), this.mRepositoryProvider.get(), this.mApplicationProvider.get(), this.mSavedStateHandleProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FilePickerViewModel_Factory(Provider<sm4.b> r100, Provider<FilePickerRepository> r101, Provider<Application> r102, Provider<SavedStateHandle> r103) {
        this.mCategoryConfigManagerProvider = r100;
        this.mRepositoryProvider = r101;
        this.mApplicationProvider = r102;
        this.mSavedStateHandleProvider = r103;
    }

    public static FilePickerViewModel_Factory create(Provider<sm4.b> r100, Provider<FilePickerRepository> r101, Provider<Application> r102, Provider<SavedStateHandle> r103) {
        return new FilePickerViewModel_Factory(r100, r101, r102, r103);
    }

    public static FilePickerViewModel newInstance(sm4.b r100, FilePickerRepository r101, Application r102, SavedStateHandle r103) {
        return new FilePickerViewModel(r100, r101, r102, r103);
    }
}
