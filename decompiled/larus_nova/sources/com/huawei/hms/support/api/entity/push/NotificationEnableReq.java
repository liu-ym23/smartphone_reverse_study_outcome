package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* JADX INFO: loaded from: classes23.dex */
public class NotificationEnableReq implements IMessageEntity {

    @Packed
    String pkgName;

    public NotificationEnableReq() {
    }

    public void setPkgName(String r100) {
        this.pkgName = r100;
    }
}
