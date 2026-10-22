package vl5;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends i {
    public String b;
    public boolean c;

    public c() {
        this.b = "";
        this.c = false;
    }

    @Override // vl5.i
    public final String a() {
        return this.b;
    }

    @Override // vl5.i
    public final void b(String r4) {
        this.a = r4;
        JSONObject r5 = JSON.parseObject(r4);     // Catch: Exception -> L12
        if (r5 != null) goto L6;
    L18:
    L15:
        if (this.b != null) goto L21;
        this.b = "";
        return;
    L21:
        return;
    L6:
        if (r5.containsKey("apiName") == false) goto L8;
        this.c = true;     // Catch: Exception -> L12
        goto L18
    L8:
        JSONObject r6 = r5.getJSONObject(WikiFolderPushPlugin.DATA).getJSONObject("header");     // Catch: Exception -> L12
        if (r6 == null) goto L18;
        this.b = r6.getString("requestId");     // Catch: Exception -> L12
    L12:
        e = move-exception;
        tt5.a.e("JSDocResponse", "parseJson exception", e, false);
        goto L15
    }
}
