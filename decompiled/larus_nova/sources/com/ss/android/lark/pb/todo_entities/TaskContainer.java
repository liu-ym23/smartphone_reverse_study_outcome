package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class TaskContainer extends Message<TaskContainer, Builder> {
    public static final ProtoAdapter<TaskContainer> ADAPTER = null;
    public static final Long DEFAULT_ARCHIVED_MILLI_TIME = null;
    public static final Long DEFAULT_ARCHIVED_USER_ID = null;
    public static final String DEFAULT_BASE_TABLE_TOKEN = "";
    public static final String DEFAULT_BASE_TOKEN = "";
    public static final Long DEFAULT_CREATE_MILLI_TIME = null;
    public static final Long DEFAULT_CURRENT_USER_JOIN_MILLI_TIME = null;
    public static final Long DEFAULT_DASHBOARD_CREATOR_ID = null;
    public static final String DEFAULT_DASHBOARD_ID = "";
    public static final Long DEFAULT_DELETE_MILLI_TIME = null;
    public static final String DEFAULT_GUID = "";
    public static final Boolean DEFAULT_IS_NOT_MINE = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_NAME = "";
    public static final Long DEFAULT_OWNER_ID = null;
    public static final String DEFAULT_RANK = "";
    public static final Long DEFAULT_USER_ID = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final AgentCategory magent_category;
    public final AgentInfo magent_origin;
    public final Long marchived_milli_time;
    public final Long marchived_user_id;
    public final String mbase_table_token;
    public final String mbase_token;
    public final Category mcategory;
    public final Long mcreate_milli_time;
    public final Long mcurrent_user_join_milli_time;
    public final TaskContainerPermission mcurrent_user_permission;
    public final Long mdashboard_creator_id;
    public final String mdashboard_id;
    public final Long mdelete_milli_time;
    public final String mguid;
    public final IconInfo miconInfo;
    public final Boolean mis_not_mine;
    public final String mkey;
    public final MeegoOrigin mmeego_origin;
    public final String mname;
    public final Long mowner_id;
    public final String mrank;
    public final Long muser_id;
    public final Long mversion;

    public static final enum AgentCategory extends Enum<AgentCategory> implements WireEnum {
        private static final /* synthetic */ AgentCategory[] $VALUES = null;
        public static final ProtoAdapter<AgentCategory> ADAPTER = null;
        public static final AgentCategory AGENT_CRON_TASK_LIST = null;
        public static final AgentCategory AGENT_CUSTOM_TASK_LIST = null;
        public static final AgentCategory AGENT_OWNED_TASK_LIST = null;
        public static final AgentCategory AGENT_UNKNOWN = null;
        private final int value;

        static {
            AgentCategory r100 = new AgentCategory("AGENT_UNKNOWN", 0, 0);
            AGENT_UNKNOWN = r100;
            AgentCategory r101 = new AgentCategory("AGENT_OWNED_TASK_LIST", 1, 1);
            AGENT_OWNED_TASK_LIST = r101;
            AgentCategory r102 = new AgentCategory("AGENT_CRON_TASK_LIST", 2, 2);
            AGENT_CRON_TASK_LIST = r102;
            AgentCategory r103 = new AgentCategory("AGENT_CUSTOM_TASK_LIST", 3, 3);
            AGENT_CUSTOM_TASK_LIST = r103;
            $VALUES = new AgentCategory[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(AgentCategory.class);
        }

        public static AgentCategory[] values() {
            return (AgentCategory[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static AgentCategory fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return AGENT_CUSTOM_TASK_LIST;
        L14:
            return AGENT_CRON_TASK_LIST;
        L16:
            return AGENT_OWNED_TASK_LIST;
        L18:
            return AGENT_UNKNOWN;
        }

        public static AgentCategory valueOf(String r100) {
            return (AgentCategory) a.a(AgentCategory.class, r100);
        }

        private AgentCategory(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends Message.Builder<TaskContainer, Builder> {
        public AgentCategory magent_category;
        public AgentInfo magent_origin;
        public Long marchived_milli_time;
        public Long marchived_user_id;
        public String mbase_table_token;
        public String mbase_token;
        public Category mcategory;
        public Long mcreate_milli_time;
        public Long mcurrent_user_join_milli_time;
        public TaskContainerPermission mcurrent_user_permission;
        public Long mdashboard_creator_id;
        public String mdashboard_id;
        public Long mdelete_milli_time;
        public String mguid;
        public IconInfo miconInfo;
        public Boolean mis_not_mine;
        public String mkey;
        public MeegoOrigin mmeego_origin;
        public String mname;
        public Long mowner_id;
        public String mrank;
        public Long muser_id;
        public Long mversion;

        @Override // com.squareup.wire.Message.Builder
        public TaskContainer build() {
            return new TaskContainer(this.mguid, this.mcategory, this.muser_id, this.mkey, this.mname, this.mrank, this.mis_not_mine, this.mcurrent_user_permission, this.mcurrent_user_join_milli_time, this.mowner_id, this.marchived_milli_time, this.marchived_user_id, this.miconInfo, this.mbase_token, this.mbase_table_token, this.mdashboard_id, this.mdashboard_creator_id, this.mversion, this.mdelete_milli_time, this.mcreate_milli_time, this.mmeego_origin, this.magent_category, this.magent_origin, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder agent_category(AgentCategory r100) {
            this.magent_category = r100;
            return this;
        }

        public Builder agent_origin(AgentInfo r100) {
            this.magent_origin = r100;
            return this;
        }

        public Builder archived_milli_time(Long r100) {
            this.marchived_milli_time = r100;
            return this;
        }

        public Builder archived_user_id(Long r100) {
            this.marchived_user_id = r100;
            return this;
        }

        public Builder base_table_token(String r100) {
            this.mbase_table_token = r100;
            return this;
        }

        public Builder base_token(String r100) {
            this.mbase_token = r100;
            return this;
        }

        public Builder category(Category r100) {
            this.mcategory = r100;
            return this;
        }

        public Builder create_milli_time(Long r100) {
            this.mcreate_milli_time = r100;
            return this;
        }

        public Builder current_user_join_milli_time(Long r100) {
            this.mcurrent_user_join_milli_time = r100;
            return this;
        }

        public Builder current_user_permission(TaskContainerPermission r100) {
            this.mcurrent_user_permission = r100;
            return this;
        }

        public Builder dashboard_creator_id(Long r100) {
            this.mdashboard_creator_id = r100;
            return this;
        }

        public Builder dashboard_id(String r100) {
            this.mdashboard_id = r100;
            return this;
        }

        public Builder delete_milli_time(Long r100) {
            this.mdelete_milli_time = r100;
            return this;
        }

        public Builder guid(String r100) {
            this.mguid = r100;
            return this;
        }

        public Builder iconInfo(IconInfo r100) {
            this.miconInfo = r100;
            return this;
        }

        public Builder is_not_mine(Boolean r100) {
            this.mis_not_mine = r100;
            return this;
        }

        public Builder key(String r100) {
            this.mkey = r100;
            return this;
        }

        public Builder meego_origin(MeegoOrigin r100) {
            this.mmeego_origin = r100;
            return this;
        }

        public Builder name(String r100) {
            this.mname = r100;
            return this;
        }

        public Builder owner_id(Long r100) {
            this.mowner_id = r100;
            return this;
        }

        public Builder rank(String r100) {
            this.mrank = r100;
            return this;
        }

        public Builder user_id(Long r100) {
            this.muser_id = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.mversion = r100;
            return this;
        }
    }

    public static final enum Category extends Enum<Category> implements WireEnum {
        private static final /* synthetic */ Category[] $VALUES = null;
        public static final ProtoAdapter<Category> ADAPTER = null;
        public static final Category FOLLOWED_TASKS = null;
        public static final Category FROM_MEEGO_DEFAULT = null;
        public static final Category MY_RECORDS = null;
        public static final Category OWNED_TASKS = null;
        public static final Category SAVED_SEARCH_TASKS = null;
        public static final Category TASK_LIST = null;
        public static final Category TODAY = null;
        public static final Category UNKNOWN = null;
        private final int value;

        static {
            Category r100 = new Category("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Category r101 = new Category("OWNED_TASKS", 1, 1);
            OWNED_TASKS = r101;
            Category r102 = new Category("FOLLOWED_TASKS", 2, 2);
            FOLLOWED_TASKS = r102;
            Category r103 = new Category("SAVED_SEARCH_TASKS", 3, 3);
            SAVED_SEARCH_TASKS = r103;
            Category r104 = new Category("TASK_LIST", 4, 4);
            TASK_LIST = r104;
            Category r105 = new Category("FROM_MEEGO_DEFAULT", 5, 5);
            FROM_MEEGO_DEFAULT = r105;
            Category r110 = new Category("TODAY", 6, 6);
            TODAY = r110;
            Category r111 = new Category("MY_RECORDS", 7, 7);
            MY_RECORDS = r111;
            $VALUES = new Category[]{r100, r101, r102, r103, r104, r105, r110, r111};
            ADAPTER = ProtoAdapter.newEnumAdapter(Category.class);
        }

        public static Category[] values() {
            return (Category[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Category fromValue(int r100) {
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
            return MY_RECORDS;
        L8:
            return TODAY;
        L10:
            return FROM_MEEGO_DEFAULT;
        L12:
            return TASK_LIST;
        L14:
            return SAVED_SEARCH_TASKS;
        L16:
            return FOLLOWED_TASKS;
        L18:
            return OWNED_TASKS;
        L20:
            return UNKNOWN;
        }

        public static Category valueOf(String r100) {
            return (Category) a.a(Category.class, r100);
        }

        private Category(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class MeegoOrigin extends Message<MeegoOrigin, Builder> {
        public static final ProtoAdapter<MeegoOrigin> ADAPTER = null;
        public static final Boolean DEFAULT_SYNC_FROM_MEEGO = null;
        public static final String DEFAULT_WORK_FLOW_NODE_KEY = "";
        public static final String DEFAULT_WORK_FLOW_NODE_NAME = "";
        public static final String DEFAULT_WORK_FLOW_NODE_STATUS = "";
        public static final String DEFAULT_WORK_ITEM_ICON_COLOR = "";
        public static final String DEFAULT_WORK_ITEM_ICON_KEY = "";
        public static final Long DEFAULT_WORK_ITEM_ID = null;
        public static final String DEFAULT_WORK_ITEM_NAME = "";
        private static final long serialVersionUID = 0;
        public final Boolean msync_from_meego;
        public final String mwork_flow_node_key;
        public final String mwork_flow_node_name;
        public final String mwork_flow_node_status;
        public final String mwork_item_icon_color;
        public final String mwork_item_icon_key;
        public final Long mwork_item_id;
        public final String mwork_item_name;

        public static final class Builder extends Message.Builder<MeegoOrigin, Builder> {
            public Boolean msync_from_meego;
            public String mwork_flow_node_key;
            public String mwork_flow_node_name;
            public String mwork_flow_node_status;
            public String mwork_item_icon_color;
            public String mwork_item_icon_key;
            public Long mwork_item_id;
            public String mwork_item_name;

            @Override // com.squareup.wire.Message.Builder
            public MeegoOrigin build() {
                return new MeegoOrigin(this.msync_from_meego, this.mwork_item_id, this.mwork_item_name, this.mwork_item_icon_key, this.mwork_item_icon_color, this.mwork_flow_node_key, this.mwork_flow_node_name, this.mwork_flow_node_status, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder sync_from_meego(Boolean r100) {
                this.msync_from_meego = r100;
                return this;
            }

            public Builder work_flow_node_key(String r100) {
                this.mwork_flow_node_key = r100;
                return this;
            }

            public Builder work_flow_node_name(String r100) {
                this.mwork_flow_node_name = r100;
                return this;
            }

            public Builder work_flow_node_status(String r100) {
                this.mwork_flow_node_status = r100;
                return this;
            }

            public Builder work_item_icon_color(String r100) {
                this.mwork_item_icon_color = r100;
                return this;
            }

            public Builder work_item_icon_key(String r100) {
                this.mwork_item_icon_key = r100;
                return this;
            }

            public Builder work_item_id(Long r100) {
                this.mwork_item_id = r100;
                return this;
            }

            public Builder work_item_name(String r100) {
                this.mwork_item_name = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MeegoOrigin extends ProtoAdapter<MeegoOrigin> {
            public ProtoAdapter_MeegoOrigin() {
                super(FieldEncoding.LENGTH_DELIMITED, MeegoOrigin.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MeegoOrigin decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.msync_from_meego = Boolean.FALSE;
                r101.mwork_item_id = 0L;
                r101.mwork_item_name = "";
                r101.mwork_item_icon_key = "";
                r101.mwork_item_icon_color = "";
                r101.mwork_flow_node_key = "";
                r101.mwork_flow_node_name = "";
                r101.mwork_flow_node_status = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                switch(r103) {
                    case 1: goto L14;
                    case 2: goto L13;
                    case 3: goto L12;
                    case 4: goto L11;
                    case 5: goto L10;
                    case 6: goto L9;
                    case 7: goto L8;
                    case 8: goto L7;
                    default: goto L6;
                };
            L7:
                r101.mwork_flow_node_status = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                r101.mwork_flow_node_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                r101.mwork_flow_node_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.mwork_item_icon_color = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.mwork_item_icon_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                r101.mwork_item_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                r101.mwork_item_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L14:
                r101.msync_from_meego = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(MeegoOrigin r100) {
                Boolean r101 = r100.msync_from_meego;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.mwork_item_id;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.mwork_item_name;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.mwork_item_icon_key;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                String r113 = r100.mwork_item_icon_color;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                String r116 = r100.mwork_flow_node_key;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                String r119 = r100.mwork_flow_node_name;
                if (r119 == null) goto L29;
                int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
            L30:
                int r121 = r118 + r120;
                String r122 = r100.mwork_flow_node_status;
                if (r122 == null) goto L34;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
            L34:
                return (r121 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ MeegoOrigin decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MeegoOrigin r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MeegoOrigin r101) throws IOException {
                Boolean r102 = r101.msync_from_meego;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.mwork_item_id;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.mwork_item_name;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.mwork_item_icon_key;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                String r106 = r101.mwork_item_icon_color;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
            L17:
                String r107 = r101.mwork_flow_node_key;
                if (r107 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
            L20:
                String r108 = r101.mwork_flow_node_name;
                if (r108 == null) goto L23;
                ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
            L23:
                String r109 = r101.mwork_flow_node_status;
                if (r109 == null) goto L26;
                ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
            L26:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MeegoOrigin r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MeegoOrigin();
            DEFAULT_SYNC_FROM_MEEGO = Boolean.FALSE;
            DEFAULT_WORK_ITEM_ID = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.msync_from_meego = this.msync_from_meego;
            r100.mwork_item_id = this.mwork_item_id;
            r100.mwork_item_name = this.mwork_item_name;
            r100.mwork_item_icon_key = this.mwork_item_icon_key;
            r100.mwork_item_icon_color = this.mwork_item_icon_color;
            r100.mwork_flow_node_key = this.mwork_flow_node_key;
            r100.mwork_flow_node_name = this.mwork_flow_node_name;
            r100.mwork_flow_node_status = this.mwork_flow_node_status;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MeegoOrigin.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public MeegoOrigin(Boolean r110, Long r111, String r112, String r113, String r114, String r115, String r116, String r117) {
            this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
        }

        public MeegoOrigin(Boolean r100, Long r101, String r102, String r103, String r104, String r105, String r106, String r107, ByteString r110) {
            super(ADAPTER, r110);
            this.msync_from_meego = r100;
            this.mwork_item_id = r101;
            this.mwork_item_name = r102;
            this.mwork_item_icon_key = r103;
            this.mwork_item_icon_color = r104;
            this.mwork_flow_node_key = r105;
            this.mwork_flow_node_name = r106;
            this.mwork_flow_node_status = r107;
        }
    }

    public static final class ProtoAdapter_TaskContainer extends ProtoAdapter<TaskContainer> {
        public ProtoAdapter_TaskContainer() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskContainer.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskContainer decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mguid = "";
            r101.muser_id = 0L;
            r101.mkey = "";
            r101.mname = "";
            r101.mrank = "";
            r101.mis_not_mine = Boolean.FALSE;
            r101.mcurrent_user_join_milli_time = 0L;
            r101.mowner_id = 0L;
            r101.marchived_milli_time = 0L;
            r101.marchived_user_id = 0L;
            r101.mbase_token = "";
            r101.mbase_table_token = "";
            r101.mdashboard_id = "";
            r101.mdashboard_creator_id = 0L;
            r101.mversion = 0L;
            r101.mdelete_milli_time = 0L;
            r101.mcreate_milli_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L37;
            switch(r103) {
                case 1: goto L36;
                case 2: goto L39;
                case 3: goto L31;
                case 4: goto L30;
                case 5: goto L29;
                case 6: goto L28;
                case 7: goto L27;
                case 8: goto L26;
                case 9: goto L25;
                case 10: goto L24;
                case 11: goto L23;
                case 12: goto L22;
                case 13: goto L21;
                case 14: goto L20;
                case 15: goto L19;
                case 16: goto L18;
                case 17: goto L17;
                default: goto L6;
            };
        L39:
            r101.mcategory = Category.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L34
        L34:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L17:
            r101.mdashboard_creator_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L18:
            r101.mdashboard_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.mbase_table_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.mbase_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.miconInfo = IconInfo.ADAPTER.decode(r100);
            goto L3
        L22:
            r101.marchived_user_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L23:
            r101.marchived_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L24:
            r101.mowner_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L25:
            r101.mcurrent_user_join_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L26:
            r101.mcurrent_user_permission = TaskContainerPermission.ADAPTER.decode(r100);
            goto L3
        L27:
            r101.mis_not_mine = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L28:
            r101.mrank = ProtoAdapter.STRING.decode(r100);
            goto L3
        L29:
            r101.mname = ProtoAdapter.STRING.decode(r100);
            goto L3
        L30:
            r101.mkey = ProtoAdapter.STRING.decode(r100);
            goto L3
        L31:
            r101.muser_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L36:
            r101.mguid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            switch(r103) {
                case 100: goto L16;
                case 101: goto L15;
                case 102: goto L14;
                case 103: goto L13;
                case 104: goto L41;
                case 105: goto L8;
                default: goto L7;
            };
        L41:
            r101.magent_category = AgentCategory.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            r101.magent_origin = AgentInfo.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.mmeego_origin = MeegoOrigin.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.mcreate_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            r101.mdelete_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            r101.mversion = ProtoAdapter.INT64.decode(r100);
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L37:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TaskContainer r100) {
            String r101 = r100.mguid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Category r104 = r100.mcategory;
            if (r104 == null) goto L9;
            int r105 = Category.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.muser_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mkey;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.mname;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.mrank;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Boolean r119 = r100.mis_not_mine;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            TaskContainerPermission r122 = r100.mcurrent_user_permission;
            if (r122 == null) goto L33;
            int r123 = TaskContainerPermission.ADAPTER.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Long r125 = r100.mcurrent_user_join_milli_time;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.INT64.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            Long r128 = r100.mowner_id;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.INT64.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            Long r131 = r100.marchived_milli_time;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.INT64.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            Long r134 = r100.marchived_user_id;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.INT64.encodedSizeWithTag(12, r134);
        L50:
            int r136 = r133 + r135;
            IconInfo r137 = r100.miconInfo;
            if (r137 == null) goto L53;
            int r138 = IconInfo.ADAPTER.encodedSizeWithTag(13, r137);
        L54:
            int r139 = r136 + r138;
            String r140 = r100.mbase_token;
            if (r140 == null) goto L57;
            int r141 = ProtoAdapter.STRING.encodedSizeWithTag(14, r140);
        L58:
            int r142 = r139 + r141;
            String r143 = r100.mbase_table_token;
            if (r143 == null) goto L61;
            int r144 = ProtoAdapter.STRING.encodedSizeWithTag(15, r143);
        L62:
            int r145 = r142 + r144;
            String r146 = r100.mdashboard_id;
            if (r146 == null) goto L65;
            int r147 = ProtoAdapter.STRING.encodedSizeWithTag(16, r146);
        L66:
            int r148 = r145 + r147;
            Long r149 = r100.mdashboard_creator_id;
            if (r149 == null) goto L69;
            int r150 = ProtoAdapter.INT64.encodedSizeWithTag(17, r149);
        L70:
            int r151 = r148 + r150;
            Long r152 = r100.mversion;
            if (r152 == null) goto L73;
            int r153 = ProtoAdapter.INT64.encodedSizeWithTag(100, r152);
        L74:
            int r154 = r151 + r153;
            Long r155 = r100.mdelete_milli_time;
            if (r155 == null) goto L77;
            int r156 = ProtoAdapter.INT64.encodedSizeWithTag(101, r155);
        L78:
            int r157 = r154 + r156;
            Long r158 = r100.mcreate_milli_time;
            if (r158 == null) goto L81;
            int r159 = ProtoAdapter.INT64.encodedSizeWithTag(102, r158);
        L82:
            int r160 = r157 + r159;
            MeegoOrigin r161 = r100.mmeego_origin;
            if (r161 == null) goto L85;
            int r162 = MeegoOrigin.ADAPTER.encodedSizeWithTag(103, r161);
        L86:
            int r163 = r160 + r162;
            AgentCategory r164 = r100.magent_category;
            if (r164 == null) goto L89;
            int r165 = AgentCategory.ADAPTER.encodedSizeWithTag(104, r164);
        L90:
            int r166 = r163 + r165;
            AgentInfo r167 = r100.magent_origin;
            if (r167 == null) goto L94;
            r102 = AgentInfo.ADAPTER.encodedSizeWithTag(105, r167);
        L94:
            return (r166 + r102) + r100.unknownFields().size();
        L89:
            r165 = 0;
            goto L90
        L85:
            r162 = 0;
            goto L86
        L81:
            r159 = 0;
            goto L82
        L77:
            r156 = 0;
            goto L78
        L73:
            r153 = 0;
            goto L74
        L69:
            r150 = 0;
            goto L70
        L65:
            r147 = 0;
            goto L66
        L61:
            r144 = 0;
            goto L62
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
        public /* bridge */ /* synthetic */ TaskContainer decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskContainer r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskContainer r101) throws IOException {
            String r102 = r101.mguid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Category r103 = r101.mcategory;
            if (r103 == null) goto L8;
            Category.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.muser_id;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mkey;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.mname;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.mrank;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            Boolean r108 = r101.mis_not_mine;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
        L23:
            TaskContainerPermission r109 = r101.mcurrent_user_permission;
            if (r109 == null) goto L26;
            TaskContainerPermission.ADAPTER.encodeWithTag(r100, 8, r109);
        L26:
            Long r110 = r101.mcurrent_user_join_milli_time;
            if (r110 == null) goto L29;
            ProtoAdapter.INT64.encodeWithTag(r100, 9, r110);
        L29:
            Long r111 = r101.mowner_id;
            if (r111 == null) goto L32;
            ProtoAdapter.INT64.encodeWithTag(r100, 10, r111);
        L32:
            Long r112 = r101.marchived_milli_time;
            if (r112 == null) goto L35;
            ProtoAdapter.INT64.encodeWithTag(r100, 11, r112);
        L35:
            Long r113 = r101.marchived_user_id;
            if (r113 == null) goto L38;
            ProtoAdapter.INT64.encodeWithTag(r100, 12, r113);
        L38:
            IconInfo r114 = r101.miconInfo;
            if (r114 == null) goto L41;
            IconInfo.ADAPTER.encodeWithTag(r100, 13, r114);
        L41:
            String r115 = r101.mbase_token;
            if (r115 == null) goto L44;
            ProtoAdapter.STRING.encodeWithTag(r100, 14, r115);
        L44:
            String r116 = r101.mbase_table_token;
            if (r116 == null) goto L47;
            ProtoAdapter.STRING.encodeWithTag(r100, 15, r116);
        L47:
            String r117 = r101.mdashboard_id;
            if (r117 == null) goto L50;
            ProtoAdapter.STRING.encodeWithTag(r100, 16, r117);
        L50:
            Long r118 = r101.mdashboard_creator_id;
            if (r118 == null) goto L53;
            ProtoAdapter.INT64.encodeWithTag(r100, 17, r118);
        L53:
            Long r119 = r101.mversion;
            if (r119 == null) goto L56;
            ProtoAdapter.INT64.encodeWithTag(r100, 100, r119);
        L56:
            Long r120 = r101.mdelete_milli_time;
            if (r120 == null) goto L59;
            ProtoAdapter.INT64.encodeWithTag(r100, 101, r120);
        L59:
            Long r121 = r101.mcreate_milli_time;
            if (r121 == null) goto L62;
            ProtoAdapter.INT64.encodeWithTag(r100, 102, r121);
        L62:
            MeegoOrigin r122 = r101.mmeego_origin;
            if (r122 == null) goto L65;
            MeegoOrigin.ADAPTER.encodeWithTag(r100, 103, r122);
        L65:
            AgentCategory r123 = r101.magent_category;
            if (r123 == null) goto L68;
            AgentCategory.ADAPTER.encodeWithTag(r100, 104, r123);
        L68:
            AgentInfo r124 = r101.magent_origin;
            if (r124 == null) goto L71;
            AgentInfo.ADAPTER.encodeWithTag(r100, 105, r124);
        L71:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskContainer r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskContainer();
        DEFAULT_USER_ID = 0L;
        DEFAULT_IS_NOT_MINE = Boolean.FALSE;
        DEFAULT_CURRENT_USER_JOIN_MILLI_TIME = 0L;
        DEFAULT_OWNER_ID = 0L;
        DEFAULT_ARCHIVED_MILLI_TIME = 0L;
        DEFAULT_ARCHIVED_USER_ID = 0L;
        DEFAULT_DASHBOARD_CREATOR_ID = 0L;
        DEFAULT_VERSION = 0L;
        DEFAULT_DELETE_MILLI_TIME = 0L;
        DEFAULT_CREATE_MILLI_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mguid = this.mguid;
        r100.mcategory = this.mcategory;
        r100.muser_id = this.muser_id;
        r100.mkey = this.mkey;
        r100.mname = this.mname;
        r100.mrank = this.mrank;
        r100.mis_not_mine = this.mis_not_mine;
        r100.mcurrent_user_permission = this.mcurrent_user_permission;
        r100.mcurrent_user_join_milli_time = this.mcurrent_user_join_milli_time;
        r100.mowner_id = this.mowner_id;
        r100.marchived_milli_time = this.marchived_milli_time;
        r100.marchived_user_id = this.marchived_user_id;
        r100.miconInfo = this.miconInfo;
        r100.mbase_token = this.mbase_token;
        r100.mbase_table_token = this.mbase_table_token;
        r100.mdashboard_id = this.mdashboard_id;
        r100.mdashboard_creator_id = this.mdashboard_creator_id;
        r100.mversion = this.mversion;
        r100.mdelete_milli_time = this.mdelete_milli_time;
        r100.mcreate_milli_time = this.mcreate_milli_time;
        r100.mmeego_origin = this.mmeego_origin;
        r100.magent_category = this.magent_category;
        r100.magent_origin = this.magent_origin;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskContainer.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskContainer(String r210, Category r211, Long r212, String r213, String r310, String r311, Boolean r312, TaskContainerPermission r313, Long r314, Long r315, Long r316, Long r317, IconInfo r318, String r319, String r410, String r411, Long r412, Long r413, Long r414, Long r415, MeegoOrigin r416, AgentCategory r417, AgentInfo r418) {
        this(r210, r211, r212, r213, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, ByteString.EMPTY);
    }

    public TaskContainer(String r100, Category r101, Long r102, String r103, String r104, String r105, Boolean r110, TaskContainerPermission r111, Long r112, Long r113, Long r114, Long r115, IconInfo r116, String r117, String r118, String r119, Long r210, Long r211, Long r212, Long r213, MeegoOrigin r214, AgentCategory r215, AgentInfo r216, ByteString r217) {
        super(ADAPTER, r217);
        this.mguid = r100;
        this.mcategory = r101;
        this.muser_id = r102;
        this.mkey = r103;
        this.mname = r104;
        this.mrank = r105;
        this.mis_not_mine = r110;
        this.mcurrent_user_permission = r111;
        this.mcurrent_user_join_milli_time = r112;
        this.mowner_id = r113;
        this.marchived_milli_time = r114;
        this.marchived_user_id = r115;
        this.miconInfo = r116;
        this.mbase_token = r117;
        this.mbase_table_token = r118;
        this.mdashboard_id = r119;
        this.mdashboard_creator_id = r210;
        this.mversion = r211;
        this.mdelete_milli_time = r212;
        this.mcreate_milli_time = r213;
        this.mmeego_origin = r214;
        this.magent_category = r215;
        this.magent_origin = r216;
    }
}
