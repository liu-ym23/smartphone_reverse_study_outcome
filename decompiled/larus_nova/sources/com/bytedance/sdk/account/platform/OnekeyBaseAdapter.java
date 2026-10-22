package com.bytedance.sdk.account.platform;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.sdk.account.platform.base.OnekeyLoginErrorResponse;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public abstract class OnekeyBaseAdapter {
    protected static final String CARRIER_APP_ID = "carrier_app_id";
    protected Map<String, String> mExtendInfo;

    public OnekeyBaseAdapter() {
    }

    public void handleAuthorizeErrorResponse(AuthorizeErrorResponse r100) {
        if ((r100 instanceof OnekeyLoginErrorResponse) == false) goto L24;
        OnekeyLoginErrorResponse r101 = (OnekeyLoginErrorResponse) r100;
        int r102 = r101.errorType;
        if (r102 != 1) goto L7;
        int r103 = -1002;
    L13:
        r101.error = r103;
        r101.mDetailErrorCode = r103;
    L18:
        e = move-exception;
        e.printStackTrace();
    L20:
        r101.mDetailErrorMsg = r100.platformErrorDetail;
        return;
    L15:
        if (TextUtils.isEmpty(r101.platformErrorCode) == true) goto L20;
        r101.mDetailErrorCode = CastIntegerProtector.parseInt(r101.platformErrorCode);     // Catch: Exception -> L18
        goto L20
    L7:
        if (r102 != 2) goto L9;
    L11:
        r103 = -1003;
        goto L13
    L9:
        if (r102 == 3) goto L11;
        r103 = -1006;
        goto L13
    }

    public void setExtendInfo(Map<String, String> r100) {
        this.mExtendInfo = r100;
    }

    public OnekeyLoginErrorResponse getBindErrorResponse(ua7.e<wb7.f> r100, String r101) {
        ec7.a r102 = new ec7.a();
        r102.netType = r101;
        r102.errorType = 4;
        r102.platformErrorCode = String.valueOf(r100.f549253g);
        String r103 = r100.f549255i;
        r102.platformErrorMsg = r103;
        r102.mDetailErrorCode = r100.f549254h;
        r102.mDetailErrorMsg = r100.f549256j;
        r102.error = r100.f549253g;
        r102.errorMsg = r103;
        T r104 = r100.f549264p;
        if (r104 != 0) goto L5;
    L10:
        return r102;
    L5:
        if (((wb7.f) r104).f559016d == null) goto L8;
        r102.rawResult = ((wb7.f) r104).f559016d.optJSONObject("data");
    L8:
        if (r100.f549253g != 1057) goto L10;
        T r105 = r100.f549264p;
        r102.mConfirmSwitchBindTips = ((wb7.f) r105).f559018f;
        r102.mConfirmSwitchBindUrl = ((wb7.f) r105).f559019g;
        goto L10
    }

    public OnekeyLoginErrorResponse getForceBindErrorResponse(ua7.e<wb7.g> r100, String r101) {
        ec7.a r102 = new ec7.a();
        r102.netType = r101;
        r102.errorType = 4;
        r102.platformErrorCode = String.valueOf(r100.f549253g);
        String r103 = r100.f549255i;
        r102.platformErrorMsg = r103;
        r102.mDetailErrorCode = r100.f549254h;
        r102.mDetailErrorMsg = r100.f549256j;
        r102.error = r100.f549253g;
        r102.errorMsg = r103;
        T r104 = r100.f549264p;
        if (r104 != 0) goto L5;
    L10:
        return r102;
    L5:
        if (((wb7.g) r104).f559021f == null) goto L8;
        r102.resultCode = ((wb7.g) r104).f559021f;
    L8:
        if (((wb7.g) r104).f559016d == null) goto L10;
        r102.rawResult = ((wb7.g) r104).f559016d.optJSONObject("data");
        goto L10
    }
}
