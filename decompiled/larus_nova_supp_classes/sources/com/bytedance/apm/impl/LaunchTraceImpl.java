package com.bytedance.apm.impl;

import android.os.Handler;
import b27.e;
import com.bytedance.apm.PerfConfig;
import com.bytedance.apm.block.evil.EvilMethodSwitcher;
import com.bytedance.apm.block.g;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.d;
import com.bytedance.apm.launch.evil.b;
import com.bytedance.services.apm.api.ILaunchTrace;
import ct3.a;
import ct3.f;
import es3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class LaunchTraceImpl implements ILaunchTrace {
    public LaunchTraceImpl() {
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void cancelTrace() {
        if (a.b == false) goto L5;
        b.b();
    L5:
        f r0 = a.a;
        if (r0 == null) goto L9;
        r0.c.clear();
        a.a = null;
        return;
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void startTrace() {
        f r0 = new f("start_trace", "launch_stats");
        a.a = r0;
        r0.a = System.currentTimeMillis();
        if (d.l() == false) goto L28;
        boolean r1 = EvilMethodSwitcher.isOpenLaunchEvilMethod();
        a.b = r1;
        if (r1 == true) goto L7;
        return;
    L7:
        monitor-enter(b.class);
    L25:
        th = move-exception;
        throw th;
    L9:
        if (b.a == false) goto L13;
        monitor-exit(b.class);
        return;
    L13:
        b.a = true;     // Catch: Throwable -> L25
        if (b.b == true) goto L22;
        b.b = true;     // Catch: Throwable -> L25
        long r2 = EvilMethodSwitcher.getLaunchEvilThresholdMs();     // Catch: Throwable -> L25
        if (r2 >= 70) goto L18;
        r2 = 1000;
    L18:
        a47.a.j = r2;     // Catch: Throwable -> L25
        a47.a.l = true;     // Catch: Throwable -> L25
        if (EvilMethodSwitcher.isMessageKeyEnable() == false) goto L21;
        PerfConfig.setReportMessage();     // Catch: Throwable -> L25
    L21:
        h.z.g();     // Catch: Throwable -> L25
        MethodCollector.getInstance().onStart();     // Catch: Throwable -> L25
        a47.a.k = true;     // Catch: Throwable -> L25
        EvilMethodSwitcher.isLaunchLimitEvilMethodDepth();     // Catch: Throwable -> L25
        a47.a r3 = new a47.a(true);     // Catch: Throwable -> L25
        b.c = r3;     // Catch: Throwable -> L25
        r3.j();     // Catch: Throwable -> L25
        e.d(true, "launch", null);     // Catch: Throwable -> L25
        new Handler().postDelayed(new com.bytedance.apm.launch.evil.a(), 10000);     // Catch: Throwable -> L25
    L22:
        g.c = true;     // Catch: Throwable -> L25
        g.a.add("app_launch_evil_method_scene_apm_2");     // Catch: Throwable -> L25
        monitor-exit(b.class);
        return;
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void endSpan(String r2, String r3) {
        f r0 = a.a;
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void startSpan(String r2, String r3) {
        f r0 = a.a;
        if (r0 == null) goto L6;
        r0.d(r2, r3);
        return;
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void endTrace(int r2, String r3, long r4) {
        if (a.b == false) goto L5;
        b.b();
    L5:
        f r0 = a.a;
        if (r0 == null) goto L9;
        r0.b(r2, r3, r4);
        return;
    }
}
