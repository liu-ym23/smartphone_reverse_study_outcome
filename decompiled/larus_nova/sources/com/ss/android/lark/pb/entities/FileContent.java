package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
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

/* JADX INFO: loaded from: classes37.dex */
public final class FileContent extends com.squareup.wire.Message<FileContent, Builder> {
    public static final ProtoAdapter<FileContent> ADAPTER = null;
    public static final String DEFAULT_COMPRESSED_FOLDER = "";
    public static final String DEFAULT_FS_UNIT = "";
    public static final Boolean DEFAULT_IS_DESTROYED = null;
    public static final Boolean DEFAULT_IS_FOLDER = null;
    public static final String DEFAULT_KEY = "";
    public static final Long DEFAULT_LAST_UPDATE_TIME_MS = null;
    public static final Long DEFAULT_LAST_UPDATE_USER_ID = null;
    public static final String DEFAULT_MIME = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_NAME_SPACE = "";
    public static final Long DEFAULT_SCENE_ID = null;
    public static final Long DEFAULT_SIZE = null;
    private static final long serialVersionUID = 0;
    public final Map<String, ResourceCleanScene> mclean_resource_key_scene;
    public final List<String> mclean_resource_keys;
    public final String mcompressed_folder;
    public final FileAbility mfile_ability;
    public final FilePermission mfile_permission;
    public final FilePreviewStage mfile_preview_stage;
    public final String mfs_unit;
    public final Boolean mis_destroyed;
    public final Boolean mis_folder;
    public final String mkey;
    public final LANTransExtra mlan_trans_extra;
    public final Long mlast_update_time_ms;
    public final Long mlast_update_user_id;
    public final String mmime;
    public final String mname;
    public final String mname_space;
    public final List<String> mrisk_object_keys;
    public final Long mscene_id;
    public final Long msize;
    public final Source msource;
    public final TransExtra mtrans_extra;

    public static final class Builder extends com.squareup.wire.Message.Builder<FileContent, Builder> {
        public Map<String, ResourceCleanScene> mclean_resource_key_scene;
        public List<String> mclean_resource_keys;
        public String mcompressed_folder;
        public FileAbility mfile_ability;
        public FilePermission mfile_permission;
        public FilePreviewStage mfile_preview_stage;
        public String mfs_unit;
        public Boolean mis_destroyed;
        public Boolean mis_folder;
        public String mkey;
        public LANTransExtra mlan_trans_extra;
        public Long mlast_update_time_ms;
        public Long mlast_update_user_id;
        public String mmime;
        public String mname;
        public String mname_space;
        public List<String> mrisk_object_keys;
        public Long mscene_id;
        public Long msize;
        public Source msource;
        public TransExtra mtrans_extra;

        @Override // com.squareup.wire.Message.Builder
        public FileContent build() {
            return new FileContent(this.mkey, this.mname, this.msize, this.mmime, this.msource, this.mname_space, this.mfs_unit, this.mlan_trans_extra, this.mtrans_extra, this.mrisk_object_keys, this.mfile_ability, this.mfile_permission, this.mlast_update_user_id, this.mlast_update_time_ms, this.mcompressed_folder, this.mfile_preview_stage, this.mclean_resource_keys, this.mis_destroyed, this.mclean_resource_key_scene, this.mscene_id, this.mis_folder, super.buildUnknownFields());
        }

        public Builder() {
            this.mrisk_object_keys = Internal.newMutableList();
            this.mclean_resource_keys = Internal.newMutableList();
            this.mclean_resource_key_scene = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder clean_resource_key_scene(Map<String, ResourceCleanScene> r100) {
            Internal.checkElementsNotNull(r100);
            this.mclean_resource_key_scene = r100;
            return this;
        }

        public Builder clean_resource_keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mclean_resource_keys = r100;
            return this;
        }

        public Builder compressed_folder(String r100) {
            this.mcompressed_folder = r100;
            return this;
        }

        public Builder file_ability(FileAbility r100) {
            this.mfile_ability = r100;
            return this;
        }

        public Builder file_permission(FilePermission r100) {
            this.mfile_permission = r100;
            return this;
        }

        public Builder file_preview_stage(FilePreviewStage r100) {
            this.mfile_preview_stage = r100;
            return this;
        }

        public Builder fs_unit(String r100) {
            this.mfs_unit = r100;
            return this;
        }

        public Builder is_destroyed(Boolean r100) {
            this.mis_destroyed = r100;
            return this;
        }

        public Builder is_folder(Boolean r100) {
            this.mis_folder = r100;
            return this;
        }

        public Builder key(String r100) {
            this.mkey = r100;
            return this;
        }

