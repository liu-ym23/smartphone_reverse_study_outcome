package com.lark.kmp.pb.calendar.v1;

import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/AppointmentMessageCancelReason;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CANCEL_REASON_UNKNOWN", "CANCEL_REASON_ACTIVELY_CANCEL", "CANCEL_REASON_RESCHEDULE", "CANCEL_REASON_CHANGE_HOST", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AppointmentMessageCancelReason extends Enum<AppointmentMessageCancelReason> implements o0 {
    public static final ProtoAdapter<AppointmentMessageCancelReason> ADAPTER = null;
    public static final AppointmentMessageCancelReason CANCEL_REASON_ACTIVELY_CANCEL = null;
    public static final AppointmentMessageCancelReason CANCEL_REASON_CHANGE_HOST = null;
    public static final AppointmentMessageCancelReason CANCEL_REASON_RESCHEDULE = null;
    public static final AppointmentMessageCancelReason CANCEL_REASON_UNKNOWN = null;
    public static final b Companion = null;
    public static final /* synthetic */ AppointmentMessageCancelReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }
    }

    public static EnumEntries<AppointmentMessageCancelReason> getEntries() {
        return b;
    }

    static {
        final AppointmentMessageCancelReason r0 = new AppointmentMessageCancelReason("CANCEL_REASON_UNKNOWN", 0, 0);
        CANCEL_REASON_UNKNOWN = r0;
        AppointmentMessageCancelReason r1 = new AppointmentMessageCancelReason("CANCEL_REASON_ACTIVELY_CANCEL", 1, 1);
        CANCEL_REASON_ACTIVELY_CANCEL = r1;
        AppointmentMessageCancelReason r3 = new AppointmentMessageCancelReason("CANCEL_REASON_RESCHEDULE", 2, 2);
        CANCEL_REASON_RESCHEDULE = r3;
        AppointmentMessageCancelReason r5 = new AppointmentMessageCancelReason("CANCEL_REASON_CHANGE_HOST", 3, 3);
        CANCEL_REASON_CHANGE_HOST = r5;
        AppointmentMessageCancelReason[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(AppointmentMessageCancelReason.class);
        final Syntax r4 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r4, r0);
    }

    public static AppointmentMessageCancelReason[] values() {
        return (AppointmentMessageCancelReason[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final AppointmentMessageCancelReason fromValue(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L17;
        return null;
    L17:
        return CANCEL_REASON_CHANGE_HOST;
    L18:
        return CANCEL_REASON_RESCHEDULE;
    L19:
        return CANCEL_REASON_ACTIVELY_CANCEL;
    L15:
        return CANCEL_REASON_UNKNOWN;
    }

    public static AppointmentMessageCancelReason valueOf(String r1) {
        return (AppointmentMessageCancelReason) r27.a.a(AppointmentMessageCancelReason.class, r1);
    }

    public AppointmentMessageCancelReason(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
