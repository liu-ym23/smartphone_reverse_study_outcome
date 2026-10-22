package com.bytedance.ee.bear.more.itemv2;

import com.bytedance.ee.bear.more.moreprotocol.ISwitchMoreItem;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubscribeCommentItemV2 f234612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ISwitchMoreItem.a f234613b;

    public a(SubscribeCommentItemV2 r100, ISwitchMoreItem.a r101) {
        this.f234612a = r100;
        this.f234613b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SubscribeCommentItemV2.access$setLoading$p(this.f234612a, false);     // Catch: Throwable -> L4
        SubscribeCommentItemV2.access$notifyItemChange(this.f234612a, this.f234613b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
