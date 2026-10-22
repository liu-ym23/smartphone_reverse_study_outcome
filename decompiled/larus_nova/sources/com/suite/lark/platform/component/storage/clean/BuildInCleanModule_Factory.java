package com.suite.lark.platform.component.storage.clean;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class BuildInCleanModule_Factory implements Factory<a> {
    private final Provider<Set<l>> eraserProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.eraserProvider);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public BuildInCleanModule_Factory(Provider<Set<l>> r100) {
        this.eraserProvider = r100;
    }

    public static BuildInCleanModule_Factory create(Provider<Set<l>> r100) {
        return new BuildInCleanModule_Factory(r100);
    }

    public static a newInstance(Provider<Set<l>> r100) {
        return new a(r100);
    }
}
