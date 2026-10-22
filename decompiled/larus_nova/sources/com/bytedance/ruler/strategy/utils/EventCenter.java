package com.bytedance.ruler.strategy.utils;

import android.os.SystemClock;
import com.bytedance.ruler.base.models.f;
import com.bytedance.ruler.strategy.store.StrategyStore;
import com.bytedance.ruler.utils.ALogWrapper;
import com.bytedance.ruler.utils.AppLogWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class EventCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f267745a = 0;

    static {
    }

    public static void b(Function0 r100, String r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        long r103 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        r100.invoke();     // Catch: Throwable -> L7
        long r104 = SystemClock.elapsedRealtime() - r103;     // Catch: Throwable -> L7
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L7
        r105.put("invokeMethod", r101);     // Catch: Throwable -> L7
        r105.put("invokeTime", r104);     // Catch: Throwable -> L7
        r105.put("invokeThread", ThreadMethodProxy.currentThread().getName());     // Catch: Throwable -> L7
        r105.put("signature", StrategyStore.f267723d);     // Catch: Throwable -> L7
        com.bytedance.ruler.utils.c r106 = com.bytedance.ruler.d.f267684h.f267753a;     // Catch: Throwable -> L7
        if (r106 == null) goto L5;
        r106.log("ruler_launch_perf", r105);     // Catch: Throwable -> L7
    L5:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static void c(final String r100, final Map r101, final fa7.d r102) {
        ALogWrapper r103 = com.bytedance.ruler.d.f267685i;     // Catch: Throwable -> L9
        if (r103 == null) goto L5;
        r103.a(2, new EventCenter$logSelectEvent$1(r101, r102));     // Catch: Throwable -> L9
    L5:
        AppLogWrapper r104 = com.bytedance.ruler.d.f267684h;     // Catch: Throwable -> L9
        if (r104 == null) goto L12;
        r104.b(r100, new EventCenter$logSelectEvent$2(r102, r100));     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    public static void a(final String r100, final Map r101, final f r110, final long r111) {
        ALogWrapper r102 = com.bytedance.ruler.d.f267685i;     // Catch: Throwable -> L17
        if (r102 == null) goto L5;
        r102.a(3, new EventCenter$logEvent$1(r101, r110));     // Catch: Throwable -> L17
    L5:
        if (r100 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        return;
    L13:
        AppLogWrapper r104 = com.bytedance.ruler.d.f267684h;     // Catch: Throwable -> L17
        if (r104 == null) goto L20;
        r104.b(r100, new EventCenter$logEvent$2(r100, r101, r110, r111));     // Catch: Throwable -> L17
        return;
    L20:
        return;
    L7:
        if (r100.length() == 0) goto L10;
        r103 = false;
    }
}
