package com.lark.kmp.pb.basic.v1;

import com.lark.kmp.pb.calendar.v1.AppointmentMessageNotify;
import com.lark.kmp.pb.calendar.v1.AppointmentMessageRoundRobin;
import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003/01B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010-\u001a\u00020\u0002H\u0016J\b\u0010.\u001a\u00020\u0012H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010%\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010)\u001a\u0004\u0018\u00010*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u00062"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/GeneralCalendarContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/GeneralCalendarContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/GeneralCalendarContent$Builder;Lokio/ByteString;)V", "calendar_type", "Lcom/lark/kmp/pb/basic/v1/GeneralCalendarContent$Type;", "getCalendar_type", "()Lcom/lark/kmp/pb/basic/v1/GeneralCalendarContent$Type;", "event_card", "Lcom/lark/kmp/pb/basic/v1/EventCardTemplate;", "getEvent_card", "()Lcom/lark/kmp/pb/basic/v1/EventCardTemplate;", "message_chatters", "", "", "Lcom/lark/kmp/pb/basic/v1/Chatter;", "getMessage_chatters$annotations", "()V", "getMessage_chatters", "()Ljava/util/Map;", "rsvp_card_info", "Lcom/lark/kmp/pb/basic/v1/RSVPCardInfo;", "getRsvp_card_info", "()Lcom/lark/kmp/pb/basic/v1/RSVPCardInfo;", "parse_content_version", "", "getParse_content_version", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "appointment_message_notify_data", "Lcom/lark/kmp/pb/calendar/v1/AppointmentMessageNotify;", "getAppointment_message_notify_data", "()Lcom/lark/kmp/pb/calendar/v1/AppointmentMessageNotify;", "appointment_message_round_robin_data", "Lcom/lark/kmp/pb/calendar/v1/AppointmentMessageRoundRobin;", "getAppointment_message_round_robin_data", "()Lcom/lark/kmp/pb/calendar/v1/AppointmentMessageRoundRobin;", "rsvp_comment_card_info", "Lcom/lark/kmp/pb/basic/v1/RSVPCommentCardInfo;", "getRsvp_comment_card_info", "()Lcom/lark/kmp/pb/basic/v1/RSVPCommentCardInfo;", "newBuilder", "toString", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class GeneralCalendarContent extends com.lark.wire.Message<GeneralCalendarContent, a> {
    public static final ProtoAdapter<GeneralCalendarContent> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final AppointmentMessageNotify appointment_message_notify_data;
    private final AppointmentMessageRoundRobin appointment_message_round_robin_data;
    private final Type calendar_type;
    private final EventCardTemplate event_card;
    private final Map<String, Chatter> message_chatters;
    private final Integer parse_content_version;
    private final RSVPCardInfo rsvp_card_info;
    private final RSVPCommentCardInfo rsvp_comment_card_info;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00102\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/GeneralCalendarContent$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "TRANSFER_CALENDAR_EVENT", "RSVP_COMMENT", "SWITCH_CALENDAR", "RSVP_CARD", "APPOINTMENT_MESSAGE_NOTIFY", "APPOINTMENT_MESSAGE_ROUND_ROBIN", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type APPOINTMENT_MESSAGE_NOTIFY = null;
        public static final Type APPOINTMENT_MESSAGE_ROUND_ROBIN = null;
        public static final b Companion = null;
        public static final Type RSVP_CARD = null;
        public static final Type RSVP_COMMENT = null;
        public static final Type SWITCH_CALENDAR = null;
        public static final Type TRANSFER_CALENDAR_EVENT = null;
        public static final Type UNKNOWN = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Type> r1, Syntax r2, Type r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Type a(int r0) {
                switch(r0) {
                    case 0: goto L11;
                    case 1: goto L18;
                    case 2: goto L17;
                    case 3: goto L16;
                    case 4: goto L15;
                    case 5: goto L14;
                    case 6: goto L13;
                    default: goto L3;
                };
            L3:
                return null;
            L13:
                return Type.APPOINTMENT_MESSAGE_ROUND_ROBIN;
            L14:
                return Type.APPOINTMENT_MESSAGE_NOTIFY;
            L15:
                return Type.RSVP_CARD;
            L16:
                return Type.SWITCH_CALENDAR;
            L17:
                return Type.RSVP_COMMENT;
            L18:
                return Type.TRANSFER_CALENDAR_EVENT;
            L11:
                return Type.UNKNOWN;
            }
        }

        @JvmStatic
        public static final Type fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("TRANSFER_CALENDAR_EVENT", 1, 1);
            TRANSFER_CALENDAR_EVENT = r1;
            Type r3 = new Type("RSVP_COMMENT", 2, 2);
            RSVP_COMMENT = r3;
            Type r5 = new Type("SWITCH_CALENDAR", 3, 3);
            SWITCH_CALENDAR = r5;
            Type r7 = new Type("RSVP_CARD", 4, 4);
            RSVP_CARD = r7;
            Type r9 = new Type("APPOINTMENT_MESSAGE_NOTIFY", 5, 5);
            APPOINTMENT_MESSAGE_NOTIFY = r9;
            Type r11 = new Type("APPOINTMENT_MESSAGE_ROUND_ROBIN", 6, 6);
            APPOINTMENT_MESSAGE_ROUND_ROBIN = r11;
            Type[] r13 = {r0, r1, r3, r5, r7, r9, r11};
            a = r13;
            b = EnumEntriesKt.enumEntries(r13);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2, r0);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<GeneralCalendarContent, a> {
        public Type d;
        public EventCardTemplate e;
        public Map<String, Chatter> f;
        public RSVPCardInfo g;
        public Integer h;
        public AppointmentMessageNotify i;
        public AppointmentMessageRoundRobin j;
        public RSVPCommentCardInfo k;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new GeneralCalendarContent(this, c(), null);
        }

        public a() {
            this.f = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ GeneralCalendarContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Deprecated(message = "message_chatters is deprecated")
    public static /* synthetic */ void getMessage_chatters$annotations() {
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(GeneralCalendarContent.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new GeneralCalendarContent$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.calendar_type;
        r0.e = this.event_card;
        r0.f = this.message_chatters;
        r0.g = this.rsvp_card_info;
        r0.h = this.parse_content_version;
        r0.i = this.appointment_message_notify_data;
        r0.j = this.appointment_message_round_robin_data;
        r0.k = this.rsvp_comment_card_info;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(GeneralCalendarContent.class).getSimpleName() + '@' + hashCode();
    }

    public final AppointmentMessageNotify getAppointment_message_notify_data() {
        return this.appointment_message_notify_data;
    }

    public final AppointmentMessageRoundRobin getAppointment_message_round_robin_data() {
        return this.appointment_message_round_robin_data;
    }

    public final Type getCalendar_type() {
        return this.calendar_type;
    }

    public final EventCardTemplate getEvent_card() {
        return this.event_card;
    }

    public final Map<String, Chatter> getMessage_chatters() {
        return this.message_chatters;
    }

    public final Integer getParse_content_version() {
        return this.parse_content_version;
    }

    public final RSVPCardInfo getRsvp_card_info() {
        return this.rsvp_card_info;
    }

    public final RSVPCommentCardInfo getRsvp_comment_card_info() {
        return this.rsvp_comment_card_info;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public GeneralCalendarContent(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.calendar_type = r2.d;
        this.event_card = r2.e;
        this.message_chatters = com.lark.wire.internal.a.d("message_chatters", r2.f);
        this.rsvp_card_info = r2.g;
        this.parse_content_version = r2.h;
        this.appointment_message_notify_data = r2.i;
        this.appointment_message_round_robin_data = r2.j;
        this.rsvp_comment_card_info = r2.k;
    }

    public /* synthetic */ GeneralCalendarContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
