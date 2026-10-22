package com.bytedance.sdk.open.aweme.common.model;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;

/* JADX INFO: loaded from: classes22.dex */
public abstract class BaseResp {
    public int errorCode;
    public String errorMsg;
    public Bundle extras;

    public BaseResp() {
    }

    public boolean checkArgs() {
        return true;
    }

    public void fromBundle(Bundle r100) {
        this.errorCode = r100.getInt(ParamKeyConstants.BaseParams.ERROR_CODE);
        this.errorMsg = r100.getString(ParamKeyConstants.BaseParams.ERROR_MSG);
        this.extras = r100.getBundle(ParamKeyConstants.BaseParams.EXTRA);
    }

    public abstract int getType();

    public boolean isCancel() {
        if (this.errorCode != (-2)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSuccess() {
        if (this.errorCode != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void toBundle(Bundle r100) {
        r100.putInt(ParamKeyConstants.BaseParams.ERROR_CODE, this.errorCode);
        r100.putString(ParamKeyConstants.BaseParams.ERROR_MSG, this.errorMsg);
        r100.putInt(ParamKeyConstants.BaseParams.TYPE, getType());
        r100.putBundle(ParamKeyConstants.BaseParams.EXTRA, this.extras);
    }
}
