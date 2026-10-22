package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeKnowledgeAIDependencyImpl_Factory implements Factory<y0> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeKnowledgeAIDependencyImpl_Factory f427826a = null;

        static {
            f427826a = new OfficeKnowledgeAIDependencyImpl_Factory();
        }
    }

    public OfficeKnowledgeAIDependencyImpl_Factory() {
    }

    public static y0 newInstance() {
        return new y0();
    }

    @Override // javax.inject.Provider
    public y0 get() {
        return newInstance();
    }

    public static OfficeKnowledgeAIDependencyImpl_Factory create() {
        return a.f427826a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
