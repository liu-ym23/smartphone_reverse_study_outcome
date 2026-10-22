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
public final class ChunkyUploadRequest extends Message<ChunkyUploadRequest, Builder> {
    public static final ProtoAdapter<ChunkyUploadRequest> ADAPTER = null;
    public static final Integer DEFAULT_CANCEL = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_CID = "";
    public static final Long DEFAULT_UPLOAD_ID = null;
    public static final ProtoAdapter_ChunkyUploadRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Integer cancel;
    public final String chat_id;
    public final String cid;
    public final ChunkInfo data;
    public final Long upload_id;

    public static final class Builder extends Message.Builder<ChunkyUploadRequest, Builder> implements d<ChunkyUploadRequest> {
        public Integer cancel;
        public String chat_id;
        public String cid;
        public ChunkInfo data;
        public Long upload_id;

        @Override // com.squareup.wire.Message.Builder
        public ChunkyUploadRequest build() {
            Long r100 = this.upload_id;
            if (r100 == null) goto L7;
            return new ChunkyUploadRequest(this.upload_id, this.cid, this.chat_id, this.cancel, this.data, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "upload_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cancel(Integer r100) {
            this.cancel = r100;
            this.data = null;
            return this;
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder cid(String r100) {
            this.cid = r100;
            return this;
        }

        public Builder data(ChunkInfo r100) {
            this.data = r100;
            this.cancel = null;
            return this;
        }

        public Builder upload_id(Long r100) {
            this.upload_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChunkyUploadRequest extends ProtoAdapter<ChunkyUploadRequest> implements c<ChunkyUploadRequest> {
        public ProtoAdapter_ChunkyUploadRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, ChunkyUploadRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChunkyUploadRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.upload_id = 0L;
            r101.cid = "";
            r101.chat_id = "";
            r101.cancel(0);
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.upload_id = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.cid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.cancel(ProtoAdapter.INT32.decode(r100));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.data(ChunkInfo.ADAPTER.decode(r100));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ChunkyUploadRequest r100) {
            int r101 = ProtoAdapter.UINT64.encodedSizeWithTag(1, r100.upload_id);
            String r102 = r100.cid;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            String r106 = r100.chat_id;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.STRING.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            Integer r109 = r100.cancel;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.INT32.encodedSizeWithTag(4, r109);
        L14:
            int r111 = r108 + r110;
            ChunkInfo r112 = r100.data;
            if (r112 == null) goto L18;
            r103 = ChunkInfo.ADAPTER.encodedSizeWithTag(5, r112);
        L18:
            return (r111 + r103) + r100.unknownFields().size();
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ChunkyUploadRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChunkyUploadRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChunkyUploadRequest r101) throws IOException {
            ProtoAdapter.UINT64.encodeWithTag(r100, 1, r101.upload_id);
            String r102 = r101.cid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            String r103 = r101.chat_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L8:
            Integer r104 = r101.cancel;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r104);
        L11:
            ChunkInfo r105 = r101.data;
            if (r105 == null) goto L14;
            ChunkInfo.ADAPTER.encodeWithTag(r100, 5, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChunkyUploadRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_ChunkyUploadRequest r100 = new ProtoAdapter_ChunkyUploadRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_UPLOAD_ID = 0L;
        DEFAULT_CANCEL = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.upload_id = this.upload_id;
        r100.cid = this.cid;
        r100.chat_id = this.chat_id;
        r100.cancel = this.cancel;
        r100.data = this.data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChunkyUploadRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChunkyUploadRequest(Long r100, String r101, String r110, Integer r111, ChunkInfo r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public ChunkyUploadRequest(Long r100, String r101, String r102, Integer r103, ChunkInfo r104, ByteString r105) {
        super(ADAPTER, r105);
        if (Internal.countNonNull(r103, r104) > 1) goto L7;
        this.upload_id = r100;
        this.cid = r101;
        this.chat_id = r102;
        this.cancel = r103;
        this.data = r104;
        return;
    L7:
        throw new IllegalArgumentException("at most one of cancel, data may be non-null");
    }
}
