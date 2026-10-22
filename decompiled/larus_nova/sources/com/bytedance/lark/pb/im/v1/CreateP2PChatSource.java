package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.ContactSource;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CreateP2PChatSource extends Message<CreateP2PChatSource, Builder> {
    public static final ProtoAdapter<CreateP2PChatSource> ADAPTER = null;
    public static final Long DEFAULT_SENDER_ID = null;
    public static final String DEFAULT_SENDER_ID_V2 = "";
    public static final String DEFAULT_SOURCE_ID = "";
    public static final String DEFAULT_SOURCE_NAME = "";
    public static final ContactSource DEFAULT_SOURCE_TYPE = null;
    public static final String DEFAULT_SUB_SOURCE_TYPE = "";
    private static final long serialVersionUID = 0;
    public final Long sender_id;
    public final String sender_id_v2;
    public final String source_id;
    public final String source_name;
    public final ContactSource source_type;
    public final String sub_source_type;

    public static final class Builder extends Message.Builder<CreateP2PChatSource, Builder> {
        public Long sender_id;
        public String sender_id_v2;
        public String source_id;
        public String source_name;
        public ContactSource source_type;
        public String sub_source_type;

        @Override // com.squareup.wire.Message.Builder
        public CreateP2PChatSource build() {
            return new CreateP2PChatSource(this.sender_id, this.source_type, this.source_id, this.source_name, this.sender_id_v2, this.sub_source_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder sender_id(Long r100) {
            this.sender_id = r100;
            return this;
        }

        public Builder sender_id_v2(String r100) {
            this.sender_id_v2 = r100;
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

        public Builder source_type(ContactSource r100) {
            this.source_type = r100;
            return this;
        }

        public Builder sub_source_type(String r100) {
            this.sub_source_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CreateP2PChatSource extends ProtoAdapter<CreateP2PChatSource> {
        public ProtoAdapter_CreateP2PChatSource() {
            super(FieldEncoding.LENGTH_DELIMITED, CreateP2PChatSource.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CreateP2PChatSource decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.sender_id = 0L;
            r101.source_type = ContactSource.UNKNOWN_SOURCE;
            r101.source_id = "";
            r101.source_name = "";
            r101.sender_id_v2 = "";
            r101.sub_source_type = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L18;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r101.source_type = ContactSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.sub_source_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.sender_id_v2 = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.source_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.sender_id = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(CreateP2PChatSource r100) {
            Long r101 = r100.sender_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            ContactSource r104 = r100.source_type;
            if (r104 == null) goto L9;
            int r105 = ContactSource.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.source_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.source_name;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.sender_id_v2;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.sub_source_type;
            if (r116 == null) goto L26;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ CreateP2PChatSource decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CreateP2PChatSource r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CreateP2PChatSource r101) throws IOException {
            Long r102 = r101.sender_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            ContactSource r103 = r101.source_type;
            if (r103 == null) goto L8;
            ContactSource.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.source_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.source_name;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.sender_id_v2;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.sub_source_type;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CreateP2PChatSource r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CreateP2PChatSource();
        DEFAULT_SENDER_ID = 0L;
        DEFAULT_SOURCE_TYPE = ContactSource.UNKNOWN_SOURCE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.sender_id = this.sender_id;
        r100.source_type = this.source_type;
        r100.source_id = this.source_id;
        r100.source_name = this.source_name;
        r100.sender_id_v2 = this.sender_id_v2;
        r100.sub_source_type = this.sub_source_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CreateP2PChatSource.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CreateP2PChatSource(Long r100, ContactSource r110, String r111, String r112, String r113, String r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public CreateP2PChatSource(Long r100, ContactSource r101, String r102, String r103, String r104, String r105, ByteString r106) {
        super(ADAPTER, r106);
        this.sender_id = r100;
        this.source_type = r101;
        this.source_id = r102;
        this.source_name = r103;
        this.sender_id_v2 = r104;
        this.sub_source_type = r105;
    }
}
