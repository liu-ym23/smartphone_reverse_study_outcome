package com.bytedance.ee.bear.profile;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements r1c.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HalfProfileActivity f236287a;

    public g(HalfProfileActivity r100) {
        this.f236287a = r100;
    }

    @Override // r1c.a.b
    public final void onScroll(int r100) {
        HalfProfileActivity r101 = this.f236287a;
        if (r100 != 0) goto L5;
        boolean r102 = true;
    L6:
        r101.f236250l = r102;
        return;
    L5:
        r102 = false;
        goto L6
    }
}
