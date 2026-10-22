package com.bytedance.ee.bear.wikiv2.home2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u implements pc5.i.c {
    public final /* synthetic */ pc5.i a;
    public final /* synthetic */ WikiHomeRecentSpaceView b;

    @Override // pc5.i.c
    public final void k(rf5.d r1) {
    }

    @Override // pc5.i.c
    public final void j0() {
        if (this.a.getParent() == null) goto L6;
        this.b.f.removeHeaderView(this.a);
        this.b.f.notifyDataSetChanged();
        return;
    }

    @Override // pc5.i.c
    public final void o0() {
        if (this.a.getParent() != null) goto L6;
        this.b.f.addHeaderView(this.a);
        this.b.f.notifyDataSetChanged();
        this.b.getListRecyclerViewFromXml().smoothScrollToPosition(0);
        return;
    }

    public u(pc5.i r1, WikiHomeRecentSpaceView r2) {
        this.a = r1;
        this.b = r2;
    }
}
