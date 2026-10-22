package com.bytedance.bdturing.livedetect.view;

import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.livedetect.TuringLiveDetectActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import vb4.s;
import vb4.t;
import vb4.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Exception b;
    public final /* synthetic */ LiveDetectView c;

    public final void a() {
        if (this.c.d.get() == 3) goto L12;
        LiveDetectView.c r0 = this.c.f;
        int r1 = this.a;
        String r2 = this.b.getMessage();
        s r3 = (s) r0;
        if (40001 != r1) goto L10;
        TuringLiveDetectActivity r4 = r3.a;
        int r5 = r4.u;
        if (r5 >= 2) goto L9;
        int r6 = r5 + 1;
        r4.u = r6;
        r4.e.postDelayed(new t(r4), ((long) r6) * 500);
        goto L10
    L9:
        r4.M1(new u(r4));
    L10:
        EventReport.p(r1, r2, r3.a.v);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(LiveDetectView r1, int r2, Exception r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
