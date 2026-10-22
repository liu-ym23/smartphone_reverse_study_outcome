package com.bytedance.lark.pb.media.v1;

import com.bytedance.lark.pb.basic.v1.FilePreviewStage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class BrowseFolderResponse extends Message<BrowseFolderResponse, Builder> {
    public static final ProtoAdapter<BrowseFolderResponse> ADAPTER = null;
    public static final ProtoAdapter_BrowseFolderResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> key2path;
    public final SerResp ser_resp;

    public static final class Builder extends Message.Builder<BrowseFolderResponse, Builder> implements d<BrowseFolderResponse> {
        public Map<String, String> key2path;
        public SerResp ser_resp;

        @Override // com.squareup.wire.Message.Builder
        public BrowseFolderResponse build() {
            SerResp r100 = this.ser_resp;
            if (r100 == null) goto L7;
            return new BrowseFolderResponse(this.ser_resp, this.key2path, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "ser_resp"});
        }

        public Builder() {
            this.key2path = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder key2path(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.key2path = r100;
            return this;
        }

        public Builder ser_resp(SerResp r100) {
            this.ser_resp = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BrowseFolderResponse extends ProtoAdapter<BrowseFolderResponse> implements c<BrowseFolderResponse> {
        private final ProtoAdapter<Map<String, String>> key2path;

        public ProtoAdapter_BrowseFolderResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, BrowseFolderResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.key2path = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BrowseFolderResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.ser_resp = SerResp.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.key2path.putAll(this.key2path.decode(r100));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BrowseFolderResponse r100) {
            return (SerResp.ADAPTER.encodedSizeWithTag(1, r100.ser_resp) + this.key2path.encodedSizeWithTag(2, r100.key2path)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BrowseFolderResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BrowseFolderResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BrowseFolderResponse r101) throws IOException {
            SerResp.ADAPTER.encodeWithTag(r100, 1, r101.ser_resp);
            this.key2path.encodeWithTag(r100, 2, r101.key2path);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BrowseFolderResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class SerResp extends Message<SerResp, Builder> {
        public static final ProtoAdapter<SerResp> ADAPTER = null;
        public static final Long DEFAULT_ALL_COUNT = null;
        public static final Boolean DEFAULT_HAS_MORE = null;
        private static final long serialVersionUID = 0;
        public final Long all_count;
        public final Boolean has_more;
        public final List<BrowseInfo> infos;

        public static final class BrowseInfo extends Message<BrowseInfo, Builder> {
            public static final ProtoAdapter<BrowseInfo> ADAPTER = null;
            public static final Long DEFAULT_CREATE_TIME = null;
            public static final String DEFAULT_KEY = "";
            public static final String DEFAULT_NAME = "";
            public static final Long DEFAULT_OWNER_ID = null;
            public static final String DEFAULT_OWNER_NAME = "";
            public static final String DEFAULT_PREVIEW_IMAGE_KEY = "";
            public static final FilePreviewStage DEFAULT_PREVIEW_STAGE = null;
            public static final Long DEFAULT_SIZE = null;
            public static final FileType DEFAULT_TYPE = null;
            private static final long serialVersionUID = 0;
            public final Long create_time;
            public final String key;
            public final String name;
            public final Long owner_id;
            public final String owner_name;
            public final String preview_image_key;
            public final FilePreviewStage preview_stage;
            public final Long size;
            public final FileType type;

            public static final class Builder extends Message.Builder<BrowseInfo, Builder> {
                public Long create_time;
                public String key;
                public String name;
                public Long owner_id;
                public String owner_name;
                public String preview_image_key;
                public FilePreviewStage preview_stage;
                public Long size;
                public FileType type;

                @Override // com.squareup.wire.Message.Builder
                public BrowseInfo build() {
                    String r100 = this.key;
                    if (r100 == null) goto L13;
                    if (this.owner_id == null) goto L13;
                    if (this.type == null) goto L13;
                    if (this.name == null) goto L13;
                    return new BrowseInfo(this.key, this.owner_id, this.owner_name, this.type, this.name, this.size, this.create_time, this.preview_image_key, this.preview_stage, super.buildUnknownFields());
                L13:
                    throw Internal.missingRequiredFields(new Object[]{r100, "key", this.owner_id, "owner_id", this.type, "type", this.name, "name"});
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder create_time(Long r100) {
                    this.create_time = r100;
                    return this;
                }

                public Builder key(String r100) {
                    this.key = r100;
                    return this;
                }

                public Builder name(String r100) {
                    this.name = r100;
                    return this;
                }

                public Builder owner_id(Long r100) {
                    this.owner_id = r100;
                    return this;
                }

                public Builder owner_name(String r100) {
                    this.owner_name = r100;
                    return this;
                }

                public Builder preview_image_key(String r100) {
                    this.preview_image_key = r100;
                    return this;
                }

                public Builder preview_stage(FilePreviewStage r100) {
                    this.preview_stage = r100;
                    return this;
                }

                public Builder size(Long r100) {
                    this.size = r100;
                    return this;
                }

                public Builder type(FileType r100) {
                    this.type = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_BrowseInfo extends ProtoAdapter<BrowseInfo> {
                public ProtoAdapter_BrowseInfo() {
                    super(FieldEncoding.LENGTH_DELIMITED, BrowseInfo.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public BrowseInfo decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.key = "";
                    r101.owner_id = 0L;
                    r101.owner_name = "";
                    r101.type = FileType.UNKNOWN;
                    r101.name = "";
                    r101.size = 0L;
                    r101.create_time = 0L;
                    r101.preview_image_key = "";
                    r101.preview_stage = FilePreviewStage.UnknownStage;
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L22;
                    switch(r103) {
                        case 1: goto L21;
                        case 2: goto L20;
                        case 3: goto L19;
                        case 4: goto L26;
                        case 5: goto L14;
                        case 6: goto L13;
                        case 7: goto L12;
                        case 8: goto L11;
                        case 9: goto L24;
                        default: goto L6;
                    };
                L24:
                    r101.preview_stage = FilePreviewStage.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
                L9:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L26:
                    r101.type = FileType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
                L17:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L11:
                    r101.preview_image_key = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L12:
                    r101.create_time = ProtoAdapter.INT64.decode(r100);
                    goto L3
                L13:
                    r101.size = ProtoAdapter.INT64.decode(r100);
                    goto L3
                L14:
                    r101.name = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L19:
                    r101.owner_name = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L20:
                    r101.owner_id = ProtoAdapter.INT64.decode(r100);
                    goto L3
                L21:
                    r101.key = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L6:
                    FieldEncoding r104 = r100.peekFieldEncoding();
                    r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                    goto L3
                L22:
                    r100.endMessage(r102);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(BrowseInfo r100) {
                    ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                    int r102 = r101.encodedSizeWithTag(1, r100.key);
                    ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
                    int r104 = r102 + r103.encodedSizeWithTag(2, r100.owner_id);
                    String r105 = r100.owner_name;
                    int r106 = 0;
                    if (r105 == null) goto L5;
                    int r107 = r101.encodedSizeWithTag(3, r105);
                L6:
                    int r108 = ((r104 + r107) + FileType.ADAPTER.encodedSizeWithTag(4, r100.type)) + r101.encodedSizeWithTag(5, r100.name);
                    Long r109 = r100.size;
                    if (r109 == null) goto L9;
                    int r110 = r103.encodedSizeWithTag(6, r109);
                L10:
                    int r111 = r108 + r110;
                    Long r112 = r100.create_time;
                    if (r112 == null) goto L13;
                    int r113 = r103.encodedSizeWithTag(7, r112);
                L14:
                    int r114 = r111 + r113;
                    String r115 = r100.preview_image_key;
                    if (r115 == null) goto L17;
                    int r116 = r101.encodedSizeWithTag(8, r115);
                L18:
                    int r117 = r114 + r116;
                    FilePreviewStage r118 = r100.preview_stage;
                    if (r118 == null) goto L22;
                    r106 = FilePreviewStage.ADAPTER.encodedSizeWithTag(9, r118);
                L22:
                    return (r117 + r106) + r100.unknownFields().size();
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
                public /* bridge */ /* synthetic */ BrowseInfo decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(BrowseInfo r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, BrowseInfo r101) throws IOException {
                    ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                    r102.encodeWithTag(r100, 1, r101.key);
                    ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
                    r103.encodeWithTag(r100, 2, r101.owner_id);
                    String r104 = r101.owner_name;
                    if (r104 == null) goto L5;
                    r102.encodeWithTag(r100, 3, r104);
                L5:
                    FileType.ADAPTER.encodeWithTag(r100, 4, r101.type);
                    r102.encodeWithTag(r100, 5, r101.name);
                    Long r105 = r101.size;
                    if (r105 == null) goto L8;
                    r103.encodeWithTag(r100, 6, r105);
                L8:
                    Long r106 = r101.create_time;
                    if (r106 == null) goto L11;
                    r103.encodeWithTag(r100, 7, r106);
                L11:
                    String r107 = r101.preview_image_key;
                    if (r107 == null) goto L14;
                    r102.encodeWithTag(r100, 8, r107);
                L14:
                    FilePreviewStage r108 = r101.preview_stage;
                    if (r108 == null) goto L17;
                    FilePreviewStage.ADAPTER.encodeWithTag(r100, 9, r108);
                L17:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BrowseInfo r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_BrowseInfo();
                DEFAULT_OWNER_ID = 0L;
                DEFAULT_TYPE = FileType.UNKNOWN;
                DEFAULT_SIZE = 0L;
                DEFAULT_CREATE_TIME = 0L;
                DEFAULT_PREVIEW_STAGE = FilePreviewStage.UnknownStage;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.key = this.key;
                r100.owner_id = this.owner_id;
                r100.owner_name = this.owner_name;
                r100.type = this.type;
                r100.name = this.name;
                r100.size = this.size;
                r100.create_time = this.create_time;
                r100.preview_image_key = this.preview_image_key;
                r100.preview_stage = this.preview_stage;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return BrowseInfo.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public BrowseInfo(String r110, Long r111, String r112, FileType r113, String r114, Long r115, Long r116, String r117, FilePreviewStage r210) {
                this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
            }

            public BrowseInfo(String r100, Long r101, String r102, FileType r103, String r104, Long r105, Long r106, String r107, FilePreviewStage r110, ByteString r111) {
                super(ADAPTER, r111);
                this.key = r100;
                this.owner_id = r101;
                this.owner_name = r102;
                this.type = r103;
                this.name = r104;
                this.size = r105;
                this.create_time = r106;
                this.preview_image_key = r107;
                this.preview_stage = r110;
            }
        }

        public static final class Builder extends Message.Builder<SerResp, Builder> {
            public Long all_count;
            public Boolean has_more;
            public List<BrowseInfo> infos;

            @Override // com.squareup.wire.Message.Builder
            public SerResp build() {
                return new SerResp(this.infos, this.all_count, this.has_more, super.buildUnknownFields());
            }

            public Builder() {
                this.infos = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder all_count(Long r100) {
                this.all_count = r100;
                return this;
            }

            public Builder has_more(Boolean r100) {
                this.has_more = r100;
                return this;
            }

            public Builder infos(List<BrowseInfo> r100) {
                Internal.checkElementsNotNull(r100);
                this.infos = r100;
                return this;
            }
        }

        public static final enum FileType extends Enum<FileType> implements WireEnum {
            private static final /* synthetic */ FileType[] $VALUES = null;
            public static final ProtoAdapter<FileType> ADAPTER = null;
            public static final FileType AUDIO = null;
            public static final FileType AVATAR = null;
            public static final FileType FILE = null;
            public static final FileType FOLDER = null;
            public static final FileType IMAGE = null;
            public static final FileType LARK_LOG = null;
            public static final FileType MEDIA = null;
            public static final FileType STICKER = null;
            public static final FileType THIRD_PARTY = null;
            public static final FileType UNKNOWN = null;
            private final int value;

            static {
                FileType r100 = new FileType("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                FileType r101 = new FileType("FILE", 1, 1);
                FILE = r101;
                FileType r102 = new FileType("IMAGE", 2, 2);
                IMAGE = r102;
                FileType r103 = new FileType("STICKER", 3, 3);
                STICKER = r103;
                FileType r104 = new FileType("AUDIO", 4, 4);
                AUDIO = r104;
                FileType r105 = new FileType("MEDIA", 5, 5);
                MEDIA = r105;
                FileType r110 = new FileType("LARK_LOG", 6, 6);
                LARK_LOG = r110;
                FileType r111 = new FileType("AVATAR", 7, 7);
                AVATAR = r111;
                FileType r112 = new FileType("THIRD_PARTY", 8, 8);
                THIRD_PARTY = r112;
                FileType r113 = new FileType("FOLDER", 9, 9);
                FOLDER = r113;
                $VALUES = new FileType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
                ADAPTER = ProtoAdapter.newEnumAdapter(FileType.class);
            }

            public static FileType[] values() {
                return (FileType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static FileType fromValue(int r100) {
                switch(r100) {
                    case 0: goto L24;
                    case 1: goto L22;
                    case 2: goto L20;
                    case 3: goto L18;
                    case 4: goto L16;
                    case 5: goto L14;
                    case 6: goto L12;
                    case 7: goto L10;
                    case 8: goto L8;
                    case 9: goto L6;
                    default: goto L3;
                };
            L3:
                return null;
            L6:
                return FOLDER;
            L8:
                return THIRD_PARTY;
            L10:
                return AVATAR;
            L12:
                return LARK_LOG;
            L14:
                return MEDIA;
            L16:
                return AUDIO;
            L18:
                return STICKER;
            L20:
                return IMAGE;
            L22:
                return FILE;
            L24:
                return UNKNOWN;
            }

            public static FileType valueOf(String r100) {
                return (FileType) a.a(FileType.class, r100);
            }

            private FileType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_SerResp extends ProtoAdapter<SerResp> {
            public ProtoAdapter_SerResp() {
                super(FieldEncoding.LENGTH_DELIMITED, SerResp.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SerResp decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.all_count = 0L;
                r101.has_more = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.infos.add(BrowseInfo.ADAPTER.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.all_count = ProtoAdapter.INT64.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.has_more = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(SerResp r100) {
                int r101 = BrowseInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.infos);
                Long r102 = r100.all_count;
                int r103 = 0;
                if (r102 == null) goto L5;
                int r104 = ProtoAdapter.INT64.encodedSizeWithTag(2, r102);
            L6:
                int r105 = r101 + r104;
                Boolean r106 = r100.has_more;
                if (r106 == null) goto L10;
                r103 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r106);
            L10:
                return (r105 + r103) + r100.unknownFields().size();
            L5:
                r104 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SerResp decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SerResp r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SerResp r101) throws IOException {
                BrowseInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.infos);
                Long r102 = r101.all_count;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r102);
            L5:
                Boolean r103 = r101.has_more;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SerResp r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SerResp();
            DEFAULT_ALL_COUNT = 0L;
            DEFAULT_HAS_MORE = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.infos = Internal.copyOf("infos", this.infos);
            r100.all_count = this.all_count;
            r100.has_more = this.has_more;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SerResp.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SerResp(List<BrowseInfo> r100, Long r101, Boolean r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public SerResp(List<BrowseInfo> r100, Long r101, Boolean r102, ByteString r103) {
            super(ADAPTER, r103);
            this.infos = Internal.immutableCopyOf("infos", r100);
            this.all_count = r101;
            this.has_more = r102;
        }
    }

    static {
        ProtoAdapter_BrowseFolderResponse r100 = new ProtoAdapter_BrowseFolderResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.ser_resp = this.ser_resp;
        r100.key2path = Internal.copyOf("key2path", this.key2path);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BrowseFolderResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BrowseFolderResponse(SerResp r100, Map<String, String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public BrowseFolderResponse(SerResp r100, Map<String, String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.ser_resp = r100;
        this.key2path = Internal.immutableCopyOf("key2path", r101);
    }
}
