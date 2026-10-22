package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes24.dex */
public class SystemPermission$Request extends LKBaseRequestModel {

    @JSONField(name = "force")
    private boolean mForceUiThread;

    @JSONField(name = ComplianceResult.JsonKey.PERMISSIONS)
    public List<String> mPermissions;

    public SystemPermission$Request() {
        this.mPermissions = new ArrayList();
        this.mForceUiThread = true;
    }

    public boolean isForceUiThread() {
        return this.mForceUiThread;
    }

    public void setForceUiThread(boolean r100) {
        this.mForceUiThread = r100;
    }
}
