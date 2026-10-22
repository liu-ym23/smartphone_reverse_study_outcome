package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class BotConfig extends com.squareup.wire.Message<BotConfig, Builder> {
    public static final ProtoAdapter<BotConfig> ADAPTER = null;
    public static final Integer DEFAULT_BOT_EXT_TYPE = null;
    public static final Boolean DEFAULT_CAN_JOIN_GROUP = null;
    public static final Boolean DEFAULT_IN_CONTACTS = null;
    public static final Boolean DEFAULT_IS_AGENT = null;
    public static final String DEFAULT_WITH_BOT_TAG = "bot";
    private static final long serialVersionUID = 0;
    public final Integer mbot_ext_type;
    public final Boolean mcan_join_group;
    public final Boolean min_contacts;
    public final Boolean mis_agent;
    public final String mwith_bot_tag;

    public static final class Builder extends com.squareup.wire.Message.Builder<BotConfig, Builder> {
        public Integer mbot_ext_type;
        public Boolean mcan_join_group;
        public Boolean min_contacts;
        public Boolean mis_agent;
        public String mwith_bot_tag;

        @Override // com.squareup.wire.Message.Builder
        public BotConfig build() {
            return new BotConfig(this.mwith_bot_tag, this.min_contacts, this.mcan_join_group, this.mbot_ext_type, this.mis_agent, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
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

        public Builder in_contacts(Boolean r100) {
            this.min_contacts = r100;
            return this;
        }

        public Builder is_agent(Boolean r100) {
            this.mis_agent = r100;
            return this;
        }

        public Builder with_bot_tag(String r100) {
            this.mwith_bot_tag = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BotConfig extends ProtoAdapter<BotConfig> {
        public ProtoAdapter_BotConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, BotConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BotConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mwith_bot_tag = "bot";
            Boolean r102 = Boolean.TRUE;
            r101.min_contacts = r102;
            r101.mcan_join_group = r102;
            r101.mbot_ext_type = 0;
            r101.mis_agent = Boolean.FALSE;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L21;
            if (r104 != 1) goto L8;
            r101.mwith_bot_tag = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.min_contacts = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.mcan_join_group = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L14;
            r101.mbot_ext_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L14:
            if (r104 != 5) goto L15;
            r101.mis_agent = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BotConfig r100) {
            String r101 = r100.mwith_bot_tag;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.min_contacts;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.mcan_join_group;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Integer r110 = r100.mbot_ext_type;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT32.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.mis_agent;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ BotConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BotConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BotConfig r101) throws IOException {
            String r102 = r101.mwith_bot_tag;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.min_contacts;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.mcan_join_group;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            Integer r105 = r101.mbot_ext_type;
            if (r105 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.mis_agent;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BotConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BotConfig();
        Boolean r100 = Boolean.TRUE;
        DEFAULT_IN_CONTACTS = r100;
        DEFAULT_CAN_JOIN_GROUP = r100;
        DEFAULT_BOT_EXT_TYPE = 0;
        DEFAULT_IS_AGENT = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mwith_bot_tag = this.mwith_bot_tag;
        r100.min_contacts = this.min_contacts;
        r100.mcan_join_group = this.mcan_join_group;
        r100.mbot_ext_type = this.mbot_ext_type;
        r100.mis_agent = this.mis_agent;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BotConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public BotConfig(String r100, Boolean r101, Boolean r110, Integer r111, Boolean r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public BotConfig(String r100, Boolean r101, Boolean r102, Integer r103, Boolean r104, ByteString r105) {
        super(ADAPTER, r105);
        this.mwith_bot_tag = r100;
        this.min_contacts = r101;
        this.mcan_join_group = r102;
        this.mbot_ext_type = r103;
        this.mis_agent = r104;
    }
}
