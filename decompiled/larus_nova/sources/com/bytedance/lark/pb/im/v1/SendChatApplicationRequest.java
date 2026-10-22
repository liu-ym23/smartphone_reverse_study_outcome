package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.ContactSource;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class SendChatApplicationRequest extends Message<SendChatApplicationRequest, Builder> {
    public static final ProtoAdapter<SendChatApplicationRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final CrossBrandActionUiStyleType DEFAULT_EXPECT_STYLE = null;
    public static final String DEFAULT_EXTRA_MESSAGE = "";
    public static final String DEFAULT_SENDER = "";
    public static final String DEFAULT_SENDER_ID = "";
    public static final ContactSource DEFAULT_SOURCE = null;
    public static final String DEFAULT_SOURCE_ID = "";
    public static final String DEFAULT_SOURCE_NAME = "";
    public static final String DEFAULT_SUB_SOURCE_TYPE = "";
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_USER_ALIAS = "";
    public static final String DEFAULT_USER_ID = "";
    public static final Boolean DEFAULT_USE_TNS_CROSS_BRAND_ACTION = null;
    public static final ProtoAdapter_SendChatApplicationRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final CrossBrandActionUiStyleType expect_style;
    public final String extra_message;
    public final String sender;
    public final String sender_id;
    public final ContactSource source;
    public final String source_id;
    public final String source_name;
    public final String sub_source_type;
    public final String token;
    public final Boolean use_tns_cross_brand_action;
    public final String user_alias;
    public final String user_id;

    public static final class Builder extends Message.Builder<SendChatApplicationRequest, Builder> implements d<SendChatApplicationRequest> {
        public String chat_id;
        public CrossBrandActionUiStyleType expect_style;
        public String extra_message;
        public String sender;
        public String sender_id;
        public ContactSource source;
        public String source_id;
        public String source_name;
        public String sub_source_type;
        public String token;
        public Boolean use_tns_cross_brand_action;
        public String user_alias;
        public String user_id;

        @Override // com.squareup.wire.Message.Builder
        public SendChatApplicationRequest build() {
            return new SendChatApplicationRequest(this.token, this.extra_message, this.chat_id, this.sender, this.source, this.source_name, this.sender_id, this.source_id, this.sub_source_type, this.user_id, this.user_alias, this.use_tns_cross_brand_action, this.expect_style, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder expect_style(CrossBrandActionUiStyleType r100) {
            this.expect_style = r100;
            return this;
        }

        public Builder extra_message(String r100) {
            this.extra_message = r100;
            return this;
        }

        public Builder sender(String r100) {
            this.sender = r100;
            return this;
        }

        public Builder sender_id(String r100) {
            this.sender_id = r100;
            return this;
        }

        public Builder source(ContactSource r100) {
            this.source = r100;
            return this;
        }

        public Builder source_id(String r100) {
            this.source_id = r100;
            return this;
        }

        public Builder source_name(String r100) {
            this.source_name = r100;
            return this;
        }

        public Builder sub_source_type(String r100) {
            this.sub_source_type = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }

        public Builder use_tns_cross_brand_action(Boolean r100) {
            this.use_tns_cross_brand_action = r100;
            return this;
        }

        public Builder user_alias(String r100) {
            this.user_alias = r100;
            return this;
        }

        public Builder user_id(String r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SendChatApplicationRequest extends ProtoAdapter<SendChatApplicationRequest> implements c<SendChatApplicationRequest> {
        public ProtoAdapter_SendChatApplicationRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SendChatApplicationRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SendChatApplicationRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.token = "";
            r101.extra_message = "";
            r101.chat_id = "";
            r101.sender = "";
            r101.source = ContactSource.UNKNOWN_SOURCE;
            r101.source_name = "";
            r101.sender_id = "";
            r101.source_id = "";
            r101.sub_source_type = "";
            r101.user_id = "";
            r101.user_alias = "";
            r101.use_tns_cross_brand_action = Boolean.FALSE;
            r101.expect_style = CrossBrandActionUiStyleType.STYLE_TYPE_UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L26;
            switch(r103) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L23;
                case 4: goto L22;
                case 5: goto L30;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L12;
                case 12: goto L11;
                case 13: goto L28;
                default: goto L6;
            };
        L28:
            r101.expect_style = CrossBrandActionUiStyleType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L30:
            r101.source = ContactSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.use_tns_cross_brand_action = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.user_alias = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.sub_source_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.sender_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.source_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.sender = ProtoAdapter.STRING.decode(r100);
            goto L3
        L23:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L24:
            r101.extra_message = ProtoAdapter.STRING.decode(r100);
            goto L3
        L25:
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L26:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SendChatApplicationRequest r100) {
            String r101 = r100.token;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.extra_message;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.chat_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.sender;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            ContactSource r113 = r100.source;
            if (r113 == null) goto L21;
            int r114 = ContactSource.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.source_name;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.sender_id;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.source_id;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            String r125 = r100.sub_source_type;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.STRING.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            String r128 = r100.user_id;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.STRING.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            String r131 = r100.user_alias;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.STRING.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            Boolean r134 = r100.use_tns_cross_brand_action;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r134);
        L50:
            int r136 = r133 + r135;
            CrossBrandActionUiStyleType r137 = r100.expect_style;
            if (r137 == null) goto L54;
            r102 = CrossBrandActionUiStyleType.ADAPTER.encodedSizeWithTag(13, r137);
        L54:
            return (r136 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ SendChatApplicationRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SendChatApplicationRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SendChatApplicationRequest r101) throws IOException {
            String r102 = r101.token;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.extra_message;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.chat_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.sender;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            ContactSource r106 = r101.source;
            if (r106 == null) goto L17;
            ContactSource.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.source_name;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.sender_id;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.source_id;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            String r110 = r101.sub_source_type;
            if (r110 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r110);
        L29:
            String r111 = r101.user_id;
            if (r111 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 10, r111);
        L32:
            String r112 = r101.user_alias;
            if (r112 == null) goto L35;
            ProtoAdapter.STRING.encodeWithTag(r100, 11, r112);
        L35:
            Boolean r113 = r101.use_tns_cross_brand_action;
            if (r113 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r100, 12, r113);
        L38:
            CrossBrandActionUiStyleType r114 = r101.expect_style;
            if (r114 == null) goto L41;
            CrossBrandActionUiStyleType.ADAPTER.encodeWithTag(r100, 13, r114);
        L41:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SendChatApplicationRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SendChatApplicationRequest r100 = new ProtoAdapter_SendChatApplicationRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SOURCE = ContactSource.UNKNOWN_SOURCE;
        DEFAULT_USE_TNS_CROSS_BRAND_ACTION = Boolean.FALSE;
        DEFAULT_EXPECT_STYLE = CrossBrandActionUiStyleType.STYLE_TYPE_UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.token = this.token;
        r100.extra_message = this.extra_message;
        r100.chat_id = this.chat_id;
        r100.sender = this.sender;
        r100.source = this.source;
        r100.source_name = this.source_name;
        r100.sender_id = this.sender_id;
        r100.source_id = this.source_id;
        r100.sub_source_type = this.sub_source_type;
        r100.user_id = this.user_id;
        r100.user_alias = this.user_alias;
        r100.use_tns_cross_brand_action = this.use_tns_cross_brand_action;
        r100.expect_style = this.expect_style;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SendChatApplicationRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SendChatApplicationRequest(String r110, String r111, String r112, String r113, ContactSource r210, String r211, String r212, String r213, String r214, String r215, String r216, Boolean r217, CrossBrandActionUiStyleType r218) {
        this(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218, ByteString.EMPTY);
    }

    public SendChatApplicationRequest(String r100, String r101, String r102, String r103, ContactSource r104, String r105, String r106, String r107, String r110, String r111, String r112, Boolean r113, CrossBrandActionUiStyleType r114, ByteString r115) {
        super(ADAPTER, r115);
        this.token = r100;
        this.extra_message = r101;
        this.chat_id = r102;
        this.sender = r103;
        this.source = r104;
        this.source_name = r105;
        this.sender_id = r106;
        this.source_id = r107;
        this.sub_source_type = r110;
        this.user_id = r111;
        this.user_alias = r112;
        this.use_tns_cross_brand_action = r113;
        this.expect_style = r114;
    }
}
