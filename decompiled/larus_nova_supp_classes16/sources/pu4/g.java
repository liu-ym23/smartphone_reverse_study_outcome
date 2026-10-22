package pu4;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements NetService.c<ShareUserInfoResult> {
    public g() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r13) {
        if (r13 != null) goto L73;
        tt5.a.d("BitableSharePermissionParser", "parseCollaborators()...json is null");
        return new ShareUserInfoResult();
    L73:
        JSONObject r14 = new JSONObject(r13).optJSONObject("data");     // Catch: Throwable -> L70
        if (r14 == null) goto L9;
        JSONArray r3 = r14.optJSONArray("members");     // Catch: Throwable -> L70
    L10:
        if (r3 == null) goto L12;
        int r4 = r3.length();     // Catch: Throwable -> L70
    L13:
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L70
        String r6 = "";
        if (r3 == null) goto L54;
        if (r4 <= 0) goto L54;
        int r7 = 0;
    L18:
        if (r7 >= r4) goto L54;
        JSONObject r8 = JSONArrayProtectorUtils.getJSONObject(r3, r7);     // Catch: Throwable -> L70
        UserInfo r9 = new UserInfo();     // Catch: Throwable -> L70
        r9.setOwnerType(r8.optInt("memberType"));     // Catch: Throwable -> L70
        String r10 = r8.optString("memberId");     // Catch: Throwable -> L70
        if (r10 != null) goto L22;
        r10 = "";
    L22:
        r9.setId(r10);     // Catch: Throwable -> L70
        r9.setPermission(r8.optInt("permission"));     // Catch: Throwable -> L70
        String r11 = r8.optString("memberName");     // Catch: Throwable -> L70
        if (r11 != null) goto L25;
        r11 = "";
    L25:
        r9.setName(r11);     // Catch: Throwable -> L70
        String r12 = r8.optString("memberDisplayName");     // Catch: Throwable -> L70
        if (r12 != null) goto L28;
        r12 = "";
    L28:
        r9.setDisplayName(r12);     // Catch: Throwable -> L70
        String r16 = r8.optString("avatarUrl");     // Catch: Throwable -> L70
        if (r16 != null) goto L31;
        r16 = "";
    L31:
        r9.setAvatarUrl(r16);     // Catch: Throwable -> L70
        if (r9.isUserType() == false) goto L38;
        String r17 = r8.optString("departmentName");     // Catch: Throwable -> L70
        if (r17 != null) goto L36;
        r17 = "";
    L36:
        r9.setLabel(r17);     // Catch: Throwable -> L70
    L43:
        String r18 = r8.optString("tenantName");     // Catch: Throwable -> L70
        if (r18 != null) goto L46;
        r18 = "";
    L46:
        r9.setTenantName(r18);     // Catch: Throwable -> L70
        String r19 = r8.optString("tenantId");     // Catch: Throwable -> L70
        if (r19 != null) goto L49;
        r19 = "";
    L49:
        r9.setTenantId(r19);     // Catch: Throwable -> L70
        r9.setOwner(r8.optBoolean("isOwner"));     // Catch: Throwable -> L70
        r9.setExternal(r8.optBoolean("isExternal"));     // Catch: Throwable -> L70
        JSONObject r20 = r8.optJSONObject("displayTag");     // Catch: Throwable -> L70
        if (r20 == null) goto L52;
        String r21 = r20.optString("tag_value");     // Catch: Throwable -> L70
    L53:
        r9.setOrganizationTagValue(r21);     // Catch: Throwable -> L70
        r5.add(r9);     // Catch: Throwable -> L70
        r7 = r7 + 1;     // Catch: Throwable -> L70
        goto L18
    L52:
        r21 = null;
        goto L53
    L38:
        if (r9.getOwnerType() != 2) goto L43;
        String r110 = r8.optString("groupDescription");     // Catch: Throwable -> L70
        if (r110 != null) goto L42;
        r110 = "";
    L42:
        r9.setLabel(r110);     // Catch: Throwable -> L70
    L54:
        ShareUserInfoResult r2 = new ShareUserInfoResult();     // Catch: Throwable -> L70
        r2.setUserInfoList(r5);     // Catch: Throwable -> L70
        if (r14 == null) goto L60;
        String r22 = r14.optString("lastLabel");     // Catch: Throwable -> L70
        if (r22 == null) goto L60;
        r6 = r22;
    L60:
        r2.setLastLabel(r6);     // Catch: Throwable -> L70
        if (r14 == null) goto L63;
        boolean r23 = r14.optBoolean("hasMore");     // Catch: Throwable -> L70
    L64:
        r2.setHasMore(r23);     // Catch: Throwable -> L70
        if (r14 == null) goto L67;
        int r111 = r14.optInt("totalNum");     // Catch: Throwable -> L70
    L68:
        r2.setTotalNum(r111);     // Catch: Throwable -> L70
        return r2;
    L67:
        r111 = 0;
        goto L68
    L63:
        r23 = false;
        goto L64
    L12:
        r4 = 0;
        goto L13
    L9:
        r3 = null;
    L70:
        th = move-exception;
        tt5.a.e("BitableSharePermissionParser", "parseCollaborators()...error", th, false);
        return new ShareUserInfoResult();
    }
}
