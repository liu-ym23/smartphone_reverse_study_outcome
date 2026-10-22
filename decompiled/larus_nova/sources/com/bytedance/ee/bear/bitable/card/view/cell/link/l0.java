package com.bytedance.ee.bear.bitable.card.view.cell.link;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class l0 implements NetService.c<LinkResult> {

    public static final class a {
    }

    static {
    }

    public l0() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
    L11:
        e = move-exception;
        tt5.a.e("LinkContentParser", "parse err ", e, false);
        throw new NetService.ParseException();
    L4:
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        JSONObject r101 = new JSONObject(r100).optJSONObject("data");     // Catch: Exception -> L11
        if (r101 != null) goto L9;
        r101 = new JSONObject();     // Catch: Exception -> L11
    L9:
        String r102 = r101.optString("offset");     // Catch: Exception -> L11
        boolean r103 = r101.optBoolean("hasMore");     // Catch: Exception -> L11
        String r104 = r101.optString("linkTableName", "");     // Catch: Exception -> L11
        LinkContent r105 = (LinkContent) JSON.parseObject(r101.optString("linkContent"), LinkContent.class);     // Catch: Exception -> L11
        return new LinkResult(r102, Boolean.valueOf(r103), r104, r105);
    }
}
