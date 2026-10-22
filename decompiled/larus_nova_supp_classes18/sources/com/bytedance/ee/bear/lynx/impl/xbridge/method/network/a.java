package com.bytedance.ee.bear.lynx.impl.xbridge.method.network;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a<T extends Result> implements NetService.c {
    public static final a<T> a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final Result parse(String r5) {
        ResponseJsonResult.a r0 = ResponseJsonResult.Companion;
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "json");
        JSONObject r1 = new JSONObject(r5);
        ResponseJsonResult r6 = new ResponseJsonResult(r1);
        int r2 = r1.optInt("code");
        String r3 = r1.optString("msg", "");
        ((Result) r6).code = r2;
        ((Result) r6).msg = r3;
        return r6;
    }
}
