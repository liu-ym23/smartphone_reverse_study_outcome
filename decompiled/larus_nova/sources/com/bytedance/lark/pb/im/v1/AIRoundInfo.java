package com.bytedance.lark.pb.im.v1;

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
public final class AIRoundInfo extends Message<AIRoundInfo, Builder> {
    public static final ProtoAdapter<AIRoundInfo> ADAPTER = null;
    public static final Long DEFAULT_AI_CHAT_MODE_ID = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final Long DEFAULT_ROUND_ID = null;
    public static final Integer DEFAULT_ROUND_ID_POSITION = null;
    public static final Integer DEFAULT_ROUND_LAST_POSITION = null;
    public static final String DEFAULT_SESSION_ID = "";
    public static final Status DEFAULT_STATUS = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    private static final long serialVersionUID = 0;
    public final Long ai_chat_mode_id;
    public final Long chat_id;
    public final Long round_id;
    public final Integer round_id_position;
    public final Integer round_last_position;
    public final String session_id;
    public final Status status;
    public final Long update_time;

    public static final class Builder extends Message.Builder<AIRoundInfo, Builder> {
        public Long ai_chat_mode_id;
        public Long chat_id;
        public Long round_id;
        public Integer round_id_position;
        public Integer round_last_position;
        public String session_id;
        public Status status;
        public Long update_time;

        @Override // com.squareup.wire.Message.Builder
        public AIRoundInfo build() {
            return new AIRoundInfo(this.chat_id, this.ai_chat_mode_id, this.round_id, this.round_id_position, this.round_last_position, this.status, this.update_time, this.session_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ai_chat_mode_id(Long r100) {
            this.ai_chat_mode_id = r100;
            return this;
        }

        public Builder chat_id(Long r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder round_id(Long r100) {
            this.round_id = r100;
            return this;
        }

        public Builder round_id_position(Integer r100) {
            this.round_id_position = r100;
            return this;
        }

        public Builder round_last_position(Integer r100) {
            this.round_last_position = r100;
            return this;
        }

        public Builder session_id(String r100) {
            this.session_id = r100;
            return this;
        }

        public Builder status(Status r100) {
            this.status = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AIRoundInfo extends ProtoAdapter<AIRoundInfo> {
        public ProtoAdapter_AIRoundInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, AIRoundInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AIRoundInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = 0L;
            r101.ai_chat_mode_id = 0L;
            r101.round_id = 0L;
            r101.round_id_position = 0;
            r101.round_last_position = 0;
            r101.status = Status.UNKNOWN;
            r101.update_time = 0L;
            r101.session_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            switch(r103) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L20;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L20:
            r101.status = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.session_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.update_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            r101.round_last_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L14:
            r101.round_id_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            r101.round_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            r101.ai_chat_mode_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L17:
            r101.chat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AIRoundInfo r100) {
            Long r101 = r100.chat_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.ai_chat_mode_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.round_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Integer r110 = r100.round_id_position;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT32.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Integer r113 = r100.round_last_position;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT32.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Status r116 = r100.status;
            if (r116 == null) goto L25;
            int r117 = Status.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Long r119 = r100.update_time;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.INT64.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.session_id;
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
        public /* bridge */ /* synthetic */ AIRoundInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AIRoundInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AIRoundInfo r101) throws IOException {
            Long r102 = r101.chat_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.ai_chat_mode_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.round_id;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            Integer r105 = r101.round_id_position;
            if (r105 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r105);
        L14:
            Integer r106 = r101.round_last_position;
            if (r106 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r106);
        L17:
            Status r107 = r101.status;
            if (r107 == null) goto L20;
            Status.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            Long r108 = r101.update_time;
            if (r108 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.session_id;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AIRoundInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status DONE = null;
        public static final Status INTERRUPT = null;
        public static final Status RESPONDING = null;
        public static final Status ROUND_ERROR = null;
        public static final Status UNKNOWN = null;
        private final int value;

        static {
            Status r100 = new Status("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Status r101 = new Status("RESPONDING", 1, 1);
            RESPONDING = r101;
            Status r102 = new Status("DONE", 2, 2);
            DONE = r102;
            Status r103 = new Status("INTERRUPT", 3, 3);
            INTERRUPT = r103;
            Status r104 = new Status("ROUND_ERROR", 4, 4);
            ROUND_ERROR = r104;
            $VALUES = new Status[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Status fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return ROUND_ERROR;
        L16:
            return INTERRUPT;
        L18:
            return DONE;
        L20:
            return RESPONDING;
        L22:
            return UNKNOWN;
        }

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        private Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AIRoundInfo();
        DEFAULT_CHAT_ID = 0L;
        DEFAULT_AI_CHAT_MODE_ID = 0L;
        DEFAULT_ROUND_ID = 0L;
        DEFAULT_ROUND_ID_POSITION = 0;
        DEFAULT_ROUND_LAST_POSITION = 0;
        DEFAULT_STATUS = Status.UNKNOWN;
        DEFAULT_UPDATE_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.ai_chat_mode_id = this.ai_chat_mode_id;
        r100.round_id = this.round_id;
        r100.round_id_position = this.round_id_position;
        r100.round_last_position = this.round_last_position;
        r100.status = this.status;
        r100.update_time = this.update_time;
        r100.session_id = this.session_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AIRoundInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AIRoundInfo(Long r110, Long r111, Long r112, Integer r113, Integer r114, Status r115, Long r116, String r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public AIRoundInfo(Long r100, Long r101, Long r102, Integer r103, Integer r104, Status r105, Long r106, String r107, ByteString r110) {
        super(ADAPTER, r110);
        this.chat_id = r100;
        this.ai_chat_mode_id = r101;
        this.round_id = r102;
        this.round_id_position = r103;
        this.round_last_position = r104;
        this.status = r105;
        this.update_time = r106;
        this.session_id = r107;
    }
}
