package com.ss.android.lark.officesdk;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class ImOfficeLoadTaskInjector_Factory implements Factory<ImOfficeLoadTaskInjector> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ImOfficeLoadTaskInjector_Factory f433089a = null;

        static {
            f433089a = new ImOfficeLoadTaskInjector_Factory();
        }
    }

    public ImOfficeLoadTaskInjector_Factory() {
    }

    public static ImOfficeLoadTaskInjector newInstance() {
        return new ImOfficeLoadTaskInjector();
    }

    @Override // javax.inject.Provider
    public ImOfficeLoadTaskInjector get() {
        return newInstance();
    }

    public static ImOfficeLoadTaskInjector_Factory create() {
        return a.f433089a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
