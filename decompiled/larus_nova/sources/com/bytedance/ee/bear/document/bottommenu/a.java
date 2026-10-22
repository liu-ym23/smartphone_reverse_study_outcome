package com.bytedance.ee.bear.document.bottommenu;

import android.view.View;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomMenuPlugin f219168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f219169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BottomMenuData.Item f219170c;

    public a(BottomMenuPlugin r100, m r101, BottomMenuData.Item r102) {
        this.f219168a = r100;
        this.f219169b = r101;
        this.f219170c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BottomMenuPlugin.access$handleResult(this.f219168a, this.f219169b, this.f219170c.getId());
    }
}
