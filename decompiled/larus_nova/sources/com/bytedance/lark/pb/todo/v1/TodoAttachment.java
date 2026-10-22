package com.bytedance.lark.pb.todo.v1;

import com.bytedance.lark.pb.basic.v1.ImageSet;
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
public final class TodoAttachment extends Message<TodoAttachment, Builder> {
    public static final ProtoAdapter<TodoAttachment> ADAPTER = null;
    public static final Boolean DEFAULT_CAN_DELETE = null;
    public static final String DEFAULT_FILE_SIZE = "";
    public static final String DEFAULT_FILE_TOKEN = "";
    public static final String DEFAULT_GUID = "";
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_POSITION = null;
    public static final Type DEFAULT_TYPE = null;
    public static final String DEFAULT_UPLOADER_USER_ID = "";
    public static final Long DEFAULT_UPLOAD_MILLI_TIME = null;
    private static final long serialVersionUID = 0;
    public final Boolean can_delete;
    public final String file_size;
    public final String file_token;
    public final String guid;
    public final ImageSet image_set;
    public final String name;
    public final Integer position;
    public final Type type;
    public final Long upload_milli_time;
    public final String uploader_user_id;

    public static final class Builder extends Message.Builder<TodoAttachment, Builder> {
        public Boolean can_delete;
        public String file_size;
        public String file_token;
        public String guid;
        public ImageSet image_set;
        public String name;
        public Integer position;
        public Type type;
        public Long upload_milli_time;
        public String uploader_user_id;

        @Override // com.squareup.wire.Message.Builder
        public TodoAttachment build() {
            return new TodoAttachment(this.file_token, this.file_size, this.name, this.type, this.uploader_user_id, this.position, this.image_set, this.guid, this.can_delete, this.upload_milli_time, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder can_delete(Boolean r100) {
            this.can_delete = r100;
            return this;
        }

        public Builder file_size(String r100) {
            this.file_size = r100;
            return this;
        }

        public Builder file_token(String r100) {
            this.file_token = r100;
            return this;
        }

        public Builder guid(String r100) {
            this.guid = r100;
            return this;
        }

        public Builder image_set(ImageSet r100) {
            this.image_set = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder position(Integer r100) {
            this.position = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }

        public Builder upload_milli_time(Long r100) {
            this.upload_milli_time = r100;
            return this;
        }

        public Builder uploader_user_id(String r100) {
            this.uploader_user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TodoAttachment extends ProtoAdapter<TodoAttachment> {
        public ProtoAdapter_TodoAttachment() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoAttachment.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TodoAttachment decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.file_token = "";
            r101.file_size = "";
            r101.name = "";
            r101.type = Type.UNKNOWN_TYPE;
            r101.uploader_user_id = "";
            r101.position = 0;
            r101.guid = "";
            r101.can_delete = Boolean.FALSE;
            r101.upload_milli_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L20;
            switch(r103) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L22;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L22:
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.upload_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            r101.can_delete = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.image_set = ImageSet.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            r101.uploader_user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.file_size = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.file_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L20:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TodoAttachment r100) {
            String r101 = r100.file_token;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.file_size;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.name;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Type r110 = r100.type;
            if (r110 == null) goto L17;
            int r111 = Type.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.uploader_user_id;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Integer r116 = r100.position;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT32.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            ImageSet r119 = r100.image_set;
            if (r119 == null) goto L29;
            int r120 = ImageSet.ADAPTER.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.guid;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Boolean r125 = r100.can_delete;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            Long r128 = r100.upload_milli_time;
            if (r128 == null) goto L42;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(10, r128);
        L42:
            return (r127 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ TodoAttachment decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TodoAttachment r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TodoAttachment r101) throws IOException {
            String r102 = r101.file_token;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.file_size;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.name;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Type r105 = r101.type;
            if (r105 == null) goto L14;
            Type.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.uploader_user_id;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            Integer r107 = r101.position;
            if (r107 == null) goto L20;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r107);
        L20:
            ImageSet r108 = r101.image_set;
            if (r108 == null) goto L23;
            ImageSet.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.guid;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            Boolean r110 = r101.can_delete;
            if (r110 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r110);
        L29:
            Long r111 = r101.upload_milli_time;
            if (r111 == null) goto L32;
            ProtoAdapter.INT64.encodeWithTag(r100, 10, r111);
        L32:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TodoAttachment r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type FILE = null;
        public static final Type IMAGE = null;
        public static final Type UNKNOWN_TYPE = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r100;
            Type r101 = new Type("IMAGE", 1, 1);
            IMAGE = r101;
            Type r102 = new Type("FILE", 2, 2);
            FILE = r102;
            $VALUES = new Type[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return FILE;
        L12:
            return IMAGE;
        L14:
            return UNKNOWN_TYPE;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TodoAttachment();
        DEFAULT_TYPE = Type.UNKNOWN_TYPE;
        DEFAULT_POSITION = 0;
        DEFAULT_CAN_DELETE = Boolean.FALSE;
        DEFAULT_UPLOAD_MILLI_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.file_token = this.file_token;
        r100.file_size = this.file_size;
        r100.name = this.name;
        r100.type = this.type;
        r100.uploader_user_id = this.uploader_user_id;
        r100.position = this.position;
        r100.image_set = this.image_set;
        r100.guid = this.guid;
        r100.can_delete = this.can_delete;
        r100.upload_milli_time = this.upload_milli_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TodoAttachment.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TodoAttachment(String r110, String r111, String r112, Type r113, String r114, Integer r115, ImageSet r116, String r210, Boolean r211, Long r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public TodoAttachment(String r100, String r101, String r102, Type r103, String r104, Integer r105, ImageSet r106, String r107, Boolean r110, Long r111, ByteString r112) {
        super(ADAPTER, r112);
        this.file_token = r100;
        this.file_size = r101;
        this.name = r102;
        this.type = r103;
        this.uploader_user_id = r104;
        this.position = r105;
        this.image_set = r106;
        this.guid = r107;
        this.can_delete = r110;
        this.upload_milli_time = r111;
    }
}
