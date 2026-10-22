package xh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.permission.folder.FolderPublicPermissionV1;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements NetService.c<FolderPublicPermissionV1> {

    public static final class a {
    }

    static {
    }

    public i() {
    }

    public final Result parse(String r14) {
        Intrinsics.checkNotNullParameter(r14, "json");
        JSONObject r2 = new JSONObject(r14).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: JSONException -> L9
        boolean r4 = r2.optBoolean("is_owner", false);     // Catch: JSONException -> L9
        boolean r5 = r2.optBoolean("admin_allow_cross", false);     // Catch: JSONException -> L9
        boolean r6 = r2.optBoolean("allow_cross_tenant", false);     // Catch: JSONException -> L9
        boolean r7 = r2.optBoolean("exist_password", false);     // Catch: JSONException -> L9
        String r8 = r2.optString("password", "");     // Catch: JSONException -> L9
        int r9 = r2.optInt("link_perm", 0);     // Catch: JSONException -> L9
        String r3 = r2.toString();     // Catch: JSONException -> L9
        if (r3 != null) goto L6;
        String r10 = "";
    L7:
        return new FolderPublicPermissionV1(r4, r5, r6, r7, r8, r9, r10);
    L6:
        r10 = r3;
    L9:
        e = move-exception;
        tt5.a.e("FolderPublicPermissionParserV1", "parse()...json = " + r14, e, false);
        return new FolderPublicPermissionV1(false, false, false, false, null, 0, null, 127, null);
    }
}
