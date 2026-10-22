package com.bytedance.sdk.account.monitor;

import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final JSONObject a(Function0<? extends JSONObject> r100) {
        if (r100 == null) goto L7;
        JSONObject r101 = r100.invoke();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new JSONObject();
    }
}
