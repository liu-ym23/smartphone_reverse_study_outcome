package com.bytedance.push;

import com.bytedance.push.client.intelligence.FeatureCollectionHelper;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        FeatureCollectionHelper.getInstance(c.O.f266761a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public l() {
    }
}
