package com.bytedance.android.shopping.sku.inner.container;

import android.view.View;
import com.bytedance.android.shopping.sku.common.monitor.business.SkuBusinessMonitor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ SkuFullScreenFragment a;

    public f(SkuFullScreenFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        mh3.a r3 = this.a.V90().getMonitorManager();
        if (r3 == null) goto L8;
        SkuBusinessMonitor r4 = r3.b;
        if (r4 == null) goto L9;
        r4.a++;
        return;
    L9:
        return;
    }
}
