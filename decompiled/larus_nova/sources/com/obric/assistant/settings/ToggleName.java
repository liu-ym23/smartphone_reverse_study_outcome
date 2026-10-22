package com.obric.assistant.settings;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001f\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006 "}, d2 = {"Lcom/obric/assistant/settings/ToggleName;", "", "toggleName", "", "isDeprecated", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Z)V", "()Z", "MAIN_TOGGLE", "USE_DATA_ON_LOCK_SCREEN", "CALL_LOGS", "CONTACTS", "MESSAGE", "CLOCK", "NOTES", FlowDoraWifiScene.ALBUM, "RECORD", "IMAGES", "VIDEO", "MEMORY", "FILE_MANAGEMENT", "CALENDAR", "ASSISTANT_ACTIVE_DATA", "EVENT_MEMORY", "COLLECTION_MEMORY", "PERSONAL_INFO_MEMORY", "SCREEN_MEMORY", "AI_DIARY", "HEARING_MEMORY", "GLOBAL_MEMORY", "getToggleName", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ToggleName extends Enum<ToggleName> {
    public static final ToggleName AI_DIARY = null;
    public static final ToggleName ALBUM = null;

    @Deprecated(message = "助手主动开关下线")
    public static final ToggleName ASSISTANT_ACTIVE_DATA = null;
    public static final ToggleName CALENDAR = null;
    public static final ToggleName CALL_LOGS = null;
    public static final ToggleName CLOCK = null;

    @Deprecated(message = "收藏记忆、个人信息记忆、屏幕记忆、听觉记忆合并成全局记忆")
    public static final ToggleName COLLECTION_MEMORY = null;
    public static final ToggleName CONTACTS = null;

    @Deprecated(message = "事件记忆隐藏")
    public static final ToggleName EVENT_MEMORY = null;
    public static final ToggleName FILE_MANAGEMENT = null;
    public static final ToggleName GLOBAL_MEMORY = null;

    @Deprecated(message = "收藏记忆、个人信息记忆、屏幕记忆、听觉记忆合并成全局记忆")
    public static final ToggleName HEARING_MEMORY = null;
    public static final ToggleName IMAGES = null;

    @Deprecated(message = "无用")
    public static final ToggleName MAIN_TOGGLE = null;

    @Deprecated(message = "拆分为事件记忆、收藏记忆、个人信息记忆")
    public static final ToggleName MEMORY = null;
    public static final ToggleName MESSAGE = null;
    public static final ToggleName NOTES = null;

    @Deprecated(message = "收藏记忆、个人信息记忆、屏幕记忆、听觉记忆合并成全局记忆")
    public static final ToggleName PERSONAL_INFO_MEMORY = null;
    public static final ToggleName RECORD = null;

    @Deprecated(message = "收藏记忆、个人信息记忆、屏幕记忆、听觉记忆合并成全局记忆")
    public static final ToggleName SCREEN_MEMORY = null;

    @Deprecated(message = "改用声纹鉴权")
    public static final ToggleName USE_DATA_ON_LOCK_SCREEN = null;
    public static final ToggleName VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ToggleName[] f391767a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f391768b = null;
    private final boolean isDeprecated;
    private final String toggleName;

    public static EnumEntries<ToggleName> getEntries() {
        return f391768b;
    }

    static {
        ToggleName r100 = new ToggleName("MAIN_TOGGLE", 0, "main_toggle", true);
        MAIN_TOGGLE = r100;
        ToggleName r101 = new ToggleName("USE_DATA_ON_LOCK_SCREEN", 1, "use_data_on_lock_screen", true);
        USE_DATA_ON_LOCK_SCREEN = r101;
        boolean r110 = false;
        int r111 = 2;
        DefaultConstructorMarker r112 = null;
        ToggleName r102 = new ToggleName("CALL_LOGS", 2, "call_logs", r110, r111, r112);
        CALL_LOGS = r102;
        ToggleName r103 = new ToggleName("CONTACTS", 3, "contacts", false, 2, null);
        CONTACTS = r103;
        ToggleName r113 = new ToggleName("MESSAGE", 4, "message", r110, r111, r112);
        MESSAGE = r113;
        boolean r114 = false;
        int r115 = 2;
        DefaultConstructorMarker r210 = null;
        ToggleName r104 = new ToggleName("CLOCK", 5, "clock", r114, r115, r210);
        CLOCK = r104;
        boolean r211 = false;
        int r212 = 2;
        DefaultConstructorMarker r213 = null;
        ToggleName r105 = new ToggleName("NOTES", 6, "notes", r211, r212, r213);
        NOTES = r105;
        ToggleName r106 = new ToggleName(FlowDoraWifiScene.ALBUM, 7, "album", r114, r115, r210);
        ALBUM = r106;
        ToggleName r107 = new ToggleName("RECORD", 8, "record", r211, r212, r213);
        RECORD = r107;
        ToggleName r116 = new ToggleName("IMAGES", 9, "images", r114, r115, r210);
        IMAGES = r116;
        ToggleName r117 = new ToggleName("VIDEO", 10, "video", r211, r212, r213);
        VIDEO = r117;
        ToggleName r118 = new ToggleName("MEMORY", 11, "memory", true);
        MEMORY = r118;
        ToggleName r119 = new ToggleName("FILE_MANAGEMENT", 12, "file_management", false, 2, null);
        FILE_MANAGEMENT = r119;
        ToggleName r120 = new ToggleName("CALENDAR", 13, "calendar", false, 2, null);
        CALENDAR = r120;
        ToggleName r108 = new ToggleName("ASSISTANT_ACTIVE_DATA", 14, "assistant_active_memory", true);
        ASSISTANT_ACTIVE_DATA = r108;
        ToggleName r109 = new ToggleName("EVENT_MEMORY", 15, "event_memory", true);
        EVENT_MEMORY = r109;
        ToggleName r121 = new ToggleName("COLLECTION_MEMORY", 16, "collection_memory", true);
        COLLECTION_MEMORY = r121;
        ToggleName r122 = new ToggleName("PERSONAL_INFO_MEMORY", 17, "personal_info_memory", true);
        PERSONAL_INFO_MEMORY = r122;
        ToggleName r123 = new ToggleName("SCREEN_MEMORY", 18, "screen_memory", true);
        SCREEN_MEMORY = r123;
        ToggleName r124 = new ToggleName("AI_DIARY", 19, "ai_diary", false, 2, null);
        AI_DIARY = r124;
        ToggleName r125 = new ToggleName("HEARING_MEMORY", 20, "hearing_memory", true);
        HEARING_MEMORY = r125;
        ToggleName r126 = new ToggleName("GLOBAL_MEMORY", 21, "global_memory", false, 2, null);
        GLOBAL_MEMORY = r126;
        ToggleName[] r127 = {r100, r101, r102, r103, r113, r104, r105, r106, r107, r116, r117, r118, r119, r120, r108, r109, r121, r122, r123, r124, r125, r126};
        f391767a = r127;
        f391768b = EnumEntriesKt.enumEntries(r127);
    }

    public static ToggleName[] values() {
        return (ToggleName[]) f391767a.clone();
    }

    public final String getToggleName() {
        return this.toggleName;
    }

    public final boolean isDeprecated() {
        return this.isDeprecated;
    }

    public static ToggleName valueOf(String r100) {
        return (ToggleName) r27.a.a(ToggleName.class, r100);
    }

    public ToggleName(String r100, int r101, String r102, boolean r103) {
        super(r100, r101);
        this.toggleName = r102;
        this.isDeprecated = r103;
    }

    public /* synthetic */ ToggleName(String r100, int r101, String r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = false;
    L5:
        this(r100, r101, r102, r103);
    }
}
