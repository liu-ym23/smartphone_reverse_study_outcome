package com.bytedance.lark.pb.feed.v1;

import com.bytedance.lark.pb.basic.v1.Chat;
import com.obric.capabilitykit.EntityProvider;
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
public final class ThreadData extends Message<ThreadData, Builder> {
    public static final ProtoAdapter<ThreadData> ADAPTER = null;
    public static final Integer DEFAULT_AT_INFOS_COUNT = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_AVATAR_PATH = "";
    public static final String DEFAULT_CHATTER_ID = "";
    public static final String DEFAULT_CHAT_ID = "";
    public static final Chat.Type DEFAULT_CHAT_TYPE = null;
    public static final Long DEFAULT_DISPLAY_TIME = null;
    public static final EntityStatus DEFAULT_ENTITY_STATUS = null;
    public static final EntityType DEFAULT_ENTITY_TYPE = null;
    public static final Boolean DEFAULT_IS_REMIND = null;
    public static final Long DEFAULT_LAST_AT_RANK_TIME = null;
    public static final com.bytedance.lark.pb.basic.v1.Message.Type DEFAULT_LAST_MESSAGE_TYPE = null;
    public static final String DEFAULT_LOCALIZED_DIGEST_MESSAGE = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_ORIGINAL_DIGEST_MESSAGE = "";
    public static final Long DEFAULT_RANK_TIME = null;
    public static final Integer DEFAULT_UNREAD_COUNT = null;
    private static final long serialVersionUID = 0;
    public final AtInfo at_info;
    public final List<AtInfo> at_infos;
    public final Integer at_infos_count;
    public final String avatar_key;
    public final String avatar_path;
    public final List<String> avatar_urls;
    public final String chat_id;
    public final Chat.Type chat_type;
    public final String chatter_id;
    public final Digest digest;
    public final Long display_time;
    public final DraftPreview draft_preview;
    public final EntityStatus entity_status;
    public final EntityType entity_type;
    public final Boolean is_remind;
    public final Digest last_at_digest;
    public final Long last_at_rank_time;
    public final com.bytedance.lark.pb.basic.v1.Message.Type last_message_type;
    public final String localized_digest_message;
    public final String name;
    public final String original_digest_message;
    public final Long rank_time;
    public final List<com.bytedance.lark.pb.basic.v1.Message.Reaction> reactions;
    public final Integer unread_count;

    public static final class Builder extends Message.Builder<ThreadData, Builder> {
        public AtInfo at_info;
        public List<AtInfo> at_infos;
        public Integer at_infos_count;
        public String avatar_key;
        public String avatar_path;
        public List<String> avatar_urls;
        public String chat_id;
        public Chat.Type chat_type;
        public String chatter_id;
        public Digest digest;
        public Long display_time;
        public DraftPreview draft_preview;
        public EntityStatus entity_status;
        public EntityType entity_type;
        public Boolean is_remind;
        public Digest last_at_digest;
        public Long last_at_rank_time;
        public com.bytedance.lark.pb.basic.v1.Message.Type last_message_type;
        public String localized_digest_message;
        public String name;
        public String original_digest_message;
        public Long rank_time;
        public List<com.bytedance.lark.pb.basic.v1.Message.Reaction> reactions;
        public Integer unread_count;

        @Override // com.squareup.wire.Message.Builder
        public ThreadData build() {
            String r100 = this.name;
            if (r100 == null) goto L11;
            if (this.entity_type == null) goto L11;
            if (this.is_remind == null) goto L11;
            return new ThreadData(this.name, this.entity_type, this.avatar_key, this.avatar_path, this.avatar_urls, this.unread_count, this.draft_preview, this.at_info, this.at_infos, this.localized_digest_message, this.entity_status, this.display_time, this.rank_time, this.original_digest_message, this.chat_id, this.is_remind, this.at_infos_count, this.digest, this.reactions, this.chat_type, this.chatter_id, this.last_at_digest, this.last_at_rank_time, this.last_message_type, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "name", this.entity_type, EntityProvider.KEY_ENTITY_TYPE, this.is_remind, "is_remind"});
        }

