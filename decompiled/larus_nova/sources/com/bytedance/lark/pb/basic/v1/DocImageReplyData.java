package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class DocImageReplyData extends com.squareup.wire.Message<DocImageReplyData, Builder> {
    public static final ProtoAdapter<DocImageReplyData> ADAPTER = null;
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_DOC_IMAGE_REPLY_BODY = "";
    private static final long serialVersionUID = 0;
    public final Long create_time;
    public final String doc_image_reply_body;

    public static final class Builder extends com.squareup.wire.Message.Builder<DocImageReplyData, Builder> {
        public Long create_time;
        public String doc_image_reply_body;

        @Override // com.squareup.wire.Message.Builder
        public DocImageReplyData build() {
            return new DocImageReplyData(this.create_time, this.doc_image_reply_body, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder create_time(Long r100) {
            this.create_time = r100;
            return this;
        }

        public Builder doc_image_reply_body(String r100) {
            this.doc_image_reply_body = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DocImageReplyData extends ProtoAdapter<DocImageReplyData> {
        public ProtoAdapter_DocImageReplyData() {
            super(FieldEncoding.LENGTH_DELIMITED, DocImageReplyData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DocImageReplyData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.create_time = 0L;
            r101.doc_image_reply_body = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.create_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.doc_image_reply_body = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DocImageReplyData r100) {
            Long r101 = r100.create_time;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.doc_image_reply_body;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DocImageReplyData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DocImageReplyData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DocImageReplyData r101) throws IOException {
            Long r102 = r101.create_time;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.doc_image_reply_body;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocImageReplyData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DocImageReplyData();
        DEFAULT_CREATE_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.create_time = this.create_time;
        r100.doc_image_reply_body = this.doc_image_reply_body;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DocImageReplyData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public DocImageReplyData(Long r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public DocImageReplyData(Long r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.create_time = r100;
        this.doc_image_reply_body = r101;
    }
}
