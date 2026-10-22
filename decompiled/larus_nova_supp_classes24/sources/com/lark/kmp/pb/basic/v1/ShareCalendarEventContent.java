package com.lark.kmp.pb.basic.v1;

import com.lark.kmp.pb.calendar.v1.CalendarEvent;
import com.lark.kmp.pb.calendar.v1.CalendarEventAttendee;
import com.lark.kmp.pb.calendar.v1.ConflictType;
import com.lark.kmp.pb.calendar.v1.OldVersionCalendarEvent;
import com.lark.kmp.pb.calendar.v1.RecurrenceDisplayInstanceInfo;
import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 12\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u000201B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010.\u001a\u00020\u0002H\u0016J\b\u0010/\u001a\u00020'H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0010\u0010\u0012R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010*\u001a\u0004\u0018\u00010+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ShareCalendarEventContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/ShareCalendarEventContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/ShareCalendarEventContent$Builder;Lokio/ByteString;)V", "old_version_calendar_event", "Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent;", "getOld_version_calendar_event", "()Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent;", "attendees_count", "", "getAttendees_count", "()I", "is_joined", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_sharable", "conflict_type", "Lcom/lark/kmp/pb/calendar/v1/ConflictType;", "getConflict_type", "()Lcom/lark/kmp/pb/calendar/v1/ConflictType;", "conflict_time", "", "getConflict_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "calendar_event", "Lcom/lark/kmp/pb/calendar/v1/CalendarEvent;", "getCalendar_event", "()Lcom/lark/kmp/pb/calendar/v1/CalendarEvent;", "self_attendee_status", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$Status;", "getSelf_attendee_status", "()Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$Status;", "current_user_cal_id", "", "getCurrent_user_cal_id", "()Ljava/lang/String;", "recurrence_display_instance_info", "Lcom/lark/kmp/pb/calendar/v1/RecurrenceDisplayInstanceInfo;", "getRecurrence_display_instance_info", "()Lcom/lark/kmp/pb/calendar/v1/RecurrenceDisplayInstanceInfo;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ShareCalendarEventContent extends com.lark.wire.Message<ShareCalendarEventContent, a> {
    public static final ProtoAdapter<ShareCalendarEventContent> ADAPTER = null;
    public static final c Companion = null;
    public static final long DEFAULT_CONFLICT_TIME = 0;
    public static final ConflictType DEFAULT_CONFLICT_TYPE = null;
    public static final boolean DEFAULT_IS_JOINED = false;
    public static final boolean DEFAULT_IS_SHARABLE = false;
    private static final long serialVersionUID = 0;
    private final int attendees_count;
    private final CalendarEvent calendar_event;
    private final Long conflict_time;
    private final ConflictType conflict_type;
    private final String current_user_cal_id;
    private final Boolean is_joined;
    private final Boolean is_sharable;
    private final OldVersionCalendarEvent old_version_calendar_event;
    private final RecurrenceDisplayInstanceInfo recurrence_display_instance_info;
    private final CalendarEventAttendee.Status self_attendee_status;

    public static final class a extends com.lark.wire.Message.a<ShareCalendarEventContent, a> {
        public OldVersionCalendarEvent d;
        public Integer e;
        public Boolean f;
        public Boolean g;
        public ConflictType h;
        public Long i;
        public CalendarEvent j;
        public CalendarEventAttendee.Status k;
        public String l;
        public RecurrenceDisplayInstanceInfo m;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new ShareCalendarEventContent(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<ShareCalendarEventContent> {
        @Override // com.lark.wire.ProtoAdapter
        public final ShareCalendarEventContent c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L24;
            switch(r4) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L27;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L25;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L25:
            r1.k = CalendarEventAttendee.Status.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L27:
            r1.h = ConflictType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L7:
            r1.m = RecurrenceDisplayInstanceInfo.ADAPTER.c(r10);
            goto L3
        L8:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.l = r10.i();
            goto L3
        L13:
            r1.j = CalendarEvent.ADAPTER.c(r10);
            goto L3
        L14:
            r1.i = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L19:
            r1.g = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L20:
            r1.f = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L21:
            r1.e = Integer.valueOf(((Number) ProtoAdapter.h.c(r10)).intValue());
            goto L3
        L22:
            r1.d = OldVersionCalendarEvent.ADAPTER.c(r10);
            goto L3
        L6:
            r10.j(r4);
            Unit r7 = Unit.INSTANCE;
            goto L3
        L24:
            return new ShareCalendarEventContent(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(ShareCalendarEventContent r5) {
            ShareCalendarEventContent r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = (r6.unknownFields().size() + OldVersionCalendarEvent.ADAPTER.l(1, r6.getOld_version_calendar_event())) + ProtoAdapter.h.l(2, Integer.valueOf(r6.getAttendees_count()));
            l r1 = ProtoAdapter.g;
            return (((((((r0 + r1.l(3, r6.is_joined())) + r1.l(4, r6.is_sharable())) + ConflictType.ADAPTER.l(5, r6.getConflict_type())) + ProtoAdapter.k.l(6, r6.getConflict_time())) + CalendarEvent.ADAPTER.l(7, r6.getCalendar_event())) + CalendarEventAttendee.Status.ADAPTER.l(8, r6.getSelf_attendee_status())) + ProtoAdapter.q.l(9, r6.getCurrent_user_cal_id())) + RecurrenceDisplayInstanceInfo.ADAPTER.l(10, r6.getRecurrence_display_instance_info());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, ShareCalendarEventContent r5) {
            ShareCalendarEventContent r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            OldVersionCalendarEvent.ADAPTER.i(r4, 1, r6.getOld_version_calendar_event());
            ProtoAdapter.h.i(r4, 2, Integer.valueOf(r6.getAttendees_count()));
            l r0 = ProtoAdapter.g;
            r0.i(r4, 3, r6.is_joined());
            r0.i(r4, 4, r6.is_sharable());
            ConflictType.ADAPTER.i(r4, 5, r6.getConflict_type());
            ProtoAdapter.k.i(r4, 6, r6.getConflict_time());
            CalendarEvent.ADAPTER.i(r4, 7, r6.getCalendar_event());
            CalendarEventAttendee.Status.ADAPTER.i(r4, 8, r6.getSelf_attendee_status());
            ProtoAdapter.q.i(r4, 9, r6.getCurrent_user_cal_id());
            RecurrenceDisplayInstanceInfo.ADAPTER.i(r4, 10, r6.getRecurrence_display_instance_info());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, ShareCalendarEventContent r5) {
            ShareCalendarEventContent r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            RecurrenceDisplayInstanceInfo.ADAPTER.j(r4, 10, r6.getRecurrence_display_instance_info());
            ProtoAdapter.q.j(r4, 9, r6.getCurrent_user_cal_id());
            CalendarEventAttendee.Status.ADAPTER.j(r4, 8, r6.getSelf_attendee_status());
            CalendarEvent.ADAPTER.j(r4, 7, r6.getCalendar_event());
            ProtoAdapter.k.j(r4, 6, r6.getConflict_time());
            ConflictType.ADAPTER.j(r4, 5, r6.getConflict_type());
            l r0 = ProtoAdapter.g;
            r0.j(r4, 4, r6.is_sharable());
            r0.j(r4, 3, r6.is_joined());
            ProtoAdapter.h.j(r4, 2, Integer.valueOf(r6.getAttendees_count()));
            OldVersionCalendarEvent.ADAPTER.j(r4, 1, r6.getOld_version_calendar_event());
        }

        public b(FieldEncoding r7, KClass<ShareCalendarEventContent> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.ShareCalendarEventContent", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ ShareCalendarEventContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        DEFAULT_CONFLICT_TYPE = ConflictType.NONE;
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ShareCalendarEventContent.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.old_version_calendar_event;
        r0.e = Integer.valueOf(this.attendees_count);
        r0.f = this.is_joined;
        r0.g = this.is_sharable;
        r0.h = this.conflict_type;
        r0.i = this.conflict_time;
        r0.j = this.calendar_event;
        r0.k = this.self_attendee_status;
        r0.l = this.current_user_cal_id;
        r0.m = this.recurrence_display_instance_info;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(ShareCalendarEventContent.class).getSimpleName() + '@' + hashCode();
    }

    public final int getAttendees_count() {
        return this.attendees_count;
    }

    public final CalendarEvent getCalendar_event() {
        return this.calendar_event;
    }

    public final Long getConflict_time() {
        return this.conflict_time;
    }

    public final ConflictType getConflict_type() {
        return this.conflict_type;
    }

    public final String getCurrent_user_cal_id() {
        return this.current_user_cal_id;
    }

    public final OldVersionCalendarEvent getOld_version_calendar_event() {
        return this.old_version_calendar_event;
    }

    public final RecurrenceDisplayInstanceInfo getRecurrence_display_instance_info() {
        return this.recurrence_display_instance_info;
    }

    public final CalendarEventAttendee.Status getSelf_attendee_status() {
        return this.self_attendee_status;
    }

    public final Boolean is_joined() {
        return this.is_joined;
    }

    public final Boolean is_sharable() {
        return this.is_sharable;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public ShareCalendarEventContent(a r2, ByteString r3) {
        super(ADAPTER, r3);
        OldVersionCalendarEvent r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.old_version_calendar_event = r4;
        Integer r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.attendees_count = r5.intValue();
        this.is_joined = r2.f;
        this.is_sharable = r2.g;
        this.conflict_type = r2.h;
        this.conflict_time = r2.i;
        this.calendar_event = r2.j;
        this.self_attendee_status = r2.k;
        this.current_user_cal_id = r2.l;
        this.recurrence_display_instance_info = r2.m;
    }

    public /* synthetic */ ShareCalendarEventContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
