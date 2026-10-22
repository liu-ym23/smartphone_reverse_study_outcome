package com.bytedance.ee.bear.drive.biz.preview.rename;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T> implements Consumer {
    public static final b<T> a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        tt5.a.d(DriveRenameUpdatePlugin.TAG, "fileInfo error");
    }
}
