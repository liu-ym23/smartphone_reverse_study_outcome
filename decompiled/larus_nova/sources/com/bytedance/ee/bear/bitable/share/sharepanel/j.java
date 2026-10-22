package com.bytedance.ee.bear.bitable.share.sharepanel;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j<T> f215449a = null;

    static {
        f215449a = new j();
    }

    public j() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("FormsQRCodePanelFragment", "genQRCode failed", (Throwable) r100, false);
    }
}
