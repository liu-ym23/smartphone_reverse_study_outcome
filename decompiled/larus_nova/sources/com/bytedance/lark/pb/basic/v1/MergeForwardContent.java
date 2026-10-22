package com.bytedance.lark.pb.basic.v1;

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
public final class MergeForwardContent extends com.squareup.wire.Message<MergeForwardContent, Builder> {
    public static final ProtoAdapter<MergeForwardContent> ADAPTER = null;
    public static final Chat.Type DEFAULT_CHAT_TYPE = null;
    public static final String DEFAULT_GROUP_CHAT_NAME = "";
    public static final Boolean DEFAULT_IS_COPY_FROM_DOUBAO = null;
    public static final Boolean DEFAULT_IS_TRANSMIT = null;
    public static final Long DEFAULT_ORIGIN_CHAT_ID = null;
    public static final Long DEFAULT_P2P_CREATOR_ID = null;
    public static final String DEFAULT_P2P_CREATOR_NAME = "";
    public static final Long DEFAULT_P2P_PARTNER_ID = null;
    public static final String DEFAULT_P2P_PARTNER_NAME = "";
    public static final String DEFAULT_QUASI_TITLE = "";
    private static final long serialVersionUID = 0;
    public final Chat.Type chat_type;
    public final Map<String, ChatterInfo> chatters;
    public final Map<String, String> creator_i18n_names;
    public final String group_chat_name;
    public final Map<String, String> i18n_thread_title;
    public final Boolean is_copy_from_doubao;
    public final Boolean is_transmit;
    public final Map<Long, MessageThread> message_threads;
    public final List<Message> messages;
    public final Chat origin_chat;
    public final Long origin_chat_id;
    public final Long p2p_creator_id;
    public final String p2p_creator_name;
    public final Long p2p_partner_id;
    public final String p2p_partner_name;
    public final Map<String, String> partner_i18n_names;
    public final OptionPutInfo put_info;
    public final String quasi_title;
    public final Map<String, MessageReaction> reaction_snapshots;
    public final Thread thread;

    public static final class Builder extends com.squareup.wire.Message.Builder<MergeForwardContent, Builder> {
        public Chat.Type chat_type;
        public Map<String, ChatterInfo> chatters;
        public Map<String, String> creator_i18n_names;
        public String group_chat_name;
        public Map<String, String> i18n_thread_title;
        public Boolean is_copy_from_doubao;
        public Boolean is_transmit;
        public Map<Long, MessageThread> message_threads;
        public List<Message> messages;
        public Chat origin_chat;
        public Long origin_chat_id;
        public Long p2p_creator_id;
        public String p2p_creator_name;
        public Long p2p_partner_id;
        public String p2p_partner_name;
        public Map<String, String> partner_i18n_names;
        public OptionPutInfo put_info;
        public String quasi_title;
        public Map<String, MessageReaction> reaction_snapshots;
        public Thread thread;

        @Override // com.squareup.wire.Message.Builder
        public MergeForwardContent build() {
            return new MergeForwardContent(this.messages, this.chat_type, this.group_chat_name, this.p2p_creator_name, this.p2p_partner_name, this.creator_i18n_names, this.partner_i18n_names, this.p2p_creator_id, this.p2p_partner_id, this.chatters, this.reaction_snapshots, this.thread, this.i18n_thread_title, this.quasi_title, this.put_info, this.is_transmit, this.message_threads, this.origin_chat_id, this.origin_chat, this.is_copy_from_doubao, super.buildUnknownFields());
        }

