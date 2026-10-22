package com.bytedance.ee.bear.bitable.jsapi;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.jsapi.common.LocationHelper;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements LocationHelper.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f214434a;

    public f(m r100) {
        this.f214434a = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.jsapi.common.LocationHelper.c
    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        tt5.a.b("NewLarkForm", "reverseLocationSuccess response=" + r100);
        m r101 = this.f214434a;
        JSONObject r102 = new JSONObject();
        r102.put2("callbackType", "success");
        r102.put2("data", r100);
        r101.b(r102);
    }

    @Override // com.bytedance.ee.bear.bitable.jsapi.common.LocationHelper.c
    public final void b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        tt5.a.b("NewLarkForm", "reverseLocationError error=" + r100);
        m r101 = this.f214434a;
        JSONObject r102 = new JSONObject();
        r102.put2("callbackType", "failure");
        r102.put2("data", r100);
        r101.b(r102);
    }
}
