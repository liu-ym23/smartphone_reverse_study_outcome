package v25;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends a {
    public b() {
    }

    @Override // v25.a
    public final int a(String r100) {
        JSONObject r101 = JSON.parseObject(r100).getJSONObject("data");
        if (r101.getIntValue("code") == 0) goto L5;
        return -1;
    L5:
        return r101.getJSONObject("collab_client_vars").getIntValue("rev");
    }
}
