package com.ss.android.lark.passport.monitor;

import dagger.internal.Factory;
import zyb.f;

/* JADX INFO: loaded from: classes37.dex */
public final class NoopEnterAppFlowMonitorService_Factory implements Factory<f> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NoopEnterAppFlowMonitorService_Factory f438048a = null;

        static {
            f438048a = new NoopEnterAppFlowMonitorService_Factory();
        }
    }

    public NoopEnterAppFlowMonitorService_Factory() {
    }

    public static f newInstance() {
        return new f();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static NoopEnterAppFlowMonitorService_Factory create() {
        return a.f438048a;
    }

    @Override // javax.inject.Provider
    public f get() {
        return newInstance();
    }
}
