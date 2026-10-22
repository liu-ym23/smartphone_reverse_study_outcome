package com.bytedance.ee.bear.middleground.permission.collaborator.invite;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.collaborator.NotNotifyUserEntity;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocPermissionAction;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements NetService.c<InviteResult> {
    public h() {
    }

    public static InviteResult a(String r12) {
        InviteResult r4 = new InviteResult();
        JSONObject r6 = new JSONObject(r12);     // Catch: JSONException -> L53
        r4.msg = r6.optString("msg");     // Catch: JSONException -> L53
        r4.code = r6.optString("code");     // Catch: JSONException -> L53
        tt5.a.h("InviteParser", "InviteParser()...code = " + r4.code + ", msg = " + r4.msg);     // Catch: JSONException -> L53
        if (r6.isNull(WikiFolderPushPlugin.DATA) == false) goto L6;
        JSONObject r13 = null;
    L7:
        if (r13 == null) goto L52;
        InviteData r1 = new InviteData();     // Catch: JSONException -> L53
        r4.data = r1;     // Catch: JSONException -> L53
        String r3 = r13.optString("space_id");     // Catch: JSONException -> L53
        String r7 = r13.optString("link_token");     // Catch: JSONException -> L53
        if (TextUtils.isEmpty(r3) == true) goto L11;
        r1.spaceId = r3;     // Catch: JSONException -> L53
        r1.linkToken = r7;     // Catch: JSONException -> L53
    L11:
        JSONObject r5 = r13.optJSONObject("failCode_collaborator_map");     // Catch: JSONException -> L53
        if (r5 != null) goto L14;
    L16:
        boolean r8 = false;
    L17:
        r1.emailExceedLimit = r8;     // Catch: JSONException -> L53
        r1.setSuccessCount(r13.optInt("success_count"));     // Catch: JSONException -> L53
        r1.setFailCount(r13.optInt("fail_count"));     // Catch: JSONException -> L53
        JSONArray r9 = r13.optJSONArray("fail_owners");     // Catch: JSONException -> L53
        if (r9 == null) goto L27;
        ArrayList r10 = new ArrayList();     // Catch: JSONException -> L53
        int r11 = 0;
    L21:
        if (r11 >= r9.length()) goto L26;
        String r14 = r9.optString(r11);     // Catch: JSONException -> L53
        if (r14 == null) goto L25;
        r10.add(r14);     // Catch: JSONException -> L53
    L25:
        r11 = r11 + 1;     // Catch: JSONException -> L53
        goto L21
    L26:
        r1.setFailOwners(r10);     // Catch: JSONException -> L53
    L27:
        r1.notificationId = "";     // Catch: JSONException -> L53
        String r15 = r13.optString("not_notify_users");     // Catch: JSONException -> L53
        if (TextUtils.isEmpty(r15) == true) goto L30;
        r1.notNotifyUsers = JSON.parseArray(r15, NotNotifyUserEntity.class);     // Catch: JSONException -> L53
    L30:
        JSONObject r16 = r13.optJSONObject("block_notification_collaborator_map");     // Catch: JSONException -> L53
        if (r16 == null) goto L33;
        r1.notNotifyOrg = r16.has(String.valueOf(10045));     // Catch: JSONException -> L53
    L33:
        r1.limitNum = r13.optInt("limit_num");     // Catch: JSONException -> L53
        JSONObject r17 = r13.optJSONObject("block_user_map");     // Catch: JSONException -> L53
        JSONObject r18 = r13.optJSONObject("user_map");     // Catch: JSONException -> L53
        if (r17 == null) goto L45;
        if (r18 == null) goto L45;
        int r19 = a.a;     // Catch: JSONException -> L53
        if (r17.optJSONArray(String.valueOf(10005)) == null) goto L39;
        int r110 = 10005;
    L40:
        r1.limitCode = r110;     // Catch: JSONException -> L53
        if (r17.optJSONArray(String.valueOf(10004)) == null) goto L43;
        int r111 = 10004;
    L44:
        r1.limitCodeByAdmin = r111;     // Catch: JSONException -> L53
        r1.blockUsers = a.d(10021, r17, r18);     // Catch: JSONException -> L53
        r1.blockedUsers = a.d(10022, r17, r18);     // Catch: JSONException -> L53
        r1.privacyUsers = a.d(10023, r17, r18);     // Catch: JSONException -> L53
        r1.addFailedUsers = a.d(10024, r17, r18);     // Catch: JSONException -> L53
        r1.limitUsers = a.d(10025, r17, r18);     // Catch: JSONException -> L53
        r1.phoneLimitUsers = a.d(10026, r17, r18);     // Catch: JSONException -> L53
        r1.notPartnerTenantUsers = a.d(10043, r17, r18);     // Catch: JSONException -> L53
        goto L45
    L43:
        r111 = 0;
        goto L44
    L39:
        r110 = 0;
    L45:
        JSONObject r0 = r13.optJSONObject("failCode_collaborator_map");     // Catch: JSONException -> L53
        if (r0 == null) goto L48;
        r1.conditionControlUsers = a.d(2002, r0, r18);     // Catch: JSONException -> L53
        r1.dlpControlUsers = a.d(DocPermissionAction.ERROR_DLP_INNER_SHARE_DETECTED_CODE, r0, r18);     // Catch: JSONException -> L53
    L48:
        JSONObject r112 = r13.optJSONObject("fail_map");     // Catch: JSONException -> L53
        if (r112 == null) goto L52;
        if (r18 == null) goto L52;
        r1.limitCode = a.e(10005, r112);     // Catch: JSONException -> L53
        r1.limitCodeByAdmin = a.e(10004, r112);     // Catch: JSONException -> L53
        r1.notPartnerTenantUsers = a.b(10043, r112, r18);     // Catch: JSONException -> L53
        r1.limitCodeByConditionControl = a.e(2002, r112);     // Catch: JSONException -> L53
        r1.blockedCode = a.e(10022, r112);     // Catch: JSONException -> L53
        goto L52
    L14:
        if (r5.has(String.valueOf(14001)) == false) goto L16;
        r8 = true;
    L52:
        return r4;
    L6:
        r13 = r6.optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: JSONException -> L53
    L53:
        e = move-exception;
        tt5.a.f("InviteParser", e, false);
        return r4;
    }

    public final /* bridge */ /* synthetic */ Result parse(String r1) throws NetService.ParseException {
        return a(r1);
    }
}
