package com.larus.common.account.douyin;

import com.larus.utils.logger.FLogger;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class l implements Runnable {
    public /* synthetic */ l() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.common.account.douyin.m, java.lang.Runnable] */
    @Override // java.lang.Runnable
    public final void run() {
        sc7.a r100 = com.bytedance.sdk.account.impl.h.a().l();
        if (r100 == null) goto L11;
        Map<String, Map<String, cra.a>> r101 = r100.f541363d;
        if (r101 == null) goto L11;
        Map r102 = (Map) ((HashMap) r101).get("aweme_v2");
        if (r102 == null) goto L11;
        cra.a r103 = (cra.a) r102.get("8943");
        if (r103 == null) goto L11;
        long r104 = r103.f465127i;
    L12:
        long r105 = r104 - System.currentTimeMillis();
        if (r105 > 0) goto L15;
        FLogger.f375446a.w("DouyinOauthTokenRefreshScheduler", "illegal params found expireIn = " + r105 + ", Abort");
        return;
    L15:
        FLogger.f375446a.i("DouyinOauthTokenRefreshScheduler", "start schedule, expireIn = " + r105);
        n.a("reschedule");
        ?? r106 = new m();
        n.f326085a.postDelayed(r106, r105);
        n.f326086b = r106;
        return;
    L11:
        r104 = 0;
        goto L12
    }
}
