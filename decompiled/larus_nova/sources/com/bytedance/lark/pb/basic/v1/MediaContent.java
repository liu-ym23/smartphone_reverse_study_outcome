package com.bytedance.lark.pb.basic.v1;

import com.obric.miniapp.alarm.AccountType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class MediaContent extends com.squareup.wire.Message<MediaContent, Builder> {
    public static final ProtoAdapter<MediaContent> ADAPTER = null;
    public static final String DEFAULT_COMPRESS_PATH = "";
    public static final Integer DEFAULT_DURATION = null;
    public static final String DEFAULT_FIRST_SCREEN_IMAGE_UPLOAD_ID = "";
    public static final Boolean DEFAULT_IS_DESTROYED = null;
    public static final Boolean DEFAULT_IS_ORIGINAL = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_MEDIA_UPLOAD_ID = "";
    public static final String DEFAULT_MIME = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_ORIGIN_PATH = "";
    public static final Long DEFAULT_SCENE_ID = null;
    public static final Long DEFAULT_SIZE = null;
    public static final Source DEFAULT_SOURCE = null;
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final String compress_path;
    public final Integer duration;
    public final String first_screen_image_upload_id;
    public final ImageSet image;
    public final Boolean is_destroyed;
    public final Boolean is_original;
    public final String key;
    public final String media_upload_id;
    public final String mime;
    public final String name;
    public final String origin_path;
    public final Long scene_id;
    public final Long size;
    public final Source source;
    public final String url;

    public static final class Builder extends com.squareup.wire.Message.Builder<MediaContent, Builder> {
        public String compress_path;
        public Integer duration;
        public String first_screen_image_upload_id;
        public ImageSet image;
        public Boolean is_destroyed;
        public Boolean is_original;
        public String key;
        public String media_upload_id;
        public String mime;
        public String name;
        public String origin_path;
        public Long scene_id;
        public Long size;
        public Source source;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public MediaContent build() {
            return new MediaContent(this.key, this.name, this.size, this.mime, this.source, this.image, this.duration, this.url, this.compress_path, this.origin_path, this.is_original, this.first_screen_image_upload_id, this.media_upload_id, this.is_destroyed, this.scene_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder compress_path(String r100) {
            this.compress_path = r100;
            return this;
        }

        public Builder duration(Integer r100) {
            this.duration = r100;
            return this;
        }

        public Builder first_screen_image_upload_id(String r100) {
            this.first_screen_image_upload_id = r100;
            return this;
        }

        public Builder image(ImageSet r100) {
            this.image = r100;
            return this;
        }

        public Builder is_destroyed(Boolean r100) {
            this.is_destroyed = r100;
            return this;
        }

        public Builder is_original(Boolean r100) {
            this.is_original = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
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

        public Builder origin_path(String r100) {
            this.origin_path = r100;
            return this;
        }

        public Builder scene_id(Long r100) {
            this.scene_id = r100;
            return this;
        }

        public Builder size(Long r100) {
            this.size = r100;
            return this;
        }

        public Builder source(Source r100) {
            this.source = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MediaContent extends ProtoAdapter<MediaContent> {
        public ProtoAdapter_MediaContent() {
            super(FieldEncoding.LENGTH_DELIMITED, MediaContent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MediaContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key = "";
            r101.name = "";
            r101.size = 0L;
            r101.mime = "";
            r101.source = Source.UNKNOWN;
            r101.duration = 0;
            r101.url = "";
            r101.compress_path = "";
            r101.origin_path = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_original = r102;
            r101.first_screen_image_upload_id = "";
            r101.media_upload_id = "";
            r101.is_destroyed = r102;
            r101.scene_id = 0L;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L25;
            switch(r104) {
                case 1: goto L24;
                case 2: goto L23;
                case 3: goto L22;
                case 4: goto L21;
                case 5: goto L27;
                case 6: goto L16;
                case 7: goto L15;
                case 8: goto L14;
                case 9: goto L13;
                case 10: goto L12;
                case 11: goto L11;
                case 12: goto L10;
                case 13: goto L9;
                case 14: goto L8;
                case 15: goto L7;
                default: goto L6;
            };
        L27:
            r101.source = Source.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.scene_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            r101.is_destroyed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.media_upload_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.first_screen_image_upload_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.is_original = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.origin_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.compress_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.duration = ProtoAdapter.INT32.decode(r100);
            goto L3
        L16:
            r101.image = ImageSet.ADAPTER.decode(r100);
            goto L3
        L21:
            r101.mime = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.size = ProtoAdapter.INT64.decode(r100);
            goto L3
        L23:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L24:
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L25:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MediaContent r100) {
            String r101 = r100.key;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.name;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.size;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mime;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Source r113 = r100.source;
            if (r113 == null) goto L21;
            int r114 = Source.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            ImageSet r116 = r100.image;
            if (r116 == null) goto L25;
            int r117 = ImageSet.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Integer r119 = r100.duration;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.INT32.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.url;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            String r125 = r100.compress_path;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.STRING.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            String r128 = r100.origin_path;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.STRING.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            Boolean r131 = r100.is_original;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            String r134 = r100.first_screen_image_upload_id;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.STRING.encodedSizeWithTag(12, r134);
        L50:
            int r136 = r133 + r135;
            String r137 = r100.media_upload_id;
            if (r137 == null) goto L53;
            int r138 = ProtoAdapter.STRING.encodedSizeWithTag(13, r137);
        L54:
            int r139 = r136 + r138;
            Boolean r140 = r100.is_destroyed;
            if (r140 == null) goto L57;
            int r141 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r140);
        L58:
            int r142 = r139 + r141;
            Long r143 = r100.scene_id;
            if (r143 == null) goto L62;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(15, r143);
        L62:
            return (r142 + r102) + r100.unknownFields().size();
        L57:
            r141 = 0;
            goto L58
        L53:
            r138 = 0;
            goto L54
        L49:
            r135 = 0;
            goto L50
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
        public /* bridge */ /* synthetic */ MediaContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MediaContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MediaContent r101) throws IOException {
            String r102 = r101.key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.name;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.size;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mime;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Source r106 = r101.source;
            if (r106 == null) goto L17;
            Source.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            ImageSet r107 = r101.image;
            if (r107 == null) goto L20;
            ImageSet.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            Integer r108 = r101.duration;
            if (r108 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.url;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            String r110 = r101.compress_path;
            if (r110 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r110);
        L29:
            String r111 = r101.origin_path;
            if (r111 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 10, r111);
        L32:
            Boolean r112 = r101.is_original;
            if (r112 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r100, 11, r112);
        L35:
            String r113 = r101.first_screen_image_upload_id;
            if (r113 == null) goto L38;
            ProtoAdapter.STRING.encodeWithTag(r100, 12, r113);
        L38:
            String r114 = r101.media_upload_id;
            if (r114 == null) goto L41;
            ProtoAdapter.STRING.encodeWithTag(r100, 13, r114);
        L41:
            Boolean r115 = r101.is_destroyed;
            if (r115 == null) goto L44;
            ProtoAdapter.BOOL.encodeWithTag(r100, 14, r115);
        L44:
            Long r116 = r101.scene_id;
            if (r116 == null) goto L47;
            ProtoAdapter.INT64.encodeWithTag(r100, 15, r116);
        L47:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MediaContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Source extends Enum<Source> implements WireEnum {
        private static final /* synthetic */ Source[] $VALUES = null;
        public static final ProtoAdapter<Source> ADAPTER = null;
        public static final Source LARK = null;
        public static final Source UNKNOWN = null;
        private final int value;

        static {
            Source r100 = new Source("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Source r101 = new Source(AccountType.LARK, 1, 1);
            LARK = r101;
            $VALUES = new Source[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(Source.class);
        }

        public static Source[] values() {
            return (Source[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Source fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return LARK;
        L10:
            return UNKNOWN;
        }

        public static Source valueOf(String r100) {
            return (Source) a.a(Source.class, r100);
        }

        private Source(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MediaContent();
        DEFAULT_SIZE = 0L;
        DEFAULT_SOURCE = Source.UNKNOWN;
        DEFAULT_DURATION = 0;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_ORIGINAL = r100;
        DEFAULT_IS_DESTROYED = r100;
        DEFAULT_SCENE_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.name = this.name;
        r100.size = this.size;
        r100.mime = this.mime;
        r100.source = this.source;
        r100.image = this.image;
        r100.duration = this.duration;
        r100.url = this.url;
        r100.compress_path = this.compress_path;
        r100.origin_path = this.origin_path;
        r100.is_original = this.is_original;
        r100.first_screen_image_upload_id = this.first_screen_image_upload_id;
        r100.media_upload_id = this.media_upload_id;
        r100.is_destroyed = this.is_destroyed;
        r100.scene_id = this.scene_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MediaContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public MediaContent(String r110, String r111, Long r210, String r211, Source r212, ImageSet r213, Integer r214, String r215, String r216, String r217, Boolean r218, String r219, String r310, Boolean r311, Long r312) {
        this(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, ByteString.EMPTY);
    }

    public MediaContent(String r100, String r101, Long r102, String r103, Source r104, ImageSet r105, Integer r110, String r111, String r112, String r113, Boolean r114, String r115, String r116, Boolean r117, Long r118, ByteString r119) {
        super(ADAPTER, r119);
        this.key = r100;
        this.name = r101;
        this.size = r102;
        this.mime = r103;
        this.source = r104;
        this.image = r105;
        this.duration = r110;
        this.url = r111;
        this.compress_path = r112;
        this.origin_path = r113;
        this.is_original = r114;
        this.first_screen_image_upload_id = r115;
        this.media_upload_id = r116;
        this.is_destroyed = r117;
        this.scene_id = r118;
    }
}
