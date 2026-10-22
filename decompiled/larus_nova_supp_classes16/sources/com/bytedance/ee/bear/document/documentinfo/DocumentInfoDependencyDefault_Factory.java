package com.bytedance.ee.bear.document.documentinfo;

import dagger.internal.Factory;
import w05.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DocumentInfoDependencyDefault_Factory implements Factory<e> {

    public static final class a {
        public static final DocumentInfoDependencyDefault_Factory a = null;

        static {
            a = new DocumentInfoDependencyDefault_Factory();
        }
    }

    public DocumentInfoDependencyDefault_Factory() {
    }

    public static e newInstance() {
        return new e();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m208get();
    }

    public static DocumentInfoDependencyDefault_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public e m208get() {
        return newInstance();
    }
}
