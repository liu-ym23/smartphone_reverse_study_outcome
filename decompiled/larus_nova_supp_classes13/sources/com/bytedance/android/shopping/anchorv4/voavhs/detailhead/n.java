package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n implements Runnable {
    public final /* synthetic */ AnchorV4DetailSkuPropertiesFragment a;
    public final /* synthetic */ List b;

    public n(AnchorV4DetailSkuPropertiesFragment r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ExpandableLinearLayoutV4 r0 = this.a.j;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.b();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
