package com.bytedance.badger.network;

import android.os.SystemClock;
import com.bytedance.badger.monitor.CollectStage;
import com.bytedance.badger.monitor.TriggerStage;
import com.bytedance.badger.utils.C10462c;
import com.ss.bytertc.engine.aigc.AIGCSessionErrorCode;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Lambda;
import z64.i;

/* JADX INFO: loaded from: classes47.dex */
final class S extends Lambda implements Function6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ T f199065a;

    public S(T r100) {
        this.f199065a = r100;
        super(6);
    }

    @Override // kotlin.jvm.functions.Function6
    public Object invoke(Object r210, Object r211, Object r212, Object r213, Object r214, Object r215) {
        String r100 = (String) r211;
        a0 r101 = (a0) r212;
        b0 r102 = (b0) r213;
        l0 r103 = (l0) r214;
        com.bytedance.badger.C.a r104 = (com.bytedance.badger.C.a) r215;
        if (((Boolean) r210).booleanValue() == false) goto L6;
        z0 r105 = d0.f199093a;
        T r106 = this.f199065a;
        b r107 = r106.f199066a;
        z64.b r108 = r106.f199067b;
        r107.f199075c.a(new i.b(r100, r107.f199073a, r108.f570457c, r107.f199076d));
        com.bytedance.badger.monitor.c r109 = com.bytedance.badger.monitor.c.f199044c;
        TriggerStage r110 = TriggerStage.custom;
        CollectStage r111 = CollectStage.report_finished;
        z64.c r112 = r107.f199074b;
        boolean r113 = r107.f199077e;
        long r114 = r107.f199078f;
        com.bytedance.badger.monitor.c.a(r109, r110, r111, r112, r108, 0, SystemClock.elapsedRealtime() - r107.f199079g, SystemClock.uptimeMillis() - r107.f199080h, null, null, r113, r114, null, 0, null, 14736);
    L9:
        return Unit.INSTANCE;
    L6:
        if (r103.a() == false) goto L9;
        z0 r115 = d0.f199093a;
        d0.e(this.f199065a.f199066a, new C10462c("uploadReport failed", AIGCSessionErrorCode.AIGC_SESSION_ERROR_TIMEOUT_NO_BOT_JOIN_ROOM, CollectStage.report_finished, null, 8), "uploadReport - last attempt failed");
        goto L9
    }
}
