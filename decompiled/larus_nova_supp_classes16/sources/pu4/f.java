package pu4;

import com.bytedance.ee.bear.bitable.share.permission.BitableShareUserPermission;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements NetService.c<BitableShareUserPermission> {
    public f() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r4) {
    L12:
        th = move-exception;
        tt5.a.e("BitableSharePermissionParser", "parseUserPerm()...error", th, false);
        return new BitableShareUserPermission(false);
    L4:
        if (r4 != null) goto L6;
        r4 = "";
    L6:
        JSONObject r5 = new JSONObject(r4).optJSONObject("data");     // Catch: Throwable -> L12
        if (r5 == null) goto L9;
        boolean r6 = r5.optBoolean("permitted");     // Catch: Throwable -> L12
    L10:
        return new BitableShareUserPermission(r6);
    L9:
        r6 = false;
        goto L10
    }
}
