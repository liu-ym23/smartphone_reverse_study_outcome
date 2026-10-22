package com.bytedance.frameworks.baselib.network.http.ok3.impl.metadispatch;

import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.config.hostpathmatch.b;
import com.bytedance.frameworks.baselib.network.config.hostpathmatch.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TTMetaDispatchConfig extends b<TTMetaDispatchValue> {
    @Override // com.bytedance.frameworks.baselib.network.config.hostpathmatch.b
    public String getConfigRootKey() {
        return "ttnet_req_meta_dp";
    }

    public TTMetaDispatchConfig() {
    }

    private Map<String, String> parseMapConfig(JSONObject r100) {
        HashMap r101 = new HashMap();
        if (r100 != null) goto L5;
    L15:
        return r101;
    L5:
        if (r100.length() == 0) goto L15;
        Iterator<String> r102 = r100.keys();
    L9:
        if (r102.hasNext() == false) goto L15;
        String r103 = r102.next();
        String r104 = r100.optString(r103);
        if (TextUtils.isEmpty(r103) == true) goto L9;
        if (TextUtils.isEmpty(r104) == true) goto L9;
        r101.put(r103, r104);
        goto L9
    }

    @Override // com.bytedance.frameworks.baselib.network.config.hostpathmatch.b
    public TTMetaDispatchValue parseHostPathValue(Object r100) {
        if ((r100 instanceof JSONObject) == false) goto L5;
        JSONObject r101 = (JSONObject) r100;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        TTMetaDispatchValue r102 = new TTMetaDispatchValue();
        r102.queryAddMap = parseMapConfig(r101.optJSONObject("query_add"));
        r102.queryRmSet = parseJSONArrayToSet(r101.optJSONArray("query_rm"));
        r102.headerAddMap = parseMapConfig(r101.optJSONObject("header_add"));
        r102.headerRmSet = parseJSONArrayToSet(r101.optJSONArray("header_rm"));
        return r102;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.frameworks.baselib.network.config.hostpathmatch.b
    public /* bridge */ /* synthetic */ c parseHostPathValue(Object r100) {
        return parseHostPathValue(r100);
    }
}
