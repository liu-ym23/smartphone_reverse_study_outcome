package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.platform.IFlowMessageService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class t1 extends bx7.c {
    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return "app.notifyAuthResult";
    }

    public t1() {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r100, ux7.d.C7943d r101, IvyBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        String r103 = r100.getString("messageId");
        if (r103.length() != 0) goto L5;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L10;
        bx7.c.c(this, r101, -3, null, 12);
        return;
    L10:
        IFlowMessageService r105 = (IFlowMessageService) ServiceManager.get().getService(IFlowMessageService.class);
        if (r105 == null) goto L13;
        r105.g(r103, false, null, "");
    L13:
        bx7.c.d(this, r101, new LinkedHashMap());
        return;
    L5:
        r104 = false;
        goto L7
    }
}
