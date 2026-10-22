package com.bytedance.ee.bear.lynx.impl.xbridge;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends XCoreBridgeMethod {
    public final String a;

    public static final class a {
    }

    static {
    }

    public b() {
        this.a = "ccm.notifyWikiSpaceFilterChange";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r9, XBridgeMethod.Callback r10, XBridgePlatformType r11) {
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r10, "callback");
        Intrinsics.checkNotNullParameter(r11, ResourceData.KEY_TYPE);
        tt5.a.h("ccm-lynx: CCMNotifyWikiFilterChangeMethod", "handle.");
        String r12 = s.f(r9, "spaceTypeId", "");
        String r13 = s.f(r9, "spaceClassId", "");
        boolean r2 = false;
        if (r12.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
    L13:
        XCoreBridgeMethod.onFailure$default(this, r10, -3, "invalid params", null, 8, null);
        return;
    L8:
        if (r13.length() != 0) goto L10;
        r2 = true;
    L10:
        if (r2 == true) goto L13;
        ((com.bytedance.ee.bear.contract.route.parcelable.g) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.g.class, null, null, 6)).b(r12, r13);
        onSuccess(r10, new LinkedHashMap(), "");
        return;
    L5:
        r1 = false;
        goto L6
    }
}
