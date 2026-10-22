package com.huawei.hms.push.task;

/* JADX INFO: loaded from: classes23.dex */
public class ProfileTask extends BaseVoidTask {
    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 2;
    }

    @Override // com.huawei.hms.push.task.BaseVoidTask, com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 50004300;
    }

    public ProfileTask(String r100, String r101, String r102) {
        super(r100, r101, r102);
    }
}
