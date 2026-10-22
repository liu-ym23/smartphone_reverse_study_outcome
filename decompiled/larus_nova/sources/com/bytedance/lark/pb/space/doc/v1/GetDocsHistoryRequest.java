package com.bytedance.lark.pb.space.doc.v1;

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
public final class GetDocsHistoryRequest extends Message<GetDocsHistoryRequest, Builder> {
    public static final ProtoAdapter<GetDocsHistoryRequest> ADAPTER = null;
    public static final Long DEFAULT_BEGIN_TIME = null;
    public static final Long DEFAULT_COUNT = null;
    public static final ProtoAdapter_GetDocsHistoryRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long begin_time;
    public final Long count;

    public static final class Builder extends Message.Builder<GetDocsHistoryRequest, Builder> implements d<GetDocsHistoryRequest> {
        public Long begin_time;
        public Long count;

        @Override // com.squareup.wire.Message.Builder
        public GetDocsHistoryRequest build() {
            Long r100 = this.begin_time;
            if (r100 == null) goto L9;
            if (this.count == null) goto L9;
            return new GetDocsHistoryRequest(this.begin_time, this.count, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "begin_time", this.count, "count"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder begin_time(Long r100) {
            this.begin_time = r100;
            return this;
        }

        public Builder count(Long r100) {
            this.count = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetDocsHistoryRequest extends ProtoAdapter<GetDocsHistoryRequest> implements c<GetDocsHistoryRequest> {
        public ProtoAdapter_GetDocsHistoryRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetDocsHistoryRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetDocsHistoryRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.begin_time = 0L;
            r101.count = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.begin_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.count = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(GetDocsHistoryRequest r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            return (r101.encodedSizeWithTag(1, r100.begin_time) + r101.encodedSizeWithTag(2, r100.count)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetDocsHistoryRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetDocsHistoryRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetDocsHistoryRequest r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 1, r101.begin_time);
            r102.encodeWithTag(r100, 2, r101.count);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetDocsHistoryRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetDocsHistoryRequest r100 = new ProtoAdapter_GetDocsHistoryRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_BEGIN_TIME = 0L;
        DEFAULT_COUNT = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.begin_time = this.begin_time;
        r100.count = this.count;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetDocsHistoryRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetDocsHistoryRequest(Long r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetDocsHistoryRequest(Long r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.begin_time = r100;
        this.count = r101;
    }
}
