package com.bytedance.ee.bear.document.bottommenu;

import android.view.View;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomMenuPlugin f219171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f219172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BottomMenuData.Item f219173c;

    public b(BottomMenuPlugin r100, m r101, BottomMenuData.Item r102) {
        this.f219171a = r100;
        this.f219172b = r101;
        this.f219173c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BottomMenuPlugin.access$handleResult(this.f219171a, this.f219172b, this.f219173c.getId());
    }
}
