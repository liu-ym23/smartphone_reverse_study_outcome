package com.bytedance.ee.android.file.picker.lib.v2.icon.impl;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import wm4.a;

/* JADX INFO: loaded from: classes15.dex */
public final class ApkIconLoader_Factory implements Factory<a> {
    private final Provider<Context> mContextProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.mContextProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ApkIconLoader_Factory(Provider<Context> r100) {
        this.mContextProvider = r100;
    }

    public static ApkIconLoader_Factory create(Provider<Context> r100) {
        return new ApkIconLoader_Factory(r100);
    }

    public static a newInstance(Context r100) {
        return new a(r100);
    }
}
