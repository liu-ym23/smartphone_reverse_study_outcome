package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class Packet extends com.squareup.wire.Message<Packet, Builder> {
    public static final ProtoAdapter<Packet> ADAPTER = null;
    public static final Command DEFAULT_CMD = null;
    public static final String DEFAULT_CONTEXT_ID = "";
    public static final Boolean DEFAULT_IS_ERR = null;
    public static final String DEFAULT_MAIL_ACCOUNT_ID = "";
    public static final String DEFAULT_MESSAGE = "";
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final String DEFAULT_START_CALLBACK_TIME = "";
    public static final Integer DEFAULT_STATUS = null;
    public static final StreamStatus DEFAULT_STREAM_STATUS = null;
    public static final Long DEFAULT_TASK_ID = null;
    public static final Long DEFAULT_USER_CONTAINER_ID = null;
    public static final String DEFAULT_USER_ID = "";
    public static final Boolean DEFAULT_VERIFY_USER_ID = null;
    public static final ProtoAdapter_Packet RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> biz_response_meta;
    public final Command cmd;
    public final String context_id;
    public final Boolean is_err;
    public final String mail_account_id;
    public final String message;
    public final ByteString payload;
    public final String start_callback_time;
    public final Integer status;
    public final StreamStatus stream_status;
    public final Long task_id;
    public final Trace trace;
    public final Long user_container_id;
    public final String user_id;
    public final Boolean verify_user_id;

    public static final class Builder extends com.squareup.wire.Message.Builder<Packet, Builder> implements d<Packet> {
        public Map<String, String> biz_response_meta;
        public Command cmd;
        public String context_id;
        public Boolean is_err;
        public String mail_account_id;
        public String message;
        public ByteString payload;
        public String start_callback_time;
        public Integer status;
        public StreamStatus stream_status;
        public Long task_id;
        public Trace trace;
        public Long user_container_id;
        public String user_id;
        public Boolean verify_user_id;

        @Override // com.squareup.wire.Message.Builder
        public Packet build() {
            return new Packet(this.cmd, this.status, this.message, this.context_id, this.user_id, this.start_callback_time, this.task_id, this.is_err, this.stream_status, this.mail_account_id, this.trace, this.verify_user_id, this.user_container_id, this.biz_response_meta, this.payload, super.buildUnknownFields());
        }

        public Builder() {
            this.biz_response_meta = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder biz_response_meta(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.biz_response_meta = r100;
            return this;
        }

        public Builder cmd(Command r100) {
            this.cmd = r100;
            return this;
        }

        public Builder context_id(String r100) {
            this.context_id = r100;
            return this;
        }

        public Builder is_err(Boolean r100) {
            this.is_err = r100;
            return this;
        }

        public Builder mail_account_id(String r100) {
            this.mail_account_id = r100;
            return this;
        }

        public Builder message(String r100) {
            this.message = r100;
            return this;
        }

        public Builder payload(ByteString r100) {
            this.payload = r100;
            return this;
        }

        public Builder start_callback_time(String r100) {
            this.start_callback_time = r100;
            return this;
        }

        public Builder status(Integer r100) {
            this.status = r100;
            return this;
        }

        public Builder stream_status(StreamStatus r100) {
            this.stream_status = r100;
            return this;
        }

        public Builder task_id(Long r100) {
            this.task_id = r100;
            return this;
        }

        public Builder trace(Trace r100) {
            this.trace = r100;
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

        public Builder verify_user_id(Boolean r100) {
            this.verify_user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Packet extends ProtoAdapter<Packet> implements c<Packet> {
        private final ProtoAdapter<Map<String, String>> biz_response_meta;

        public ProtoAdapter_Packet() {
            super(FieldEncoding.LENGTH_DELIMITED, Packet.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.biz_response_meta = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Packet decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.cmd = Command.UNKNOWN_COMMAND;
            r101.status = 0;
            r101.message = "";
            r101.context_id = "";
            r101.user_id = "";
            r101.start_callback_time = "";
            r101.task_id = 0L;
            Boolean r102 = Boolean.FALSE;
            r101.is_err = r102;
            r101.stream_status = StreamStatus.ACTIVE;
            r101.mail_account_id = "";
            r101.verify_user_id = r102;
            r101.user_container_id = 0L;
            r101.payload = ByteString.EMPTY;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L30;
            if (r104 != 9999) goto L7;
            r101.payload = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L7:
            switch(r104) {
                case 1: goto L34;
                case 2: goto L24;
                case 3: goto L23;
                case 4: goto L22;
                case 5: goto L21;
                case 6: goto L20;
                case 7: goto L19;
                case 8: goto L18;
                case 9: goto L32;
                case 10: goto L13;
                case 11: goto L12;
                case 12: goto L11;
                case 13: goto L10;
                case 14: goto L9;
                default: goto L8;
            };
        L32:
            r101.stream_status = StreamStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L34:
            r101.cmd = Command.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L27
        L27:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            r101.biz_response_meta.putAll(this.biz_response_meta.decode(r100));
            goto L3
        L10:
            r101.user_container_id = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L11:
            r101.verify_user_id = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.trace = Trace.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.mail_account_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.is_err = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L19:
            r101.task_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L20:
            r101.start_callback_time = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.context_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L23:
            r101.message = ProtoAdapter.STRING.decode(r100);
            goto L3
        L24:
            r101.status = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L8:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L30:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Packet r100) {
            Command r101 = r100.cmd;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Command.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.status;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.UINT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.message;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.context_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.user_id;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.start_callback_time;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Long r119 = r100.task_id;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.INT64.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Boolean r122 = r100.is_err;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            StreamStatus r125 = r100.stream_status;
            if (r125 == null) goto L37;
            int r126 = StreamStatus.ADAPTER.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            String r128 = r100.mail_account_id;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.STRING.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            Trace r131 = r100.trace;
            if (r131 == null) goto L45;
            int r132 = Trace.ADAPTER.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            Boolean r134 = r100.verify_user_id;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r134);
        L50:
            int r136 = r133 + r135;
            Long r137 = r100.user_container_id;
            if (r137 == null) goto L53;
            int r138 = ProtoAdapter.UINT64.encodedSizeWithTag(13, r137);
        L54:
            int r139 = (r136 + r138) + this.biz_response_meta.encodedSizeWithTag(14, r100.biz_response_meta);
            ByteString r140 = r100.payload;
            if (r140 == null) goto L58;
            r102 = ProtoAdapter.BYTES.encodedSizeWithTag(9999, r140);
        L58:
            return (r139 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Packet decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Packet r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Packet r101) throws IOException {
            Command r102 = r101.cmd;
            if (r102 == null) goto L5;
            Command.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.status;
            if (r103 == null) goto L8;
            ProtoAdapter.UINT32.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.message;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.context_id;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.user_id;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.start_callback_time;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            Long r108 = r101.task_id;
            if (r108 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 7, r108);
        L23:
            Boolean r109 = r101.is_err;
            if (r109 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r109);
        L26:
            StreamStatus r110 = r101.stream_status;
            if (r110 == null) goto L29;
            StreamStatus.ADAPTER.encodeWithTag(r100, 9, r110);
        L29:
            String r111 = r101.mail_account_id;
            if (r111 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 10, r111);
        L32:
            Trace r112 = r101.trace;
            if (r112 == null) goto L35;
            Trace.ADAPTER.encodeWithTag(r100, 11, r112);
        L35:
            Boolean r113 = r101.verify_user_id;
            if (r113 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r100, 12, r113);
        L38:
            Long r114 = r101.user_container_id;
            if (r114 == null) goto L41;
            ProtoAdapter.UINT64.encodeWithTag(r100, 13, r114);
        L41:
            this.biz_response_meta.encodeWithTag(r100, 14, r101.biz_response_meta);
            ByteString r115 = r101.payload;
            if (r115 == null) goto L44;
            ProtoAdapter.BYTES.encodeWithTag(r100, 9999, r115);
        L44:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Packet r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum StreamStatus extends Enum<StreamStatus> implements WireEnum {
        private static final /* synthetic */ StreamStatus[] $VALUES = null;
        public static final StreamStatus ACTIVE = null;
        public static final ProtoAdapter<StreamStatus> ADAPTER = null;
        public static final StreamStatus FINAL_WITHOUT_PAYLOAD = null;
        public static final StreamStatus FINAL_WITH_PAYLOAD = null;
        private final int value;

        static {
            StreamStatus r100 = new StreamStatus("ACTIVE", 0, 1);
            ACTIVE = r100;
            StreamStatus r101 = new StreamStatus("FINAL_WITH_PAYLOAD", 1, 2);
            FINAL_WITH_PAYLOAD = r101;
            StreamStatus r102 = new StreamStatus("FINAL_WITHOUT_PAYLOAD", 2, 3);
            FINAL_WITHOUT_PAYLOAD = r102;
            $VALUES = new StreamStatus[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(StreamStatus.class);
        }

        public static StreamStatus[] values() {
            return (StreamStatus[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static StreamStatus fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return FINAL_WITHOUT_PAYLOAD;
        L13:
            return FINAL_WITH_PAYLOAD;
        L15:
            return ACTIVE;
        }

        public static StreamStatus valueOf(String r100) {
            return (StreamStatus) a.a(StreamStatus.class, r100);
        }

        private StreamStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_Packet r100 = new ProtoAdapter_Packet();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_CMD = Command.UNKNOWN_COMMAND;
        DEFAULT_STATUS = 0;
        DEFAULT_TASK_ID = 0L;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_IS_ERR = r101;
        DEFAULT_STREAM_STATUS = StreamStatus.ACTIVE;
        DEFAULT_VERIFY_USER_ID = r101;
        DEFAULT_USER_CONTAINER_ID = 0L;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.cmd = this.cmd;
        r100.status = this.status;
        r100.message = this.message;
        r100.context_id = this.context_id;
        r100.user_id = this.user_id;
        r100.start_callback_time = this.start_callback_time;
        r100.task_id = this.task_id;
        r100.is_err = this.is_err;
        r100.stream_status = this.stream_status;
        r100.mail_account_id = this.mail_account_id;
        r100.trace = this.trace;
        r100.verify_user_id = this.verify_user_id;
        r100.user_container_id = this.user_container_id;
        r100.biz_response_meta = Internal.copyOf("biz_response_meta", this.biz_response_meta);
        r100.payload = this.payload;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Packet.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Packet(Command r110, Integer r111, String r210, String r211, String r212, String r213, Long r214, Boolean r215, StreamStatus r216, String r217, Trace r218, Boolean r219, Long r310, Map<String, String> r311, ByteString r312) {
        this(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, ByteString.EMPTY);
    }

    public Packet(Command r100, Integer r101, String r102, String r103, String r104, String r105, Long r110, Boolean r111, StreamStatus r112, String r113, Trace r114, Boolean r115, Long r116, Map<String, String> r117, ByteString r118, ByteString r119) {
        super(ADAPTER, r119);
        this.cmd = r100;
        this.status = r101;
        this.message = r102;
        this.context_id = r103;
        this.user_id = r104;
        this.start_callback_time = r105;
        this.task_id = r110;
        this.is_err = r111;
        this.stream_status = r112;
        this.mail_account_id = r113;
        this.trace = r114;
        this.verify_user_id = r115;
        this.user_container_id = r116;
        this.biz_response_meta = Internal.immutableCopyOf("biz_response_meta", r117);
        this.payload = r118;
    }
}
