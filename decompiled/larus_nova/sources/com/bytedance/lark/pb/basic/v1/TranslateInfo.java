package com.bytedance.lark.pb.basic.v1;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TranslateInfo extends com.squareup.wire.Message<TranslateInfo, Builder> {
    public static final ProtoAdapter<TranslateInfo> ADAPTER = null;
    public static final Boolean DEFAULT_IS_AUTO_TRANSLATE = null;
    public static final String DEFAULT_LANGUAGE = "";
    public static final Integer DEFAULT_MESSAGE_CONTENT_VERSION = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final Message.Type DEFAULT_MESSAGE_TYPE = null;
    private static final long serialVersionUID = 0;
    public final Content content;
    public final ImageTranslationInfo image_translation_info;
    public final Boolean is_auto_translate;
    public final String language;
    public final Integer message_content_version;
    public final String message_id;
    public final MessageSource message_source;
    public final Message.Type message_type;

    public static final class Builder extends com.squareup.wire.Message.Builder<TranslateInfo, Builder> {
        public Content content;
        public ImageTranslationInfo image_translation_info;
        public Boolean is_auto_translate;
        public String language;
        public Integer message_content_version;
        public String message_id;
        public MessageSource message_source;
        public Message.Type message_type;

        @Override // com.squareup.wire.Message.Builder
        public TranslateInfo build() {
            String r100 = this.message_id;
            if (r100 == null) goto L13;
            if (this.language == null) goto L13;
            if (this.content == null) goto L13;
            if (this.message_type == null) goto L13;
            return new TranslateInfo(this.message_id, this.language, this.content, this.message_type, this.is_auto_translate, this.message_source, this.image_translation_info, this.message_content_version, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, MusicAppletPage.KEY_MESSAGE_ID, this.language, "language", this.content, "content", this.message_type, "message_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder content(Content r100) {
            this.content = r100;
            return this;
        }

        public Builder image_translation_info(ImageTranslationInfo r100) {
            this.image_translation_info = r100;
            return this;
        }

        public Builder is_auto_translate(Boolean r100) {
            this.is_auto_translate = r100;
            return this;
        }

        public Builder language(String r100) {
            this.language = r100;
            return this;
        }

        public Builder message_content_version(Integer r100) {
            this.message_content_version = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder message_source(MessageSource r100) {
            this.message_source = r100;
            return this;
        }

        public Builder message_type(Message.Type r100) {
            this.message_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TranslateInfo extends ProtoAdapter<TranslateInfo> {
        public ProtoAdapter_TranslateInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, TranslateInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TranslateInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_id = "";
            r101.language = "";
            r101.message_type = Message.Type.UNKNOWN;
            r101.is_auto_translate = Boolean.FALSE;
            r101.message_content_version = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            switch(r103) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L20;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L20:
            r101.message_type = Message.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.message_content_version = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            r101.image_translation_info = ImageTranslationInfo.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.message_source = MessageSource.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.is_auto_translate = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            r101.content = Content.ADAPTER.decode(r100);
            goto L3
        L16:
            r101.language = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.message_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(TranslateInfo r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = ((r101.encodedSizeWithTag(1, r100.message_id) + r101.encodedSizeWithTag(2, r100.language)) + Content.ADAPTER.encodedSizeWithTag(3, r100.content)) + Message.Type.ADAPTER.encodedSizeWithTag(4, r100.message_type);
            Boolean r103 = r100.is_auto_translate;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r103);
        L6:
            int r106 = r102 + r105;
            MessageSource r107 = r100.message_source;
            if (r107 == null) goto L9;
            int r108 = MessageSource.ADAPTER.encodedSizeWithTag(6, r107);
        L10:
            int r109 = r106 + r108;
            ImageTranslationInfo r110 = r100.image_translation_info;
            if (r110 == null) goto L13;
            int r111 = ImageTranslationInfo.ADAPTER.encodedSizeWithTag(7, r110);
        L14:
            int r112 = r109 + r111;
            Integer r113 = r100.message_content_version;
            if (r113 == null) goto L18;
            r104 = ProtoAdapter.INT32.encodedSizeWithTag(8, r113);
        L18:
            return (r112 + r104) + r100.unknownFields().size();
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TranslateInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TranslateInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TranslateInfo r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.message_id);
            r102.encodeWithTag(r100, 2, r101.language);
            Content.ADAPTER.encodeWithTag(r100, 3, r101.content);
            Message.Type.ADAPTER.encodeWithTag(r100, 4, r101.message_type);
            Boolean r103 = r101.is_auto_translate;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r103);
        L5:
            MessageSource r104 = r101.message_source;
            if (r104 == null) goto L8;
            MessageSource.ADAPTER.encodeWithTag(r100, 6, r104);
        L8:
            ImageTranslationInfo r105 = r101.image_translation_info;
            if (r105 == null) goto L11;
            ImageTranslationInfo.ADAPTER.encodeWithTag(r100, 7, r105);
        L11:
            Integer r106 = r101.message_content_version;
            if (r106 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 8, r106);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TranslateInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TranslateInfo();
        DEFAULT_MESSAGE_TYPE = Message.Type.UNKNOWN;
        DEFAULT_IS_AUTO_TRANSLATE = Boolean.FALSE;
        DEFAULT_MESSAGE_CONTENT_VERSION = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_id = this.message_id;
        r100.language = this.language;
        r100.content = this.content;
        r100.message_type = this.message_type;
        r100.is_auto_translate = this.is_auto_translate;
        r100.message_source = this.message_source;
        r100.image_translation_info = this.image_translation_info;
        r100.message_content_version = this.message_content_version;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TranslateInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TranslateInfo(String r110, String r111, Content r112, Message.Type r113, Boolean r114, MessageSource r115, ImageTranslationInfo r116, Integer r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public TranslateInfo(String r100, String r101, Content r102, Message.Type r103, Boolean r104, MessageSource r105, ImageTranslationInfo r106, Integer r107, ByteString r110) {
        super(ADAPTER, r110);
        this.message_id = r100;
        this.language = r101;
        this.content = r102;
        this.message_type = r103;
        this.is_auto_translate = r104;
        this.message_source = r105;
        this.image_translation_info = r106;
        this.message_content_version = r107;
    }
}
