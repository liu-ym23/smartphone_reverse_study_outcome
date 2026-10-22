package com.bytedance.ee.bear.templates.topic;

import com.bytedance.ee.bear.list.loadstateview.LoadStateView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements LoadStateView.c {
    public final /* synthetic */ BaseTopicView a;

    public c(BaseTopicView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.c
    public final void a() {
        e.a r0 = this.a.f;
        if (r0 == null) goto L6;
        r0.onLoadFailed();
        return;
    }
}
