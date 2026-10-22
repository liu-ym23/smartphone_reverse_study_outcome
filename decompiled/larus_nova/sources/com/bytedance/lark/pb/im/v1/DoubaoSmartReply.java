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
public final class DoubaoSmartReply extends Message<DoubaoSmartReply, Builder> {
    public static final ProtoAdapter<DoubaoSmartReply> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final ByteString DEFAULT_CONTENT = null;
    public static final Long DEFAULT_DOUBAO_AI_MSG_ID = null;
    public static final Long DEFAULT_REPLY_LARK_MSG_CREATE_TIME_MS = null;
    public static final Long DEFAULT_REPLY_LARK_MSG_ID = null;
    public static final Long DEFAULT_REPLY_LARK_THREAD_ID = null;
    public static final TaskStatus DEFAULT_STATUS = null;
    public static final Long DEFAULT_UPDATE_TIME_MS = null;
    private static final long serialVersionUID = 0;
    public final Long chat_id;
    public final ByteString content;
    public final Long doubao_ai_msg_id;
    public final Long reply_lark_msg_create_time_ms;
    public final Long reply_lark_msg_id;
    public final Long reply_lark_thread_id;
    public final TaskStatus status;
    public final Long update_time_ms;

    public static final class Builder extends Message.Builder<DoubaoSmartReply, Builder> {
        public Long chat_id;
        public ByteString content;
        public Long doubao_ai_msg_id;
        public Long reply_lark_msg_create_time_ms;
        public Long reply_lark_msg_id;
        public Long reply_lark_thread_id;
        public TaskStatus status;
        public Long update_time_ms;

