package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class QuasiContent extends com.squareup.wire.Message<QuasiContent, Builder> {
    public static final ProtoAdapter<QuasiContent> ADAPTER = null;
    public static final ByteString DEFAULT_AUDIO = null;
    public static final String DEFAULT_COMPRESS_PATH = "";
    public static final Integer DEFAULT_DURATION = null;
    public static final Long DEFAULT_FILE_HANDLE = null;
    public static final File.Source DEFAULT_FILE_SOURCE = null;
    public static final String DEFAULT_FILE_UPLOAD_ID = "";
    public static final String DEFAULT_FILE_URI = "";
    public static final String DEFAULT_FIRST_SCREEN_IMAGE_UPLOAD_ID = "";
    public static final Integer DEFAULT_HEIGHT = null;
    public static final ByteString DEFAULT_IMAGE = null;
    public static final String DEFAULT_IMAGE_PATH = "";
    public static final String DEFAULT_IMAGE_UPLOAD_ID = "";
    public static final Boolean DEFAULT_IS_GROUP_ANNOUNCEMENT = null;
    public static final Boolean DEFAULT_IS_ORIGIN_SOURCE = null;
    public static final Boolean DEFAULT_IS_TRY_USE_LAN_TRANS = null;
    public static final String DEFAULT_KEY = "";
    public static final TransStatus DEFAULT_LAN_TRANS_STATUS = null;
    public static final MediaContent.Source DEFAULT_MEDIA_SOURCE = null;
    public static final String DEFAULT_MEDIA_UPLOAD_ID = "";
    public static final String DEFAULT_MIME = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PATH = "";
    public static final String DEFAULT_PREPROCESS_KEY = "";
    public static final String DEFAULT_SHARE_CHATTER_ID = "";
    public static final String DEFAULT_SHARE_CHAT_ID = "";
    public static final Long DEFAULT_SIZE_BYTES = null;
    public static final String DEFAULT_STICKER_ID = "";
    public static final String DEFAULT_STICKER_SET_ID = "";
    public static final String DEFAULT_TEXT = "";
    public static final String DEFAULT_TITLE = "";
    public static final Integer DEFAULT_WIDTH = null;
    private static final long serialVersionUID = 0;
    public final List<File> attachments;
    public final ByteString audio;
    public final CardContent card_content;
    public final String compress_path;
    public final DoubaoResource doubao_resource;
    public final Integer duration;
    public final List<File> file_attachments;
    public final Long file_handle;
    public final File.Source file_source;
    public final String file_upload_id;
    public final String file_uri;
    public final String first_screen_image_upload_id;
    public final Integer height;
    public final ByteString image;
    public final String image_path;
    public final String image_upload_id;
    public final Boolean is_group_announcement;
    public final Boolean is_origin_source;
    public final Boolean is_try_use_lan_trans;
    public final String key;
    public final TransStatus lan_trans_status;
    public final LingoOption lingo_option;
    public final LocationContent location_content;
    public final MediaContent.Source media_source;
    public final String media_upload_id;
    public final String mime;
    public final String name;
    public final String path;
    public final String preprocess_key;
    public final RichText rich_text;
    public final String share_chat_id;
    public final String share_chatter_id;
    public final Long size_bytes;
    public final String sticker_id;
    public final String sticker_set_id;
    public final String text;
    public final String title;
    public final Map<String, UrlPreviewHangPoint> url_preview_hang_point_map;
    public final Integer width;

    public static final class Builder extends com.squareup.wire.Message.Builder<QuasiContent, Builder> {
        public List<File> attachments;
        public ByteString audio;
        public CardContent card_content;
        public String compress_path;
        public DoubaoResource doubao_resource;
        public Integer duration;
        public List<File> file_attachments;
        public Long file_handle;
        public File.Source file_source;
        public String file_upload_id;
        public String file_uri;
        public String first_screen_image_upload_id;
        public Integer height;
        public ByteString image;
        public String image_path;
        public String image_upload_id;
        public Boolean is_group_announcement;
        public Boolean is_origin_source;
        public Boolean is_try_use_lan_trans;
        public String key;
        public TransStatus lan_trans_status;
        public LingoOption lingo_option;
        public LocationContent location_content;
        public MediaContent.Source media_source;
        public String media_upload_id;
        public String mime;
        public String name;
        public String path;
        public String preprocess_key;
        public RichText rich_text;
        public String share_chat_id;
        public String share_chatter_id;
        public Long size_bytes;
        public String sticker_id;
        public String sticker_set_id;
        public String text;
        public String title;
        public Map<String, UrlPreviewHangPoint> url_preview_hang_point_map;
        public Integer width;

        @Override // com.squareup.wire.Message.Builder
        public QuasiContent build() {
            return new QuasiContent(this.title, this.text, this.image, this.is_origin_source, this.path, this.audio, this.duration, this.image_path, this.image_upload_id, this.attachments, this.file_attachments, this.url_preview_hang_point_map, this.share_chat_id, this.key, this.width, this.height, this.rich_text, this.card_content, this.location_content, this.name, this.mime, this.size_bytes, this.file_source, this.lan_trans_status, this.is_try_use_lan_trans, this.file_handle, this.file_uri, this.preprocess_key, this.media_source, this.compress_path, this.first_screen_image_upload_id, this.media_upload_id, this.file_upload_id, this.is_group_announcement, this.sticker_set_id, this.sticker_id, this.share_chatter_id, this.doubao_resource, this.lingo_option, super.buildUnknownFields());
        }

        public Builder() {
            this.attachments = Internal.newMutableList();
            this.file_attachments = Internal.newMutableList();
            this.url_preview_hang_point_map = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder attachments(List<File> r100) {
            Internal.checkElementsNotNull(r100);
            this.attachments = r100;
            return this;
        }

        public Builder audio(ByteString r100) {
            this.audio = r100;
            return this;
        }

        public Builder card_content(CardContent r100) {
            this.card_content = r100;
            return this;
        }

        public Builder compress_path(String r100) {
            this.compress_path = r100;
            return this;
        }

        public Builder doubao_resource(DoubaoResource r100) {
            this.doubao_resource = r100;
            return this;
        }

        public Builder duration(Integer r100) {
            this.duration = r100;
            return this;
        }

        public Builder file_attachments(List<File> r100) {
            Internal.checkElementsNotNull(r100);
            this.file_attachments = r100;
            return this;
        }

        public Builder file_handle(Long r100) {
            this.file_handle = r100;
            return this;
        }

        public Builder file_source(File.Source r100) {
            this.file_source = r100;
            return this;
        }

        public Builder file_upload_id(String r100) {
            this.file_upload_id = r100;
            return this;
        }

        public Builder file_uri(String r100) {
            this.file_uri = r100;
            return this;
        }

        public Builder first_screen_image_upload_id(String r100) {
            this.first_screen_image_upload_id = r100;
            return this;
        }

        public Builder height(Integer r100) {
            this.height = r100;
            return this;
        }

        public Builder image(ByteString r100) {
            this.image = r100;
            return this;
        }

        public Builder image_path(String r100) {
            this.image_path = r100;
            return this;
        }

        public Builder image_upload_id(String r100) {
            this.image_upload_id = r100;
            return this;
        }

        public Builder is_group_announcement(Boolean r100) {
            this.is_group_announcement = r100;
            return this;
        }

        public Builder is_origin_source(Boolean r100) {
            this.is_origin_source = r100;
            return this;
        }

        public Builder is_try_use_lan_trans(Boolean r100) {
            this.is_try_use_lan_trans = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder lan_trans_status(TransStatus r100) {
            this.lan_trans_status = r100;
            return this;
        }

        public Builder lingo_option(LingoOption r100) {
            this.lingo_option = r100;
            return this;
        }

        public Builder location_content(LocationContent r100) {
            this.location_content = r100;
            return this;
        }

        public Builder media_source(MediaContent.Source r100) {
            this.media_source = r100;
            return this;
        }

        public Builder media_upload_id(String r100) {
            this.media_upload_id = r100;
            return this;
        }

        public Builder mime(String r100) {
            this.mime = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder path(String r100) {
            this.path = r100;
            return this;
        }

        public Builder preprocess_key(String r100) {
            this.preprocess_key = r100;
            return this;
        }

        public Builder rich_text(RichText r100) {
            this.rich_text = r100;
            return this;
        }

        public Builder share_chat_id(String r100) {
            this.share_chat_id = r100;
            return this;
        }

        public Builder share_chatter_id(String r100) {
            this.share_chatter_id = r100;
            return this;
        }

        public Builder size_bytes(Long r100) {
            this.size_bytes = r100;
            return this;
        }

        public Builder sticker_id(String r100) {
            this.sticker_id = r100;
            return this;
        }

        public Builder sticker_set_id(String r100) {
            this.sticker_set_id = r100;
            return this;
        }

        public Builder text(String r100) {
            this.text = r100;
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

        public Builder width(Integer r100) {
            this.width = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_QuasiContent extends ProtoAdapter<QuasiContent> {
        private final ProtoAdapter<Map<String, UrlPreviewHangPoint>> url_preview_hang_point_map;

        public ProtoAdapter_QuasiContent() {
            super(FieldEncoding.LENGTH_DELIMITED, QuasiContent.class);
            this.url_preview_hang_point_map = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, UrlPreviewHangPoint.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public QuasiContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.title = "";
            r101.text = "";
            ByteString r102 = ByteString.EMPTY;
            r101.image = r102;
            Boolean r103 = Boolean.FALSE;
            r101.is_origin_source = r103;
            r101.path = "";
            r101.audio = r102;
            r101.duration = 0;
            r101.image_path = "";
            r101.image_upload_id = "";
            r101.share_chat_id = "";
            r101.key = "";
            r101.width = 0;
            r101.height = 0;
            r101.name = "";
            r101.mime = "";
            r101.size_bytes = 0L;
            r101.file_source = File.Source.LARK_SERVER;
            r101.lan_trans_status = TransStatus.PENDING;
            r101.is_try_use_lan_trans = r103;
            r101.file_handle = 0L;
            r101.file_uri = "";
            r101.preprocess_key = "";
            r101.media_source = MediaContent.Source.LARK;
            r101.compress_path = "";
            r101.first_screen_image_upload_id = "";
            r101.media_upload_id = "";
            r101.file_upload_id = "";
            r101.is_group_announcement = r103;
            r101.sticker_set_id = "";
            r101.sticker_id = "";
            r101.share_chatter_id = "";
            long r104 = r100.beginMessage();
        L3:
            int r105 = r100.nextTag();
            if (r105 == (-1)) goto L84;
            if (r105 != 20) goto L8;
            r101.attachments.add(File.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r105 != 21) goto L10;
            r101.file_attachments.add(File.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r105 != 29) goto L12;
            r101.url_preview_hang_point_map.putAll(this.url_preview_hang_point_map.decode(r100));
            goto L3
        L12:
            if (r105 != 30) goto L14;
            r101.share_chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r105 != 33) goto L16;
            r101.lingo_option = LingoOption.ADAPTER.decode(r100);
            goto L3
        L16:
            if (r105 != 50) goto L18;
            r101.rich_text = RichText.ADAPTER.decode(r100);
            goto L3
        L18:
            if (r105 != 60) goto L20;
            r101.card_content = CardContent.ADAPTER.decode(r100);
            goto L3
        L20:
            if (r105 != 70) goto L22;
            r101.location_content = LocationContent.ADAPTER.decode(r100);
            goto L3
        L22:
            if (r105 != 150) goto L24;
            r101.is_group_announcement = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L24:
            if (r105 != 200) goto L26;
            r101.sticker_set_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L26:
            if (r105 != 201) goto L28;
            r101.sticker_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L28:
            if (r105 != 220) goto L30;
            r101.share_chatter_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L30:
            if (r105 != 221) goto L31;
            r101.doubao_resource = DoubaoResource.ADAPTER.decode(r100);
            goto L3
        L31:
            switch(r105) {
                case 1: goto L70;
                case 2: goto L69;
                case 3: goto L68;
                case 4: goto L67;
                case 5: goto L66;
                case 6: goto L65;
                case 7: goto L64;
                case 8: goto L63;
                case 9: goto L62;
                default: goto L32;
            };
        L62:
            r101.is_origin_source = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L63:
            r101.image_upload_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L64:
            r101.image_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L65:
            r101.duration = ProtoAdapter.INT32.decode(r100);
            goto L3
        L66:
            r101.audio = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L67:
            r101.path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L68:
            r101.image = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L69:
            r101.text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L70:
            r101.title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L32:
            switch(r105) {
                case 40: goto L61;
                case 41: goto L60;
                case 42: goto L59;
                default: goto L33;
            };
        L59:
            r101.height = ProtoAdapter.INT32.decode(r100);
            goto L3
        L60:
            r101.width = ProtoAdapter.INT32.decode(r100);
            goto L3
        L61:
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L33:
            switch(r105) {
                case 100: goto L58;
                case 101: goto L57;
                case 102: goto L56;
                case 103: goto L88;
                case 104: goto L90;
                case 105: goto L47;
                case 106: goto L46;
                case 107: goto L45;
                case 108: goto L44;
                default: goto L34;
            };
        L88:
            r101.file_source = File.Source.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L54
        L54:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L90:
            r101.lan_trans_status = TransStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L50
        L50:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L44:
            r101.preprocess_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L45:
            r101.file_uri = ProtoAdapter.STRING.decode(r100);
            goto L3
        L46:
            r101.file_handle = ProtoAdapter.INT64.decode(r100);
            goto L3
        L47:
            r101.is_try_use_lan_trans = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L56:
            r101.size_bytes = ProtoAdapter.INT64.decode(r100);
            goto L3
        L57:
            r101.mime = ProtoAdapter.STRING.decode(r100);
            goto L3
        L58:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L34:
            switch(r105) {
                case 120: goto L86;
                case 121: goto L39;
                case 122: goto L38;
                case 123: goto L37;
                case 124: goto L36;
                default: goto L35;
            };
        L86:
            r101.media_source = MediaContent.Source.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L42
        L42:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L36:
            r101.file_upload_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L37:
            r101.media_upload_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L38:
            r101.first_screen_image_upload_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L39:
            r101.compress_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L35:
            FieldEncoding r106 = r100.peekFieldEncoding();
            r101.addUnknownField(r105, r106, r106.rawProtoAdapter().decode(r100));
            goto L3
        L84:
            r100.endMessage(r104);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(QuasiContent r100) {
            String r101 = r100.title;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.text;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ByteString r107 = r100.image;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BYTES.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.is_origin_source;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.path;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(4, r113);
        L22:
            int r115 = r112 + r114;
            ByteString r116 = r100.audio;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.BYTES.encodedSizeWithTag(5, r116);
        L26:
            int r118 = r115 + r117;
            Integer r119 = r100.duration;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.INT32.encodedSizeWithTag(6, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.image_path;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(7, r122);
        L34:
            int r124 = r121 + r123;
            String r125 = r100.image_upload_id;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.STRING.encodedSizeWithTag(8, r125);
        L38:
            int r127 = r124 + r126;
            ProtoAdapter<File> r128 = File.ADAPTER;
            int r129 = ((r127 + r128.asRepeated().encodedSizeWithTag(20, r100.attachments)) + r128.asRepeated().encodedSizeWithTag(21, r100.file_attachments)) + this.url_preview_hang_point_map.encodedSizeWithTag(29, r100.url_preview_hang_point_map);
            String r130 = r100.share_chat_id;
            if (r130 == null) goto L41;
            int r131 = ProtoAdapter.STRING.encodedSizeWithTag(30, r130);
        L42:
            int r132 = r129 + r131;
            String r133 = r100.key;
            if (r133 == null) goto L45;
            int r134 = ProtoAdapter.STRING.encodedSizeWithTag(40, r133);
        L46:
            int r135 = r132 + r134;
            Integer r136 = r100.width;
            if (r136 == null) goto L49;
            int r137 = ProtoAdapter.INT32.encodedSizeWithTag(41, r136);
        L50:
            int r138 = r135 + r137;
            Integer r139 = r100.height;
            if (r139 == null) goto L53;
            int r140 = ProtoAdapter.INT32.encodedSizeWithTag(42, r139);
        L54:
            int r141 = r138 + r140;
            RichText r142 = r100.rich_text;
            if (r142 == null) goto L57;
            int r143 = RichText.ADAPTER.encodedSizeWithTag(50, r142);
        L58:
            int r144 = r141 + r143;
            CardContent r145 = r100.card_content;
            if (r145 == null) goto L61;
            int r146 = CardContent.ADAPTER.encodedSizeWithTag(60, r145);
        L62:
            int r147 = r144 + r146;
            LocationContent r148 = r100.location_content;
            if (r148 == null) goto L65;
            int r149 = LocationContent.ADAPTER.encodedSizeWithTag(70, r148);
        L66:
            int r150 = r147 + r149;
            String r151 = r100.name;
            if (r151 == null) goto L69;
            int r152 = ProtoAdapter.STRING.encodedSizeWithTag(100, r151);
        L70:
            int r153 = r150 + r152;
            String r154 = r100.mime;
            if (r154 == null) goto L73;
            int r155 = ProtoAdapter.STRING.encodedSizeWithTag(101, r154);
        L74:
            int r156 = r153 + r155;
            Long r157 = r100.size_bytes;
            if (r157 == null) goto L77;
            int r158 = ProtoAdapter.INT64.encodedSizeWithTag(102, r157);
        L78:
            int r159 = r156 + r158;
            File.Source r160 = r100.file_source;
            if (r160 == null) goto L81;
            int r161 = File.Source.ADAPTER.encodedSizeWithTag(103, r160);
        L82:
            int r162 = r159 + r161;
            TransStatus r163 = r100.lan_trans_status;
            if (r163 == null) goto L85;
            int r164 = TransStatus.ADAPTER.encodedSizeWithTag(104, r163);
        L86:
            int r165 = r162 + r164;
            Boolean r166 = r100.is_try_use_lan_trans;
            if (r166 == null) goto L89;
            int r167 = ProtoAdapter.BOOL.encodedSizeWithTag(105, r166);
        L90:
            int r168 = r165 + r167;
            Long r169 = r100.file_handle;
            if (r169 == null) goto L93;
            int r170 = ProtoAdapter.INT64.encodedSizeWithTag(106, r169);
        L94:
            int r171 = r168 + r170;
            String r172 = r100.file_uri;
            if (r172 == null) goto L97;
            int r173 = ProtoAdapter.STRING.encodedSizeWithTag(107, r172);
        L98:
            int r174 = r171 + r173;
            String r175 = r100.preprocess_key;
            if (r175 == null) goto L101;
            int r176 = ProtoAdapter.STRING.encodedSizeWithTag(108, r175);
        L102:
            int r177 = r174 + r176;
            MediaContent.Source r178 = r100.media_source;
            if (r178 == null) goto L105;
            int r179 = MediaContent.Source.ADAPTER.encodedSizeWithTag(120, r178);
        L106:
            int r180 = r177 + r179;
            String r181 = r100.compress_path;
            if (r181 == null) goto L109;
            int r182 = ProtoAdapter.STRING.encodedSizeWithTag(121, r181);
        L110:
            int r183 = r180 + r182;
            String r184 = r100.first_screen_image_upload_id;
            if (r184 == null) goto L113;
            int r185 = ProtoAdapter.STRING.encodedSizeWithTag(122, r184);
        L114:
            int r186 = r183 + r185;
            String r187 = r100.media_upload_id;
            if (r187 == null) goto L117;
            int r188 = ProtoAdapter.STRING.encodedSizeWithTag(123, r187);
        L118:
            int r189 = r186 + r188;
            String r190 = r100.file_upload_id;
            if (r190 == null) goto L121;
            int r191 = ProtoAdapter.STRING.encodedSizeWithTag(124, r190);
        L122:
            int r192 = r189 + r191;
            Boolean r193 = r100.is_group_announcement;
            if (r193 == null) goto L125;
            int r194 = ProtoAdapter.BOOL.encodedSizeWithTag(150, r193);
        L126:
            int r195 = r192 + r194;
            String r196 = r100.sticker_set_id;
            if (r196 == null) goto L129;
            int r197 = ProtoAdapter.STRING.encodedSizeWithTag(200, r196);
        L130:
            int r198 = r195 + r197;
            String r199 = r100.sticker_id;
            if (r199 == null) goto L133;
            int r200 = ProtoAdapter.STRING.encodedSizeWithTag(201, r199);
        L134:
            int r201 = r198 + r200;
            String r202 = r100.share_chatter_id;
            if (r202 == null) goto L137;
            int r203 = ProtoAdapter.STRING.encodedSizeWithTag(220, r202);
        L138:
            int r204 = r201 + r203;
            DoubaoResource r205 = r100.doubao_resource;
            if (r205 == null) goto L141;
            int r206 = DoubaoResource.ADAPTER.encodedSizeWithTag(221, r205);
        L142:
            int r207 = r204 + r206;
            LingoOption r208 = r100.lingo_option;
            if (r208 == null) goto L146;
            r102 = LingoOption.ADAPTER.encodedSizeWithTag(33, r208);
        L146:
            return (r207 + r102) + r100.unknownFields().size();
        L141:
            r206 = 0;
            goto L142
        L137:
            r203 = 0;
            goto L138
        L133:
            r200 = 0;
            goto L134
        L129:
            r197 = 0;
            goto L130
        L125:
            r194 = 0;
            goto L126
        L121:
            r191 = 0;
            goto L122
        L117:
            r188 = 0;
            goto L118
        L113:
            r185 = 0;
            goto L114
        L109:
            r182 = 0;
            goto L110
        L105:
            r179 = 0;
            goto L106
        L101:
            r176 = 0;
            goto L102
        L97:
            r173 = 0;
            goto L98
        L93:
            r170 = 0;
            goto L94
        L89:
            r167 = 0;
            goto L90
        L85:
            r164 = 0;
            goto L86
        L81:
            r161 = 0;
            goto L82
        L77:
            r158 = 0;
            goto L78
        L73:
            r155 = 0;
            goto L74
        L69:
            r152 = 0;
            goto L70
        L65:
            r149 = 0;
            goto L66
        L61:
            r146 = 0;
            goto L62
        L57:
            r143 = 0;
            goto L58
        L53:
            r140 = 0;
            goto L54
        L49:
            r137 = 0;
            goto L50
        L45:
            r134 = 0;
            goto L46
        L41:
            r131 = 0;
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
        public /* bridge */ /* synthetic */ QuasiContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(QuasiContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, QuasiContent r101) throws IOException {
            String r102 = r101.title;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.text;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            ByteString r104 = r101.image;
            if (r104 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.is_origin_source;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r105);
        L14:
            String r106 = r101.path;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r106);
        L17:
            ByteString r107 = r101.audio;
            if (r107 == null) goto L20;
            ProtoAdapter.BYTES.encodeWithTag(r100, 5, r107);
        L20:
            Integer r108 = r101.duration;
            if (r108 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r108);
        L23:
            String r109 = r101.image_path;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r109);
        L26:
            String r110 = r101.image_upload_id;
            if (r110 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r110);
        L29:
            ProtoAdapter<File> r111 = File.ADAPTER;
            r111.asRepeated().encodeWithTag(r100, 20, r101.attachments);
            r111.asRepeated().encodeWithTag(r100, 21, r101.file_attachments);
            this.url_preview_hang_point_map.encodeWithTag(r100, 29, r101.url_preview_hang_point_map);
            String r112 = r101.share_chat_id;
            if (r112 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 30, r112);
        L32:
            String r113 = r101.key;
            if (r113 == null) goto L35;
            ProtoAdapter.STRING.encodeWithTag(r100, 40, r113);
        L35:
            Integer r114 = r101.width;
            if (r114 == null) goto L38;
            ProtoAdapter.INT32.encodeWithTag(r100, 41, r114);
        L38:
            Integer r115 = r101.height;
            if (r115 == null) goto L41;
            ProtoAdapter.INT32.encodeWithTag(r100, 42, r115);
        L41:
            RichText r116 = r101.rich_text;
            if (r116 == null) goto L44;
            RichText.ADAPTER.encodeWithTag(r100, 50, r116);
        L44:
            CardContent r117 = r101.card_content;
            if (r117 == null) goto L47;
            CardContent.ADAPTER.encodeWithTag(r100, 60, r117);
        L47:
            LocationContent r118 = r101.location_content;
            if (r118 == null) goto L50;
            LocationContent.ADAPTER.encodeWithTag(r100, 70, r118);
        L50:
            String r119 = r101.name;
            if (r119 == null) goto L53;
            ProtoAdapter.STRING.encodeWithTag(r100, 100, r119);
        L53:
            String r120 = r101.mime;
            if (r120 == null) goto L56;
            ProtoAdapter.STRING.encodeWithTag(r100, 101, r120);
        L56:
            Long r121 = r101.size_bytes;
            if (r121 == null) goto L59;
            ProtoAdapter.INT64.encodeWithTag(r100, 102, r121);
        L59:
            File.Source r122 = r101.file_source;
            if (r122 == null) goto L62;
            File.Source.ADAPTER.encodeWithTag(r100, 103, r122);
        L62:
            TransStatus r123 = r101.lan_trans_status;
            if (r123 == null) goto L65;
            TransStatus.ADAPTER.encodeWithTag(r100, 104, r123);
        L65:
            Boolean r124 = r101.is_try_use_lan_trans;
            if (r124 == null) goto L68;
            ProtoAdapter.BOOL.encodeWithTag(r100, 105, r124);
        L68:
            Long r125 = r101.file_handle;
            if (r125 == null) goto L71;
            ProtoAdapter.INT64.encodeWithTag(r100, 106, r125);
        L71:
            String r126 = r101.file_uri;
            if (r126 == null) goto L74;
            ProtoAdapter.STRING.encodeWithTag(r100, 107, r126);
        L74:
            String r127 = r101.preprocess_key;
            if (r127 == null) goto L77;
            ProtoAdapter.STRING.encodeWithTag(r100, 108, r127);
        L77:
            MediaContent.Source r128 = r101.media_source;
            if (r128 == null) goto L80;
            MediaContent.Source.ADAPTER.encodeWithTag(r100, 120, r128);
        L80:
            String r129 = r101.compress_path;
            if (r129 == null) goto L83;
            ProtoAdapter.STRING.encodeWithTag(r100, 121, r129);
        L83:
            String r130 = r101.first_screen_image_upload_id;
            if (r130 == null) goto L86;
            ProtoAdapter.STRING.encodeWithTag(r100, 122, r130);
        L86:
            String r131 = r101.media_upload_id;
            if (r131 == null) goto L89;
            ProtoAdapter.STRING.encodeWithTag(r100, 123, r131);
        L89:
            String r132 = r101.file_upload_id;
            if (r132 == null) goto L92;
            ProtoAdapter.STRING.encodeWithTag(r100, 124, r132);
        L92:
            Boolean r133 = r101.is_group_announcement;
            if (r133 == null) goto L95;
            ProtoAdapter.BOOL.encodeWithTag(r100, 150, r133);
        L95:
            String r134 = r101.sticker_set_id;
            if (r134 == null) goto L98;
            ProtoAdapter.STRING.encodeWithTag(r100, 200, r134);
        L98:
            String r135 = r101.sticker_id;
            if (r135 == null) goto L101;
            ProtoAdapter.STRING.encodeWithTag(r100, 201, r135);
        L101:
            String r136 = r101.share_chatter_id;
            if (r136 == null) goto L104;
            ProtoAdapter.STRING.encodeWithTag(r100, 220, r136);
        L104:
            DoubaoResource r137 = r101.doubao_resource;
            if (r137 == null) goto L107;
            DoubaoResource.ADAPTER.encodeWithTag(r100, 221, r137);
        L107:
            LingoOption r138 = r101.lingo_option;
            if (r138 == null) goto L110;
            LingoOption.ADAPTER.encodeWithTag(r100, 33, r138);
        L110:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, QuasiContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_QuasiContent();
        ByteString r100 = ByteString.EMPTY;
        DEFAULT_IMAGE = r100;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_IS_ORIGIN_SOURCE = r101;
        DEFAULT_AUDIO = r100;
        DEFAULT_DURATION = 0;
        DEFAULT_WIDTH = 0;
        DEFAULT_HEIGHT = 0;
        DEFAULT_SIZE_BYTES = 0L;
        DEFAULT_FILE_SOURCE = File.Source.LARK_SERVER;
        DEFAULT_LAN_TRANS_STATUS = TransStatus.PENDING;
        DEFAULT_IS_TRY_USE_LAN_TRANS = r101;
        DEFAULT_FILE_HANDLE = 0L;
        DEFAULT_MEDIA_SOURCE = MediaContent.Source.LARK;
        DEFAULT_IS_GROUP_ANNOUNCEMENT = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.title = this.title;
        r100.text = this.text;
        r100.image = this.image;
        r100.is_origin_source = this.is_origin_source;
        r100.path = this.path;
        r100.audio = this.audio;
        r100.duration = this.duration;
        r100.image_path = this.image_path;
        r100.image_upload_id = this.image_upload_id;
        r100.attachments = Internal.copyOf("attachments", this.attachments);
        r100.file_attachments = Internal.copyOf("file_attachments", this.file_attachments);
        r100.url_preview_hang_point_map = Internal.copyOf("url_preview_hang_point_map", this.url_preview_hang_point_map);
        r100.share_chat_id = this.share_chat_id;
        r100.key = this.key;
        r100.width = this.width;
        r100.height = this.height;
        r100.rich_text = this.rich_text;
        r100.card_content = this.card_content;
        r100.location_content = this.location_content;
        r100.name = this.name;
        r100.mime = this.mime;
        r100.size_bytes = this.size_bytes;
        r100.file_source = this.file_source;
        r100.lan_trans_status = this.lan_trans_status;
        r100.is_try_use_lan_trans = this.is_try_use_lan_trans;
        r100.file_handle = this.file_handle;
        r100.file_uri = this.file_uri;
        r100.preprocess_key = this.preprocess_key;
        r100.media_source = this.media_source;
        r100.compress_path = this.compress_path;
        r100.first_screen_image_upload_id = this.first_screen_image_upload_id;
        r100.media_upload_id = this.media_upload_id;
        r100.file_upload_id = this.file_upload_id;
        r100.is_group_announcement = this.is_group_announcement;
        r100.sticker_set_id = this.sticker_set_id;
        r100.sticker_id = this.sticker_id;
        r100.share_chatter_id = this.share_chatter_id;
        r100.doubao_resource = this.doubao_resource;
        r100.lingo_option = this.lingo_option;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return QuasiContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public QuasiContent(String r410, String r411, ByteString r412, Boolean r413, String r414, ByteString r415, Integer r416, String r417, String r510, List<File> r511, List<File> r512, Map<String, UrlPreviewHangPoint> r513, String r514, String r515, Integer r516, Integer r517, RichText r518, CardContent r519, LocationContent r610, String r611, String r612, Long r613, File.Source r614, TransStatus r615, Boolean r616, Long r617, String r618, String r619, MediaContent.Source r710, String r711, String r712, String r713, String r714, Boolean r715, String r716, String r717, String r718, DoubaoResource r719, LingoOption r810) {
        this(r410, r411, r412, r413, r414, r415, r416, r417, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, ByteString.EMPTY);
    }

    public QuasiContent(String r100, String r101, ByteString r102, Boolean r103, String r104, ByteString r105, Integer r110, String r111, String r112, List<File> r113, List<File> r114, Map<String, UrlPreviewHangPoint> r115, String r116, String r117, Integer r118, Integer r119, RichText r210, CardContent r211, LocationContent r212, String r213, String r214, Long r215, File.Source r216, TransStatus r217, Boolean r218, Long r219, String r310, String r311, MediaContent.Source r312, String r313, String r314, String r315, String r316, Boolean r317, String r318, String r319, String r410, DoubaoResource r411, LingoOption r412, ByteString r413) {
        super(ADAPTER, r413);
        this.title = r100;
        this.text = r101;
        this.image = r102;
        this.is_origin_source = r103;
        this.path = r104;
        this.audio = r105;
        this.duration = r110;
        this.image_path = r111;
        this.image_upload_id = r112;
        this.attachments = Internal.immutableCopyOf("attachments", r113);
        this.file_attachments = Internal.immutableCopyOf("file_attachments", r114);
        this.url_preview_hang_point_map = Internal.immutableCopyOf("url_preview_hang_point_map", r115);
        this.share_chat_id = r116;
        this.key = r117;
        this.width = r118;
        this.height = r119;
        this.rich_text = r210;
        this.card_content = r211;
        this.location_content = r212;
        this.name = r213;
        this.mime = r214;
        this.size_bytes = r215;
        this.file_source = r216;
        this.lan_trans_status = r217;
        this.is_try_use_lan_trans = r218;
        this.file_handle = r219;
        this.file_uri = r310;
        this.preprocess_key = r311;
        this.media_source = r312;
        this.compress_path = r313;
        this.first_screen_image_upload_id = r314;
        this.media_upload_id = r315;
        this.file_upload_id = r316;
        this.is_group_announcement = r317;
        this.sticker_set_id = r318;
        this.sticker_id = r319;
        this.share_chatter_id = r410;
        this.doubao_resource = r411;
        this.lingo_option = r412;
    }
}
