package com.bytedance.ee.bear.document.profile;

import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.lark.dependency.c0;
import org.json.JSONException;
import org.json.JSONObject;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements c0.a {
    public final /* synthetic */ m a;
    public final /* synthetic */ ShowProfilePlugin.a b;

    @Override // com.bytedance.ee.bear.lark.dependency.c0.a
    public final void onCancel() {
        if (ShowProfilePlugin.access$1000(this.b.a) == false) goto L13;
        m r0 = this.a;
        this.b.getClass();
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L7
        r1.put("id", "cancel");     // Catch: JSONException -> L7
        String r2 = r1.toString();     // Catch: JSONException -> L7
    L9:
        r0.onCallBack(r2);
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        r2 = "{}";
        goto L9
    }

    @Override // com.bytedance.ee.bear.lark.dependency.c0.a
    public final void onConfirm() {
        if (ShowProfilePlugin.access$800(this.b.a) == false) goto L13;
        m r0 = this.a;
        this.b.getClass();
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L7
        r1.put("id", TipCallBackData.CONFIRM);     // Catch: JSONException -> L7
        String r2 = r1.toString();     // Catch: JSONException -> L7
    L9:
        r0.onCallBack(r2);
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        r2 = "{}";
        goto L9
    }

    public b(ShowProfilePlugin.a r1, m r2) {
        this.b = r1;
        this.a = r2;
    }
}
