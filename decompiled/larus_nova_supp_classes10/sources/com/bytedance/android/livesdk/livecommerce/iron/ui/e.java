package com.bytedance.android.livesdk.livecommerce.iron.ui;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements Runnable {
    public final /* synthetic */ ECPromotionListFooterView a;
    public final /* synthetic */ List b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ ECCustomizedElementView d;

    public e(ECPromotionListFooterView r1, List r2, boolean r3, ECCustomizedElementView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECPromotionListFooterView.R5(this.a, this.d, this.b, this.c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
