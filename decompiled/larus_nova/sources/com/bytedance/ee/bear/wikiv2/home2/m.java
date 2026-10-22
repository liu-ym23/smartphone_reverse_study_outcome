package com.bytedance.ee.bear.wikiv2.home2;

import com.bytedance.ee.bear.widgets.BaseRecyclerView;

/* JADX INFO: loaded from: classes18.dex */
public final class m implements BaseRecyclerView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f240855a;

    @Override // com.bytedance.ee.bear.widgets.BaseRecyclerView.a
    public final void a0() {
    }

    public m(k r100) {
        this.f240855a = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.BaseRecyclerView.a
    public final void T(int r100, int r101) {
        com.bytedance.ee.bear.list.homepage.title.b r102 = this.f240855a.f240843c;
        if (r102 == null) goto L6;
        r102.a(r101);
        return;
    }
}
