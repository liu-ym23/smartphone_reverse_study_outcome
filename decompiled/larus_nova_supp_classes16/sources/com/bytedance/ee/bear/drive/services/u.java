package com.bytedance.ee.bear.drive.services;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class u<T> implements Consumer {
    public static final u<T> a = null;

    static {
        a = new u();
    }

    public u() {
    }

    public final void accept(Object r3) {
        tt5.a.d("DriveSaveCacheManager", "addUploadDriveFileCache fail: " + ((Throwable) r3));
    }
}
