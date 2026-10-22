package com.ss.android.lark.passport.flow.mfa;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class FlowMfaFlowRegistry_Factory implements Factory<h> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FlowMfaFlowRegistry_Factory f437827a = null;

        static {
            f437827a = new FlowMfaFlowRegistry_Factory();
        }
    }

    public FlowMfaFlowRegistry_Factory() {
    }

    public static h newInstance() {
        return new h();
    }

    @Override // javax.inject.Provider
    public h get() {
        return newInstance();
    }

    public static FlowMfaFlowRegistry_Factory create() {
        return a.f437827a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
