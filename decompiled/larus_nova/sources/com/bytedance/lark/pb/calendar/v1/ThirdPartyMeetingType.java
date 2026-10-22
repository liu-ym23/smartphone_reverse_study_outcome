package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ThirdPartyMeetingType extends Enum<ThirdPartyMeetingType> implements WireEnum {
    private static final /* synthetic */ ThirdPartyMeetingType[] $VALUES = null;
    public static final ProtoAdapter<ThirdPartyMeetingType> ADAPTER = null;
    public static final ThirdPartyMeetingType JULIAN = null;
    public static final ThirdPartyMeetingType UNKNOWN_MEETING_TYPE = null;
    private final int value;

    static {
        ThirdPartyMeetingType r100 = new ThirdPartyMeetingType("UNKNOWN_MEETING_TYPE", 0, 0);
        UNKNOWN_MEETING_TYPE = r100;
        ThirdPartyMeetingType r101 = new ThirdPartyMeetingType("JULIAN", 1, 1);
        JULIAN = r101;
        $VALUES = new ThirdPartyMeetingType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(ThirdPartyMeetingType.class);
    }

    public static ThirdPartyMeetingType[] values() {
        return (ThirdPartyMeetingType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ThirdPartyMeetingType fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return JULIAN;
    L10:
        return UNKNOWN_MEETING_TYPE;
    }

    public static ThirdPartyMeetingType valueOf(String r100) {
        return (ThirdPartyMeetingType) a.a(ThirdPartyMeetingType.class, r100);
    }

    private ThirdPartyMeetingType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
