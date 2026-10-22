package com.bytedance.lark.pb.media.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetImageCompressParametersResponse extends Message<GetImageCompressParametersResponse, Builder> {
    public static final ProtoAdapter<GetImageCompressParametersResponse> ADAPTER = null;
    public static final Integer DEFAULT_QUALITY = null;
    public static final Integer DEFAULT_SHORT_SIDE = null;
    public static final ProtoAdapter_GetImageCompressParametersResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Integer quality;
    public final Integer short_side;

    public static final class Builder extends Message.Builder<GetImageCompressParametersResponse, Builder> implements d<GetImageCompressParametersResponse> {
        public Integer quality;
        public Integer short_side;

        @Override // com.squareup.wire.Message.Builder
        public GetImageCompressParametersResponse build() {
            Integer r100 = this.short_side;
            if (r100 == null) goto L9;
            if (this.quality == null) goto L9;
            return new GetImageCompressParametersResponse(this.short_side, this.quality, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "short_side", this.quality, GearStrategyConsts.EV_QUALITY});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder quality(Integer r100) {
            this.quality = r100;
            return this;
        }

        public Builder short_side(Integer r100) {
            this.short_side = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetImageCompressParametersResponse extends ProtoAdapter<GetImageCompressParametersResponse> implements c<GetImageCompressParametersResponse> {
        public ProtoAdapter_GetImageCompressParametersResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetImageCompressParametersResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetImageCompressParametersResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.short_side = 0;
            r101.quality = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.short_side = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.quality = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(GetImageCompressParametersResponse r100) {
            ProtoAdapter<Integer> r101 = ProtoAdapter.INT32;
            return (r101.encodedSizeWithTag(1, r100.short_side) + r101.encodedSizeWithTag(2, r100.quality)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetImageCompressParametersResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetImageCompressParametersResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetImageCompressParametersResponse r101) throws IOException {
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            r102.encodeWithTag(r100, 1, r101.short_side);
            r102.encodeWithTag(r100, 2, r101.quality);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetImageCompressParametersResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetImageCompressParametersResponse r100 = new ProtoAdapter_GetImageCompressParametersResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SHORT_SIDE = 0;
        DEFAULT_QUALITY = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.short_side = this.short_side;
        r100.quality = this.quality;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetImageCompressParametersResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetImageCompressParametersResponse(Integer r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetImageCompressParametersResponse(Integer r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.short_side = r100;
        this.quality = r101;
    }
}
