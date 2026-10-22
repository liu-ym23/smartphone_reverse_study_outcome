package com.obric.assistant.settings;

import android.util.EventsUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.xmlpull.v1.XmlPullParser;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001f\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006 "}, d2 = {"Lcom/obric/assistant/settings/ToggleName;", XmlPullParser.NO_NAMESPACE, "toggleName", XmlPullParser.NO_NAMESPACE, "isDeprecated", XmlPullParser.NO_NAMESPACE, "<init>", "(Ljava/lang/String;ILjava/lang/String;Z)V", "()Z", "MAIN_TOGGLE", "USE_DATA_ON_LOCK_SCREEN", "CALL_LOGS", "CONTACTS", "MESSAGE", "CLOCK", "NOTES", "ALBUM", "RECORD", "IMAGES", "VIDEO", "MEMORY", "FILE_MANAGEMENT", "CALENDAR", "ASSISTANT_ACTIVE_DATA", "EVENT_MEMORY", "COLLECTION_MEMORY", "PERSONAL_INFO_MEMORY", "SCREEN_MEMORY", "AI_DIARY", "HEARING_MEMORY", "GLOBAL_MEMORY", "getToggleName", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
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
    public static final /* synthetic */ ToggleName[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final boolean isDeprecated;
    private final String toggleName;

    public static EnumEntries<ToggleName> getEntries() {
        return b;
    }

    static {
        ToggleName r0 = new ToggleName("MAIN_TOGGLE", 0, "main_toggle", true);
        MAIN_TOGGLE = r0;
        ToggleName r1 = new ToggleName("USE_DATA_ON_LOCK_SCREEN", 1, "use_data_on_lock_screen", true);
        USE_DATA_ON_LOCK_SCREEN = r1;
        boolean r10 = false;
        int r11 = 2;
        DefaultConstructorMarker r12 = null;
        ToggleName r3 = new ToggleName("CALL_LOGS", 2, "call_logs", r10, r11, r12);
        CALL_LOGS = r3;
        ToggleName r5 = new ToggleName("CONTACTS", 3, "contacts", false, 2, null);
        CONTACTS = r5;
        ToggleName r13 = new ToggleName("MESSAGE", 4, "message", r10, r11, r12);
        MESSAGE = r13;
        boolean r18 = false;
        int r19 = 2;
        DefaultConstructorMarker r20 = null;
        ToggleName r6 = new ToggleName("CLOCK", 5, "clock", r18, r19, r20);
        CLOCK = r6;
        boolean r25 = false;
        int r26 = 2;
        DefaultConstructorMarker r28 = null;
        ToggleName r7 = new ToggleName("NOTES", 6, "notes", r25, r26, r28);
        NOTES = r7;
        ToggleName r8 = new ToggleName("ALBUM", 7, "album", r18, r19, r20);
        ALBUM = r8;
        ToggleName r9 = new ToggleName("RECORD", 8, "record", r25, r26, r28);
        RECORD = r9;
        ToggleName r14 = new ToggleName("IMAGES", 9, "images", r18, r19, r20);
        IMAGES = r14;
        ToggleName r15 = new ToggleName("VIDEO", 10, "video", r25, r26, r28);
        VIDEO = r15;
        ToggleName r16 = new ToggleName("MEMORY", 11, "memory", true);
        MEMORY = r16;
        ToggleName r17 = new ToggleName("FILE_MANAGEMENT", 12, "file_management", false, 2, null);
        FILE_MANAGEMENT = r17;
        ToggleName r110 = new ToggleName("CALENDAR", 13, "calendar", false, 2, null);
        CALENDAR = r110;
        ToggleName r2 = new ToggleName("ASSISTANT_ACTIVE_DATA", 14, "assistant_active_memory", true);
        ASSISTANT_ACTIVE_DATA = r2;
        ToggleName r4 = new ToggleName("EVENT_MEMORY", 15, "event_memory", true);
        EVENT_MEMORY = r4;
        ToggleName r111 = new ToggleName("COLLECTION_MEMORY", 16, "collection_memory", true);
        COLLECTION_MEMORY = r111;
        ToggleName r21 = new ToggleName("PERSONAL_INFO_MEMORY", 17, "personal_info_memory", true);
        PERSONAL_INFO_MEMORY = r21;
        ToggleName r22 = new ToggleName("SCREEN_MEMORY", 18, "screen_memory", true);
        SCREEN_MEMORY = r22;
        ToggleName r112 = new ToggleName("AI_DIARY", 19, "ai_diary", false, 2, null);
        AI_DIARY = r112;
        ToggleName r113 = new ToggleName("HEARING_MEMORY", 20, "hearing_memory", true);
        HEARING_MEMORY = r113;
        ToggleName r23 = new ToggleName("GLOBAL_MEMORY", 21, "global_memory", false, 2, null);
        GLOBAL_MEMORY = r23;
        ToggleName[] r24 = {r0, r1, r3, r5, r13, r6, r7, r8, r9, r14, r15, r16, r17, r110, r2, r4, r111, r21, r22, r112, r113, r23};
        a = r24;
        b = EnumEntriesKt.enumEntries(r24);
    }

    public static ToggleName[] values() {
        return (ToggleName[]) a.clone();
    }

    public final String getToggleName() {
        return this.toggleName;
    }

    public final boolean isDeprecated() {
        return this.isDeprecated;
    }

    public static ToggleName valueOf(String r1) {
        return (ToggleName) a.a(ToggleName.class, r1);
    }

    public ToggleName(String r1, int r2, String r3, boolean r4) {
        super(r1, r2);
        this.toggleName = r3;
        this.isDeprecated = r4;
    }

    public /* synthetic */ ToggleName(String r1, int r2, String r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L5;
        r4 = false;
    L5:
        this(r1, r2, r3, r4);
    }
}