        public Builder lan_trans_extra(LANTransExtra r100) {
            this.mlan_trans_extra = r100;
            return this;
        }

        public Builder last_update_time_ms(Long r100) {
            this.mlast_update_time_ms = r100;
            return this;
        }

        public Builder last_update_user_id(Long r100) {
            this.mlast_update_user_id = r100;
            return this;
        }

        public Builder mime(String r100) {
            this.mmime = r100;
            return this;
        }

        public Builder name(String r100) {
            this.mname = r100;
            return this;
        }

        public Builder name_space(String r100) {
            this.mname_space = r100;
            return this;
        }

        public Builder risk_object_keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mrisk_object_keys = r100;
            return this;
        }

        public Builder scene_id(Long r100) {
            this.mscene_id = r100;
            return this;
        }

        public Builder size(Long r100) {
            this.msize = r100;
            return this;
        }

        public Builder source(Source r100) {
            this.msource = r100;
            return this;
        }

        public Builder trans_extra(TransExtra r100) {
            this.mtrans_extra = r100;
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

    public static final class LANTransExtra extends com.squareup.wire.Message<LANTransExtra, Builder> {
        public static final ProtoAdapter<LANTransExtra> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final TransStatus mstatus;

        public static final class Builder extends com.squareup.wire.Message.Builder<LANTransExtra, Builder> {
            public TransStatus mstatus;

            @Override // com.squareup.wire.Message.Builder
            public LANTransExtra build() {
                return new LANTransExtra(this.mstatus, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder status(TransStatus r100) {
                this.mstatus = r100;
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
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L7;
                r101.mstatus = TransStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
                TransStatus r101 = r100.mstatus;
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
                TransStatus r102 = r101.mstatus;
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
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mstatus = this.mstatus;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return LANTransExtra.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public LANTransExtra(TransStatus r100) {
            this(r100, ByteString.EMPTY);
        }

        public LANTransExtra(TransStatus r100, ByteString r101) {
            super(ADAPTER, r101);
            this.mstatus = r100;
        }
    }

    public static final class ProtoAdapter_FileContent extends ProtoAdapter<FileContent> {
        private final ProtoAdapter<Map<String, ResourceCleanScene>> mclean_resource_key_scene;

        public ProtoAdapter_FileContent() {
            super(FieldEncoding.LENGTH_DELIMITED, FileContent.class);
            this.mclean_resource_key_scene = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ResourceCleanScene.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FileContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mkey = "";
            r101.mname = "";
            r101.msize = 0L;
            r101.mmime = "";
            r101.mname_space = "";
            r101.mfs_unit = "";
            r101.mlast_update_user_id = 0L;
            r101.mlast_update_time_ms = 0L;
            r101.mcompressed_folder = "";
            Boolean r102 = Boolean.FALSE;
            r101.mis_destroyed = r102;
            r101.mscene_id = 0L;
            r101.mis_folder = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L40;
            switch(r104) {
                case 1: goto L39;
                case 2: goto L38;
                case 3: goto L37;
                case 4: goto L36;
                case 5: goto L42;
                case 6: goto L31;
                case 7: goto L30;
                case 8: goto L29;
                case 9: goto L28;
                case 10: goto L27;
                case 11: goto L46;
                case 12: goto L48;
                case 13: goto L18;
                case 14: goto L17;
                case 15: goto L16;
                case 16: goto L44;
                case 17: goto L11;
                case 18: goto L10;
                case 19: goto L9;
                case 20: goto L8;
                case 21: goto L7;
                default: goto L6;
            };
        L42:
            r101.msource = Source.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L34
        L34:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L44:
            r101.mfile_preview_stage = FilePreviewStage.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L46:
            r101.mfile_ability = FileAbility.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L48:
            r101.mfile_permission = FilePermission.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mis_folder = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.mscene_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L9:
            r101.mclean_resource_key_scene.putAll(this.mclean_resource_key_scene.decode(r100));
            goto L3
        L10:
            r101.mis_destroyed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.mclean_resource_keys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L16:
            r101.mcompressed_folder = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.mlast_update_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L18:
            r101.mlast_update_user_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L27:
            r101.mrisk_object_keys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L28:
            r101.mtrans_extra = TransExtra.ADAPTER.decode(r100);
            goto L3
        L29:
            r101.mlan_trans_extra = LANTransExtra.ADAPTER.decode(r100);
            goto L3
        L30:
            r101.mfs_unit = ProtoAdapter.STRING.decode(r100);
            goto L3
        L31:
            r101.mname_space = ProtoAdapter.STRING.decode(r100);
            goto L3
        L36:
            r101.mmime = ProtoAdapter.STRING.decode(r100);
            goto L3
        L37:
            r101.msize = ProtoAdapter.INT64.decode(r100);
            goto L3
        L38:
            r101.mname = ProtoAdapter.STRING.decode(r100);
            goto L3
        L39:
            r101.mkey = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L40:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FileContent r100) {
            String r101 = r100.mkey;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mname;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.msize;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mmime;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Source r113 = r100.msource;
            if (r113 == null) goto L21;
            int r114 = Source.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.mname_space;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.mfs_unit;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            LANTransExtra r122 = r100.mlan_trans_extra;
            if (r122 == null) goto L33;
            int r123 = LANTransExtra.ADAPTER.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            TransExtra r125 = r100.mtrans_extra;
            if (r125 == null) goto L37;
            int r126 = TransExtra.ADAPTER.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            ProtoAdapter<String> r128 = ProtoAdapter.STRING;
            int r129 = r127 + r128.asRepeated().encodedSizeWithTag(10, r100.mrisk_object_keys);
            FileAbility r130 = r100.mfile_ability;
            if (r130 == null) goto L41;
            int r131 = FileAbility.ADAPTER.encodedSizeWithTag(11, r130);
        L42:
            int r132 = r129 + r131;
            FilePermission r133 = r100.mfile_permission;
            if (r133 == null) goto L45;
            int r134 = FilePermission.ADAPTER.encodedSizeWithTag(12, r133);
        L46:
            int r135 = r132 + r134;
            Long r136 = r100.mlast_update_user_id;
            if (r136 == null) goto L49;
            int r137 = ProtoAdapter.INT64.encodedSizeWithTag(13, r136);
        L50:
            int r138 = r135 + r137;
            Long r139 = r100.mlast_update_time_ms;
            if (r139 == null) goto L53;
            int r140 = ProtoAdapter.INT64.encodedSizeWithTag(14, r139);
        L54:
            int r141 = r138 + r140;
            String r142 = r100.mcompressed_folder;
            if (r142 == null) goto L57;
            int r143 = r128.encodedSizeWithTag(15, r142);
        L58:
            int r144 = r141 + r143;
            FilePreviewStage r145 = r100.mfile_preview_stage;
            if (r145 == null) goto L61;
            int r146 = FilePreviewStage.ADAPTER.encodedSizeWithTag(16, r145);
        L62:
            int r147 = (r144 + r146) + r128.asRepeated().encodedSizeWithTag(17, r100.mclean_resource_keys);
            Boolean r148 = r100.mis_destroyed;
            if (r148 == null) goto L65;
            int r149 = ProtoAdapter.BOOL.encodedSizeWithTag(18, r148);
        L66:
            int r150 = (r147 + r149) + this.mclean_resource_key_scene.encodedSizeWithTag(19, r100.mclean_resource_key_scene);
            Long r151 = r100.mscene_id;
            if (r151 == null) goto L69;
            int r152 = ProtoAdapter.INT64.encodedSizeWithTag(20, r151);
        L70:
            int r153 = r150 + r152;
            Boolean r154 = r100.mis_folder;
            if (r154 == null) goto L74;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(21, r154);
        L74:
            return (r153 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ FileContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FileContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FileContent r101) throws IOException {
            String r102 = r101.mkey;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mname;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.msize;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mmime;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Source r106 = r101.msource;
            if (r106 == null) goto L17;
            Source.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.mname_space;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.mfs_unit;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            LANTransExtra r109 = r101.mlan_trans_extra;
            if (r109 == null) goto L26;
            LANTransExtra.ADAPTER.encodeWithTag(r100, 8, r109);
        L26:
            TransExtra r110 = r101.mtrans_extra;
            if (r110 == null) goto L29;
            TransExtra.ADAPTER.encodeWithTag(r100, 9, r110);
        L29:
            ProtoAdapter<String> r111 = ProtoAdapter.STRING;
            r111.asRepeated().encodeWithTag(r100, 10, r101.mrisk_object_keys);
            FileAbility r112 = r101.mfile_ability;
            if (r112 == null) goto L32;
            FileAbility.ADAPTER.encodeWithTag(r100, 11, r112);
        L32:
            FilePermission r113 = r101.mfile_permission;
            if (r113 == null) goto L35;
            FilePermission.ADAPTER.encodeWithTag(r100, 12, r113);
        L35:
            Long r114 = r101.mlast_update_user_id;
            if (r114 == null) goto L38;
            ProtoAdapter.INT64.encodeWithTag(r100, 13, r114);
        L38:
            Long r115 = r101.mlast_update_time_ms;
            if (r115 == null) goto L41;
            ProtoAdapter.INT64.encodeWithTag(r100, 14, r115);
        L41:
            String r116 = r101.mcompressed_folder;
            if (r116 == null) goto L44;
            r111.encodeWithTag(r100, 15, r116);
        L44:
            FilePreviewStage r117 = r101.mfile_preview_stage;
            if (r117 == null) goto L47;
            FilePreviewStage.ADAPTER.encodeWithTag(r100, 16, r117);
        L47:
            r111.asRepeated().encodeWithTag(r100, 17, r101.mclean_resource_keys);
            Boolean r118 = r101.mis_destroyed;
            if (r118 == null) goto L50;
            ProtoAdapter.BOOL.encodeWithTag(r100, 18, r118);
        L50:
            this.mclean_resource_key_scene.encodeWithTag(r100, 19, r101.mclean_resource_key_scene);
            Long r119 = r101.mscene_id;
            if (r119 == null) goto L53;
            ProtoAdapter.INT64.encodeWithTag(r100, 20, r119);
        L53:
            Boolean r120 = r101.mis_folder;
            if (r120 == null) goto L56;
            ProtoAdapter.BOOL.encodeWithTag(r100, 21, r120);
        L56:
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
        DEFAULT_LAST_UPDATE_USER_ID = 0L;
        DEFAULT_LAST_UPDATE_TIME_MS = 0L;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_DESTROYED = r100;
        DEFAULT_SCENE_ID = 0L;
        DEFAULT_IS_FOLDER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mkey = this.mkey;
        r100.mname = this.mname;
        r100.msize = this.msize;
        r100.mmime = this.mmime;
        r100.msource = this.msource;
        r100.mname_space = this.mname_space;
        r100.mfs_unit = this.mfs_unit;
        r100.mlan_trans_extra = this.mlan_trans_extra;
        r100.mtrans_extra = this.mtrans_extra;
        r100.mrisk_object_keys = Internal.copyOf("mrisk_object_keys", this.mrisk_object_keys);
        r100.mfile_ability = this.mfile_ability;
        r100.mfile_permission = this.mfile_permission;
        r100.mlast_update_user_id = this.mlast_update_user_id;
        r100.mlast_update_time_ms = this.mlast_update_time_ms;
        r100.mcompressed_folder = this.mcompressed_folder;
        r100.mfile_preview_stage = this.mfile_preview_stage;
        r100.mclean_resource_keys = Internal.copyOf("mclean_resource_keys", this.mclean_resource_keys);
        r100.mis_destroyed = this.mis_destroyed;
        r100.mclean_resource_key_scene = Internal.copyOf("mclean_resource_key_scene", this.mclean_resource_key_scene);
        r100.mscene_id = this.mscene_id;
        r100.mis_folder = this.mis_folder;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FileContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public FileContent(String r210, String r211, Long r212, String r213, Source r214, String r215, String r310, LANTransExtra r311, TransExtra r312, List<String> r313, FileAbility r314, FilePermission r315, Long r316, Long r317, String r318, FilePreviewStage r319, List<String> r410, Boolean r411, Map<String, ResourceCleanScene> r412, Long r413, Boolean r414) {
        this(r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, ByteString.EMPTY);
    }

    public FileContent(String r100, String r101, Long r102, String r103, Source r104, String r105, String r110, LANTransExtra r111, TransExtra r112, List<String> r113, FileAbility r114, FilePermission r115, Long r116, Long r117, String r118, FilePreviewStage r119, List<String> r210, Boolean r211, Map<String, ResourceCleanScene> r212, Long r213, Boolean r214, ByteString r215) {
        super(ADAPTER, r215);
        this.mkey = r100;
        this.mname = r101;
        this.msize = r102;
        this.mmime = r103;
        this.msource = r104;
        this.mname_space = r105;
        this.mfs_unit = r110;
        this.mlan_trans_extra = r111;
        this.mtrans_extra = r112;
        this.mrisk_object_keys = Internal.immutableCopyOf("mrisk_object_keys", r113);
        this.mfile_ability = r114;
        this.mfile_permission = r115;
        this.mlast_update_user_id = r116;
        this.mlast_update_time_ms = r117;
        this.mcompressed_folder = r118;
        this.mfile_preview_stage = r119;
        this.mclean_resource_keys = Internal.immutableCopyOf("mclean_resource_keys", r210);
        this.mis_destroyed = r211;
        this.mclean_resource_key_scene = Internal.immutableCopyOf("mclean_resource_key_scene", r212);
        this.mscene_id = r213;
        this.mis_folder = r214;
    }
}
