package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum WebinarAttendeeType extends Enum<WebinarAttendeeType> implements WireEnum {
    private static final /* synthetic */ WebinarAttendeeType[] $VALUES = null;
    public static final ProtoAdapter<WebinarAttendeeType> ADAPTER = null;
    public static final WebinarAttendeeType Audience = null;
    public static final WebinarAttendeeType Speaker = null;
    public static final WebinarAttendeeType Unknown = null;
    private final int value;

    static {
        WebinarAttendeeType r100 = new WebinarAttendeeType("Unknown", 0, 0);
        Unknown = r100;
        WebinarAttendeeType r101 = new WebinarAttendeeType("Speaker", 1, 1);
        Speaker = r101;
        WebinarAttendeeType r102 = new WebinarAttendeeType("Audience", 2, 2);
        Audience = r102;
        $VALUES = new WebinarAttendeeType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(WebinarAttendeeType.class);
    }

    public static WebinarAttendeeType[] values() {
        return (WebinarAttendeeType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static WebinarAttendeeType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return Audience;
    L12:
        return Speaker;
    L14:
        return Unknown;
    }

    public static WebinarAttendeeType valueOf(String r100) {
        return (WebinarAttendeeType) a.a(WebinarAttendeeType.class, r100);
    }

    private WebinarAttendeeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
