package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements Runnable {
    public final /* synthetic */ AnchorV4DetailHeadView a;

    public h(AnchorV4DetailHeadView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AnchorV4DetailHeadView.a(this.a).b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
