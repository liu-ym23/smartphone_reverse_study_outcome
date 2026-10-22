package com.lark.kmp.pb.calendar.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.t;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 B2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002ABB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010?\u001a\u00020\u0002H\u0016J\b\u0010@\u001a\u00020\u0011H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0013\u0010 \u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0013R\u0013\u0010$\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0013R\u0013\u0010&\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0013R\u0015\u0010(\u001a\u0004\u0018\u00010)¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0015\u0010-\u001a\u0004\u0018\u00010)¢\u0006\n\n\u0002\u0010,\u001a\u0004\b.\u0010+R\u0013\u0010/\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0013R\u0013\u00101\u001a\u0004\u0018\u000102¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u00105\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0013R\u0013\u00107\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0013R\u0015\u00109\u001a\u0004\u0018\u00010:¢\u0006\n\n\u0002\u0010<\u001a\u0004\b9\u0010;R\u0015\u0010=\u001a\u0004\u0018\u00010)¢\u0006\n\n\u0002\u0010,\u001a\u0004\b>\u0010+¨\u0006C"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/AppointmentMessageRoundRobin;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/AppointmentMessageRoundRobin$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/AppointmentMessageRoundRobin$Builder;Lokio/ByteString;)V", "status", "Lcom/lark/kmp/pb/calendar/v1/AppointmentMessageStatus;", "getStatus", "()Lcom/lark/kmp/pb/calendar/v1/AppointmentMessageStatus;", "action", "Lcom/lark/kmp/pb/calendar/v1/AppointmentAction;", "getAction", "()Lcom/lark/kmp/pb/calendar/v1/AppointmentAction;", "operator_id", "", "getOperator_id", "()Ljava/lang/String;", "scheduler_id", "getScheduler_id", "scheduler_type", "Lcom/lark/kmp/pb/calendar/v1/Scheduler$Type;", "getScheduler_type", "()Lcom/lark/kmp/pb/calendar/v1/Scheduler$Type;", "scheduler_name", "getScheduler_name", "appointment_id", "getAppointment_id", "creator_id", "getCreator_id", "host_id", "getHost_id", "guest_name", "getGuest_name", "guest_email", "getGuest_email", "timezone", "getTimezone", "start_time", "", "getStart_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "end_time", "getEnd_time", "message", "getMessage", "expired_reason", "Lcom/lark/kmp/pb/calendar/v1/AppointmentMessageExpiredReason;", "getExpired_reason", "()Lcom/lark/kmp/pb/calendar/v1/AppointmentMessageExpiredReason;", "host_name", "getHost_name", "operator_name", "getOperator_name", "is_forward_msg", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "origin_message_id", "getOrigin_message_id", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AppointmentMessageRoundRobin extends Message<AppointmentMessageRoundRobin, a> {
    public static final ProtoAdapter<AppointmentMessageRoundRobin> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final AppointmentAction action;
    private final String appointment_id;
    private final String creator_id;
    private final Long end_time;
    private final AppointmentMessageExpiredReason expired_reason;
    private final String guest_email;
    private final String guest_name;
    private final String host_id;
    private final String host_name;
    private final Boolean is_forward_msg;
    private final String message;
    private final String operator_id;
    private final String operator_name;
    private final Long origin_message_id;
    private final String scheduler_id;
    private final String scheduler_name;
    private final Scheduler.Type scheduler_type;
    private final Long start_time;
    private final AppointmentMessageStatus status;
    private final String timezone;

    public static final class a extends Message.a<AppointmentMessageRoundRobin, a> {
        public AppointmentMessageStatus d;
        public AppointmentAction e;
        public String f;
        public String g;
        public Scheduler.Type h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public String n;
        public String o;
        public Long p;
        public Long q;
        public String r;
        public AppointmentMessageExpiredReason s;
        public String t;
        public String u;
        public Boolean v;
        public Long w;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new AppointmentMessageRoundRobin(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<AppointmentMessageRoundRobin> {
        @Override // com.lark.wire.ProtoAdapter
        public final AppointmentMessageRoundRobin c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L40;
            switch(r4) {
                case 1: goto L41;
                case 2: goto L43;
                case 3: goto L30;
                case 4: goto L29;
                case 5: goto L47;
                case 6: goto L24;
                case 7: goto L23;
                case 8: goto L22;
                case 9: goto L21;
                case 10: goto L20;
                case 11: goto L19;
                case 12: goto L18;
                case 13: goto L17;
                case 14: goto L16;
                case 15: goto L15;
                case 16: goto L45;
                case 17: goto L10;
                case 18: goto L9;
                case 19: goto L8;
                case 20: goto L7;
                default: goto L6;
            };
        L41:
            r1.d = AppointmentMessageStatus.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L37
        L37:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L43:
            r1.e = AppointmentAction.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L33
        L33:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L45:
            r1.s = AppointmentMessageExpiredReason.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L47:
            r1.h = Scheduler.Type.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L27
        L27:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r8 = Unit.INSTANCE;
            goto L3
        L7:
            r1.w = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L8:
            r1.v = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L9:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.u = r10.i();
            goto L3
        L10:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.t = r10.i();
            goto L3
        L15:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.r = r10.i();
            goto L3
        L16:
            r1.q = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L17:
            r1.p = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L18:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.o = r10.i();
            goto L3
        L19:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.n = r10.i();
            goto L3
        L20:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.m = r10.i();
            goto L3
        L21:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.l = r10.i();
            goto L3
        L22:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.k = r10.i();
            goto L3
        L23:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.j = r10.i();
            goto L3
        L24:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.i = r10.i();
            goto L3
        L29:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.g = r10.i();
            goto L3
        L30:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.f = r10.i();
            goto L3
        L6:
            r10.j(r4);
            Unit r9 = Unit.INSTANCE;
            goto L3
        L40:
            return new AppointmentMessageRoundRobin(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(AppointmentMessageRoundRobin r7) {
            AppointmentMessageRoundRobin r8 = r7;
            Intrinsics.checkNotNullParameter(r8, "value");
            int r0 = (r8.unknownFields().size() + AppointmentMessageStatus.ADAPTER.l(1, r8.getStatus())) + AppointmentAction.ADAPTER.l(2, r8.getAction());
            w r1 = ProtoAdapter.q;
            int r2 = (((((((((r0 + r1.l(3, r8.getOperator_id())) + r1.l(4, r8.getScheduler_id())) + Scheduler.Type.ADAPTER.l(5, r8.getScheduler_type())) + r1.l(6, r8.getScheduler_name())) + r1.l(7, r8.getAppointment_id())) + r1.l(8, r8.getCreator_id())) + r1.l(9, r8.getHost_id())) + r1.l(10, r8.getGuest_name())) + r1.l(11, r8.getGuest_email())) + r1.l(12, r8.getTimezone());
            t r3 = ProtoAdapter.k;
            return (((((((r2 + r3.l(13, r8.getStart_time())) + r3.l(14, r8.getEnd_time())) + r1.l(15, r8.getMessage())) + AppointmentMessageExpiredReason.ADAPTER.l(16, r8.getExpired_reason())) + r1.l(17, r8.getHost_name())) + r1.l(18, r8.getOperator_name())) + ProtoAdapter.g.l(19, r8.is_forward_msg())) + r3.l(20, r8.getOrigin_message_id());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r6, AppointmentMessageRoundRobin r7) {
            AppointmentMessageRoundRobin r8 = r7;
            Intrinsics.checkNotNullParameter(r6, "writer");
            Intrinsics.checkNotNullParameter(r8, "value");
            AppointmentMessageStatus.ADAPTER.i(r6, 1, r8.getStatus());
            AppointmentAction.ADAPTER.i(r6, 2, r8.getAction());
            w r0 = ProtoAdapter.q;
            r0.i(r6, 3, r8.getOperator_id());
            r0.i(r6, 4, r8.getScheduler_id());
            Scheduler.Type.ADAPTER.i(r6, 5, r8.getScheduler_type());
            r0.i(r6, 6, r8.getScheduler_name());
            r0.i(r6, 7, r8.getAppointment_id());
            r0.i(r6, 8, r8.getCreator_id());
            r0.i(r6, 9, r8.getHost_id());
            r0.i(r6, 10, r8.getGuest_name());
            r0.i(r6, 11, r8.getGuest_email());
            r0.i(r6, 12, r8.getTimezone());
            t r1 = ProtoAdapter.k;
            r1.i(r6, 13, r8.getStart_time());
            r1.i(r6, 14, r8.getEnd_time());
            r0.i(r6, 15, r8.getMessage());
            AppointmentMessageExpiredReason.ADAPTER.i(r6, 16, r8.getExpired_reason());
            r0.i(r6, 17, r8.getHost_name());
            r0.i(r6, 18, r8.getOperator_name());
            ProtoAdapter.g.i(r6, 19, r8.is_forward_msg());
            r1.i(r6, 20, r8.getOrigin_message_id());
            r6.a(r8.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r6, AppointmentMessageRoundRobin r7) {
            AppointmentMessageRoundRobin r8 = r7;
            Intrinsics.checkNotNullParameter(r6, "writer");
            Intrinsics.checkNotNullParameter(r8, "value");
            r6.d(r8.unknownFields());
            t r0 = ProtoAdapter.k;
            r0.j(r6, 20, r8.getOrigin_message_id());
            ProtoAdapter.g.j(r6, 19, r8.is_forward_msg());
            w r1 = ProtoAdapter.q;
            r1.j(r6, 18, r8.getOperator_name());
            r1.j(r6, 17, r8.getHost_name());
            AppointmentMessageExpiredReason.ADAPTER.j(r6, 16, r8.getExpired_reason());
            r1.j(r6, 15, r8.getMessage());
            r0.j(r6, 14, r8.getEnd_time());
            r0.j(r6, 13, r8.getStart_time());
            r1.j(r6, 12, r8.getTimezone());
            r1.j(r6, 11, r8.getGuest_email());
            r1.j(r6, 10, r8.getGuest_name());
            r1.j(r6, 9, r8.getHost_id());
            r1.j(r6, 8, r8.getCreator_id());
            r1.j(r6, 7, r8.getAppointment_id());
            r1.j(r6, 6, r8.getScheduler_name());
            Scheduler.Type.ADAPTER.j(r6, 5, r8.getScheduler_type());
            r1.j(r6, 4, r8.getScheduler_id());
            r1.j(r6, 3, r8.getOperator_id());
            AppointmentAction.ADAPTER.j(r6, 2, r8.getAction());
            AppointmentMessageStatus.ADAPTER.j(r6, 1, r8.getStatus());
        }

        public b(FieldEncoding r7, KClass<AppointmentMessageRoundRobin> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.AppointmentMessageRoundRobin", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ AppointmentMessageRoundRobin(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AppointmentMessageRoundRobin.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.status;
        r0.e = this.action;
        r0.f = this.operator_id;
        r0.g = this.scheduler_id;
        r0.h = this.scheduler_type;
        r0.i = this.scheduler_name;
        r0.j = this.appointment_id;
        r0.k = this.creator_id;
        r0.l = this.host_id;
        r0.m = this.guest_name;
        r0.n = this.guest_email;
        r0.o = this.timezone;
        r0.p = this.start_time;
        r0.q = this.end_time;
        r0.r = this.message;
        r0.s = this.expired_reason;
        r0.t = this.host_name;
        r0.u = this.operator_name;
        r0.v = this.is_forward_msg;
        r0.w = this.origin_message_id;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(AppointmentMessageRoundRobin.class).getSimpleName() + '@' + hashCode();
    }

    public final AppointmentAction getAction() {
        return this.action;
    }

    public final String getAppointment_id() {
        return this.appointment_id;
    }

    public final String getCreator_id() {
        return this.creator_id;
    }

    public final Long getEnd_time() {
        return this.end_time;
    }

    public final AppointmentMessageExpiredReason getExpired_reason() {
        return this.expired_reason;
    }

    public final String getGuest_email() {
        return this.guest_email;
    }

    public final String getGuest_name() {
        return this.guest_name;
    }

    public final String getHost_id() {
        return this.host_id;
    }

    public final String getHost_name() {
        return this.host_name;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getOperator_id() {
        return this.operator_id;
    }

    public final String getOperator_name() {
        return this.operator_name;
    }

    public final Long getOrigin_message_id() {
        return this.origin_message_id;
    }

    public final String getScheduler_id() {
        return this.scheduler_id;
    }

    public final String getScheduler_name() {
        return this.scheduler_name;
    }

    public final Scheduler.Type getScheduler_type() {
        return this.scheduler_type;
    }

    public final Long getStart_time() {
        return this.start_time;
    }

    public final AppointmentMessageStatus getStatus() {
        return this.status;
    }

    public final String getTimezone() {
        return this.timezone;
    }

    public final Boolean is_forward_msg() {
        return this.is_forward_msg;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public AppointmentMessageRoundRobin(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.status = r2.d;
        this.action = r2.e;
        this.operator_id = r2.f;
        this.scheduler_id = r2.g;
        this.scheduler_type = r2.h;
        this.scheduler_name = r2.i;
        this.appointment_id = r2.j;
        this.creator_id = r2.k;
        this.host_id = r2.l;
        this.guest_name = r2.m;
        this.guest_email = r2.n;
        this.timezone = r2.o;
        this.start_time = r2.p;
        this.end_time = r2.q;
        this.message = r2.r;
        this.expired_reason = r2.s;
        this.host_name = r2.t;
        this.operator_name = r2.u;
        this.is_forward_msg = r2.v;
        this.origin_message_id = r2.w;
    }

    public /* synthetic */ AppointmentMessageRoundRobin(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
