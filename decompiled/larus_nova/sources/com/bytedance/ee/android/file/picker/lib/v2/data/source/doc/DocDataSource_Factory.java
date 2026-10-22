package com.bytedance.ee.android.file.picker.lib.v2.data.source.doc;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes15.dex */
public final class DocDataSource_Factory implements Factory<DocDataSource> {
    private final Provider<Context> mContextProvider;

    @Override // javax.inject.Provider
    public DocDataSource get() {
        return newInstance(this.mContextProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DocDataSource_Factory(Provider<Context> r100) {
        this.mContextProvider = r100;
    }

    public static DocDataSource_Factory create(Provider<Context> r100) {
        return new DocDataSource_Factory(r100);
    }

    public static DocDataSource newInstance(Context r100) {
        return new DocDataSource(r100);
    }
}
