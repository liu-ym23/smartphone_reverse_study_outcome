package com.ss.android.lark.biz.im.extension.chat_window.keyboard_top;

import com.obric.miniapp.alarm.AlarmSessionType;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/biz/im/extension/chat_window/keyboard_top/ExtendType;", "", "value", "", SocialConstants.PARAM_APP_DESC, "", "areaType", "<init>", "(Ljava/lang/String;IILjava/lang/String;I)V", "getValue", "()I", "getDesc", "()Ljava/lang/String;", "getAreaType", "UNKNOWN", "ON_CALL", AlarmSessionType.TODO, "TEAM", "TOOL_KIT", "SCHEDULE_SEND", "TIME_ZONE", "STATUS_INFO", "AI", "AI_THREAD_CUSTOM_EXTENSION", "BOT_NEW_MENU", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ExtendType extends Enum<ExtendType> {
    public static final ExtendType AI = null;
    public static final ExtendType AI_THREAD_CUSTOM_EXTENSION = null;
    public static final ExtendType BOT_NEW_MENU = null;
    public static final ExtendType ON_CALL = null;
    public static final ExtendType SCHEDULE_SEND = null;
    public static final ExtendType STATUS_INFO = null;
    public static final ExtendType TEAM = null;
    public static final ExtendType TIME_ZONE = null;
    public static final ExtendType TODO = null;
    public static final ExtendType TOOL_KIT = null;
    public static final ExtendType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExtendType[] f410494a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410495b = null;
    private final int areaType;
    private final String desc;
    private final int value;

    public static EnumEntries<ExtendType> getEntries() {
        return f410495b;
    }

    static {
        ExtendType r100 = new ExtendType("UNKNOWN", 0, 0, "Unknown", -1);
        UNKNOWN = r100;
        ExtendType r101 = new ExtendType("ON_CALL", 1, 1, "OnCall", 1);
        ON_CALL = r101;
        ExtendType r102 = new ExtendType(AlarmSessionType.TODO, 2, 2, "Todo", 1);
        TODO = r102;
        ExtendType r103 = new ExtendType("TEAM", 3, 3, "Team", 1);
        TEAM = r103;
        ExtendType r104 = new ExtendType("TOOL_KIT", 4, 4, "ToolKit", 1);
        TOOL_KIT = r104;
        ExtendType r105 = new ExtendType("SCHEDULE_SEND", 5, 5, "ScheduleSend", 0);
        SCHEDULE_SEND = r105;
        ExtendType r106 = new ExtendType("TIME_ZONE", 6, 6, "TimeZone", 0);
        TIME_ZONE = r106;
        ExtendType r110 = new ExtendType("STATUS_INFO", 7, 7, "StatusInfo", 1);
        STATUS_INFO = r110;
        ExtendType r107 = new ExtendType("AI", 8, 8, "AI", 1);
        AI = r107;
        ExtendType r108 = new ExtendType("AI_THREAD_CUSTOM_EXTENSION", 9, 9, "MeetingQuickAction", 1);
        AI_THREAD_CUSTOM_EXTENSION = r108;
        ExtendType r109 = new ExtendType("BOT_NEW_MENU", 10, 10, "BotNewMenu", 1);
        BOT_NEW_MENU = r109;
        ExtendType[] r111 = {r100, r101, r102, r103, r104, r105, r106, r110, r107, r108, r109};
        f410494a = r111;
        f410495b = EnumEntriesKt.enumEntries(r111);
    }

    public static ExtendType[] values() {
        return (ExtendType[]) f410494a.clone();
    }

    public final int getAreaType() {
        return this.areaType;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getValue() {
        return this.value;
    }

    public static ExtendType valueOf(String r100) {
        return (ExtendType) a.a(ExtendType.class, r100);
    }

    public ExtendType(String r100, int r101, int r102, String r103, int r104) {
        super(r100, r101);
        this.value = r102;
        this.desc = r103;
        this.areaType = r104;
    }
}
