package com.bytedance.ies.bullet.base.bridge;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class k implements IDLXBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XBridgeMethod f246292a;

    public static final class a implements XBridgeMethod.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IDLXBridgeMethod.a f246293a;

        public a(IDLXBridgeMethod.a r100) {
            this.f246293a = r100;
        }

        @Override // com.bytedance.ies.xbridge.XBridgeMethod.Callback
        public final void invoke(Map<String, Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f246293a.invoke(r100);
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        XBridgeMethod r100 = this.f246292a;
        if ((r100 instanceof XCoreBridgeMethod) == true) goto L5;
        return false;
    L5:
        return ((XCoreBridgeMethod) r100).canRunInBackground();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        XBridgeMethod.Access r100 = this.f246292a.getAccess();
        Intrinsics.checkNotNullParameter(r100, "privilege");
        int r101 = j.a.f246290b[r100.ordinal()];
        if (r101 != 1) goto L5;
        IDLXBridgeMethod.Access r102 = IDLXBridgeMethod.Access.PUBLIC;
    L15:
        if (r102 == null) goto L17;
        return r102;
    L17:
        return IDLXBridgeMethod.Access.PRIVATE;
    L5:
        if (r101 != 2) goto L7;
        r102 = IDLXBridgeMethod.Access.PRIVATE;
        goto L15
    L7:
        if (r101 != 3) goto L9;
        r102 = IDLXBridgeMethod.Access.PROTECT;
        goto L15
    L9:
        if (r101 == 4) goto L11;
        r102 = null;
        goto L15
    L11:
        r102 = IDLXBridgeMethod.Access.SECURE;
        goto L15
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f246292a.getName();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Compatibility getCompatibility() {
        return IDLXBridgeMethod.Compatibility.Compatible;
    }

    public k(XBridgeMethod r100) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        this.f246292a = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, IDLXBridgeMethod.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        a r103 = new a(r102);     // Catch: Throwable -> L5
        XBridgeMethod r104 = this.f246292a;     // Catch: Throwable -> L5
        int r105 = com.bytedance.ies.xbridge.platform.web.a.f249528a;     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(r101, "map");     // Catch: Throwable -> L5
        r104.handle(new o66.d(com.bytedance.ies.xbridge.platform.web.a.d(r101)), r103, j.b(r100));     // Catch: Throwable -> L5
        return;
    }
}
