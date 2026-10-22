package com.bytedance.ee.bear.document.export;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DefaultDocumentExportResultListener_Factory implements Factory<g15.a> {

    public static final class a {
        public static final DefaultDocumentExportResultListener_Factory a = null;

        static {
            a = new DefaultDocumentExportResultListener_Factory();
        }
    }

    public DefaultDocumentExportResultListener_Factory() {
    }

    public static g15.a newInstance() {
        return new g15.a();
    }

    public g15.a get() {
        return newInstance();
    }

    public static DefaultDocumentExportResultListener_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m209get() {
        return get();
    }
}
