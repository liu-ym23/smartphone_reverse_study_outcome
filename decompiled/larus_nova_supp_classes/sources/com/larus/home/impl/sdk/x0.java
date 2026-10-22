package com.larus.home.impl.sdk;

import com.larus.home.api.main.IPrivacyService;
import com.larus.platform.api.h3;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class x0 implements h3 {
    public static final x0 a = null;

    static {
        a = new x0();
    }

    public x0() {
    }

    @Override // com.larus.platform.api.h3
    public final boolean a() {
        IPrivacyService r0 = (IPrivacyService) ServiceManager.get().getService(IPrivacyService.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }
}
