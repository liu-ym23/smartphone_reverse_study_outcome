package com.bytedance.ee.bear.templates.topic;

import com.bytedance.ee.bear.list.loadstateview.LoadStateView;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements LoadStateView.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseTopicView f239433a;

    public c(BaseTopicView r100) {
        this.f239433a = r100;
    }

    @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.c
    public final void a() {
        e.a r100 = this.f239433a.f239416f;
        if (r100 == null) goto L6;
        r100.onLoadFailed();
        return;
    }
}
