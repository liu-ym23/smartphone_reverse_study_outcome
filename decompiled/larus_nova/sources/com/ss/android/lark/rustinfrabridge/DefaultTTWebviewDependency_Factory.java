package com.ss.android.lark.rustinfrabridge;

import c3c.c;
import dagger.internal.Factory;

/* JADX INFO: loaded from: classes38.dex */
public final class DefaultTTWebviewDependency_Factory implements Factory<c> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DefaultTTWebviewDependency_Factory f439679a = null;

        static {
            f439679a = new DefaultTTWebviewDependency_Factory();
        }
    }

    public DefaultTTWebviewDependency_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    @Override // javax.inject.Provider
    public c get() {
        return newInstance();
    }

    public static DefaultTTWebviewDependency_Factory create() {
        return a.f439679a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
