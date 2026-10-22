package com.bytedance.lark.pb.media.v1;

import com.obric.miniapp.alarm.AlarmSessionType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PreprocessResourceRequest extends Message<PreprocessResourceRequest, Builder> {
    public static final ProtoAdapter<PreprocessResourceRequest> ADAPTER = null;
    public static final String DEFAULT_CONTAINER = "";
    public static final Long DEFAULT_FILE_HANDLE = null;
    public static final String DEFAULT_FILE_PATH = "";
    public static final FileType DEFAULT_FILE_TYPE = null;
    public static final ByteString DEFAULT_IMAGE = null;
    public static final Scene DEFAULT_SCENE = null;
    public static final ProtoAdapter_PreprocessResourceRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String container;
    public final Long file_handle;
    public final String file_path;
    public final FileType file_type;
    public final ByteString image;
    public final Scene scene;

    public static final class Builder extends Message.Builder<PreprocessResourceRequest, Builder> implements d<PreprocessResourceRequest> {
        public String container;
        public Long file_handle;
        public String file_path;
        public FileType file_type;
        public ByteString image;
        public Scene scene;

        @Override // com.squareup.wire.Message.Builder
        public PreprocessResourceRequest build() {
            FileType r100 = this.file_type;
            if (r100 == null) goto L7;
            return new PreprocessResourceRequest(this.file_type, this.file_path, this.file_handle, this.image, this.scene, this.container, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "file_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder container(String r100) {
            this.container = r100;
            return this;
        }

        public Builder file_handle(Long r100) {
            this.file_handle = r100;
            return this;
        }

        public Builder file_path(String r100) {
            this.file_path = r100;
            return this;
        }

        public Builder file_type(FileType r100) {
            this.file_type = r100;
            return this;
        }

        public Builder image(ByteString r100) {
            this.image = r100;
            return this;
        }

        public Builder scene(Scene r100) {
            this.scene = r100;
            return this;
        }
    }

    public static final enum FileType extends Enum<FileType> implements WireEnum {
        private static final /* synthetic */ FileType[] $VALUES = null;
        public static final ProtoAdapter<FileType> ADAPTER = null;
        public static final FileType FILE = null;
        public static final FileType IMAGE = null;
        public static final FileType MEDIA = null;
        private final int value;

        static {
            FileType r100 = new FileType("FILE", 0, 1);
            FILE = r100;
            FileType r101 = new FileType("IMAGE", 1, 2);
            IMAGE = r101;
            FileType r102 = new FileType("MEDIA", 2, 5);
            MEDIA = r102;
            $VALUES = new FileType[]{r100, r101, r102};
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
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 5) goto L11;
            return null;
        L11:
            return MEDIA;
        L13:
            return IMAGE;
        L15:
            return FILE;
        }

        public static FileType valueOf(String r100) {
            return (FileType) a.a(FileType.class, r100);
        }

        private FileType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_PreprocessResourceRequest extends ProtoAdapter<PreprocessResourceRequest> implements c<PreprocessResourceRequest> {
        public ProtoAdapter_PreprocessResourceRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PreprocessResourceRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PreprocessResourceRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.file_type = FileType.FILE;
            r101.file_path = "";
            r101.file_handle = 0L;
            r101.image = ByteString.EMPTY;
            r101.scene = Scene.UNKNOWN;
            r101.container = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L21;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L23;
                case 6: goto L7;
                default: goto L6;
            };
        L21:
            r101.file_type = FileType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L23:
            r101.scene = Scene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.container = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.image = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L13:
            r101.file_handle = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            r101.file_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PreprocessResourceRequest r100) {
            int r101 = FileType.ADAPTER.encodedSizeWithTag(1, r100.file_type);
            String r102 = r100.file_path;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Long r106 = r100.file_handle;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.INT64.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            ByteString r109 = r100.image;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.BYTES.encodedSizeWithTag(4, r109);
        L14:
            int r111 = r108 + r110;
            Scene r112 = r100.scene;
            if (r112 == null) goto L17;
            int r113 = Scene.ADAPTER.encodedSizeWithTag(5, r112);
        L18:
            int r114 = r111 + r113;
            String r115 = r100.container;
            if (r115 == null) goto L22;
            r103 = ProtoAdapter.STRING.encodedSizeWithTag(6, r115);
        L22:
            return (r114 + r103) + r100.unknownFields().size();
        L17:
            r113 = 0;
            goto L18
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PreprocessResourceRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PreprocessResourceRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PreprocessResourceRequest r101) throws IOException {
            FileType.ADAPTER.encodeWithTag(r100, 1, r101.file_type);
            String r102 = r101.file_path;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            Long r103 = r101.file_handle;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r103);
        L8:
            ByteString r104 = r101.image;
            if (r104 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r100, 4, r104);
        L11:
            Scene r105 = r101.scene;
            if (r105 == null) goto L14;
            Scene.ADAPTER.encodeWithTag(r100, 5, r105);
        L14:
            String r106 = r101.container;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PreprocessResourceRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Scene extends Enum<Scene> implements WireEnum {
        private static final /* synthetic */ Scene[] $VALUES = null;
        public static final ProtoAdapter<Scene> ADAPTER = null;
        public static final Scene CHAT = null;
        public static final Scene FAVORITE = null;
        public static final Scene Moments = null;
        public static final Scene TODO = null;
        public static final Scene UNKNOWN = null;
        private final int value;

        static {
            Scene r100 = new Scene("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Scene r101 = new Scene("CHAT", 1, 1);
            CHAT = r101;
            Scene r102 = new Scene("FAVORITE", 2, 2);
            FAVORITE = r102;
            Scene r103 = new Scene(AlarmSessionType.TODO, 3, 3);
            TODO = r103;
            Scene r104 = new Scene("Moments", 4, 4);
            Moments = r104;
            $VALUES = new Scene[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(Scene.class);
        }

        public static Scene[] values() {
            return (Scene[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Scene fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return Moments;
        L16:
            return TODO;
        L18:
            return FAVORITE;
        L20:
            return CHAT;
        L22:
            return UNKNOWN;
        }

        public static Scene valueOf(String r100) {
            return (Scene) a.a(Scene.class, r100);
        }

        private Scene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_PreprocessResourceRequest r100 = new ProtoAdapter_PreprocessResourceRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_FILE_TYPE = FileType.FILE;
        DEFAULT_FILE_HANDLE = 0L;
        DEFAULT_IMAGE = ByteString.EMPTY;
        DEFAULT_SCENE = Scene.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.file_type = this.file_type;
        r100.file_path = this.file_path;
        r100.file_handle = this.file_handle;
        r100.image = this.image;
        r100.scene = this.scene;
        r100.container = this.container;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PreprocessResourceRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PreprocessResourceRequest(FileType r100, String r110, Long r111, ByteString r112, Scene r113, String r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public PreprocessResourceRequest(FileType r100, String r101, Long r102, ByteString r103, Scene r104, String r105, ByteString r106) {
        super(ADAPTER, r106);
        this.file_type = r100;
        this.file_path = r101;
        this.file_handle = r102;
        this.image = r103;
        this.scene = r104;
        this.container = r105;
    }
}
