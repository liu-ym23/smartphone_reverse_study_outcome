package com.bytedance.ee.bear.more.itemv2;

import com.bytedance.ee.bear.more.moreprotocol.ISwitchMoreItem;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements Runnable {
    public final /* synthetic */ SubscribeCommentItemV2 a;
    public final /* synthetic */ ISwitchMoreItem.a b;

    public a(SubscribeCommentItemV2 r1, ISwitchMoreItem.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SubscribeCommentItemV2.access$setLoading$p(this.a, false);     // Catch: Throwable -> L4
        SubscribeCommentItemV2.access$notifyItemChange(this.a, this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
