package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class BannerTemplateMore extends Message<BannerTemplateMore, Builder> {
    public static final ProtoAdapter<BannerTemplateMore> ADAPTER = null;
    public static final String DEFAULT_BACKGROUND_COLOR = "";
    public static final String DEFAULT_FRAME_COLOR = "";
    private static final long serialVersionUID = 0;
    public final String mbackground_color;
    public final ImageElement mcontent_pic;
    public final String mframe_color;
    public final TextElement mlink;
    public final TextElement mname;

    public static final class Builder extends Message.Builder<BannerTemplateMore, Builder> {
        public String mbackground_color;
        public ImageElement mcontent_pic;
        public String mframe_color;
        public TextElement mlink;
        public TextElement mname;

        @Override // com.squareup.wire.Message.Builder
        public BannerTemplateMore build() {
            return new BannerTemplateMore(this.mbackground_color, this.mcontent_pic, this.mname, this.mlink, this.mframe_color, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder background_color(String r100) {
            this.mbackground_color = r100;
            return this;
        }

        public Builder content_pic(ImageElement r100) {
            this.mcontent_pic = r100;
            return this;
        }

        public Builder frame_color(String r100) {
            this.mframe_color = r100;
            return this;
        }

        public Builder link(TextElement r100) {
            this.mlink = r100;
            return this;
        }

        public Builder name(TextElement r100) {
            this.mname = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BannerTemplateMore extends ProtoAdapter<BannerTemplateMore> {
        public ProtoAdapter_BannerTemplateMore() {
            super(FieldEncoding.LENGTH_DELIMITED, BannerTemplateMore.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BannerTemplateMore decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mbackground_color = "";
            r101.mframe_color = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mbackground_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mcontent_pic = ImageElement.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mname = TextElement.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.mlink = TextElement.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.mframe_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BannerTemplateMore r100) {
            String r101 = r100.mbackground_color;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ImageElement r104 = r100.mcontent_pic;
            if (r104 == null) goto L9;
            int r105 = ImageElement.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            TextElement r107 = r100.mname;
            if (r107 == null) goto L13;
            int r108 = TextElement.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            TextElement r110 = r100.mlink;
            if (r110 == null) goto L17;
            int r111 = TextElement.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.mframe_color;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BannerTemplateMore decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BannerTemplateMore r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BannerTemplateMore r101) throws IOException {
            String r102 = r101.mbackground_color;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ImageElement r103 = r101.mcontent_pic;
            if (r103 == null) goto L8;
            ImageElement.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            TextElement r104 = r101.mname;
            if (r104 == null) goto L11;
            TextElement.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            TextElement r105 = r101.mlink;
            if (r105 == null) goto L14;
            TextElement.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.mframe_color;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BannerTemplateMore r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BannerTemplateMore();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mbackground_color = this.mbackground_color;
        r100.mcontent_pic = this.mcontent_pic;
        r100.mname = this.mname;
        r100.mlink = this.mlink;
        r100.mframe_color = this.mframe_color;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BannerTemplateMore.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BannerTemplateMore(String r100, ImageElement r101, TextElement r110, TextElement r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public BannerTemplateMore(String r100, ImageElement r101, TextElement r102, TextElement r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.mbackground_color = r100;
        this.mcontent_pic = r101;
        this.mname = r102;
        this.mlink = r103;
        this.mframe_color = r104;
    }
}
