package com.bytedance.ee.bear.bitable.card.view.cell.progress;

import android.view.View;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.NumberModel;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProgressItemsAdapter f207989a;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ProgressItemsAdapter.a r101 = this.f207989a.f207954l;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }

    public f(ProgressItemsAdapter r100, NumberModel r101) {
        this.f207989a = r100;
    }
}
