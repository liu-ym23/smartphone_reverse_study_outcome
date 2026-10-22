package com.ss.android.lark.framework.assembly.diskmanage;

import dagger.internal.Factory;
import ebb.f;
import ebb.h;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class DefaultCleanTask_Factory implements Factory<a> {
    private final Provider<Set<f>> cleanFileProvider;
    private final Provider<h> manuDiskCleanTriggerProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.cleanFileProvider, this.manuDiskCleanTriggerProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DefaultCleanTask_Factory(Provider<Set<f>> r100, Provider<h> r101) {
        this.cleanFileProvider = r100;
        this.manuDiskCleanTriggerProvider = r101;
    }

    public static DefaultCleanTask_Factory create(Provider<Set<f>> r100, Provider<h> r101) {
        return new DefaultCleanTask_Factory(r100, r101);
    }

    public static a newInstance(Provider<Set<f>> r100, h r101) {
        return new a(r100, r101);
    }
}
