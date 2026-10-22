package com.larus.home.impl.sdk;

import com.larus.audio.autotest.api.IAudioAutotestService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes4.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f346266a = null;

    static {
        f346266a = new x();
    }

    public x() {
    }

    public final boolean a() {
        IAudioAutotestService r100 = (IAudioAutotestService) ServiceManager.get().getService(IAudioAutotestService.class);
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.a();
    }
}
