package com.bytedance.ee.bear.drive.biz.preview.more;

import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f223527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a95.a f223528b;

    public g(b r100, a95.a r101) {
        this.f223527a = r100;
        this.f223528b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        b.a(this.f223527a, new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d(null), this.f223528b);
    }
}
