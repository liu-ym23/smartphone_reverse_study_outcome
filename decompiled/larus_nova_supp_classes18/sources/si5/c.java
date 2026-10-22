package si5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements NetService.c<ShareUserInfoResult> {
    public final String a;

    public c(String r1) {
        this.a = r1;
    }

    public final Result parse(String r5) throws NetService.ParseException {
        ArrayList<UserInfo> r0 = new ArrayList();
        JSONObject r6 = new JSONObject(r5).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: JSONException -> L10
        JSONObject r1 = JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r6, "entities"), "users");     // Catch: JSONException -> L10
        JSONArray r7 = r6.optJSONArray(this.a);     // Catch: JSONException -> L10
        if (r7 == null) goto L12;
        int r2 = 0;
    L7:
        if (r2 >= r7.length()) goto L12;
        a(r0, r1, r7, r2);     // Catch: JSONException -> L10
        r2 = r2 + 1;
    L12:
        ShareUserInfoResult r8 = new ShareUserInfoResult();
        r8.setUserInfoList(r0);
        return r8;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public static void a(ArrayList r3, JSONObject r4, JSONArray r5, int r6) throws JSONException {
        JSONObject r7 = JSONArrayProtectorUtils.getJSONObject(r5, r6);
        String r8 = r7.optString("owner_id");
        JSONObject r9 = r4.optJSONObject(r8);
        UserInfo r0 = new UserInfo();
        r0.setId(r8);
        r0.setName(r7.optString("owner_name"));
        r0.setAvatarUrl(r7.optString("avatar_url"));
        r0.setOwnerType(r7.optInt("owner_type"));
        r0.setInviter_id(r7.optString("inviter_id"));
        if (r7.optInt("is_owner") != 1) goto L5;
        boolean r10 = true;
    L6:
        r0.setOwner(r10);
        r0.setPermission(r7.optInt("perm", 1));
        r0.setExternal(r7.optBoolean("is_external"));
        r0.setCan_modify_perm(r7.optBoolean("can_modify_perm", false));
        int r11 = r0.getOwnerType();
        if (r11 == 0) goto L16;
        if (r11 != 1) goto L10;
        String r12 = r7.optString("group_description");
        if (TextUtils.isEmpty(r12) == false) goto L15;
        r12 = eu5.b.a.getResources().getString(2131887636);
    L15:
        r0.setLabel(r12);
    L17:
        if (r9 == null) goto L19;
        r0.setCnName(r9.optString("cn_name"));
        r0.setEnName(r9.optString("en_name"));
        r0.setTenantName(r9.optString("tenant_name"));
        r0.setTenantId(r9.optString("tenant_id"));
    L19:
        r3.add(r0);
        return;
    L10:
        if (r11 != 17) goto L17;
    L16:
        r0.setLabel(r7.optString("department_name"));
        r0.setTenant_tag(r7.optString("tenant_tag"));
        r0.setIs_single_product(r7.optBoolean("is_single_product"));
        goto L17
    L5:
        r10 = false;
        goto L6
    }
}
