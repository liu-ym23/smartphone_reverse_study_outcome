package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.ResourceFile;
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
public final class UploadResourceRequest extends Message<UploadResourceRequest, Builder> {
    public static final ProtoAdapter<UploadResourceRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_UPLOAD_ID = "";
    public static final ProtoAdapter_UploadResourceRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final ResourceFile file;
    public final String upload_id;

    public static final class Builder extends Message.Builder<UploadResourceRequest, Builder> implements d<UploadResourceRequest> {
        public String chat_id;
        public ResourceFile file;
        public String upload_id;

        @Override // com.squareup.wire.Message.Builder
        public UploadResourceRequest build() {
            String r100 = this.upload_id;
            if (r100 == null) goto L9;
            if (this.file == null) goto L9;
            return new UploadResourceRequest(this.upload_id, this.chat_id, this.file, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "upload_id", this.file, "file"});
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

        public Builder file(ResourceFile r100) {
            this.file = r100;
            return this;
        }

        public Builder upload_id(String r100) {
            this.upload_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UploadResourceRequest extends ProtoAdapter<UploadResourceRequest> implements c<UploadResourceRequest> {
        public ProtoAdapter_UploadResourceRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UploadResourceRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UploadResourceRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.upload_id = "";
            r101.chat_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.upload_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.file = ResourceFile.ADAPTER.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UploadResourceRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.upload_id);
            String r103 = r100.chat_id;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(2, r103);
        L7:
            return ((r102 + r104) + ResourceFile.ADAPTER.encodedSizeWithTag(3, r100.file)) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UploadResourceRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UploadResourceRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UploadResourceRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.upload_id);
            String r103 = r101.chat_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            ResourceFile.ADAPTER.encodeWithTag(r100, 3, r101.file);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UploadResourceRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UploadResourceRequest r100 = new ProtoAdapter_UploadResourceRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.upload_id = this.upload_id;
        r100.chat_id = this.chat_id;
        r100.file = this.file;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UploadResourceRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UploadResourceRequest(String r100, String r101, ResourceFile r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public UploadResourceRequest(String r100, String r101, ResourceFile r102, ByteString r103) {
        super(ADAPTER, r103);
        this.upload_id = r100;
        this.chat_id = r101;
        this.file = r102;
    }
}
