package com.bytedance.lego.init.util;

import androidx.core.os.TraceCompat;
import com.bytedance.lego.init.InitScheduler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public static void c() {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        TraceCompat.endSection();
    }

    static {
    }

    public static void a(String r2) {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        TraceCompat.beginSection("Task:" + r2);
    }

    public static void b(bf6.f r2) {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        TraceCompat.beginSection("Task:" + r2.a);
    }
}
