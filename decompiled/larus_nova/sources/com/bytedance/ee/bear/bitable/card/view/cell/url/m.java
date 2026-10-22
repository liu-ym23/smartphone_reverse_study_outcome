package com.bytedance.ee.bear.bitable.card.view.cell.url;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m<T> f208310a = null;

    static {
        f208310a = new m();
    }

    public m() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("UrlCellViewHolder", "sync url value failed", (Throwable) r100, false);
    }
}
