package com.ss.android.lark.integrator.im.extension;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class ExtensionDependencyImpl_Factory implements Factory<com.ss.android.lark.integrator.im.extension.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ExtensionDependencyImpl_Factory f427931a = null;

        static {
            f427931a = new ExtensionDependencyImpl_Factory();
        }
    }

    public ExtensionDependencyImpl_Factory() {
    }

    public static com.ss.android.lark.integrator.im.extension.a newInstance() {
        return new com.ss.android.lark.integrator.im.extension.a();
    }

    @Override // javax.inject.Provider
    public com.ss.android.lark.integrator.im.extension.a get() {
        return newInstance();
    }

    public static ExtensionDependencyImpl_Factory create() {
        return a.f427931a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
