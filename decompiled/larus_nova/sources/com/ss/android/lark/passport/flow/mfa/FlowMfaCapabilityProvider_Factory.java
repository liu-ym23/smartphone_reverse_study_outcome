package com.ss.android.lark.passport.flow.mfa;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class FlowMfaCapabilityProvider_Factory implements Factory<d> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FlowMfaCapabilityProvider_Factory f437820a = null;

        static {
            f437820a = new FlowMfaCapabilityProvider_Factory();
        }
    }

    public FlowMfaCapabilityProvider_Factory() {
    }

    public static d newInstance() {
        return new d();
    }

    @Override // javax.inject.Provider
    public d get() {
        return newInstance();
    }

    public static FlowMfaCapabilityProvider_Factory create() {
        return a.f437820a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
