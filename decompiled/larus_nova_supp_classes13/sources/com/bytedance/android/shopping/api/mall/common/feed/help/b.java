package com.bytedance.android.shopping.api.mall.common.feed.help;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Runnable {
    public final /* synthetic */ ECMallCommonImpressionReportHelper a;

    public b(ECMallCommonImpressionReportHelper r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECMallCommonImpressionReportHelper.a(this.a, true, true, null, 4);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
