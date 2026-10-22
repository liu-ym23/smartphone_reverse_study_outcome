package com.bytedance.ee.bear.drive.services;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u<T> f224635a = null;

    static {
        f224635a = new u();
    }

    public u() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("DriveSaveCacheManager", "addUploadDriveFileCache fail: " + ((Throwable) r100));
    }
}
