package com.bytedance.lark.pb.todo.v1;

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
public final class GetRecommendedContentsRequest extends Message<GetRecommendedContentsRequest, Builder> {
    public static final ProtoAdapter<GetRecommendedContentsRequest> ADAPTER = null;
    public static final Integer DEFAULT_COUNT = null;
    public static final ProtoAdapter_GetRecommendedContentsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Integer count;

    public static final class Builder extends Message.Builder<GetRecommendedContentsRequest, Builder> implements d<GetRecommendedContentsRequest> {
        public Integer count;

        @Override // com.squareup.wire.Message.Builder
        public GetRecommendedContentsRequest build() {
            return new GetRecommendedContentsRequest(this.count, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder count(Integer r100) {
            this.count = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetRecommendedContentsRequest extends ProtoAdapter<GetRecommendedContentsRequest> implements c<GetRecommendedContentsRequest> {
        public ProtoAdapter_GetRecommendedContentsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetRecommendedContentsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetRecommendedContentsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.count = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetRecommendedContentsRequest r100) {
            Integer r101 = r100.count;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetRecommendedContentsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetRecommendedContentsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetRecommendedContentsRequest r101) throws IOException {
            Integer r102 = r101.count;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetRecommendedContentsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetRecommendedContentsRequest r100 = new ProtoAdapter_GetRecommendedContentsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_COUNT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.count = this.count;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetRecommendedContentsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetRecommendedContentsRequest(Integer r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetRecommendedContentsRequest(Integer r100, ByteString r101) {
        super(ADAPTER, r101);
        this.count = r100;
    }
}
