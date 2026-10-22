package com.bytedance.locallife.adapter.impl.host.location;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.ss.android.ugc.aweme.feed.model.NearbyCities;
import com.ss.android.ugc.aweme.feed.model.nearby.NearbyPageType;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kt6.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public class d implements f {
    public d() {
    }

    @Override // kt6.f
    public final void a() {
    }

    @Override // kt6.f
    public boolean b(String r100) {
        return false;
    }

    @Override // kt6.f
    public String d() {
        return "";
    }

    @Override // kt6.f
    public String e() {
        return "";
    }

    @Override // kt6.f
    public String c(NearbyPageType r100) {
        Intrinsics.checkNotNullParameter(r100, "pageType");
        NearbyCities.CityBean r101 = null;
        NearbyCities.CityBean r102 = c.b(r100);     // Catch: Exception -> L5
    L12:
        if (r102 != null) goto L14;
        r101 = c.a(r100);     // Catch: Exception -> L19
    L26:
        if (r101 != null) goto L28;
        return "";
    L28:
        if (r101.getCode() != null) goto L31;
        return "";
    L31:
        return r101.getCode();
    L19:
        e = move-exception;
        HashMap r103 = new HashMap();
        r103.put("poi_class_code", "");
        r103.put(LocationMonitorConst.ERR_MSG, "getCurrentCity:" + e.getMessage());
        JSONObject r104 = new JSONObject(r103);     // Catch: Exception -> L23
    L25:
        NearbyCities.CityBean r105 = c.f256462a;
        HostServiceUtilsKt.l().a(r104);
    L23:
        e = move-exception;
        e.printStackTrace();
        r104 = null;
        goto L25
    L14:
        if (r102.getCode() != null) goto L40;
        return "";
    L40:
        return r102.getCode();
    L5:
        e = move-exception;
        HashMap r106 = new HashMap();
        r106.put("poi_class_code", "");
        r106.put(LocationMonitorConst.ERR_MSG, "getSelectCity:" + e.getMessage());
        JSONObject r107 = new JSONObject(r106);     // Catch: Exception -> L9
    L11:
        NearbyCities.CityBean r108 = c.f256462a;
        HostServiceUtilsKt.l().a(r107);
        r102 = null;
    L9:
        e = move-exception;
        e.printStackTrace();
        r107 = null;
        goto L11
    }
}
