package com.lark.kmp.pb.calendar.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarEventWebinarAttendeeInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventWebinarAttendeeInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/CalendarEventWebinarAttendeeInfo$Builder;Lokio/ByteString;)V", "attendees", "", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee;", "getAttendees", "()Ljava/util/List;", "event_attendee_info", "Lcom/lark/kmp/pb/calendar/v1/EventAttendeeInfo;", "getEvent_attendee_info", "()Lcom/lark/kmp/pb/calendar/v1/EventAttendeeInfo;", "require_more", "", "getRequire_more", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "sync_token", "", "getSync_token", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CalendarEventWebinarAttendeeInfo extends Message<CalendarEventWebinarAttendeeInfo, a> {
    public static final ProtoAdapter<CalendarEventWebinarAttendeeInfo> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final List<CalendarEventAttendee> attendees;
    private final EventAttendeeInfo event_attendee_info;
    private final Boolean require_more;
    private final String sync_token;

    public static final class a extends Message.a<CalendarEventWebinarAttendeeInfo, a> {
        public List<CalendarEventAttendee> d;
        public EventAttendeeInfo e;
        public Boolean f;
        public String g;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new CalendarEventWebinarAttendeeInfo(this, c(), null);
        }

        public a() {
            this.d = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<CalendarEventWebinarAttendeeInfo> {
        @Override // com.lark.wire.ProtoAdapter
        public final CalendarEventWebinarAttendeeInfo c(g0 r8) {
            Intrinsics.checkNotNullParameter(r8, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r8.c();
        L3:
            int r5 = r8.e();
            if (r5 == (-1)) goto L18;
            if (r5 != 1) goto L8;
            r2.add(CalendarEventAttendee.ADAPTER.c(r8));
            goto L3
        L8:
            if (r5 != 2) goto L10;
            r1.e = EventAttendeeInfo.ADAPTER.c(r8);
            goto L3
        L10:
            if (r5 != 3) goto L12;
            r1.f = (Boolean) ProtoAdapter.g.c(r8);
            goto L3
        L12:
            if (r5 != 4) goto L13;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r8, "reader");
            r1.g = r8.i();
            goto L3
        L13:
            r8.j(r5);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L18:
            ByteString r9 = r8.d(r3);
            Intrinsics.checkNotNullParameter(r2, "attendees");
            com.lark.wire.internal.a.a(r2);
            r1.d = r2;
            return new CalendarEventWebinarAttendeeInfo(r1, r9, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(CalendarEventWebinarAttendeeInfo r5) {
            CalendarEventWebinarAttendeeInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (((r6.unknownFields().size() + CalendarEventAttendee.ADAPTER.a().l(1, r6.getAttendees())) + EventAttendeeInfo.ADAPTER.l(2, r6.getEvent_attendee_info())) + ProtoAdapter.g.l(3, r6.getRequire_more())) + ProtoAdapter.q.l(4, r6.getSync_token());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, CalendarEventWebinarAttendeeInfo r5) {
            CalendarEventWebinarAttendeeInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            CalendarEventAttendee.ADAPTER.a().i(r4, 1, r6.getAttendees());
            EventAttendeeInfo.ADAPTER.i(r4, 2, r6.getEvent_attendee_info());
            ProtoAdapter.g.i(r4, 3, r6.getRequire_more());
            ProtoAdapter.q.i(r4, 4, r6.getSync_token());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, CalendarEventWebinarAttendeeInfo r5) {
            CalendarEventWebinarAttendeeInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.q.j(r4, 4, r6.getSync_token());
            ProtoAdapter.g.j(r4, 3, r6.getRequire_more());
            EventAttendeeInfo.ADAPTER.j(r4, 2, r6.getEvent_attendee_info());
            CalendarEventAttendee.ADAPTER.a().j(r4, 1, r6.getAttendees());
        }

        public b(FieldEncoding r7, KClass<CalendarEventWebinarAttendeeInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.CalendarEventWebinarAttendeeInfo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ CalendarEventWebinarAttendeeInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CalendarEventWebinarAttendeeInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.attendees;
        r0.e = this.event_attendee_info;
        r0.f = this.require_more;
        r0.g = this.sync_token;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(CalendarEventWebinarAttendeeInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final List<CalendarEventAttendee> getAttendees() {
        return this.attendees;
    }

    public final EventAttendeeInfo getEvent_attendee_info() {
        return this.event_attendee_info;
    }

    public final Boolean getRequire_more() {
        return this.require_more;
    }

    public final String getSync_token() {
        return this.sync_token;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public CalendarEventWebinarAttendeeInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.attendees = com.lark.wire.internal.a.c("attendees", r2.d);
        this.event_attendee_info = r2.e;
        this.require_more = r2.f;
        this.sync_token = r2.g;
    }

    public /* synthetic */ CalendarEventWebinarAttendeeInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
