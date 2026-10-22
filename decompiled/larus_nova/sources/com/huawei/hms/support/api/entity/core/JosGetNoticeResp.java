package com.huawei.hms.support.api.entity.core;

import android.content.Intent;
import com.huawei.hms.core.aidl.annotation.Packed;

/* JADX INFO: loaded from: classes23.dex */
public class JosGetNoticeResp extends JosBaseResp {

    @Packed
    private Intent noticeIntent;

    private static <T> T get(T r100) {
        return r100;
    }

    public Intent getNoticeIntent() {
        return (Intent) get(this.noticeIntent);
    }

    public JosGetNoticeResp() {
    }

    public void setNoticeIntent(Intent r100) {
        this.noticeIntent = r100;
    }
}
