package pu4;

import com.bytedance.ee.bear.bitable.share.permission.BitableSharePublicPermission;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements NetService.c<BitableSharePublicPermission> {
    public e() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r6) {
    L17:
        th = move-exception;
        tt5.a.e("BitableSharePermissionParser", "parsePublicPerm()...error", th, false);
        return new BitableSharePublicPermission(0, "");
    L4:
        if (r6 != null) goto L6;
        r6 = "";
    L6:
        JSONObject r3 = new JSONObject(r6);     // Catch: Throwable -> L17
        JSONObject r7 = r3.optJSONObject("data");     // Catch: Throwable -> L17
        if (r7 == null) goto L9;
        int r8 = r7.optInt("linkShareEntity");     // Catch: Throwable -> L17
    L10:
        JSONObject r0 = r3.optJSONObject("data");     // Catch: Throwable -> L17
        if (r0 == null) goto L14;
        String r1 = r0.toString();     // Catch: Throwable -> L17
        if (r1 == null) goto L14;
    L15:
        return new BitableSharePublicPermission(r8, r1);
    L14:
        r1 = "";
        goto L15
    L9:
        r8 = 0;
        goto L10
    }
}
