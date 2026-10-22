package com.larus.dora.impl.core;

import android.os.SystemClock;
import com.larus.dora.impl.DoraBuryPointManager;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes27.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f332316a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f332317b = null;

    public z() {
    }

    static {
        f332316a = new z();
        f332317b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }

    @JvmStatic
    public static final void c(int r100) {
        if (l0.f332218c != 0) goto L5;
        return;
    L5:
        DoraBuryPointManager.f331862a.L("d_keepalive_service", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", 2), TuplesKt.to("reason", Integer.valueOf(r100)), TuplesKt.to("duration", Long.valueOf(SystemClock.elapsedRealtime() - l0.f332218c))}));
    }

    public static void d(long r100) {
        DoraBuryPointManager.f331862a.L("d_device_found", MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(SystemClock.elapsedRealtime() - r100))));
    }

    public static void b(int r100, int r101) {
        DoraBuryPointManager r102 = DoraBuryPointManager.f331862a;
        Pair[] r103 = new Pair[3];
        r103[0] = TuplesKt.to("step", "end");
        r103[1] = TuplesKt.to("retry_times", Integer.valueOf(r100));
        if (r101 != 0) goto L5;
        String r104 = "success";
    L6:
        r103[2] = TuplesKt.to("fail_reason", r104);
        DoraBuryPointManager.J(r102, "dm_send_bind_cmd", MapsKt.mapOf(r103), false, 12);
        return;
    L5:
        r104 = "cmd_error(" + r101 + ')';
        goto L6
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0096 -> B:23:0x0099). Please report as a decompilation issue!!! */
    public static final Object a(z r100, kj4.a r101, String r102, Function1 r110, Continuation r111) {
        r100.getClass();
        if ((r111 instanceof DoraCoreTracker$stateWithRetry$1) == false) goto L7;
        DoraCoreTracker$stateWithRetry$1 r103 = (DoraCoreTracker$stateWithRetry$1) r111;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r112 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        int r107 = r103.I$0;
        byte r108 = r103.B$0;
        r110 = (Function1) r103.L$2;
        String r109 = (String) r103.L$1;
        kj4.a r113 = (kj4.a) r103.L$0;
        ResultKt.throwOnFailure(r105);
        kj4.a r114 = r113;
        byte r115 = r108;
        r102 = r109;
    L23:
        r107 = r107 + 1;
    L16:
        if (r107 >= 3) goto L24;
        r115 = ((Number) r110.invoke(r114)).byteValue();
        g49.d.d("DoraCoreTracker", "stateWithRetry: i=" + r107 + ' ' + r102 + com.alipay.sdk.m.n.a.f25612h + r115);
        if (r115 != (-1)) goto L24;
        r103.L$0 = r114;
        r103.L$1 = r102;
        r103.L$2 = r110;
        r103.B$0 = r115;
        r103.I$0 = r107;
        r103.label = 1;
        if (DelayKt.delay(200, r103) != r112) goto L23;
        return r112;
    L24:
        if (r115 == 0) goto L28;
        if (r115 == 1) goto L27;
        String r116 = "none";
    L30:
        return r116;
    L27:
        r116 = "on";
        goto L30
    L28:
        r116 = "off";
        goto L30
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r114 = r101;
        r107 = 0;
        r115 = -1;
    L7:
        r103 = new DoraCoreTracker$stateWithRetry$1(r100, r111);
        goto L8
    }
}
