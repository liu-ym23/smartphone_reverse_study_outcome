package com.bytedance.ee.bear.bitable.jsapi.common;

import android.app.Activity;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.jsapi.BitableJSApiErrorCode;
import com.bytedance.ee.bear.lark.dependency.r;
import com.ss.android.lark.location.dto.POIInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class o implements r.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocationHelper.a f214421a;

    public o(LocationHelper.a r100) {
        this.f214421a = r100;
    }

    @Override // com.bytedance.ee.bear.lark.dependency.r.a
    public final void a(Activity r100, POIInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (r101 == null) goto L13;
        LocationHelper.a r102 = this.f214421a;
        if (r101.getErrorCode() != 40400) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L10;
        tt5.a.h("NewLarkForm", "aMapDisable :true");
        goto L13
    L10:
        if (r102 == null) goto L17;
        JSONObject r104 = new JSONObject();
        r104.put2("name", r101.getLocationName());
        r104.put2("address", r101.getLocationAddress());
        r104.put2("latitude", Double.valueOf(r101.getLatitude()));
        r104.put2("longitude", Double.valueOf(r101.getLongitude()));
        r102.b(r104);
        return;
    L17:
        return;
    L7:
        r103 = false;
    L13:
        LocationHelper.a r105 = this.f214421a;
        if (r105 == null) goto L18;
        JSONObject r106 = new JSONObject();
        BitableJSApiErrorCode r107 = BitableJSApiErrorCode.UNKNOWN;
        r106.put2("errCode", Integer.valueOf(r107.getCode()));
        r106.put2("errMsg", r107.getErrMsg());
        r105.a(r106);
        return;
    }
}
