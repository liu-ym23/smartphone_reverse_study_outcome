package com.obric.miniapp.calendar;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001a\b\u0086\u0081\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/obric/miniapp/calendar/CalendarOpType;", "", "<init>", "(Ljava/lang/String;I)V", "QUERY_CALENDAR", "MODIFY_CALENDAR", "SYNC_CALENDAR", "DELETE_CALENDAR", "QUERY_EVENT", "ADD_EVENT", "UPDATE_EVENT", "DELETE_EVENT", "SYNC_EVENT", "ADD_ATTENDEE", "QUERY_REMINDER", "ADD_REMINDER", "UPDATE_REMINDER", "DELETE_REMINDER", "SYNC_REMINDER", "QUERY_INSTANCES", "QUERY_EVENT_IDS_OF_INSTANCES", "QUERY_INSTANCES_BETWEEN", "QUERY_ENABLE_EVENTS", "QUERY_BY_KEYWORD", "SYNC_COLORS", "MERGE_CALENDAR", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CalendarOpType extends Enum<CalendarOpType> {
    public static final CalendarOpType ADD_ATTENDEE = null;
    public static final CalendarOpType ADD_EVENT = null;
    public static final CalendarOpType ADD_REMINDER = null;
    public static final a Companion = null;
    public static final CalendarOpType DELETE_CALENDAR = null;
    public static final CalendarOpType DELETE_EVENT = null;
    public static final CalendarOpType DELETE_REMINDER = null;
    public static final CalendarOpType MERGE_CALENDAR = null;
    public static final CalendarOpType MODIFY_CALENDAR = null;
    public static final CalendarOpType QUERY_BY_KEYWORD = null;
    public static final CalendarOpType QUERY_CALENDAR = null;
    public static final CalendarOpType QUERY_ENABLE_EVENTS = null;
    public static final CalendarOpType QUERY_EVENT = null;
    public static final CalendarOpType QUERY_EVENT_IDS_OF_INSTANCES = null;
    public static final CalendarOpType QUERY_INSTANCES = null;
    public static final CalendarOpType QUERY_INSTANCES_BETWEEN = null;
    public static final CalendarOpType QUERY_REMINDER = null;
    public static final CalendarOpType SYNC_CALENDAR = null;
    public static final CalendarOpType SYNC_COLORS = null;
    public static final CalendarOpType SYNC_EVENT = null;
    public static final CalendarOpType SYNC_REMINDER = null;
    public static final CalendarOpType UPDATE_EVENT = null;
    public static final CalendarOpType UPDATE_REMINDER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CalendarOpType[] f397494a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f397495b = null;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<CalendarOpType> getEntries() {
        return f397495b;
    }

    static {
        CalendarOpType r100 = new CalendarOpType("QUERY_CALENDAR", 0);
        QUERY_CALENDAR = r100;
        CalendarOpType r101 = new CalendarOpType("MODIFY_CALENDAR", 1);
        MODIFY_CALENDAR = r101;
        CalendarOpType r102 = new CalendarOpType("SYNC_CALENDAR", 2);
        SYNC_CALENDAR = r102;
        CalendarOpType r103 = new CalendarOpType("DELETE_CALENDAR", 3);
        DELETE_CALENDAR = r103;
        CalendarOpType r104 = new CalendarOpType("QUERY_EVENT", 4);
        QUERY_EVENT = r104;
        CalendarOpType r105 = new CalendarOpType("ADD_EVENT", 5);
        ADD_EVENT = r105;
        CalendarOpType r110 = new CalendarOpType("UPDATE_EVENT", 6);
        UPDATE_EVENT = r110;
        CalendarOpType r111 = new CalendarOpType("DELETE_EVENT", 7);
        DELETE_EVENT = r111;
        CalendarOpType r112 = new CalendarOpType("SYNC_EVENT", 8);
        SYNC_EVENT = r112;
        CalendarOpType r113 = new CalendarOpType("ADD_ATTENDEE", 9);
        ADD_ATTENDEE = r113;
        CalendarOpType r114 = new CalendarOpType("QUERY_REMINDER", 10);
        QUERY_REMINDER = r114;
        CalendarOpType r115 = new CalendarOpType("ADD_REMINDER", 11);
        ADD_REMINDER = r115;
        CalendarOpType r106 = new CalendarOpType("UPDATE_REMINDER", 12);
        UPDATE_REMINDER = r106;
        CalendarOpType r107 = new CalendarOpType("DELETE_REMINDER", 13);
        DELETE_REMINDER = r107;
        CalendarOpType r108 = new CalendarOpType("SYNC_REMINDER", 14);
        SYNC_REMINDER = r108;
        CalendarOpType r109 = new CalendarOpType("QUERY_INSTANCES", 15);
        QUERY_INSTANCES = r109;
        CalendarOpType r116 = new CalendarOpType("QUERY_EVENT_IDS_OF_INSTANCES", 16);
        QUERY_EVENT_IDS_OF_INSTANCES = r116;
        CalendarOpType r117 = new CalendarOpType("QUERY_INSTANCES_BETWEEN", 17);
        QUERY_INSTANCES_BETWEEN = r117;
        CalendarOpType r118 = new CalendarOpType("QUERY_ENABLE_EVENTS", 18);
        QUERY_ENABLE_EVENTS = r118;
        CalendarOpType r119 = new CalendarOpType("QUERY_BY_KEYWORD", 19);
        QUERY_BY_KEYWORD = r119;
        CalendarOpType r120 = new CalendarOpType("SYNC_COLORS", 20);
        SYNC_COLORS = r120;
        CalendarOpType r121 = new CalendarOpType("MERGE_CALENDAR", 21);
        MERGE_CALENDAR = r121;
        CalendarOpType[] r122 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121};
        f397494a = r122;
        f397495b = EnumEntriesKt.enumEntries(r122);
        Companion = new a();
    }

    public static CalendarOpType[] values() {
        return (CalendarOpType[]) f397494a.clone();
    }

    public static CalendarOpType valueOf(String r100) {
        return (CalendarOpType) r27.a.a(CalendarOpType.class, r100);
    }

    public CalendarOpType(String r100, int r101) {
        super(r100, r101);
    }
}
