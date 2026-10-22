package com.ss.android.lark.watermark.userscope;

import android.app.Activity;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UiThreadExecutionWatermarkImplV3 f445435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f445436b;

    public f(UiThreadExecutionWatermarkImplV3 r100, Activity r101) {
        this.f445435a = r100;
        this.f445436b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WatermarkImplV3 r100 = this.f445435a.f445332a;     // Catch: Throwable -> L4
        Activity r101 = this.f445436b;     // Catch: Throwable -> L4
        r100.getClass();     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(r101, "activity");     // Catch: Throwable -> L4
        r101.runOnUiThread(new o(r100, r101));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