        public Builder() {
            this.avatar_urls = Internal.newMutableList();
            this.at_infos = Internal.newMutableList();
            this.reactions = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder at_info(AtInfo r100) {
            this.at_info = r100;
            return this;
        }

        public Builder at_infos(List<AtInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.at_infos = r100;
            return this;
        }

        public Builder at_infos_count(Integer r100) {
            this.at_infos_count = r100;
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

        public Builder avatar_urls(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.avatar_urls = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder chat_type(Chat.Type r100) {
            this.chat_type = r100;
            return this;
        }

        public Builder chatter_id(String r100) {
            this.chatter_id = r100;
            return this;
        }

        public Builder digest(Digest r100) {
            this.digest = r100;
            return this;
        }

        public Builder display_time(Long r100) {
            this.display_time = r100;
            return this;
        }

        public Builder draft_preview(DraftPreview r100) {
            this.draft_preview = r100;
            return this;
        }

        public Builder entity_status(EntityStatus r100) {
            this.entity_status = r100;
            return this;
        }

        public Builder entity_type(EntityType r100) {
            this.entity_type = r100;
            return this;
        }

        public Builder is_remind(Boolean r100) {
            this.is_remind = r100;
            return this;
        }

        public Builder last_at_digest(Digest r100) {
            this.last_at_digest = r100;
            return this;
        }

        public Builder last_at_rank_time(Long r100) {
            this.last_at_rank_time = r100;
            return this;
        }

        public Builder last_message_type(com.bytedance.lark.pb.basic.v1.Message.Type r100) {
            this.last_message_type = r100;
            return this;
        }

        public Builder localized_digest_message(String r100) {
            this.localized_digest_message = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder original_digest_message(String r100) {
            this.original_digest_message = r100;
            return this;
        }

        public Builder rank_time(Long r100) {
            this.rank_time = r100;
            return this;
        }

        public Builder reactions(List<com.bytedance.lark.pb.basic.v1.Message.Reaction> r100) {
            Internal.checkElementsNotNull(r100);
            this.reactions = r100;
            return this;
        }

        public Builder unread_count(Integer r100) {
            this.unread_count = r100;
            return this;
        }
    }

    public static final enum EntityType extends Enum<EntityType> implements WireEnum {
        private static final /* synthetic */ EntityType[] $VALUES = null;
        public static final ProtoAdapter<EntityType> ADAPTER = null;
        public static final EntityType MSG_THREAD = null;
        public static final EntityType THREAD = null;
        public static final EntityType TOPIC = null;
        private final int value;

        static {
            EntityType r100 = new EntityType("THREAD", 0, 1);
            THREAD = r100;
            EntityType r101 = new EntityType("TOPIC", 1, 2);
            TOPIC = r101;
            EntityType r102 = new EntityType("MSG_THREAD", 2, 3);
            MSG_THREAD = r102;
            $VALUES = new EntityType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(EntityType.class);
        }

        public static EntityType[] values() {
            return (EntityType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static EntityType fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return MSG_THREAD;
        L13:
            return TOPIC;
        L15:
            return THREAD;
        }

        public static EntityType valueOf(String r100) {
            return (EntityType) a.a(EntityType.class, r100);
        }

        private EntityType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_ThreadData extends ProtoAdapter<ThreadData> {
        public ProtoAdapter_ThreadData() {
            super(FieldEncoding.LENGTH_DELIMITED, ThreadData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ThreadData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.name = "";
            r101.entity_type = EntityType.THREAD;
            r101.avatar_key = "";
            r101.avatar_path = "";
            r101.unread_count = 0;
            r101.localized_digest_message = "";
            r101.entity_status = EntityStatus.NORMAL;
            r101.display_time = 0L;
            r101.rank_time = 0L;
            r101.original_digest_message = "";
            r101.chat_id = "";
            r101.is_remind = Boolean.FALSE;
            r101.at_infos_count = 0;
            r101.chat_type = Chat.Type.P2P;
            r101.chatter_id = "";
            r101.last_at_rank_time = 0L;
            r101.last_message_type = com.bytedance.lark.pb.basic.v1.Message.Type.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L43;
            switch(r103) {
                case 1: goto L42;
                case 2: goto L45;
                case 3: goto L37;
                case 4: goto L36;
                case 5: goto L35;
                case 6: goto L34;
                case 7: goto L33;
                case 8: goto L32;
                case 9: goto L31;
                case 10: goto L30;
                case 11: goto L47;
                case 12: goto L25;
                case 13: goto L24;
                case 14: goto L23;
                case 15: goto L22;
                case 16: goto L21;
                case 17: goto L20;
                case 18: goto L19;
                case 19: goto L18;
                case 20: goto L49;
                case 21: goto L13;
                case 22: goto L12;
                case 23: goto L11;
                case 24: goto L51;
                default: goto L6;
            };
        L45:
            r101.entity_type = EntityType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L40
        L40:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L47:
            r101.entity_status = EntityStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L28
        L28:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L49:
            r101.chat_type = Chat.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L51:
            r101.last_message_type = com.bytedance.lark.pb.basic.v1.Message.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.last_at_rank_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            r101.last_at_digest = Digest.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.chatter_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.reactions.add(com.bytedance.lark.pb.basic.v1.Message.Reaction.ADAPTER.decode(r100));
            goto L3
        L19:
            r101.digest = Digest.ADAPTER.decode(r100);
            goto L3
        L20:
            r101.at_infos_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L21:
            r101.is_remind = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L22:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L23:
            r101.original_digest_message = ProtoAdapter.STRING.decode(r100);
            goto L3
        L24:
            r101.rank_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L25:
            r101.display_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L30:
            r101.localized_digest_message = ProtoAdapter.STRING.decode(r100);
            goto L3
        L31:
            r101.at_infos.add(AtInfo.ADAPTER.decode(r100));
            goto L3
        L32:
            r101.at_info = AtInfo.ADAPTER.decode(r100);
            goto L3
        L33:
            r101.draft_preview = DraftPreview.ADAPTER.decode(r100);
            goto L3
        L34:
            r101.unread_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L35:
            r101.avatar_urls.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L36:
            r101.avatar_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L37:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L42:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L43:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ThreadData r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.name) + EntityType.ADAPTER.encodedSizeWithTag(2, r100.entity_type);
            String r103 = r100.avatar_key;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.avatar_path;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(4, r107);
        L10:
            int r109 = (r106 + r108) + r101.asRepeated().encodedSizeWithTag(5, r100.avatar_urls);
            Integer r110 = r100.unread_count;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.INT32.encodedSizeWithTag(6, r110);
        L14:
            int r112 = r109 + r111;
            DraftPreview r113 = r100.draft_preview;
            if (r113 == null) goto L17;
            int r114 = DraftPreview.ADAPTER.encodedSizeWithTag(7, r113);
        L18:
            int r115 = r112 + r114;
            AtInfo r116 = r100.at_info;
            if (r116 == null) goto L21;
            int r117 = AtInfo.ADAPTER.encodedSizeWithTag(8, r116);
        L22:
            int r118 = (r115 + r117) + AtInfo.ADAPTER.asRepeated().encodedSizeWithTag(9, r100.at_infos);
            String r119 = r100.localized_digest_message;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(10, r119);
        L26:
            int r121 = r118 + r120;
            EntityStatus r122 = r100.entity_status;
            if (r122 == null) goto L29;
            int r123 = EntityStatus.ADAPTER.encodedSizeWithTag(11, r122);
        L30:
            int r124 = r121 + r123;
            Long r125 = r100.display_time;
            if (r125 == null) goto L33;
            int r126 = ProtoAdapter.INT64.encodedSizeWithTag(12, r125);
        L34:
            int r127 = r124 + r126;
            Long r128 = r100.rank_time;
            if (r128 == null) goto L37;
            int r129 = ProtoAdapter.INT64.encodedSizeWithTag(13, r128);
        L38:
            int r130 = r127 + r129;
            String r131 = r100.original_digest_message;
            if (r131 == null) goto L41;
            int r132 = r101.encodedSizeWithTag(14, r131);
        L42:
            int r133 = r130 + r132;
            String r134 = r100.chat_id;
            if (r134 == null) goto L45;
            int r135 = r101.encodedSizeWithTag(15, r134);
        L46:
            int r136 = (r133 + r135) + ProtoAdapter.BOOL.encodedSizeWithTag(16, r100.is_remind);
            Integer r137 = r100.at_infos_count;
            if (r137 == null) goto L49;
            int r138 = ProtoAdapter.INT32.encodedSizeWithTag(17, r137);
        L50:
            int r139 = r136 + r138;
            Digest r140 = r100.digest;
            if (r140 == null) goto L53;
            int r141 = Digest.ADAPTER.encodedSizeWithTag(18, r140);
        L54:
            int r142 = (r139 + r141) + com.bytedance.lark.pb.basic.v1.Message.Reaction.ADAPTER.asRepeated().encodedSizeWithTag(19, r100.reactions);
            Chat.Type r143 = r100.chat_type;
            if (r143 == null) goto L57;
            int r144 = Chat.Type.ADAPTER.encodedSizeWithTag(20, r143);
        L58:
            int r145 = r142 + r144;
            String r146 = r100.chatter_id;
            if (r146 == null) goto L61;
            int r147 = r101.encodedSizeWithTag(21, r146);
        L62:
            int r148 = r145 + r147;
            Digest r149 = r100.last_at_digest;
            if (r149 == null) goto L65;
            int r150 = Digest.ADAPTER.encodedSizeWithTag(22, r149);
        L66:
            int r151 = r148 + r150;
            Long r152 = r100.last_at_rank_time;
            if (r152 == null) goto L69;
            int r153 = ProtoAdapter.INT64.encodedSizeWithTag(23, r152);
        L70:
            int r154 = r151 + r153;
            com.bytedance.lark.pb.basic.v1.Message.Type r155 = r100.last_message_type;
            if (r155 == null) goto L74;
            r104 = com.bytedance.lark.pb.basic.v1.Message.Type.ADAPTER.encodedSizeWithTag(24, r155);
        L74:
            return (r154 + r104) + r100.unknownFields().size();
        L69:
            r153 = 0;
            goto L70
        L65:
            r150 = 0;
            goto L66
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
        public /* bridge */ /* synthetic */ ThreadData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ThreadData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ThreadData r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.name);
            EntityType.ADAPTER.encodeWithTag(r100, 2, r101.entity_type);
            String r103 = r101.avatar_key;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            String r104 = r101.avatar_path;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            r102.asRepeated().encodeWithTag(r100, 5, r101.avatar_urls);
            Integer r105 = r101.unread_count;
            if (r105 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r105);
        L11:
            DraftPreview r106 = r101.draft_preview;
            if (r106 == null) goto L14;
            DraftPreview.ADAPTER.encodeWithTag(r100, 7, r106);
        L14:
            AtInfo r107 = r101.at_info;
            if (r107 == null) goto L17;
            AtInfo.ADAPTER.encodeWithTag(r100, 8, r107);
        L17:
            AtInfo.ADAPTER.asRepeated().encodeWithTag(r100, 9, r101.at_infos);
            String r108 = r101.localized_digest_message;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 10, r108);
        L20:
            EntityStatus r109 = r101.entity_status;
            if (r109 == null) goto L23;
            EntityStatus.ADAPTER.encodeWithTag(r100, 11, r109);
        L23:
            Long r110 = r101.display_time;
            if (r110 == null) goto L26;
            ProtoAdapter.INT64.encodeWithTag(r100, 12, r110);
        L26:
            Long r111 = r101.rank_time;
            if (r111 == null) goto L29;
            ProtoAdapter.INT64.encodeWithTag(r100, 13, r111);
        L29:
            String r112 = r101.original_digest_message;
            if (r112 == null) goto L32;
            r102.encodeWithTag(r100, 14, r112);
        L32:
            String r113 = r101.chat_id;
            if (r113 == null) goto L35;
            r102.encodeWithTag(r100, 15, r113);
        L35:
            ProtoAdapter.BOOL.encodeWithTag(r100, 16, r101.is_remind);
            Integer r114 = r101.at_infos_count;
            if (r114 == null) goto L38;
            ProtoAdapter.INT32.encodeWithTag(r100, 17, r114);
        L38:
            Digest r115 = r101.digest;
            if (r115 == null) goto L41;
            Digest.ADAPTER.encodeWithTag(r100, 18, r115);
        L41:
            com.bytedance.lark.pb.basic.v1.Message.Reaction.ADAPTER.asRepeated().encodeWithTag(r100, 19, r101.reactions);
            Chat.Type r116 = r101.chat_type;
            if (r116 == null) goto L44;
            Chat.Type.ADAPTER.encodeWithTag(r100, 20, r116);
        L44:
            String r117 = r101.chatter_id;
            if (r117 == null) goto L47;
            r102.encodeWithTag(r100, 21, r117);
        L47:
            Digest r118 = r101.last_at_digest;
            if (r118 == null) goto L50;
            Digest.ADAPTER.encodeWithTag(r100, 22, r118);
        L50:
            Long r119 = r101.last_at_rank_time;
            if (r119 == null) goto L53;
            ProtoAdapter.INT64.encodeWithTag(r100, 23, r119);
        L53:
            com.bytedance.lark.pb.basic.v1.Message.Type r120 = r101.last_message_type;
            if (r120 == null) goto L56;
            com.bytedance.lark.pb.basic.v1.Message.Type.ADAPTER.encodeWithTag(r100, 24, r120);
        L56:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ThreadData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ThreadData();
        DEFAULT_ENTITY_TYPE = EntityType.THREAD;
        DEFAULT_UNREAD_COUNT = 0;
        DEFAULT_ENTITY_STATUS = EntityStatus.NORMAL;
        DEFAULT_DISPLAY_TIME = 0L;
        DEFAULT_RANK_TIME = 0L;
        DEFAULT_IS_REMIND = Boolean.FALSE;
        DEFAULT_AT_INFOS_COUNT = 0;
        DEFAULT_CHAT_TYPE = Chat.Type.P2P;
        DEFAULT_LAST_AT_RANK_TIME = 0L;
        DEFAULT_LAST_MESSAGE_TYPE = com.bytedance.lark.pb.basic.v1.Message.Type.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.name = this.name;
        r100.entity_type = this.entity_type;
        r100.avatar_key = this.avatar_key;
        r100.avatar_path = this.avatar_path;
        r100.avatar_urls = Internal.copyOf("avatar_urls", this.avatar_urls);
        r100.unread_count = this.unread_count;
        r100.draft_preview = this.draft_preview;
        r100.at_info = this.at_info;
        r100.at_infos = Internal.copyOf("at_infos", this.at_infos);
        r100.localized_digest_message = this.localized_digest_message;
        r100.entity_status = this.entity_status;
        r100.display_time = this.display_time;
        r100.rank_time = this.rank_time;
        r100.original_digest_message = this.original_digest_message;
        r100.chat_id = this.chat_id;
        r100.is_remind = this.is_remind;
        r100.at_infos_count = this.at_infos_count;
        r100.digest = this.digest;
        r100.reactions = Internal.copyOf("reactions", this.reactions);
        r100.chat_type = this.chat_type;
        r100.chatter_id = this.chatter_id;
        r100.last_at_digest = this.last_at_digest;
        r100.last_at_rank_time = this.last_at_rank_time;
        r100.last_message_type = this.last_message_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ThreadData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ThreadData(String r210, EntityType r211, String r212, String r310, List<String> r311, Integer r312, DraftPreview r313, AtInfo r314, List<AtInfo> r315, String r316, EntityStatus r317, Long r318, Long r319, String r410, String r411, Boolean r412, Integer r413, Digest r414, List<com.bytedance.lark.pb.basic.v1.Message.Reaction> r415, Chat.Type r416, String r417, Digest r418, Long r419, com.bytedance.lark.pb.basic.v1.Message.Type r510) {
        this(r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, ByteString.EMPTY);
    }

    public ThreadData(String r100, EntityType r101, String r102, String r103, List<String> r104, Integer r105, DraftPreview r110, AtInfo r111, List<AtInfo> r112, String r113, EntityStatus r114, Long r115, Long r116, String r117, String r118, Boolean r119, Integer r210, Digest r211, List<com.bytedance.lark.pb.basic.v1.Message.Reaction> r212, Chat.Type r213, String r214, Digest r215, Long r216, com.bytedance.lark.pb.basic.v1.Message.Type r217, ByteString r218) {
        super(ADAPTER, r218);
        this.name = r100;
        this.entity_type = r101;
        this.avatar_key = r102;
        this.avatar_path = r103;
        this.avatar_urls = Internal.immutableCopyOf("avatar_urls", r104);
        this.unread_count = r105;
        this.draft_preview = r110;
        this.at_info = r111;
        this.at_infos = Internal.immutableCopyOf("at_infos", r112);
        this.localized_digest_message = r113;
        this.entity_status = r114;
        this.display_time = r115;
        this.rank_time = r116;
        this.original_digest_message = r117;
        this.chat_id = r118;
        this.is_remind = r119;
        this.at_infos_count = r210;
        this.digest = r211;
        this.reactions = Internal.immutableCopyOf("reactions", r212);
        this.chat_type = r213;
        this.chatter_id = r214;
        this.last_at_digest = r215;
        this.last_at_rank_time = r216;
        this.last_message_type = r217;
    }
}
