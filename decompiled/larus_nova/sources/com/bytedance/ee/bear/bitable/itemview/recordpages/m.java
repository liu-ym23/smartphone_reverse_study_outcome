package com.bytedance.ee.bear.bitable.itemview.recordpages;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ItemViewRecordFooterChild4 f214212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ItemViewRecordFooterData f214213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ gv4.a f214214c;

    public m(ItemViewRecordFooterChild4 r100, ItemViewRecordFooterData r101, t r102) {
        this.f214212a = r100;
        this.f214213b = r101;
        this.f214214c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ItemViewRecordFooterChild4.b(this.f214212a, this.f214213b, this.f214214c);
    }
}
