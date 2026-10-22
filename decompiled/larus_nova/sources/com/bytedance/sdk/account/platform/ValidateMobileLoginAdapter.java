package com.bytedance.sdk.account.platform;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.sdk.account.platform.base.OneLoginCallback;
import com.bytedance.sdk.account.platform.base.OnekeyLoginErrorResponse;
import java.util.HashMap;
import org.json.JSONObject;
import sa7.h;

/* JADX INFO: loaded from: classes22.dex */
public abstract class ValidateMobileLoginAdapter extends OnekeyBaseAdapter implements OneLoginCallback {
    protected ta7.g accountAPI;
    private volatile boolean isCancel;
    private h<ua7.h> mCallback;
    private String mFrom;
    private boolean mIsCheckMatchSecretMobile;
    private final String mMobile;
    private String mProviderAppId;
    private String mSecretMobile;
    private String mToken;

    public class a extends h<ua7.h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValidateMobileLoginAdapter f269245a;

        public a(ValidateMobileLoginAdapter r100) {
            this.f269245a = r100;
        }

        @Override // sa7.h
        public final void onSuccess(ua7.b r100) {
            ValidateMobileLoginAdapter r101 = this.f269245a;
            r101.onLoginSuccess((ua7.h) r100);
        }

        @Override // sa7.h
        public final void onError(ua7.b r100, int r101) {
            ValidateMobileLoginAdapter r102 = this.f269245a;
            r102.onLoginError(ValidateMobileLoginAdapter.access$100(r102, (ua7.h) r100, ValidateMobileLoginAdapter.access$000(r102)));
        }
    }

    public void cancel() {
        this.isCancel = true;
        h<ua7.h> r100 = this.mCallback;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    public abstract void onLoginError(AuthorizeErrorResponse r100);

    public abstract void onLoginSuccess(ua7.h r100);

    @Override // com.bytedance.sdk.account.platform.base.OneLoginCallback
    public JSONObject onSendEvent() {
        return null;
    }

    private boolean checkMismatchSecretMobile() {
        if (TextUtils.isEmpty(this.mSecretMobile) == false) goto L5;
        return true;
    L5:
        if (this.mSecretMobile.length() == 11) goto L7;
        return true;
    L7:
        if (TextUtils.isEmpty(this.mMobile) == true) goto L22;
        String r100 = this.mSecretMobile.substring(0, 3);
        String r101 = this.mSecretMobile.substring(7, 11);
        String r102 = this.mMobile.trim();
        if (r102.startsWith("+86") == false) goto L13;
        r102 = r102.substring(3).trim();
    L13:
        if (r102.startsWith(r100) == true) goto L15;
        return true;
    L15:
        if (r102.endsWith(r101) == false) goto L23;
        return false;
    L23:
        return true;
    L22:
        return true;
    }

    private OnekeyLoginErrorResponse getErrorResponse() {
        OnekeyLoginErrorResponse r100 = new OnekeyLoginErrorResponse();
        r100.error = -1;
        r100.errorMsg = "secret mobile mismatch";
        return r100;
    }

    public static /* synthetic */ String access$000(ValidateMobileLoginAdapter r100) {
        return r100.mFrom;
    }

    private void parseData(Bundle r100) {
        this.mToken = r100.getString("access_token");
        this.mFrom = r100.getString(IOnekeyLoginService.ResponseConstants.CARRIER_FROM);
        this.mProviderAppId = r100.getString("carrier_app_id");
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public final void onError(AuthorizeErrorResponse r100) {
        if (this.isCancel == false) goto L5;
        return;
    L5:
        handleAuthorizeErrorResponse(r100);
        onLoginError(r100);
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public final void onSuccess(Bundle r110) {
        if (this.isCancel == false) goto L6;
        return;
    L6:
        if (this.mIsCheckMatchSecretMobile == true) goto L8;
    L11:
        parseData(r110);
        this.mCallback = new a(this);
        if (this.mExtendInfo != null) goto L14;
        this.mExtendInfo = new HashMap();
    L14:
        this.mExtendInfo.put("provider_app_id", this.mProviderAppId);
        this.accountAPI.g(this.mSecretMobile, this.mMobile, this.mToken, this.mFrom, this.mExtendInfo, this.mCallback);
        return;
    L8:
        if (checkMismatchSecretMobile() == false) goto L11;
        onLoginError(getErrorResponse());
    }

    public ValidateMobileLoginAdapter(Context r100, String r101) {
        this.mMobile = r101;
        this.accountAPI = com.bytedance.sdk.account.impl.d.l();
        this.isCancel = false;
    }

    private OnekeyLoginErrorResponse getErrorResponse(ua7.h r100, String r101) {
        OnekeyLoginErrorResponse r102 = new OnekeyLoginErrorResponse();
        r102.netType = r101;
        r102.errorType = 4;
        r102.platformErrorCode = String.valueOf(r100.f549253g);
        String r103 = r100.f549255i;
        r102.platformErrorMsg = r103;
        r102.mDetailErrorCode = r100.f549254h;
        r102.mDetailErrorMsg = r100.f549256j;
        r102.error = r100.f549253g;
        r102.errorMsg = r103;
        JSONObject r104 = r100.f549259m;
        if (r104 == null) goto L6;
        r102.rawResult = r104.optJSONObject("data");
    L6:
        if (r100.f549253g != 1075) goto L8;
        r102.mCancelApplyTime = r100.f549284u;
        r102.mCancelAvatarUrl = r100.f549287x;
        r102.mCancelNickName = r100.f549286w;
        r102.mCancelTime = r100.f549285v;
        r102.mCancelToken = r100.f549283t;
    L8:
        return r102;
    }

    public ValidateMobileLoginAdapter(Context r100, String r101, String r102) {
        this(r100, r102);
        this.mSecretMobile = r101;
        this.mIsCheckMatchSecretMobile = true;
    }

    public static /* synthetic */ OnekeyLoginErrorResponse access$100(ValidateMobileLoginAdapter r100, ua7.h r101, String r102) {
        return r100.getErrorResponse(r101, r102);
    }
}
