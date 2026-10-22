package pu4;

import com.bytedance.ee.bear.bitable.share.permission.ShareTokenData;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements NetService.c<ShareTokenData> {
    public h() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r4) {
    L13:
        th = move-exception;
        tt5.a.e("BitableSharePermissionParser", "parseShareToken()...error", th, false);
        return new ShareTokenData(null, 1, null);
    L3:
        String r1 = "";
        if (r4 != null) goto L6;
        r4 = "";
    L6:
        JSONObject r5 = new JSONObject(r4).optJSONObject("data");     // Catch: Throwable -> L13
        if (r5 == null) goto L11;
        String r6 = r5.optString("shareToken");     // Catch: Throwable -> L13
        if (r6 == null) goto L11;
        r1 = r6;
    L11:
        return new ShareTokenData(r1);
    }
}
