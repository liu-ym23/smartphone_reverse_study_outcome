package com.bytedance.ee.bear.contract.dependency;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DefaultDocumentCoreDependency_Factory implements Factory<nw4.a> {

    public static final class a {
        public static final DefaultDocumentCoreDependency_Factory a = null;

        static {
            a = new DefaultDocumentCoreDependency_Factory();
        }
    }

    public DefaultDocumentCoreDependency_Factory() {
    }

    public static nw4.a newInstance() {
        return new nw4.a();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m112get();
    }

    public static DefaultDocumentCoreDependency_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public nw4.a m112get() {
        return newInstance();
    }
}
