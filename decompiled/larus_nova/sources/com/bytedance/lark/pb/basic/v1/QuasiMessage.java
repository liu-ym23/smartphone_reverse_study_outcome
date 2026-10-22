package com.bytedance.lark.pb.basic.v1;

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
public final class QuasiMessage extends com.squareup.wire.Message<QuasiMessage, Builder> {
    public static final ProtoAdapter<QuasiMessage> ADAPTER = null;
    public static final Long DEFAULT_AI_CHAT_MODE_ID = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_CID = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final Long DEFAULT_CREATE_TIME_US = null;
    public static final String DEFAULT_CRYPTO_TOKEN = "";
    public static final MessageDLPState DEFAULT_DLP_STATE = null;
    public static final String DEFAULT_FROM_ID = "";
    public static final String DEFAULT_ID = "";
    public static final Long DEFAULT_IMAGE_COMPRESSED_SIZE_KB = null;
    public static final Message.ChatDisplayModeSetting DEFAULT_IN_CHAT_DISPLAY_MODE = null;
    public static final Boolean DEFAULT_IS_NEW_TOPIC = null;
    public static final String DEFAULT_PARENT_ID = "";
    public static final String DEFAULT_PARENT_SOURCE_ID = "";
    public static final Integer DEFAULT_POSITION = null;
    public static final Integer DEFAULT_READ_COUNT = null;
    public static final String DEFAULT_ROOT_ID = "";
    public static final String DEFAULT_ROOT_SOURCE_ID = "";
    public static final Boolean DEFAULT_SHOULD_NOTIFY = null;
    public static final Status DEFAULT_STATUS = null;
    public static final Message.SyncToChatMessageType DEFAULT_SYNC_TO_CHAT_MESSAGE_TYPE = null;
    public static final Long DEFAULT_SYNC_TO_CHAT_RELATED_MESSAGE_ID = null;
    public static final Long DEFAULT_SYNC_TO_CHAT_THREAD_ROOT_ID = null;
    public static final String DEFAULT_THREAD_ID = "";
    public static final Integer DEFAULT_THREAD_POSITION = null;
    public static final Message.Type DEFAULT_TYPE = null;
    public static final Integer DEFAULT_UNREAD_COUNT = null;
    public static final Integer DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final Long ai_chat_mode_id;
    public final Channel channel;
    public final String chat_id;
    public final String cid;
    public final Content content;
    public final Long create_time;
    public final Long create_time_us;
    public final String crypto_token;
    public final MessageDLPState dlp_state;
    public final String from_id;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253537id;
    public final Long image_compressed_size_kb;
    public final Message.ChatDisplayModeSetting in_chat_display_mode;
    public final Boolean is_new_topic;
    public final String parent_id;
    public final String parent_source_id;
    public final Message.PartialReplyInfo partial_reply_info;
    public final Integer position;
    public final Integer read_count;
    public final String root_id;
    public final String root_source_id;
    public final SecurityESCReviewExtra security_extra;
    public final Boolean should_notify;
    public final Status status;
    public final Message.SyncToChatMessageType sync_to_chat_message_type;
    public final Long sync_to_chat_related_message_id;
    public final Long sync_to_chat_thread_root_id;
    public final String thread_id;
    public final Integer thread_position;
    public final Message.Type type;
    public final List<String> unread_chatter_ids;
    public final Integer unread_count;
    public final Integer version;

    public static final class Builder extends com.squareup.wire.Message.Builder<QuasiMessage, Builder> {
        public Long ai_chat_mode_id;
        public Channel channel;
        public String chat_id;
        public String cid;
        public Content content;
        public Long create_time;
        public Long create_time_us;
        public String crypto_token;
        public MessageDLPState dlp_state;
        public String from_id;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253538id;
        public Long image_compressed_size_kb;
        public Message.ChatDisplayModeSetting in_chat_display_mode;
        public Boolean is_new_topic;
        public String parent_id;
        public String parent_source_id;
        public Message.PartialReplyInfo partial_reply_info;
        public Integer position;
        public Integer read_count;
        public String root_id;
        public String root_source_id;
        public SecurityESCReviewExtra security_extra;
        public Boolean should_notify;
        public Status status;
        public Message.SyncToChatMessageType sync_to_chat_message_type;
        public Long sync_to_chat_related_message_id;
        public Long sync_to_chat_thread_root_id;
        public String thread_id;
        public Integer thread_position;
        public Message.Type type;
        public List<String> unread_chatter_ids;
        public Integer unread_count;
        public Integer version;

