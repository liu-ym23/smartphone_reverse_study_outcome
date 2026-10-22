package com.huawei.hms.framework.network.grs.g;

import android.text.TextUtils;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class h {
    public static String a(String r100, String r101) {
        if (r100.equals(r101) == false) goto L5;
        return r100;
    L5:
        return b(r100, r101);
    }

    private static String b(String r100, String r101) {
        HashSet r102 = new HashSet();
        int r103 = 0;
        if (TextUtils.isEmpty(r100) == true) goto L9;
        JSONArray r104 = JSONObjectProtectorUtils.getJSONArray(new JSONObject(r100), PromotionProductPrivilegesStruct.SERVICES);
        int r105 = 0;
    L6:
        if (r105 >= r104.length()) goto L9;
        r102.add(JSONArrayProtectorUtils.getString(r104, r105));
        r105 = r105 + 1;
    L9:
        if (TextUtils.isEmpty(r101) == true) goto L15;
        JSONArray r106 = JSONObjectProtectorUtils.getJSONArray(new JSONObject(r101), PromotionProductPrivilegesStruct.SERVICES);
    L12:
        if (r103 >= r106.length()) goto L15;
        r102.add(JSONArrayProtectorUtils.getString(r106, r103));
        r103 = r103 + 1;
    L15:
        if (r102.isEmpty() == false) goto L18;
        return "";
    L18:
        JSONObject r107 = new JSONObject();
        JSONArray r108 = new JSONArray();
        Iterator r109 = r102.iterator();
    L20:
        if (r109.hasNext() == false) goto L22;
        r108.put((String) r109.next());
        goto L20
    L22:
        r107.put(PromotionProductPrivilegesStruct.SERVICES, r108);
        return r107.toString();
    }
}
