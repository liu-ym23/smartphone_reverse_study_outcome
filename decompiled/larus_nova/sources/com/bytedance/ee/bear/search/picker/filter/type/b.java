package com.bytedance.ee.bear.search.picker.filter.type;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchSelectAdapter f236920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewHolder f236921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f236922c;

    public b(SearchSelectAdapter r100, ViewHolder r101, e r102) {
        this.f236920a = r100;
        this.f236921b = r101;
        this.f236922c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        SearchSelectAdapter.y2(this.f236920a, this.f236921b, this.f236922c, false);
    }
}
