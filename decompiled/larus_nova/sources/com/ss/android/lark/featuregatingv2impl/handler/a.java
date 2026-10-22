package com.ss.android.lark.featuregatingv2impl.handler;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.featuregatingv2impl.statistics.metrics.FeatureGatingMetricsTracker;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f420740a = null;

    static {
        f420740a = new a();
    }

    public a() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        FeatureGatingMetricsTracker r100 = FeatureGatingMetricsTracker.f420741a;     // Catch: Throwable -> L4
        FeatureGatingMetricsTracker.d();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
