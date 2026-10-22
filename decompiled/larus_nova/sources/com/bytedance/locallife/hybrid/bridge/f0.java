package com.bytedance.locallife.hybrid.bridge;

import android.content.Intent;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f0 extends mt6.c {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return "uniAppInstalled";
    }

    public f0() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, IDLXBridgeMethod.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Object r103 = r101.get("packageName");
        String r104 = null;
        if ((r103 instanceof String) == false) goto L5;
        String r105 = (String) r103;
    L6:
        Object r106 = r101.get("openURL");
        if ((r106 instanceof String) == false) goto L9;
        r104 = (String) r106;
    L9:
        boolean r107 = false;
        if (r105 != null) goto L12;
    L15:
        boolean r108 = true;
    L16:
        if (r108 == false) goto L18;
    L19:
        if (r104 != null) goto L21;
    L24:
        boolean r109 = true;
    L25:
        if (r109 == true) goto L30;
        Intent r110 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        r110.setData(UriProtector.parse(r104));
        if (ou6.j.a(r110.toString()) == false) goto L30;
    L28:
        r107 = true;
    L30:
        if (r107 == false) goto L32;
        b.b(r102, "");
        return;
    L32:
        b.a(r102, "");
        return;
    L21:
        if (r104.length() == 0) goto L24;
        r109 = false;
        goto L25
    L18:
        if (ou6.j.a(r105) == true) goto L28;
    L12:
        if (r105.length() == 0) goto L15;
        r108 = false;
        goto L16
    L5:
        r105 = null;
        goto L6
    }
}
