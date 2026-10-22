package com.bytedance.ee.android.file.picker.lib.v2.data;

import dagger.internal.Factory;
import javax.inject.Provider;
import um4.b;

/* JADX INFO: loaded from: classes15.dex */
public final class FilePickerRepository_Factory implements Factory<FilePickerRepository> {
    private final Provider<b> mDataSourceFactoryProvider;

    @Override // javax.inject.Provider
    public FilePickerRepository get() {
        return newInstance(this.mDataSourceFactoryProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FilePickerRepository_Factory(Provider<b> r100) {
        this.mDataSourceFactoryProvider = r100;
    }

    public static FilePickerRepository_Factory create(Provider<b> r100) {
        return new FilePickerRepository_Factory(r100);
    }

    public static FilePickerRepository newInstance(b r100) {
        return new FilePickerRepository(r100);
    }
}
