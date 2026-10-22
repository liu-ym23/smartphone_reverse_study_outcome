package com.ss.android.lark.watermark.userscope;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class ToolsV3Kt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f445331a = null;

    static {
        f445331a = LazyKt.lazy(ToolsV3Kt$securityComplianceInternalApi$2.INSTANCE);
    }

    public static final p4c.d a() {
        return (p4c.d) f445331a.getValue();
    }

    public static /* synthetic */ void c(String r100, Map r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 16) == 0) goto L8;
        r102 = 0;
    L8:
        b(r100, r101, null, null, r102);
    }

    public static final void b(String r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102, Map<String, ? extends Object> r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        p4c.d r103 = a();
        if (r103 == null) goto L6;
        r103.monitorEventV2(r100, r101, r102, r110, r111);
        return;
    }
}
