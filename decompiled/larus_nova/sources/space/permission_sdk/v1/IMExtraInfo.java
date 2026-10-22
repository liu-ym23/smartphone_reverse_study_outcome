package space.permission_sdk.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class IMExtraInfo extends Message<IMExtraInfo, Builder> {
    public static final ProtoAdapter<IMExtraInfo> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final Long DEFAULT_CHAT_TYPE = null;
    public static final String DEFAULT_FILE_KEY = "";
    public static final String DEFAULT_MSG_ID = "";
    public static final String DEFAULT_SCOPED_ENTITY_OPERATE = "";
    public static final String DEFAULT_SCOPED_ENTITY_TYPE = "";
    public static final String DEFAULT_SCOPED_FILE_BIZ_DOMAIN = "";
    public static final String DEFAULT_SENDER_TENANT_ID = "";
    public static final String DEFAULT_SENDER_USER_ID = "";
    public static final FieldOptions FIELD_OPTIONS_CHAT_TYPE = null;
    public static final FieldOptions FIELD_OPTIONS_SENDER_TENANT_ID = null;
    private static final long serialVersionUID = 0;
    public final Long chat_id;
    public final Long chat_type;
    public final String file_key;
    public final String msg_id;
    public final String scoped_entity_operate;
    public final String scoped_entity_type;
    public final String scoped_file_biz_domain;
    public final String sender_tenant_id;
    public final String sender_user_id;

    public static final class Builder extends Message.Builder<IMExtraInfo, Builder> {
        public Long chat_id;
        public Long chat_type;
        public String file_key;
        public String msg_id;
        public String scoped_entity_operate;
        public String scoped_entity_type;
        public String scoped_file_biz_domain;
        public String sender_tenant_id;
        public String sender_user_id;

        @Override // com.squareup.wire.Message.Builder
        public IMExtraInfo build() {
            return new IMExtraInfo(this.chat_id, this.chat_type, this.sender_user_id, this.sender_tenant_id, this.msg_id, this.file_key, this.scoped_file_biz_domain, this.scoped_entity_operate, this.scoped_entity_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(Long r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder chat_type(Long r100) {
            this.chat_type = r100;
            return this;
        }

        public Builder file_key(String r100) {
            this.file_key = r100;
            return this;
        }

        public Builder msg_id(String r100) {
            this.msg_id = r100;
            return this;
        }

        public Builder scoped_entity_operate(String r100) {
            this.scoped_entity_operate = r100;
            return this;
        }

        public Builder scoped_entity_type(String r100) {
            this.scoped_entity_type = r100;
            return this;
        }

        public Builder scoped_file_biz_domain(String r100) {
            this.scoped_file_biz_domain = r100;
            return this;
        }

        public Builder sender_tenant_id(String r100) {
            this.sender_tenant_id = r100;
            return this;
        }

        public Builder sender_user_id(String r100) {
            this.sender_user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_IMExtraInfo extends ProtoAdapter<IMExtraInfo> {
        public ProtoAdapter_IMExtraInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, IMExtraInfo.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public IMExtraInfo decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = 0L;
            r101.chat_type = 0L;
            r101.sender_user_id = "";
            r101.sender_tenant_id = "";
            r101.msg_id = "";
            r101.file_key = "";
            r101.scoped_file_biz_domain = "";
            r101.scoped_entity_operate = "";
            r101.scoped_entity_type = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r101.scoped_entity_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.scoped_entity_operate = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.scoped_file_biz_domain = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.file_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.msg_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.sender_tenant_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.sender_user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.chat_type = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L15:
            r101.chat_id = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(IMExtraInfo r100) {
            Long r101 = r100.chat_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.UINT64.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.chat_type;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.UINT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.sender_user_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.sender_tenant_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.msg_id;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.file_key;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.scoped_file_biz_domain;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.scoped_entity_operate;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            String r125 = r100.scoped_entity_type;
            if (r125 == null) goto L38;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(9, r125);
        L38:
            return (r124 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ IMExtraInfo decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(IMExtraInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, IMExtraInfo r101) throws IOException {
            Long r102 = r101.chat_id;
            if (r102 == null) goto L5;
            ProtoAdapter.UINT64.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.chat_type;
            if (r103 == null) goto L8;
            ProtoAdapter.UINT64.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.sender_user_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.sender_tenant_id;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.msg_id;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.file_key;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.scoped_file_biz_domain;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.scoped_entity_operate;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            String r110 = r101.scoped_entity_type;
            if (r110 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r110);
        L29:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, IMExtraInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_IMExtraInfo();
        FIELD_OPTIONS_CHAT_TYPE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_SENDER_TENANT_ID = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_CHAT_ID = 0L;
        DEFAULT_CHAT_TYPE = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.chat_type = this.chat_type;
        r100.sender_user_id = this.sender_user_id;
        r100.sender_tenant_id = this.sender_tenant_id;
        r100.msg_id = this.msg_id;
        r100.file_key = this.file_key;
        r100.scoped_file_biz_domain = this.scoped_file_biz_domain;
        r100.scoped_entity_operate = this.scoped_entity_operate;
        r100.scoped_entity_type = this.scoped_entity_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return IMExtraInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public IMExtraInfo(Long r110, Long r111, String r112, String r113, String r114, String r115, String r116, String r117, String r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public IMExtraInfo(Long r100, Long r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, ByteString r111) {
        super(ADAPTER, r111);
        this.chat_id = r100;
        this.chat_type = r101;
        this.sender_user_id = r102;
        this.sender_tenant_id = r103;
        this.msg_id = r104;
        this.file_key = r105;
        this.scoped_file_biz_domain = r106;
        this.scoped_entity_operate = r107;
        this.scoped_entity_type = r110;
    }
}
