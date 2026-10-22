package com.bytedance.ee.bear.templates.scene;

import com.bytedance.ee.bear.list.loadstateview.LoadStateView;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements LoadStateView.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseSceneView f239318a;

    public b(BaseSceneView r100) {
        this.f239318a = r100;
    }

    @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.c
    public final void a() {
        d.a r100 = this.f239318a.f239301e;
        if (r100 == null) goto L6;
        r100.onLoadFailed();
        return;
    }
}
