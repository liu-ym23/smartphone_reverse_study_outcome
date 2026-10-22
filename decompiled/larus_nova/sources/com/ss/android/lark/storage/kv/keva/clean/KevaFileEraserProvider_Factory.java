package com.ss.android.lark.storage.kv.keva.clean;

import dagger.internal.Factory;
import k6c.b;

/* JADX INFO: loaded from: classes38.dex */
public final class KevaFileEraserProvider_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final KevaFileEraserProvider_Factory f441054a = null;

        static {
            f441054a = new KevaFileEraserProvider_Factory();
        }
    }

    public KevaFileEraserProvider_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static KevaFileEraserProvider_Factory create() {
        return a.f441054a;
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }
}
