package com.bytedance.ee.bear.document.icon;

import com.bytedance.ee.bear.facade.common.empty.EmptyView;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements EmptyView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IconSelectFragment f219993a;

    public f(IconSelectFragment r100) {
        this.f219993a = r100;
    }

    @Override // com.bytedance.ee.bear.facade.common.empty.EmptyView.a
    public final void onFailedRetry() {
        IconSelectFragment.W90(this.f219993a);
    }
}
