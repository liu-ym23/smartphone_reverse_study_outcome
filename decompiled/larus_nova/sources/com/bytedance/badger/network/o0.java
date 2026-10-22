package com.bytedance.badger.network;

import android.os.SystemClock;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.e;
import com.bytedance.badger.j;
import com.bytedance.badger.monitor.CollectStage;
import com.bytedance.badger.monitor.TriggerStage;
import com.bytedance.badger.utils.C10462c;
import com.bytedance.badger.v.f;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function6;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f199132a = null;

    static {
        f199132a = new o0();
    }

    public o0() {
    }

    public static void a(n0 r210) {
        com.bytedance.badger.monitor.c r100 = com.bytedance.badger.monitor.c.f199044c;
        TriggerStage r101 = r210.f199126d;
        CollectStage r102 = CollectStage.collect_pre;
        int r103 = r210.f199125c;
        com.bytedance.badger.monitor.c.a(r100, r101, r102, r210.f199123a, null, r103, 0, 0, null, null, false, 0, r210.f199131i, 0, null, 14304);
    }

    public static void d(n0 r210, z64.b r211) {
        com.bytedance.badger.monitor.c r100 = com.bytedance.badger.monitor.c.f199044c;
        TriggerStage r101 = r210.f199126d;
        CollectStage r102 = CollectStage.collect_finished;
        int r103 = r210.f199125c;
        long r104 = SystemClock.elapsedRealtime() - r210.f199128f;
        long r105 = SystemClock.uptimeMillis() - r210.f199129g;
        com.bytedance.badger.monitor.c.a(r100, r101, r102, r210.f199123a, r211, r103, r104, r105, null, null, r210.f199127e, r210.f199130h.get(), r210.f199131i, 0, null, 12672);
    }

    public static void e(n0 r100, boolean r101) {
        BadgerCore.Companion.getClass();
        j.a().checkReadyForReportAndThrow(r101);
        if (StringsKt.isBlank(r100.f199123a.getDeviceId()) == true) goto L6;
        return;
    L6:
        throw new C10462c("deviceId is blank", SpeechEngineDefines.ERR_AUTHENTICATION_FAILED, CollectStage.collect_pre, null, 8);
    }

    public final void c(n0 r100, Function6 r101) {
        Integer r102 = null;
        BadgerCore.Companion.getClass();     // Catch: Exception -> L5
        z64.b r103 = BadgerCore.getBadgerReport$default(j.a(), r100.f199123a, false, 2, null);     // Catch: Exception -> L5
        Exception r104 = null;
    L7:
        d(r100, r103);
        if (r103 != null) goto L10;
    L22:
        if (r103 == null) goto L24;
        BadgerCore.Companion.getClass();
        String r105 = j.a().getLastCollectError();
    L25:
        if (r104 != null) goto L31;
        StringBuilder r106 = new StringBuilder("getBadgerReport: fullReport empty or errorCode != 0, errorCode: ");
        if (r103 == null) goto L30;
        r102 = Integer.valueOf(r103.f570456b);
    L30:
        r106.append(r102);
        r104 = new C10462c(r106.toString(), SpeechEngineDefines.ERR_GET_DEVICEID_FAILED, CollectStage.collect_finished, r105);
    L31:
        b(r100, r104, r103);
        return;
    L24:
        r105 = "";
        goto L25
    L10:
        if (r103.f570456b != 0) goto L22;
        f(this, r103, r100, r101);     // Catch: Exception -> L19
        if (r100.f199127e == false) goto L16;
        String r107 = "collectFullReport - timeout upload end";
    L17:
        e.f("BadgerNetworkHandler", r107);
        return;
    L16:
        r107 = "collectFullReport - full report upload end";
    L19:
        e = move-exception;
        e.e("BadgerNetworkHandler", "Failed to upload report: " + e.getMessage());
        b(r100, e, r103);
        return;
    L5:
        e = move-exception;
        r104 = e;
        r103 = null;
        goto L7
    }

    public static void b(n0 r110, Throwable r210, z64.b r211) {
        com.bytedance.badger.monitor.c.b(com.bytedance.badger.monitor.c.f199044c, r110.f199126d, r210, 0, null, r110.f199125c, SystemClock.elapsedRealtime() - r110.f199128f, SystemClock.uptimeMillis() - r110.f199129g, r110.f199123a, null, r110.f199127e, r110.f199130h.get(), r110.f199131i, null, 4364);
    }

    public static void f(o0 r100, z64.b r101, n0 r102, Function6 r103) {
        com.bytedance.badger.v.d.f199322f0.getClass();
        f r104 = com.bytedance.badger.v.d.f199340x;
        KProperty r105 = com.bytedance.badger.v.d.f199311a[24];
        boolean r106 = ((Boolean) r104.a()).booleanValue();
        r100.getClass();
        g(r101, r102, r106, r103);
    }

    public static void g(z64.b r100, n0 r110, boolean r111, Function6 r112) {
        e.f("BadgerNetworkHandler", "sendFollowUpRequest doRequest start");
        z64.c r101 = r110.f199123a;
        String r102 = r110.f199124b;
        ArrayList r103 = new ArrayList();
        BadgerCore.Companion.getClass();     // Catch: Exception -> L7
        Pair r104 = j.a().getRequestHeaderTag();     // Catch: Exception -> L7
        if (r104 == null) goto L8;
        r103.add(TuplesKt.to(r104.getFirst(), r104.getSecond()));     // Catch: Exception -> L7
    L8:
        BadgerCore.Companion.getClass();
        String r105 = j.a().getNetRequestInterface().getHost();
        int r106 = 0;
        if (r105.length() != 0) goto L11;
        boolean r107 = true;
    L12:
        if (r107 == false) goto L14;
        r105 = "aweme.snssdk.com";
    L14:
        String r108 = "https://" + r105 + r102;
        Pair[] r109 = new Pair[3];
        String r113 = r100.f570455a;
        if (r113 != null) goto L18;
        r113 = "";
    L18:
        r109[0] = TuplesKt.to("badger_payload_data", r113);
        r109[1] = TuplesKt.to("badger_signal", String.valueOf(r101.getTimestamp()));
        r109[2] = TuplesKt.to("badger_scene", String.valueOf(r101.getSceneId()));
        a0 r114 = new a0(r108, r103, MapsKt.mapOf(r109));
        u0 r115 = u0.f199154h;
        if (r111 == false) goto L21;
        com.bytedance.badger.v.d.f199322f0.getClass();
        com.bytedance.badger.v.h r116 = com.bytedance.badger.v.d.f199341y;
        KProperty r117 = com.bytedance.badger.v.d.f199311a[25];
        int r118 = ((Number) r116.a()).intValue();
    L22:
        if (r111 == false) goto L24;
        com.bytedance.badger.v.d.f199322f0.getClass();
        com.bytedance.badger.v.h r119 = com.bytedance.badger.v.d.f199342z;
        KProperty r120 = com.bytedance.badger.v.d.f199311a[26];
        r106 = ((Number) r119.a()).intValue();
    L24:
        BadgerRetryReportCallback r121 = new BadgerRetryReportCallback(r100, r110, r112);
        com.bytedance.badger.C.a r122 = r110.f199131i;
        r115.getClass();
        u0.b(r114, r118, r106, r121, r122);
        return;
    L21:
        r118 = 0;
        goto L22
    L11:
        r107 = false;
        goto L12
    }

    public final void h(z64.c r110, int r111, TriggerStage r210, boolean r211, com.bytedance.badger.C.a r212, b74.b r213) {
        n0 r112 = new n0(r110, r111, r210, r212, 240);
        long r100 = r112.f199128f;
        long r113 = r112.f199129g;
        AtomicLong r114 = r112.f199130h;
        n0 r115 = new n0(r110, "/passport/dtrait/sinr/", r111, r210, true, r100, r113, r114, r112.f199131i);
        e(r112, true);
        a(r112);
        e.f("BadgerNetworkHandler", "start collect1...");
        BadgerCore.Companion.getClass();
        int r101 = j.a().updateFeatures(r110, r111, true);
        if (r101 == 0) goto L9;
        if (r101 == 1) goto L6;
        e.f("BadgerNetworkHandler", "collectFullReport - updateFeatures failed, status: " + r101);
        b(r112, new C10462c("badger update failed: " + r101, 0, null, null, 14), null);
        return;
    L6:
        e.f("BadgerNetworkHandler", "collectFullReport - updateFeatures timeout, status: " + r101);
        j.a().addSceneCompletionCallback(r110.getSceneId(), new C10456g(r101, r115, r213));
        r114.set(SystemClock.elapsedRealtime());
        e.f("BadgerNetworkHandler", "collectFullReport - timeout, first upload");
        if (r211 == false) goto L12;
        c(r112, r213);
        return;
    L12:
        return;
    L9:
        c(r112, r213);
        com.bytedance.badger.monitor.c.f199044c.getClass();
        com.bytedance.badger.monitor.c.e();
    }

    public final void i(z64.c r100, int r110, TriggerStage r111, boolean r112, com.bytedance.badger.C.a r113, b74.b r114) {
        n0 r101 = new n0(r100, r110, r111, r113, 240);
        e(r101, r112);
        a(r101);
        e.f("BadgerNetworkHandler", "start collect2...");
        BadgerCore.Companion.getClass();
        int r115 = BadgerCore.updateFeatures$default(j.a(), r100, r110, false, 4, null);
        com.bytedance.badger.v.d.f199322f0.getClass();
        com.bytedance.badger.v.h r116 = com.bytedance.badger.v.d.f199337u;
        KProperty r102 = com.bytedance.badger.v.d.f199311a[21];
        if (((Number) r116.a()).intValue() <= 0) goto L9;
        if (r115 != 0) goto L7;
        com.bytedance.badger.monitor.c.f199044c.getClass();
        com.bytedance.badger.monitor.c.e();
        goto L9
    L7:
        if (r115 != 1) goto L9;
        j.a().addSceneCompletionCallback(r100.getSceneId(), C10457h.f199107a);
    L9:
        z64.b r103 = j.a().getBadgerReport(r100, r112);
        if (r103 == null) goto L18;
        if (r103.f570456b != 0) goto L16;
        d(r101, r103);
        f(this, r103, r101, r114);
        e.f("BadgerNetworkHandler", "sendFollowUpRequest end");
        return;
    L16:
        throw new C10462c("getBadgerReport failed,errorCode=" + r103.f570456b, SpeechEngineDefines.ERR_GET_DEVICEID_FAILED, CollectStage.collect_finished, j.a().getLastCollectError());
    L18:
        throw new C10462c("getBadgerReport failed, switch is off", -1, CollectStage.collect_finished, null, 8);
    }
}
