package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.s;
import com.lark.wire.t;
import com.lark.wire.w;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0018\u0019\u001a\u001bB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/VideoChatContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/VideoChatContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/VideoChatContent$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/VideoChatContent$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/VideoChatContent$Type;", "meeting_card", "Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard;", "getMeeting_card", "()Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard;", "sequence_id", "", "getSequence_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "", "Builder", "Companion", "Type", "MeetingCard", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class VideoChatContent extends com.lark.wire.Message<VideoChatContent, a> {
    public static final ProtoAdapter<VideoChatContent> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final MeetingCard meeting_card;
    private final Long sequence_id;
    private final Type type;

    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 U2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0007TUVWXYZB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010R\u001a\u00020\u0002H\u0016J\b\u0010S\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u0011\u0010\u001a\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000bR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000bR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0015\u0010%\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0013\u0010*\u001a\u0004\u0018\u00010+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010.\u001a\u0004\u0018\u00010/¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u00102\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u000bR\u0013\u00104\u001a\u0004\u0018\u000105¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u00108\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u000bR\u0015\u0010:\u001a\u0004\u0018\u00010;¢\u0006\n\n\u0002\u0010=\u001a\u0004\b:\u0010<R\u0013\u0010>\u001a\u0004\u0018\u00010?¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0015\u0010B\u001a\u0004\u0018\u00010;¢\u0006\n\n\u0002\u0010=\u001a\u0004\bB\u0010<R\u0013\u0010C\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u000bR\u0013\u0010E\u001a\u0004\u0018\u00010+¢\u0006\b\n\u0000\u001a\u0004\bF\u0010-R\u0015\u0010G\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\bH\u0010\u0016R\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00110!¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010$R\u0015\u0010K\u001a\u0004\u0018\u00010;¢\u0006\n\n\u0002\u0010=\u001a\u0004\bK\u0010<R\u0015\u0010L\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0002\u0010)\u001a\u0004\bM\u0010(R\u0015\u0010N\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0002\u0010)\u001a\u0004\bO\u0010(R\u0013\u0010P\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u000b¨\u0006["}, d2 = {"Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$Builder;Lokio/ByteString;)V", "meeting_id", "", "getMeeting_id", "()Ljava/lang/String;", "status", "Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$Status;", "getStatus", "()Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$Status;", "start_time_ms", "", "getStart_time_ms", "()J", "end_time_ms", "getEnd_time_ms", "()Ljava/lang/Long;", "Ljava/lang/Long;", "topic", "getTopic", "sponsor_id", "getSponsor_id", "host_id", "getHost_id", "meet_number", "getMeet_number", "participants", "", "Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$MeetingParticipant;", "getParticipants", "()Ljava/util/List;", "max_participant_count", "", "getMax_participant_count", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "host_type", "Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$ParticipantType;", "getHost_type", "()Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$ParticipantType;", "card_type", "Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$CardType;", "getCard_type", "()Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$CardType;", "forwarder_id", "getForwarder_id", "meeting_source", "Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$MeetingSource;", "getMeeting_source", "()Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$MeetingSource;", "calendar_uid", "getCalendar_uid", "is_locked", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "i18n_default_topic", "Lcom/lark/kmp/pb/basic/v1/VideoChatI18nDefaultTopic;", "getI18n_default_topic", "()Lcom/lark/kmp/pb/basic/v1/VideoChatI18nDefaultTopic;", "is_open_lobby", "owner_user_id", "getOwner_user_id", "owner_type", "getOwner_type", "total_participant_num", "getTotal_participant_num", "all_participant_tenant", "getAll_participant_tenant", "is_cross_with_ka", "meeting_sub_type", "getMeeting_sub_type", "webinar_attendee_num", "getWebinar_attendee_num", "password", "getPassword", "newBuilder", "toString", "Builder", "Companion", "Status", "ParticipantType", "CardType", "MeetingSource", "MeetingParticipant", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class MeetingCard extends com.lark.wire.Message<MeetingCard, a> {
        public static final ProtoAdapter<MeetingCard> ADAPTER = null;
        public static final c Companion = null;
        public static final ParticipantType DEFAULT_HOST_TYPE = null;
        private static final long serialVersionUID = 0;
        private final List<Long> all_participant_tenant;
        private final String calendar_uid;
        private final CardType card_type;
        private final Long end_time_ms;
        private final String forwarder_id;
        private final String host_id;
        private final ParticipantType host_type;
        private final VideoChatI18nDefaultTopic i18n_default_topic;
        private final Boolean is_cross_with_ka;
        private final Boolean is_locked;
        private final Boolean is_open_lobby;
        private final Integer max_participant_count;
        private final String meet_number;
        private final String meeting_id;
        private final MeetingSource meeting_source;
        private final Integer meeting_sub_type;
        private final ParticipantType owner_type;
        private final String owner_user_id;
        private final List<MeetingParticipant> participants;
        private final String password;
        private final String sponsor_id;
        private final long start_time_ms;
        private final Status status;
        private final String topic;
        private final Long total_participant_num;
        private final Integer webinar_attendee_num;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$CardType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_CARD_TYPE", "SPONSOR", "FORWARD", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum CardType extends Enum<CardType> implements o0 {
            public static final ProtoAdapter<CardType> ADAPTER = null;
            public static final b Companion = null;
            public static final CardType FORWARD = null;
            public static final CardType SPONSOR = null;
            public static final CardType UNKNOWN_CARD_TYPE = null;
            public static final /* synthetic */ CardType[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<CardType> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    CardType.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return CardType.FORWARD;
                L15:
                    return CardType.SPONSOR;
                L12:
                    return CardType.UNKNOWN_CARD_TYPE;
                }

                public a(KClass<CardType> r1, Syntax r2, CardType r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<CardType> getEntries() {
                return b;
            }

            static {
                CardType r0 = new CardType("UNKNOWN_CARD_TYPE", 0, 0);
                UNKNOWN_CARD_TYPE = r0;
                CardType r1 = new CardType("SPONSOR", 1, 1);
                SPONSOR = r1;
                CardType r3 = new CardType("FORWARD", 2, 2);
                FORWARD = r3;
                CardType[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(CardType.class), Syntax.PROTO_2, r0);
            }

            public static CardType[] values() {
                return (CardType[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final CardType fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return FORWARD;
            L15:
                return SPONSOR;
            L12:
                return UNKNOWN_CARD_TYPE;
            }

            public static CardType valueOf(String r1) {
                return (CardType) r27.a.a(CardType.class, r1);
            }

            public CardType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 42\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0006345678B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u00101\u001a\u00020\u0002H\u0016J\b\u00102\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000bR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001b\u0010\u001dR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010#\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u000bR\u0013\u0010%\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010)\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u000bR\u0013\u0010+\u001a\u0004\u0018\u00010,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0015\u0010/\u001a\u0004\u0018\u00010\u001c¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b0\u0010\u001d¨\u00069"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$MeetingParticipant;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$MeetingParticipant$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$MeetingParticipant$Builder;Lokio/ByteString;)V", "user_id", "", "getUser_id", "()Ljava/lang/String;", "join_time_ms", "", "getJoin_time_ms", "()Ljava/lang/Long;", "Ljava/lang/Long;", "status", "Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$MeetingParticipant$Status;", "getStatus", "()Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$MeetingParticipant$Status;", "device_id", "getDevice_id", "user_type", "Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$ParticipantType;", "getUser_type", "()Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$ParticipantType;", "is_lark_guest", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "device_type", "Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$MeetingParticipant$DeviceType;", "getDevice_type", "()Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$MeetingParticipant$DeviceType;", "tenant_id", "getTenant_id", "tenant_tag", "Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$MeetingParticipant$TenantTag;", "getTenant_tag", "()Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$MeetingParticipant$TenantTag;", "bind_id", "getBind_id", "bind_type", "Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$MeetingParticipant$BindType;", "getBind_type", "()Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$MeetingParticipant$BindType;", "used_call_me", "getUsed_call_me", "newBuilder", "toString", "Builder", "Companion", "Status", "TenantTag", "DeviceType", "BindType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class MeetingParticipant extends com.lark.wire.Message<MeetingParticipant, a> {
            public static final ProtoAdapter<MeetingParticipant> ADAPTER = null;
            public static final c Companion = null;
            public static final ParticipantType DEFAULT_USER_TYPE = null;
            private static final long serialVersionUID = 0;
            private final String bind_id;
            private final BindType bind_type;
            private final String device_id;
            private final DeviceType device_type;
            private final Boolean is_lark_guest;
            private final Long join_time_ms;
            private final Status status;
            private final String tenant_id;
            private final TenantTag tenant_tag;
            private final Boolean used_call_me;
            private final String user_id;
            private final ParticipantType user_type;

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$MeetingParticipant$BindType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKOWN", "LARK", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
            public static final enum BindType extends Enum<BindType> implements o0 {
                public static final ProtoAdapter<BindType> ADAPTER = null;
                public static final b Companion = null;
                public static final BindType LARK = null;
                public static final BindType UNKOWN = null;
                public static final /* synthetic */ BindType[] a = null;
                public static final /* synthetic */ EnumEntries b = null;
                private final int value;

                public static final class a extends d<BindType> {
                    @Override // com.lark.wire.d
                    public final o0 n(int r2) {
                        BindType.Companion.getClass();
                        if (r2 == 0) goto L9;
                        if (r2 == 1) goto L11;
                        return null;
                    L11:
                        return BindType.LARK;
                    L9:
                        return BindType.UNKOWN;
                    }

                    public a(KClass<BindType> r1, Syntax r2, BindType r3) {
                        super(r1, r2, r3);
                    }
                }

                public static final class b {
                    public b() {
                    }
                }

                public static EnumEntries<BindType> getEntries() {
                    return b;
                }

                static {
                    BindType r0 = new BindType("UNKOWN", 0, 0);
                    UNKOWN = r0;
                    BindType r1 = new BindType("LARK", 1, 1);
                    LARK = r1;
                    BindType[] r3 = {r0, r1};
                    a = r3;
                    b = EnumEntriesKt.enumEntries(r3);
                    Companion = new b();
                    ADAPTER = new a(Reflection.getOrCreateKotlinClass(BindType.class), Syntax.PROTO_2, r0);
                }

                public static BindType[] values() {
                    return (BindType[]) a.clone();
                }

                @Override // com.lark.wire.o0
                public int getValue() {
                    return this.value;
                }

                @JvmStatic
                public static final BindType fromValue(int r1) {
                    Companion.getClass();
                    if (r1 == 0) goto L9;
                    if (r1 == 1) goto L11;
                    return null;
                L11:
                    return LARK;
                L9:
                    return UNKOWN;
                }

                public static BindType valueOf(String r1) {
                    return (BindType) r27.a.a(BindType.class, r1);
                }

                public BindType(String r1, int r2, int r3) {
                    super(r1, r2);
                    this.value = r3;
                }
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$MeetingParticipant$DeviceType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_DEVICE_TYPE", "DESKTOP", "MOBILE", "WEB", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
            public static final enum DeviceType extends Enum<DeviceType> implements o0 {
                public static final ProtoAdapter<DeviceType> ADAPTER = null;
                public static final b Companion = null;
                public static final DeviceType DESKTOP = null;
                public static final DeviceType MOBILE = null;
                public static final DeviceType UNKNOWN_DEVICE_TYPE = null;
                public static final DeviceType WEB = null;
                public static final /* synthetic */ DeviceType[] a = null;
                public static final /* synthetic */ EnumEntries b = null;
                private final int value;

                public static final class a extends d<DeviceType> {
                    @Override // com.lark.wire.d
                    public final o0 n(int r2) {
                        DeviceType.Companion.getClass();
                        if (r2 == 0) goto L15;
                        if (r2 == 1) goto L19;
                        if (r2 == 2) goto L18;
                        if (r2 == 3) goto L17;
                        return null;
                    L17:
                        return DeviceType.WEB;
                    L18:
                        return DeviceType.MOBILE;
                    L19:
                        return DeviceType.DESKTOP;
                    L15:
                        return DeviceType.UNKNOWN_DEVICE_TYPE;
                    }

                    public a(KClass<DeviceType> r1, Syntax r2, DeviceType r3) {
                        super(r1, r2, r3);
                    }
                }

                public static final class b {
                    public b() {
                    }
                }

                public static EnumEntries<DeviceType> getEntries() {
                    return b;
                }

                static {
                    DeviceType r0 = new DeviceType("UNKNOWN_DEVICE_TYPE", 0, 0);
                    UNKNOWN_DEVICE_TYPE = r0;
                    DeviceType r1 = new DeviceType("DESKTOP", 1, 1);
                    DESKTOP = r1;
                    DeviceType r3 = new DeviceType("MOBILE", 2, 2);
                    MOBILE = r3;
                    DeviceType r5 = new DeviceType("WEB", 3, 3);
                    WEB = r5;
                    DeviceType[] r7 = {r0, r1, r3, r5};
                    a = r7;
                    b = EnumEntriesKt.enumEntries(r7);
                    Companion = new b();
                    ADAPTER = new a(Reflection.getOrCreateKotlinClass(DeviceType.class), Syntax.PROTO_2, r0);
                }

                public static DeviceType[] values() {
                    return (DeviceType[]) a.clone();
                }

                @Override // com.lark.wire.o0
                public int getValue() {
                    return this.value;
                }

                @JvmStatic
                public static final DeviceType fromValue(int r1) {
                    Companion.getClass();
                    if (r1 == 0) goto L15;
                    if (r1 == 1) goto L19;
                    if (r1 == 2) goto L18;
                    if (r1 == 3) goto L17;
                    return null;
                L17:
                    return WEB;
                L18:
                    return MOBILE;
                L19:
                    return DESKTOP;
                L15:
                    return UNKNOWN_DEVICE_TYPE;
                }

                public static DeviceType valueOf(String r1) {
                    return (DeviceType) r27.a.a(DeviceType.class, r1);
                }

                public DeviceType(String r1, int r2, int r3) {
                    super(r1, r2);
                    this.value = r3;
                }
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$MeetingParticipant$Status;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "CALLING", "ON_THE_CALL", "RINGING", "IDLE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
            public static final enum Status extends Enum<Status> implements o0 {
                public static final ProtoAdapter<Status> ADAPTER = null;
                public static final Status CALLING = null;
                public static final b Companion = null;
                public static final Status IDLE = null;
                public static final Status ON_THE_CALL = null;
                public static final Status RINGING = null;
                public static final Status UNKNOWN = null;
                public static final /* synthetic */ Status[] a = null;
                public static final /* synthetic */ EnumEntries b = null;
                private final int value;

                public static final class a extends d<Status> {
                    @Override // com.lark.wire.d
                    public final o0 n(int r2) {
                        Status.Companion.getClass();
                        return b.a(r2);
                    }

                    public a(KClass<Status> r1, Syntax r2, Status r3) {
                        super(r1, r2, r3);
                    }
                }

                public static final class b {
                    public b() {
                    }

                    @JvmStatic
                    public static Status a(int r1) {
                        if (r1 == 0) goto L17;
                        if (r1 == 1) goto L22;
                        if (r1 == 2) goto L21;
                        if (r1 == 3) goto L20;
                        if (r1 == 4) goto L19;
                        return null;
                    L19:
                        return Status.IDLE;
                    L20:
                        return Status.RINGING;
                    L21:
                        return Status.ON_THE_CALL;
                    L22:
                        return Status.CALLING;
                    L17:
                        return Status.UNKNOWN;
                    }
                }

                @JvmStatic
                public static final Status fromValue(int r1) {
                    Companion.getClass();
                    return b.a(r1);
                }

                public static EnumEntries<Status> getEntries() {
                    return b;
                }

                static {
                    Status r0 = new Status("UNKNOWN", 0, 0);
                    UNKNOWN = r0;
                    Status r1 = new Status("CALLING", 1, 1);
                    CALLING = r1;
                    Status r3 = new Status("ON_THE_CALL", 2, 2);
                    ON_THE_CALL = r3;
                    Status r5 = new Status("RINGING", 3, 3);
                    RINGING = r5;
                    Status r7 = new Status("IDLE", 4, 4);
                    IDLE = r7;
                    Status[] r9 = {r0, r1, r3, r5, r7};
                    a = r9;
                    b = EnumEntriesKt.enumEntries(r9);
                    Companion = new b();
                    ADAPTER = new a(Reflection.getOrCreateKotlinClass(Status.class), Syntax.PROTO_2, r0);
                }

                public static Status[] values() {
                    return (Status[]) a.clone();
                }

                @Override // com.lark.wire.o0
                public int getValue() {
                    return this.value;
                }

                public static Status valueOf(String r1) {
                    return (Status) r27.a.a(Status.class, r1);
                }

                public Status(String r1, int r2, int r3) {
                    super(r1, r2);
                    this.value = r3;
                }
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$MeetingParticipant$TenantTag;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "STANDARD", "UNDEFINED", "SIMPLE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
            public static final enum TenantTag extends Enum<TenantTag> implements o0 {
                public static final ProtoAdapter<TenantTag> ADAPTER = null;
                public static final b Companion = null;
                public static final TenantTag SIMPLE = null;
                public static final TenantTag STANDARD = null;
                public static final TenantTag UNDEFINED = null;
                public static final /* synthetic */ TenantTag[] a = null;
                public static final /* synthetic */ EnumEntries b = null;
                private final int value;

                public static final class a extends d<TenantTag> {
                    @Override // com.lark.wire.d
                    public final o0 n(int r2) {
                        TenantTag.Companion.getClass();
                        if (r2 == 0) goto L12;
                        if (r2 == 1) goto L15;
                        if (r2 == 2) goto L14;
                        return null;
                    L14:
                        return TenantTag.SIMPLE;
                    L15:
                        return TenantTag.UNDEFINED;
                    L12:
                        return TenantTag.STANDARD;
                    }

                    public a(KClass<TenantTag> r1, Syntax r2, TenantTag r3) {
                        super(r1, r2, r3);
                    }
                }

                public static final class b {
                    public b() {
                    }
                }

                public static EnumEntries<TenantTag> getEntries() {
                    return b;
                }

                static {
                    TenantTag r0 = new TenantTag("STANDARD", 0, 0);
                    STANDARD = r0;
                    TenantTag r1 = new TenantTag("UNDEFINED", 1, 1);
                    UNDEFINED = r1;
                    TenantTag r3 = new TenantTag("SIMPLE", 2, 2);
                    SIMPLE = r3;
                    TenantTag[] r5 = {r0, r1, r3};
                    a = r5;
                    b = EnumEntriesKt.enumEntries(r5);
                    Companion = new b();
                    ADAPTER = new a(Reflection.getOrCreateKotlinClass(TenantTag.class), Syntax.PROTO_2, r0);
                }

                public static TenantTag[] values() {
                    return (TenantTag[]) a.clone();
                }

                @Override // com.lark.wire.o0
                public int getValue() {
                    return this.value;
                }

                @JvmStatic
                public static final TenantTag fromValue(int r1) {
                    Companion.getClass();
                    if (r1 == 0) goto L12;
                    if (r1 == 1) goto L15;
                    if (r1 == 2) goto L14;
                    return null;
                L14:
                    return SIMPLE;
                L15:
                    return UNDEFINED;
                L12:
                    return STANDARD;
                }

                public static TenantTag valueOf(String r1) {
                    return (TenantTag) r27.a.a(TenantTag.class, r1);
                }

                public TenantTag(String r1, int r2, int r3) {
                    super(r1, r2);
                    this.value = r3;
                }
            }

            public static final class a extends com.lark.wire.Message.a<MeetingParticipant, a> {
                public String d;
                public Long e;
                public Status f;
                public String g;
                public ParticipantType h;
                public Boolean i;
                public DeviceType j;
                public String k;
                public TenantTag l;
                public String m;
                public BindType n;
                public Boolean o;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new MeetingParticipant(this, c(), null);
                }

                public a() {
                }
            }

            public static final class b extends ProtoAdapter<MeetingParticipant> {
                @Override // com.lark.wire.ProtoAdapter
                public final MeetingParticipant c(g0 r10) {
                    Intrinsics.checkNotNullParameter(r10, "reader");
                    a r1 = new a();
                    long r2 = r10.c();
                L3:
                    int r4 = r10.e();
                    if (r4 == (-1)) goto L35;
                    switch(r4) {
                        case 1: goto L33;
                        case 2: goto L32;
                        case 3: goto L40;
                        case 4: goto L27;
                        case 5: goto L44;
                        case 6: goto L22;
                        case 7: goto L38;
                        case 8: goto L17;
                        case 9: goto L42;
                        case 10: goto L12;
                        case 11: goto L36;
                        case 12: goto L7;
                        default: goto L6;
                    };
                L36:
                    r1.n = BindType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
                L10:
                    e = move-exception;
                    r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                    Unit r5 = Unit.INSTANCE;
                    goto L3
                L38:
                    r1.j = DeviceType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
                L20:
                    e = move-exception;
                    r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                    Unit r6 = Unit.INSTANCE;
                    goto L3
                L40:
                    r1.f = Status.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L30
                L30:
                    e = move-exception;
                    r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                    Unit r7 = Unit.INSTANCE;
                    goto L3
                L42:
                    r1.l = TenantTag.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
                L15:
                    e = move-exception;
                    r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                    Unit r8 = Unit.INSTANCE;
                    goto L3
                L44:
                    r1.h = ParticipantType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
                L25:
                    e = move-exception;
                    r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                    Unit r9 = Unit.INSTANCE;
                    goto L3
                L7:
                    r1.o = (Boolean) ProtoAdapter.g.c(r10);
                    goto L3
                L12:
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r10, "reader");
                    r1.m = r10.i();
                    goto L3
                L17:
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r10, "reader");
                    r1.k = r10.i();
                    goto L3
                L22:
                    r1.i = (Boolean) ProtoAdapter.g.c(r10);
                    goto L3
                L27:
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r10, "reader");
                    r1.g = r10.i();
                    goto L3
                L32:
                    r1.e = (Long) ProtoAdapter.k.c(r10);
                    goto L3
                L33:
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r10, "reader");
                    String r11 = r10.i();
                    Intrinsics.checkNotNullParameter(r11, "user_id");
                    r1.d = r11;
                    goto L3
                L6:
                    r10.j(r4);
                    Unit r12 = Unit.INSTANCE;
                    goto L3
                L35:
                    return new MeetingParticipant(r1, r10.d(r2), null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(MeetingParticipant r7) {
                    MeetingParticipant r8 = r7;
                    Intrinsics.checkNotNullParameter(r8, "value");
                    int r0 = r8.unknownFields().size();
                    w r1 = ProtoAdapter.q;
                    int r2 = ((((r0 + r1.l(1, r8.getUser_id())) + ProtoAdapter.k.l(2, r8.getJoin_time_ms())) + Status.ADAPTER.l(3, r8.getStatus())) + r1.l(4, r8.getDevice_id())) + ParticipantType.ADAPTER.l(5, r8.getUser_type());
                    l r3 = ProtoAdapter.g;
                    return ((((((r2 + r3.l(6, r8.is_lark_guest())) + DeviceType.ADAPTER.l(7, r8.getDevice_type())) + r1.l(8, r8.getTenant_id())) + TenantTag.ADAPTER.l(9, r8.getTenant_tag())) + r1.l(10, r8.getBind_id())) + BindType.ADAPTER.l(11, r8.getBind_type())) + r3.l(12, r8.getUsed_call_me());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r6, MeetingParticipant r7) {
                    MeetingParticipant r8 = r7;
                    Intrinsics.checkNotNullParameter(r6, "writer");
                    Intrinsics.checkNotNullParameter(r8, "value");
                    w r0 = ProtoAdapter.q;
                    r0.i(r6, 1, r8.getUser_id());
                    ProtoAdapter.k.i(r6, 2, r8.getJoin_time_ms());
                    Status.ADAPTER.i(r6, 3, r8.getStatus());
                    r0.i(r6, 4, r8.getDevice_id());
                    ParticipantType.ADAPTER.i(r6, 5, r8.getUser_type());
                    l r1 = ProtoAdapter.g;
                    r1.i(r6, 6, r8.is_lark_guest());
                    DeviceType.ADAPTER.i(r6, 7, r8.getDevice_type());
                    r0.i(r6, 8, r8.getTenant_id());
                    TenantTag.ADAPTER.i(r6, 9, r8.getTenant_tag());
                    r0.i(r6, 10, r8.getBind_id());
                    BindType.ADAPTER.i(r6, 11, r8.getBind_type());
                    r1.i(r6, 12, r8.getUsed_call_me());
                    r6.a(r8.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r6, MeetingParticipant r7) {
                    MeetingParticipant r8 = r7;
                    Intrinsics.checkNotNullParameter(r6, "writer");
                    Intrinsics.checkNotNullParameter(r8, "value");
                    r6.d(r8.unknownFields());
                    l r0 = ProtoAdapter.g;
                    r0.j(r6, 12, r8.getUsed_call_me());
                    BindType.ADAPTER.j(r6, 11, r8.getBind_type());
                    w r1 = ProtoAdapter.q;
                    r1.j(r6, 10, r8.getBind_id());
                    TenantTag.ADAPTER.j(r6, 9, r8.getTenant_tag());
                    r1.j(r6, 8, r8.getTenant_id());
                    DeviceType.ADAPTER.j(r6, 7, r8.getDevice_type());
                    r0.j(r6, 6, r8.is_lark_guest());
                    ParticipantType.ADAPTER.j(r6, 5, r8.getUser_type());
                    r1.j(r6, 4, r8.getDevice_id());
                    Status.ADAPTER.j(r6, 3, r8.getStatus());
                    ProtoAdapter.k.j(r6, 2, r8.getJoin_time_ms());
                    r1.j(r6, 1, r8.getUser_id());
                }

                public b(FieldEncoding r7, KClass<MeetingParticipant> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.VideoChatContent.MeetingCard.MeetingParticipant", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ MeetingParticipant(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                DEFAULT_USER_TYPE = ParticipantType.LARK_USER;
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MeetingParticipant.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.user_id;
                r0.e = this.join_time_ms;
                r0.f = this.status;
                r0.g = this.device_id;
                r0.h = this.user_type;
                r0.i = this.is_lark_guest;
                r0.j = this.device_type;
                r0.k = this.tenant_id;
                r0.l = this.tenant_tag;
                r0.m = this.bind_id;
                r0.n = this.bind_type;
                r0.o = this.used_call_me;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(MeetingParticipant.class).getSimpleName() + '@' + hashCode();
            }

            public final String getBind_id() {
                return this.bind_id;
            }

            public final BindType getBind_type() {
                return this.bind_type;
            }

            public final String getDevice_id() {
                return this.device_id;
            }

            public final DeviceType getDevice_type() {
                return this.device_type;
            }

            public final Long getJoin_time_ms() {
                return this.join_time_ms;
            }

            public final Status getStatus() {
                return this.status;
            }

            public final String getTenant_id() {
                return this.tenant_id;
            }

            public final TenantTag getTenant_tag() {
                return this.tenant_tag;
            }

            public final Boolean getUsed_call_me() {
                return this.used_call_me;
            }

            public final String getUser_id() {
                return this.user_id;
            }

            public final ParticipantType getUser_type() {
                return this.user_type;
            }

            public final Boolean is_lark_guest() {
                return this.is_lark_guest;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public MeetingParticipant(a r2, ByteString r3) {
                super(ADAPTER, r3);
                String r4 = r2.d;
                Intrinsics.checkNotNull(r4);
                this.user_id = r4;
                this.join_time_ms = r2.e;
                this.status = r2.f;
                this.device_id = r2.g;
                this.user_type = r2.h;
                this.is_lark_guest = r2.i;
                this.device_type = r2.j;
                this.tenant_id = r2.k;
                this.tenant_tag = r2.l;
                this.bind_id = r2.m;
                this.bind_type = r2.n;
                this.used_call_me = r2.o;
            }

            public /* synthetic */ MeetingParticipant(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$MeetingSource;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CARD_UNKNOWN_SOURCE_TYPE", "CARD_FROM_USER", "CARD_FROM_CALENDAR", "CARD_FROM_INTERVIEW", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum MeetingSource extends Enum<MeetingSource> implements o0 {
            public static final ProtoAdapter<MeetingSource> ADAPTER = null;
            public static final MeetingSource CARD_FROM_CALENDAR = null;
            public static final MeetingSource CARD_FROM_INTERVIEW = null;
            public static final MeetingSource CARD_FROM_USER = null;
            public static final MeetingSource CARD_UNKNOWN_SOURCE_TYPE = null;
            public static final b Companion = null;
            public static final /* synthetic */ MeetingSource[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<MeetingSource> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    MeetingSource.Companion.getClass();
                    if (r2 == 0) goto L15;
                    if (r2 == 1) goto L19;
                    if (r2 == 2) goto L18;
                    if (r2 == 3) goto L17;
                    return null;
                L17:
                    return MeetingSource.CARD_FROM_INTERVIEW;
                L18:
                    return MeetingSource.CARD_FROM_CALENDAR;
                L19:
                    return MeetingSource.CARD_FROM_USER;
                L15:
                    return MeetingSource.CARD_UNKNOWN_SOURCE_TYPE;
                }

                public a(KClass<MeetingSource> r1, Syntax r2, MeetingSource r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<MeetingSource> getEntries() {
                return b;
            }

            static {
                MeetingSource r0 = new MeetingSource("CARD_UNKNOWN_SOURCE_TYPE", 0, 0);
                CARD_UNKNOWN_SOURCE_TYPE = r0;
                MeetingSource r1 = new MeetingSource("CARD_FROM_USER", 1, 1);
                CARD_FROM_USER = r1;
                MeetingSource r3 = new MeetingSource("CARD_FROM_CALENDAR", 2, 2);
                CARD_FROM_CALENDAR = r3;
                MeetingSource r5 = new MeetingSource("CARD_FROM_INTERVIEW", 3, 3);
                CARD_FROM_INTERVIEW = r5;
                MeetingSource[] r7 = {r0, r1, r3, r5};
                a = r7;
                b = EnumEntriesKt.enumEntries(r7);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(MeetingSource.class), Syntax.PROTO_2, r0);
            }

            public static MeetingSource[] values() {
                return (MeetingSource[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final MeetingSource fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L15;
                if (r1 == 1) goto L19;
                if (r1 == 2) goto L18;
                if (r1 == 3) goto L17;
                return null;
            L17:
                return CARD_FROM_INTERVIEW;
            L18:
                return CARD_FROM_CALENDAR;
            L19:
                return CARD_FROM_USER;
            L15:
                return CARD_UNKNOWN_SOURCE_TYPE;
            }

            public static MeetingSource valueOf(String r1) {
                return (MeetingSource) r27.a.a(MeetingSource.class, r1);
            }

            public MeetingSource(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\"\b\u0086\u0081\u0002\u0018\u0000 %2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001%B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$¨\u0006&"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$ParticipantType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOW_TYPE", "LARK_USER", "ROOM", "DOC_USER", "NEO_USER", "NEO_GUEST_USER", "PSTN_USER", "SIP_USER", "RESERVED_USER_1", "RESERVED_USER_2", "RESERVED_USER_3", "RESERVED_USER_4", "RESERVED_USER_5", "RESERVED_USER_6", "RESERVED_USER_7", "RESERVED_USER_8", "RESERVED_USER_9", "RESERVED_USER_10", "RESERVED_USER_11", "RESERVED_USER_12", "RESERVED_USER_13", "RESERVED_USER_14", "RESERVED_USER_15", "RESERVED_USER_16", "RESERVED_USER_17", "RESERVED_USER_18", "RESERVED_USER_19", "RESERVED_USER_20", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum ParticipantType extends Enum<ParticipantType> implements o0 {
            public static final ProtoAdapter<ParticipantType> ADAPTER = null;
            public static final b Companion = null;
            public static final ParticipantType DOC_USER = null;
            public static final ParticipantType LARK_USER = null;
            public static final ParticipantType NEO_GUEST_USER = null;
            public static final ParticipantType NEO_USER = null;
            public static final ParticipantType PSTN_USER = null;
            public static final ParticipantType RESERVED_USER_1 = null;
            public static final ParticipantType RESERVED_USER_10 = null;
            public static final ParticipantType RESERVED_USER_11 = null;
            public static final ParticipantType RESERVED_USER_12 = null;
            public static final ParticipantType RESERVED_USER_13 = null;
            public static final ParticipantType RESERVED_USER_14 = null;
            public static final ParticipantType RESERVED_USER_15 = null;
            public static final ParticipantType RESERVED_USER_16 = null;
            public static final ParticipantType RESERVED_USER_17 = null;
            public static final ParticipantType RESERVED_USER_18 = null;
            public static final ParticipantType RESERVED_USER_19 = null;
            public static final ParticipantType RESERVED_USER_2 = null;
            public static final ParticipantType RESERVED_USER_20 = null;
            public static final ParticipantType RESERVED_USER_3 = null;
            public static final ParticipantType RESERVED_USER_4 = null;
            public static final ParticipantType RESERVED_USER_5 = null;
            public static final ParticipantType RESERVED_USER_6 = null;
            public static final ParticipantType RESERVED_USER_7 = null;
            public static final ParticipantType RESERVED_USER_8 = null;
            public static final ParticipantType RESERVED_USER_9 = null;
            public static final ParticipantType ROOM = null;
            public static final ParticipantType SIP_USER = null;
            public static final ParticipantType UNKNOW_TYPE = null;
            public static final /* synthetic */ ParticipantType[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<ParticipantType> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    ParticipantType.Companion.getClass();
                    return b.a(r2);
                }

                public a(KClass<ParticipantType> r1, Syntax r2, ParticipantType r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }

                @JvmStatic
                public static ParticipantType a(int r0) {
                    switch(r0) {
                        case 0: goto L32;
                        case 1: goto L60;
                        case 2: goto L59;
                        case 3: goto L58;
                        case 4: goto L57;
                        case 5: goto L56;
                        case 6: goto L55;
                        case 7: goto L54;
                        case 8: goto L53;
                        case 9: goto L52;
                        case 10: goto L51;
                        case 11: goto L50;
                        case 12: goto L49;
                        case 13: goto L48;
                        case 14: goto L47;
                        case 15: goto L46;
                        case 16: goto L45;
                        case 17: goto L44;
                        case 18: goto L43;
                        case 19: goto L42;
                        case 20: goto L41;
                        case 21: goto L40;
                        case 22: goto L39;
                        case 23: goto L38;
                        case 24: goto L37;
                        case 25: goto L36;
                        case 26: goto L35;
                        case 27: goto L34;
                        default: goto L3;
                    };
                L3:
                    return null;
                L34:
                    return ParticipantType.RESERVED_USER_20;
                L35:
                    return ParticipantType.RESERVED_USER_19;
                L36:
                    return ParticipantType.RESERVED_USER_18;
                L37:
                    return ParticipantType.RESERVED_USER_17;
                L38:
                    return ParticipantType.RESERVED_USER_16;
                L39:
                    return ParticipantType.RESERVED_USER_15;
                L40:
                    return ParticipantType.RESERVED_USER_14;
                L41:
                    return ParticipantType.RESERVED_USER_13;
                L42:
                    return ParticipantType.RESERVED_USER_12;
                L43:
                    return ParticipantType.RESERVED_USER_11;
                L44:
                    return ParticipantType.RESERVED_USER_10;
                L45:
                    return ParticipantType.RESERVED_USER_9;
                L46:
                    return ParticipantType.RESERVED_USER_8;
                L47:
                    return ParticipantType.RESERVED_USER_7;
                L48:
                    return ParticipantType.RESERVED_USER_6;
                L49:
                    return ParticipantType.RESERVED_USER_5;
                L50:
                    return ParticipantType.RESERVED_USER_4;
                L51:
                    return ParticipantType.RESERVED_USER_3;
                L52:
                    return ParticipantType.RESERVED_USER_2;
                L53:
                    return ParticipantType.RESERVED_USER_1;
                L54:
                    return ParticipantType.SIP_USER;
                L55:
                    return ParticipantType.PSTN_USER;
                L56:
                    return ParticipantType.NEO_GUEST_USER;
                L57:
                    return ParticipantType.NEO_USER;
                L58:
                    return ParticipantType.DOC_USER;
                L59:
                    return ParticipantType.ROOM;
                L60:
                    return ParticipantType.LARK_USER;
                L32:
                    return ParticipantType.UNKNOW_TYPE;
                }
            }

            @JvmStatic
            public static final ParticipantType fromValue(int r1) {
                Companion.getClass();
                return b.a(r1);
            }

            public static EnumEntries<ParticipantType> getEntries() {
                return b;
            }

            static {
                ParticipantType r0 = new ParticipantType("UNKNOW_TYPE", 0, 0);
                UNKNOW_TYPE = r0;
                ParticipantType r1 = new ParticipantType("LARK_USER", 1, 1);
                LARK_USER = r1;
                ParticipantType r3 = new ParticipantType("ROOM", 2, 2);
                ROOM = r3;
                ParticipantType r5 = new ParticipantType("DOC_USER", 3, 3);
                DOC_USER = r5;
                ParticipantType r7 = new ParticipantType("NEO_USER", 4, 4);
                NEO_USER = r7;
                ParticipantType r9 = new ParticipantType("NEO_GUEST_USER", 5, 5);
                NEO_GUEST_USER = r9;
                ParticipantType r11 = new ParticipantType("PSTN_USER", 6, 6);
                PSTN_USER = r11;
                ParticipantType r13 = new ParticipantType("SIP_USER", 7, 7);
                SIP_USER = r13;
                ParticipantType r15 = new ParticipantType("RESERVED_USER_1", 8, 8);
                RESERVED_USER_1 = r15;
                ParticipantType r14 = new ParticipantType("RESERVED_USER_2", 9, 9);
                RESERVED_USER_2 = r14;
                ParticipantType r12 = new ParticipantType("RESERVED_USER_3", 10, 10);
                RESERVED_USER_3 = r12;
                ParticipantType r10 = new ParticipantType("RESERVED_USER_4", 11, 11);
                RESERVED_USER_4 = r10;
                ParticipantType r8 = new ParticipantType("RESERVED_USER_5", 12, 12);
                RESERVED_USER_5 = r8;
                ParticipantType r6 = new ParticipantType("RESERVED_USER_6", 13, 13);
                RESERVED_USER_6 = r6;
                ParticipantType r4 = new ParticipantType("RESERVED_USER_7", 14, 14);
                RESERVED_USER_7 = r4;
                ParticipantType r2 = new ParticipantType("RESERVED_USER_8", 15, 15);
                RESERVED_USER_8 = r2;
                ParticipantType r16 = new ParticipantType("RESERVED_USER_9", 16, 16);
                RESERVED_USER_9 = r16;
                ParticipantType r17 = new ParticipantType("RESERVED_USER_10", 17, 17);
                RESERVED_USER_10 = r17;
                ParticipantType r19 = new ParticipantType("RESERVED_USER_11", 18, 18);
                RESERVED_USER_11 = r19;
                ParticipantType r20 = new ParticipantType("RESERVED_USER_12", 19, 19);
                RESERVED_USER_12 = r20;
                ParticipantType r21 = new ParticipantType("RESERVED_USER_13", 20, 20);
                RESERVED_USER_13 = r21;
                ParticipantType r22 = new ParticipantType("RESERVED_USER_14", 21, 21);
                RESERVED_USER_14 = r22;
                ParticipantType r23 = new ParticipantType("RESERVED_USER_15", 22, 22);
                RESERVED_USER_15 = r23;
                ParticipantType r24 = new ParticipantType("RESERVED_USER_16", 23, 23);
                RESERVED_USER_16 = r24;
                ParticipantType r25 = new ParticipantType("RESERVED_USER_17", 24, 24);
                RESERVED_USER_17 = r25;
                ParticipantType r26 = new ParticipantType("RESERVED_USER_18", 25, 25);
                RESERVED_USER_18 = r26;
                ParticipantType r27 = new ParticipantType("RESERVED_USER_19", 26, 26);
                RESERVED_USER_19 = r27;
                ParticipantType r29 = new ParticipantType("RESERVED_USER_20", 27, 27);
                RESERVED_USER_20 = r29;
                ParticipantType[] r30 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r19, r20, r21, r22, r23, r24, r25, r26, r27, r29};
                a = r30;
                b = EnumEntriesKt.enumEntries(r30);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(ParticipantType.class), Syntax.PROTO_2, r0);
            }

            public static ParticipantType[] values() {
                return (ParticipantType[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            public static ParticipantType valueOf(String r1) {
                return (ParticipantType) r27.a.a(ParticipantType.class, r1);
            }

            public ParticipantType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/VideoChatContent$MeetingCard$Status;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "JOINABLE", "FULL", "END", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Status extends Enum<Status> implements o0 {
            public static final ProtoAdapter<Status> ADAPTER = null;
            public static final b Companion = null;
            public static final Status END = null;
            public static final Status FULL = null;
            public static final Status JOINABLE = null;
            public static final Status UNKNOWN = null;
            public static final /* synthetic */ Status[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Status> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Status.Companion.getClass();
                    if (r2 == 0) goto L15;
                    if (r2 == 1) goto L19;
                    if (r2 == 2) goto L18;
                    if (r2 == 3) goto L17;
                    return null;
                L17:
                    return Status.END;
                L18:
                    return Status.FULL;
                L19:
                    return Status.JOINABLE;
                L15:
                    return Status.UNKNOWN;
                }

                public a(KClass<Status> r1, Syntax r2, Status r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Status> getEntries() {
                return b;
            }

            static {
                Status r0 = new Status("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Status r1 = new Status("JOINABLE", 1, 1);
                JOINABLE = r1;
                Status r3 = new Status("FULL", 2, 2);
                FULL = r3;
                Status r5 = new Status("END", 3, 3);
                END = r5;
                Status[] r7 = {r0, r1, r3, r5};
                a = r7;
                b = EnumEntriesKt.enumEntries(r7);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Status.class), Syntax.PROTO_2, r0);
            }

            public static Status[] values() {
                return (Status[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Status fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L15;
                if (r1 == 1) goto L19;
                if (r1 == 2) goto L18;
                if (r1 == 3) goto L17;
                return null;
            L17:
                return END;
            L18:
                return FULL;
            L19:
                return JOINABLE;
            L15:
                return UNKNOWN;
            }

            public static Status valueOf(String r1) {
                return (Status) r27.a.a(Status.class, r1);
            }

            public Status(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<MeetingCard, a> {
            public Integer A;
            public Integer B;
            public String C;
            public String d;
            public Status e;
            public Long f;
            public Long g;
            public String h;
            public String i;
            public String j;
            public String k;
            public List<MeetingParticipant> l;
            public Integer m;
            public ParticipantType n;
            public CardType o;
            public String p;
            public MeetingSource q;
            public String r;
            public Boolean s;
            public VideoChatI18nDefaultTopic t;
            public Boolean u;
            public String v;
            public ParticipantType w;
            public Long x;
            public List<Long> y;
            public Boolean z;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new MeetingCard(this, c(), null);
            }

            public a() {
                this.l = CollectionsKt.emptyList();
                this.y = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<MeetingCard> {
            @Override // com.lark.wire.ProtoAdapter
            public final MeetingCard c(g0 r12) {
                Intrinsics.checkNotNullParameter(r12, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                ArrayList r3 = new ArrayList();
                long r4 = r12.c();
            L3:
                int r6 = r12.e();
                if (r6 == (-1)) goto L48;
                switch(r6) {
                    case 1: goto L47;
                    case 2: goto L52;
                    case 3: goto L42;
                    case 4: goto L41;
                    case 5: goto L40;
                    case 6: goto L39;
                    case 7: goto L38;
                    case 8: goto L37;
                    case 9: goto L36;
                    case 10: goto L35;
                    case 11: goto L58;
                    case 12: goto L50;
                    case 13: goto L26;
                    case 14: goto L54;
                    case 15: goto L21;
                    case 16: goto L20;
                    case 17: goto L6;
                    case 18: goto L6;
                    case 19: goto L19;
                    case 20: goto L18;
                    case 21: goto L17;
                    case 22: goto L56;
                    case 23: goto L12;
                    case 24: goto L11;
                    case 25: goto L10;
                    case 26: goto L6;
                    case 27: goto L6;
                    case 28: goto L6;
                    case 29: goto L6;
                    case 30: goto L9;
                    case 31: goto L8;
                    case 32: goto L7;
                    default: goto L6;
                };
            L50:
                r1.o = CardType.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L29
            L29:
                e = move-exception;
                r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r7 = Unit.INSTANCE;
                goto L3
            L52:
                Status r8 = Status.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L45
                Intrinsics.checkNotNullParameter(r8, "status");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L45
                r1.e = r8;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L45
            L45:
                e = move-exception;
                r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r9 = Unit.INSTANCE;
                goto L3
            L54:
                r1.q = MeetingSource.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
            L24:
                e = move-exception;
                r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r10 = Unit.INSTANCE;
                goto L3
            L56:
                r1.w = ParticipantType.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r11 = Unit.INSTANCE;
                goto L3
            L58:
                r1.n = ParticipantType.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L33
            L33:
                e = move-exception;
                r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r13 = Unit.INSTANCE;
                goto L3
            L7:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r12, "reader");
                r1.C = r12.i();
                goto L3
            L8:
                r1.B = (Integer) ProtoAdapter.h.c(r12);
                goto L3
            L9:
                r1.A = (Integer) ProtoAdapter.h.c(r12);
                goto L3
            L10:
                r1.z = (Boolean) ProtoAdapter.g.c(r12);
                goto L3
            L11:
                r3.add(ProtoAdapter.k.c(r12));
                goto L3
            L12:
                r1.x = (Long) ProtoAdapter.k.c(r12);
                goto L3
            L17:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r12, "reader");
                r1.v = r12.i();
                goto L3
            L18:
                r1.u = (Boolean) ProtoAdapter.g.c(r12);
                goto L3
            L19:
                r1.t = VideoChatI18nDefaultTopic.ADAPTER.c(r12);
                goto L3
            L20:
                r1.s = (Boolean) ProtoAdapter.g.c(r12);
                goto L3
            L21:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r12, "reader");
                r1.r = r12.i();
                goto L3
            L26:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r12, "reader");
                r1.p = r12.i();
                goto L3
            L35:
                r1.m = (Integer) ProtoAdapter.h.c(r12);
                goto L3
            L36:
                r2.add(MeetingParticipant.ADAPTER.c(r12));
                goto L3
            L37:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r12, "reader");
                r1.k = r12.i();
                goto L3
            L38:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r12, "reader");
                r1.j = r12.i();
                goto L3
            L39:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r12, "reader");
                String r14 = r12.i();
                Intrinsics.checkNotNullParameter(r14, "sponsor_id");
                r1.i = r14;
                goto L3
            L40:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r12, "reader");
                String r15 = r12.i();
                Intrinsics.checkNotNullParameter(r15, "topic");
                r1.h = r15;
                goto L3
            L41:
                r1.g = (Long) ProtoAdapter.k.c(r12);
                goto L3
            L42:
                r1.f = Long.valueOf(((Number) ProtoAdapter.k.c(r12)).longValue());
                goto L3
            L47:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r12, "reader");
                String r16 = r12.i();
                Intrinsics.checkNotNullParameter(r16, "meeting_id");
                r1.d = r16;
                goto L3
            L6:
                r12.j(r6);
                Unit r17 = Unit.INSTANCE;
                goto L3
            L48:
                ByteString r19 = r12.d(r4);
                Intrinsics.checkNotNullParameter(r2, "participants");
                com.lark.wire.internal.a.a(r2);
                r1.l = r2;
                Intrinsics.checkNotNullParameter(r3, "all_participant_tenant");
                com.lark.wire.internal.a.a(r3);
                r1.y = r3;
                return new MeetingCard(r1, r19, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(MeetingCard r10) {
                MeetingCard r11 = r10;
                Intrinsics.checkNotNullParameter(r11, "value");
                int r0 = r11.unknownFields().size();
                w r1 = ProtoAdapter.q;
                int r2 = (r0 + r1.l(1, r11.getMeeting_id())) + Status.ADAPTER.l(2, r11.getStatus());
                t r3 = ProtoAdapter.k;
                int r4 = ((((((r2 + r3.l(3, Long.valueOf(r11.getStart_time_ms()))) + r3.l(4, r11.getEnd_time_ms())) + r1.l(5, r11.getTopic())) + r1.l(6, r11.getSponsor_id())) + r1.l(7, r11.getHost_id())) + r1.l(8, r11.getMeet_number())) + MeetingParticipant.ADAPTER.a().l(9, r11.getParticipants());
                s r5 = ProtoAdapter.h;
                int r6 = r4 + r5.l(10, r11.getMax_participant_count());
                ProtoAdapter<ParticipantType> r7 = ParticipantType.ADAPTER;
                int r8 = ((((r6 + r7.l(11, r11.getHost_type())) + CardType.ADAPTER.l(12, r11.getCard_type())) + r1.l(13, r11.getForwarder_id())) + MeetingSource.ADAPTER.l(14, r11.getMeeting_source())) + r1.l(15, r11.getCalendar_uid());
                l r9 = ProtoAdapter.g;
                return ((((((((((r8 + r9.l(16, r11.is_locked())) + VideoChatI18nDefaultTopic.ADAPTER.l(19, r11.getI18n_default_topic())) + r9.l(20, r11.is_open_lobby())) + r1.l(21, r11.getOwner_user_id())) + r7.l(22, r11.getOwner_type())) + r3.l(23, r11.getTotal_participant_num())) + r3.a().l(24, r11.getAll_participant_tenant())) + r9.l(25, r11.is_cross_with_ka())) + r5.l(30, r11.getMeeting_sub_type())) + r5.l(31, r11.getWebinar_attendee_num())) + r1.l(32, r11.getPassword());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r9, MeetingCard r10) {
                MeetingCard r11 = r10;
                Intrinsics.checkNotNullParameter(r9, "writer");
                Intrinsics.checkNotNullParameter(r11, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r9, 1, r11.getMeeting_id());
                Status.ADAPTER.i(r9, 2, r11.getStatus());
                t r1 = ProtoAdapter.k;
                r1.i(r9, 3, Long.valueOf(r11.getStart_time_ms()));
                r1.i(r9, 4, r11.getEnd_time_ms());
                r0.i(r9, 5, r11.getTopic());
                r0.i(r9, 6, r11.getSponsor_id());
                r0.i(r9, 7, r11.getHost_id());
                r0.i(r9, 8, r11.getMeet_number());
                MeetingParticipant.ADAPTER.a().i(r9, 9, r11.getParticipants());
                s r2 = ProtoAdapter.h;
                r2.i(r9, 10, r11.getMax_participant_count());
                ProtoAdapter<ParticipantType> r3 = ParticipantType.ADAPTER;
                r3.i(r9, 11, r11.getHost_type());
                CardType.ADAPTER.i(r9, 12, r11.getCard_type());
                r0.i(r9, 13, r11.getForwarder_id());
                MeetingSource.ADAPTER.i(r9, 14, r11.getMeeting_source());
                r0.i(r9, 15, r11.getCalendar_uid());
                l r4 = ProtoAdapter.g;
                r4.i(r9, 16, r11.is_locked());
                VideoChatI18nDefaultTopic.ADAPTER.i(r9, 19, r11.getI18n_default_topic());
                r4.i(r9, 20, r11.is_open_lobby());
                r0.i(r9, 21, r11.getOwner_user_id());
                r3.i(r9, 22, r11.getOwner_type());
                r1.i(r9, 23, r11.getTotal_participant_num());
                r1.a().i(r9, 24, r11.getAll_participant_tenant());
                r4.i(r9, 25, r11.is_cross_with_ka());
                r2.i(r9, 30, r11.getMeeting_sub_type());
                r2.i(r9, 31, r11.getWebinar_attendee_num());
                r0.i(r9, 32, r11.getPassword());
                r9.a(r11.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r9, MeetingCard r10) {
                MeetingCard r11 = r10;
                Intrinsics.checkNotNullParameter(r9, "writer");
                Intrinsics.checkNotNullParameter(r11, "value");
                r9.d(r11.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r9, 32, r11.getPassword());
                s r1 = ProtoAdapter.h;
                r1.j(r9, 31, r11.getWebinar_attendee_num());
                r1.j(r9, 30, r11.getMeeting_sub_type());
                l r2 = ProtoAdapter.g;
                r2.j(r9, 25, r11.is_cross_with_ka());
                t r3 = ProtoAdapter.k;
                r3.a().j(r9, 24, r11.getAll_participant_tenant());
                r3.j(r9, 23, r11.getTotal_participant_num());
                ProtoAdapter<ParticipantType> r4 = ParticipantType.ADAPTER;
                r4.j(r9, 22, r11.getOwner_type());
                r0.j(r9, 21, r11.getOwner_user_id());
                r2.j(r9, 20, r11.is_open_lobby());
                VideoChatI18nDefaultTopic.ADAPTER.j(r9, 19, r11.getI18n_default_topic());
                r2.j(r9, 16, r11.is_locked());
                r0.j(r9, 15, r11.getCalendar_uid());
                MeetingSource.ADAPTER.j(r9, 14, r11.getMeeting_source());
                r0.j(r9, 13, r11.getForwarder_id());
                CardType.ADAPTER.j(r9, 12, r11.getCard_type());
                r4.j(r9, 11, r11.getHost_type());
                r1.j(r9, 10, r11.getMax_participant_count());
                MeetingParticipant.ADAPTER.a().j(r9, 9, r11.getParticipants());
                r0.j(r9, 8, r11.getMeet_number());
                r0.j(r9, 7, r11.getHost_id());
                r0.j(r9, 6, r11.getSponsor_id());
                r0.j(r9, 5, r11.getTopic());
                r3.j(r9, 4, r11.getEnd_time_ms());
                r3.j(r9, 3, Long.valueOf(r11.getStart_time_ms()));
                Status.ADAPTER.j(r9, 2, r11.getStatus());
                r0.j(r9, 1, r11.getMeeting_id());
            }

            public b(FieldEncoding r7, KClass<MeetingCard> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.VideoChatContent.MeetingCard", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ MeetingCard(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            DEFAULT_HOST_TYPE = ParticipantType.LARK_USER;
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MeetingCard.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.meeting_id;
            r0.e = this.status;
            r0.f = Long.valueOf(this.start_time_ms);
            r0.g = this.end_time_ms;
            r0.h = this.topic;
            r0.i = this.sponsor_id;
            r0.j = this.host_id;
            r0.k = this.meet_number;
            r0.l = this.participants;
            r0.m = this.max_participant_count;
            r0.n = this.host_type;
            r0.o = this.card_type;
            r0.p = this.forwarder_id;
            r0.q = this.meeting_source;
            r0.r = this.calendar_uid;
            r0.s = this.is_locked;
            r0.t = this.i18n_default_topic;
            r0.u = this.is_open_lobby;
            r0.v = this.owner_user_id;
            r0.w = this.owner_type;
            r0.x = this.total_participant_num;
            r0.y = this.all_participant_tenant;
            r0.z = this.is_cross_with_ka;
            r0.A = this.meeting_sub_type;
            r0.B = this.webinar_attendee_num;
            r0.C = this.password;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(MeetingCard.class).getSimpleName() + '@' + hashCode();
        }

        public final List<Long> getAll_participant_tenant() {
            return this.all_participant_tenant;
        }

        public final String getCalendar_uid() {
            return this.calendar_uid;
        }

        public final CardType getCard_type() {
            return this.card_type;
        }

        public final Long getEnd_time_ms() {
            return this.end_time_ms;
        }

        public final String getForwarder_id() {
            return this.forwarder_id;
        }

        public final String getHost_id() {
            return this.host_id;
        }

        public final ParticipantType getHost_type() {
            return this.host_type;
        }

        public final VideoChatI18nDefaultTopic getI18n_default_topic() {
            return this.i18n_default_topic;
        }

        public final Integer getMax_participant_count() {
            return this.max_participant_count;
        }

        public final String getMeet_number() {
            return this.meet_number;
        }

        public final String getMeeting_id() {
            return this.meeting_id;
        }

        public final MeetingSource getMeeting_source() {
            return this.meeting_source;
        }

        public final Integer getMeeting_sub_type() {
            return this.meeting_sub_type;
        }

        public final ParticipantType getOwner_type() {
            return this.owner_type;
        }

        public final String getOwner_user_id() {
            return this.owner_user_id;
        }

        public final List<MeetingParticipant> getParticipants() {
            return this.participants;
        }

        public final String getPassword() {
            return this.password;
        }

        public final String getSponsor_id() {
            return this.sponsor_id;
        }

        public final long getStart_time_ms() {
            return this.start_time_ms;
        }

        public final Status getStatus() {
            return this.status;
        }

        public final String getTopic() {
            return this.topic;
        }

        public final Long getTotal_participant_num() {
            return this.total_participant_num;
        }

        public final Integer getWebinar_attendee_num() {
            return this.webinar_attendee_num;
        }

        public final Boolean is_cross_with_ka() {
            return this.is_cross_with_ka;
        }

        public final Boolean is_locked() {
            return this.is_locked;
        }

        public final Boolean is_open_lobby() {
            return this.is_open_lobby;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public MeetingCard(a r3, ByteString r4) {
            super(ADAPTER, r4);
            String r5 = r3.d;
            Intrinsics.checkNotNull(r5);
            this.meeting_id = r5;
            Status r6 = r3.e;
            Intrinsics.checkNotNull(r6);
            this.status = r6;
            Long r7 = r3.f;
            Intrinsics.checkNotNull(r7);
            this.start_time_ms = r7.longValue();
            this.end_time_ms = r3.g;
            String r8 = r3.h;
            Intrinsics.checkNotNull(r8);
            this.topic = r8;
            String r9 = r3.i;
            Intrinsics.checkNotNull(r9);
            this.sponsor_id = r9;
            this.host_id = r3.j;
            this.meet_number = r3.k;
            this.participants = com.lark.wire.internal.a.c("participants", r3.l);
            this.max_participant_count = r3.m;
            this.host_type = r3.n;
            this.card_type = r3.o;
            this.forwarder_id = r3.p;
            this.meeting_source = r3.q;
            this.calendar_uid = r3.r;
            this.is_locked = r3.s;
            this.i18n_default_topic = r3.t;
            this.is_open_lobby = r3.u;
            this.owner_user_id = r3.v;
            this.owner_type = r3.w;
            this.total_participant_num = r3.x;
            this.all_participant_tenant = com.lark.wire.internal.a.c("all_participant_tenant", r3.y);
            this.is_cross_with_ka = r3.z;
            this.meeting_sub_type = r3.A;
            this.webinar_attendee_num = r3.B;
            this.password = r3.C;
        }

        public /* synthetic */ MeetingCard(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/VideoChatContent$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "MEETING_CARD", "CHAT_ROOM_CARD", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type CHAT_ROOM_CARD = null;
        public static final b Companion = null;
        public static final Type MEETING_CARD = null;
        public static final Type UNKNOWN = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return Type.CHAT_ROOM_CARD;
            L15:
                return Type.MEETING_CARD;
            L12:
                return Type.UNKNOWN;
            }

            public a(KClass<Type> r1, Syntax r2, Type r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("MEETING_CARD", 1, 1);
            MEETING_CARD = r1;
            Type r3 = new Type("CHAT_ROOM_CARD", 2, 2);
            CHAT_ROOM_CARD = r3;
            Type[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
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

        @JvmStatic
        public static final Type fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return CHAT_ROOM_CARD;
        L15:
            return MEETING_CARD;
        L12:
            return UNKNOWN;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<VideoChatContent, a> {
        public Type d;
        public MeetingCard e;
        public Long f;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new VideoChatContent(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<VideoChatContent> {
        @Override // com.lark.wire.ProtoAdapter
        public final VideoChatContent c(g0 r9) {
            Intrinsics.checkNotNullParameter(r9, "reader");
            a r0 = new a();
            long r1 = r9.c();
        L3:
            int r3 = r9.e();
            if (r3 == (-1)) goto L19;
            if (r3 != 1) goto L8;
            Type r4 = Type.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            Intrinsics.checkNotNullParameter(r4, "type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            r0.d = r4;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.e = MeetingCard.ADAPTER.c(r9);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.f = (Long) ProtoAdapter.k.c(r9);
            goto L3
        L11:
            r9.j(r3);
            goto L3
        L19:
            return new VideoChatContent(r0, r9.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(VideoChatContent r5) {
            VideoChatContent r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return ((r6.unknownFields().size() + Type.ADAPTER.l(1, r6.getType())) + MeetingCard.ADAPTER.l(2, r6.getMeeting_card())) + ProtoAdapter.k.l(3, r6.getSequence_id());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, VideoChatContent r5) {
            VideoChatContent r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            Type.ADAPTER.i(r4, 1, r6.getType());
            MeetingCard.ADAPTER.i(r4, 2, r6.getMeeting_card());
            ProtoAdapter.k.i(r4, 3, r6.getSequence_id());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, VideoChatContent r5) {
            VideoChatContent r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.k.j(r4, 3, r6.getSequence_id());
            MeetingCard.ADAPTER.j(r4, 2, r6.getMeeting_card());
            Type.ADAPTER.j(r4, 1, r6.getType());
        }

        public b(FieldEncoding r7, KClass<VideoChatContent> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.VideoChatContent", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ VideoChatContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(VideoChatContent.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.type;
        r0.e = this.meeting_card;
        r0.f = this.sequence_id;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(VideoChatContent.class).getSimpleName() + '@' + hashCode();
    }

    public final MeetingCard getMeeting_card() {
        return this.meeting_card;
    }

    public final Long getSequence_id() {
        return this.sequence_id;
    }

    public final Type getType() {
        return this.type;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public VideoChatContent(a r2, ByteString r3) {
        super(ADAPTER, r3);
        Type r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.type = r4;
        this.meeting_card = r2.e;
        this.sequence_id = r2.f;
    }

    public /* synthetic */ VideoChatContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
