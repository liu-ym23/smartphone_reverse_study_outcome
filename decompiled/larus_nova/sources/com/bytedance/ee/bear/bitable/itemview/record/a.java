package com.bytedance.ee.bear.bitable.itemview.record;

import com.bytedance.ee.bear.bitable.card.view.page.RecordCatalogView;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements RecordCatalogView.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ItemViewRecordCatalogData f214054a;

    @Override // com.bytedance.ee.bear.bitable.card.view.page.RecordCatalogView.d
    public final void l() {
        String r100 = this.f214054a.getBaseId();
        if (r100 == null) goto L6;
        com.bytedance.ee.bear.bitable.itemview.util.i.f(r100, null, null);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.page.RecordCatalogView.d
    public final void n() {
        String r100 = this.f214054a.getBaseId();
        if (r100 == null) goto L6;
        com.bytedance.ee.bear.bitable.itemview.util.i.f(r100, this.f214054a.getTableId(), null);
        return;
    }

    public a(ItemViewRecordCatalogData r100) {
        this.f214054a = r100;
    }
}
