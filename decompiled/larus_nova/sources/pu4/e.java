package pu4;

import com.bytedance.ee.bear.bitable.share.permission.BitableSharePublicPermission;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements NetService.c<BitableSharePublicPermission> {
    public e() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
    L17:
        th = move-exception;
        tt5.a.e("BitableSharePermissionParser", "parsePublicPerm()...error", th, false);
        return new BitableSharePublicPermission(0, "");
    L4:
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        JSONObject r101 = new JSONObject(r100);     // Catch: Throwable -> L17
        JSONObject r102 = r101.optJSONObject("data");     // Catch: Throwable -> L17
        if (r102 == null) goto L9;
        int r103 = r102.optInt("linkShareEntity");     // Catch: Throwable -> L17
    L10:
        JSONObject r104 = r101.optJSONObject("data");     // Catch: Throwable -> L17
        if (r104 == null) goto L14;
        String r105 = r104.toString();     // Catch: Throwable -> L17
        if (r105 == null) goto L14;
    L15:
        return new BitableSharePublicPermission(r103, r105);
    L14:
        r105 = "";
        goto L15
    L9:
        r103 = 0;
        goto L10
    }
}
