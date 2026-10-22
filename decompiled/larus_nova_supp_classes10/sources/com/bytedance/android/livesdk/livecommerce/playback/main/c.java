package com.bytedance.android.livesdk.livecommerce.playback.main;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final boolean a(String r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.length() <= 0) goto L6;
        return true;
    }

    public static String b(String r2) {
        Intrinsics.checkNotNullParameter("", "default");
        if (r2 == null) goto L5;
        return r2;
    L5:
        return "";
    }

    public static final JSONObject c(String r1) {
    L6:
        ECExceptionMonitor.c("json_format_error");
        return null;
    L3:
        if (a(r1) == false) goto L11;
        return new JSONObject(r1);
    L11:
        return null;
    }
}
