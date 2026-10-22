package com.bytedance.ee.bear.wikiv2.home2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements k.b {
    public final /* synthetic */ WikiHomeFragment2 a;

    @Override // com.bytedance.ee.bear.wikiv2.home2.k.b
    public final void onLoadMore() {
        WikiHomeFragment2 r0 = this.a;
        int r1 = WikiHomeFragment2.s;
        r0.Z90().loadMoreRecent();
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.k.b
    public final void onRefresh() {
        WikiHomeFragment2 r0 = this.a;
        int r1 = WikiHomeFragment2.s;
        r0.Z90().refresh();
    }

    public a(WikiHomeFragment2 r1) {
        this.a = r1;
    }
}
