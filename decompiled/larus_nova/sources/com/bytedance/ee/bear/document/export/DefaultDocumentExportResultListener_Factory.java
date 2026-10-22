package com.bytedance.ee.bear.document.export;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes16.dex */
public final class DefaultDocumentExportResultListener_Factory implements Factory<g15.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DefaultDocumentExportResultListener_Factory f219686a = null;

        static {
            f219686a = new DefaultDocumentExportResultListener_Factory();
        }
    }

    public DefaultDocumentExportResultListener_Factory() {
    }

    public static g15.a newInstance() {
        return new g15.a();
    }

    @Override // javax.inject.Provider
    public g15.a get() {
        return newInstance();
    }

    public static DefaultDocumentExportResultListener_Factory create() {
        return a.f219686a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
