package com.ss.android.lark.usersetting.entity;

import com.bytedance.lark.pb.settings.v1.MessengerNotificationSetting;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public static NotificationSettingV2 a(com.bytedance.lark.pb.settings.v1.NotificationSettingV2 r100) {
        if (r100 != null) goto L6;
        Log.e("NotificationSettingParser", "parseNotificationSettingV2FromPb failed: pbSettingV2 is null");
        return null;
    L6:
        NotificationSettingV2 r101 = new NotificationSettingV2();
        MessengerNotificationSetting r102 = r100.messenger_notification_setting;
        com.bytedance.lark.pb.settings.v1.DriveNotificationSetting r103 = r100.drive_notification_setting;
        if (r103 != null) goto L9;
        DriveNotificationSetting r104 = null;
    L10:
        if (r104 != null) goto L12;
        Log.e("NotificationSettingParser", "parseNotificationSettingV2FromPb failed: driveNotificationSetting is null");
    L13:
        if (r102 != null) goto L16;
        Log.e("NotificationSettingParser", "parseNotificationSettingV2FromPb failed: msgSetting is null");
        return null;
    L16:
        r101.setChatMsgState(NotificationSettingV2.ChatMsgNotificationState.forNumber(r102.switch_state.getValue()));
        r101.setBuzzOpen(r102.buzz_open.booleanValue());
        r101.setMentionOpen(r102.mention_open.booleanValue());
        r101.setUserSingleChatOpen(r102.user_p2p_chat_open.booleanValue());
        r101.setMentionAllOpen(r102.mention_all_open.booleanValue());
        r101.setSpecialFocusOpen(r102.special_focus_open.booleanValue());
        if (r102.special_focus_setting == null) goto L19;
        r101.setSpecialFocusSetting(new SpecialFocusSetting(r102.special_focus_setting.notice_in_mute_chat.booleanValue(), r102.special_focus_setting.notice_in_chat_box.booleanValue(), r102.special_focus_setting.notice_in_mute_mode.booleanValue()));
    L19:
        return r101;
    L12:
        r101.setDriveNotificationSetting(r104);
        goto L13
    L9:
        r104 = new DriveNotificationSetting(r103.notify_open.booleanValue());
        goto L10
    }
}
