package oo7;

import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class t {
    public static void a(kn7.b r100, ShareContent r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L8
        r102.put("platform", r100.f504258d);     // Catch: Exception -> L8
        r102.put("error", r100.f504255a);     // Catch: Exception -> L8
        r102.put("original_error_code", r100.f504256b);     // Catch: Exception -> L8
        r102.put("original_sub_error_code", r100.f504257c);     // Catch: Exception -> L8
        if (r101 == null) goto L5;
        r.a r103 = r101.getLogContext();     // Catch: Exception -> L8
    L6:
        r.c("share to platform finish", "share", r102, r103);     // Catch: Exception -> L8
        return;
    L5:
        r103 = null;
    }
}
