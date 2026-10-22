package com.bytedance.ee.bear.document.ai.docai;

import dagger.internal.Factory;
import yz4.c;

/* JADX INFO: loaded from: classes16.dex */
public final class OfficeCcmDocAIExtensionProvider_Factory implements Factory<c> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeCcmDocAIExtensionProvider_Factory f218801a = null;

        static {
            f218801a = new OfficeCcmDocAIExtensionProvider_Factory();
        }
    }

    public OfficeCcmDocAIExtensionProvider_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static OfficeCcmDocAIExtensionProvider_Factory create() {
        return a.f218801a;
    }

    @Override // javax.inject.Provider
    public c get() {
        return newInstance();
    }
}
