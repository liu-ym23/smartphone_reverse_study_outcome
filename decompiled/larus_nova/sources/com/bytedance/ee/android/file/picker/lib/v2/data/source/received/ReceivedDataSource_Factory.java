package com.bytedance.ee.android.file.picker.lib.v2.data.source.received;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes15.dex */
public final class ReceivedDataSource_Factory implements Factory<a> {
    private final Provider<Context> contextProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.contextProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ReceivedDataSource_Factory(Provider<Context> r100) {
        this.contextProvider = r100;
    }

    public static ReceivedDataSource_Factory create(Provider<Context> r100) {
        return new ReceivedDataSource_Factory(r100);
    }

    public static a newInstance(Context r100) {
        return new a(r100);
    }
}
