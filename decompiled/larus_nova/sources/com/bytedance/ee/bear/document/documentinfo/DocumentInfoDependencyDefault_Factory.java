package com.bytedance.ee.bear.document.documentinfo;

import dagger.internal.Factory;
import w05.e;

/* JADX INFO: loaded from: classes16.dex */
public final class DocumentInfoDependencyDefault_Factory implements Factory<e> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DocumentInfoDependencyDefault_Factory f219538a = null;

        static {
            f219538a = new DocumentInfoDependencyDefault_Factory();
        }
    }

    public DocumentInfoDependencyDefault_Factory() {
    }

    public static e newInstance() {
        return new e();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static DocumentInfoDependencyDefault_Factory create() {
        return a.f219538a;
    }

    @Override // javax.inject.Provider
    public e get() {
        return newInstance();
    }
}
