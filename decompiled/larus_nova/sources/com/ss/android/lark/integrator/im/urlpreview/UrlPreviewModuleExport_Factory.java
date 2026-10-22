package com.ss.android.lark.integrator.im.urlpreview;

import com.ss.android.lark.chat.preview.service.d;
import com.ss.android.lark.chat.preview.service.impl.UrlPreviewService;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import fnb.a;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class UrlPreviewModuleExport_Factory implements Factory<a> {
    private final Provider<d> lazeUrlPreviewPushProvider;
    private final Provider<UrlPreviewService> lazeUrlPreviewServiceProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(DoubleCheck.lazy(this.lazeUrlPreviewServiceProvider), DoubleCheck.lazy(this.lazeUrlPreviewPushProvider));
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UrlPreviewModuleExport_Factory(Provider<UrlPreviewService> r100, Provider<d> r101) {
        this.lazeUrlPreviewServiceProvider = r100;
        this.lazeUrlPreviewPushProvider = r101;
    }

    public static UrlPreviewModuleExport_Factory create(Provider<UrlPreviewService> r100, Provider<d> r101) {
        return new UrlPreviewModuleExport_Factory(r100, r101);
    }

    public static a newInstance(Lazy<UrlPreviewService> r100, Lazy<d> r101) {
        return new a(r100, r101);
    }
}
