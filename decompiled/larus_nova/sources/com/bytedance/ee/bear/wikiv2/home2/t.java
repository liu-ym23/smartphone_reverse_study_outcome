package com.bytedance.ee.bear.wikiv2.home2;

import com.bytedance.ee.bear.list.loadstateview.LoadStateView;

/* JADX INFO: loaded from: classes18.dex */
public final class t implements LoadStateView.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiHomeRecentSpaceView f240951a;

    public t(WikiHomeRecentSpaceView r100) {
        this.f240951a = r100;
    }

    @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.c
    public final void a() {
        WikiHomeRecentSpaceView.b r100 = this.f240951a.f240819k;
        if (r100 == null) goto L6;
        r100.M2();
        return;
    }
}
