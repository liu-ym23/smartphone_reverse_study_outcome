package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum AppointmentAction extends Enum<AppointmentAction> implements WireEnum {
    private static final /* synthetic */ AppointmentAction[] $VALUES = null;
    public static final AppointmentAction ACTION_CANCEL = null;
    public static final AppointmentAction ACTION_CHANGE_HOST = null;
    public static final AppointmentAction ACTION_CREATE = null;
    public static final AppointmentAction ACTION_RESCHEDULE = null;
    public static final AppointmentAction ACTION_UNKNOWN = null;
    public static final ProtoAdapter<AppointmentAction> ADAPTER = null;
    private final int value;

    static {
        AppointmentAction r100 = new AppointmentAction("ACTION_UNKNOWN", 0, 0);
        ACTION_UNKNOWN = r100;
        AppointmentAction r101 = new AppointmentAction("ACTION_CREATE", 1, 1);
        ACTION_CREATE = r101;
        AppointmentAction r102 = new AppointmentAction("ACTION_RESCHEDULE", 2, 2);
        ACTION_RESCHEDULE = r102;
        AppointmentAction r103 = new AppointmentAction("ACTION_CANCEL", 3, 3);
        ACTION_CANCEL = r103;
        AppointmentAction r104 = new AppointmentAction("ACTION_CHANGE_HOST", 4, 4);
        ACTION_CHANGE_HOST = r104;
        $VALUES = new AppointmentAction[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(AppointmentAction.class);
    }

    public static AppointmentAction[] values() {
        return (AppointmentAction[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static AppointmentAction fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return ACTION_CHANGE_HOST;
    L16:
        return ACTION_CANCEL;
    L18:
        return ACTION_RESCHEDULE;
    L20:
        return ACTION_CREATE;
    L22:
        return ACTION_UNKNOWN;
    }

    public static AppointmentAction valueOf(String r100) {
        return (AppointmentAction) a.a(AppointmentAction.class, r100);
    }

    private AppointmentAction(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
