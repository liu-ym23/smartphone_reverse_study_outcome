package com.bytedance.ee.bear.document.menu.interceptor;

import dagger.internal.Factory;
import z15.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class HighPriorityInterceptors_Factory implements Factory<c> {

    public static final class a {
        public static final HighPriorityInterceptors_Factory a = null;

        static {
            a = new HighPriorityInterceptors_Factory();
        }
    }

    public HighPriorityInterceptors_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m220get();
    }

    public static HighPriorityInterceptors_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public c m220get() {
        return newInstance();
    }
}
