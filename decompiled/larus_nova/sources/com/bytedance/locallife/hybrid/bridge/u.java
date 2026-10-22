package com.bytedance.locallife.hybrid.bridge;

import android.text.TextUtils;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class u extends mt6.c {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return "minigameShow";
    }

    public u() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, IDLXBridgeMethod.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (TextUtils.isEmpty(String.valueOf(r101.get("schema"))) == true) goto L5;
        ((lz6.f) bs6.a.a().getGrouponDiamondService()).getClass();
        Intrinsics.checkNotNullParameter(BdpAppEventConstant.EVENT_MP_SHOW, "eventName");
        b.b(r102, "success");
        return;
    L5:
        b.a(r102, "schema is null");
    }
}
