package com.bytedance.ee.bear.wikiv2.home2;

import com.bytedance.ee.bear.list.loadstateview.LoadStateView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t implements LoadStateView.c {
    public final /* synthetic */ WikiHomeRecentSpaceView a;

    public t(WikiHomeRecentSpaceView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.c
    public final void a() {
        WikiHomeRecentSpaceView.b r0 = this.a.k;
        if (r0 == null) goto L6;
        r0.M2();
        return;
    }
}
