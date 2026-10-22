package com.bytedance.sdk.open.aweme.authorize.model;

import android.os.Bundle;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.common.model.BaseReq;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;
import com.google.gson.Gson;

/* JADX INFO: loaded from: classes22.dex */
public class Authorization {

    public static class Request extends BaseReq {
        public String authTicket;
        public String clientKey;
        public String commentId;
        public boolean isOtherAccountAuth;
        public boolean isSkipUIInThirdAuth;
        public boolean isSupportLite;
        public boolean isThridAuthDialog;
        public String maskPhoneNumber;
        public String optionalScope0;
        public String optionalScope1;
        public String redirectUri;
        public String scope;
        public String state;
        public String thirdAuthScene;
        public VerifyObject verifyObject;

        public Request() {
            this.isSupportLite = true;
            this.isThridAuthDialog = false;
            this.isSkipUIInThirdAuth = false;
            this.isOtherAccountAuth = false;
        }

        public Request(Bundle r100) {
            this.isSupportLite = true;
            this.isThridAuthDialog = false;
            this.isSkipUIInThirdAuth = false;
            this.isOtherAccountAuth = false;
            fromBundle(r100);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            this.state = r100.getString(ParamKeyConstants.AuthParams.STATE);
            this.clientKey = r100.getString(ParamKeyConstants.AuthParams.CLIENT_KEY);
            this.redirectUri = r100.getString(ParamKeyConstants.AuthParams.REDIRECT_URI);
            this.scope = r100.getString(ParamKeyConstants.AuthParams.SCOPE);
            this.optionalScope0 = r100.getString(ParamKeyConstants.AuthParams.OPTIONAL_SCOPE0);
            this.optionalScope1 = r100.getString(ParamKeyConstants.AuthParams.OPTIONAL_SCOPE1);
            this.authTicket = r100.getString(ParamKeyConstants.AuthParams.AUTH_THIRD_APP_TICKET);
            this.maskPhoneNumber = r100.getString(ParamKeyConstants.AuthParams.AUTH_MASK_PHONE);
            this.commentId = r100.getString(ParamKeyConstants.AuthParams.AUTH_COMMENT_ID);
            String r101 = r100.getString(ParamKeyConstants.AuthParams.VERIFY_SCOPE);
            if (r101 == null) goto L5;
            this.verifyObject = (VerifyObject) GsonProtectorUtils.fromJson(new Gson(), r101, VerifyObject.class);
        L5:
            this.isSkipUIInThirdAuth = r100.getBoolean(ParamKeyConstants.AuthParams.IS_SKIP_UI_IN_THIRD_AUTH);
            this.thirdAuthScene = r100.getString(ParamKeyConstants.AuthParams.THIRD_AUTH_SCENE);
            this.isOtherAccountAuth = r100.getBoolean("is_other_account_auth");
        }

        public String getClientKey() {
            return this.clientKey;
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public int getType() {
            return 1;
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString(ParamKeyConstants.AuthParams.STATE, this.state);
            r100.putString(ParamKeyConstants.AuthParams.CLIENT_KEY, this.clientKey);
            r100.putString(ParamKeyConstants.AuthParams.REDIRECT_URI, this.redirectUri);
            r100.putString(ParamKeyConstants.AuthParams.SCOPE, this.scope);
            r100.putString(ParamKeyConstants.AuthParams.OPTIONAL_SCOPE0, this.optionalScope0);
            r100.putString(ParamKeyConstants.AuthParams.OPTIONAL_SCOPE1, this.optionalScope1);
            r100.putString(ParamKeyConstants.AuthParams.AUTH_THIRD_APP_TICKET, this.authTicket);
            r100.putString(ParamKeyConstants.AuthParams.AUTH_MASK_PHONE, this.maskPhoneNumber);
            r100.putString(ParamKeyConstants.AuthParams.AUTH_COMMENT_ID, this.commentId);
            if (this.verifyObject == null) goto L5;
            r100.putString(ParamKeyConstants.AuthParams.VERIFY_SCOPE, GsonProtectorUtils.toJson(new Gson(), this.verifyObject));
        L5:
            r100.putBoolean(ParamKeyConstants.AuthParams.IS_SKIP_UI_IN_THIRD_AUTH, this.isSkipUIInThirdAuth);
            r100.putString(ParamKeyConstants.AuthParams.THIRD_AUTH_SCENE, this.thirdAuthScene);
            r100.putBoolean("is_other_account_auth", this.isOtherAccountAuth);
        }
    }

    public static class Response extends BaseResp {
        public String authCode;
        public String grantedPermissions;
        public String state;

        public Response() {
        }

        public Response(Bundle r100) {
            fromBundle(r100);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            this.authCode = r100.getString(ParamKeyConstants.AuthParams.AUTH_CODE);
            this.state = r100.getString(ParamKeyConstants.AuthParams.STATE);
            this.grantedPermissions = r100.getString(ParamKeyConstants.AuthParams.GRANTED_PERMISSION);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public int getType() {
            return 2;
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString(ParamKeyConstants.AuthParams.AUTH_CODE, this.authCode);
            r100.putString(ParamKeyConstants.AuthParams.STATE, this.state);
            r100.putString(ParamKeyConstants.AuthParams.GRANTED_PERMISSION, this.grantedPermissions);
        }
    }

    public Authorization() {
    }
}
