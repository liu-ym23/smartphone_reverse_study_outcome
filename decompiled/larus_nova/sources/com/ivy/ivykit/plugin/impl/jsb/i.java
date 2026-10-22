package com.ivy.ivykit.plugin.impl.jsb;

import android.content.Context;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.registry.core.RefType;
import com.lynx.tasm.LynxView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class i implements com.ivy.ivykit.api.bridge.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxBDXBridge f278395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f278396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f278397c;

    @Override // com.ivy.ivykit.api.bridge.g
    public final void release() {
        m16.b r100 = (m16.b) this.f278395a.D().getService(m16.b.class);
        if (r100 == null) goto L5;
        r100.h();
    L5:
        this.f278395a.A();
    }

    @Override // com.ivy.ivykit.api.bridge.g
    public final void a(LynxView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f278395a.E(r100);
        m16.b r101 = new m16.b();
        r101.g(Context.class, r100.getContext());
        r101.g(LynxView.class, r100);
        r101.g(XBridgeMethod.b.class, new d(r100));
        r101.g(IDLXBridgeMethod.b.class, new e(r100));
        this.f278395a.y(m16.b.class, r101, RefType.NORMAL);
        h r102 = new h(this, r100);
        this.f278395a.D().a(ue7.c.class, r102);
        r101.d(p56.b.class, new f(this));
        r101.d(ue7.c.class, r102);
        r101.d(h16.e.class, new g(this, r100));
        s26.d r103 = s26.d.f540305c;
        k16.b r104 = (k16.b) s26.d.f540305c.d(this.f278397c, k16.b.class);
        if (r104 == null) goto L15;
        ExecutorService r105 = BulletLogger.f247763a;
        BulletLogger.k("IvyLynxBridge, createMethodFinder from ".concat(r104.getClass().getName()), null, null, 6);
        List<MethodFinder> r106 = r104.L(r101);
        if (r106 == null) goto L10;
        LynxBDXBridge r107 = this.f278395a;
        Iterator<T> r108 = r106.iterator();
    L8:
        if (r108.hasNext() == false) goto L10;
        r107.d((MethodFinder) r108.next());
    L10:
        this.f278395a.d(new com.bytedance.ies.bullet.base.bridge.l(r101));
        if ((r104 instanceof k16.a) == false) goto L15;
        MethodFinder r109 = ((k16.a) r104).G0(r101);
        if (r109 == null) goto L15;
        this.f278395a.e(r109, 0);
    L15:
        this.f278395a.e(new l(), 0);
    }

    @Override // com.ivy.ivykit.api.bridge.g
    public final void b(Map r100) {
        Intrinsics.checkNotNullParameter("onFocusChange", "eventName");
        this.f278395a.a("onFocusChange", r100);
    }

    public i(LynxBDXBridge r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "bridge");
        Intrinsics.checkNotNullParameter(r101, "containerId");
        Intrinsics.checkNotNullParameter(r102, "bid");
        this.f278395a = r100;
        this.f278396b = r101;
        this.f278397c = r102;
    }
}
