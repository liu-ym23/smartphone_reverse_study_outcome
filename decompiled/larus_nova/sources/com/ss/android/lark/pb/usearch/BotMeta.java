package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class BotMeta extends Message<BotMeta, Builder> {
    public static final ProtoAdapter<BotMeta> ADAPTER = null;
    public static final Integer DEFAULT_BOT_EXT_TYPE = null;
    public static final Boolean DEFAULT_CAN_JOIN_GROUP = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IN_CONTACTS = null;
    public static final Boolean DEFAULT_IS_AGENT = null;
    public static final String DEFAULT_TENANT_ID = "";
    public static final String DEFAULT_WITH_BOT_TAG = "bot";
    private static final long serialVersionUID = 0;
    public final Integer mbot_ext_type;
    public final Boolean mcan_join_group;
    public final String mchat_id;
    public final ExtraFields mextraFields;
    public final String mid;
    public final Boolean min_contacts;
    public final Boolean mis_agent;
    public final String mtenant_id;
    public final String mwith_bot_tag;

    public static final class Builder extends Message.Builder<BotMeta, Builder> {
        public Integer mbot_ext_type;
        public Boolean mcan_join_group;
        public String mchat_id;
        public ExtraFields mextraFields;
        public String mid;
        public Boolean min_contacts;
        public Boolean mis_agent;
        public String mtenant_id;
        public String mwith_bot_tag;

        @Override // com.squareup.wire.Message.Builder
        public BotMeta build() {
            String r100 = this.mid;
            if (r100 == null) goto L7;
            return new BotMeta(this.mid, this.mtenant_id, this.mwith_bot_tag, this.min_contacts, this.mcan_join_group, this.mchat_id, this.mextraFields, this.mbot_ext_type, this.mis_agent, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mid"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder bot_ext_type(Integer r100) {
            this.mbot_ext_type = r100;
            return this;
        }

        public Builder can_join_group(Boolean r100) {
            this.mcan_join_group = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.mchat_id = r100;
            return this;
        }

        public Builder extraFields(ExtraFields r100) {
            this.mextraFields = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder in_contacts(Boolean r100) {
            this.min_contacts = r100;
            return this;
        }

        public Builder is_agent(Boolean r100) {
            this.mis_agent = r100;
            return this;
        }

        public Builder tenant_id(String r100) {
            this.mtenant_id = r100;
            return this;
        }

        public Builder with_bot_tag(String r100) {
            this.mwith_bot_tag = r100;
            return this;
        }
    }

    public static final class ExtraFields extends Message<ExtraFields, Builder> {
        public static final ProtoAdapter<ExtraFields> ADAPTER = null;
        public static final Boolean DEFAULT_IS_IN_CHAT = null;
        private static final long serialVersionUID = 0;
        public final Boolean mis_in_chat;

        public static final class Builder extends Message.Builder<ExtraFields, Builder> {
            public Boolean mis_in_chat;

            @Override // com.squareup.wire.Message.Builder
            public ExtraFields build() {
                return new ExtraFields(this.mis_in_chat, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder is_in_chat(Boolean r100) {
                this.mis_in_chat = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ExtraFields extends ProtoAdapter<ExtraFields> {
            public ProtoAdapter_ExtraFields() {
                super(FieldEncoding.LENGTH_DELIMITED, ExtraFields.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ExtraFields decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mis_in_chat = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.mis_in_chat = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(ExtraFields r100) {
                Boolean r101 = r100.mis_in_chat;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ExtraFields decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ExtraFields r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ExtraFields r101) throws IOException {
                Boolean r102 = r101.mis_in_chat;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExtraFields r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ExtraFields();
            DEFAULT_IS_IN_CHAT = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mis_in_chat = this.mis_in_chat;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ExtraFields.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ExtraFields(Boolean r100) {
            this(r100, ByteString.EMPTY);
        }

        public ExtraFields(Boolean r100, ByteString r101) {
            super(ADAPTER, r101);
            this.mis_in_chat = r100;
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
            r101.mid = "";
            r101.mtenant_id = "";
            r101.mwith_bot_tag = "bot";
            Boolean r102 = Boolean.TRUE;
            r101.min_contacts = r102;
            r101.mcan_join_group = r102;
            r101.mchat_id = "";
            r101.mbot_ext_type = 0;
            r101.mis_agent = Boolean.FALSE;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L16;
            switch(r104) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L6;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r101.mis_agent = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.mbot_ext_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L9:
            r101.mextraFields = ExtraFields.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.mchat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.mcan_join_group = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.min_contacts = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.mwith_bot_tag = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.mtenant_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BotMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.mid);
            String r103 = r100.mtenant_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.mwith_bot_tag;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            Boolean r110 = r100.min_contacts;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            Boolean r113 = r100.mcan_join_group;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.mchat_id;
            if (r116 == null) goto L21;
            int r117 = r101.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            ExtraFields r119 = r100.mextraFields;
            if (r119 == null) goto L25;
            int r120 = ExtraFields.ADAPTER.encodedSizeWithTag(8, r119);
        L26:
            int r121 = r118 + r120;
            Integer r122 = r100.mbot_ext_type;
            if (r122 == null) goto L29;
            int r123 = ProtoAdapter.INT32.encodedSizeWithTag(9, r122);
        L30:
            int r124 = r121 + r123;
            Boolean r125 = r100.mis_agent;
            if (r125 == null) goto L34;
            r104 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r125);
        L34:
            return (r124 + r104) + r100.unknownFields().size();
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
            r102.encodeWithTag(r100, 1, r101.mid);
            String r103 = r101.mtenant_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.mwith_bot_tag;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            Boolean r105 = r101.min_contacts;
            if (r105 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L11:
            Boolean r106 = r101.mcan_join_group;
            if (r106 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L14:
            String r107 = r101.mchat_id;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 6, r107);
        L17:
            ExtraFields r108 = r101.mextraFields;
            if (r108 == null) goto L20;
            ExtraFields.ADAPTER.encodeWithTag(r100, 8, r108);
        L20:
            Integer r109 = r101.mbot_ext_type;
            if (r109 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r100, 9, r109);
        L23:
            Boolean r110 = r101.mis_agent;
            if (r110 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 10, r110);
        L26:
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
        DEFAULT_BOT_EXT_TYPE = 0;
        DEFAULT_IS_AGENT = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.mtenant_id = this.mtenant_id;
        r100.mwith_bot_tag = this.mwith_bot_tag;
        r100.min_contacts = this.min_contacts;
        r100.mcan_join_group = this.mcan_join_group;
        r100.mchat_id = this.mchat_id;
        r100.mextraFields = this.mextraFields;
        r100.mbot_ext_type = this.mbot_ext_type;
        r100.mis_agent = this.mis_agent;
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

    public BotMeta(String r110, String r111, String r112, Boolean r113, Boolean r114, String r115, ExtraFields r116, Integer r117, Boolean r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public BotMeta(String r100, String r101, String r102, Boolean r103, Boolean r104, String r105, ExtraFields r106, Integer r107, Boolean r110, ByteString r111) {
        super(ADAPTER, r111);
        this.mid = r100;
        this.mtenant_id = r101;
        this.mwith_bot_tag = r102;
        this.min_contacts = r103;
        this.mcan_join_group = r104;
        this.mchat_id = r105;
        this.mextraFields = r106;
        this.mbot_ext_type = r107;
        this.mis_agent = r110;
    }
}
