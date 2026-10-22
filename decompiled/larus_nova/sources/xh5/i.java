package xh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.permission.folder.FolderPublicPermissionV1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class i implements NetService.c<FolderPublicPermissionV1> {

    public static final class a {
    }

    static {
    }

    public i() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r110) {
        Intrinsics.checkNotNullParameter(r110, "json");
        JSONObject r100 = new JSONObject(r110).optJSONObject("data");     // Catch: JSONException -> L9
        boolean r101 = r100.optBoolean("is_owner", false);     // Catch: JSONException -> L9
        boolean r102 = r100.optBoolean("admin_allow_cross", false);     // Catch: JSONException -> L9
        boolean r103 = r100.optBoolean("allow_cross_tenant", false);     // Catch: JSONException -> L9
        boolean r104 = r100.optBoolean("exist_password", false);     // Catch: JSONException -> L9
        String r105 = r100.optString("password", "");     // Catch: JSONException -> L9
        int r106 = r100.optInt("link_perm", 0);     // Catch: JSONException -> L9
        String r107 = r100.toString();     // Catch: JSONException -> L9
        if (r107 != null) goto L6;
        String r111 = "";
    L7:
        return new FolderPublicPermissionV1(r101, r102, r103, r104, r105, r106, r111);
    L6:
        r111 = r107;
    L9:
        e = move-exception;
        tt5.a.e("FolderPublicPermissionParserV1", "parse()...json = " + r110, e, false);
        return new FolderPublicPermissionV1(false, false, false, false, null, 0, null, 127, null);
    }
}
