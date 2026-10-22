package com.lark.kmp.pb.basic.v1;

import com.lark.kmp.pb.calendar.v1.CalendarEvent;
import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.t;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 =2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003<=>B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u00109\u001a\u00020\u0002H\u0016J\b\u0010:\u001a\u00020;H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010 \u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b!\u0010\u000bR\u0015\u0010\"\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b#\u0010\u000bR\u0015\u0010$\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b%\u0010\u000bR\u0015\u0010&\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b'\u0010\u000bR\u0015\u0010(\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b)\u0010\u000bR\u0015\u0010*\u001a\u0004\u0018\u00010+¢\u0006\n\n\u0002\u0010-\u001a\u0004\b*\u0010,R\u0015\u0010.\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b/\u0010\u000bR\u0015\u00100\u001a\u0004\u0018\u00010+¢\u0006\n\n\u0002\u0010-\u001a\u0004\b0\u0010,R\u0013\u00101\u001a\u0004\u0018\u000102¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u00105\u001a\u0004\u0018\u000106¢\u0006\b\n\u0000\u001a\u0004\b7\u00108¨\u0006?"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RSVPCardInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RSVPCardInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RSVPCardInfo$Builder;Lokio/ByteString;)V", "message_id", "", "getMessage_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "chat_id", "getChat_id", "basic_event_info", "Lcom/lark/kmp/pb/basic/v1/EventCardTemplate;", "getBasic_event_info", "()Lcom/lark/kmp/pb/basic/v1/EventCardTemplate;", "attendee_rsvp_info", "", "Lcom/lark/kmp/pb/basic/v1/AttendeeRSVPInfo;", "getAttendee_rsvp_info", "()Ljava/util/List;", "card_status", "Lcom/lark/kmp/pb/basic/v1/RSVPCardInfo$EventRSVPCardStatus;", "getCard_status", "()Lcom/lark/kmp/pb/basic/v1/RSVPCardInfo$EventRSVPCardStatus;", "card_change_info", "Lcom/lark/kmp/pb/basic/v1/RSVPCardChangeInfo;", "getCard_change_info", "()Lcom/lark/kmp/pb/basic/v1/RSVPCardChangeInfo;", "needs_action_count", "getNeeds_action_count", "accept_count", "getAccept_count", "tentative_count", "getTentative_count", "decline_count", "getDecline_count", "attendee_count", "getAttendee_count", "is_attendee_overflow", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "event_change_time", "getEvent_change_time", "is_joined", "notes_info", "Lcom/lark/kmp/pb/basic/v1/MeetingNotesInfo;", "getNotes_info", "()Lcom/lark/kmp/pb/basic/v1/MeetingNotesInfo;", "organizer_visibility", "Lcom/lark/kmp/pb/calendar/v1/CalendarEvent$Visibility;", "getOrganizer_visibility", "()Lcom/lark/kmp/pb/calendar/v1/CalendarEvent$Visibility;", "newBuilder", "toString", "", "Builder", "Companion", "EventRSVPCardStatus", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class RSVPCardInfo extends com.lark.wire.Message<RSVPCardInfo, a> {
    public static final ProtoAdapter<RSVPCardInfo> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Long accept_count;
    private final Long attendee_count;
    private final List<AttendeeRSVPInfo> attendee_rsvp_info;
    private final EventCardTemplate basic_event_info;
    private final RSVPCardChangeInfo card_change_info;
    private final EventRSVPCardStatus card_status;
    private final Long chat_id;
    private final Long decline_count;
    private final Long event_change_time;
    private final Boolean is_attendee_overflow;
    private final Boolean is_joined;
    private final Long message_id;
    private final Long needs_action_count;
    private final MeetingNotesInfo notes_info;
    private final CalendarEvent.Visibility organizer_visibility;
    private final Long tentative_count;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RSVPCardInfo$EventRSVPCardStatus;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NORMAL", "UPDATED", "INVALID", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum EventRSVPCardStatus extends Enum<EventRSVPCardStatus> implements o0 {
        public static final ProtoAdapter<EventRSVPCardStatus> ADAPTER = null;
        public static final b Companion = null;
        public static final EventRSVPCardStatus INVALID = null;
        public static final EventRSVPCardStatus NORMAL = null;
        public static final EventRSVPCardStatus UPDATED = null;
        public static final /* synthetic */ EventRSVPCardStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<EventRSVPCardStatus> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                EventRSVPCardStatus.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return EventRSVPCardStatus.INVALID;
            L15:
                return EventRSVPCardStatus.UPDATED;
            L12:
                return EventRSVPCardStatus.NORMAL;
            }

            public a(KClass<EventRSVPCardStatus> r1, Syntax r2, EventRSVPCardStatus r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<EventRSVPCardStatus> getEntries() {
            return b;
        }

        static {
            EventRSVPCardStatus r0 = new EventRSVPCardStatus("NORMAL", 0, 0);
            NORMAL = r0;
            EventRSVPCardStatus r1 = new EventRSVPCardStatus("UPDATED", 1, 1);
            UPDATED = r1;
            EventRSVPCardStatus r3 = new EventRSVPCardStatus("INVALID", 2, 2);
            INVALID = r3;
            EventRSVPCardStatus[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(EventRSVPCardStatus.class), Syntax.PROTO_2, r0);
        }

        public static EventRSVPCardStatus[] values() {
            return (EventRSVPCardStatus[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final EventRSVPCardStatus fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return INVALID;
        L15:
            return UPDATED;
        L12:
            return NORMAL;
        }

        public static EventRSVPCardStatus valueOf(String r1) {
            return (EventRSVPCardStatus) r27.a.a(EventRSVPCardStatus.class, r1);
        }

        public EventRSVPCardStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<RSVPCardInfo, a> {
        public Long d;
        public Long e;
        public EventCardTemplate f;
        public List<AttendeeRSVPInfo> g;
        public EventRSVPCardStatus h;
        public RSVPCardChangeInfo i;
        public Long j;
        public Long k;
        public Long l;
        public Long m;
        public Long n;
        public Boolean o;
        public Long p;
        public Boolean q;
        public MeetingNotesInfo r;
        public CalendarEvent.Visibility s;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new RSVPCardInfo(this, c(), null);
        }

        public a() {
            this.g = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<RSVPCardInfo> {
        @Override // com.lark.wire.ProtoAdapter
        public final RSVPCardInfo c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r0 = new a();
            ArrayList r1 = new ArrayList();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L29;
            switch(r4) {
                case 1: goto L28;
                case 2: goto L27;
                case 3: goto L26;
                case 4: goto L25;
                case 5: goto L31;
                case 6: goto L20;
                case 7: goto L19;
                case 8: goto L18;
                case 9: goto L17;
                case 10: goto L16;
                case 11: goto L15;
                case 12: goto L14;
                case 13: goto L13;
                case 14: goto L12;
                case 15: goto L11;
                case 16: goto L33;
                default: goto L6;
            };
        L31:
            r0.h = EventRSVPCardStatus.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L33:
            r0.s = CalendarEvent.Visibility.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L11:
            r0.r = MeetingNotesInfo.ADAPTER.c(r10);
            goto L3
        L12:
            r0.q = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L13:
            r0.p = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L14:
            r0.o = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L15:
            r0.n = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L16:
            r0.m = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L17:
            r0.l = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L18:
            r0.k = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L19:
            r0.j = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L20:
            r0.i = RSVPCardChangeInfo.ADAPTER.c(r10);
            goto L3
        L25:
            r1.add(AttendeeRSVPInfo.ADAPTER.c(r10));
            goto L3
        L26:
            r0.f = EventCardTemplate.ADAPTER.c(r10);
            goto L3
        L27:
            r0.e = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L28:
            r0.d = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L6:
            r10.j(r4);
            Unit r7 = Unit.INSTANCE;
            goto L3
        L29:
            ByteString r11 = r10.d(r2);
            Intrinsics.checkNotNullParameter(r1, "attendee_rsvp_info");
            com.lark.wire.internal.a.a(r1);
            r0.g = r1;
            return new RSVPCardInfo(r0, r11, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(RSVPCardInfo r6) {
            RSVPCardInfo r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            t r1 = ProtoAdapter.k;
            int r2 = ((((((((((r0 + r1.l(1, r7.getMessage_id())) + r1.l(2, r7.getChat_id())) + EventCardTemplate.ADAPTER.l(3, r7.getBasic_event_info())) + AttendeeRSVPInfo.ADAPTER.a().l(4, r7.getAttendee_rsvp_info())) + EventRSVPCardStatus.ADAPTER.l(5, r7.getCard_status())) + RSVPCardChangeInfo.ADAPTER.l(6, r7.getCard_change_info())) + r1.l(7, r7.getNeeds_action_count())) + r1.l(8, r7.getAccept_count())) + r1.l(9, r7.getTentative_count())) + r1.l(10, r7.getDecline_count())) + r1.l(11, r7.getAttendee_count());
            l r3 = ProtoAdapter.g;
            return ((((r2 + r3.l(12, r7.is_attendee_overflow())) + r1.l(13, r7.getEvent_change_time())) + r3.l(14, r7.is_joined())) + MeetingNotesInfo.ADAPTER.l(15, r7.getNotes_info())) + CalendarEvent.Visibility.ADAPTER.l(16, r7.getOrganizer_visibility());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, RSVPCardInfo r6) {
            RSVPCardInfo r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            t r0 = ProtoAdapter.k;
            r0.i(r5, 1, r7.getMessage_id());
            r0.i(r5, 2, r7.getChat_id());
            EventCardTemplate.ADAPTER.i(r5, 3, r7.getBasic_event_info());
            AttendeeRSVPInfo.ADAPTER.a().i(r5, 4, r7.getAttendee_rsvp_info());
            EventRSVPCardStatus.ADAPTER.i(r5, 5, r7.getCard_status());
            RSVPCardChangeInfo.ADAPTER.i(r5, 6, r7.getCard_change_info());
            r0.i(r5, 7, r7.getNeeds_action_count());
            r0.i(r5, 8, r7.getAccept_count());
            r0.i(r5, 9, r7.getTentative_count());
            r0.i(r5, 10, r7.getDecline_count());
            r0.i(r5, 11, r7.getAttendee_count());
            l r1 = ProtoAdapter.g;
            r1.i(r5, 12, r7.is_attendee_overflow());
            r0.i(r5, 13, r7.getEvent_change_time());
            r1.i(r5, 14, r7.is_joined());
            MeetingNotesInfo.ADAPTER.i(r5, 15, r7.getNotes_info());
            CalendarEvent.Visibility.ADAPTER.i(r5, 16, r7.getOrganizer_visibility());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, RSVPCardInfo r6) {
            RSVPCardInfo r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            CalendarEvent.Visibility.ADAPTER.j(r5, 16, r7.getOrganizer_visibility());
            MeetingNotesInfo.ADAPTER.j(r5, 15, r7.getNotes_info());
            l r0 = ProtoAdapter.g;
            r0.j(r5, 14, r7.is_joined());
            t r1 = ProtoAdapter.k;
            r1.j(r5, 13, r7.getEvent_change_time());
            r0.j(r5, 12, r7.is_attendee_overflow());
            r1.j(r5, 11, r7.getAttendee_count());
            r1.j(r5, 10, r7.getDecline_count());
            r1.j(r5, 9, r7.getTentative_count());
            r1.j(r5, 8, r7.getAccept_count());
            r1.j(r5, 7, r7.getNeeds_action_count());
            RSVPCardChangeInfo.ADAPTER.j(r5, 6, r7.getCard_change_info());
            EventRSVPCardStatus.ADAPTER.j(r5, 5, r7.getCard_status());
            AttendeeRSVPInfo.ADAPTER.a().j(r5, 4, r7.getAttendee_rsvp_info());
            EventCardTemplate.ADAPTER.j(r5, 3, r7.getBasic_event_info());
            r1.j(r5, 2, r7.getChat_id());
            r1.j(r5, 1, r7.getMessage_id());
        }

        public b(FieldEncoding r7, KClass<RSVPCardInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.RSVPCardInfo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ RSVPCardInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(RSVPCardInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.message_id;
        r0.e = this.chat_id;
        r0.f = this.basic_event_info;
        r0.g = this.attendee_rsvp_info;
        r0.h = this.card_status;
        r0.i = this.card_change_info;
        r0.j = this.needs_action_count;
        r0.k = this.accept_count;
        r0.l = this.tentative_count;
        r0.m = this.decline_count;
        r0.n = this.attendee_count;
        r0.o = this.is_attendee_overflow;
        r0.p = this.event_change_time;
        r0.q = this.is_joined;
        r0.r = this.notes_info;
        r0.s = this.organizer_visibility;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(RSVPCardInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final Long getAccept_count() {
        return this.accept_count;
    }

    public final Long getAttendee_count() {
        return this.attendee_count;
    }

    public final List<AttendeeRSVPInfo> getAttendee_rsvp_info() {
        return this.attendee_rsvp_info;
    }

    public final EventCardTemplate getBasic_event_info() {
        return this.basic_event_info;
    }

    public final RSVPCardChangeInfo getCard_change_info() {
        return this.card_change_info;
    }

    public final EventRSVPCardStatus getCard_status() {
        return this.card_status;
    }

    public final Long getChat_id() {
        return this.chat_id;
    }

    public final Long getDecline_count() {
        return this.decline_count;
    }

    public final Long getEvent_change_time() {
        return this.event_change_time;
    }

    public final Long getMessage_id() {
        return this.message_id;
    }

    public final Long getNeeds_action_count() {
        return this.needs_action_count;
    }

    public final MeetingNotesInfo getNotes_info() {
        return this.notes_info;
    }

    public final CalendarEvent.Visibility getOrganizer_visibility() {
        return this.organizer_visibility;
    }

    public final Long getTentative_count() {
        return this.tentative_count;
    }

    public final Boolean is_attendee_overflow() {
        return this.is_attendee_overflow;
    }

    public final Boolean is_joined() {
        return this.is_joined;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public RSVPCardInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.message_id = r2.d;
        this.chat_id = r2.e;
        this.basic_event_info = r2.f;
        this.attendee_rsvp_info = com.lark.wire.internal.a.c("attendee_rsvp_info", r2.g);
        this.card_status = r2.h;
        this.card_change_info = r2.i;
        this.needs_action_count = r2.j;
        this.accept_count = r2.k;
        this.tentative_count = r2.l;
        this.decline_count = r2.m;
        this.attendee_count = r2.n;
        this.is_attendee_overflow = r2.o;
        this.event_change_time = r2.p;
        this.is_joined = r2.q;
        this.notes_info = r2.r;
        this.organizer_visibility = r2.s;
    }

    public /* synthetic */ RSVPCardInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
