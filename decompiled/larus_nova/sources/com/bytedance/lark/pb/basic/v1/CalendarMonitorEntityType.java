package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum CalendarMonitorEntityType extends Enum<CalendarMonitorEntityType> implements WireEnum {
    private static final /* synthetic */ CalendarMonitorEntityType[] $VALUES = null;
    public static final ProtoAdapter<CalendarMonitorEntityType> ADAPTER = null;
    public static final CalendarMonitorEntityType CALENDAR_MONITOR_UNKNOWN = null;
    public static final CalendarMonitorEntityType FROM_LLM_CHECK = null;
    public static final CalendarMonitorEntityType FROM_REGEX_MATCH = null;
    private final int value;

    static {
        CalendarMonitorEntityType r100 = new CalendarMonitorEntityType("CALENDAR_MONITOR_UNKNOWN", 0, 0);
        CALENDAR_MONITOR_UNKNOWN = r100;
        CalendarMonitorEntityType r101 = new CalendarMonitorEntityType("FROM_REGEX_MATCH", 1, 1);
        FROM_REGEX_MATCH = r101;
        CalendarMonitorEntityType r102 = new CalendarMonitorEntityType("FROM_LLM_CHECK", 2, 2);
        FROM_LLM_CHECK = r102;
        $VALUES = new CalendarMonitorEntityType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(CalendarMonitorEntityType.class);
    }

    public static CalendarMonitorEntityType[] values() {
        return (CalendarMonitorEntityType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static CalendarMonitorEntityType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return FROM_LLM_CHECK;
    L12:
        return FROM_REGEX_MATCH;
    L14:
        return CALENDAR_MONITOR_UNKNOWN;
    }

    public static CalendarMonitorEntityType valueOf(String r100) {
        return (CalendarMonitorEntityType) a.a(CalendarMonitorEntityType.class, r100);
    }

    private CalendarMonitorEntityType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
