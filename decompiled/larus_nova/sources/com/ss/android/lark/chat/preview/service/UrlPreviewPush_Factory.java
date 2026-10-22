package com.ss.android.lark.chat.preview.service;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes35.dex */
public final class UrlPreviewPush_Factory implements Factory<d> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final UrlPreviewPush_Factory f416301a = null;

        static {
            f416301a = new UrlPreviewPush_Factory();
        }
    }

    public UrlPreviewPush_Factory() {
    }

    public static d newInstance() {
        return new d();
    }

    @Override // javax.inject.Provider
    public d get() {
        return newInstance();
    }

    public static UrlPreviewPush_Factory create() {
        return a.f416301a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
