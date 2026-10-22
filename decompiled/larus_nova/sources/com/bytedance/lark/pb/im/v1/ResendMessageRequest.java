package com.bytedance.lark.pb.im.v1;

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
public final class ResendMessageRequest extends Message<ResendMessageRequest, Builder> {
    public static final ProtoAdapter<ResendMessageRequest> ADAPTER = null;
    public static final String DEFAULT_CID = "";
    public static final Long DEFAULT_FILE_HANDLE = null;
    public static final ProtoAdapter_ResendMessageRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String cid;
    public final Long file_handle;

    public static final class Builder extends Message.Builder<ResendMessageRequest, Builder> implements d<ResendMessageRequest> {
        public String cid;
        public Long file_handle;

        @Override // com.squareup.wire.Message.Builder
        public ResendMessageRequest build() {
            String r100 = this.cid;
            if (r100 == null) goto L7;
            return new ResendMessageRequest(this.cid, this.file_handle, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "cid"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cid(String r100) {
            this.cid = r100;
            return this;
        }

        public Builder file_handle(Long r100) {
            this.file_handle = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ResendMessageRequest extends ProtoAdapter<ResendMessageRequest> implements c<ResendMessageRequest> {
        public ProtoAdapter_ResendMessageRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, ResendMessageRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ResendMessageRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.cid = "";
            r101.file_handle = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.cid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.file_handle = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(ResendMessageRequest r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.cid);
            Long r102 = r100.file_handle;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ResendMessageRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ResendMessageRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ResendMessageRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.cid);
            Long r102 = r101.file_handle;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ResendMessageRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_ResendMessageRequest r100 = new ProtoAdapter_ResendMessageRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_FILE_HANDLE = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.cid = this.cid;
        r100.file_handle = this.file_handle;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ResendMessageRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ResendMessageRequest(String r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ResendMessageRequest(String r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.cid = r100;
        this.file_handle = r101;
    }
}