        public Builder() {
            this.messages = Internal.newMutableList();
            this.creator_i18n_names = Internal.newMutableMap();
            this.partner_i18n_names = Internal.newMutableMap();
            this.chatters = Internal.newMutableMap();
            this.reaction_snapshots = Internal.newMutableMap();
            this.i18n_thread_title = Internal.newMutableMap();
            this.message_threads = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder chat_type(Chat.Type r100) {
            this.chat_type = r100;
            return this;
        }

        public Builder chatters(Map<String, ChatterInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatters = r100;
            return this;
        }

        public Builder creator_i18n_names(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.creator_i18n_names = r100;
            return this;
        }

        public Builder group_chat_name(String r100) {
            this.group_chat_name = r100;
            return this;
        }

        public Builder i18n_thread_title(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.i18n_thread_title = r100;
            return this;
        }

        public Builder is_copy_from_doubao(Boolean r100) {
            this.is_copy_from_doubao = r100;
            return this;
        }

        public Builder is_transmit(Boolean r100) {
            this.is_transmit = r100;
            return this;
        }

        public Builder message_threads(Map<Long, MessageThread> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_threads = r100;
            return this;
        }

        public Builder messages(List<Message> r100) {
            Internal.checkElementsNotNull(r100);
            this.messages = r100;
            return this;
        }

        public Builder origin_chat(Chat r100) {
            this.origin_chat = r100;
            return this;
        }

        public Builder origin_chat_id(Long r100) {
            this.origin_chat_id = r100;
            return this;
        }

        public Builder p2p_creator_id(Long r100) {
            this.p2p_creator_id = r100;
            return this;
        }

        public Builder p2p_creator_name(String r100) {
            this.p2p_creator_name = r100;
            return this;
        }

        public Builder p2p_partner_id(Long r100) {
            this.p2p_partner_id = r100;
            return this;
        }

        public Builder p2p_partner_name(String r100) {
            this.p2p_partner_name = r100;
            return this;
        }

        public Builder partner_i18n_names(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.partner_i18n_names = r100;
            return this;
        }

        public Builder put_info(OptionPutInfo r100) {
            this.put_info = r100;
            return this;
        }

        public Builder quasi_title(String r100) {
            this.quasi_title = r100;
            return this;
        }

        public Builder reaction_snapshots(Map<String, MessageReaction> r100) {
            Internal.checkElementsNotNull(r100);
            this.reaction_snapshots = r100;
            return this;
        }

        public Builder thread(Thread r100) {
            this.thread = r100;
            return this;
        }
    }

    public static final class ChatterInfo extends com.squareup.wire.Message<ChatterInfo, Builder> {
        public static final ProtoAdapter<ChatterInfo> ADAPTER = null;
        public static final String DEFAULT_AVATAR_KEY = "";
        public static final String DEFAULT_AVATAR_PATH = "";
        public static final String DEFAULT_ID = "";
        public static final Boolean DEFAULT_IS_ANONYMOUS = null;
        public static final String DEFAULT_NAME = "";
        public static final Chatter.Type DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final ImageSet avatar;
        public final String avatar_key;
        public final String avatar_path;
        public final Map<String, String> i18n_name;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public final String f253511id;
        public final Boolean is_anonymous;
        public final String name;
        public final Chatter.Type type;

        public static final class Builder extends com.squareup.wire.Message.Builder<ChatterInfo, Builder> {
            public ImageSet avatar;
            public String avatar_key;
            public String avatar_path;
            public Map<String, String> i18n_name;

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            public String f253512id;
            public Boolean is_anonymous;
            public String name;
            public Chatter.Type type;

            @Override // com.squareup.wire.Message.Builder
            public ChatterInfo build() {
                return new ChatterInfo(this.f253512id, this.name, this.avatar, this.type, this.avatar_key, this.avatar_path, this.is_anonymous, this.i18n_name, super.buildUnknownFields());
            }

