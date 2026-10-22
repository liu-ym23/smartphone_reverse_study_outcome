package si5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.nova.R;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements NetService.c<ShareUserInfoResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f542238a;

    public c(String r100) {
        this.f542238a = r100;
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) throws NetService.ParseException {
        ArrayList<UserInfo> r101 = new ArrayList();
        JSONObject r102 = new JSONObject(r100).optJSONObject("data");     // Catch: JSONException -> L10
        JSONObject r103 = JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r102, "entities"), "users");     // Catch: JSONException -> L10
        JSONArray r104 = r102.optJSONArray(this.f542238a);     // Catch: JSONException -> L10
        if (r104 == null) goto L12;
        int r105 = 0;
    L7:
        if (r105 >= r104.length()) goto L12;
        a(r101, r103, r104, r105);     // Catch: JSONException -> L10
        r105 = r105 + 1;
    L12:
        ShareUserInfoResult r106 = new ShareUserInfoResult();
        r106.setUserInfoList(r101);
        return r106;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public static void a(ArrayList r100, JSONObject r101, JSONArray r102, int r103) throws JSONException {
        JSONObject r104 = JSONArrayProtectorUtils.getJSONObject(r102, r103);
        String r105 = r104.optString("owner_id");
        JSONObject r106 = r101.optJSONObject(r105);
        UserInfo r107 = new UserInfo();
        r107.setId(r105);
        r107.setName(r104.optString("owner_name"));
        r107.setAvatarUrl(r104.optString("avatar_url"));
        r107.setOwnerType(r104.optInt("owner_type"));
        r107.setInviter_id(r104.optString("inviter_id"));
        if (r104.optInt("is_owner") != 1) goto L5;
        boolean r108 = true;
    L6:
        r107.setOwner(r108);
        r107.setPermission(r104.optInt("perm", 1));
        r107.setExternal(r104.optBoolean("is_external"));
        r107.setCan_modify_perm(r104.optBoolean("can_modify_perm", false));
        int r109 = r107.getOwnerType();
        if (r109 == 0) goto L16;
        if (r109 != 1) goto L10;
        String r110 = r104.optString("group_description");
        if (TextUtils.isEmpty(r110) == false) goto L15;
        r110 = eu5.b.f474075a.getResources().getString(R.string.Doc_Contract_NoGroupDesc);
    L15:
        r107.setLabel(r110);
    L17:
        if (r106 == null) goto L19;
        r107.setCnName(r106.optString("cn_name"));
        r107.setEnName(r106.optString("en_name"));
        r107.setTenantName(r106.optString("tenant_name"));
        r107.setTenantId(r106.optString("tenant_id"));
    L19:
        r100.add(r107);
        return;
    L10:
        if (r109 != 17) goto L17;
    L16:
        r107.setLabel(r104.optString("department_name"));
        r107.setTenant_tag(r104.optString("tenant_tag"));
        r107.setIs_single_product(r104.optBoolean("is_single_product"));
        goto L17
    L5:
        r108 = false;
        goto L6
    }
}
