package com.ss.android.lark.screenprotect;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class ScreenshotProtectionModule_Factory implements Factory<ScreenshotProtectionModule> {
    private final Provider<a> dependencyProvider;

    public static ScreenshotProtectionModule newInstance() {
        return new ScreenshotProtectionModule();
    }

    @Override // javax.inject.Provider
    public ScreenshotProtectionModule get() {
        ScreenshotProtectionModule r100 = newInstance();
        r100.f439775a = this.dependencyProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ScreenshotProtectionModule_Factory(Provider<a> r100) {
        this.dependencyProvider = r100;
    }

    public static ScreenshotProtectionModule_Factory create(Provider<a> r100) {
        return new ScreenshotProtectionModule_Factory(r100);
    }
}
