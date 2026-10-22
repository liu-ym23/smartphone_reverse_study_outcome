package com.bytedance.badger.network;

import android.os.SystemClock;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.e;
import com.bytedance.badger.j;
import com.bytedance.badger.monitor.CollectStage;
import com.bytedance.badger.monitor.TriggerStage;
import com.bytedance.badger.utils.C10462c;
import com.bytedance.badger.utils.n;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import java.nio.charset.Charset;
import kotlin.TypeCastException;
import kotlin.UInt;
import kotlin.jvm.functions.Function0;
import kotlin.text.Charsets;
import z64.i;

/* JADX INFO: loaded from: classes47.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z0 f199093a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z0 f199094b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile long f199095c;

    static {
        f199093a = new z0("collection", 1, 1);
        f199094b = new z0("upload", 2, 8);
    }

    public d0() {
    }

    public static z64.d a(int r100) {
        BadgerCore.Companion.getClass();
        String r101 = j.a().getDeviceId();
        int r102 = n.f199273a;     // Catch: Throwable -> L10
        Charset r103 = Charsets.UTF_8;     // Catch: Throwable -> L10
        if (r101 == null) goto L9;
        return new z64.d(UInt.m9590toStringimpl(UInt.m9544constructorimpl(n.a(r101.getBytes(r103)))), r100, r101, null, 24);
    L9:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        e.c("BadgerCustomReportHandler", "getBadgerRequest - failed to generate challenge key for scene " + r100 + ": " + th.getMessage(), th);
        return null;
    }

    public static void f(b r100, Function0 r101) {
        f199093a.a(new r(r101, r100));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        e(r100, th, "collectionThread - scheduling failed");
    }

    public static final void c(b r210) {
        BadgerCore.Companion.getClass();
        z64.b r100 = j.a().getBadgerReport(r210.f199074b, r210.f199081i);
        if (r100 == null) goto L15;
        if (r100.f570456b != 0) goto L13;
        com.bytedance.badger.monitor.c.a(com.bytedance.badger.monitor.c.f199044c, TriggerStage.custom, CollectStage.collect_finished, r210.f199074b, r100, 0, SystemClock.elapsedRealtime() - r210.f199079g, SystemClock.uptimeMillis() - r210.f199080h, null, null, r210.f199077e, r210.f199078f, null, 0, null, 14736);
        f199094b.a(new c0(new T(r210, r100), r210));     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        e(r210, th, "uploadThread - scheduling failed");
        return;
    L13:
        throw new C10462c("getBadgerReport failed,errorCode=" + r100.f570456b, SpeechEngineDefines.ERR_GET_DEVICEID_FAILED, CollectStage.collect_finished, j.a().getLastCollectError());
    L15:
        throw new C10462c("Switch is off for scene " + r210.f199073a, 0, null, null, 14);
    }

    public static void e(b r210, Throwable r211, String r212) {
        e.c("BadgerCustomReportHandler", r212 + " - " + r211.getMessage(), r211);
        r210.f199075c.a(new i.a(r211, r211 instanceof C10462c, r210.f199076d));
        com.bytedance.badger.monitor.c r100 = com.bytedance.badger.monitor.c.f199044c;
        TriggerStage r101 = TriggerStage.custom;
        z64.c r110 = r210.f199074b;
        boolean r111 = r210.f199077e;
        com.bytedance.badger.monitor.c.b(r100, r101, r211, 0, null, 0, SystemClock.elapsedRealtime() - r210.f199079g, SystemClock.uptimeMillis() - r210.f199080h, r110, null, r111, r210.f199078f, null, null, 6428);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v5 */
    public static void b(int r410, z64.h r411, z64.g r412, boolean r413) {
        BadgerCore.Companion.getClass();
        if (j.a().isInitialized() == true) goto L5;
        i.a r100 = new i.a(new C10462c("Badger is not initialized", -1001, null, null, 12), false);
    L8:
        r412.a(r100);
        return;
    L5:
        com.bytedance.badger.v.d.f199322f0.getClass();
        String r101 = com.bytedance.badger.v.d.g();
        if (r101 != 0) goto L40;
        r100 = new i.a(new C10462c("Badger is disabled", -1002, null, null, 12), false);
        goto L8
    L40:
        z64.d r110 = a(r410);     // Catch: Throwable -> L33
        if (r110 == null) goto L36;
        b r102 = new b(r410, r110, r412, null, false, 0, 0, 0, r413, 248);     // Catch: Throwable -> L31
        com.bytedance.badger.monitor.c.a(com.bytedance.badger.monitor.c.f199044c, TriggerStage.custom, CollectStage.collect_pre, r110, null, 0, 0, 0, null, null, false, 0, null, 0, r411, 6544);     // Catch: Throwable -> L31
        if ((r411 instanceof z64.h.c) == false) goto L20;
        e.f("BadgerCustomReportHandler", "handlePreload - scene: " + r102.f199073a);     // Catch: Throwable -> L37
        f(r102, new J(r102));     // Catch: Throwable -> L37
        return;
    L20:
        if ((r411 instanceof z64.h.d) == false) goto L23;
        ((z64.h.d) r411).getClass();     // Catch: Throwable -> L37
        e.f("BadgerCustomReportHandler", "handleTimeout - timeoutMs: 0, scene: " + r102.f199073a);     // Catch: Throwable -> L37
        f(r102, new L(r102, 0));     // Catch: Throwable -> L37
        return;
    L23:
        if ((r411 instanceof z64.h.e) == false) goto L26;
        int r103 = ((z64.h.e) r411).f570474a;     // Catch: Throwable -> L37
        e.f("BadgerCustomReportHandler", "handleTimeoutWithRetry - timeoutMs: " + r103 + ", scene: " + r102.f199073a);     // Catch: Throwable -> L37
        f(r102, new M(r102, r103));     // Catch: Throwable -> L37
        return;
    L26:
        if ((r411 instanceof z64.h.a) == false) goto L29;
        e.f("BadgerCustomReportHandler", "handleCompleteReport - scene: " + r102.f199073a);     // Catch: Throwable -> L37
        f(r102, new F(r102));     // Catch: Throwable -> L37
        return;
    L29:
        if ((r411 instanceof z64.h.b) == false) goto L49;
        e.f("BadgerCustomReportHandler", "handleGetReportAndReport - scene: " + r102.f199073a);     // Catch: Throwable -> L37
        f(r102, new G(r102));     // Catch: Throwable -> L37
        return;
    L49:
        return;
    L31:
        th = th;
        r101 = "BadgerCustomReportHandler";
    L38:
        e.c(r101, "doBadgerReport - failed for scene " + r410 + ": " + th.getMessage(), th);
        r412.a(new i.a(th, th instanceof C10462c));
        return;
    L36:
        throw new C10462c("Failed to generate badger request for scene " + r410, 0, null, null, 14);     // Catch: Throwable -> L37
    L37:
        th = th;
    L33:
        th = th;
        r101 = "BadgerCustomReportHandler";
        goto L38
    }

    public static void d(b r100, int r101, Function0 r102, Function0 r110, int r111) {
        if ((r111 & 4) == 0) goto L6;
        r102 = N.f199059a;
    L6:
        if ((r111 & 8) == 0) goto L9;
        r110 = O.f199060a;
    L9:
        if ((r111 & 16) == 0) goto L11;
        P r112 = P.f199061a;
    L13:
        if (r101 != 0) goto L15;
        e.f("BadgerCustomReportHandler", "handleUpdateResult - completed for scene: " + r100.f199073a);
        com.bytedance.badger.monitor.c.f199044c.getClass();
        com.bytedance.badger.monitor.c.e();
        r110.invoke();
        return;
    L15:
        if (r101 != 1) goto L17;
        e.f("BadgerCustomReportHandler", "handleUpdateResult - timeout for scene: " + r100.f199073a);
        r102.invoke();
        return;
    L17:
        e.e("BadgerCustomReportHandler", "handleUpdateResult - error: " + r101 + " for scene: " + r100.f199073a);
        r112.getClass();
        throw new C10462c("Badger update failed for scene " + r100.f199073a + " with code: " + r101, 0, null, null, 14);
    L11:
        r112 = null;
        goto L13
    }
}
