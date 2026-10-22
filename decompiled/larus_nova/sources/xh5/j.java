package xh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.permission.folder.FolderPublicPermissionV3;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptions;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class j implements NetService.c<FolderPublicPermissionV3> {
    public j() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r310) {
        Intrinsics.checkNotNullParameter(r310, "json");
        JSONObject r100 = new JSONObject(r310);
        int r101 = k.f563884a;
        JSONObject r102 = r100.optJSONObject("data");
        if (r102 != null) goto L5;
        r102 = new JSONObject();
    L5:
        JSONObject r103 = r102;
        Intrinsics.checkNotNullParameter(r103, "dataObj");
        JSONObject r104 = r103.optJSONObject("perm_public");     // Catch: JSONException -> L19
        JSONObject r105 = r104.optJSONObject("block_options");     // Catch: JSONException -> L19
        boolean r106 = r103.optBoolean("is_owner", false);     // Catch: JSONException -> L19
        boolean r107 = r103.optBoolean("admin_can_cross", false);     // Catch: JSONException -> L19
        int r108 = r103.optInt("admin_external_access");     // Catch: JSONException -> L19
        boolean r109 = r103.optBoolean("can_unlock", false);     // Catch: JSONException -> L19
        boolean r110 = r103.optBoolean("is_share_folder", false);     // Catch: JSONException -> L19
        int r111 = r104.optInt("share_entity");     // Catch: JSONException -> L19
        int r112 = r104.optInt("manage_collaborator_entity");     // Catch: JSONException -> L19
        int r113 = r104.optInt("security_entity");     // Catch: JSONException -> L19
        int r114 = r104.optInt("comment_entity");     // Catch: JSONException -> L19
        int r115 = r104.optInt("link_share_entity_v2");     // Catch: JSONException -> L19
        boolean r116 = r104.optBoolean("has_modified_link_share", false);     // Catch: JSONException -> L19
        boolean r117 = r104.optBoolean("link_password_switch");     // Catch: JSONException -> L19
        String r118 = r104.optString("link_password");     // Catch: JSONException -> L19
        int r119 = r104.optInt("external_access_entity");     // Catch: JSONException -> L19
        int r120 = r104.optInt("share_external_entity");     // Catch: JSONException -> L19
        boolean r210 = r104.optBoolean("lock_switch");     // Catch: JSONException -> L19
        String r211 = r103.optString("tenant_name");     // Catch: JSONException -> L19
        if (r105 != null) goto L9;
        BlockOptions r121 = new BlockOptions(null, null, null, null, null, null, null, null, null, null, 1023, null);     // Catch: JSONException -> L19
    L10:
        BlockOptions r212 = r121;
        if (r105 != null) goto L13;
        BlockOptionsV2 r122 = new BlockOptionsV2(null, null, null, null, null, null, null, null, null, null, 1023, null);     // Catch: JSONException -> L19
    L14:
        BlockOptionsV2 r213 = r122;
        String r123 = r103.toString();     // Catch: JSONException -> L19
        if (r123 != null) goto L17;
        r123 = "";
    L17:
        return new FolderPublicPermissionV3(r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r117, r118, r119, r120, r210, r211, r212, r213, r123, Boolean.valueOf(r116), Integer.valueOf(r104.optInt("visibility_status")));
    L13:
        r122 = k.d(r105);     // Catch: JSONException -> L19
        goto L14
    L9:
        r121 = k.c(r105);     // Catch: JSONException -> L19
    L19:
        e = move-exception;
        tt5.a.e("FolderPublicPermissionSupport", "parse()...json = " + r103, e, false);
        return new FolderPublicPermissionV3(false, false, 0, false, false, 0, 0, 0, 0, 0, false, null, 0, 0, false, null, null, null, null, null, null, 2097151, null);
    }
}
