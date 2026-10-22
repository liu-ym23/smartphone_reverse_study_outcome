package com.ss.android.lark.passport.monitor;

import dagger.internal.Factory;
import zyb.g;

/* JADX INFO: loaded from: classes37.dex */
public final class NoopSwitchMonitorService_Factory implements Factory<g> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NoopSwitchMonitorService_Factory f438049a = null;

        static {
            f438049a = new NoopSwitchMonitorService_Factory();
        }
    }

    public NoopSwitchMonitorService_Factory() {
    }

    public static g newInstance() {
        return new g();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static NoopSwitchMonitorService_Factory create() {
        return a.f438049a;
    }

    @Override // javax.inject.Provider
    public g get() {
        return newInstance();
    }
}
