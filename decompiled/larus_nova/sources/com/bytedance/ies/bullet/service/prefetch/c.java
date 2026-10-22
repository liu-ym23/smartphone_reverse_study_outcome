package com.bytedance.ies.bullet.service.prefetch;

import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.tools.prefetch.l;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, l> f248052a = null;

    static {
        f248052a = new LinkedHashMap();
    }

    public static l a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (StringsKt.contains$default(r100, "prefetch_business=lucky_page", false, 2, null) == false) goto L5;
        l r101 = (l) ((LinkedHashMap) f248052a).get("lucky_page");
    L6:
        ExecutorService r102 = BulletLogger.f247763a;
        BulletLogger.k("Get Processor: " + r101 + " For Url: " + r100, null, "XPreRender", 2);
        return r101;
    L5:
        r101 = null;
        goto L6
    }
}
