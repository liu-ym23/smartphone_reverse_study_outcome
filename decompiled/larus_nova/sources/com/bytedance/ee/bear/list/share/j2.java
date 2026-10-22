package com.bytedance.ee.bear.list.share;

import com.bytedance.ee.bear.list.dto.Document;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class j2 extends com.bytedance.ee.bear.list.u {
    public j2() {
    }

    @Override // com.bytedance.ee.bear.list.u
    public final Document d(JSONObject r100, JSONObject r101, JSONObject r102, boolean r103) {
        Document r104 = super.d(r100, r101, r102, true);
        if (r104 == null) goto L5;
        r104.f227890o = r100.optString("share_time");
        r104.f227872c = r100.optString("obj_token");
    L5:
        return r104;
    }
}
