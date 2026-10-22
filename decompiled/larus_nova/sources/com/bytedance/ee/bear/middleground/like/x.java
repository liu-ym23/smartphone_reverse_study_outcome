package com.bytedance.ee.bear.middleground.like;

/* JADX INFO: loaded from: classes18.dex */
public final class x implements bu5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f232822a;

    public x(f55.d r100) {
        this.f232822a = r100;
    }

    @Override // bu5.a
    public final void didReceivePush(final String r100) {
        final f55.f r101 = ((f55.d) this.f232822a).f475634a;
        r101.getClass();
        tt5.a.h("LikeWrapper", "like push receive");
        com.bytedance.ee.util.ui.m.a(new f55.e(r101, r100));
    }
}
