package com.bytedance.lark.pb.feed.v1;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.lark.pb.basic.v1.Chat;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.TagData;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
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
public final class ForwardCommonData extends Message<ForwardCommonData, Builder> {
    public static final ProtoAdapter<ForwardCommonData> ADAPTER = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final Long DEFAULT_CHAT_ID = null;
    public static final Long DEFAULT_ID = null;
    public static final Boolean DEFAULT_ISCRYPTO = null;
    public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
    public static final Boolean DEFAULT_IS_CROSS_WITH_KA = null;
    public static final Boolean DEFAULT_IS_MEETING = null;
    public static final ItemType DEFAULT_ITEM_TYPE = null;
    public static final String DEFAULT_SUBTITLE = "";
    public static final Long DEFAULT_TIMESTAMP = null;
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    public final String avatar_key;
    public final ChatInfo chat;
    public final Long chat_id;
    public final ChatterInfo chatter;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final Long f253625id;
    public final Boolean isCrypto;
    public final Boolean is_cross_tenant;
    public final Boolean is_cross_with_ka;
    public final Boolean is_meeting;
    public final ItemType item_type;
    public final ReplyInThreadInfo replyInThread;
    public final ShieldP2PChatInfo shieldP2PChatInfo;
    public final String subTitle;
    public final TagData tag_data;
    public final ThreadInfo thread;
    public final Long timestamp;
    public final String title;

    public static final class Builder extends Message.Builder<ForwardCommonData, Builder> {
        public String avatar_key;
        public ChatInfo chat;
        public Long chat_id;
        public ChatterInfo chatter;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public Long f253626id;
        public Boolean isCrypto;
        public Boolean is_cross_tenant;
        public Boolean is_cross_with_ka;
        public Boolean is_meeting;
        public ItemType item_type;
        public ReplyInThreadInfo replyInThread;
        public ShieldP2PChatInfo shieldP2PChatInfo;
        public String subTitle;
        public TagData tag_data;
        public ThreadInfo thread;
        public Long timestamp;
        public String title;

