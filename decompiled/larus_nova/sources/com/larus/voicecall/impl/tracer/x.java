package com.larus.voicecall.impl.tracer;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.utils.logger.FLogger;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class x {
    public static final Integer a(String r100) {
        if (r100 != null) goto L12;
        return null;
    L12:
        JSONObject r101 = new JSONObject(StringsKt.removePrefix(StringsKt.removePrefix(r100, "error: sami WebSocketStateChanged:"), "error: "));     // Catch: Throwable -> L9
        if (r101.has("statusCode") == false) goto L11;
        return Integer.valueOf(JSONObjectProtectorUtils.getInt(r101, "statusCode"));
    L11:
        return null;
    L9:
        th = move-exception;
        FLogger.f375446a.e("TRACER_HELPER", "getSubErrorCode on err! msg=" + th);
        goto L11
    }
}
