package com.huawei.hms.support.api.entity.hwid;

import android.os.Bundle;
import com.huawei.hms.support.api.entity.common.CommonConstant;

/* JADX INFO: loaded from: classes23.dex */
public class SignInResp extends IHwIDRespEntity {

    @Checked(permission = CommonConstant.LocalPermission.ACCESS_TOKEN, value = CommonConstant.RETKEY.ACCESS_TOKEN)
    private String mAccessToken;

    @Checked(permission = CommonConstant.PERMISSION.COUNTRY, scope = CommonConstant.SCOPE.SCOPE_ACCOUNT_COUNTRY, value = CommonConstant.RETKEY.COUNTRYCODE)
    private String mCountryCode;

    @Checked(permission = CommonConstant.PERMISSION.BASE_PROFILE, scope = CommonConstant.SCOPE.ACCOUNT_BASEPROFILE, value = CommonConstant.RETKEY.GENDER)
    private String mGender;

    @Checked(permission = CommonConstant.PERMISSION.BASE_PROFILE, scope = CommonConstant.SCOPE.ACCOUNT_BASEPROFILE, value = CommonConstant.RETKEY.DISPLAYNAME)
    private String mLoginUserName;

    @Checked(permission = CommonConstant.PERMISSION.OPENID, value = CommonConstant.RETKEY.OPENID)
    private String mOpenId;

    @Checked(CommonConstant.RETKEY.SCOPE)
    private String mScopeUri;

    @Checked(permission = CommonConstant.LocalPermission.SERVICE_AUTH_CODE, value = CommonConstant.RETKEY.SERVICEAUTHCODE)
    private String mServiceAuthCode;

    @Checked(permission = CommonConstant.PERMISSION.COUNTRY, scope = CommonConstant.SCOPE.SCOPE_ACCOUNT_COUNTRY, value = CommonConstant.RETKEY.SERVICECOUNTRYCODE)
    private String mServiceCountryCode;

    @Checked(permission = CommonConstant.PERMISSION.UID, value = "USER_ID")
    private String mUid;

    @Checked(permission = CommonConstant.PERMISSION.UNIONID, value = CommonConstant.RETKEY.UNIONID)
    private String mUnionID;

    @Checked(permission = CommonConstant.PERMISSION.BASE_PROFILE, scope = CommonConstant.SCOPE.ACCOUNT_BASEPROFILE, value = CommonConstant.RETKEY.STATUS)
    private String mUserStatus;

    @Checked(permission = CommonConstant.PERMISSION.BASE_PROFILE, scope = CommonConstant.SCOPE.ACCOUNT_BASEPROFILE, value = CommonConstant.RETKEY.PHOTOURL)
    private String photoUrl;

    public SignInResp() {
    }

    public String getAccessToken() {
        return this.mAccessToken;
    }

    public String getCountryCode() {
        return this.mCountryCode;
    }

    public String getGender() {
        return this.mGender;
    }

    public String getLoginUserName() {
        return this.mLoginUserName;
    }

    public String getOpenId() {
        return this.mOpenId;
    }

    public String getPhotoUrl() {
        return this.photoUrl;
    }

    public String getScopeUri() {
        return this.mScopeUri;
    }

    public String getServiceAuthCode() {
        return this.mServiceAuthCode;
    }

    public String getServiceCountryCode() {
        return this.mServiceCountryCode;
    }

    public String getUid() {
        return this.mUid;
    }

    public String getUserStatus() {
        return this.mUserStatus;
    }

    public String getmUnionID() {
        return this.mUnionID;
    }

    public static SignInResp buildSignInResp(Bundle r100) {
        SignInResp r101 = new SignInResp();
        if (r100 == null) goto L5;
        r101.mUid = r100.getString("USER_ID", "");
        r101.mLoginUserName = r100.getString(CommonConstant.RETKEY.DISPLAYNAME, "");
        r101.photoUrl = r100.getString(CommonConstant.RETKEY.PHOTOURL, "");
        r101.mAccessToken = r100.getString(CommonConstant.RETKEY.ACCESS_TOKEN, "");
        r101.mUserStatus = r100.getString(CommonConstant.RETKEY.STATUS, "");
        r101.mGender = r100.getString(CommonConstant.RETKEY.GENDER, "");
        r101.mScopeUri = r100.getString(CommonConstant.RETKEY.SCOPE, "");
        r101.mOpenId = r100.getString(CommonConstant.RETKEY.OPENID, "");
        r101.mServiceCountryCode = r100.getString(CommonConstant.RETKEY.SERVICECOUNTRYCODE, "");
        r101.mCountryCode = r100.getString(CommonConstant.RETKEY.COUNTRYCODE, "");
        r101.mServiceAuthCode = r100.getString(CommonConstant.RETKEY.SERVICEAUTHCODE, "");
        r101.mUnionID = r100.getString(CommonConstant.RETKEY.UNIONID, "");
    L5:
        return r101;
    }
}
