package com.bytedance.lark.pb.media.v1;

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
public final class GetFileMetaResponse extends Message<GetFileMetaResponse, Builder> {
    public static final ProtoAdapter<GetFileMetaResponse> ADAPTER = null;
    public static final String DEFAULT_FILE_PATH = "";
    public static final Integer DEFAULT_PROGRESS = null;
    public static final ProtoAdapter_GetFileMetaResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String file_path;
    public final Integer progress;

    public static final class Builder extends Message.Builder<GetFileMetaResponse, Builder> implements d<GetFileMetaResponse> {
        public String file_path;
        public Integer progress;

        @Override // com.squareup.wire.Message.Builder
        public GetFileMetaResponse build() {
            return new GetFileMetaResponse(this.file_path, this.progress, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder file_path(String r100) {
            this.file_path = r100;
            return this;
        }

        public Builder progress(Integer r100) {
            this.progress = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetFileMetaResponse extends ProtoAdapter<GetFileMetaResponse> implements c<GetFileMetaResponse> {
        public ProtoAdapter_GetFileMetaResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetFileMetaResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetFileMetaResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.file_path = "";
            r101.progress = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.file_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.progress = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(GetFileMetaResponse r100) {
            String r101 = r100.file_path;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.progress;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetFileMetaResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetFileMetaResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetFileMetaResponse r101) throws IOException {
            String r102 = r101.file_path;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.progress;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetFileMetaResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetFileMetaResponse r100 = new ProtoAdapter_GetFileMetaResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_PROGRESS = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.file_path = this.file_path;
        r100.progress = this.progress;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetFileMetaResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetFileMetaResponse(String r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetFileMetaResponse(String r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.file_path = r100;
        this.progress = r101;
    }
}
