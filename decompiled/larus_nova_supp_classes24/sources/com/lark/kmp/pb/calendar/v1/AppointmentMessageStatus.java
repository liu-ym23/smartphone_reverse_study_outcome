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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/AppointmentMessageStatus;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "STATUS_UNKNOWN", "STATUS_ACTIVE", "STATUS_EXPIRED", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AppointmentMessageStatus extends Enum<AppointmentMessageStatus> implements o0 {
    public static final ProtoAdapter<AppointmentMessageStatus> ADAPTER = null;
    public static final b Companion = null;
    public static final AppointmentMessageStatus STATUS_ACTIVE = null;
    public static final AppointmentMessageStatus STATUS_EXPIRED = null;
    public static final AppointmentMessageStatus STATUS_UNKNOWN = null;
    public static final /* synthetic */ AppointmentMessageStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }
    }

    public static EnumEntries<AppointmentMessageStatus> getEntries() {
        return b;
    }

    static {
        final AppointmentMessageStatus r0 = new AppointmentMessageStatus("STATUS_UNKNOWN", 0, 0);
        STATUS_UNKNOWN = r0;
        AppointmentMessageStatus r1 = new AppointmentMessageStatus("STATUS_ACTIVE", 1, 1);
        STATUS_ACTIVE = r1;
        AppointmentMessageStatus r3 = new AppointmentMessageStatus("STATUS_EXPIRED", 2, 2);
        STATUS_EXPIRED = r3;
        AppointmentMessageStatus[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(AppointmentMessageStatus.class);
        final Syntax r4 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r4, r0);
    }

    public static AppointmentMessageStatus[] values() {
        return (AppointmentMessageStatus[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final AppointmentMessageStatus fromValue(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L14;
        return null;
    L14:
        return STATUS_EXPIRED;
    L15:
        return STATUS_ACTIVE;
    L12:
        return STATUS_UNKNOWN;
    }

    public static AppointmentMessageStatus valueOf(String r1) {
        return (AppointmentMessageStatus) r27.a.a(AppointmentMessageStatus.class, r1);
    }

    public AppointmentMessageStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
