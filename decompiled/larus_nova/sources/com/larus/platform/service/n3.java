package com.larus.platform.service;

import android.content.Context;
import com.bytedance.router.SmartRouter;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f365779a = 0;

    static {
    }

    public static void a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L14;
        FLogger.f375446a.i("UrlNavigationService", "openUrl skipped: blank url");
        return;
    L14:
        if (com.larus.utils.y0.e(r101) == false) goto L16;
        FLogger.f375446a.i("UrlNavigationService", "openUrl routeType=browser");
        q.f365787a.e(r100, com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", r101)}), null);
        return;
    L16:
        FLogger.f375446a.i("UrlNavigationService", "openUrl routeType=smart_router");
        SmartRouter.buildRoute(r100, r101).d();
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L10
    }
}
