package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public class v {
    public static ErrorEnum a(Context r100) {
        if (TextUtils.isEmpty(BaseUtils.getLocalToken(r100, null)) == false) goto L11;
        if (AutoInitHelper.isAutoInitEnabled(r100) == false) goto L8;
        HMSLog.e("TokenUtil", "Token not exist, try auto init");
        AutoInitHelper.doAutoInit(r100);
        return ErrorEnum.ERROR_AUTO_INITIALIZING;
    L8:
        HMSLog.e("TokenUtil", "Token not exist");
        return ErrorEnum.ERROR_NO_TOKEN;
    L11:
        return ErrorEnum.SUCCESS;
    }
}
