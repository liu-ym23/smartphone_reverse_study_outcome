package com.bytedance.lark.pb.basic.v1;

import com.obric.miniapp.alarm.AccountType;
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

/* JADX INFO: loaded from: classes20.dex */
public final class RequestPacket extends com.squareup.wire.Message<RequestPacket, Builder> {
    public static final ProtoAdapter<RequestPacket> ADAPTER = null;
    public static final Command DEFAULT_CMD = null;
    public static final Boolean DEFAULT_COLLECT_TRACE = null;
    public static final String DEFAULT_CONTEXT_ID = "";
    public static final Boolean DEFAULT_ENABLE_START_UP_CONTROL = null;
    public static final Boolean DEFAULT_IS_CALLBACK_BY_STREAM = null;
    public static final String DEFAULT_MAIL_ACCOUNT_ID = "";
    public static final Long DEFAULT_MAX_AGE = null;
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final Long DEFAULT_SPAN_ID = null;
    public static final Long DEFAULT_TASK_ID = null;
    public static final Long DEFAULT_THREAD_ID = null;
    public static final TrafficType DEFAULT_TRAFFIC_TYPE = null;
    public static final Long DEFAULT_USER_CONTAINER_ID = null;
    public static final String DEFAULT_USER_ID = "";
    public static final Boolean DEFAULT_USE_CACHE_CONTROL = null;
    private static final long serialVersionUID = 0;
    public final BizConfig biz_config;
    public final Map<String, String> biz_request_meta;
    public final Command cmd;
    public final Boolean collect_trace;
    public final String context_id;
    public final Boolean enable_start_up_control;
    public final List<HttpHeader> headers;
    public final Boolean is_callback_by_stream;
    public final String mail_account_id;
    public final MailContext mail_context;
    public final Long max_age;
    public final PassThrough pass_through;
    public final ByteString payload;
    public final Long span_id;
    public final Long task_id;
    public final Long thread_id;
    public final TrafficType traffic_type;
    public final Boolean use_cache_control;
    public final Long user_container_id;
    public final String user_id;

    public static final class BizConfig extends com.squareup.wire.Message<BizConfig, Builder> {
        public static final ProtoAdapter<BizConfig> ADAPTER = null;
        public static final DataSource DEFAULT_DATA_SOURCE = null;
        private static final long serialVersionUID = 0;
        public final DataSource data_source;

        public static final class Builder extends com.squareup.wire.Message.Builder<BizConfig, Builder> {
            public DataSource data_source;

