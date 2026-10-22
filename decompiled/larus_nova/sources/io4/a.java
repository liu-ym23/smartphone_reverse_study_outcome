package io4;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.ss.android.lark.lynxkit.bridge.LarkLynxXBridgeMethod;

/* JADX INFO: loaded from: classes15.dex */
public abstract class a extends LarkLynxXBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XBridgeMethod.Access f495195a;

    public a() {
        this.f495195a = XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public XBridgeMethod.Access getAccess() {
        return this.f495195a;
    }
}
