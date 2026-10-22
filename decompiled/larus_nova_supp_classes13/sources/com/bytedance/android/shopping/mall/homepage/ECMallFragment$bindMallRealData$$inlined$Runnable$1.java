package com.bytedance.android.shopping.mall.homepage;

import com.bytedance.android.ec.hybrid.ECMallConfigs;
import com.bytedance.android.ec.hybrid.data.ECHybridDataEngine;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFragment$bindMallRealData$$inlined$Runnable$1 implements Runnable {
    public final /* synthetic */ ECMallFragment a;
    public final /* synthetic */ String b;

    public ECMallFragment$bindMallRealData$$inlined$Runnable$1(ECMallFragment r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        Lazy r0 = HybridAppInfoService.a;
        if (HybridAppInfoService.l() == true) goto L5;
    L14:
        final String r1 = this.a.Q;
        if (r1 != null) goto L20;
        ECMallFragment r2 = this.a;
        ECHybridDataEngine r3 = r2.P0;
        if (r3 == null) goto L19;
        r1 = r3.m(r2.k);
    L19:
        r1 = null;
    L20:
        if (r1 != null) goto L22;
        return;
    L22:
        if (Intrinsics.areEqual(this.b, "handle_init_data") == false) goto L28;
        ECMallFragment r4 = this.a;
        int r5 = ECMallFragment.h4;
        if (((Boolean) r4.G3.getValue()).booleanValue() == false) goto L28;
        if (this.a.H2 == false) goto L28;
        return;
    L28:
        ECMallFragment r6 = this.a;
        r6.da0(r6.k, r1, null, new ECMallFragment$bindMallRealData$$inlined$Runnable$1$lambda$1(r1, this));
        this.a.Q = null;
        return;
    L5:
        if (ECMallConfigs.INSTANCE.getLegouPrefetchFlowOptEnable() == false) goto L14;
        if (Intrinsics.areEqual(this.b, "handle_init_data") == false) goto L9;
        r1 = this.a.Q;
        goto L20
    L9:
        r1 = this.a.Q;
        if (r1 != null) goto L20;
        ECMallFragment r7 = this.a;
        ECHybridDataEngine r8 = r7.P0;
        if (r8 == null) goto L19;
        r1 = r8.m(r7.k);
        goto L20
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
