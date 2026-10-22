package com.larus.dora.impl.device.battery;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.util.r0;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes4.dex */
public final class f extends r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f333614a;

    public f(e r100) {
        this.f333614a = r100;
    }

    @Override // com.larus.dora.impl.util.r0, mj4.h
    public final void D(DoraDevice r110, int[] r111) {
        StringBuilder r100 = new StringBuilder("onChargeStateChanged: charge=");
        if (r111 == null) goto L5;
        String r101 = ArraysKt.joinToString$default(r111, null, null, null, 0, null, null, 63, null);
    L6:
        r100.append(r101);
        g49.d.d("DoraChargingCaseNotificationManager", r100.toString());
        e.a(this.f333614a, r110, o59.a.a(r110), r111);
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.dora.impl.util.r0, mj4.h
    public final void b0(DoraDevice r110, int[] r111) {
        StringBuilder r100 = new StringBuilder("onBatteryChanged: battery=");
        if (r111 == null) goto L5;
        String r101 = ArraysKt.joinToString$default(r111, null, null, null, 0, null, null, 63, null);
    L6:
        r100.append(r101);
        g49.d.d("DoraChargingCaseNotificationManager", r100.toString());
        e.a(this.f333614a, r110, r111, o59.a.b(r110));
        return;
    L5:
        r101 = null;
        goto L6
    }
}
