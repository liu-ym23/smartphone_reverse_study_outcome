package com.bytedance.ee.bear.bitable.search;

import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableSearchPlugin.a f215304a;

    public e(BitableSearchPlugin.a r100) {
        this.f215304a = r100;
    }

    public final void a() {
        BitableSearchPlugin.a r100 = this.f215304a;
        BitableSearchModel r101 = r100.f215295a.getValue();
        if (r101 == null) goto L9;
        SimpleItemModel r102 = r101.getCancelItem();
        if (r102 == null) goto L9;
        ActionPayload r103 = r102.getClickActionPayload();
        if (r103 == null) goto L9;
        r100.f215296b.a(r103);
    L9:
        BitableSearchPlugin.access$getUIContainer(r100.f215297c).d(r100.f215297c);
        r100.f215295a.setValue(new BitableSearchModel());
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
