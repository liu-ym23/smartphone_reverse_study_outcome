package com.bytedance.apm;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.util.b;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedList;
import vr3.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ApmAgent$x implements Runnable {
    public final /* synthetic */ String a;

    public final void a() {
        k r0 = k.a.a;
        String r1 = this.a;
        if (r0.g == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r1) == true) goto L22;
        k.b r2 = new k.b();
        r2.b = SystemClock.uptimeMillis();
        long r3 = b.a();
        r2.c = r3;
        r2.a = r1;
        if (r3 <= 0) goto L23;
        LinkedList<k.b> r4 = r0.l;
        monitor-enter(r4);
        r0.l.push(r2);     // Catch: Throwable -> L15
        monitor-exit(r4);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L23:
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

    public ApmAgent$x(String r1) {
        this.a = r1;
    }
}
