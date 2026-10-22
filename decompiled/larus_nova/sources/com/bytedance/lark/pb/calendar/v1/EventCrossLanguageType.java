package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum EventCrossLanguageType extends Enum<EventCrossLanguageType> implements WireEnum {
    private static final /* synthetic */ EventCrossLanguageType[] $VALUES = null;
    public static final ProtoAdapter<EventCrossLanguageType> ADAPTER = null;
    public static final EventCrossLanguageType ALL_CHINESE = null;
    public static final EventCrossLanguageType ALL_NON_CHINESE = null;
    public static final EventCrossLanguageType LEAST_ONE_CHINESE_AND_NON_CHINESE = null;
    public static final EventCrossLanguageType TYPE_UNKNOWN = null;
    private final int value;

    static {
        EventCrossLanguageType r100 = new EventCrossLanguageType("TYPE_UNKNOWN", 0, 0);
        TYPE_UNKNOWN = r100;
        EventCrossLanguageType r101 = new EventCrossLanguageType("ALL_CHINESE", 1, 1);
        ALL_CHINESE = r101;
        EventCrossLanguageType r102 = new EventCrossLanguageType("ALL_NON_CHINESE", 2, 2);
        ALL_NON_CHINESE = r102;
        EventCrossLanguageType r103 = new EventCrossLanguageType("LEAST_ONE_CHINESE_AND_NON_CHINESE", 3, 3);
        LEAST_ONE_CHINESE_AND_NON_CHINESE = r103;
        $VALUES = new EventCrossLanguageType[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(EventCrossLanguageType.class);
    }

    public static EventCrossLanguageType[] values() {
        return (EventCrossLanguageType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static EventCrossLanguageType fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return LEAST_ONE_CHINESE_AND_NON_CHINESE;
    L14:
        return ALL_NON_CHINESE;
    L16:
        return ALL_CHINESE;
    L18:
        return TYPE_UNKNOWN;
    }

    public static EventCrossLanguageType valueOf(String r100) {
        return (EventCrossLanguageType) a.a(EventCrossLanguageType.class, r100);
    }

    private EventCrossLanguageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
