package com.bytedance.ee.bear.document.knowledgeai;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfficeDocsKnowledgeAIProvider_Factory implements Factory<b> {

    public static final class a {
        public static final OfficeDocsKnowledgeAIProvider_Factory a = null;

        static {
            a = new OfficeDocsKnowledgeAIProvider_Factory();
        }
    }

    public OfficeDocsKnowledgeAIProvider_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    public b get() {
        return newInstance();
    }

    public static OfficeDocsKnowledgeAIProvider_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m211get() {
        return get();
    }
}
