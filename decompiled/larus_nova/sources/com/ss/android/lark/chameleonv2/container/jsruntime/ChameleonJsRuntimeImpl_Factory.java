package com.ss.android.lark.chameleonv2.container.jsruntime;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes35.dex */
public final class ChameleonJsRuntimeImpl_Factory implements Factory<m0b.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ChameleonJsRuntimeImpl_Factory f411117a = null;

        static {
            f411117a = new ChameleonJsRuntimeImpl_Factory();
        }
    }

    public ChameleonJsRuntimeImpl_Factory() {
    }

    public static m0b.a newInstance() {
        return new m0b.a();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static ChameleonJsRuntimeImpl_Factory create() {
        return a.f411117a;
    }

    @Override // javax.inject.Provider
    public m0b.a get() {
        return newInstance();
    }
}
