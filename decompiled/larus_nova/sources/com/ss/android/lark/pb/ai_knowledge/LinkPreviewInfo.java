package com.ss.android.lark.pb.ai_knowledge;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class LinkPreviewInfo extends Message<LinkPreviewInfo, Builder> {
    public static final ProtoAdapter<LinkPreviewInfo> ADAPTER = null;
    public static final String DEFAULT_ICON_IMG_KEY = "";
    public static final String DEFAULT_ICON_URL = "";
    public static final String DEFAULT_LINK = "";
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    public final String micon_img_key;
    public final String micon_url;
    public final String mlink;
    public final String mtitle;

    public static final class Builder extends Message.Builder<LinkPreviewInfo, Builder> {
        public String micon_img_key;
        public String micon_url;
        public String mlink;
        public String mtitle;

        @Override // com.squareup.wire.Message.Builder
        public LinkPreviewInfo build() {
            return new LinkPreviewInfo(this.mlink, this.mtitle, this.micon_img_key, this.micon_url, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder icon_img_key(String r100) {
            this.micon_img_key = r100;
            return this;
        }

        public Builder icon_url(String r100) {
            this.micon_url = r100;
            return this;
        }

        public Builder link(String r100) {
            this.mlink = r100;
            return this;
        }

        public Builder title(String r100) {
            this.mtitle = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LinkPreviewInfo extends ProtoAdapter<LinkPreviewInfo> {
        public ProtoAdapter_LinkPreviewInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, LinkPreviewInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public LinkPreviewInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mlink = "";
            r101.mtitle = "";
            r101.micon_img_key = "";
            r101.micon_url = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mlink = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mtitle = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.micon_img_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.micon_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(LinkPreviewInfo r100) {
            String r101 = r100.mlink;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mtitle;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.micon_img_key;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.micon_url;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ LinkPreviewInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LinkPreviewInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LinkPreviewInfo r101) throws IOException {
            String r102 = r101.mlink;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mtitle;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.micon_img_key;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.micon_url;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LinkPreviewInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LinkPreviewInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mlink = this.mlink;
        r100.mtitle = this.mtitle;
        r100.micon_img_key = this.micon_img_key;
        r100.micon_url = this.micon_url;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LinkPreviewInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LinkPreviewInfo(String r100, String r101, String r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public LinkPreviewInfo(String r100, String r101, String r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mlink = r100;
        this.mtitle = r101;
        this.micon_img_key = r102;
        this.micon_url = r103;
    }
}
