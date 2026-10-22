package com.bytedance.ee.bear.bitable.search;

import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements Runnable {
    public final /* synthetic */ BitableSearchPlugin.a a;

    public e(BitableSearchPlugin.a r1) {
        this.a = r1;
    }

    public final void a() {
        BitableSearchPlugin.a r0 = this.a;
        BitableSearchModel r1 = (BitableSearchModel) r0.a.getValue();
        if (r1 == null) goto L9;
        SimpleItemModel r2 = r1.getCancelItem();
        if (r2 == null) goto L9;
        ActionPayload r3 = r2.getClickActionPayload();
        if (r3 == null) goto L9;
        r0.b.a(r3);
    L9:
        BitableSearchPlugin.access$getUIContainer(r0.c).d(r0.c);
        r0.a.setValue(new BitableSearchModel());
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
