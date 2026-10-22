package com.bytedance.ee.bear.document.menu.interceptor;

import dagger.internal.Factory;
import z15.c;

/* JADX INFO: loaded from: classes16.dex */
public final class HighPriorityInterceptors_Factory implements Factory<c> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HighPriorityInterceptors_Factory f220253a = null;

        static {
            f220253a = new HighPriorityInterceptors_Factory();
        }
    }

    public HighPriorityInterceptors_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static HighPriorityInterceptors_Factory create() {
        return a.f220253a;
    }

    @Override // javax.inject.Provider
    public c get() {
        return newInstance();
    }
}
