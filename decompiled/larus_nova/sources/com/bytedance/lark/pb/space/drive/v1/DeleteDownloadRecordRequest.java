package com.bytedance.lark.pb.space.drive.v1;

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
public final class DeleteDownloadRecordRequest extends Message<DeleteDownloadRecordRequest, Builder> {
    public static final ProtoAdapter<DeleteDownloadRecordRequest> ADAPTER = null;
    public static final DownloadRequest.ApiType DEFAULT_API_TYPE = null;
    public static final String DEFAULT_DATA_VERSION = "";
    public static final String DEFAULT_FILE_TOKEN = "";
    public static final ProtoAdapter_DeleteDownloadRecordRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DownloadRequest.ApiType api_type;
    public final String data_version;
    public final String file_token;

    public static final class Builder extends Message.Builder<DeleteDownloadRecordRequest, Builder> implements d<DeleteDownloadRecordRequest> {
        public DownloadRequest.ApiType api_type;
        public String data_version;
        public String file_token;

        @Override // com.squareup.wire.Message.Builder
        public DeleteDownloadRecordRequest build() {
            DownloadRequest.ApiType r100 = this.api_type;
            if (r100 == null) goto L9;
            if (this.file_token == null) goto L9;
            return new DeleteDownloadRecordRequest(this.api_type, this.file_token, this.data_version, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "api_type", this.file_token, "file_token"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder api_type(DownloadRequest.ApiType r100) {
            this.api_type = r100;
            return this;
        }

        public Builder data_version(String r100) {
            this.data_version = r100;
            return this;
        }

        public Builder file_token(String r100) {
            this.file_token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DeleteDownloadRecordRequest extends ProtoAdapter<DeleteDownloadRecordRequest> implements c<DeleteDownloadRecordRequest> {
        public ProtoAdapter_DeleteDownloadRecordRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DeleteDownloadRecordRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DeleteDownloadRecordRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.api_type = DownloadRequest.ApiType.DRIVE;
            r101.file_token = "";
            r101.data_version = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.api_type = DownloadRequest.ApiType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.file_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.data_version = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(DeleteDownloadRecordRequest r100) {
            int r101 = DownloadRequest.ApiType.ADAPTER.encodedSizeWithTag(1, r100.api_type);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            int r103 = r101 + r102.encodedSizeWithTag(2, r100.file_token);
            String r104 = r100.data_version;
            if (r104 == null) goto L5;
            int r105 = r102.encodedSizeWithTag(3, r104);
        L7:
            return (r103 + r105) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DeleteDownloadRecordRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DeleteDownloadRecordRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DeleteDownloadRecordRequest r101) throws IOException {
            DownloadRequest.ApiType.ADAPTER.encodeWithTag(r100, 1, r101.api_type);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 2, r101.file_token);
            String r103 = r101.data_version;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DeleteDownloadRecordRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_DeleteDownloadRecordRequest r100 = new ProtoAdapter_DeleteDownloadRecordRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_API_TYPE = DownloadRequest.ApiType.DRIVE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.api_type = this.api_type;
        r100.file_token = this.file_token;
        r100.data_version = this.data_version;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DeleteDownloadRecordRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DeleteDownloadRecordRequest(DownloadRequest.ApiType r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public DeleteDownloadRecordRequest(DownloadRequest.ApiType r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.api_type = r100;
        this.file_token = r101;
        this.data_version = r102;
    }
}
