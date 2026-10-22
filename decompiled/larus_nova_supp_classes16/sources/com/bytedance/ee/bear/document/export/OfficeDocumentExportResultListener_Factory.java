package com.bytedance.ee.bear.document.export;

import dagger.internal.Factory;
import g15.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfficeDocumentExportResultListener_Factory implements Factory<x> {

    public static final class a {
        public static final OfficeDocumentExportResultListener_Factory a = null;

        static {
            a = new OfficeDocumentExportResultListener_Factory();
        }
    }

    public OfficeDocumentExportResultListener_Factory() {
    }

    public static x newInstance() {
        return new x();
    }

    public x get() {
        return newInstance();
    }

    public static OfficeDocumentExportResultListener_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m210get() {
        return get();
    }
}
