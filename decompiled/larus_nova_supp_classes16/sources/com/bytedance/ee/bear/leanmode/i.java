package com.bytedance.ee.bear.leanmode;

import com.bytedance.ee.bear.contract.leanmode.CCMConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i implements ww4.a {
    public i() {
    }

    @Override // ww4.a
    public final CCMConfig a() {
        CCMConfig r0 = (CCMConfig) h.a().a.getValue();
        if (r0 != null) goto L6;
        tt5.a.h("LeanModeManager", "getCCMConfig()... liveData is empty");
        return new CCMConfig();
    L6:
        return r0;
    }
}
