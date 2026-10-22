package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.bmhome.code.IAiChatCodePreviewService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class x extends bx7.c {

    public static final class a {
    }

    static {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return "app.readyForCodePreview";
    }

    public x() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.StringBuilder] */
    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r100, ux7.d.C7943d r101, IvyBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        String r103 = r100.getString("codeId");
        boolean r104 = cx7.a.b(r100, "isSuccess", true);
        IAiChatCodePreviewService r105 = (IAiChatCodePreviewService) ServiceManager.get().getService(IAiChatCodePreviewService.class);
        if (r105 == null) goto L5;
        ?? r106 = r105.a(r103, r104);
    L6:
        LinkedHashMap r107 = new LinkedHashMap();
        r107.put("result", Integer.valueOf(r106));
        FLogger.f375446a.i("AppReadyForCodePreviewMethod", "app.readyForCodePreview codeId = " + r103 + " result = " + r106 + " isSuccess = " + r104);
        bx7.c.d(this, r101, r107);
        return;
    L5:
        r106 = 0;
        goto L6
    }
}
