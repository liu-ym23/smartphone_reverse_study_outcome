package com.bytedance.android.shopping.api.mall.common.homepage.pagecard.monitor;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class MallDeliveryMonitor$unRegisterLifecycleCallback$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Boolean $forceUnRegister;
    final /* synthetic */ MallDeliveryMonitor this$0;

    public MallDeliveryMonitor$unRegisterLifecycleCallback$1(MallDeliveryMonitor r1, Boolean r2) {
        this.this$0 = r1;
        this.$forceUnRegister = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m206invoke() {
        if (((Number) this.this$0.h.getValue()).intValue() != 1) goto L5;
    L6:
        MallDeliveryMonitor.MallDeliveryLifecycleCallback r0 = this.this$0.g;
        if (r0 == null) goto L14;
        Context r2 = HybridAppInfoService.p.getApplicationContext();
        if ((r2 instanceof Application) == true) goto L11;
        r2 = null;
    L11:
        Application r3 = (Application) r2;
        if (r3 == null) goto L14;
        r3.unregisterActivityLifecycleCallbacks(r0);
    L14:
        this.this$0.g = null;
        return;
    L5:
        if (Intrinsics.areEqual(this.$forceUnRegister, Boolean.TRUE) == true) goto L6;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m206invoke();
        return Unit.INSTANCE;
    }
}
