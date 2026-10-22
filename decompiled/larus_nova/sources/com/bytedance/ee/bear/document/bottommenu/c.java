package com.bytedance.ee.bear.document.bottommenu;

import android.view.View;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomMenuPlugin f219174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f219175b;

    public c(BottomMenuPlugin r100, m r101) {
        this.f219174a = r100;
        this.f219175b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BottomMenuPlugin.access$handleResult(this.f219174a, this.f219175b, "Cancel");
    }
}
