package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class PreviewVideo extends com.squareup.wire.Message<PreviewVideo, Builder> {
    public static final ProtoAdapter<PreviewVideo> ADAPTER = null;
    public static final String DEFAULT_IFRAME_URL = "";
    public static final Site DEFAULT_SITE = null;
    public static final String DEFAULT_VID = "";
    private static final long serialVersionUID = 0;
    public final String iframe_url;
    public final Site site;
    public final String vid;

    public static final class Builder extends com.squareup.wire.Message.Builder<PreviewVideo, Builder> {
        public String iframe_url;
        public Site site;
        public String vid;

        @Override // com.squareup.wire.Message.Builder
        public PreviewVideo build() {
            Site r100 = this.site;
            if (r100 == null) goto L7;
            return new PreviewVideo(this.site, this.vid, this.iframe_url, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "site"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder iframe_url(String r100) {
            this.iframe_url = r100;
            return this;
        }

        public Builder site(Site r100) {
            this.site = r100;
            return this;
        }

        public Builder vid(String r100) {
            this.vid = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PreviewVideo extends ProtoAdapter<PreviewVideo> {
        public ProtoAdapter_PreviewVideo() {
            super(FieldEncoding.LENGTH_DELIMITED, PreviewVideo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PreviewVideo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.site = Site.UNKNOWN;
            r101.vid = "";
            r101.iframe_url = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.site = Site.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.vid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.iframe_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PreviewVideo r100) {
            int r101 = Site.ADAPTER.encodedSizeWithTag(1, r100.site);
            String r102 = r100.vid;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            String r106 = r100.iframe_url;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.STRING.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PreviewVideo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PreviewVideo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PreviewVideo r101) throws IOException {
            Site.ADAPTER.encodeWithTag(r100, 1, r101.site);
            String r102 = r101.vid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            String r103 = r101.iframe_url;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PreviewVideo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Site extends Enum<Site> implements WireEnum {
        private static final /* synthetic */ Site[] $VALUES = null;
        public static final ProtoAdapter<Site> ADAPTER = null;
        public static final Site DOUYIN = null;
        public static final Site HUOSHAN = null;
        public static final Site IQIYI = null;
        public static final Site QQ = null;
        public static final Site UNKNOWN = null;
        public static final Site XIGUA = null;
        public static final Site YOUKU = null;
        public static final Site YOUTUBE = null;
        private final int value;

        static {
            Site r100 = new Site("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Site r101 = new Site("XIGUA", 1, 1);
            XIGUA = r101;
            Site r102 = new Site("DOUYIN", 2, 2);
            DOUYIN = r102;
            Site r103 = new Site("HUOSHAN", 3, 3);
            HUOSHAN = r103;
            Site r104 = new Site("YOUTUBE", 4, 4);
            YOUTUBE = r104;
            Site r105 = new Site("IQIYI", 5, 5);
            IQIYI = r105;
            Site r110 = new Site("YOUKU", 6, 6);
            YOUKU = r110;
            Site r111 = new Site(Constants.SOURCE_QQ, 7, 7);
            QQ = r111;
            $VALUES = new Site[]{r100, r101, r102, r103, r104, r105, r110, r111};
            ADAPTER = ProtoAdapter.newEnumAdapter(Site.class);
        }

        public static Site[] values() {
            return (Site[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Site fromValue(int r100) {
            switch(r100) {
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return QQ;
        L8:
            return YOUKU;
        L10:
            return IQIYI;
        L12:
            return YOUTUBE;
        L14:
            return HUOSHAN;
        L16:
            return DOUYIN;
        L18:
            return XIGUA;
        L20:
            return UNKNOWN;
        }

        public static Site valueOf(String r100) {
            return (Site) a.a(Site.class, r100);
        }

        private Site(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PreviewVideo();
        DEFAULT_SITE = Site.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.site = this.site;
        r100.vid = this.vid;
        r100.iframe_url = this.iframe_url;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PreviewVideo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public PreviewVideo(Site r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PreviewVideo(Site r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.site = r100;
        this.vid = r101;
        this.iframe_url = r102;
    }
}
