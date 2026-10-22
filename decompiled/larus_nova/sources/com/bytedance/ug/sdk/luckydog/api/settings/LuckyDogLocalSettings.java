package com.bytedance.ug.sdk.luckydog.api.settings;

import com.bytedance.news.common.settings.api.annotation.ILocalSettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes3.dex */
@Settings(settingsId = "luckydog_settings", storageKey = "activity_local")
public interface LuckyDogLocalSettings extends ILocalSettings {
    String getBdnEnv();

    String getColdPopData();

    String getColdPopupSet();

    int getColdRequestFailTimes();

    String getDynamicSettings();

    long getLastServerTime();

    LinkedHashSet<String> getNotificationSet();

    String getPollSettings();

    String getPollSettingsDg();

    LinkedHashSet<String> getPopupSet();

    LinkedHashSet<Long> getReceivePopupIdSet();

    LinkedHashSet<Long> getShownLottieIdSet();

    LinkedHashSet<Long> getShownNotificationIdSet();

    LinkedHashSet<Long> getShownPopupIdSet();

    String getStaticSettings();

    long getTimeInterval();

    long getTimeManagerOldBoot();

    void setBdnEnv(String r100);

    void setColdPopData(String r100);

    void setColdPopupSet(String r100);

    void setColdRequestFailTimes(int r100);

    void setDynamicSettings(String r100);

    void setLastServerTime(long r100);

    void setNotificationSet(LinkedHashSet<String> r100);

    void setPollSettings(String r100);

    void setPollSettingsDg(String r100);

    void setPopupSet(LinkedHashSet<String> r100);

    void setReceivePopupIdSet(LinkedHashSet<Long> r100);

    void setShownLottieIdSet(LinkedHashSet<Long> r100);

    void setShownNotificationIdSet(LinkedHashSet<Long> r100);

    void setShownPopupIdSet(LinkedHashSet<Long> r100);

    void setStaticSettings(String r100);

    void setTimeInterval(long r100);

    void setTimeManagerOldBoot(long r100);
}
