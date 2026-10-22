package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.miui.easygo.constant.EasyGoConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class HiAnalyticsBase {
    public HiAnalyticsBase() {
    }

    public static Map<String, String> getMapForBi(Context r100, String r101) {
        HashMap r102 = new HashMap();
        if (r100 != null) goto L5;
    L10:
        return r102;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L10;
        String[] r103 = r101.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r103.length < 2) goto L10;
        String r104 = r103[0];
        String r105 = r103[1];
        r102.put("service", r104);
        r102.put("apiName", r105);
        r102.put("package", r100.getPackageName());
        r102.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.13.0.301");
        r102.put("callTime", String.valueOf(System.currentTimeMillis()));
        goto L10
    }
}
