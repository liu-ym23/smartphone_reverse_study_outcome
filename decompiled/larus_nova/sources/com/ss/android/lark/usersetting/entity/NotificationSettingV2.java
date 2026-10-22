package com.ss.android.lark.usersetting.entity;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import java.io.Serializable;

/* JADX INFO: loaded from: classes38.dex */
public class NotificationSettingV2 implements Serializable {
    private ChatMsgNotificationState chatMsgState;
    private DriveNotificationSetting driveNotificationSetting;
    private boolean isBuzzOpen;
    private boolean isMentionAllOpen;
    private boolean isMentionOpen;
    private boolean isSpecialFocusOpen;
    private boolean isUserSingleChatOpen;
    private SpecialFocusSetting specialFocusSetting;

    public static final enum ChatMsgNotificationState extends Enum<ChatMsgNotificationState> {
        public static final ChatMsgNotificationState CLOSED = null;
        public static final ChatMsgNotificationState HALF_OPEN = null;
        public static final ChatMsgNotificationState OPEN = null;
        public static final ChatMsgNotificationState UNKNOWN_STATE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChatMsgNotificationState[] f444628a = null;
        private int value;

        static {
            ChatMsgNotificationState r100 = new ChatMsgNotificationState("UNKNOWN_STATE", 0, 0);
            UNKNOWN_STATE = r100;
            ChatMsgNotificationState r101 = new ChatMsgNotificationState(ErrorCode.CLOSED, 1, 1);
            CLOSED = r101;
            ChatMsgNotificationState r102 = new ChatMsgNotificationState("HALF_OPEN", 2, 2);
            HALF_OPEN = r102;
            ChatMsgNotificationState r103 = new ChatMsgNotificationState("OPEN", 3, 3);
            OPEN = r103;
            f444628a = new ChatMsgNotificationState[]{r100, r101, r102, r103};
        }

        public static ChatMsgNotificationState[] values() {
            return (ChatMsgNotificationState[]) f444628a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static ChatMsgNotificationState forNumber(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return UNKNOWN_STATE;
        L11:
            return OPEN;
        L13:
            return HALF_OPEN;
        L15:
            return CLOSED;
        }

        public static ChatMsgNotificationState valueOf(String r100) {
            return (ChatMsgNotificationState) r27.a.a(ChatMsgNotificationState.class, r100);
        }

        public static ChatMsgNotificationState valueOf(int r100) {
            return forNumber(r100);
        }

        public ChatMsgNotificationState(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public NotificationSettingV2 openBuzz() {
        setBuzzOpen(true);
        return this;
    }

    public NotificationSettingV2 openMention() {
        setMentionOpen(true);
        return this;
    }

    public NotificationSettingV2 openMentionAll() {
        setMentionAllOpen(true);
        return this;
    }

    public NotificationSettingV2 openSpecialFocus() {
        setSpecialFocusOpen(true);
        return this;
    }

    public NotificationSettingV2 openUserSingleChat() {
        setUserSingleChatOpen(true);
        return this;
    }

    public void setBuzzOpen(boolean r100) {
    }

    public static NotificationSettingV2 allInstance() {
        return new NotificationSettingV2(ChatMsgNotificationState.OPEN);
    }

    public static NotificationSettingV2 halfOpenInstance() {
        return new NotificationSettingV2(ChatMsgNotificationState.HALF_OPEN);
    }

    public static NotificationSettingV2 noneInstance() {
        return new NotificationSettingV2(ChatMsgNotificationState.CLOSED);
    }

    public NotificationSettingV2 closeNotify() {
        this.chatMsgState = ChatMsgNotificationState.CLOSED;
        return this;
    }

    public NotificationSettingV2 halfOpenNotify() {
        this.chatMsgState = ChatMsgNotificationState.HALF_OPEN;
        return this;
    }

    public boolean isAll() {
        ChatMsgNotificationState r100 = this.chatMsgState;
        if (r100 != ChatMsgNotificationState.HALF_OPEN) goto L5;
    L7:
        return false;
    L5:
        if (r100 == ChatMsgNotificationState.CLOSED) goto L7;
        return true;
    }

    public boolean isHalfOpen() {
        if (this.chatMsgState != ChatMsgNotificationState.HALF_OPEN) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNone() {
        if (this.chatMsgState != ChatMsgNotificationState.CLOSED) goto L5;
        return true;
    L5:
        return false;
    }

    public NotificationSettingV2 openNotify() {
        this.chatMsgState = ChatMsgNotificationState.OPEN;
        return this;
    }

    public NotificationSettingV2() {
        this.chatMsgState = ChatMsgNotificationState.OPEN;
        this.isBuzzOpen = true;
        this.driveNotificationSetting = new DriveNotificationSetting(true);
    }

    public ChatMsgNotificationState getChatMsgState() {
        return this.chatMsgState;
    }

    public DriveNotificationSetting getDriveNotificationSetting() {
        return this.driveNotificationSetting;
    }

    public SpecialFocusSetting getSpecialFocusSetting() {
        return this.specialFocusSetting;
    }

    public boolean isBuzzOpen() {
        return this.isBuzzOpen;
    }

    public boolean isMentionAllOpen() {
        return this.isMentionAllOpen;
    }

    public boolean isMentionOpen() {
        return this.isMentionOpen;
    }

    public boolean isSpecialFocusOpen() {
        return this.isSpecialFocusOpen;
    }

    public boolean isUserSingleChatOpen() {
        return this.isUserSingleChatOpen;
    }

    public NotificationSettingV2(ChatMsgNotificationState r100) {
        this.chatMsgState = ChatMsgNotificationState.OPEN;
        this.isBuzzOpen = true;
        this.driveNotificationSetting = new DriveNotificationSetting(true);
        this.chatMsgState = r100;
    }

    public void setChatMsgState(ChatMsgNotificationState r100) {
        this.chatMsgState = r100;
    }

    public void setDriveNotificationSetting(DriveNotificationSetting r100) {
        this.driveNotificationSetting = r100;
    }

    public void setMentionAllOpen(boolean r100) {
        this.isMentionAllOpen = r100;
    }

    public void setMentionOpen(boolean r100) {
        this.isMentionOpen = r100;
    }

    public void setSpecialFocusOpen(boolean r100) {
        this.isSpecialFocusOpen = r100;
    }

    public void setSpecialFocusSetting(SpecialFocusSetting r100) {
        this.specialFocusSetting = r100;
    }

    public void setUserSingleChatOpen(boolean r100) {
        this.isUserSingleChatOpen = r100;
    }
}
