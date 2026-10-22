package com.bytedance.lark.pb.basic.v1;

import com.alibaba.gaiax.model.GXAnimation;
import com.obric.miniapp.alarm.AccountType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class VideoChatContent extends com.squareup.wire.Message<VideoChatContent, Builder> {
    public static final ProtoAdapter<VideoChatContent> ADAPTER = null;
    public static final Long DEFAULT_SEQUENCE_ID = null;
    public static final Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final MeetingCard meeting_card;
    public final Long sequence_id;
    public final Type type;

    public static final class Builder extends com.squareup.wire.Message.Builder<VideoChatContent, Builder> {
        public MeetingCard meeting_card;
        public Long sequence_id;
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public VideoChatContent build() {
            Type r100 = this.type;
            if (r100 == null) goto L7;
            return new VideoChatContent(this.type, this.meeting_card, this.sequence_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder meeting_card(MeetingCard r100) {
            this.meeting_card = r100;
            return this;
        }

        public Builder sequence_id(Long r100) {
            this.sequence_id = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class MeetingCard extends com.squareup.wire.Message<MeetingCard, Builder> {
        public static final ProtoAdapter<MeetingCard> ADAPTER = null;
        public static final String DEFAULT_CALENDAR_UID = "";
        public static final CardType DEFAULT_CARD_TYPE = null;
        public static final Long DEFAULT_END_TIME_MS = null;
        public static final String DEFAULT_FORWARDER_ID = "";
        public static final String DEFAULT_HOST_ID = "";
        public static final ParticipantType DEFAULT_HOST_TYPE = null;
        public static final Boolean DEFAULT_IS_CROSS_WITH_KA = null;
        public static final Boolean DEFAULT_IS_LOCKED = null;
        public static final Boolean DEFAULT_IS_OPEN_LOBBY = null;
        public static final Integer DEFAULT_MAX_PARTICIPANT_COUNT = null;
        public static final String DEFAULT_MEETING_ID = "";
        public static final MeetingSource DEFAULT_MEETING_SOURCE = null;
        public static final Integer DEFAULT_MEETING_SUB_TYPE = null;
        public static final String DEFAULT_MEET_NUMBER = "";
        public static final ParticipantType DEFAULT_OWNER_TYPE = null;
        public static final String DEFAULT_OWNER_USER_ID = "";
        public static final String DEFAULT_PASSWORD = "";
        public static final String DEFAULT_SPONSOR_ID = "";
        public static final Long DEFAULT_START_TIME_MS = null;
        public static final Status DEFAULT_STATUS = null;
        public static final String DEFAULT_TOPIC = "";
        public static final Long DEFAULT_TOTAL_PARTICIPANT_NUM = null;
        public static final Integer DEFAULT_WEBINAR_ATTENDEE_NUM = null;
        private static final long serialVersionUID = 0;
        public final List<Long> all_participant_tenant;
        public final String calendar_uid;
        public final CardType card_type;
        public final Long end_time_ms;
        public final String forwarder_id;
        public final String host_id;
        public final ParticipantType host_type;
        public final VideoChatI18nDefaultTopic i18n_default_topic;
        public final Boolean is_cross_with_ka;
        public final Boolean is_locked;
        public final Boolean is_open_lobby;
        public final Integer max_participant_count;
        public final String meet_number;
        public final String meeting_id;
        public final MeetingSource meeting_source;
        public final Integer meeting_sub_type;
        public final ParticipantType owner_type;
        public final String owner_user_id;
        public final List<MeetingParticipant> participants;
        public final String password;
        public final String sponsor_id;
        public final Long start_time_ms;
        public final Status status;
        public final String topic;
        public final Long total_participant_num;
        public final Integer webinar_attendee_num;

        public static final class Builder extends com.squareup.wire.Message.Builder<MeetingCard, Builder> {
            public List<Long> all_participant_tenant;
            public String calendar_uid;
            public CardType card_type;
            public Long end_time_ms;
            public String forwarder_id;
            public String host_id;
            public ParticipantType host_type;
            public VideoChatI18nDefaultTopic i18n_default_topic;
            public Boolean is_cross_with_ka;
            public Boolean is_locked;
            public Boolean is_open_lobby;
            public Integer max_participant_count;
            public String meet_number;
            public String meeting_id;
            public MeetingSource meeting_source;
            public Integer meeting_sub_type;
            public ParticipantType owner_type;
            public String owner_user_id;
            public List<MeetingParticipant> participants;
            public String password;
            public String sponsor_id;
            public Long start_time_ms;
            public Status status;
            public String topic;
            public Long total_participant_num;
            public Integer webinar_attendee_num;

            @Override // com.squareup.wire.Message.Builder
            public MeetingCard build() {
                String r100 = this.meeting_id;
                if (r100 == null) goto L15;
                if (this.status == null) goto L15;
                if (this.start_time_ms == null) goto L15;
                if (this.topic == null) goto L15;
                if (this.sponsor_id == null) goto L15;
                return new MeetingCard(this.meeting_id, this.status, this.start_time_ms, this.end_time_ms, this.topic, this.sponsor_id, this.host_id, this.meet_number, this.participants, this.max_participant_count, this.host_type, this.card_type, this.forwarder_id, this.meeting_source, this.calendar_uid, this.is_locked, this.i18n_default_topic, this.is_open_lobby, this.owner_user_id, this.owner_type, this.total_participant_num, this.all_participant_tenant, this.is_cross_with_ka, this.meeting_sub_type, this.webinar_attendee_num, this.password, super.buildUnknownFields());
            L15:
                throw Internal.missingRequiredFields(new Object[]{r100, "meeting_id", this.status, "status", this.start_time_ms, "start_time_ms", this.topic, "topic", this.sponsor_id, "sponsor_id"});
            }

            public Builder() {
                this.participants = Internal.newMutableList();
                this.all_participant_tenant = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder all_participant_tenant(List<Long> r100) {
                Internal.checkElementsNotNull(r100);
                this.all_participant_tenant = r100;
                return this;
            }

            public Builder calendar_uid(String r100) {
                this.calendar_uid = r100;
                return this;
            }

            public Builder card_type(CardType r100) {
                this.card_type = r100;
                return this;
            }

            public Builder end_time_ms(Long r100) {
                this.end_time_ms = r100;
                return this;
            }

            public Builder forwarder_id(String r100) {
                this.forwarder_id = r100;
                return this;
            }

            public Builder host_id(String r100) {
                this.host_id = r100;
                return this;
            }

            public Builder host_type(ParticipantType r100) {
                this.host_type = r100;
                return this;
            }

            public Builder i18n_default_topic(VideoChatI18nDefaultTopic r100) {
                this.i18n_default_topic = r100;
                return this;
            }

            public Builder is_cross_with_ka(Boolean r100) {
                this.is_cross_with_ka = r100;
                return this;
            }

            public Builder is_locked(Boolean r100) {
                this.is_locked = r100;
                return this;
            }

            public Builder is_open_lobby(Boolean r100) {
                this.is_open_lobby = r100;
                return this;
            }

            public Builder max_participant_count(Integer r100) {
                this.max_participant_count = r100;
                return this;
            }

            public Builder meet_number(String r100) {
                this.meet_number = r100;
                return this;
            }

            public Builder meeting_id(String r100) {
                this.meeting_id = r100;
                return this;
            }

            public Builder meeting_source(MeetingSource r100) {
                this.meeting_source = r100;
                return this;
            }

            public Builder meeting_sub_type(Integer r100) {
                this.meeting_sub_type = r100;
                return this;
            }

            public Builder owner_type(ParticipantType r100) {
                this.owner_type = r100;
                return this;
            }

            public Builder owner_user_id(String r100) {
                this.owner_user_id = r100;
                return this;
            }

            public Builder participants(List<MeetingParticipant> r100) {
                Internal.checkElementsNotNull(r100);
                this.participants = r100;
                return this;
            }

            public Builder password(String r100) {
                this.password = r100;
                return this;
            }

            public Builder sponsor_id(String r100) {
                this.sponsor_id = r100;
                return this;
            }

            public Builder start_time_ms(Long r100) {
                this.start_time_ms = r100;
                return this;
            }

            public Builder status(Status r100) {
                this.status = r100;
                return this;
            }

            public Builder topic(String r100) {
                this.topic = r100;
                return this;
            }

            public Builder total_participant_num(Long r100) {
                this.total_participant_num = r100;
                return this;
            }

            public Builder webinar_attendee_num(Integer r100) {
                this.webinar_attendee_num = r100;
                return this;
            }
        }

        public static final enum CardType extends Enum<CardType> implements WireEnum {
            private static final /* synthetic */ CardType[] $VALUES = null;
            public static final ProtoAdapter<CardType> ADAPTER = null;
            public static final CardType FORWARD = null;
            public static final CardType SPONSOR = null;
            public static final CardType UNKNOWN_CARD_TYPE = null;
            private final int value;

            static {
                CardType r100 = new CardType("UNKNOWN_CARD_TYPE", 0, 0);
                UNKNOWN_CARD_TYPE = r100;
                CardType r101 = new CardType("SPONSOR", 1, 1);
                SPONSOR = r101;
                CardType r102 = new CardType("FORWARD", 2, 2);
                FORWARD = r102;
                $VALUES = new CardType[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(CardType.class);
            }

            public static CardType[] values() {
                return (CardType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static CardType fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return FORWARD;
            L12:
                return SPONSOR;
            L14:
                return UNKNOWN_CARD_TYPE;
            }

            public static CardType valueOf(String r100) {
                return (CardType) a.a(CardType.class, r100);
            }

            private CardType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class MeetingParticipant extends com.squareup.wire.Message<MeetingParticipant, Builder> {
            public static final ProtoAdapter<MeetingParticipant> ADAPTER = null;
            public static final String DEFAULT_BIND_ID = "";
            public static final BindType DEFAULT_BIND_TYPE = null;
            public static final String DEFAULT_DEVICE_ID = "";
            public static final DeviceType DEFAULT_DEVICE_TYPE = null;
            public static final Boolean DEFAULT_IS_LARK_GUEST = null;
            public static final Long DEFAULT_JOIN_TIME_MS = null;
            public static final Status DEFAULT_STATUS = null;
            public static final String DEFAULT_TENANT_ID = "";
            public static final TenantTag DEFAULT_TENANT_TAG = null;
            public static final Boolean DEFAULT_USED_CALL_ME = null;
            public static final String DEFAULT_USER_ID = "";
            public static final ParticipantType DEFAULT_USER_TYPE = null;
            private static final long serialVersionUID = 0;
            public final String bind_id;
            public final BindType bind_type;
            public final String device_id;
            public final DeviceType device_type;
            public final Boolean is_lark_guest;
            public final Long join_time_ms;
            public final Status status;
            public final String tenant_id;
            public final TenantTag tenant_tag;
            public final Boolean used_call_me;
            public final String user_id;
            public final ParticipantType user_type;

            public static final enum BindType extends Enum<BindType> implements WireEnum {
                private static final /* synthetic */ BindType[] $VALUES = null;
                public static final ProtoAdapter<BindType> ADAPTER = null;
                public static final BindType LARK = null;
                public static final BindType UNKOWN = null;
                private final int value;

                static {
                    BindType r100 = new BindType("UNKOWN", 0, 0);
                    UNKOWN = r100;
                    BindType r101 = new BindType(AccountType.LARK, 1, 1);
                    LARK = r101;
                    $VALUES = new BindType[]{r100, r101};
                    ADAPTER = ProtoAdapter.newEnumAdapter(BindType.class);
                }

                public static BindType[] values() {
                    return (BindType[]) $VALUES.clone();
                }

                @Override // com.squareup.wire.WireEnum
                public final int getValue() {
                    return this.value;
                }

                public static BindType fromValue(int r100) {
                    if (r100 == 0) goto L10;
                    if (r100 == 1) goto L8;
                    return null;
                L8:
                    return LARK;
                L10:
                    return UNKOWN;
                }

                public static BindType valueOf(String r100) {
                    return (BindType) a.a(BindType.class, r100);
                }

                private BindType(String r100, int r101, int r102) {
                    super(r100, r101);
                    this.value = r102;
                }
            }

            public static final class Builder extends com.squareup.wire.Message.Builder<MeetingParticipant, Builder> {
                public String bind_id;
                public BindType bind_type;
                public String device_id;
                public DeviceType device_type;
                public Boolean is_lark_guest;
                public Long join_time_ms;
                public Status status;
                public String tenant_id;
                public TenantTag tenant_tag;
                public Boolean used_call_me;
                public String user_id;
                public ParticipantType user_type;

                @Override // com.squareup.wire.Message.Builder
                public MeetingParticipant build() {
                    String r100 = this.user_id;
                    if (r100 == null) goto L7;
                    return new MeetingParticipant(this.user_id, this.join_time_ms, this.status, this.device_id, this.user_type, this.is_lark_guest, this.device_type, this.tenant_id, this.tenant_tag, this.bind_id, this.bind_type, this.used_call_me, super.buildUnknownFields());
                L7:
                    throw Internal.missingRequiredFields(new Object[]{r100, "user_id"});
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder bind_id(String r100) {
                    this.bind_id = r100;
                    return this;
                }

                public Builder bind_type(BindType r100) {
                    this.bind_type = r100;
                    return this;
                }

                public Builder device_id(String r100) {
                    this.device_id = r100;
                    return this;
                }

                public Builder device_type(DeviceType r100) {
                    this.device_type = r100;
                    return this;
                }

                public Builder is_lark_guest(Boolean r100) {
                    this.is_lark_guest = r100;
                    return this;
                }

                public Builder join_time_ms(Long r100) {
                    this.join_time_ms = r100;
                    return this;
                }

                public Builder status(Status r100) {
                    this.status = r100;
                    return this;
                }

                public Builder tenant_id(String r100) {
                    this.tenant_id = r100;
                    return this;
                }

                public Builder tenant_tag(TenantTag r100) {
                    this.tenant_tag = r100;
                    return this;
                }

                public Builder used_call_me(Boolean r100) {
                    this.used_call_me = r100;
                    return this;
                }

                public Builder user_id(String r100) {
                    this.user_id = r100;
                    return this;
                }

                public Builder user_type(ParticipantType r100) {
                    this.user_type = r100;
                    return this;
                }
            }

            public static final enum DeviceType extends Enum<DeviceType> implements WireEnum {
                private static final /* synthetic */ DeviceType[] $VALUES = null;
                public static final ProtoAdapter<DeviceType> ADAPTER = null;
                public static final DeviceType DESKTOP = null;
                public static final DeviceType MOBILE = null;
                public static final DeviceType UNKNOWN_DEVICE_TYPE = null;
                public static final DeviceType WEB = null;
                private final int value;

                static {
                    DeviceType r100 = new DeviceType("UNKNOWN_DEVICE_TYPE", 0, 0);
                    UNKNOWN_DEVICE_TYPE = r100;
                    DeviceType r101 = new DeviceType("DESKTOP", 1, 1);
                    DESKTOP = r101;
                    DeviceType r102 = new DeviceType("MOBILE", 2, 2);
                    MOBILE = r102;
                    DeviceType r103 = new DeviceType("WEB", 3, 3);
                    WEB = r103;
                    $VALUES = new DeviceType[]{r100, r101, r102, r103};
                    ADAPTER = ProtoAdapter.newEnumAdapter(DeviceType.class);
                }

                public static DeviceType[] values() {
                    return (DeviceType[]) $VALUES.clone();
                }

                @Override // com.squareup.wire.WireEnum
                public final int getValue() {
                    return this.value;
                }

                public static DeviceType fromValue(int r100) {
                    if (r100 == 0) goto L18;
                    if (r100 == 1) goto L16;
                    if (r100 == 2) goto L14;
                    if (r100 == 3) goto L12;
                    return null;
                L12:
                    return WEB;
                L14:
                    return MOBILE;
                L16:
                    return DESKTOP;
                L18:
                    return UNKNOWN_DEVICE_TYPE;
                }

                public static DeviceType valueOf(String r100) {
                    return (DeviceType) a.a(DeviceType.class, r100);
                }

                private DeviceType(String r100, int r101, int r102) {
                    super(r100, r101);
                    this.value = r102;
                }
            }

            public static final class ProtoAdapter_MeetingParticipant extends ProtoAdapter<MeetingParticipant> {
                public ProtoAdapter_MeetingParticipant() {
                    super(FieldEncoding.LENGTH_DELIMITED, MeetingParticipant.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public MeetingParticipant decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.user_id = "";
                    r101.join_time_ms = 0L;
                    r101.status = Status.UNKNOWN;
                    r101.device_id = "";
                    r101.user_type = ParticipantType.LARK_USER;
                    Boolean r102 = Boolean.FALSE;
                    r101.is_lark_guest = r102;
                    r101.device_type = DeviceType.UNKNOWN_DEVICE_TYPE;
                    r101.tenant_id = "";
                    r101.tenant_tag = TenantTag.STANDARD;
                    r101.bind_id = "";
                    r101.bind_type = BindType.UNKOWN;
                    r101.used_call_me = r102;
                    long r103 = r100.beginMessage();
                L3:
                    int r104 = r100.nextTag();
                    if (r104 == (-1)) goto L34;
                    switch(r104) {
                        case 1: goto L33;
                        case 2: goto L32;
                        case 3: goto L42;
                        case 4: goto L27;
                        case 5: goto L40;
                        case 6: goto L22;
                        case 7: goto L36;
                        case 8: goto L17;
                        case 9: goto L44;
                        case 10: goto L12;
                        case 11: goto L38;
                        case 12: goto L7;
                        default: goto L6;
                    };
                L36:
                    r101.device_type = DeviceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
                L20:
                    e = move-exception;
                    r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L38:
                    r101.bind_type = BindType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
                L10:
                    e = move-exception;
                    r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L40:
                    r101.user_type = ParticipantType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
                L25:
                    e = move-exception;
                    r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L42:
                    r101.status = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L30
                L30:
                    e = move-exception;
                    r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L44:
                    r101.tenant_tag = TenantTag.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
                L15:
                    e = move-exception;
                    r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L7:
                    r101.used_call_me = ProtoAdapter.BOOL.decode(r100);
                    goto L3
                L12:
                    r101.bind_id = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L17:
                    r101.tenant_id = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L22:
                    r101.is_lark_guest = ProtoAdapter.BOOL.decode(r100);
                    goto L3
                L27:
                    r101.device_id = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L32:
                    r101.join_time_ms = ProtoAdapter.INT64.decode(r100);
                    goto L3
                L33:
                    r101.user_id = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L6:
                    FieldEncoding r105 = r100.peekFieldEncoding();
                    r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                    goto L3
                L34:
                    r100.endMessage(r103);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(MeetingParticipant r100) {
                    ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                    int r102 = r101.encodedSizeWithTag(1, r100.user_id);
                    Long r103 = r100.join_time_ms;
                    int r104 = 0;
                    if (r103 == null) goto L5;
                    int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r103);
                L6:
                    int r106 = r102 + r105;
                    Status r107 = r100.status;
                    if (r107 == null) goto L9;
                    int r108 = Status.ADAPTER.encodedSizeWithTag(3, r107);
                L10:
                    int r109 = r106 + r108;
                    String r110 = r100.device_id;
                    if (r110 == null) goto L13;
                    int r111 = r101.encodedSizeWithTag(4, r110);
                L14:
                    int r112 = r109 + r111;
                    ParticipantType r113 = r100.user_type;
                    if (r113 == null) goto L17;
                    int r114 = ParticipantType.ADAPTER.encodedSizeWithTag(5, r113);
                L18:
                    int r115 = r112 + r114;
                    Boolean r116 = r100.is_lark_guest;
                    if (r116 == null) goto L21;
                    int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
                L22:
                    int r118 = r115 + r117;
                    DeviceType r119 = r100.device_type;
                    if (r119 == null) goto L25;
                    int r120 = DeviceType.ADAPTER.encodedSizeWithTag(7, r119);
                L26:
                    int r121 = r118 + r120;
                    String r122 = r100.tenant_id;
                    if (r122 == null) goto L29;
                    int r123 = r101.encodedSizeWithTag(8, r122);
                L30:
                    int r124 = r121 + r123;
                    TenantTag r125 = r100.tenant_tag;
                    if (r125 == null) goto L33;
                    int r126 = TenantTag.ADAPTER.encodedSizeWithTag(9, r125);
                L34:
                    int r127 = r124 + r126;
                    String r128 = r100.bind_id;
                    if (r128 == null) goto L37;
                    int r129 = r101.encodedSizeWithTag(10, r128);
                L38:
                    int r130 = r127 + r129;
                    BindType r131 = r100.bind_type;
                    if (r131 == null) goto L41;
                    int r132 = BindType.ADAPTER.encodedSizeWithTag(11, r131);
                L42:
                    int r133 = r130 + r132;
                    Boolean r134 = r100.used_call_me;
                    if (r134 == null) goto L46;
                    r104 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r134);
                L46:
                    return (r133 + r104) + r100.unknownFields().size();
                L41:
                    r132 = 0;
                    goto L42
                L37:
                    r129 = 0;
                    goto L38
                L33:
                    r126 = 0;
                    goto L34
                L29:
                    r123 = 0;
                    goto L30
                L25:
                    r120 = 0;
                    goto L26
                L21:
                    r117 = 0;
                    goto L22
                L17:
                    r114 = 0;
                    goto L18
                L13:
                    r111 = 0;
                    goto L14
                L9:
                    r108 = 0;
                    goto L10
                L5:
                    r105 = 0;
                    goto L6
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ MeetingParticipant decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(MeetingParticipant r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, MeetingParticipant r101) throws IOException {
                    ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                    r102.encodeWithTag(r100, 1, r101.user_id);
                    Long r103 = r101.join_time_ms;
                    if (r103 == null) goto L5;
                    ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
                L5:
                    Status r104 = r101.status;
                    if (r104 == null) goto L8;
                    Status.ADAPTER.encodeWithTag(r100, 3, r104);
                L8:
                    String r105 = r101.device_id;
                    if (r105 == null) goto L11;
                    r102.encodeWithTag(r100, 4, r105);
                L11:
                    ParticipantType r106 = r101.user_type;
                    if (r106 == null) goto L14;
                    ParticipantType.ADAPTER.encodeWithTag(r100, 5, r106);
                L14:
                    Boolean r107 = r101.is_lark_guest;
                    if (r107 == null) goto L17;
                    ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
                L17:
                    DeviceType r108 = r101.device_type;
                    if (r108 == null) goto L20;
                    DeviceType.ADAPTER.encodeWithTag(r100, 7, r108);
                L20:
                    String r109 = r101.tenant_id;
                    if (r109 == null) goto L23;
                    r102.encodeWithTag(r100, 8, r109);
                L23:
                    TenantTag r110 = r101.tenant_tag;
                    if (r110 == null) goto L26;
                    TenantTag.ADAPTER.encodeWithTag(r100, 9, r110);
                L26:
                    String r111 = r101.bind_id;
                    if (r111 == null) goto L29;
                    r102.encodeWithTag(r100, 10, r111);
                L29:
                    BindType r112 = r101.bind_type;
                    if (r112 == null) goto L32;
                    BindType.ADAPTER.encodeWithTag(r100, 11, r112);
                L32:
                    Boolean r113 = r101.used_call_me;
                    if (r113 == null) goto L35;
                    ProtoAdapter.BOOL.encodeWithTag(r100, 12, r113);
                L35:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MeetingParticipant r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            public static final enum Status extends Enum<Status> implements WireEnum {
                private static final /* synthetic */ Status[] $VALUES = null;
                public static final ProtoAdapter<Status> ADAPTER = null;
                public static final Status CALLING = null;
                public static final Status IDLE = null;
                public static final Status ON_THE_CALL = null;
                public static final Status RINGING = null;
                public static final Status UNKNOWN = null;
                private final int value;

                static {
                    Status r100 = new Status("UNKNOWN", 0, 0);
                    UNKNOWN = r100;
                    Status r101 = new Status("CALLING", 1, 1);
                    CALLING = r101;
                    Status r102 = new Status("ON_THE_CALL", 2, 2);
                    ON_THE_CALL = r102;
                    Status r103 = new Status("RINGING", 3, 3);
                    RINGING = r103;
                    Status r104 = new Status("IDLE", 4, 4);
                    IDLE = r104;
                    $VALUES = new Status[]{r100, r101, r102, r103, r104};
                    ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
                }

                public static Status[] values() {
                    return (Status[]) $VALUES.clone();
                }

                @Override // com.squareup.wire.WireEnum
                public final int getValue() {
                    return this.value;
                }

                public static Status fromValue(int r100) {
                    if (r100 == 0) goto L22;
                    if (r100 == 1) goto L20;
                    if (r100 == 2) goto L18;
                    if (r100 == 3) goto L16;
                    if (r100 == 4) goto L14;
                    return null;
                L14:
                    return IDLE;
                L16:
                    return RINGING;
                L18:
                    return ON_THE_CALL;
                L20:
                    return CALLING;
                L22:
                    return UNKNOWN;
                }

                public static Status valueOf(String r100) {
                    return (Status) a.a(Status.class, r100);
                }

                private Status(String r100, int r101, int r102) {
                    super(r100, r101);
                    this.value = r102;
                }
            }

            public static final enum TenantTag extends Enum<TenantTag> implements WireEnum {
                private static final /* synthetic */ TenantTag[] $VALUES = null;
                public static final ProtoAdapter<TenantTag> ADAPTER = null;
                public static final TenantTag SIMPLE = null;
                public static final TenantTag STANDARD = null;
                public static final TenantTag UNDEFINED = null;
                private final int value;

                static {
                    TenantTag r100 = new TenantTag("STANDARD", 0, 0);
                    STANDARD = r100;
                    TenantTag r101 = new TenantTag("UNDEFINED", 1, 1);
                    UNDEFINED = r101;
                    TenantTag r102 = new TenantTag("SIMPLE", 2, 2);
                    SIMPLE = r102;
                    $VALUES = new TenantTag[]{r100, r101, r102};
                    ADAPTER = ProtoAdapter.newEnumAdapter(TenantTag.class);
                }

                public static TenantTag[] values() {
                    return (TenantTag[]) $VALUES.clone();
                }

                @Override // com.squareup.wire.WireEnum
                public final int getValue() {
                    return this.value;
                }

                public static TenantTag fromValue(int r100) {
                    if (r100 == 0) goto L14;
                    if (r100 == 1) goto L12;
                    if (r100 == 2) goto L10;
                    return null;
                L10:
                    return SIMPLE;
                L12:
                    return UNDEFINED;
                L14:
                    return STANDARD;
                }

                public static TenantTag valueOf(String r100) {
                    return (TenantTag) a.a(TenantTag.class, r100);
                }

                private TenantTag(String r100, int r101, int r102) {
                    super(r100, r101);
                    this.value = r102;
                }
            }

            static {
                ADAPTER = new ProtoAdapter_MeetingParticipant();
                DEFAULT_JOIN_TIME_MS = 0L;
                DEFAULT_STATUS = Status.UNKNOWN;
                DEFAULT_USER_TYPE = ParticipantType.LARK_USER;
                Boolean r100 = Boolean.FALSE;
                DEFAULT_IS_LARK_GUEST = r100;
                DEFAULT_DEVICE_TYPE = DeviceType.UNKNOWN_DEVICE_TYPE;
                DEFAULT_TENANT_TAG = TenantTag.STANDARD;
                DEFAULT_BIND_TYPE = BindType.UNKOWN;
                DEFAULT_USED_CALL_ME = r100;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.user_id = this.user_id;
                r100.join_time_ms = this.join_time_ms;
                r100.status = this.status;
                r100.device_id = this.device_id;
                r100.user_type = this.user_type;
                r100.is_lark_guest = this.is_lark_guest;
                r100.device_type = this.device_type;
                r100.tenant_id = this.tenant_id;
                r100.tenant_tag = this.tenant_tag;
                r100.bind_id = this.bind_id;
                r100.bind_type = this.bind_type;
                r100.used_call_me = this.used_call_me;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return MeetingParticipant.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public MeetingParticipant(String r110, Long r111, Status r112, String r113, ParticipantType r114, Boolean r210, DeviceType r211, String r212, TenantTag r213, String r214, BindType r215, Boolean r216) {
                this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, ByteString.EMPTY);
            }

            public MeetingParticipant(String r100, Long r101, Status r102, String r103, ParticipantType r104, Boolean r105, DeviceType r106, String r107, TenantTag r110, String r111, BindType r112, Boolean r113, ByteString r114) {
                super(ADAPTER, r114);
                this.user_id = r100;
                this.join_time_ms = r101;
                this.status = r102;
                this.device_id = r103;
                this.user_type = r104;
                this.is_lark_guest = r105;
                this.device_type = r106;
                this.tenant_id = r107;
                this.tenant_tag = r110;
                this.bind_id = r111;
                this.bind_type = r112;
                this.used_call_me = r113;
            }
        }

        public static final enum MeetingSource extends Enum<MeetingSource> implements WireEnum {
            private static final /* synthetic */ MeetingSource[] $VALUES = null;
            public static final ProtoAdapter<MeetingSource> ADAPTER = null;
            public static final MeetingSource CARD_FROM_CALENDAR = null;
            public static final MeetingSource CARD_FROM_INTERVIEW = null;
            public static final MeetingSource CARD_FROM_USER = null;
            public static final MeetingSource CARD_UNKNOWN_SOURCE_TYPE = null;
            private final int value;

            static {
                MeetingSource r100 = new MeetingSource("CARD_UNKNOWN_SOURCE_TYPE", 0, 0);
                CARD_UNKNOWN_SOURCE_TYPE = r100;
                MeetingSource r101 = new MeetingSource("CARD_FROM_USER", 1, 1);
                CARD_FROM_USER = r101;
                MeetingSource r102 = new MeetingSource("CARD_FROM_CALENDAR", 2, 2);
                CARD_FROM_CALENDAR = r102;
                MeetingSource r103 = new MeetingSource("CARD_FROM_INTERVIEW", 3, 3);
                CARD_FROM_INTERVIEW = r103;
                $VALUES = new MeetingSource[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(MeetingSource.class);
            }

            public static MeetingSource[] values() {
                return (MeetingSource[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static MeetingSource fromValue(int r100) {
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 3) goto L12;
                return null;
            L12:
                return CARD_FROM_INTERVIEW;
            L14:
                return CARD_FROM_CALENDAR;
            L16:
                return CARD_FROM_USER;
            L18:
                return CARD_UNKNOWN_SOURCE_TYPE;
            }

            public static MeetingSource valueOf(String r100) {
                return (MeetingSource) a.a(MeetingSource.class, r100);
            }

            private MeetingSource(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final enum ParticipantType extends Enum<ParticipantType> implements WireEnum {
            private static final /* synthetic */ ParticipantType[] $VALUES = null;
            public static final ProtoAdapter<ParticipantType> ADAPTER = null;
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
            private final int value;

            static {
                ParticipantType r100 = new ParticipantType("UNKNOW_TYPE", 0, 0);
                UNKNOW_TYPE = r100;
                ParticipantType r101 = new ParticipantType("LARK_USER", 1, 1);
                LARK_USER = r101;
                ParticipantType r102 = new ParticipantType("ROOM", 2, 2);
                ROOM = r102;
                ParticipantType r103 = new ParticipantType("DOC_USER", 3, 3);
                DOC_USER = r103;
                ParticipantType r104 = new ParticipantType("NEO_USER", 4, 4);
                NEO_USER = r104;
                ParticipantType r105 = new ParticipantType("NEO_GUEST_USER", 5, 5);
                NEO_GUEST_USER = r105;
                ParticipantType r110 = new ParticipantType("PSTN_USER", 6, 6);
                PSTN_USER = r110;
                ParticipantType r111 = new ParticipantType("SIP_USER", 7, 7);
                SIP_USER = r111;
                ParticipantType r112 = new ParticipantType("RESERVED_USER_1", 8, 8);
                RESERVED_USER_1 = r112;
                ParticipantType r113 = new ParticipantType("RESERVED_USER_2", 9, 9);
                RESERVED_USER_2 = r113;
                ParticipantType r114 = new ParticipantType("RESERVED_USER_3", 10, 10);
                RESERVED_USER_3 = r114;
                ParticipantType r115 = new ParticipantType("RESERVED_USER_4", 11, 11);
                RESERVED_USER_4 = r115;
                ParticipantType r106 = new ParticipantType("RESERVED_USER_5", 12, 12);
                RESERVED_USER_5 = r106;
                ParticipantType r107 = new ParticipantType("RESERVED_USER_6", 13, 13);
                RESERVED_USER_6 = r107;
                ParticipantType r108 = new ParticipantType("RESERVED_USER_7", 14, 14);
                RESERVED_USER_7 = r108;
                ParticipantType r109 = new ParticipantType("RESERVED_USER_8", 15, 15);
                RESERVED_USER_8 = r109;
                ParticipantType r116 = new ParticipantType("RESERVED_USER_9", 16, 16);
                RESERVED_USER_9 = r116;
                ParticipantType r117 = new ParticipantType("RESERVED_USER_10", 17, 17);
                RESERVED_USER_10 = r117;
                ParticipantType r118 = new ParticipantType("RESERVED_USER_11", 18, 18);
                RESERVED_USER_11 = r118;
                ParticipantType r119 = new ParticipantType("RESERVED_USER_12", 19, 19);
                RESERVED_USER_12 = r119;
                ParticipantType r120 = new ParticipantType("RESERVED_USER_13", 20, 20);
                RESERVED_USER_13 = r120;
                ParticipantType r121 = new ParticipantType("RESERVED_USER_14", 21, 21);
                RESERVED_USER_14 = r121;
                ParticipantType r122 = new ParticipantType("RESERVED_USER_15", 22, 22);
                RESERVED_USER_15 = r122;
                ParticipantType r123 = new ParticipantType("RESERVED_USER_16", 23, 23);
                RESERVED_USER_16 = r123;
                ParticipantType r124 = new ParticipantType("RESERVED_USER_17", 24, 24);
                RESERVED_USER_17 = r124;
                ParticipantType r125 = new ParticipantType("RESERVED_USER_18", 25, 25);
                RESERVED_USER_18 = r125;
                ParticipantType r126 = new ParticipantType("RESERVED_USER_19", 26, 26);
                RESERVED_USER_19 = r126;
                ParticipantType r127 = new ParticipantType("RESERVED_USER_20", 27, 27);
                RESERVED_USER_20 = r127;
                $VALUES = new ParticipantType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127};
                ADAPTER = ProtoAdapter.newEnumAdapter(ParticipantType.class);
            }

            public static ParticipantType[] values() {
                return (ParticipantType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static ParticipantType fromValue(int r100) {
                switch(r100) {
                    case 0: goto L60;
                    case 1: goto L58;
                    case 2: goto L56;
                    case 3: goto L54;
                    case 4: goto L52;
                    case 5: goto L50;
                    case 6: goto L48;
                    case 7: goto L46;
                    case 8: goto L44;
                    case 9: goto L42;
                    case 10: goto L40;
                    case 11: goto L38;
                    case 12: goto L36;
                    case 13: goto L34;
                    case 14: goto L32;
                    case 15: goto L30;
                    case 16: goto L28;
                    case 17: goto L26;
                    case 18: goto L24;
                    case 19: goto L22;
                    case 20: goto L20;
                    case 21: goto L18;
                    case 22: goto L16;
                    case 23: goto L14;
                    case 24: goto L12;
                    case 25: goto L10;
                    case 26: goto L8;
                    case 27: goto L6;
                    default: goto L3;
                };
            L3:
                return null;
            L6:
                return RESERVED_USER_20;
            L8:
                return RESERVED_USER_19;
            L10:
                return RESERVED_USER_18;
            L12:
                return RESERVED_USER_17;
            L14:
                return RESERVED_USER_16;
            L16:
                return RESERVED_USER_15;
            L18:
                return RESERVED_USER_14;
            L20:
                return RESERVED_USER_13;
            L22:
                return RESERVED_USER_12;
            L24:
                return RESERVED_USER_11;
            L26:
                return RESERVED_USER_10;
            L28:
                return RESERVED_USER_9;
            L30:
                return RESERVED_USER_8;
            L32:
                return RESERVED_USER_7;
            L34:
                return RESERVED_USER_6;
            L36:
                return RESERVED_USER_5;
            L38:
                return RESERVED_USER_4;
            L40:
                return RESERVED_USER_3;
            L42:
                return RESERVED_USER_2;
            L44:
                return RESERVED_USER_1;
            L46:
                return SIP_USER;
            L48:
                return PSTN_USER;
            L50:
                return NEO_GUEST_USER;
            L52:
                return NEO_USER;
            L54:
                return DOC_USER;
            L56:
                return ROOM;
            L58:
                return LARK_USER;
            L60:
                return UNKNOW_TYPE;
            }

            public static ParticipantType valueOf(String r100) {
                return (ParticipantType) a.a(ParticipantType.class, r100);
            }

            private ParticipantType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_MeetingCard extends ProtoAdapter<MeetingCard> {
            public ProtoAdapter_MeetingCard() {
                super(FieldEncoding.LENGTH_DELIMITED, MeetingCard.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MeetingCard decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.meeting_id = "";
                r101.status = Status.UNKNOWN;
                r101.start_time_ms = 0L;
                r101.end_time_ms = 0L;
                r101.topic = "";
                r101.sponsor_id = "";
                r101.host_id = "";
                r101.meet_number = "";
                r101.max_participant_count = 0;
                r101.host_type = ParticipantType.LARK_USER;
                r101.card_type = CardType.UNKNOWN_CARD_TYPE;
                r101.forwarder_id = "";
                r101.meeting_source = MeetingSource.CARD_UNKNOWN_SOURCE_TYPE;
                r101.calendar_uid = "";
                Boolean r102 = Boolean.FALSE;
                r101.is_locked = r102;
                r101.is_open_lobby = r102;
                r101.owner_user_id = "";
                r101.owner_type = ParticipantType.UNKNOW_TYPE;
                r101.total_participant_num = 0L;
                r101.is_cross_with_ka = r102;
                r101.meeting_sub_type = 0;
                r101.webinar_attendee_num = 0;
                r101.password = "";
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L48;
                switch(r104) {
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
                    case 11: goto L50;
                    case 12: goto L56;
                    case 13: goto L26;
                    case 14: goto L54;
                    case 15: goto L21;
                    case 16: goto L20;
                    case 17: goto L6;
                    case 18: goto L6;
                    case 19: goto L19;
                    case 20: goto L18;
                    case 21: goto L17;
                    case 22: goto L58;
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
                r101.host_type = ParticipantType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L33
            L33:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L52:
                r101.status = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L45
            L45:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L54:
                r101.meeting_source = MeetingSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
            L24:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L56:
                r101.card_type = CardType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L29
            L29:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L58:
                r101.owner_type = ParticipantType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.password = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                r101.webinar_attendee_num = ProtoAdapter.INT32.decode(r100);
                goto L3
            L9:
                r101.meeting_sub_type = ProtoAdapter.INT32.decode(r100);
                goto L3
            L10:
                r101.is_cross_with_ka = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L11:
                r101.all_participant_tenant.add(ProtoAdapter.INT64.decode(r100));
                goto L3
            L12:
                r101.total_participant_num = ProtoAdapter.INT64.decode(r100);
                goto L3
            L17:
                r101.owner_user_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L18:
                r101.is_open_lobby = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L19:
                r101.i18n_default_topic = VideoChatI18nDefaultTopic.ADAPTER.decode(r100);
                goto L3
            L20:
                r101.is_locked = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L21:
                r101.calendar_uid = ProtoAdapter.STRING.decode(r100);
                goto L3
            L26:
                r101.forwarder_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L35:
                r101.max_participant_count = ProtoAdapter.INT32.decode(r100);
                goto L3
            L36:
                r101.participants.add(MeetingParticipant.ADAPTER.decode(r100));
                goto L3
            L37:
                r101.meet_number = ProtoAdapter.STRING.decode(r100);
                goto L3
            L38:
                r101.host_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L39:
                r101.sponsor_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L40:
                r101.topic = ProtoAdapter.STRING.decode(r100);
                goto L3
            L41:
                r101.end_time_ms = ProtoAdapter.INT64.decode(r100);
                goto L3
            L42:
                r101.start_time_ms = ProtoAdapter.INT64.decode(r100);
                goto L3
            L47:
                r101.meeting_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L48:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(MeetingCard r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.encodedSizeWithTag(1, r100.meeting_id) + Status.ADAPTER.encodedSizeWithTag(2, r100.status);
                ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
                int r104 = r102 + r103.encodedSizeWithTag(3, r100.start_time_ms);
                Long r105 = r100.end_time_ms;
                int r106 = 0;
                if (r105 == null) goto L5;
                int r107 = r103.encodedSizeWithTag(4, r105);
            L6:
                int r108 = ((r104 + r107) + r101.encodedSizeWithTag(5, r100.topic)) + r101.encodedSizeWithTag(6, r100.sponsor_id);
                String r109 = r100.host_id;
                if (r109 == null) goto L9;
                int r110 = r101.encodedSizeWithTag(7, r109);
            L10:
                int r111 = r108 + r110;
                String r112 = r100.meet_number;
                if (r112 == null) goto L13;
                int r113 = r101.encodedSizeWithTag(8, r112);
            L14:
                int r114 = (r111 + r113) + MeetingParticipant.ADAPTER.asRepeated().encodedSizeWithTag(9, r100.participants);
                Integer r115 = r100.max_participant_count;
                if (r115 == null) goto L17;
                int r116 = ProtoAdapter.INT32.encodedSizeWithTag(10, r115);
            L18:
                int r117 = r114 + r116;
                ParticipantType r118 = r100.host_type;
                if (r118 == null) goto L21;
                int r119 = ParticipantType.ADAPTER.encodedSizeWithTag(11, r118);
            L22:
                int r120 = r117 + r119;
                CardType r121 = r100.card_type;
                if (r121 == null) goto L25;
                int r122 = CardType.ADAPTER.encodedSizeWithTag(12, r121);
            L26:
                int r123 = r120 + r122;
                String r124 = r100.forwarder_id;
                if (r124 == null) goto L29;
                int r125 = r101.encodedSizeWithTag(13, r124);
            L30:
                int r126 = r123 + r125;
                MeetingSource r127 = r100.meeting_source;
                if (r127 == null) goto L33;
                int r128 = MeetingSource.ADAPTER.encodedSizeWithTag(14, r127);
            L34:
                int r129 = r126 + r128;
                String r130 = r100.calendar_uid;
                if (r130 == null) goto L37;
                int r131 = r101.encodedSizeWithTag(15, r130);
            L38:
                int r132 = r129 + r131;
                Boolean r133 = r100.is_locked;
                if (r133 == null) goto L41;
                int r134 = ProtoAdapter.BOOL.encodedSizeWithTag(16, r133);
            L42:
                int r135 = r132 + r134;
                VideoChatI18nDefaultTopic r136 = r100.i18n_default_topic;
                if (r136 == null) goto L45;
                int r137 = VideoChatI18nDefaultTopic.ADAPTER.encodedSizeWithTag(19, r136);
            L46:
                int r138 = r135 + r137;
                Boolean r139 = r100.is_open_lobby;
                if (r139 == null) goto L49;
                int r140 = ProtoAdapter.BOOL.encodedSizeWithTag(20, r139);
            L50:
                int r141 = r138 + r140;
                String r142 = r100.owner_user_id;
                if (r142 == null) goto L53;
                int r143 = r101.encodedSizeWithTag(21, r142);
            L54:
                int r144 = r141 + r143;
                ParticipantType r145 = r100.owner_type;
                if (r145 == null) goto L57;
                int r146 = ParticipantType.ADAPTER.encodedSizeWithTag(22, r145);
            L58:
                int r147 = r144 + r146;
                Long r148 = r100.total_participant_num;
                if (r148 == null) goto L61;
                int r149 = r103.encodedSizeWithTag(23, r148);
            L62:
                int r150 = (r147 + r149) + r103.asRepeated().encodedSizeWithTag(24, r100.all_participant_tenant);
                Boolean r151 = r100.is_cross_with_ka;
                if (r151 == null) goto L65;
                int r152 = ProtoAdapter.BOOL.encodedSizeWithTag(25, r151);
            L66:
                int r153 = r150 + r152;
                Integer r154 = r100.meeting_sub_type;
                if (r154 == null) goto L69;
                int r155 = ProtoAdapter.INT32.encodedSizeWithTag(30, r154);
            L70:
                int r156 = r153 + r155;
                Integer r157 = r100.webinar_attendee_num;
                if (r157 == null) goto L73;
                int r158 = ProtoAdapter.INT32.encodedSizeWithTag(31, r157);
            L74:
                int r159 = r156 + r158;
                String r160 = r100.password;
                if (r160 == null) goto L78;
                r106 = r101.encodedSizeWithTag(32, r160);
            L78:
                return (r159 + r106) + r100.unknownFields().size();
            L73:
                r158 = 0;
                goto L74
            L69:
                r155 = 0;
                goto L70
            L65:
                r152 = 0;
                goto L66
            L61:
                r149 = 0;
                goto L62
            L57:
                r146 = 0;
                goto L58
            L53:
                r143 = 0;
                goto L54
            L49:
                r140 = 0;
                goto L50
            L45:
                r137 = 0;
                goto L46
            L41:
                r134 = 0;
                goto L42
            L37:
                r131 = 0;
                goto L38
            L33:
                r128 = 0;
                goto L34
            L29:
                r125 = 0;
                goto L30
            L25:
                r122 = 0;
                goto L26
            L21:
                r119 = 0;
                goto L22
            L17:
                r116 = 0;
                goto L18
            L13:
                r113 = 0;
                goto L14
            L9:
                r110 = 0;
                goto L10
            L5:
                r107 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MeetingCard decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MeetingCard r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MeetingCard r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.meeting_id);
                Status.ADAPTER.encodeWithTag(r100, 2, r101.status);
                ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
                r103.encodeWithTag(r100, 3, r101.start_time_ms);
                Long r104 = r101.end_time_ms;
                if (r104 == null) goto L5;
                r103.encodeWithTag(r100, 4, r104);
            L5:
                r102.encodeWithTag(r100, 5, r101.topic);
                r102.encodeWithTag(r100, 6, r101.sponsor_id);
                String r105 = r101.host_id;
                if (r105 == null) goto L8;
                r102.encodeWithTag(r100, 7, r105);
            L8:
                String r106 = r101.meet_number;
                if (r106 == null) goto L11;
                r102.encodeWithTag(r100, 8, r106);
            L11:
                MeetingParticipant.ADAPTER.asRepeated().encodeWithTag(r100, 9, r101.participants);
                Integer r107 = r101.max_participant_count;
                if (r107 == null) goto L14;
                ProtoAdapter.INT32.encodeWithTag(r100, 10, r107);
            L14:
                ParticipantType r108 = r101.host_type;
                if (r108 == null) goto L17;
                ParticipantType.ADAPTER.encodeWithTag(r100, 11, r108);
            L17:
                CardType r109 = r101.card_type;
                if (r109 == null) goto L20;
                CardType.ADAPTER.encodeWithTag(r100, 12, r109);
            L20:
                String r110 = r101.forwarder_id;
                if (r110 == null) goto L23;
                r102.encodeWithTag(r100, 13, r110);
            L23:
                MeetingSource r111 = r101.meeting_source;
                if (r111 == null) goto L26;
                MeetingSource.ADAPTER.encodeWithTag(r100, 14, r111);
            L26:
                String r112 = r101.calendar_uid;
                if (r112 == null) goto L29;
                r102.encodeWithTag(r100, 15, r112);
            L29:
                Boolean r113 = r101.is_locked;
                if (r113 == null) goto L32;
                ProtoAdapter.BOOL.encodeWithTag(r100, 16, r113);
            L32:
                VideoChatI18nDefaultTopic r114 = r101.i18n_default_topic;
                if (r114 == null) goto L35;
                VideoChatI18nDefaultTopic.ADAPTER.encodeWithTag(r100, 19, r114);
            L35:
                Boolean r115 = r101.is_open_lobby;
                if (r115 == null) goto L38;
                ProtoAdapter.BOOL.encodeWithTag(r100, 20, r115);
            L38:
                String r116 = r101.owner_user_id;
                if (r116 == null) goto L41;
                r102.encodeWithTag(r100, 21, r116);
            L41:
                ParticipantType r117 = r101.owner_type;
                if (r117 == null) goto L44;
                ParticipantType.ADAPTER.encodeWithTag(r100, 22, r117);
            L44:
                Long r118 = r101.total_participant_num;
                if (r118 == null) goto L47;
                r103.encodeWithTag(r100, 23, r118);
            L47:
                r103.asRepeated().encodeWithTag(r100, 24, r101.all_participant_tenant);
                Boolean r119 = r101.is_cross_with_ka;
                if (r119 == null) goto L50;
                ProtoAdapter.BOOL.encodeWithTag(r100, 25, r119);
            L50:
                Integer r120 = r101.meeting_sub_type;
                if (r120 == null) goto L53;
                ProtoAdapter.INT32.encodeWithTag(r100, 30, r120);
            L53:
                Integer r121 = r101.webinar_attendee_num;
                if (r121 == null) goto L56;
                ProtoAdapter.INT32.encodeWithTag(r100, 31, r121);
            L56:
                String r122 = r101.password;
                if (r122 == null) goto L59;
                r102.encodeWithTag(r100, 32, r122);
            L59:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MeetingCard r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Status extends Enum<Status> implements WireEnum {
            private static final /* synthetic */ Status[] $VALUES = null;
            public static final ProtoAdapter<Status> ADAPTER = null;
            public static final Status END = null;
            public static final Status FULL = null;
            public static final Status JOINABLE = null;
            public static final Status UNKNOWN = null;
            private final int value;

            static {
                Status r100 = new Status("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Status r101 = new Status("JOINABLE", 1, 1);
                JOINABLE = r101;
                Status r102 = new Status("FULL", 2, 2);
                FULL = r102;
                Status r103 = new Status(GXAnimation.STATE_END, 3, 3);
                END = r103;
                $VALUES = new Status[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
            }

            public static Status[] values() {
                return (Status[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Status fromValue(int r100) {
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 3) goto L12;
                return null;
            L12:
                return END;
            L14:
                return FULL;
            L16:
                return JOINABLE;
            L18:
                return UNKNOWN;
            }

            public static Status valueOf(String r100) {
                return (Status) a.a(Status.class, r100);
            }

            private Status(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MeetingCard();
            DEFAULT_STATUS = Status.UNKNOWN;
            DEFAULT_START_TIME_MS = 0L;
            DEFAULT_END_TIME_MS = 0L;
            DEFAULT_MAX_PARTICIPANT_COUNT = 0;
            DEFAULT_HOST_TYPE = ParticipantType.LARK_USER;
            DEFAULT_CARD_TYPE = CardType.UNKNOWN_CARD_TYPE;
            DEFAULT_MEETING_SOURCE = MeetingSource.CARD_UNKNOWN_SOURCE_TYPE;
            Boolean r100 = Boolean.FALSE;
            DEFAULT_IS_LOCKED = r100;
            DEFAULT_IS_OPEN_LOBBY = r100;
            DEFAULT_OWNER_TYPE = ParticipantType.UNKNOW_TYPE;
            DEFAULT_TOTAL_PARTICIPANT_NUM = 0L;
            DEFAULT_IS_CROSS_WITH_KA = r100;
            DEFAULT_MEETING_SUB_TYPE = 0;
            DEFAULT_WEBINAR_ATTENDEE_NUM = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.meeting_id = this.meeting_id;
            r100.status = this.status;
            r100.start_time_ms = this.start_time_ms;
            r100.end_time_ms = this.end_time_ms;
            r100.topic = this.topic;
            r100.sponsor_id = this.sponsor_id;
            r100.host_id = this.host_id;
            r100.meet_number = this.meet_number;
            r100.participants = Internal.copyOf("participants", this.participants);
            r100.max_participant_count = this.max_participant_count;
            r100.host_type = this.host_type;
            r100.card_type = this.card_type;
            r100.forwarder_id = this.forwarder_id;
            r100.meeting_source = this.meeting_source;
            r100.calendar_uid = this.calendar_uid;
            r100.is_locked = this.is_locked;
            r100.i18n_default_topic = this.i18n_default_topic;
            r100.is_open_lobby = this.is_open_lobby;
            r100.owner_user_id = this.owner_user_id;
            r100.owner_type = this.owner_type;
            r100.total_participant_num = this.total_participant_num;
            r100.all_participant_tenant = Internal.copyOf("all_participant_tenant", this.all_participant_tenant);
            r100.is_cross_with_ka = this.is_cross_with_ka;
            r100.meeting_sub_type = this.meeting_sub_type;
            r100.webinar_attendee_num = this.webinar_attendee_num;
            r100.password = this.password;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MeetingCard.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public MeetingCard(String r210, Status r310, Long r311, Long r312, String r313, String r314, String r315, String r316, List<MeetingParticipant> r317, Integer r318, ParticipantType r319, CardType r410, String r411, MeetingSource r412, String r413, Boolean r414, VideoChatI18nDefaultTopic r415, Boolean r416, String r417, ParticipantType r418, Long r419, List<Long> r510, Boolean r511, Integer r512, Integer r513, String r514) {
            this(r210, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, ByteString.EMPTY);
        }

        public MeetingCard(String r100, Status r101, Long r102, Long r103, String r104, String r105, String r110, String r111, List<MeetingParticipant> r112, Integer r113, ParticipantType r114, CardType r115, String r116, MeetingSource r117, String r118, Boolean r119, VideoChatI18nDefaultTopic r210, Boolean r211, String r212, ParticipantType r213, Long r214, List<Long> r215, Boolean r216, Integer r217, Integer r218, String r219, ByteString r310) {
            super(ADAPTER, r310);
            this.meeting_id = r100;
            this.status = r101;
            this.start_time_ms = r102;
            this.end_time_ms = r103;
            this.topic = r104;
            this.sponsor_id = r105;
            this.host_id = r110;
            this.meet_number = r111;
            this.participants = Internal.immutableCopyOf("participants", r112);
            this.max_participant_count = r113;
            this.host_type = r114;
            this.card_type = r115;
            this.forwarder_id = r116;
            this.meeting_source = r117;
            this.calendar_uid = r118;
            this.is_locked = r119;
            this.i18n_default_topic = r210;
            this.is_open_lobby = r211;
            this.owner_user_id = r212;
            this.owner_type = r213;
            this.total_participant_num = r214;
            this.all_participant_tenant = Internal.immutableCopyOf("all_participant_tenant", r215);
            this.is_cross_with_ka = r216;
            this.meeting_sub_type = r217;
            this.webinar_attendee_num = r218;
            this.password = r219;
        }
    }

    public static final class ProtoAdapter_VideoChatContent extends ProtoAdapter<VideoChatContent> {
        public ProtoAdapter_VideoChatContent() {
            super(FieldEncoding.LENGTH_DELIMITED, VideoChatContent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public VideoChatContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = Type.UNKNOWN;
            r101.sequence_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.meeting_card = MeetingCard.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.sequence_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(VideoChatContent r100) {
            int r101 = Type.ADAPTER.encodedSizeWithTag(1, r100.type);
            MeetingCard r102 = r100.meeting_card;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = MeetingCard.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Long r106 = r100.sequence_id;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.INT64.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ VideoChatContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(VideoChatContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, VideoChatContent r101) throws IOException {
            Type.ADAPTER.encodeWithTag(r100, 1, r101.type);
            MeetingCard r102 = r101.meeting_card;
            if (r102 == null) goto L5;
            MeetingCard.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            Long r103 = r101.sequence_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, VideoChatContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type CHAT_ROOM_CARD = null;
        public static final Type MEETING_CARD = null;
        public static final Type UNKNOWN = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("MEETING_CARD", 1, 1);
            MEETING_CARD = r101;
            Type r102 = new Type("CHAT_ROOM_CARD", 2, 2);
            CHAT_ROOM_CARD = r102;
            $VALUES = new Type[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return CHAT_ROOM_CARD;
        L12:
            return MEETING_CARD;
        L14:
            return UNKNOWN;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_VideoChatContent();
        DEFAULT_TYPE = Type.UNKNOWN;
        DEFAULT_SEQUENCE_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.meeting_card = this.meeting_card;
        r100.sequence_id = this.sequence_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return VideoChatContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public VideoChatContent(Type r100, MeetingCard r101, Long r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public VideoChatContent(Type r100, MeetingCard r101, Long r102, ByteString r103) {
        super(ADAPTER, r103);
        this.type = r100;
        this.meeting_card = r101;
        this.sequence_id = r102;
    }
}
