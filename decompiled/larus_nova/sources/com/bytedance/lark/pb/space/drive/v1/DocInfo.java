package com.bytedance.lark.pb.space.drive.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class DocInfo extends Message<DocInfo, Builder> {
    public static final ProtoAdapter<DocInfo> ADAPTER = null;
    public static final String DEFAULT_DOC_TOKEN = "";
    public static final Integer DEFAULT_DOC_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String doc_token;
    public final Integer doc_type;

    public static final class Builder extends Message.Builder<DocInfo, Builder> {
        public String doc_token;
        public Integer doc_type;

        @Override // com.squareup.wire.Message.Builder
        public DocInfo build() {
            String r100 = this.doc_token;
            if (r100 == null) goto L7;
            return new DocInfo(this.doc_token, this.doc_type, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "doc_token"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder doc_token(String r100) {
            this.doc_token = r100;
            return this;
        }

        public Builder doc_type(Integer r100) {
            this.doc_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DocInfo extends ProtoAdapter<DocInfo> {
        public ProtoAdapter_DocInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, DocInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DocInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.doc_token = "";
            r101.doc_type = 2;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L11;
            if (r103 != 1) goto L7;
            r101.doc_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L7:
            if (r103 != 2) goto L8;
            r101.doc_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L11:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DocInfo r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.doc_token);
            Integer r102 = r100.doc_type;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DocInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DocInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DocInfo r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.doc_token);
            Integer r102 = r101.doc_type;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DocInfo();
        DEFAULT_DOC_TYPE = 2;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.doc_token = this.doc_token;
        r100.doc_type = this.doc_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DocInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DocInfo(String r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public DocInfo(String r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.doc_token = r100;
        this.doc_type = r101;
    }
}
