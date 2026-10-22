package com.bytedance.ee.bear.bitable.load.workimpl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f214573a = 0;

    static {
    }

    public static void a(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (r101 != null) goto L5;
        r101 = new JSONObject();
    L5:
        r101.put("action", r100);
        tt5.a.h("CacheFabAnalytic", "reportPerformanceCacheFab: " + r101);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).u("base_mobile_performance_cache_fab", r101);
    }
}
