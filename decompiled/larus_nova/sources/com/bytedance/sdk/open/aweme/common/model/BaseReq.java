package com.bytedance.sdk.open.aweme.common.model;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.a;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;

/* JADX INFO: loaded from: classes22.dex */
public abstract class BaseReq {
    public String callerLocalEntry;
    public String callerPackage;
    public String callerVersion;
    public Bundle extras;
    public long sdkLaunchTime;

    public BaseReq() {
    }

    public boolean checkArgs() {
        return true;
    }

    public void fromBundle(Bundle r100) {
        this.callerPackage = r100.getString(ParamKeyConstants.BaseParams.CALLER_PKG);
        this.callerVersion = r100.getString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_VERSION);
        this.extras = r100.getBundle(ParamKeyConstants.BaseParams.EXTRA);
        this.callerLocalEntry = r100.getString(ParamKeyConstants.BaseParams.FROM_ENTRY);
        this.sdkLaunchTime = r100.getLong(ParamKeyConstants.BaseParams.SDK_LAUNCH_TIME);
    }

    public String getCallerLocalEntry() {
        return this.callerLocalEntry;
    }

    public String getCallerPackage() {
        return this.callerPackage;
    }

    public String getCallerVersion() {
        return this.callerVersion;
    }

    public abstract int getType();

    public void toBundle(Bundle r100) {
        r100.putInt(ParamKeyConstants.BaseParams.TYPE, getType());
        r100.putBundle(ParamKeyConstants.BaseParams.EXTRA, this.extras);
        r100.putString(ParamKeyConstants.BaseParams.FROM_ENTRY, this.callerLocalEntry);
        r100.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_COMMON_NAME, a.f269605e);
        r100.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_COMMON_VERSION, "5.21.1-rc.0");
        r100.putLong(ParamKeyConstants.BaseParams.SDK_LAUNCH_TIME, System.currentTimeMillis());
    }
}
