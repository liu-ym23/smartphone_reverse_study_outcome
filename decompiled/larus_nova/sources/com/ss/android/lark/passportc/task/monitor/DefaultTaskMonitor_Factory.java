package com.ss.android.lark.passportc.task.monitor;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class DefaultTaskMonitor_Factory implements Factory<l0c.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DefaultTaskMonitor_Factory f438530a = null;

        static {
            f438530a = new DefaultTaskMonitor_Factory();
        }
    }

    public DefaultTaskMonitor_Factory() {
    }

    public static l0c.a newInstance() {
        return new l0c.a();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static DefaultTaskMonitor_Factory create() {
        return a.f438530a;
    }

    @Override // javax.inject.Provider
    public l0c.a get() {
        return newInstance();
    }
}
