package com.bytedance.ee.bear.more.itemv2;

import com.bytedance.ee.bear.more.moreprotocol.ISwitchMoreItem;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubscribeItemV2 f234614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ISwitchMoreItem.a f234615b;

    public b(SubscribeItemV2 r100, ISwitchMoreItem.a r101) {
        this.f234614a = r100;
        this.f234615b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SubscribeItemV2.access$setLoading$p(this.f234614a, false);     // Catch: Throwable -> L4
        SubscribeItemV2.access$notifyItemChange(this.f234614a, this.f234615b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
