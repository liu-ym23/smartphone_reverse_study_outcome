package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.bmhome.code.IAiChatCodePreviewService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class m extends bx7.c {

    public static final class a {
    }

    static {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return "app.getCodeForPreview";
    }

    public m() {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r100, ux7.d.C7943d r101, IvyBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        String r103 = r100.getString("codeId");
        IAiChatCodePreviewService r104 = (IAiChatCodePreviewService) ServiceManager.get().getService(IAiChatCodePreviewService.class);
        String r105 = null;
        if (r104 == null) goto L5;
        String r106 = r104.b(r103);
    L6:
        IAiChatCodePreviewService r107 = (IAiChatCodePreviewService) ServiceManager.get().getService(IAiChatCodePreviewService.class);
        if (r107 == null) goto L10;
        r105 = r107.c(r103);
    L10:
        if (r106 != null) goto L12;
        int r108 = 0;
    L13:
        LinkedHashMap r109 = new LinkedHashMap();
        r109.put("result", Integer.valueOf(r108));
        if (r108 == 1) goto L16;
    L22:
        FLogger.f375446a.i("AppGetCodeForPreviewMethod", "app.getCodeForPreview codeId = " + r103 + " result = " + r108);
        bx7.c.d(this, r101, r109);
        return;
    L16:
        if (r106 != null) goto L18;
        r106 = "";
    L18:
        r109.put("code", r106);
        if (r105 != null) goto L21;
        r105 = "";
    L21:
        r109.put("language", r105);
        goto L22
    L12:
        r108 = 1;
        goto L13
    L5:
        r106 = null;
        goto L6
    }
}
