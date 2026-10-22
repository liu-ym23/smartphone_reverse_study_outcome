package com.ss.android.lark.intent.export.entity.output;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/Direction;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN_PAGE_MESSAGE", "CHAT", "CHATTER", "CALENDER_EDIT", "MAIN_PAGE_CALENDAR", "CALENDAR_DETAIL", "CALENDAR_CALL_BACK", "CALLBACK_ASR_RESULT", "CALLBACK_SEARCH_CONTACT", "SEND_MESSAGE", "QUERY_KNOWLEDGE_AI_SYNC", "QUERY_KNOWLEDGE_AI_ASYNC", "WEB_URL", "ERROR", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Direction extends Enum<Direction> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ Direction[] $VALUES = null;
    public static final Direction CALENDAR_CALL_BACK = null;
    public static final Direction CALENDAR_DETAIL = null;
    public static final Direction CALENDER_EDIT = null;
    public static final Direction CALLBACK_ASR_RESULT = null;
    public static final Direction CALLBACK_SEARCH_CONTACT = null;
    public static final Direction CHAT = null;
    public static final Direction CHATTER = null;
    public static final Direction ERROR = null;
    public static final Direction MAIN_PAGE_CALENDAR = null;
    public static final Direction MAIN_PAGE_MESSAGE = null;
    public static final Direction QUERY_KNOWLEDGE_AI_ASYNC = null;
    public static final Direction QUERY_KNOWLEDGE_AI_SYNC = null;
    public static final Direction SEND_MESSAGE = null;
    public static final Direction WEB_URL = null;

    private static final /* synthetic */ Direction[] $values() {
        return new Direction[]{MAIN_PAGE_MESSAGE, CHAT, CHATTER, CALENDER_EDIT, MAIN_PAGE_CALENDAR, CALENDAR_DETAIL, CALENDAR_CALL_BACK, CALLBACK_ASR_RESULT, CALLBACK_SEARCH_CONTACT, SEND_MESSAGE, QUERY_KNOWLEDGE_AI_SYNC, QUERY_KNOWLEDGE_AI_ASYNC, WEB_URL, ERROR};
    }

    public static EnumEntries<Direction> getEntries() {
        return $ENTRIES;
    }

    static {
        MAIN_PAGE_MESSAGE = new Direction("MAIN_PAGE_MESSAGE", 0);
        CHAT = new Direction("CHAT", 1);
        CHATTER = new Direction("CHATTER", 2);
        CALENDER_EDIT = new Direction("CALENDER_EDIT", 3);
        MAIN_PAGE_CALENDAR = new Direction("MAIN_PAGE_CALENDAR", 4);
        CALENDAR_DETAIL = new Direction("CALENDAR_DETAIL", 5);
        CALENDAR_CALL_BACK = new Direction("CALENDAR_CALL_BACK", 6);
        CALLBACK_ASR_RESULT = new Direction("CALLBACK_ASR_RESULT", 7);
        CALLBACK_SEARCH_CONTACT = new Direction("CALLBACK_SEARCH_CONTACT", 8);
        SEND_MESSAGE = new Direction("SEND_MESSAGE", 9);
        QUERY_KNOWLEDGE_AI_SYNC = new Direction("QUERY_KNOWLEDGE_AI_SYNC", 10);
        QUERY_KNOWLEDGE_AI_ASYNC = new Direction("QUERY_KNOWLEDGE_AI_ASYNC", 11);
        WEB_URL = new Direction("WEB_URL", 12);
        ERROR = new Direction("ERROR", 13);
        Direction[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static Direction[] values() {
        return (Direction[]) $VALUES.clone();
    }

    public static Direction valueOf(String r100) {
        return (Direction) a.a(Direction.class, r100);
    }

    private Direction(String r100, int r101) {
        super(r100, r101);
    }
}
