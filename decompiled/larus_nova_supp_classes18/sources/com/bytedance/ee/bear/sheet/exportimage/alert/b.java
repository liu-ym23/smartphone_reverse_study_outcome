package com.bytedance.ee.bear.sheet.exportimage.alert;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T> implements Consumer {
    public static final b<T> a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void accept(Object r4) {
        int r0 = ScreenshotImageAlertFragment.w;
        tt5.a.e("ScreenshotImageAlertFragment", "handleCustomShare, getImageInner failed: ", (Throwable) r4, false);
    }
}
