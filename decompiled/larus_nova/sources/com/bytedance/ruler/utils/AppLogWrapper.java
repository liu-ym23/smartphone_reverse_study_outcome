package com.bytedance.ruler.utils;

import android.os.SystemClock;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class AppLogWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f267753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f267754b;

    public AppLogWrapper() {
    }

    public final void b(String r110, final Function1<? super com.bytedance.express.util.a.b, Unit> r111) {
        long r100 = 100000;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        com.bytedance.ruler.a r102 = com.bytedance.ruler.d.f267678b;     // Catch: Throwable -> L11
        if (r102 == null) goto L13;
        JsonObject r103 = r102.f267627m;     // Catch: Throwable -> L11
        if (r103 == null) goto L13;
        JsonElement r112 = r103.get(r110);     // Catch: Throwable -> L11
        if (r112 == null) goto L13;
        long r104 = r112.getAsLong();     // Catch: Throwable -> L11
    L14:
        final boolean r113 = true;
        if (r104 != 0) goto L18;
    L28:
        boolean r105 = true;
    L29:
        if (r105 == false) goto L32;
        return;
    L32:
        if (ThreadMethodProxy.currentThread().getId() == a.f267761e) goto L36;
        r113 = false;
    L36:
        if (Intrinsics.areEqual(AsyncExecutorKt.f267756b.get(), Boolean.TRUE) == false) goto L38;
        AsyncExecutorKt.a(new AppLogWrapper$log$$inlined$runInLogThread$1(this, r111, r113));
        return;
    L38:
        a.b(new AppLogWrapper$log$$inlined$runInLogThread$2(this, r111, r113));
        return;
    L18:
        if (r104 == 1) goto L27;
        if (r104 < 0) goto L24;
        r100 = r104;
    L24:
        if (r100 <= 1) goto L28;
        if ((SystemClock.elapsedRealtime() % r100) != 0) goto L28;
    L27:
        r105 = false;
    L13:
        r104 = 100000;
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static final void a(AppLogWrapper r100, String r101, JSONObject r102, JSONObject r103, JSONObject r104) {
        if (r100.f267754b == false) goto L7;
        c r105 = r100.f267753a;
        if (r105 == null) goto L7;
        r105.log(r101, i.a(i.a(r102, r103), r104));
    L7:
        com.bytedance.ruler.a r106 = com.bytedance.ruler.d.f267678b;
        if (r106 == null) goto L10;
        f r107 = r106.f267622h;
    L11:
        if (r107 == null) goto L14;
        r107.monitorEvent(r101, r102, r103, r104);
        return;
    L14:
        return;
    L10:
        r107 = null;
        goto L11
    }
}
