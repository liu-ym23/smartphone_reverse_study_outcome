package com.ss.android.lark.integrator.im.module.export;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowGroupCreateExport_Factory implements Factory<FlowGroupCreateExport> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FlowGroupCreateExport_Factory f428037a = null;

        static {
            f428037a = new FlowGroupCreateExport_Factory();
        }
    }

    public FlowGroupCreateExport_Factory() {
    }

    public static FlowGroupCreateExport newInstance() {
        return new FlowGroupCreateExport();
    }

    @Override // javax.inject.Provider
    public FlowGroupCreateExport get() {
        return newInstance();
    }

    public static FlowGroupCreateExport_Factory create() {
        return a.f428037a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
