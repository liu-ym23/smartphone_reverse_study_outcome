package com.larus.init.task.firstframe;

import com.larus.audio.autotest.api.IAudioAutotestService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes4.dex */
public final class q implements m58.i {
    public q() {
    }

    @Override // m58.i
    public final boolean a() {
        IAudioAutotestService r100 = (IAudioAutotestService) ServiceManager.get().getService(IAudioAutotestService.class);
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.a();
    }

    @Override // m58.i
    public final String b() {
        IAudioAutotestService r100 = (IAudioAutotestService) ServiceManager.get().getService(IAudioAutotestService.class);
        if (r100 == null) goto L6;
        String r101 = r100.b();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // m58.i
    public final String c() {
        IAudioAutotestService r100 = (IAudioAutotestService) ServiceManager.get().getService(IAudioAutotestService.class);
        if (r100 == null) goto L6;
        String r101 = r100.c();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }
}
