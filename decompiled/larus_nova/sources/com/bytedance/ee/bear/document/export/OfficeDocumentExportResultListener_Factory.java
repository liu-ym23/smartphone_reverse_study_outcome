package com.bytedance.ee.bear.document.export;

import dagger.internal.Factory;
import g15.x;

/* JADX INFO: loaded from: classes16.dex */
public final class OfficeDocumentExportResultListener_Factory implements Factory<x> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeDocumentExportResultListener_Factory f219687a = null;

        static {
            f219687a = new OfficeDocumentExportResultListener_Factory();
        }
    }

    public OfficeDocumentExportResultListener_Factory() {
    }

    public static x newInstance() {
        return new x();
    }

    @Override // javax.inject.Provider
    public x get() {
        return newInstance();
    }

    public static OfficeDocumentExportResultListener_Factory create() {
        return a.f219687a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
