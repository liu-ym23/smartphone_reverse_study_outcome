package com.ss.android.lark.integrator.ccm.dependency.di;

import android.os.SystemClock;
import com.bytedance.ee.bear.integrator.di.KoinSetupTask;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes36.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile kwc.a f427862a;

    public static kwc.a a() {
        if (f427862a != null) goto L15;
        monitor-enter(q.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f427862a != null) goto L9;
        long r100 = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        eu5.b.f474075a = LarkContext.getApplication();     // Catch: Throwable -> L11
        KoinSetupTask.b(LarkContext.getApplication());     // Catch: Throwable -> L11
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L11
        kwc.a r102 = LarkAppKoinModuleKt.f427809a;     // Catch: Throwable -> L11
        r101.add(r102);     // Catch: Throwable -> L11
        hwc.a r103 = hwc.a.f487464a;     // Catch: Throwable -> L11
        hwc.a.a().c(r101, false);     // Catch: Throwable -> L11
        f427862a = r102;     // Catch: Throwable -> L11
        tt5.a.h("DependencyDiInit", "DependencyDiInit#injectDependencyModule cost=" + (SystemClock.uptimeMillis() - r100));     // Catch: Throwable -> L11
    L9:
        monitor-exit(q.class);     // Catch: Throwable -> L11
    L15:
        return f427862a;
    }

    public q() {
    }
}
