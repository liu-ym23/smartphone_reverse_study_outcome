package com.bytedance.ee.bear.watermark;

import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.watermark.Watermark;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements Runnable {
    public final /* synthetic */ FrameLayout a;

    public j(FrameLayout r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Watermark.Companion.getClass();     // Catch: Throwable -> L4
        Watermark.a.a().attachWatermark(this.a, true, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
