package com.bytedance.ee.bear.profile;

import com.bytedance.ee.bear.lark.dependency.c0;

/* JADX INFO: loaded from: classes18.dex */
public final class l implements com.ss.android.lark.api.ui.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HalfProfileFragment f236291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ tua.b f236292b;

    @Override // com.ss.android.lark.api.ui.a
    public final void a() {
        HalfProfileFragment r100 = this.f236291a;
        if (r100.f236271l == true) goto L7;
        r100.f236271l = true;
        c0.a r101 = r100.f236270k;
        if (r101 == null) goto L7;
        r101.onCancel();
    L7:
        this.f236292b.R(this.f236291a, this);
    }

    public l(HalfProfileFragment r100, tua.b r101) {
        this.f236291a = r100;
        this.f236292b = r101;
    }
}
