package com.bytedance.ee.bear.drive.services;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t<T> implements Consumer {
    public static final t<T> a = null;

    static {
        a = new t();
    }

    public t() {
    }

    public final void accept(Object r3) {
        tt5.a.h("DriveSaveCacheManager", "addUploadDriveFileCache success: " + ((Boolean) r3));
    }
}
