package com.ss.android.lark.chatwindow.launcher.transform;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatterIdBundleTransform_Factory implements Factory<ChatterIdBundleTransform> {
    private final Provider<b> chatLaunchServiceProvider;

    @Override // javax.inject.Provider
    public ChatterIdBundleTransform get() {
        return newInstance(this.chatLaunchServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatterIdBundleTransform_Factory(Provider<b> r100) {
        this.chatLaunchServiceProvider = r100;
    }

    public static ChatterIdBundleTransform_Factory create(Provider<b> r100) {
        return new ChatterIdBundleTransform_Factory(r100);
    }

    public static ChatterIdBundleTransform newInstance(b r100) {
        return new ChatterIdBundleTransform(r100);
    }
}
