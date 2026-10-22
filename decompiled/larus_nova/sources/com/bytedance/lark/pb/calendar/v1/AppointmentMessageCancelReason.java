package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum AppointmentMessageCancelReason extends Enum<AppointmentMessageCancelReason> implements WireEnum {
    private static final /* synthetic */ AppointmentMessageCancelReason[] $VALUES = null;
    public static final ProtoAdapter<AppointmentMessageCancelReason> ADAPTER = null;
    public static final AppointmentMessageCancelReason CANCEL_REASON_ACTIVELY_CANCEL = null;
    public static final AppointmentMessageCancelReason CANCEL_REASON_CHANGE_HOST = null;
    public static final AppointmentMessageCancelReason CANCEL_REASON_RESCHEDULE = null;
    public static final AppointmentMessageCancelReason CANCEL_REASON_UNKNOWN = null;
    private final int value;

    static {
        AppointmentMessageCancelReason r100 = new AppointmentMessageCancelReason("CANCEL_REASON_UNKNOWN", 0, 0);
        CANCEL_REASON_UNKNOWN = r100;
        AppointmentMessageCancelReason r101 = new AppointmentMessageCancelReason("CANCEL_REASON_ACTIVELY_CANCEL", 1, 1);
        CANCEL_REASON_ACTIVELY_CANCEL = r101;
        AppointmentMessageCancelReason r102 = new AppointmentMessageCancelReason("CANCEL_REASON_RESCHEDULE", 2, 2);
        CANCEL_REASON_RESCHEDULE = r102;
        AppointmentMessageCancelReason r103 = new AppointmentMessageCancelReason("CANCEL_REASON_CHANGE_HOST", 3, 3);
        CANCEL_REASON_CHANGE_HOST = r103;
        $VALUES = new AppointmentMessageCancelReason[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(AppointmentMessageCancelReason.class);
    }

    public static AppointmentMessageCancelReason[] values() {
        return (AppointmentMessageCancelReason[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static AppointmentMessageCancelReason fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return CANCEL_REASON_CHANGE_HOST;
    L14:
        return CANCEL_REASON_RESCHEDULE;
    L16:
        return CANCEL_REASON_ACTIVELY_CANCEL;
    L18:
        return CANCEL_REASON_UNKNOWN;
    }

    public static AppointmentMessageCancelReason valueOf(String r100) {
        return (AppointmentMessageCancelReason) a.a(AppointmentMessageCancelReason.class, r100);
    }

    private AppointmentMessageCancelReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
