package com.lark.kmp.pb.basic.v1;

import com.lark.kmp.pb.calendar.v1.CalendarEventDescriptionElements;
import com.lark.kmp.pb.calendar.v1.ConflictType;
import com.lark.kmp.pb.calendar.v1.RecurrenceDisplayInstanceInfo;
import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0018\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 i2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002hiB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010f\u001a\u00020\u0002H\u0016J\b\u0010g\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000e\u0010\u0010R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000bR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u001b\u0010\u0010R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001d\u0010\u0015R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000bR\u0013\u0010 \u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000bR\u0013\u0010\"\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000bR\u0015\u0010$\u001a\u0004\u0018\u00010%¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0013\u0010)\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u000bR\u0015\u0010+\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b,\u0010\u0015R\u0013\u0010-\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u000bR\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\t00¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020\t00¢\u0006\b\n\u0000\u001a\u0004\b4\u00102R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\t00¢\u0006\b\n\u0000\u001a\u0004\b6\u00102R\u0015\u00107\u001a\u0004\u0018\u00010%¢\u0006\n\n\u0002\u0010(\u001a\u0004\b8\u0010'R\u0015\u00109\u001a\u0004\u0018\u00010%¢\u0006\n\n\u0002\u0010(\u001a\u0004\b:\u0010'R\u0013\u0010;\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u000bR\u0013\u0010=\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u000bR\u0015\u0010?\u001a\u0004\u0018\u00010%¢\u0006\n\n\u0002\u0010(\u001a\u0004\b@\u0010'R\u0015\u0010A\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\bA\u0010\u0010R\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020\t00¢\u0006\b\n\u0000\u001a\u0004\bC\u00102R\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020\u000f00¢\u0006\b\n\u0000\u001a\u0004\bD\u00102R\u0015\u0010E\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\bE\u0010\u0010R\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020\t00¢\u0006\b\n\u0000\u001a\u0004\bG\u00102R\u001d\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0I¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0015\u0010L\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\bM\u0010\u0015R\u0013\u0010N\u001a\u0004\u0018\u00010O¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0015\u0010R\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\bS\u0010\u0015R\u001d\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0I¢\u0006\b\n\u0000\u001a\u0004\bU\u0010KR\u0013\u0010V\u001a\u0004\u0018\u00010W¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u0013\u0010Z\u001a\u0004\u0018\u00010[¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0013\u0010^\u001a\u0004\u0018\u00010_¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u0013\u0010b\u001a\u0004\u0018\u00010c¢\u0006\b\n\u0000\u001a\u0004\bd\u0010e¨\u0006j"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/EventCardTemplate;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/EventCardTemplate$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/EventCardTemplate$Builder;Lokio/ByteString;)V", "summary", "", "getSummary", "()Ljava/lang/String;", "sender_id", "getSender_id", "is_optional", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "start_time", "", "getStart_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "end_time", "getEnd_time", "rrule", "getRrule", "is_all_day", "version", "getVersion", "start_timezone", "getStart_timezone", "end_timezone", "getEnd_timezone", "id", "getId", "type", "", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "key", "getKey", "original_time", "getOriginal_time", "calendar_id", "getCalendar_id", "meeting_rooms", "", "getMeeting_rooms", "()Ljava/util/List;", "attendee_chatter_ids", "getAttendee_chatter_ids", "chat_ids", "getChat_ids", "self_attendee_status", "getSelf_attendee_status", "attendee_count", "getAttendee_count", "location", "getLocation", "description", "getDescription", "event_type", "getEvent_type", "is_cross_tenant", "individual_chatter_ids", "getIndividual_chatter_ids", "is_meeting_rooms_disabled", "is_webinar", "speaker_chatter_ids", "getSpeaker_chatter_ids", "speaker_chat_names", "", "getSpeaker_chat_names", "()Ljava/util/Map;", "organizer_calendar_id", "getOrganizer_calendar_id", "conflict_type", "Lcom/lark/kmp/pb/calendar/v1/ConflictType;", "getConflict_type", "()Lcom/lark/kmp/pb/calendar/v1/ConflictType;", "conflict_time", "getConflict_time", "chat_names", "getChat_names", "relation_tag", "Lcom/lark/kmp/pb/basic/v1/TagData;", "getRelation_tag", "()Lcom/lark/kmp/pb/basic/v1/TagData;", "server_tag", "Lcom/lark/kmp/pb/basic/v1/ServerTagData;", "getServer_tag", "()Lcom/lark/kmp/pb/basic/v1/ServerTagData;", "description_elements", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventDescriptionElements;", "getDescription_elements", "()Lcom/lark/kmp/pb/calendar/v1/CalendarEventDescriptionElements;", "recurrence_display_instance_info", "Lcom/lark/kmp/pb/calendar/v1/RecurrenceDisplayInstanceInfo;", "getRecurrence_display_instance_info", "()Lcom/lark/kmp/pb/calendar/v1/RecurrenceDisplayInstanceInfo;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class EventCardTemplate extends com.lark.wire.Message<EventCardTemplate, a> {
    public static final ProtoAdapter<EventCardTemplate> ADAPTER = null;
    public static final b Companion = null;
    public static final long DEFAULT_CONFLICT_TIME = 0;
    public static final ConflictType DEFAULT_CONFLICT_TYPE = null;
    private static final long serialVersionUID = 0;
    private final List<String> attendee_chatter_ids;
    private final Integer attendee_count;
    private final String calendar_id;
    private final List<String> chat_ids;
    private final Map<String, String> chat_names;
    private final Long conflict_time;
    private final ConflictType conflict_type;
    private final String description;
    private final CalendarEventDescriptionElements description_elements;
    private final Long end_time;
    private final String end_timezone;
    private final Integer event_type;
    private final String id;
    private final List<String> individual_chatter_ids;
    private final Boolean is_all_day;
    private final Boolean is_cross_tenant;
    private final List<Boolean> is_meeting_rooms_disabled;
    private final Boolean is_optional;
    private final Boolean is_webinar;
    private final String key;
    private final String location;
    private final List<String> meeting_rooms;
    private final Long organizer_calendar_id;
    private final Long original_time;
    private final RecurrenceDisplayInstanceInfo recurrence_display_instance_info;
    private final TagData relation_tag;
    private final String rrule;
    private final Integer self_attendee_status;
    private final String sender_id;
    private final ServerTagData server_tag;
    private final Map<String, String> speaker_chat_names;
    private final List<String> speaker_chatter_ids;
    private final Long start_time;
    private final String start_timezone;
    private final String summary;
    private final Integer type;
    private final Long version;

    public static final class a extends com.lark.wire.Message.a<EventCardTemplate, a> {
        public Boolean A;
        public List<String> B;
        public List<Boolean> C;
        public Boolean D;
        public List<String> E;
        public Map<String, String> F;
        public Long G;
        public ConflictType H;
        public Long I;
        public Map<String, String> J;
        public TagData K;
        public ServerTagData L;
        public CalendarEventDescriptionElements M;
        public RecurrenceDisplayInstanceInfo N;
        public String d;
        public String e;
        public Boolean f;
        public Long g;
        public Long h;
        public String i;
        public Boolean j;
        public Long k;
        public String l;
        public String m;
        public String n;
        public Integer o;
        public String p;
        public Long q;
        public String r;
        public List<String> s;
        public List<String> t;
        public List<String> u;
        public Integer v;
        public Integer w;
        public String x;
        public String y;
        public Integer z;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new EventCardTemplate(this, c(), null);
        }

        public a() {
            this.s = CollectionsKt.emptyList();
            this.t = CollectionsKt.emptyList();
            this.u = CollectionsKt.emptyList();
            this.B = CollectionsKt.emptyList();
            this.C = CollectionsKt.emptyList();
            this.E = CollectionsKt.emptyList();
            this.F = MapsKt.emptyMap();
            this.J = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ EventCardTemplate(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        DEFAULT_CONFLICT_TYPE = ConflictType.NONE;
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(EventCardTemplate.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new EventCardTemplate$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.summary;
        r0.e = this.sender_id;
        r0.f = this.is_optional;
        r0.g = this.start_time;
        r0.h = this.end_time;
        r0.i = this.rrule;
        r0.j = this.is_all_day;
        r0.k = this.version;
        r0.l = this.start_timezone;
        r0.m = this.end_timezone;
        r0.n = this.id;
        r0.o = this.type;
        r0.p = this.key;
        r0.q = this.original_time;
        r0.r = this.calendar_id;
        r0.s = this.meeting_rooms;
        r0.t = this.attendee_chatter_ids;
        r0.u = this.chat_ids;
        r0.v = this.self_attendee_status;
        r0.w = this.attendee_count;
        r0.x = this.location;
        r0.y = this.description;
        r0.z = this.event_type;
        r0.A = this.is_cross_tenant;
        r0.B = this.individual_chatter_ids;
        r0.C = this.is_meeting_rooms_disabled;
        r0.D = this.is_webinar;
        r0.E = this.speaker_chatter_ids;
        r0.F = this.speaker_chat_names;
        r0.G = this.organizer_calendar_id;
        r0.H = this.conflict_type;
        r0.I = this.conflict_time;
        r0.J = this.chat_names;
        r0.K = this.relation_tag;
        r0.L = this.server_tag;
        r0.M = this.description_elements;
        r0.N = this.recurrence_display_instance_info;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(EventCardTemplate.class).getSimpleName() + '@' + hashCode();
    }

    public final List<String> getAttendee_chatter_ids() {
        return this.attendee_chatter_ids;
    }

    public final Integer getAttendee_count() {
        return this.attendee_count;
    }

    public final String getCalendar_id() {
        return this.calendar_id;
    }

    public final List<String> getChat_ids() {
        return this.chat_ids;
    }

    public final Map<String, String> getChat_names() {
        return this.chat_names;
    }

    public final Long getConflict_time() {
        return this.conflict_time;
    }

    public final ConflictType getConflict_type() {
        return this.conflict_type;
    }

    public final String getDescription() {
        return this.description;
    }

    public final CalendarEventDescriptionElements getDescription_elements() {
        return this.description_elements;
    }

    public final Long getEnd_time() {
        return this.end_time;
    }

    public final String getEnd_timezone() {
        return this.end_timezone;
    }

    public final Integer getEvent_type() {
        return this.event_type;
    }

    public final String getId() {
        return this.id;
    }

    public final List<String> getIndividual_chatter_ids() {
        return this.individual_chatter_ids;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getLocation() {
        return this.location;
    }

    public final List<String> getMeeting_rooms() {
        return this.meeting_rooms;
    }

    public final Long getOrganizer_calendar_id() {
        return this.organizer_calendar_id;
    }

    public final Long getOriginal_time() {
        return this.original_time;
    }

    public final RecurrenceDisplayInstanceInfo getRecurrence_display_instance_info() {
        return this.recurrence_display_instance_info;
    }

    public final TagData getRelation_tag() {
        return this.relation_tag;
    }

    public final String getRrule() {
        return this.rrule;
    }

    public final Integer getSelf_attendee_status() {
        return this.self_attendee_status;
    }

    public final String getSender_id() {
        return this.sender_id;
    }

    public final ServerTagData getServer_tag() {
        return this.server_tag;
    }

    public final Map<String, String> getSpeaker_chat_names() {
        return this.speaker_chat_names;
    }

    public final List<String> getSpeaker_chatter_ids() {
        return this.speaker_chatter_ids;
    }

    public final Long getStart_time() {
        return this.start_time;
    }

    public final String getStart_timezone() {
        return this.start_timezone;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final Integer getType() {
        return this.type;
    }

    public final Long getVersion() {
        return this.version;
    }

    public final Boolean is_all_day() {
        return this.is_all_day;
    }

    public final Boolean is_cross_tenant() {
        return this.is_cross_tenant;
    }

    public final List<Boolean> is_meeting_rooms_disabled() {
        return this.is_meeting_rooms_disabled;
    }

    public final Boolean is_optional() {
        return this.is_optional;
    }

    public final Boolean is_webinar() {
        return this.is_webinar;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public EventCardTemplate(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.summary = r2.d;
        this.sender_id = r2.e;
        this.is_optional = r2.f;
        this.start_time = r2.g;
        this.end_time = r2.h;
        this.rrule = r2.i;
        this.is_all_day = r2.j;
        this.version = r2.k;
        this.start_timezone = r2.l;
        this.end_timezone = r2.m;
        this.id = r2.n;
        this.type = r2.o;
        this.key = r2.p;
        this.original_time = r2.q;
        this.calendar_id = r2.r;
        this.meeting_rooms = com.lark.wire.internal.a.c("meeting_rooms", r2.s);
        this.attendee_chatter_ids = com.lark.wire.internal.a.c("attendee_chatter_ids", r2.t);
        this.chat_ids = com.lark.wire.internal.a.c("chat_ids", r2.u);
        this.self_attendee_status = r2.v;
        this.attendee_count = r2.w;
        this.location = r2.x;
        this.description = r2.y;
        this.event_type = r2.z;
        this.is_cross_tenant = r2.A;
        this.individual_chatter_ids = com.lark.wire.internal.a.c("individual_chatter_ids", r2.B);
        this.is_meeting_rooms_disabled = com.lark.wire.internal.a.c("is_meeting_rooms_disabled", r2.C);
        this.is_webinar = r2.D;
        this.speaker_chatter_ids = com.lark.wire.internal.a.c("speaker_chatter_ids", r2.E);
        this.speaker_chat_names = com.lark.wire.internal.a.d("speaker_chat_names", r2.F);
        this.organizer_calendar_id = r2.G;
        this.conflict_type = r2.H;
        this.conflict_time = r2.I;
        this.chat_names = com.lark.wire.internal.a.d("chat_names", r2.J);
        this.relation_tag = r2.K;
        this.server_tag = r2.L;
        this.description_elements = r2.M;
        this.recurrence_display_instance_info = r2.N;
    }

    public /* synthetic */ EventCardTemplate(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
