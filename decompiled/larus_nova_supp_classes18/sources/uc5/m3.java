package uc5;

import com.bytedance.ee.bear.contract.NetService;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m3 {
    public static boolean a(Throwable r4) {
        if (ax4.d.b(r4, 4) == true) goto L13;
    L12:
        return false;
    L13:
        if (new JSONObject(((NetService.ServerErrorException) r4).getData()).optInt("permission_status_code") != 10016) goto L15;
        return true;
    L15:
        return false;
    L10:
        e = move-exception;
        tt5.a.e("PermissionErrorHelper", "isForbiddenForPassword()...throwable = " + r4, e, false);
        goto L12
    }
}
