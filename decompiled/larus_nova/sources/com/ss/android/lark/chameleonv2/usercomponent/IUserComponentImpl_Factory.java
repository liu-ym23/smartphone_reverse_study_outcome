package com.ss.android.lark.chameleonv2.usercomponent;

import dagger.internal.Factory;
import v1b.b;

/* JADX INFO: loaded from: classes35.dex */
public final class IUserComponentImpl_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final IUserComponentImpl_Factory f411522a = null;

        static {
            f411522a = new IUserComponentImpl_Factory();
        }
    }

    public IUserComponentImpl_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static IUserComponentImpl_Factory create() {
        return a.f411522a;
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }
}
