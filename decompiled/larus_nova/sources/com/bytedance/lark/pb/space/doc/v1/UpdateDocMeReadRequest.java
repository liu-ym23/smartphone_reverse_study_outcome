package com.bytedance.lark.pb.space.doc.v1;

import com.bytedance.lark.pb.basic.v1.Doc;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class UpdateDocMeReadRequest extends Message<UpdateDocMeReadRequest, Builder> {
    public static final ProtoAdapter<UpdateDocMeReadRequest> ADAPTER = null;
    public static final Doc.Type DEFAULT_DOC_TYPE = null;
    public static final String DEFAULT_TOKEN = "";
    public static final ProtoAdapter_UpdateDocMeReadRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Doc.Type doc_type;
    public final List<String> message_ids;
    public final String token;

    public static final class Builder extends Message.Builder<UpdateDocMeReadRequest, Builder> implements d<UpdateDocMeReadRequest> {
        public Doc.Type doc_type;
        public List<String> message_ids;
        public String token;

        @Override // com.squareup.wire.Message.Builder
        public UpdateDocMeReadRequest build() {
            return new UpdateDocMeReadRequest(this.message_ids, this.token, this.doc_type, super.buildUnknownFields());
        }

        public Builder() {
            this.message_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder doc_type(Doc.Type r100) {
            this.doc_type = r100;
            return this;
        }

        public Builder message_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_ids = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateDocMeReadRequest extends ProtoAdapter<UpdateDocMeReadRequest> implements c<UpdateDocMeReadRequest> {
        public ProtoAdapter_UpdateDocMeReadRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateDocMeReadRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateDocMeReadRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.token = "";
            r101.doc_type = Doc.Type.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.message_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.doc_type = Doc.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UpdateDocMeReadRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.asRepeated().encodedSizeWithTag(1, r100.message_ids);
            String r103 = r100.token;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Doc.Type r107 = r100.doc_type;
            if (r107 == null) goto L10;
            r104 = Doc.Type.ADAPTER.encodedSizeWithTag(3, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateDocMeReadRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateDocMeReadRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateDocMeReadRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 1, r101.message_ids);
            String r103 = r101.token;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            Doc.Type r104 = r101.doc_type;
            if (r104 == null) goto L8;
            Doc.Type.ADAPTER.encodeWithTag(r100, 3, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateDocMeReadRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateDocMeReadRequest r100 = new ProtoAdapter_UpdateDocMeReadRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_DOC_TYPE = Doc.Type.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_ids = Internal.copyOf("message_ids", this.message_ids);
        r100.token = this.token;
        r100.doc_type = this.doc_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateDocMeReadRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateDocMeReadRequest(List<String> r100, String r101, Doc.Type r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public UpdateDocMeReadRequest(List<String> r100, String r101, Doc.Type r102, ByteString r103) {
        super(ADAPTER, r103);
        this.message_ids = Internal.immutableCopyOf("message_ids", r100);
        this.token = r101;
        this.doc_type = r102;
    }
}
