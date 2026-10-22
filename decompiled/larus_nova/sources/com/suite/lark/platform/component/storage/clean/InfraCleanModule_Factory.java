package com.suite.lark.platform.component.storage.clean;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class InfraCleanModule_Factory implements Factory<InfraCleanModule> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final InfraCleanModule_Factory f460598a = null;

        static {
            f460598a = new InfraCleanModule_Factory();
        }
    }

    public InfraCleanModule_Factory() {
    }

    public static InfraCleanModule newInstance() {
        return new InfraCleanModule();
    }

    @Override // javax.inject.Provider
    public InfraCleanModule get() {
        return newInstance();
    }

    public static InfraCleanModule_Factory create() {
        return a.f460598a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