        @Override // com.squareup.wire.Message.Builder
        public ForwardCommonData build() {
            Long r100 = this.f253626id;
            if (r100 == null) goto L7;
            return new ForwardCommonData(this.f253626id, this.title, this.tag_data, this.is_cross_tenant, this.is_cross_with_ka, this.isCrypto, this.subTitle, this.item_type, this.avatar_key, this.timestamp, this.chat_id, this.is_meeting, this.chat, this.chatter, this.thread, this.replyInThread, this.shieldP2PChatInfo, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder avatar_key(String r100) {
            this.avatar_key = r100;
            return this;
        }

        public Builder chat(ChatInfo r100) {
            this.chat = r100;
            return this;
        }

        public Builder chat_id(Long r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder chatter(ChatterInfo r100) {
            this.chatter = r100;
            return this;
        }

        public Builder id(Long r100) {
            this.f253626id = r100;
            return this;
        }

        public Builder isCrypto(Boolean r100) {
            this.isCrypto = r100;
            return this;
        }

        public Builder is_cross_tenant(Boolean r100) {
            this.is_cross_tenant = r100;
            return this;
        }

        public Builder is_cross_with_ka(Boolean r100) {
            this.is_cross_with_ka = r100;
            return this;
        }

        public Builder is_meeting(Boolean r100) {
            this.is_meeting = r100;
            return this;
        }

        public Builder item_type(ItemType r100) {
            this.item_type = r100;
            return this;
        }

        public Builder replyInThread(ReplyInThreadInfo r100) {
            this.replyInThread = r100;
            return this;
        }

        public Builder shieldP2PChatInfo(ShieldP2PChatInfo r100) {
            this.shieldP2PChatInfo = r100;
            return this;
        }

        public Builder subTitle(String r100) {
            this.subTitle = r100;
            return this;
        }

        public Builder tag_data(TagData r100) {
            this.tag_data = r100;
            return this;
        }

        public Builder thread(ThreadInfo r100) {
            this.thread = r100;
            return this;
        }

        public Builder timestamp(Long r100) {
            this.timestamp = r100;
            return this;
        }

        public Builder title(String r100) {
            this.title = r100;
            return this;
        }
    }

    public static final class ChatInfo extends Message<ChatInfo, Builder> {
        public static final ProtoAdapter<ChatInfo> ADAPTER = null;
        public static final Chat.ChatDisplayModeSetting.Enum DEFAULT_CHAT_DISPLAY_MODE_SETTING = null;
        public static final Chat.ChatMode DEFAULT_CHAT_TYPE = null;
        public static final Integer DEFAULT_CHAT_USER_COUNT = null;
        public static final Boolean DEFAULT_IS_DEPARTMENT = null;
        public static final Boolean DEFAULT_IS_OFFICIAL_ONCALL = null;
        public static final Boolean DEFAULT_IS_PUBLIC = null;
        public static final Boolean DEFAULT_IS_SHIELD_MODE = null;
        public static final Boolean DEFAULT_IS_USER_COUNT_VISIBLE = null;
        public static final String DEFAULT_LAST_MESSAGE_POSITION = "";
        private static final long serialVersionUID = 0;
        public final Chat.ChatDisplayModeSetting.Enum chat_display_mode_setting;
        public final Chat.ChatMode chat_type;
        public final Integer chat_user_count;
        public final Boolean is_department;
        public final Boolean is_official_oncall;
        public final Boolean is_public;
        public final Boolean is_shield_mode;
        public final Boolean is_user_count_visible;
        public final String last_message_position;
        public final List<Integer> tags;

        public static final class Builder extends Message.Builder<ChatInfo, Builder> {
            public Chat.ChatDisplayModeSetting.Enum chat_display_mode_setting;
            public Chat.ChatMode chat_type;
            public Integer chat_user_count;
            public Boolean is_department;
            public Boolean is_official_oncall;
            public Boolean is_public;
            public Boolean is_shield_mode;
            public Boolean is_user_count_visible;
            public String last_message_position;
            public List<Integer> tags;

            @Override // com.squareup.wire.Message.Builder
            public ChatInfo build() {
                return new ChatInfo(this.is_official_oncall, this.tags, this.is_shield_mode, this.chat_type, this.chat_display_mode_setting, this.chat_user_count, this.is_department, this.last_message_position, this.is_public, this.is_user_count_visible, super.buildUnknownFields());
            }

            public Builder() {
                this.tags = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder chat_display_mode_setting(Chat.ChatDisplayModeSetting.Enum r100) {
                this.chat_display_mode_setting = r100;
                return this;
            }

            public Builder chat_type(Chat.ChatMode r100) {
                this.chat_type = r100;
                return this;
            }

            public Builder chat_user_count(Integer r100) {
                this.chat_user_count = r100;
                return this;
            }

            public Builder is_department(Boolean r100) {
                this.is_department = r100;
                return this;
            }

            public Builder is_official_oncall(Boolean r100) {
                this.is_official_oncall = r100;
                return this;
            }

            public Builder is_public(Boolean r100) {
                this.is_public = r100;
                return this;
            }

            public Builder is_shield_mode(Boolean r100) {
                this.is_shield_mode = r100;
                return this;
            }

            public Builder is_user_count_visible(Boolean r100) {
                this.is_user_count_visible = r100;
                return this;
            }

            public Builder last_message_position(String r100) {
                this.last_message_position = r100;
                return this;
            }

            public Builder tags(List<Integer> r100) {
                Internal.checkElementsNotNull(r100);
                this.tags = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ChatInfo extends ProtoAdapter<ChatInfo> {
            public ProtoAdapter_ChatInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, ChatInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ChatInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.is_official_oncall = r102;
                r101.is_shield_mode = r102;
                r101.chat_type = Chat.ChatMode.UNKNOWN;
                r101.chat_display_mode_setting = Chat.ChatDisplayModeSetting.Enum.UNKNOWN;
                r101.chat_user_count = 0;
                r101.is_department = r102;
                r101.last_message_position = "";
                r101.is_public = r102;
                r101.is_user_count_visible = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L23;
                switch(r104) {
                    case 1: goto L22;
                    case 2: goto L6;
                    case 3: goto L21;
                    case 4: goto L20;
                    case 5: goto L25;
                    case 6: goto L27;
                    case 7: goto L11;
                    case 8: goto L10;
                    case 9: goto L9;
                    case 10: goto L8;
                    case 11: goto L7;
                    default: goto L6;
                };
            L25:
                r101.chat_type = Chat.ChatMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L27:
                r101.chat_display_mode_setting = Chat.ChatDisplayModeSetting.Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.is_user_count_visible = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                r101.is_public = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                r101.last_message_position = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.is_department = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L11:
                r101.chat_user_count = ProtoAdapter.INT32.decode(r100);
                goto L3
            L20:
                r101.is_shield_mode = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L21:
                r101.tags.add(ProtoAdapter.INT32.decode(r100));
                goto L3
            L22:
                r101.is_official_oncall = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L23:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ChatInfo r100) {
                Boolean r101 = r100.is_official_oncall;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                ProtoAdapter<Integer> r104 = ProtoAdapter.INT32;
                int r105 = r103 + r104.asRepeated().encodedSizeWithTag(3, r100.tags);
                Boolean r106 = r100.is_shield_mode;
                if (r106 == null) goto L9;
                int r107 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r106);
            L10:
                int r108 = r105 + r107;
                Chat.ChatMode r109 = r100.chat_type;
                if (r109 == null) goto L13;
                int r110 = Chat.ChatMode.ADAPTER.encodedSizeWithTag(5, r109);
            L14:
                int r111 = r108 + r110;
                Chat.ChatDisplayModeSetting.Enum r112 = r100.chat_display_mode_setting;
                if (r112 == null) goto L17;
                int r113 = Chat.ChatDisplayModeSetting.Enum.ADAPTER.encodedSizeWithTag(6, r112);
            L18:
                int r114 = r111 + r113;
                Integer r115 = r100.chat_user_count;
                if (r115 == null) goto L21;
                int r116 = r104.encodedSizeWithTag(7, r115);
            L22:
                int r117 = r114 + r116;
                Boolean r118 = r100.is_department;
                if (r118 == null) goto L25;
                int r119 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r118);
            L26:
                int r120 = r117 + r119;
                String r121 = r100.last_message_position;
                if (r121 == null) goto L29;
                int r122 = ProtoAdapter.STRING.encodedSizeWithTag(9, r121);
            L30:
                int r123 = r120 + r122;
                Boolean r124 = r100.is_public;
                if (r124 == null) goto L33;
                int r125 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r124);
            L34:
                int r126 = r123 + r125;
                Boolean r127 = r100.is_user_count_visible;
                if (r127 == null) goto L38;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r127);
            L38:
                return (r126 + r102) + r100.unknownFields().size();
            L33:
                r125 = 0;
                goto L34
            L29:
                r122 = 0;
                goto L30
            L25:
                r119 = 0;
                goto L26
            L21:
                r116 = 0;
                goto L22
            L17:
                r113 = 0;
                goto L18
            L13:
                r110 = 0;
                goto L14
            L9:
                r107 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ChatInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ChatInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ChatInfo r101) throws IOException {
                Boolean r102 = r101.is_official_oncall;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                ProtoAdapter<Integer> r103 = ProtoAdapter.INT32;
                r103.asRepeated().encodeWithTag(r100, 3, r101.tags);
                Boolean r104 = r101.is_shield_mode;
                if (r104 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
            L8:
                Chat.ChatMode r105 = r101.chat_type;
                if (r105 == null) goto L11;
                Chat.ChatMode.ADAPTER.encodeWithTag(r100, 5, r105);
            L11:
                Chat.ChatDisplayModeSetting.Enum r106 = r101.chat_display_mode_setting;
                if (r106 == null) goto L14;
                Chat.ChatDisplayModeSetting.Enum.ADAPTER.encodeWithTag(r100, 6, r106);
            L14:
                Integer r107 = r101.chat_user_count;
                if (r107 == null) goto L17;
                r103.encodeWithTag(r100, 7, r107);
            L17:
                Boolean r108 = r101.is_department;
                if (r108 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r100, 8, r108);
            L20:
                String r109 = r101.last_message_position;
                if (r109 == null) goto L23;
                ProtoAdapter.STRING.encodeWithTag(r100, 9, r109);
            L23:
                Boolean r110 = r101.is_public;
                if (r110 == null) goto L26;
                ProtoAdapter.BOOL.encodeWithTag(r100, 10, r110);
            L26:
                Boolean r111 = r101.is_user_count_visible;
                if (r111 == null) goto L29;
                ProtoAdapter.BOOL.encodeWithTag(r100, 11, r111);
            L29:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChatInfo();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_IS_OFFICIAL_ONCALL = r100;
            DEFAULT_IS_SHIELD_MODE = r100;
            DEFAULT_CHAT_TYPE = Chat.ChatMode.UNKNOWN;
            DEFAULT_CHAT_DISPLAY_MODE_SETTING = Chat.ChatDisplayModeSetting.Enum.UNKNOWN;
            DEFAULT_CHAT_USER_COUNT = 0;
            DEFAULT_IS_DEPARTMENT = r100;
            DEFAULT_IS_PUBLIC = r100;
            DEFAULT_IS_USER_COUNT_VISIBLE = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.is_official_oncall = this.is_official_oncall;
            r100.tags = Internal.copyOf(PromotionProductPrivilegesStruct.TAGS, this.tags);
            r100.is_shield_mode = this.is_shield_mode;
            r100.chat_type = this.chat_type;
            r100.chat_display_mode_setting = this.chat_display_mode_setting;
            r100.chat_user_count = this.chat_user_count;
            r100.is_department = this.is_department;
            r100.last_message_position = this.last_message_position;
            r100.is_public = this.is_public;
            r100.is_user_count_visible = this.is_user_count_visible;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ChatInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ChatInfo(Boolean r110, List<Integer> r111, Boolean r112, Chat.ChatMode r113, Chat.ChatDisplayModeSetting.Enum r114, Integer r115, Boolean r116, String r210, Boolean r211, Boolean r212) {
            this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
        }

        public ChatInfo(Boolean r100, List<Integer> r101, Boolean r102, Chat.ChatMode r103, Chat.ChatDisplayModeSetting.Enum r104, Integer r105, Boolean r106, String r107, Boolean r110, Boolean r111, ByteString r112) {
            super(ADAPTER, r112);
            this.is_official_oncall = r100;
            this.tags = Internal.immutableCopyOf(PromotionProductPrivilegesStruct.TAGS, r101);
            this.is_shield_mode = r102;
            this.chat_type = r103;
            this.chat_display_mode_setting = r104;
            this.chat_user_count = r105;
            this.is_department = r106;
            this.last_message_position = r107;
            this.is_public = r110;
            this.is_user_count_visible = r111;
        }
    }

    public static final class ChatterInfo extends Message<ChatterInfo, Builder> {
        public static final ProtoAdapter<ChatterInfo> ADAPTER = null;
        public static final Integer DEFAULT_BOT_EXT_TYPE = null;
        public static final Long DEFAULT_CHATTER_ID = null;
        public static final Chatter.Type DEFAULT_CHATTER_TYPE = null;
        public static final Long DEFAULT_DONOTDISTURBENDTIME = null;
        public static final Boolean DEFAULT_IS_AGENT = null;
        private static final long serialVersionUID = 0;
        public final Integer bot_ext_type;
        public final Long chatter_id;
        public final Chatter.Type chatter_type;
        public final List<Chatter.ChatterCustomStatus> customStatus;
        public final Long doNotDisturbEndTime;
        public final Boolean is_agent;

        public static final class Builder extends Message.Builder<ChatterInfo, Builder> {
            public Integer bot_ext_type;
            public Long chatter_id;
            public Chatter.Type chatter_type;
            public List<Chatter.ChatterCustomStatus> customStatus;
            public Long doNotDisturbEndTime;
            public Boolean is_agent;

            @Override // com.squareup.wire.Message.Builder
            public ChatterInfo build() {
                Long r100 = this.chatter_id;
                if (r100 == null) goto L7;
                return new ChatterInfo(this.chatter_id, this.customStatus, this.doNotDisturbEndTime, this.chatter_type, this.bot_ext_type, this.is_agent, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "chatter_id"});
            }

            public Builder() {
                this.customStatus = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder bot_ext_type(Integer r100) {
                this.bot_ext_type = r100;
                return this;
            }

            public Builder chatter_id(Long r100) {
                this.chatter_id = r100;
                return this;
            }

            public Builder chatter_type(Chatter.Type r100) {
                this.chatter_type = r100;
                return this;
            }

            public Builder customStatus(List<Chatter.ChatterCustomStatus> r100) {
                Internal.checkElementsNotNull(r100);
                this.customStatus = r100;
                return this;
            }

            public Builder doNotDisturbEndTime(Long r100) {
                this.doNotDisturbEndTime = r100;
                return this;
            }

            public Builder is_agent(Boolean r100) {
                this.is_agent = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ChatterInfo extends ProtoAdapter<ChatterInfo> {
            public ProtoAdapter_ChatterInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, ChatterInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ChatterInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.chatter_id = 0L;
                r101.doNotDisturbEndTime = 0L;
                r101.chatter_type = Chatter.Type.UNKNOWN;
                r101.bot_ext_type = 0;
                r101.is_agent = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L27;
                if (r103 != 1) goto L8;
                r101.chatter_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 3) goto L10;
                r101.customStatus.add(Chatter.ChatterCustomStatus.ADAPTER.decode(r100));
                goto L3
            L10:
                if (r103 != 4) goto L12;
                r101.doNotDisturbEndTime = ProtoAdapter.INT64.decode(r100);
                goto L3
            L12:
                if (r103 != 6) goto L14;
                r101.chatter_type = Chatter.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L14:
                if (r103 != 7) goto L16;
                r101.bot_ext_type = ProtoAdapter.INT32.decode(r100);
                goto L3
            L16:
                if (r103 != 8) goto L17;
                r101.is_agent = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L17:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L27:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ChatterInfo r100) {
                ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
                int r102 = r101.encodedSizeWithTag(1, r100.chatter_id) + Chatter.ChatterCustomStatus.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.customStatus);
                Long r103 = r100.doNotDisturbEndTime;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = r101.encodedSizeWithTag(4, r103);
            L6:
                int r106 = r102 + r105;
                Chatter.Type r107 = r100.chatter_type;
                if (r107 == null) goto L9;
                int r108 = Chatter.Type.ADAPTER.encodedSizeWithTag(6, r107);
            L10:
                int r109 = r106 + r108;
                Integer r110 = r100.bot_ext_type;
                if (r110 == null) goto L13;
                int r111 = ProtoAdapter.INT32.encodedSizeWithTag(7, r110);
            L14:
                int r112 = r109 + r111;
                Boolean r113 = r100.is_agent;
                if (r113 == null) goto L18;
                r104 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r113);
            L18:
                return (r112 + r104) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ ChatterInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ChatterInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ChatterInfo r101) throws IOException {
                ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
                r102.encodeWithTag(r100, 1, r101.chatter_id);
                Chatter.ChatterCustomStatus.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.customStatus);
                Long r103 = r101.doNotDisturbEndTime;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 4, r103);
            L5:
                Chatter.Type r104 = r101.chatter_type;
                if (r104 == null) goto L8;
                Chatter.Type.ADAPTER.encodeWithTag(r100, 6, r104);
            L8:
                Integer r105 = r101.bot_ext_type;
                if (r105 == null) goto L11;
                ProtoAdapter.INT32.encodeWithTag(r100, 7, r105);
            L11:
                Boolean r106 = r101.is_agent;
                if (r106 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 8, r106);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatterInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChatterInfo();
            DEFAULT_CHATTER_ID = 0L;
            DEFAULT_DONOTDISTURBENDTIME = 0L;
            DEFAULT_CHATTER_TYPE = Chatter.Type.UNKNOWN;
            DEFAULT_BOT_EXT_TYPE = 0;
            DEFAULT_IS_AGENT = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.chatter_id = this.chatter_id;
            r100.customStatus = Internal.copyOf("customStatus", this.customStatus);
            r100.doNotDisturbEndTime = this.doNotDisturbEndTime;
            r100.chatter_type = this.chatter_type;
            r100.bot_ext_type = this.bot_ext_type;
            r100.is_agent = this.is_agent;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ChatterInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ChatterInfo(Long r100, List<Chatter.ChatterCustomStatus> r110, Long r111, Chatter.Type r112, Integer r113, Boolean r114) {
            this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
        }

        public ChatterInfo(Long r100, List<Chatter.ChatterCustomStatus> r101, Long r102, Chatter.Type r103, Integer r104, Boolean r105, ByteString r106) {
            super(ADAPTER, r106);
            this.chatter_id = r100;
            this.customStatus = Internal.immutableCopyOf("customStatus", r101);
            this.doNotDisturbEndTime = r102;
            this.chatter_type = r103;
            this.bot_ext_type = r104;
            this.is_agent = r105;
        }
    }

    public static final enum ItemType extends Enum<ItemType> implements WireEnum {
        private static final /* synthetic */ ItemType[] $VALUES = null;
        public static final ProtoAdapter<ItemType> ADAPTER = null;
        public static final ItemType ITEM_TYPE_CHAT = null;
        public static final ItemType ITEM_TYPE_CHATTER = null;
        public static final ItemType ITEM_TYPE_REPLY_IN_THREAD = null;
        public static final ItemType ITEM_TYPE_SHIELD_P2P_CHAT = null;
        public static final ItemType ITEM_TYPE_THREAD = null;
        public static final ItemType ITEM_TYPE_UNKNOWN = null;
        private final int value;

        static {
            ItemType r100 = new ItemType("ITEM_TYPE_UNKNOWN", 0, 0);
            ITEM_TYPE_UNKNOWN = r100;
            ItemType r101 = new ItemType("ITEM_TYPE_CHAT", 1, 1);
            ITEM_TYPE_CHAT = r101;
            ItemType r102 = new ItemType("ITEM_TYPE_CHATTER", 2, 2);
            ITEM_TYPE_CHATTER = r102;
            ItemType r103 = new ItemType("ITEM_TYPE_THREAD", 3, 3);
            ITEM_TYPE_THREAD = r103;
            ItemType r104 = new ItemType("ITEM_TYPE_REPLY_IN_THREAD", 4, 4);
            ITEM_TYPE_REPLY_IN_THREAD = r104;
            ItemType r105 = new ItemType("ITEM_TYPE_SHIELD_P2P_CHAT", 5, 5);
            ITEM_TYPE_SHIELD_P2P_CHAT = r105;
            $VALUES = new ItemType[]{r100, r101, r102, r103, r104, r105};
            ADAPTER = ProtoAdapter.newEnumAdapter(ItemType.class);
        }

        public static ItemType[] values() {
            return (ItemType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ItemType fromValue(int r100) {
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 5) goto L16;
            return null;
        L16:
            return ITEM_TYPE_SHIELD_P2P_CHAT;
        L18:
            return ITEM_TYPE_REPLY_IN_THREAD;
        L20:
            return ITEM_TYPE_THREAD;
        L22:
            return ITEM_TYPE_CHATTER;
        L24:
            return ITEM_TYPE_CHAT;
        L26:
            return ITEM_TYPE_UNKNOWN;
        }

        public static ItemType valueOf(String r100) {
            return (ItemType) a.a(ItemType.class, r100);
        }

        private ItemType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_ForwardCommonData extends ProtoAdapter<ForwardCommonData> {
        public ProtoAdapter_ForwardCommonData() {
            super(FieldEncoding.LENGTH_DELIMITED, ForwardCommonData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ForwardCommonData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253626id = 0L;
            r101.title = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_cross_tenant = r102;
            r101.is_cross_with_ka = r102;
            r101.isCrypto = r102;
            r101.subTitle = "";
            r101.item_type = ItemType.ITEM_TYPE_UNKNOWN;
            r101.avatar_key = "";
            r101.timestamp = 0L;
            r101.chat_id = 0L;
            r101.is_meeting = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L28;
            switch(r104) {
                case 1: goto L27;
                case 2: goto L26;
                case 3: goto L25;
                case 4: goto L24;
                case 5: goto L23;
                case 6: goto L22;
                case 7: goto L21;
                case 8: goto L30;
                case 9: goto L16;
                case 10: goto L15;
                case 11: goto L14;
                case 12: goto L13;
                default: goto L6;
            };
        L30:
            r101.item_type = ItemType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            r101.is_meeting = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            r101.chat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            r101.timestamp = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.subTitle = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.isCrypto = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L23:
            r101.is_cross_with_ka = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L24:
            r101.is_cross_tenant = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L25:
            r101.tag_data = TagData.ADAPTER.decode(r100);
            goto L3
        L26:
            r101.title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L27:
            r101.f253626id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L6:
            switch(r104) {
                case 20: goto L12;
                case 21: goto L11;
                case 22: goto L10;
                case 23: goto L9;
                case 24: goto L8;
                default: goto L7;
            };
        L8:
            r101.shieldP2PChatInfo = ShieldP2PChatInfo.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.replyInThread = ReplyInThreadInfo.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.thread = ThreadInfo.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.chatter = ChatterInfo.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.chat = ChatInfo.ADAPTER.decode(r100);
            goto L3
        L7:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L28:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ForwardCommonData r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            int r102 = r101.encodedSizeWithTag(1, r100.f253625id);
            String r103 = r100.title;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            TagData r107 = r100.tag_data;
            if (r107 == null) goto L9;
            int r108 = TagData.ADAPTER.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            Boolean r110 = r100.is_cross_tenant;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            Boolean r113 = r100.is_cross_with_ka;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            Boolean r116 = r100.isCrypto;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.subTitle;
            if (r119 == null) goto L25;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L26:
            int r121 = r118 + r120;
            ItemType r122 = r100.item_type;
            if (r122 == null) goto L29;
            int r123 = ItemType.ADAPTER.encodedSizeWithTag(8, r122);
        L30:
            int r124 = r121 + r123;
            String r125 = r100.avatar_key;
            if (r125 == null) goto L33;
            int r126 = ProtoAdapter.STRING.encodedSizeWithTag(9, r125);
        L34:
            int r127 = r124 + r126;
            Long r128 = r100.timestamp;
            if (r128 == null) goto L37;
            int r129 = r101.encodedSizeWithTag(10, r128);
        L38:
            int r130 = r127 + r129;
            Long r131 = r100.chat_id;
            if (r131 == null) goto L41;
            int r132 = r101.encodedSizeWithTag(11, r131);
        L42:
            int r133 = r130 + r132;
            Boolean r134 = r100.is_meeting;
            if (r134 == null) goto L45;
            int r135 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r134);
        L46:
            int r136 = r133 + r135;
            ChatInfo r137 = r100.chat;
            if (r137 == null) goto L49;
            int r138 = ChatInfo.ADAPTER.encodedSizeWithTag(20, r137);
        L50:
            int r139 = r136 + r138;
            ChatterInfo r140 = r100.chatter;
            if (r140 == null) goto L53;
            int r141 = ChatterInfo.ADAPTER.encodedSizeWithTag(21, r140);
        L54:
            int r142 = r139 + r141;
            ThreadInfo r143 = r100.thread;
            if (r143 == null) goto L57;
            int r144 = ThreadInfo.ADAPTER.encodedSizeWithTag(22, r143);
        L58:
            int r145 = r142 + r144;
            ReplyInThreadInfo r146 = r100.replyInThread;
            if (r146 == null) goto L61;
            int r147 = ReplyInThreadInfo.ADAPTER.encodedSizeWithTag(23, r146);
        L62:
            int r148 = r145 + r147;
            ShieldP2PChatInfo r149 = r100.shieldP2PChatInfo;
            if (r149 == null) goto L66;
            r104 = ShieldP2PChatInfo.ADAPTER.encodedSizeWithTag(24, r149);
        L66:
            return (r148 + r104) + r100.unknownFields().size();
        L61:
            r147 = 0;
            goto L62
        L57:
            r144 = 0;
            goto L58
        L53:
            r141 = 0;
            goto L54
        L49:
            r138 = 0;
            goto L50
        L45:
            r135 = 0;
            goto L46
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
        public /* bridge */ /* synthetic */ ForwardCommonData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ForwardCommonData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ForwardCommonData r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 1, r101.f253625id);
            String r103 = r101.title;
            if (r103 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L5:
            TagData r104 = r101.tag_data;
            if (r104 == null) goto L8;
            TagData.ADAPTER.encodeWithTag(r100, 3, r104);
        L8:
            Boolean r105 = r101.is_cross_tenant;
            if (r105 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L11:
            Boolean r106 = r101.is_cross_with_ka;
            if (r106 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L14:
            Boolean r107 = r101.isCrypto;
            if (r107 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L17:
            String r108 = r101.subTitle;
            if (r108 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L20:
            ItemType r109 = r101.item_type;
            if (r109 == null) goto L23;
            ItemType.ADAPTER.encodeWithTag(r100, 8, r109);
        L23:
            String r110 = r101.avatar_key;
            if (r110 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r110);
        L26:
            Long r111 = r101.timestamp;
            if (r111 == null) goto L29;
            r102.encodeWithTag(r100, 10, r111);
        L29:
            Long r112 = r101.chat_id;
            if (r112 == null) goto L32;
            r102.encodeWithTag(r100, 11, r112);
        L32:
            Boolean r113 = r101.is_meeting;
            if (r113 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r100, 12, r113);
        L35:
            ChatInfo r114 = r101.chat;
            if (r114 == null) goto L38;
            ChatInfo.ADAPTER.encodeWithTag(r100, 20, r114);
        L38:
            ChatterInfo r115 = r101.chatter;
            if (r115 == null) goto L41;
            ChatterInfo.ADAPTER.encodeWithTag(r100, 21, r115);
        L41:
            ThreadInfo r116 = r101.thread;
            if (r116 == null) goto L44;
            ThreadInfo.ADAPTER.encodeWithTag(r100, 22, r116);
        L44:
            ReplyInThreadInfo r117 = r101.replyInThread;
            if (r117 == null) goto L47;
            ReplyInThreadInfo.ADAPTER.encodeWithTag(r100, 23, r117);
        L47:
            ShieldP2PChatInfo r118 = r101.shieldP2PChatInfo;
            if (r118 == null) goto L50;
            ShieldP2PChatInfo.ADAPTER.encodeWithTag(r100, 24, r118);
        L50:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ForwardCommonData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class ReplyInThreadInfo extends Message<ReplyInThreadInfo, Builder> {
        public static final ProtoAdapter<ReplyInThreadInfo> ADAPTER = null;
        public static final Long DEFAULT_P2P_CHATTER_ID = null;
        private static final long serialVersionUID = 0;
        public final Long p2p_chatter_id;

        public static final class Builder extends Message.Builder<ReplyInThreadInfo, Builder> {
            public Long p2p_chatter_id;

            @Override // com.squareup.wire.Message.Builder
            public ReplyInThreadInfo build() {
                return new ReplyInThreadInfo(this.p2p_chatter_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder p2p_chatter_id(Long r100) {
                this.p2p_chatter_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ReplyInThreadInfo extends ProtoAdapter<ReplyInThreadInfo> {
            public ProtoAdapter_ReplyInThreadInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, ReplyInThreadInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ReplyInThreadInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.p2p_chatter_id = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.p2p_chatter_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ReplyInThreadInfo r100) {
                Long r101 = r100.p2p_chatter_id;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ReplyInThreadInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ReplyInThreadInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ReplyInThreadInfo r101) throws IOException {
                Long r102 = r101.p2p_chatter_id;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ReplyInThreadInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ReplyInThreadInfo();
            DEFAULT_P2P_CHATTER_ID = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.p2p_chatter_id = this.p2p_chatter_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ReplyInThreadInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ReplyInThreadInfo(Long r100) {
            this(r100, ByteString.EMPTY);
        }

        public ReplyInThreadInfo(Long r100, ByteString r101) {
            super(ADAPTER, r101);
            this.p2p_chatter_id = r100;
        }
    }

    public static final class ShieldP2PChatInfo extends Message<ShieldP2PChatInfo, Builder> {
        public static final ProtoAdapter<ShieldP2PChatInfo> ADAPTER = null;
        public static final Long DEFAULT_CHATTER_ID = null;
        private static final long serialVersionUID = 0;
        public final Long chatter_id;

        public static final class Builder extends Message.Builder<ShieldP2PChatInfo, Builder> {
            public Long chatter_id;

            @Override // com.squareup.wire.Message.Builder
            public ShieldP2PChatInfo build() {
                Long r100 = this.chatter_id;
                if (r100 == null) goto L7;
                return new ShieldP2PChatInfo(this.chatter_id, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "chatter_id"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder chatter_id(Long r100) {
                this.chatter_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ShieldP2PChatInfo extends ProtoAdapter<ShieldP2PChatInfo> {
            public ProtoAdapter_ShieldP2PChatInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, ShieldP2PChatInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ShieldP2PChatInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.chatter_id = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.chatter_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ShieldP2PChatInfo r100) {
                return ProtoAdapter.INT64.encodedSizeWithTag(1, r100.chatter_id) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ShieldP2PChatInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ShieldP2PChatInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ShieldP2PChatInfo r101) throws IOException {
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.chatter_id);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ShieldP2PChatInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ShieldP2PChatInfo();
            DEFAULT_CHATTER_ID = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.chatter_id = this.chatter_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ShieldP2PChatInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ShieldP2PChatInfo(Long r100) {
            this(r100, ByteString.EMPTY);
        }

        public ShieldP2PChatInfo(Long r100, ByteString r101) {
            super(ADAPTER, r101);
            this.chatter_id = r100;
        }
    }

    public static final class ThreadInfo extends Message<ThreadInfo, Builder> {
        public static final ProtoAdapter<ThreadInfo> ADAPTER = null;
        public static final Boolean DEFAULT_IS_PUBLIC = null;
        private static final long serialVersionUID = 0;
        public final Boolean is_public;

        public static final class Builder extends Message.Builder<ThreadInfo, Builder> {
            public Boolean is_public;

            @Override // com.squareup.wire.Message.Builder
            public ThreadInfo build() {
                return new ThreadInfo(this.is_public, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder is_public(Boolean r100) {
                this.is_public = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ThreadInfo extends ProtoAdapter<ThreadInfo> {
            public ProtoAdapter_ThreadInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, ThreadInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ThreadInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.is_public = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.is_public = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ThreadInfo r100) {
                Boolean r101 = r100.is_public;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ThreadInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ThreadInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ThreadInfo r101) throws IOException {
                Boolean r102 = r101.is_public;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ThreadInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ThreadInfo();
            DEFAULT_IS_PUBLIC = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.is_public = this.is_public;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ThreadInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ThreadInfo(Boolean r100) {
            this(r100, ByteString.EMPTY);
        }

        public ThreadInfo(Boolean r100, ByteString r101) {
            super(ADAPTER, r101);
            this.is_public = r100;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ForwardCommonData();
        DEFAULT_ID = 0L;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_CROSS_TENANT = r100;
        DEFAULT_IS_CROSS_WITH_KA = r100;
        DEFAULT_ISCRYPTO = r100;
        DEFAULT_ITEM_TYPE = ItemType.ITEM_TYPE_UNKNOWN;
        DEFAULT_TIMESTAMP = 0L;
        DEFAULT_CHAT_ID = 0L;
        DEFAULT_IS_MEETING = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253626id = this.f253625id;
        r100.title = this.title;
        r100.tag_data = this.tag_data;
        r100.is_cross_tenant = this.is_cross_tenant;
        r100.is_cross_with_ka = this.is_cross_with_ka;
        r100.isCrypto = this.isCrypto;
        r100.subTitle = this.subTitle;
        r100.item_type = this.item_type;
        r100.avatar_key = this.avatar_key;
        r100.timestamp = this.timestamp;
        r100.chat_id = this.chat_id;
        r100.is_meeting = this.is_meeting;
        r100.chat = this.chat;
        r100.chatter = this.chatter;
        r100.thread = this.thread;
        r100.replyInThread = this.replyInThread;
        r100.shieldP2PChatInfo = this.shieldP2PChatInfo;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ForwardCommonData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ForwardCommonData(Long r210, String r211, TagData r212, Boolean r213, Boolean r214, Boolean r215, String r216, ItemType r217, String r218, Long r219, Long r310, Boolean r311, ChatInfo r312, ChatterInfo r313, ThreadInfo r314, ReplyInThreadInfo r315, ShieldP2PChatInfo r316) {
        this(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, ByteString.EMPTY);
    }

    public ForwardCommonData(Long r100, String r101, TagData r102, Boolean r103, Boolean r104, Boolean r105, String r110, ItemType r111, String r112, Long r113, Long r114, Boolean r115, ChatInfo r116, ChatterInfo r117, ThreadInfo r118, ReplyInThreadInfo r119, ShieldP2PChatInfo r210, ByteString r211) {
        super(ADAPTER, r211);
        this.f253625id = r100;
        this.title = r101;
        this.tag_data = r102;
        this.is_cross_tenant = r103;
        this.is_cross_with_ka = r104;
        this.isCrypto = r105;
        this.subTitle = r110;
        this.item_type = r111;
        this.avatar_key = r112;
        this.timestamp = r113;
        this.chat_id = r114;
        this.is_meeting = r115;
        this.chat = r116;
        this.chatter = r117;
        this.thread = r118;
        this.replyInThread = r119;
        this.shieldP2PChatInfo = r210;
    }
}