        @Override // com.squareup.wire.Message.Builder
        public DoubaoSmartReply build() {
            return new DoubaoSmartReply(this.doubao_ai_msg_id, this.reply_lark_msg_id, this.reply_lark_msg_create_time_ms, this.reply_lark_thread_id, this.content, this.update_time_ms, this.chat_id, this.status, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(Long r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder content(ByteString r100) {
            this.content = r100;
            return this;
        }

        public Builder doubao_ai_msg_id(Long r100) {
            this.doubao_ai_msg_id = r100;
            return this;
        }

        public Builder reply_lark_msg_create_time_ms(Long r100) {
            this.reply_lark_msg_create_time_ms = r100;
            return this;
        }

        public Builder reply_lark_msg_id(Long r100) {
            this.reply_lark_msg_id = r100;
            return this;
        }

        public Builder reply_lark_thread_id(Long r100) {
            this.reply_lark_thread_id = r100;
            return this;
        }

        public Builder status(TaskStatus r100) {
            this.status = r100;
            return this;
        }

        public Builder update_time_ms(Long r100) {
            this.update_time_ms = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DoubaoSmartReply extends ProtoAdapter<DoubaoSmartReply> {
        public ProtoAdapter_DoubaoSmartReply() {
            super(FieldEncoding.LENGTH_DELIMITED, DoubaoSmartReply.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DoubaoSmartReply decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.doubao_ai_msg_id = 0L;
            r101.reply_lark_msg_id = 0L;
            r101.reply_lark_msg_create_time_ms = 0L;
            r101.reply_lark_thread_id = 0L;
            r101.content = ByteString.EMPTY;
            r101.update_time_ms = 0L;
            r101.chat_id = 0L;
            r101.status = TaskStatus.CLOSE;
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
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L20;
                default: goto L6;
            };
        L20:
            r101.status = TaskStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.chat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            r101.update_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            r101.content = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L14:
            r101.reply_lark_thread_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            r101.reply_lark_msg_create_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            r101.reply_lark_msg_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L17:
            r101.doubao_ai_msg_id = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(DoubaoSmartReply r100) {
            Long r101 = r100.doubao_ai_msg_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.reply_lark_msg_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.reply_lark_msg_create_time_ms;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.reply_lark_thread_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            ByteString r113 = r100.content;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BYTES.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Long r116 = r100.update_time_ms;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT64.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Long r119 = r100.chat_id;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.INT64.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            TaskStatus r122 = r100.status;
            if (r122 == null) goto L34;
            r102 = TaskStatus.ADAPTER.encodedSizeWithTag(8, r122);
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
        public /* bridge */ /* synthetic */ DoubaoSmartReply decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DoubaoSmartReply r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DoubaoSmartReply r101) throws IOException {
            Long r102 = r101.doubao_ai_msg_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.reply_lark_msg_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.reply_lark_msg_create_time_ms;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.reply_lark_thread_id;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            ByteString r106 = r101.content;
            if (r106 == null) goto L17;
            ProtoAdapter.BYTES.encodeWithTag(r100, 5, r106);
        L17:
            Long r107 = r101.update_time_ms;
            if (r107 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 6, r107);
        L20:
            Long r108 = r101.chat_id;
            if (r108 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 7, r108);
        L23:
            TaskStatus r109 = r101.status;
            if (r109 == null) goto L26;
            TaskStatus.ADAPTER.encodeWithTag(r100, 8, r109);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DoubaoSmartReply r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum TaskStatus extends Enum<TaskStatus> implements WireEnum {
        private static final /* synthetic */ TaskStatus[] $VALUES = null;
        public static final ProtoAdapter<TaskStatus> ADAPTER = null;
        public static final TaskStatus CLOSE = null;
        public static final TaskStatus OPEN = null;
        private final int value;

        static {
            TaskStatus r100 = new TaskStatus("CLOSE", 0, 0);
            CLOSE = r100;
            TaskStatus r101 = new TaskStatus("OPEN", 1, 1);
            OPEN = r101;
            $VALUES = new TaskStatus[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(TaskStatus.class);
        }

        public static TaskStatus[] values() {
            return (TaskStatus[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static TaskStatus fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return OPEN;
        L10:
            return CLOSE;
        }

        public static TaskStatus valueOf(String r100) {
            return (TaskStatus) a.a(TaskStatus.class, r100);
        }

        private TaskStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DoubaoSmartReply();
        DEFAULT_DOUBAO_AI_MSG_ID = 0L;
        DEFAULT_REPLY_LARK_MSG_ID = 0L;
        DEFAULT_REPLY_LARK_MSG_CREATE_TIME_MS = 0L;
        DEFAULT_REPLY_LARK_THREAD_ID = 0L;
        DEFAULT_CONTENT = ByteString.EMPTY;
        DEFAULT_UPDATE_TIME_MS = 0L;
        DEFAULT_CHAT_ID = 0L;
        DEFAULT_STATUS = TaskStatus.CLOSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.doubao_ai_msg_id = this.doubao_ai_msg_id;
        r100.reply_lark_msg_id = this.reply_lark_msg_id;
        r100.reply_lark_msg_create_time_ms = this.reply_lark_msg_create_time_ms;
        r100.reply_lark_thread_id = this.reply_lark_thread_id;
        r100.content = this.content;
        r100.update_time_ms = this.update_time_ms;
        r100.chat_id = this.chat_id;
        r100.status = this.status;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DoubaoSmartReply.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DoubaoSmartReply(Long r110, Long r111, Long r112, Long r113, ByteString r114, Long r115, Long r116, TaskStatus r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public DoubaoSmartReply(Long r100, Long r101, Long r102, Long r103, ByteString r104, Long r105, Long r106, TaskStatus r107, ByteString r110) {
        super(ADAPTER, r110);
        this.doubao_ai_msg_id = r100;
        this.reply_lark_msg_id = r101;
        this.reply_lark_msg_create_time_ms = r102;
        this.reply_lark_thread_id = r103;
        this.content = r104;
        this.update_time_ms = r105;
        this.chat_id = r106;
        this.status = r107;
    }
}
