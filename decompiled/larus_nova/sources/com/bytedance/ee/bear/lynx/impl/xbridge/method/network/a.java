package com.bytedance.ee.bear.lynx.impl.xbridge.method.network;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class a<T extends Result> implements NetService.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T> f229965a = null;

    static {
        f229965a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
        ResponseJsonResult.a r101 = ResponseJsonResult.Companion;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "json");
        JSONObject r102 = new JSONObject(r100);
        ResponseJsonResult r103 = new ResponseJsonResult(r102);
        int r104 = r102.optInt("code");
        String r105 = r102.optString("msg", "");
        r103.code = r104;
        r103.msg = r105;
        return r103;
    }
}
