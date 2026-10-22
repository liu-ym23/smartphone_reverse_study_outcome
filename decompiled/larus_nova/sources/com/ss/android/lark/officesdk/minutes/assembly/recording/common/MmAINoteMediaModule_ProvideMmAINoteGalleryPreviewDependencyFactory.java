package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes37.dex */
public final class MmAINoteMediaModule_ProvideMmAINoteGalleryPreviewDependencyFactory implements Factory<com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.b> {
    private final d module;

    @Override // javax.inject.Provider
    public com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.b get() {
        return provideMmAINoteGalleryPreviewDependency(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MmAINoteMediaModule_ProvideMmAINoteGalleryPreviewDependencyFactory(d r100) {
        this.module = r100;
    }

    public static MmAINoteMediaModule_ProvideMmAINoteGalleryPreviewDependencyFactory create(d r100) {
        return new MmAINoteMediaModule_ProvideMmAINoteGalleryPreviewDependencyFactory(r100);
    }

    public static com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.b provideMmAINoteGalleryPreviewDependency(d r100) {
        r100.getClass();
        String r101 = OfficeSDKManager.getCurrentUid();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        Object r102 = (com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.b) OfficeSDKManager.getHostUserService(r101, com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.b.class);
        if (r102 != null) goto L9;
        r102 = new c();
    L9:
        return (com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.b) Preconditions.checkNotNullFromProvides(r102);
    }
}
