package com.bytedance.ee.bear.templates.center.list.base;

import com.bytedance.ee.bear.list.loadstateview.LoadStateView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n implements LoadStateView.c {
    public final /* synthetic */ BaseTemplateListView a;

    public n(BaseTemplateListView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.c
    public final void a() {
        q.a r0 = this.a.d;
        if (r0 == null) goto L6;
        r0.onLoadFailed();
        return;
    }
}
