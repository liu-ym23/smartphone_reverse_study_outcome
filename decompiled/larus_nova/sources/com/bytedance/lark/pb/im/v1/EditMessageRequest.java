package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.EditMessageContent;
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
public final class EditMessageRequest extends Message<EditMessageRequest, Builder> {
    public static final ProtoAdapter<EditMessageRequest> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final String DEFAULT_CID = "";
    public static final Long DEFAULT_MSG_ID = null;
    public static final com.bytedance.lark.pb.basic.v1.Message.Type DEFAULT_TYPE = null;
    public static final ProtoAdapter_EditMessageRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long chat_id;
    public final String cid;
    public final EditMessageContent content;
    public final QuasiMessageExtraData extra_data;
    public final Long msg_id;
    public final com.bytedance.lark.pb.basic.v1.Message.Type type;

    public static final class Builder extends Message.Builder<EditMessageRequest, Builder> implements d<EditMessageRequest> {
        public Long chat_id;
        public String cid;
        public EditMessageContent content;
        public QuasiMessageExtraData extra_data;
        public Long msg_id;
        public com.bytedance.lark.pb.basic.v1.Message.Type type;

        @Override // com.squareup.wire.Message.Builder
        public EditMessageRequest build() {
            return new EditMessageRequest(this.msg_id, this.cid, this.type, this.content, this.chat_id, this.extra_data, super.buildUnknownFields());
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

        public Builder cid(String r100) {
            this.cid = r100;
            return this;
        }

        public Builder content(EditMessageContent r100) {
            this.content = r100;
            return this;
        }

        public Builder extra_data(QuasiMessageExtraData r100) {
            this.extra_data = r100;
            return this;
        }

        public Builder msg_id(Long r100) {
            this.msg_id = r100;
            return this;
        }

        public Builder type(com.bytedance.lark.pb.basic.v1.Message.Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EditMessageRequest extends ProtoAdapter<EditMessageRequest> implements c<EditMessageRequest> {
        public ProtoAdapter_EditMessageRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, EditMessageRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EditMessageRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.msg_id = 0L;
            r101.cid = "";
            r101.type = com.bytedance.lark.pb.basic.v1.Message.Type.UNKNOWN;
            r101.chat_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L18;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r101.type = com.bytedance.lark.pb.basic.v1.Message.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.extra_data = QuasiMessageExtraData.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.chat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L9:
            r101.content = EditMessageContent.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.cid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.msg_id = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(EditMessageRequest r100) {
            Long r101 = r100.msg_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.cid;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            com.bytedance.lark.pb.basic.v1.Message.Type r107 = r100.type;
            if (r107 == null) goto L13;
            int r108 = com.bytedance.lark.pb.basic.v1.Message.Type.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            EditMessageContent r110 = r100.content;
            if (r110 == null) goto L17;
            int r111 = EditMessageContent.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.chat_id;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT64.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            QuasiMessageExtraData r116 = r100.extra_data;
            if (r116 == null) goto L26;
            r102 = QuasiMessageExtraData.ADAPTER.encodedSizeWithTag(6, r116);
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
        public /* bridge */ /* synthetic */ EditMessageRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EditMessageRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EditMessageRequest r101) throws IOException {
            Long r102 = r101.msg_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.cid;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            com.bytedance.lark.pb.basic.v1.Message.Type r104 = r101.type;
            if (r104 == null) goto L11;
            com.bytedance.lark.pb.basic.v1.Message.Type.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            EditMessageContent r105 = r101.content;
            if (r105 == null) goto L14;
            EditMessageContent.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            Long r106 = r101.chat_id;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r106);
        L17:
            QuasiMessageExtraData r107 = r101.extra_data;
            if (r107 == null) goto L20;
            QuasiMessageExtraData.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EditMessageRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_EditMessageRequest r100 = new ProtoAdapter_EditMessageRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_MSG_ID = 0L;
        DEFAULT_TYPE = com.bytedance.lark.pb.basic.v1.Message.Type.UNKNOWN;
        DEFAULT_CHAT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.msg_id = this.msg_id;
        r100.cid = this.cid;
        r100.type = this.type;
        r100.content = this.content;
        r100.chat_id = this.chat_id;
        r100.extra_data = this.extra_data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EditMessageRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public EditMessageRequest(Long r100, String r110, com.bytedance.lark.pb.basic.v1.Message.Type r111, EditMessageContent r112, Long r113, QuasiMessageExtraData r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public EditMessageRequest(Long r100, String r101, com.bytedance.lark.pb.basic.v1.Message.Type r102, EditMessageContent r103, Long r104, QuasiMessageExtraData r105, ByteString r106) {
        super(ADAPTER, r106);
        this.msg_id = r100;
        this.cid = r101;
        this.type = r102;
        this.content = r103;
        this.chat_id = r104;
        this.extra_data = r105;
    }
}
