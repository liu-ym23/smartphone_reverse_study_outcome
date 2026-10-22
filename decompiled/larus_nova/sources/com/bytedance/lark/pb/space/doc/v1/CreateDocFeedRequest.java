package com.bytedance.lark.pb.space.doc.v1;

import com.bytedance.lark.pb.basic.v1.Doc;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class CreateDocFeedRequest extends Message<CreateDocFeedRequest, Builder> {
    public static final ProtoAdapter<CreateDocFeedRequest> ADAPTER = null;
    public static final String DEFAULT_KEY = "";
    public static final Doc.Type DEFAULT_TYPE = null;
    public static final ProtoAdapter_CreateDocFeedRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String key;
    public final Doc.Type type;

    public static final class Builder extends Message.Builder<CreateDocFeedRequest, Builder> implements d<CreateDocFeedRequest> {
        public String key;
        public Doc.Type type;

        @Override // com.squareup.wire.Message.Builder
        public CreateDocFeedRequest build() {
            String r100 = this.key;
            if (r100 == null) goto L9;
            if (this.type == null) goto L9;
            return new CreateDocFeedRequest(this.key, this.type, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "key", this.type, "type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder type(Doc.Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CreateDocFeedRequest extends ProtoAdapter<CreateDocFeedRequest> implements c<CreateDocFeedRequest> {
        public ProtoAdapter_CreateDocFeedRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CreateDocFeedRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CreateDocFeedRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key = "";
            r101.type = Doc.Type.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.type = Doc.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CreateDocFeedRequest r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.key) + Doc.Type.ADAPTER.encodedSizeWithTag(2, r100.type)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CreateDocFeedRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CreateDocFeedRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CreateDocFeedRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.key);
            Doc.Type.ADAPTER.encodeWithTag(r100, 2, r101.type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CreateDocFeedRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CreateDocFeedRequest r100 = new ProtoAdapter_CreateDocFeedRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_TYPE = Doc.Type.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.type = this.type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CreateDocFeedRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CreateDocFeedRequest(String r100, Doc.Type r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CreateDocFeedRequest(String r100, Doc.Type r101, ByteString r102) {
        super(ADAPTER, r102);
        this.key = r100;
        this.type = r101;
    }
}
