package com.ss.android.lark.thirdshare.base.export;

import android.text.TextUtils;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.Serializable;

/* JADX INFO: loaded from: classes38.dex */
public abstract class OnShareCallback implements Serializable {
    public static final ShareError ADMIN_QQ_SDK_DISABLE = null;
    public static final ShareError ADMIN_WECHAT_SDK_DISABLE = null;
    public static final ShareError ADMIN_WEIBO_SDK_DISABLE = null;
    public static final ShareError BASE_DEP_API_IS_NULL = null;
    public static final ShareError CANCELED = null;
    public static final ShareError FETCH_REMOTE_CONFIG_FAILED = null;
    public static final ShareError ILLEGAL_CONFIG_PARAM = null;
    public static final ShareError INTERCEPT_DOWNGRADE = null;
    public static final ShareError NOT_INSTALLED = null;
    public static final ShareError PARSE_CONFIG_FAILED = null;
    public static final ShareError SAVE_FAILED = null;
    public static final ShareError SHARE_FAILED = null;

    public static class ShareError implements Serializable {
        private String append;
        private int code;
        private String msg;

        public String getMsg() {
            if (TextUtils.isEmpty(this.append) == false) goto L5;
            String r100 = this.msg;
        L6:
            this.append = "";
            return r100;
        L5:
            r100 = this.msg + ": " + this.append;
            goto L6
        }

        public String toString() {
            return "ShareError{code=" + this.code + ", msg='" + getMsg() + "'}";
        }

        public String getAppend() {
            return this.append;
        }

        public int getCode() {
            return this.code;
        }

        public String getOriginMessage() {
            return this.msg;
        }

        public ShareError appendMsg(String r100) {
            this.append = r100;
            return this;
        }

        public String toString(String r100) {
            return "ShareError{code=" + this.code + ", msg='" + this.msg + "', append='" + r100 + "'}";
        }

        public ShareError(int r100, String r101) {
            this.code = r100;
            this.msg = r101;
        }
    }

    public OnShareCallback() {
    }

    public boolean intercept(ShareActionType r100) {
        return false;
    }

    public void onDismiss(boolean r100) {
    }

    public abstract void onFailed(ShareActionType r100, ShareError r101);

    public void onShow() {
    }

    public abstract void onSuccess(ShareActionType r100);

    static {
        NOT_INSTALLED = new ShareError(101, "notInstalled");
        SAVE_FAILED = new ShareError(102, "saveFailed");
        CANCELED = new ShareError(103, "cancel");
        INTERCEPT_DOWNGRADE = new ShareError(300, "interceptDowngrade");
        PARSE_CONFIG_FAILED = new ShareError(400, "parseConfigFailed");
        ILLEGAL_CONFIG_PARAM = new ShareError(401, "illegalConfigParam");
        BASE_DEP_API_IS_NULL = new ShareError(TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_BARRAGE_MASK, "ThirdShareBaseDepApi is null");
        ADMIN_QQ_SDK_DISABLE = new ShareError(TTVideoEngineInterface.PLAYER_OPTION_DISABLE_MC_REUSE, "admin qq sdk is disable");
        ADMIN_WECHAT_SDK_DISABLE = new ShareError(477, "admin wechat sdk is disable");
        ADMIN_WEIBO_SDK_DISABLE = new ShareError(MediaPlayer.MEDIA_PLAYER_OPTION_SOCKET_ERR_CODE, "admin weibo sdk is disable");
        FETCH_REMOTE_CONFIG_FAILED = new ShareError(500, "fetchRemoteConfigFailed");
        SHARE_FAILED = new ShareError(200, "share failed");
    }
}
