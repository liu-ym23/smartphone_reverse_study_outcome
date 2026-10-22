package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class FileContent extends Message<FileContent, Builder> {
    public static final ProtoAdapter<FileContent> ADAPTER = null;
    public static final FileAbility DEFAULT_FILE_ABILITY = null;
    public static final FilePermission DEFAULT_FILE_PERMISSION = null;
    public static final String DEFAULT_FS_UNIT = "";
    public static final Boolean DEFAULT_IS_DESTROYED = null;
    public static final String DEFAULT_KEY = "";
    public static final Long DEFAULT_LAST_UPDATE_TIME_MS = null;
    public static final Long DEFAULT_LAST_UPDATE_USER_ID = null;
    public static final String DEFAULT_MIME = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_NAME_SPACE = "";
    public static final Long DEFAULT_SCENE_ID = null;
    public static final Long DEFAULT_SIZE = null;
    public static final Source DEFAULT_SOURCE = null;
    private static final long serialVersionUID = 0;
    public final FileAbility file_ability;
    public final FilePermission file_permission;
    public final String fs_unit;
    public final Boolean is_destroyed;
    public final String key;
    public final LANTransExtra lan_trans_extra;
    public final Long last_update_time_ms;
    public final Long last_update_user_id;
    public final String mime;
    public final String name;
    public final String name_space;
    public final List<String> risk_object_keys;
    public final Long scene_id;
    public final Long size;
    public final Source source;
    public final TransExtra trans_extra;

    public static final class Builder extends Message.Builder<FileContent, Builder> {
        public FileAbility file_ability;
        public FilePermission file_permission;
        public String fs_unit;
        public Boolean is_destroyed;
        public String key;
        public LANTransExtra lan_trans_extra;
        public Long last_update_time_ms;
        public Long last_update_user_id;
        public String mime;
        public String name;
        public String name_space;
        public List<String> risk_object_keys;
        public Long scene_id;
        public Long size;
        public Source source;
        public TransExtra trans_extra;

        @Override // com.squareup.wire.Message.Builder
        public FileContent build() {
            return new FileContent(this.key, this.name, this.size, this.mime, this.source, this.name_space, this.fs_unit, this.lan_trans_extra, this.trans_extra, this.risk_object_keys, this.file_ability, this.file_permission, this.last_update_user_id, this.last_update_time_ms, this.is_destroyed, this.scene_id, super.buildUnknownFields());
        }

        public Builder() {
            this.risk_object_keys = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder file_ability(FileAbility r100) {
            this.file_ability = r100;
            return this;
        }

        public Builder file_permission(FilePermission r100) {
            this.file_permission = r100;
            return this;
        }

        public Builder fs_unit(String r100) {
            this.fs_unit = r100;
            return this;
        }

        public Builder is_destroyed(Boolean r100) {
            this.is_destroyed = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder lan_trans_extra(LANTransExtra r100) {
            this.lan_trans_extra = r100;
            return this;
        }

        public Builder last_update_time_ms(Long r100) {
            this.last_update_time_ms = r100;
            return this;
        }

        public Builder last_update_user_id(Long r100) {
            this.last_update_user_id = r100;
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

        public Builder name_space(String r100) {
            this.name_space = r100;
            return this;
        }

        public Builder risk_object_keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.risk_object_keys = r100;
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

        public Builder trans_extra(TransExtra r100) {
            this.trans_extra = r100;
            return this;
        }
    }

    public static final enum FileAbility extends Enum<FileAbility> implements WireEnum {
        private static final /* synthetic */ FileAbility[] $VALUES = null;
        public static final ProtoAdapter<FileAbility> ADAPTER = null;
        public static final FileAbility NOT_SUPPORT_PREVIEW = null;
        public static final FileAbility SUPPORT_EDIT = null;
        public static final FileAbility SUPPORT_PREVIEW = null;
        public static final FileAbility UNKNOWN_SUPPORT_STATE = null;
        private final int value;

        static {
            FileAbility r100 = new FileAbility("UNKNOWN_SUPPORT_STATE", 0, 0);
            UNKNOWN_SUPPORT_STATE = r100;
            FileAbility r101 = new FileAbility("SUPPORT_EDIT", 1, 1);
            SUPPORT_EDIT = r101;
            FileAbility r102 = new FileAbility("SUPPORT_PREVIEW", 2, 2);
            SUPPORT_PREVIEW = r102;
            FileAbility r103 = new FileAbility("NOT_SUPPORT_PREVIEW", 3, 3);
            NOT_SUPPORT_PREVIEW = r103;
            $VALUES = new FileAbility[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(FileAbility.class);
        }

        public static FileAbility[] values() {
            return (FileAbility[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static FileAbility fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return NOT_SUPPORT_PREVIEW;
        L14:
            return SUPPORT_PREVIEW;
        L16:
            return SUPPORT_EDIT;
        L18:
            return UNKNOWN_SUPPORT_STATE;
        }

        public static FileAbility valueOf(String r100) {
            return (FileAbility) a.a(FileAbility.class, r100);
        }

        private FileAbility(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum FilePermission extends Enum<FilePermission> implements WireEnum {
        private static final /* synthetic */ FilePermission[] $VALUES = null;
        public static final ProtoAdapter<FilePermission> ADAPTER = null;
        public static final FilePermission CAN_EDIT = null;
        public static final FilePermission CAN_PREVIEW = null;
        public static final FilePermission UNKNOWN_CAN_STATE = null;
        private final int value;

        static {
            FilePermission r100 = new FilePermission("UNKNOWN_CAN_STATE", 0, 0);
            UNKNOWN_CAN_STATE = r100;
            FilePermission r101 = new FilePermission("CAN_EDIT", 1, 1);
            CAN_EDIT = r101;
            FilePermission r102 = new FilePermission("CAN_PREVIEW", 2, 2);
            CAN_PREVIEW = r102;
            $VALUES = new FilePermission[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(FilePermission.class);
        }

        public static FilePermission[] values() {
            return (FilePermission[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static FilePermission fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return CAN_PREVIEW;
        L12:
            return CAN_EDIT;
        L14:
            return UNKNOWN_CAN_STATE;
        }

        public static FilePermission valueOf(String r100) {
            return (FilePermission) a.a(FilePermission.class, r100);
        }

        private FilePermission(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class LANTransExtra extends Message<LANTransExtra, Builder> {
        public static final ProtoAdapter<LANTransExtra> ADAPTER = null;
        public static final TransStatus DEFAULT_STATUS = null;
        private static final long serialVersionUID = 0;
        public final TransStatus status;

        public static final class Builder extends Message.Builder<LANTransExtra, Builder> {
            public TransStatus status;

            @Override // com.squareup.wire.Message.Builder
            public LANTransExtra build() {
                return new LANTransExtra(this.status, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder status(TransStatus r100) {
                this.status = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_LANTransExtra extends ProtoAdapter<LANTransExtra> {
            public ProtoAdapter_LANTransExtra() {
                super(FieldEncoding.LENGTH_DELIMITED, LANTransExtra.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LANTransExtra decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.status = TransStatus.PENDING;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L7;
                r101.status = TransStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(LANTransExtra r100) {
                TransStatus r101 = r100.status;
                if (r101 == null) goto L5;
                int r102 = TransStatus.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ LANTransExtra decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(LANTransExtra r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, LANTransExtra r101) throws IOException {
                TransStatus r102 = r101.status;
                if (r102 == null) goto L5;
                TransStatus.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LANTransExtra r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum TransStatus extends Enum<TransStatus> implements WireEnum {
            private static final /* synthetic */ TransStatus[] $VALUES = null;
            public static final TransStatus ABORT_BY_RECEIVER = null;
            public static final TransStatus ABORT_BY_SENDER = null;
            public static final TransStatus ACCEPT = null;
            public static final ProtoAdapter<TransStatus> ADAPTER = null;
            public static final TransStatus CANCEL = null;
            public static final TransStatus DONE = null;
            public static final TransStatus OFFLINE_MODE = null;
            public static final TransStatus PENDING = null;
            public static final TransStatus REFUSE = null;
            private final int value;

            static {
                TransStatus r100 = new TransStatus("PENDING", 0, 0);
                PENDING = r100;
                TransStatus r101 = new TransStatus("ACCEPT", 1, 1);
                ACCEPT = r101;
                TransStatus r102 = new TransStatus("REFUSE", 2, 2);
                REFUSE = r102;
                TransStatus r103 = new TransStatus("CANCEL", 3, 3);
                CANCEL = r103;
                TransStatus r104 = new TransStatus("ABORT_BY_SENDER", 4, 4);
                ABORT_BY_SENDER = r104;
                TransStatus r105 = new TransStatus("ABORT_BY_RECEIVER", 5, 5);
                ABORT_BY_RECEIVER = r105;
                TransStatus r110 = new TransStatus("DONE", 6, 6);
                DONE = r110;
                TransStatus r111 = new TransStatus("OFFLINE_MODE", 7, 7);
                OFFLINE_MODE = r111;
                $VALUES = new TransStatus[]{r100, r101, r102, r103, r104, r105, r110, r111};
                ADAPTER = ProtoAdapter.newEnumAdapter(TransStatus.class);
            }

            public static TransStatus[] values() {
                return (TransStatus[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static TransStatus fromValue(int r100) {
                switch(r100) {
                    case 0: goto L20;
                    case 1: goto L18;
                    case 2: goto L16;
                    case 3: goto L14;
                    case 4: goto L12;
                    case 5: goto L10;
                    case 6: goto L8;
                    case 7: goto L6;
                    default: goto L3;
                };
            L3:
                return null;
            L6:
                return OFFLINE_MODE;
            L8:
                return DONE;
            L10:
                return ABORT_BY_RECEIVER;
            L12:
                return ABORT_BY_SENDER;
            L14:
                return CANCEL;
            L16:
                return REFUSE;
            L18:
                return ACCEPT;
            L20:
                return PENDING;
            }

            public static TransStatus valueOf(String r100) {
                return (TransStatus) a.a(TransStatus.class, r100);
            }

            private TransStatus(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_LANTransExtra();
            DEFAULT_STATUS = TransStatus.PENDING;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.status = this.status;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return LANTransExtra.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public LANTransExtra(TransStatus r100) {
            this(r100, ByteString.EMPTY);
        }

        public LANTransExtra(TransStatus r100, ByteString r101) {
            super(ADAPTER, r101);
            this.status = r100;
        }
    }

    public static final class ProtoAdapter_FileContent extends ProtoAdapter<FileContent> {
        public ProtoAdapter_FileContent() {
            super(FieldEncoding.LENGTH_DELIMITED, FileContent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FileContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key = "";
            r101.name = "";
            r101.size = 0L;
            r101.mime = "";
            r101.source = Source.UNKNOWN;
            r101.name_space = "";
            r101.fs_unit = "";
            r101.file_ability = FileAbility.UNKNOWN_SUPPORT_STATE;
            r101.file_permission = FilePermission.UNKNOWN_CAN_STATE;
            r101.last_update_user_id = 0L;
            r101.last_update_time_ms = 0L;
            r101.is_destroyed = Boolean.FALSE;
            r101.scene_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L34;
            if (r103 != 20) goto L7;
            r101.scene_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L7:
            switch(r103) {
                case 1: goto L32;
                case 2: goto L31;
                case 3: goto L30;
                case 4: goto L29;
                case 5: goto L36;
                case 6: goto L24;
                case 7: goto L23;
                case 8: goto L22;
                case 9: goto L21;
                case 10: goto L20;
                case 11: goto L40;
                case 12: goto L38;
                case 13: goto L11;
                case 14: goto L10;
                case 15: goto L9;
                default: goto L8;
            };
        L36:
            r101.source = Source.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L27
        L27:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L38:
            r101.file_permission = FilePermission.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L40:
            r101.file_ability = FileAbility.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            r101.is_destroyed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.last_update_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            r101.last_update_user_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L20:
            r101.risk_object_keys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L21:
            r101.trans_extra = TransExtra.ADAPTER.decode(r100);
            goto L3
        L22:
            r101.lan_trans_extra = LANTransExtra.ADAPTER.decode(r100);
            goto L3
        L23:
            r101.fs_unit = ProtoAdapter.STRING.decode(r100);
            goto L3
        L24:
            r101.name_space = ProtoAdapter.STRING.decode(r100);
            goto L3
        L29:
            r101.mime = ProtoAdapter.STRING.decode(r100);
            goto L3
        L30:
            r101.size = ProtoAdapter.INT64.decode(r100);
            goto L3
        L31:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L32:
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L34:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FileContent r100) {
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
            String r116 = r100.name_space;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.fs_unit;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            LANTransExtra r122 = r100.lan_trans_extra;
            if (r122 == null) goto L33;
            int r123 = LANTransExtra.ADAPTER.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            TransExtra r125 = r100.trans_extra;
            if (r125 == null) goto L37;
            int r126 = TransExtra.ADAPTER.encodedSizeWithTag(9, r125);
        L38:
            int r127 = (r124 + r126) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(10, r100.risk_object_keys);
            FileAbility r128 = r100.file_ability;
            if (r128 == null) goto L41;
            int r129 = FileAbility.ADAPTER.encodedSizeWithTag(11, r128);
        L42:
            int r130 = r127 + r129;
            FilePermission r131 = r100.file_permission;
            if (r131 == null) goto L45;
            int r132 = FilePermission.ADAPTER.encodedSizeWithTag(12, r131);
        L46:
            int r133 = r130 + r132;
            Long r134 = r100.last_update_user_id;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.INT64.encodedSizeWithTag(13, r134);
        L50:
            int r136 = r133 + r135;
            Long r137 = r100.last_update_time_ms;
            if (r137 == null) goto L53;
            int r138 = ProtoAdapter.INT64.encodedSizeWithTag(14, r137);
        L54:
            int r139 = r136 + r138;
            Boolean r140 = r100.is_destroyed;
            if (r140 == null) goto L57;
            int r141 = ProtoAdapter.BOOL.encodedSizeWithTag(15, r140);
        L58:
            int r142 = r139 + r141;
            Long r143 = r100.scene_id;
            if (r143 == null) goto L62;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(20, r143);
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
        public /* bridge */ /* synthetic */ FileContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FileContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FileContent r101) throws IOException {
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
            String r107 = r101.name_space;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.fs_unit;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            LANTransExtra r109 = r101.lan_trans_extra;
            if (r109 == null) goto L26;
            LANTransExtra.ADAPTER.encodeWithTag(r100, 8, r109);
        L26:
            TransExtra r110 = r101.trans_extra;
            if (r110 == null) goto L29;
            TransExtra.ADAPTER.encodeWithTag(r100, 9, r110);
        L29:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 10, r101.risk_object_keys);
            FileAbility r111 = r101.file_ability;
            if (r111 == null) goto L32;
            FileAbility.ADAPTER.encodeWithTag(r100, 11, r111);
        L32:
            FilePermission r112 = r101.file_permission;
            if (r112 == null) goto L35;
            FilePermission.ADAPTER.encodeWithTag(r100, 12, r112);
        L35:
            Long r113 = r101.last_update_user_id;
            if (r113 == null) goto L38;
            ProtoAdapter.INT64.encodeWithTag(r100, 13, r113);
        L38:
            Long r114 = r101.last_update_time_ms;
            if (r114 == null) goto L41;
            ProtoAdapter.INT64.encodeWithTag(r100, 14, r114);
        L41:
            Boolean r115 = r101.is_destroyed;
            if (r115 == null) goto L44;
            ProtoAdapter.BOOL.encodeWithTag(r100, 15, r115);
        L44:
            Long r116 = r101.scene_id;
            if (r116 == null) goto L47;
            ProtoAdapter.INT64.encodeWithTag(r100, 20, r116);
        L47:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FileContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Source extends Enum<Source> implements WireEnum {
        private static final /* synthetic */ Source[] $VALUES = null;
        public static final ProtoAdapter<Source> ADAPTER = null;
        public static final Source LAN_TRANS = null;
        public static final Source NUT_STORE = null;
        public static final Source UNKNOWN = null;
        private final int value;

        static {
            Source r100 = new Source("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Source r101 = new Source("NUT_STORE", 1, 2);
            NUT_STORE = r101;
            Source r102 = new Source("LAN_TRANS", 2, 3);
            LAN_TRANS = r102;
            $VALUES = new Source[]{r100, r101, r102};
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
            if (r100 == 0) goto L14;
            if (r100 == 2) goto L12;
            if (r100 == 3) goto L10;
            return null;
        L10:
            return LAN_TRANS;
        L12:
            return NUT_STORE;
        L14:
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
        ADAPTER = new ProtoAdapter_FileContent();
        DEFAULT_SIZE = 0L;
        DEFAULT_SOURCE = Source.UNKNOWN;
        DEFAULT_FILE_ABILITY = FileAbility.UNKNOWN_SUPPORT_STATE;
        DEFAULT_FILE_PERMISSION = FilePermission.UNKNOWN_CAN_STATE;
        DEFAULT_LAST_UPDATE_USER_ID = 0L;
        DEFAULT_LAST_UPDATE_TIME_MS = 0L;
        DEFAULT_IS_DESTROYED = Boolean.FALSE;
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
        r100.name_space = this.name_space;
        r100.fs_unit = this.fs_unit;
        r100.lan_trans_extra = this.lan_trans_extra;
        r100.trans_extra = this.trans_extra;
        r100.risk_object_keys = Internal.copyOf("risk_object_keys", this.risk_object_keys);
        r100.file_ability = this.file_ability;
        r100.file_permission = this.file_permission;
        r100.last_update_user_id = this.last_update_user_id;
        r100.last_update_time_ms = this.last_update_time_ms;
        r100.is_destroyed = this.is_destroyed;
        r100.scene_id = this.scene_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FileContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FileContent(String r110, String r210, Long r211, String r212, Source r213, String r214, String r215, LANTransExtra r216, TransExtra r217, List<String> r218, FileAbility r219, FilePermission r310, Long r311, Long r312, Boolean r313, Long r314) {
        this(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, ByteString.EMPTY);
    }

    public FileContent(String r100, String r101, Long r102, String r103, Source r104, String r105, String r110, LANTransExtra r111, TransExtra r112, List<String> r113, FileAbility r114, FilePermission r115, Long r116, Long r117, Boolean r118, Long r119, ByteString r210) {
        super(ADAPTER, r210);
        this.key = r100;
        this.name = r101;
        this.size = r102;
        this.mime = r103;
        this.source = r104;
        this.name_space = r105;
        this.fs_unit = r110;
        this.lan_trans_extra = r111;
        this.trans_extra = r112;
        this.risk_object_keys = Internal.immutableCopyOf("risk_object_keys", r113);
        this.file_ability = r114;
        this.file_permission = r115;
        this.last_update_user_id = r116;
        this.last_update_time_ms = r117;
        this.is_destroyed = r118;
        this.scene_id = r119;
    }
}
