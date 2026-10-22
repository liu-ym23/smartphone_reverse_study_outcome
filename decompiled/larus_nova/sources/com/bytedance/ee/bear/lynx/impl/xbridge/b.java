package com.bytedance.ee.bear.lynx.impl.xbridge;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f229913a;

    public static final class a {
    }

    static {
    }

    public b() {
        this.f229913a = "ccm.notifyWikiSpaceFilterChange";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f229913a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r110, XBridgePlatformType r111) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        Intrinsics.checkNotNullParameter(r111, "type");
        tt5.a.h("ccm-lynx: CCMNotifyWikiFilterChangeMethod", "handle.");
        String r112 = s.f(r100, "spaceTypeId", "");
        String r101 = s.f(r100, "spaceClassId", "");
        boolean r102 = false;
        if (r112.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
    L13:
        XCoreBridgeMethod.onFailure$default(this, r110, -3, "invalid params", null, 8, null);
        return;
    L8:
        if (r101.length() != 0) goto L10;
        r102 = true;
    L10:
        if (r102 == true) goto L13;
        ((com.bytedance.ee.bear.contract.route.parcelable.g) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.g.class, null, null, 6)).b(r112, r101);
        onSuccess(r110, new LinkedHashMap(), "");
        return;
    L5:
        r103 = false;
        goto L6
    }
}
