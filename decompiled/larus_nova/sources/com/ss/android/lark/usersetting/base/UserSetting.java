package com.ss.android.lark.usersetting.base;

import com.ss.android.lark.usersetting.entity.BadgeStyle;
import com.ss.android.lark.usersetting.entity.NotificationSettingV2;
import com.ss.android.lark.usersetting.entity.SmsPhoneUrgentSetting;
import com.ss.android.lark.usersetting.service.timeformat.TimeFormatSetting;
import com.ss.android.lark.usersetting.service.timezone.ExposureTimeZoneSetting;
import java.io.Serializable;

/* JADX INFO: loaded from: classes38.dex */
public class UserSetting implements Serializable, Comparable<UserSetting> {
    private boolean autoAudioToText;
    private boolean autoUpdateWorkStatus;
    private BadgeStyle badgeStyle;
    private long doNotDisturbEndTime;
    private ExposureTimeZoneSetting exposureTimeZoneSetting;
    private boolean isMessageNotificationsOff;
    private NotificationSettingV2 notificationSettingV2;
    private boolean showNavMuteBadge;
    private SmsPhoneUrgentSetting smsPhoneUrgentSetting;
    private TimeFormatSetting timeFormatSetting;
    private long updateTime;

    public BadgeStyle getBadgeStyle() {
        return this.badgeStyle;
    }

    public long getDoNotDisturbEndTime() {
        return this.doNotDisturbEndTime;
    }

    public ExposureTimeZoneSetting getExposureTimeZoneSetting() {
        return this.exposureTimeZoneSetting;
    }

    public boolean getIsMessageNotificationsOff() {
        return this.isMessageNotificationsOff;
    }

    public NotificationSettingV2 getNotificationSettingV2() {
        return this.notificationSettingV2;
    }

    public SmsPhoneUrgentSetting getSmsPhoneUrgentSetting() {
        return this.smsPhoneUrgentSetting;
    }

    public TimeFormatSetting getTimeFormatSetting() {
        return this.timeFormatSetting;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public boolean isAutoAudioToText() {
        return this.autoAudioToText;
    }

    public boolean isAutoUpdateWorkStatus() {
        return this.autoUpdateWorkStatus;
    }

    public boolean isShowNavMuteBadge() {
        return this.showNavMuteBadge;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(UserSetting r100) {
        return Long.compare(this.updateTime, r100.updateTime);
    }

    public void setShowNavMuteBadge(boolean r100) {
        this.showNavMuteBadge = r100;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UserSetting r100) {
        return compareTo2(r100);
    }

    public UserSetting(boolean r100, BadgeStyle r101, boolean r102, TimeFormatSetting r103, boolean r104, long r105, SmsPhoneUrgentSetting r106, NotificationSettingV2 r107, long r110, boolean r111, ExposureTimeZoneSetting r112) {
        this.autoUpdateWorkStatus = r100;
        this.badgeStyle = r101;
        this.showNavMuteBadge = r102;
        this.timeFormatSetting = r103;
        this.autoAudioToText = r104;
        this.doNotDisturbEndTime = r105;
        this.smsPhoneUrgentSetting = r106;
        this.notificationSettingV2 = r107;
        this.updateTime = r110;
        this.isMessageNotificationsOff = r111;
        this.exposureTimeZoneSetting = r112;
    }
}
