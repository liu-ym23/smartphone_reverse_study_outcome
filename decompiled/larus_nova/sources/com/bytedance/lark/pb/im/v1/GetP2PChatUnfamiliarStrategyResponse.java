package com.bytedance.lark.pb.im.v1;

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
public final class GetP2PChatUnfamiliarStrategyResponse extends Message<GetP2PChatUnfamiliarStrategyResponse, Builder> {
    public static final ProtoAdapter<GetP2PChatUnfamiliarStrategyResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HIT_STRATEGY = null;
    public static final Long DEFAULT_JOIN_TIME = null;
    public static final ProtoAdapter_GetP2PChatUnfamiliarStrategyResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean hit_strategy;
    public final Long join_time;

    public static final class Builder extends Message.Builder<GetP2PChatUnfamiliarStrategyResponse, Builder> implements d<GetP2PChatUnfamiliarStrategyResponse> {
        public Boolean hit_strategy;
        public Long join_time;

        @Override // com.squareup.wire.Message.Builder
        public GetP2PChatUnfamiliarStrategyResponse build() {
            return new GetP2PChatUnfamiliarStrategyResponse(this.hit_strategy, this.join_time, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder hit_strategy(Boolean r100) {
            this.hit_strategy = r100;
            return this;
        }

        public Builder join_time(Long r100) {
            this.join_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetP2PChatUnfamiliarStrategyResponse extends ProtoAdapter<GetP2PChatUnfamiliarStrategyResponse> implements c<GetP2PChatUnfamiliarStrategyResponse> {
        public ProtoAdapter_GetP2PChatUnfamiliarStrategyResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetP2PChatUnfamiliarStrategyResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetP2PChatUnfamiliarStrategyResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.hit_strategy = Boolean.FALSE;
            r101.join_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.hit_strategy = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.join_time = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(GetP2PChatUnfamiliarStrategyResponse r100) {
            Boolean r101 = r100.hit_strategy;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.join_time;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetP2PChatUnfamiliarStrategyResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetP2PChatUnfamiliarStrategyResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetP2PChatUnfamiliarStrategyResponse r101) throws IOException {
            Boolean r102 = r101.hit_strategy;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.join_time;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetP2PChatUnfamiliarStrategyResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetP2PChatUnfamiliarStrategyResponse r100 = new ProtoAdapter_GetP2PChatUnfamiliarStrategyResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_HIT_STRATEGY = Boolean.FALSE;
        DEFAULT_JOIN_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.hit_strategy = this.hit_strategy;
        r100.join_time = this.join_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetP2PChatUnfamiliarStrategyResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetP2PChatUnfamiliarStrategyResponse(Boolean r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetP2PChatUnfamiliarStrategyResponse(Boolean r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.hit_strategy = r100;
        this.join_time = r101;
    }
}
