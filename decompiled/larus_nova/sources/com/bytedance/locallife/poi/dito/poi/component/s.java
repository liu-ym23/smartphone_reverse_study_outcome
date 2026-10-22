package com.bytedance.locallife.poi.dito.poi.component;

import android.view.View;

/* JADX INFO: loaded from: classes21.dex */
public final class s implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f262529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PoiHeadImageDitoView f262530b;

    public s(View r100, PoiHeadImageDitoView r101) {
        this.f262529a = r100;
        this.f262530b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        if (com.bytedance.locallife.common.utils.g.a(this.f262529a) == false) goto L5;
        return;
    L5:
        PoiHeadImageDitoView r100 = this.f262530b;
        PoiHeadImageDitoView.c0(r100, r100.S, "click_photo", null, 0, false, false, null, null, null, null, 65528);
    }
}