            public Builder() {
                this.i18n_name = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder avatar(ImageSet r100) {
                this.avatar = r100;
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

            public Builder i18n_name(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.i18n_name = r100;
                return this;
            }

            public Builder id(String r100) {
                this.f253512id = r100;
                return this;
            }

            public Builder is_anonymous(Boolean r100) {
                this.is_anonymous = r100;
                return this;
            }

            public Builder name(String r100) {
                this.name = r100;
                return this;
            }

            public Builder type(Chatter.Type r100) {
                this.type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ChatterInfo extends ProtoAdapter<ChatterInfo> {
            private final ProtoAdapter<Map<String, String>> i18n_name;

            public ProtoAdapter_ChatterInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, ChatterInfo.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.i18n_name = ProtoAdapter.newMapAdapter(r100, r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ChatterInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.f253512id = "";
                r101.name = "";
                r101.type = Chatter.Type.UNKNOWN;
                r101.avatar_key = "";
                r101.avatar_path = "";
                r101.is_anonymous = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                switch(r103) {
                    case 1: goto L17;
                    case 2: goto L16;
                    case 3: goto L15;
                    case 4: goto L20;
                    case 5: goto L10;
                    case 6: goto L9;
                    case 7: goto L8;
                    case 8: goto L7;
                    default: goto L6;
                };
            L20:
                r101.type = Chatter.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.i18n_name.putAll(this.i18n_name.decode(r100));
                goto L3
            L8:
                r101.is_anonymous = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                r101.avatar_path = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.avatar_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L15:
                r101.avatar = ImageSet.ADAPTER.decode(r100);
                goto L3
            L16:
                r101.name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L17:
                r101.f253512id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ChatterInfo r100) {
                String r101 = r100.f253511id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.name;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                ImageSet r107 = r100.avatar;
                if (r107 == null) goto L13;
                int r108 = ImageSet.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Chatter.Type r110 = r100.type;
                if (r110 == null) goto L17;
                int r111 = Chatter.Type.ADAPTER.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                String r113 = r100.avatar_key;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                String r116 = r100.avatar_path;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                Boolean r119 = r100.is_anonymous;
                if (r119 == null) goto L30;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
            L30:
                return ((r118 + r102) + this.i18n_name.encodedSizeWithTag(8, r100.i18n_name)) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ ChatterInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ChatterInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ChatterInfo r101) throws IOException {
                String r102 = r101.f253511id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.name;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                ImageSet r104 = r101.avatar;
                if (r104 == null) goto L11;
                ImageSet.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                Chatter.Type r105 = r101.type;
                if (r105 == null) goto L14;
                Chatter.Type.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                String r106 = r101.avatar_key;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
            L17:
                String r107 = r101.avatar_path;
                if (r107 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
            L20:
                Boolean r108 = r101.is_anonymous;
                if (r108 == null) goto L23;
                ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
            L23:
                this.i18n_name.encodeWithTag(r100, 8, r101.i18n_name);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatterInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChatterInfo();
            DEFAULT_TYPE = Chatter.Type.UNKNOWN;
            DEFAULT_IS_ANONYMOUS = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.f253512id = this.f253511id;
            r100.name = this.name;
            r100.avatar = this.avatar;
            r100.type = this.type;
            r100.avatar_key = this.avatar_key;
            r100.avatar_path = this.avatar_path;
            r100.is_anonymous = this.is_anonymous;
            r100.i18n_name = Internal.copyOf("i18n_name", this.i18n_name);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ChatterInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ChatterInfo(String r110, String r111, ImageSet r112, Chatter.Type r113, String r114, String r115, Boolean r116, Map<String, String> r117) {
            this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
        }

        public ChatterInfo(String r100, String r101, ImageSet r102, Chatter.Type r103, String r104, String r105, Boolean r106, Map<String, String> r107, ByteString r110) {
            super(ADAPTER, r110);
            this.f253511id = r100;
            this.name = r101;
            this.avatar = r102;
            this.type = r103;
            this.avatar_key = r104;
            this.avatar_path = r105;
            this.is_anonymous = r106;
            this.i18n_name = Internal.immutableCopyOf("i18n_name", r107);
        }
    }

    public static final class MessageReaction extends com.squareup.wire.Message<MessageReaction, Builder> {
        public static final ProtoAdapter<MessageReaction> ADAPTER = null;
        public static final String DEFAULT_MESSAGE_ID = "";
        private static final long serialVersionUID = 0;
        public final String message_id;
        public final List<Reaction> reactions;

        public static final class Builder extends com.squareup.wire.Message.Builder<MessageReaction, Builder> {
            public String message_id;
            public List<Reaction> reactions;

            @Override // com.squareup.wire.Message.Builder
            public MessageReaction build() {
                return new MessageReaction(this.message_id, this.reactions, super.buildUnknownFields());
            }

            public Builder() {
                this.reactions = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder message_id(String r100) {
                this.message_id = r100;
                return this;
            }

            public Builder reactions(List<Reaction> r100) {
                Internal.checkElementsNotNull(r100);
                this.reactions = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MessageReaction extends ProtoAdapter<MessageReaction> {
            public ProtoAdapter_MessageReaction() {
                super(FieldEncoding.LENGTH_DELIMITED, MessageReaction.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MessageReaction decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.message_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.message_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.reactions.add(Reaction.ADAPTER.decode(r100));
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(MessageReaction r100) {
                String r101 = r100.message_id;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return (r102 + Reaction.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.reactions)) + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MessageReaction decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MessageReaction r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MessageReaction r101) throws IOException {
                String r102 = r101.message_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Reaction.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.reactions);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageReaction r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MessageReaction();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.message_id = this.message_id;
            r100.reactions = Internal.copyOf("reactions", this.reactions);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MessageReaction.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public MessageReaction(String r100, List<Reaction> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public MessageReaction(String r100, List<Reaction> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.message_id = r100;
            this.reactions = Internal.immutableCopyOf("reactions", r101);
        }
    }

    public static final class MessageThread extends com.squareup.wire.Message<MessageThread, Builder> {
        public static final ProtoAdapter<MessageThread> ADAPTER = null;
        public static final Long DEFAULT_ID = null;
        public static final Long DEFAULT_LATEST_REPLY_TIME = null;
        public static final Integer DEFAULT_REPLY_COUNT = null;
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public final Long f253513id;
        public final Long latest_reply_time;
        public final List<Message> messages;
        public final Map<String, MessageReaction> reaction_snapshots;
        public final Integer reply_count;
        public final List<Long> top_repliers;

        public static final class Builder extends com.squareup.wire.Message.Builder<MessageThread, Builder> {

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            public Long f253514id;
            public Long latest_reply_time;
            public List<Message> messages;
            public Map<String, MessageReaction> reaction_snapshots;
            public Integer reply_count;
            public List<Long> top_repliers;

            @Override // com.squareup.wire.Message.Builder
            public MessageThread build() {
                return new MessageThread(this.f253514id, this.reply_count, this.top_repliers, this.latest_reply_time, this.messages, this.reaction_snapshots, super.buildUnknownFields());
            }

            public Builder() {
                this.top_repliers = Internal.newMutableList();
                this.messages = Internal.newMutableList();
                this.reaction_snapshots = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder id(Long r100) {
                this.f253514id = r100;
                return this;
            }

            public Builder latest_reply_time(Long r100) {
                this.latest_reply_time = r100;
                return this;
            }

            public Builder messages(List<Message> r100) {
                Internal.checkElementsNotNull(r100);
                this.messages = r100;
                return this;
            }

            public Builder reaction_snapshots(Map<String, MessageReaction> r100) {
                Internal.checkElementsNotNull(r100);
                this.reaction_snapshots = r100;
                return this;
            }

            public Builder reply_count(Integer r100) {
                this.reply_count = r100;
                return this;
            }

            public Builder top_repliers(List<Long> r100) {
                Internal.checkElementsNotNull(r100);
                this.top_repliers = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MessageThread extends ProtoAdapter<MessageThread> {
            private final ProtoAdapter<Map<String, MessageReaction>> reaction_snapshots;

            public ProtoAdapter_MessageThread() {
                super(FieldEncoding.LENGTH_DELIMITED, MessageThread.class);
                this.reaction_snapshots = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, MessageReaction.ADAPTER);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MessageThread decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.f253514id = 0L;
                r101.reply_count = 0;
                r101.latest_reply_time = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L13;
                switch(r103) {
                    case 1: goto L12;
                    case 2: goto L11;
                    case 3: goto L10;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    default: goto L6;
                };
            L7:
                r101.reaction_snapshots.putAll(this.reaction_snapshots.decode(r100));
                goto L3
            L8:
                r101.messages.add(Message.ADAPTER.decode(r100));
                goto L3
            L9:
                r101.latest_reply_time = ProtoAdapter.INT64.decode(r100);
                goto L3
            L10:
                r101.top_repliers.add(ProtoAdapter.INT64.decode(r100));
                goto L3
            L11:
                r101.reply_count = ProtoAdapter.INT32.decode(r100);
                goto L3
            L12:
                r101.f253514id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L13:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(MessageThread r100) {
                Long r101 = r100.f253513id;
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
                return (((r108 + r102) + Message.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.messages)) + this.reaction_snapshots.encodedSizeWithTag(6, r100.reaction_snapshots)) + r100.unknownFields().size();
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
                Long r102 = r101.f253513id;
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
                Message.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.messages);
                this.reaction_snapshots.encodeWithTag(r100, 6, r101.reaction_snapshots);
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
            r100.f253514id = this.f253513id;
            r100.reply_count = this.reply_count;
            r100.top_repliers = Internal.copyOf("top_repliers", this.top_repliers);
            r100.latest_reply_time = this.latest_reply_time;
            r100.messages = Internal.copyOf("messages", this.messages);
            r100.reaction_snapshots = Internal.copyOf("reaction_snapshots", this.reaction_snapshots);
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

        public MessageThread(Long r100, Integer r110, List<Long> r111, Long r112, List<Message> r113, Map<String, MessageReaction> r114) {
            this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
        }

        public MessageThread(Long r100, Integer r101, List<Long> r102, Long r103, List<Message> r104, Map<String, MessageReaction> r105, ByteString r106) {
            super(ADAPTER, r106);
            this.f253513id = r100;
            this.reply_count = r101;
            this.top_repliers = Internal.immutableCopyOf("top_repliers", r102);
            this.latest_reply_time = r103;
            this.messages = Internal.immutableCopyOf("messages", r104);
            this.reaction_snapshots = Internal.immutableCopyOf("reaction_snapshots", r105);
        }
    }

    public static final class OptionPutInfo extends com.squareup.wire.Message<OptionPutInfo, Builder> {
        public static final ProtoAdapter<OptionPutInfo> ADAPTER = null;
        public static final Boolean DEFAULT_LIMITED = null;
        public static final MergeFowardMessageType DEFAULT_MERGE_TYPE = null;
        public static final Boolean DEFAULT_NEED_COPY_REACTION = null;
        public static final String DEFAULT_THREAD_ID = "";
        private static final long serialVersionUID = 0;
        public final Boolean limited;
        public final MergeFowardMessageType merge_type;
        public final Boolean need_copy_reaction;
        public final String thread_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<OptionPutInfo, Builder> {
            public Boolean limited;
            public MergeFowardMessageType merge_type;
            public Boolean need_copy_reaction;
            public String thread_id;

            @Override // com.squareup.wire.Message.Builder
            public OptionPutInfo build() {
                return new OptionPutInfo(this.merge_type, this.thread_id, this.limited, this.need_copy_reaction, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder limited(Boolean r100) {
                this.limited = r100;
                return this;
            }

            public Builder merge_type(MergeFowardMessageType r100) {
                this.merge_type = r100;
                return this;
            }

            public Builder need_copy_reaction(Boolean r100) {
                this.need_copy_reaction = r100;
                return this;
            }

            public Builder thread_id(String r100) {
                this.thread_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_OptionPutInfo extends ProtoAdapter<OptionPutInfo> {
            public ProtoAdapter_OptionPutInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, OptionPutInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public OptionPutInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.merge_type = MergeFowardMessageType.MERGE_MESSAGE;
                r101.thread_id = "";
                Boolean r102 = Boolean.FALSE;
                r101.limited = r102;
                r101.need_copy_reaction = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L21;
                if (r104 != 1) goto L8;
                r101.merge_type = MergeFowardMessageType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r104 != 2) goto L10;
                r101.thread_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r104 != 3) goto L12;
                r101.limited = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                if (r104 != 4) goto L13;
                r101.need_copy_reaction = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(OptionPutInfo r100) {
                MergeFowardMessageType r101 = r100.merge_type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = MergeFowardMessageType.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.thread_id;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.limited;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Boolean r110 = r100.need_copy_reaction;
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
            public /* bridge */ /* synthetic */ OptionPutInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(OptionPutInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, OptionPutInfo r101) throws IOException {
                MergeFowardMessageType r102 = r101.merge_type;
                if (r102 == null) goto L5;
                MergeFowardMessageType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.thread_id;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.limited;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                Boolean r105 = r101.need_copy_reaction;
                if (r105 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OptionPutInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OptionPutInfo();
            DEFAULT_MERGE_TYPE = MergeFowardMessageType.MERGE_MESSAGE;
            Boolean r100 = Boolean.FALSE;
            DEFAULT_LIMITED = r100;
            DEFAULT_NEED_COPY_REACTION = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.merge_type = this.merge_type;
            r100.thread_id = this.thread_id;
            r100.limited = this.limited;
            r100.need_copy_reaction = this.need_copy_reaction;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return OptionPutInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public OptionPutInfo(MergeFowardMessageType r100, String r101, Boolean r102, Boolean r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public OptionPutInfo(MergeFowardMessageType r100, String r101, Boolean r102, Boolean r103, ByteString r104) {
            super(ADAPTER, r104);
            this.merge_type = r100;
            this.thread_id = r101;
            this.limited = r102;
            this.need_copy_reaction = r103;
        }
    }

    public static final class ProtoAdapter_MergeForwardContent extends ProtoAdapter<MergeForwardContent> {
        private final ProtoAdapter<Map<String, ChatterInfo>> chatters;
        private final ProtoAdapter<Map<String, String>> creator_i18n_names;
        private final ProtoAdapter<Map<String, String>> i18n_thread_title;
        private final ProtoAdapter<Map<Long, MessageThread>> message_threads;
        private final ProtoAdapter<Map<String, String>> partner_i18n_names;
        private final ProtoAdapter<Map<String, MessageReaction>> reaction_snapshots;

        public ProtoAdapter_MergeForwardContent() {
            super(FieldEncoding.LENGTH_DELIMITED, MergeForwardContent.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.creator_i18n_names = ProtoAdapter.newMapAdapter(r100, r100);
            this.partner_i18n_names = ProtoAdapter.newMapAdapter(r100, r100);
            this.chatters = ProtoAdapter.newMapAdapter(r100, ChatterInfo.ADAPTER);
            this.reaction_snapshots = ProtoAdapter.newMapAdapter(r100, MessageReaction.ADAPTER);
            this.i18n_thread_title = ProtoAdapter.newMapAdapter(r100, r100);
            this.message_threads = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, MessageThread.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MergeForwardContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_type = Chat.Type.P2P;
            r101.group_chat_name = "";
            r101.p2p_creator_name = "";
            r101.p2p_partner_name = "";
            r101.p2p_creator_id = 0L;
            r101.p2p_partner_id = 0L;
            r101.quasi_title = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_transmit = r102;
            r101.origin_chat_id = 0L;
            r101.is_copy_from_doubao = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L31;
            switch(r104) {
                case 1: goto L30;
                case 2: goto L33;
                case 3: goto L25;
                case 4: goto L24;
                case 5: goto L23;
                case 6: goto L22;
                case 7: goto L21;
                case 8: goto L20;
                case 9: goto L19;
                case 10: goto L18;
                case 11: goto L17;
                case 12: goto L16;
                case 13: goto L15;
                default: goto L6;
            };
        L33:
            r101.chat_type = Chat.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L28
        L28:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            r101.i18n_thread_title.putAll(this.i18n_thread_title.decode(r100));
            goto L3
        L16:
            r101.thread = Thread.ADAPTER.decode(r100);
            goto L3
        L17:
            r101.reaction_snapshots.putAll(this.reaction_snapshots.decode(r100));
            goto L3
        L18:
            r101.chatters.putAll(this.chatters.decode(r100));
            goto L3
        L19:
            r101.p2p_partner_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L20:
            r101.p2p_creator_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L21:
            r101.partner_i18n_names.putAll(this.partner_i18n_names.decode(r100));
            goto L3
        L22:
            r101.creator_i18n_names.putAll(this.creator_i18n_names.decode(r100));
            goto L3
        L23:
            r101.p2p_partner_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L24:
            r101.p2p_creator_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L25:
            r101.group_chat_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L30:
            r101.messages.add(Message.ADAPTER.decode(r100));
            goto L3
        L6:
            switch(r104) {
                case 20: goto L14;
                case 21: goto L13;
                case 22: goto L12;
                case 23: goto L11;
                case 24: goto L10;
                case 25: goto L9;
                case 26: goto L8;
                default: goto L7;
            };
        L8:
            r101.is_copy_from_doubao = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.origin_chat = Chat.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.origin_chat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            r101.message_threads.putAll(this.message_threads.decode(r100));
            goto L3
        L12:
            r101.is_transmit = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.put_info = OptionPutInfo.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.quasi_title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L7:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L31:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MergeForwardContent r100) {
            int r101 = Message.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.messages);
            Chat.Type r102 = r100.chat_type;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = Chat.Type.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            String r106 = r100.group_chat_name;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.STRING.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            String r109 = r100.p2p_creator_name;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.STRING.encodedSizeWithTag(4, r109);
        L14:
            int r111 = r108 + r110;
            String r112 = r100.p2p_partner_name;
            if (r112 == null) goto L17;
            int r113 = ProtoAdapter.STRING.encodedSizeWithTag(5, r112);
        L18:
            int r114 = ((r111 + r113) + this.creator_i18n_names.encodedSizeWithTag(6, r100.creator_i18n_names)) + this.partner_i18n_names.encodedSizeWithTag(7, r100.partner_i18n_names);
            Long r115 = r100.p2p_creator_id;
            if (r115 == null) goto L21;
            int r116 = ProtoAdapter.INT64.encodedSizeWithTag(8, r115);
        L22:
            int r117 = r114 + r116;
            Long r118 = r100.p2p_partner_id;
            if (r118 == null) goto L25;
            int r119 = ProtoAdapter.INT64.encodedSizeWithTag(9, r118);
        L26:
            int r120 = ((r117 + r119) + this.chatters.encodedSizeWithTag(10, r100.chatters)) + this.reaction_snapshots.encodedSizeWithTag(11, r100.reaction_snapshots);
            Thread r121 = r100.thread;
            if (r121 == null) goto L29;
            int r122 = Thread.ADAPTER.encodedSizeWithTag(12, r121);
        L30:
            int r123 = (r120 + r122) + this.i18n_thread_title.encodedSizeWithTag(13, r100.i18n_thread_title);
            String r124 = r100.quasi_title;
            if (r124 == null) goto L33;
            int r125 = ProtoAdapter.STRING.encodedSizeWithTag(20, r124);
        L34:
            int r126 = r123 + r125;
            OptionPutInfo r127 = r100.put_info;
            if (r127 == null) goto L37;
            int r128 = OptionPutInfo.ADAPTER.encodedSizeWithTag(21, r127);
        L38:
            int r129 = r126 + r128;
            Boolean r130 = r100.is_transmit;
            if (r130 == null) goto L41;
            int r131 = ProtoAdapter.BOOL.encodedSizeWithTag(22, r130);
        L42:
            int r132 = (r129 + r131) + this.message_threads.encodedSizeWithTag(23, r100.message_threads);
            Long r133 = r100.origin_chat_id;
            if (r133 == null) goto L45;
            int r134 = ProtoAdapter.INT64.encodedSizeWithTag(24, r133);
        L46:
            int r135 = r132 + r134;
            Chat r136 = r100.origin_chat;
            if (r136 == null) goto L49;
            int r137 = Chat.ADAPTER.encodedSizeWithTag(25, r136);
        L50:
            int r138 = r135 + r137;
            Boolean r139 = r100.is_copy_from_doubao;
            if (r139 == null) goto L54;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(26, r139);
        L54:
            return (r138 + r103) + r100.unknownFields().size();
        L49:
            r137 = 0;
            goto L50
        L45:
            r134 = 0;
            goto L46
        L41:
            r131 = 0;
            goto L42
        L37:
            r128 = 0;
            goto L38
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
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MergeForwardContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MergeForwardContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MergeForwardContent r101) throws IOException {
            Message.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.messages);
            Chat.Type r102 = r101.chat_type;
            if (r102 == null) goto L5;
            Chat.Type.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            String r103 = r101.group_chat_name;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L8:
            String r104 = r101.p2p_creator_name;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
        L11:
            String r105 = r101.p2p_partner_name;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r105);
        L14:
            this.creator_i18n_names.encodeWithTag(r100, 6, r101.creator_i18n_names);
            this.partner_i18n_names.encodeWithTag(r100, 7, r101.partner_i18n_names);
            Long r106 = r101.p2p_creator_id;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 8, r106);
        L17:
            Long r107 = r101.p2p_partner_id;
            if (r107 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 9, r107);
        L20:
            this.chatters.encodeWithTag(r100, 10, r101.chatters);
            this.reaction_snapshots.encodeWithTag(r100, 11, r101.reaction_snapshots);
            Thread r108 = r101.thread;
            if (r108 == null) goto L23;
            Thread.ADAPTER.encodeWithTag(r100, 12, r108);
        L23:
            this.i18n_thread_title.encodeWithTag(r100, 13, r101.i18n_thread_title);
            String r109 = r101.quasi_title;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 20, r109);
        L26:
            OptionPutInfo r110 = r101.put_info;
            if (r110 == null) goto L29;
            OptionPutInfo.ADAPTER.encodeWithTag(r100, 21, r110);
        L29:
            Boolean r111 = r101.is_transmit;
            if (r111 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 22, r111);
        L32:
            this.message_threads.encodeWithTag(r100, 23, r101.message_threads);
            Long r112 = r101.origin_chat_id;
            if (r112 == null) goto L35;
            ProtoAdapter.INT64.encodeWithTag(r100, 24, r112);
        L35:
            Chat r113 = r101.origin_chat;
            if (r113 == null) goto L38;
            Chat.ADAPTER.encodeWithTag(r100, 25, r113);
        L38:
            Boolean r114 = r101.is_copy_from_doubao;
            if (r114 == null) goto L41;
            ProtoAdapter.BOOL.encodeWithTag(r100, 26, r114);
        L41:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MergeForwardContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class Reaction extends com.squareup.wire.Message<Reaction, Builder> {
        public static final ProtoAdapter<Reaction> ADAPTER = null;
        public static final Integer DEFAULT_COUNT = null;
        public static final String DEFAULT_TYPE = "";
        private static final long serialVersionUID = 0;
        public final List<String> chatter_ids;
        public final Integer count;
        public final String type;

        public static final class Builder extends com.squareup.wire.Message.Builder<Reaction, Builder> {
            public List<String> chatter_ids;
            public Integer count;
            public String type;

            @Override // com.squareup.wire.Message.Builder
            public Reaction build() {
                return new Reaction(this.type, this.count, this.chatter_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.chatter_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder chatter_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.chatter_ids = r100;
                return this;
            }

            public Builder count(Integer r100) {
                this.count = r100;
                return this;
            }

            public Builder type(String r100) {
                this.type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Reaction extends ProtoAdapter<Reaction> {
            public ProtoAdapter_Reaction() {
                super(FieldEncoding.LENGTH_DELIMITED, Reaction.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Reaction decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = "";
                r101.count = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.type = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.count = ProtoAdapter.INT32.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.chatter_ids.add(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(Reaction r100) {
                String r101 = r100.type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.count;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                return ((r103 + r102) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(3, r100.chatter_ids)) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Reaction decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Reaction r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Reaction r101) throws IOException {
                String r102 = r101.type;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.count;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 3, r101.chatter_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Reaction r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Reaction();
            DEFAULT_COUNT = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.count = this.count;
            r100.chatter_ids = Internal.copyOf("chatter_ids", this.chatter_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Reaction.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Reaction(String r100, Integer r101, List<String> r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public Reaction(String r100, Integer r101, List<String> r102, ByteString r103) {
            super(ADAPTER, r103);
            this.type = r100;
            this.count = r101;
            this.chatter_ids = Internal.immutableCopyOf("chatter_ids", r102);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MergeForwardContent();
        DEFAULT_CHAT_TYPE = Chat.Type.P2P;
        DEFAULT_P2P_CREATOR_ID = 0L;
        DEFAULT_P2P_PARTNER_ID = 0L;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_TRANSMIT = r100;
        DEFAULT_ORIGIN_CHAT_ID = 0L;
        DEFAULT_IS_COPY_FROM_DOUBAO = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.messages = Internal.copyOf("messages", this.messages);
        r100.chat_type = this.chat_type;
        r100.group_chat_name = this.group_chat_name;
        r100.p2p_creator_name = this.p2p_creator_name;
        r100.p2p_partner_name = this.p2p_partner_name;
        r100.creator_i18n_names = Internal.copyOf("creator_i18n_names", this.creator_i18n_names);
        r100.partner_i18n_names = Internal.copyOf("partner_i18n_names", this.partner_i18n_names);
        r100.p2p_creator_id = this.p2p_creator_id;
        r100.p2p_partner_id = this.p2p_partner_id;
        r100.chatters = Internal.copyOf("chatters", this.chatters);
        r100.reaction_snapshots = Internal.copyOf("reaction_snapshots", this.reaction_snapshots);
        r100.thread = this.thread;
        r100.i18n_thread_title = Internal.copyOf("i18n_thread_title", this.i18n_thread_title);
        r100.quasi_title = this.quasi_title;
        r100.put_info = this.put_info;
        r100.is_transmit = this.is_transmit;
        r100.message_threads = Internal.copyOf("message_threads", this.message_threads);
        r100.origin_chat_id = this.origin_chat_id;
        r100.origin_chat = this.origin_chat;
        r100.is_copy_from_doubao = this.is_copy_from_doubao;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MergeForwardContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public MergeForwardContent(List<Message> r210, Chat.Type r211, String r212, String r213, String r214, Map<String, String> r215, Map<String, String> r216, Long r310, Long r311, Map<String, ChatterInfo> r312, Map<String, MessageReaction> r313, Thread r314, Map<String, String> r315, String r316, OptionPutInfo r317, Boolean r318, Map<Long, MessageThread> r319, Long r410, Chat r411, Boolean r412) {
        this(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, ByteString.EMPTY);
    }

    public MergeForwardContent(List<Message> r100, Chat.Type r101, String r102, String r103, String r104, Map<String, String> r105, Map<String, String> r110, Long r111, Long r112, Map<String, ChatterInfo> r113, Map<String, MessageReaction> r114, Thread r115, Map<String, String> r116, String r117, OptionPutInfo r118, Boolean r119, Map<Long, MessageThread> r210, Long r211, Chat r212, Boolean r213, ByteString r214) {
        super(ADAPTER, r214);
        this.messages = Internal.immutableCopyOf("messages", r100);
        this.chat_type = r101;
        this.group_chat_name = r102;
        this.p2p_creator_name = r103;
        this.p2p_partner_name = r104;
        this.creator_i18n_names = Internal.immutableCopyOf("creator_i18n_names", r105);
        this.partner_i18n_names = Internal.immutableCopyOf("partner_i18n_names", r110);
        this.p2p_creator_id = r111;
        this.p2p_partner_id = r112;
        this.chatters = Internal.immutableCopyOf("chatters", r113);
        this.reaction_snapshots = Internal.immutableCopyOf("reaction_snapshots", r114);
        this.thread = r115;
        this.i18n_thread_title = Internal.immutableCopyOf("i18n_thread_title", r116);
        this.quasi_title = r117;
        this.put_info = r118;
        this.is_transmit = r119;
        this.message_threads = Internal.immutableCopyOf("message_threads", r210);
        this.origin_chat_id = r211;
        this.origin_chat = r212;
        this.is_copy_from_doubao = r213;
    }
}
