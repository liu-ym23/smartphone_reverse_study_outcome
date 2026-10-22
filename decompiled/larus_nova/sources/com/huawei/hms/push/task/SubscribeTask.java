package com.huawei.hms.push.task;

/* JADX INFO: loaded from: classes23.dex */
public class SubscribeTask extends BaseVoidTask {
    @Override // com.huawei.hms.push.task.BaseVoidTask, com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 40003000;
    }

    public SubscribeTask(String r100, String r101, String r102) {
        super(r100, r101, r102);
    }
}
