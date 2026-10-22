package com.suite.component.logger;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class d {
    public static final String a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map r101 = r100.f460130p;
        if (r101 != null) goto L7;
        r101 = MapsKt.emptyMap();
    L7:
        if (r101.isEmpty() == false) goto L10;
        return null;
    L10:
        return new JSONObject(r101).toString();
    }

    public static final void b(c r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        e r101 = r100.f460133s;
        if (r101 == null) goto L16;
        Intrinsics.checkNotNullParameter(r100, "logEntity");
        com.suite.component.logger.interceptor.b r102 = new com.suite.component.logger.interceptor.b(-1, r101.f460138b);
        r102.a(r101.f460137a, r100);     // Catch: Throwable -> L7 Exception -> L9
    L13:
        r100.a();
        return;
    L9:
        e = move-exception;
        com.suite.lark.component.logger.dynamic.a r103 = Log.f460091e;     // Catch: Throwable -> L7
        if (r103 == null) goto L13;
        r103.b(r100, e);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        r100.a();
        throw th;
    }
}
