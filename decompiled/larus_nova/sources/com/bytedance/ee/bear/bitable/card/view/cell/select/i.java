package com.bytedance.ee.bear.bitable.card.view.cell.select;

import io.reactivex.functions.Function;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final /* synthetic */ class i implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseSelectCellViewHolder f208138a;

    public /* synthetic */ i(BaseSelectCellViewHolder r100) {
        this.f208138a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        return this.f208138a.Q4((List) r100);
    }
}
