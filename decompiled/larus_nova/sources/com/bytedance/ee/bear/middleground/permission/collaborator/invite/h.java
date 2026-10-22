package com.bytedance.ee.bear.middleground.permission.collaborator.invite;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.byted.cast.common.CommonOptionConstants;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.middleground.permission.collaborator.NotNotifyUserEntity;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements NetService.c<InviteResult> {
    public h() {
    }

    public static InviteResult a(String r110) {
        InviteResult r100 = new InviteResult();
        JSONObject r101 = new JSONObject(r110);     // Catch: JSONException -> L53
        r100.msg = r101.optString("msg");     // Catch: JSONException -> L53
        r100.code = r101.optString("code");     // Catch: JSONException -> L53
        tt5.a.h("InviteParser", "InviteParser()...code = " + r100.code + ", msg = " + r100.msg);     // Catch: JSONException -> L53
        if (r101.isNull("data") == false) goto L6;
        JSONObject r111 = null;
    L7:
        if (r111 == null) goto L52;
        InviteData r102 = new InviteData();     // Catch: JSONException -> L53
        r100.data = r102;     // Catch: JSONException -> L53
        String r103 = r111.optString(DocViewModel.EXTRA_SPACE_ID);     // Catch: JSONException -> L53
        String r104 = r111.optString("link_token");     // Catch: JSONException -> L53
        if (TextUtils.isEmpty(r103) == true) goto L11;
        r102.spaceId = r103;     // Catch: JSONException -> L53
        r102.linkToken = r104;     // Catch: JSONException -> L53
    L11:
        JSONObject r105 = r111.optJSONObject("failCode_collaborator_map");     // Catch: JSONException -> L53
        if (r105 != null) goto L14;
    L16:
        boolean r106 = false;
    L17:
        r102.emailExceedLimit = r106;     // Catch: JSONException -> L53
        r102.setSuccessCount(r111.optInt("success_count"));     // Catch: JSONException -> L53
        r102.setFailCount(r111.optInt("fail_count"));     // Catch: JSONException -> L53
        JSONArray r107 = r111.optJSONArray("fail_owners");     // Catch: JSONException -> L53
        if (r107 == null) goto L27;
        ArrayList r108 = new ArrayList();     // Catch: JSONException -> L53
        int r109 = 0;
    L21:
        if (r109 >= r107.length()) goto L26;
        String r112 = r107.optString(r109);     // Catch: JSONException -> L53
        if (r112 == null) goto L25;
        r108.add(r112);     // Catch: JSONException -> L53
    L25:
        r109 = r109 + 1;     // Catch: JSONException -> L53
        goto L21
    L26:
        r102.setFailOwners(r108);     // Catch: JSONException -> L53
    L27:
        r102.notificationId = "";     // Catch: JSONException -> L53
        String r113 = r111.optString("not_notify_users");     // Catch: JSONException -> L53
        if (TextUtils.isEmpty(r113) == true) goto L30;
        r102.notNotifyUsers = JSON.parseArray(r113, NotNotifyUserEntity.class);     // Catch: JSONException -> L53
    L30:
        JSONObject r114 = r111.optJSONObject("block_notification_collaborator_map");     // Catch: JSONException -> L53
        if (r114 == null) goto L33;
        r102.notNotifyOrg = r114.has(String.valueOf(10045));     // Catch: JSONException -> L53
    L33:
        r102.limitNum = r111.optInt("limit_num");     // Catch: JSONException -> L53
        JSONObject r115 = r111.optJSONObject("block_user_map");     // Catch: JSONException -> L53
        JSONObject r116 = r111.optJSONObject("user_map");     // Catch: JSONException -> L53
        if (r115 == null) goto L45;
        if (r116 == null) goto L45;
        int r117 = a.f233189a;     // Catch: JSONException -> L53
        if (r115.optJSONArray(String.valueOf(10005)) == null) goto L39;
        int r118 = 10005;
    L40:
        r102.limitCode = r118;     // Catch: JSONException -> L53
        if (r115.optJSONArray(String.valueOf(10004)) == null) goto L43;
        int r119 = 10004;
    L44:
        r102.limitCodeByAdmin = r119;     // Catch: JSONException -> L53
        r102.blockUsers = a.d(10021, r115, r116);     // Catch: JSONException -> L53
        r102.blockedUsers = a.d(10022, r115, r116);     // Catch: JSONException -> L53
        r102.privacyUsers = a.d(10023, r115, r116);     // Catch: JSONException -> L53
        r102.addFailedUsers = a.d(10024, r115, r116);     // Catch: JSONException -> L53
        r102.limitUsers = a.d(CommonOptionConstants.OPTION_SET_SINK_DATA_LISTENER_AUDIO, r115, r116);     // Catch: JSONException -> L53
        r102.phoneLimitUsers = a.d(10026, r115, r116);     // Catch: JSONException -> L53
        r102.notPartnerTenantUsers = a.d(10043, r115, r116);     // Catch: JSONException -> L53
        goto L45
    L43:
        r119 = 0;
        goto L44
    L39:
        r118 = 0;
    L45:
        JSONObject r120 = r111.optJSONObject("failCode_collaborator_map");     // Catch: JSONException -> L53
        if (r120 == null) goto L48;
        r102.conditionControlUsers = a.d(2002, r120, r116);     // Catch: JSONException -> L53
        r102.dlpControlUsers = a.d(2005, r120, r116);     // Catch: JSONException -> L53
    L48:
        JSONObject r121 = r111.optJSONObject("fail_map");     // Catch: JSONException -> L53
        if (r121 == null) goto L52;
        if (r116 == null) goto L52;
        r102.limitCode = a.e(10005, r121);     // Catch: JSONException -> L53
        r102.limitCodeByAdmin = a.e(10004, r121);     // Catch: JSONException -> L53
        r102.notPartnerTenantUsers = a.b(10043, r121, r116);     // Catch: JSONException -> L53
        r102.limitCodeByConditionControl = a.e(2002, r121);     // Catch: JSONException -> L53
        r102.blockedCode = a.e(10022, r121);     // Catch: JSONException -> L53
        goto L52
    L14:
        if (r105.has(String.valueOf(14001)) == false) goto L16;
        r106 = true;
    L52:
        return r100;
    L6:
        r111 = r101.optJSONObject("data");     // Catch: JSONException -> L53
    L53:
        e = move-exception;
        tt5.a.f("InviteParser", e, false);
        return r100;
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final /* bridge */ /* synthetic */ Result parse(String r100) throws NetService.ParseException {
        return a(r100);
    }
}
