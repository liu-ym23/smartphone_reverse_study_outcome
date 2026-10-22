package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor;

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
final class SecondaryPageGeneralCallback$unRegisterLifecycleGeneralCallback$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Boolean $forceUnRegister;

    public SecondaryPageGeneralCallback$unRegisterLifecycleGeneralCallback$1(Boolean r1) {
        this.$forceUnRegister = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m184invoke() {
        if (Intrinsics.areEqual(this.$forceUnRegister, Boolean.TRUE) == false) goto L14;
        MallDeliveryLifecycleGeneralCallback r0 = b.a;
        MallDeliveryLifecycleGeneralCallback r1 = b.a;
        if (r1 == null) goto L12;
        Context r2 = HybridAppInfoService.p.getApplicationContext();
        if ((r2 instanceof Application) == true) goto L9;
        r2 = null;
    L9:
        Application r3 = (Application) r2;
        if (r3 == null) goto L12;
        r3.unregisterActivityLifecycleCallbacks(r1);
    L12:
        b.a = null;
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m184invoke();
        return Unit.INSTANCE;
    }
}
