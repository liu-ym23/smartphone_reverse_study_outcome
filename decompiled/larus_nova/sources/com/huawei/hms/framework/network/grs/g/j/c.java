package com.huawei.hms.framework.network.grs.g.j;

import android.content.Context;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GrsBaseInfo f277256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f277257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<String> f277258c;

    public c(GrsBaseInfo r100, Context r101) {
        this.f277258c = new HashSet();
        this.f277256a = r100;
        this.f277257b = r101;
    }

    private String e() {
        Set<String> r100 = com.huawei.hms.framework.network.grs.f.b.a(this.f277257b.getPackageName()).b();
        if (r100.isEmpty() == false) goto L5;
        return "";
    L5:
        JSONObject r101 = new JSONObject();
        JSONArray r102 = new JSONArray();
        Iterator<String> r103 = r100.iterator();
    L7:
        if (r103.hasNext() == false) goto L13;
        r102.put(r103.next());
        goto L7
    L13:
        r101.put(PromotionProductPrivilegesStruct.SERVICES, r102);     // Catch: JSONException -> L12
        Logger.d("GrsRequestInfo", "post service list is:%s", new Object[]{r101.toString()});
        return r101.toString();
    L12:
        return "";
    }

    private String f() {
        Logger.v("GrsRequestInfo", "getGeoipService enter");
        JSONObject r100 = new JSONObject();
        JSONArray r101 = new JSONArray();
        Iterator<String> r102 = this.f277258c.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        r101.put(r102.next());
        goto L4
    L11:
        r100.put(PromotionProductPrivilegesStruct.SERVICES, r101);     // Catch: JSONException -> L9
        Logger.v("GrsRequestInfo", "post query service list is:%s", new Object[]{r100.toString()});
        return r100.toString();
    L9:
        return "";
    }

    public Context a() {
        return this.f277257b;
    }

    public void a(String r100) {
        this.f277258c.add(r100);
    }

    public GrsBaseInfo b() {
        return this.f277256a;
    }

    public String c() {
        if (this.f277258c.size() != 0) goto L7;
        return e();
    L7:
        return f();
    }

    public Set<String> d() {
        return this.f277258c;
    }
}
