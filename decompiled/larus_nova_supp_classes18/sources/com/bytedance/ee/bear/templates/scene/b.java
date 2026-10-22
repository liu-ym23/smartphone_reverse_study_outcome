package com.bytedance.ee.bear.templates.scene;

import com.bytedance.ee.bear.list.loadstateview.LoadStateView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements LoadStateView.c {
    public final /* synthetic */ BaseSceneView a;

    public b(BaseSceneView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.c
    public final void a() {
        d.a r0 = this.a.e;
        if (r0 == null) goto L6;
        r0.onLoadFailed();
        return;
    }
}
