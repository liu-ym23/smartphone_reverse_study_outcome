package com.obric.assistant.provider.hybrid;

import android.os.Bundle;
import com.bytedance.ai.api.AppletExtService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes5.dex */
public final class l implements a {
    public l() {
    }

    @Override // com.obric.assistant.provider.hybrid.a
    public Bundle call(String r100, Bundle r101) {
        if (r101 == null) goto L8;
        AppletExtService r102 = (AppletExtService) ServiceManager.get().getService(AppletExtService.class);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.q(r101);
    L8:
        return null;
    }
}
