package com.bytedance.sdk.open.aweme.commonability;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.common.model.BaseReq;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;

/* JADX INFO: loaded from: classes22.dex */
public class CommonAbility {
    public static final int COMMON_TYPE_JUMP_CONTACT = 2;
    public static final int COMMON_TYPE_JUMP_PRODUCTION = 3;
    public static final int COMMON_TYPE_JUMP_PROFILE = 1;

    public static class Request extends BaseReq {
        public int commonType;
        public String data;
        public String mState;

        public Request() {
        }

        public Request(Bundle r100) {
            fromBundle(r100);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public boolean checkArgs() {
            if (this.commonType > 0) goto L7;
            return false;
        L7:
            return super.checkArgs();
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            this.mState = r100.getString(ParamKeyConstants.CommonAbilityParam.STATE);
            this.commonType = r100.getInt(ParamKeyConstants.CommonAbilityParam.TYPE);
            this.data = r100.getString(ParamKeyConstants.CommonAbilityParam.DATA);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public int getType() {
            return 9;
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString(ParamKeyConstants.BaseParams.CALLER_PKG, this.callerPackage);
            r100.putString(ParamKeyConstants.CommonAbilityParam.STATE, this.mState);
            r100.putInt(ParamKeyConstants.CommonAbilityParam.TYPE, this.commonType);
            r100.putString(ParamKeyConstants.CommonAbilityParam.DATA, this.data);
        }
    }

    public static class Response extends BaseResp {
        public int commonType;
        public String state;

        public Response() {
        }

        public Response(Bundle r100) {
            fromBundle(r100);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            this.state = r100.getString(ParamKeyConstants.CommonAbilityParam.STATE);
            this.commonType = r100.getInt(ParamKeyConstants.CommonAbilityParam.TYPE);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public int getType() {
            return 10;
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString(ParamKeyConstants.CommonAbilityParam.STATE, this.state);
            r100.putInt(ParamKeyConstants.CommonAbilityParam.TYPE, this.commonType);
        }
    }

    public CommonAbility() {
    }

    public static int supportApi(int r100) {
        if (r100 != 1) goto L5;
    L11:
        return 1;
    L5:
        if (r100 == 2) goto L11;
        if (r100 == 3) goto L10;
        return Integer.MAX_VALUE;
    L10:
        return 2;
    }
}
