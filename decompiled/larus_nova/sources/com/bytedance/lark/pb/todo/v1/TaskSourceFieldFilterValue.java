package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskSourceFieldFilterValue extends Message<TaskSourceFieldFilterValue, Builder> {
    public static final ProtoAdapter<TaskSourceFieldFilterValue> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final String DEFAULT_DOCX_TOKEN = "";
    public static final TaskSimpleSourceType DEFAULT_SOURCE_TYPE = null;
    private static final long serialVersionUID = 0;
    public final Long chat_id;
    public final String docx_token;
    public final TaskSimpleSourceType source_type;

    public static final class Builder extends Message.Builder<TaskSourceFieldFilterValue, Builder> {
        public Long chat_id;
        public String docx_token;
        public TaskSimpleSourceType source_type;

        @Override // com.squareup.wire.Message.Builder
        public TaskSourceFieldFilterValue build() {
            return new TaskSourceFieldFilterValue(this.source_type, this.chat_id, this.docx_token, super.buildUnknownFields());
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

        public Builder docx_token(String r100) {
            this.docx_token = r100;
            return this;
        }

        public Builder source_type(TaskSimpleSourceType r100) {
            this.source_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskSourceFieldFilterValue extends ProtoAdapter<TaskSourceFieldFilterValue> {
        public ProtoAdapter_TaskSourceFieldFilterValue() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskSourceFieldFilterValue.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskSourceFieldFilterValue decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.source_type = TaskSimpleSourceType.UNKNOWN_SOURCE_TYPE;
            r101.chat_id = 0L;
            r101.docx_token = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.source_type = TaskSimpleSourceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.chat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.docx_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TaskSourceFieldFilterValue r100) {
            TaskSimpleSourceType r101 = r100.source_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = TaskSimpleSourceType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.chat_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.docx_token;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskSourceFieldFilterValue decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskSourceFieldFilterValue r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskSourceFieldFilterValue r101) throws IOException {
            TaskSimpleSourceType r102 = r101.source_type;
            if (r102 == null) goto L5;
            TaskSimpleSourceType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.chat_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.docx_token;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskSourceFieldFilterValue r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskSourceFieldFilterValue();
        DEFAULT_SOURCE_TYPE = TaskSimpleSourceType.UNKNOWN_SOURCE_TYPE;
        DEFAULT_CHAT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.source_type = this.source_type;
        r100.chat_id = this.chat_id;
        r100.docx_token = this.docx_token;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskSourceFieldFilterValue.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskSourceFieldFilterValue(TaskSimpleSourceType r100, Long r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public TaskSourceFieldFilterValue(TaskSimpleSourceType r100, Long r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.source_type = r100;
        this.chat_id = r101;
        this.docx_token = r102;
    }
}
