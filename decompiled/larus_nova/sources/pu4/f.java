package pu4;

import com.bytedance.ee.bear.bitable.share.permission.BitableShareUserPermission;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements NetService.c<BitableShareUserPermission> {
    public f() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
    L12:
        th = move-exception;
        tt5.a.e("BitableSharePermissionParser", "parseUserPerm()...error", th, false);
        return new BitableShareUserPermission(false);
    L4:
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        JSONObject r101 = new JSONObject(r100).optJSONObject("data");     // Catch: Throwable -> L12
        if (r101 == null) goto L9;
        boolean r102 = r101.optBoolean("permitted");     // Catch: Throwable -> L12
    L10:
        return new BitableShareUserPermission(r102);
    L9:
        r102 = false;
        goto L10
    }
}
