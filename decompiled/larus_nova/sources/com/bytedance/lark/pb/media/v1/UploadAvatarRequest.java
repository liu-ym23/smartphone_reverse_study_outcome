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
public final class UploadAvatarRequest extends Message<UploadAvatarRequest, Builder> {
    public static final ProtoAdapter<UploadAvatarRequest> ADAPTER = null;
    public static final ByteString DEFAULT_IMAGE = null;
    public static final Boolean DEFAULT_NEED_MOSAIC = null;
    public static final ProtoAdapter_UploadAvatarRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ByteString image;
    public final Boolean need_mosaic;

    public static final class Builder extends Message.Builder<UploadAvatarRequest, Builder> implements d<UploadAvatarRequest> {
        public ByteString image;
        public Boolean need_mosaic;

        @Override // com.squareup.wire.Message.Builder
        public UploadAvatarRequest build() {
            ByteString r100 = this.image;
            if (r100 == null) goto L7;
            return new UploadAvatarRequest(this.image, this.need_mosaic, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "image"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder image(ByteString r100) {
            this.image = r100;
            return this;
        }

        public Builder need_mosaic(Boolean r100) {
            this.need_mosaic = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UploadAvatarRequest extends ProtoAdapter<UploadAvatarRequest> implements c<UploadAvatarRequest> {
        public ProtoAdapter_UploadAvatarRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UploadAvatarRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UploadAvatarRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.image = ByteString.EMPTY;
            r101.need_mosaic = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.image = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.need_mosaic = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(UploadAvatarRequest r100) {
            int r101 = ProtoAdapter.BYTES.encodedSizeWithTag(1, r100.image);
            Boolean r102 = r100.need_mosaic;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UploadAvatarRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UploadAvatarRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UploadAvatarRequest r101) throws IOException {
            ProtoAdapter.BYTES.encodeWithTag(r100, 1, r101.image);
            Boolean r102 = r101.need_mosaic;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UploadAvatarRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UploadAvatarRequest r100 = new ProtoAdapter_UploadAvatarRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_IMAGE = ByteString.EMPTY;
        DEFAULT_NEED_MOSAIC = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.image = this.image;
        r100.need_mosaic = this.need_mosaic;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UploadAvatarRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UploadAvatarRequest(ByteString r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public UploadAvatarRequest(ByteString r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.image = r100;
        this.need_mosaic = r101;
    }
}
