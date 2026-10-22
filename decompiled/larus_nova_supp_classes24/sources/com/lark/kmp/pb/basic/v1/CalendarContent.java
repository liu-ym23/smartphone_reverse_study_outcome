package com.lark.kmp.pb.basic.v1;

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
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 92\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u000489:;B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u00106\u001a\u00020\u0002H\u0016J\b\u00107\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000bR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000bR\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u0019\u0010\u001bR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000bR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010'\u001a\u0004\u0018\u00010(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010+\u001a\u0004\u0018\u00010,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R(\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u000201008\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u0006<"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CalendarContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CalendarContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CalendarContent$Builder;Lokio/ByteString;)V", "payload", "", "getPayload", "()Ljava/lang/String;", "card_title", "getCard_title", "start_time", "", "getStart_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "end_time", "getEnd_time", "start_timezone", "getStart_timezone", "end_timezone", "getEnd_timezone", "is_all_day", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "rrule", "getRrule", "calendar_card", "Lcom/lark/kmp/pb/basic/v1/CalendarMessageCard;", "getCalendar_card", "()Lcom/lark/kmp/pb/basic/v1/CalendarMessageCard;", "event_card", "Lcom/lark/kmp/pb/basic/v1/CalendarEventMessageCard;", "getEvent_card", "()Lcom/lark/kmp/pb/basic/v1/CalendarEventMessageCard;", "message_type", "Lcom/lark/kmp/pb/basic/v1/CalendarContent$CalendarMessageType;", "getMessage_type", "()Lcom/lark/kmp/pb/basic/v1/CalendarContent$CalendarMessageType;", "message_version", "Lcom/lark/kmp/pb/basic/v1/CalendarContent$CalendarMessageVersion;", "getMessage_version", "()Lcom/lark/kmp/pb/basic/v1/CalendarContent$CalendarMessageVersion;", "message_chatters", "", "Lcom/lark/kmp/pb/basic/v1/Chatter;", "getMessage_chatters$annotations", "()V", "getMessage_chatters", "()Ljava/util/Map;", "newBuilder", "toString", "Builder", "Companion", "CalendarMessageVersion", "CalendarMessageType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CalendarContent extends com.lark.wire.Message<CalendarContent, a> {
    public static final ProtoAdapter<CalendarContent> ADAPTER = null;
    public static final b Companion = null;
    public static final String DEFAULT_CARD_TITLE = "";
    public static final CalendarMessageType DEFAULT_MESSAGE_TYPE = null;
    public static final CalendarMessageVersion DEFAULT_MESSAGE_VERSION = null;
    private static final long serialVersionUID = 0;
    private final CalendarMessageCard calendar_card;
    private final String card_title;
    private final Long end_time;
    private final String end_timezone;
    private final CalendarEventMessageCard event_card;
    private final Boolean is_all_day;
    private final Map<String, Chatter> message_chatters;
    private final CalendarMessageType message_type;
    private final CalendarMessageVersion message_version;
    private final String payload;
    private final String rrule;
    private final Long start_time;
    private final String start_timezone;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u0000 \u00192\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0019B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CalendarContent$CalendarMessageType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "REPLY_ACCEPT", "REPLY_DECLINE", "REPLY_TENTATIVE", "EVENT_INVITE", "EVENT_DELETE", "EVENT_UPDATE", "EVENT_RESCHEDULE", "CALENDAR_UPDATE", "EVENT_UPDATE_LOCATION", "SELF_ATTENDEE_STATUS_CHANGE", "ADJUST_SHARE_CALENDAR_MEMBER", "REMOVE_SHARE_CALENDAR_MEMBER", "DELETE_SHARE_CALENDAR", "EVENT_UPDATE_DESCRIPTION", "REPLY_ACCEPT_AFTER_DECLINE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum CalendarMessageType extends Enum<CalendarMessageType> implements o0 {
        public static final ProtoAdapter<CalendarMessageType> ADAPTER = null;
        public static final CalendarMessageType ADJUST_SHARE_CALENDAR_MEMBER = null;
        public static final CalendarMessageType CALENDAR_UPDATE = null;
        public static final b Companion = null;
        public static final CalendarMessageType DELETE_SHARE_CALENDAR = null;
        public static final CalendarMessageType EVENT_DELETE = null;
        public static final CalendarMessageType EVENT_INVITE = null;
        public static final CalendarMessageType EVENT_RESCHEDULE = null;
        public static final CalendarMessageType EVENT_UPDATE = null;
        public static final CalendarMessageType EVENT_UPDATE_DESCRIPTION = null;
        public static final CalendarMessageType EVENT_UPDATE_LOCATION = null;
        public static final CalendarMessageType REMOVE_SHARE_CALENDAR_MEMBER = null;
        public static final CalendarMessageType REPLY_ACCEPT = null;
        public static final CalendarMessageType REPLY_ACCEPT_AFTER_DECLINE = null;
        public static final CalendarMessageType REPLY_DECLINE = null;
        public static final CalendarMessageType REPLY_TENTATIVE = null;
        public static final CalendarMessageType SELF_ATTENDEE_STATUS_CHANGE = null;
        public static final CalendarMessageType UNKNOWN = null;
        public static final /* synthetic */ CalendarMessageType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<CalendarMessageType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                CalendarMessageType.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<CalendarMessageType> r1, Syntax r2, CalendarMessageType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static CalendarMessageType a(int r0) {
                switch(r0) {
                    case 0: goto L20;
                    case 1: goto L36;
                    case 2: goto L35;
                    case 3: goto L34;
                    case 4: goto L33;
                    case 5: goto L32;
                    case 6: goto L31;
                    case 7: goto L30;
                    case 8: goto L29;
                    case 9: goto L28;
                    case 10: goto L27;
                    case 11: goto L26;
                    case 12: goto L25;
                    case 13: goto L24;
                    case 14: goto L23;
                    case 15: goto L22;
                    default: goto L3;
                };
            L3:
                return null;
            L22:
                return CalendarMessageType.REPLY_ACCEPT_AFTER_DECLINE;
            L23:
                return CalendarMessageType.EVENT_UPDATE_DESCRIPTION;
            L24:
                return CalendarMessageType.DELETE_SHARE_CALENDAR;
            L25:
                return CalendarMessageType.REMOVE_SHARE_CALENDAR_MEMBER;
            L26:
                return CalendarMessageType.ADJUST_SHARE_CALENDAR_MEMBER;
            L27:
                return CalendarMessageType.SELF_ATTENDEE_STATUS_CHANGE;
            L28:
                return CalendarMessageType.EVENT_UPDATE_LOCATION;
            L29:
                return CalendarMessageType.CALENDAR_UPDATE;
            L30:
                return CalendarMessageType.EVENT_RESCHEDULE;
            L31:
                return CalendarMessageType.EVENT_UPDATE;
            L32:
                return CalendarMessageType.EVENT_DELETE;
            L33:
                return CalendarMessageType.EVENT_INVITE;
            L34:
                return CalendarMessageType.REPLY_TENTATIVE;
            L35:
                return CalendarMessageType.REPLY_DECLINE;
            L36:
                return CalendarMessageType.REPLY_ACCEPT;
            L20:
                return CalendarMessageType.UNKNOWN;
            }
        }

        @JvmStatic
        public static final CalendarMessageType fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<CalendarMessageType> getEntries() {
            return b;
        }

        static {
            CalendarMessageType r0 = new CalendarMessageType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            CalendarMessageType r1 = new CalendarMessageType("REPLY_ACCEPT", 1, 1);
            REPLY_ACCEPT = r1;
            CalendarMessageType r3 = new CalendarMessageType("REPLY_DECLINE", 2, 2);
            REPLY_DECLINE = r3;
            CalendarMessageType r5 = new CalendarMessageType("REPLY_TENTATIVE", 3, 3);
            REPLY_TENTATIVE = r5;
            CalendarMessageType r7 = new CalendarMessageType("EVENT_INVITE", 4, 4);
            EVENT_INVITE = r7;
            CalendarMessageType r9 = new CalendarMessageType("EVENT_DELETE", 5, 5);
            EVENT_DELETE = r9;
            CalendarMessageType r11 = new CalendarMessageType("EVENT_UPDATE", 6, 6);
            EVENT_UPDATE = r11;
            CalendarMessageType r13 = new CalendarMessageType("EVENT_RESCHEDULE", 7, 7);
            EVENT_RESCHEDULE = r13;
            CalendarMessageType r15 = new CalendarMessageType("CALENDAR_UPDATE", 8, 8);
            CALENDAR_UPDATE = r15;
            CalendarMessageType r14 = new CalendarMessageType("EVENT_UPDATE_LOCATION", 9, 9);
            EVENT_UPDATE_LOCATION = r14;
            CalendarMessageType r12 = new CalendarMessageType("SELF_ATTENDEE_STATUS_CHANGE", 10, 10);
            SELF_ATTENDEE_STATUS_CHANGE = r12;
            CalendarMessageType r10 = new CalendarMessageType("ADJUST_SHARE_CALENDAR_MEMBER", 11, 11);
            ADJUST_SHARE_CALENDAR_MEMBER = r10;
            CalendarMessageType r8 = new CalendarMessageType("REMOVE_SHARE_CALENDAR_MEMBER", 12, 12);
            REMOVE_SHARE_CALENDAR_MEMBER = r8;
            CalendarMessageType r6 = new CalendarMessageType("DELETE_SHARE_CALENDAR", 13, 13);
            DELETE_SHARE_CALENDAR = r6;
            CalendarMessageType r4 = new CalendarMessageType("EVENT_UPDATE_DESCRIPTION", 14, 14);
            EVENT_UPDATE_DESCRIPTION = r4;
            CalendarMessageType r2 = new CalendarMessageType("REPLY_ACCEPT_AFTER_DECLINE", 15, 15);
            REPLY_ACCEPT_AFTER_DECLINE = r2;
            CalendarMessageType[] r16 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2};
            a = r16;
            b = EnumEntriesKt.enumEntries(r16);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(CalendarMessageType.class), Syntax.PROTO_2, r0);
        }

        public static CalendarMessageType[] values() {
            return (CalendarMessageType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static CalendarMessageType valueOf(String r1) {
            return (CalendarMessageType) r27.a.a(CalendarMessageType.class, r1);
        }

        public CalendarMessageType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CalendarContent$CalendarMessageVersion;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "V1", "V2", "V3", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum CalendarMessageVersion extends Enum<CalendarMessageVersion> implements o0 {
        public static final ProtoAdapter<CalendarMessageVersion> ADAPTER = null;
        public static final b Companion = null;
        public static final CalendarMessageVersion V1 = null;
        public static final CalendarMessageVersion V2 = null;
        public static final CalendarMessageVersion V3 = null;
        public static final /* synthetic */ CalendarMessageVersion[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<CalendarMessageVersion> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                CalendarMessageVersion.Companion.getClass();
                if (r2 == 1) goto L12;
                if (r2 == 2) goto L15;
                if (r2 == 3) goto L14;
                return null;
            L14:
                return CalendarMessageVersion.V3;
            L15:
                return CalendarMessageVersion.V2;
            L12:
                return CalendarMessageVersion.V1;
            }

            public a(KClass<CalendarMessageVersion> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<CalendarMessageVersion> getEntries() {
            return b;
        }

        static {
            CalendarMessageVersion r0 = new CalendarMessageVersion("V1", 0, 1);
            V1 = r0;
            CalendarMessageVersion r1 = new CalendarMessageVersion("V2", 1, 2);
            V2 = r1;
            CalendarMessageVersion r4 = new CalendarMessageVersion("V3", 2, 3);
            V3 = r4;
            CalendarMessageVersion[] r6 = {r0, r1, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(CalendarMessageVersion.class), Syntax.PROTO_2);
        }

        public static CalendarMessageVersion[] values() {
            return (CalendarMessageVersion[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final CalendarMessageVersion fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L15;
            if (r1 == 3) goto L14;
            return null;
        L14:
            return V3;
        L15:
            return V2;
        L12:
            return V1;
        }

        public static CalendarMessageVersion valueOf(String r1) {
            return (CalendarMessageVersion) r27.a.a(CalendarMessageVersion.class, r1);
        }

        public CalendarMessageVersion(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<CalendarContent, a> {
        public String d;
        public String e;
        public Long f;
        public Long g;
        public String h;
        public String i;
        public Boolean j;
        public String k;
        public CalendarMessageCard l;
        public CalendarEventMessageCard m;
        public CalendarMessageType n;
        public CalendarMessageVersion o;
        public Map<String, Chatter> p;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new CalendarContent(this, c(), null);
        }

        public a() {
            this.p = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ CalendarContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Deprecated(message = "message_chatters is deprecated")
    public static /* synthetic */ void getMessage_chatters$annotations() {
    }

    static {
        Companion = new b();
        DEFAULT_MESSAGE_TYPE = CalendarMessageType.UNKNOWN;
        DEFAULT_MESSAGE_VERSION = CalendarMessageVersion.V1;
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(CalendarContent.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new CalendarContent$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.payload;
        r0.e = this.card_title;
        r0.f = this.start_time;
        r0.g = this.end_time;
        r0.h = this.start_timezone;
        r0.i = this.end_timezone;
        r0.j = this.is_all_day;
        r0.k = this.rrule;
        r0.l = this.calendar_card;
        r0.m = this.event_card;
        r0.n = this.message_type;
        r0.o = this.message_version;
        r0.p = this.message_chatters;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(CalendarContent.class).getSimpleName() + '@' + hashCode();
    }

    public final CalendarMessageCard getCalendar_card() {
        return this.calendar_card;
    }

    public final String getCard_title() {
        return this.card_title;
    }

    public final Long getEnd_time() {
        return this.end_time;
    }

    public final String getEnd_timezone() {
        return this.end_timezone;
    }

    public final CalendarEventMessageCard getEvent_card() {
        return this.event_card;
    }

    public final Map<String, Chatter> getMessage_chatters() {
        return this.message_chatters;
    }

    public final CalendarMessageType getMessage_type() {
        return this.message_type;
    }

    public final CalendarMessageVersion getMessage_version() {
        return this.message_version;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final String getRrule() {
        return this.rrule;
    }

    public final Long getStart_time() {
        return this.start_time;
    }

    public final String getStart_timezone() {
        return this.start_timezone;
    }

    public final Boolean is_all_day() {
        return this.is_all_day;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public CalendarContent(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.payload = r2.d;
        this.card_title = r2.e;
        this.start_time = r2.f;
        this.end_time = r2.g;
        this.start_timezone = r2.h;
        this.end_timezone = r2.i;
        this.is_all_day = r2.j;
        this.rrule = r2.k;
        this.calendar_card = r2.l;
        this.event_card = r2.m;
        this.message_type = r2.n;
        this.message_version = r2.o;
        this.message_chatters = com.lark.wire.internal.a.d("message_chatters", r2.p);
    }

    public /* synthetic */ CalendarContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
