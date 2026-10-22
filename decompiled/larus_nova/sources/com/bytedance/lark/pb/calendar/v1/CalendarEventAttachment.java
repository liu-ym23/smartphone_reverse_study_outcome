package com.bytedance.lark.pb.calendar.v1;

import com.obric.miniapp.alarm.AccountType;
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
public final class CalendarEventAttachment extends Message<CalendarEventAttachment, Builder> {
    public static final ProtoAdapter<CalendarEventAttachment> ADAPTER = null;
    public static final Long DEFAULT_EXPIRE_TIME = null;
    public static final String DEFAULT_FILE_SIZE = "";
    public static final String DEFAULT_FILE_TOKEN = "";
    public static final String DEFAULT_GOOGLE_DRIVE_LINK = "";
    public static final Boolean DEFAULT_IS_DELETED = null;
    public static final String DEFAULT_LOCAL_PATH = "";
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_POSITION = null;
    public static final Type DEFAULT_TYPE = null;
    public static final String DEFAULT_UPLOADER_USER_ID = "";
    public static final String DEFAULT_URL_LINK = "";
    private static final long serialVersionUID = 0;
    public final Long expire_time;
    public final String file_size;
    public final String file_token;
    public final String google_drive_link;
    public final Boolean is_deleted;
    public final String local_path;
    public final String name;
    public final Integer position;
    public final Type type;
    public final String uploader_user_id;
    public final String url_link;

    public static final class Builder extends Message.Builder<CalendarEventAttachment, Builder> {
        public Long expire_time;
        public String file_size;
        public String file_token;
        public String google_drive_link;
        public Boolean is_deleted;
        public String local_path;
        public String name;
        public Integer position;
        public Type type;
        public String uploader_user_id;
        public String url_link;

        @Override // com.squareup.wire.Message.Builder
        public CalendarEventAttachment build() {
            return new CalendarEventAttachment(this.file_token, this.file_size, this.name, this.type, this.local_path, this.uploader_user_id, this.is_deleted, this.position, this.expire_time, this.google_drive_link, this.url_link, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder expire_time(Long r100) {
            this.expire_time = r100;
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

        public Builder google_drive_link(String r100) {
            this.google_drive_link = r100;
            return this;
        }

        public Builder is_deleted(Boolean r100) {
            this.is_deleted = r100;
            return this;
        }

        public Builder local_path(String r100) {
            this.local_path = r100;
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

        public Builder uploader_user_id(String r100) {
            this.uploader_user_id = r100;
            return this;
        }

        public Builder url_link(String r100) {
            this.url_link = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CalendarEventAttachment extends ProtoAdapter<CalendarEventAttachment> {
        public ProtoAdapter_CalendarEventAttachment() {
            super(FieldEncoding.LENGTH_DELIMITED, CalendarEventAttachment.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CalendarEventAttachment decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.file_token = "";
            r101.file_size = "";
            r101.name = "";
            r101.type = Type.UNKNOWN;
            r101.local_path = "";
            r101.uploader_user_id = "";
            r101.is_deleted = Boolean.FALSE;
            r101.position = 0;
            r101.expire_time = 0L;
            r101.google_drive_link = "";
            r101.url_link = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            switch(r103) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L23;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L23:
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.url_link = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.google_drive_link = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.expire_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            r101.position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            r101.is_deleted = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.uploader_user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.local_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.file_size = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.file_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CalendarEventAttachment r100) {
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
            String r113 = r100.local_path;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.uploader_user_id;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Boolean r119 = r100.is_deleted;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Integer r122 = r100.position;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.INT32.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Long r125 = r100.expire_time;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.INT64.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            String r128 = r100.google_drive_link;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.STRING.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            String r131 = r100.url_link;
            if (r131 == null) goto L46;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(11, r131);
        L46:
            return (r130 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ CalendarEventAttachment decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CalendarEventAttachment r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CalendarEventAttachment r101) throws IOException {
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
            String r106 = r101.local_path;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.uploader_user_id;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            Boolean r108 = r101.is_deleted;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
        L23:
            Integer r109 = r101.position;
            if (r109 == null) goto L26;
            ProtoAdapter.INT32.encodeWithTag(r100, 8, r109);
        L26:
            Long r110 = r101.expire_time;
            if (r110 == null) goto L29;
            ProtoAdapter.INT64.encodeWithTag(r100, 9, r110);
        L29:
            String r111 = r101.google_drive_link;
            if (r111 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 10, r111);
        L32:
            String r112 = r101.url_link;
            if (r112 == null) goto L35;
            ProtoAdapter.STRING.encodeWithTag(r100, 11, r112);
        L35:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CalendarEventAttachment r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type GOOGLE_DRIVE = null;
        public static final Type LARGE_ATTACHMENT = null;
        public static final Type LOCAL = null;
        public static final Type UNKNOWN = null;
        public static final Type URL = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type(AccountType.LOCAL, 1, 1);
            LOCAL = r101;
            Type r102 = new Type("LARGE_ATTACHMENT", 2, 3);
            LARGE_ATTACHMENT = r102;
            Type r103 = new Type("GOOGLE_DRIVE", 3, 4);
            GOOGLE_DRIVE = r103;
            Type r104 = new Type("URL", 4, 5);
            URL = r104;
            $VALUES = new Type[]{r100, r101, r102, r103, r104};
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
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 3) goto L18;
            if (r100 == 4) goto L16;
            if (r100 == 5) goto L14;
            return null;
        L14:
            return URL;
        L16:
            return GOOGLE_DRIVE;
        L18:
            return LARGE_ATTACHMENT;
        L20:
            return LOCAL;
        L22:
            return UNKNOWN;
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
        ADAPTER = new ProtoAdapter_CalendarEventAttachment();
        DEFAULT_TYPE = Type.UNKNOWN;
        DEFAULT_IS_DELETED = Boolean.FALSE;
        DEFAULT_POSITION = 0;
        DEFAULT_EXPIRE_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.file_token = this.file_token;
        r100.file_size = this.file_size;
        r100.name = this.name;
        r100.type = this.type;
        r100.local_path = this.local_path;
        r100.uploader_user_id = this.uploader_user_id;
        r100.is_deleted = this.is_deleted;
        r100.position = this.position;
        r100.expire_time = this.expire_time;
        r100.google_drive_link = this.google_drive_link;
        r100.url_link = this.url_link;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CalendarEventAttachment.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CalendarEventAttachment(String r110, String r111, String r112, Type r113, String r114, String r115, Boolean r210, Integer r211, Long r212, String r213, String r214) {
        this(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, ByteString.EMPTY);
    }

    public CalendarEventAttachment(String r100, String r101, String r102, Type r103, String r104, String r105, Boolean r106, Integer r107, Long r110, String r111, String r112, ByteString r113) {
        super(ADAPTER, r113);
        this.file_token = r100;
        this.file_size = r101;
        this.name = r102;
        this.type = r103;
        this.local_path = r104;
        this.uploader_user_id = r105;
        this.is_deleted = r106;
        this.position = r107;
        this.expire_time = r110;
        this.google_drive_link = r111;
        this.url_link = r112;
    }
}
