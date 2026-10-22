package com.bytedance.ee.bear.drive.view.preview.wps;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.loader.download.platform.api.BasePuller;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class j implements Function {
    public final /* synthetic */ WpsAccessTokenPuller.Params a;

    public /* synthetic */ j(WpsAccessTokenPuller.Params r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        Throwable r5 = (Throwable) r4;
        tt5.a.d(BasePuller.TAG, String.format("wps getAccessToken error, msg: %s, params: %s", new Object[]{r5, this.a.toString()}));
        if ((r5 instanceof NetService.ServerErrorException) == false) goto L14;
        int r0 = ((NetService.ServerErrorException) r5).getCode();
        if (r0 != 90001061) goto L8;
        return Flowable.error(new DriveException(ErrCode.WPS_PREVIEW_GET_ACCESS_TOKEN_USER_MEMORY_OVER_LIMIT, r5));
    L8:
        if (r0 != 11001) goto L11;
        return Flowable.error(new DriveException(ErrCode.WPS_PREVIEW_GET_ACCESS_TOKEN_TENANT_MEMORY_OVER_LIMIT, r5));
    L11:
        if (r0 != 90001081) goto L14;
        return Flowable.error(new DriveException(ErrCode.WPS_PREVIEW_GET_ACCESS_TOKEN_EDITOR_MEMORY_OVER_LIMIT, r5));
    L14:
        return Flowable.error(new DriveException(ErrCode.WPS_PREVIEW_GET_ACCESS_TOKEN_EXP, r5));
    }
}
