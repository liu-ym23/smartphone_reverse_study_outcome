package com.bytedance.lark.pb.basic.v1;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class MessageData extends com.squareup.wire.Message<MessageData, Builder> {
    public static final ProtoAdapter<MessageData> ADAPTER = null;
    public static final String DEFAULT_APP_ID = "";
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_AVATAR_PATH = "";
    public static final String DEFAULT_CHANNEL_NAME = "";
    public static final Integer DEFAULT_CHANNEL_THREAD_POSITION = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Chat.ChatMode DEFAULT_CHAT_MODE = null;
    public static final Chat.Type DEFAULT_CHAT_TYPE = null;
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_FROM_CHATTER_ID = "";
    public static final String DEFAULT_FROM_CHATTER_NAME = "";
    public static final Boolean DEFAULT_IS_BOT = null;
    public static final Boolean DEFAULT_IS_CRYPTO = null;
    public static final Boolean DEFAULT_IS_FOLLOWED = null;
    public static final Boolean DEFAULT_IS_ON_TIME_DEL = null;
    public static final Boolean DEFAULT_IS_SHOW_DETAIL = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final Boolean DEFAULT_ME_READ = null;
    public static final Integer DEFAULT_NEW_MESSAGE_COUNT = null;
    public static final Boolean DEFAULT_NOT_COMM_NOTIFICATION = null;
    public static final String DEFAULT_OPEN_APP_CHAT_FEED_ID = "";
    public static final Integer DEFAULT_POSITION = null;
    public static final Integer DEFAULT_QUICK_REPLY_CATEGORY = null;
    public static final String DEFAULT_RECALLER_ID = "";
    public static final Message.RecallerIdentity DEFAULT_RECALLER_IDENTITY = null;
    public static final String DEFAULT_RECALLER_NAME = "";
    public static final String DEFAULT_SOUND_URL = "default";
    public static final Long DEFAULT_TARGET_USER_ID = null;
    public static final String DEFAULT_THREAD_ID = "";
    public static final Integer DEFAULT_THREAD_MESSAGE_POSITION = null;
    public static final Message.ThreadMessageType DEFAULT_THREAD_MESSAGE_TYPE = null;
    public static final Type DEFAULT_TYPE = null;
    public static final String DEFAULT_UNIT_KEY = "";
    public static final String DEFAULT_URGENT_ID = "";
    private static final long serialVersionUID = 0;
    public final String app_id;
    public final String avatar_key;
    public final String avatar_path;
    public final Channel channel;
    public final String channel_name;
    public final Integer channel_thread_position;
    public final String chat_id;
    public final Chat.ChatMode chat_mode;
    public final Chat.Type chat_type;
    public final Long create_time;
    public final String from_chatter_id;
    public final String from_chatter_name;
    public final List<String> image_urls;
    public final Boolean is_bot;
    public final Boolean is_crypto;
    public final Boolean is_followed;
    public final Boolean is_on_time_del;
    public final Boolean is_show_detail;
    public final Boolean me_read;
    public final String message_id;
    public final Integer new_message_count;
    public final Boolean not_comm_notification;
    public final String open_app_chat_feed_id;
    public final Integer position;
    public final Integer quick_reply_category;
    public final String recaller_id;
    public final Message.RecallerIdentity recaller_identity;
    public final String recaller_name;
    public final String sound_url;
    public final Long target_user_id;
    public final String thread_id;
    public final Integer thread_message_position;
    public final Message.ThreadMessageType thread_message_type;
    public final Type type;
    public final String unit_key;
    public final String urgent_id;

    public static final class Builder extends com.squareup.wire.Message.Builder<MessageData, Builder> {
        public String app_id;
        public String avatar_key;
        public String avatar_path;
        public Channel channel;
        public String channel_name;
        public Integer channel_thread_position;
        public String chat_id;
        public Chat.ChatMode chat_mode;
        public Chat.Type chat_type;
        public Long create_time;
        public String from_chatter_id;
        public String from_chatter_name;
        public List<String> image_urls;
        public Boolean is_bot;
        public Boolean is_crypto;
        public Boolean is_followed;
        public Boolean is_on_time_del;
        public Boolean is_show_detail;
        public Boolean me_read;
        public String message_id;
        public Integer new_message_count;
        public Boolean not_comm_notification;
        public String open_app_chat_feed_id;
        public Integer position;
        public Integer quick_reply_category;
        public String recaller_id;
        public Message.RecallerIdentity recaller_identity;
        public String recaller_name;
        public String sound_url;
        public Long target_user_id;
        public String thread_id;
        public Integer thread_message_position;
        public Message.ThreadMessageType thread_message_type;
        public Type type;
        public String unit_key;
        public String urgent_id;

        @Override // com.squareup.wire.Message.Builder
        public MessageData build() {
            Type r100 = this.type;
            if (r100 == null) goto L7;
            return new MessageData(this.urgent_id, this.message_id, this.position, this.recaller_id, this.type, this.channel, this.chat_id, this.chat_type, this.chat_mode, this.is_crypto, this.new_message_count, this.avatar_key, this.avatar_path, this.thread_message_position, this.from_chatter_id, this.image_urls, this.is_followed, this.thread_id, this.channel_thread_position, this.create_time, this.me_read, this.app_id, this.open_app_chat_feed_id, this.is_bot, this.is_on_time_del, this.quick_reply_category, this.not_comm_notification, this.from_chatter_name, this.channel_name, this.sound_url, this.target_user_id, this.is_show_detail, this.recaller_name, this.recaller_identity, this.thread_message_type, this.unit_key, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "type"});
        }

        public Builder() {
            this.image_urls = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder app_id(String r100) {
            this.app_id = r100;
            return this;
        }

        public Builder avatar_key(String r100) {
            this.avatar_key = r100;
            return this;
        }

        public Builder avatar_path(String r100) {
            this.avatar_path = r100;
            return this;
        }

        public Builder channel(Channel r100) {
            this.channel = r100;
            return this;
        }

        public Builder channel_name(String r100) {
            this.channel_name = r100;
            return this;
        }

        public Builder channel_thread_position(Integer r100) {
            this.channel_thread_position = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder chat_mode(Chat.ChatMode r100) {
            this.chat_mode = r100;
            return this;
        }

        public Builder chat_type(Chat.Type r100) {
            this.chat_type = r100;
            return this;
        }

        public Builder create_time(Long r100) {
            this.create_time = r100;
            return this;
        }

        public Builder from_chatter_id(String r100) {
            this.from_chatter_id = r100;
            return this;
        }

        public Builder from_chatter_name(String r100) {
            this.from_chatter_name = r100;
            return this;
        }

        public Builder image_urls(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.image_urls = r100;
            return this;
        }

        public Builder is_bot(Boolean r100) {
            this.is_bot = r100;
            return this;
        }

        public Builder is_crypto(Boolean r100) {
            this.is_crypto = r100;
            return this;
        }

        public Builder is_followed(Boolean r100) {
            this.is_followed = r100;
            return this;
        }

        public Builder is_on_time_del(Boolean r100) {
            this.is_on_time_del = r100;
            return this;
        }

        public Builder is_show_detail(Boolean r100) {
            this.is_show_detail = r100;
            return this;
        }

        public Builder me_read(Boolean r100) {
            this.me_read = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder new_message_count(Integer r100) {
            this.new_message_count = r100;
            return this;
        }

        public Builder not_comm_notification(Boolean r100) {
            this.not_comm_notification = r100;
            return this;
        }

        public Builder open_app_chat_feed_id(String r100) {
            this.open_app_chat_feed_id = r100;
            return this;
        }

        public Builder position(Integer r100) {
            this.position = r100;
            return this;
        }

        public Builder quick_reply_category(Integer r100) {
            this.quick_reply_category = r100;
            return this;
        }

        public Builder recaller_id(String r100) {
            this.recaller_id = r100;
            return this;
        }

        public Builder recaller_identity(Message.RecallerIdentity r100) {
            this.recaller_identity = r100;
            return this;
        }

        public Builder recaller_name(String r100) {
            this.recaller_name = r100;
            return this;
        }

        public Builder sound_url(String r100) {
            this.sound_url = r100;
            return this;
        }

        public Builder target_user_id(Long r100) {
            this.target_user_id = r100;
            return this;
        }

        public Builder thread_id(String r100) {
            this.thread_id = r100;
            return this;
        }

        public Builder thread_message_position(Integer r100) {
            this.thread_message_position = r100;
            return this;
        }

        public Builder thread_message_type(Message.ThreadMessageType r100) {
            this.thread_message_type = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }

        public Builder unit_key(String r100) {
            this.unit_key = r100;
            return this;
        }

        public Builder urgent_id(String r100) {
            this.urgent_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MessageData extends ProtoAdapter<MessageData> {
        public ProtoAdapter_MessageData() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MessageData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.urgent_id = "";
            r101.message_id = "";
            r101.position = 0;
            r101.recaller_id = "";
            r101.type = Type.NORMAL;
            r101.chat_id = "";
            r101.chat_type = Chat.Type.P2P;
            r101.chat_mode = Chat.ChatMode.UNKNOWN;
            Boolean r102 = Boolean.FALSE;
            r101.is_crypto = r102;
            r101.new_message_count = 0;
            r101.avatar_key = "";
            r101.avatar_path = "";
            r101.thread_message_position = 0;
            r101.from_chatter_id = "";
            r101.is_followed = r102;
            r101.thread_id = "";
            r101.channel_thread_position = 0;
            r101.create_time = 0L;
            r101.me_read = r102;
            r101.app_id = "";
            r101.open_app_chat_feed_id = "";
            r101.is_bot = r102;
            r101.is_on_time_del = r102;
            r101.quick_reply_category = 0;
            r101.not_comm_notification = r102;
            r101.from_chatter_name = "";
            r101.channel_name = "";
            r101.sound_url = "default";
            r101.target_user_id = 0L;
            r101.is_show_detail = r102;
            r101.recaller_name = "";
            r101.recaller_identity = Message.RecallerIdentity.UNKNOWN_IDENTITY;
            r101.thread_message_type = Message.ThreadMessageType.UNKNOWN_THREAD_MESSAGE;
            r101.unit_key = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L58;
            switch(r104) {
                case 1: goto L57;
                case 2: goto L56;
                case 3: goto L55;
                case 4: goto L54;
                case 5: goto L66;
                case 6: goto L49;
                case 7: goto L48;
                case 8: goto L62;
                case 9: goto L64;
                case 10: goto L39;
                case 11: goto L38;
                case 12: goto L37;
                case 13: goto L36;
                case 14: goto L35;
                case 15: goto L34;
                case 16: goto L33;
                case 17: goto L32;
                case 18: goto L31;
                case 19: goto L30;
                case 20: goto L29;
                case 21: goto L28;
                case 22: goto L27;
                case 23: goto L26;
                case 24: goto L25;
                case 25: goto L24;
                case 26: goto L23;
                case 27: goto L22;
                case 28: goto L21;
                case 29: goto L20;
                case 30: goto L19;
                case 31: goto L18;
                case 32: goto L17;
                case 33: goto L16;
                case 34: goto L60;
                case 35: goto L68;
                case 36: goto L7;
                default: goto L6;
            };
        L60:
            r101.recaller_identity = Message.RecallerIdentity.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L62:
            r101.chat_type = Chat.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L46
        L46:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L64:
            r101.chat_mode = Chat.ChatMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L42
        L42:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L66:
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L52
        L52:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L68:
            r101.thread_message_type = Message.ThreadMessageType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.unit_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.recaller_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.is_show_detail = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L18:
            r101.target_user_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L19:
            r101.sound_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.channel_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.from_chatter_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.not_comm_notification = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L23:
            r101.quick_reply_category = ProtoAdapter.INT32.decode(r100);
            goto L3
        L24:
            r101.is_on_time_del = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L25:
            r101.is_bot = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L26:
            r101.open_app_chat_feed_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L27:
            r101.app_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L28:
            r101.me_read = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L29:
            r101.create_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L30:
            r101.channel_thread_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L31:
            r101.thread_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L32:
            r101.is_followed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L33:
            r101.image_urls.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L34:
            r101.from_chatter_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L35:
            r101.thread_message_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L36:
            r101.avatar_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L37:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L38:
            r101.new_message_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L39:
            r101.is_crypto = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L48:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L49:
            r101.channel = Channel.ADAPTER.decode(r100);
            goto L3
        L54:
            r101.recaller_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L55:
            r101.position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L56:
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L57:
            r101.urgent_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L58:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MessageData r100) {
            String r101 = r100.urgent_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.message_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.position;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.recaller_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = (r109 + r111) + Type.ADAPTER.encodedSizeWithTag(5, r100.type);
            Channel r113 = r100.channel;
            if (r113 == null) goto L21;
            int r114 = Channel.ADAPTER.encodedSizeWithTag(6, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.chat_id;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(7, r116);
        L26:
            int r118 = r115 + r117;
            Chat.Type r119 = r100.chat_type;
            if (r119 == null) goto L29;
            int r120 = Chat.Type.ADAPTER.encodedSizeWithTag(8, r119);
        L30:
            int r121 = r118 + r120;
            Chat.ChatMode r122 = r100.chat_mode;
            if (r122 == null) goto L33;
            int r123 = Chat.ChatMode.ADAPTER.encodedSizeWithTag(9, r122);
        L34:
            int r124 = r121 + r123;
            Boolean r125 = r100.is_crypto;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r125);
        L38:
            int r127 = r124 + r126;
            Integer r128 = r100.new_message_count;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.INT32.encodedSizeWithTag(11, r128);
        L42:
            int r130 = r127 + r129;
            String r131 = r100.avatar_key;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.STRING.encodedSizeWithTag(12, r131);
        L46:
            int r133 = r130 + r132;
            String r134 = r100.avatar_path;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.STRING.encodedSizeWithTag(13, r134);
        L50:
            int r136 = r133 + r135;
            Integer r137 = r100.thread_message_position;
            if (r137 == null) goto L53;
            int r138 = ProtoAdapter.INT32.encodedSizeWithTag(14, r137);
        L54:
            int r139 = r136 + r138;
            String r140 = r100.from_chatter_id;
            if (r140 == null) goto L57;
            int r141 = ProtoAdapter.STRING.encodedSizeWithTag(15, r140);
        L58:
            int r142 = r139 + r141;
            ProtoAdapter<String> r143 = ProtoAdapter.STRING;
            int r144 = r142 + r143.asRepeated().encodedSizeWithTag(16, r100.image_urls);
            Boolean r145 = r100.is_followed;
            if (r145 == null) goto L61;
            int r146 = ProtoAdapter.BOOL.encodedSizeWithTag(17, r145);
        L62:
            int r147 = r144 + r146;
            String r148 = r100.thread_id;
            if (r148 == null) goto L65;
            int r149 = r143.encodedSizeWithTag(18, r148);
        L66:
            int r150 = r147 + r149;
            Integer r151 = r100.channel_thread_position;
            if (r151 == null) goto L69;
            int r152 = ProtoAdapter.INT32.encodedSizeWithTag(19, r151);
        L70:
            int r153 = r150 + r152;
            Long r154 = r100.create_time;
            if (r154 == null) goto L73;
            int r155 = ProtoAdapter.INT64.encodedSizeWithTag(20, r154);
        L74:
            int r156 = r153 + r155;
            Boolean r157 = r100.me_read;
            if (r157 == null) goto L77;
            int r158 = ProtoAdapter.BOOL.encodedSizeWithTag(21, r157);
        L78:
            int r159 = r156 + r158;
            String r160 = r100.app_id;
            if (r160 == null) goto L81;
            int r161 = r143.encodedSizeWithTag(22, r160);
        L82:
            int r162 = r159 + r161;
            String r163 = r100.open_app_chat_feed_id;
            if (r163 == null) goto L85;
            int r164 = r143.encodedSizeWithTag(23, r163);
        L86:
            int r165 = r162 + r164;
            Boolean r166 = r100.is_bot;
            if (r166 == null) goto L89;
            int r167 = ProtoAdapter.BOOL.encodedSizeWithTag(24, r166);
        L90:
            int r168 = r165 + r167;
            Boolean r169 = r100.is_on_time_del;
            if (r169 == null) goto L93;
            int r170 = ProtoAdapter.BOOL.encodedSizeWithTag(25, r169);
        L94:
            int r171 = r168 + r170;
            Integer r172 = r100.quick_reply_category;
            if (r172 == null) goto L97;
            int r173 = ProtoAdapter.INT32.encodedSizeWithTag(26, r172);
        L98:
            int r174 = r171 + r173;
            Boolean r175 = r100.not_comm_notification;
            if (r175 == null) goto L101;
            int r176 = ProtoAdapter.BOOL.encodedSizeWithTag(27, r175);
        L102:
            int r177 = r174 + r176;
            String r178 = r100.from_chatter_name;
            if (r178 == null) goto L105;
            int r179 = r143.encodedSizeWithTag(28, r178);
        L106:
            int r180 = r177 + r179;
            String r181 = r100.channel_name;
            if (r181 == null) goto L109;
            int r182 = r143.encodedSizeWithTag(29, r181);
        L110:
            int r183 = r180 + r182;
            String r184 = r100.sound_url;
            if (r184 == null) goto L113;
            int r185 = r143.encodedSizeWithTag(30, r184);
        L114:
            int r186 = r183 + r185;
            Long r187 = r100.target_user_id;
            if (r187 == null) goto L117;
            int r188 = ProtoAdapter.INT64.encodedSizeWithTag(31, r187);
        L118:
            int r189 = r186 + r188;
            Boolean r190 = r100.is_show_detail;
            if (r190 == null) goto L121;
            int r191 = ProtoAdapter.BOOL.encodedSizeWithTag(32, r190);
        L122:
            int r192 = r189 + r191;
            String r193 = r100.recaller_name;
            if (r193 == null) goto L125;
            int r194 = r143.encodedSizeWithTag(33, r193);
        L126:
            int r195 = r192 + r194;
            Message.RecallerIdentity r196 = r100.recaller_identity;
            if (r196 == null) goto L129;
            int r197 = Message.RecallerIdentity.ADAPTER.encodedSizeWithTag(34, r196);
        L130:
            int r198 = r195 + r197;
            Message.ThreadMessageType r199 = r100.thread_message_type;
            if (r199 == null) goto L133;
            int r200 = Message.ThreadMessageType.ADAPTER.encodedSizeWithTag(35, r199);
        L134:
            int r201 = r198 + r200;
            String r202 = r100.unit_key;
            if (r202 == null) goto L138;
            r102 = r143.encodedSizeWithTag(36, r202);
        L138:
            return (r201 + r102) + r100.unknownFields().size();
        L133:
            r200 = 0;
            goto L134
        L129:
            r197 = 0;
            goto L130
        L125:
            r194 = 0;
            goto L126
        L121:
            r191 = 0;
            goto L122
        L117:
            r188 = 0;
            goto L118
        L113:
            r185 = 0;
            goto L114
        L109:
            r182 = 0;
            goto L110
        L105:
            r179 = 0;
            goto L106
        L101:
            r176 = 0;
            goto L102
        L97:
            r173 = 0;
            goto L98
        L93:
            r170 = 0;
            goto L94
        L89:
            r167 = 0;
            goto L90
        L85:
            r164 = 0;
            goto L86
        L81:
            r161 = 0;
            goto L82
        L77:
            r158 = 0;
            goto L78
        L73:
            r155 = 0;
            goto L74
        L69:
            r152 = 0;
            goto L70
        L65:
            r149 = 0;
            goto L66
        L61:
            r146 = 0;
            goto L62
        L57:
            r141 = 0;
            goto L58
        L53:
            r138 = 0;
            goto L54
        L49:
            r135 = 0;
            goto L50
        L45:
            r132 = 0;
            goto L46
        L41:
            r129 = 0;
            goto L42
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MessageData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MessageData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MessageData r101) throws IOException {
            String r102 = r101.urgent_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.message_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.position;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.recaller_id;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Type.ADAPTER.encodeWithTag(r100, 5, r101.type);
            Channel r106 = r101.channel;
            if (r106 == null) goto L17;
            Channel.ADAPTER.encodeWithTag(r100, 6, r106);
        L17:
            String r107 = r101.chat_id;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r107);
        L20:
            Chat.Type r108 = r101.chat_type;
            if (r108 == null) goto L23;
            Chat.Type.ADAPTER.encodeWithTag(r100, 8, r108);
        L23:
            Chat.ChatMode r109 = r101.chat_mode;
            if (r109 == null) goto L26;
            Chat.ChatMode.ADAPTER.encodeWithTag(r100, 9, r109);
        L26:
            Boolean r110 = r101.is_crypto;
            if (r110 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 10, r110);
        L29:
            Integer r111 = r101.new_message_count;
            if (r111 == null) goto L32;
            ProtoAdapter.INT32.encodeWithTag(r100, 11, r111);
        L32:
            String r112 = r101.avatar_key;
            if (r112 == null) goto L35;
            ProtoAdapter.STRING.encodeWithTag(r100, 12, r112);
        L35:
            String r113 = r101.avatar_path;
            if (r113 == null) goto L38;
            ProtoAdapter.STRING.encodeWithTag(r100, 13, r113);
        L38:
            Integer r114 = r101.thread_message_position;
            if (r114 == null) goto L41;
            ProtoAdapter.INT32.encodeWithTag(r100, 14, r114);
        L41:
            String r115 = r101.from_chatter_id;
            if (r115 == null) goto L44;
            ProtoAdapter.STRING.encodeWithTag(r100, 15, r115);
        L44:
            ProtoAdapter<String> r116 = ProtoAdapter.STRING;
            r116.asRepeated().encodeWithTag(r100, 16, r101.image_urls);
            Boolean r117 = r101.is_followed;
            if (r117 == null) goto L47;
            ProtoAdapter.BOOL.encodeWithTag(r100, 17, r117);
        L47:
            String r118 = r101.thread_id;
            if (r118 == null) goto L50;
            r116.encodeWithTag(r100, 18, r118);
        L50:
            Integer r119 = r101.channel_thread_position;
            if (r119 == null) goto L53;
            ProtoAdapter.INT32.encodeWithTag(r100, 19, r119);
        L53:
            Long r120 = r101.create_time;
            if (r120 == null) goto L56;
            ProtoAdapter.INT64.encodeWithTag(r100, 20, r120);
        L56:
            Boolean r121 = r101.me_read;
            if (r121 == null) goto L59;
            ProtoAdapter.BOOL.encodeWithTag(r100, 21, r121);
        L59:
            String r122 = r101.app_id;
            if (r122 == null) goto L62;
            r116.encodeWithTag(r100, 22, r122);
        L62:
            String r123 = r101.open_app_chat_feed_id;
            if (r123 == null) goto L65;
            r116.encodeWithTag(r100, 23, r123);
        L65:
            Boolean r124 = r101.is_bot;
            if (r124 == null) goto L68;
            ProtoAdapter.BOOL.encodeWithTag(r100, 24, r124);
        L68:
            Boolean r125 = r101.is_on_time_del;
            if (r125 == null) goto L71;
            ProtoAdapter.BOOL.encodeWithTag(r100, 25, r125);
        L71:
            Integer r126 = r101.quick_reply_category;
            if (r126 == null) goto L74;
            ProtoAdapter.INT32.encodeWithTag(r100, 26, r126);
        L74:
            Boolean r127 = r101.not_comm_notification;
            if (r127 == null) goto L77;
            ProtoAdapter.BOOL.encodeWithTag(r100, 27, r127);
        L77:
            String r128 = r101.from_chatter_name;
            if (r128 == null) goto L80;
            r116.encodeWithTag(r100, 28, r128);
        L80:
            String r129 = r101.channel_name;
            if (r129 == null) goto L83;
            r116.encodeWithTag(r100, 29, r129);
        L83:
            String r130 = r101.sound_url;
            if (r130 == null) goto L86;
            r116.encodeWithTag(r100, 30, r130);
        L86:
            Long r131 = r101.target_user_id;
            if (r131 == null) goto L89;
            ProtoAdapter.INT64.encodeWithTag(r100, 31, r131);
        L89:
            Boolean r132 = r101.is_show_detail;
            if (r132 == null) goto L92;
            ProtoAdapter.BOOL.encodeWithTag(r100, 32, r132);
        L92:
            String r133 = r101.recaller_name;
            if (r133 == null) goto L95;
            r116.encodeWithTag(r100, 33, r133);
        L95:
            Message.RecallerIdentity r134 = r101.recaller_identity;
            if (r134 == null) goto L98;
            Message.RecallerIdentity.ADAPTER.encodeWithTag(r100, 34, r134);
        L98:
            Message.ThreadMessageType r135 = r101.thread_message_type;
            if (r135 == null) goto L101;
            Message.ThreadMessageType.ADAPTER.encodeWithTag(r100, 35, r135);
        L101:
            String r136 = r101.unit_key;
            if (r136 == null) goto L104;
            r116.encodeWithTag(r100, 36, r136);
        L104:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type AT = null;
        public static final Type NORMAL = null;
        public static final Type REACTION = null;
        public static final Type SPECIAL_FOCUS = null;
        public static final Type URGENT = null;
        public static final Type URGENT_ACK = null;
        public static final Type URGENT_FAILED = null;
        private final int value;

        static {
            Type r100 = new Type(EffectConstants.NORMAL, 0, 1);
            NORMAL = r100;
            Type r101 = new Type("AT", 1, 2);
            AT = r101;
            Type r102 = new Type("URGENT", 2, 3);
            URGENT = r102;
            Type r103 = new Type(CardAdapter.REACTION, 3, 4);
            REACTION = r103;
            Type r104 = new Type("URGENT_ACK", 4, 5);
            URGENT_ACK = r104;
            Type r110 = new Type("URGENT_FAILED", 5, 6);
            URGENT_FAILED = r110;
            Type r111 = new Type("SPECIAL_FOCUS", 6, 7);
            SPECIAL_FOCUS = r111;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r110, r111};
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
            switch(r100) {
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return SPECIAL_FOCUS;
        L8:
            return URGENT_FAILED;
        L10:
            return URGENT_ACK;
        L12:
            return REACTION;
        L14:
            return URGENT;
        L16:
            return AT;
        L18:
            return NORMAL;
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
        ADAPTER = new ProtoAdapter_MessageData();
        DEFAULT_POSITION = 0;
        DEFAULT_TYPE = Type.NORMAL;
        DEFAULT_CHAT_TYPE = Chat.Type.P2P;
        DEFAULT_CHAT_MODE = Chat.ChatMode.UNKNOWN;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_CRYPTO = r100;
        DEFAULT_NEW_MESSAGE_COUNT = 0;
        DEFAULT_THREAD_MESSAGE_POSITION = 0;
        DEFAULT_IS_FOLLOWED = r100;
        DEFAULT_CHANNEL_THREAD_POSITION = 0;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_ME_READ = r100;
        DEFAULT_IS_BOT = r100;
        DEFAULT_IS_ON_TIME_DEL = r100;
        DEFAULT_QUICK_REPLY_CATEGORY = 0;
        DEFAULT_NOT_COMM_NOTIFICATION = r100;
        DEFAULT_TARGET_USER_ID = 0L;
        DEFAULT_IS_SHOW_DETAIL = r100;
        DEFAULT_RECALLER_IDENTITY = Message.RecallerIdentity.UNKNOWN_IDENTITY;
        DEFAULT_THREAD_MESSAGE_TYPE = Message.ThreadMessageType.UNKNOWN_THREAD_MESSAGE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.urgent_id = this.urgent_id;
        r100.message_id = this.message_id;
        r100.position = this.position;
        r100.recaller_id = this.recaller_id;
        r100.type = this.type;
        r100.channel = this.channel;
        r100.chat_id = this.chat_id;
        r100.chat_type = this.chat_type;
        r100.chat_mode = this.chat_mode;
        r100.is_crypto = this.is_crypto;
        r100.new_message_count = this.new_message_count;
        r100.avatar_key = this.avatar_key;
        r100.avatar_path = this.avatar_path;
        r100.thread_message_position = this.thread_message_position;
        r100.from_chatter_id = this.from_chatter_id;
        r100.image_urls = Internal.copyOf("image_urls", this.image_urls);
        r100.is_followed = this.is_followed;
        r100.thread_id = this.thread_id;
        r100.channel_thread_position = this.channel_thread_position;
        r100.create_time = this.create_time;
        r100.me_read = this.me_read;
        r100.app_id = this.app_id;
        r100.open_app_chat_feed_id = this.open_app_chat_feed_id;
        r100.is_bot = this.is_bot;
        r100.is_on_time_del = this.is_on_time_del;
        r100.quick_reply_category = this.quick_reply_category;
        r100.not_comm_notification = this.not_comm_notification;
        r100.from_chatter_name = this.from_chatter_name;
        r100.channel_name = this.channel_name;
        r100.sound_url = this.sound_url;
        r100.target_user_id = this.target_user_id;
        r100.is_show_detail = this.is_show_detail;
        r100.recaller_name = this.recaller_name;
        r100.recaller_identity = this.recaller_identity;
        r100.thread_message_type = this.thread_message_type;
        r100.unit_key = this.unit_key;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MessageData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public MessageData(String r310, String r410, Integer r411, String r412, Type r413, Channel r414, String r415, Chat.Type r416, Chat.ChatMode r417, Boolean r418, Integer r419, String r510, String r511, Integer r512, String r513, List<String> r514, Boolean r515, String r516, Integer r517, Long r518, Boolean r519, String r610, String r611, Boolean r612, Boolean r613, Integer r614, Boolean r615, String r616, String r617, String r618, Long r619, Boolean r710, String r711, Message.RecallerIdentity r712, Message.ThreadMessageType r713, String r714) {
        this(r310, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, ByteString.EMPTY);
    }

    public MessageData(String r100, String r101, Integer r102, String r103, Type r104, Channel r105, String r110, Chat.Type r111, Chat.ChatMode r112, Boolean r113, Integer r114, String r115, String r116, Integer r117, String r118, List<String> r119, Boolean r210, String r211, Integer r212, Long r213, Boolean r214, String r215, String r216, Boolean r217, Boolean r218, Integer r219, Boolean r310, String r311, String r312, String r313, Long r314, Boolean r315, String r316, Message.RecallerIdentity r317, Message.ThreadMessageType r318, String r319, ByteString r410) {
        super(ADAPTER, r410);
        this.urgent_id = r100;
        this.message_id = r101;
        this.position = r102;
        this.recaller_id = r103;
        this.type = r104;
        this.channel = r105;
        this.chat_id = r110;
        this.chat_type = r111;
        this.chat_mode = r112;
        this.is_crypto = r113;
        this.new_message_count = r114;
        this.avatar_key = r115;
        this.avatar_path = r116;
        this.thread_message_position = r117;
        this.from_chatter_id = r118;
        this.image_urls = Internal.immutableCopyOf("image_urls", r119);
        this.is_followed = r210;
        this.thread_id = r211;
        this.channel_thread_position = r212;
        this.create_time = r213;
        this.me_read = r214;
        this.app_id = r215;
        this.open_app_chat_feed_id = r216;
        this.is_bot = r217;
        this.is_on_time_del = r218;
        this.quick_reply_category = r219;
        this.not_comm_notification = r310;
        this.from_chatter_name = r311;
        this.channel_name = r312;
        this.sound_url = r313;
        this.target_user_id = r314;
        this.is_show_detail = r315;
        this.recaller_name = r316;
        this.recaller_identity = r317;
        this.thread_message_type = r318;
        this.unit_key = r319;
    }
}
