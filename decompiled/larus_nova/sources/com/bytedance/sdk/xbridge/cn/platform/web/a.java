package com.bytedance.sdk.xbridge.cn.platform.web;

import com.bytedance.sdk.xbridge.cn.protocol.g;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a extends com.bytedance.sdk.xbridge.cn.protocol.c<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WebPlatformDataProcessor f270029b;

    public a() {
        this.f270029b = new WebPlatformDataProcessor();
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.c
    public final g<JSONObject, JSONObject> c() {
        return this.f270029b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.c
    public final JSONObject b(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        JSONObject r102 = new JSONObject();
        r102.put("code", r100);
        r102.put("msg", r101);
        return r102;
    }
}
