package com.bytedance.ies.bullet.monitor.reliability;

import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.LoadStage;
import com.bytedance.ies.bullet.core.k;
import com.bytedance.salamander.anniex.SLEndToEndStage;
import com.bytedance.salamander.anniex.SLEndToEndStatus;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import i36.d;
import id7.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes19.dex */
@XBridgeMethod(name = "sendCustomPerfMetric", owner = "zhangjiangkun")
public final class b extends a {
    public b() {
        ConcurrentHashMap<Class<? extends IDLXBridgeMethod>, id7.b> r100 = e.f489350a;
        e.a(b.class, new id7.b(a.b.class, a.c.class));
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((a.b) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        m16.b r103 = (m16.b) r100.getService(m16.b.class);
        if (r103 == null) goto L7;
        h16.e r104 = (h16.e) r103.c(h16.e.class);
        if (r104 == null) goto L7;
        BulletContext r105 = r104.getBulletContext();
    L8:
        ia.c r106 = com.bytedance.android.anniex.lite.utils.c.e(r100);
        if (r106 == null) goto L11;
        Map<String, d> r107 = MonitorManager.f40977a;
        MonitorManager.Z(r106.getBid(), r106.getContainerId());
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(a.c.class)), null, 2, null);
        return;
    L11:
        if (r105 == null) goto L15;
        String r108 = r105.getSessionId();
        if (r108 == null) goto L15;
        SLMonitorCompat r109 = SLMonitorCompat.f41001a;
        SLEndToEndStage r110 = SLEndToEndStage.DataUpdate;
        SLEndToEndStatus r111 = SLEndToEndStatus.Success;
        r109.getClass();
        SLMonitorCompat.e(r108, r110, r111, null, null);
    L15:
        if (r105 == null) goto L17;
        com.bytedance.ies.bullet.core.e r112 = r105.f246455w;
        r112.getClass();
        Intrinsics.checkNotNullParameter("update", "<set-?>");
        r112.f246488p = "update";
        k r113 = r105.f246436d;
        LoadStage r114 = LoadStage.UPDATE;
        r113.getClass();
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r113.f246520f = r114;
        k r115 = r105.f246436d;
        r115.getClass();
        Intrinsics.checkNotNullParameter("data_update", "<set-?>");
        r115.f246521g = "data_update";
        h36.b.d(r105, "update");
        h36.b.e(r105);
    L17:
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(a.c.class)), null, 2, null);
        return;
    L7:
        r105 = null;
        goto L8
    }
}
