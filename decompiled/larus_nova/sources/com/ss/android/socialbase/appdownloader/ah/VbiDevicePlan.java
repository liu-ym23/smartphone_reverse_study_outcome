package com.ss.android.socialbase.appdownloader.ah;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.socialbase.appdownloader.util.DecryptUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public class VbiDevicePlan extends AbsDevicePlan {
    @Override // com.ss.android.socialbase.appdownloader.ah.IAhDevicePlan
    public Intent getJumpIntent() {
        String r100 = this.mSetting.optString("s");
        String r101 = DecryptUtils.decrypt(this.mSetting.optString("bb"), r100);
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L14:
        return null;
    L5:
        if (r101.split(",").length != 2) goto L14;
        String r102 = DecryptUtils.decrypt(this.mSetting.optString("bc"), r100);
        if (TextUtils.isEmpty(r102) == true) goto L14;
        if (r102.split(",").length != 2) goto L14;
        String[] r103 = r101.split(",");
        String[] r104 = r102.split(",");
        String r105 = DecryptUtils.decrypt(this.mSetting.optString("bd"), r100);
        String r106 = DecryptUtils.decrypt(this.mSetting.optString("be"), r100);
        String r107 = DecryptUtils.decrypt(this.mSetting.optString("bf"), r100);
        HashMap r108 = new HashMap();
        r108.put(r103[0], r103[1]);
        r108.put(r104[0], r104[1]);
        r108.put(r105, this.mJumpPath);
        Intent r109 = new Intent();
        r109.setAction(r107);
        r109.setData(UriProtector.parse(r106 + getUrlParamsByMap(r108)));
        r109.addFlags(268468224);
        return r109;
    }

    public static String getUrlParamsByMap(Map<String, String> r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        StringBuilder r101 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<String, String> r103 = r102.next();
        r101.append(r103.getKey());
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r101.append(URLEncoder.encode(r103.getValue()));
        r101.append("&");
        goto L7
    L9:
        String r104 = r101.toString();
        if (r104.endsWith("&") == true) goto L12;
        return r104;
    L12:
        return r104.substring(0, r104.length() - 1);
    }

    public VbiDevicePlan(Context r100, DownloadSetting r101, String r102) {
        super(r100, r101, r102);
    }
}
