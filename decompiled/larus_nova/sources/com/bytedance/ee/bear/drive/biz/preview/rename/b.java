package com.bytedance.ee.bear.drive.biz.preview.rename;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T> f223679a = null;

    static {
        f223679a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        tt5.a.d(DriveRenameUpdatePlugin.TAG, "fileInfo error");
    }
}
