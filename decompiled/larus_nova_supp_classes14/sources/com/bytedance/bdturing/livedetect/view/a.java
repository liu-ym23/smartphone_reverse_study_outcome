package com.bytedance.bdturing.livedetect.view;

import android.graphics.PointF;
import android.graphics.RectF;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements Runnable {
    public final /* synthetic */ com.bytedance.bdturing.livedetect.pty.c a;
    public final /* synthetic */ LiveDetectView b;

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.bdturing.livedetect.pty.c r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        DetectDebugView r1 = this.b.h;     // Catch: Throwable -> L6
        List<List<PointF>> r2 = r0.a;     // Catch: Throwable -> L6
        List<RectF> r3 = r0.b;     // Catch: Throwable -> L6
        r1.c = r2;     // Catch: Throwable -> L6
        r1.d = r3;     // Catch: Throwable -> L6
        r1.postInvalidate();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public a(LiveDetectView r1, com.bytedance.bdturing.livedetect.pty.c r2) {
        this.b = r1;
        this.a = r2;
    }
}
