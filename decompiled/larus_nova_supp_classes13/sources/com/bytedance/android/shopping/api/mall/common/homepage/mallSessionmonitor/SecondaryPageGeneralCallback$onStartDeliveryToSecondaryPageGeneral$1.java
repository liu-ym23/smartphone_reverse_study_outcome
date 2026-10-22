package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor;

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
final class SecondaryPageGeneralCallback$onStartDeliveryToSecondaryPageGeneral$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $schema;

    public SecondaryPageGeneralCallback$onStartDeliveryToSecondaryPageGeneral$1(String r1) {
        this.$schema = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m183invoke() {
        if (b.a == null) goto L5;
        d.c(new SecondaryPageGeneralCallback$unRegisterLifecycleGeneralCallback$1(Boolean.TRUE));
    L5:
        MallDeliveryLifecycleGeneralCallback r0 = new MallDeliveryLifecycleGeneralCallback(this.$schema);
        b.a = r0;
        Context r1 = HybridAppInfoService.p.getApplicationContext();
        if ((r1 instanceof Application) == true) goto L8;
        r1 = null;
    L8:
        Application r2 = (Application) r1;
        if (r2 == null) goto L12;
        r2.registerActivityLifecycleCallbacks(r0);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m183invoke();
        return Unit.INSTANCE;
    }
}
