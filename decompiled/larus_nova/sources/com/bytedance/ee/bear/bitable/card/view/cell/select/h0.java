package com.bytedance.ee.bear.bitable.card.view.cell.select;

import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ColorBean;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.RandomColorResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class h0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SelectEditPanel f208137a;

    public h0(SelectEditPanel r100) {
        this.f208137a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        SelectEditPanel r101 = this.f208137a;
        Integer r102 = ((RandomColorResult) r100).getColor();
        if (r102 == null) goto L5;
        int r103 = r102.intValue();
    L6:
        r101.A = r103;
        SelectEditPanel r104 = this.f208137a;
        ColorBean[] r105 = r104.f208075n;
        if (r105 == null) goto L14;
        ColorBean r106 = r105[r104.A];
        if (r106 == null) goto L15;
        r104.G.f210683m.Q(r106.getColor(), r106.getTextColor());
        if (r104.I == false) goto L16;
        r104.G.f210684n.Q(r106.getColor(), r106.getTextColor());
        r104.G.f210684n.S(r106.getBorderColor());
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r103 = 0;
        goto L6
    }
}
