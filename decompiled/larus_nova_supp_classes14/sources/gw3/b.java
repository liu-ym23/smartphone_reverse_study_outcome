package gw3;

import android.content.ClipData;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.runtime.depend.g;
import com.bytedance.sdk.xbridge.cn.system.s;
import com.larus.home.impl.sdk.i1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.CoordinateType;
import com.larus.platform.model.LocateScene;
import com.larus.platform.service.m;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements g {
    public b() {
    }

    public final void d(Context r3, s.a r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "callback");
        m r5 = m.a;
        LocateScene r0 = LocateScene.APPLET;
        a r1 = new a(r4);
        r5.b(r0, CoordinateType.WGS_84, r1);
    }

    public final boolean a(Context r2, IBDXBridgeContext r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "bridgeName");
        IFlowSdkDepend r5 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r5 == null) goto L5;
        r5.d0();
        return i1.a.h(r2, "bpea-applet-frontend");
    L5:
        return false;
    }

    public final ClipData b(Context r2, IBDXBridgeContext r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "bridgeName");
        IFlowSdkDepend r5 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r5 == null) goto L5;
        r5.d0();
        return i1.a.e(r2, "bpea-applet-frontend");
    L5:
        return null;
    }

    public final Sensor c(SensorManager r2, IBDXBridgeContext r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "sensorManager");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "bridgeName");
        return r2.getDefaultSensor(15);
    }

    public final void e(Context r2, IBDXBridgeContext r3, String r4, ClipData r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "bridgeName");
        Intrinsics.checkNotNullParameter(r5, "clipData");
        IFlowSdkDepend r6 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r6 == null) goto L6;
        r6.d0();
        i1.a.i(r2, r5, "bpea-applet-frontend");
        return;
    }
}
