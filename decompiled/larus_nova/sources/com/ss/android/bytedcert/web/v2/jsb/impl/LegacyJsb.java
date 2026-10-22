package com.ss.android.bytedcert.web.v2.jsb.impl;

import com.ss.android.bytedcert.flow.cert.BytedCertFlow;
import com.ss.android.bytedcert.web.v2.jsb.AbsJsBridge;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.web.jsb.IBridgeContext;

/* JADX INFO: loaded from: classes34.dex */
public class LegacyJsb extends AbsJsBridge {
    private static final long serialVersionUID = 3057768368160164833L;
    private final BytedCertFlow mFlow;

    public LegacyJsb(BytedCertFlow r100) {
        this.mFlow = r100;
    }

    @Override // com.ss.android.cert.manager.web.jsb.IJsBridge
    public void invoke(IBridgeContext r100, Object... r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (BytedCertConstant.JsbKey.METHOD_TRACK_FLOW_ABILITY.equals((String) r101[0]) == false) goto L8;
        this.mFlow.getMonitorManager().a((String) r101[1]);
        return;
    }
}
