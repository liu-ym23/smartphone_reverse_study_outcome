package com.ss.android.lark.framework.assembly.diskmanage;

import dagger.internal.Factory;
import ebb.g;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class DiskCleanTaskCollector_Factory implements Factory<b> {
    private final Provider<Set<g>> cleanTasksProvider;

    @Override // javax.inject.Provider
    public b get() {
        return newInstance(this.cleanTasksProvider);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DiskCleanTaskCollector_Factory(Provider<Set<g>> r100) {
        this.cleanTasksProvider = r100;
    }

    public static DiskCleanTaskCollector_Factory create(Provider<Set<g>> r100) {
        return new DiskCleanTaskCollector_Factory(r100);
    }

    public static b newInstance(Provider<Set<g>> r100) {
        return new b(r100);
    }
}
