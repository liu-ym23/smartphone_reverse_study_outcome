package com.ss.android.lark.integrator.im.mock;

import dagger.internal.Factory;
import dnb.b;

/* JADX INFO: loaded from: classes36.dex */
public final class StrangerActionUploaderMock_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final StrangerActionUploaderMock_Factory f428035a = null;

        static {
            f428035a = new StrangerActionUploaderMock_Factory();
        }
    }

    public StrangerActionUploaderMock_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }

    public static StrangerActionUploaderMock_Factory create() {
        return a.f428035a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
