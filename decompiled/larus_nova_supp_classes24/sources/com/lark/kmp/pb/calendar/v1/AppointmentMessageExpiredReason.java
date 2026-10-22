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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/AppointmentMessageExpiredReason;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "EXPIRED_REASON_UNKNOWN", "EXPIRED_REASON_RESCHEDULE", "EXPIRED_REASON_CANCEL", "EXPIRED_REASON_CHANGE_HOST", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AppointmentMessageExpiredReason extends Enum<AppointmentMessageExpiredReason> implements o0 {
    public static final ProtoAdapter<AppointmentMessageExpiredReason> ADAPTER = null;
    public static final b Companion = null;
    public static final AppointmentMessageExpiredReason EXPIRED_REASON_CANCEL = null;
    public static final AppointmentMessageExpiredReason EXPIRED_REASON_CHANGE_HOST = null;
    public static final AppointmentMessageExpiredReason EXPIRED_REASON_RESCHEDULE = null;
    public static final AppointmentMessageExpiredReason EXPIRED_REASON_UNKNOWN = null;
    public static final /* synthetic */ AppointmentMessageExpiredReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }
    }

    public static EnumEntries<AppointmentMessageExpiredReason> getEntries() {
        return b;
    }

    static {
        final AppointmentMessageExpiredReason r0 = new AppointmentMessageExpiredReason("EXPIRED_REASON_UNKNOWN", 0, 0);
        EXPIRED_REASON_UNKNOWN = r0;
        AppointmentMessageExpiredReason r1 = new AppointmentMessageExpiredReason("EXPIRED_REASON_RESCHEDULE", 1, 1);
        EXPIRED_REASON_RESCHEDULE = r1;
        AppointmentMessageExpiredReason r3 = new AppointmentMessageExpiredReason("EXPIRED_REASON_CANCEL", 2, 2);
        EXPIRED_REASON_CANCEL = r3;
        AppointmentMessageExpiredReason r5 = new AppointmentMessageExpiredReason("EXPIRED_REASON_CHANGE_HOST", 3, 3);
        EXPIRED_REASON_CHANGE_HOST = r5;
        AppointmentMessageExpiredReason[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(AppointmentMessageExpiredReason.class);
        final Syntax r4 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r4, r0);
    }

    public static AppointmentMessageExpiredReason[] values() {
        return (AppointmentMessageExpiredReason[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final AppointmentMessageExpiredReason fromValue(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L17;
        return null;
    L17:
        return EXPIRED_REASON_CHANGE_HOST;
    L18:
        return EXPIRED_REASON_CANCEL;
    L19:
        return EXPIRED_REASON_RESCHEDULE;
    L15:
        return EXPIRED_REASON_UNKNOWN;
    }

    public static AppointmentMessageExpiredReason valueOf(String r1) {
        return (AppointmentMessageExpiredReason) r27.a.a(AppointmentMessageExpiredReason.class, r1);
    }

    public AppointmentMessageExpiredReason(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
