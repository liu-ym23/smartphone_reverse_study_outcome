package com.bytedance.ee.bear.search.picker.filter.type;

import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchSelectAdapter f236917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewHolder f236918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f236919c;

    public a(SearchSelectAdapter r100, ViewHolder r101, e r102) {
        this.f236917a = r100;
        this.f236918b = r101;
        this.f236919c = r102;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        SearchSelectAdapter.y2(this.f236917a, this.f236918b, this.f236919c, true);
    }
}
