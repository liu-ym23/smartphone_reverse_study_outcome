package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class PreviewUrlContent extends com.squareup.wire.Message<PreviewUrlContent, Builder> {
    public static final ProtoAdapter<PreviewUrlContent> ADAPTER = null;
    public static final Integer DEFAULT_COUNT = null;
    public static final Boolean DEFAULT_HAS_PREVIEW = null;
    public static final Boolean DEFAULT_IS_HIDDEN = null;
    public static final Integer DEFAULT_OFFSET = null;
    public static final Integer DEFAULT_SEQUENCE_ID = null;
    public static final String DEFAULT_SUMMARY = "";
    public static final String DEFAULT_TITLE = "";
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final Integer count;
    public final ImageSet cover_image;
    public final Boolean has_preview;
    public final ImageSet icon;
    public final Boolean is_hidden;
    public final Integer offset;
    public final Integer sequence_id;
    public final String summary;
    public final String title;
    public final String url;
    public final PreviewVideo video_info;

    public static final class Builder extends com.squareup.wire.Message.Builder<PreviewUrlContent, Builder> {
        public Integer count;
        public ImageSet cover_image;
        public Boolean has_preview;
        public ImageSet icon;
        public Boolean is_hidden;
        public Integer offset;
        public Integer sequence_id;
        public String summary;
        public String title;
        public String url;
        public PreviewVideo video_info;

        @Override // com.squareup.wire.Message.Builder
        public PreviewUrlContent build() {
            Integer r100 = this.sequence_id;
            if (r100 == null) goto L13;
            if (this.url == null) goto L13;
            if (this.offset == null) goto L13;
            if (this.count == null) goto L13;
            return new PreviewUrlContent(this.sequence_id, this.url, this.offset, this.count, this.title, this.summary, this.icon, this.is_hidden, this.has_preview, this.cover_image, this.video_info, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "sequence_id", this.url, "url", this.offset, "offset", this.count, "count"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder count(Integer r100) {
            this.count = r100;
            return this;
        }

        public Builder cover_image(ImageSet r100) {
            this.cover_image = r100;
            return this;
        }

        public Builder has_preview(Boolean r100) {
            this.has_preview = r100;
            return this;
        }

        public Builder icon(ImageSet r100) {
            this.icon = r100;
            return this;
        }

        public Builder is_hidden(Boolean r100) {
            this.is_hidden = r100;
            return this;
        }

        public Builder offset(Integer r100) {
            this.offset = r100;
            return this;
        }

        public Builder sequence_id(Integer r100) {
            this.sequence_id = r100;
            return this;
        }

        public Builder summary(String r100) {
            this.summary = r100;
            return this;
        }

        public Builder title(String r100) {
            this.title = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }

        public Builder video_info(PreviewVideo r100) {
            this.video_info = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PreviewUrlContent extends ProtoAdapter<PreviewUrlContent> {
        public ProtoAdapter_PreviewUrlContent() {
            super(FieldEncoding.LENGTH_DELIMITED, PreviewUrlContent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PreviewUrlContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.sequence_id = 0;
            r101.url = "";
            r101.offset = 0;
            r101.count = 0;
            r101.title = "";
            r101.summary = "";
            r101.is_hidden = Boolean.FALSE;
            r101.has_preview = Boolean.TRUE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            switch(r103) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            r101.video_info = PreviewVideo.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.cover_image = ImageSet.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.has_preview = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.is_hidden = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.icon = ImageSet.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.summary = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            r101.offset = ProtoAdapter.INT32.decode(r100);
            goto L3
        L16:
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.sequence_id = ProtoAdapter.INT32.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PreviewUrlContent r100) {
            ProtoAdapter<Integer> r101 = ProtoAdapter.INT32;
            int r102 = r101.encodedSizeWithTag(1, r100.sequence_id);
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            int r104 = ((r102 + r103.encodedSizeWithTag(2, r100.url)) + r101.encodedSizeWithTag(3, r100.offset)) + r101.encodedSizeWithTag(4, r100.count);
            String r105 = r100.title;
            int r106 = 0;
            if (r105 == null) goto L5;
            int r107 = r103.encodedSizeWithTag(5, r105);
        L6:
            int r108 = r104 + r107;
            String r109 = r100.summary;
            if (r109 == null) goto L9;
            int r110 = r103.encodedSizeWithTag(6, r109);
        L10:
            int r111 = r108 + r110;
            ImageSet r112 = r100.icon;
            if (r112 == null) goto L13;
            int r113 = ImageSet.ADAPTER.encodedSizeWithTag(7, r112);
        L14:
            int r114 = r111 + r113;
            Boolean r115 = r100.is_hidden;
            if (r115 == null) goto L17;
            int r116 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r115);
        L18:
            int r117 = r114 + r116;
            Boolean r118 = r100.has_preview;
            if (r118 == null) goto L21;
            int r119 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r118);
        L22:
            int r120 = r117 + r119;
            ImageSet r121 = r100.cover_image;
            if (r121 == null) goto L25;
            int r122 = ImageSet.ADAPTER.encodedSizeWithTag(10, r121);
        L26:
            int r123 = r120 + r122;
            PreviewVideo r124 = r100.video_info;
            if (r124 == null) goto L30;
            r106 = PreviewVideo.ADAPTER.encodedSizeWithTag(11, r124);
        L30:
            return (r123 + r106) + r100.unknownFields().size();
        L25:
            r122 = 0;
            goto L26
        L21:
            r119 = 0;
            goto L22
        L17:
            r116 = 0;
            goto L18
        L13:
            r113 = 0;
            goto L14
        L9:
            r110 = 0;
            goto L10
        L5:
            r107 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PreviewUrlContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PreviewUrlContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PreviewUrlContent r101) throws IOException {
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            r102.encodeWithTag(r100, 1, r101.sequence_id);
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            r103.encodeWithTag(r100, 2, r101.url);
            r102.encodeWithTag(r100, 3, r101.offset);
            r102.encodeWithTag(r100, 4, r101.count);
            String r104 = r101.title;
            if (r104 == null) goto L5;
            r103.encodeWithTag(r100, 5, r104);
        L5:
            String r105 = r101.summary;
            if (r105 == null) goto L8;
            r103.encodeWithTag(r100, 6, r105);
        L8:
            ImageSet r106 = r101.icon;
            if (r106 == null) goto L11;
            ImageSet.ADAPTER.encodeWithTag(r100, 7, r106);
        L11:
            Boolean r107 = r101.is_hidden;
            if (r107 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r107);
        L14:
            Boolean r108 = r101.has_preview;
            if (r108 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r108);
        L17:
            ImageSet r109 = r101.cover_image;
            if (r109 == null) goto L20;
            ImageSet.ADAPTER.encodeWithTag(r100, 10, r109);
        L20:
            PreviewVideo r110 = r101.video_info;
            if (r110 == null) goto L23;
            PreviewVideo.ADAPTER.encodeWithTag(r100, 11, r110);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PreviewUrlContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PreviewUrlContent();
        DEFAULT_SEQUENCE_ID = 0;
        DEFAULT_OFFSET = 0;
        DEFAULT_COUNT = 0;
        DEFAULT_IS_HIDDEN = Boolean.FALSE;
        DEFAULT_HAS_PREVIEW = Boolean.TRUE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.sequence_id = this.sequence_id;
        r100.url = this.url;
        r100.offset = this.offset;
        r100.count = this.count;
        r100.title = this.title;
        r100.summary = this.summary;
        r100.icon = this.icon;
        r100.is_hidden = this.is_hidden;
        r100.has_preview = this.has_preview;
        r100.cover_image = this.cover_image;
        r100.video_info = this.video_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PreviewUrlContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public PreviewUrlContent(Integer r110, String r111, Integer r112, Integer r113, String r114, String r115, ImageSet r210, Boolean r211, Boolean r212, ImageSet r213, PreviewVideo r214) {
        this(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, ByteString.EMPTY);
    }

    public PreviewUrlContent(Integer r100, String r101, Integer r102, Integer r103, String r104, String r105, ImageSet r106, Boolean r107, Boolean r110, ImageSet r111, PreviewVideo r112, ByteString r113) {
        super(ADAPTER, r113);
        this.sequence_id = r100;
        this.url = r101;
        this.offset = r102;
        this.count = r103;
        this.title = r104;
        this.summary = r105;
        this.icon = r106;
        this.is_hidden = r107;
        this.has_preview = r110;
        this.cover_image = r111;
        this.video_info = r112;
    }
}
