package com.bytedance.sdk.open.aweme.share;

import android.os.Bundle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.open.aweme.base.AnchorObject;
import com.bytedance.sdk.open.aweme.base.MediaContent;
import com.bytedance.sdk.open.aweme.base.MicroAppInfo;
import com.bytedance.sdk.open.aweme.base.ShareParam;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.common.model.BaseReq;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes22.dex */
public class Share {
    public static final int IMAGE = 1;
    public static final int MIX = 2;
    private static final String TAG = "Aweme.OpenSDK.Share";
    public static final int UNKNOWN = -1;
    public static final int VIDEO = 0;

    public static class Request extends BaseReq {
        public AnchorObject mAnchorInfo;
        public String mCallerPackage;
        public String mClientKey;
        public ArrayList<String> mHashTagList;
        public MediaContent mMediaContent;
        public MicroAppInfo mMicroAppInfo;
        public String mState;
        private int mTargetSceneType;
        public boolean newShare;
        public int requireApi;
        public ShareParam shareParam;
        public boolean shareToPublish;
        public int shareToType;

        public Request() {
            this.mTargetSceneType = 0;
            this.shareToPublish = false;
            this.newShare = false;
            this.shareToType = 0;
            this.requireApi = 10003;
        }

        public Request(Bundle r100) {
            this.mTargetSceneType = 0;
            this.shareToPublish = false;
            this.newShare = false;
            this.shareToType = 0;
            this.requireApi = 10003;
            fromBundle(r100);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public boolean checkArgs() {
            MediaContent r100 = this.mMediaContent;
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.checkArgs();
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
            this.mMediaContent = MediaContent.Builder.fromBundle(r100);
            this.mMicroAppInfo = MicroAppInfo.unserialize(r100);
            this.mAnchorInfo = AnchorObject.unserialize(r100);
            this.newShare = r100.getBoolean(ParamKeyConstants.ShareParams.SHARE_NEW_SAHRE, false);
            this.shareParam = ShareParam.unserialize(r100);
            this.shareToType = r100.getInt(ParamKeyConstants.ShareParams.SHARE_TO_TYPE);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public int getType() {
            return 3;
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString(ParamKeyConstants.ShareParams.CALLER_LOCAL_ENTRY, this.callerLocalEntry);
            r100.putString(ParamKeyConstants.ShareParams.CLIENT_KEY, this.mClientKey);
            r100.putString(ParamKeyConstants.ShareParams.CALLER_PKG, this.mCallerPackage);
            if (this.shareToPublish == false) goto L5;
            r100.putInt(ParamKeyConstants.ShareParams.SHARE_TARGET_SCENE, 2);
        L6:
            r100.putString(ParamKeyConstants.ShareParams.STATE, this.mState);
            MediaContent r101 = this.mMediaContent;
            if (r101 == null) goto L9;
            r100.putAll(MediaContent.Builder.toBundle(r101));
        L9:
            ArrayList<String> r102 = this.mHashTagList;
            if (r102 != null) goto L12;
        L14:
            MicroAppInfo r103 = this.mMicroAppInfo;
            if (r103 == null) goto L17;
            r103.serialize(r100);
        L17:
            AnchorObject r104 = this.mAnchorInfo;
            if (r104 == null) goto L20;
            r104.serialize(r100);
        L20:
            ShareParam r105 = this.shareParam;
            if (r105 == null) goto L23;
            r105.serialize(r100);
        L23:
            r100.putBoolean(ParamKeyConstants.ShareParams.SHARE_NEW_SAHRE, this.newShare);
            r100.putInt(ParamKeyConstants.ShareParams.SHARE_TO_TYPE, this.shareToType);
            return;
        L12:
            if (r102.size() <= 0) goto L14;
            r100.putString(ParamKeyConstants.ShareParams.SHARE_DEFAULT_HASHTAG, (String) ListProtector.get(this.mHashTagList, 0));
            r100.putStringArrayList(ParamKeyConstants.ShareParams.SHARE_HASHTAG_LIST, this.mHashTagList);
            goto L14
        L5:
            r100.putInt(ParamKeyConstants.ShareParams.SHARE_TARGET_SCENE, 0);
            goto L6
        }
    }

    public static class Response extends BaseResp {
        public String state;
        public int subErrorCode;

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
            this.subErrorCode = r100.getInt(ParamKeyConstants.ShareParams.SHARE_SUB_ERROR_CODE, -1000);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public int getType() {
            return 4;
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public void toBundle(Bundle r100) {
            r100.putInt(ParamKeyConstants.ShareParams.ERROR_CODE, this.errorCode);
            r100.putString(ParamKeyConstants.ShareParams.ERROR_MSG, this.errorMsg);
            r100.putInt(ParamKeyConstants.ShareParams.TYPE, getType());
            r100.putBundle(ParamKeyConstants.BaseParams.EXTRA, this.extras);
            r100.putString(ParamKeyConstants.ShareParams.STATE, this.state);
            r100.putInt(ParamKeyConstants.ShareParams.SHARE_SUB_ERROR_CODE, this.subErrorCode);
        }
    }

    public Share() {
    }
}
