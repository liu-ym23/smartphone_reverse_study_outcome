package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum AppointmentMessageStatus extends Enum<AppointmentMessageStatus> implements WireEnum {
    private static final /* synthetic */ AppointmentMessageStatus[] $VALUES = null;
    public static final ProtoAdapter<AppointmentMessageStatus> ADAPTER = null;
    public static final AppointmentMessageStatus STATUS_ACTIVE = null;
    public static final AppointmentMessageStatus STATUS_EXPIRED = null;
    public static final AppointmentMessageStatus STATUS_UNKNOWN = null;
    private final int value;

    static {
        AppointmentMessageStatus r100 = new AppointmentMessageStatus("STATUS_UNKNOWN", 0, 0);
        STATUS_UNKNOWN = r100;
        AppointmentMessageStatus r101 = new AppointmentMessageStatus("STATUS_ACTIVE", 1, 1);
        STATUS_ACTIVE = r101;
        AppointmentMessageStatus r102 = new AppointmentMessageStatus("STATUS_EXPIRED", 2, 2);
        STATUS_EXPIRED = r102;
        $VALUES = new AppointmentMessageStatus[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(AppointmentMessageStatus.class);
    }

    public static AppointmentMessageStatus[] values() {
        return (AppointmentMessageStatus[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static AppointmentMessageStatus fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return STATUS_EXPIRED;
    L12:
        return STATUS_ACTIVE;
    L14:
        return STATUS_UNKNOWN;
    }

    public static AppointmentMessageStatus valueOf(String r100) {
        return (AppointmentMessageStatus) a.a(AppointmentMessageStatus.class, r100);
    }

    private AppointmentMessageStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
