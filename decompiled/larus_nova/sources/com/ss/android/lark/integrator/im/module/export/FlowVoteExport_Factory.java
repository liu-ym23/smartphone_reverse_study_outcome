package com.ss.android.lark.integrator.im.module.export;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowVoteExport_Factory implements Factory<enb.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FlowVoteExport_Factory f428038a = null;

        static {
            f428038a = new FlowVoteExport_Factory();
        }
    }

    public FlowVoteExport_Factory() {
    }

    public static enb.a newInstance() {
        return new enb.a();
    }

    @Override // javax.inject.Provider
    public enb.a get() {
        return newInstance();
    }

    public static FlowVoteExport_Factory create() {
        return a.f428038a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
