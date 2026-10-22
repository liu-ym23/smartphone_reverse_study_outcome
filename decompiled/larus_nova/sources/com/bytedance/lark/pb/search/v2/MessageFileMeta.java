package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class MessageFileMeta extends Message<MessageFileMeta, Builder> {
    public static final ProtoAdapter<MessageFileMeta> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_FILE_HIERARCHY = "";
    public static final String DEFAULT_FILE_PATH = "";
    public static final FileType DEFAULT_FILE_TYPE = null;
    public static final String DEFAULT_FROM_ID = "";
    public static final String DEFAULT_FROM_TENANT_ID = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_DESTROYED = null;
    public static final Boolean DEFAULT_IS_FILE_ACCESS_AUTH = null;
    public static final Boolean DEFAULT_IS_INNER_FILE = null;
    public static final Boolean DEFAULT_IS_RESTRICTED = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final Integer DEFAULT_MESSAGE_POSITION = null;
    public static final String DEFAULT_MESSAGE_SENDER_NAME = "";
    public static final Integer DEFAULT_ROOT_MESSAGE_POSITION = null;
    public static final Long DEFAULT_SCENE_ID = null;
    public static final Integer DEFAULT_THREAD_CHAT_POSITION = null;
    public static final String DEFAULT_THREAD_ID = "";
    public static final com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType DEFAULT_THREAD_MESSAGE_TYPE = null;
    public static final Integer DEFAULT_THREAD_POSITION = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final Long create_time;
    public final Map<Integer, MessageBehavior> disabled_action;
    public final String file_hierarchy;
    public final FileContent file_meta;
    public final String file_path;
    public final FileType file_type;
    public final String from_id;
    public final String from_tenant_id;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253719id;
    public final Boolean is_destroyed;
    public final Boolean is_file_access_auth;
    public final Boolean is_inner_file;
    public final Boolean is_restricted;
    public final String message_id;
    public final Integer message_position;
    public final String message_sender_name;
    public final Integer root_message_position;
    public final Long scene_id;
    public final Integer thread_chat_position;
    public final String thread_id;
    public final com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType thread_message_type;
    public final Integer thread_position;

    public static final class Builder extends Message.Builder<MessageFileMeta, Builder> {
        public String chat_id;
        public Long create_time;
        public Map<Integer, MessageBehavior> disabled_action;
        public String file_hierarchy;
        public FileContent file_meta;
        public String file_path;
        public FileType file_type;
        public String from_id;
        public String from_tenant_id;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253720id;
        public Boolean is_destroyed;
        public Boolean is_file_access_auth;
        public Boolean is_inner_file;
        public Boolean is_restricted;
        public String message_id;
        public Integer message_position;
        public String message_sender_name;
        public Integer root_message_position;
        public Long scene_id;
        public Integer thread_chat_position;
        public String thread_id;
        public com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType thread_message_type;
        public Integer thread_position;

        @Override // com.squareup.wire.Message.Builder
        public MessageFileMeta build() {
            String r100 = this.f253720id;
            if (r100 == null) goto L7;
            return new MessageFileMeta(this.f253720id, this.file_type, this.create_time, this.message_id, this.message_position, this.chat_id, this.from_id, this.file_meta, this.file_hierarchy, this.is_inner_file, this.file_path, this.thread_id, this.thread_position, this.thread_chat_position, this.is_file_access_auth, this.thread_message_type, this.root_message_position, this.is_restricted, this.disabled_action, this.is_destroyed, this.from_tenant_id, this.message_sender_name, this.scene_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
            this.disabled_action = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder create_time(Long r100) {
            this.create_time = r100;
            return this;
        }

        public Builder disabled_action(Map<Integer, MessageBehavior> r100) {
            Internal.checkElementsNotNull(r100);
            this.disabled_action = r100;
            return this;
        }

        public Builder file_hierarchy(String r100) {
            this.file_hierarchy = r100;
            return this;
        }

        public Builder file_meta(FileContent r100) {
            this.file_meta = r100;
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

        public Builder from_id(String r100) {
            this.from_id = r100;
            return this;
        }

        public Builder from_tenant_id(String r100) {
            this.from_tenant_id = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253720id = r100;
            return this;
        }

        public Builder is_destroyed(Boolean r100) {
            this.is_destroyed = r100;
            return this;
        }

        public Builder is_file_access_auth(Boolean r100) {
            this.is_file_access_auth = r100;
            return this;
        }

        public Builder is_inner_file(Boolean r100) {
            this.is_inner_file = r100;
            return this;
        }

        public Builder is_restricted(Boolean r100) {
            this.is_restricted = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder message_position(Integer r100) {
            this.message_position = r100;
            return this;
        }

        public Builder message_sender_name(String r100) {
            this.message_sender_name = r100;
            return this;
        }

        public Builder root_message_position(Integer r100) {
            this.root_message_position = r100;
            return this;
        }

        public Builder scene_id(Long r100) {
            this.scene_id = r100;
            return this;
        }

        public Builder thread_chat_position(Integer r100) {
            this.thread_chat_position = r100;
            return this;
        }

        public Builder thread_id(String r100) {
            this.thread_id = r100;
            return this;
        }

        public Builder thread_message_type(com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType r100) {
            this.thread_message_type = r100;
            return this;
        }

        public Builder thread_position(Integer r100) {
            this.thread_position = r100;
            return this;
        }
    }

    public static final enum FileType extends Enum<FileType> implements WireEnum {
        private static final /* synthetic */ FileType[] $VALUES = null;
        public static final ProtoAdapter<FileType> ADAPTER = null;
        public static final FileType FILE = null;
        public static final FileType FOLDER = null;
        public static final FileType UNKNOWN = null;
        private final int value;

        static {
            FileType r100 = new FileType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            FileType r101 = new FileType("FILE", 1, 1);
            FILE = r101;
            FileType r102 = new FileType("FOLDER", 2, 2);
            FOLDER = r102;
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
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return FOLDER;
        L12:
            return FILE;
        L14:
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

    public static final class ProtoAdapter_MessageFileMeta extends ProtoAdapter<MessageFileMeta> {
        private final ProtoAdapter<Map<Integer, MessageBehavior>> disabled_action;

        public ProtoAdapter_MessageFileMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageFileMeta.class);
            this.disabled_action = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, MessageBehavior.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MessageFileMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253720id = "";
            r101.file_type = FileType.UNKNOWN;
            r101.create_time = 0L;
            r101.message_id = "";
            r101.message_position = 0;
            r101.chat_id = "";
            r101.from_id = "";
            r101.file_hierarchy = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_inner_file = r102;
            r101.file_path = "";
            r101.thread_id = "";
            r101.thread_position = 0;
            r101.thread_chat_position = 0;
            r101.is_file_access_auth = r102;
            r101.thread_message_type = com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType.UNKNOWN_THREAD_MESSAGE;
            r101.root_message_position = 0;
            r101.is_restricted = r102;
            r101.is_destroyed = r102;
            r101.from_tenant_id = "";
            r101.message_sender_name = "";
            r101.scene_id = 0L;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L36;
            switch(r104) {
                case 1: goto L35;
                case 2: goto L38;
                case 3: goto L30;
                case 4: goto L29;
                case 5: goto L28;
                case 6: goto L27;
                case 7: goto L26;
                case 8: goto L25;
                case 9: goto L24;
                case 10: goto L23;
                case 11: goto L22;
                case 12: goto L21;
                case 13: goto L20;
                case 14: goto L19;
                case 15: goto L18;
                case 16: goto L40;
                case 17: goto L13;
                case 18: goto L12;
                case 19: goto L11;
                case 20: goto L10;
                case 21: goto L9;
                case 22: goto L8;
                case 23: goto L7;
                default: goto L6;
            };
        L38:
            r101.file_type = FileType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L33
        L33:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L40:
            r101.thread_message_type = com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.scene_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            r101.message_sender_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.from_tenant_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.is_destroyed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.disabled_action.putAll(this.disabled_action.decode(r100));
            goto L3
        L12:
            r101.is_restricted = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.root_message_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L18:
            r101.is_file_access_auth = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L19:
            r101.thread_chat_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L20:
            r101.thread_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L21:
            r101.thread_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.file_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L23:
            r101.is_inner_file = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L24:
            r101.file_hierarchy = ProtoAdapter.STRING.decode(r100);
            goto L3
        L25:
            r101.file_meta = FileContent.ADAPTER.decode(r100);
            goto L3
        L26:
            r101.from_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L27:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L28:
            r101.message_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L29:
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L30:
            r101.create_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L35:
            r101.f253720id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L36:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MessageFileMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253719id);
            FileType r103 = r100.file_type;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = FileType.ADAPTER.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Long r107 = r100.create_time;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.message_id;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            Integer r113 = r100.message_position;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.INT32.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.chat_id;
            if (r116 == null) goto L21;
            int r117 = r101.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.from_id;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(7, r119);
        L26:
            int r121 = r118 + r120;
            FileContent r122 = r100.file_meta;
            if (r122 == null) goto L29;
            int r123 = FileContent.ADAPTER.encodedSizeWithTag(8, r122);
        L30:
            int r124 = r121 + r123;
            String r125 = r100.file_hierarchy;
            if (r125 == null) goto L33;
            int r126 = r101.encodedSizeWithTag(9, r125);
        L34:
            int r127 = r124 + r126;
            Boolean r128 = r100.is_inner_file;
            if (r128 == null) goto L37;
            int r129 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r128);
        L38:
            int r130 = r127 + r129;
            String r131 = r100.file_path;
            if (r131 == null) goto L41;
            int r132 = r101.encodedSizeWithTag(11, r131);
        L42:
            int r133 = r130 + r132;
            String r134 = r100.thread_id;
            if (r134 == null) goto L45;
            int r135 = r101.encodedSizeWithTag(12, r134);
        L46:
            int r136 = r133 + r135;
            Integer r137 = r100.thread_position;
            if (r137 == null) goto L49;
            int r138 = ProtoAdapter.INT32.encodedSizeWithTag(13, r137);
        L50:
            int r139 = r136 + r138;
            Integer r140 = r100.thread_chat_position;
            if (r140 == null) goto L53;
            int r141 = ProtoAdapter.INT32.encodedSizeWithTag(14, r140);
        L54:
            int r142 = r139 + r141;
            Boolean r143 = r100.is_file_access_auth;
            if (r143 == null) goto L57;
            int r144 = ProtoAdapter.BOOL.encodedSizeWithTag(15, r143);
        L58:
            int r145 = r142 + r144;
            com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType r146 = r100.thread_message_type;
            if (r146 == null) goto L61;
            int r147 = com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType.ADAPTER.encodedSizeWithTag(16, r146);
        L62:
            int r148 = r145 + r147;
            Integer r149 = r100.root_message_position;
            if (r149 == null) goto L65;
            int r150 = ProtoAdapter.INT32.encodedSizeWithTag(17, r149);
        L66:
            int r151 = r148 + r150;
            Boolean r152 = r100.is_restricted;
            if (r152 == null) goto L69;
            int r153 = ProtoAdapter.BOOL.encodedSizeWithTag(18, r152);
        L70:
            int r154 = (r151 + r153) + this.disabled_action.encodedSizeWithTag(19, r100.disabled_action);
            Boolean r155 = r100.is_destroyed;
            if (r155 == null) goto L73;
            int r156 = ProtoAdapter.BOOL.encodedSizeWithTag(20, r155);
        L74:
            int r157 = r154 + r156;
            String r158 = r100.from_tenant_id;
            if (r158 == null) goto L77;
            int r159 = r101.encodedSizeWithTag(21, r158);
        L78:
            int r160 = r157 + r159;
            String r161 = r100.message_sender_name;
            if (r161 == null) goto L81;
            int r162 = r101.encodedSizeWithTag(22, r161);
        L82:
            int r163 = r160 + r162;
            Long r164 = r100.scene_id;
            if (r164 == null) goto L86;
            r104 = ProtoAdapter.INT64.encodedSizeWithTag(23, r164);
        L86:
            return (r163 + r104) + r100.unknownFields().size();
        L81:
            r162 = 0;
            goto L82
        L77:
            r159 = 0;
            goto L78
        L73:
            r156 = 0;
            goto L74
        L69:
            r153 = 0;
            goto L70
        L65:
            r150 = 0;
            goto L66
        L61:
            r147 = 0;
            goto L62
        L57:
            r144 = 0;
            goto L58
        L53:
            r141 = 0;
            goto L54
        L49:
            r138 = 0;
            goto L50
        L45:
            r135 = 0;
            goto L46
        L41:
            r132 = 0;
            goto L42
        L37:
            r129 = 0;
            goto L38
        L33:
            r126 = 0;
            goto L34
        L29:
            r123 = 0;
            goto L30
        L25:
            r120 = 0;
            goto L26
        L21:
            r117 = 0;
            goto L22
        L17:
            r114 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ MessageFileMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MessageFileMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MessageFileMeta r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253719id);
            FileType r103 = r101.file_type;
            if (r103 == null) goto L5;
            FileType.ADAPTER.encodeWithTag(r100, 2, r103);
        L5:
            Long r104 = r101.create_time;
            if (r104 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L8:
            String r105 = r101.message_id;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            Integer r106 = r101.message_position;
            if (r106 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r106);
        L14:
            String r107 = r101.chat_id;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 6, r107);
        L17:
            String r108 = r101.from_id;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 7, r108);
        L20:
            FileContent r109 = r101.file_meta;
            if (r109 == null) goto L23;
            FileContent.ADAPTER.encodeWithTag(r100, 8, r109);
        L23:
            String r110 = r101.file_hierarchy;
            if (r110 == null) goto L26;
            r102.encodeWithTag(r100, 9, r110);
        L26:
            Boolean r111 = r101.is_inner_file;
            if (r111 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 10, r111);
        L29:
            String r112 = r101.file_path;
            if (r112 == null) goto L32;
            r102.encodeWithTag(r100, 11, r112);
        L32:
            String r113 = r101.thread_id;
            if (r113 == null) goto L35;
            r102.encodeWithTag(r100, 12, r113);
        L35:
            Integer r114 = r101.thread_position;
            if (r114 == null) goto L38;
            ProtoAdapter.INT32.encodeWithTag(r100, 13, r114);
        L38:
            Integer r115 = r101.thread_chat_position;
            if (r115 == null) goto L41;
            ProtoAdapter.INT32.encodeWithTag(r100, 14, r115);
        L41:
            Boolean r116 = r101.is_file_access_auth;
            if (r116 == null) goto L44;
            ProtoAdapter.BOOL.encodeWithTag(r100, 15, r116);
        L44:
            com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType r117 = r101.thread_message_type;
            if (r117 == null) goto L47;
            com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType.ADAPTER.encodeWithTag(r100, 16, r117);
        L47:
            Integer r118 = r101.root_message_position;
            if (r118 == null) goto L50;
            ProtoAdapter.INT32.encodeWithTag(r100, 17, r118);
        L50:
            Boolean r119 = r101.is_restricted;
            if (r119 == null) goto L53;
            ProtoAdapter.BOOL.encodeWithTag(r100, 18, r119);
        L53:
            this.disabled_action.encodeWithTag(r100, 19, r101.disabled_action);
            Boolean r120 = r101.is_destroyed;
            if (r120 == null) goto L56;
            ProtoAdapter.BOOL.encodeWithTag(r100, 20, r120);
        L56:
            String r121 = r101.from_tenant_id;
            if (r121 == null) goto L59;
            r102.encodeWithTag(r100, 21, r121);
        L59:
            String r122 = r101.message_sender_name;
            if (r122 == null) goto L62;
            r102.encodeWithTag(r100, 22, r122);
        L62:
            Long r123 = r101.scene_id;
            if (r123 == null) goto L65;
            ProtoAdapter.INT64.encodeWithTag(r100, 23, r123);
        L65:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageFileMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageFileMeta();
        DEFAULT_FILE_TYPE = FileType.UNKNOWN;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_MESSAGE_POSITION = 0;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_INNER_FILE = r100;
        DEFAULT_THREAD_POSITION = 0;
        DEFAULT_THREAD_CHAT_POSITION = 0;
        DEFAULT_IS_FILE_ACCESS_AUTH = r100;
        DEFAULT_THREAD_MESSAGE_TYPE = com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType.UNKNOWN_THREAD_MESSAGE;
        DEFAULT_ROOT_MESSAGE_POSITION = 0;
        DEFAULT_IS_RESTRICTED = r100;
        DEFAULT_IS_DESTROYED = r100;
        DEFAULT_SCENE_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253720id = this.f253719id;
        r100.file_type = this.file_type;
        r100.create_time = this.create_time;
        r100.message_id = this.message_id;
        r100.message_position = this.message_position;
        r100.chat_id = this.chat_id;
        r100.from_id = this.from_id;
        r100.file_meta = this.file_meta;
        r100.file_hierarchy = this.file_hierarchy;
        r100.is_inner_file = this.is_inner_file;
        r100.file_path = this.file_path;
        r100.thread_id = this.thread_id;
        r100.thread_position = this.thread_position;
        r100.thread_chat_position = this.thread_chat_position;
        r100.is_file_access_auth = this.is_file_access_auth;
        r100.thread_message_type = this.thread_message_type;
        r100.root_message_position = this.root_message_position;
        r100.is_restricted = this.is_restricted;
        r100.disabled_action = Internal.copyOf("disabled_action", this.disabled_action);
        r100.is_destroyed = this.is_destroyed;
        r100.from_tenant_id = this.from_tenant_id;
        r100.message_sender_name = this.message_sender_name;
        r100.scene_id = this.scene_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MessageFileMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MessageFileMeta(String r210, FileType r211, Long r212, String r213, Integer r310, String r311, String r312, FileContent r313, String r314, Boolean r315, String r316, String r317, Integer r318, Integer r319, Boolean r410, com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType r411, Integer r412, Boolean r413, Map<Integer, MessageBehavior> r414, Boolean r415, String r416, String r417, Long r418) {
        this(r210, r211, r212, r213, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, ByteString.EMPTY);
    }

    public MessageFileMeta(String r100, FileType r101, Long r102, String r103, Integer r104, String r105, String r110, FileContent r111, String r112, Boolean r113, String r114, String r115, Integer r116, Integer r117, Boolean r118, com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType r119, Integer r210, Boolean r211, Map<Integer, MessageBehavior> r212, Boolean r213, String r214, String r215, Long r216, ByteString r217) {
        super(ADAPTER, r217);
        this.f253719id = r100;
        this.file_type = r101;
        this.create_time = r102;
        this.message_id = r103;
        this.message_position = r104;
        this.chat_id = r105;
        this.from_id = r110;
        this.file_meta = r111;
        this.file_hierarchy = r112;
        this.is_inner_file = r113;
        this.file_path = r114;
        this.thread_id = r115;
        this.thread_position = r116;
        this.thread_chat_position = r117;
        this.is_file_access_auth = r118;
        this.thread_message_type = r119;
        this.root_message_position = r210;
        this.is_restricted = r211;
        this.disabled_action = Internal.immutableCopyOf("disabled_action", r212);
        this.is_destroyed = r213;
        this.from_tenant_id = r214;
        this.message_sender_name = r215;
        this.scene_id = r216;
    }
}
