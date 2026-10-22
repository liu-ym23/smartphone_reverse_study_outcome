package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class BannerText extends Message<BannerText, Builder> {
    public static final ProtoAdapter<BannerText> ADAPTER = null;
    public static final String DEFAULT_HEAD_ICON = "";
    public static final String DEFAULT_RICH_TEXT = "";
    public static final String DEFAULT_TAIL_ICON = "";
    private static final long serialVersionUID = 0;
    public final String mhead_icon;
    public final String mrich_text;
    public final String mtail_icon;
    public final BannerTextType mtext_type;

    public static final class Builder extends Message.Builder<BannerText, Builder> {
        public String mhead_icon;
        public String mrich_text;
        public String mtail_icon;
        public BannerTextType mtext_type;

        @Override // com.squareup.wire.Message.Builder
        public BannerText build() {
            return new BannerText(this.mrich_text, this.mhead_icon, this.mtail_icon, this.mtext_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder head_icon(String r100) {
            this.mhead_icon = r100;
            return this;
        }

        public Builder rich_text(String r100) {
            this.mrich_text = r100;
            return this;
        }

        public Builder tail_icon(String r100) {
            this.mtail_icon = r100;
            return this;
        }

        public Builder text_type(BannerTextType r100) {
            this.mtext_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BannerText extends ProtoAdapter<BannerText> {
        public ProtoAdapter_BannerText() {
            super(FieldEncoding.LENGTH_DELIMITED, BannerText.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BannerText decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mrich_text = "";
            r101.mhead_icon = "";
            r101.mtail_icon = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mrich_text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mhead_icon = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mtail_icon = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mtext_type = BannerTextType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BannerText r100) {
            String r101 = r100.mrich_text;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mhead_icon;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mtail_icon;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            BannerTextType r110 = r100.mtext_type;
            if (r110 == null) goto L18;
            r102 = BannerTextType.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ BannerText decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BannerText r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BannerText r101) throws IOException {
            String r102 = r101.mrich_text;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mhead_icon;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mtail_icon;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            BannerTextType r105 = r101.mtext_type;
            if (r105 == null) goto L14;
            BannerTextType.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BannerText r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BannerText();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mrich_text = this.mrich_text;
        r100.mhead_icon = this.mhead_icon;
        r100.mtail_icon = this.mtail_icon;
        r100.mtext_type = this.mtext_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BannerText.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BannerText(String r100, String r101, String r102, BannerTextType r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public BannerText(String r100, String r101, String r102, BannerTextType r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mrich_text = r100;
        this.mhead_icon = r101;
        this.mtail_icon = r102;
        this.mtext_type = r103;
    }
}
