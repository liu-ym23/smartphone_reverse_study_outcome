package com.bytedance.ee.bear.bitable.lynx.pro;

import com.bytedance.ee.bear.share.export.UserInfo;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class c {
    public static final ArrayList<UserInfo> a(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "membersArrayObj");
        ArrayList<UserInfo> r101 = new ArrayList();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        JSONObject r104 = r100.optJSONObject(r103);
        UserInfo r105 = new UserInfo();
        r105.setAvatarUrl(r104.optString("memberAvatarUrl", ""));
        r105.setLabel(r104.optString("memberDepartmentName", ""));
        r105.setEnName(r104.optString("memberEnName", ""));
        r105.setId(r104.optString("memberId", ""));
        r105.setName(r104.optString("memberName", ""));
        r105.setCnName(r105.getName());
        r105.setOwnerType(r104.optInt("memberType", 0));
        r105.setDisplayName(r104.optString("memberDisplayName", ""));
        r105.setExternal(r104.optBoolean("isExternal"));
        JSONObject r106 = r104.optJSONObject("displayTag");
        if (r106 == null) goto L7;
        String r107 = r106.optString("tag_value");
    L8:
        r105.setOrganizationTagValue(r107);
        r101.add(r105);
        r103 = r103 + 1;
        goto L3
    L7:
        r107 = null;
        goto L8
    L9:
        return r101;
    }
}
