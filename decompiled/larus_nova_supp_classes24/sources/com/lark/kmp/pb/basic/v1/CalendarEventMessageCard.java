package com.lark.kmp.pb.basic.v1;

import com.lark.kmp.pb.calendar.v1.CalendarEvent;
import com.lark.kmp.pb.calendar.v1.CalendarEventAttendee;
import com.lark.kmp.pb.calendar.v1.ConflictType;
import com.lark.kmp.pb.calendar.v1.RecurrenceDisplayInstanceInfo;
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
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 {2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0005z{|}~B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010x\u001a\u00020\u0002H\u0016J\b\u0010y\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0010\u0010\u0012R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000bR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001c\u0010\u0017R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000bR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000bR\u0013\u0010!\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000bR\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0$¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0013\u0010)\u001a\u0004\u0018\u00010*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010-\u001a\u0004\u0018\u00010.¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0015\u00101\u001a\u0004\u0018\u000102¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u0015\u00106\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b6\u0010\u0012R\u0013\u00107\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u000bR\u0013\u00109\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u000bR\u0015\u0010;\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b<\u0010\u0017R\u0013\u0010=\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u000bR\u0015\u0010?\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b@\u0010\u0017R\u0013\u0010A\u001a\u0004\u0018\u00010B¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u001d\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0F¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0015\u0010I\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\bI\u0010\u0012R\u0015\u0010J\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\bK\u0010\u0017R\u0013\u0010L\u001a\u0004\u0018\u00010M¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0017\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00110$¢\u0006\b\n\u0000\u001a\u0004\bP\u0010&R\u0013\u0010Q\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\u000bR\u0015\u0010S\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\bT\u0010\u0012R\u0013\u0010U\u001a\u0004\u0018\u00010V¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0013\u0010Y\u001a\u0004\u0018\u00010Z¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u0015\u0010]\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b]\u0010\u0012R\u0017\u0010^\u001a\b\u0012\u0004\u0012\u00020\t0$¢\u0006\b\n\u0000\u001a\u0004\b_\u0010&R\u001d\u0010`\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0F¢\u0006\b\n\u0000\u001a\u0004\ba\u0010HR\u0013\u0010b\u001a\u0004\u0018\u00010c¢\u0006\b\n\u0000\u001a\u0004\bd\u0010eR\u0013\u0010f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bg\u0010\u000bR\u0013\u0010h\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bi\u0010\u000bR\u0013\u0010j\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bk\u0010\u000bR\u0013\u0010l\u001a\u0004\u0018\u00010m¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0017\u0010p\u001a\b\u0012\u0004\u0012\u00020\t0$¢\u0006\b\n\u0000\u001a\u0004\bq\u0010&R\u0017\u0010r\u001a\b\u0012\u0004\u0012\u00020\t0$¢\u0006\b\n\u0000\u001a\u0004\bs\u0010&R\u0013\u0010t\u001a\u0004\u0018\u00010u¢\u0006\b\n\u0000\u001a\u0004\bv\u0010w¨\u0006\u007f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CalendarEventMessageCard;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CalendarEventMessageCard$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CalendarEventMessageCard$Builder;Lokio/ByteString;)V", "event_id", "", "getEvent_id", "()Ljava/lang/String;", "sender_user_id", "getSender_user_id", "summary", "getSummary", "is_all_day", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "start_time", "", "getStart_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "start_timezone", "getStart_timezone", "end_time", "getEnd_time", "end_timezone", "getEnd_timezone", "rrule", "getRrule", "location", "getLocation", "meeting_rooms", "", "getMeeting_rooms", "()Ljava/util/List;", "attendee_user_ids", "getAttendee_user_ids", "conflict_type", "Lcom/lark/kmp/pb/calendar/v1/ConflictType;", "getConflict_type", "()Lcom/lark/kmp/pb/calendar/v1/ConflictType;", "self_attendee_status", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$Status;", "getSelf_attendee_status", "()Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$Status;", "attendee_count", "", "getAttendee_count", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "is_optional", "calendar_id", "getCalendar_id", "event_key", "getEvent_key", "original_time", "getOriginal_time", "description", "getDescription", "conflict_time", "getConflict_time", "event_type", "Lcom/lark/kmp/pb/calendar/v1/CalendarEvent$Type;", "getEvent_type", "()Lcom/lark/kmp/pb/calendar/v1/CalendarEvent$Type;", "chat_names", "", "getChat_names", "()Ljava/util/Map;", "is_cross_tenant", "version", "getVersion", "desc_rich_text", "Lcom/lark/kmp/pb/basic/v1/RichText;", "getDesc_rich_text", "()Lcom/lark/kmp/pb/basic/v1/RichText;", "is_meeting_rooms_disabled", "user_invite_operator_id", "getUser_invite_operator_id", "show_reply_inviter_entry", "getShow_reply_inviter_entry", "card_status", "Lcom/lark/kmp/pb/basic/v1/CalendarEventMessageCard$EventCardStatus;", "getCard_status", "()Lcom/lark/kmp/pb/basic/v1/CalendarEventMessageCard$EventCardStatus;", "card_info_for_diff", "Lcom/lark/kmp/pb/basic/v1/CalendarEventMessageCard$EventCardInfoForDiff;", "getCard_info_for_diff", "()Lcom/lark/kmp/pb/basic/v1/CalendarEventMessageCard$EventCardInfoForDiff;", "is_webinar", "speaker_chatter_ids", "getSpeaker_chatter_ids", "speaker_chat_names", "getSpeaker_chat_names", "relation_tag", "Lcom/lark/kmp/pb/basic/v1/TagData;", "getRelation_tag", "()Lcom/lark/kmp/pb/basic/v1/TagData;", "successor_user_id", "getSuccessor_user_id", "organizer_user_id", "getOrganizer_user_id", "creator_user_id", "getCreator_user_id", "recurrence_display_instance_info", "Lcom/lark/kmp/pb/calendar/v1/RecurrenceDisplayInstanceInfo;", "getRecurrence_display_instance_info", "()Lcom/lark/kmp/pb/calendar/v1/RecurrenceDisplayInstanceInfo;", "sorted_chat_ids", "getSorted_chat_ids", "sorted_speaker_chat_ids", "getSorted_speaker_chat_ids", "minutes_record_card_state", "Lcom/lark/kmp/pb/basic/v1/CalendarEventMessageCard$MinutesRecordCardState;", "getMinutes_record_card_state", "()Lcom/lark/kmp/pb/basic/v1/CalendarEventMessageCard$MinutesRecordCardState;", "newBuilder", "toString", "Builder", "Companion", "EventCardInfoForDiff", "MinutesRecordCardState", "EventCardStatus", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CalendarEventMessageCard extends com.lark.wire.Message<CalendarEventMessageCard, a> {
    public static final ProtoAdapter<CalendarEventMessageCard> ADAPTER = null;
    public static final b Companion = null;
    public static final int DEFAULT_ATTENDEE_COUNT = 0;
    public static final String DEFAULT_CALENDAR_ID = "";
    public static final EventCardStatus DEFAULT_CARD_STATUS = null;
    public static final long DEFAULT_CONFLICT_TIME = 0;
    public static final ConflictType DEFAULT_CONFLICT_TYPE = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final long DEFAULT_END_TIME = 0;
    public static final String DEFAULT_END_TIMEZONE = "";
    public static final String DEFAULT_EVENT_ID = "";
    public static final String DEFAULT_EVENT_KEY = "";
    public static final CalendarEvent.Type DEFAULT_EVENT_TYPE = null;
    public static final boolean DEFAULT_IS_ALL_DAY = false;
    public static final boolean DEFAULT_IS_CROSS_TENANT = false;
    public static final boolean DEFAULT_IS_OPTIONAL = false;
    public static final String DEFAULT_LOCATION = "";
    public static final long DEFAULT_ORIGINAL_TIME = 0;
    public static final String DEFAULT_RRULE = "";
    public static final CalendarEventAttendee.Status DEFAULT_SELF_ATTENDEE_STATUS = null;
    public static final String DEFAULT_SENDER_USER_ID = "";
    public static final boolean DEFAULT_SHOW_REPLY_INVITER_ENTRY = true;
    public static final long DEFAULT_START_TIME = 0;
    public static final String DEFAULT_START_TIMEZONE = "";
    public static final String DEFAULT_SUMMARY = "";
    public static final String DEFAULT_USER_INVITE_OPERATOR_ID = "";
    public static final long DEFAULT_VERSION = 0;
    private static final long serialVersionUID = 0;
    private final Integer attendee_count;
    private final List<String> attendee_user_ids;
    private final String calendar_id;
    private final EventCardInfoForDiff card_info_for_diff;
    private final EventCardStatus card_status;
    private final Map<String, String> chat_names;
    private final Long conflict_time;
    private final ConflictType conflict_type;
    private final String creator_user_id;
    private final RichText desc_rich_text;
    private final String description;
    private final Long end_time;
    private final String end_timezone;
    private final String event_id;
    private final String event_key;
    private final CalendarEvent.Type event_type;
    private final Boolean is_all_day;
    private final Boolean is_cross_tenant;
    private final List<Boolean> is_meeting_rooms_disabled;
    private final Boolean is_optional;
    private final Boolean is_webinar;
    private final String location;
    private final List<String> meeting_rooms;
    private final MinutesRecordCardState minutes_record_card_state;
    private final String organizer_user_id;
    private final Long original_time;
    private final RecurrenceDisplayInstanceInfo recurrence_display_instance_info;
    private final TagData relation_tag;
    private final String rrule;
    private final CalendarEventAttendee.Status self_attendee_status;
    private final String sender_user_id;
    private final Boolean show_reply_inviter_entry;
    private final List<String> sorted_chat_ids;
    private final List<String> sorted_speaker_chat_ids;
    private final Map<String, String> speaker_chat_names;
    private final List<String> speaker_chatter_ids;
    private final Long start_time;
    private final String start_timezone;
    private final String successor_user_id;
    private final String summary;
    private final String user_invite_operator_id;
    private final Long version;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\"#B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\u0010H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0013\u0010\u0015R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001e¨\u0006$"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CalendarEventMessageCard$EventCardInfoForDiff;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CalendarEventMessageCard$EventCardInfoForDiff$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CalendarEventMessageCard$EventCardInfoForDiff$Builder;Lokio/ByteString;)V", "start_time", "", "getStart_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "end_time", "getEnd_time", "rrule", "", "getRrule", "()Ljava/lang/String;", "is_all_day", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "description", "getDescription", "location", "getLocation", "meeting_rooms", "", "getMeeting_rooms", "()Ljava/util/List;", "is_meeting_rooms_disabled", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class EventCardInfoForDiff extends com.lark.wire.Message<EventCardInfoForDiff, a> {
        public static final ProtoAdapter<EventCardInfoForDiff> ADAPTER = null;
        public static final c Companion = null;
        public static final String DEFAULT_DESCRIPTION = "";
        public static final long DEFAULT_END_TIME = 0;
        public static final boolean DEFAULT_IS_ALL_DAY = false;
        public static final String DEFAULT_LOCATION = "";
        public static final String DEFAULT_RRULE = "";
        public static final long DEFAULT_START_TIME = 0;
        private static final long serialVersionUID = 0;
        private final String description;
        private final Long end_time;
        private final Boolean is_all_day;
        private final List<Boolean> is_meeting_rooms_disabled;
        private final String location;
        private final List<String> meeting_rooms;
        private final String rrule;
        private final Long start_time;

        public static final class a extends com.lark.wire.Message.a<EventCardInfoForDiff, a> {
            public Long d;
            public Long e;
            public String f;
            public Boolean g;
            public String h;
            public String i;
            public List<String> j;
            public List<Boolean> k;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new EventCardInfoForDiff(this, c(), null);
            }

            public a() {
                this.j = CollectionsKt.emptyList();
                this.k = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<EventCardInfoForDiff> {
            @Override // com.lark.wire.ProtoAdapter
            public final EventCardInfoForDiff c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                ArrayList r3 = new ArrayList();
                long r4 = r9.c();
            L3:
                int r6 = r9.e();
                if (r6 == (-1)) goto L15;
                switch(r6) {
                    case 1: goto L14;
                    case 2: goto L13;
                    case 3: goto L12;
                    case 4: goto L11;
                    case 5: goto L10;
                    case 6: goto L9;
                    case 7: goto L8;
                    case 8: goto L7;
                    default: goto L6;
                };
            L7:
                r3.add(ProtoAdapter.g.c(r9));
                goto L3
            L8:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r9, "reader");
                r2.add(r9.i());
                goto L3
            L9:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r9, "reader");
                r1.i = r9.i();
                goto L3
            L10:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r9, "reader");
                r1.h = r9.i();
                goto L3
            L11:
                r1.g = (Boolean) ProtoAdapter.g.c(r9);
                goto L3
            L12:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r9, "reader");
                r1.f = r9.i();
                goto L3
            L13:
                r1.e = (Long) ProtoAdapter.k.c(r9);
                goto L3
            L14:
                r1.d = (Long) ProtoAdapter.k.c(r9);
                goto L3
            L6:
                r9.j(r6);
                Unit r7 = Unit.INSTANCE;
                goto L3
            L15:
                ByteString r10 = r9.d(r4);
                Intrinsics.checkNotNullParameter(r2, "meeting_rooms");
                com.lark.wire.internal.a.a(r2);
                r1.j = r2;
                Intrinsics.checkNotNullParameter(r3, "is_meeting_rooms_disabled");
                com.lark.wire.internal.a.a(r3);
                r1.k = r3;
                return new EventCardInfoForDiff(r1, r10, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(EventCardInfoForDiff r6) {
                EventCardInfoForDiff r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size();
                t r1 = ProtoAdapter.k;
                int r2 = (r0 + r1.l(1, r7.getStart_time())) + r1.l(2, r7.getEnd_time());
                w r3 = ProtoAdapter.q;
                int r4 = r2 + r3.l(3, r7.getRrule());
                l r5 = ProtoAdapter.g;
                return ((((r4 + r5.l(4, r7.is_all_day())) + r3.l(5, r7.getDescription())) + r3.l(6, r7.getLocation())) + r3.a().l(7, r7.getMeeting_rooms())) + r5.a().l(8, r7.is_meeting_rooms_disabled());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, EventCardInfoForDiff r6) {
                EventCardInfoForDiff r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                t r0 = ProtoAdapter.k;
                r0.i(r5, 1, r7.getStart_time());
                r0.i(r5, 2, r7.getEnd_time());
                w r1 = ProtoAdapter.q;
                r1.i(r5, 3, r7.getRrule());
                l r2 = ProtoAdapter.g;
                r2.i(r5, 4, r7.is_all_day());
                r1.i(r5, 5, r7.getDescription());
                r1.i(r5, 6, r7.getLocation());
                r1.a().i(r5, 7, r7.getMeeting_rooms());
                r2.a().i(r5, 8, r7.is_meeting_rooms_disabled());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r6, EventCardInfoForDiff r7) {
                EventCardInfoForDiff r8 = r7;
                Intrinsics.checkNotNullParameter(r6, "writer");
                Intrinsics.checkNotNullParameter(r8, "value");
                r6.d(r8.unknownFields());
                l r0 = ProtoAdapter.g;
                r0.a().j(r6, 8, r8.is_meeting_rooms_disabled());
                w r1 = ProtoAdapter.q;
                r1.a().j(r6, 7, r8.getMeeting_rooms());
                r1.j(r6, 6, r8.getLocation());
                r1.j(r6, 5, r8.getDescription());
                r0.j(r6, 4, r8.is_all_day());
                r1.j(r6, 3, r8.getRrule());
                t r2 = ProtoAdapter.k;
                r2.j(r6, 2, r8.getEnd_time());
                r2.j(r6, 1, r8.getStart_time());
            }

            public b(FieldEncoding r7, KClass<EventCardInfoForDiff> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.CalendarEventMessageCard.EventCardInfoForDiff", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ EventCardInfoForDiff(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(EventCardInfoForDiff.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.start_time;
            r0.e = this.end_time;
            r0.f = this.rrule;
            r0.g = this.is_all_day;
            r0.h = this.description;
            r0.i = this.location;
            r0.j = this.meeting_rooms;
            r0.k = this.is_meeting_rooms_disabled;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(EventCardInfoForDiff.class).getSimpleName() + '@' + hashCode();
        }

        public final String getDescription() {
            return this.description;
        }

        public final Long getEnd_time() {
            return this.end_time;
        }

        public final String getLocation() {
            return this.location;
        }

        public final List<String> getMeeting_rooms() {
            return this.meeting_rooms;
        }

        public final String getRrule() {
            return this.rrule;
        }

        public final Long getStart_time() {
            return this.start_time;
        }

        public final Boolean is_all_day() {
            return this.is_all_day;
        }

        public final List<Boolean> is_meeting_rooms_disabled() {
            return this.is_meeting_rooms_disabled;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public EventCardInfoForDiff(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.start_time = r2.d;
            this.end_time = r2.e;
            this.rrule = r2.f;
            this.is_all_day = r2.g;
            this.description = r2.h;
            this.location = r2.i;
            this.meeting_rooms = com.lark.wire.internal.a.c("meeting_rooms", r2.j);
            this.is_meeting_rooms_disabled = com.lark.wire.internal.a.c("is_meeting_rooms_disabled", r2.k);
        }

        public /* synthetic */ EventCardInfoForDiff(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CalendarEventMessageCard$EventCardStatus;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NORMAL", "INVALID", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum EventCardStatus extends Enum<EventCardStatus> implements o0 {
        public static final ProtoAdapter<EventCardStatus> ADAPTER = null;
        public static final b Companion = null;
        public static final EventCardStatus INVALID = null;
        public static final EventCardStatus NORMAL = null;
        public static final /* synthetic */ EventCardStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<EventCardStatus> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                EventCardStatus.Companion.getClass();
                if (r2 == 0) goto L9;
                if (r2 == 1) goto L11;
                return null;
            L11:
                return EventCardStatus.INVALID;
            L9:
                return EventCardStatus.NORMAL;
            }

            public a(KClass<EventCardStatus> r1, Syntax r2, EventCardStatus r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<EventCardStatus> getEntries() {
            return b;
        }

        static {
            EventCardStatus r0 = new EventCardStatus("NORMAL", 0, 0);
            NORMAL = r0;
            EventCardStatus r1 = new EventCardStatus("INVALID", 1, 1);
            INVALID = r1;
            EventCardStatus[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(EventCardStatus.class), Syntax.PROTO_2, r0);
        }

        public static EventCardStatus[] values() {
            return (EventCardStatus[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final EventCardStatus fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L11;
            return null;
        L11:
            return INVALID;
        L9:
            return NORMAL;
        }

        public static EventCardStatus valueOf(String r1) {
            return (EventCardStatus) r27.a.a(EventCardStatus.class, r1);
        }

        public EventCardStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CalendarEventMessageCard$MinutesRecordCardState;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CalendarEventMessageCard$MinutesRecordCardState$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CalendarEventMessageCard$MinutesRecordCardState$Builder;Lokio/ByteString;)V", "checked", "", "getChecked", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "disabled", "getDisabled", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class MinutesRecordCardState extends com.lark.wire.Message<MinutesRecordCardState, a> {
        public static final ProtoAdapter<MinutesRecordCardState> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Boolean checked;
        private final Boolean disabled;

        public static final class a extends com.lark.wire.Message.a<MinutesRecordCardState, a> {
            public Boolean d;
            public Boolean e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new MinutesRecordCardState(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<MinutesRecordCardState> {
            @Override // com.lark.wire.ProtoAdapter
            public final MinutesRecordCardState c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L13;
                if (r3 != 1) goto L8;
                r0.d = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.e = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L9:
                r6.j(r3);
                Unit r4 = Unit.INSTANCE;
                goto L3
            L13:
                return new MinutesRecordCardState(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(MinutesRecordCardState r5) {
                MinutesRecordCardState r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                l r1 = ProtoAdapter.g;
                return (r0 + r1.l(1, r6.getChecked())) + r1.l(2, r6.getDisabled());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, MinutesRecordCardState r5) {
                MinutesRecordCardState r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                l r0 = ProtoAdapter.g;
                r0.i(r4, 1, r6.getChecked());
                r0.i(r4, 2, r6.getDisabled());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, MinutesRecordCardState r5) {
                MinutesRecordCardState r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                l r0 = ProtoAdapter.g;
                r0.j(r4, 2, r6.getDisabled());
                r0.j(r4, 1, r6.getChecked());
            }

            public b(FieldEncoding r7, KClass<MinutesRecordCardState> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.CalendarEventMessageCard.MinutesRecordCardState", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ MinutesRecordCardState(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MinutesRecordCardState.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.checked;
            r0.e = this.disabled;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(MinutesRecordCardState.class).getSimpleName() + '@' + hashCode();
        }

        public final Boolean getChecked() {
            return this.checked;
        }

        public final Boolean getDisabled() {
            return this.disabled;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public MinutesRecordCardState(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.checked = r2.d;
            this.disabled = r2.e;
        }

        public /* synthetic */ MinutesRecordCardState(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<CalendarEventMessageCard, a> {
        public Boolean A;
        public Long B;
        public RichText C;
        public List<Boolean> D;
        public String E;
        public Boolean F;
        public EventCardStatus G;
        public EventCardInfoForDiff H;
        public Boolean I;
        public List<String> J;
        public Map<String, String> K;
        public TagData L;
        public String M;
        public String N;
        public String O;
        public RecurrenceDisplayInstanceInfo P;
        public List<String> Q;
        public List<String> R;
        public MinutesRecordCardState S;
        public String d;
        public String e;
        public String f;
        public Boolean g;
        public Long h;
        public String i;
        public Long j;
        public String k;
        public String l;
        public String m;
        public List<String> n;
        public List<String> o;
        public ConflictType p;
        public CalendarEventAttendee.Status q;
        public Integer r;
        public Boolean s;
        public String t;
        public String u;
        public Long v;
        public String w;
        public Long x;
        public CalendarEvent.Type y;
        public Map<String, String> z;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new CalendarEventMessageCard(this, c(), null);
        }

        public a() {
            this.n = CollectionsKt.emptyList();
            this.o = CollectionsKt.emptyList();
            this.z = MapsKt.emptyMap();
            this.D = CollectionsKt.emptyList();
            this.J = CollectionsKt.emptyList();
            this.K = MapsKt.emptyMap();
            this.Q = CollectionsKt.emptyList();
            this.R = CollectionsKt.emptyList();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ CalendarEventMessageCard(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        DEFAULT_CONFLICT_TYPE = ConflictType.NONE;
        DEFAULT_SELF_ATTENDEE_STATUS = CalendarEventAttendee.Status.NEEDS_ACTION;
        DEFAULT_EVENT_TYPE = CalendarEvent.Type.DEFAULT_TYPE;
        DEFAULT_CARD_STATUS = EventCardStatus.NORMAL;
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(CalendarEventMessageCard.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new CalendarEventMessageCard$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.event_id;
        r0.e = this.sender_user_id;
        r0.f = this.summary;
        r0.g = this.is_all_day;
        r0.h = this.start_time;
        r0.i = this.start_timezone;
        r0.j = this.end_time;
        r0.k = this.end_timezone;
        r0.l = this.rrule;
        r0.m = this.location;
        r0.n = this.meeting_rooms;
        r0.o = this.attendee_user_ids;
        r0.p = this.conflict_type;
        r0.q = this.self_attendee_status;
        r0.r = this.attendee_count;
        r0.s = this.is_optional;
        r0.t = this.calendar_id;
        r0.u = this.event_key;
        r0.v = this.original_time;
        r0.w = this.description;
        r0.x = this.conflict_time;
        r0.y = this.event_type;
        r0.z = this.chat_names;
        r0.A = this.is_cross_tenant;
        r0.B = this.version;
        r0.C = this.desc_rich_text;
        r0.D = this.is_meeting_rooms_disabled;
        r0.E = this.user_invite_operator_id;
        r0.F = this.show_reply_inviter_entry;
        r0.G = this.card_status;
        r0.H = this.card_info_for_diff;
        r0.I = this.is_webinar;
        r0.J = this.speaker_chatter_ids;
        r0.K = this.speaker_chat_names;
        r0.L = this.relation_tag;
        r0.M = this.successor_user_id;
        r0.N = this.organizer_user_id;
        r0.O = this.creator_user_id;
        r0.P = this.recurrence_display_instance_info;
        r0.Q = this.sorted_chat_ids;
        r0.R = this.sorted_speaker_chat_ids;
        r0.S = this.minutes_record_card_state;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(CalendarEventMessageCard.class).getSimpleName() + '@' + hashCode();
    }

    public final Integer getAttendee_count() {
        return this.attendee_count;
    }

    public final List<String> getAttendee_user_ids() {
        return this.attendee_user_ids;
    }

    public final String getCalendar_id() {
        return this.calendar_id;
    }

    public final EventCardInfoForDiff getCard_info_for_diff() {
        return this.card_info_for_diff;
    }

    public final EventCardStatus getCard_status() {
        return this.card_status;
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

    public final String getCreator_user_id() {
        return this.creator_user_id;
    }

    public final RichText getDesc_rich_text() {
        return this.desc_rich_text;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Long getEnd_time() {
        return this.end_time;
    }

    public final String getEnd_timezone() {
        return this.end_timezone;
    }

    public final String getEvent_id() {
        return this.event_id;
    }

    public final String getEvent_key() {
        return this.event_key;
    }

    public final CalendarEvent.Type getEvent_type() {
        return this.event_type;
    }

    public final String getLocation() {
        return this.location;
    }

    public final List<String> getMeeting_rooms() {
        return this.meeting_rooms;
    }

    public final MinutesRecordCardState getMinutes_record_card_state() {
        return this.minutes_record_card_state;
    }

    public final String getOrganizer_user_id() {
        return this.organizer_user_id;
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

    public final CalendarEventAttendee.Status getSelf_attendee_status() {
        return this.self_attendee_status;
    }

    public final String getSender_user_id() {
        return this.sender_user_id;
    }

    public final Boolean getShow_reply_inviter_entry() {
        return this.show_reply_inviter_entry;
    }

    public final List<String> getSorted_chat_ids() {
        return this.sorted_chat_ids;
    }

    public final List<String> getSorted_speaker_chat_ids() {
        return this.sorted_speaker_chat_ids;
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

    public final String getSuccessor_user_id() {
        return this.successor_user_id;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getUser_invite_operator_id() {
        return this.user_invite_operator_id;
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

    public CalendarEventMessageCard(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.event_id = r2.d;
        this.sender_user_id = r2.e;
        this.summary = r2.f;
        this.is_all_day = r2.g;
        this.start_time = r2.h;
        this.start_timezone = r2.i;
        this.end_time = r2.j;
        this.end_timezone = r2.k;
        this.rrule = r2.l;
        this.location = r2.m;
        this.meeting_rooms = com.lark.wire.internal.a.c("meeting_rooms", r2.n);
        this.attendee_user_ids = com.lark.wire.internal.a.c("attendee_user_ids", r2.o);
        this.conflict_type = r2.p;
        this.self_attendee_status = r2.q;
        this.attendee_count = r2.r;
        this.is_optional = r2.s;
        this.calendar_id = r2.t;
        this.event_key = r2.u;
        this.original_time = r2.v;
        this.description = r2.w;
        this.conflict_time = r2.x;
        this.event_type = r2.y;
        this.chat_names = com.lark.wire.internal.a.d("chat_names", r2.z);
        this.is_cross_tenant = r2.A;
        this.version = r2.B;
        this.desc_rich_text = r2.C;
        this.is_meeting_rooms_disabled = com.lark.wire.internal.a.c("is_meeting_rooms_disabled", r2.D);
        this.user_invite_operator_id = r2.E;
        this.show_reply_inviter_entry = r2.F;
        this.card_status = r2.G;
        this.card_info_for_diff = r2.H;
        this.is_webinar = r2.I;
        this.speaker_chatter_ids = com.lark.wire.internal.a.c("speaker_chatter_ids", r2.J);
        this.speaker_chat_names = com.lark.wire.internal.a.d("speaker_chat_names", r2.K);
        this.relation_tag = r2.L;
        this.successor_user_id = r2.M;
        this.organizer_user_id = r2.N;
        this.creator_user_id = r2.O;
        this.recurrence_display_instance_info = r2.P;
        this.sorted_chat_ids = com.lark.wire.internal.a.c("sorted_chat_ids", r2.Q);
        this.sorted_speaker_chat_ids = com.lark.wire.internal.a.c("sorted_speaker_chat_ids", r2.R);
        this.minutes_record_card_state = r2.S;
    }

    public /* synthetic */ CalendarEventMessageCard(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
