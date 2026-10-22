package com.bytedance.ee.bear.bizwidget.shareview;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends t {
    public final /* synthetic */ int c;
    public final /* synthetic */ ShareItemAdapter d;

    public final void a(View r3) {
        ShareItemAdapter r4 = this.d;
        ShareItemAdapter.a r0 = r4.b;
        if (r0 == null) goto L6;
        ShareItemModel r5 = (ShareItemModel) ListProtector.get(r4.a, this.c);
        ExternalShareView.a(((a) r0).a, r5);
        return;
    }

    public c(ShareItemAdapter r1, int r2) {
        this.d = r1;
        this.c = r2;
    }
}
