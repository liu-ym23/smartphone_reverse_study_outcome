package pu4;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class g implements NetService.c<ShareUserInfoResult> {
    public g() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r110) {
        if (r110 != null) goto L73;
        tt5.a.d("BitableSharePermissionParser", "parseCollaborators()...json is null");
        return new ShareUserInfoResult();
    L73:
        JSONObject r111 = new JSONObject(r110).optJSONObject("data");     // Catch: Throwable -> L70
        if (r111 == null) goto L9;
        JSONArray r100 = r111.optJSONArray("members");     // Catch: Throwable -> L70
    L10:
        if (r100 == null) goto L12;
        int r101 = r100.length();     // Catch: Throwable -> L70
    L13:
        ArrayList<UserInfo> r102 = new ArrayList();     // Catch: Throwable -> L70
        String r103 = "";
        if (r100 == null) goto L54;
        if (r101 <= 0) goto L54;
        int r104 = 0;
    L18:
        if (r104 >= r101) goto L54;
        JSONObject r105 = JSONArrayProtectorUtils.getJSONObject(r100, r104);     // Catch: Throwable -> L70
        UserInfo r106 = new UserInfo();     // Catch: Throwable -> L70
        r106.setOwnerType(r105.optInt("memberType"));     // Catch: Throwable -> L70
        String r112 = r105.optString("memberId");     // Catch: Throwable -> L70
        if (r112 != null) goto L22;
        r112 = "";
    L22:
        r106.setId(r112);     // Catch: Throwable -> L70
        r106.setPermission(r105.optInt("permission"));     // Catch: Throwable -> L70
        String r113 = r105.optString("memberName");     // Catch: Throwable -> L70
        if (r113 != null) goto L25;
        r113 = "";
    L25:
        r106.setName(r113);     // Catch: Throwable -> L70
        String r114 = r105.optString("memberDisplayName");     // Catch: Throwable -> L70
        if (r114 != null) goto L28;
        r114 = "";
    L28:
        r106.setDisplayName(r114);     // Catch: Throwable -> L70
        String r115 = r105.optString("avatarUrl");     // Catch: Throwable -> L70
        if (r115 != null) goto L31;
        r115 = "";
    L31:
        r106.setAvatarUrl(r115);     // Catch: Throwable -> L70
        if (r106.isUserType() == false) goto L38;
        String r116 = r105.optString("departmentName");     // Catch: Throwable -> L70
        if (r116 != null) goto L36;
        r116 = "";
    L36:
        r106.setLabel(r116);     // Catch: Throwable -> L70
    L43:
        String r117 = r105.optString("tenantName");     // Catch: Throwable -> L70
        if (r117 != null) goto L46;
        r117 = "";
    L46:
        r106.setTenantName(r117);     // Catch: Throwable -> L70
        String r118 = r105.optString("tenantId");     // Catch: Throwable -> L70
        if (r118 != null) goto L49;
        r118 = "";
    L49:
        r106.setTenantId(r118);     // Catch: Throwable -> L70
        r106.setOwner(r105.optBoolean("isOwner"));     // Catch: Throwable -> L70
        r106.setExternal(r105.optBoolean("isExternal"));     // Catch: Throwable -> L70
        JSONObject r107 = r105.optJSONObject("displayTag");     // Catch: Throwable -> L70
        if (r107 == null) goto L52;
        String r108 = r107.optString("tag_value");     // Catch: Throwable -> L70
    L53:
        r106.setOrganizationTagValue(r108);     // Catch: Throwable -> L70
        r102.add(r106);     // Catch: Throwable -> L70
        r104 = r104 + 1;     // Catch: Throwable -> L70
        goto L18
    L52:
        r108 = null;
        goto L53
    L38:
        if (r106.getOwnerType() != 2) goto L43;
        String r119 = r105.optString("groupDescription");     // Catch: Throwable -> L70
        if (r119 != null) goto L42;
        r119 = "";
    L42:
        r106.setLabel(r119);     // Catch: Throwable -> L70
    L54:
        ShareUserInfoResult r109 = new ShareUserInfoResult();     // Catch: Throwable -> L70
        r109.setUserInfoList(r102);     // Catch: Throwable -> L70
        if (r111 == null) goto L60;
        String r120 = r111.optString("lastLabel");     // Catch: Throwable -> L70
        if (r120 == null) goto L60;
        r103 = r120;
    L60:
        r109.setLastLabel(r103);     // Catch: Throwable -> L70
        if (r111 == null) goto L63;
        boolean r121 = r111.optBoolean("hasMore");     // Catch: Throwable -> L70
    L64:
        r109.setHasMore(r121);     // Catch: Throwable -> L70
        if (r111 == null) goto L67;
        int r122 = r111.optInt("totalNum");     // Catch: Throwable -> L70
    L68:
        r109.setTotalNum(r122);     // Catch: Throwable -> L70
        return r109;
    L67:
        r122 = 0;
        goto L68
    L63:
        r121 = false;
        goto L64
    L12:
        r101 = 0;
        goto L13
    L9:
        r100 = null;
    L70:
        th = move-exception;
        tt5.a.e("BitableSharePermissionParser", "parseCollaborators()...error", th, false);
        return new ShareUserInfoResult();
    }
}
