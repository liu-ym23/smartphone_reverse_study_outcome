package com.ss.android.lark.integrator.im.impl.photopicker;

import anb.b;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import rza.a;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeSDKPhotoPickerModule_ProvideOfficeSDKPhotoPickerFactory implements Factory<a> {
    private final b module;

    @Override // javax.inject.Provider
    public a get() {
        return provideOfficeSDKPhotoPicker(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSDKPhotoPickerModule_ProvideOfficeSDKPhotoPickerFactory(b r100) {
        this.module = r100;
    }

    public static OfficeSDKPhotoPickerModule_ProvideOfficeSDKPhotoPickerFactory create(b r100) {
        return new OfficeSDKPhotoPickerModule_ProvideOfficeSDKPhotoPickerFactory(r100);
    }

    public static a provideOfficeSDKPhotoPicker(b r100) {
        r100.getClass();
        Object r101 = (a) OfficeSDKManager.getHostGlobalService(a.class);
        if (r101 != null) goto L6;
        r101 = new anb.a();
    L6:
        return (a) Preconditions.checkNotNullFromProvides(r101);
    }
}
