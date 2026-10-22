package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h0<T> implements Consumer {
    public static final h0<T> a = null;

    static {
        a = new h0();
    }

    public h0() {
    }

    public final void accept(Object r4) {
        tt5.a.e("PDFCtrlView", "loadPresentationPageView fail. ", (Throwable) r4, false);
    }
}
