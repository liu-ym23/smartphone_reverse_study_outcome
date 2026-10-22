package com.bytedance.ee.bear.bitable.card.view.cell.select;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final /* synthetic */ class e implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseSelectCellViewHolder f208126a;

    public /* synthetic */ e(BaseSelectCellViewHolder r100) {
        this.f208126a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        p0 r102 = this.f208126a.I;
        if (r102 == null) goto L5;
        r102.I(false);
    L5:
        tt5.a.e("BaseSelectCellViewHolder", "updateOption ->fetchOptionAttsEditPerm error ", r101, false);
    }
}
