package com.huawei.hms.framework.network.grs.local.model;

import android.text.TextUtils;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.huawei.hms.framework.common.Logger;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f277271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, c> f277272c;

    public a() {
        this.f277272c = new ConcurrentHashMap(16);
    }

    public c a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        Logger.w("ApplicationBean", "In getServing(String serviceName), the serviceName is Empty or null");
        return null;
    L7:
        return this.f277272c.get(r100);
    }

    public String a() {
        return this.f277270a;
    }

    public void a(long r100) {
        this.f277271b = r100;
    }

    public void a(String r100, c r101) {
        if (TextUtils.isEmpty(r100) == true) goto L7;
        if (r101 == null) goto L8;
        this.f277272c.put(r100, r101);
        return;
    L8:
        return;
    }

    public JSONObject b() {
        JSONObject r100 = new JSONObject();
        if (TextUtils.isEmpty(this.f277270a) == false) goto L5;
        String r101 = "";
    L6:
        r100.put("name", r101);
        r100.put("cacheControl", this.f277271b);
        JSONArray r102 = new JSONArray();
        Iterator<String> r103 = this.f277272c.keySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        c r104 = this.f277272c.get(r103.next());
        if (r104 == null) goto L8;
        r102.put(r104.c());
        goto L8
    L12:
        Logger.i("ApplicationBean", "local config save to sp, services count:" + r102.length());
        r100.put(PromotionProductPrivilegesStruct.SERVICES, r102);
        return r100;
    L5:
        r101 = this.f277270a;
        goto L6
    }

    public void b(String r100) {
        this.f277270a = r100;
    }
}
