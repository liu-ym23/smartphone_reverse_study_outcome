package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.miui.easygo.constant.EasyGoConstant;

/* JADX INFO: loaded from: classes23.dex */
public class GrsApp {
    private static final String BRAND = null;
    private static final GrsApp INSTANCE = null;
    private static final String TAG = "GrsApp";
    private String appConfigName;

    static {
        INSTANCE = new GrsApp();
        String r100 = GrsApp.class.getPackage().getName();
        if ("com.huawei.hms.framework.network.grs".equals(r100) == false) goto L5;
        String r101 = "";
    L6:
        BRAND = r101;
        return;
    L5:
        String[] r102 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        Logger.v(TAG, "current brand is: " + r102[1]);
        r101 = r102[1];
        goto L6
    }

    private GrsApp() {
    }

    public static GrsApp getInstance() {
        return INSTANCE;
    }

    public String getAppConfigName() {
        return this.appConfigName;
    }

    public String getBrand(String r100) {
        String r101 = BRAND;
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return "";
    L7:
        return r101 + r100;
    }

    public String getIssueCountryCode(Context r100) {
        return a.a(r100, false).getCountryCode();
    }

    public void setAppConfigName(String r100) {
        this.appConfigName = r100;
    }
}
