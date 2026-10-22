package com.bytedance.ee.bear.middleground.like;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x implements bu5.a {
    public final /* synthetic */ y a;

    public x(f55.d r1) {
        this.a = r1;
    }

    public final void didReceivePush(String r4) {
        f55.f r0 = this.a.a;
        r0.getClass();
        tt5.a.h("LikeWrapper", "like push receive");
        com.bytedance.ee.util.ui.m.a(new f55.e(r0, r4));
    }
}
