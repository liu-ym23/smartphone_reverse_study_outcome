package com.huawei.hms.support.api.entity.opendevice;

import android.app.PendingIntent;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* JADX INFO: loaded from: classes23.dex */
public class OaidResp extends AbstractMessageEntity {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @Packed
    private String f277738id;

    @Packed
    private boolean isTrackLimited;

    @Packed
    private PendingIntent settingIntent;

    public OaidResp() {
    }

    public String getId() {
        return this.f277738id;
    }

    public PendingIntent getSettingIntent() {
        return this.settingIntent;
    }

    public boolean isTrackLimited() {
        return this.isTrackLimited;
    }

    public void setId(String r100) {
        this.f277738id = r100;
    }

    public void setSettingIntent(PendingIntent r100) {
        this.settingIntent = r100;
    }

    public void setTrackLimited(boolean r100) {
        this.isTrackLimited = r100;
    }
}