            @Override // com.squareup.wire.Message.Builder
            public BizConfig build() {
                return new BizConfig(this.data_source, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder data_source(DataSource r100) {
                this.data_source = r100;
                return this;
            }
        }

        public static final enum DataSource extends Enum<DataSource> implements WireEnum {
            private static final /* synthetic */ DataSource[] $VALUES = null;
            public static final ProtoAdapter<DataSource> ADAPTER = null;
            public static final DataSource DEFAULT = null;
            public static final DataSource LOCAL = null;
            public static final DataSource PREFERRED_ONLINE = null;
            private final int value;

            static {
                DataSource r100 = new DataSource("DEFAULT", 0, 1);
                DEFAULT = r100;
                DataSource r101 = new DataSource(AccountType.LOCAL, 1, 2);
                LOCAL = r101;
                DataSource r102 = new DataSource("PREFERRED_ONLINE", 2, 3);
                PREFERRED_ONLINE = r102;
                $VALUES = new DataSource[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(DataSource.class);
            }

            public static DataSource[] values() {
                return (DataSource[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static DataSource fromValue(int r100) {
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L13;
                if (r100 == 3) goto L11;
                return null;
            L11:
                return PREFERRED_ONLINE;
            L13:
                return LOCAL;
            L15:
                return DEFAULT;
            }

            public static DataSource valueOf(String r100) {
                return (DataSource) a.a(DataSource.class, r100);
            }

            private DataSource(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_BizConfig extends ProtoAdapter<BizConfig> {
            public ProtoAdapter_BizConfig() {
                super(FieldEncoding.LENGTH_DELIMITED, BizConfig.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public BizConfig decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.data_source = DataSource.DEFAULT;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L7;
                r101.data_source = DataSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
            public int encodedSize2(BizConfig r100) {
                DataSource r101 = r100.data_source;
                if (r101 == null) goto L5;
                int r102 = DataSource.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ BizConfig decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(BizConfig r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, BizConfig r101) throws IOException {
                DataSource r102 = r101.data_source;
                if (r102 == null) goto L5;
                DataSource.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BizConfig r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_BizConfig();
            DEFAULT_DATA_SOURCE = DataSource.DEFAULT;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.data_source = this.data_source;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return BizConfig.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public BizConfig(DataSource r100) {
            this(r100, ByteString.EMPTY);
        }

        public BizConfig(DataSource r100, ByteString r101) {
            super(ADAPTER, r101);
            this.data_source = r100;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<RequestPacket, Builder> {
        public BizConfig biz_config;
        public Map<String, String> biz_request_meta;
        public Command cmd;
        public Boolean collect_trace;
        public String context_id;
        public Boolean enable_start_up_control;
        public List<HttpHeader> headers;
        public Boolean is_callback_by_stream;
        public String mail_account_id;
        public MailContext mail_context;
        public Long max_age;
        public PassThrough pass_through;
        public ByteString payload;
        public Long span_id;
        public Long task_id;
        public Long thread_id;
        public TrafficType traffic_type;
        public Boolean use_cache_control;
        public Long user_container_id;
        public String user_id;

        @Override // com.squareup.wire.Message.Builder
        public RequestPacket build() {
            return new RequestPacket(this.cmd, this.context_id, this.user_id, this.is_callback_by_stream, this.pass_through, this.biz_request_meta, this.biz_config, this.task_id, this.max_age, this.use_cache_control, this.thread_id, this.span_id, this.collect_trace, this.mail_account_id, this.enable_start_up_control, this.headers, this.user_container_id, this.mail_context, this.traffic_type, this.payload, super.buildUnknownFields());
        }

        public Builder() {
            this.biz_request_meta = Internal.newMutableMap();
            this.headers = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder biz_config(BizConfig r100) {
            this.biz_config = r100;
            return this;
        }

        public Builder biz_request_meta(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.biz_request_meta = r100;
            return this;
        }

        public Builder cmd(Command r100) {
            this.cmd = r100;
            return this;
        }

        public Builder collect_trace(Boolean r100) {
            this.collect_trace = r100;
            return this;
        }

        public Builder context_id(String r100) {
            this.context_id = r100;
            return this;
        }

        public Builder enable_start_up_control(Boolean r100) {
            this.enable_start_up_control = r100;
            return this;
        }

        public Builder headers(List<HttpHeader> r100) {
            Internal.checkElementsNotNull(r100);
            this.headers = r100;
            return this;
        }

        public Builder is_callback_by_stream(Boolean r100) {
            this.is_callback_by_stream = r100;
            return this;
        }

        public Builder mail_account_id(String r100) {
            this.mail_account_id = r100;
            return this;
        }

        public Builder mail_context(MailContext r100) {
            this.mail_context = r100;
            return this;
        }

        public Builder max_age(Long r100) {
            this.max_age = r100;
            return this;
        }

        public Builder pass_through(PassThrough r100) {
            this.pass_through = r100;
            return this;
        }

        public Builder payload(ByteString r100) {
            this.payload = r100;
            return this;
        }

        public Builder span_id(Long r100) {
            this.span_id = r100;
            return this;
        }

        public Builder task_id(Long r100) {
            this.task_id = r100;
            return this;
        }

        public Builder thread_id(Long r100) {
            this.thread_id = r100;
            return this;
        }

        public Builder traffic_type(TrafficType r100) {
            this.traffic_type = r100;
            return this;
        }

        public Builder use_cache_control(Boolean r100) {
            this.use_cache_control = r100;
            return this;
        }

        public Builder user_container_id(Long r100) {
            this.user_container_id = r100;
            return this;
        }

        public Builder user_id(String r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class PassThrough extends com.squareup.wire.Message<PassThrough, Builder> {
        public static final ProtoAdapter<PassThrough> ADAPTER = null;
        public static final String DEFAULT_SER_COMMAND = "";
        private static final long serialVersionUID = 0;
        public final String ser_command;

        public static final class Builder extends com.squareup.wire.Message.Builder<PassThrough, Builder> {
            public String ser_command;

            @Override // com.squareup.wire.Message.Builder
            public PassThrough build() {
                return new PassThrough(this.ser_command, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder ser_command(String r100) {
                this.ser_command = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_PassThrough extends ProtoAdapter<PassThrough> {
            public ProtoAdapter_PassThrough() {
                super(FieldEncoding.LENGTH_DELIMITED, PassThrough.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PassThrough decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.ser_command = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.ser_command = ProtoAdapter.STRING.decode(r100);
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(PassThrough r100) {
                String r101 = r100.ser_command;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ PassThrough decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(PassThrough r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, PassThrough r101) throws IOException {
                String r102 = r101.ser_command;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PassThrough r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_PassThrough();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.ser_command = this.ser_command;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return PassThrough.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public PassThrough(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public PassThrough(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.ser_command = r100;
        }
    }

    public static final class ProtoAdapter_RequestPacket extends ProtoAdapter<RequestPacket> {
        private final ProtoAdapter<Map<String, String>> biz_request_meta;

        public ProtoAdapter_RequestPacket() {
            super(FieldEncoding.LENGTH_DELIMITED, RequestPacket.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.biz_request_meta = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RequestPacket decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.cmd = Command.UNKNOWN_COMMAND;
            r101.context_id = "";
            r101.user_id = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_callback_by_stream = r102;
            r101.task_id = 0L;
            r101.max_age = 0L;
            r101.use_cache_control = r102;
            r101.thread_id = 0L;
            r101.span_id = 0L;
            r101.collect_trace = r102;
            r101.mail_account_id = "";
            r101.enable_start_up_control = r102;
            r101.user_container_id = 0L;
            r101.traffic_type = TrafficType.UNKNOWN;
            r101.payload = ByteString.EMPTY;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L48;
            if (r104 != 1) goto L8;
            r101.cmd = Command.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L46
        L46:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r104 != 7) goto L10;
            r101.is_callback_by_stream = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 9999) goto L12;
            r101.payload = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L14;
            r101.context_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r104 != 5) goto L16;
            r101.user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            if (r104 != 10) goto L18;
            r101.pass_through = PassThrough.ADAPTER.decode(r100);
            goto L3
        L18:
            if (r104 != 11) goto L19;
            r101.biz_request_meta.putAll(this.biz_request_meta.decode(r100));
            goto L3
        L19:
            switch(r104) {
                case 100: goto L37;
                case 101: goto L36;
                case 102: goto L35;
                case 103: goto L34;
                case 104: goto L33;
                default: goto L20;
            };
        L33:
            r101.thread_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L34:
            r101.use_cache_control = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L35:
            r101.max_age = ProtoAdapter.INT64.decode(r100);
            goto L3
        L36:
            r101.task_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L37:
            r101.biz_config = BizConfig.ADAPTER.decode(r100);
            goto L3
        L20:
            switch(r104) {
                case 106: goto L32;
                case 107: goto L31;
                case 108: goto L30;
                case 109: goto L29;
                case 110: goto L28;
                case 111: goto L27;
                case 112: goto L26;
                case 113: goto L50;
                default: goto L21;
            };
        L50:
            r101.traffic_type = TrafficType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
        L24:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L26:
            r101.mail_context = MailContext.ADAPTER.decode(r100);
            goto L3
        L27:
            r101.user_container_id = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L28:
            r101.headers.add(HttpHeader.ADAPTER.decode(r100));
            goto L3
        L29:
            r101.enable_start_up_control = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L30:
            r101.mail_account_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L31:
            r101.collect_trace = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L32:
            r101.span_id = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L21:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L48:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(RequestPacket r100) {
            Command r101 = r100.cmd;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Command.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.context_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(4, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.user_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(5, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.is_callback_by_stream;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r110);
        L18:
            int r112 = r109 + r111;
            PassThrough r113 = r100.pass_through;
            if (r113 == null) goto L21;
            int r114 = PassThrough.ADAPTER.encodedSizeWithTag(10, r113);
        L22:
            int r115 = (r112 + r114) + this.biz_request_meta.encodedSizeWithTag(11, r100.biz_request_meta);
            BizConfig r116 = r100.biz_config;
            if (r116 == null) goto L25;
            int r117 = BizConfig.ADAPTER.encodedSizeWithTag(100, r116);
        L26:
            int r118 = r115 + r117;
            Long r119 = r100.task_id;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.INT64.encodedSizeWithTag(101, r119);
        L30:
            int r121 = r118 + r120;
            Long r122 = r100.max_age;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.INT64.encodedSizeWithTag(102, r122);
        L34:
            int r124 = r121 + r123;
            Boolean r125 = r100.use_cache_control;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.BOOL.encodedSizeWithTag(103, r125);
        L38:
            int r127 = r124 + r126;
            Long r128 = r100.thread_id;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.INT64.encodedSizeWithTag(104, r128);
        L42:
            int r130 = r127 + r129;
            Long r131 = r100.span_id;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.UINT64.encodedSizeWithTag(106, r131);
        L46:
            int r133 = r130 + r132;
            Boolean r134 = r100.collect_trace;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.BOOL.encodedSizeWithTag(107, r134);
        L50:
            int r136 = r133 + r135;
            String r137 = r100.mail_account_id;
            if (r137 == null) goto L53;
            int r138 = ProtoAdapter.STRING.encodedSizeWithTag(108, r137);
        L54:
            int r139 = r136 + r138;
            Boolean r140 = r100.enable_start_up_control;
            if (r140 == null) goto L57;
            int r141 = ProtoAdapter.BOOL.encodedSizeWithTag(109, r140);
        L58:
            int r142 = (r139 + r141) + HttpHeader.ADAPTER.asRepeated().encodedSizeWithTag(110, r100.headers);
            Long r143 = r100.user_container_id;
            if (r143 == null) goto L61;
            int r144 = ProtoAdapter.UINT64.encodedSizeWithTag(111, r143);
        L62:
            int r145 = r142 + r144;
            MailContext r146 = r100.mail_context;
            if (r146 == null) goto L65;
            int r147 = MailContext.ADAPTER.encodedSizeWithTag(112, r146);
        L66:
            int r148 = r145 + r147;
            TrafficType r149 = r100.traffic_type;
            if (r149 == null) goto L69;
            int r150 = TrafficType.ADAPTER.encodedSizeWithTag(113, r149);
        L70:
            int r151 = r148 + r150;
            ByteString r152 = r100.payload;
            if (r152 == null) goto L74;
            r102 = ProtoAdapter.BYTES.encodedSizeWithTag(9999, r152);
        L74:
            return (r151 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ RequestPacket decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RequestPacket r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RequestPacket r101) throws IOException {
            Command r102 = r101.cmd;
            if (r102 == null) goto L5;
            Command.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.context_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r103);
        L8:
            String r104 = r101.user_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r104);
        L11:
            Boolean r105 = r101.is_callback_by_stream;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r105);
        L14:
            PassThrough r106 = r101.pass_through;
            if (r106 == null) goto L17;
            PassThrough.ADAPTER.encodeWithTag(r100, 10, r106);
        L17:
            this.biz_request_meta.encodeWithTag(r100, 11, r101.biz_request_meta);
            BizConfig r107 = r101.biz_config;
            if (r107 == null) goto L20;
            BizConfig.ADAPTER.encodeWithTag(r100, 100, r107);
        L20:
            Long r108 = r101.task_id;
            if (r108 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 101, r108);
        L23:
            Long r109 = r101.max_age;
            if (r109 == null) goto L26;
            ProtoAdapter.INT64.encodeWithTag(r100, 102, r109);
        L26:
            Boolean r110 = r101.use_cache_control;
            if (r110 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 103, r110);
        L29:
            Long r111 = r101.thread_id;
            if (r111 == null) goto L32;
            ProtoAdapter.INT64.encodeWithTag(r100, 104, r111);
        L32:
            Long r112 = r101.span_id;
            if (r112 == null) goto L35;
            ProtoAdapter.UINT64.encodeWithTag(r100, 106, r112);
        L35:
            Boolean r113 = r101.collect_trace;
            if (r113 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r100, 107, r113);
        L38:
            String r114 = r101.mail_account_id;
            if (r114 == null) goto L41;
            ProtoAdapter.STRING.encodeWithTag(r100, 108, r114);
        L41:
            Boolean r115 = r101.enable_start_up_control;
            if (r115 == null) goto L44;
            ProtoAdapter.BOOL.encodeWithTag(r100, 109, r115);
        L44:
            HttpHeader.ADAPTER.asRepeated().encodeWithTag(r100, 110, r101.headers);
            Long r116 = r101.user_container_id;
            if (r116 == null) goto L47;
            ProtoAdapter.UINT64.encodeWithTag(r100, 111, r116);
        L47:
            MailContext r117 = r101.mail_context;
            if (r117 == null) goto L50;
            MailContext.ADAPTER.encodeWithTag(r100, 112, r117);
        L50:
            TrafficType r118 = r101.traffic_type;
            if (r118 == null) goto L53;
            TrafficType.ADAPTER.encodeWithTag(r100, 113, r118);
        L53:
            ByteString r119 = r101.payload;
            if (r119 == null) goto L56;
            ProtoAdapter.BYTES.encodeWithTag(r100, 9999, r119);
        L56:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RequestPacket r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum TrafficType extends Enum<TrafficType> implements WireEnum {
        private static final /* synthetic */ TrafficType[] $VALUES = null;
        public static final ProtoAdapter<TrafficType> ADAPTER = null;
        public static final TrafficType HIGH_PRIORITY = null;
        public static final TrafficType LOW_PRIORITY = null;
        public static final TrafficType UNKNOWN = null;
        private final int value;

        static {
            TrafficType r100 = new TrafficType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            TrafficType r101 = new TrafficType("HIGH_PRIORITY", 1, 1);
            HIGH_PRIORITY = r101;
            TrafficType r102 = new TrafficType("LOW_PRIORITY", 2, 10);
            LOW_PRIORITY = r102;
            $VALUES = new TrafficType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(TrafficType.class);
        }

        public static TrafficType[] values() {
            return (TrafficType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static TrafficType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 10) goto L10;
            return null;
        L10:
            return LOW_PRIORITY;
        L12:
            return HIGH_PRIORITY;
        L14:
            return UNKNOWN;
        }

        public static TrafficType valueOf(String r100) {
            return (TrafficType) a.a(TrafficType.class, r100);
        }

        private TrafficType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RequestPacket();
        DEFAULT_CMD = Command.UNKNOWN_COMMAND;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_CALLBACK_BY_STREAM = r100;
        DEFAULT_TASK_ID = 0L;
        DEFAULT_MAX_AGE = 0L;
        DEFAULT_USE_CACHE_CONTROL = r100;
        DEFAULT_THREAD_ID = 0L;
        DEFAULT_SPAN_ID = 0L;
        DEFAULT_COLLECT_TRACE = r100;
        DEFAULT_ENABLE_START_UP_CONTROL = r100;
        DEFAULT_USER_CONTAINER_ID = 0L;
        DEFAULT_TRAFFIC_TYPE = TrafficType.UNKNOWN;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.cmd = this.cmd;
        r100.context_id = this.context_id;
        r100.user_id = this.user_id;
        r100.is_callback_by_stream = this.is_callback_by_stream;
        r100.pass_through = this.pass_through;
        r100.biz_request_meta = Internal.copyOf("biz_request_meta", this.biz_request_meta);
        r100.biz_config = this.biz_config;
        r100.task_id = this.task_id;
        r100.max_age = this.max_age;
        r100.use_cache_control = this.use_cache_control;
        r100.thread_id = this.thread_id;
        r100.span_id = this.span_id;
        r100.collect_trace = this.collect_trace;
        r100.mail_account_id = this.mail_account_id;
        r100.enable_start_up_control = this.enable_start_up_control;
        r100.headers = Internal.copyOf("headers", this.headers);
        r100.user_container_id = this.user_container_id;
        r100.mail_context = this.mail_context;
        r100.traffic_type = this.traffic_type;
        r100.payload = this.payload;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RequestPacket.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public RequestPacket(Command r210, String r211, String r212, Boolean r213, PassThrough r214, Map<String, String> r215, BizConfig r216, Long r310, Long r311, Boolean r312, Long r313, Long r314, Boolean r315, String r316, Boolean r317, List<HttpHeader> r318, Long r319, MailContext r410, TrafficType r411, ByteString r412) {
        this(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, ByteString.EMPTY);
    }

    public RequestPacket(Command r100, String r101, String r102, Boolean r103, PassThrough r104, Map<String, String> r105, BizConfig r110, Long r111, Long r112, Boolean r113, Long r114, Long r115, Boolean r116, String r117, Boolean r118, List<HttpHeader> r119, Long r210, MailContext r211, TrafficType r212, ByteString r213, ByteString r214) {
        super(ADAPTER, r214);
        this.cmd = r100;
        this.context_id = r101;
        this.user_id = r102;
        this.is_callback_by_stream = r103;
        this.pass_through = r104;
        this.biz_request_meta = Internal.immutableCopyOf("biz_request_meta", r105);
        this.biz_config = r110;
        this.task_id = r111;
        this.max_age = r112;
        this.use_cache_control = r113;
        this.thread_id = r114;
        this.span_id = r115;
        this.collect_trace = r116;
        this.mail_account_id = r117;
        this.enable_start_up_control = r118;
        this.headers = Internal.immutableCopyOf("headers", r119);
        this.user_container_id = r210;
        this.mail_context = r211;
        this.traffic_type = r212;
        this.payload = r213;
    }
}
