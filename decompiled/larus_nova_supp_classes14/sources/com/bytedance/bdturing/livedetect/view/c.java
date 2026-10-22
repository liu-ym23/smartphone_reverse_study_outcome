package com.bytedance.bdturing.livedetect.view;

import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.livedetect.LiveDetectService;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Map;
import vb4.j;
import vb4.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements Runnable {
    public final /* synthetic */ com.bytedance.bdturing.livedetect.pty.c a;
    public final /* synthetic */ LiveDetectView b;

    /* JADX WARN: Type inference failed for: r0v6, types: [android.app.Activity, com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity, com.bytedance.bdturing.livedetect.TuringLiveDetectActivity] */
    public final void a() {
        LiveDetectView r0 = this.b;
        if (r0.f != null) goto L5;
        return;
    L5:
        if (r0.d.get() != 2) goto L17;
        LiveDetectView.c r1 = this.b.f;
        com.bytedance.bdturing.livedetect.pty.c r5 = this.a;
        ?? r2 = ((s) r1).a;
        if (r2.r == true) goto L18;
        if (r5 == null) goto L19;
        Map<Integer, String> r3 = r2.k;
        HashMap r4 = (HashMap) r3;
        r2.O1((String) r4.get(Integer.valueOf(r5.e)));
        if (r5.e != 0) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L20;
        EventReport.b(true, System.currentTimeMillis() - r2.s, "", r2.v);
        r2.P1();
        r2.runOnUiThread(new j(r2));
        r2.g.setText(2131923608);
        LiveDetectService.getInstance().verify(r2.n, r2.o, r2.p, r5, r2.x);
        return;
    L20:
        return;
    L12:
        r6 = false;
        goto L13
    L19:
        return;
    L18:
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

    public c(LiveDetectView r1, com.bytedance.bdturing.livedetect.pty.c r2) {
        this.b = r1;
        this.a = r2;
    }
}
