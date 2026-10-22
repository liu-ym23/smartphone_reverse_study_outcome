package com.bytedance.ee.bear.bitable.itemview.recordpages;

import android.view.View;
import com.bytedance.ee.bear.bitable.baseadd.RecordSubmitState;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;

/* JADX INFO: loaded from: classes15.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ItemViewRecordFooterData f214204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ItemViewRecordFooterChild3 f214205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ gv4.a f214206c;

    public i(ItemViewRecordFooterData r100, ItemViewRecordFooterChild3 r101, t r102) {
        this.f214204a = r100;
        this.f214205b = r101;
        this.f214206c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f214204a.getFromCache() == true) goto L5;
        this.f214205b.d(RecordSubmitState.LOADING);
    L5:
        ActionPayload r101 = this.f214204a.getClickSubmitAction();
        if (r101 == null) goto L11;
        gv4.a r102 = this.f214206c;
        com.bytedance.ee.bear.bitable.itemview.util.l.a("ItemViewRecordFooterChild3.clickSubmitAction", null, null, null, 14);
        if (r102 == null) goto L12;
        r102.a(r101);
        return;
    L12:
        return;
    }
}
