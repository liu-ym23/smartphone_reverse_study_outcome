package v25;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends a {
    public b() {
    }

    @Override // v25.a
    public final int a(String r2) {
        JSONObject r3 = JSON.parseObject(r2).getJSONObject("data");
        if (r3.getIntValue("code") == 0) goto L5;
        return -1;
    L5:
        return r3.getJSONObject("collab_client_vars").getIntValue("rev");
    }
}
