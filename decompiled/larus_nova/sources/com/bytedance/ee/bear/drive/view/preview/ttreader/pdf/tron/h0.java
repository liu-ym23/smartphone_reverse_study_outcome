package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class h0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0<T> f225356a = null;

    static {
        f225356a = new h0();
    }

    public h0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("PDFCtrlView", "loadPresentationPageView fail. ", (Throwable) r100, false);
    }
}
