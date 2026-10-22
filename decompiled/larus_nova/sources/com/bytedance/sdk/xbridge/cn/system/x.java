package com.bytedance.sdk.xbridge.cn.system;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.startGyroscope")
public final class x extends ye7.c implements com.bytedance.sdk.xbridge.cn.protocol.h {
    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
        ze7.b.f571549a.a();
    }

    public x() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r110, CompletionBlock r111) {
        ye7.c.b r112 = (ye7.c.b) r110;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Number r113 = r112.getInterval();
        Activity r101 = r100.getOwnerActivity();
        if (r101 != null) goto L5;
        id7.c.a("obtaining context, but got a null.");
        CompletionBlock.DefaultImpls.onFailure$default(r111, 0, "context is null!!", null, 4, null);
        return;
    L5:
        ze7.b r102 = ze7.b.f571549a;
        int r114 = r113.intValue();
        String r103 = this.f567409a;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "bridgeName");
        r102.a();
        int r104 = 1;
        if (r114 >= 1) goto L8;
    L30:
        r111.onSuccess((XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(ye7.c.InterfaceC8336c.class)), "start gyroscope execute success.");
        return;
    L8:
        if (r114 > 1000) goto L30;
        Object r105 = r101.getSystemService(faceverify.w.BLOB_ELEM_TYPE_SENSOR);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.hardware.SensorManager");
        ze7.b.f571550b = (SensorManager) r105;
        Handler r106 = new Handler();
        ze7.b.f571551c = r106;
        ze7.a r107 = new ze7.a(r114);
        ze7.b.f571552d = r107;
        r106.post(r107);
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "bridgeName");
        int r108 = 1000 / r114;
        boolean r115 = false;
        if (r108 < 0) goto L14;
        if (r108 >= 10) goto L14;
        boolean r109 = true;
    L15:
        if (r109 == false) goto L17;
        r104 = 3;
    L23:
        SensorManager r116 = ze7.b.f571550b;
        if (r116 == null) goto L30;
        XBaseRuntime.f270095a.getClass();
        com.bytedance.sdk.xbridge.cn.runtime.depend.g r117 = XBaseRuntime.f270111q;
        if (r117 == null) goto L30;
        Sensor r118 = r117.c(r116, r100, r103);
        if (r118 == null) goto L30;
        r116.registerListener(r102, r118, r104);
        goto L30
    L17:
        if (10 <= r108) goto L19;
    L21:
        if (r115 == false) goto L23;
        r104 = 2;
        goto L23
    L19:
        if (r108 >= 30) goto L21;
        r115 = true;
    L14:
        r109 = false;
        goto L15
    }
}
