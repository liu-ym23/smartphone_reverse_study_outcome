package com.ss.android.lark.app.initiator.perf;

import dagger.internal.Factory;
import eva.b;

/* JADX INFO: loaded from: classes34.dex */
public final class NoopPerfDispatcher_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NoopPerfDispatcher_Factory f408747a = null;

        static {
            f408747a = new NoopPerfDispatcher_Factory();
        }
    }

    public NoopPerfDispatcher_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }

    public static NoopPerfDispatcher_Factory create() {
        return a.f408747a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
