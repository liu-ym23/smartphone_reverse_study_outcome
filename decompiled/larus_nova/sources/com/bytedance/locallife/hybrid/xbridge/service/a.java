package com.bytedance.locallife.hybrid.xbridge.service;

import com.bytedance.ies.bullet.base.bridge.BDXCompatMethodFinderKt;
import com.bytedance.ies.bullet.base.bridge.q;
import com.bytedance.locallife.biz.common.utils.c;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends MethodFinder {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, b> f259089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, IDLXBridgeMethod> f259090e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m16.b f259091f;

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final String f() {
        return "bid_poi";
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final IDLXBridgeMethod h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
    L28:
        c.b("XBridge3MethodFinder", "### Load method by reflect failed, method name: " + r100);
    L29:
        return null;
    L4:
        if (this.f259089d.containsKey(r100) == false) goto L6;
    L7:
        c.a("LifeBridgeService", "localBridgeMap containsKey : " + r100);     // Catch: Throwable -> L28
        IDLXBridgeMethod r101 = this.f259090e.get(r100);     // Catch: Throwable -> L28
        if (r101 != null) goto L17;
        if (this.f259089d.containsKey(r100) == false) goto L17;
        b r102 = this.f259089d.get(r100);     // Catch: Throwable -> L28
        if (r102 == null) goto L17;
        IDLXBridgeMethod r103 = r102.a();     // Catch: Throwable -> L28
        if (r103 == null) goto L17;
        this.f259090e.put(r100, r103);     // Catch: Throwable -> L28
        r101 = r103;
    L17:
        if ((r101 instanceof q) == true) goto L19;
    L26:
        return r101;
    L19:
        if ((r101 instanceof q) == false) goto L21;
        q r104 = (q) r101;     // Catch: Throwable -> L28
    L22:
        if (r104 == null) goto L26;
        com.bytedance.ies.xbridge.IDLXBridgeMethod r105 = r104.f246301a;     // Catch: Throwable -> L28
        if (r105 == null) goto L26;
        r105.setProviderFactory(BDXCompatMethodFinderKt.a(this.f259091f));     // Catch: Throwable -> L28
        goto L26
    L21:
        r104 = null;
        goto L22
    L6:
        if (this.f259090e.containsKey(r100) == false) goto L29;
        goto L7
    }

    public a(Map<String, b> r100, Map<String, IDLXBridgeMethod> r101, m16.b r102) {
        Intrinsics.checkNotNullParameter(r100, "localBridgeMap");
        Intrinsics.checkNotNullParameter(r101, "cachedBridgeMap");
        Intrinsics.checkNotNullParameter(r102, "providerFactory");
        this.f259089d = r100;
        this.f259090e = r101;
        this.f259091f = r102;
    }
}
