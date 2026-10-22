package com.bytedance.ies.bullet.base.bridge;

import com.bytedance.ies.xbridge.platform.web.WebPlatformDataProcessor;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public class q implements IDLXBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ies.xbridge.IDLXBridgeMethod f246301a;

    public static final class a implements com.bytedance.ies.xbridge.IDLXBridgeMethod.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IDLXBridgeMethod.a f246302a;

        public a(IDLXBridgeMethod.a r100) {
            this.f246302a = r100;
        }

        @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod.a
        public final void invoke(Map<String, ? extends Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f246302a.invoke(r100);
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        com.bytedance.ies.xbridge.IDLXBridgeMethod r100 = this.f246301a;
        if ((r100 instanceof v56.c) == false) goto L6;
        v56.c r101 = (v56.c) r100;
        r101.getClass();
        return r101 instanceof com.bytedance.locallife.bridge.common.method.i;
    L6:
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        com.bytedance.ies.xbridge.IDLXBridgeMethod.Access r100 = this.f246301a.getAccess();
        Intrinsics.checkNotNullParameter(r100, "privilege");
        int r101 = j.a.f246291c[r100.ordinal()];
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
        return this.f246301a.getName();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Compatibility getCompatibility() {
        return IDLXBridgeMethod.Compatibility.Compatible;
    }

    public q(com.bytedance.ies.xbridge.IDLXBridgeMethod r100) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        this.f246301a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, IDLXBridgeMethod.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        JSONObject r103 = new JSONObject(r101);
        Map<String, ? extends Object> r104 = new WebPlatformDataProcessor().h(r103, this.f246301a.getClass());
        if (r104 != null) goto L6;
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put("code", 0);
        r105.put("msg", "XBridge2 IDL 数据转换失败");
        r102.invoke(r105);
        return;
    L6:
        this.f246301a.d(r104, new a(r102), j.b(r100));
    }
}
