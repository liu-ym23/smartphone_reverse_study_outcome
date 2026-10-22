package com.bytedance.sdk.open.douyin.model;

import android.os.Bundle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.open.aweme.base.AnchorObject;
import com.bytedance.sdk.open.aweme.base.MicroAppInfo;
import com.bytedance.sdk.open.aweme.base.ShareParam;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.common.model.BaseReq;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes22.dex */
public class OpenRecord {

    public static class Request extends BaseReq {
        public AnchorObject mAnchorInfo;
        public String mCallerPackage;
        public String mClientKey;
        public ArrayList<String> mHashTagList;
        public MicroAppInfo mMicroAppInfo;
        public String mState;
        public int mTargetSceneType;
        public int requireApi;
        public ShareParam shareParam;

        public Request() {
            this.mTargetSceneType = 0;
            this.requireApi = 10003;
        }

        public Request(Bundle r100) {
            this.mTargetSceneType = 0;
            this.requireApi = 10003;
            fromBundle(r100);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public boolean checkArgs() {
            return true;
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            this.mCallerPackage = r100.getString(ParamKeyConstants.ShareParams.CALLER_PKG);
            this.callerLocalEntry = r100.getString(ParamKeyConstants.ShareParams.CALLER_LOCAL_ENTRY);
            this.mState = r100.getString(ParamKeyConstants.ShareParams.STATE);
            this.mClientKey = r100.getString(ParamKeyConstants.ShareParams.CLIENT_KEY);
            this.mTargetSceneType = r100.getInt(ParamKeyConstants.ShareParams.SHARE_TARGET_SCENE, 0);
            this.mHashTagList = r100.getStringArrayList(ParamKeyConstants.ShareParams.SHARE_HASHTAG_LIST);
            this.mMicroAppInfo = MicroAppInfo.unserialize(r100);
            this.mAnchorInfo = AnchorObject.unserialize(r100);
            this.shareParam = ShareParam.unserialize(r100);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public int getType() {
            return 7;
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString(ParamKeyConstants.ShareParams.CALLER_LOCAL_ENTRY, this.callerLocalEntry);
            r100.putString(ParamKeyConstants.ShareParams.CLIENT_KEY, this.mClientKey);
            r100.putString(ParamKeyConstants.ShareParams.CALLER_PKG, this.mCallerPackage);
            r100.putString(ParamKeyConstants.ShareParams.STATE, this.mState);
            r100.putInt(ParamKeyConstants.ShareParams.SHARE_TARGET_SCENE, this.mTargetSceneType);
            ArrayList<String> r101 = this.mHashTagList;
            if (r101 != null) goto L5;
        L7:
            MicroAppInfo r102 = this.mMicroAppInfo;
            if (r102 == null) goto L10;
            r102.serialize(r100);
        L10:
            AnchorObject r103 = this.mAnchorInfo;
            if (r103 == null) goto L13;
            r103.serialize(r100);
        L13:
            ShareParam r104 = this.shareParam;
            if (r104 == null) goto L17;
            r104.serialize(r100);
            return;
        L17:
            return;
        L5:
            if (r101.size() <= 0) goto L7;
            r100.putString(ParamKeyConstants.ShareParams.SHARE_DEFAULT_HASHTAG, (String) ListProtector.get(this.mHashTagList, 0));
            r100.putStringArrayList(ParamKeyConstants.ShareParams.SHARE_HASHTAG_LIST, this.mHashTagList);
            goto L7
        }
    }

    public static class Response extends BaseResp {
        public String state;

        public Response() {
        }

        public Response(Bundle r100) {
            fromBundle(r100);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public void fromBundle(Bundle r100) {
            this.errorCode = r100.getInt(ParamKeyConstants.ShareParams.ERROR_CODE);
            this.errorMsg = r100.getString(ParamKeyConstants.ShareParams.ERROR_MSG);
            this.extras = r100.getBundle(ParamKeyConstants.BaseParams.EXTRA);
            this.state = r100.getString(ParamKeyConstants.ShareParams.STATE);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public int getType() {
            return 8;
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public void toBundle(Bundle r100) {
            r100.putInt(ParamKeyConstants.ShareParams.ERROR_CODE, this.errorCode);
            r100.putString(ParamKeyConstants.ShareParams.ERROR_MSG, this.errorMsg);
            r100.putInt(ParamKeyConstants.ShareParams.TYPE, getType());
            r100.putBundle(ParamKeyConstants.BaseParams.EXTRA, this.extras);
            r100.putString(ParamKeyConstants.ShareParams.STATE, this.state);
        }
    }

    public OpenRecord() {
    }
}
