package com.bytedance.bdturing.livedetect.view;

import android.graphics.PointF;
import android.graphics.RectF;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.bdturing.livedetect.pty.c f201986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveDetectView f201987b;

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.bdturing.livedetect.pty.c r100 = this.f201986a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        DetectDebugView r101 = this.f201987b.f201973h;     // Catch: Throwable -> L6
        List<List<PointF>> r102 = r100.f201923a;     // Catch: Throwable -> L6
        List<RectF> r103 = r100.f201924b;     // Catch: Throwable -> L6
        r101.f201936c = r102;     // Catch: Throwable -> L6
        r101.f201937d = r103;     // Catch: Throwable -> L6
        r101.postInvalidate();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public a(LiveDetectView r100, com.bytedance.bdturing.livedetect.pty.c r101) {
        this.f201987b = r100;
        this.f201986a = r101;
    }
}
