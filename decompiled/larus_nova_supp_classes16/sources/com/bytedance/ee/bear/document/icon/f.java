package com.bytedance.ee.bear.document.icon;

import com.bytedance.ee.bear.facade.common.empty.EmptyView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements EmptyView.a {
    public final /* synthetic */ IconSelectFragment a;

    public f(IconSelectFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.facade.common.empty.EmptyView.a
    public final void onFailedRetry() {
        IconSelectFragment.W90(this.a);
    }
}
