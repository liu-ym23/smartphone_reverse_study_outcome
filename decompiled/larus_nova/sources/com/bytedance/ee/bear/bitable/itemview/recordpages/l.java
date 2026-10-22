package com.bytedance.ee.bear.bitable.itemview.recordpages;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ItemViewRecordFooterChild4 f214209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ItemViewRecordFooterData f214210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ gv4.a f214211c;

    public l(ItemViewRecordFooterChild4 r100, ItemViewRecordFooterData r101, t r102) {
        this.f214209a = r100;
        this.f214210b = r101;
        this.f214211c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ItemViewRecordFooterChild4.b(this.f214209a, this.f214210b, this.f214211c);
    }
}
