package com.bytedance.lark.pb.basic.v1;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class File extends com.squareup.wire.Message<File, Builder> {
    public static final ProtoAdapter<File> ADAPTER = null;
    public static final Boolean DEFAULT_IS_DESTROYED = null;
    public static final Boolean DEFAULT_IS_FOLDER = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_MIME = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PATH = "";
    public static final Long DEFAULT_SCENE_ID = null;
    public static final Long DEFAULT_SIZE = null;
    private static final long serialVersionUID = 0;
    public final Extra extra;
    public final Boolean is_destroyed;
    public final Boolean is_folder;
    public final String key;
    public final String mime;
    public final String name;
    public final String path;
    public final Long scene_id;
    public final Long size;

    public static final class Builder extends com.squareup.wire.Message.Builder<File, Builder> {
        public Extra extra;
        public Boolean is_destroyed;
        public Boolean is_folder;
        public String key;
        public String mime;
        public String name;
        public String path;
        public Long scene_id;
        public Long size;

        @Override // com.squareup.wire.Message.Builder
        public File build() {
            return new File(this.key, this.name, this.size, this.mime, this.path, this.extra, this.is_destroyed, this.scene_id, this.is_folder, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder extra(Extra r100) {
            this.extra = r100;
            return this;
        }

        public Builder is_destroyed(Boolean r100) {
            this.is_destroyed = r100;
            return this;
        }

        public Builder is_folder(Boolean r100) {
            this.is_folder = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
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

        public Builder scene_id(Long r100) {
            this.scene_id = r100;
            return this;
        }

        public Builder size(Long r100) {
            this.size = r100;
            return this;
        }
    }

    public static final enum EntityType extends Enum<EntityType> implements WireEnum {
        private static final /* synthetic */ EntityType[] $VALUES = null;
        public static final ProtoAdapter<EntityType> ADAPTER = null;
        public static final EntityType CARD_FILE = null;
        public static final EntityType EMAIL = null;
        public static final EntityType MESSAGE = null;
        public final Boolean deprecated;
        private final int value;

        static {
            EntityType r100 = new EntityType("MESSAGE", 0, 1, null);
            MESSAGE = r100;
            EntityType r101 = new EntityType(CommonConstant.RETKEY.EMAIL, 1, 2, Boolean.TRUE);
            EMAIL = r101;
            EntityType r102 = new EntityType("CARD_FILE", 2, 16, null);
            CARD_FILE = r102;
            $VALUES = new EntityType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(EntityType.class);
        }

        public static EntityType[] values() {
            return (EntityType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static EntityType fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 16) goto L11;
            return null;
        L11:
            return CARD_FILE;
        L13:
            return EMAIL;
        L15:
            return MESSAGE;
        }

        public static EntityType valueOf(String r100) {
            return (EntityType) a.a(EntityType.class, r100);
        }

        private EntityType(String r100, int r101, int r102, Boolean r103) {
            super(r100, r101);
            this.value = r102;
            this.deprecated = r103;
        }
    }

    public static final class Extra extends com.squareup.wire.Message<Extra, Builder> {
        public static final ProtoAdapter<Extra> ADAPTER = null;
        public static final Source DEFAULT_SOURCE = null;
        private static final long serialVersionUID = 0;
        public final Source source;
        public final Image thumbnail;

        public static final class Builder extends com.squareup.wire.Message.Builder<Extra, Builder> {
            public Source source;
            public Image thumbnail;

            @Override // com.squareup.wire.Message.Builder
            public Extra build() {
                return new Extra(this.thumbnail, this.source, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder source(Source r100) {
                this.source = r100;
                return this;
            }

            public Builder thumbnail(Image r100) {
                this.thumbnail = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Extra extends ProtoAdapter<Extra> {
            public ProtoAdapter_Extra() {
                super(FieldEncoding.LENGTH_DELIMITED, Extra.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Extra decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.source = Source.UNKNOWN;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.thumbnail = Image.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.source = Source.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Extra r100) {
                Image r101 = r100.thumbnail;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Image.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Source r104 = r100.source;
                if (r104 == null) goto L10;
                r102 = Source.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Extra decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Extra r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Extra r101) throws IOException {
                Image r102 = r101.thumbnail;
                if (r102 == null) goto L5;
                Image.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Source r103 = r101.source;
                if (r103 == null) goto L8;
                Source.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Extra r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Extra();
            DEFAULT_SOURCE = Source.UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.thumbnail = this.thumbnail;
            r100.source = this.source;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Extra.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Extra(Image r100, Source r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public Extra(Image r100, Source r101, ByteString r102) {
            super(ADAPTER, r102);
            this.thumbnail = r100;
            this.source = r101;
        }
    }

    public static final class ProtoAdapter_File extends ProtoAdapter<File> {
        public ProtoAdapter_File() {
            super(FieldEncoding.LENGTH_DELIMITED, File.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public File decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key = "";
            r101.name = "";
            r101.size = 0L;
            r101.mime = "";
            r101.path = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_destroyed = r102;
            r101.scene_id = 0L;
            r101.is_folder = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L16;
            switch(r104) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r101.is_folder = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.scene_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L9:
            r101.is_destroyed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.extra = Extra.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.mime = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.size = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(File r100) {
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
            String r113 = r100.path;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Extra r116 = r100.extra;
            if (r116 == null) goto L25;
            int r117 = Extra.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Boolean r119 = r100.is_destroyed;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Long r122 = r100.scene_id;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.INT64.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Boolean r125 = r100.is_folder;
            if (r125 == null) goto L38;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r125);
        L38:
            return (r124 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ File decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(File r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, File r101) throws IOException {
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
            String r106 = r101.path;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            Extra r107 = r101.extra;
            if (r107 == null) goto L20;
            Extra.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            Boolean r108 = r101.is_destroyed;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
        L23:
            Long r109 = r101.scene_id;
            if (r109 == null) goto L26;
            ProtoAdapter.INT64.encodeWithTag(r100, 8, r109);
        L26:
            Boolean r110 = r101.is_folder;
            if (r110 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r110);
        L29:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, File r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Source extends Enum<Source> implements WireEnum {
        private static final /* synthetic */ Source[] $VALUES = null;
        public static final ProtoAdapter<Source> ADAPTER = null;
        public static final Source LAN_TRANS = null;
        public static final Source LARK_SERVER = null;
        public static final Source NUT_STORE = null;
        public static final Source UNKNOWN = null;
        private final int value;

        static {
            Source r100 = new Source("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Source r101 = new Source("LARK_SERVER", 1, 1);
            LARK_SERVER = r101;
            Source r102 = new Source("NUT_STORE", 2, 2);
            NUT_STORE = r102;
            Source r103 = new Source("LAN_TRANS", 3, 3);
            LAN_TRANS = r103;
            $VALUES = new Source[]{r100, r101, r102, r103};
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
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return LAN_TRANS;
        L14:
            return NUT_STORE;
        L16:
            return LARK_SERVER;
        L18:
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
        ADAPTER = new ProtoAdapter_File();
        DEFAULT_SIZE = 0L;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_DESTROYED = r100;
        DEFAULT_SCENE_ID = 0L;
        DEFAULT_IS_FOLDER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.name = this.name;
        r100.size = this.size;
        r100.mime = this.mime;
        r100.path = this.path;
        r100.extra = this.extra;
        r100.is_destroyed = this.is_destroyed;
        r100.scene_id = this.scene_id;
        r100.is_folder = this.is_folder;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return File.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public File(String r110, String r111, Long r112, String r113, String r114, Extra r115, Boolean r116, Long r117, Boolean r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public File(String r100, String r101, Long r102, String r103, String r104, Extra r105, Boolean r106, Long r107, Boolean r110, ByteString r111) {
        super(ADAPTER, r111);
        this.key = r100;
        this.name = r101;
        this.size = r102;
        this.mime = r103;
        this.path = r104;
        this.extra = r105;
        this.is_destroyed = r106;
        this.scene_id = r107;
        this.is_folder = r110;
    }
}
