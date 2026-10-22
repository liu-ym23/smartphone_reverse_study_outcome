package com.bytedance.ee.bear.document.knowledgeai;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes16.dex */
public final class OfficeDocsKnowledgeAIProvider_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeDocsKnowledgeAIProvider_Factory f220148a = null;

        static {
            f220148a = new OfficeDocsKnowledgeAIProvider_Factory();
        }
    }

    public OfficeDocsKnowledgeAIProvider_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }

    public static OfficeDocsKnowledgeAIProvider_Factory create() {
        return a.f220148a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
