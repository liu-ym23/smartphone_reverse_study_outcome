package com.suite.lark.platform.component.storage.clean;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class EmptyFileEraserProvider_Factory implements Factory<g> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EmptyFileEraserProvider_Factory f460597a = null;

        static {
            f460597a = new EmptyFileEraserProvider_Factory();
        }
    }

    public EmptyFileEraserProvider_Factory() {
    }

    public static g newInstance() {
        return new g();
    }

    @Override // javax.inject.Provider
    public g get() {
        return newInstance();
    }

    public static EmptyFileEraserProvider_Factory create() {
        return a.f460597a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
