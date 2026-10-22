package xh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.permission.folder.FolderPublicPermissionV3;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptions;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements NetService.c<FolderPublicPermissionV3> {
    public j() {
    }

    public final Result parse(String r37) {
        Intrinsics.checkNotNullParameter(r37, "json");
        JSONObject r1 = new JSONObject(r37);
        int r0 = k.a;
        JSONObject r2 = r1.optJSONObject(WikiFolderPushPlugin.DATA);
        if (r2 != null) goto L5;
        r2 = new JSONObject();
    L5:
        JSONObject r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "dataObj");
        JSONObject r4 = r3.optJSONObject("perm_public");     // Catch: JSONException -> L19
        JSONObject r5 = r4.optJSONObject("block_options");     // Catch: JSONException -> L19
        boolean r6 = r3.optBoolean("is_owner", false);     // Catch: JSONException -> L19
        boolean r7 = r3.optBoolean("admin_can_cross", false);     // Catch: JSONException -> L19
        int r8 = r3.optInt("admin_external_access");     // Catch: JSONException -> L19
        boolean r9 = r3.optBoolean("can_unlock", false);     // Catch: JSONException -> L19
        boolean r10 = r3.optBoolean("is_share_folder", false);     // Catch: JSONException -> L19
        int r11 = r4.optInt("share_entity");     // Catch: JSONException -> L19
        int r12 = r4.optInt("manage_collaborator_entity");     // Catch: JSONException -> L19
        int r13 = r4.optInt("security_entity");     // Catch: JSONException -> L19
        int r14 = r4.optInt("comment_entity");     // Catch: JSONException -> L19
        int r15 = r4.optInt("link_share_entity_v2");     // Catch: JSONException -> L19
        boolean r16 = r4.optBoolean("has_modified_link_share", false);     // Catch: JSONException -> L19
        boolean r17 = r4.optBoolean("link_password_switch");     // Catch: JSONException -> L19
        String r18 = r4.optString("link_password");     // Catch: JSONException -> L19
        int r19 = r4.optInt("external_access_entity");     // Catch: JSONException -> L19
        int r110 = r4.optInt("share_external_entity");     // Catch: JSONException -> L19
        boolean r20 = r4.optBoolean("lock_switch");     // Catch: JSONException -> L19
        String r21 = r3.optString("tenant_name");     // Catch: JSONException -> L19
        if (r5 != null) goto L9;
        BlockOptions r22 = new BlockOptions(null, null, null, null, null, null, null, null, null, null, 1023, null);     // Catch: JSONException -> L19
    L10:
        BlockOptions r23 = r22;
        if (r5 != null) goto L13;
        BlockOptionsV2 r24 = new BlockOptionsV2(null, null, null, null, null, null, null, null, null, null, 1023, null);     // Catch: JSONException -> L19
    L14:
        BlockOptionsV2 r25 = r24;
        String r26 = r3.toString();     // Catch: JSONException -> L19
        if (r26 != null) goto L17;
        r26 = "";
    L17:
        return new FolderPublicPermissionV3(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r17, r18, r19, r110, r20, r21, r23, r25, r26, Boolean.valueOf(r16), Integer.valueOf(r4.optInt("visibility_status")));
    L13:
        r24 = k.d(r5);     // Catch: JSONException -> L19
        goto L14
    L9:
        r22 = k.c(r5);     // Catch: JSONException -> L19
    L19:
        e = move-exception;
        tt5.a.e("FolderPublicPermissionSupport", "parse()...json = " + r3, e, false);
        return new FolderPublicPermissionV3(false, false, 0, false, false, 0, 0, 0, 0, 0, false, null, 0, 0, false, null, null, null, null, null, null, 2097151, null);
    }
}
