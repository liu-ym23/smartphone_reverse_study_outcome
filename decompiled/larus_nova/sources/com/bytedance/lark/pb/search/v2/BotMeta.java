package com.bytedance.lark.pb.search.v2;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.Tag;
import com.bytedance.lark.pb.search.v1.TimeZone;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class BotMeta extends Message<BotMeta, Builder> {
    public static final ProtoAdapter<BotMeta> ADAPTER = null;
    public static final Integer DEFAULT_BOT_EXT_TYPE = null;
    public static final Boolean DEFAULT_CAN_JOIN_GROUP = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Chatter.Description.Type DEFAULT_DESCRIPTION_FLAG = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IN_CONTACTS = null;
    public static final Boolean DEFAULT_IS_AGENT = null;
    public static final String DEFAULT_TENANT_ID = "";
    public static final String DEFAULT_WITH_BOT_TAG = "bot";
    private static final long serialVersionUID = 0;
    public final Integer bot_ext_type;
    public final Boolean can_join_group;
    public final String description;
    public final Chatter.Description.Type description_flag;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253701id;
    public final Boolean in_contacts;
    public final Boolean is_agent;
    public final SimpleP2PChatInfo p2p_chat_info;
    public final List<Tag> tags;
    public final String tenant_id;
    public final TimeZone timezone;
    public final String with_bot_tag;

    public static final class Builder extends Message.Builder<BotMeta, Builder> {
        public Integer bot_ext_type;
        public Boolean can_join_group;
        public String description;
        public Chatter.Description.Type description_flag;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253702id;
        public Boolean in_contacts;
        public Boolean is_agent;
        public SimpleP2PChatInfo p2p_chat_info;
        public List<Tag> tags;
        public String tenant_id;
        public TimeZone timezone;
        public String with_bot_tag;

        @Override // com.squareup.wire.Message.Builder
        public BotMeta build() {
            String r100 = this.f253702id;
            if (r100 == null) goto L7;
            return new BotMeta(this.f253702id, this.tenant_id, this.timezone, this.with_bot_tag, this.in_contacts, this.can_join_group, this.description, this.description_flag, this.tags, this.p2p_chat_info, this.bot_ext_type, this.is_agent, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
            this.tags = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder bot_ext_type(Integer r100) {
            this.bot_ext_type = r100;
            return this;
        }

        public Builder can_join_group(Boolean r100) {
            this.can_join_group = r100;
            return this;
        }

        public Builder description(String r100) {
            this.description = r100;
            return this;
        }

        public Builder description_flag(Chatter.Description.Type r100) {
            this.description_flag = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253702id = r100;
            return this;
        }

        public Builder in_contacts(Boolean r100) {
            this.in_contacts = r100;
            return this;
        }

        public Builder is_agent(Boolean r100) {
            this.is_agent = r100;
            return this;
        }

        public Builder p2p_chat_info(SimpleP2PChatInfo r100) {
            this.p2p_chat_info = r100;
            return this;
        }

        public Builder tags(List<Tag> r100) {
            Internal.checkElementsNotNull(r100);
            this.tags = r100;
            return this;
        }

        public Builder tenant_id(String r100) {
            this.tenant_id = r100;
            return this;
        }

        public Builder timezone(TimeZone r100) {
            this.timezone = r100;
            return this;
        }

        public Builder with_bot_tag(String r100) {
            this.with_bot_tag = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BotMeta extends ProtoAdapter<BotMeta> {
        public ProtoAdapter_BotMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, BotMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BotMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253702id = "";
            r101.tenant_id = "";
            r101.with_bot_tag = "bot";
            Boolean r102 = Boolean.TRUE;
            r101.in_contacts = r102;
            r101.can_join_group = r102;
            r101.description = "";
            r101.description_flag = Chatter.Description.Type.ON_DEFAULT;
            r101.bot_ext_type = 0;
            r101.is_agent = Boolean.FALSE;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L25;
            switch(r104) {
                case 1: goto L24;
                case 2: goto L23;
                case 3: goto L22;
                case 4: goto L21;
                case 5: goto L20;
                case 6: goto L19;
                case 7: goto L18;
                case 8: goto L27;
                case 9: goto L29;
                case 10: goto L9;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L6;
            };
        L27:
            r101.description_flag = Chatter.Description.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L29:
            r101.tags.add(Tag.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.is_agent = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.bot_ext_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L9:
            r101.p2p_chat_info = SimpleP2PChatInfo.ADAPTER.decode(r100);
            goto L3
        L18:
            r101.description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.can_join_group = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L20:
            r101.in_contacts = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L21:
            r101.with_bot_tag = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.timezone = TimeZone.ADAPTER.decode(r100);
            goto L3
        L23:
            r101.tenant_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L24:
            r101.f253702id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L25:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BotMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253701id);
            String r103 = r100.tenant_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            TimeZone r107 = r100.timezone;
            if (r107 == null) goto L9;
            int r108 = TimeZone.ADAPTER.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.with_bot_tag;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            Boolean r113 = r100.in_contacts;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            Boolean r116 = r100.can_join_group;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.description;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(7, r119);
        L26:
            int r121 = r118 + r120;
            Chatter.Description.Type r122 = r100.description_flag;
            if (r122 == null) goto L29;
            int r123 = Chatter.Description.Type.ADAPTER.encodedSizeWithTag(8, r122);
        L30:
            int r124 = (r121 + r123) + Tag.ADAPTER.asRepeated().encodedSizeWithTag(9, r100.tags);
            SimpleP2PChatInfo r125 = r100.p2p_chat_info;
            if (r125 == null) goto L33;
            int r126 = SimpleP2PChatInfo.ADAPTER.encodedSizeWithTag(10, r125);
        L34:
            int r127 = r124 + r126;
            Integer r128 = r100.bot_ext_type;
            if (r128 == null) goto L37;
            int r129 = ProtoAdapter.INT32.encodedSizeWithTag(11, r128);
        L38:
            int r130 = r127 + r129;
            Boolean r131 = r100.is_agent;
            if (r131 == null) goto L42;
            r104 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r131);
        L42:
            return (r130 + r104) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ BotMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BotMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BotMeta r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253701id);
            String r103 = r101.tenant_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            TimeZone r104 = r101.timezone;
            if (r104 == null) goto L8;
            TimeZone.ADAPTER.encodeWithTag(r100, 3, r104);
        L8:
            String r105 = r101.with_bot_tag;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            Boolean r106 = r101.in_contacts;
            if (r106 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L14:
            Boolean r107 = r101.can_join_group;
            if (r107 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L17:
            String r108 = r101.description;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 7, r108);
        L20:
            Chatter.Description.Type r109 = r101.description_flag;
            if (r109 == null) goto L23;
            Chatter.Description.Type.ADAPTER.encodeWithTag(r100, 8, r109);
        L23:
            Tag.ADAPTER.asRepeated().encodeWithTag(r100, 9, r101.tags);
            SimpleP2PChatInfo r110 = r101.p2p_chat_info;
            if (r110 == null) goto L26;
            SimpleP2PChatInfo.ADAPTER.encodeWithTag(r100, 10, r110);
        L26:
            Integer r111 = r101.bot_ext_type;
            if (r111 == null) goto L29;
            ProtoAdapter.INT32.encodeWithTag(r100, 11, r111);
        L29:
            Boolean r112 = r101.is_agent;
            if (r112 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 12, r112);
        L32:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BotMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BotMeta();
        Boolean r100 = Boolean.TRUE;
        DEFAULT_IN_CONTACTS = r100;
        DEFAULT_CAN_JOIN_GROUP = r100;
        DEFAULT_DESCRIPTION_FLAG = Chatter.Description.Type.ON_DEFAULT;
        DEFAULT_BOT_EXT_TYPE = 0;
        DEFAULT_IS_AGENT = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253702id = this.f253701id;
        r100.tenant_id = this.tenant_id;
        r100.timezone = this.timezone;
        r100.with_bot_tag = this.with_bot_tag;
        r100.in_contacts = this.in_contacts;
        r100.can_join_group = this.can_join_group;
        r100.description = this.description;
        r100.description_flag = this.description_flag;
        r100.tags = Internal.copyOf(PromotionProductPrivilegesStruct.TAGS, this.tags);
        r100.p2p_chat_info = this.p2p_chat_info;
        r100.bot_ext_type = this.bot_ext_type;
        r100.is_agent = this.is_agent;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BotMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BotMeta(String r110, String r111, TimeZone r112, String r113, Boolean r114, Boolean r210, String r211, Chatter.Description.Type r212, List<Tag> r213, SimpleP2PChatInfo r214, Integer r215, Boolean r216) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, ByteString.EMPTY);
    }

    public BotMeta(String r100, String r101, TimeZone r102, String r103, Boolean r104, Boolean r105, String r106, Chatter.Description.Type r107, List<Tag> r110, SimpleP2PChatInfo r111, Integer r112, Boolean r113, ByteString r114) {
        super(ADAPTER, r114);
        this.f253701id = r100;
        this.tenant_id = r101;
        this.timezone = r102;
        this.with_bot_tag = r103;
        this.in_contacts = r104;
        this.can_join_group = r105;
        this.description = r106;
        this.description_flag = r107;
        this.tags = Internal.immutableCopyOf(PromotionProductPrivilegesStruct.TAGS, r110);
        this.p2p_chat_info = r111;
        this.bot_ext_type = r112;
        this.is_agent = r113;
    }
}
