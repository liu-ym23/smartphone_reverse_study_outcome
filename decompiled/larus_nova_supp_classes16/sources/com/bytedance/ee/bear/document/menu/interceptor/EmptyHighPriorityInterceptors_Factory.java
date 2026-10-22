package com.bytedance.ee.bear.document.menu.interceptor;

import dagger.internal.Factory;
import z15.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class EmptyHighPriorityInterceptors_Factory implements Factory<b> {

    public static final class a {
        public static final EmptyHighPriorityInterceptors_Factory a = null;

        static {
            a = new EmptyHighPriorityInterceptors_Factory();
        }
    }

    public EmptyHighPriorityInterceptors_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m219get();
    }

    public static EmptyHighPriorityInterceptors_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public b m219get() {
        return newInstance();
    }
}
