package com.bytedance.ee.bear.document.ai.docai;

import dagger.internal.Factory;
import yz4.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfficeCcmDocAIExtensionProvider_Factory implements Factory<c> {

    public static final class a {
        public static final OfficeCcmDocAIExtensionProvider_Factory a = null;

        static {
            a = new OfficeCcmDocAIExtensionProvider_Factory();
        }
    }

    public OfficeCcmDocAIExtensionProvider_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m185get();
    }

    public static OfficeCcmDocAIExtensionProvider_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public c m185get() {
        return newInstance();
    }
}
