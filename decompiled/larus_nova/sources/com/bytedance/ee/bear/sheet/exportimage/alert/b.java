package com.bytedance.ee.bear.sheet.exportimage.alert;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T> f237510a = null;

    static {
        f237510a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = ScreenshotImageAlertFragment.f237478w;
        tt5.a.e("ScreenshotImageAlertFragment", "handleCustomShare, getImageInner failed: ", (Throwable) r100, false);
    }
}
