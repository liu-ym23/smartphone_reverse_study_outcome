package com.bytedance.ee.bear.bitable.card.view.cell.rating;

import android.view.View;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.NumberModel;

/* JADX INFO: loaded from: classes15.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RatingItemsAdapter f208030a;

    public g(RatingItemsAdapter r100, NumberModel r101) {
        this.f208030a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        RatingItemsAdapter.a r101 = this.f208030a.f207999j;
        if (r101 == null) goto L6;
        r101.c();
        return;
    }
}
