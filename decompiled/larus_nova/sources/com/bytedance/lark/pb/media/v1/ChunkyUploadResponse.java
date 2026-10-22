package com.bytedance.lark.pb.media.v1;

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
public final class ChunkyUploadResponse extends Message<ChunkyUploadResponse, Builder> {
    public static final ProtoAdapter<ChunkyUploadResponse> ADAPTER = null;
    public static final ChunkyUploadCode DEFAULT_CODE = null;
    public static final ProtoAdapter_ChunkyUploadResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ChunkyUploadCode code;

    public static final class Builder extends Message.Builder<ChunkyUploadResponse, Builder> implements d<ChunkyUploadResponse> {
        public ChunkyUploadCode code;

        @Override // com.squareup.wire.Message.Builder
        public ChunkyUploadResponse build() {
            ChunkyUploadCode r100 = this.code;
            if (r100 == null) goto L7;
            return new ChunkyUploadResponse(this.code, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "code"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder code(ChunkyUploadCode r100) {
            this.code = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChunkyUploadResponse extends ProtoAdapter<ChunkyUploadResponse> implements c<ChunkyUploadResponse> {
        public ProtoAdapter_ChunkyUploadResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, ChunkyUploadResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChunkyUploadResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.code = ChunkyUploadCode.ERROR;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.code = ChunkyUploadCode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ChunkyUploadResponse r100) {
            return ChunkyUploadCode.ADAPTER.encodedSizeWithTag(1, r100.code) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ChunkyUploadResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChunkyUploadResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChunkyUploadResponse r101) throws IOException {
            ChunkyUploadCode.ADAPTER.encodeWithTag(r100, 1, r101.code);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChunkyUploadResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_ChunkyUploadResponse r100 = new ProtoAdapter_ChunkyUploadResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_CODE = ChunkyUploadCode.ERROR;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.code = this.code;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChunkyUploadResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChunkyUploadResponse(ChunkyUploadCode r100) {
        this(r100, ByteString.EMPTY);
    }

    public ChunkyUploadResponse(ChunkyUploadCode r100, ByteString r101) {
        super(ADAPTER, r101);
        this.code = r100;
    }
}
