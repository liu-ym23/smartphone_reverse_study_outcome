package com.ss.android.lark.flow.chat.mediapreview;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowPreviewImageService_Factory implements Factory<c> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FlowPreviewImageService_Factory f422219a = null;

        static {
            f422219a = new FlowPreviewImageService_Factory();
        }
    }

    public FlowPreviewImageService_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    @Override // javax.inject.Provider
    public c get() {
        return newInstance();
    }

    public static FlowPreviewImageService_Factory create() {
        return a.f422219a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
