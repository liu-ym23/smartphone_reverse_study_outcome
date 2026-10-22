package com.ss.android.lark.integrator.im.impl.mediapreview;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kza.d;
import wmb.a;
import wmb.b;

/* JADX INFO: loaded from: classes36.dex */
public final class MediaPreviewModule_ProvideOpenFeishuGalleryPreviewDependencyFactory implements Factory<d> {
    private final b module;

    @Override // javax.inject.Provider
    public d get() {
        return provideOpenFeishuGalleryPreviewDependency(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MediaPreviewModule_ProvideOpenFeishuGalleryPreviewDependencyFactory(b r100) {
        this.module = r100;
    }

    public static MediaPreviewModule_ProvideOpenFeishuGalleryPreviewDependencyFactory create(b r100) {
        return new MediaPreviewModule_ProvideOpenFeishuGalleryPreviewDependencyFactory(r100);
    }

    public static d provideOpenFeishuGalleryPreviewDependency(b r100) {
        r100.getClass();
        Object r101 = (d) OfficeSDKManager.getHostGlobalService(d.class);
        if (r101 != null) goto L6;
        r101 = new a();
    L6:
        return (d) Preconditions.checkNotNullFromProvides(r101);
    }
}
