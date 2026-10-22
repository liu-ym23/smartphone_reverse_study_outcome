package com.bytedance.android.shopping.api.mall.common.homepage.pagecard.monitor;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import kk.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class MallDeliveryMonitor$onStartDeliveryToSecondaryPage$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $isNightMode;
    final /* synthetic */ String $schema;
    final /* synthetic */ String $uuid;
    final /* synthetic */ MallDeliveryMonitor this$0;

    public MallDeliveryMonitor$onStartDeliveryToSecondaryPage$1(MallDeliveryMonitor r1, String r2, String r3, boolean r4) {
        this.this$0 = r1;
        this.$uuid = r2;
        this.$schema = r3;
        this.$isNightMode = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m197invoke() {
        MallDeliveryMonitor r0 = this.this$0;
        if (r0.g == null) goto L5;
        d.c(new MallDeliveryMonitor$unRegisterLifecycleCallback$1(r0, Boolean.TRUE));
    L5:
        MallDeliveryMonitor r1 = this.this$0;
        r1.g = new MallDeliveryMonitor.MallDeliveryLifecycleCallback(r1, this.$uuid, this.$schema, this.$isNightMode);
        MallDeliveryMonitor.MallDeliveryLifecycleCallback r2 = this.this$0.g;
        if (r2 == null) goto L14;
        Context r3 = HybridAppInfoService.p.getApplicationContext();
        if ((r3 instanceof Application) == true) goto L10;
        r3 = null;
    L10:
        Application r4 = (Application) r3;
        if (r4 == null) goto L15;
        r4.registerActivityLifecycleCallbacks(r2);
        return;
    L15:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m197invoke();
        return Unit.INSTANCE;
    }
}
