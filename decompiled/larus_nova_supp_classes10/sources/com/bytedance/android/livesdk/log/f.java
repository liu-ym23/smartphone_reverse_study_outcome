package com.bytedance.android.livesdk.log;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        b0 r1 = b0.o();
        Intrinsics.checkNotNullParameter(r5, "eventName");
        if (StringsKt.startsWith$default(r5, "ttlive_logger_", false, 2, null) == true) goto L6;
        r5 = "ttlive_logger_".concat(r5);
    L6:
        r1.k(r5, r6);
    }
}
