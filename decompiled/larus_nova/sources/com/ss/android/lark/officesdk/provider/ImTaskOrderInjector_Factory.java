package com.ss.android.lark.officesdk.provider;

import dagger.internal.Factory;
import nwb.c;

/* JADX INFO: loaded from: classes37.dex */
public final class ImTaskOrderInjector_Factory implements Factory<c> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ImTaskOrderInjector_Factory f437146a = null;

        static {
            f437146a = new ImTaskOrderInjector_Factory();
        }
    }

    public ImTaskOrderInjector_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static ImTaskOrderInjector_Factory create() {
        return a.f437146a;
    }

    @Override // javax.inject.Provider
    public c get() {
        return newInstance();
    }
}
