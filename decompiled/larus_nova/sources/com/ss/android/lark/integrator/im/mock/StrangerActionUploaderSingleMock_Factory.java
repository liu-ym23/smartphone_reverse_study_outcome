package com.ss.android.lark.integrator.im.mock;

import dagger.internal.Factory;
import dnb.c;

/* JADX INFO: loaded from: classes36.dex */
public final class StrangerActionUploaderSingleMock_Factory implements Factory<c> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final StrangerActionUploaderSingleMock_Factory f428036a = null;

        static {
            f428036a = new StrangerActionUploaderSingleMock_Factory();
        }
    }

    public StrangerActionUploaderSingleMock_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    @Override // javax.inject.Provider
    public c get() {
        return newInstance();
    }

    public static StrangerActionUploaderSingleMock_Factory create() {
        return a.f428036a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
