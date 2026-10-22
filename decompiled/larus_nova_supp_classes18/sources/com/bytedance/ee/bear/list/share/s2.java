package com.bytedance.ee.bear.list.share;

import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s2 extends com.bytedance.ee.bear.list.u {
    public final boolean c;

    public s2() {
    }

    public s2(boolean r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.list.u
    public final void f(DocumentListInfo r2, JSONObject r3) {
        super.f(r2, r3);
        r2.setAll_visited(r3.optBoolean("all_visited"));
        r2.setHas_hidden(r3.optBoolean("has_hidden"));
    }

    @Override // com.bytedance.ee.bear.list.u
    public final Document d(JSONObject r1, JSONObject r2, JSONObject r3, boolean r4) {
        Document r5 = super.d(r1, r2, r3, true);
        if (r5 == null) goto L5;
        r5.o = r1.optString("share_time");
        r5.P0 = this.c;
    L5:
        return r5;
    }
}
