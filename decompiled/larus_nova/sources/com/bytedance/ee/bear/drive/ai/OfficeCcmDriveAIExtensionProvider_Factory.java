package com.bytedance.ee.bear.drive.ai;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes16.dex */
public final class OfficeCcmDriveAIExtensionProvider_Factory implements Factory<x45.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeCcmDriveAIExtensionProvider_Factory f222581a = null;

        static {
            f222581a = new OfficeCcmDriveAIExtensionProvider_Factory();
        }
    }

    public OfficeCcmDriveAIExtensionProvider_Factory() {
    }

    public static x45.a newInstance() {
        return new x45.a();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static OfficeCcmDriveAIExtensionProvider_Factory create() {
        return a.f222581a;
    }

    @Override // javax.inject.Provider
    public x45.a get() {
        return newInstance();
    }
}
