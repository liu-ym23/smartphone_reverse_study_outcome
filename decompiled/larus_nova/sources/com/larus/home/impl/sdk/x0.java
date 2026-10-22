package com.larus.home.impl.sdk;

import com.larus.home.api.main.IPrivacyService;
import com.larus.platform.api.h3;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes.dex */
public final class x0 implements h3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x0 f346267a = null;

    static {
        f346267a = new x0();
    }

    public x0() {
    }

    @Override // com.larus.platform.api.h3
    public final boolean a() {
        IPrivacyService r100 = (IPrivacyService) ServiceManager.get().getService(IPrivacyService.class);
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.a();
    }
}
