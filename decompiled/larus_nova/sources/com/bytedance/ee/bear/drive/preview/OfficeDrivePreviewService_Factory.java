package com.bytedance.ee.bear.drive.preview;

import by4.b;
import dagger.internal.Factory;
import javax.inject.Provider;
import s85.a;

/* JADX INFO: loaded from: classes16.dex */
public final class OfficeDrivePreviewService_Factory implements Factory<a> {
    private final Provider<b> kvStorageProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.kvStorageProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeDrivePreviewService_Factory(Provider<b> r100) {
        this.kvStorageProvider = r100;
    }

    public static OfficeDrivePreviewService_Factory create(Provider<b> r100) {
        return new OfficeDrivePreviewService_Factory(r100);
    }

    public static a newInstance(b r100) {
        return new a(r100);
    }
}
