package pu4;

import com.bytedance.ee.bear.bitable.share.permission.ShareTokenData;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements NetService.c<ShareTokenData> {
    public h() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
    L13:
        th = move-exception;
        tt5.a.e("BitableSharePermissionParser", "parseShareToken()...error", th, false);
        return new ShareTokenData(null, 1, null);
    L3:
        String r101 = "";
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        JSONObject r102 = new JSONObject(r100).optJSONObject("data");     // Catch: Throwable -> L13
        if (r102 == null) goto L11;
        String r103 = r102.optString("shareToken");     // Catch: Throwable -> L13
        if (r103 == null) goto L11;
        r101 = r103;
    L11:
        return new ShareTokenData(r101);
    }
}
