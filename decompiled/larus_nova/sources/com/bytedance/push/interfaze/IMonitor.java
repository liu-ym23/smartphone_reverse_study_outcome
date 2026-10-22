package com.bytedance.push.interfaze;

import android.app.NotificationChannel;

/* JADX INFO: loaded from: classes3.dex */
public interface IMonitor {
    void init();

    void markOuterSwitchStatusFailed(int r100, String r101);

    void markOuterSwitchStatusSuccess();

    void markOuterSwitchUploadFailed(int r100, String r101);

    void markOuterSwitchUploadSuccess();

    void markUpdateSenderFailed(int r100, int r101, String r102, String r103);

    void markUpdateSenderSuccess();

    void monitorDecryptResult(int r100, int r101);

    void monitorEvent(String r100, String r101);

    void monitorHarmonyOs4Compliance(boolean r100, int r101);

    void monitorInitTimeCoast(long r100);

    void monitorNotificationCreate(NotificationChannel r100);

    void monitorRegisterSender(int r100);

    void monitorRegisterSenderFailed(int r100, int r101, String r102, String r103);

    void monitorRegisterSenderSuccess(int r100);

    void monitorSenderSupport(boolean r100, String r101);

    void monitorShowEmpty(int r100, String r101, int r102, int r103);

    void monitorStart();
}
