package com.bytedance.lark.pb.basic.v1;

import com.bytedance.lark.pb.openplatform.v1.AppInfoItem;
import com.obric.capabilitykit.EntityProvider;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class MessageLink extends com.squareup.wire.Message<MessageLink, Builder> {
    public static final ProtoAdapter<MessageLink> ADAPTER = null;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    public final Map<Long, AppInfoItem> app_info_items;
    public final ChatInfo chat_info;
    public final Map<String, Chat> chats;
    public final Map<String, Chatter> chatters;
    public final Map<Long, Entity> entities;
    public final List<Long> entity_ids;
    public final MetaInfo meta_info;
    public final Map<String, PreviewEntityPair> preview_entities;
    public final Map<String, URLPreviewTemplate> preview_templates;
    public final String token;

    public static final class Builder extends com.squareup.wire.Message.Builder<MessageLink, Builder> {
        public Map<Long, AppInfoItem> app_info_items;
        public ChatInfo chat_info;
        public Map<String, Chat> chats;
        public Map<String, Chatter> chatters;
        public Map<Long, Entity> entities;
        public List<Long> entity_ids;
        public MetaInfo meta_info;
        public Map<String, PreviewEntityPair> preview_entities;
        public Map<String, URLPreviewTemplate> preview_templates;
        public String token;

        @Override // com.squareup.wire.Message.Builder
        public MessageLink build() {
            return new MessageLink(this.token, this.entity_ids, this.entities, this.chatters, this.chats, this.preview_entities, this.preview_templates, this.meta_info, this.chat_info, this.app_info_items, super.buildUnknownFields());
        }

        public Builder() {
            this.entity_ids = Internal.newMutableList();
            this.entities = Internal.newMutableMap();
            this.chatters = Internal.newMutableMap();
            this.chats = Internal.newMutableMap();
            this.preview_entities = Internal.newMutableMap();
            this.preview_templates = Internal.newMutableMap();
            this.app_info_items = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder app_info_items(Map<Long, AppInfoItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.app_info_items = r100;
            return this;
        }

        public Builder chat_info(ChatInfo r100) {
            this.chat_info = r100;
            return this;
        }

        public Builder chats(Map<String, Chat> r100) {
            Internal.checkElementsNotNull(r100);
            this.chats = r100;
            return this;
        }

        public Builder chatters(Map<String, Chatter> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatters = r100;
            return this;
        }

        public Builder entities(Map<Long, Entity> r100) {
            Internal.checkElementsNotNull(r100);
            this.entities = r100;
            return this;
        }

        public Builder entity_ids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.entity_ids = r100;
            return this;
        }

        public Builder meta_info(MetaInfo r100) {
            this.meta_info = r100;
            return this;
        }

        public Builder preview_entities(Map<String, PreviewEntityPair> r100) {
            Internal.checkElementsNotNull(r100);
            this.preview_entities = r100;
            return this;
        }

        public Builder preview_templates(Map<String, URLPreviewTemplate> r100) {
            Internal.checkElementsNotNull(r100);
            this.preview_templates = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }
    }

    public static final class ChatInfo extends com.squareup.wire.Message<ChatInfo, Builder> {
        public static final ProtoAdapter<ChatInfo> ADAPTER = null;
        public static final Boolean DEFAULT_IS_AUTH = null;
        public static final Boolean DEFAULT_IS_P2P_BOT = null;
        public static final String DEFAULT_NAME = "";
        public static final Chat.Type DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final Boolean is_auth;
        public final Boolean is_p2p_bot;
        public final String name;
        public final Chat.Type type;

        public static final class Builder extends com.squareup.wire.Message.Builder<ChatInfo, Builder> {
            public Boolean is_auth;
            public Boolean is_p2p_bot;
            public String name;
            public Chat.Type type;

            @Override // com.squareup.wire.Message.Builder
            public ChatInfo build() {
                return new ChatInfo(this.name, this.is_auth, this.type, this.is_p2p_bot, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder is_auth(Boolean r100) {
                this.is_auth = r100;
                return this;
            }

            public Builder is_p2p_bot(Boolean r100) {
                this.is_p2p_bot = r100;
                return this;
            }

            public Builder name(String r100) {
                this.name = r100;
                return this;
            }

            public Builder type(Chat.Type r100) {
                this.type = r100;
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
                r101.name = "";
                Boolean r102 = Boolean.FALSE;
                r101.is_auth = r102;
                r101.type = Chat.Type.P2P;
                r101.is_p2p_bot = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L21;
                if (r104 != 1) goto L8;
                r101.name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L10;
                r101.is_auth = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                if (r104 != 3) goto L12;
                r101.type = Chat.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L12:
                if (r104 != 4) goto L13;
                r101.is_p2p_bot = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L13:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ChatInfo r100) {
                String r101 = r100.name;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.is_auth;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Chat.Type r107 = r100.type;
                if (r107 == null) goto L13;
                int r108 = Chat.Type.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Boolean r110 = r100.is_p2p_bot;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
            L18:
                return (r109 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ ChatInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ChatInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ChatInfo r101) throws IOException {
                String r102 = r101.name;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.is_auth;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                Chat.Type r104 = r101.type;
                if (r104 == null) goto L11;
                Chat.Type.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                Boolean r105 = r101.is_p2p_bot;
                if (r105 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
            L14:
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
            DEFAULT_IS_AUTH = r100;
            DEFAULT_TYPE = Chat.Type.P2P;
            DEFAULT_IS_P2P_BOT = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.name = this.name;
            r100.is_auth = this.is_auth;
            r100.type = this.type;
            r100.is_p2p_bot = this.is_p2p_bot;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ChatInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ChatInfo(String r100, Boolean r101, Chat.Type r102, Boolean r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public ChatInfo(String r100, Boolean r101, Chat.Type r102, Boolean r103, ByteString r104) {
            super(ADAPTER, r104);
            this.name = r100;
            this.is_auth = r101;
            this.type = r102;
            this.is_p2p_bot = r103;
        }
    }

    public static final class Entity extends com.squareup.wire.Message<Entity, Builder> {
        public static final ProtoAdapter<Entity> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Message message;
        public final MessageThread message_thread;
        public final Thread thread;

        public static final class Builder extends com.squareup.wire.Message.Builder<Entity, Builder> {
            public Message message;
            public MessageThread message_thread;
            public Thread thread;

            @Override // com.squareup.wire.Message.Builder
            public Entity build() {
                return new Entity(this.message, this.thread, this.message_thread, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder message(Message r100) {
                this.message = r100;
                return this;
            }

            public Builder message_thread(MessageThread r100) {
                this.message_thread = r100;
                return this;
            }

            public Builder thread(Thread r100) {
                this.thread = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Entity extends ProtoAdapter<Entity> {
            public ProtoAdapter_Entity() {
                super(FieldEncoding.LENGTH_DELIMITED, Entity.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Entity decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.message = Message.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.thread = Thread.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.message_thread = MessageThread.ADAPTER.decode(r100);
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Entity r100) {
                Message r101 = r100.message;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Message.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Thread r104 = r100.thread;
                if (r104 == null) goto L9;
                int r105 = Thread.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                MessageThread r107 = r100.message_thread;
                if (r107 == null) goto L14;
                r102 = MessageThread.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                return (r106 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Entity decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Entity r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Entity r101) throws IOException {
                Message r102 = r101.message;
                if (r102 == null) goto L5;
                Message.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Thread r103 = r101.thread;
                if (r103 == null) goto L8;
                Thread.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                MessageThread r104 = r101.message_thread;
                if (r104 == null) goto L11;
                MessageThread.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Entity r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Entity();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.message = this.message;
            r100.thread = this.thread;
            r100.message_thread = this.message_thread;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Entity.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Entity(Message r100, Thread r101, MessageThread r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public Entity(Message r100, Thread r101, MessageThread r102, ByteString r103) {
            super(ADAPTER, r103);
            this.message = r100;
            this.thread = r101;
            this.message_thread = r102;
        }
    }

    public static final class MessageThread extends com.squareup.wire.Message<MessageThread, Builder> {
        public static final ProtoAdapter<MessageThread> ADAPTER = null;
        public static final Long DEFAULT_ID = null;
        public static final Long DEFAULT_LATEST_REPLY_TIME = null;
        public static final Integer DEFAULT_REPLY_COUNT = null;
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public final Long f253519id;
        public final Long latest_reply_time;
        public final Integer reply_count;
        public final List<Long> reply_entity_ids;
        public final List<Long> top_repliers;

        public static final class Builder extends com.squareup.wire.Message.Builder<MessageThread, Builder> {

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            public Long f253520id;
            public Long latest_reply_time;
            public Integer reply_count;
            public List<Long> reply_entity_ids;
            public List<Long> top_repliers;

            @Override // com.squareup.wire.Message.Builder
            public MessageThread build() {
                return new MessageThread(this.f253520id, this.reply_count, this.top_repliers, this.latest_reply_time, this.reply_entity_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.top_repliers = Internal.newMutableList();
                this.reply_entity_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder id(Long r100) {
                this.f253520id = r100;
                return this;
            }

            public Builder latest_reply_time(Long r100) {
                this.latest_reply_time = r100;
                return this;
            }

            public Builder reply_count(Integer r100) {
                this.reply_count = r100;
                return this;
            }

            public Builder reply_entity_ids(List<Long> r100) {
                Internal.checkElementsNotNull(r100);
                this.reply_entity_ids = r100;
                return this;
            }

            public Builder top_repliers(List<Long> r100) {
                Internal.checkElementsNotNull(r100);
                this.top_repliers = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MessageThread extends ProtoAdapter<MessageThread> {
            public ProtoAdapter_MessageThread() {
                super(FieldEncoding.LENGTH_DELIMITED, MessageThread.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MessageThread decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.f253520id = 0L;
                r101.reply_count = 0;
                r101.latest_reply_time = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.f253520id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.reply_count = ProtoAdapter.INT32.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.top_repliers.add(ProtoAdapter.INT64.decode(r100));
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.latest_reply_time = ProtoAdapter.INT64.decode(r100);
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.reply_entity_ids.add(ProtoAdapter.INT64.decode(r100));
                goto L3
            L15:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(MessageThread r100) {
                Long r101 = r100.f253519id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.reply_count;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                ProtoAdapter<Long> r107 = ProtoAdapter.INT64;
                int r108 = r106 + r107.asRepeated().encodedSizeWithTag(3, r100.top_repliers);
                Long r109 = r100.latest_reply_time;
                if (r109 == null) goto L14;
                r102 = r107.encodedSizeWithTag(4, r109);
            L14:
                return ((r108 + r102) + r107.asRepeated().encodedSizeWithTag(5, r100.reply_entity_ids)) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MessageThread decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MessageThread r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MessageThread r101) throws IOException {
                Long r102 = r101.f253519id;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.reply_count;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                ProtoAdapter<Long> r104 = ProtoAdapter.INT64;
                r104.asRepeated().encodeWithTag(r100, 3, r101.top_repliers);
                Long r105 = r101.latest_reply_time;
                if (r105 == null) goto L11;
                r104.encodeWithTag(r100, 4, r105);
            L11:
                r104.asRepeated().encodeWithTag(r100, 5, r101.reply_entity_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageThread r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MessageThread();
            DEFAULT_ID = 0L;
            DEFAULT_REPLY_COUNT = 0;
            DEFAULT_LATEST_REPLY_TIME = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.f253520id = this.f253519id;
            r100.reply_count = this.reply_count;
            r100.top_repliers = Internal.copyOf("top_repliers", this.top_repliers);
            r100.latest_reply_time = this.latest_reply_time;
            r100.reply_entity_ids = Internal.copyOf("reply_entity_ids", this.reply_entity_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MessageThread.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public MessageThread(Long r100, Integer r101, List<Long> r110, Long r111, List<Long> r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public MessageThread(Long r100, Integer r101, List<Long> r102, Long r103, List<Long> r104, ByteString r105) {
            super(ADAPTER, r105);
            this.f253519id = r100;
            this.reply_count = r101;
            this.top_repliers = Internal.immutableCopyOf("top_repliers", r102);
            this.latest_reply_time = r103;
            this.reply_entity_ids = Internal.immutableCopyOf("reply_entity_ids", r104);
        }
    }

    public static final class MetaInfo extends com.squareup.wire.Message<MetaInfo, Builder> {
        public static final ProtoAdapter<MetaInfo> ADAPTER = null;
        public static final Long DEFAULT_FROM_CHAT_ID = null;
        public static final Integer DEFAULT_JUMP_POS = null;
        public static final Long DEFAULT_OPERATOR_ID = null;
        public static final Long DEFAULT_OPERATOR_TIME_NS = null;
        private static final long serialVersionUID = 0;
        public final Long from_chat_id;
        public final Integer jump_pos;
        public final Long operator_id;
        public final Long operator_time_ns;

        public static final class Builder extends com.squareup.wire.Message.Builder<MetaInfo, Builder> {
            public Long from_chat_id;
            public Integer jump_pos;
            public Long operator_id;
            public Long operator_time_ns;

            @Override // com.squareup.wire.Message.Builder
            public MetaInfo build() {
                return new MetaInfo(this.operator_id, this.from_chat_id, this.operator_time_ns, this.jump_pos, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder from_chat_id(Long r100) {
                this.from_chat_id = r100;
                return this;
            }

            public Builder jump_pos(Integer r100) {
                this.jump_pos = r100;
                return this;
            }

            public Builder operator_id(Long r100) {
                this.operator_id = r100;
                return this;
            }

            public Builder operator_time_ns(Long r100) {
                this.operator_time_ns = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MetaInfo extends ProtoAdapter<MetaInfo> {
            public ProtoAdapter_MetaInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, MetaInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MetaInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.operator_id = 0L;
                r101.from_chat_id = 0L;
                r101.operator_time_ns = 0L;
                r101.jump_pos = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.operator_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.from_chat_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.operator_time_ns = ProtoAdapter.INT64.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.jump_pos = ProtoAdapter.INT32.decode(r100);
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(MetaInfo r100) {
                Long r101 = r100.operator_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.from_chat_id;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Long r107 = r100.operator_time_ns;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Integer r110 = r100.jump_pos;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(4, r110);
            L18:
                return (r109 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ MetaInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MetaInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MetaInfo r101) throws IOException {
                Long r102 = r101.operator_id;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.from_chat_id;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
            L8:
                Long r104 = r101.operator_time_ns;
                if (r104 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
            L11:
                Integer r105 = r101.jump_pos;
                if (r105 == null) goto L14;
                ProtoAdapter.INT32.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MetaInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MetaInfo();
            DEFAULT_OPERATOR_ID = 0L;
            DEFAULT_FROM_CHAT_ID = 0L;
            DEFAULT_OPERATOR_TIME_NS = 0L;
            DEFAULT_JUMP_POS = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.operator_id = this.operator_id;
            r100.from_chat_id = this.from_chat_id;
            r100.operator_time_ns = this.operator_time_ns;
            r100.jump_pos = this.jump_pos;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MetaInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public MetaInfo(Long r100, Long r101, Long r102, Integer r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public MetaInfo(Long r100, Long r101, Long r102, Integer r103, ByteString r104) {
            super(ADAPTER, r104);
            this.operator_id = r100;
            this.from_chat_id = r101;
            this.operator_time_ns = r102;
            this.jump_pos = r103;
        }
    }

    public static final class ProtoAdapter_MessageLink extends ProtoAdapter<MessageLink> {
        private final ProtoAdapter<Map<Long, AppInfoItem>> app_info_items;
        private final ProtoAdapter<Map<String, Chat>> chats;
        private final ProtoAdapter<Map<String, Chatter>> chatters;
        private final ProtoAdapter<Map<Long, Entity>> entities;
        private final ProtoAdapter<Map<String, PreviewEntityPair>> preview_entities;
        private final ProtoAdapter<Map<String, URLPreviewTemplate>> preview_templates;

        public ProtoAdapter_MessageLink() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageLink.class);
            ProtoAdapter<Long> r100 = ProtoAdapter.INT64;
            this.entities = ProtoAdapter.newMapAdapter(r100, Entity.ADAPTER);
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            this.chatters = ProtoAdapter.newMapAdapter(r101, Chatter.ADAPTER);
            this.chats = ProtoAdapter.newMapAdapter(r101, Chat.ADAPTER);
            this.preview_entities = ProtoAdapter.newMapAdapter(r101, PreviewEntityPair.ADAPTER);
            this.preview_templates = ProtoAdapter.newMapAdapter(r101, URLPreviewTemplate.ADAPTER);
            this.app_info_items = ProtoAdapter.newMapAdapter(r100, AppInfoItem.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MessageLink decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.token = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            switch(r103) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                default: goto L6;
            };
        L11:
            r101.chats.putAll(this.chats.decode(r100));
            goto L3
        L12:
            r101.preview_templates.putAll(this.preview_templates.decode(r100));
            goto L3
        L13:
            r101.preview_entities.putAll(this.preview_entities.decode(r100));
            goto L3
        L14:
            r101.chatters.putAll(this.chatters.decode(r100));
            goto L3
        L15:
            r101.entities.putAll(this.entities.decode(r100));
            goto L3
        L16:
            r101.entity_ids.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L17:
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            switch(r103) {
                case 15: goto L10;
                case 16: goto L9;
                case 17: goto L8;
                default: goto L7;
            };
        L8:
            r101.app_info_items.putAll(this.app_info_items.decode(r100));
            goto L3
        L9:
            r101.chat_info = ChatInfo.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.meta_info = MetaInfo.ADAPTER.decode(r100);
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MessageLink r100) {
            String r101 = r100.token;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r104 = (((((r103 + ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(2, r100.entity_ids)) + this.entities.encodedSizeWithTag(3, r100.entities)) + this.chatters.encodedSizeWithTag(4, r100.chatters)) + this.chats.encodedSizeWithTag(7, r100.chats)) + this.preview_entities.encodedSizeWithTag(5, r100.preview_entities)) + this.preview_templates.encodedSizeWithTag(6, r100.preview_templates);
            MetaInfo r105 = r100.meta_info;
            if (r105 == null) goto L9;
            int r106 = MetaInfo.ADAPTER.encodedSizeWithTag(15, r105);
        L10:
            int r107 = r104 + r106;
            ChatInfo r108 = r100.chat_info;
            if (r108 == null) goto L14;
            r102 = ChatInfo.ADAPTER.encodedSizeWithTag(16, r108);
        L14:
            return ((r107 + r102) + this.app_info_items.encodedSizeWithTag(17, r100.app_info_items)) + r100.unknownFields().size();
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MessageLink decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MessageLink r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MessageLink r101) throws IOException {
            String r102 = r101.token;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter.INT64.asRepeated().encodeWithTag(r100, 2, r101.entity_ids);
            this.entities.encodeWithTag(r100, 3, r101.entities);
            this.chatters.encodeWithTag(r100, 4, r101.chatters);
            this.chats.encodeWithTag(r100, 7, r101.chats);
            this.preview_entities.encodeWithTag(r100, 5, r101.preview_entities);
            this.preview_templates.encodeWithTag(r100, 6, r101.preview_templates);
            MetaInfo r103 = r101.meta_info;
            if (r103 == null) goto L8;
            MetaInfo.ADAPTER.encodeWithTag(r100, 15, r103);
        L8:
            ChatInfo r104 = r101.chat_info;
            if (r104 == null) goto L11;
            ChatInfo.ADAPTER.encodeWithTag(r100, 16, r104);
        L11:
            this.app_info_items.encodeWithTag(r100, 17, r101.app_info_items);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageLink r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageLink();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.token = this.token;
        r100.entity_ids = Internal.copyOf(EntityProvider.KEY_ENTITY_IDS, this.entity_ids);
        r100.entities = Internal.copyOf("entities", this.entities);
        r100.chatters = Internal.copyOf("chatters", this.chatters);
        r100.chats = Internal.copyOf("chats", this.chats);
        r100.preview_entities = Internal.copyOf("preview_entities", this.preview_entities);
        r100.preview_templates = Internal.copyOf("preview_templates", this.preview_templates);
        r100.meta_info = this.meta_info;
        r100.chat_info = this.chat_info;
        r100.app_info_items = Internal.copyOf("app_info_items", this.app_info_items);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MessageLink.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public MessageLink(String r110, List<Long> r111, Map<Long, Entity> r112, Map<String, Chatter> r113, Map<String, Chat> r114, Map<String, PreviewEntityPair> r115, Map<String, URLPreviewTemplate> r116, MetaInfo r210, ChatInfo r211, Map<Long, AppInfoItem> r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public MessageLink(String r100, List<Long> r101, Map<Long, Entity> r102, Map<String, Chatter> r103, Map<String, Chat> r104, Map<String, PreviewEntityPair> r105, Map<String, URLPreviewTemplate> r106, MetaInfo r107, ChatInfo r110, Map<Long, AppInfoItem> r111, ByteString r112) {
        super(ADAPTER, r112);
        this.token = r100;
        this.entity_ids = Internal.immutableCopyOf(EntityProvider.KEY_ENTITY_IDS, r101);
        this.entities = Internal.immutableCopyOf("entities", r102);
        this.chatters = Internal.immutableCopyOf("chatters", r103);
        this.chats = Internal.immutableCopyOf("chats", r104);
        this.preview_entities = Internal.immutableCopyOf("preview_entities", r105);
        this.preview_templates = Internal.immutableCopyOf("preview_templates", r106);
        this.meta_info = r107;
        this.chat_info = r110;
        this.app_info_items = Internal.immutableCopyOf("app_info_items", r111);
    }
}
