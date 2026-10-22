package com.bytedance.ee.bear.drive.services;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class t<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t<T> f224634a = null;

    static {
        f224634a = new t();
    }

    public t() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.h("DriveSaveCacheManager", "addUploadDriveFileCache success: " + ((Boolean) r100));
    }
}