        @Override // com.squareup.wire.Message.Builder
        public QuasiMessage build() {
            String r100 = this.cid;
            if (r100 == null) goto L21;
            if (this.chat_id == null) goto L21;
            if (this.type == null) goto L21;
            if (this.should_notify == null) goto L21;
            if (this.content == null) goto L21;
            if (this.f253538id == null) goto L21;
            if (this.from_id == null) goto L21;
            if (this.create_time == null) goto L21;
            return new QuasiMessage(this.cid, this.chat_id, this.root_id, this.type, this.should_notify, this.position, this.content, this.parent_id, this.parent_source_id, this.root_source_id, this.f253538id, this.from_id, this.create_time, this.unread_count, this.read_count, this.unread_chatter_ids, this.image_compressed_size_kb, this.status, this.version, this.channel, this.thread_id, this.thread_position, this.crypto_token, this.dlp_state, this.in_chat_display_mode, this.security_extra, this.ai_chat_mode_id, this.sync_to_chat_thread_root_id, this.sync_to_chat_message_type, this.sync_to_chat_related_message_id, this.partial_reply_info, this.is_new_topic, this.create_time_us, super.buildUnknownFields());
        L21:
            throw Internal.missingRequiredFields(new Object[]{r100, "cid", this.chat_id, "chat_id", this.type, "type", this.should_notify, "should_notify", this.content, "content", this.f253538id, "id", this.from_id, "from_id", this.create_time, "create_time"});
        }

