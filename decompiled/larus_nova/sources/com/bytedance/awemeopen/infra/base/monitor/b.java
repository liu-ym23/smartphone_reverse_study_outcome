package com.bytedance.awemeopen.infra.base.monitor;

import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements Function0<Unit> {
    public b() {
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        monitor-enter(AoMonitor.class);
        Iterator<AoMonitor.b> r100 = AoMonitor.f198649b.iterator();     // Catch: Throwable -> L37
    L6:
        if (r100.hasNext() == false) goto L33;
        AoMonitor.b r101 = r100.next();     // Catch: Throwable -> L37
        int r102 = AoMonitor.a.f198651a[r101.f198652a.ordinal()];     // Catch: Throwable -> L37
        if (r102 != 1) goto L10;
        o64.a r103 = AoMonitor.f198648a;     // Catch: Throwable -> L37
        String r104 = r101.f198653b;     // Catch: Throwable -> L37
        int r105 = r101.f198654c;     // Catch: Throwable -> L37
        JSONObject r106 = r101.f198655d;     // Catch: Throwable -> L37
        JSONObject r107 = r101.f198656e;     // Catch: Throwable -> L37
        SDKMonitor r108 = ((g64.a) r103).f480160a;     // Catch: Throwable -> L37
        if (r108 == null) goto L6;
        r108.monitorStatusAndDuration(r104, r105, r106, r107);     // Catch: Throwable -> L37
        goto L6
    L10:
        if (r102 != 2) goto L12;
        o64.a r109 = AoMonitor.f198648a;     // Catch: Throwable -> L37
        String r110 = r101.f198653b;     // Catch: Throwable -> L37
        int r111 = r101.f198654c;     // Catch: Throwable -> L37
        JSONObject r112 = r101.f198656e;     // Catch: Throwable -> L37
        SDKMonitor r113 = ((g64.a) r109).f480160a;     // Catch: Throwable -> L37
        if (r113 == null) goto L6;
        r113.monitorStatusRate(r110, r111, r112);     // Catch: Throwable -> L37
        goto L6
    L12:
        if (r102 != 3) goto L14;
        o64.a r114 = AoMonitor.f198648a;     // Catch: Throwable -> L37
        String r115 = r101.f198653b;     // Catch: Throwable -> L37
        JSONObject r116 = r101.f198655d;     // Catch: Throwable -> L37
        JSONObject r117 = r101.f198656e;     // Catch: Throwable -> L37
        SDKMonitor r118 = ((g64.a) r114).f480160a;     // Catch: Throwable -> L37
        if (r118 == null) goto L6;
        r118.monitorDuration(r115, r116, r117);     // Catch: Throwable -> L37
        goto L6
    L14:
        if (r102 != 4) goto L16;
        o64.a r119 = AoMonitor.f198648a;     // Catch: Throwable -> L37
        String r120 = r101.f198657f;     // Catch: Throwable -> L37
        JSONObject r121 = r101.f198656e;     // Catch: Throwable -> L37
        SDKMonitor r122 = ((g64.a) r119).f480160a;     // Catch: Throwable -> L37
        if (r122 == null) goto L6;
        r122.monitorCommonLog(r120, r121);     // Catch: Throwable -> L37
        goto L6
    L16:
        if (r102 != 5) goto L17;
        o64.a r123 = AoMonitor.f198648a;     // Catch: Throwable -> L37
        String r124 = r101.f198653b;     // Catch: Throwable -> L37
        JSONObject r125 = r101.f198658g;     // Catch: Throwable -> L37
        JSONObject r126 = r101.f198659h;     // Catch: Throwable -> L37
        JSONObject r127 = r101.f198656e;     // Catch: Throwable -> L37
        SDKMonitor r128 = ((g64.a) r123).f480160a;     // Catch: Throwable -> L37
        if (r128 == null) goto L6;
        r128.monitorEvent(r124, r125, r126, r127);     // Catch: Throwable -> L37
        goto L6
    L17:
        AoLogger.c("AoAppMonitor", new Object[]{"unknown report type"});     // Catch: Throwable -> L37
        goto L6
    L33:
        AoMonitor.f198649b.clear();     // Catch: Throwable -> L37
        AoMonitor.f198649b = null;     // Catch: Throwable -> L37
        monitor-exit(AoMonitor.class);
        return Unit.INSTANCE;
    L37:
        th = move-exception;
        throw th;
    }
}
