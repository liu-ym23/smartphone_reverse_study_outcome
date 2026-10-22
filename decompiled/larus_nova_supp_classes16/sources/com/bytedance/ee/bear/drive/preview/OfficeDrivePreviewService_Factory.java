package com.bytedance.ee.bear.drive.preview;

import by4.b;
import dagger.internal.Factory;
import javax.inject.Provider;
import s85.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfficeDrivePreviewService_Factory implements Factory<a> {
    private final Provider<b> kvStorageProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m357get() {
        return newInstance((b) this.kvStorageProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m357get();
    }

    public OfficeDrivePreviewService_Factory(Provider<b> r1) {
        this.kvStorageProvider = r1;
    }

    public static OfficeDrivePreviewService_Factory create(Provider<b> r1) {
        return new OfficeDrivePreviewService_Factory(r1);
    }

    public static a newInstance(b r1) {
        return new a(r1);
    }
}
