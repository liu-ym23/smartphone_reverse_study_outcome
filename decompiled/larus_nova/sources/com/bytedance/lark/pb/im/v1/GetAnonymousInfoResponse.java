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
public final class GetAnonymousInfoResponse extends Message<GetAnonymousInfoResponse, Builder> {
    public static final ProtoAdapter<GetAnonymousInfoResponse> ADAPTER = null;
    public static final Long DEFAULT_LEFT_QUOTA = null;
    public static final Long DEFAULT_TOTAL_QUOTA = null;
    public static final ProtoAdapter_GetAnonymousInfoResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long left_quota;
    public final Long total_quota;

    public static final class Builder extends Message.Builder<GetAnonymousInfoResponse, Builder> implements d<GetAnonymousInfoResponse> {
        public Long left_quota;
        public Long total_quota;

        @Override // com.squareup.wire.Message.Builder
        public GetAnonymousInfoResponse build() {
            Long r100 = this.left_quota;
            if (r100 == null) goto L7;
            return new GetAnonymousInfoResponse(this.left_quota, this.total_quota, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "left_quota"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder left_quota(Long r100) {
            this.left_quota = r100;
            return this;
        }

        public Builder total_quota(Long r100) {
            this.total_quota = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetAnonymousInfoResponse extends ProtoAdapter<GetAnonymousInfoResponse> implements c<GetAnonymousInfoResponse> {
        public ProtoAdapter_GetAnonymousInfoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetAnonymousInfoResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetAnonymousInfoResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.left_quota = 0L;
            r101.total_quota = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.left_quota = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.total_quota = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(GetAnonymousInfoResponse r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            int r102 = r101.encodedSizeWithTag(1, r100.left_quota);
            Long r103 = r100.total_quota;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(2, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetAnonymousInfoResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetAnonymousInfoResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetAnonymousInfoResponse r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 1, r101.left_quota);
            Long r103 = r101.total_quota;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetAnonymousInfoResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetAnonymousInfoResponse r100 = new ProtoAdapter_GetAnonymousInfoResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_LEFT_QUOTA = 0L;
        DEFAULT_TOTAL_QUOTA = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.left_quota = this.left_quota;
        r100.total_quota = this.total_quota;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetAnonymousInfoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetAnonymousInfoResponse(Long r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetAnonymousInfoResponse(Long r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.left_quota = r100;
        this.total_quota = r101;
    }
}
