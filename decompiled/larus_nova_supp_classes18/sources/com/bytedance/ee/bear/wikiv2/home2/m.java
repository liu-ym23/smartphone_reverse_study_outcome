package com.bytedance.ee.bear.wikiv2.home2;

import com.bytedance.ee.bear.widgets.BaseRecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements BaseRecyclerView.a {
    public final /* synthetic */ k a;

    @Override // com.bytedance.ee.bear.widgets.BaseRecyclerView.a
    public final void a0() {
    }

    public m(k r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.BaseRecyclerView.a
    public final void T(int r1, int r2) {
        com.bytedance.ee.bear.list.homepage.title.b r3 = this.a.c;
        if (r3 == null) goto L6;
        r3.a(r2);
        return;
    }
}
