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
public final class GetImageCompressParametersRequest extends Message<GetImageCompressParametersRequest, Builder> {
    public static final ProtoAdapter<GetImageCompressParametersRequest> ADAPTER = null;
    public static final Long DEFAULT_IMAGE_SIZE = null;
    public static final Integer DEFAULT_LONG_SIDE = null;
    public static final Integer DEFAULT_QUALITY = null;
    public static final Integer DEFAULT_SHORT_SIDE = null;
    public static final Integer DEFAULT_TARGET_QUALITY = null;
    public static final Integer DEFAULT_TARGET_SHORT_SIDE = null;
    public static final ProtoAdapter_GetImageCompressParametersRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long image_size;
    public final Integer long_side;
    public final Integer quality;
    public final Integer short_side;
    public final Integer target_quality;
    public final Integer target_short_side;

    public static final class Builder extends Message.Builder<GetImageCompressParametersRequest, Builder> implements d<GetImageCompressParametersRequest> {
        public Long image_size;
        public Integer long_side;
        public Integer quality;
        public Integer short_side;
        public Integer target_quality;
        public Integer target_short_side;

        @Override // com.squareup.wire.Message.Builder
        public GetImageCompressParametersRequest build() {
            Long r100 = this.image_size;
            if (r100 == null) goto L11;
            if (this.short_side == null) goto L11;
            if (this.long_side == null) goto L11;
            return new GetImageCompressParametersRequest(this.image_size, this.short_side, this.long_side, this.quality, this.target_short_side, this.target_quality, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "image_size", this.short_side, "short_side", this.long_side, "long_side"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder image_size(Long r100) {
            this.image_size = r100;
            return this;
        }

        public Builder long_side(Integer r100) {
            this.long_side = r100;
            return this;
        }

        public Builder quality(Integer r100) {
            this.quality = r100;
            return this;
        }

        public Builder short_side(Integer r100) {
            this.short_side = r100;
            return this;
        }

        public Builder target_quality(Integer r100) {
            this.target_quality = r100;
            return this;
        }

        public Builder target_short_side(Integer r100) {
            this.target_short_side = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetImageCompressParametersRequest extends ProtoAdapter<GetImageCompressParametersRequest> implements c<GetImageCompressParametersRequest> {
        public ProtoAdapter_GetImageCompressParametersRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetImageCompressParametersRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetImageCompressParametersRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.image_size = 0L;
            r101.short_side = 0;
            r101.long_side = 0;
            r101.quality = 0;
            r101.target_short_side = 0;
            r101.target_quality = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L13;
            switch(r103) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.target_quality = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            r101.target_short_side = ProtoAdapter.INT32.decode(r100);
            goto L3
        L9:
            r101.quality = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.long_side = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            r101.short_side = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            r101.image_size = ProtoAdapter.INT64.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetImageCompressParametersRequest r100) {
            int r101 = ProtoAdapter.INT64.encodedSizeWithTag(1, r100.image_size);
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            int r103 = (r101 + r102.encodedSizeWithTag(2, r100.short_side)) + r102.encodedSizeWithTag(3, r100.long_side);
            Integer r104 = r100.quality;
            int r105 = 0;
            if (r104 == null) goto L5;
            int r106 = r102.encodedSizeWithTag(4, r104);
        L6:
            int r107 = r103 + r106;
            Integer r108 = r100.target_short_side;
            if (r108 == null) goto L9;
            int r109 = r102.encodedSizeWithTag(5, r108);
        L10:
            int r110 = r107 + r109;
            Integer r111 = r100.target_quality;
            if (r111 == null) goto L14;
            r105 = r102.encodedSizeWithTag(6, r111);
        L14:
            return (r110 + r105) + r100.unknownFields().size();
        L9:
            r109 = 0;
            goto L10
        L5:
            r106 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetImageCompressParametersRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetImageCompressParametersRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetImageCompressParametersRequest r101) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.image_size);
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            r102.encodeWithTag(r100, 2, r101.short_side);
            r102.encodeWithTag(r100, 3, r101.long_side);
            Integer r103 = r101.quality;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 4, r103);
        L5:
            Integer r104 = r101.target_short_side;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 5, r104);
        L8:
            Integer r105 = r101.target_quality;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 6, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetImageCompressParametersRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetImageCompressParametersRequest r100 = new ProtoAdapter_GetImageCompressParametersRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_IMAGE_SIZE = 0L;
        DEFAULT_SHORT_SIDE = 0;
        DEFAULT_LONG_SIDE = 0;
        DEFAULT_QUALITY = 0;
        DEFAULT_TARGET_SHORT_SIDE = 0;
        DEFAULT_TARGET_QUALITY = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.image_size = this.image_size;
        r100.short_side = this.short_side;
        r100.long_side = this.long_side;
        r100.quality = this.quality;
        r100.target_short_side = this.target_short_side;
        r100.target_quality = this.target_quality;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetImageCompressParametersRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetImageCompressParametersRequest(Long r100, Integer r110, Integer r111, Integer r112, Integer r113, Integer r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public GetImageCompressParametersRequest(Long r100, Integer r101, Integer r102, Integer r103, Integer r104, Integer r105, ByteString r106) {
        super(ADAPTER, r106);
        this.image_size = r100;
        this.short_side = r101;
        this.long_side = r102;
        this.quality = r103;
        this.target_short_side = r104;
        this.target_quality = r105;
    }
}
