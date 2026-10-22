package com.huawei.hms.push.ups;

import android.content.Context;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.HmsMessaging;
import com.huawei.hms.push.d;
import com.huawei.hms.push.ups.entity.TokenResult;
import com.huawei.hms.push.ups.entity.UPSRegisterCallBack;
import com.huawei.hms.push.ups.entity.UPSTurnCallBack;
import com.huawei.hms.push.ups.entity.UPSUnRegisterCallBack;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public final class UPSService {
    private UPSService() {
    }

    public static void turnOffPush(Context r100, final UPSTurnCallBack r101) {
        HMSLog.i("UPSService", "invoke turnOffPush");
        Preconditions.checkNotNull(r101);
        if (d.b() == true) goto L6;
        r101.onResult(new TokenResult(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
        return;
    L6:
        HmsMessaging.getInstance(r100).turnOffPush().addOnCompleteListener(new AnonymousClass2(r101));
    }

    public static void turnOnPush(Context r100, final UPSTurnCallBack r101) {
        HMSLog.i("UPSService", "invoke turnOnPush");
        Preconditions.checkNotNull(r101);
        if (d.b() == true) goto L6;
        r101.onResult(new TokenResult(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
        return;
    L6:
        HmsMessaging.getInstance(r100).turnOnPush().addOnCompleteListener(new AnonymousClass1(r101));
    }

    public static void unRegisterToken(Context r100, UPSUnRegisterCallBack r101) {
        HMSLog.i("UPSService", "invoke unRegisterToken");
        Preconditions.checkNotNull(r101);
        if (d.b() == true) goto L11;
        r101.onResult(new TokenResult(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
        return;
    L11:
        HmsInstanceId.getInstance(r100).deleteToken(null, null);     // Catch: ApiException -> L8
        r101.onResult(new TokenResult());     // Catch: ApiException -> L8
        return;
    L8:
        e = move-exception;
        r101.onResult(new TokenResult(e.getStatusCode(), e.getMessage()));
    }

    public static void registerToken(Context r100, String r101, String r102, String r103, UPSRegisterCallBack r104) {
        HMSLog.i("UPSService", "invoke registerToken");
        Preconditions.checkNotNull(r104);
        if (d.b() == true) goto L11;
        r104.onResult(new TokenResult(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
        return;
    L11:
        r104.onResult(new TokenResult(HmsInstanceId.getInstance(r100).getToken(r101, null)));     // Catch: ApiException -> L8
        return;
    L8:
        e = move-exception;
        r104.onResult(new TokenResult(e.getStatusCode(), e.getMessage()));
    }
}
