package com.ss.android.lark.chat.preview.service.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes35.dex */
public final class UrlPreviewService_Factory implements Factory<UrlPreviewService> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final UrlPreviewService_Factory f416311a = null;

        static {
            f416311a = new UrlPreviewService_Factory();
        }
    }

    public UrlPreviewService_Factory() {
    }

    public static UrlPreviewService newInstance() {
        return new UrlPreviewService();
    }

    @Override // javax.inject.Provider
    public UrlPreviewService get() {
        return newInstance();
    }

    public static UrlPreviewService_Factory create() {
        return a.f416311a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
