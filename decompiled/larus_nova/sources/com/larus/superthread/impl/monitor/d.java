package com.larus.superthread.impl.monitor;

import android.os.Looper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.GroupingKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class d {
    public d() {
    }

    public static void a(JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        boolean r100 = false;
        PolarisFileWrapper r101 = new PolarisFileWrapper("/proc/self/task/");     // Catch: Throwable -> L9
        if (r101.exists() == false) goto L10;
        String[] r102 = r101.list();     // Catch: Throwable -> L9
        if (r102 == null) goto L10;
        int r103 = r102.length;     // Catch: Throwable -> L9
    L11:
        if (r103 != 0) goto L13;
        return;
    L13:
        ThreadGroup r104 = ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getThreadGroup();
    L14:
        Object r105 = null;
        if (r104 == null) goto L17;
        ThreadGroup r106 = r104.getParent();
    L18:
        if (r106 == null) goto L20;
        r104 = r104.getParent();
        goto L14
    L20:
        if (r104 != null) goto L22;
        return;
    L22:
        int r107 = r104.activeCount();
        int r108 = r107 + (r107 / 2);
        Thread[] r109 = new Thread[r108];
        int r111 = r104.enumerate(r109);
        if (r108 != 0) goto L25;
        r100 = true;
    L25:
        if (r100 == false) goto L39;
    L35:
        r110.put("total_thread_count", r103);
        r110.put("java_thread_count", r111);
        r110.put("native_thread_count", r103 - r111);
        r110.put("thread_names", r105);
        r110.putOpt("current_thread", ThreadMethodProxy.currentThread().getName());
        return;
    L39:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L29
        r105 = CollectionsKt.joinToString$default(GroupingKt.eachCount(new c(ArraysKt.filterNotNull(r109))).entrySet(), ",", null, null, 0, null, new b(), 30, null);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r114) == true) goto L34;
        r105 = r114;
    L34:
        r105 = (String) r105;
        goto L35
    L17:
        r106 = null;
    L10:
        r103 = 0;
        goto L11
    }
}
