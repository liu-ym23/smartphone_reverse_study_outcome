package com.ss.android.lark.integrator.im.impl.preview;

import com.ss.android.lark.chat.preview.service.impl.UrlPreviewService;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeUrlPreviewService_Factory implements Factory<b> {
    private final Provider<com.ss.android.lark.chat.preview.service.d> urlPreviewPushProvider;
    private final Provider<UrlPreviewService> urlPreviewServiceProvider;

    @Override // javax.inject.Provider
    public b get() {
        return newInstance(DoubleCheck.lazy(this.urlPreviewServiceProvider), DoubleCheck.lazy(this.urlPreviewPushProvider));
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeUrlPreviewService_Factory(Provider<UrlPreviewService> r100, Provider<com.ss.android.lark.chat.preview.service.d> r101) {
        this.urlPreviewServiceProvider = r100;
        this.urlPreviewPushProvider = r101;
    }

    public static OfficeUrlPreviewService_Factory create(Provider<UrlPreviewService> r100, Provider<com.ss.android.lark.chat.preview.service.d> r101) {
        return new OfficeUrlPreviewService_Factory(r100, r101);
    }

    public static b newInstance(Lazy<UrlPreviewService> r100, Lazy<com.ss.android.lark.chat.preview.service.d> r101) {
        return new b(r100, r101);
    }
}