        public Builder() {
            this.unread_chatter_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder ai_chat_mode_id(Long r100) {
            this.ai_chat_mode_id = r100;
            return this;
        }

        public Builder channel(Channel r100) {
            this.channel = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder cid(String r100) {
            this.cid = r100;
            return this;
        }

        public Builder content(Content r100) {
            this.content = r100;
            return this;
        }

        public Builder create_time(Long r100) {
            this.create_time = r100;
            return this;
        }

        public Builder create_time_us(Long r100) {
            this.create_time_us = r100;
            return this;
        }

        public Builder crypto_token(String r100) {
            this.crypto_token = r100;
            return this;
        }

        public Builder dlp_state(MessageDLPState r100) {
            this.dlp_state = r100;
            return this;
        }

        public Builder from_id(String r100) {
            this.from_id = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253538id = r100;
            return this;
        }

        public Builder image_compressed_size_kb(Long r100) {
            this.image_compressed_size_kb = r100;
            return this;
        }

        public Builder in_chat_display_mode(Message.ChatDisplayModeSetting r100) {
            this.in_chat_display_mode = r100;
            return this;
        }

        public Builder is_new_topic(Boolean r100) {
            this.is_new_topic = r100;
            return this;
        }

        public Builder parent_id(String r100) {
            this.parent_id = r100;
            return this;
        }

        public Builder parent_source_id(String r100) {
            this.parent_source_id = r100;
            return this;
        }

        public Builder partial_reply_info(Message.PartialReplyInfo r100) {
            this.partial_reply_info = r100;
            return this;
        }

        public Builder position(Integer r100) {
            this.position = r100;
            return this;
        }

        public Builder read_count(Integer r100) {
            this.read_count = r100;
            return this;
        }

        public Builder root_id(String r100) {
            this.root_id = r100;
            return this;
        }

        public Builder root_source_id(String r100) {
            this.root_source_id = r100;
            return this;
        }

        public Builder security_extra(SecurityESCReviewExtra r100) {
            this.security_extra = r100;
            return this;
        }

        public Builder should_notify(Boolean r100) {
            this.should_notify = r100;
            return this;
        }

        public Builder status(Status r100) {
            this.status = r100;
            return this;
        }

        public Builder sync_to_chat_message_type(Message.SyncToChatMessageType r100) {
            this.sync_to_chat_message_type = r100;
            return this;
        }

        public Builder sync_to_chat_related_message_id(Long r100) {
            this.sync_to_chat_related_message_id = r100;
            return this;
        }

        public Builder sync_to_chat_thread_root_id(Long r100) {
            this.sync_to_chat_thread_root_id = r100;
            return this;
        }

        public Builder thread_id(String r100) {
            this.thread_id = r100;
            return this;
        }

        public Builder thread_position(Integer r100) {
            this.thread_position = r100;
            return this;
        }

        public Builder type(Message.Type r100) {
            this.type = r100;
            return this;
        }

        public Builder unread_chatter_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.unread_chatter_ids = r100;
            return this;
        }

        public Builder unread_count(Integer r100) {
            this.unread_count = r100;
            return this;
        }

        public Builder version(Integer r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_QuasiMessage extends ProtoAdapter<QuasiMessage> {
        public ProtoAdapter_QuasiMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, QuasiMessage.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public QuasiMessage decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.cid = "";
            r101.chat_id = "";
            r101.root_id = "";
            r101.type = Message.Type.UNKNOWN;
            Boolean r102 = Boolean.FALSE;
            r101.should_notify = r102;
            r101.position = 0;
            r101.parent_id = "";
            r101.parent_source_id = "";
            r101.root_source_id = "";
            r101.f253538id = "";
            r101.from_id = "";
            r101.create_time = 0L;
            r101.unread_count = 0;
            r101.read_count = 1;
            r101.image_compressed_size_kb = 0L;
            r101.status = Status.PENDING;
            r101.version = 0;
            r101.thread_id = "";
            r101.thread_position = 0;
            r101.crypto_token = "";
            r101.dlp_state = MessageDLPState.UNKNOWN_DLP_STATE;
            r101.in_chat_display_mode = Message.ChatDisplayModeSetting.UNKNOWN_DISPLAY_MODE;
            r101.ai_chat_mode_id = 0L;
            r101.sync_to_chat_thread_root_id = 0L;
            r101.sync_to_chat_message_type = Message.SyncToChatMessageType.UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE;
            r101.sync_to_chat_related_message_id = 0L;
            r101.is_new_topic = r102;
            r101.create_time_us = 0L;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L55;
            switch(r104) {
                case 1: goto L54;
                case 2: goto L53;
                case 3: goto L52;
                case 4: goto L61;
                case 5: goto L47;
                case 6: goto L46;
                case 7: goto L45;
                case 8: goto L44;
                case 9: goto L43;
                case 10: goto L42;
                case 11: goto L41;
                case 12: goto L40;
                case 13: goto L39;
                case 14: goto L38;
                case 15: goto L37;
                case 16: goto L36;
                case 17: goto L35;
                case 18: goto L57;
                case 19: goto L30;
                case 20: goto L29;
                case 21: goto L28;
                case 22: goto L27;
                case 23: goto L26;
                case 24: goto L63;
                case 25: goto L65;
                case 26: goto L17;
                case 27: goto L16;
                case 28: goto L15;
                case 29: goto L59;
                case 30: goto L10;
                case 31: goto L9;
                case 32: goto L8;
                case 33: goto L7;
                default: goto L6;
            };
        L57:
            r101.status = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L33
        L33:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L59:
            r101.sync_to_chat_message_type = Message.SyncToChatMessageType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L61:
            r101.type = Message.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L50
        L50:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L63:
            r101.dlp_state = MessageDLPState.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
        L24:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L65:
            r101.in_chat_display_mode = Message.ChatDisplayModeSetting.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.create_time_us = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            r101.is_new_topic = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.partial_reply_info = Message.PartialReplyInfo.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.sync_to_chat_related_message_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            r101.sync_to_chat_thread_root_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            r101.ai_chat_mode_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L17:
            r101.security_extra = SecurityESCReviewExtra.ADAPTER.decode(r100);
            goto L3
        L26:
            r101.crypto_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L27:
            r101.thread_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L28:
            r101.thread_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L29:
            r101.channel = Channel.ADAPTER.decode(r100);
            goto L3
        L30:
            r101.version = ProtoAdapter.INT32.decode(r100);
            goto L3
        L35:
            r101.image_compressed_size_kb = ProtoAdapter.INT64.decode(r100);
            goto L3
        L36:
            r101.unread_chatter_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L37:
            r101.read_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L38:
            r101.unread_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L39:
            r101.create_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L40:
            r101.from_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L41:
            r101.f253538id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L42:
            r101.root_source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L43:
            r101.parent_source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L44:
            r101.parent_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L45:
            r101.content = Content.ADAPTER.decode(r100);
            goto L3
        L46:
            r101.position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L47:
            r101.should_notify = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L52:
            r101.root_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L53:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L54:
            r101.cid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L55:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(QuasiMessage r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.cid) + r101.encodedSizeWithTag(2, r100.chat_id);
            String r103 = r100.root_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(3, r103);
        L6:
            int r106 = (r102 + r105) + Message.Type.ADAPTER.encodedSizeWithTag(4, r100.type);
            ProtoAdapter<Boolean> r107 = ProtoAdapter.BOOL;
            int r108 = r106 + r107.encodedSizeWithTag(5, r100.should_notify);
            Integer r109 = r100.position;
            if (r109 == null) goto L9;
            int r110 = ProtoAdapter.INT32.encodedSizeWithTag(6, r109);
        L10:
            int r111 = (r108 + r110) + Content.ADAPTER.encodedSizeWithTag(7, r100.content);
            String r112 = r100.parent_id;
            if (r112 == null) goto L13;
            int r113 = r101.encodedSizeWithTag(8, r112);
        L14:
            int r114 = r111 + r113;
            String r115 = r100.parent_source_id;
            if (r115 == null) goto L17;
            int r116 = r101.encodedSizeWithTag(9, r115);
        L18:
            int r117 = r114 + r116;
            String r118 = r100.root_source_id;
            if (r118 == null) goto L21;
            int r119 = r101.encodedSizeWithTag(10, r118);
        L22:
            int r120 = ((r117 + r119) + r101.encodedSizeWithTag(11, r100.f253537id)) + r101.encodedSizeWithTag(12, r100.from_id);
            ProtoAdapter<Long> r121 = ProtoAdapter.INT64;
            int r122 = r120 + r121.encodedSizeWithTag(13, r100.create_time);
            Integer r123 = r100.unread_count;
            if (r123 == null) goto L25;
            int r124 = ProtoAdapter.INT32.encodedSizeWithTag(14, r123);
        L26:
            int r125 = r122 + r124;
            Integer r126 = r100.read_count;
            if (r126 == null) goto L29;
            int r127 = ProtoAdapter.INT32.encodedSizeWithTag(15, r126);
        L30:
            int r128 = (r125 + r127) + r101.asRepeated().encodedSizeWithTag(16, r100.unread_chatter_ids);
            Long r129 = r100.image_compressed_size_kb;
            if (r129 == null) goto L33;
            int r130 = r121.encodedSizeWithTag(17, r129);
        L34:
            int r131 = r128 + r130;
            Status r132 = r100.status;
            if (r132 == null) goto L37;
            int r133 = Status.ADAPTER.encodedSizeWithTag(18, r132);
        L38:
            int r134 = r131 + r133;
            Integer r135 = r100.version;
            if (r135 == null) goto L41;
            int r136 = ProtoAdapter.INT32.encodedSizeWithTag(19, r135);
        L42:
            int r137 = r134 + r136;
            Channel r138 = r100.channel;
            if (r138 == null) goto L45;
            int r139 = Channel.ADAPTER.encodedSizeWithTag(20, r138);
        L46:
            int r140 = r137 + r139;
            String r141 = r100.thread_id;
            if (r141 == null) goto L49;
            int r142 = r101.encodedSizeWithTag(21, r141);
        L50:
            int r143 = r140 + r142;
            Integer r144 = r100.thread_position;
            if (r144 == null) goto L53;
            int r145 = ProtoAdapter.INT32.encodedSizeWithTag(22, r144);
        L54:
            int r146 = r143 + r145;
            String r147 = r100.crypto_token;
            if (r147 == null) goto L57;
            int r148 = r101.encodedSizeWithTag(23, r147);
        L58:
            int r149 = r146 + r148;
            MessageDLPState r150 = r100.dlp_state;
            if (r150 == null) goto L61;
            int r151 = MessageDLPState.ADAPTER.encodedSizeWithTag(24, r150);
        L62:
            int r152 = r149 + r151;
            Message.ChatDisplayModeSetting r153 = r100.in_chat_display_mode;
            if (r153 == null) goto L65;
            int r154 = Message.ChatDisplayModeSetting.ADAPTER.encodedSizeWithTag(25, r153);
        L66:
            int r155 = r152 + r154;
            SecurityESCReviewExtra r156 = r100.security_extra;
            if (r156 == null) goto L69;
            int r157 = SecurityESCReviewExtra.ADAPTER.encodedSizeWithTag(26, r156);
        L70:
            int r158 = r155 + r157;
            Long r159 = r100.ai_chat_mode_id;
            if (r159 == null) goto L73;
            int r160 = r121.encodedSizeWithTag(27, r159);
        L74:
            int r161 = r158 + r160;
            Long r162 = r100.sync_to_chat_thread_root_id;
            if (r162 == null) goto L77;
            int r163 = r121.encodedSizeWithTag(28, r162);
        L78:
            int r164 = r161 + r163;
            Message.SyncToChatMessageType r165 = r100.sync_to_chat_message_type;
            if (r165 == null) goto L81;
            int r166 = Message.SyncToChatMessageType.ADAPTER.encodedSizeWithTag(29, r165);
        L82:
            int r167 = r164 + r166;
            Long r168 = r100.sync_to_chat_related_message_id;
            if (r168 == null) goto L85;
            int r169 = r121.encodedSizeWithTag(30, r168);
        L86:
            int r170 = r167 + r169;
            Message.PartialReplyInfo r171 = r100.partial_reply_info;
            if (r171 == null) goto L89;
            int r172 = Message.PartialReplyInfo.ADAPTER.encodedSizeWithTag(31, r171);
        L90:
            int r173 = r170 + r172;
            Boolean r174 = r100.is_new_topic;
            if (r174 == null) goto L93;
            int r175 = r107.encodedSizeWithTag(32, r174);
        L94:
            int r176 = r173 + r175;
            Long r177 = r100.create_time_us;
            if (r177 == null) goto L98;
            r104 = r121.encodedSizeWithTag(33, r177);
        L98:
            return (r176 + r104) + r100.unknownFields().size();
        L93:
            r175 = 0;
            goto L94
        L89:
            r172 = 0;
            goto L90
        L85:
            r169 = 0;
            goto L86
        L81:
            r166 = 0;
            goto L82
        L77:
            r163 = 0;
            goto L78
        L73:
            r160 = 0;
            goto L74
        L69:
            r157 = 0;
            goto L70
        L65:
            r154 = 0;
            goto L66
        L61:
            r151 = 0;
            goto L62
        L57:
            r148 = 0;
            goto L58
        L53:
            r145 = 0;
            goto L54
        L49:
            r142 = 0;
            goto L50
        L45:
            r139 = 0;
            goto L46
        L41:
            r136 = 0;
            goto L42
        L37:
            r133 = 0;
            goto L38
        L33:
            r130 = 0;
            goto L34
        L29:
            r127 = 0;
            goto L30
        L25:
            r124 = 0;
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
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ QuasiMessage decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(QuasiMessage r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, QuasiMessage r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.cid);
            r102.encodeWithTag(r100, 2, r101.chat_id);
            String r103 = r101.root_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            Message.Type.ADAPTER.encodeWithTag(r100, 4, r101.type);
            ProtoAdapter<Boolean> r104 = ProtoAdapter.BOOL;
            r104.encodeWithTag(r100, 5, r101.should_notify);
            Integer r105 = r101.position;
            if (r105 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r105);
        L8:
            Content.ADAPTER.encodeWithTag(r100, 7, r101.content);
            String r106 = r101.parent_id;
            if (r106 == null) goto L11;
            r102.encodeWithTag(r100, 8, r106);
        L11:
            String r107 = r101.parent_source_id;
            if (r107 == null) goto L14;
            r102.encodeWithTag(r100, 9, r107);
        L14:
            String r108 = r101.root_source_id;
            if (r108 == null) goto L17;
            r102.encodeWithTag(r100, 10, r108);
        L17:
            r102.encodeWithTag(r100, 11, r101.f253537id);
            r102.encodeWithTag(r100, 12, r101.from_id);
            ProtoAdapter<Long> r109 = ProtoAdapter.INT64;
            r109.encodeWithTag(r100, 13, r101.create_time);
            Integer r110 = r101.unread_count;
            if (r110 == null) goto L20;
            ProtoAdapter.INT32.encodeWithTag(r100, 14, r110);
        L20:
            Integer r111 = r101.read_count;
            if (r111 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r100, 15, r111);
        L23:
            r102.asRepeated().encodeWithTag(r100, 16, r101.unread_chatter_ids);
            Long r112 = r101.image_compressed_size_kb;
            if (r112 == null) goto L26;
            r109.encodeWithTag(r100, 17, r112);
        L26:
            Status r113 = r101.status;
            if (r113 == null) goto L29;
            Status.ADAPTER.encodeWithTag(r100, 18, r113);
        L29:
            Integer r114 = r101.version;
            if (r114 == null) goto L32;
            ProtoAdapter.INT32.encodeWithTag(r100, 19, r114);
        L32:
            Channel r115 = r101.channel;
            if (r115 == null) goto L35;
            Channel.ADAPTER.encodeWithTag(r100, 20, r115);
        L35:
            String r116 = r101.thread_id;
            if (r116 == null) goto L38;
            r102.encodeWithTag(r100, 21, r116);
        L38:
            Integer r117 = r101.thread_position;
            if (r117 == null) goto L41;
            ProtoAdapter.INT32.encodeWithTag(r100, 22, r117);
        L41:
            String r118 = r101.crypto_token;
            if (r118 == null) goto L44;
            r102.encodeWithTag(r100, 23, r118);
        L44:
            MessageDLPState r119 = r101.dlp_state;
            if (r119 == null) goto L47;
            MessageDLPState.ADAPTER.encodeWithTag(r100, 24, r119);
        L47:
            Message.ChatDisplayModeSetting r120 = r101.in_chat_display_mode;
            if (r120 == null) goto L50;
            Message.ChatDisplayModeSetting.ADAPTER.encodeWithTag(r100, 25, r120);
        L50:
            SecurityESCReviewExtra r121 = r101.security_extra;
            if (r121 == null) goto L53;
            SecurityESCReviewExtra.ADAPTER.encodeWithTag(r100, 26, r121);
        L53:
            Long r122 = r101.ai_chat_mode_id;
            if (r122 == null) goto L56;
            r109.encodeWithTag(r100, 27, r122);
        L56:
            Long r123 = r101.sync_to_chat_thread_root_id;
            if (r123 == null) goto L59;
            r109.encodeWithTag(r100, 28, r123);
        L59:
            Message.SyncToChatMessageType r124 = r101.sync_to_chat_message_type;
            if (r124 == null) goto L62;
            Message.SyncToChatMessageType.ADAPTER.encodeWithTag(r100, 29, r124);
        L62:
            Long r125 = r101.sync_to_chat_related_message_id;
            if (r125 == null) goto L65;
            r109.encodeWithTag(r100, 30, r125);
        L65:
            Message.PartialReplyInfo r126 = r101.partial_reply_info;
            if (r126 == null) goto L68;
            Message.PartialReplyInfo.ADAPTER.encodeWithTag(r100, 31, r126);
        L68:
            Boolean r127 = r101.is_new_topic;
            if (r127 == null) goto L71;
            r104.encodeWithTag(r100, 32, r127);
        L71:
            Long r128 = r101.create_time_us;
            if (r128 == null) goto L74;
            r109.encodeWithTag(r100, 33, r128);
        L74:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, QuasiMessage r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status FAILED = null;
        public static final Status PENDING = null;
        private final int value;

        static {
            Status r100 = new Status("PENDING", 0, 1);
            PENDING = r100;
            Status r101 = new Status("FAILED", 1, 2);
            FAILED = r101;
            $VALUES = new Status[]{r100, r101};
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
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return FAILED;
        L11:
            return PENDING;
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
        ADAPTER = new ProtoAdapter_QuasiMessage();
        DEFAULT_TYPE = Message.Type.UNKNOWN;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_SHOULD_NOTIFY = r100;
        DEFAULT_POSITION = 0;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_UNREAD_COUNT = 0;
        DEFAULT_READ_COUNT = 1;
        DEFAULT_IMAGE_COMPRESSED_SIZE_KB = 0L;
        DEFAULT_STATUS = Status.PENDING;
        DEFAULT_VERSION = 0;
        DEFAULT_THREAD_POSITION = 0;
        DEFAULT_DLP_STATE = MessageDLPState.UNKNOWN_DLP_STATE;
        DEFAULT_IN_CHAT_DISPLAY_MODE = Message.ChatDisplayModeSetting.UNKNOWN_DISPLAY_MODE;
        DEFAULT_AI_CHAT_MODE_ID = 0L;
        DEFAULT_SYNC_TO_CHAT_THREAD_ROOT_ID = 0L;
        DEFAULT_SYNC_TO_CHAT_MESSAGE_TYPE = Message.SyncToChatMessageType.UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE;
        DEFAULT_SYNC_TO_CHAT_RELATED_MESSAGE_ID = 0L;
        DEFAULT_IS_NEW_TOPIC = r100;
        DEFAULT_CREATE_TIME_US = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.cid = this.cid;
        r100.chat_id = this.chat_id;
        r100.root_id = this.root_id;
        r100.type = this.type;
        r100.should_notify = this.should_notify;
        r100.position = this.position;
        r100.content = this.content;
        r100.parent_id = this.parent_id;
        r100.parent_source_id = this.parent_source_id;
        r100.root_source_id = this.root_source_id;
        r100.f253538id = this.f253537id;
        r100.from_id = this.from_id;
        r100.create_time = this.create_time;
        r100.unread_count = this.unread_count;
        r100.read_count = this.read_count;
        r100.unread_chatter_ids = Internal.copyOf("unread_chatter_ids", this.unread_chatter_ids);
        r100.image_compressed_size_kb = this.image_compressed_size_kb;
        r100.status = this.status;
        r100.version = this.version;
        r100.channel = this.channel;
        r100.thread_id = this.thread_id;
        r100.thread_position = this.thread_position;
        r100.crypto_token = this.crypto_token;
        r100.dlp_state = this.dlp_state;
        r100.in_chat_display_mode = this.in_chat_display_mode;
        r100.security_extra = this.security_extra;
        r100.ai_chat_mode_id = this.ai_chat_mode_id;
        r100.sync_to_chat_thread_root_id = this.sync_to_chat_thread_root_id;
        r100.sync_to_chat_message_type = this.sync_to_chat_message_type;
        r100.sync_to_chat_related_message_id = this.sync_to_chat_related_message_id;
        r100.partial_reply_info = this.partial_reply_info;
        r100.is_new_topic = this.is_new_topic;
        r100.create_time_us = this.create_time_us;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return QuasiMessage.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public QuasiMessage(String r310, String r311, String r312, Message.Type r313, Boolean r410, Integer r411, Content r412, String r413, String r414, String r415, String r416, String r417, Long r418, Integer r419, Integer r510, List<String> r511, Long r512, Status r513, Integer r514, Channel r515, String r516, Integer r517, String r518, MessageDLPState r519, Message.ChatDisplayModeSetting r610, SecurityESCReviewExtra r611, Long r612, Long r613, Message.SyncToChatMessageType r614, Long r615, Message.PartialReplyInfo r616, Boolean r617, Long r618) {
        this(r310, r311, r312, r313, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, ByteString.EMPTY);
    }

    public QuasiMessage(String r100, String r101, String r102, Message.Type r103, Boolean r104, Integer r105, Content r110, String r111, String r112, String r113, String r114, String r115, Long r116, Integer r117, Integer r118, List<String> r119, Long r210, Status r211, Integer r212, Channel r213, String r214, Integer r215, String r216, MessageDLPState r217, Message.ChatDisplayModeSetting r218, SecurityESCReviewExtra r219, Long r310, Long r311, Message.SyncToChatMessageType r312, Long r313, Message.PartialReplyInfo r314, Boolean r315, Long r316, ByteString r317) {
        super(ADAPTER, r317);
        this.cid = r100;
        this.chat_id = r101;
        this.root_id = r102;
        this.type = r103;
        this.should_notify = r104;
        this.position = r105;
        this.content = r110;
        this.parent_id = r111;
        this.parent_source_id = r112;
        this.root_source_id = r113;
        this.f253537id = r114;
        this.from_id = r115;
        this.create_time = r116;
        this.unread_count = r117;
        this.read_count = r118;
        this.unread_chatter_ids = Internal.immutableCopyOf("unread_chatter_ids", r119);
        this.image_compressed_size_kb = r210;
        this.status = r211;
        this.version = r212;
        this.channel = r213;
        this.thread_id = r214;
        this.thread_position = r215;
        this.crypto_token = r216;
        this.dlp_state = r217;
        this.in_chat_display_mode = r218;
        this.security_extra = r219;
        this.ai_chat_mode_id = r310;
        this.sync_to_chat_thread_root_id = r311;
        this.sync_to_chat_message_type = r312;
        this.sync_to_chat_related_message_id = r313;
        this.partial_reply_info = r314;
        this.is_new_topic = r315;
        this.create_time_us = r316;
    }
}
