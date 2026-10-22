package com.bytedance.locallife.hybrid.bridge;

import android.content.Context;
import com.bytedance.locallife.biz.utils.ToastUtils;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e0 extends mt6.c {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return "showToast";
    }

    public e0() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, IDLXBridgeMethod.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Object r103 = r101.get("message");
        if ((r103 instanceof String) == false) goto L5;
        String r104 = (String) r103;
    L7:
        if (r104 != null) goto L9;
    L12:
        boolean r105 = true;
    L13:
        if (r105 == true) goto L17;
        Context r106 = ou6.b.f526748a.getContext(r100);
        if (r106 == null) goto L17;
        Lazy r107 = ToastUtils.f256981a;
        ToastUtils.a(r106, r104, 0);
    L17:
        b.c(r102, null);
        return;
    L9:
        if (r104.length() == 0) goto L12;
        r105 = false;
        goto L13
    L5:
        r104 = null;
        goto L7
    }
}
