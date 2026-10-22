package com.bytedance.lark.pb.media.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class ImageStyleDetectResponse extends Message<ImageStyleDetectResponse, Builder> {
    public static final ProtoAdapter<ImageStyleDetectResponse> ADAPTER = null;
    public static final ImageStyle DEFAULT_STYLE = null;
    public static final ProtoAdapter_ImageStyleDetectResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ImageStyle style;

    public static final class Builder extends Message.Builder<ImageStyleDetectResponse, Builder> implements d<ImageStyleDetectResponse> {
        public ImageStyle style;

        @Override // com.squareup.wire.Message.Builder
        public ImageStyleDetectResponse build() {
            ImageStyle r100 = this.style;
            if (r100 == null) goto L7;
            return new ImageStyleDetectResponse(this.style, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "style"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder style(ImageStyle r100) {
            this.style = r100;
            return this;
        }
    }

    public static final enum ImageStyle extends Enum<ImageStyle> implements WireEnum {
        private static final /* synthetic */ ImageStyle[] $VALUES = null;
        public static final ProtoAdapter<ImageStyle> ADAPTER = null;
        public static final ImageStyle DARK = null;
        public static final ImageStyle LIGHT = null;
        private final int value;

        static {
            ImageStyle r100 = new ImageStyle("LIGHT", 0, 1);
            LIGHT = r100;
            ImageStyle r101 = new ImageStyle("DARK", 1, 2);
            DARK = r101;
            $VALUES = new ImageStyle[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(ImageStyle.class);
        }

        public static ImageStyle[] values() {
            return (ImageStyle[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ImageStyle fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return DARK;
        L11:
            return LIGHT;
        }

        public static ImageStyle valueOf(String r100) {
            return (ImageStyle) a.a(ImageStyle.class, r100);
        }

        private ImageStyle(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_ImageStyleDetectResponse extends ProtoAdapter<ImageStyleDetectResponse> implements c<ImageStyleDetectResponse> {
        public ProtoAdapter_ImageStyleDetectResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, ImageStyleDetectResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ImageStyleDetectResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.style = ImageStyle.LIGHT;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.style = ImageStyle.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
        public int encodedSize2(ImageStyleDetectResponse r100) {
            return ImageStyle.ADAPTER.encodedSizeWithTag(1, r100.style) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ImageStyleDetectResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ImageStyleDetectResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ImageStyleDetectResponse r101) throws IOException {
            ImageStyle.ADAPTER.encodeWithTag(r100, 1, r101.style);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ImageStyleDetectResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_ImageStyleDetectResponse r100 = new ProtoAdapter_ImageStyleDetectResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STYLE = ImageStyle.LIGHT;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.style = this.style;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ImageStyleDetectResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ImageStyleDetectResponse(ImageStyle r100) {
        this(r100, ByteString.EMPTY);
    }

    public ImageStyleDetectResponse(ImageStyle r100, ByteString r101) {
        super(ADAPTER, r101);
        this.style = r100;
    }
}
