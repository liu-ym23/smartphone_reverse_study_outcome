package com.bytedance.ee.bear.bitable.card.view.cell.select;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final /* synthetic */ class b implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseSelectCellViewHolder f208121a;

    public /* synthetic */ b(BaseSelectCellViewHolder r100) {
        this.f208121a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        BaseSelectCellViewHolder r101 = this.f208121a;
        Boolean r102 = (Boolean) r100;
        int r103 = BaseSelectCellViewHolder.Q;
        r101.getClass();
        tt5.a.h("BaseSelectCellViewHolder", "updateOption ->fetchOptionAttsEditPerm result: " + r102);
        if (r101.F == null) goto L14;
        p0 r104 = r101.I;
        if (r104 != null) goto L7;
        return;
    L7:
        if (r102.booleanValue() == true) goto L9;
    L11:
        boolean r105 = false;
    L12:
        r104.I(r105);
        return;
    L9:
        if (BaseSelectCellViewHolder.i5(r101.F.f469587a) == true) goto L11;
        r105 = true;
        goto L12
    }
}
