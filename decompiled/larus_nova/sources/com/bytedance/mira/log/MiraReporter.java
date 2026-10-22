package com.bytedance.mira.log;

import com.bytedance.crash.upload.b;
import com.bytedance.crash.util.u;
import com.bytedance.mira.exception.MonitorException;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import eh4.a;
import eh4.d;

/* JADX INFO: loaded from: classes21.dex */
public class MiraReporter {
    public static final String FILTER_TYPE_PLUGIN_APK_NOT_EXISTS = "plugin_apk_not_exists";
    public static final String FILTER_TYPE_START_ACTIVITY_TIMEOUT = "start_activity_timeout";

    public MiraReporter() {
    }

    public static void reportException(String r100, String r101) {
        d r102 = d.c(new StackTraceElement(MiraReporter.class.getName(), "", "", 0), u.a(new MonitorException(r101)), r101, ThreadMethodProxy.currentThread().getName(), true, "EnsureNotReachHere", "mira_custom_exception");     // Catch: Throwable -> L5
        a.b(r102.f472653a, "filters", "mira_custom_exception", r100);     // Catch: Throwable -> L5
        b.a(r102);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG, " reportIfTimeout failed.", th);
    }
}
