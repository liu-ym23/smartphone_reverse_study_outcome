package com.bytedance.ies.bullet.monitor.reliability;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.salamander.anniex.SLAnnieXMonitor;
import com.bytedance.salamander.anniex.j5;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import defpackage.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@XBridgeMethod(name = "x.getAnnieXMonitorData", owner = "zhangjiangkun")
public final class c extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f247452d = 0;

    public c() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, final CompletionBlock r110) {
        final e.b r102 = (e.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        m16.b r103 = (m16.b) r100.getService(m16.b.class);
        SLAnnieXMonitor r104 = null;
        if (r103 == null) goto L7;
        h16.e r105 = (h16.e) r103.c(h16.e.class);
        if (r105 == null) goto L7;
        BulletContext r106 = r105.getBulletContext();
    L8:
        if (r106 == null) goto L12;
        String r107 = r106.getSessionId();
        if (r107 == null) goto L12;
        r104 = j5.f268155j.a(r107);
    L12:
        if (r104 != null) goto L14;
        CompletionBlock.DefaultImpls.onFailure$default(r110, 0, "Get data failed.", null, 4, null);
        return;
    L14:
        r104.w(new XGetAnnieXMonitorDataMethod$handle$1(r110, this, r102));
        return;
    L7:
        r106 = null;
        goto L8
    }
}
