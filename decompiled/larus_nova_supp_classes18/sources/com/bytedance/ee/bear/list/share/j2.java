package com.bytedance.ee.bear.list.share;

import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j2 extends com.bytedance.ee.bear.list.u {
    public j2() {
    }

    @Override // com.bytedance.ee.bear.list.u
    public final Document d(JSONObject r1, JSONObject r2, JSONObject r3, boolean r4) {
        Document r5 = super.d(r1, r2, r3, true);
        if (r5 == null) goto L5;
        r5.o = r1.optString("share_time");
        r5.c = r1.optString(ResourceData.KEY_OBJ_TOKEN);
    L5:
        return r5;
    }
}
