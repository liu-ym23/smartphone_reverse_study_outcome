package com.bytedance.sdk.xbridge.cn.auth;

import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;

/* JADX INFO: loaded from: classes22.dex */
public final class i {
    public static final IDLXBridgeMethod.Access a(String r100) {
        if (r100 == null) goto L27;
        switch(r100.hashCode()) {
            case -977423767: goto L23;
            case -906273929: goto L19;
            case -608539730: goto L15;
            case -314497661: goto L11;
            case -309012785: goto L7;
            default: goto L27;
        };
    L7:
        if (r100.equals("protect") == false) goto L27;
        return IDLXBridgeMethod.Access.PROTECT;
    L11:
        if (r100.equals(BridgePrivilege.PRIVATE) == false) goto L27;
        return IDLXBridgeMethod.Access.PRIVATE;
    L15:
        if (r100.equals("protected") == false) goto L27;
        return IDLXBridgeMethod.Access.PROTECT;
    L19:
        if (r100.equals("secure") == false) goto L27;
        return IDLXBridgeMethod.Access.SECURE;
    L23:
        if (r100.equals("public") == false) goto L27;
        return IDLXBridgeMethod.Access.PUBLIC;
    L27:
        return IDLXBridgeMethod.Access.PUBLIC;
    }
}
