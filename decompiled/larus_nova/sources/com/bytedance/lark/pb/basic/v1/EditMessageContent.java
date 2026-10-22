package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class EditMessageContent extends com.squareup.wire.Message<EditMessageContent, Builder> {
    public static final ProtoAdapter<EditMessageContent> ADAPTER = null;
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    public final EditMessageAttachmentUpdate attachment_update;
    public final LingoOption lingo_option;
    public final RichText rich_text;
    public final String title;
    public final Map<String, UrlPreviewHangPoint> url_preview_hang_point_map;

    public static final class Builder extends com.squareup.wire.Message.Builder<EditMessageContent, Builder> {
        public EditMessageAttachmentUpdate attachment_update;
        public LingoOption lingo_option;
        public RichText rich_text;
        public String title;
        public Map<String, UrlPreviewHangPoint> url_preview_hang_point_map;

        @Override // com.squareup.wire.Message.Builder
        public EditMessageContent build() {
            return new EditMessageContent(this.rich_text, this.title, this.lingo_option, this.url_preview_hang_point_map, this.attachment_update, super.buildUnknownFields());
        }

        public Builder() {
            this.url_preview_hang_point_map = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder attachment_update(EditMessageAttachmentUpdate r100) {
            this.attachment_update = r100;
            return this;
        }

        public Builder lingo_option(LingoOption r100) {
            this.lingo_option = r100;
            return this;
        }

        public Builder rich_text(RichText r100) {
            this.rich_text = r100;
            return this;
        }

        public Builder title(String r100) {
            this.title = r100;
            return this;
        }

        public Builder url_preview_hang_point_map(Map<String, UrlPreviewHangPoint> r100) {
            Internal.checkElementsNotNull(r100);
            this.url_preview_hang_point_map = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EditMessageContent extends ProtoAdapter<EditMessageContent> {
        private final ProtoAdapter<Map<String, UrlPreviewHangPoint>> url_preview_hang_point_map;

        public ProtoAdapter_EditMessageContent() {
            super(FieldEncoding.LENGTH_DELIMITED, EditMessageContent.class);
            this.url_preview_hang_point_map = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, UrlPreviewHangPoint.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EditMessageContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.title = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.rich_text = RichText.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.lingo_option = LingoOption.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.url_preview_hang_point_map.putAll(this.url_preview_hang_point_map.decode(r100));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.attachment_update = EditMessageAttachmentUpdate.ADAPTER.decode(r100);
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
        public int encodedSize2(EditMessageContent r100) {
            RichText r101 = r100.rich_text;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = RichText.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.title;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            LingoOption r107 = r100.lingo_option;
            if (r107 == null) goto L13;
            int r108 = LingoOption.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = (r106 + r108) + this.url_preview_hang_point_map.encodedSizeWithTag(4, r100.url_preview_hang_point_map);
            EditMessageAttachmentUpdate r110 = r100.attachment_update;
            if (r110 == null) goto L18;
            r102 = EditMessageAttachmentUpdate.ADAPTER.encodedSizeWithTag(5, r110);
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
        public /* bridge */ /* synthetic */ EditMessageContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EditMessageContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EditMessageContent r101) throws IOException {
            RichText r102 = r101.rich_text;
            if (r102 == null) goto L5;
            RichText.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.title;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            LingoOption r104 = r101.lingo_option;
            if (r104 == null) goto L11;
            LingoOption.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            this.url_preview_hang_point_map.encodeWithTag(r100, 4, r101.url_preview_hang_point_map);
            EditMessageAttachmentUpdate r105 = r101.attachment_update;
            if (r105 == null) goto L14;
            EditMessageAttachmentUpdate.ADAPTER.encodeWithTag(r100, 5, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EditMessageContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EditMessageContent();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.rich_text = this.rich_text;
        r100.title = this.title;
        r100.lingo_option = this.lingo_option;
        r100.url_preview_hang_point_map = Internal.copyOf("url_preview_hang_point_map", this.url_preview_hang_point_map);
        r100.attachment_update = this.attachment_update;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EditMessageContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public EditMessageContent(RichText r100, String r101, LingoOption r110, Map<String, UrlPreviewHangPoint> r111, EditMessageAttachmentUpdate r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public EditMessageContent(RichText r100, String r101, LingoOption r102, Map<String, UrlPreviewHangPoint> r103, EditMessageAttachmentUpdate r104, ByteString r105) {
        super(ADAPTER, r105);
        this.rich_text = r100;
        this.title = r101;
        this.lingo_option = r102;
        this.url_preview_hang_point_map = Internal.immutableCopyOf("url_preview_hang_point_map", r103);
        this.attachment_update = r104;
    }
}
