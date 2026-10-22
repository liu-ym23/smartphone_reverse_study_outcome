package com.bytedance.locallife.bridge.groupon.method;

import com.bytedance.android.locallife.core.service.LifeServiceManager;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "localLife.lifeGrouponCacheJSB", owner = "sunxinghang")
public final class l extends qo6.n {

    public static final class a {
    }

    static {
    }

    public l() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        qo6.n.b r113 = (qo6.n.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Number r114 = r113.getAction();
        ConcurrentHashMap<Class<?>, Object> r100 = LifeServiceManager.f162660a;
        ((wq6.a) LifeServiceManager.b(wq6.a.class)).h();
        boolean r101 = true;
        if (Intrinsics.areEqual(r114, 1) == false) goto L15;
        String r115 = r113.getCacheData();
        if (r115 != null) goto L7;
    L10:
        if (r101 == false) goto L12;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -100, "cacheData is null", null, 4, null);
        return;
    L12:
        r113.getSchema();
        r113.getCheckParams();
        r113.getKeyExtraParams();
        throw null;
    L7:
        if (r115.length() == 0) goto L10;
        r101 = false;
        goto L10
    L15:
        if (Intrinsics.areEqual(r114, 2) == false) goto L17;
        r113.getSchema();
        r113.getKeyExtraParams();
        throw null;
    L17:
        if (Intrinsics.areEqual(r114, -1) == false) goto L23;
        r113.getSchema();
        r113.getKeyExtraParams();
        throw null;
    }
}
