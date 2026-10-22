package com.bytedance.android.shopping.api.mall.common.feed.help;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallCommonImpressionReportHelper$pollingRunnable$1 implements Runnable {
    public final /* synthetic */ ECMallCommonImpressionReportHelper a;

    @Override // java.lang.Runnable
    public final void run() {
        ECMallCommonImpressionReportHelper r0 = this.a;     // Catch: Throwable -> L7
        if (r0.g == true) goto L10;
        ECMallCommonImpressionReportHelper.a(r0, false, false, new ECMallCommonImpressionReportHelper$pollingRunnable$1$run$1(this), 2);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }

    public ECMallCommonImpressionReportHelper$pollingRunnable$1(ECMallCommonImpressionReportHelper r1) {
        this.a = r1;
    }
}
