package com.ss.android.common.applog;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class l0 {
    public static void a(Object r100, String r101) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r101.concat("can not be null"));
    }

    public static long b(JSONObject r100, String r101) {
        return CastLongProtector.valueOf(r100.optString(r101)).longValue();
    L5:
        return 0;
    }
}
