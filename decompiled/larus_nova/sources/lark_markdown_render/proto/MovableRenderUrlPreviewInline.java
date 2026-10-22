package lark_markdown_render.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class MovableRenderUrlPreviewInline extends Message<MovableRenderUrlPreviewInline, Builder> {
    public static final ProtoAdapter<MovableRenderUrlPreviewInline> ADAPTER = null;
    public static final String DEFAULT_CLICK_URL = "";
    public static final String DEFAULT_ICON_KEY = "";
    public static final String DEFAULT_ICON_TYPE = "";
    public static final String DEFAULT_ORIGIN_URL = "";
    public static final String DEFAULT_PREVIEW_ID = "";
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    public final String click_url;
    public final String icon_key;
    public final String icon_type;
    public final String origin_url;
    public final String preview_id;
    public final String title;

    public static final class Builder extends Message.Builder<MovableRenderUrlPreviewInline, Builder> {
        public String click_url;
        public String icon_key;
        public String icon_type;
        public String origin_url;
        public String preview_id;
        public String title;

        @Override // com.squareup.wire.Message.Builder
        public MovableRenderUrlPreviewInline build() {
            String r100 = this.preview_id;
            if (r100 == null) goto L13;
            if (this.origin_url == null) goto L13;
            if (this.click_url == null) goto L13;
            if (this.title == null) goto L13;
            return new MovableRenderUrlPreviewInline(this.preview_id, this.origin_url, this.click_url, this.title, this.icon_key, this.icon_type, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "preview_id", this.origin_url, "origin_url", this.click_url, "click_url", this.title, "title"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder click_url(String r100) {
            this.click_url = r100;
            return this;
        }

        public Builder icon_key(String r100) {
            this.icon_key = r100;
            return this;
        }

        public Builder icon_type(String r100) {
            this.icon_type = r100;
            return this;
        }

        public Builder origin_url(String r100) {
            this.origin_url = r100;
            return this;
        }

        public Builder preview_id(String r100) {
            this.preview_id = r100;
            return this;
        }

        public Builder title(String r100) {
            this.title = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MovableRenderUrlPreviewInline extends ProtoAdapter<MovableRenderUrlPreviewInline> {
        public ProtoAdapter_MovableRenderUrlPreviewInline() {
            super(FieldEncoding.LENGTH_DELIMITED, MovableRenderUrlPreviewInline.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public MovableRenderUrlPreviewInline decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
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
            r101.icon_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.icon_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.click_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.origin_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.preview_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(MovableRenderUrlPreviewInline r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = ((r101.encodedSizeWithTag(1, r100.preview_id) + r101.encodedSizeWithTag(2, r100.origin_url)) + r101.encodedSizeWithTag(3, r100.click_url)) + r101.encodedSizeWithTag(4, r100.title);
            String r103 = r100.icon_key;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(5, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.icon_type;
            if (r107 == null) goto L10;
            r104 = r101.encodedSizeWithTag(6, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MovableRenderUrlPreviewInline decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MovableRenderUrlPreviewInline r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MovableRenderUrlPreviewInline r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.preview_id);
            r102.encodeWithTag(r100, 2, r101.origin_url);
            r102.encodeWithTag(r100, 3, r101.click_url);
            r102.encodeWithTag(r100, 4, r101.title);
            String r103 = r101.icon_key;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 5, r103);
        L5:
            String r104 = r101.icon_type;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 6, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MovableRenderUrlPreviewInline r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MovableRenderUrlPreviewInline();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.preview_id = this.preview_id;
        r100.origin_url = this.origin_url;
        r100.click_url = this.click_url;
        r100.title = this.title;
        r100.icon_key = this.icon_key;
        r100.icon_type = this.icon_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MovableRenderUrlPreviewInline.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MovableRenderUrlPreviewInline(String r100, String r110, String r111, String r112, String r113, String r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public MovableRenderUrlPreviewInline(String r100, String r101, String r102, String r103, String r104, String r105, ByteString r106) {
        super(ADAPTER, r106);
        this.preview_id = r100;
        this.origin_url = r101;
        this.click_url = r102;
        this.title = r103;
        this.icon_key = r104;
        this.icon_type = r105;
    }
}
