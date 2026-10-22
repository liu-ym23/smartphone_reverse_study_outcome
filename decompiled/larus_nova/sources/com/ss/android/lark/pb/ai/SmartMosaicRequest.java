package com.ss.android.lark.pb.ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class SmartMosaicRequest extends Message<SmartMosaicRequest, Builder> {
    public static final ProtoAdapter<SmartMosaicRequest> ADAPTER = null;
    public static final Boolean DEFAULT_AVATAR = null;
    public static final Boolean DEFAULT_TEXT = null;
    private static final long serialVersionUID = 0;
    public final Boolean mavatar;
    public final ImageInfo mimage;
    public final Boolean mtext;

    public static final class Builder extends Message.Builder<SmartMosaicRequest, Builder> {
        public Boolean mavatar;
        public ImageInfo mimage;
        public Boolean mtext;

        @Override // com.squareup.wire.Message.Builder
        public SmartMosaicRequest build() {
            ImageInfo r100 = this.mimage;
            if (r100 == null) goto L7;
            return new SmartMosaicRequest(this.mimage, this.mtext, this.mavatar, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mimage"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder avatar(Boolean r100) {
            this.mavatar = r100;
            return this;
        }

        public Builder image(ImageInfo r100) {
            this.mimage = r100;
            return this;
        }

        public Builder text(Boolean r100) {
            this.mtext = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SmartMosaicRequest extends ProtoAdapter<SmartMosaicRequest> {
        public ProtoAdapter_SmartMosaicRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SmartMosaicRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SmartMosaicRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.TRUE;
            r101.mtext = r102;
            r101.mavatar = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L15;
            if (r104 != 1) goto L8;
            r101.mimage = ImageInfo.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.mtext = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L11;
            r101.mavatar = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SmartMosaicRequest r100) {
            int r101 = ImageInfo.ADAPTER.encodedSizeWithTag(1, r100.mimage);
            Boolean r102 = r100.mtext;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.mavatar;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SmartMosaicRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SmartMosaicRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SmartMosaicRequest r101) throws IOException {
            ImageInfo.ADAPTER.encodeWithTag(r100, 1, r101.mimage);
            Boolean r102 = r101.mtext;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            Boolean r103 = r101.mavatar;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SmartMosaicRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SmartMosaicRequest();
        Boolean r100 = Boolean.TRUE;
        DEFAULT_TEXT = r100;
        DEFAULT_AVATAR = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mimage = this.mimage;
        r100.mtext = this.mtext;
        r100.mavatar = this.mavatar;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SmartMosaicRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SmartMosaicRequest(ImageInfo r100, Boolean r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public SmartMosaicRequest(ImageInfo r100, Boolean r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mimage = r100;
        this.mtext = r101;
        this.mavatar = r102;
    }
}
