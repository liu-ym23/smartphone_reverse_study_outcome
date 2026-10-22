package com.tencent.mm.opensdk.modelbase;

import android.os.Bundle;

/* JADX INFO: loaded from: classes40.dex */
public abstract class BaseResp {
    public int errCode;
    public String errStr;
    public String openId;
    public String transaction;

    public interface ErrCode {
        public static final int ERR_AUTH_DENIED = -4;
        public static final int ERR_BAN = -6;
        public static final int ERR_COMM = -1;
        public static final int ERR_OK = 0;
        public static final int ERR_SENT_FAILED = -3;
        public static final int ERR_UNSUPPORT = -5;
        public static final int ERR_USER_CANCEL = -2;
    }

    public BaseResp() {
    }

    public abstract boolean checkArgs();

    public void fromBundle(Bundle r100) {
        this.errCode = r100.getInt("_wxapi_baseresp_errcode");
        this.errStr = r100.getString("_wxapi_baseresp_errstr");
        this.transaction = r100.getString("_wxapi_baseresp_transaction");
        this.openId = r100.getString("_wxapi_baseresp_openId");
    }

    public abstract int getType();

    public void toBundle(Bundle r100) {
        r100.putInt("_wxapi_command_type", getType());
        r100.putInt("_wxapi_baseresp_errcode", this.errCode);
        r100.putString("_wxapi_baseresp_errstr", this.errStr);
        r100.putString("_wxapi_baseresp_transaction", this.transaction);
        r100.putString("_wxapi_baseresp_openId", this.openId);
    }
}
