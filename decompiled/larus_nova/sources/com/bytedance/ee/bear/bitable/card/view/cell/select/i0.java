package com.bytedance.ee.bear.bitable.card.view.cell.select;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class i0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i0<T> f208139a = null;

    static {
        f208139a = new i0();
    }

    public i0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.i("SelectEditPanel", "fetch random colorId failed", (Throwable) r100);
    }
}
