package com.bytedance.android.shopping.utils;

import android.text.TextUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(JSONObject r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "meta");
        if (r2 == null) goto L16;
    L11:
        e = move-exception;
        ECExceptionMonitor.f(e, "MetaUtil");
        return;
    L5:
        if ((!TextUtils.isEmpty(r2)) == false) goto L7;
        String r0 = r2;
    L8:
        if (r0 == null) goto L17;
        r1.put("entrance_info", r2);     // Catch: Exception -> L11
        return;
    L17:
        return;
    L7:
        r0 = null;
        goto L8
    }
}
