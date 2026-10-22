package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum AppointmentMessageExpiredReason extends Enum<AppointmentMessageExpiredReason> implements WireEnum {
    private static final /* synthetic */ AppointmentMessageExpiredReason[] $VALUES = null;
    public static final ProtoAdapter<AppointmentMessageExpiredReason> ADAPTER = null;
    public static final AppointmentMessageExpiredReason EXPIRED_REASON_CANCEL = null;
    public static final AppointmentMessageExpiredReason EXPIRED_REASON_CHANGE_HOST = null;
    public static final AppointmentMessageExpiredReason EXPIRED_REASON_RESCHEDULE = null;
    public static final AppointmentMessageExpiredReason EXPIRED_REASON_UNKNOWN = null;
    private final int value;

    static {
        AppointmentMessageExpiredReason r100 = new AppointmentMessageExpiredReason("EXPIRED_REASON_UNKNOWN", 0, 0);
        EXPIRED_REASON_UNKNOWN = r100;
        AppointmentMessageExpiredReason r101 = new AppointmentMessageExpiredReason("EXPIRED_REASON_RESCHEDULE", 1, 1);
        EXPIRED_REASON_RESCHEDULE = r101;
        AppointmentMessageExpiredReason r102 = new AppointmentMessageExpiredReason("EXPIRED_REASON_CANCEL", 2, 2);
        EXPIRED_REASON_CANCEL = r102;
        AppointmentMessageExpiredReason r103 = new AppointmentMessageExpiredReason("EXPIRED_REASON_CHANGE_HOST", 3, 3);
        EXPIRED_REASON_CHANGE_HOST = r103;
        $VALUES = new AppointmentMessageExpiredReason[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(AppointmentMessageExpiredReason.class);
    }

    public static AppointmentMessageExpiredReason[] values() {
        return (AppointmentMessageExpiredReason[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static AppointmentMessageExpiredReason fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return EXPIRED_REASON_CHANGE_HOST;
    L14:
        return EXPIRED_REASON_CANCEL;
    L16:
        return EXPIRED_REASON_RESCHEDULE;
    L18:
        return EXPIRED_REASON_UNKNOWN;
    }

    public static AppointmentMessageExpiredReason valueOf(String r100) {
        return (AppointmentMessageExpiredReason) a.a(AppointmentMessageExpiredReason.class, r100);
    }

    private AppointmentMessageExpiredReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
