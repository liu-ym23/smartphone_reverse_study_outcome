package com.bytedance.ee.bear.bitable.itemview.recordpages;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class r implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ItemViewRecordFooterChild4 f214225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ItemViewRecordFooterData f214226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ gv4.a f214227c;

    public r(ItemViewRecordFooterChild4 r100, ItemViewRecordFooterData r101, gv4.a r102) {
        this.f214225a = r100;
        this.f214226b = r101;
        this.f214227c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ItemViewRecordFooterChild4.b(this.f214225a, this.f214226b, this.f214227c);
    }
}
