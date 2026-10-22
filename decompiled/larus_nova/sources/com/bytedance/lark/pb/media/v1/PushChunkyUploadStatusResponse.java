package com.bytedance.lark.pb.media.v1;

import com.bytedance.lark.pb.basic.v1.LarkError;
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
public final class PushChunkyUploadStatusResponse extends Message<PushChunkyUploadStatusResponse, Builder> {
    public static final ProtoAdapter<PushChunkyUploadStatusResponse> ADAPTER = null;
    public static final Integer DEFAULT_SUCCESS = null;
    public static final Long DEFAULT_UPLOAD_ID = null;
    public static final ProtoAdapter_PushChunkyUploadStatusResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final LarkError error;
    public final Integer success;
    public final Long upload_id;

    public static final class Builder extends Message.Builder<PushChunkyUploadStatusResponse, Builder> implements d<PushChunkyUploadStatusResponse> {
        public LarkError error;
        public Integer success;
        public Long upload_id;

        @Override // com.squareup.wire.Message.Builder
        public PushChunkyUploadStatusResponse build() {
            Long r100 = this.upload_id;
            if (r100 == null) goto L7;
            return new PushChunkyUploadStatusResponse(this.upload_id, this.success, this.error, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "upload_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder error(LarkError r100) {
            this.error = r100;
            this.success = null;
            return this;
        }

        public Builder success(Integer r100) {
            this.success = r100;
            this.error = null;
            return this;
        }

        public Builder upload_id(Long r100) {
            this.upload_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushChunkyUploadStatusResponse extends ProtoAdapter<PushChunkyUploadStatusResponse> implements c<PushChunkyUploadStatusResponse> {
        public ProtoAdapter_PushChunkyUploadStatusResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PushChunkyUploadStatusResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushChunkyUploadStatusResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.upload_id = 0L;
            r101.success(0);
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.upload_id = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.success(ProtoAdapter.INT32.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.error(LarkError.ADAPTER.decode(r100));
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
        public int encodedSize2(PushChunkyUploadStatusResponse r100) {
            int r101 = ProtoAdapter.UINT64.encodedSizeWithTag(1, r100.upload_id);
            Integer r102 = r100.success;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.INT32.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            LarkError r106 = r100.error;
            if (r106 == null) goto L10;
            r103 = LarkError.ADAPTER.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushChunkyUploadStatusResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushChunkyUploadStatusResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushChunkyUploadStatusResponse r101) throws IOException {
            ProtoAdapter.UINT64.encodeWithTag(r100, 1, r101.upload_id);
            Integer r102 = r101.success;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r102);
        L5:
            LarkError r103 = r101.error;
            if (r103 == null) goto L8;
            LarkError.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushChunkyUploadStatusResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushChunkyUploadStatusResponse r100 = new ProtoAdapter_PushChunkyUploadStatusResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_UPLOAD_ID = 0L;
        DEFAULT_SUCCESS = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.upload_id = this.upload_id;
        r100.success = this.success;
        r100.error = this.error;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushChunkyUploadStatusResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushChunkyUploadStatusResponse(Long r100, Integer r101, LarkError r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PushChunkyUploadStatusResponse(Long r100, Integer r101, LarkError r102, ByteString r103) {
        super(ADAPTER, r103);
        if (Internal.countNonNull(r101, r102) > 1) goto L7;
        this.upload_id = r100;
        this.success = r101;
        this.error = r102;
        return;
    L7:
        throw new IllegalArgumentException("at most one of success, error may be non-null");
    }
}
