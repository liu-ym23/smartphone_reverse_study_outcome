package com.huawei.hms.support.api.hwid;

import android.content.Intent;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;

/* JADX INFO: loaded from: classes23.dex */
public class SignInResult extends Result {
    private AuthHuaweiId authHuaweiId;
    private Intent data;

    public boolean isSuccess() {
        return getStatus().isSuccess();
    }

    public SignInResult() {
    }

    public AuthHuaweiId getAuthHuaweiId() {
        return this.authHuaweiId;
    }

    public Intent getData() {
        return this.data;
    }

    public SignInResult(Status r100) {
        setStatus(r100);
    }

    public void setAuthHuaweiId(AuthHuaweiId r100) {
        this.authHuaweiId = r100;
    }

    public void setData(Intent r100) {
        this.data = r100;
    }
}
