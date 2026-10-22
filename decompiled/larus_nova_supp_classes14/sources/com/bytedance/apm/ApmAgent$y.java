package com.bytedance.apm;

import android.os.SystemClock;
import android.text.TextUtils;
import av3.b;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedList;
import vr3.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ApmAgent$y implements Runnable {
    public final /* synthetic */ String a;

    public final void a() {
        k r0 = k.a.a;
        String r1 = this.a;
        if (r0.g == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return;
    L8:
        if (r0.l.size() == 0) goto L52;
        LinkedList<k.b> r2 = r0.l;
        monitor-enter(r2);
        k.b r3 = r0.l.pop();     // Catch: Throwable -> L34
        monitor-exit(r2);     // Catch: Throwable -> L34
        if (r3 != null) goto L15;
    L32:
        if (r3 == null) goto L8;
        b.a("ProcessEnergyCollector", String.format("Unexpected scene, top: %s, cur:%s", new Object[]{r3.a, r1}));
        goto L8
    L15:
        if (r3.a.equals(r1) == false) goto L32;
        r3.d = SystemClock.uptimeMillis();
        long r4 = com.bytedance.apm.util.b.a();
        r3.e = r4;
        if (r4 <= 0) goto L50;
        Long r5 = r0.k.get(r3.a);
        if (r5 != null) goto L22;
    L24:
        LinkedList<k.b> r6 = r0.m;
        monitor-enter(r6);
        r0.m.add(r3);     // Catch: Throwable -> L29
        monitor-exit(r6);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    L22:
        if ((r3.d - r3.b) >= r5.longValue()) goto L24;
        return;
    L50:
        return;
    L34:
        th = move-exception;
        throw th;
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

    public ApmAgent$y(String r1) {
        this.a = r1;
    }
}
