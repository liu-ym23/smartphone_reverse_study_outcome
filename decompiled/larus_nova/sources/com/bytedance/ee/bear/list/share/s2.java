package com.bytedance.ee.bear.list.share;

import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class s2 extends com.bytedance.ee.bear.list.u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f229529c;

    public s2() {
    }

    public s2(boolean r100) {
        this.f229529c = r100;
    }

    @Override // com.bytedance.ee.bear.list.u
    public final void f(DocumentListInfo r100, JSONObject r101) {
        super.f(r100, r101);
        r100.setAll_visited(r101.optBoolean("all_visited"));
        r100.setHas_hidden(r101.optBoolean("has_hidden"));
    }

    @Override // com.bytedance.ee.bear.list.u
    public final Document d(JSONObject r100, JSONObject r101, JSONObject r102, boolean r103) {
        Document r104 = super.d(r100, r101, r102, true);
        if (r104 == null) goto L5;
        r104.f227890o = r100.optString("share_time");
        r104.P0 = this.f229529c;
    L5:
        return r104;
    }
}
