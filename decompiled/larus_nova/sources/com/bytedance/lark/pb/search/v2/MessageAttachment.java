package com.bytedance.lark.pb.search.v2;

import com.bytedance.lark.pb.basic.v1.File;
import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.bytedance.lark.pb.basic.v1.MediaContent;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class MessageAttachment extends Message<MessageAttachment, Builder> {
    public static final ProtoAdapter<MessageAttachment> ADAPTER = null;
    public static final AttachmentRenderType DEFAULT_ATTACHMENTRENDERTYPE = null;
    public static final com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType DEFAULT_ATTACHMENTTYPE = null;
    public static final Boolean DEFAULT_HAS_RESOURCE_ACCESS_AUTH = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_SUMMARY = "";
    public static final String DEFAULT_SUMMARY_HIGHLIGHTED = "";
    public static final String DEFAULT_TITLE = "";
    public static final String DEFAULT_TITLE_HIGHLIGHTED = "";
    private static final long serialVersionUID = 0;
    public final AttachmentRenderType attachmentRenderType;
    public final com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType attachmentType;
    public final File file_meta;
    public final Boolean has_resource_access_auth;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253717id;
    public final ImageSet image;
    public final MediaContent media_content;
    public final String summary;
    public final String summary_highlighted;
    public final String title;
    public final String title_highlighted;
    public final URLMeta url_meta;

    public static final enum AttachmentRenderType extends Enum<AttachmentRenderType> implements WireEnum {
        private static final /* synthetic */ AttachmentRenderType[] $VALUES = null;
        public static final ProtoAdapter<AttachmentRenderType> ADAPTER = null;
        public static final AttachmentRenderType CARD = null;
        public static final AttachmentRenderType SLOT = null;
        public static final AttachmentRenderType UNKNOWN = null;
        private final int value;

        static {
            AttachmentRenderType r100 = new AttachmentRenderType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            AttachmentRenderType r101 = new AttachmentRenderType("SLOT", 1, 1);
            SLOT = r101;
            AttachmentRenderType r102 = new AttachmentRenderType("CARD", 2, 2);
            CARD = r102;
            $VALUES = new AttachmentRenderType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(AttachmentRenderType.class);
        }

        public static AttachmentRenderType[] values() {
            return (AttachmentRenderType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static AttachmentRenderType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return CARD;
        L12:
            return SLOT;
        L14:
            return UNKNOWN;
        }

        public static AttachmentRenderType valueOf(String r100) {
            return (AttachmentRenderType) a.a(AttachmentRenderType.class, r100);
        }

        private AttachmentRenderType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends Message.Builder<MessageAttachment, Builder> {
        public AttachmentRenderType attachmentRenderType;
        public com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType attachmentType;
        public File file_meta;
        public Boolean has_resource_access_auth;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253718id;
        public ImageSet image;
        public MediaContent media_content;
        public String summary;
        public String summary_highlighted;
        public String title;
        public String title_highlighted;
        public URLMeta url_meta;

        @Override // com.squareup.wire.Message.Builder
        public MessageAttachment build() {
            return new MessageAttachment(this.f253718id, this.attachmentType, this.attachmentRenderType, this.title, this.title_highlighted, this.summary, this.summary_highlighted, this.image, this.media_content, this.file_meta, this.url_meta, this.has_resource_access_auth, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder attachmentRenderType(AttachmentRenderType r100) {
            this.attachmentRenderType = r100;
            return this;
        }

        public Builder attachmentType(com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType r100) {
            this.attachmentType = r100;
            return this;
        }

        public Builder file_meta(File r100) {
            this.file_meta = r100;
            return this;
        }

        public Builder has_resource_access_auth(Boolean r100) {
            this.has_resource_access_auth = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253718id = r100;
            return this;
        }

        public Builder image(ImageSet r100) {
            this.image = r100;
            return this;
        }

        public Builder media_content(MediaContent r100) {
            this.media_content = r100;
            return this;
        }

        public Builder summary(String r100) {
            this.summary = r100;
            return this;
        }

        public Builder summary_highlighted(String r100) {
            this.summary_highlighted = r100;
            return this;
        }

        public Builder title(String r100) {
            this.title = r100;
            return this;
        }

        public Builder title_highlighted(String r100) {
            this.title_highlighted = r100;
            return this;
        }

        public Builder url_meta(URLMeta r100) {
            this.url_meta = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MessageAttachment extends ProtoAdapter<MessageAttachment> {
        public ProtoAdapter_MessageAttachment() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageAttachment.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MessageAttachment decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253718id = "";
            r101.attachmentType = com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType.UNKNOWN_ATTACHMENT_TYPE;
            r101.attachmentRenderType = AttachmentRenderType.UNKNOWN;
            r101.title = "";
            r101.title_highlighted = "";
            r101.summary = "";
            r101.summary_highlighted = "";
            r101.has_resource_access_auth = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L25;
            switch(r103) {
                case 1: goto L24;
                case 2: goto L27;
                case 3: goto L29;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L6;
                case 9: goto L6;
                case 10: goto L6;
                case 11: goto L11;
                case 12: goto L10;
                case 13: goto L9;
                case 14: goto L8;
                case 15: goto L7;
                default: goto L6;
            };
        L27:
            r101.attachmentType = com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L29:
            r101.attachmentRenderType = AttachmentRenderType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.has_resource_access_auth = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.url_meta = URLMeta.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.file_meta = File.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.media_content = MediaContent.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.image = ImageSet.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.summary_highlighted = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.summary = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.title_highlighted = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L24:
            r101.f253718id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L25:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MessageAttachment r100) {
            String r101 = r100.f253717id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType r104 = r100.attachmentType;
            if (r104 == null) goto L9;
            int r105 = com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            AttachmentRenderType r107 = r100.attachmentRenderType;
            if (r107 == null) goto L13;
            int r108 = AttachmentRenderType.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.title;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.title_highlighted;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.summary;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.summary_highlighted;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            ImageSet r122 = r100.image;
            if (r122 == null) goto L33;
            int r123 = ImageSet.ADAPTER.encodedSizeWithTag(11, r122);
        L34:
            int r124 = r121 + r123;
            MediaContent r125 = r100.media_content;
            if (r125 == null) goto L37;
            int r126 = MediaContent.ADAPTER.encodedSizeWithTag(12, r125);
        L38:
            int r127 = r124 + r126;
            File r128 = r100.file_meta;
            if (r128 == null) goto L41;
            int r129 = File.ADAPTER.encodedSizeWithTag(13, r128);
        L42:
            int r130 = r127 + r129;
            URLMeta r131 = r100.url_meta;
            if (r131 == null) goto L45;
            int r132 = URLMeta.ADAPTER.encodedSizeWithTag(14, r131);
        L46:
            int r133 = r130 + r132;
            Boolean r134 = r100.has_resource_access_auth;
            if (r134 == null) goto L50;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(15, r134);
        L50:
            return (r133 + r102) + r100.unknownFields().size();
        L45:
            r132 = 0;
            goto L46
        L41:
            r129 = 0;
            goto L42
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
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
        public /* bridge */ /* synthetic */ MessageAttachment decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MessageAttachment r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MessageAttachment r101) throws IOException {
            String r102 = r101.f253717id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType r103 = r101.attachmentType;
            if (r103 == null) goto L8;
            com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            AttachmentRenderType r104 = r101.attachmentRenderType;
            if (r104 == null) goto L11;
            AttachmentRenderType.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.title;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.title_highlighted;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.summary;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.summary_highlighted;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            ImageSet r109 = r101.image;
            if (r109 == null) goto L26;
            ImageSet.ADAPTER.encodeWithTag(r100, 11, r109);
        L26:
            MediaContent r110 = r101.media_content;
            if (r110 == null) goto L29;
            MediaContent.ADAPTER.encodeWithTag(r100, 12, r110);
        L29:
            File r111 = r101.file_meta;
            if (r111 == null) goto L32;
            File.ADAPTER.encodeWithTag(r100, 13, r111);
        L32:
            URLMeta r112 = r101.url_meta;
            if (r112 == null) goto L35;
            URLMeta.ADAPTER.encodeWithTag(r100, 14, r112);
        L35:
            Boolean r113 = r101.has_resource_access_auth;
            if (r113 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r100, 15, r113);
        L38:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageAttachment r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageAttachment();
        DEFAULT_ATTACHMENTTYPE = com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType.UNKNOWN_ATTACHMENT_TYPE;
        DEFAULT_ATTACHMENTRENDERTYPE = AttachmentRenderType.UNKNOWN;
        DEFAULT_HAS_RESOURCE_ACCESS_AUTH = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253718id = this.f253717id;
        r100.attachmentType = this.attachmentType;
        r100.attachmentRenderType = this.attachmentRenderType;
        r100.title = this.title;
        r100.title_highlighted = this.title_highlighted;
        r100.summary = this.summary;
        r100.summary_highlighted = this.summary_highlighted;
        r100.image = this.image;
        r100.media_content = this.media_content;
        r100.file_meta = this.file_meta;
        r100.url_meta = this.url_meta;
        r100.has_resource_access_auth = this.has_resource_access_auth;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MessageAttachment.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MessageAttachment(String r110, com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType r111, AttachmentRenderType r112, String r113, String r114, String r210, String r211, ImageSet r212, MediaContent r213, File r214, URLMeta r215, Boolean r216) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, ByteString.EMPTY);
    }

    public MessageAttachment(String r100, com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType r101, AttachmentRenderType r102, String r103, String r104, String r105, String r106, ImageSet r107, MediaContent r110, File r111, URLMeta r112, Boolean r113, ByteString r114) {
        super(ADAPTER, r114);
        this.f253717id = r100;
        this.attachmentType = r101;
        this.attachmentRenderType = r102;
        this.title = r103;
        this.title_highlighted = r104;
        this.summary = r105;
        this.summary_highlighted = r106;
        this.image = r107;
        this.media_content = r110;
        this.file_meta = r111;
        this.url_meta = r112;
        this.has_resource_access_auth = r113;
    }
}
