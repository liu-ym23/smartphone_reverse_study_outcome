package com.bytedance.lark.pb.space.doc.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class InlineAITaskStatus extends Message<InlineAITaskStatus, Builder> {
    public static final ProtoAdapter<InlineAITaskStatus> ADAPTER = null;
    public static final String DEFAULT_AI_MESSAGE_ID = "";
    public static final String DEFAULT_CONTENT = "";
    public static final Long DEFAULT_SEQ_ID = null;
    public static final String DEFAULT_SESSION_ID = "";
    public static final Long DEFAULT_STATUS_CODE = null;
    public static final String DEFAULT_TASK_STATUS = "";
    public static final String DEFAULT_UNIQUE_TASK_ID = "";
    private static final long serialVersionUID = 0;
    public final String ai_message_id;
    public final String content;
    public final Long seq_id;
    public final String session_id;
    public final Long status_code;
    public final String task_status;
    public final String unique_task_id;

    public static final class Builder extends Message.Builder<InlineAITaskStatus, Builder> {
        public String ai_message_id;
        public String content;
        public Long seq_id;
        public String session_id;
        public Long status_code;
        public String task_status;
        public String unique_task_id;

        @Override // com.squareup.wire.Message.Builder
        public InlineAITaskStatus build() {
            return new InlineAITaskStatus(this.session_id, this.seq_id, this.content, this.task_status, this.status_code, this.ai_message_id, this.unique_task_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ai_message_id(String r100) {
            this.ai_message_id = r100;
            return this;
        }

        public Builder content(String r100) {
            this.content = r100;
            return this;
        }

        public Builder seq_id(Long r100) {
            this.seq_id = r100;
            return this;
        }

        public Builder session_id(String r100) {
            this.session_id = r100;
            return this;
        }

        public Builder status_code(Long r100) {
            this.status_code = r100;
            return this;
        }

        public Builder task_status(String r100) {
            this.task_status = r100;
            return this;
        }

        public Builder unique_task_id(String r100) {
            this.unique_task_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_InlineAITaskStatus extends ProtoAdapter<InlineAITaskStatus> {
        public ProtoAdapter_InlineAITaskStatus() {
            super(FieldEncoding.LENGTH_DELIMITED, InlineAITaskStatus.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public InlineAITaskStatus decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.session_id = "";
            r101.seq_id = 0L;
            r101.content = "";
            r101.task_status = "";
            r101.status_code = 0L;
            r101.ai_message_id = "";
            r101.unique_task_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.unique_task_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.ai_message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.status_code = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            r101.task_status = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.content = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.seq_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            r101.session_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(InlineAITaskStatus r100) {
            String r101 = r100.session_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.seq_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.content;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.task_status;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.status_code;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT64.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.ai_message_id;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.unique_task_id;
            if (r119 == null) goto L30;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            return (r118 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ InlineAITaskStatus decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(InlineAITaskStatus r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, InlineAITaskStatus r101) throws IOException {
            String r102 = r101.session_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.seq_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.content;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.task_status;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Long r106 = r101.status_code;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.ai_message_id;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.unique_task_id;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, InlineAITaskStatus r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_InlineAITaskStatus();
        DEFAULT_SEQ_ID = 0L;
        DEFAULT_STATUS_CODE = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.session_id = this.session_id;
        r100.seq_id = this.seq_id;
        r100.content = this.content;
        r100.task_status = this.task_status;
        r100.status_code = this.status_code;
        r100.ai_message_id = this.ai_message_id;
        r100.unique_task_id = this.unique_task_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return InlineAITaskStatus.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public InlineAITaskStatus(String r110, Long r111, String r112, String r113, Long r114, String r115, String r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public InlineAITaskStatus(String r100, Long r101, String r102, String r103, Long r104, String r105, String r106, ByteString r107) {
        super(ADAPTER, r107);
        this.session_id = r100;
        this.seq_id = r101;
        this.content = r102;
        this.task_status = r103;
        this.status_code = r104;
        this.ai_message_id = r105;
        this.unique_task_id = r106;
    }
}
