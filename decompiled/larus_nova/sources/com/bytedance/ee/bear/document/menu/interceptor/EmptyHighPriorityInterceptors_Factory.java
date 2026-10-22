package com.bytedance.ee.bear.document.menu.interceptor;

import dagger.internal.Factory;
import z15.b;

/* JADX INFO: loaded from: classes16.dex */
public final class EmptyHighPriorityInterceptors_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EmptyHighPriorityInterceptors_Factory f220252a = null;

        static {
            f220252a = new EmptyHighPriorityInterceptors_Factory();
        }
    }

    public EmptyHighPriorityInterceptors_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static EmptyHighPriorityInterceptors_Factory create() {
        return a.f220252a;
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }
}
