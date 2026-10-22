package com.bytedance.ee.bear.watermark;

import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.watermark.Watermark;

/* JADX INFO: loaded from: classes18.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f239833a;

    public j(FrameLayout r100) {
        this.f239833a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Watermark.Companion.getClass();     // Catch: Throwable -> L4
        Watermark.a.a().attachWatermark(this.f239833a, true, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
