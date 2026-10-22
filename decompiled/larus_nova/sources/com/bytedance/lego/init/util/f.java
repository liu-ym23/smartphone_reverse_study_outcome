package com.bytedance.lego.init.util;

import androidx.core.os.TraceCompat;
import com.bytedance.lego.init.InitScheduler;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f254573a = 0;

    public static void c() {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        TraceCompat.endSection();
    }

    static {
    }

    public static void a(String r100) {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        TraceCompat.beginSection("Task:" + r100);
    }

    public static void b(bf6.f r100) {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        TraceCompat.beginSection("Task:" + r100.f18824a);
    }
}
