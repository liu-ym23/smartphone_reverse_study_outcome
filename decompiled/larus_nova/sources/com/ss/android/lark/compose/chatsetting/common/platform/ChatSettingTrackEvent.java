package com.ss.android.lark.compose.chatsetting.common.platform;

import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/compose/chatsetting/common/platform/ChatSettingTrackEvent;", "", "<init>", "(Ljava/lang/String;I)V", "GROUP_MEMBER", "GROUP_MEMBER_AVATAR", "GROUP_MEMBER_ADD", "GROUP_MEMBER_DELETE", "EDIT_GROUP_INFO", "GROUP_QR_CODE", "GROUP_MANAGE", "MUTE_TOGGLE", "PIN_TOGGLE", "SEARCH", "CLEAR_HISTORY_ENTRY", "CLEAR_HISTORY_CONFIRM", "DISMISS_GROUP_ENTRY", "DISMISS_GROUP_CONFIRM", "QUIT_GROUP_ENTRY", "QUIT_GROUP_CONFIRM", OpenNetMethod.REPORT, "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatSettingTrackEvent extends Enum<ChatSettingTrackEvent> {
    public static final ChatSettingTrackEvent CLEAR_HISTORY_CONFIRM = null;
    public static final ChatSettingTrackEvent CLEAR_HISTORY_ENTRY = null;
    public static final ChatSettingTrackEvent DISMISS_GROUP_CONFIRM = null;
    public static final ChatSettingTrackEvent DISMISS_GROUP_ENTRY = null;
    public static final ChatSettingTrackEvent EDIT_GROUP_INFO = null;
    public static final ChatSettingTrackEvent GROUP_MANAGE = null;
    public static final ChatSettingTrackEvent GROUP_MEMBER = null;
    public static final ChatSettingTrackEvent GROUP_MEMBER_ADD = null;
    public static final ChatSettingTrackEvent GROUP_MEMBER_AVATAR = null;
    public static final ChatSettingTrackEvent GROUP_MEMBER_DELETE = null;
    public static final ChatSettingTrackEvent GROUP_QR_CODE = null;
    public static final ChatSettingTrackEvent MUTE_TOGGLE = null;
    public static final ChatSettingTrackEvent PIN_TOGGLE = null;
    public static final ChatSettingTrackEvent QUIT_GROUP_CONFIRM = null;
    public static final ChatSettingTrackEvent QUIT_GROUP_ENTRY = null;
    public static final ChatSettingTrackEvent REPORT = null;
    public static final ChatSettingTrackEvent SEARCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatSettingTrackEvent[] f417364a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f417365b = null;

    public static EnumEntries<ChatSettingTrackEvent> getEntries() {
        return f417365b;
    }

    static {
        ChatSettingTrackEvent r100 = new ChatSettingTrackEvent("GROUP_MEMBER", 0);
        GROUP_MEMBER = r100;
        ChatSettingTrackEvent r101 = new ChatSettingTrackEvent("GROUP_MEMBER_AVATAR", 1);
        GROUP_MEMBER_AVATAR = r101;
        ChatSettingTrackEvent r102 = new ChatSettingTrackEvent("GROUP_MEMBER_ADD", 2);
        GROUP_MEMBER_ADD = r102;
        ChatSettingTrackEvent r103 = new ChatSettingTrackEvent("GROUP_MEMBER_DELETE", 3);
        GROUP_MEMBER_DELETE = r103;
        ChatSettingTrackEvent r104 = new ChatSettingTrackEvent("EDIT_GROUP_INFO", 4);
        EDIT_GROUP_INFO = r104;
        ChatSettingTrackEvent r105 = new ChatSettingTrackEvent("GROUP_QR_CODE", 5);
        GROUP_QR_CODE = r105;
        ChatSettingTrackEvent r110 = new ChatSettingTrackEvent("GROUP_MANAGE", 6);
        GROUP_MANAGE = r110;
        ChatSettingTrackEvent r111 = new ChatSettingTrackEvent("MUTE_TOGGLE", 7);
        MUTE_TOGGLE = r111;
        ChatSettingTrackEvent r112 = new ChatSettingTrackEvent("PIN_TOGGLE", 8);
        PIN_TOGGLE = r112;
        ChatSettingTrackEvent r113 = new ChatSettingTrackEvent("SEARCH", 9);
        SEARCH = r113;
        ChatSettingTrackEvent r114 = new ChatSettingTrackEvent("CLEAR_HISTORY_ENTRY", 10);
        CLEAR_HISTORY_ENTRY = r114;
        ChatSettingTrackEvent r115 = new ChatSettingTrackEvent("CLEAR_HISTORY_CONFIRM", 11);
        CLEAR_HISTORY_CONFIRM = r115;
        ChatSettingTrackEvent r106 = new ChatSettingTrackEvent("DISMISS_GROUP_ENTRY", 12);
        DISMISS_GROUP_ENTRY = r106;
        ChatSettingTrackEvent r107 = new ChatSettingTrackEvent("DISMISS_GROUP_CONFIRM", 13);
        DISMISS_GROUP_CONFIRM = r107;
        ChatSettingTrackEvent r108 = new ChatSettingTrackEvent("QUIT_GROUP_ENTRY", 14);
        QUIT_GROUP_ENTRY = r108;
        ChatSettingTrackEvent r109 = new ChatSettingTrackEvent("QUIT_GROUP_CONFIRM", 15);
        QUIT_GROUP_CONFIRM = r109;
        ChatSettingTrackEvent r116 = new ChatSettingTrackEvent(OpenNetMethod.REPORT, 16);
        REPORT = r116;
        ChatSettingTrackEvent[] r117 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116};
        f417364a = r117;
        f417365b = EnumEntriesKt.enumEntries(r117);
    }

    public static ChatSettingTrackEvent[] values() {
        return (ChatSettingTrackEvent[]) f417364a.clone();
    }

    public static ChatSettingTrackEvent valueOf(String r100) {
        return (ChatSettingTrackEvent) r27.a.a(ChatSettingTrackEvent.class, r100);
    }

    public ChatSettingTrackEvent(String r100, int r101) {
        super(r100, r101);
    }
}
