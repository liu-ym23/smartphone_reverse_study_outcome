package com.larus.business.debug.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes26.dex */
public class NmtServiceInjector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NmtInjectService f319942a = null;

    public NmtServiceInjector() {
    }

    public static void clearCommonQueryParams() {
        NmtInjectService r100 = f319942a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.f();
    }

    public static void clearTestEnv() {
        NmtInjectService r100 = f319942a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.i();
    }

    public static void closeAppLogEtVerify() {
        NmtInjectService r100 = f319942a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.g();
    }

    public static void closeDebugFloatPanel() {
        NmtInjectService r100 = f319942a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.d();
    }

    public static void closeNetworkAnyDoor() {
        NmtInjectService r100 = f319942a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.a();
    }

    public static void openAppLogEtVerify() {
        NmtInjectService r100 = f319942a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.b();
    }

    public static void openNetworkAnyDoor() {
        NmtInjectService r100 = f319942a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.h();
    }

    public static void uploadAllALog() {
        NmtInjectService r100 = f319942a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.j();
    }

    static {
        f319942a = (NmtInjectService) ServiceManager.get().getService(NmtInjectService.class);
    }

    public static void addOrUpdateCommonQueryParams(String r100, String r101) {
        NmtInjectService r102 = f319942a;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.c(r100, r101);
    }

    public static void setTestEnv(String r100, String r101) {
        NmtInjectService r102 = f319942a;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.e(r100, r101);
    }
}
