package com.bytedance.ee.bear.document.offline.sync;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.eenet.util.ComplexConnect;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class g extends f {
    public g() {
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.q
    public void f(AccountService$Account r3) {
        this.l = System.currentTimeMillis() + "00";
        this.k = "https://" + s45.p.u + PreloadConfigModel.GET_CLIENT_VARS + this.l;
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f
    public final boolean n(JSONObject r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        JSONObject r4 = r3.optJSONObject("data");
        if (r4 != null) goto L8;
        return false;
    L8:
        int r5 = r4.optInt("code", 0);
        this.h = r5;
        if (r5 != 0) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f
    public final Response p(OfflineDoc r4) {
        com.alibaba.fastjson.JSONObject r5 = l(r4.getObj_token(), f.m(r4), TextUtils.equals("tab_manual_offline", r4.getFrom_source()));
        com.alibaba.fastjson.JSONObject r0 = new com.alibaba.fastjson.JSONObject();
        r0.put("os", "Android");
        r0.put("os_version", Build.VERSION.RELEASE);
        r0.put("platform", this.c.getPlatform());
        r0.put("app_version", this.c.getVersionName());
        r5.put("context", r0);
        Request.Builder r6 = new Request.Builder().url(this.k).addHeader("EENet-Request-Enable-Complex-Connect", ComplexConnect.TRUE.toString()).addHeader("EENet-Request-Tag", "docs_preload_clientvar").post(RequestBody.create(MediaType.parse("application/json"), r5.toJSONString()));
        return this.b.g6(r6.build());
    }

    public final com.alibaba.fastjson.JSONObject r(k0 r7) {
        com.alibaba.fastjson.JSONObject r2 = new com.alibaba.fastjson.JSONObject();     // Catch: Exception -> L5
        r2.put("type", r7.getType());     // Catch: Exception -> L5
        com.alibaba.fastjson.JSONObject r3 = new com.alibaba.fastjson.JSONObject();     // Catch: Exception -> L5
        r3.put("member_id", r7.b.a);     // Catch: Exception -> L5
        r3.put("base_rev", Integer.valueOf(r7.b.b));     // Catch: Exception -> L5
        r3.put("version", Integer.valueOf(r7.b.c));     // Catch: Exception -> L5
        r3.put("type", r7.b.getType());     // Catch: Exception -> L5
        r3.put("token", r7.b.e);     // Catch: Exception -> L5
        r3.put("open_type", Integer.valueOf(r7.b.f));     // Catch: Exception -> L5
        r2.put("data", r3);     // Catch: Exception -> L5
        r2.put("version", Integer.valueOf(r7.c));     // Catch: Exception -> L5
        return r2;
    L5:
        e = move-exception;
        tt5.a.d(this.a, "consumeDoc()... e = " + e);
        return null;
    }
}
