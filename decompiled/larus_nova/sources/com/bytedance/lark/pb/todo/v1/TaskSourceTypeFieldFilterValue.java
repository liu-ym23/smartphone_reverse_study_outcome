package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskSourceTypeFieldFilterValue extends Message<TaskSourceTypeFieldFilterValue, Builder> {
    public static final ProtoAdapter<TaskSourceTypeFieldFilterValue> ADAPTER = null;
    public static final TaskSimpleSourceType DEFAULT_SOURCE_TYPE = null;
    private static final long serialVersionUID = 0;
    public final TaskSimpleSourceType source_type;

    public static final class Builder extends Message.Builder<TaskSourceTypeFieldFilterValue, Builder> {
        public TaskSimpleSourceType source_type;

        @Override // com.squareup.wire.Message.Builder
        public TaskSourceTypeFieldFilterValue build() {
            return new TaskSourceTypeFieldFilterValue(this.source_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder source_type(TaskSimpleSourceType r100) {
            this.source_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskSourceTypeFieldFilterValue extends ProtoAdapter<TaskSourceTypeFieldFilterValue> {
        public ProtoAdapter_TaskSourceTypeFieldFilterValue() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskSourceTypeFieldFilterValue.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskSourceTypeFieldFilterValue decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.source_type = TaskSimpleSourceType.UNKNOWN_SOURCE_TYPE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.source_type = TaskSimpleSourceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
        public int encodedSize2(TaskSourceTypeFieldFilterValue r100) {
            TaskSimpleSourceType r101 = r100.source_type;
            if (r101 == null) goto L5;
            int r102 = TaskSimpleSourceType.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskSourceTypeFieldFilterValue decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskSourceTypeFieldFilterValue r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskSourceTypeFieldFilterValue r101) throws IOException {
            TaskSimpleSourceType r102 = r101.source_type;
            if (r102 == null) goto L5;
            TaskSimpleSourceType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskSourceTypeFieldFilterValue r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskSourceTypeFieldFilterValue();
        DEFAULT_SOURCE_TYPE = TaskSimpleSourceType.UNKNOWN_SOURCE_TYPE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.source_type = this.source_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskSourceTypeFieldFilterValue.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskSourceTypeFieldFilterValue(TaskSimpleSourceType r100) {
        this(r100, ByteString.EMPTY);
    }

    public TaskSourceTypeFieldFilterValue(TaskSimpleSourceType r100, ByteString r101) {
        super(ADAPTER, r101);
        this.source_type = r100;
    }
}
