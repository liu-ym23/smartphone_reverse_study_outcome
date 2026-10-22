package com.bytedance.ee.bear.bitable.share.sharepanel;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j<T> implements Consumer {
    public static final j<T> a = null;

    static {
        a = new j();
    }

    public j() {
    }

    public final void accept(Object r4) {
        tt5.a.e("FormsQRCodePanelFragment", "genQRCode failed", (Throwable) r4, false);
    }
}
